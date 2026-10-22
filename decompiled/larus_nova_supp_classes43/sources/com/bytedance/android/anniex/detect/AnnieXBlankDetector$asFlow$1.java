package com.bytedance.android.anniex.detect;

import android.graphics.Bitmap;
import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bytedance/android/anniex/detect/g;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetector$asFlow$1", f = "AnnieXBlankDetector.kt", i = {0, 0, 0, 2}, l = {32, 42, 55, 60}, m = "invokeSuspend", n = {"$this$flow", "viewRef", "snapShotContext", "$this$flow"}, s = {"L$0", "L$1", "L$2", "L$0"})
final class AnnieXBlankDetector$asFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super g>, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $detectionStatus;
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ b this$0;

    /* JADX INFO: renamed from: com.bytedance.android.anniex.detect.AnnieXBlankDetector$asFlow$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetector$asFlow$1$3", f = "AnnieXBlankDetector.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ f $context;
        int label;
        final /* synthetic */ b this$0;

        public AnonymousClass3(b r1, f r10, Continuation<? super AnonymousClass3> r11) {
            this.this$0 = r1;
            this.$context = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass3(this.this$0, this.$context, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
            return invoke((CoroutineScope) r1, (Continuation) r10);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
            return create(r1, r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            this.$context.b.a = true;
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            DetectionPipeline r11 = this.this$0.b;
            f r12 = this.$context;
            this.label = 1;
            if (r11.a(r12, this) != r0) goto L11;
            return r0;
        }
    }

    public AnnieXBlankDetector$asFlow$1(View r1, b r10, g r11, Continuation<? super AnnieXBlankDetector$asFlow$1> r12) {
        this.$view = r1;
        this.this$0 = r10;
        this.$detectionStatus = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AnnieXBlankDetector$asFlow$1 r0 = new AnnieXBlankDetector$asFlow$1(this.$view, this.this$0, this.$detectionStatus, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((FlowCollector) r1, (Continuation) r10);
    }

    public final Object invoke(FlowCollector<? super g> r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r13);
    L31:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        FlowCollector r10 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r13);
    L27:
        g r14 = this.$detectionStatus;
        this.L$0 = null;
        this.label = 4;
        if (r10.emit(r14, this) != r0) goto L31;
        return r0;
    L12:
        ResultKt.throwOnFailure(r13);
    L36:
        return Unit.INSTANCE;
    L13:
        j r11 = (j) this.L$2;
        WeakReference r12 = (WeakReference) this.L$1;
        FlowCollector r15 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r13);
    L18:
        k r16 = (k) r13;
        g r17 = this.$detectionStatus;
        r17.a = false;
        l r18 = r11.c;
        r17.d = r18.b;
        r17.c = r18.a;
        if (r16.a == true) goto L21;
    L32:
        StringBuilder r19 = r17.m;
        r19.append("PixelCopy EXCEPTION: " + r16.b);
        r19.append('\n');
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        if (r15.emit(r17, this) != r0) goto L36;
        return r0;
    L21:
        if (r11.b == null) goto L32;
        r12.clear();
        Bitmap r20 = r11.b;
        Intrinsics.checkNotNull(r20);
        f r110 = new f(r20, this.$detectionStatus);
        CoroutineDispatcher r21 = Dispatchers.getIO();
        AnonymousClass3 r22 = new AnonymousClass3(this.this$0, r110, null);
        this.L$0 = r15;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (BuildersKt.withContext(r21, r22, this) != r0) goto L26;
        return r0;
    L26:
        r10 = r15;
        goto L27
    L14:
        ResultKt.throwOnFailure(r13);
        FlowCollector r111 = (FlowCollector) this.L$0;
        WeakReference r23 = new WeakReference(this.$view);
        j r24 = new j(r23);
        SnapshotPipeline r25 = this.this$0.a;
        this.L$0 = r111;
        this.L$1 = r23;
        this.L$2 = r24;
        this.label = 1;
        Object r26 = r25.a(r24, this);
        if (r26 != r0) goto L17;
        return r0;
    L17:
        r15 = r111;
        r13 = r26;
        r12 = r23;
        r11 = r24;
        goto L18
    }
}
