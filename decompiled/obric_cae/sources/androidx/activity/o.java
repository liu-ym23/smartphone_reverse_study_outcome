package androidx.activity;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
public final class o extends he.j implements ge.l<b, xd.j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OnBackPressedDispatcher f501a;

    public o(OnBackPressedDispatcher r8) {
        this.f501a = r8;
        super(1);
    }

    @Override // ge.l
    public final xd.j invoke(b r8) {
        he.i.f(r8, "backEvent");
        OnBackPressedDispatcher r10 = this.f501a;
        yd.d<n> r11 = r10.f451c;
        ListIterator<n> r12 = r11.listIterator(r11.size());
    L4:
        if (r12.hasPrevious() == false) goto L8;
        n r13 = r12.previous();
        if (r13.f498a == false) goto L4;
    L9:
        r10.f452d = r13;
        return xd.j.f13877a;
    L8:
        r13 = null;
        goto L9
    }
}
