package com.larus.ui.arch.vm.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;
import w1a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class n<S extends w1a.b> {
    public static final /* synthetic */ int f = 0;
    public final Channel<Function1<S, S>> a;
    public final Channel<Function1<S, Unit>> b;
    public final MutableSharedFlow<S> c;
    public S d;
    public final a1 e;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(w1a.b r9, CoroutineScope r10, CoroutineDispatcher r11) {
        Intrinsics.checkNotNullParameter(r9, "initialState");
        Intrinsics.checkNotNullParameter(r10, "scope");
        Intrinsics.checkNotNullParameter(r11, "dispatcher");
        this.a = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.b = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        MutableSharedFlow<S> r0 = SharedFlowKt.MutableSharedFlow(1, 63, BufferOverflow.SUSPEND);
        r0.tryEmit(r9);
        this.c = r0;
        this.d = r9;
        this.e = kotlinx.coroutines.flow.e.a(r0);
        BuildersKt.launch$default(r10, r11, null, new CoroutinesStateStore$1(this, null), 2, null);
    }
}
