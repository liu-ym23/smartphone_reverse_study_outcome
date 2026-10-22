package com.larus.bmhome.share.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.share.network.SharePanelShowHelper", f = "SharePanelShowHelper.kt", i = {}, l = {221}, m = "doRequestMessageShareApi", n = {}, s = {})
final class SharePanelShowHelper$doRequestMessageShareApi$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharePanelShowHelper this$0;

    public SharePanelShowHelper$doRequestMessageShareApi$1(SharePanelShowHelper r1, Continuation<? super SharePanelShowHelper$doRequestMessageShareApi$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return SharePanelShowHelper.b(this.this$0, null, null, this);
    }
}
