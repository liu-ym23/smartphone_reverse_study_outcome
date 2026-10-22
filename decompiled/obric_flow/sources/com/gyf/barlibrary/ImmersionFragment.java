package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kl.g;
import kl.h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmersionFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f9466a;

    public ImmersionFragment() {
        h r5 = new h();
        r5.f18681a = this;
        r5.f18682b = this;
        this.f9466a = r5;
    }

    public abstract void c();

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        h r10 = this.f9466a;
        r10.f18683c = true;
        ImmersionFragment r11 = r10.f18681a;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.getUserVisibleHint() == false) goto L11;
        r10.f18682b.getClass();
        r10.f18682b.c();
        if (r10.d == true) goto L12;
        r10.f18682b.getClass();
        r10.d = true;
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        h r10 = this.f9466a;
        ImmersionFragment r11 = r10.f18681a;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.getUserVisibleHint() == false) goto L9;
        r10.f18682b.getClass();
        r10.f18682b.c();
        r10.f18682b.getClass();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        h r10 = this.f9466a;
        ImmersionFragment r11 = r10.f18681a;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (r10.e == true) goto L12;
        r10.f18682b.getClass();
        r10.e = true;
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        h r5 = this.f9466a;
        ImmersionFragment r10 = r5.f18681a;
        if (r10 != null) goto L5;
    L7:
        r5.f18681a = null;
        r5.f18682b = null;
        return;
    L5:
        if (r10.getActivity() == null) goto L7;
        r5.f18682b.getClass();
        g.d(r5.f18681a).b();
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final void onHiddenChanged(boolean r5) {
        super.onHiddenChanged(r5);
        ImmersionFragment r10 = this.f9466a.f18681a;
        if (r10 == null) goto L6;
        r10.setUserVisibleHint(!r5);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        h r5 = this.f9466a;
        if (r5.f18681a == null) goto L6;
        r5.f18682b.getClass();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        h r5 = this.f9466a;
        ImmersionFragment r10 = r5.f18681a;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getUserVisibleHint() == false) goto L9;
        r5.f18682b.getClass();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r5) {
        super.setUserVisibleHint(r5);
        h r10 = this.f9466a;
        ImmersionFragment r11 = r10.f18681a;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.getUserVisibleHint() == false) goto L18;
        if (r10.e == true) goto L10;
        r10.f18682b.getClass();
        r10.e = true;
    L10:
        if (r10.f18683c == true) goto L12;
        return;
    L12:
        if (r10.f18681a.getUserVisibleHint() == false) goto L23;
        r10.f18682b.getClass();
        r10.f18682b.c();
        if (r10.d == true) goto L16;
        r10.f18682b.getClass();
        r10.d = true;
    L16:
        r10.f18682b.getClass();
        return;
    L23:
        return;
    L18:
        if (r10.f18683c == false) goto L25;
        r10.f18682b.getClass();
        return;
    }
}
