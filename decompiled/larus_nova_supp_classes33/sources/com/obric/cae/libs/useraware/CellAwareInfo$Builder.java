package com.obric.cae.libs.useraware;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class CellAwareInfo$Builder {
    public String a;
    public String b;
    public int c;
    public int d;
    public int e;
    public long f;
    public int[] g;
    public String h;
    public String i;
    public int j;
    public int k;
    public int l;
    public boolean m;

    public CellAwareInfo$Builder() {
    }

    public CellAwareInfo build() {
        return new CellAwareInfo(this);
    }

    public static /* synthetic */ String a(CellAwareInfo$Builder r0) {
        return r0.a;
    }

    public static /* synthetic */ String b(CellAwareInfo$Builder r0) {
        return r0.b;
    }

    public static /* synthetic */ int c(CellAwareInfo$Builder r0) {
        return r0.k;
    }

    public static /* synthetic */ int d(CellAwareInfo$Builder r0) {
        return r0.l;
    }

    public static /* synthetic */ boolean e(CellAwareInfo$Builder r0) {
        return r0.m;
    }

    public static /* synthetic */ int f(CellAwareInfo$Builder r0) {
        return r0.c;
    }

    public static /* synthetic */ int g(CellAwareInfo$Builder r0) {
        return r0.d;
    }

    public static /* synthetic */ int h(CellAwareInfo$Builder r0) {
        return r0.e;
    }

    public static /* synthetic */ long i(CellAwareInfo$Builder r2) {
        return r2.f;
    }

    public static /* synthetic */ int[] j(CellAwareInfo$Builder r0) {
        return r0.g;
    }

    public static /* synthetic */ String k(CellAwareInfo$Builder r0) {
        return r0.h;
    }

    public static /* synthetic */ String l(CellAwareInfo$Builder r0) {
        return r0.i;
    }

    public static /* synthetic */ int m(CellAwareInfo$Builder r0) {
        return r0.j;
    }

    public CellAwareInfo$Builder arfcn(int r1) {
        this.c = r1;
        return this;
    }

    public CellAwareInfo$Builder bands(int[] r1) {
        this.g = r1;
        return this;
    }

    public CellAwareInfo$Builder ci(long r1) {
        this.f = r1;
        return this;
    }

    public CellAwareInfo$Builder level(int r1) {
        this.l = r1;
        return this;
    }

    public CellAwareInfo$Builder mcc(String r1) {
        this.h = r1;
        return this;
    }

    public CellAwareInfo$Builder mnc(String r1) {
        this.i = r1;
        return this;
    }

    public CellAwareInfo$Builder pci(int r1) {
        this.d = r1;
        return this;
    }

    public CellAwareInfo$Builder registered(boolean r1) {
        this.m = r1;
        return this;
    }

    public CellAwareInfo$Builder signalQuality(int r1) {
        this.k = r1;
        return this;
    }

    public CellAwareInfo$Builder signalStrength(int r1) {
        this.j = r1;
        return this;
    }

    public CellAwareInfo$Builder standard(String r1) {
        this.b = r1;
        return this;
    }

    public CellAwareInfo$Builder tac(int r1) {
        this.e = r1;
        return this;
    }

    public CellAwareInfo$Builder timestamp(String r1) {
        this.a = r1;
        return this;
    }
}
