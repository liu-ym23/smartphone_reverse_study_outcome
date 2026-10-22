package com.obric.memorydata.middleware.api.store;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005J \u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005J5\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/middleware/api/store/AccountScopedStoreMigration;", "", "<init>", "()V", "readBoolean", "", "personalStore", "Lcom/obric/memorydata/middleware/api/store/IStore;", "legacyStore", "key", "", "defaultValue", "saveBoolean", EventBody.KEY_VALUE, "resolveBooleanRead", "Lcom/obric/memorydata/middleware/api/store/AccountScopedStoreMigration$BooleanReadDecision;", "personalContains", "personalValue", "legacyContains", "legacyValue", "resolveBooleanRead$middleware_api_obricRelease", "BooleanReadDecision", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11639a = null;

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.api.store.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/middleware/api/store/AccountScopedStoreMigration$BooleanReadDecision;", "", EventBody.KEY_VALUE, "", "copyLegacyToPersonal", "removeLegacy", "<init>", "(ZZZ)V", "getValue", "()Z", "getCopyLegacyToPersonal", "getRemoveLegacy", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0622a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f11640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f11641b;
        private final boolean c;

        public C0622a(boolean r1, boolean r2, boolean r3) {
            this.f11640a = r1;
            this.f11641b = r2;
            this.c = r3;
        }

        public final boolean a() {
            return this.f11640a;
        }

        public final boolean b() {
            return this.f11641b;
        }

        public final boolean c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0622a.class) == true) goto L8;
            return false;
        L8:
            C0622a r6 = (C0622a) ZeusTransformUtils.preCheckCast(r5, C0622a.class, "com.obric.memorydata.plugin");
            if (this.f11640a == r6.f11640a) goto L12;
            return false;
        L12:
            if (this.f11641b == r6.f11641b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f11640a) * 31) + Boolean.hashCode(this.f11641b)) * 31) + Boolean.hashCode(this.c);
        }

        public String toString() {
            return "BooleanReadDecision(value=" + this.f11640a + ", copyLegacyToPersonal=" + this.f11641b + ", removeLegacy=" + this.c + ')';
        }
    }

    static {
        f11639a = new a();
    }

    private a() {
    }

    public final C0622a a(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5) {
        if (r1 == false) goto L6;
        return new C0622a(r2, false, r3);
    L6:
        if (r3 == false) goto L9;
        return new C0622a(r4, true, true);
    L9:
        return new C0622a(r5, false, false);
    }

    public final synchronized boolean a(IStore r8, IStore r9, String r10, boolean r11) {
        monitor-enter(this);
        IStore r12 = (IStore) ZeusTransformUtils.wrapperContextForParams(r8, IStore.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        IStore r13 = (IStore) ZeusTransformUtils.wrapperContextForParams(r9, IStore.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r13, "legacyStore");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r10, "key");     // Catch: Throwable -> L16
        if (r12 != null) goto L7;
        monitor-exit(this);
        return r11;
    L7:
        C0622a r14 = a(r12.contains(r10), r12.getBoolean(r10, r11), r13.contains(r10), r13.getBoolean(r10, r11), r11);     // Catch: Throwable -> L16
        if (r14.b() == false) goto L11;
        r12.save(r10, r14.a());     // Catch: Throwable -> L16
    L11:
        if (r14.c() == false) goto L13;
        r13.remove(new String[]{r10});     // Catch: Throwable -> L16
    L13:
        boolean r15 = r14.a();     // Catch: Throwable -> L16
        monitor-exit(this);
        return r15;
    L16:
        th = move-exception;
        throw th;
    }

    public final boolean a(IStore r2, String r3, boolean r4) {
        IStore r1 = (IStore) ZeusTransformUtils.wrapperContextForParams(r2, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "key");
        if (r1 != null) goto L6;
        return false;
    L6:
        r1.save(r3, r4);
        return true;
    }
}
