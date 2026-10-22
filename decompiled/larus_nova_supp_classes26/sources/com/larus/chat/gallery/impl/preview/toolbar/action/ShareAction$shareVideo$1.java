package com.larus.chat.gallery.impl.preview.toolbar.action;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.ShareAction", f = "ShareAction.kt", i = {0, 0, 0, 0}, l = {196}, m = "shareVideo", n = {"ctx", "data", "rootView", "videoPlayData"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class ShareAction$shareVideo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ShareAction this$0;

    public ShareAction$shareVideo$1(ShareAction r1, Continuation<? super ShareAction$shareVideo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ShareAction r3 = this.this$0;
        Map<String, String> r0 = ShareAction.b;
        return r3.h(null, null, this);
    }
}
