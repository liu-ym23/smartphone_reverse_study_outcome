package com.bytedance.ies.bullet.kit.web;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.lynx.tasm.behavior.x0;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends ActionMode.Callback2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x0 f5499a;

    public e(x0 r5) {
        this.f5499a = r5;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r5, MenuItem r10) {
        return ((ActionMode.Callback) this.f5499a.f10812a).onActionItemClicked(r5, r10);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r5, Menu r10) {
        return ((ActionMode.Callback) this.f5499a.f10812a).onCreateActionMode(r5, r10);
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r5) {
        ((ActionMode.Callback) this.f5499a.f10812a).onDestroyActionMode(r5);
    }

    @Override // android.view.ActionMode.Callback2
    public final void onGetContentRect(ActionMode r5, View r10, Rect r11) {
        ActionMode.Callback r12 = (ActionMode.Callback) this.f5499a.f10812a;
        if ((r12 instanceof ActionMode.Callback2) == false) goto L6;
        ((ActionMode.Callback2) r12).onGetContentRect(r5, r10, r11);
        return;
    L6:
        super.onGetContentRect(r5, r10, r11);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r5, Menu r10) {
        return ((ActionMode.Callback) this.f5499a.f10812a).onPrepareActionMode(r5, r10);
    }
}
