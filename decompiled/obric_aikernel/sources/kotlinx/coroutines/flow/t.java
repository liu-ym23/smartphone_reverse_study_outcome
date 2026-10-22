package kotlinx.coroutines.flow;

import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class t {
    public static final <T> c<T> a(c<? extends T> r10, int r11, BufferOverflow r12) {
        boolean r13 = true;
        if (r11 < 0) goto L5;
    L9:
        boolean r14 = true;
    L10:
        if (r14 == false) goto L28;
        if (r11 == (-1)) goto L13;
    L16:
        if (r13 == false) goto L26;
        if (r11 != (-1)) goto L19;
        BufferOverflow r15 = BufferOverflow.DROP_OLDEST;
        int r16 = 0;
    L21:
        if ((r10 instanceof kotlinx.coroutines.flow.internal.k) == false) goto L24;
        return kotlinx.coroutines.flow.internal.k.a.a((kotlinx.coroutines.flow.internal.k) r10, null, r16, r15, 1, null);
    L24:
        return new kotlinx.coroutines.flow.internal.f(r10, null, r16, r15, 2, null);
    L19:
        r16 = r11;
        r15 = r12;
        goto L21
    L26:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    L13:
        if (r12 == BufferOverflow.SUSPEND) goto L16;
        r13 = false;
        goto L16
    L28:
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + r11).toString());
    L5:
        if (r11 == (-2)) goto L9;
        if (r11 == (-1)) goto L9;
        r14 = false;
        goto L10
    }

    public static /* synthetic */ c b(c r10, int r11, BufferOverflow r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = -2;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = BufferOverflow.SUSPEND;
    L9:
        return e.b(r10, r11, r12);
    }
}
