package com.bumptech.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import ba.a;
import com.bumptech.glide.b;
import com.bumptech.glide.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import k0.d;
import k0.f;
import q0.i;
import ym.o;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class RequestManagerFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f1666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f1667c;
    public g d;
    public RequestManagerFragment e;

    public RequestManagerFragment() {
        a r5 = new a(2);
        this.f1666b = new o(this, 9);
        this.f1667c = new HashSet();
        this.f1665a = r5;
    }

    public final void a(Activity r5) {
        RequestManagerFragment r10 = this.e;
        if (r10 == null) goto L5;
        r10.f1667c.remove(this);
        this.e = null;
    L5:
        f r11 = b.b(r5).f;
        r11.getClass();
        RequestManagerFragment r12 = r11.c(r5.getFragmentManager(), f.e(r5));
        this.e = r12;
        if (equals(r12) == true) goto L9;
        this.e.f1667c.add(this);
        return;
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity r5) {
        super.onAttach(r5);
        a(r5);     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        if (Log.isLoggable("RMFragment", 5) == false) goto L12;
        Log.w("RMFragment", "Unable to register fragment with root", e);
        return;
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a r5 = this.f1665a;
        r5.f889b = true;
        Iterator r10 = i.d((Set) r5.f890c).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((d) r10.next()).onDestroy();
        goto L4
    L6:
        RequestManagerFragment r11 = this.e;
        if (r11 == null) goto L11;
        r11.f1667c.remove(this);
        this.e = null;
        return;
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        RequestManagerFragment r5 = this.e;
        if (r5 == null) goto L6;
        r5.f1667c.remove(this);
        this.e = null;
        return;
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f1665a.g();
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a r5 = this.f1665a;
        r5.f888a = false;
        Iterator r10 = i.d((Set) r5.f890c).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((d) r10.next()).i();
        goto L4
    }

    @Override // android.app.Fragment
    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(super.toString());
        r5.append("{parent=");
        Fragment r10 = getParentFragment();
        if (r10 != null) goto L6;
        r10 = null;
    L6:
        r5.append(r10);
        r5.append("}");
        return r5.toString();
    }
}
