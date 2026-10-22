package com.larus.uaigc.instruction;

import android.net.Uri;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.MultiAttachmentSelectorWidget$handlePassedImageAlbumPathsToResourceItems$1", f = "MultiAttachmentSelectorWidget.kt", i = {0}, l = {515}, m = "invokeSuspend", n = {"mediaMaxNum"}, s = {"I$0"})
final class MultiAttachmentSelectorWidget$handlePassedImageAlbumPathsToResourceItems$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Uri> $passedImageAlbumPaths;
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MultiAttachmentSelectorWidget this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MultiAttachmentSelectorWidget$handlePassedImageAlbumPathsToResourceItems$1(MultiAttachmentSelectorWidget r1, List<? extends Uri> r2, Continuation<? super MultiAttachmentSelectorWidget$handlePassedImageAlbumPathsToResourceItems$1> r3) {
        this.this$0 = r1;
        this.$passedImageAlbumPaths = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MultiAttachmentSelectorWidget$handlePassedImageAlbumPathsToResourceItems$1(this.this$0, this.$passedImageAlbumPaths, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        Iterator r3 = (Iterator) this.L$1;
        MultiAttachmentSelectorWidget r4 = (MultiAttachmentSelectorWidget) this.L$0;
        ResultKt.throwOnFailure(r7);
    L11:
        MultiAttachmentSelectorWidget$handlePassedImageAlbumPathsToResourceItems$1 r8 = this;
    L13:
        if (r3.hasNext() == false) goto L18;
        Uri r5 = (Uri) r3.next();
        r8.L$0 = r4;
        r8.L$1 = r3;
        r8.I$0 = r2;
        r8.label = 1;
        if (MultiAttachmentSelectorWidget.C6(r4, r5, r2, r8) != r0) goto L13;
        return r0;
    L18:
        MultiAttachmentSelectorWidget r9 = r8.this$0;
        int r6 = MultiAttachmentSelectorWidget.m;
        com.larus.bmhome.view.actionbar.edit.c r10 = r9.getViewModel();
        if (r10 == null) goto L21;
        r10.setOriginalRatioEnable(true);
    L21:
        r9.N6();
        r9.w7();
        mt8.a r11 = r9.f;
        if (r11 == null) goto L25;
        r11.e(r9.h);
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        int r12 = MultiAttachmentSelectorWidget.s6(this.this$0);
        List<Uri> r13 = this.$passedImageAlbumPaths;
        if (r13 == null) goto L17;
        MultiAttachmentSelectorWidget r14 = this.this$0;
        r4 = r14;
        r3 = r13.iterator();
        r2 = r12;
        goto L11
    L17:
        r8 = this;
        goto L18
    }
}
