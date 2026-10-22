package com.bytedance.common.wschannel.heartbeat.b;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.common.wschannel.heartbeat.model.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2121b;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.heartbeat.b.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.heartbeat.b.a$a, reason: collision with other inner class name */
    private static class C0116a extends a {
        private C0116a() {
            super(-1, 5000);
        }

        /* synthetic */ C0116a(AnonymousClass1 r1) {
            this();
        }
    }

    public a() {
    }

    public a(long r1, long r3) {
        this.f2120a = r1;
        this.f2121b = r3;
    }

    public long a() {
        return this.f2120a;
    }

    void a(long r1) {
        this.f2120a = r1;
    }

    public long b() {
        return this.f2121b;
    }

    public a c() {
        return new C0116a(null);
    }
}
