package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleImmersionFragment extends Fragment implements j {
    private k mSimpleImmersionProxy;

    public SimpleImmersionFragment() {
        this.mSimpleImmersionProxy = new k(this);
    }

    @Override // com.gyf.barlibrary.j
    public boolean immersionBarEnabled() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        this.mSimpleImmersionProxy.a(r1);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.mSimpleImmersionProxy.a(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mSimpleImmersionProxy.a();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r1) {
        super.onHiddenChanged(r1);
        this.mSimpleImmersionProxy.b(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        this.mSimpleImmersionProxy.a(r1);
    }
}
