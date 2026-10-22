package com.larus.common_ui.floatwindow.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.facebook.imagepipeline.postprocessors.BlurPostProcessor;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common_ui.floatwindow.view.SingleFloatBall$autoUpdateBlurMask$2", f = "SingleFloatBall.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SingleFloatBall$autoUpdateBlurMask$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    int label;
    final /* synthetic */ SingleFloatBall this$0;

    /* JADX INFO: renamed from: com.larus.common_ui.floatwindow.view.SingleFloatBall$autoUpdateBlurMask$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common_ui.floatwindow.view.SingleFloatBall$autoUpdateBlurMask$2$2", f = "SingleFloatBall.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BitmapDrawable $drawable;
        int label;
        final /* synthetic */ SingleFloatBall this$0;

        public AnonymousClass2(SingleFloatBall r1, BitmapDrawable r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$drawable = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$drawable, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.this$0.g.setBackground(this.$drawable);
            this.this$0.h.setBackground(this.$drawable);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r3, Throwable r4) {
            FLogger.a.e("SingleFloatBall", "autoUpdateBlurMask MainScope fail: " + r4);
        }
    }

    public SingleFloatBall$autoUpdateBlurMask$2(SingleFloatBall r1, Bitmap r2, Continuation<? super SingleFloatBall$autoUpdateBlurMask$2> r3) {
        this.this$0 = r1;
        this.$bitmap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SingleFloatBall$autoUpdateBlurMask$2(this.this$0, this.$bitmap, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r9);
        new BlurPostProcessor(20, this.this$0.getContext()).process(this.$bitmap);
        BitmapDrawable r10 = new BitmapDrawable(this.this$0.getResources(), this.$bitmap);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), new a(CoroutineExceptionHandler.Key), null, new AnonymousClass2(this.this$0, r10, null), 2, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
