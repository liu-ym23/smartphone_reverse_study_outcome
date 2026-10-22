package com.obric.aikernel.runtime.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/obric/aikernel/runtime/utils/NetworkStateStore;", "", "()V", "networkChanges", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getNetworkChanges", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "networkSnapshot", "Lcom/obric/aikernel/runtime/utils/NetworkStateStore$Snapshot;", "getNetworkSnapshot", com.obric.memorydata.BuildConfig.CHANNEL, "", "snapshot", "Snapshot", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f6221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ae<a> f6222b = null;
    private static final ae<Boolean> c = null;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J'\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/aikernel/runtime/utils/NetworkStateStore$Snapshot;", "", "hasInternet", "", "hasValidatedInternet", "isUnmetered", "(ZZZ)V", "getHasInternet", "()Z", "getHasValidatedInternet", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "pyvm_utils_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f6223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f6224b;
        private final boolean c;

        public a() {
            this(false, false, false, 7, null);
        }

        public a(boolean r1, boolean r2, boolean r3) {
            this.f6223a = r1;
            this.f6224b = r2;
            this.c = r3;
        }

        public /* synthetic */ a(boolean r2, boolean r3, boolean r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = false;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = false;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = false;
        L11:
            this(r2, r3, r4);
        }

        public final boolean a() {
            return this.f6224b;
        }

        public final boolean b() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f6223a == r6.f6223a) goto L12;
            return false;
        L12:
            if (this.f6224b == r6.f6224b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3 */
        public int hashCode() {
            boolean r0 = this.f6223a;
            ?? r1 = 1;
            ?? r2 = r0;
            if (r0 == false) goto L5;
            r2 = 1;
        L5:
            int r3 = r2 * 31;
            boolean r4 = this.f6224b;
            ?? r5 = r4;
            if (r4 == false) goto L8;
            r5 = 1;
        L8:
            int r6 = (r3 + r5) * 31;
            boolean r7 = this.c;
            if (r7 == true) goto L13;
            r1 = r7;
        L13:
            return r6 + r1;
        }

        public String toString() {
            return "Snapshot(hasInternet=" + this.f6223a + ", hasValidatedInternet=" + this.f6224b + ", isUnmetered=" + this.c + ')';
        }
    }

    static {
        f6221a = new g();
        f6222b = at.a(new a(false, false, false, 7, null));
        c = at.a(false);
    }

    private g() {
    }

    public final ae<a> a() {
        return f6222b;
    }

    public final void update(a r1) {
        Intrinsics.checkNotNullParameter(r1, "snapshot");
        f6222b.b(r1);
        c.b(Boolean.valueOf(r1.a()));
    }
}
