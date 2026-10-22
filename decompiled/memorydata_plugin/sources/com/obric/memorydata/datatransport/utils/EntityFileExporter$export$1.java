package com.obric.memorydata.datatransport.utils;

import com.bytedance.crash.constants.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.datatransport.utils.EntityFileExporter", f = "EntityFileExporter.kt", i = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 6, 7, 7, 7, 8, 9, 9, 9, 10, 11, 12}, l = {91, 103, 115, 124, 136, 152, 164, 175, 183, 194, 202, Constants.UPLOAD_DISASTER_DROP, 224}, m = "export", n = {"result", "this", "$this$export", "result", "this", "$this$export", "result", "this", "$this$export", "result", "this", "$this$export", "result", "result", "result", "this", "$this$export", "result", "result", "this", "$this$export", "result", "result", "result", "result"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$0", "L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$2", "L$0", "L$0", "L$0"})
final class EntityFileExporter$export$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e this$0;

    EntityFileExporter$export$1(e r3, Continuation<? super EntityFileExporter$export$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return e.a(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
