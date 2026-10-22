package com.larus.dora.impl.core;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import pk4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraCoreTracker$reportConnect$1", f = "DoraCoreTracker.kt", i = {1, 2}, l = {156, 165, 170, 175}, m = "invokeSuspend", n = {"adapter", "adapter"}, s = {"L$0", "L$0"})
final class DoraCoreTracker$reportConnect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $connectDuration;
    final /* synthetic */ boolean $isConnected;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public DoraCoreTracker$reportConnect$1(boolean r1, long r2, Continuation<? super DoraCoreTracker$reportConnect$1> r4) {
        this.$isConnected = r1;
        this.$connectDuration = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraCoreTracker$reportConnect$1(this.$isConnected, this.$connectDuration, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = false;
        String r8 = "none";
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        int r4 = this.I$0;
        String r5 = (String) this.L$2;
        Pair[] r6 = (Pair[]) this.L$1;
        Pair[] r7 = (Pair[]) this.L$0;
        ResultKt.throwOnFailure(r16);
        String r9 = r5;
        Object r10 = r16;
    L45:
        String r11 = (String) r10;
        Pair[] r12 = r6;
        Pair[] r14 = r7;
        int r13 = r4;
        Pair[] r15 = r14;
    L47:
        r12[r13] = TuplesKt.to(r9, r11);
        final Map r17 = MapsKt.mutableMapOf(r15);
        DoraDevice r18 = ak4.a.d().a.A;
        if (r18 != null) goto L50;
    L59:
        if (r18 != null) goto L61;
    L80:
        DoraBuryPointManager r20 = DoraBuryPointManager.a;
        final boolean r21 = this.$isConnected;
        r20.getClass();
        Intrinsics.checkNotNullParameter("dora_initiate_proprietary_protocol", "event");
        Intrinsics.checkNotNullParameter(r17, "params");
        g49.d.d(DoraBuryPointManager.b, "reportConnectEventToDouBao dora_initiate_proprietary_protocol, " + r17 + ", " + r21);
        DoraBuryPointManager.e.post(new h(r21, r17));
        return Unit.INSTANCE;
    L61:
        if (o59.a.n(Boxing.boxInt(r18.type)) == false) goto L80;
        String r22 = r18.getSerialNumber();
        if (r22 != null) goto L65;
        r22 = "none";
    L65:
        r17.put("dora_g_series_no", r22);
        String r23 = r18.softVersion;
        if (r23 == null) goto L69;
        r8 = r23;
    L69:
        r17.put("dora_g_FW_version", r8);
        if (DoraAdapterExtKt.p(kj4.a.g()) == false) goto L72;
        String r24 = "on";
    L73:
        r17.put("dora_g_wakeup_settings", r24);
        kj4.a.g().d.getClass();
        Long r25 = 1L;
        if (i.a.a.a.getLong("tag_speak_then_take_photo", r25.longValue()) != 1) goto L76;
        r3 = true;
    L76:
        if (r3 == false) goto L78;
        String r26 = "smart_capture";
    L79:
        r17.put("dora_g_normal_mode_settings", r26);
        goto L80
    L78:
        r26 = "intent_capture";
        goto L79
    L72:
        r24 = "off";
        goto L73
    L50:
        if (ProductNameType.DORA_E.deviceType != r18.type) goto L59;
        String r27 = r18.sn;
        if (r27 != null) goto L54;
        r27 = "none";
    L54:
        r17.put("dora_e_series_no", r27);
        String r28 = r18.softVersion;
        if (r28 == null) goto L58;
        r8 = r28;
    L58:
        r17.put("dora_e_FW_version", r8);
        goto L80
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        int r30 = this.I$0;
        String r31 = (String) this.L$3;
        Pair[] r32 = (Pair[]) this.L$2;
        Pair[] r33 = (Pair[]) this.L$1;
        kj4.a r110 = (kj4.a) this.L$0;
        ResultKt.throwOnFailure(r16);
        kj4.a r111 = r110;
        Pair[] r112 = r33;
        r12 = r32;
        int r34 = r30;
        Object r35 = r16;
    L37:
        String r36 = (String) r35;
        Pair[] r113 = r112;
        String r114 = r31;
        Pair[] r37 = r12;
        r12 = r113;
    L39:
        r37[r34] = TuplesKt.to(r114, r36);
        r13 = 6;
        r9 = "dora_continuous_photo_settings";
        if (this.$isConnected == false) goto L46;
        z r38 = z.a;
        Intrinsics.checkNotNull(r111);
        Function1 r115 = new y();
        this.L$0 = r12;
        this.L$1 = r12;
        this.L$2 = "dora_continuous_photo_settings";
        this.L$3 = null;
        this.I$0 = 6;
        this.label = 4;
        r10 = z.a(r38, r111, "burstTakeImageEnable", r115, this);
        if (r10 != r1) goto L44;
        return r1;
    L44:
        r6 = r12;
        r7 = r6;
        r4 = 6;
        goto L45
    L46:
        r11 = "none";
        r15 = r12;
        goto L47
    L12:
        int r40 = this.I$0;
        String r41 = (String) this.L$3;
        r12 = (Pair[]) this.L$2;
        Pair[] r116 = (Pair[]) this.L$1;
        kj4.a r117 = (kj4.a) this.L$0;
        ResultKt.throwOnFailure(r16);
        r111 = r117;
        Pair[] r118 = r116;
        String r119 = r41;
        int r42 = r40;
        Object r43 = r16;
    L29:
        String r44 = (String) r43;
        String r120 = r119;
        Pair[] r121 = r12;
        r12 = r118;
        String r122 = r120;
    L31:
        r121[r42] = TuplesKt.to(r122, r44);
        r34 = 5;
        r114 = "dora_photo_settings";
        if (this.$isConnected == false) goto L38;
        z r45 = z.a;
        Intrinsics.checkNotNull(r111);
        Function1 r123 = new x();
        this.L$0 = r111;
        this.L$1 = r12;
        this.L$2 = r12;
        this.L$3 = "dora_photo_settings";
        this.I$0 = 5;
        this.label = 3;
        r35 = z.a(r45, r111, "takeImageEnable", r123, this);
        if (r35 != r1) goto L36;
        return r1;
    L36:
        r31 = "dora_photo_settings";
        r112 = r12;
        goto L37
    L38:
        r36 = "none";
        r37 = r12;
        goto L39
    L13:
        ResultKt.throwOnFailure(r16);
    L19:
        kj4.a r124 = kj4.a.g();
        r12 = new Pair[7];
        r12[0] = TuplesKt.to("external_device_type", "earphone");
        r12[1] = TuplesKt.to("external_device_name", "dora");
        if (this.$isConnected == false) goto L22;
        String r46 = FlowDoraConnectReason.SUCCESS;
    L23:
        r12[2] = TuplesKt.to("connection_status", r46);
        r12[3] = TuplesKt.to("connection_time", Boxing.boxLong(this.$connectDuration));
        r119 = "dora_wear_detection_settiings";
        if (this.$isConnected == false) goto L30;
        z r47 = z.a;
        Intrinsics.checkNotNull(r124);
        Function1 r125 = new w();
        this.L$0 = r124;
        this.L$1 = r12;
        this.L$2 = r12;
        this.L$3 = "dora_wear_detection_settiings";
        this.I$0 = 4;
        this.label = 2;
        r43 = z.a(r47, r124, "wearSensor", r125, this);
        if (r43 != r1) goto L28;
        return r1;
    L28:
        r111 = r124;
        r42 = 4;
        r118 = r12;
        goto L29
    L30:
        r44 = "none";
        r111 = r124;
        r42 = 4;
        r122 = "dora_wear_detection_settiings";
        r121 = r12;
        goto L31
    L22:
        r46 = "failure";
        goto L23
    L14:
        ResultKt.throwOnFailure(r16);
        if (this.$isConnected == false) goto L19;
        this.label = 1;
        if (DelayKt.delay(500, this) != r1) goto L19;
        return r1;
    }
}
