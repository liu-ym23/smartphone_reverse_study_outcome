package com.obric.capabilitykit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.capabilitykit.execution.IntentDispatcherClient", f = "IntentDispatcherClient.kt", i = {0, 0, 0}, l = {36}, m = "onIntentReceived", n = {"intentCalling", "context", "start"}, s = {"L$0", "L$1", "J$0"})
public final class s$a extends ContinuationImpl {
    public Object a;
    public Object b;
    public long c;
    public /* synthetic */ Object d;
    public final /* synthetic */ s e;
    public int f;

    public s$a(s r1, Continuation<? super s$a> r2) {
        this.e = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.d = r2;
        this.f |= Integer.MIN_VALUE;
        return this.e.a(null, null, this);
    }
}
