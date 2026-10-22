package com.bytedance.android.live.base.sp;

import a70.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.annie.util.ThreadUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.setting.d6;
import com.bytedance.android.live.core.setting.d7;
import com.bytedance.android.live.core.setting.e7;
import com.bytedance.android.live.core.setting.f7;
import com.bytedance.android.live.core.setting.g7;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import lz.a;
import lz.d;
import lz.e;
import lz.f;
import lz.g;
import org.json.JSONObject;
import w60.b;
import y9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class TTOpenLiveSettingUtil {
    public static final String KEY_AB_SETTINGS = "key_ttlive_open_sdk_ab_setting";
    public static final String KEY_SETTINGS = "key_ttlive_open_sdk_setting";
    public static String LITE_OPEN_SETTING = "open_live_config";
    public static String settingAsync = "enable_async_update_settings";
    public static String settingExtraKey = "_setting_extra";
    public static String settingMode = "setting_update_mode";
    public static PublishSubject<Boolean> settingUpdateFinish = null;
    public static String settingVersion = "setting_version";
    public static PublishSubject<Boolean> update;
    public static PublishSubject<Boolean> updateAB;

    public TTOpenLiveSettingUtil() {
    }

    public static /* synthetic */ void a(Boolean r0) {
        lambda$saveLiveSP$1(r0);
    }

    public static /* synthetic */ JsonObject b(JsonObject r0, JsonObject r1) {
        return lambda$updateSettingsV2$2(r0, r1);
    }

    public static /* synthetic */ Boolean c(SharedPreferences r0, JsonObject r1) {
        return lambda$updateABSettings$5(r0, r1);
    }

    public static /* synthetic */ void d(Context r0, JsonObject r1, JsonObject r2) {
        lambda$updateSettingsV2$3(r0, r1, r2);
    }

    public static /* synthetic */ void e(Boolean r0) {
        lambda$updateABSettings$6(r0);
    }

    public static /* synthetic */ void f(Throwable r0) {
        lambda$updateSettingsV2$4(r0);
    }

    public static /* synthetic */ Boolean g(SharedPreferences r0, JsonObject r1) {
        return lambda$saveLiveSP$0(r0, r1);
    }

    public static boolean isAsyncSettingEnable() {
        return ((JSONObject) k.f(IMiddleWareHostContext.class).getSetting(LITE_OPEN_SETTING, new JSONObject())).optBoolean(settingAsync, true);
    L5:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    public static void setLocalTest(boolean r0) {
    }

    static {
        update = PublishSubject.create();
        updateAB = PublishSubject.create();
        settingUpdateFinish = PublishSubject.create();
    }

    private static /* synthetic */ void lambda$saveLiveSP$1(Boolean r1) throws Exception {
        update.onNext(r1);
    }

    private static /* synthetic */ void lambda$updateABSettings$6(Boolean r1) throws Exception {
        updateAB.onNext(r1);
    }

    private static /* synthetic */ void lambda$updateSettingsV2$4(Throwable r8) throws Exception {
        d7.a("update_annie_failed", r8);
        c.a(1, "incr", "clod", 0L, 0, 0, "update数据" + r8.getCause());
    }

    private static void notifyUpdateObserve(Boolean r1) {
        update.onNext(r1);
    }

    private static void settingDataAdapter(JsonObject r3) {
        if (r3.get(settingExtraKey) != null) goto L6;
        JsonObject r0 = new JsonObject();
        r0.addProperty(settingVersion, "v2");
        r0.addProperty(settingMode, "full");
        r3.add(settingExtraKey, r0);
        return;
    }

    public static void updateAppSettings(JSONObject r2) {
        Map<String, JSONObject> r0 = g7.a;
        Intrinsics.checkNotNullParameter(SettingUtil.KEY_TT_APP_SETTING, "key");
        Intrinsics.checkNotNullParameter(r2, "settings");
        g7.a.put(SettingUtil.KEY_TT_APP_SETTING, r2);
    }

    private static void copySetingToOuter(SharedPreferences.Editor r2, JsonObject r3) {
        if (r2 == null) goto L9;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.get("live_fresco_config_key") == null) goto L10;
        r2.putString("live_fresco_config_key", r3.get("live_fresco_config_key").toString());
        return;
    L10:
        return;
    }

    private static JsonObject getSettingObj(JsonObject r3, JsonObject r4) {
        e7.a("update setting v2 from cold launch");
        b r0 = SettingIncStrategy.a;
        e7.a("update setting v2, result: " + SettingIncStrategy.b(SettingIncStrategy.IncScene.COLD_LAUNCH, r3, r4) + " thread = " + ThreadMethodProxy.currentThread().getId());
        f7.d(r4);
        e7.a("update annie setting");
        return (JsonObject) GsonProtectorUtils.fromJson(GsonHelper.get(), GsonProtectorUtils.toJson(GsonHelper.get(), SettingIncStrategy.a.c()), JsonObject.class);
    }

    private static /* synthetic */ Boolean lambda$saveLiveSP$0(SharedPreferences r2, JsonObject r3) throws Exception {
        SharedPreferences.Editor r4 = r2.edit();
        r4.putString(KEY_SETTINGS, r3.toString());
        copySetingToOuter(r4, r3);
        return Boolean.valueOf(r4.commit());
    }

    private static /* synthetic */ Boolean lambda$updateABSettings$5(SharedPreferences r1, JsonObject r2) throws Exception {
        SharedPreferences.Editor r3 = r1.edit();
        r3.putString(KEY_AB_SETTINGS, r2.toString());
        return Boolean.valueOf(r3.commit());
    }

    private static /* synthetic */ JsonObject lambda$updateSettingsV2$2(JsonObject r0, JsonObject r1) throws Exception {
        return getSettingObj(r0, r1);
    }

    private static void saveLiveSP(Context r2, final JsonObject r3) {
        final SharedPreferences r4 = r2.getSharedPreferences("ttlive_open_sdk_shared_pref_cache", 0);
        if (ThreadUtils.b() == false) goto L5;
    L8:
        if (r4 == null) goto L12;
        Observable.fromCallable(new a(r4, r3)).subscribeOn(Schedulers.io()).subscribe(new lz.b());
        return;
    L12:
        return;
    L5:
        if (isAsyncSettingEnable() == true) goto L8;
        notifyUpdateObserve(saveTTLiveSdkSp(r4, r3));
    }

    private static Boolean saveTTLiveSdkSp(SharedPreferences r2, JsonObject r3) {
        SharedPreferences.Editor r4 = r2.edit();
        r4.putString(KEY_SETTINGS, r3.toString());
        copySetingToOuter(r4, r3);
        return Boolean.valueOf(r4.commit());
    }

    public static void updateABSettings(Context r2, final JsonObject r3) {
        if (isAsyncSettingEnable() == false) goto L5;
        return;
    L5:
        if (r2 == null) goto L11;
        if (r3 == null) goto L12;
        final SharedPreferences r4 = r2.getSharedPreferences("ttlive_open_sdk_shared_pref_cache", 0);
        if (r4 == null) goto L13;
        Observable.fromCallable(new f(r4, r3)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new g());
        return;
    L13:
        return;
    L12:
        return;
    }

    public static void updateSettings(Context r3, JsonObject r4) {
        if (r3 == null) goto L20;
        if (r4 == null) goto L21;
        settingDataAdapter(r4);
        JsonElement r0 = r4.get(settingExtraKey);
        if (r0 == null) goto L15;
        if (r0.isJsonObject() == false) goto L15;
        if (TextUtils.isEmpty("update setting v2") == true) goto L12;
        d6.c("SettingGuard", "update setting v2");
    L12:
        f7.c();
        updateSettingsV2(r3, r4, r0.getAsJsonObject());
        return;
    L15:
        if (isAsyncSettingEnable() == false) goto L17;
        int r1 = com.bytedance.android.annie.a.a;
        Intrinsics.checkNotNullParameter(o.class, "clazz");
        com.bytedance.android.annie.a.c(o.class).G(r3, r4);
    L18:
        saveLiveSP(r3, r4);
        return;
    L17:
        int r2 = com.bytedance.android.annie.a.a;
        Intrinsics.checkNotNullParameter(o.class, "clazz");
        com.bytedance.android.annie.a.c(o.class).x1(r3, r4);
        goto L18
    L21:
        return;
    }

    private static /* synthetic */ void lambda$updateSettingsV2$3(Context r1, JsonObject r2, JsonObject r3) throws Exception {
        if (isAsyncSettingEnable() == false) goto L5;
        int r0 = com.bytedance.android.annie.a.a;
        com.bytedance.android.annie.a.b(o.class).G(r1, r3);
    L6:
        saveLiveSP(r1, r2);
        return;
    L5:
        int r4 = com.bytedance.android.annie.a.a;
        com.bytedance.android.annie.a.b(o.class).x1(r1, r3);
        goto L6
    }

    private static void updateSettingsV2(final Context r7, final JsonObject r8, final JsonObject r9) {
        if (ThreadUtils.b() == false) goto L5;
    L15:
        Observable.fromCallable(new lz.c(r8, r9)).subscribeOn(Schedulers.io()).subscribe(new d(r7, r8), new e());
        return;
    L5:
        if (isAsyncSettingEnable() == true) goto L15;
        JsonObject r11 = getSettingObj(r8, r9);     // Catch: Exception -> L13
        if (isAsyncSettingEnable() == false) goto L10;
        int r0 = com.bytedance.android.annie.a.a;     // Catch: Exception -> L13
        com.bytedance.android.annie.a.b(o.class).G(r7, r11);     // Catch: Exception -> L13
    L11:
        saveLiveSP(r7, r8);     // Catch: Exception -> L13
        return;
    L10:
        int r1 = com.bytedance.android.annie.a.a;     // Catch: Exception -> L13
        com.bytedance.android.annie.a.b(o.class).x1(r7, r11);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        d7.a("update_annie_failed", e);
        c.a(1, "incr", "clod", 0L, 0, 0, "update数据" + e.getCause());
    }
}
