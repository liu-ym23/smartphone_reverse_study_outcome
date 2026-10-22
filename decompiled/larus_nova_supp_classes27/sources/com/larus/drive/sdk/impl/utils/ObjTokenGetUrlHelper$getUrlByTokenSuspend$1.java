package com.larus.drive.sdk.impl.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.utils.ObjTokenGetUrlHelper", f = "ObjTokenGetUrlHelper.kt", i = {}, l = {83, 87}, m = "getUrlByTokenSuspend", n = {}, s = {})
public final class ObjTokenGetUrlHelper$getUrlByTokenSuspend$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObjTokenGetUrlHelper this$0;

    public ObjTokenGetUrlHelper$getUrlByTokenSuspend$1(ObjTokenGetUrlHelper r1, Continuation<? super ObjTokenGetUrlHelper$getUrlByTokenSuspend$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
