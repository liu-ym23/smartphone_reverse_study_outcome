package com.larus.asr.view;

import android.view.View;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.asr.api.databinding.LarusWidgetSpeakerBinding;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.asr.view.ContinuousSpeechManager$tryHandleOnActionUp$1", f = "ContinuousSpeechManager.kt", i = {}, l = {336, 337}, m = "invokeSuspend", n = {}, s = {})
final class ContinuousSpeechManager$tryHandleOnActionUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LarusWidgetSpeakerBinding $binding;
    final /* synthetic */ float $x;
    final /* synthetic */ float $y;
    int label;
    final /* synthetic */ v0 this$0;

    /* JADX INFO: renamed from: com.larus.asr.view.ContinuousSpeechManager$tryHandleOnActionUp$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larus.asr.view.ContinuousSpeechManager$tryHandleOnActionUp$1$1", f = "ContinuousSpeechManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ LarusWidgetSpeakerBinding $binding;
        final /* synthetic */ float $x;
        final /* synthetic */ float $y;
        int label;
        final /* synthetic */ v0 this$0;

        public AnonymousClass1(v0 r1, LarusWidgetSpeakerBinding r2, float r3, float r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$binding = r2;
            this.$x = r3;
            this.$y = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$binding, this.$x, this.$y, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r3);
            v0 r4 = this.this$0;
            View r0 = this.$binding.a;
            int r1 = v0.r;
            r4.getClass();
            v0.b(r0, false);
            this.this$0.i.invoke(TuplesKt.to(Boxing.boxFloat(this.$x), Boxing.boxFloat(this.$y)));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ContinuousSpeechManager$tryHandleOnActionUp$1(v0 r1, LarusWidgetSpeakerBinding r2, float r3, float r4, Continuation<? super ContinuousSpeechManager$tryHandleOnActionUp$1> r5) {
        this.this$0 = r1;
        this.$binding = r2;
        this.$x = r3;
        this.$y = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ContinuousSpeechManager$tryHandleOnActionUp$1(this.this$0, this.$binding, this.$x, this.$y, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r10);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L13:
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$binding, this.$x, this.$y, null);
        this.label = 2;
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r10);
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L13;
        return r0;
    }
}
