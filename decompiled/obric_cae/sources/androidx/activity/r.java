package androidx.activity;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class r extends he.j implements ge.a<xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f504a;

    public r(OnBackPressedDispatcher r8) {
        this.f504a = r8;
        super(0);
    }

    @Override // ge.a
    public final xd.j f() {
        OnBackPressedDispatcher r8 = this.f504a;
        yd.d<n> r10 = r8.f451c;
        ListIterator<n> r11 = r10.listIterator(r10.size());
    L4:
        if (r11.hasPrevious() == false) goto L8;
        n r12 = r11.previous();
        if (r12.f498a == false) goto L4;
    L9:
        r8.f452d = null;
        return xd.j.f13877a;
    L8:
        r12 = null;
        goto L9
    }
}
