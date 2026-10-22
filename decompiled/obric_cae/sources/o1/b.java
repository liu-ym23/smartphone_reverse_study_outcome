package o1;

import he.i;
import p1.h;
import r1.t;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f9611f;

    public b(p1.c r8) {
        this.f9611f = 0;
        i.f(r8, "tracker");
        super(r8);
    }

    @Override // o1.c
    public final boolean b(t r8) {
        switch(this.f9611f) {
            case 0: goto L5;
            default: goto L7;
        };
    L5:
        i.f(r8, "workSpec");
        return r8.f11348j.f2811d;
    L7:
        i.f(r8, "workSpec");
        return r8.f11348j.f2812e;
    }

    @Override // o1.c
    public final boolean c(Object r8) {
        int r10 = this.f9611f;
        switch(r10) {
            case 0: goto L5;
            default: goto L9;
        };
    L5:
        boolean r11 = ((Boolean) r8).booleanValue();
        switch(r10) {
            case 0: goto L8;
            default: goto L8;
        };
    L8:
        return !r11;
    L9:
        boolean r12 = ((Boolean) r8).booleanValue();
        switch(r10) {
            case 0: goto L12;
            default: goto L12;
        };
    L12:
        return !r12;
    }

    public b(h r8) {
        this.f9611f = 1;
        i.f(r8, "tracker");
        super(r8);
    }
}
