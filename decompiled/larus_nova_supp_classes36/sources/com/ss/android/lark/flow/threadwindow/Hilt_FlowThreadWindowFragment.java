package com.ss.android.lark.flow.threadwindow;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.ss.android.lark.im.base.page.BasePageFragment;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class Hilt_FlowThreadWindowFragment extends BasePageFragment {
    public ContextWrapper i;
    public boolean j;

    @Override // com.ss.android.lark.im.base.page.Hilt_BasePageFragment
    public final void S90() {
        if (this.j == true) goto L6;
        this.j = true;
        ((h) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent()).p((FlowThreadWindowFragment) UnsafeCasts.unsafeCast(this));
        return;
    }

    public Hilt_FlowThreadWindowFragment() {
        this.j = false;
    }

    @Override // com.ss.android.lark.im.base.page.Hilt_BasePageFragment
    public Context getContext() {
        if (super.getContext() != null) goto L9;
        if (this.i != null) goto L9;
        return null;
    L9:
        if (this.i != null) goto L12;
        this.i = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        return this.i;
    }

    @Override // com.ss.android.lark.im.base.page.Hilt_BasePageFragment
    public final void onAttach(Activity r3) {
        super.onAttach(r3);
        ContextWrapper r0 = this.i;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.i != null) goto L12;
        this.i = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        S90();
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r3) goto L8;
        r4 = false;
        goto L9
    }

    @Override // com.ss.android.lark.im.base.page.Hilt_BasePageFragment
    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super.onGetLayoutInflater(r1), this));
    }

    @Override // com.ss.android.lark.im.base.page.Hilt_BasePageFragment
    public final void onAttach(Context r1) {
        super.onAttach(r1);
        if (this.i != null) goto L5;
        this.i = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L5:
        S90();
    }
}
