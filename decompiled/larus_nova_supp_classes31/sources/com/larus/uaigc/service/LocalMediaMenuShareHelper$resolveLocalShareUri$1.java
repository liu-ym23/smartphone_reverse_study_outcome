package com.larus.uaigc.service;

import com.larus.platform.model.CollectionType;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.service.LocalMediaMenuShareHelper", f = "LocalMediaMenuShareHelper.kt", i = {0, 0}, l = {96, CollectionType.SINGLE_QISHUI_ALBUM}, m = "resolveLocalShareUri", n = {"context", "filePath"}, s = {"L$0", "L$1"})
final class LocalMediaMenuShareHelper$resolveLocalShareUri$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ u this$0;

    public LocalMediaMenuShareHelper$resolveLocalShareUri$1(u r1, Continuation<? super LocalMediaMenuShareHelper$resolveLocalShareUri$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return u.a(this.this$0, null, null, false, this);
    }
}
