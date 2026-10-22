package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f2444b;

    public e(k r8, ArrayList r10) {
        this.f2444b = r8;
        this.f2443a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList r8 = this.f2443a;
        Iterator r10 = r8.iterator();
    L3:
        boolean r11 = r10.hasNext();
        k r12 = this.f2444b;
        if (r11 == false) goto L6;
        RecyclerView.c0 r13 = (RecyclerView.c0) r10.next();
        r12.getClass();
        View r14 = r13.f2281a;
        ViewPropertyAnimator r15 = r14.animate();
        r12.f2475o.add(r13);
        r15.alpha(1.0f).setDuration(r12.f2306c).setListener(new g(r14, r15, r12, r13)).start();
        goto L3
    L6:
        r8.clear();
        r12.f2472l.remove(r8);
    }
}
