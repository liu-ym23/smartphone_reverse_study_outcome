package com.ss.android.lark.conditional.access.device.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class Hilt_UserScopeDeclareReasonEditFragment<VB extends ViewBinding> extends BaseTitleBarFragment<VB> {
    public ContextWrapper g;
    public boolean h;

    public final void W90() {
        if (this.h == true) goto L6;
        this.h = true;
        c r0 = (c) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent();
        UserScopeDeclareReasonEditFragment r1 = (UserScopeDeclareReasonEditFragment) UnsafeCasts.unsafeCast(this);
        r0.r();
        return;
    }

    public Hilt_UserScopeDeclareReasonEditFragment() {
        this.h = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Context getContext() {
        if (super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.getContext() != null) goto L9;
        if (this.g != null) goto L9;
        return null;
    L9:
        if (this.g != null) goto L12;
        this.g = FragmentComponentManager.createContextWrapper(super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.getContext(), this);
    L12:
        return this.g;
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DwarfViewModelFactories.getFragmentFactory(this, super/*androidx.fragment.app.Fragment*/.getDefaultViewModelProviderFactory(), ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttach(Activity r3) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r3);
        ContextWrapper r0 = this.g;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.g != null) goto L12;
        this.g = FragmentComponentManager.createContextWrapper(super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.getContext(), this);
    L12:
        W90();
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r3) goto L8;
        r4 = false;
        goto L9
    }

    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super/*androidx.fragment.app.Fragment*/.onGetLayoutInflater(r1), this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttach(Context r1) {
        super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.onAttach(r1);
        if (this.g != null) goto L5;
        this.g = FragmentComponentManager.createContextWrapper(super/*com.ss.android.lark.desktopmode.app.DesktopCompatFragment*/.getContext(), this);
    L5:
        W90();
    }
}
