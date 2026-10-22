package com.obric.cae.libs.useraware;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class WifiStandardData$Builder {
    public long a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public int g;
    public long h;
    public long i;
    public int j;
    public int k;
    public int l;

    public WifiStandardData build() {
        return new WifiStandardData(this);
    }

    public WifiStandardData$Builder() {
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = -1;
        this.l = 0;
    }

    public static /* synthetic */ long a(WifiStandardData$Builder r2) {
        return r2.a;
    }

    public static /* synthetic */ String b(WifiStandardData$Builder r0) {
        return r0.b;
    }

    public static /* synthetic */ int c(WifiStandardData$Builder r0) {
        return r0.k;
    }

    public static /* synthetic */ int d(WifiStandardData$Builder r0) {
        return r0.l;
    }

    public static /* synthetic */ String e(WifiStandardData$Builder r0) {
        return r0.c;
    }

    public static /* synthetic */ int f(WifiStandardData$Builder r0) {
        return r0.d;
    }

    public static /* synthetic */ int g(WifiStandardData$Builder r0) {
        return r0.e;
    }

    public static /* synthetic */ int h(WifiStandardData$Builder r0) {
        return r0.f;
    }

    public static /* synthetic */ int i(WifiStandardData$Builder r0) {
        return r0.g;
    }

    public static /* synthetic */ long j(WifiStandardData$Builder r2) {
        return r2.h;
    }

    public static /* synthetic */ long k(WifiStandardData$Builder r2) {
        return r2.i;
    }

    public static /* synthetic */ int l(WifiStandardData$Builder r0) {
        return r0.j;
    }

    public WifiStandardData$Builder setApStandard(int r1) {
        this.l = r1;
        return this;
    }

    public WifiStandardData$Builder setApType(int r1) {
        this.k = r1;
        return this;
    }

    public WifiStandardData$Builder setAuthType(int r1) {
        this.j = r1;
        return this;
    }

    public WifiStandardData$Builder setBand(int r1) {
        this.g = r1;
        return this;
    }

    public WifiStandardData$Builder setBssid(String r1) {
        this.b = r1;
        return this;
    }

    public WifiStandardData$Builder setDataflow(long r1) {
        this.h = r1;
        return this;
    }

    public WifiStandardData$Builder setFrequency(int r1) {
        this.f = r1;
        return this;
    }

    public WifiStandardData$Builder setRssi(int r1) {
        this.e = r1;
        return this;
    }

    public WifiStandardData$Builder setSignalLevel(int r1) {
        this.d = r1;
        return this;
    }

    public WifiStandardData$Builder setSsid(String r1) {
        this.c = r1;
        return this;
    }

    public WifiStandardData$Builder setTimestamp(long r1) {
        this.a = r1;
        return this;
    }

    public WifiStandardData$Builder setUseTime(long r1) {
        this.i = r1;
        return this;
    }
}
