package t;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public abstract class h implements Window.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Window.Callback f12921c;

    public h(Window.Callback r10) {
        this.f12921c = r10;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r10) {
        return this.f12921c.dispatchGenericMotionEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r10) {
        return this.f12921c.dispatchKeyShortcutEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        return this.f12921c.dispatchPopulateAccessibilityEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r10) {
        return this.f12921c.dispatchTrackballEvent(r10);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode r10) {
        this.f12921c.onActionModeFinished(r10);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode r10) {
        this.f12921c.onActionModeStarted(r10);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f12921c.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f12921c.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r10, @NonNull Menu r11) {
        return this.f12921c.onCreatePanelMenu(r10, r11);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public View onCreatePanelView(int r10) {
        return this.f12921c.onCreatePanelView(r10);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f12921c.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r10, @NonNull MenuItem r11) {
        return this.f12921c.onMenuItemSelected(r10, r11);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r10, @NonNull Menu r11) {
        return this.f12921c.onMenuOpened(r10, r11);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r10, @NonNull Menu r11) {
        this.f12921c.onPanelClosed(r10, r11);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r10, @Nullable View r11, @NonNull Menu r12) {
        return this.f12921c.onPreparePanel(r10, r11, r12);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f12921c.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r10) {
        return this.f12921c.onSearchRequested(r10);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r10) {
        this.f12921c.onWindowAttributesChanged(r10);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r10) {
        this.f12921c.onWindowFocusChanged(r10);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r10) {
        return this.f12921c.onWindowStartingActionMode(r10);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r10, int r11) {
        return this.f12921c.onWindowStartingActionMode(r10, r11);
    }
}
