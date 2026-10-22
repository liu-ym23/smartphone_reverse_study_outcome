package com.loc;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class dv implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5473b;
    public int c;
    public int d;
    public long e;
    public long f;
    public int g;
    public boolean h;
    public boolean i;

    public dv() {
        this.f5472a = "";
        this.f5473b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = true;
    }

    public dv(boolean r3, boolean r4) {
        this.f5472a = "";
        this.f5473b = "";
        this.c = 99;
        this.d = Integer.MAX_VALUE;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = true;
        this.h = r3;
        this.i = r4;
    }

    private static int a(String r0) {
        return Integer.parseInt(r0);
    L4:
        e = move-exception;
        de.a(e);
        return 0;
    }

    public abstract dv a();

    public final void a(dv r3) {
        this.f5472a = r3.f5472a;
        this.f5473b = r3.f5473b;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
    }

    public final int b() {
        return a(this.f5472a);
    }

    public final int c() {
        return a(this.f5473b);
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f5472a + ", mnc=" + this.f5473b + ", signalStrength=" + this.c + ", asulevel=" + this.d + ", lastUpdateSystemMills=" + this.e + ", lastUpdateUtcMills=" + this.f + ", age=" + this.g + ", main=" + this.h + ", newapi=" + this.i + '}';
    }
}
