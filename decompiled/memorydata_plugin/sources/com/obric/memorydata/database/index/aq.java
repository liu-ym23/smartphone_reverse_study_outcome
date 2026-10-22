package com.obric.memorydata.database.index;

import androidx.exifinterface.media.ExifInterface;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ?\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0013¢\u0006\u0002\u0010\u0014J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bR\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/database/index/IndexSourceStartTime;", "", "<init>", "()V", "materializingSource", "Ljava/lang/ThreadLocal;", "Lcom/obric/memorydata/database/index/IndexSourceStartTime$Source;", "currentTimestamp", "", "entityType", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "entityId", "(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/Long;", "materialize", ExifInterface.GPS_DIRECTION_TRUE, "timestamp", "block", "Lkotlin/Function0;", "(ILjava/lang/String;Ljava/lang/String;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "resolve", "sourceTimestamp", "previousStartedAt", "nowMs", "Source", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aq f9375a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<a> f9376b = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/database/index/IndexSourceStartTime$Source;", "", "entityType", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "entityId", "timestamp", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;J)V", "getEntityType", "()I", "getPackageName", "()Ljava/lang/String;", "getEntityId", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f9377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9378b;
        private final String c;
        private final long d;

        public a(int r2, String r3, String r4, long r5) {
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Intrinsics.checkNotNullParameter(r4, "entityId");
            this.f9377a = r2;
            this.f9378b = r3;
            this.c = r4;
            this.d = r5;
        }

        public final int a() {
            return this.f9377a;
        }

        public final String b() {
            return this.f9378b;
        }

        public final String c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (this.f9377a == r8.f9377a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f9378b, r8.f9378b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r8.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f9377a) * 31) + this.f9378b.hashCode()) * 31) + this.c.hashCode()) * 31) + Long.hashCode(this.d);
        }

        public String toString() {
            return "Source(entityType=" + this.f9377a + ", packageName=" + this.f9378b + ", entityId=" + this.c + ", timestamp=" + this.d + ')';
        }
    }

    static {
        f9375a = new aq();
        f9376b = new ThreadLocal();
    }

    private aq() {
    }

    public static /* synthetic */ long a(aq r7, long r8, long r10, long r12, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r10 = 0;
    L6:
        return r7.a(r8, r10, r12);
    }

    public final long a(long r7, long r9, long r11) {
        Long r6 = Long.valueOf(r7);
        long r0 = ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue();
        boolean r4 = true;
        if (1 <= r0) goto L5;
    L7:
        boolean r8 = false;
    L8:
        Long r1 = null;
        if (r8 == true) goto L12;
        r6 = null;
    L12:
        if (r6 != null) goto L25;
        Long r10 = Long.valueOf(r9);
        long r12 = ((Number) ZeusTransformUtils.preCheckCast(r10, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (1 <= r12) goto L17;
    L19:
        r4 = false;
    L20:
        if (r4 == false) goto L22;
        r1 = r10;
    L22:
        if (r1 != null) goto L24;
        return r11;
    L24:
        return r1.longValue();
    L17:
        if (r12 > r11) goto L19;
    L25:
        return r6.longValue();
    L5:
        if (r0 > r11) goto L7;
        r8 = true;
        goto L8
    }

    public final Long a(int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r5, "entityId");
        a r2 = (a) ZeusTransformUtils.preCheckCast(f9376b.get(), a.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.a() == r3) goto L7;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == true) goto L15;
        r2 = null;
    L15:
        if (r2 != null) goto L17;
        return null;
    L17:
        return Long.valueOf(r2.d());
    L7:
        if (Intrinsics.areEqual(r2.b(), r4) == false) goto L11;
        if (Intrinsics.areEqual(r2.c(), r5) == false) goto L11;
        r6 = true;
        goto L12
    }

    public final <T> T a(int r9, String r10, String r11, long r12, Function0<? extends T> r14) {
        Function0 r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r14, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r11, "entityId");
        Intrinsics.checkNotNullParameter(r8, "block");
        ThreadLocal<a> r15 = f9376b;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r15.get(), a.class, "com.obric.memorydata.plugin");
        r15.set(new a(r9, r10, r11, r12));
        T r13 = (T) r8.invoke();
        if (r0 != null) goto L6;
        r15.remove();
    L7:
        return r13;
    L6:
        r15.set(r0);
    L8:
        th = move-exception;
        ThreadLocal<a> r16 = f9376b;
        if (r0 != null) goto L12;
        r16.remove();
    L13:
        throw th;
    L12:
        r16.set(r0);
        goto L13
    }
}
