package com.lynx.tasm.behavior.ui;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxBaseUI f10474a;

    public g(LynxBaseUI r5) {
        this.f10474a = r5;
    }

    @Override // com.lynx.tasm.behavior.ui.q
    public final void a(int r5) {
        LynxBaseUI r10 = this.f10474a;
        monitor-enter(r10);
        q[] r11 = (q[]) LynxBaseUI.access$200(this.f10474a).toArray(new q[LynxBaseUI.access$200(this.f10474a).size()]);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        int r12 = r11.length;
        int r13 = 0;
    L7:
        if (r13 >= r12) goto L9;
        r11[r13].a(r5);
        r13 = r13 + 1;
        goto L7
    L9:
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
