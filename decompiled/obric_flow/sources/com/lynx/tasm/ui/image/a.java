package com.lynx.tasm.ui.image;

import com.facebook.drawee.components.DeferredReleaser;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f10991a;

    public a(b r5) {
        this.f10991a = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r5 = this.f10991a;
        Iterator r10 = r5.f11025a.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((DeferredReleaser.Releasable) r10.next()).release();
        goto L4
    L6:
        r5.f11025a.clear();
    }
}
