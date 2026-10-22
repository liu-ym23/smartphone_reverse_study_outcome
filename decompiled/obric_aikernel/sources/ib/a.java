package ib;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9452a;

    public a() {
        this.f9452a = false;
    }

    @Override // ib.x
    public void H(List<String> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L9;
        this.f9452a = true;
        return;
    }

    @Override // ib.x
    public boolean c0() {
        return this.f9452a;
    }
}
