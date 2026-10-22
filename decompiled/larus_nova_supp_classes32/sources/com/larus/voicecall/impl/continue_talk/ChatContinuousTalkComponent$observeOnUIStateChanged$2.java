package com.larus.voicecall.impl.continue_talk;

import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.audio.call.InstanceCallState;
import com.larus.common_ui.view.ChatContinuousAudioVisualizerOpt;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.databinding.LarusLayoutContinousBottomControllerBinding;
import com.larus.voicecall.impl.databinding.LarusLayoutContinuousBottomContainerBinding;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "talkState", NameKeys.UnloadStrategy_No_Strategy}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.continue_talk.ChatContinuousTalkComponent$observeOnUIStateChanged$2", f = "ChatContinuousTalkComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatContinuousTalkComponent$observeOnUIStateChanged$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ ChatContinuousTalkComponent this$0;

    public ChatContinuousTalkComponent$observeOnUIStateChanged$2(ChatContinuousTalkComponent r1, Continuation<? super ChatContinuousTalkComponent$observeOnUIStateChanged$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatContinuousTalkComponent$observeOnUIStateChanged$2 r0 = new ChatContinuousTalkComponent$observeOnUIStateChanged$2(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L89;
        ResultKt.throwOnFailure(r12);
        int r13 = this.I$0;
        InstanceCallState.Companion.getClass();
        FLogger.a.i("ChatContinuousComponent", "new state: ".concat(InstanceCallState.a.a(r13)));
        LarusLayoutContinuousBottomContainerBinding r0 = this.this$0.n;
        if (r0 == null) goto L11;
        FrameLayout r1 = r0.c;
        if (r1 == null) goto L11;
        if (r1.getVisibility() != 8) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L16;
        return Unit.INSTANCE;
    L16:
        if (r13 != 14) goto L18;
        LarusLayoutContinuousBottomContainerBinding r14 = this.this$0.n;
        if (r14 == null) goto L87;
        ChatContinuousTalkLayout r15 = r14.d;
        if (r15 == null) goto L87;
        r15.b(true);
        Job r7 = null;
        if (ArraysKt.contains(new Integer[]{6, 7}, null) == true) goto L87;
        LarusLayoutContinousBottomControllerBinding r3 = r15.b;
        TextView r8 = r3.i;
        r8.setTextColor(ContextCompat.getColor(r8.getContext(), c.b(2130972079, r8.getContext(), 2131103136)));
        r8.setAlpha(1.0f);
        r8.setText(r8.getContext().getString(2131908047));
        r8.setVisibility(0);
        ChatContinuousAudioVisualizerOpt r4 = r3.e;
        if (r4.n <= 0) goto L77;
        r4.k.clear();
        r4.f(r4.n, true);
        r4.l = 0;
    L77:
        r3.f.setVisibility(8);
        r3.e.setVisibility(0);
        r3.c.setVisibility(8);
        r3.g.setVisibility(8);
        Job r5 = r15.c;
        if (r5 == null) goto L80;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L80:
        LifecycleOwner r6 = ViewTreeLifecycleOwner.get(r15);
        if (r6 == null) goto L85;
        LifecycleCoroutineScope r9 = LifecycleOwnerKt.getLifecycleScope(r6);
        if (r9 == null) goto L85;
        r7 = BuildersKt.launch$default(r9, null, null, new ChatContinuousTalkLayout$delayShowInterrupt$1(r15, null), 3, null);
    L85:
        r15.c = r7;
    L87:
        return Unit.INSTANCE;
    L18:
        if (r13 == 15) goto L62;
        switch(r13) {
            case 1: goto L57;
            case 2: goto L52;
            case 3: goto L47;
            case 4: goto L42;
            case 5: goto L37;
            case 6: goto L32;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L42;
            default: goto L87;
        };
    L21:
        LarusLayoutContinuousBottomContainerBinding r16 = this.this$0.n;
        goto L87
    L22:
        LarusLayoutContinuousBottomContainerBinding r17 = this.this$0.n;
        if (r17 == null) goto L27;
        ChatContinuousTalkLayout r18 = r17.d;
        if (r18 == null) goto L27;
        LarusLayoutContinousBottomControllerBinding r19 = r18.b;
        TextView r10 = r19.i;
        r10.setTextColor(ContextCompat.getColor(r10.getContext(), c.b(2130972079, r10.getContext(), 2131103136)));
        r10.setText(r10.getContext().getString(2131898477));
        r10.setVisibility(0);
        r19.f.setVisibility(8);
        r19.e.setVisibility(8);
        r19.c.setVisibility(8);
        r19.g.setVisibility(0);
    L27:
        LarusLayoutContinuousBottomContainerBinding r110 = this.this$0.n;
        if (r110 == null) goto L87;
        if (r110.b == null) goto L87;
        ColorProtector.parseColor("#80FFFFFF");
        goto L87
    L32:
        LarusLayoutContinuousBottomContainerBinding r111 = this.this$0.n;
        if (r111 == null) goto L87;
        ChatContinuousTalkLayout r112 = r111.d;
        if (r112 == null) goto L87;
        LarusLayoutContinousBottomControllerBinding r113 = r112.b;
        TextView r11 = r113.i;
        r11.setTextColor(ContextCompat.getColor(r11.getContext(), c.b(2130972079, r11.getContext(), 2131103136)));
        r11.setAlpha(1.0f);
        r11.setText(r11.getContext().getString(2131908699));
        r11.setVisibility(0);
        r113.f.setVisibility(8);
        r113.e.setVisibility(8);
        r113.c.setVisibility(8);
        r113.g.setVisibility(0);
        goto L87
    L37:
        LarusLayoutContinuousBottomContainerBinding r114 = this.this$0.n;
        if (r114 == null) goto L87;
        ChatContinuousTalkLayout r115 = r114.d;
        if (r115 == null) goto L87;
        r115.a(false);
        goto L87
    L42:
        LarusLayoutContinuousBottomContainerBinding r116 = this.this$0.n;
        if (r116 == null) goto L87;
        ChatContinuousTalkLayout r117 = r116.d;
        if (r117 == null) goto L87;
        r117.a(false);
        goto L87
    L47:
        LarusLayoutContinuousBottomContainerBinding r118 = this.this$0.n;
        if (r118 == null) goto L87;
        ChatContinuousTalkLayout r119 = r118.d;
        if (r119 == null) goto L87;
        LarusLayoutContinousBottomControllerBinding r20 = r119.b;
        TextView r21 = r20.i;
        r21.setTextColor(ContextCompat.getColor(r21.getContext(), c.b(2130972079, r21.getContext(), 2131103136)));
        r21.setAlpha(1.0f);
        r21.setText(r21.getContext().getString(2131898446));
        r21.setVisibility(0);
        r20.f.setVisibility(8);
        r20.c.setVisibility(8);
        r20.g.setVisibility(8);
        r20.e.setVisibility(0);
        r119.b(false);
        goto L87
    L52:
        LarusLayoutContinuousBottomContainerBinding r120 = this.this$0.n;
        if (r120 == null) goto L87;
        ChatContinuousTalkLayout r121 = r120.d;
        if (r121 == null) goto L87;
        LarusLayoutContinousBottomControllerBinding r122 = r121.b;
        TextView r22 = r122.i;
        r22.setTextColor(ContextCompat.getColor(r22.getContext(), c.b(2130972079, r22.getContext(), 2131103136)));
        r22.setAlpha(1.0f);
        r22.setText(r22.getContext().getString(2131898476));
        r22.setVisibility(0);
        r122.f.setVisibility(8);
        r122.e.setVisibility(0);
        r122.c.setVisibility(8);
        r122.g.setVisibility(8);
        goto L87
    L57:
        LarusLayoutContinuousBottomContainerBinding r123 = this.this$0.n;
        if (r123 == null) goto L87;
        ChatContinuousTalkLayout r124 = r123.d;
        if (r124 == null) goto L87;
        LarusLayoutContinousBottomControllerBinding r125 = r124.b;
        TextView r23 = r125.i;
        r23.setAlpha(1.0f);
        r23.setText(r23.getContext().getString(2131898459));
        r23.setTextColor(ContextCompat.getColor(r23.getContext(), c.b(2130972079, r23.getContext(), 2131103136)));
        r23.setVisibility(0);
        r125.f.setVisibility(0);
        r125.e.setVisibility(8);
        r125.c.setVisibility(8);
        r125.g.setVisibility(8);
        goto L87
    L62:
        LarusLayoutContinuousBottomContainerBinding r126 = this.this$0.n;
        if (r126 == null) goto L87;
        ChatContinuousTalkLayout r127 = r126.d;
        if (r127 == null) goto L87;
        r127.b(false);
    L11:
        r2 = false;
        goto L12
    L89:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
