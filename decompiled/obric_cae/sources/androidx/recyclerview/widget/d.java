package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f2442b;

    public d(k r8, ArrayList r10) {
        this.f2442b = r8;
        this.f2441a = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList r8 = this.f2441a;
        Iterator r10 = r8.iterator();
    L3:
        boolean r11 = r10.hasNext();
        k r12 = this.f2442b;
        if (r11 == false) goto L17;
        k.a r13 = (k.a) r10.next();
        r12.getClass();
        RecyclerView.c0 r14 = r13.f2479a;
        View r15 = null;
        if (r14 != null) goto L8;
        View r16 = null;
    L9:
        RecyclerView.c0 r17 = r13.f2480b;
        if (r17 == null) goto L12;
        r15 = r17.f2281a;
    L12:
        ArrayList<RecyclerView.c0> r18 = r12.f2478r;
        long r19 = r12.f2309f;
        if (r16 == null) goto L15;
        ViewPropertyAnimator r110 = r16.animate().setDuration(r19);
        r18.add(r13.f2479a);
        r110.translationX(r13.f2483e - r13.f2481c);
        r110.translationY(r13.f2484f - r13.f2482d);
        r110.alpha(0.0f).setListener(new i(r12, r13, r110, r16)).start();
    L15:
        if (r15 == null) goto L3;
        ViewPropertyAnimator r20 = r15.animate();
        r18.add(r13.f2480b);
        r20.translationX(0.0f).translationY(0.0f).setDuration(r19).alpha(1.0f).setListener(new j(r12, r13, r20, r15)).start();
        goto L3
    L8:
        r16 = r14.f2281a;
        goto L9
    L17:
        r8.clear();
        r12.f2474n.remove(r8);
    }
}
