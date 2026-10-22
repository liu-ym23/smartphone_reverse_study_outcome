package com.ss.android.lark.profile_office.userprofile;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.GeneratedComponentManager;
import dagger.hilt.internal.GeneratedComponentManagerHolder;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class Hilt_OfficeProfileFragment extends Fragment implements GeneratedComponentManagerHolder {
    public ContextWrapper d;
    public volatile FragmentComponentManager e;
    public final Object f;
    public boolean g;

    public final GeneratedComponentManager componentManager() {
        if (this.e != null) goto L15;
        Object r0 = this.f;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.e != null) goto L9;
        this.e = new FragmentComponentManager(this);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.e;
    }

    public final Object generatedComponent() {
        if (this.e != null) goto L15;
        Object r0 = this.f;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.e != null) goto L9;
        this.e = new FragmentComponentManager(this);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.e.generatedComponent();
    }

    public Hilt_OfficeProfileFragment() {
        this.f = new Object();
        this.g = false;
    }

    public Context getContext() {
        if (super.getContext() != null) goto L9;
        if (this.d != null) goto L9;
        return null;
    L9:
        if (this.d != null) goto L12;
        this.d = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        return this.d;
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DefaultViewModelFactories.getFragmentFactory(this, super.getDefaultViewModelProviderFactory());
    }

    public final void onAttach(Activity r4) {
        super.onAttach(r4);
        ContextWrapper r0 = this.d;
        if (r0 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        Preconditions.checkState(r5, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.d != null) goto L13;
        this.d = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L13:
        if (this.g == true) goto L16;
        this.g = true;
        e r6 = (e) generatedComponent();
        OfficeProfileFragment r1 = (OfficeProfileFragment) UnsafeCasts.unsafeCast(this);
        r6.a();
        return;
    L16:
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r4) goto L8;
        r5 = false;
        goto L9
    }

    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super.onGetLayoutInflater(r1), this));
    }

    public final void onAttach(Context r2) {
        super.onAttach(r2);
        if (this.d != null) goto L6;
        this.d = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L6:
        if (this.g == true) goto L9;
        this.g = true;
        e r3 = (e) generatedComponent();
        OfficeProfileFragment r0 = (OfficeProfileFragment) UnsafeCasts.unsafeCast(this);
        r3.a();
        return;
    }
}
