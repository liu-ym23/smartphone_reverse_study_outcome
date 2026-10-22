package t;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class g extends f {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12180m;

    public g(p r8) {
        super(r8);
        if ((r8 instanceof l) == false) goto L5;
        f.a r10 = f.a.f12172b;
    L6:
        this.f12163e = r10;
        return;
    L5:
        r10 = f.a.f12173m;
        goto L6
    }

    @Override // t.f
    public final void d(int r8) {
        if (this.f12168j == false) goto L5;
        return;
    L5:
        this.f12168j = true;
        this.f12165g = r8;
        Iterator r10 = this.f12169k.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        d r11 = (d) r10.next();
        r11.a(r11);
        goto L7
    }
}
