package g;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f7496a;

    public static class a {
        public static boolean a(Window.Callback r8, SearchEvent r10) {
            return r8.onSearchRequested(r10);
        }

        public static ActionMode b(Window.Callback r8, ActionMode.Callback r10, int r11) {
            return r8.onWindowStartingActionMode(r10, r11);
        }
    }

    public static class b {
        public static void a(Window.Callback r8, List<KeyboardShortcutGroup> r10, Menu r11, int r12) {
            r8.onProvideKeyboardShortcuts(r10, r11, r12);
        }
    }

    public static class c {
        public static void a(Window.Callback r8, boolean r10) {
            r8.onPointerCaptureChanged(r10);
        }
    }

    public i(Window.Callback r8) {
        if (r8 == null) goto L7;
        this.f7496a = r8;
        return;
    L7:
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent r8) {
        return this.f7496a.dispatchGenericMotionEvent(r8);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r8) {
        return this.f7496a.dispatchKeyEvent(r8);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r8) {
        return this.f7496a.dispatchKeyShortcutEvent(r8);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r8) {
        return this.f7496a.dispatchPopulateAccessibilityEvent(r8);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r8) {
        return this.f7496a.dispatchTouchEvent(r8);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent r8) {
        return this.f7496a.dispatchTrackballEvent(r8);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode r8) {
        this.f7496a.onActionModeFinished(r8);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode r8) {
        this.f7496a.onActionModeStarted(r8);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f7496a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r8, Menu r10) {
        return this.f7496a.onCreatePanelMenu(r8, r10);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int r8) {
        return this.f7496a.onCreatePanelView(r8);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f7496a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int r8, MenuItem r10) {
        return this.f7496a.onMenuItemSelected(r8, r10);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r8, Menu r10) {
        return this.f7496a.onMenuOpened(r8, r10);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r8, Menu r10) {
        this.f7496a.onPanelClosed(r8, r10);
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean r8) {
        c.a(this.f7496a, r8);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r8, View r10, Menu r11) {
        return this.f7496a.onPreparePanel(r8, r10, r11);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r8, Menu r10, int r11) {
        b.a(this.f7496a, r8, r10, r11);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f7496a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams r8) {
        this.f7496a.onWindowAttributesChanged(r8);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r8) {
        this.f7496a.onWindowFocusChanged(r8);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r8, int r10) {
        return a.b(this.f7496a, r8, r10);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent r8) {
        return a.a(this.f7496a, r8);
    }
}
