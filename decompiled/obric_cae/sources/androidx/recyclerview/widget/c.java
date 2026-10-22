package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f2440b;

    public c(k r8, ArrayList r10) {
        this.f2440b = r8;
        this.f2439a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList r8 = this.f2439a;
        Iterator r10 = r8.iterator();
    L3:
        boolean r11 = r10.hasNext();
        k r12 = this.f2440b;
        if (r11 == false) goto L11;
        k.b r13 = (k.b) r10.next();
        RecyclerView.c0 r14 = r13.f2485a;
        r12.getClass();
        View r15 = r14.f2281a;
        int r16 = r13.f2488d - r13.f2486b;
        int r17 = r13.f2489e - r13.f2487c;
        if (r16 == 0) goto L8;
        r15.animate().translationX(0.0f);
    L8:
        if (r17 == 0) goto L10;
        r15.animate().translationY(0.0f);
    L10:
        ViewPropertyAnimator r18 = r15.animate();
        r12.f2476p.add(r14);
        r18.setDuration(r12.f2308e).setListener(new h(r12, r14, r16, r15, r17, r18)).start();
        goto L3
    L11:
        r8.clear();
        r12.f2473m.remove(r8);
    }
}
