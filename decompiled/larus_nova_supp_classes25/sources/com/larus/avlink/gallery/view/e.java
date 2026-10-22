package com.larus.avlink.gallery.view;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ Function0 a;

    public /* synthetic */ e(Function0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r0 = this.a;
        AlbumListAdapter$Companion$DIFF_CALLBACK$1 r1 = AlbumListAdapter.d;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }
}
