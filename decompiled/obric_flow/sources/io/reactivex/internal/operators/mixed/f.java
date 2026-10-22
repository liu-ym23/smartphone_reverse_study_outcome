package io.reactivex.internal.operators.mixed;

import com.lynx.tasm.p;
import mt.n;
import mt.u;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f17695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f17696c;
    public final boolean d;

    public /* synthetic */ f(n r5, o r10, boolean r11, int r12) {
        this.f17694a = r12;
        this.f17695b = r5;
        this.f17696c = r10;
        this.d = r11;
    }

    @Override // mt.n
    public final void subscribeActual(u r5) {
        switch(this.f17694a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        n r10 = this.f17695b;
        o r11 = this.f17696c;
        if (p.l(r10, r11, r5) == true) goto L12;
        r10.subscribe(new ObservableSwitchMapSingle$SwitchMapSingleMainObserver(r5, r11, this.d));
        return;
    L12:
        return;
    L8:
        n r12 = this.f17695b;
        o r13 = this.f17696c;
        if (p.k(r12, r13, r5) == true) goto L13;
        r12.subscribe(new ObservableSwitchMapMaybe$SwitchMapMaybeMainObserver(r5, r13, this.d));
        return;
    }
}
