package eo8;

import androidx.fragment.app.Fragment;
import com.larus.im.bean.message.Message;
import kc8.e0;
import kc8.n;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ro8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b implements a {
    public final Fragment a;
    public final Function0<Boolean> b;
    public final Function0<Long> c;
    public final Function0<Unit> d;
    public final Function0<Unit> e;
    public final Function1<Message, Unit> f;
    public final n g;
    public final e0 h;
    public final Function0<String> i;
    public final Function0<String> j;

    public b() {
        throw null;
    }

    @Override // eo8.a
    public final long O() {
        Function0<Long> r0 = this.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return ((Number) r0.invoke()).longValue();
    }

    @Override // eo8.a
    public final boolean W() {
        Function0<Boolean> r0 = this.b;
        if (r0 != null) goto L7;
        return false;
    L7:
        return ((Boolean) r0.invoke()).booleanValue();
    }

    @Override // eo8.a
    public final String Z0() {
        Function0<String> r0 = this.j;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (String) r0.invoke();
    }

    @Override // eo8.a
    public final void a() {
        Function0<Unit> r0 = this.d;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    @Override // eo8.a
    public final String m() {
        Function0<String> r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (String) r0.invoke();
    }

    @Override // eo8.a
    public final void n2() {
        Function0<Unit> r0 = this.e;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    @Override // eo8.a
    public final Fragment o2() {
        return this.a;
    }

    @Override // eo8.a
    public final e0 p2() {
        return this.h;
    }

    @Override // eo8.a
    public final n q2() {
        return this.g;
    }

    @Override // eo8.a
    public final void r2(Message r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Function1<Message, Unit> r0 = this.f;
        if (r0 == null) goto L6;
        r0.invoke(r2);
        return;
    }

    public b(Fragment r3, Function0 r4, Function0 r5, d r6, Function0 r7, Function1 r8, n r9, e0 r10, Function0 r11, Function0 r12, int r13) {
        if ((r13 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r13 & 8) == 0) goto L9;
        r5 = null;
    L9:
        if ((r13 & 16) == 0) goto L12;
        r6 = null;
    L12:
        if ((r13 & 32) == 0) goto L15;
        r7 = null;
    L15:
        if ((r13 & 64) == 0) goto L18;
        r8 = null;
    L18:
        if ((r13 & 128) == 0) goto L21;
        r9 = null;
    L21:
        if ((r13 & 256) == 0) goto L24;
        r10 = null;
    L24:
        if ((r13 & 512) == 0) goto L27;
        r11 = null;
    L27:
        if ((r13 & 1024) == 0) goto L29;
        r12 = null;
    L29:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
    }
}
