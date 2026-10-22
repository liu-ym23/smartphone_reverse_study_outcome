package com.obric.memorydata.middleware.impl.bdtracker;

import android.app.Application;
import android.os.Process;
import com.bytedance.applog.AppLog;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.utils.am;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0018j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0019J\"\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0018j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001`\u0019J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001fH\u0002J(\u0010 \u001a\u00020\u001c*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050!2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/middleware/impl/bdtracker/MemoryAppLogCommonParams;", "", "<init>", "()V", "DEFAULT_APP_VARIANT", "", "KEY_FLOW_PROCESS_NAME", "KEY_FLOW_PROCESS_ID", "KEY_REGION", "KEY_SYS_REGION", "KEY_LANG", "KEY_LANGUAGE", "KEY_SYSTEM_LANGUAGE_DETAIL", "KEY_APP_LANGUAGE", "KEY_TIME_ZONE_NAME", "KEY_USER_IS_LOGIN", "KEY_OBRIC_OS_BUILD_TYPE", "KEY_ROM_VERSION", "KEY_ROM_FULL_VERSION", "KEY_ROM_RELEASE_DATE", "KEY_RELEASE_REGION", "KEY_IS_UT_ROM", "KEY_ASSISTANT_SYSTEM_OS_DEVICE_ID", "getExtraParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getCommonHeader", "syncSystemOsDeviceId", "", "getAppVariant", "getObricParams", "", "putIfNotBlank", "", "key", EventBody.KEY_VALUE, "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11706a = null;

    static {
        f11706a = new a();
    }

    private a() {
    }

    public static final /* synthetic */ void a(String r0) {
        b(r0);
    }

    private final void a(Map<String, String> r2, String r3, String r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L6;
        r1.put(r3, r4);
        return;
    }

    private static final void b(String r2) {
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L6;
        AppLog.setHeaderInfo("assistant_system_os_device_id", r2);
        return;
    }

    private final String d() {
        String r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        a r3 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        com.obric.aiagent.product.feature.a.a r4 = am.f13169a.b();     // Catch: Throwable -> L9
        if (r4 == null) goto L6;
        String r5 = r4.d();     // Catch: Throwable -> L9
    L7:
        Object r6 = Result.m1421constructorimpl(r5);     // Catch: Throwable -> L9
    L12:
        if (Result.m1427isFailureimpl(r6) == false) goto L14;
        r6 = null;
    L14:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L17;
    L21:
        return "obric";
    L17:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L19;
        r1 = r7;
    L19:
        if (r1 == null) goto L21;
        return r1;
    L6:
        r5 = null;
    L9:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    private final Map<String, String> e() {
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        a r8 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        IPlatformService r9 = am.f13169a.a();     // Catch: Throwable -> L9
        if (r9 == null) goto L6;
        IRomInfo r10 = r9.romInfo();     // Catch: Throwable -> L9
    L7:
        Object r11 = Result.m1421constructorimpl(r10);     // Catch: Throwable -> L9
    L12:
        if (Result.m1427isFailureimpl(r11) == false) goto L14;
        r11 = null;
    L14:
        IRomInfo r12 = (IRomInfo) ZeusTransformUtils.preCheckCast(r11, IRomInfo.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L17;
        HashMap r3 = new HashMap();
        a r4 = f11706a;
        Map<String, String> r5 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L21
        Object r7 = Result.m1421constructorimpl(r12.getRomBuildType());     // Catch: Throwable -> L21
    L23:
        Object r13 = "";
        if (Result.m1427isFailureimpl(r7) == false) goto L26;
        r7 = "";
    L26:
        r4.a(r5, "obric_os_build_type", (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"));
        a r14 = f11706a;
        Map<String, String> r15 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L29
        Object r17 = Result.m1421constructorimpl(r12.getShortOSVersion());     // Catch: Throwable -> L29
    L32:
        if (Result.m1427isFailureimpl(r17) == false) goto L34;
        r17 = "";
    L34:
        r14.a(r15, "o_rom_version", (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin"));
        a r18 = f11706a;
        Map<String, String> r19 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L37
        Object r21 = Result.m1421constructorimpl(r12.getOSVersion());     // Catch: Throwable -> L37
    L40:
        if (Result.m1427isFailureimpl(r21) == false) goto L42;
        r21 = "";
    L42:
        r18.a(r19, "o_rom_full_version", (String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.memorydata.plugin"));
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L45
        Object r23 = Result.m1421constructorimpl(String.valueOf(r12.getOSReleaseDate()));     // Catch: Throwable -> L45
    L48:
        if (Result.m1427isFailureimpl(r23) == false) goto L50;
        r23 = null;
    L50:
        String r24 = (String) ZeusTransformUtils.preCheckCast(r23, String.class, "com.obric.memorydata.plugin");
        if (r24 == null) goto L53;
        String r25 = (String) ZeusTransformUtils.preCheckCast(r3.put("o_rom_release_date", r24), String.class, "com.obric.memorydata.plugin");
    L53:
        a r26 = f11706a;
        Map<String, String> r27 = (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L56
        Object r29 = Result.m1421constructorimpl(r12.getRomReleaseRegion());     // Catch: Throwable -> L56
    L59:
        if (Result.m1427isFailureimpl(r29) == true) goto L62;
        r13 = r29;
    L62:
        r26.a(r27, "o_release_region", (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin"));
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L65
        Object r31 = Result.m1421constructorimpl(String.valueOf(r12.isUTRom()));     // Catch: Throwable -> L65
    L68:
        if (Result.m1427isFailureimpl(r31) == true) goto L71;
        r1 = r31;
    L71:
        String r32 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
        if (r32 == null) goto L75;
        r3.put("o_is_ut_rom", r32);
    L75:
        return (Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin");
    L65:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r31 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L56:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r29 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L45:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r23 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L37:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r21 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L29:
        th = move-exception;
        Result.Companion r37 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    L17:
        return MapsKt.emptyMap();
    L6:
        r10 = null;
    L9:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r11 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final HashMap<String, String> a() {
        Locale r0 = Locale.CHINA;
        HashMap<String, String> r4 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Api.KEY_REGION, r0.getCountry()), TuplesKt.to("sys_region", r0.getCountry()), TuplesKt.to("lang", r0.getLanguage()), TuplesKt.to(Api.KEY_LANGUAGE, r0.getLanguage()), TuplesKt.to("system_language_detail", r0.toLanguageTag()), TuplesKt.to(Api.KEY_APP_LANGUAGE, r0.getLanguage()), TuplesKt.to(Api.KEY_TZ_NAME, TimeZone.getDefault().getID()), TuplesKt.to("flow_app_variant", d())});
        if (Intrinsics.areEqual(AppContext.INSTANCE.getPackageName(), "com.obric.lifelog") == false) goto L5;
    L9:
        r4.putAll(f11706a.e());
        return r4;
    L5:
        if (AppContext.INSTANCE.isLogin() == false) goto L7;
        String r1 = "1";
    L8:
        r4.put("user_is_login", r1);
        goto L9
    L7:
        r1 = "0";
        goto L8
    }

    public final HashMap<String, Object> b() {
        Locale r0 = Locale.CHINA;
        HashMap<String, Object> r5 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("flow_process_name", Application.getProcessName()), TuplesKt.to("flow_process_id", String.valueOf(Process.myPid())), TuplesKt.to("flow_app_variant", d()), TuplesKt.to("system_language_detail", r0.toLanguageTag()), TuplesKt.to(Api.KEY_APP_LANGUAGE, r0.getLanguage())});
        r5.putAll(f11706a.e());
        String r1 = null;
        String r2 = AppContext.INSTANCE.getOsDeviceId(null);
        if (r2 != null) goto L5;
    L9:
        return r5;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L7;
        r1 = r2;
    L7:
        if (r1 == null) goto L9;
        r5.put("assistant_system_os_device_id", r1);
        goto L9
    }

    public final void c() {
        String r3 = AppContext.INSTANCE.getOsDeviceId((Function1) ZeusTransformUtils.preCheckCast(MemoryAppLogCommonParams$syncSystemOsDeviceId$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L6;
        b(r3);
        return;
    }
}
