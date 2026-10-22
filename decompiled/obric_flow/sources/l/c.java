package l;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v.a f19480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f19481b;

    public c(List r5) {
        this.f19481b = -1.0f;
        this.f19480a = (v.a) r5.get(0);
    }

    @Override // l.b
    public final boolean a(float r5) {
        if (this.f19481b != r5) goto L6;
        return true;
    L6:
        this.f19481b = r5;
        return false;
    }

    @Override // l.b
    public final v.a b() {
        return this.f19480a;
    }

    @Override // l.b
    public final boolean c(float r5) {
        return !this.f19480a.c();
    }

    @Override // l.b
    public final float f() {
        return this.f19480a.b();
    }

    @Override // l.b
    public final float g() {
        return this.f19480a.a();
    }

    @Override // l.b
    public final boolean isEmpty() {
        return false;
    }
}
