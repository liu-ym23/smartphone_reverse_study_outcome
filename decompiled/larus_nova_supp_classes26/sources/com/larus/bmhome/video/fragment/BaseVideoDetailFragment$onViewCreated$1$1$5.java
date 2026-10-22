package com.larus.bmhome.video.fragment;

import androidx.lifecycle.PausingDispatcherKt;
import com.larus.common_ui.video.VideoPlayView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.fragment.BaseVideoDetailFragment$onViewCreated$1$1$5", f = "BaseVideoDetailFragment.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
public final class BaseVideoDetailFragment$onViewCreated$1$1$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VideoPlayView $this_apply;
    int label;
    final /* synthetic */ BaseVideoDetailFragment<T> this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.video.fragment.BaseVideoDetailFragment$onViewCreated$1$1$5$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.video.fragment.BaseVideoDetailFragment$onViewCreated$1$1$5$1", f = "BaseVideoDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ VideoPlayView $this_apply;
        int label;
        final /* synthetic */ BaseVideoDetailFragment<T> this$0;

        public AnonymousClass1(BaseVideoDetailFragment<T> r1, VideoPlayView r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$this_apply = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$this_apply, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            BaseVideoDetailFragment<T> r3 = this.this$0;
            if (r3.p == 0) goto L7;
            r3.ca0(true);
            boolean r4 = x19.a.a;
            x19.a.a = true;
            this.$this_apply.M();
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BaseVideoDetailFragment$onViewCreated$1$1$5(BaseVideoDetailFragment<T> r1, VideoPlayView r2, Continuation<? super BaseVideoDetailFragment$onViewCreated$1$1$5> r3) {
        this.this$0 = r1;
        this.$this_apply = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BaseVideoDetailFragment$onViewCreated$1$1$5(this.this$0, this.$this_apply, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        BaseVideoDetailFragment<T> r7 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(r7, this.$this_apply, null);
        this.label = 1;
        if (PausingDispatcherKt.whenResumed(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
