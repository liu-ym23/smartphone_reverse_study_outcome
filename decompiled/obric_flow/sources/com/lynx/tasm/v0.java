package com.lynx.tasm;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TemplateData f11184b;

    public /* synthetic */ v0(TemplateData r5, int r10) {
        this.f11183a = r10;
        this.f11184b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f11183a) {
            case 0: goto L13;
            case 1: goto L7;
            default: goto L4;
        };
    L4:
        this.f11184b.m();
        return;
    L7:
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L9;
        return;
    L9:
        if (this.f11184b.f == 0) goto L19;
        TemplateData.f(this.f11184b.f);
        this.f11184b.f = 0;
        return;
    L19:
        return;
    L13:
        if (LynxEnv.inst().isNativeLibraryLoaded() == true) goto L15;
        return;
    L15:
        if (this.f11184b.f10054a == 0) goto L21;
        TemplateData.f(this.f11184b.f10054a);
        this.f11184b.f10054a = 0;
        return;
    }
}
