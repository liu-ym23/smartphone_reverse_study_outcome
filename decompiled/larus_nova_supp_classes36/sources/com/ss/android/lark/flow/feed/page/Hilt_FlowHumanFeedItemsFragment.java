package com.ss.android.lark.flow.feed.page;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.ss.android.lark.feed.shared.page.FeedItemsFragment;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public abstract class Hilt_FlowHumanFeedItemsFragment extends FeedItemsFragment {
    public ContextWrapper R;
    public boolean S;

    public final void S90() {
        if (this.S == true) goto L6;
        this.S = true;
        ((a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent()).H((FlowHumanFeedItemsFragment) UnsafeCasts.unsafeCast(this));
        return;
    }

    public Hilt_FlowHumanFeedItemsFragment() {
        this.S = false;
    }

    public Context getContext() {
        if (super/*com.ss.android.lark.feed.shared.page.Hilt_FeedItemsFragment*/.getContext() != null) goto L9;
        if (this.R != null) goto L9;
        return null;
    L9:
        if (this.R != null) goto L12;
        this.R = FragmentComponentManager.createContextWrapper(super/*com.ss.android.lark.feed.shared.page.Hilt_FeedItemsFragment*/.getContext(), this);
    L12:
        return this.R;
    }

    public final void onAttach(Activity r3) {
        super/*com.ss.android.lark.feed.shared.page.Hilt_FeedItemsFragment*/.onAttach(r3);
        ContextWrapper r0 = this.R;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.R != null) goto L12;
        this.R = FragmentComponentManager.createContextWrapper(super/*com.ss.android.lark.feed.shared.page.Hilt_FeedItemsFragment*/.getContext(), this);
    L12:
        S90();
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r3) goto L8;
        r4 = false;
        goto L9
    }

    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super/*com.ss.android.lark.feed.shared.page.Hilt_FeedItemsFragment*/.onGetLayoutInflater(r1), this));
    }

    public final void onAttach(Context r1) {
        super/*com.ss.android.lark.feed.shared.page.Hilt_FeedItemsFragment*/.onAttach(r1);
        if (this.R != null) goto L5;
        this.R = FragmentComponentManager.createContextWrapper(super/*com.ss.android.lark.feed.shared.page.Hilt_FeedItemsFragment*/.getContext(), this);
    L5:
        S90();
    }
}
