package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ImmersionFragment extends Fragment implements e {
    private f mImmersionProxy;

    public ImmersionFragment() {
        this.mImmersionProxy = new f(this);
    }

    @Override // com.gyf.barlibrary.e
    public boolean immersionBarEnabled() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        this.mImmersionProxy.b(r1);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.mImmersionProxy.a(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mImmersionProxy.a(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mImmersionProxy.c();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r1) {
        super.onHiddenChanged(r1);
        this.mImmersionProxy.b(r1);
    }

    @Override // com.gyf.barlibrary.e
    public void onInvisible() {
    }

    @Override // com.gyf.barlibrary.e
    public void onLazyAfterView() {
    }

    @Override // com.gyf.barlibrary.e
    public void onLazyBeforeView() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mImmersionProxy.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mImmersionProxy.a();
    }

    @Override // com.gyf.barlibrary.e
    public void onVisible() {
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        this.mImmersionProxy.a(r1);
    }
}
