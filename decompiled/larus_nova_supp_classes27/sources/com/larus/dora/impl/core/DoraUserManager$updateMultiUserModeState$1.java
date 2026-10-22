package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraUserManager", f = "DoraUserManager.kt", i = {0}, l = {188}, m = "updateMultiUserModeState", n = {"enable"}, s = {"Z$0"})
public final class DoraUserManager$updateMultiUserModeState$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraUserManager this$0;

    public DoraUserManager$updateMultiUserModeState$1(DoraUserManager r1, Continuation<? super DoraUserManager$updateMultiUserModeState$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(false, 0, this);
    }
}
