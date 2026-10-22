package com.bytedance.iesgurd.settings;

import android.content.Context;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.net.RequestExecutor;
import com.bytedance.geckox.settings.model.GlobalConfigSettings;
import com.bytedance.geckox.settings.model.SettingsLocal;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.RequestBodySettings;
import com.lynx.tasm.behavior.ui.utils.n;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import l9.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static GlobalConfigSettings f6692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f6693b = "0";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final n f6694c = null;
    public static final g d = null;
    public static final AtomicBoolean e = null;
    public static final AtomicBoolean f = null;
    public static ff.a g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ReqType f6695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ReqType f6696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static SettingsExtra f6697j;

    static {
        n r5 = new n(5);
        f6694c = r5;
        e = new AtomicBoolean(false);
        f = new AtomicBoolean(false);
        df.c r10 = df.c.f16652i;
        r10.a();
        r10.a();
        GeckoGlobalConfig r11 = df.c.f;
        we.a r12 = com.bytedance.geckox.utils.d.f4794a;
        String r13 = r12.e((Context) r5.f10761a, "gecko_settings_local", null);
        if (r13 != null) goto L46;
    L6:
        SettingsLocal r14 = null;
    L7:
        String r15 = r11.getEnv().name();
        String r16 = r11.getAppVersion();
        if (r14 == null) goto L10;
        String r17 = r14.getEnv();
        String r18 = r14.getAppVersion();
    L11:
        Context r19 = df.c.c();
        if (r19 == null) goto L17;
        String r20 = r12.e(r19, "gecko_settings_extra", null);
        if (r20 == null) goto L17;
        SettingsExtra r21 = (SettingsExtra) oa.b.f20421b.f20423a.fromJson(r20, SettingsExtra.class);     // Catch: Throwable -> L42
    L18:
        f6697j = r21;
        n r22 = f6694c;
        SettingsLocal r23 = new SettingsLocal(r15, r16);
        r22.getClass();
        GeckoLogger.a("settings local cache stored: " + r23.getAppVersion());
        String r24 = oa.b.f20421b.f20423a.toJson(r23);
        Context r25 = (Context) r22.f10761a;
        r12.g(r25, "gecko_settings_local", r24);
        if (r17 != null) goto L21;
    L40:
        d = new g(4);
        return;
    L21:
        if (Intrinsics.areEqual(r15, r17) == false) goto L28;
        if (Intrinsics.areEqual(r16, r18) == false) goto L28;
        GlobalConfigSettings r26 = r22.k();
        f6692a = r26;
        if (r26 == null) goto L40;
        f6693b = r26.getVersion();
    L28:
        if (Intrinsics.areEqual(r15, r17) == true) goto L31;
        GeckoLogger.a("env changed, delete gecko cache, from " + r17 + " to " + r15);
        com.lynx.tasm.behavior.utils.d.d();
        f6692a = null;
        f6693b = "0";
        GeckoLogger.a("settings cache deleted");
        r12.f(r25);
        goto L40
    L31:
        if (Intrinsics.areEqual(r16, r18) == true) goto L40;
        GeckoLogger.a("app_version changed, from " + r18 + " to " + r16);
        GlobalConfigSettings r27 = r22.k();
        f6692a = r27;
        f6693b = "0";
        if (r27 == null) goto L40;
        if (r27.getResourceMeta() == null) goto L40;
        GlobalConfigSettings r28 = f6692a;
        if (r28 != null) goto L39;
        Intrinsics.throwNpe();
    L39:
        r28.getResourceMeta().setAccessKeys(MapsKt.emptyMap());
    L17:
        r21 = null;
        goto L18
    L10:
        r18 = null;
        r17 = null;
        goto L11
    L46:
        r14 = (SettingsLocal) oa.b.f20421b.f20423a.fromJson(r13, SettingsLocal.class);     // Catch: Throwable -> L43
        goto L7
    }

    public static final /* synthetic */ ff.a a() {
        ff.a r5 = g;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statisticData");
    L5:
        return r5;
    }

    public static final void b(ReqType r5, boolean r10) {
        ff.a r11 = g;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statisticData");
    L5:
        r11.getClass();
        r11.f = r5;
        ff.a r12 = g;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("statisticData");
    L8:
        String r13 = f6693b;
        r12.f16896h = r13;
        RequestBodySettings r14 = new RequestBodySettings(r5, r13);
        if (r10 == false) goto L11;
        r14.getReqInfo().setRetry(true);
    L11:
        df.c.f16652i.a();
        new RequestExecutor(r14, "https://" + df.c.f.getHost() + "/gkx/api/settings/v3", GlobalSettingsManager$syncRequestServer$2.f6684a).b();
    }
}
