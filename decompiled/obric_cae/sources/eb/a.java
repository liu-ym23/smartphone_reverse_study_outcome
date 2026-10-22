package eb;

import db.d;
import ge.p;
import he.i;
import he.j;
import java.util.ArrayList;
import ya.b;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends j implements p<Boolean, Throwable, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f7212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f7213b;

    public a(d r8) {
        this.f7212a = null;
        this.f7213b = r8;
        super(2);
    }

    @Override // ge.p
    public final xd.j invoke(Boolean r8, Throwable r10) {
        boolean r11 = r8.booleanValue();
        Throwable r12 = r10;
        p r13 = this.f7212a;
        if (r13 == null) goto L5;
        xd.j r14 = (xd.j) r13.invoke(Boolean.valueOf(r11), r12);
    L5:
        ArrayList<d> r15 = b.f14104a;
        d r16 = this.f7213b;
        i.f(r16, "animationManager");
        ArrayList<d> r17 = b.f14104a;
        r17.remove(r16);
        mb.a.e("removeAnimationManager, size: " + r17.size());
        return xd.j.f13877a;
    }
}
