package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import ba.a;
import com.bumptech.glide.b;
import com.bumptech.glide.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import k0.d;
import k0.f;
import q0.i;
import zm.c;

/* JADX INFO: loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f1668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f1669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet f1670c;
    public SupportRequestManagerFragment d;
    public g e;

    public SupportRequestManagerFragment() {
        a r5 = new a(2);
        this.f1669b = new c(this, 9);
        this.f1670c = new HashSet();
        this.f1668a = r5;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r5) {
        super.onAttach(r5);
        Fragment r10 = this;
    L4:
        if (r10.getParentFragment() == null) goto L6;
        r10 = r10.getParentFragment();
        goto L4
    L6:
        FragmentManager r11 = r10.getFragmentManager();
        if (r11 == null) goto L9;
        Context r12 = getContext();     // Catch: IllegalStateException -> L19
        SupportRequestManagerFragment r13 = this.d;     // Catch: IllegalStateException -> L19
        if (r13 == null) goto L15;
        r13.f1670c.remove(this);     // Catch: IllegalStateException -> L19
        this.d = null;     // Catch: IllegalStateException -> L19
    L15:
        f r14 = b.b(r12).f;     // Catch: IllegalStateException -> L19
        r14.getClass();     // Catch: IllegalStateException -> L19
        SupportRequestManagerFragment r15 = r14.d(r11, f.e(r12));     // Catch: IllegalStateException -> L19
        this.d = r15;     // Catch: IllegalStateException -> L19
        if (equals(r15) == true) goto L28;
        this.d.f1670c.add(this);     // Catch: IllegalStateException -> L19
        return;
    L28:
        return;
    L19:
        e = move-exception;
        if (Log.isLoggable("SupportRMFragment", 5) == false) goto L29;
        Log.w("SupportRMFragment", "Unable to register fragment with root", e);
        return;
    L29:
        return;
    L9:
        if (Log.isLoggable("SupportRMFragment", 5) == false) goto L27;
        Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a r5 = this.f1668a;
        r5.f889b = true;
        Iterator r10 = i.d((Set) r5.f890c).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((d) r10.next()).onDestroy();
        goto L4
    L6:
        SupportRequestManagerFragment r11 = this.d;
        if (r11 == null) goto L11;
        r11.f1670c.remove(this);
        this.d = null;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        SupportRequestManagerFragment r5 = this.d;
        if (r5 == null) goto L6;
        r5.f1670c.remove(this);
        this.d = null;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f1668a.g();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        a r5 = this.f1668a;
        r5.f888a = false;
        Iterator r10 = i.d((Set) r5.f890c).iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((d) r10.next()).i();
        goto L4
    }

    @Override // androidx.fragment.app.Fragment
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
