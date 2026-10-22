package com.larus.asr.view;

import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.api.databinding.LarusWidgetSpeakerBinding;
import com.larus.asr.config.ChatSpeakerStatus;
import com.larus.common_ui.blur.BlurCircleWithAmplitude;
import com.larus.common_ui.widget.input.AudioVisualizerOpt;
import com.larus.platform.model.SpeakStyleConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.asr.view.ContinuousSpeechManager$tryHandleOnActionMove$2", f = "ContinuousSpeechManager.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
final class ContinuousSpeechManager$tryHandleOnActionMove$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusWidgetSpeakerBinding $binding;
    int label;
    final /* synthetic */ v0 this$0;

    public ContinuousSpeechManager$tryHandleOnActionMove$2(v0 r1, LarusWidgetSpeakerBinding r2, Continuation<? super ContinuousSpeechManager$tryHandleOnActionMove$2> r3) {
        this.this$0 = r1;
        this.$binding = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ContinuousSpeechManager$tryHandleOnActionMove$2(this.this$0, this.$binding, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        v0.c r10 = this.this$0.d;
        if (r10.c == 2) goto L15;
        r10.c = 2;
        r10.b.invoke();
    L15:
        v0 r11 = this.this$0;
        ChatSpeakerStatus r3 = r11.g;
        ChatSpeakerStatus r4 = ChatSpeakerStatus.Cancel;
        r11.j(r4);
        this.this$0.n.invoke(r4);
        if (r3 == r4) goto L92;
        this.this$0.g(this.$binding);
        v0 r12 = this.this$0;
        LarusWidgetSpeakerBinding r5 = this.$binding;
        if (((SpeakStyleConfig) r12.f.getValue()).getEnableNewStyle() == false) goto L20;
        BlurCircleWithAmplitude r13 = r5.f;
        r13.setCircleColor(new int[]{ColorProtector.parseColor("#26FF3B30")});
        r13.a();
        Intrinsics.checkNotNull(r13);
    L21:
        v0 r14 = this.this$0;
        LarusWidgetSpeakerBinding r6 = this.$binding;
        if (((SpeakStyleConfig) r14.f.getValue()).getEnableNewStyle() == false) goto L24;
        int r7 = 2131102650;
    L25:
        AudioVisualizerOpt r8 = r6.b.getChildAt(0);
        Integer r15 = null;
        if ((r8 instanceof AudioVisualizerOpt) == false) goto L28;
        AudioVisualizerOpt r16 = r8;
    L29:
        if (r16 == null) goto L31;
        r16.setPaintColor(ContextCompat.getColor(r14.a, r7));
    L31:
        v0 r17 = this.this$0;
        LarusWidgetSpeakerBinding r19 = this.$binding;
        if (((Boolean) r17.b.invoke()).booleanValue() == false) goto L34;
    L37:
        boolean r20 = true;
    L38:
        ChatSpeakerStatus r21 = r17.g;
        if (r21 == null) goto L41;
        ChatSpeakerStatus r22 = r21.toLegacyStatus();
    L42:
        z48.b r23 = new z48.b(r20, r22);
        z48.a r24 = r17.q;
        if (r24 == null) goto L52;
        a58.a r25 = r24.a;
        if (r25 == null) goto L49;
        Function1<z48.b, Integer> r26 = r25.b;
        if (r26 == null) goto L49;
        Integer r27 = (Integer) r26.invoke(r23);
    L50:
        if (r27 == null) goto L52;
        int r29 = r27.intValue();
    L53:
        z48.a r30 = r17.q;
        if (r30 == null) goto L62;
        a58.a r31 = r30.a;
        if (r31 == null) goto L60;
        Function1<z48.b, String> r32 = r31.a;
        if (r32 == null) goto L60;
        String r33 = (String) r32.invoke(r23);
    L61:
        if (r33 == null) goto L62;
    L63:
        r19.p.setTextColor(r29);
        r19.p.setText(r33);
        v0 r34 = this.this$0;
        LarusWidgetSpeakerBinding r35 = this.$binding;
        if (r35 != null) goto L67;
        r34.getClass();
        goto L92
    L67:
        if (r34.m == false) goto L69;
        v0.a r36 = v0.a.f;
    L70:
        v0.a.b r37 = r36.a(r35);
        if (((Boolean) r34.b.invoke()).booleanValue() == false) goto L73;
    L76:
        ChatSpeakerStatus r38 = r34.g;
        if (r38 == null) goto L79;
        ChatSpeakerStatus r39 = r38.toLegacyStatus();
    L80:
        z48.b r40 = new z48.b(r2, r39);
        z48.a r41 = r34.q;
        if (r41 == null) goto L89;
        b58.a r42 = r41.b;
        if (r42 == null) goto L87;
        Function1<z48.b, Integer> r43 = r42.a;
        if (r43 == null) goto L87;
        r15 = (Integer) r43.invoke(r40);
    L87:
        if (r15 == null) goto L89;
        int r44 = r15.intValue();
    L90:
        r37.b.setImageResource(r44);
        com.larus.utils.e1.x(r37.c);
        v0.a(r37.a);
    L89:
        r44 = 2131242827;
        goto L90
    L79:
        r39 = null;
        goto L80
    L73:
        if (((Boolean) r34.e.getFirst()).booleanValue() == true) goto L76;
        r2 = false;
        goto L76
    L69:
        r36 = v0.a.e;
    L60:
        r33 = null;
    L62:
        r33 = r17.a.getString(2131908758);
    L49:
        r27 = null;
    L52:
        r29 = ContextCompat.getColor(r17.a, 2131102650);
        goto L53
    L41:
        r22 = null;
        goto L42
    L34:
        if (((Boolean) r17.e.getFirst()).booleanValue() == true) goto L37;
        r20 = false;
        goto L38
    L28:
        r16 = null;
        goto L29
    L24:
        r7 = 2131103298;
        goto L25
    L20:
        r5.b.setBackgroundResource(2131238623);
    L92:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        long r45 = this.this$0.l;
        this.label = 1;
        if (DelayKt.delay(r45, this) != r0) goto L11;
        return r0;
    }
}
