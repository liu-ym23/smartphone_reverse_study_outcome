package com.bytedance.common.wschannel.heartbeat.a;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f2115a;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.heartbeat.a.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.heartbeat.a.a$a, reason: collision with other inner class name */
    private static final class C0115a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f2116a = null;

        static {
            f2116a = new a(null);
        }

        static /* synthetic */ a a() {
            return f2116a;
        }
    }

    private a() {
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    public static a a() {
        return C0115a.a();
    }

    @Override // com.bytedance.common.wschannel.heartbeat.a.b
    public void a(Throwable r1) {
        b r0 = this.f2115a;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.a.b
    public void b() {
        b r0 = this.f2115a;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.common.wschannel.heartbeat.a.b
    public void c() {
        b r0 = this.f2115a;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }
}
