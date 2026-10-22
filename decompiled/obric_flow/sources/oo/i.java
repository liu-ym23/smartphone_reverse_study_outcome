package oo;

import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.LynxContext;
import ko.r;

/* JADX INFO: loaded from: classes2.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxContext f20812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f20813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f20814c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ String e;
    public final /* synthetic */ int f;
    public final /* synthetic */ int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f20815h;

    public i(int r5, int r10, long r11, long r12, LynxContext r13, String r14, boolean r15, boolean r16) {
        this.f20812a = r13;
        this.f20813b = r11;
        this.f20814c = r12;
        this.d = r15;
        this.e = r14;
        this.f = r5;
        this.g = r10;
        this.f20815h = r16;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LynxContext r5 = this.f20812a;
        if (r5 == null) goto L5;
        LynxView r10 = r5.k();
    L6:
        if (r10 == null) goto L13;
        ko.d r11 = (ko.d) r.g().e(ko.d.class);
        if (r11 != null) goto L11;
        return;
    L11:
        ko.j r12 = new ko.j();
        r12.f18691a = this.f20813b;
        r12.f18692b = this.f20814c;
        r12.f18693c = this.d;
        r12.d = this.e;
        r12.e = this.f;
        r12.f = this.g;
        r12.g = r10;
        r12.f18694h = this.f20815h;
        r11.reportImageInfo(new ko.k(r12));
        return;
    L13:
        return;
    L5:
        r10 = null;
        goto L6
    }
}
