package com.bytedance.android.anniex.detect.detection;

import android.graphics.Bitmap;
import com.byted.cast.sink.api.CastInfo;
import com.bytedance.android.anniex.detect.c;
import com.bytedance.android.anniex.detect.f;
import ga.e;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/anniex/detect/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep$execute$duration$1$1", f = "PartialBlankDetectionStep.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
public final class PartialBlankDetectionStep$execute$duration$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super c>, Object> {
    final /* synthetic */ f $context;
    final /* synthetic */ CompletableDeferred<c> $resultDeferred;
    int label;
    final /* synthetic */ PartialBlankDetectionStep this$0;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep$execute$duration$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/anniex/detect/c;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep$execute$duration$1$1$1", f = "PartialBlankDetectionStep.kt", i = {}, l = {44, CastInfo.TYPE_INFO}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super c>, Object> {
        final /* synthetic */ f $context;
        final /* synthetic */ CompletableDeferred<c> $resultDeferred;
        int label;
        final /* synthetic */ PartialBlankDetectionStep this$0;

        /* JADX INFO: renamed from: com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep$execute$duration$1$1$1$a */
        public static final class a implements e {
            public final /* synthetic */ CompletableDeferred<c> a;

            public a(CompletableDeferred r1) {
                this.a = r1;
            }
        }

        public AnonymousClass1(PartialBlankDetectionStep r1, f r10, CompletableDeferred<c> r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r1;
            this.$context = r10;
            this.$resultDeferred = r11;
            super(2, r12);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$context, this.$resultDeferred, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super c> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r10);
        L16:
            return r10;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L13:
            CompletableDeferred<c> r11 = this.$resultDeferred;
            this.label = 2;
            r10 = r11.await(this);
            if (r10 != r0) goto L16;
            return r0;
        L10:
            ResultKt.throwOnFailure(r10);
            System.currentTimeMillis();
            Function3<Bitmap, e, Continuation<? super Unit>, Object> r12 = this.this$0.b;
            Bitmap r13 = this.$context.a;
            a r14 = new a(this.$resultDeferred);
            this.label = 1;
            if (r12.invoke(r13, r14, this) != r0) goto L13;
            return r0;
        }
    }

    public PartialBlankDetectionStep$execute$duration$1$1(PartialBlankDetectionStep r1, f r10, CompletableDeferred<c> r11, Continuation<? super PartialBlankDetectionStep$execute$duration$1$1> r12) {
        this.this$0 = r1;
        this.$context = r10;
        this.$resultDeferred = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PartialBlankDetectionStep$execute$duration$1$1(this.this$0, this.$context, this.$resultDeferred, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super c> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineDispatcher r11 = Dispatchers.getDefault();
        AnonymousClass1 r12 = new AnonymousClass1(this.this$0, this.$context, this.$resultDeferred, null);
        this.label = 1;
        r10 = BuildersKt.withContext(r11, r12, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
