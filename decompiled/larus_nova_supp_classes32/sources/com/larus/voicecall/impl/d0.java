package com.larus.voicecall.impl;

import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d0<T> {
    public final Channel<T> a;
    public final kotlinx.coroutines.flow.b b;

    public d0() {
        Channel<T> r0 = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.a = r0;
        this.b = e.A(r0);
    }
}
