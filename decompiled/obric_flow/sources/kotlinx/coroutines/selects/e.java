package kotlinx.coroutines.selects;

import kotlin.Function;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.internal.s;
import kotlinx.coroutines.t0;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function3 f19000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3 f19001c;
    public final g8.g d;
    public final Function e;
    public final Function3 f;
    public Object g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f19002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ f f19003i;

    public e(f r5, Object r10, Function3 r11, Function3 r12, g8.g r13, Function r14, Function3 r15) {
        this.f19003i = r5;
        this.f18999a = r10;
        this.f19000b = r11;
        this.f19001c = r12;
        this.d = r13;
        this.e = r14;
        this.f = r15;
        this.f19002h = -1;
    }

    public final void a() {
        Object r5 = this.g;
        if ((r5 instanceof s) == false) goto L6;
        ((s) r5).h(this.f19002h, this.f19003i.f19004a);
        return;
    L6:
        if ((r5 instanceof t0) == false) goto L8;
        t0 r10 = (t0) r5;
    L9:
        if (r10 == null) goto L13;
        r10.dispose();
        return;
    L13:
        return;
    L8:
        r10 = null;
        goto L9
    }
}
