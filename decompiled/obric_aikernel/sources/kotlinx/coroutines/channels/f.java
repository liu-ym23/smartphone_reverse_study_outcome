package kotlinx.coroutines.channels;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final <E> d<E> a(int r10, BufferOverflow r11, Function1<? super E, Unit> r12) {
        if (r10 == (-2)) goto L27;
        boolean r13 = false;
        if (r10 == (-1)) goto L20;
        if (r10 == 0) goto L15;
        if (r10 == Integer.MAX_VALUE) goto L32;
        if (r11 != BufferOverflow.SUSPEND) goto L31;
        return new BufferedChannel(r10, r12);
    L31:
        return new j(r10, r11, r12);
    L32:
        return new BufferedChannel(Integer.MAX_VALUE, r12);
    L15:
        if (r11 != BufferOverflow.SUSPEND) goto L17;
        d<E> r14 = new BufferedChannel(0, r12);
    L33:
        return r14;
    L17:
        r14 = new j(1, r11, r12);
        goto L33
    L20:
        if (r11 != BufferOverflow.SUSPEND) goto L22;
        r13 = true;
    L22:
        if (r13 == false) goto L25;
        return new j(1, BufferOverflow.DROP_OLDEST, r12);
    L25:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    L27:
        if (r11 != BufferOverflow.SUSPEND) goto L29;
        r14 = new BufferedChannel(d.f10314f.a(), r12);
        goto L33
    L29:
        r14 = new j(1, r11, r12);
        goto L33
    }

    public static /* synthetic */ d b(int r10, BufferOverflow r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = BufferOverflow.SUSPEND;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = null;
    L12:
        return a(r10, r11, r12);
    }
}
