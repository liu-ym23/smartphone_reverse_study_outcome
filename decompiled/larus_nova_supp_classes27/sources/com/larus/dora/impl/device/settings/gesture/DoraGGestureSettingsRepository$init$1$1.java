package com.larus.dora.impl.device.settings.gesture;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.impl.DoraBuryPointManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.DoraGGestureSettingsRepository$init$1$1", f = "DoraGGestureSettingsRepository.kt", i = {}, l = {115, 117}, m = "invokeSuspend", n = {}, s = {})
final class DoraGGestureSettingsRepository$init$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public DoraGGestureSettingsRepository$init$1$1(Continuation<? super DoraGGestureSettingsRepository$init$1$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraGGestureSettingsRepository$init$1$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L16:
        DoraGGestureSettingsRepository r15 = DoraGGestureSettingsRepository.a;
        Object r16 = null;
        BuildersKt.launch$default((CoroutineScope) DoraGGestureSettingsRepository.k.getValue(), null, null, new DoraGGestureSettingsRepository$updateGestureSettingsInfo$1(null), 3, null);
        DoraBuryPointManager r2 = DoraBuryPointManager.a;
        List<DoraGGestureSettings> r3 = DoraGGestureSettingsRepository.c;
        List<DoraGGestureSettings> r4 = DoraGGestureSettingsRepository.d;
        List<DoraGGestureSettings> r5 = DoraGGestureSettingsRepository.e;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "leftSideList");
        Intrinsics.checkNotNullParameter(r4, "rightSideList");
        Intrinsics.checkNotNullParameter(r5, "leftButtonList");
        List<DoraGGestureSettings> r6 = r5;
        Iterator<T> r7 = r6.iterator();
    L18:
        if (r7.hasNext() == false) goto L27;
        Object r8 = r7.next();
        DoraGGestureSettings r11 = (DoraGGestureSettings) r8;
        if (r11.b == 4) goto L22;
    L24:
        boolean r12 = false;
    L25:
        if (r12 == false) goto L18;
    L28:
        DoraGGestureSettings r9 = (DoraGGestureSettings) r8;
        Iterator<T> r10 = r6.iterator();
    L30:
        if (r10.hasNext() == false) goto L39;
        Object r13 = r10.next();
        DoraGGestureSettings r17 = (DoraGGestureSettings) r13;
        if (r17.b == 4) goto L34;
    L36:
        boolean r18 = false;
    L37:
        if (r18 == false) goto L30;
        r16 = r13;
        goto L39
    L34:
        if (r17.c != 2) goto L36;
        r18 = true;
    L39:
        DoraGGestureSettings r110 = (DoraGGestureSettings) r16;
        Pair[] r20 = new Pair[15];
        String r21 = "none";
        if (r9 == null) goto L42;
        String r22 = DoraBuryPointManager.o(r9.d);
    L43:
        r20[0] = TuplesKt.to("left_button_long_press", r22);
        r20[1] = TuplesKt.to("left_button_single_click", "take_photo");
        if (r110 == null) goto L46;
        String r111 = DoraBuryPointManager.o(r110.d);
    L47:
        r20[2] = TuplesKt.to("left_button_double_click", r111);
        if (CollectionsKt.getOrNull(r4, 0) == null) goto L50;
        String r112 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r4, 0)).d);
    L51:
        r20[3] = TuplesKt.to("right_quick_control_single_click", r112);
        if (CollectionsKt.getOrNull(r4, 1) == null) goto L54;
        String r113 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r4, 1)).d);
    L55:
        r20[4] = TuplesKt.to("right_quick_control_double_click", r113);
        if (CollectionsKt.getOrNull(r4, 2) == null) goto L58;
        String r114 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r4, 2)).d);
    L59:
        r20[5] = TuplesKt.to("right_quick_control_tripple_click", r114);
        if (CollectionsKt.getOrNull(r4, 3) == null) goto L62;
        String r115 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r4, 3)).d);
    L63:
        r20[6] = TuplesKt.to("right_quick_control_swipe", r115);
        if (CollectionsKt.getOrNull(r4, 4) == null) goto L66;
        String r116 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r4, 4)).d);
    L67:
        r20[7] = TuplesKt.to("right_call_double_click", r116);
        if (CollectionsKt.getOrNull(r4, 5) == null) goto L70;
        String r117 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r4, 5)).d);
    L71:
        r20[8] = TuplesKt.to("right_doubao_long_press", r117);
        if (CollectionsKt.getOrNull(r3, 0) == null) goto L74;
        String r118 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r3, 0)).d);
    L75:
        r20[9] = TuplesKt.to("left_quick_control_single_click", r118);
        if (CollectionsKt.getOrNull(r3, 1) == null) goto L78;
        String r119 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r3, 1)).d);
    L79:
        r20[10] = TuplesKt.to("left_quick_control_double_click", r119);
        if (CollectionsKt.getOrNull(r3, 2) == null) goto L82;
        String r120 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r3, 2)).d);
    L83:
        r20[11] = TuplesKt.to("left_quick_control_tripple_click", r120);
        if (CollectionsKt.getOrNull(r3, 3) == null) goto L86;
        String r121 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r3, 3)).d);
    L87:
        r20[12] = TuplesKt.to("left_quick_control_swipe", r121);
        if (CollectionsKt.getOrNull(r3, 4) == null) goto L90;
        String r122 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r3, 4)).d);
    L91:
        r20[13] = TuplesKt.to("left_call_double_click", r122);
        if (CollectionsKt.getOrNull(r3, 5) == null) goto L94;
        r21 = DoraBuryPointManager.o(((DoraGGestureSettings) ListProtector.get(r3, 5)).d);
    L94:
        r20[14] = TuplesKt.to("left_doubao_long_press", r21);
        r2.L("dora_g_gesture_settings", MapsKt.toMap(MapsKt.mutableMapOf(r20)));
        return Unit.INSTANCE;
    L90:
        r122 = "none";
        goto L91
    L86:
        r121 = "none";
        goto L87
    L82:
        r120 = "none";
        goto L83
    L78:
        r119 = "none";
        goto L79
    L74:
        r118 = "none";
        goto L75
    L70:
        r117 = "none";
        goto L71
    L66:
        r116 = "none";
        goto L67
    L62:
        r115 = "none";
        goto L63
    L58:
        r114 = "none";
        goto L59
    L54:
        r113 = "none";
        goto L55
    L50:
        r112 = "none";
        goto L51
    L46:
        r111 = "none";
        goto L47
    L42:
        r22 = "none";
        goto L43
    L22:
        if (r11.c != 6) goto L24;
        r12 = true;
        goto L25
    L27:
        r8 = null;
        goto L28
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L13:
        g49.d.d("DoraGGestureSettingsRepository", "init, start reporting gesture settings");
        DoraGGestureSettingsRepository r123 = DoraGGestureSettingsRepository.a;
        this.label = 2;
        if (DoraGGestureSettingsRepository.a(r123, this) != r0) goto L16;
        return r0;
    L10:
        ResultKt.throwOnFailure(r14);
        this.label = 1;
        if (DelayKt.delay(5000, this) != r0) goto L13;
        return r0;
    }
}
