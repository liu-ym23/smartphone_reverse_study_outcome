package io.reactivex.internal.operators.mixed;

import com.lynx.tasm.p;
import io.reactivex.internal.util.ErrorMode;
import mt.n;
import mt.u;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f17685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f17686c;
    public final ErrorMode d;
    public final int e;

    public /* synthetic */ c(n r5, o r10, ErrorMode r11, int r12, int r13) {
        this.f17684a = r13;
        this.f17685b = r5;
        this.f17686c = r10;
        this.d = r11;
        this.e = r12;
    }

    @Override // mt.n
    public final void subscribeActual(u r5) {
        switch(this.f17684a) {
            case 0: goto L8;
            default: goto L4;
        };
    L4:
        n r10 = this.f17685b;
        o r11 = this.f17686c;
        if (p.l(r10, r11, r5) == true) goto L12;
        r10.subscribe(new ObservableConcatMapSingle$ConcatMapSingleMainObserver(r5, r11, this.e, this.d));
        return;
    L12:
        return;
    L8:
        n r12 = this.f17685b;
        o r13 = this.f17686c;
        if (p.k(r12, r13, r5) == true) goto L13;
        r12.subscribe(new ObservableConcatMapMaybe$ConcatMapMaybeMainObserver(r5, r13, this.e, this.d));
        return;
    }
}
