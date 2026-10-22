package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Fragment> f2064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, x> f2065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v f2066c;

    public y() {
        this.f2064a = new ArrayList();
        this.f2065b = new HashMap();
    }

    public final void a(Fragment r8) {
        if (this.f2064a.contains(r8) == true) goto L14;
        ArrayList<Fragment> r10 = this.f2064a;
        monitor-enter(r10);
        this.f2064a.add(r8);     // Catch: Throwable -> L10
        monitor-exit(r10);     // Catch: Throwable -> L10
        r8.mAdded = true;
        return;
    L10:
        th = move-exception;
        throw th;
    L14:
        throw new IllegalStateException("Fragment already added: " + r8);
    }

    public final Fragment b(String r8) {
        x r10 = this.f2065b.get(r8);
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.f2060c;
    }

    public final Fragment c(String r8) {
        Iterator<x> r10 = this.f2065b.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        x r11 = r10.next();
        if (r11 == null) goto L4;
        Fragment r12 = r11.f2060c.findFragmentByWho(r8);
        if (r12 == null) goto L4;
        return r12;
    L10:
        return null;
    }

    public final ArrayList d() {
        ArrayList r8 = new ArrayList();
        Iterator<x> r10 = this.f2065b.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        x r11 = r10.next();
        if (r11 == null) goto L4;
        r8.add(r11);
        goto L4
    L8:
        return r8;
    }

    public final ArrayList e() {
        ArrayList r8 = new ArrayList();
        Iterator<x> r10 = this.f2065b.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        x r11 = r10.next();
        if (r11 == null) goto L8;
        Fragment r12 = r11.f2060c;
    L9:
        r8.add(r12);
        goto L4
    L8:
        r12 = null;
        goto L9
    L10:
        return r8;
    }

    public final List<Fragment> f() {
        if (this.f2064a.isEmpty() == true) goto L5;
        ArrayList<Fragment> r8 = this.f2064a;
        monitor-enter(r8);
        ArrayList r10 = new ArrayList(this.f2064a);     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return r10;
    L11:
        th = move-exception;
        throw th;
    L5:
        return Collections.emptyList();
    }

    public final void g(x r8) {
        Fragment r10 = r8.f2060c;
        String r11 = r10.mWho;
        HashMap<String, x> r12 = this.f2065b;
        if (r12.get(r11) == null) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == false) goto L8;
        return;
    L8:
        r12.put(r10.mWho, r8);
        if (r10.mRetainInstanceChangedWhileDetached == false) goto L16;
        boolean r14 = r10.mRetainInstance;
        v r15 = this.f2066c;
        if (r14 == false) goto L13;
        r15.c(r10);
    L14:
        r10.mRetainInstanceChangedWhileDetached = false;
        goto L16
    L13:
        r15.d(r10);
    L16:
        if (FragmentManager.G(2) == false) goto L19;
        Log.v("FragmentManager", "Added fragment to active set " + r10);
        return;
    L19:
        return;
    L5:
        r13 = false;
        goto L6
    }

    public final void h(x r8) {
        Fragment r10 = r8.f2060c;
        if (r10.mRetainInstance == false) goto L6;
        this.f2066c.d(r10);
    L6:
        if (this.f2065b.put(r10.mWho, null) != null) goto L9;
        return;
    L9:
        if (FragmentManager.G(2) == false) goto L12;
        Log.v("FragmentManager", "Removed fragment from active set " + r10);
        return;
    }
}
