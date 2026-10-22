package io.reactivex.internal.operators.mixed;

import com.lynx.tasm.p;
import mt.n;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends mt.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f17691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f17692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17693c;

    public e(n r5, o r10, boolean r11) {
        this.f17691a = r5;
        this.f17692b = r10;
        this.f17693c = r11;
    }

    @Override // mt.a
    public final void c(mt.b r5) {
        n r10 = this.f17691a;
        o r11 = this.f17692b;
        if (p.j(r10, r11, r5) == true) goto L6;
        r10.subscribe(new d(r5, r11, this.f17693c));
        return;
    }
}
