package com.ss.android.lark.flow.mergeforward;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.base.fragment.BaseFragment;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class Hilt_FlowMergeForwardContainerFragment extends BaseFragment {
    public ContextWrapper d;
    public boolean e;

    public final void S90() {
        if (this.e == true) goto L6;
        this.e = true;
        ((b) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent()).P((FlowMergeForwardContainerFragment) UnsafeCasts.unsafeCast(this));
        return;
    }

    public Hilt_FlowMergeForwardContainerFragment() {
        this.e = false;
    }

    public Context getContext() {
        if (super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.getContext() != null) goto L9;
        if (this.d != null) goto L9;
        return null;
    L9:
        if (this.d != null) goto L12;
        this.d = FragmentComponentManager.createContextWrapper(super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.getContext(), this);
    L12:
        return this.d;
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DwarfViewModelFactories.getFragmentFactory(this, super/*androidx.fragment.app.Fragment*/.getDefaultViewModelProviderFactory(), ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent());
    }

    public final void onAttach(Activity r3) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r3);
        ContextWrapper r0 = this.d;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.d != null) goto L12;
        this.d = FragmentComponentManager.createContextWrapper(super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.getContext(), this);
    L12:
        S90();
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r3) goto L8;
        r4 = false;
        goto L9
    }

    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super/*androidx.fragment.app.Fragment*/.onGetLayoutInflater(r1), this));
    }

    public final void onAttach(Context r1) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onAttach(r1);
        if (this.d != null) goto L5;
        this.d = FragmentComponentManager.createContextWrapper(super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.getContext(), this);
    L5:
        S90();
    }
}
