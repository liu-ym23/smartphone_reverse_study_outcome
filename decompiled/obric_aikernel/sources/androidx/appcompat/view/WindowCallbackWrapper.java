package androidx.appcompat.view;

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
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowCallbackWrapper implements Window.Callback {
    final Window.Callback mWrapped;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static boolean onSearchRequested(Window.Callback r10, SearchEvent r11) {
            return r10.onSearchRequested(r11);
        }

        @DoNotInline
        static android.view.ActionMode onWindowStartingActionMode(Window.Callback r10, android.view.ActionMode.Callback r11, int r12) {
            return r10.onWindowStartingActionMode(r11, r12);
        }
    }

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void onProvideKeyboardShortcuts(Window.Callback r10, List<KeyboardShortcutGroup> r11, Menu r12, int r13) {
            r10.onProvideKeyboardShortcuts(r11, r12, r13);
        }
    }

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static void onPointerCaptureChanged(Window.Callback r10, boolean r11) {
            r10.onPointerCaptureChanged(r11);
        }
    }

    public WindowCallbackWrapper(Window.Callback r10) {
        if (r10 == null) goto L7;
        this.mWrapped = r10;
        return;
    L7:
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r10) {
        return this.mWrapped.dispatchGenericMotionEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r10) {
        return this.mWrapped.dispatchKeyEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r10) {
        return this.mWrapped.dispatchKeyShortcutEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        return this.mWrapped.dispatchPopulateAccessibilityEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r10) {
        return this.mWrapped.dispatchTouchEvent(r10);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r10) {
        return this.mWrapped.dispatchTrackballEvent(r10);
    }

    public final Window.Callback getWrapped() {
        return this.mWrapped;
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(android.view.ActionMode r10) {
        this.mWrapped.onActionModeFinished(r10);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(android.view.ActionMode r10) {
        this.mWrapped.onActionModeStarted(r10);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mWrapped.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.mWrapped.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r10, Menu r11) {
        return this.mWrapped.onCreatePanelMenu(r10, r11);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int r10) {
        return this.mWrapped.onCreatePanelView(r10);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mWrapped.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r10, MenuItem r11) {
        return this.mWrapped.onMenuItemSelected(r10, r11);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r10, Menu r11) {
        return this.mWrapped.onMenuOpened(r10, r11);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r10, Menu r11) {
        this.mWrapped.onPanelClosed(r10, r11);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(26)
    public void onPointerCaptureChanged(boolean r10) {
        Api26Impl.onPointerCaptureChanged(this.mWrapped, r10);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r10, View r11, Menu r12) {
        return this.mWrapped.onPreparePanel(r10, r11, r12);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r10, Menu r11, int r12) {
        Api24Impl.onProvideKeyboardShortcuts(this.mWrapped, r10, r11, r12);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mWrapped.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    @RequiresApi(23)
    public boolean onSearchRequested(SearchEvent r10) {
        return Api23Impl.onSearchRequested(this.mWrapped, r10);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r10) {
        this.mWrapped.onWindowAttributesChanged(r10);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r10) {
        this.mWrapped.onWindowFocusChanged(r10);
    }

    @Override // android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r10) {
        return this.mWrapped.onWindowStartingActionMode(r10);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(23)
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r10, int r11) {
        return Api23Impl.onWindowStartingActionMode(this.mWrapped, r10, r11);
    }
}
