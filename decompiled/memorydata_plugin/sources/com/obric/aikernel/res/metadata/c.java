package com.obric.aikernel.res.metadata;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.runtime.utils.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/aikernel/res/metadata/VlmLocalVersionConstrict;", "", "()V", "TAG", "", "VLM_PACKAGE_NAME", "pkgInfo", "Lcom/obric/aikernel/res/metadata/VlmLocalVersionConstrict$RestrictedPackageInfo;", "getPackage", "Lcom/obric/aikernel/res/metadata/data/AIPackage;", "isVlmPackage", "", ActivityLifecycle.NAME, "set", "", "pkg", "shouldInitPackage", "shouldInject", "RestrictedPackageInfo", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6058a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f6059b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/obric/aikernel/res/metadata/VlmLocalVersionConstrict$RestrictedPackageInfo;", "", "src", "Lcom/obric/aikernel/res/metadata/data/AIPackage;", "(Lcom/obric/aikernel/res/metadata/data/AIPackage;)V", "mockAvail", "getSrc", "()Lcom/obric/aikernel/res/metadata/data/AIPackage;", "getPackage", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.aikernel.res.metadata.data.b f6060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile com.obric.aikernel.res.metadata.data.b f6061b;

        /* JADX INFO: renamed from: com.obric.aikernel.res.metadata.c$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/obric/aikernel/res/metadata/VlmLocalVersionConstrict$RestrictedPackageInfo$getPackage$1$1", "Lcom/obric/aikernel/res/metadata/data/AIPackage;", "isAvailable", "", "resourceIsAvailable", "resourceIsReady", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class C0262a extends com.obric.aikernel.res.metadata.data.b {
            C0262a(String r1, String r2, PackageResourceManager.PresmConfig r3) {
                super(r1, r2, r3);
            }

            @Override // com.obric.aikernel.res.metadata.data.b, com.obric.aikernel.res.metadata.data.d
            public boolean d() {
                return true;
            }

            @Override // com.obric.aikernel.res.metadata.data.d
            public boolean e() {
                return true;
            }

            @Override // com.obric.aikernel.res.metadata.data.b, com.obric.aikernel.res.metadata.data.d
            public boolean f() {
                return true;
            }
        }

        public a(com.obric.aikernel.res.metadata.data.b r2) {
            Intrinsics.checkNotNullParameter(r2, "src");
            this.f6060a = r2;
        }

        public final com.obric.aikernel.res.metadata.data.b a() {
            return this.f6060a;
        }

        public final com.obric.aikernel.res.metadata.data.b b() {
            if (this.f6060a.d() == false) goto L6;
            return this.f6060a;
        L6:
            if (this.f6061b != null) goto L19;
            monitor-enter(this);
        L16:
            th = move-exception;
            throw th;
        L9:
            if (this.f6061b != null) goto L13;
            this.f6061b = (com.obric.aikernel.res.metadata.data.b) ZeusTransformUtils.preCheckCast(new C0262a(this.f6060a.s(), this.f6060a.t(), this.f6060a.u()), com.obric.aikernel.res.metadata.data.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
            com.obric.aikernel.res.metadata.data.b r0 = this.f6061b;     // Catch: Throwable -> L16
            if (r0 == null) goto L13;
            r0.a(this.f6060a.p());     // Catch: Throwable -> L16
        L13:
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L16
            monitor-exit(this);
        L19:
            com.obric.aikernel.res.metadata.data.b r4 = this.f6061b;
            if (r4 == null) goto L23;
            return r4;
        L23:
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    static {
        f6058a = new c();
    }

    private c() {
    }

    public final synchronized void a(com.obric.aikernel.res.metadata.data.b r6) {
        monitor-enter(this);
        d r0 = d.f6216a;     // Catch: Throwable -> L15
        StringBuilder r2 = new StringBuilder().append("set: ").append(r6).append(" from ");     // Catch: Throwable -> L15
        a r3 = f6059b;     // Catch: Throwable -> L15
        if (r3 == null) goto L6;
        com.obric.aikernel.res.metadata.data.b r4 = r3.a();     // Catch: Throwable -> L15
    L7:
        r0.e("VlmLocalVersionConstrict", r2.append(r4).toString());     // Catch: Throwable -> L15
        if (r6 != null) goto L11;
        f6059b = null;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L11:
        if (f6059b != null) goto L13;
        f6059b = new a(r6);     // Catch: Throwable -> L15
        goto L13
    L6:
        r4 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean a() {
        monitor-enter(this);
        a r0 = f6059b;     // Catch: Throwable -> L17
        boolean r1 = false;
        if (r0 == null) goto L14;
        com.obric.aikernel.res.metadata.data.b r2 = r0.a();     // Catch: Throwable -> L17
        if (r2 == null) goto L14;
        PackageResourceManager.PresmConfig r3 = r2.u();     // Catch: Throwable -> L17
        if (r3 == null) goto L14;
        Function0<Boolean> r4 = r3.isInferProcess();     // Catch: Throwable -> L17
        if (r4 == null) goto L14;
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L14;
        r1 = true;
    L14:
        boolean r5 = !r1;
        monitor-exit(this);
        return r5;
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, ActivityLifecycle.NAME);
        return Intrinsics.areEqual(r1, "vlm_local");
    }

    public final com.obric.aikernel.res.metadata.data.b b() {
        a r0 = f6059b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b();
    }

    public final synchronized boolean b(com.obric.aikernel.res.metadata.data.b r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "pkg");     // Catch: Throwable -> L24
        boolean r1 = true;
        if (a(r5.s()) == true) goto L6;
    L21:
        r1 = false;
    L22:
        monitor-exit(this);
        return r1;
    L6:
        if (Intrinsics.areEqual(r5.t(), "debug") == true) goto L21;
        a r0 = f6059b;     // Catch: Throwable -> L24
        if (r0 == null) goto L21;
        com.obric.aikernel.res.metadata.data.b r2 = r0.a();     // Catch: Throwable -> L24
        if (r2 == null) goto L21;
        if (Intrinsics.areEqual(r5.t(), r2.t()) == false) goto L18;
        if (r2.d() == false) goto L18;
        boolean r6 = false;
    L19:
        if (r6 != true) goto L21;
    L18:
        r6 = true;
    L24:
        th = move-exception;
        throw th;
    }
}
