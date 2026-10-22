package com.obric.aikernel.res.metadata;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.res.metadata.data.AIPackage;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f5055a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f5056b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AIPackage f5057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile AIPackage f5058b;

        /* JADX INFO: renamed from: com.obric.aikernel.res.metadata.d$a$a, reason: collision with other inner class name */
        public static final class C0114a extends AIPackage {
            C0114a(String r10, String r11, PackageResourceManager.PresmConfig r12) {
                super(r10, r11, r12);
            }

            @Override // com.obric.aikernel.res.metadata.data.AIPackage, com.obric.aikernel.res.metadata.data.b
            public boolean H() {
                return true;
            }

            @Override // com.obric.aikernel.res.metadata.data.b
            public boolean Z() {
                return true;
            }

            @Override // com.obric.aikernel.res.metadata.data.AIPackage, com.obric.aikernel.res.metadata.data.b
            public boolean a0() {
                return true;
            }
        }

        public a(AIPackage r10) {
            Intrinsics.checkNotNullParameter(r10, "src");
            this.f5057a = r10;
        }

        public final AIPackage a() {
            if (this.f5057a.H() == false) goto L6;
            return this.f5057a;
        L6:
            if (this.f5058b != null) goto L19;
            monitor-enter(this);
        L16:
            th = move-exception;
            throw th;
        L9:
            if (this.f5058b != null) goto L13;
            this.f5058b = new C0114a(this.f5057a.w(), this.f5057a.D(), this.f5057a.q());     // Catch: Throwable -> L16
            AIPackage r10 = this.f5058b;     // Catch: Throwable -> L16
            if (r10 == null) goto L13;
            r10.q0(this.f5057a.k0());     // Catch: Throwable -> L16
        L13:
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(this);
        L19:
            AIPackage r12 = this.f5058b;
            if (r12 == null) goto L23;
            return r12;
        L23:
            throw new IllegalArgumentException("Required value was null.".toString());
        }

        public final AIPackage b() {
            return this.f5057a;
        }
    }

    static {
        f5055a = new d();
    }

    private d() {
    }

    public final AIPackage a() {
        a r10 = f5056b;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.a();
    }

    public final boolean b(String r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        return Intrinsics.areEqual(r10, "vlm_local");
    }

    public final synchronized void c(AIPackage r10) {
        monitor-enter(this);
        com.obric.aikernel.runtime.utils.d r11 = com.obric.aikernel.runtime.utils.d.f5417a;     // Catch: Throwable -> L15
        StringBuilder r12 = new StringBuilder();     // Catch: Throwable -> L15
        r12.append("set: ");     // Catch: Throwable -> L15
        r12.append(r10);     // Catch: Throwable -> L15
        r12.append(" from ");     // Catch: Throwable -> L15
        a r13 = f5056b;     // Catch: Throwable -> L15
        if (r13 == null) goto L6;
        AIPackage r14 = r13.b();     // Catch: Throwable -> L15
    L7:
        r12.append(r14);     // Catch: Throwable -> L15
        r11.g("VlmLocalVersionConstrict", r12.toString());     // Catch: Throwable -> L15
        if (r10 != null) goto L11;
        f5056b = null;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L11:
        if (f5056b != null) goto L13;
        f5056b = new a(r10);     // Catch: Throwable -> L15
        goto L13
    L6:
        r14 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean d() {
        monitor-enter(this);
        a r10 = f5056b;     // Catch: Throwable -> L17
        boolean r11 = false;
        if (r10 == null) goto L14;
        AIPackage r12 = r10.b();     // Catch: Throwable -> L17
        if (r12 == null) goto L14;
        PackageResourceManager.PresmConfig r13 = r12.q();     // Catch: Throwable -> L17
        if (r13 == null) goto L14;
        Function0<Boolean> r14 = r13.isInferProcess();     // Catch: Throwable -> L17
        if (r14 == null) goto L14;
        if (r14.invoke().booleanValue() != true) goto L14;
        r11 = true;
    L14:
        boolean r15 = !r11;
        monitor-exit(this);
        return r15;
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean e(AIPackage r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "pkg");     // Catch: Throwable -> L24
        boolean r11 = true;
        if (b(r10.w()) == true) goto L6;
    L21:
        r11 = false;
    L22:
        monitor-exit(this);
        return r11;
    L6:
        if (Intrinsics.areEqual(r10.D(), "debug") == true) goto L21;
        a r12 = f5056b;     // Catch: Throwable -> L24
        if (r12 == null) goto L21;
        AIPackage r13 = r12.b();     // Catch: Throwable -> L24
        if (r13 == null) goto L21;
        if (Intrinsics.areEqual(r10.D(), r13.D()) == false) goto L18;
        if (r13.H() == false) goto L18;
        boolean r14 = false;
    L19:
        if (r14 != true) goto L21;
    L18:
        r14 = true;
    L24:
        th = move-exception;
        throw th;
    }
}
