package com.larus.uaigc.createpage.component.stylelist;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.stylelist.ImageStyleListComponent", f = "ImageStyleListComponent.kt", i = {0, 0, 1, 1}, l = {59, 61}, m = "refreshImageStyleList", n = {"languageCode", "fromRemote", "languageCode", "fromRemote"}, s = {"L$0", "Z$0", "L$0", "Z$0"})
public final class ImageStyleListComponent$refreshImageStyleList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageStyleListComponent this$0;

    public ImageStyleListComponent$refreshImageStyleList$1(ImageStyleListComponent r1, Continuation<? super ImageStyleListComponent$refreshImageStyleList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.N2(false, this);
    }
}
