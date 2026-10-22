package com.obric.memorydata.database.index;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0081@\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/index/DurationMs;", "", EventBody.KEY_VALUE, "", "constructor-impl", "(J)J", "getValue", "()J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9432a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9433b;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/index/DurationMs$Companion;", "", "<init>", "()V", "fromRawMs", "Lcom/obric/memorydata/database/index/DurationMs;", EventBody.KEY_VALUE, "", "fromRawMs--U2HUHs", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final q a(long r5) {
            Long r4 = Long.valueOf(r5);
            if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue() < 0) goto L5;
            boolean r6 = true;
        L7:
            if (r6 == true) goto L10;
            r4 = null;
        L10:
            if (r4 != null) goto L12;
            return null;
        L12:
            return q.c(q.d(((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue()));
        L5:
            r6 = false;
            goto L7
        }
    }

    static {
        f9432a = new a(null);
    }

    private /* synthetic */ q(long r1) {
        this.f9433b = r1;
    }

    public static String a(long r2) {
        return "DurationMs(value=" + r2 + ')';
    }

    public static final boolean a(long r0, long r2) {
        if (r0 != r2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean a(long r3, Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, q.class) == true) goto L6;
        return false;
    L6:
        if (r3 == ((q) ZeusTransformUtils.preCheckCast(r5, q.class, "com.obric.memorydata.plugin")).a()) goto L8;
        return false;
    L8:
        return true;
    }

    public static int b(long r0) {
        return Long.hashCode(r0);
    }

    public static final /* synthetic */ q c(long r1) {
        return new q(r1);
    }

    public static final /* synthetic */ long d(long r0) {
        return e(r0);
    }

    private static long e(long r0) {
        return r0;
    }

    public final /* synthetic */ long a() {
        return this.f9433b;
    }

    public boolean equals(Object r3) {
        return a(this.f9433b, r3);
    }

    public int hashCode() {
        return b(this.f9433b);
    }

    public String toString() {
        return a(this.f9433b);
    }
}
