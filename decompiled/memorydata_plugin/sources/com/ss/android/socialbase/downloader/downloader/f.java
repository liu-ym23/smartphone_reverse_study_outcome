package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.ah;
import com.ss.android.socialbase.downloader.depend.y;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f15421b;
    private ah c;
    private com.ss.android.socialbase.downloader.network.i d;
    private com.ss.android.socialbase.downloader.network.f e;
    private j f;
    private p g;
    private com.ss.android.socialbase.downloader.f.b h;
    private List<com.ss.android.socialbase.downloader.depend.l> i;
    private ab j;
    private ExecutorService k;
    private ExecutorService l;
    private ExecutorService m;
    private ExecutorService n;
    private ExecutorService o;
    private ExecutorService p;
    private ExecutorService q;
    private ExecutorService r;
    private ExecutorService s;
    private t t;
    private y u;
    private int v;
    private boolean w;
    private boolean x;

    public i a() {
        return this.f15421b;
    }

    public com.ss.android.socialbase.downloader.network.i b() {
        return this.d;
    }

    public j c() {
        return this.f;
    }

    public ExecutorService d() {
        return this.k;
    }

    public ExecutorService e() {
        return this.l;
    }

    public ExecutorService f() {
        return this.m;
    }

    public ExecutorService g() {
        return this.n;
    }

    public Context getContext() {
        return this.f15420a;
    }

    public ExecutorService h() {
        return this.o;
    }

    public ExecutorService i() {
        return this.p;
    }

    public ExecutorService j() {
        return this.q;
    }

    public ExecutorService k() {
        return this.r;
    }

    public ExecutorService l() {
        return this.s;
    }

    public List<com.ss.android.socialbase.downloader.depend.l> m() {
        return this.i;
    }

    public int n() {
        return this.v;
    }

    public boolean o() {
        return this.w;
    }

    public p p() {
        return this.g;
    }

    public t q() {
        return this.t;
    }

    public y r() {
        return this.u;
    }

    public boolean s() {
        return this.x;
    }

    public ah t() {
        return this.c;
    }

    public ab u() {
        return this.j;
    }

    public com.ss.android.socialbase.downloader.f.b v() {
        return this.h;
    }

    public com.ss.android.socialbase.downloader.network.f w() {
        return this.e;
    }

    public Downloader x() {
        return new Downloader(this);
    }
}
