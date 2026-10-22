package com.larus.dora.impl.ota;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.device.ota.model.OTAUpdateMeta;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.impl.device.ota.DoraOTAReporter;
import com.larus.dora.impl.ota.check.DoraOTACheckRepository;
import com.larus.dora.impl.ota.utils.KeyLogUtils;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import com.larus.dora.impl.util.g0;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import g49.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.DoraOTATask$checkUpdate$1", f = "DoraOTATask.kt", i = {0, 0, 0, 0, 0}, l = {287}, m = "invokeSuspend", n = {"stateBeforeCheck", "sn", "product", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "osVersion"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class DoraOTATask$checkUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ DoraOTACheckFrom $from;
    final /* synthetic */ boolean $isDebug;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ DoraOTATask this$0;

    public DoraOTATask$checkUpdate$1(DoraOTATask r1, DoraOTACheckFrom r2, DoraDevice r3, boolean r4, Continuation<? super DoraOTATask$checkUpdate$1> r5) {
        this.this$0 = r1;
        this.$from = r2;
        this.$device = r3;
        this.$isDebug = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraOTATask$checkUpdate$1(this.this$0, this.$from, this.$device, this.$isDebug, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r36) {
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        String r1 = (String) this.L$4;
        String r2 = (String) this.L$3;
        String r3 = (String) this.L$2;
        String r14 = (String) this.L$1;
        d49.a r4 = (d49.a) this.L$0;
        ResultKt.throwOnFailure(r36);
        Object r18 = ((Result) r36).unbox-impl();
        String r15 = "DoraOTATask0711";
        String r32 = "DoraOTAUtils";
        String r31 = "product";
        String r17 = DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL;
        Object r33 = "0";
        String r5 = r14;
        String r16 = "checkUpdate: from=";
        Object r6 = r18;
    L72:
        DoraOTACheckFrom r7 = this.$from;
        DoraOTATask r8 = this.this$0;
        boolean r9 = this.$isDebug;
        DoraDevice r10 = this.$device;
        if (Result.isSuccess-impl(r6) == false) goto L196;
        e49.a r11 = (e49.a) r6;
        StringBuilder r12 = new StringBuilder(r16);
        r12.append(r7);
        r12.append(" success: response packageInfoList=");
        if (r11 == null) goto L79;
        z39.a r20 = r11.a;
        if (r20 == null) goto L79;
        List<OTAUpdatePackage> r21 = r20.b();
    L80:
        r12.append(r21);
        d.d(r15, r12.toString());
        StringBuilder r22 = new StringBuilder(r16);
        r22.append(r7);
        r22.append(" success: response meta=");
        if (r11 == null) goto L85;
        z39.a r110 = r11.a;
        if (r110 == null) goto L85;
        OTAUpdateMeta r111 = r110.a();
    L86:
        r22.append(r111);
        d.d(r15, r22.toString());
        StringBuilder r23 = new StringBuilder(r16);
        r23.append(r7);
        r23.append(" success: response trace=");
        if (r11 == null) goto L91;
        z39.a r112 = r11.a;
        if (r112 == null) goto L91;
        String r113 = r112.d();
    L92:
        r23.append(r113);
        d.d(r15, r23.toString());
        StringBuilder r24 = new StringBuilder(r16);
        r24.append(r7);
        r24.append(" success: response taskId=");
        if (r11 == null) goto L97;
        z39.a r114 = r11.a;
        if (r114 == null) goto L97;
        String r115 = r114.c();
    L98:
        r24.append(r115);
        d.d(r15, r24.toString());
        StringBuilder r25 = new StringBuilder(r16);
        r25.append(r7);
        r25.append(" success, isPeripheralResponse=");
        if (r11 == null) goto L101;
        Boolean r116 = Boxing.boxBoolean(r11.c);
    L102:
        r25.append(r116);
        r25.append(", isNuttxFirmware=");
        if (r11 == null) goto L105;
        Boolean r117 = Boxing.boxBoolean(r11.b);
    L106:
        r25.append(r117);
        d.d(r15, r25.toString());
        if (r11 == null) goto L112;
        if (r11.c != true) goto L112;
        boolean r26 = true;
    L113:
        if (r26 == false) goto L116;
        d49.a.c r27 = new d49.a.c(r11);
        int r28 = DoraOTATask.z;
        r8.t(r27);
        return Unit.INSTANCE;
    L116:
        r8.s = r9;
        int r30 = KeyLogUtils.a;
        KeyLogUtils.LogType r210 = KeyLogUtils.LogType.KEY;
        KeyLogUtils.DataLink r211 = KeyLogUtils.DataLink.OTA;
        KeyLogUtils.DataFlowDirection r212 = KeyLogUtils.DataFlowDirection.INTERNAL;
        KeyLogUtils.a r34 = new KeyLogUtils.a();
        r34.a("package", "none");
        KeyLogUtils.a(r210, r211, r212, "ota_check_end", r34, "-");
        if (r11 == null) goto L119;
        z39.a r35 = r11.a;
    L120:
        if (r11 == null) goto L122;
        OTAUpdatePackage r118 = e49.b.a(r11);
    L123:
        if (r118 == null) goto L125;
        String r119 = r118.getVersion();
    L126:
        d49.a r213 = r4;
        if (r119 != null) goto L130;
        r119 = "";
    L130:
        if (r35 == null) goto L166;
        if (r118 == null) goto L166;
        if (r119.length() != 0) goto L135;
        boolean r214 = true;
    L136:
        if (r214 == true) goto L166;
        int r215 = j69.a.a;
        Intrinsics.checkNotNull(r2);
        String r37 = r35.d();
        if (r37 != null) goto L141;
        r37 = "";
    L141:
        int r38 = r118.getType();
        Intrinsics.checkNotNullParameter(r5, "sn");
        Intrinsics.checkNotNullParameter(r2, r17);
        Intrinsics.checkNotNullParameter(r3, r31);
        Intrinsics.checkNotNullParameter(r1, "osVersion");
        Intrinsics.checkNotNullParameter(r37, "trace");
        Intrinsics.checkNotNullParameter(r119, "targetVersion");
        d.d("DoraOTATracker", "initParameters: sn=" + r5 + ", model=" + r2 + ", product=" + r3 + ", osVersion=" + r1 + ", trace=" + r37 + ", pkgType=" + r38 + ", targetVersion=" + r119);
        j69.a.a = r38;
        j69.a.b = r119;
        DoraOTAReporter.a(r5, r2, r1, r3, r37);
        String r40 = r8.d.a;
        String r41 = r118.getName();
        if (r41 != null) goto L144;
        r41 = "";
    L144:
        String r42 = r118.getMd5();
        if (r42 != null) goto L147;
        r42 = "";
    L147:
        boolean r43 = DownloadUtils.isFileDownloaded(r40, r41, r42, false);
        d.d(r15, r16 + r7 + " isFileDownloaded=" + r43);
        if (r43 == false) goto L150;
        d49.a r44 = new d49.a.j(r11);
    L165:
        r8.t(r44);
        DoraSystemInfoManager r45 = DoraSystemInfoManager.a;
        DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("has_new_firmware_available", "1")));
        DoraDevice r46 = r10;
    L189:
        if (r9 == true) goto L194;
        b r47 = b.a;
        String r48 = r46.sn;
        if (r48 != null) goto L193;
        r48 = "";
    L193:
        r47.b(r48, r119);
    L194:
        d.d(r15, r16 + r7 + ", syncOTAWifiSilentVersion " + r119 + ", ret=" + kj4.a.g().t(r119));
        goto L196
    L150:
        if (r9 == true) goto L164;
        d.d(r15, r16 + r7 + " deleteOTAFilesExcludeTemp");
        int r50 = k69.b.a;
        String r51 = r8.d.a;
        String r52 = r118.getName();
        if (r52 != null) goto L154;
        r52 = "";
    L154:
        Intrinsics.checkNotNullParameter(r51, "path");
        Intrinsics.checkNotNullParameter(r52, "otaFileName");
        String r53 = r32;
        d.d(r53, "deleteOTAFilesExcludeTemp: path=" + r51 + ", name=" + r52);     // Catch: Throwable -> L159
        k69.b.a(r51, new String[]{DownloadUtils.getTempFileName(r52)});     // Catch: Throwable -> L159
        d.d(r53, "deleteOTAFilesExcludeTemp: success");     // Catch: Throwable -> L159
    L159:
        th = th;
    L163:
        d.c(r53, "deleteOTAFilesExcludeTemp: ERROR", th);
    L161:
        th = th;
        r53 = r32;
    L164:
        r44 = new d49.a.c(r11);
        goto L165
    L135:
        r214 = false;
    L166:
        boolean r54 = true;
        r46 = r10;
        String r55 = r46.androidRomVersion;
        String r120 = r46.softVersion;
        d49.b r56 = new d49.b(r55, r120);
        Intrinsics.checkNotNullParameter(r56, "currentDevice");
        Intrinsics.checkNotNullParameter(r213, "stateBeforeCheck");
        if ((r213 instanceof d49.a.n) == false) goto L169;
        d49.a.n r121 = (d49.a.n) r213;
    L170:
        if (r121 == null) goto L174;
        d49.b r122 = r121.c;
        if (r122 == null) goto L174;
        String r123 = r122.b;
    L175:
        if (r123 != null) goto L178;
        r123 = "";
    L178:
        if (r123.length() > 0) goto L181;
        r54 = false;
    L181:
        if (r54 == false) goto L188;
        int r57 = g0.a;
        if (r120 != null) goto L186;
        r120 = "";
    L186:
        if (g0.a(r120, r123) >= 0) goto L188;
        r56 = new d49.b(r55, r123);
    L188:
        r8.t(new d49.a.b(r56));
        DoraSystemInfoManager r58 = DoraSystemInfoManager.a;
        DoraSystemInfoManager.f(CollectionsKt.listOf(TuplesKt.to("has_new_firmware_available", r33)));
    L174:
        r123 = null;
        goto L175
    L169:
        r121 = null;
        goto L170
    L125:
        r119 = null;
        goto L126
    L122:
        r118 = null;
        goto L123
    L119:
        r35 = null;
    L112:
        r26 = false;
        goto L113
    L105:
        r117 = null;
        goto L106
    L101:
        r116 = null;
    L97:
        r115 = null;
    L91:
        r113 = null;
    L85:
        r111 = null;
    L79:
        r21 = null;
    L196:
        DoraOTATask r60 = this.this$0;
        Throwable r61 = Result.exceptionOrNull-impl(r6);
        if (r61 == null) goto L200;
        int r62 = KeyLogUtils.a;
        KeyLogUtils.a(KeyLogUtils.LogType.ERROR, KeyLogUtils.DataLink.OTA, KeyLogUtils.DataFlowDirection.INTERNAL, "ota_check_end", null, "Message:" + r61);
        d49.a.C0124a r63 = d49.a.C0124a.c;
        int r64 = DoraOTATask.z;
        r60.t(r63);
    L200:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r36);
        DoraOTATask r65 = this.this$0;
        int r66 = DoraOTATask.z;
        d49.a r67 = r65.o();
        if (r67.b == true) goto L12;
        d.e("DoraOTATask0711", "checkUpdate: from=" + this.$from + " RETURN, currentState=" + this.this$0.o());
        return Unit.INSTANCE;
    L12:
        this.this$0.t(d49.a.d.c);
        String r68 = this.$device.sn;
        if (r68 != null) goto L15;
        String r70 = "";
    L16:
        Intrinsics.checkNotNullParameter(wj4.a.a.a, "<this>");
        DoraDevice r71 = ak4.a.d().current();
        if (r71 == null) goto L19;
        int r72 = r71.type;
    L20:
        d.d("DoraOTAUtils", "productName: " + r72);
        if (r72 == 2) goto L27;
        switch(r72) {
            case 16: goto L26;
            case 17: goto L25;
            case 18: goto L24;
            default: goto L23;
        };
    L23:
        String r73 = DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME;
    L28:
        String r124 = r73;
        DoraDevice r74 = ak4.a.d().a.A;
        if (r74 == null) goto L36;
        int r75 = r74.type;
        if (r75 == 2) goto L35;
        switch(r75) {
            case 16: goto L34;
            case 17: goto L34;
            case 18: goto L34;
            case 19: goto L34;
            default: goto L36;
        };
    L34:
        String r76 = "WYF";
    L37:
        String r125 = r76;
        DoraDevice r77 = this.$device;
        String r78 = r77.androidOSVersion;
        if (r78 != null) goto L40;
        r78 = "";
    L40:
        String r126 = r77.androidRomVersion;
        if (r126 != null) goto L43;
        r126 = "";
    L43:
        String r80 = r77.androidBuildTime;
        if (r80 != null) goto L47;
        r80 = "";
    L47:
        if (this.$from != DoraOTACheckFrom.REQUIRE_FULL_PACKAGE) goto L49;
        int r81 = 1;
    L50:
        String r82 = "userdebug";
        if (StringsKt.contains$default(r126, "userdebug", false, 2, null) == true) goto L54;
        r82 = "user";
    L54:
        String r127 = r82;
        int r83 = KeyLogUtils.a;
        KeyLogUtils.LogType r216 = KeyLogUtils.LogType.KEY;
        KeyLogUtils.DataLink r217 = KeyLogUtils.DataLink.OTA;
        KeyLogUtils.DataFlowDirection r218 = KeyLogUtils.DataFlowDirection.INTERNAL;
        KeyLogUtils.a r84 = new KeyLogUtils.a();
        r84.a("product", this.$device.getProductName());
        r31 = "product";
        Intrinsics.checkNotNullParameter("android_pkg_type", "key");
        r84.a.put("android_pkg_type", r81);     // Catch: JSONException -> L57
    L59:
        r84.a(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, r125);
        r84.a("android_os_version", r78);
        r84.a("android_rom_version", r126);
        r84.a("android_build_time", r80);
        r84.a("sn", r70);
        boolean r85 = this.$isDebug;
        String r128 = r80;
        Intrinsics.checkNotNullParameter("isDebug", "key");
        r84.a.put("isDebug", r85);     // Catch: JSONException -> L62
    L64:
        KeyLogUtils.a(r216, r217, r218, "ota_check_start", r84, "-");
        DoraOTACheckRepository r86 = DoraOTACheckRepository.a;
        Intrinsics.checkNotNull(r125);
        if (r81 != 1) goto L67;
        String r129 = "1";
    L68:
        boolean r87 = this.$isDebug;
        this.L$0 = r67;
        this.L$1 = r70;
        this.L$2 = r124;
        this.L$3 = r125;
        this.L$4 = r78;
        this.label = 1;
        String r219 = r78;
        String r220 = r70;
        r16 = "checkUpdate: from=";
        r15 = "DoraOTATask0711";
        r32 = "DoraOTAUtils";
        String r88 = r129;
        r17 = DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL;
        r33 = "0";
        Object r90 = r86.b(r124, r125, r220, r219, r126, r128, r88, r127, r87, this);
        if (r90 != r13) goto L71;
        return r13;
    L71:
        r6 = r90;
        r2 = r125;
        r3 = r124;
        r1 = r219;
        r5 = r220;
        r4 = r67;
        goto L72
    L67:
        r129 = "0";
    L62:
        e = move-exception;
        KeyLogUtils.a.b("isDebug", e);
    L57:
        e = move-exception;
        KeyLogUtils.a.b("android_pkg_type", e);
        goto L59
    L49:
        r81 = r77.androidPkgType;
        goto L50
    L35:
        r76 = "Ola-Vision";
    L36:
        r76 = "SPD";
        goto L37
    L24:
        r73 = "GAir";
        goto L28
    L25:
        r73 = "G2";
        goto L28
    L26:
        r73 = "DoraG";
        goto L28
    L27:
        r73 = "DoraE";
        goto L28
    L19:
        r72 = -1;
        goto L20
    L15:
        r70 = r68;
        goto L16
    }
}
