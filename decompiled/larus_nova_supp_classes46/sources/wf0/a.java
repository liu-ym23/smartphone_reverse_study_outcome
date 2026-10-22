package wf0;

import com.bytedance.android.live.broadcast.api.model.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public t a;
    public qz.a b;

    /* JADX INFO: renamed from: wf0.a$a, reason: collision with other inner class name */
    public static final class C0285a {
    }

    static {
    }

    public a() {
    }

    public final qz.a a() {
        if (b.e() == false) goto L9;
        qz.a r0 = this.b;
        if (r0 != null) goto L7;
    L8:
        this.b = new c();
    L15:
        return this.b;
    L7:
        if ((r0 instanceof d) == false) goto L15;
    L9:
        qz.a r1 = this.b;
        if (r1 != null) goto L12;
    L13:
        this.b = new d();
        goto L15
    L12:
        if ((r1 instanceof c) == false) goto L15;
        goto L13
    }
}
