package q;

import com.airbnb.lottie.model.content.ShapeTrimPath$Type;
import com.airbnb.lottie.w;
import k.q;
import k.r;
import k.u;

/* JADX INFO: loaded from: classes.dex */
public final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p.b f21422c;
    public final boolean d;
    public final p.e e;
    public final Object f;

    public i(String r5, p.b r10, p.b r11, p.d r12, boolean r13) {
        this.f21420a = 1;
        this.f21421b = r5;
        this.f21422c = r10;
        this.e = r11;
        this.f = r12;
        this.d = r13;
    }

    @Override // q.b
    public final k.c a(w r5, r.c r10) {
        switch(this.f21420a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return new u(r10, this);
    L7:
        return new r(r5, r10, this);
    L9:
        return new q(r5, r10, this);
    }

    public String toString() {
        switch(this.f21420a) {
            case 0: goto L9;
            case 1: goto L5;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return "Trim Path: {start: " + this.f21422c + ", end: " + ((p.b) this.e) + ", offset: " + ((p.b) this.f) + "}";
    L9:
        return "RectangleShape{position=" + this.e + ", size=" + ((p.a) this.f) + '}';
    }

    public i(String r5, p.e r10, p.a r11, p.b r12, boolean r13) {
        this.f21420a = 0;
        this.f21421b = r5;
        this.e = r10;
        this.f = r11;
        this.f21422c = r12;
        this.d = r13;
    }

    public i(String r5, ShapeTrimPath$Type r10, p.b r11, p.b r12, p.b r13, boolean r14) {
        this.f21420a = 2;
        this.f21421b = r10;
        this.f21422c = r11;
        this.e = r12;
        this.f = r13;
        this.d = r14;
    }
}
