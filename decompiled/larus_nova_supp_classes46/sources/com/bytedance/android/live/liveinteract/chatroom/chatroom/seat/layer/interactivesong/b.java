package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.interactivesong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b {
    public q a;
    public boolean b;
    public final Object c;

    public b() {
        this(null);
    }

    public abstract void a();

    public final String toString() {
        return "{type:" + getClass() + ",working:" + this.b + ",token:" + this.c + '}';
    }

    public b(Object r1) {
        this.c = r1;
        this.b = true;
    }
}
