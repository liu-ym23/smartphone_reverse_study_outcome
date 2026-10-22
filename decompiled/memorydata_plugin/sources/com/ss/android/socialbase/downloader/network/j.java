package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.service.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private q f15595a;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.j$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f15596a = null;

        static {
            f15596a = new j(null);
        }
    }

    public interface b {
        void a(NetworkQuality r1);
    }

    private j() {
        this.f15595a = (q) ZeusTransformUtils.preCheckCast(com.ss.android.socialbase.downloader.service.k.a(q.class), q.class, "com.obric.memorydata.plugin");
    }

    /* synthetic */ j(AnonymousClass1 r1) {
        this();
    }

    public static j a() {
        return a.f15596a;
    }

    public void a(long r1, long r3) {
        this.f15595a.a(r1, r3);
    }

    public double b() {
        return this.f15595a.a();
    }

    public double c() {
        return this.f15595a.b();
    }

    public long d() {
        return this.f15595a.c();
    }
}
