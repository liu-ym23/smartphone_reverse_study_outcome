package com.obric.search.api.a;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.CrashBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016JT\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f\u0018\u00010\u000e2\u001a\u0010\u0010\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u000f\u0018\u00010\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\"\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016¨\u0006\u0019"}, d2 = {"Lcom/obric/search/api/config/SQLiteTrace;", "", "onConnectionObtained", "", "sql", "", "waitTime", "", "isPrimary", "", "onConnectionPoolBusy", "sqlWaiting", "wantPrimaryConnection", "sqlRunning", "", "Lcom/obric/search/api/config/SQLiteTrace$TraceInfo;", "longLastingActions", "", "Ljava/lang/StackTraceElement;", "onDatabaseCorrupted", "onSQLExecuted", "type", "", OaidModel.KEY_TIME, "TraceInfo", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface c {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        public static void a(c r0, String r1, int r2, long r3) {
            c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r0, c.class, "com.obric.memorydata.plugin");
        }

        public static void a(c r0, String r1, long r2, boolean r4) {
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r0, c.class, "com.obric.memorydata.plugin");
        }

        public static void a(c r0, String r1, long r2, boolean r4, List<b<String>> r5, List<b<StackTraceElement[]>> r6) {
            c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r0, c.class, "com.obric.memorydata.plugin");
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0010\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J2\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/search/api/config/SQLiteTrace$TraceInfo;", ExifInterface.GPS_DIRECTION_TRUE, "", "info", OaidModel.KEY_TIME, "", CrashBody.TID, "", "(Ljava/lang/Object;JI)V", "getInfo", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTid", "()I", "getTime", "()J", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;JI)Lcom/obric/search/api/config/SQLiteTrace$TraceInfo;", "equals", "", "other", "hashCode", "toString", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f14926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f14927b;
        private final int c;

        public b(T r1, long r2, int r4) {
            this.f14926a = r1;
            this.f14927b = r2;
            this.c = r4;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f14926a, r10.f14926a) == true) goto L12;
            return false;
        L12:
            if (this.f14927b == r10.f14927b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            T r0 = this.f14926a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((r1 * 31) + Long.hashCode(this.f14927b)) * 31) + Integer.hashCode(this.c);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "TraceInfo(info=" + this.f14926a + ", time=" + this.f14927b + ", tid=" + this.c + ')';
        }
    }

    void a();

    void a(String r1, int r2, long r3);

    void a(String r1, long r2, boolean r4);

    void a(String r1, long r2, boolean r4, List<b<String>> r5, List<b<StackTraceElement[]>> r6);
}
