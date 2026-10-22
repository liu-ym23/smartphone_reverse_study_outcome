package okio;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 2}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0000J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokio/Segment;", "", "()V", "data", "", "pos", "", "limit", "shared", "", "owner", "([BIIZZ)V", "next", "prev", "compact", "", "pop", "push", "segment", "sharedCopy", "split", "byteCount", "unsharedCopy", "writeTo", "sink", "Companion", "jvm"}, k = 1, mv = {1, 1, 11})
public final class Segment {
    public static final Companion Companion = null;
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokio/Segment$Companion;", "", "()V", "SHARE_MINIMUM", "", "SIZE", "jvm"}, k = 1, mv = {1, 1, 11})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public Segment(byte[] r2, int r3, int r4, boolean r5, boolean r6) {
        Intrinsics.checkParameterIsNotNull(r2, "data");
        this.data = r2;
        this.pos = r3;
        this.limit = r4;
        this.shared = r5;
        this.owner = r6;
    }

    public final void compact() {
        int r3 = 0;
        if (this.prev == ((Segment) ZeusTransformUtils.preCheckCast(this, Segment.class, "com.obric.memorydata.plugin"))) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L35;
        Segment r1 = this.prev;
        if (r1 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        if (r1.owner == true) goto L13;
        return;
    L13:
        int r2 = this.limit - this.pos;
        Segment r4 = this.prev;
        if (r4 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        int r5 = 8192 - r4.limit;
        Segment r6 = this.prev;
        if (r6 != null) goto L20;
        Intrinsics.throwNpe();
    L20:
        if (r6.shared == true) goto L27;
        Segment r7 = this.prev;
        if (r7 != null) goto L25;
        Intrinsics.throwNpe();
    L25:
        r3 = r7.pos;
    L27:
        if (r2 <= (r5 + r3)) goto L29;
        return;
    L29:
        Segment r8 = this.prev;
        if (r8 != null) goto L32;
        Intrinsics.throwNpe();
    L32:
        writeTo(r8, r2);
        pop();
        SegmentPool.recycle(this);
        return;
    L35:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("cannot compact".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        r0 = false;
        goto L6
    }

    public final Segment pop() {
        if (this.next == ((Segment) ZeusTransformUtils.preCheckCast(this, Segment.class, "com.obric.memorydata.plugin"))) goto L5;
        Segment r1 = this.next;
    L6:
        Segment r3 = this.prev;
        if (r3 != null) goto L9;
        Intrinsics.throwNpe();
    L9:
        r3.next = this.next;
        Segment r4 = this.next;
        if (r4 != null) goto L12;
        Intrinsics.throwNpe();
    L12:
        r4.prev = this.prev;
        this.next = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");
        this.prev = (Segment) ZeusTransformUtils.preCheckCast(null, Segment.class, "com.obric.memorydata.plugin");
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public final Segment push(Segment r3) {
        Intrinsics.checkParameterIsNotNull(r3, "segment");
        r3.prev = (Segment) ZeusTransformUtils.preCheckCast(this, Segment.class, "com.obric.memorydata.plugin");
        r3.next = this.next;
        Segment r0 = this.next;
        if (r0 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        r0.prev = r3;
        this.next = r3;
        return r3;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int r6) {
        if (r6 > 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L19;
        if (r6 < 1024) goto L12;
        Segment r0 = sharedCopy();
    L13:
        r0.limit = r0.pos + r6;
        this.pos += r6;
        Segment r5 = this.prev;
        if (r5 != null) goto L16;
        Intrinsics.throwNpe();
    L16:
        r5.push(r0);
        return r0;
    L12:
        Segment r2 = SegmentPool.take();
        Platform.arraycopy(this.data, this.pos, r2.data, 0, r6);
        r0 = r2;
        goto L13
    L19:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException("byteCount out of range".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    L5:
        if (r6 > (this.limit - this.pos)) goto L7;
        r1 = true;
        goto L8
    }

    public final Segment unsharedCopy() {
        byte[] r0 = this.data;
        byte[] r1 = Arrays.copyOf(r0, r0.length);
        Intrinsics.checkExpressionValueIsNotNull(r1, "java.util.Arrays.copyOf(this, size)");
        return new Segment(r1, this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment r6, int r7) {
        Intrinsics.checkParameterIsNotNull(r6, "sink");
        if (r6.owner == false) goto L18;
        int r0 = r6.limit;
        if ((r0 + r7) > 8192) goto L7;
    L15:
        Platform.arraycopy(this.data, this.pos, r6.data, r6.limit, r7);
        r6.limit += r7;
        this.pos += r7;
        return;
    L7:
        if (r6.shared == true) goto L14;
        int r4 = r6.pos;
        if (((r0 + r7) - r4) > 8192) goto L12;
        byte[] r1 = r6.data;
        Platform.arraycopy(r1, r4, r1, 0, r0 - r4);
        r6.limit -= r6.pos;
        r6.pos = 0;
        goto L15
    L12:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(), Throwable.class, "com.obric.memorydata.plugin"));
    L14:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalArgumentException(), Throwable.class, "com.obric.memorydata.plugin"));
    L18:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(new IllegalStateException("only owner can write".toString()), Throwable.class, "com.obric.memorydata.plugin"));
    }
}
