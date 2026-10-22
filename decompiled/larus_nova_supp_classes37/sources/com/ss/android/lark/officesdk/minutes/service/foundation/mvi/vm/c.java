package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c<S extends l> {
    public static final ExecutorCoroutineDispatcher g = null;
    public final CoroutineScope a;
    public final Channel<Function1<S, S>> b;
    public final Channel<Function1<S, Unit>> c;
    public final MutableSharedFlow<S> d;
    public volatile S e;
    public final a1 f;

    public static final class a {
    }

    static {
        g = ExecutorsKt.from(PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("vm/StateStore")));
    }

    public c(S r9, CoroutineScope r10) {
        Intrinsics.checkNotNullParameter(r9, "initialState");
        Intrinsics.checkNotNullParameter(r10, "scope");
        this.a = r10;
        this.b = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.c = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        MutableSharedFlow<S> r0 = SharedFlowKt.MutableSharedFlow(1, 63, BufferOverflow.SUSPEND);
        r0.tryEmit(r9);
        this.d = r0;
        this.e = r9;
        this.f = kotlinx.coroutines.flow.e.a(r0);
        BuildersKt.launch$default(r10, g, null, new StateStore$setupTriggerFlushQueues$1(this, null), 2, null);
    }

    public static void a(c r6, Flow r7, CoroutineScope r8, Function2 r9) {
        BuildersKt.launch$default(r8, null, null, new StateStore$resolveSubscription$1(true, r7, r9, null), 3, null);
    }
}
