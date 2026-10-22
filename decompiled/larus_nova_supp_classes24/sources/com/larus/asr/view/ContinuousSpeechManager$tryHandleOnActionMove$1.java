package com.larus.asr.view;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.api.databinding.LarusWidgetSpeakerBinding;
import com.larus.asr.config.ChatSpeakerStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.asr.view.ContinuousSpeechManager$tryHandleOnActionMove$1", f = "ContinuousSpeechManager.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
final class ContinuousSpeechManager$tryHandleOnActionMove$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusWidgetSpeakerBinding $binding;
    final /* synthetic */ float $x;
    final /* synthetic */ float $y;
    int label;
    final /* synthetic */ v0 this$0;

    public ContinuousSpeechManager$tryHandleOnActionMove$1(v0 r1, LarusWidgetSpeakerBinding r2, float r3, float r4, Continuation<? super ContinuousSpeechManager$tryHandleOnActionMove$1> r5) {
        this.this$0 = r1;
        this.$binding = r2;
        this.$x = r3;
        this.$y = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ContinuousSpeechManager$tryHandleOnActionMove$1(this.this$0, this.$binding, this.$x, this.$y, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        v0.c r9 = this.this$0.d;
        if (r9.c == 1) goto L15;
        r9.c = 1;
        r9.b.invoke();
    L15:
        v0 r10 = this.this$0;
        ChatSpeakerStatus r3 = r10.g;
        ChatSpeakerStatus r4 = ChatSpeakerStatus.Speech;
        r10.j(r4);
        this.this$0.n.invoke(r4);
        if (r3 == r4) goto L77;
        this.this$0.f(this.$binding);
        v0 r11 = this.this$0;
        LarusWidgetSpeakerBinding r5 = this.$binding;
        if (((Boolean) r11.b.invoke()).booleanValue() == false) goto L20;
    L23:
        boolean r6 = true;
    L24:
        ChatSpeakerStatus r7 = r11.g;
        Integer r12 = null;
        if (r7 == null) goto L27;
        ChatSpeakerStatus r13 = r7.toLegacyStatus();
    L28:
        z48.b r14 = new z48.b(r6, r13);
        z48.a r15 = r11.q;
        if (r15 == null) goto L38;
        a58.a r16 = r15.a;
        if (r16 == null) goto L35;
        Function1<z48.b, Integer> r17 = r16.b;
        if (r17 == null) goto L35;
        Integer r19 = (Integer) r17.invoke(r14);
    L36:
        if (r19 == null) goto L38;
        int r20 = r19.intValue();
    L39:
        z48.a r21 = r11.q;
        if (r21 == null) goto L48;
        a58.a r22 = r21.a;
        if (r22 == null) goto L46;
        Function1<z48.b, String> r23 = r22.a;
        if (r23 == null) goto L46;
        String r24 = (String) r23.invoke(r14);
    L47:
        if (r24 == null) goto L48;
    L49:
        r5.p.setTextColor(r20);
        r5.p.setText(r24);
        this.this$0.h(this.$binding);
        v0 r25 = this.this$0;
        LarusWidgetSpeakerBinding r26 = this.$binding;
        if (r26 != null) goto L53;
        r25.getClass();
        goto L77
    L53:
        if (r25.m == false) goto L55;
        v0.a r27 = v0.a.e;
    L56:
        v0.a.b r29 = r27.a(r26);
        if (((Boolean) r25.b.invoke()).booleanValue() == false) goto L59;
    L62:
        ChatSpeakerStatus r30 = r25.g;
        if (r30 == null) goto L65;
        ChatSpeakerStatus r31 = r30.toLegacyStatus();
    L66:
        z48.b r32 = new z48.b(r2, r31);
        z48.a r33 = r25.q;
        if (r33 == null) goto L75;
        b58.a r34 = r33.c;
        if (r34 == null) goto L73;
        Function1<z48.b, Integer> r35 = r34.a;
        if (r35 == null) goto L73;
        r12 = (Integer) r35.invoke(r32);
    L73:
        if (r12 == null) goto L75;
        int r36 = r12.intValue();
    L76:
        r29.b.setImageResource(r36);
        com.larus.utils.e1.x(r29.c);
        v0.a(r29.a);
    L75:
        r36 = 2131242832;
        goto L76
    L65:
        r31 = null;
        goto L66
    L59:
        if (((Boolean) r25.e.getFirst()).booleanValue() == true) goto L62;
        r2 = false;
        goto L62
    L55:
        r27 = v0.a.f;
    L46:
        r24 = null;
    L48:
        r24 = r11.a.getString(2131899937);
    L35:
        r19 = null;
    L38:
        r20 = r11.e();
        goto L39
    L27:
        r13 = null;
        goto L28
    L20:
        if (((Boolean) r11.e.getFirst()).booleanValue() == true) goto L23;
        r6 = false;
    L77:
        this.this$0.i(this.$binding, this.$x, this.$y);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        long r37 = this.this$0.l;
        this.label = 1;
        if (DelayKt.delay(r37, this) != r0) goto L11;
        return r0;
    }
}
