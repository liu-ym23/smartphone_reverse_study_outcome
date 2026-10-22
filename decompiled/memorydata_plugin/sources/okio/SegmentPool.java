package okio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0007J\b\u0010\u000b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lokio/SegmentPool;", "", "()V", "MAX_SIZE", "", "byteCount", "next", "Lokio/Segment;", "recycle", "", "segment", "take", "jvm"}, k = 1, mv = {1, 1, 11})
public final class SegmentPool {
    public static final SegmentPool INSTANCE = null;
    public static final long MAX_SIZE = 65536;
    public static long byteCount;
    public static Segment next;

    static {
        INSTANCE = new SegmentPool();
    }

    private SegmentPool() {
    }

    @JvmStatic
    public static final void recycle(Segment r10) {
        Intrinsics.checkParameterIsNotNull(r10, "segment");
        if (r10.next == null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L27;
        if (r10.shared == false) goto L12;
        return;
    L12:
        SegmentPool r1 = INSTANCE;
        monitor-enter(r1);
        long r2 = byteCount;     // Catch: Throwable -> L23
        long r4 = 8192;
        if ((r2 + r4) <= 65536) goto L20;
        monitor-exit(r1);
        return;
    L20:
        byteCount = r2 + r4;     // Catch: Throwable -> L23
        r10.next = next;     // Catch: Throwable -> L23
        r10.limit = 0;     // Catch: Throwable -> L23
        r10.pos = r10.limit;     // Catch: Throwable -> L23
        next = r10;     // Catch: Throwable -> L23
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r1);
        return;
    L23:
        th = move-exception;
        throw th;
    L27:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("Failed requirement.".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        if (r10.prev != null) goto L7;
        r0 = true;
        goto L8
    }

    @JvmStatic
    public static final Segment take() {
        SegmentPool r0 = INSTANCE;
        monitor-enter(r0);
        Segment r1 = next;     // Catch: Throwable -> L12
        if (r1 == null) goto L9;
        next = r1.next;     // Catch: Throwable -> L12
        r1.next = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        byteCount -= (long) 8192;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return r1;
    L9:
        monitor-exit(r0);
        return new Segment();
    L12:
        th = move-exception;
        throw th;
    }
}
