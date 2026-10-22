package com.obric.assistant.guide.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.guide.ui.LocalDataSearchFragment", f = "LocalDataSearchFragment.kt", i = {0}, l = {184}, m = "buildCustomPermissionToggleList", n = {"toggleList"}, s = {"L$0"})
final class LocalDataSearchFragment$buildCustomPermissionToggleList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalDataSearchFragment this$0;

    public LocalDataSearchFragment$buildCustomPermissionToggleList$1(LocalDataSearchFragment r1, Continuation<? super LocalDataSearchFragment$buildCustomPermissionToggleList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return LocalDataSearchFragment.S90(this.this$0, this);
    }
}
