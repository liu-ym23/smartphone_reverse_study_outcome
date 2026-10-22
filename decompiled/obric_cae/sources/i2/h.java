package i2;

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

/* JADX INFO: loaded from: classes.dex */
public abstract class h implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f8135a;

    public h(Window.Callback r8) {
        this.f8135a = r8;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent r8) {
        return this.f8135a.dispatchGenericMotionEvent(r8);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent r8) {
        return this.f8135a.dispatchKeyShortcutEvent(r8);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r8) {
        return this.f8135a.dispatchPopulateAccessibilityEvent(r8);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent r8) {
        return this.f8135a.dispatchTrackballEvent(r8);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode r8) {
        this.f8135a.onActionModeFinished(r8);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode r8) {
        this.f8135a.onActionModeStarted(r8);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f8135a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.f8135a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int r8, Menu r10) {
        return this.f8135a.onCreatePanelMenu(r8, r10);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int r8) {
        return this.f8135a.onCreatePanelView(r8);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f8135a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int r8, MenuItem r10) {
        return this.f8135a.onMenuItemSelected(r8, r10);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int r8, Menu r10) {
        return this.f8135a.onMenuOpened(r8, r10);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int r8, Menu r10) {
        this.f8135a.onPanelClosed(r8, r10);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int r8, View r10, Menu r11) {
        return this.f8135a.onPreparePanel(r8, r10, r11);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f8135a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams r8) {
        this.f8135a.onWindowAttributesChanged(r8);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r8) {
        this.f8135a.onWindowFocusChanged(r8);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r8) {
        return this.f8135a.onWindowStartingActionMode(r8);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent r8) {
        return this.f8135a.onSearchRequested(r8);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r8, int r10) {
        return this.f8135a.onWindowStartingActionMode(r8, r10);
    }
}
