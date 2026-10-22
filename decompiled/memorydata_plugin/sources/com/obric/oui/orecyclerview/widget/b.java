package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclerView.Adapter f14140a;

    public b(RecyclerView.Adapter r1) {
        this.f14140a = r1;
    }

    @Override // com.obric.oui.orecyclerview.widget.r
    public void a(int r1, int r2) {
        this.f14140a.c(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.r
    public void a(int r1, int r2, Object r3) {
        this.f14140a.a(r1, r2, r3);
    }

    @Override // com.obric.oui.orecyclerview.widget.r
    public void b(int r1, int r2) {
        this.f14140a.d(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.widget.r
    public void c(int r1, int r2) {
        this.f14140a.b(r1, r2);
    }
}
