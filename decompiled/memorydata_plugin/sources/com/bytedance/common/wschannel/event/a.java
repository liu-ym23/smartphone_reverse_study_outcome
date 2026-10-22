package com.bytedance.common.wschannel.event;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChannelType f2110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectionState f2111b;
    public final int c;
    public final int d;

    public a(ConnectionState r1, ChannelType r2, int r3, int r4) {
        this.f2111b = r1;
        this.f2110a = r2;
        this.d = r3;
        this.c = r4;
    }

    public String toString() {
        return "ConnectEvent{mType=" + this.f2110a + ", connectionState=" + this.f2111b + ", mChannelId=" + this.d + ", errorCode=" + this.c + '}';
    }
}
