package com.larus.uaigc.creation.gallery.providers;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationGalleryUtil", f = "CreationGalleryUtil.kt", i = {0}, l = {187}, m = "getMetaDataMap", n = {"creationTaskId"}, s = {"L$0"})
final class CreationGalleryUtil$getMetaDataMap$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationGalleryUtil this$0;

    public CreationGalleryUtil$getMetaDataMap$1(CreationGalleryUtil r1, Continuation<? super CreationGalleryUtil$getMetaDataMap$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationGalleryUtil.a(this.this$0, null, null, null, this);
    }
}
