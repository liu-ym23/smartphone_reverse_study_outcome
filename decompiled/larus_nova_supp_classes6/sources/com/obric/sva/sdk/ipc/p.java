package com.obric.sva.sdk.ipc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ SvaContentProvider a;

    public /* synthetic */ p(SvaContentProvider r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SvaContentProvider.c(this.a);
    }
}
