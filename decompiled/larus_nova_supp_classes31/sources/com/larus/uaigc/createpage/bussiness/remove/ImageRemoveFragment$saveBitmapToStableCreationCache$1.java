package com.larus.uaigc.createpage.bussiness.remove;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment", f = "ImageRemoveFragment.kt", i = {0}, l = {743}, m = "saveBitmapToStableCreationCache", n = {"file"}, s = {"L$0"})
final class ImageRemoveFragment$saveBitmapToStableCreationCache$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageRemoveFragment this$0;

    public ImageRemoveFragment$saveBitmapToStableCreationCache$1(ImageRemoveFragment r1, Continuation<? super ImageRemoveFragment$saveBitmapToStableCreationCache$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ImageRemoveFragment.T90(this.this$0, null, this);
    }
}
