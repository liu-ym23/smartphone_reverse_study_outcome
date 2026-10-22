package com.bytedance.android.monitorV2;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f3579a;

    public g(Window.Callback r5) {
        this.f3579a = r5;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent r5) {
        return this.f3579a.dispatchGenericMotionEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r5) {
        return this.f3579a.dispatchKeyEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent r5) {
        return this.f3579a.dispatchKeyShortcutEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r5) {
        return this.f3579a.dispatchPopulateAccessibilityEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L7;
        if (r5.getAction() != 0) goto L7;
        sk.a.f21938a = System.currentTimeMillis();
    L7:
        return this.f3579a.dispatchTouchEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent r5) {
        return this.f3579a.dispatchTrackballEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode r5) {
        this.f3579a.onActionModeFinished(r5);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode r5) {
        this.f3579a.onActionModeStarted(r5);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f3579a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.f3579a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int r5, Menu r10) {
        return this.f3579a.onCreatePanelMenu(r5, r10);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int r5) {
        return this.f3579a.onCreatePanelView(r5);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f3579a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int r5, MenuItem r10) {
        return this.f3579a.onMenuItemSelected(r5, r10);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int r5, Menu r10) {
        return this.f3579a.onMenuOpened(r5, r10);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int r5, Menu r10) {
        this.f3579a.onPanelClosed(r5, r10);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int r5, View r10, Menu r11) {
        return this.f3579a.onPreparePanel(r5, r10, r11);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f3579a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams r5) {
        this.f3579a.onWindowAttributesChanged(r5);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r5) {
        this.f3579a.onWindowFocusChanged(r5);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r5) {
        return this.f3579a.onWindowStartingActionMode(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent r5) {
        return this.f3579a.onSearchRequested(r5);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r5, int r10) {
        return this.f3579a.onWindowStartingActionMode(r5, r10);
    }
}
