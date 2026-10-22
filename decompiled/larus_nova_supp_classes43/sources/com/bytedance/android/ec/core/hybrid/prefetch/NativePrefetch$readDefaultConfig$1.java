package com.bytedance.android.ec.core.hybrid.prefetch;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@"}, d2 = {"Landroid/net/Uri;", com.bytedance.android.ec.core.event.a.KEY_SCHEMA, "Lkotlinx/coroutines/channels/Channel;", "Lorg/json/JSONObject;", "channel", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "readDefaultConfig"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetch", f = "NativePrefetch.kt", i = {}, l = {216}, m = "readDefaultConfig", n = {}, s = {})
final class NativePrefetch$readDefaultConfig$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NativePrefetch this$0;

    public NativePrefetch$readDefaultConfig$1(NativePrefetch r1, Continuation r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return NativePrefetch.d(this.this$0, null, null, this);
    }
}
