package com.larus.dora.impl.feedback;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackFragment$initPickers$1$1$1", f = "DoraGFeedbackFragment.kt", i = {}, l = {328, 338}, m = "invokeSuspend", n = {}, s = {})
final class DoraGFeedbackFragment$initPickers$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isImage;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ DoraGFeedbackFragment this$0;

    public DoraGFeedbackFragment$initPickers$1$1$1(boolean r1, DoraGFeedbackFragment r2, Uri r3, Continuation<? super DoraGFeedbackFragment$initPickers$1$1$1> r4) {
        this.$isImage = r1;
        this.this$0 = r2;
        this.$uri = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraGFeedbackFragment$initPickers$1$1$1(this.$isImage, this.this$0, this.$uri, r5);
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
        DoraGFeedbackFragment.ImagePreviewAdapter r3 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L22:
        if (((Number) r8).longValue() <= 60) goto L25;
        t19.s r9 = t19.s.a;
        Context r2 = this.this$0.getContext();
        r9.getClass();
        t19.s.s(r2, 2131902737);
    L24:
        boolean r10 = false;
    L26:
        if (r10 == false) goto L45;
        int r11 = ((ArrayList) this.this$0.k).size();
        DoraGFeedbackFragment r4 = this.this$0;
        if (r11 >= r4.g) goto L45;
        ((ArrayList) r4.k).add(this.$uri);
        this.this$0.X90().addImage(this.$uri);
        int r12 = ((ArrayList) this.this$0.k).size();
        DoraGFeedbackFragment r5 = this.this$0;
        if (r12 != r5.g) goto L35;
        DoraGFeedbackFragment.ImagePreviewAdapter r6 = r5.l;
        if (r6 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r6 = null;
    L34:
        r6.notifyItemRemoved(this.this$0.g - 1);
    L39:
        DoraGFeedbackFragment.ImagePreviewAdapter r7 = this.this$0.l;
        if (r7 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
    L43:
        r3.notifyItemInserted(r12 - 1);
        goto L45
    L42:
        r3 = r7;
        goto L43
    L35:
        DoraGFeedbackFragment.ImagePreviewAdapter r13 = r5.l;
        if (r13 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r13 = null;
    L38:
        r13.notifyItemChanged(r12 - 1);
    L45:
        return Unit.INSTANCE;
    L25:
        r10 = true;
        goto L26
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L16:
        if ((((Number) r8).longValue() / ((double) 1048576)) <= 10.0d) goto L25;
        t19.s r14 = t19.s.a;
        Context r15 = this.this$0.getContext();
        r14.getClass();
        t19.s.s(r15, 2131902722);
        goto L24
    L10:
        ResultKt.throwOnFailure(r8);
        if (this.$isImage == false) goto L18;
        Context r16 = this.this$0.requireContext();
        Uri r17 = this.$uri;
        this.label = 1;
        int r18 = DoraGFeedbackFragment.r;
        r8 = BuildersKt.withContext(Dispatchers.getIO(), new DoraGFeedbackFragment$getFileSizeFromUri$2(r16, r17, null), this);
        if (r8 != r0) goto L16;
        return r0;
    L18:
        Context r20 = this.this$0.requireContext();
        Uri r21 = this.$uri;
        this.label = 2;
        int r22 = DoraGFeedbackFragment.r;
        r8 = BuildersKt.withContext(Dispatchers.getIO(), new DoraGFeedbackFragment$getVideoDurationFromUri$2(r20, r21, null), this);
        if (r8 != r0) goto L22;
        return r0;
    }
}
