package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a0\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t\u001a6\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000b\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a#\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015\u001a+\u0010\u0016\u001a\u00020\u0017*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0019\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"NO_VALUE", "Lkotlinx/coroutines/internal/Symbol;", "MutableSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", ExifInterface.GPS_DIRECTION_TRUE, "replay", "", "extraBufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "fuseSharedFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharedFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getBufferAt", "", "", "index", "", "([Ljava/lang/Object;J)Ljava/lang/Object;", "setBufferAt", "", "item", "([Ljava/lang/Object;JLjava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.aj f17417a = null;

    static {
        f17417a = new kotlinx.coroutines.internal.aj("NO_VALUE");
    }

    public static final /* synthetic */ Object a(Object[] r0, long r1) {
        return b(r0, r1);
    }

    public static final <T> ad<T> a(int r3, int r4, BufferOverflow r5) {
        boolean r0 = true;
        if (r3 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L28;
        if (r4 < 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L26;
        if (r3 > 0) goto L17;
        if (r4 > 0) goto L17;
        if (r5 == BufferOverflow.SUSPEND) goto L17;
        r0 = false;
    L17:
        if (r0 == false) goto L24;
        int r7 = r4 + r3;
        if (r7 >= 0) goto L22;
        r7 = Integer.MAX_VALUE;
    L22:
        return (ad) ZeusTransformUtils.preCheckCast(new aj(r3, r7, r5), ad.class, "com.obric.memorydata.plugin");
    L24:
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + r5).toString());
    L26:
        throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + r4).toString());
    L9:
        r6 = false;
        goto L10
    L28:
        throw new IllegalArgumentException(("replay cannot be negative, but was " + r3).toString());
    L5:
        r2 = false;
        goto L6
    }

    public static /* synthetic */ ad a(int r1, int r2, BufferOverflow r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 0;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = BufferOverflow.SUSPEND;
    L12:
        return a(r1, r2, r3);
    }

    public static final <T> i<T> a(ai<? extends T> r3, CoroutineContext r4, int r5, BufferOverflow r6) {
        ai r7 = (ai) ZeusTransformUtils.wrapperContextForParams(r3, ai.class, "com.obric.memorydata.plugin");
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r4, CoroutineContext.class, "com.obric.memorydata.plugin");
        if (r5 == 0) goto L7;
        if (r5 == (-3)) goto L7;
    L11:
        Object r9 = ZeusTransformUtils.preCheckCast(new kotlinx.coroutines.flow.internal.h((i) ZeusTransformUtils.preCheckCast(r7, i.class, "com.obric.memorydata.plugin"), r8, r5, r6), i.class, "com.obric.memorydata.plugin");
    L10:
        return (i) r9;
    L7:
        if (r6 != BufferOverflow.SUSPEND) goto L11;
        r9 = ZeusTransformUtils.preCheckCast(r7, i.class, "com.obric.memorydata.plugin");
        goto L10
    }

    public static final /* synthetic */ void a(Object[] r0, long r1, Object r3) {
        b(r0, r1, r3);
    }

    private static final Object b(Object[] r0, long r1) {
        return r0[((int) r1) & (r0.length - 1)];
    }

    private static final void b(Object[] r0, long r1, Object r3) {
        r0[((int) r1) & (r0.length - 1)] = r3;
    }
}
