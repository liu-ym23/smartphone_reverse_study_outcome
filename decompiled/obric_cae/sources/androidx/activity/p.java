package androidx.activity;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class p extends he.j implements ge.l<b, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f502a;

    public p(OnBackPressedDispatcher r8) {
        this.f502a = r8;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(b r8) {
        he.i.f(r8, "backEvent");
        yd.d<n> r10 = this.f502a.f451c;
        ListIterator<n> r11 = r10.listIterator(r10.size());
    L4:
        if (r11.hasPrevious() == false) goto L8;
        n r12 = r11.previous();
        if (r12.f498a == false) goto L4;
    L10:
        return xd.j.f13877a;
    L8:
        r12 = null;
        goto L10
    }
}
