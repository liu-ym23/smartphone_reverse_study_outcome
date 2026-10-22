package com.google.common.collect;

import java.util.Collection;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g1 implements BiConsumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function f8987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function f8988c;

    public /* synthetic */ g1(Function r5, Function r10, int r11) {
        this.f8986a = r11;
        this.f8987b = r5;
        this.f8988c = r10;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object r5, Object r10) {
        switch(this.f8986a) {
            case 0: goto L16;
            case 1: goto L14;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L6;
            default: goto L4;
        };
    L4:
        ((p3) r5).l(this.f8987b.apply(r10), this.f8988c.apply(r10));
        return;
    L6:
        ((v4) r5).l(this.f8987b.apply(r10), this.f8988c.apply(r10));
        return;
    L8:
        Collection r11 = ((q7) r5).get(this.f8987b.apply(r10));
        Stream r12 = (Stream) this.f8988c.apply(r10);
        Objects.requireNonNull(r11);
        r12.forEachOrdered(new m1(r11, 0));
        return;
    L10:
        ((s4) r5).f(this.f8987b.apply(r10), this.f8988c.apply(r10));
        return;
    L12:
        ((v3) r5).f(this.f8987b.apply(r10), this.f8988c.apply(r10));
        return;
    L14:
        ((x3) r5).g(this.f8987b.apply(r10), this.f8988c.apply(r10));
        return;
    L16:
        ((j4) r5).b((Range) this.f8987b.apply(r10), this.f8988c.apply(r10));
    }
}
