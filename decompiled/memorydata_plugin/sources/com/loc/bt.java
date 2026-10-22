package com.loc;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class bt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    bv f5380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f5381b;

    bt(int r2) {
        ByteBuffer r3 = ByteBuffer.allocate(r2);
        this.f5381b = r3;
        r3.order(ByteOrder.LITTLE_ENDIAN);
        this.f5380a = new bv(this.f5381b);
    }

    public final bt a() {
        this.f5380a.a(this.f5381b);
        return this;
    }
}
