package com.ss.android.lark.keyboard.edittext2.copy;

import com.bytedance.lark.pb.im.v1.BatchHardLinkResourcesV2Request;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.base.b;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext2.copy.CopyProtocolServiceImpl", f = "CopyProtocolServiceImpl.kt", i = {}, l = {79}, m = "batchHardLinkResourceV2-0E7RQCE", n = {}, s = {})
final class CopyProtocolServiceImpl$batchHardLinkResourceV2$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CopyProtocolServiceImpl this$0;

    public CopyProtocolServiceImpl$batchHardLinkResourceV2$1(CopyProtocolServiceImpl r1, Continuation<? super CopyProtocolServiceImpl$batchHardLinkResourceV2$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Target.SIZE_ORIGINAL;
        final CopyProtocolServiceImpl r5 = this.this$0;
        r5.getClass();
        int r1 = this.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L5;
        this.label = r1 - Target.SIZE_ORIGINAL;
        CopyProtocolServiceImpl$batchHardLinkResourceV2$1 r0 = this;
    L6:
        Object r2 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 != 0) goto L9;
        ResultKt.throwOnFailure(r2);
        final RichText r6 = null;
        new CopyProtocolServiceImpl$batchHardLinkResourceV2$entityMapper$1(r6, r5);
        new BatchHardLinkResourcesV2Request.Builder();
        new ArrayList(CollectionsKt.collectionSizeOrDefault(null, 10));
        throw null;
    L9:
        if (r3 != 1) goto L23;
        ResultKt.throwOnFailure(r2);
        b r7 = (b) r2;
        r7.getClass();
        if ((true ^ (r7 instanceof b.b)) == false) goto L13;
        Result.Companion r8 = Result.Companion;
        Object r9 = Result.constructor-impl(r7.b());
    L18:
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        return r9;
    L21:
        return Result.box-impl(r9);
    L13:
        Result.Companion r10 = Result.Companion;
        ErrorResult r11 = r7.a();
        if (r11 != null) goto L16;
        r11 = new ErrorResult("");
    L16:
        r9 = Result.constructor-impl(ResultKt.createFailure(r11));
        goto L18
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new CopyProtocolServiceImpl$batchHardLinkResourceV2$1(r5, this);
        goto L6
    }
}
