package db;

import android.view.View;
import ge.p;
import ge.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f7020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f7021b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ cb.b f7022m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ float f7023n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ cb.a f7024o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ List f7025p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ q f7026q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final /* synthetic */ p f7027r;

    public c(d r8, float r10, View r11, cb.b r12, float r13, cb.a r14, ArrayList r15, q r16, eb.a r17) {
        this.f7020a = r8;
        this.f7021b = r11;
        this.f7022m = r12;
        this.f7023n = r13;
        this.f7024o = r14;
        this.f7025p = r15;
        this.f7026q = r16;
        this.f7027r = r17;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7020a.b(this.f7021b, this.f7022m, this.f7023n, this.f7024o, this.f7025p, this.f7026q, this.f7027r);
    }
}
