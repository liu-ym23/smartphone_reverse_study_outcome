package com.obric.memorydata.aikernelcore.bridge;

import android.os.Process;
import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019¢\u0006\u0002\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001c\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00050\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0005`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/aikernelcore/bridge/SqlCallTiming;", "", "<init>", "()V", "startMs", "", "threadId", "", "stages", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "failedStage", "rowCount", "getRowCount", "()I", "setRowCount", "(I)V", "resultChars", "getResultChars", "setResultChars", "measure", ExifInterface.GPS_DIRECTION_TRUE, "stage", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "elapsedMs", "summary", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f8476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8477b;
    private final LinkedHashMap<String, Long> c;
    private String d;
    private int e;
    private int f;

    public f() {
        this.f8476a = SystemClock.elapsedRealtime();
        this.f8477b = Process.myTid();
        this.c = new LinkedHashMap();
    }

    private static final CharSequence a(Map.Entry r4) {
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(((String) ZeusTransformUtils.preCheckCast(r5.getKey(), String.class, "com.obric.memorydata.plugin")) + '=' + ((Number) ZeusTransformUtils.preCheckCast(r5.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue(), CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ CharSequence lambda$xnTFNSlxk0VIx_DOeZ5xHuHZL1E(Map.Entry r0) {
        return a(r0);
    }

    public final long a() {
        return SystemClock.elapsedRealtime() - this.f8476a;
    }

    public final <T> T a(String r9, Function0<? extends T> r10) {
        Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r10, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "stage");
        Intrinsics.checkNotNullParameter(r11, "block");
        long r2 = SystemClock.elapsedRealtime();
        long r4 = 0;
        T r12 = (T) r11.invoke();
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin");
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(this.c.get(r9), Long.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L7;
        r4 = r8.longValue();
    L7:
        r0.put(r9, Long.valueOf((r4 + SystemClock.elapsedRealtime()) - r2));
        return r12;
    L9:
        th = move-exception;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin");
        Long r3 = (Long) ZeusTransformUtils.preCheckCast(this.c.get(r9), Long.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
        r4 = r3.longValue();
    L13:
        r1.put(r9, Long.valueOf((r4 + SystemClock.elapsedRealtime()) - r2));
        if (this.d != null) goto L16;
        this.d = r9;
    L16:
        throw th;
    }

    public final void a(int r1) {
        this.e = r1;
    }

    public final String b() {
        long r0 = a();
        Collection<Long> r2 = this.c.values();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-values>(...)");
        long r1 = RangesKt.coerceAtLeast(r0 - CollectionsKt.sumOfLong((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), 0);
        StringBuilder r3 = new StringBuilder().append("threadId=").append(this.f8477b).append(" rows=").append(this.e).append(" resultChars=").append(this.f).append(" failedStage=");
        String r4 = this.d;
        if (r4 != null) goto L5;
        r4 = "none";
    L5:
        StringBuilder r5 = r3.append(r4).append(' ');
        Set<Map.Entry<String, Long>> r14 = this.c.entrySet();
        Intrinsics.checkNotNullExpressionValue(r14, "<get-entries>(...)");
        return r5.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$f$xnTFNSlxk0VIx_DOeZ5xHuHZL1E.INSTANCE, 30, null)).append(" otherMs=").append(r1).toString();
    }

    public final void b(int r1) {
        this.f = r1;
    }
}
