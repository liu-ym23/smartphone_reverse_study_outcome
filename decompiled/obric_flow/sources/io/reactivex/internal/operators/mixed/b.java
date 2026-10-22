package io.reactivex.internal.operators.mixed;

import com.lynx.tasm.p;
import io.reactivex.internal.util.ErrorMode;
import mt.n;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends mt.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f17681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f17682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ErrorMode f17683c;
    public final int d;

    public b(n r5, o r10, ErrorMode r11, int r12) {
        this.f17681a = r5;
        this.f17682b = r10;
        this.f17683c = r11;
        this.d = r12;
    }

    @Override // mt.a
    public final void c(mt.b r5) {
        n r10 = this.f17681a;
        o r11 = this.f17682b;
        if (p.j(r10, r11, r5) == true) goto L6;
        r10.subscribe(new ObservableConcatMapCompletable$ConcatMapCompletableObserver(r5, r11, this.f17683c, this.d));
        return;
    }
}
