package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.ViewModelProvider;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.j;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.l;
import com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MviBaseFragment;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public abstract class Hilt_MmEndWindowFragment<S extends l, E extends k, UE extends j, VM extends com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.a<S, E, UE>> extends MviBaseFragment<S, E, UE, VM> {
    public ContextWrapper k;
    public boolean l;

    public final void ca0() {
        if (this.l == true) goto L6;
        this.l = true;
        ((b) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent()).o1((MmEndWindowFragment) UnsafeCasts.unsafeCast(this));
        return;
    }

    public Hilt_MmEndWindowFragment() {
        this.l = false;
    }

    public Context getContext() {
        if (super.getContext() != null) goto L9;
        if (this.k != null) goto L9;
        return null;
    L9:
        if (this.k != null) goto L12;
        this.k = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        return this.k;
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DwarfViewModelFactories.getFragmentFactory(this, super.getDefaultViewModelProviderFactory(), ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent());
    }

    public final void onAttach(Activity r3) {
        super.onAttach(r3);
        ContextWrapper r0 = this.k;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.k != null) goto L12;
        this.k = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        ca0();
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r3) goto L8;
        r4 = false;
        goto L9
    }

    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super.onGetLayoutInflater(r1), this));
    }

    @Override // com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment
    public final void onAttach(Context r1) {
        super.onAttach(r1);
        if (this.k != null) goto L5;
        this.k = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L5:
        ca0();
    }
}
