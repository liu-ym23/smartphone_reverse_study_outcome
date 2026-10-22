package ub;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements vb.b.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f12575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ android.support.v4.media.a f12576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f12577c;

    public c(b r8, d r10) {
        vb.b.C0183b r11 = vb.b.f12793m;
        this.f12575a = r8;
        this.f12576b = r11;
        this.f12577c = r10;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // vb.b.i
    public final void a(vb.b r8, boolean r10) {
        b r11 = this.f12575a;
        r11.f12569b.remove(this.f12576b);
        if (r8 == null) goto L7;
        ArrayList<vb.b.i> r12 = r8.f12810k;
        int r13 = r12.indexOf(this);
        if (r13 < 0) goto L7;
        r12.set(r13, null);
    L7:
        if (r8 == null) goto L11;
        ArrayList<vb.b.j> r14 = r8.f12811l;
        int r15 = r14.indexOf(this.f12577c);
        if (r15 < 0) goto L11;
        r14.set(r15, null);
    L11:
        r11.f12573f = null;
        if (r11.f12569b.isEmpty() == false) goto L18;
        if (r10 == true) goto L19;
        b.a<T> r16 = r11.f12572e;
        if (r16 == 0) goto L20;
        r16.a((b<T>) r11);
        return;
    L20:
        return;
    L19:
        return;
    }
}
