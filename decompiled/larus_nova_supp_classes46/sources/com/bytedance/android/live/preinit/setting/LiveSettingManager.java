package com.bytedance.android.live.preinit.setting;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.base.sp.TTOpenLiveSettingUtil;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdk.config.LiveInitSettingKeysForSaas;
import com.bytedance.android.livesdkapi.util.LiveSDKConstUtil;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ms0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010J$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/preinit/setting/LiveSettingManager;", "", "()V", "ASYNC_SETTING", "", "SETTING_CALLBACK", "Lkotlin/Function1;", "", "", "getSETTING_CALLBACK", "()Lkotlin/jvm/functions/Function1;", "setSETTING_CALLBACK", "(Lkotlin/jvm/functions/Function1;)V", "SETTING_PATH", "getSettingsTasksInIoThread", "context", "Landroid/content/Context;", "syncLiveSDKSettings", "callback", "livehostadapter_release"}, k = 1, mv = {1, 4, 3})
public final class LiveSettingManager {
    public static final String ASYNC_SETTING = "enable_async_settings";
    public static final LiveSettingManager INSTANCE = null;
    private static Function1<? super Boolean, Unit> SETTING_CALLBACK = null;
    public static final String SETTING_PATH = "/webcast/openapi/setting/";

    public static final class a<T> implements ObservableOnSubscribe {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void subscribe(ObservableEmitter<JsonObject> r7) {
            Intrinsics.checkNotNullParameter(r7, "it");
            IHostNetwork r0 = k.f(IHostNetwork.class);
            String r1 = null;
            if (r0 == null) goto L5;
            String r2 = r0.getHostDomain();
        L7:
            if (TextUtils.isEmpty(r2) == true) goto L35;
            UrlBuilder r3 = new UrlBuilder("https://" + r2 + LiveSettingManager.SETTING_PATH);
            IHostContext r4 = k.f(IHostContext.class);
            boolean r5 = false;
            if (r4 == null) goto L11;
            int r6 = r4.appId();
        L12:
            r3.addParam("webcast_app_id", r6);
            String r8 = LiveSDKConstUtil.getSdkVersion();
            if (r8.length() <= 0) goto L15;
            boolean r9 = true;
        L16:
            if (r9 == true) goto L19;
            r8 = null;
        L19:
            if (r8 == null) goto L37;
            r3.addParam("webcast_sdk_version", r8);
        L37:
            String r10 = NetworkClient.getDefault().get(r3.build());     // Catch: Exception -> L31
            if (r10.length() <= 0) goto L24;
            r5 = true;
        L24:
            if (r5 == false) goto L26;
            r1 = r10;
        L26:
            if (r1 == null) goto L35;
            LiveInitSettingKeysForSaas.canReadPerformanceSettings = true;     // Catch: Exception -> L31
            JsonObject r11 = ((ms0.a) LiveGsonHelper.get().fromJson(r1, ms0.a.class)).a();     // Catch: Exception -> L31
            if (r11 == null) goto L35;
            r7.onNext(r11);     // Catch: Exception -> L31
        L31:
            e = move-exception;
            ALogger.e("ttlive_error", e);
            Function1<Boolean, Unit> r12 = LiveSettingManager.INSTANCE.getSETTING_CALLBACK();
            if (r12 == null) goto L35;
            Unit r13 = (Unit) r12.invoke(Boolean.FALSE);
            goto L35
        L15:
            r9 = false;
            goto L16
        L11:
            r6 = 0;
        L35:
            r7.onComplete();
            return;
        L5:
            r2 = null;
            goto L7
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ Context a;

        public b(Context r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            JsonObject r4 = (JsonObject) r3;
            Function1<Boolean, Unit> r0 = LiveSettingManager.INSTANCE.getSETTING_CALLBACK();
            if (r0 == null) goto L5;
            Unit r1 = (Unit) r0.invoke(Boolean.TRUE);
        L5:
            TTOpenLiveSettingUtil.updateSettings(this.a, r4);
        }
    }

    private LiveSettingManager() {
    }

    static {
        INSTANCE = new LiveSettingManager();
    }

    public final Function1<Boolean, Unit> getSETTING_CALLBACK() {
        return SETTING_CALLBACK;
    }

    private final void getSettingsTasksInIoThread(Context r3) {
        Observable.create(a.a).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new b(r3));
    }

    public final void setSETTING_CALLBACK(Function1<? super Boolean, Unit> r1) {
        SETTING_CALLBACK = r1;
    }

    public final void syncLiveSDKSettings(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (TTOpenLiveSettingUtil.isAsyncSettingEnable() == false) goto L5;
        getSettingsTasksInIoThread(r2.getApplicationContext());
        return;
    L5:
        new c(r2.getApplicationContext()).execute1(new String[0]);
    }

    public final void syncLiveSDKSettings(Context r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        SETTING_CALLBACK = r3;
        if (TTOpenLiveSettingUtil.isAsyncSettingEnable() == false) goto L5;
        getSettingsTasksInIoThread(r2.getApplicationContext());
        return;
    L5:
        new c(r2.getApplicationContext()).execute1(new String[0]);
    }
}
