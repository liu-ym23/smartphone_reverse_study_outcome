package com.bytedance.awemeopen.infra.plugs.settings.service.data;

import com.bytedance.awemeopen.infra.base.debug.AoDebug;
import com.bytedance.awemeopen.infra.base.env.AoEnv;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.task.AoPool;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\u000eH\u0007J+\u0010\r\u001a\u0004\u0018\u00010\u000e2\u001a\u0010\u000f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010\"\u0006\u0012\u0002\b\u00030\u0011H\u0007¢\u0006\u0002\u0010\u0012J#\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0010\"\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0013J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015H\u0007J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J)\u0010\u0018\u001a\u00020\u000e2\u001a\u0010\u000f\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00110\u0010\"\u0006\u0012\u0002\b\u00030\u0011H\u0007¢\u0006\u0002\u0010\u0012J!\u0010\u0018\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0010\"\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u001a\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0007J\u0018\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020!H\u0007J\u001c\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015*\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006#"}, d2 = {"Lcom/bytedance/awemeopen/infra/plugs/settings/service/data/MiniAppSettingsHelper;", "", "()V", "TAG", "", "mMiniAppSettings", "Lcom/bytedance/awemeopen/infra/plugs/settings/service/data/AoSDKSettingsServiceImpl;", "getMMiniAppSettings", "()Lcom/bytedance/awemeopen/infra/plugs/settings/service/data/AoSDKSettingsServiceImpl;", "mMiniAppSettings$delegate", "Lkotlin/Lazy;", "clearMockSettings", "", "getSettings", "Lorg/json/JSONObject;", "keys", "", "", "([Ljava/lang/Enum;)Lorg/json/JSONObject;", "([Ljava/lang/String;)Lorg/json/JSONObject;", "key", "", "getSettingsArray", "Lorg/json/JSONArray;", "getSettingsNonNull", "setMockSettings", "mock", "updateSettings", "from", "force", "", "updateSettingsWithMeta", "needUpdateSettings", "", "optListString", "ao_plugin_settings_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MiniAppSettingsHelper {
    public static final MiniAppSettingsHelper INSTANCE = null;
    private static final String TAG = "MiniAppSettingsHelper";
    private static final Lazy mMiniAppSettings$delegate = null;

    private MiniAppSettingsHelper() {
    }

    static {
        INSTANCE = new MiniAppSettingsHelper();
        mMiniAppSettings$delegate = LazyKt.lazy(MiniAppSettingsHelper$mMiniAppSettings$2.INSTANCE);
    }

    private final AoSDKSettingsServiceImpl getMMiniAppSettings() {
        return (AoSDKSettingsServiceImpl) mMiniAppSettings$delegate.getValue();
    }

    @Deprecated(message = "replace getSettings(key)")
    @JvmStatic
    public static final JSONObject getSettings() {
        return INSTANCE.getMMiniAppSettings().getSettings();
    }

    @JvmStatic
    public static final void clearMockSettings() {
        if (AoDebug.b() == false) goto L5;
    L6:
        INSTANCE.getMMiniAppSettings().clearMockSettings(null);
        return;
    L5:
        if (AoEnv.i() == true) goto L6;
    }

    @JvmStatic
    public static final JSONObject getSettings(List<String> r5) {
        if (r5 != null) goto L5;
    L14:
        return null;
    L5:
        if (r5.isEmpty() == true) goto L14;
        JSONObject r1 = getSettings((String) ListProtector.get(r5, 0));
        int r2 = r5.size();
        int r3 = 1;
    L8:
        if (r3 >= r2) goto L13;
        if (r1 == null) goto L11;
        r1 = r1.optJSONObject((String) ListProtector.get(r5, r3));
    L12:
        r3 = r3 + 1;
        goto L8
    L11:
        r1 = null;
        goto L12
    L13:
        return r1;
    }

    @JvmStatic
    public static final JSONArray getSettingsArray(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        return INSTANCE.getMMiniAppSettings().getSettingsArray(r1);
    }

    @JvmStatic
    public static final JSONObject getSettingsNonNull(Enum<?>... r4) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(r4[r2].toString());
        r2 = r2 + 1;
        goto L3
    L5:
        JSONObject r5 = getSettings(r0);
        if (r5 == null) goto L8;
        return r5;
    L8:
        return new JSONObject();
    }

    @JvmStatic
    public static final void updateSettingsWithMeta(final int r1) {
        AoPool.a(new AnonymousClass1(r1));
    }

    @JvmStatic
    public static final JSONObject getSettings(Enum<?>... r4) {
        Intrinsics.checkNotNullParameter(r4, "keys");
        ArrayList r0 = new ArrayList(r4.length);
        int r1 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        r0.add(r4[r2].toString());
        r2 = r2 + 1;
        goto L3
    L6:
        return getSettings(r0);
    }

    @JvmStatic
    public static final JSONObject getSettingsNonNull(String... r1) {
        Intrinsics.checkNotNullParameter(r1, "keys");
        JSONObject r2 = getSettings(ArraysKt.toList(r1));
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new JSONObject();
    }

    @JvmStatic
    public static final JSONObject getSettings(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        return INSTANCE.getMMiniAppSettings().getSettings(r1);
    }

    @JvmStatic
    public static final JSONObject getSettingsNonNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "key");
        JSONObject r2 = getSettings(r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return new JSONObject();
    }

    @JvmStatic
    public static final JSONObject getSettings(String... r1) {
        Intrinsics.checkNotNullParameter(r1, "keys");
        return getSettings(ArraysKt.toList(r1));
    }

    @JvmStatic
    public static final List<String> optListString(JSONObject r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "key");
        JSONArray r5 = r3.optJSONArray(r4);
        if (r5 != null) goto L6;
        return null;
    L6:
        ArrayList r6 = new ArrayList();
        int r0 = r5.length();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L9;
        r6.add(r5.optString(r1));
        r1 = r1 + 1;
        goto L7
    L9:
        return r6;
    }

    @JvmStatic
    public static final void setMockSettings(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "key");
        if (AoDebug.b() == false) goto L5;
    L6:
        INSTANCE.getMMiniAppSettings().setMockSettings(r1, r2);
        return;
    L5:
        if (AoEnv.i() == true) goto L6;
    }

    @JvmStatic
    public static final void updateSettings(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "from");
        AoLogger.g(TAG, new Object[]{"updateSettings", r3, Boolean.valueOf(r4)});
        INSTANCE.getMMiniAppSettings().updateSettings(r4, r3);
    }
}
