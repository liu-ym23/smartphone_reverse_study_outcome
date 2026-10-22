package com.obric.assistant.state.multitask;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import jha.c;
import jha.i;
import jha.l;
import jha.o;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class TaskFlowManager$b<S extends o> {
    public final l<S> a;
    public final i<S> b;
    public final c c;
    public final Channel<TaskFlowManager$a<S>> d;
    public final AtomicLong e;
    public final AtomicLong f;
    public final AtomicReference<TaskFlowManager$EntryLifecycle> g;
    public final AtomicBoolean h;
    public final CompletableDeferred<Unit> i;

    public TaskFlowManager$b(l<S> r3, i<S> r4, c r5) {
        Intrinsics.checkNotNullParameter(r3, "handle");
        Intrinsics.checkNotNullParameter(r4, "machine");
        Intrinsics.checkNotNullParameter(r5, "dispatchPolicy");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = ChannelKt.Channel$default(64, null, null, 6, null);
        this.e = new AtomicLong(0);
        this.f = new AtomicLong(0);
        this.g = new AtomicReference(TaskFlowManager$EntryLifecycle.OPEN);
        this.h = new AtomicBoolean(false);
        this.i = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    }
}
