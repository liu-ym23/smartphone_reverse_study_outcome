package com.obric.capabilitykit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.capabilitykit.ActionDispatcher", f = "ActionDispatcher.kt", i = {0, 0}, l = {58}, m = "onActionReceived", n = {"action", "start"}, s = {"L$0", "J$0"})
public final class ActionDispatcher$b extends ContinuationImpl {
    public Object a;
    public long b;
    public /* synthetic */ Object c;
    public final /* synthetic */ ActionDispatcher d;
    public int e;

    public ActionDispatcher$b(ActionDispatcher r1, Continuation<? super ActionDispatcher$b> r2) {
        this.d = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.c = r2;
        this.e |= Integer.MIN_VALUE;
        return this.d.onActionReceived(null, this);
    }
}
