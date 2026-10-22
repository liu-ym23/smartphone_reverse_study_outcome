package com.obric.memorydata.personalcontext;

import android.os.SystemClock;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\f\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0012J\f\u0010\u0015\u001a\u00020\u0012*\u00020\u0012H\u0002J\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/personalcontext/NotificationIngestFilter;", "", "<init>", "()V", "DEDUP_WINDOW_MS", "", "DEDUP_CACHE_MAX", "", "PREFIX_SIMILARITY_THRESHOLD", "", "MAX_FINGERPRINT_LEN", "cache", "com/obric/memorydata/personalcontext/NotificationIngestFilter$cache$1", "Lcom/obric/memorydata/personalcontext/NotificationIngestFilter$cache$1;", "lock", "shouldAccept", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "title", Params.CONTENT, "truncate", "isInDedupWindow", "Lcom/obric/memorydata/personalcontext/NotificationIngestFilter$Fingerprint;", "now", "isSameOrSimilar", "prev", "current", "Fingerprint", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f12240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final NotificationIngestFilter$cache$1 f12241b = null;
    private static final Object c = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/personalcontext/NotificationIngestFilter$Fingerprint;", "", "title", "", Params.CONTENT, "timestampMs", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getTitle", "()Ljava/lang/String;", "getContent", "getTimestampMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12243b;
        private final long c;

        public a(String r2, String r3, long r4) {
            Intrinsics.checkNotNullParameter(r2, "title");
            Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
            this.f12242a = r2;
            this.f12243b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f12242a;
        }

        public final String b() {
            return this.f12243b;
        }

        public final long c() {
            return this.c;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12242a, r8.f12242a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12243b, r8.f12243b) == true) goto L15;
            return false;
        L15:
            if (this.c == r8.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f12242a.hashCode() * 31) + this.f12243b.hashCode()) * 31) + Long.hashCode(this.c);
        }

        public String toString() {
            return "Fingerprint(title=" + this.f12242a + ", content=" + this.f12243b + ", timestampMs=" + this.c + ')';
        }
    }

    static {
        f12240a = new p();
        f12241b = new NotificationIngestFilter$cache$1();
        c = new Object();
    }

    private p() {
    }

    private final String a(String r2) {
        if (r2.length() <= 128) goto L7;
        String r3 = r2.substring(0, 128);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        return r3;
    L7:
        return r2;
    }

    private final boolean a(a r1, long r2) {
        if ((r2 - r1.c()) >= 5000) goto L5;
        return true;
    L5:
        return false;
    }

    private final boolean a(String r6, String r7) {
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
    L26:
        return false;
    L8:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L10;
        boolean r8 = true;
    L11:
        if (r8 == true) goto L26;
        if (Intrinsics.areEqual(r6, r7) == false) goto L16;
        return true;
    L16:
        int r9 = Math.min(r6.length(), r7.length());
        int r0 = 0;
    L17:
        if (r0 >= r9) goto L22;
        if (r6.charAt(r0) != r7.charAt(r0)) goto L22;
        r0 = r0 + 1;
    L22:
        if ((((double) r0) / ((double) r9)) < 0.8d) goto L25;
        return true;
    L25:
        return false;
    L10:
        r8 = false;
        goto L11
    L5:
        r5 = false;
        goto L6
    }

    public final boolean a(String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (r9 != null) goto L5;
        r9 = "";
    L5:
        String r11 = a(r9);
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        String r7 = a(r10);
        long r0 = SystemClock.elapsedRealtime();
        Object r12 = c;
        monitor-enter(r12);
        NotificationIngestFilter$cache$1 r2 = f12241b;     // Catch: Throwable -> L24
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.get(r8), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r3 == null) goto L19;
        p r5 = f12240a;     // Catch: Throwable -> L24
        if (r5.a(r3, r0) == false) goto L19;
        if (r5.a(r3.a(), r11) == false) goto L17;
    L18:
        boolean r4 = true;
    L20:
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin")).put(r8, new a(r11, r7, r0));     // Catch: Throwable -> L24
        boolean r13 = !r4;
        monitor-exit(r12);
        return r13;
    L17:
        if (r5.a(r3.b(), r7) == true) goto L18;
    L19:
        r4 = false;
    L24:
        th = move-exception;
        throw th;
    }
}
