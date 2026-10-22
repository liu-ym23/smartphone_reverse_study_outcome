package com.larus.dora.obric.device_management.setting.g.feedback;

import android.content.Context;
import android.net.Uri;
import com.larus.dora.obric.utils.DoraObricToastUtils;
import java.lang.ref.WeakReference;
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
@DebugMetadata(c = "com.larus.dora.obric.device_management.setting.g.feedback.DoraObricGFeedbackFragment$initPickers$1$1$1", f = "DoraObricGFeedbackFragment.kt", i = {}, l = {589, 598}, m = "invokeSuspend", n = {}, s = {})
final class DoraObricGFeedbackFragment$initPickers$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isImage;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ DoraObricGFeedbackFragment this$0;

    public DoraObricGFeedbackFragment$initPickers$1$1$1(boolean r1, DoraObricGFeedbackFragment r2, Uri r3, Continuation<? super DoraObricGFeedbackFragment$initPickers$1$1$1> r4) {
        this.$isImage = r1;
        this.this$0 = r2;
        this.$uri = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraObricGFeedbackFragment$initPickers$1$1$1(this.$isImage, this.this$0, this.$uri, r5);
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
        DoraObricGFeedbackFragment.b r3 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L22:
        if (((Number) r8).longValue() <= 60) goto L25;
        WeakReference<com.obric.oui.toast.f> r9 = DoraObricToastUtils.a;
        DoraObricToastUtils.e(this.this$0.requireContext(), 2131902737);
    L24:
        boolean r10 = false;
    L26:
        if (r10 == false) goto L45;
        if (((ArrayList) this.this$0.g).size() >= 4) goto L45;
        ((ArrayList) this.this$0.g).add(this.$uri);
        this.this$0.Y90().addImage(this.$uri);
        int r11 = ((ArrayList) this.this$0.g).size();
        if (r11 != 4) goto L35;
        DoraObricGFeedbackFragment.b r2 = this.this$0.j;
        if (r2 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r2 = null;
    L34:
        r2.notifyItemRemoved(3);
    L39:
        DoraObricGFeedbackFragment.b r4 = this.this$0.j;
        if (r4 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
    L43:
        r3.notifyItemInserted(r11 - 1);
        this.this$0.ja0();
        goto L45
    L42:
        r3 = r4;
        goto L43
    L35:
        DoraObricGFeedbackFragment.b r5 = this.this$0.j;
        if (r5 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("imageAdapter");
        r5 = null;
    L38:
        r5.notifyItemChanged(r11 - 1);
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
        WeakReference<com.obric.oui.toast.f> r12 = DoraObricToastUtils.a;
        DoraObricToastUtils.e(this.this$0.requireContext(), 2131902722);
        goto L24
    L10:
        ResultKt.throwOnFailure(r8);
        if (this.$isImage == false) goto L18;
        Context r13 = this.this$0.requireContext();
        Uri r6 = this.$uri;
        this.label = 1;
        int r7 = DoraObricGFeedbackFragment.A;
        r8 = BuildersKt.withContext(Dispatchers.getIO(), new DoraObricGFeedbackFragment$getFileSizeFromUri$2(r13, r6, null), this);
        if (r8 != r0) goto L16;
        return r0;
    L18:
        Context r14 = this.this$0.requireContext();
        Uri r15 = this.$uri;
        this.label = 2;
        int r16 = DoraObricGFeedbackFragment.A;
        r8 = BuildersKt.withContext(Dispatchers.getIO(), new DoraObricGFeedbackFragment$getVideoDurationFromUri$2(r14, r15, null), this);
        if (r8 != r0) goto L22;
        return r0;
    }
}
