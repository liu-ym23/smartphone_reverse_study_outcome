package com.bytedance.android.ec.core.arch.event;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastChannelImpl;
import kotlinx.coroutines.flow.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public final o a;
    public volatile boolean b;
    public volatile Object c;
    public final BroadcastChannel<Object> d;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.arch.event.a$a, reason: collision with other inner class name */
    public static final class C0126a {
    }

    static {
    }

    public a(BroadcastChannelImpl r10) {
        Intrinsics.checkNotNullParameter(r10, "normalEventChannel");
        this.d = r10;
        this.a = new o(r10);
    }
}
