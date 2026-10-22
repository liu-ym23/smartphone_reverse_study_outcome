package com.ss.android.lark.photoeditor.impl.ui;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ r a;

    public /* synthetic */ p(r r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        r.b r0 = this.a.g;
        if (r0 == null) goto L6;
        ((PhotoEditorFragment.a) r0).a.finish();
        return;
    }
}
