package com.obric.aikernel.res.metadata.data;

import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nH\u0002J\r\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0011J\u001e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\nJ(\u0010\u0013\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\nJ(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\nJ+\u0010\u0017\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u00182\u0006\u0010\f\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001aH\u0000¢\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/ModelMd5CheckCache;", "", "()V", "verificationLockRegistry", "verificationLocks", "", "", "Lcom/obric/aikernel/res/metadata/data/ModelMd5CheckCache$VerificationLock;", "verifiedAtMs", "Ljava/util/concurrent/ConcurrentHashMap;", "", "cacheKey", "path", "md5", "size", "clear", "", "clear$resource_manager_release", "invalidate", "recordSuccess", "nowMs", "shouldUseFastMode", "", "withVerificationLock", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "withVerificationLock$resource_manager_release", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "VerificationLock", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f6092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f6093b = null;
    private static final Object c = null;
    private static final Map<String, a> d = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/aikernel/res/metadata/data/ModelMd5CheckCache$VerificationLock;", "", "()V", CommonConsts.LOG_REPORT_TYPE_DEFAULT, "getMonitor", "()Ljava/lang/Object;", "references", "", "getReferences", "()I", "setReferences", "(I)V", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f6094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6095b;

        public a() {
            this.f6094a = new Object();
        }

        public final Object a() {
            return this.f6094a;
        }

        public final void a(int r1) {
            this.f6095b = r1;
        }

        public final int b() {
            return this.f6095b;
        }
    }

    static {
        f6092a = new g();
        f6093b = new ConcurrentHashMap();
        c = new Object();
        d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private g() {
    }

    public static /* synthetic */ boolean a(g r7, String r8, String r9, long r10, long r12, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L6;
        r12 = SystemClock.elapsedRealtime();
    L6:
        return r7.a(r8, r9, r10, r12);
    }

    private final String b(String r1, String r2, long r3) {
        return r1 + 0 + r2 + 0 + r3;
    }

    public static /* synthetic */ void b(g r7, String r8, String r9, long r10, long r12, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r12 = SystemClock.elapsedRealtime();
    L5:
        r7.b(r8, r9, r10, r12);
    }

    public final <T> T a(String r5, Function0<? extends T> r6) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r6, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "path");
        Intrinsics.checkNotNullParameter(r4, "block");
        Object r7 = c;
        monitor-enter(r7);
        Map<String, a> r0 = d;     // Catch: Throwable -> L42
        a r1 = r0.get(r5);     // Catch: Throwable -> L42
        if (r1 != null) goto L7;
        r1 = new a();     // Catch: Throwable -> L42
        r0.put(r5, r1);     // Catch: Throwable -> L42
    L7:
        a r2 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        r2.a(r2.b() + 1);     // Catch: Throwable -> L42
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        monitor-exit(r7);
        Object r8 = r3.a();     // Catch: Throwable -> L28
        monitor-enter(r8);     // Catch: Throwable -> L28
        T r9 = (T) r4.invoke();
        monitor-exit(r8);     // Catch: Throwable -> L28
        monitor-enter(r7);
        r3.a(r3.b() - 1);     // Catch: Throwable -> L22
        if (r3.b() == 0) goto L17;
    L19:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r7);
        return r9;
    L17:
        if (r0.get(r5) != r3) goto L19;
        r0.remove(r5);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        monitor-enter(c);
        r3.a(r3.b() - 1);     // Catch: Throwable -> L39
        if (r3.b() != 0) goto L36;
        Map<String, a> r11 = d;     // Catch: Throwable -> L39
        if (r11.get(r5) != r3) goto L36;
        r11.remove(r5);     // Catch: Throwable -> L39
    L36:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L39
        throw th;
    L39:
        th = move-exception;
        throw th;
    L42:
        th = move-exception;
        throw th;
    }

    public final void a(String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "md5");
        f6093b.remove(b(r2, r3, r4));
    }

    public final boolean a(String r2, String r3, long r4, long r6) {
        Intrinsics.checkNotNullParameter(r2, "path");
        Intrinsics.checkNotNullParameter(r3, "md5");
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(f6093b.get(b(r2, r3, r4)), Long.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return false;
    L5:
        long r7 = r6 - ((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue();
        if (0 <= r7) goto L8;
        return false;
    L8:
        if (r7 >= ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS) goto L12;
        return true;
    L12:
        return false;
    }

    public final void b(String r3, String r4, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r3, "path");
        Intrinsics.checkNotNullParameter(r4, "md5");
        Long r8 = Long.valueOf(r7);
        ((Map) ZeusTransformUtils.preCheckCast(f6093b, Map.class, "com.obric.memorydata.plugin")).put(b(r3, r4, r5), r8);
    }
}
