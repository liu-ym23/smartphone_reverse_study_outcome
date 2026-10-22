package p;

import java.util.List;
import l.f;
import l.l;

/* JADX INFO: loaded from: classes.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f21309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f21310b;

    public c(b r5, b r10) {
        this.f21309a = r5;
        this.f21310b = r10;
    }

    @Override // p.e
    public final l.d d() {
        l.d r5 = this.f21309a.d();
        return new l((f) r5, (f) this.f21310b.d());
    }

    @Override // p.e
    public final List e() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // p.e
    public final boolean isStatic() {
        if (this.f21309a.isStatic() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f21310b.isStatic() == false) goto L7;
        return true;
    }
}
