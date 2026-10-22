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
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static boolean onSearchRequested(Window.Callback r5, SearchEvent r10) {
            return r5.onSearchRequested(r10);
        }

        @DoNotInline
        public static android.view.ActionMode onWindowStartingActionMode(Window.Callback r5, android.view.ActionMode.Callback r10, int r11) {
            return r5.onWindowStartingActionMode(r10, r11);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static void onProvideKeyboardShortcuts(Window.Callback r5, List<KeyboardShortcutGroup> r10, Menu r11, int r12) {
            r5.onProvideKeyboardShortcuts(r10, r11, r12);
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static void onPointerCaptureChanged(Window.Callback r5, boolean r10) {
            r5.onPointerCaptureChanged(r10);
        }
    }

    public WindowCallbackWrapper(Window.Callback r5) {
        if (r5 == null) goto L7;
        this.mWrapped = r5;
        return;
    L7:
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r5) {
        return this.mWrapped.dispatchGenericMotionEvent(r5);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r5) {
        return this.mWrapped.dispatchKeyEvent(r5);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r5) {
        return this.mWrapped.dispatchKeyShortcutEvent(r5);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r5) {
        return this.mWrapped.dispatchPopulateAccessibilityEvent(r5);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r5) {
        return this.mWrapped.dispatchTouchEvent(r5);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r5) {
        return this.mWrapped.dispatchTrackballEvent(r5);
    }

    public final Window.Callback getWrapped() {
        return this.mWrapped;
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(android.view.ActionMode r5) {
        this.mWrapped.onActionModeFinished(r5);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(android.view.ActionMode r5) {
        this.mWrapped.onActionModeStarted(r5);
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
    public boolean onCreatePanelMenu(int r5, Menu r10) {
        return this.mWrapped.onCreatePanelMenu(r5, r10);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int r5) {
        return this.mWrapped.onCreatePanelView(r5);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mWrapped.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r5, MenuItem r10) {
        return this.mWrapped.onMenuItemSelected(r5, r10);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r5, Menu r10) {
        return this.mWrapped.onMenuOpened(r5, r10);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r5, Menu r10) {
        this.mWrapped.onPanelClosed(r5, r10);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(26)
    public void onPointerCaptureChanged(boolean r5) {
        Api26Impl.onPointerCaptureChanged(this.mWrapped, r5);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r5, View r10, Menu r11) {
        return this.mWrapped.onPreparePanel(r5, r10, r11);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r5, Menu r10, int r11) {
        Api24Impl.onProvideKeyboardShortcuts(this.mWrapped, r5, r10, r11);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(23)
    public boolean onSearchRequested(SearchEvent r5) {
        return Api23Impl.onSearchRequested(this.mWrapped, r5);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r5) {
        this.mWrapped.onWindowAttributesChanged(r5);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r5) {
        this.mWrapped.onWindowFocusChanged(r5);
    }

    @Override // android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r5) {
        return this.mWrapped.onWindowStartingActionMode(r5);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mWrapped.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    @RequiresApi(23)
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r5, int r10) {
        return Api23Impl.onWindowStartingActionMode(this.mWrapped, r5, r10);
    }
}
