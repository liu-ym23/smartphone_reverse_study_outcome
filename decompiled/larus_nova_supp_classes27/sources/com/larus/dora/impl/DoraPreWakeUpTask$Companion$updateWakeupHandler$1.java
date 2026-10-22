package com.larus.dora.impl;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.enroll.audio.enroll.IVoiceEnrollService;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.impl.util.PacificInterfaceManager;
import com.mammon.audiosdk.SAMICore;
import com.obric.assistant.spi.dora.IObricDoraService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ugc.effectplatform.algorithm.AlgorithmModelResourceFinder;
import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceManager;
import g49.d;
import java.io.File;
import kj4.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraPreWakeUpTask$Companion$updateWakeupHandler$1", f = "DoraPreWakeUpTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraPreWakeUpTask$Companion$updateWakeupHandler$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraPreWakeUpTask$Companion$updateWakeupHandler$1(Continuation<? super DoraPreWakeUpTask$Companion$updateWakeupHandler$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraPreWakeUpTask$Companion$updateWakeupHandler$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L155;
        ResultKt.throwOnFailure(r110);
        int r0 = DoraPreWakeUpTask.d;
        AlgorithmResourceManager r1 = DoraPreWakeUpTask.Companion.f();
        if (r1 == null) goto L153;
        AlgorithmModelResourceFinder r2 = r1.getResourceFinder();
        if (r2 == null) goto L153;
        String r3 = r2.findResourceUri("db_lp_kws_255");
        if (r3 == null) goto L11;
        String r4 = StringsKt.replace$default(r3, "file://", "", false, 4, null);
    L12:
        String r5 = r2.findResourceUri("db_kws_sid_255");
        if (r5 == null) goto L15;
        String r6 = StringsKt.replace$default(r5, "file://", "", false, 4, null);
    L16:
        if (r4 != null) goto L18;
    L21:
        boolean r7 = true;
    L23:
        if (r7 == true) goto L150;
        if (r6 != null) goto L26;
    L29:
        boolean r8 = true;
    L30:
        if (r8 == true) goto L150;
        AppHost.Companion r9 = AppHost.a;
        File r10 = r9.getApplication().getExternalFilesDir(null);
        if (r10 == null) goto L36;
        String r11 = r10.getAbsolutePath();
        if (r11 == null) goto L36;
    L37:
        String r12 = r11 + File.separator;
        DoraDevice r13 = DoraAdapterExtKt.h(a.g());
        if (r4 == null) goto L40;
        String r14 = DoraPreWakeUpTask.Companion.i(r4);
    L41:
        if (r6 == null) goto L43;
        String r15 = DoraPreWakeUpTask.Companion.i(r6);
    L44:
        Function1<? super Boolean, Unit> r16 = PacificInterfaceManager.a;
        if (r13 == null) goto L48;
        String r17 = r13.mac;
        if (r17 == null) goto L48;
    L49:
        Intrinsics.checkNotNullParameter(r17, "mac");
        String r18 = PacificInterfaceManager.f(r17);
        if (r18 == null) goto L53;
        r17 = r18;
    L53:
        IVoiceEnrollService r111 = (IVoiceEnrollService) ServiceManager.get().getService(IVoiceEnrollService.class);
        if (r111 == null) goto L86;
        byte[] r112 = r111.h(r17);
        if (r112 == null) goto L86;
        if (r112.length != 0) goto L61;
        boolean r113 = true;
    L63:
        if (r113 == false) goto L65;
        d.d("PacificInterfaceManager", "saveFeatureToFile: feature is null or empty, skip save");
        goto L86
    L65:
        ILoginService r20 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r20 == null) goto L71;
        q38.a r21 = r20.getAccountInfo();
        if (r21 == null) goto L71;
        String r22 = r21.c;
        if (r22 == null) goto L71;
    L72:
        String r114 = PacificInterfaceManager.g(r112);
        if (r114 != null) goto L75;
        r114 = "";
    L75:
        d.d("PacificInterfaceManager", "saveFeatureToFile hash: ".concat(r114));
        PolarisFileWrapper r23 = new PolarisFileWrapper(r9.getApplication().getFilesDir(), "wakeup_sid");
        if (r23.exists() == true) goto L78;
        r23.mkdirs();
    L78:
        PacificInterfaceManager.a(r17);
        String r115 = "";
        PolarisFileWrapper r24 = new PolarisFileWrapper(r23, "sid_feature_" + r22 + '_' + r17 + '_' + r114 + ".bin");
    L84:
        e = move-exception;
        d.b("PacificInterfaceManager", "saveFeatureToFile failed: " + e.getMessage());
    L87:
        String r25 = null;
    L88:
        IObricDoraService r26 = (IObricDoraService) ServiceManager.get().getService(IObricDoraService.class);
        if (r26 != null) goto L91;
    L93:
        boolean r27 = false;
    L94:
        d.a("DoraPreWakeUpTask", "registerWakeupRequestHandler sidFeaturePath: " + r25 + ", useObricLogic: " + r27);
        IDoraService r28 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r28 == null) goto L101;
        DeviceService r30 = r28.device();
        if (r30 == null) goto L101;
        if (r30.a() != true) goto L101;
        boolean r31 = true;
    L102:
        JSONObject r32 = new JSONObject();
        r32.put("model_md5", r14);
        r32.put("model_path", r4);
        if (r31 == false) goto L118;
        r32.put("sid_model_md5", r15);
        r32.put("sid_model_path", r6);
        if (r27 == true) goto L118;
        if (r25 != null) goto L108;
    L111:
        boolean r33 = true;
    L112:
        if (r33 == true) goto L118;
        PolarisFileWrapper r34 = new PolarisFileWrapper(r25);
        if (r34.exists() == false) goto L118;
        if (r34.length() <= 0) goto L118;
        r32.put("sid_file_path", r25);
        goto L118
    L108:
        if (r25.length() == 0) goto L111;
        r33 = false;
    L118:
        r32.put("sid_level", 2);
        if ((DoraPreWakeUpTask.d & 3) == 0) goto L121;
        int r35 = 1;
    L122:
        r32.put("sid_bargin_status", r35);
        float r36 = a.g().takeVolLevel() / 16.0f;
        if (r36 >= 0.0f) goto L125;
        r36 = 1.0f;
    L125:
        r32.put("sid_volume", Float.valueOf(r36));
        String r37 = DoraPreWakeUpTask.Companion.k();
        String r38 = new JSONObject(r37).toString();     // Catch: Exception -> L128
    L129:
        Intrinsics.checkNotNull(r38);
        JSONObject r40 = new JSONObject();
        IDoraService r41 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r41 == null) goto L134;
        SessionService r42 = r41.d();
        if (r42 == null) goto L134;
        String r43 = r42.g("dora_full_duplex");
    L135:
        r40.put("app_key", r43);
        int r44 = DoraPreWakeUpTask.d;
        r40.put("business_type", DoraPreWakeUpTask.Companion.g());
        r40.put("token", r37);
        r40.put("token_type", 1);
        r40.put("header", r38);
        r40.put("url", "https://audio.doubao.com/internal");
        final JSONObject r45 = new JSONObject();
        if (r13 == null) goto L138;
        String r46 = r13.sn;
    L139:
        if (r46 != null) goto L141;
        r46 = r115;
    L141:
        r45.put("sn", r46);
        com.larus.platform.service.o r47 = com.larus.platform.service.o.a;
        r45.put("did", r47.getDeviceId());
        r45.put("uid", r47.getUserID());
        r45.put("app_status", AppHost.a.a().isAppBackground() ? 1 : 0);
        if (r13 == null) goto L147;
        String r48 = r13.modelVersion;
        if (r48 == null) goto L147;
        String r50 = r48;
    L148:
        r45.put("engine_version", r50);
        r45.put("model_info", r32);
        r45.put("server_param", r40);
        r45.put("dump_dir", r12);
        SAMICore.RegisterSpeechWakeupParamRequestCallback(new k(r45));
        return Unit.INSTANCE;
    L147:
        r50 = r115;
        goto L148
    L138:
        r46 = null;
    L134:
        r43 = r115;
    L128:
        r38 = r37;
        goto L129
    L121:
        r35 = 0;
    L101:
        r31 = false;
        goto L102
    L91:
        if (r26.t() != true) goto L93;
        r27 = true;
        goto L94
    L80:
        if (r24.exists() == false) goto L82;
        r24.delete();     // Catch: Exception -> L84
    L82:
        r24.createNewFile();     // Catch: Exception -> L84
        FilesKt.writeBytes(r24, r112);     // Catch: Exception -> L84
        r25 = r24.getAbsolutePath();     // Catch: Exception -> L84
    L71:
        r22 = "unknown";
        goto L72
    L61:
        r113 = false;
    L86:
        r115 = "";
    L48:
        r17 = "";
        goto L49
    L43:
        r15 = "";
        goto L44
    L40:
        r14 = "";
    L36:
        r11 = "";
        goto L37
    L26:
        if (r6.length() == 0) goto L29;
        r8 = false;
    L150:
        d.b("DoraPreWakeUpTask", "updateWakeupHandler failed wakeupPath:" + r4 + ", sidPath:" + r6);
        return Unit.INSTANCE;
    L18:
        if (r4.length() == 0) goto L21;
        r7 = false;
        goto L23
    L15:
        r6 = null;
        goto L16
    L11:
        r4 = null;
    L153:
        return Unit.INSTANCE;
    L155:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
