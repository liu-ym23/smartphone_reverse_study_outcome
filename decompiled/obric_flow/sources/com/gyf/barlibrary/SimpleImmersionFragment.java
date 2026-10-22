package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import c5.a;
import kl.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SimpleImmersionFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f9467a;

    public SimpleImmersionFragment() {
        a r5 = new a(9, false);
        r5.f1119c = this;
        r5.d = this;
        this.f9467a = r5;
    }

    public abstract void c();

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        a r10 = this.f9467a;
        r10.f1118b = true;
        r10.d();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.f9467a.d();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a r5 = this.f9467a;
        SimpleImmersionFragment r10 = (SimpleImmersionFragment) r5.f1119c;
        if (r10 != null) goto L5;
    L7:
        r5.f1119c = null;
        r5.d = null;
        return;
    L5:
        if (r10.getActivity() == null) goto L7;
        ((SimpleImmersionFragment) r5.d).getClass();
        g.d((SimpleImmersionFragment) r5.f1119c).b();
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r5) {
        super.onHiddenChanged(r5);
        SimpleImmersionFragment r10 = (SimpleImmersionFragment) this.f9467a.f1119c;
        if (r10 == null) goto L6;
        r10.setUserVisibleHint(!r5);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r5) {
        super.setUserVisibleHint(r5);
        this.f9467a.d();
    }
}
