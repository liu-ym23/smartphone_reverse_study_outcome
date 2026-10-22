package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationImageUploadPolicy", f = "CreationImageUploadPolicy.kt", i = {0, 0, 0, 0, 0, 1, 1, 1}, l = {52, 66}, m = "compressAlbumImg", n = {"uri", "scene", "subScene", "compressConfig", "startTime", "uri", "compressConfig", "findResult"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2"})
public final class CreationImageUploadPolicy$compressAlbumImg$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationImageUploadPolicy this$0;

    public CreationImageUploadPolicy$compressAlbumImg$1(CreationImageUploadPolicy r1, Continuation<? super CreationImageUploadPolicy$compressAlbumImg$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
