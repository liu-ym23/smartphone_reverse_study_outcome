package com.obric.memorydata.memory.ui.automemory.create;

import com.ss.bduploader.UploadKeys;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.create.AutoMemoryCollectionAiTaskQueue", f = "AutoMemoryCollectionAiTaskQueue.kt", i = {2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7}, l = {99, UploadKeys.KeyIsEnd2EndEncryptionOption, 122, WebSocketProtocol.PAYLOAD_SHORT, 130, 136, 140, 144}, m = "runOneOrWait", n = {"this", "task", "this", "task", "this", "task", "this", "task", "this", "task", "this", "task"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
final class AutoMemoryCollectionAiTaskQueue$runOneOrWait$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AutoMemoryCollectionAiTaskQueue this$0;

    AutoMemoryCollectionAiTaskQueue$runOneOrWait$1(AutoMemoryCollectionAiTaskQueue r3, Continuation<? super AutoMemoryCollectionAiTaskQueue$runOneOrWait$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return AutoMemoryCollectionAiTaskQueue.a(this.this$0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
