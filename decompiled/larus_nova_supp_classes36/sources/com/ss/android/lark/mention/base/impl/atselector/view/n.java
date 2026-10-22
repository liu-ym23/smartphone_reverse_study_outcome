package com.ss.android.lark.mention.base.impl.atselector.view;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n {
    public static final /* synthetic */ int f = 0;
    public final CoroutineScope a;
    public final long b;
    public final m c;
    public final Channel<String> d;
    public Job e;

    public static final class a {
    }

    static {
    }

    public n(CoroutineScope r1, long r2, m r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = ChannelKt.Channel$default(-1, null, null, 6, null);
    }
}
