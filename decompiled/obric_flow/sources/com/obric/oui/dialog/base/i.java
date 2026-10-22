package com.obric.oui.dialog.base;

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
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Window.Callback f13124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13125c;

    public i(d6.c r5, Window.Callback r10) {
        this.f13123a = 1;
        this.f13125c = r5;
        this.f13124b = r10;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent r5) {
        switch(this.f13123a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f13124b.dispatchGenericMotionEvent(r5);
    L7:
        return this.f13124b.dispatchGenericMotionEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r5) {
        switch(this.f13123a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        d6.c r10 = (d6.c) this.f13125c;
        if (r10.f == true) goto L8;
        r10.f16600b.d(r5.getEventTime());
    L8:
        return this.f13124b.dispatchKeyEvent(r5);
    L9:
        Intrinsics.checkNotNullParameter(r5, "event");
        j r11 = (j) ((WeakReference) this.f13125c).get();
        if (r11 == null) goto L19;
        if (r5.getKeyCode() != 4) goto L19;
        if (r5.getAction() != 1) goto L19;
        if (r11.f13136o == false) goto L19;
        r11.cancel();
        return true;
    L19:
        return this.f13124b.dispatchKeyEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent r5) {
        switch(this.f13123a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f13124b.dispatchKeyShortcutEvent(r5);
    L7:
        return this.f13124b.dispatchKeyShortcutEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r5) {
        switch(this.f13123a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f13124b.dispatchPopulateAccessibilityEvent(r5);
    L7:
        return this.f13124b.dispatchPopulateAccessibilityEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        switch(this.f13123a) {
            case 0: goto L10;
            default: goto L4;
        };
    L4:
        d6.c r10 = (d6.c) this.f13125c;
        if (r10.f == true) goto L8;
        r10.f16600b.d(r5.getEventTime());
    L8:
        return this.f13124b.dispatchTouchEvent(r5);
    L10:
        return this.f13124b.dispatchTouchEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent r5) {
        switch(this.f13123a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f13124b.dispatchTrackballEvent(r5);
    L7:
        return this.f13124b.dispatchTrackballEvent(r5);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode r5) {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f13124b.onActionModeFinished(r5);
        return;
    L6:
        this.f13124b.onActionModeFinished(r5);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode r5) {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f13124b.onActionModeStarted(r5);
        return;
    L6:
        this.f13124b.onActionModeStarted(r5);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f13124b.onAttachedToWindow();
        return;
    L6:
        this.f13124b.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f13124b.onContentChanged();
        return;
    L6:
        this.f13124b.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int r5, Menu r10) {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        Intrinsics.checkNotNullParameter(r10, "p1");
        return this.f13124b.onCreatePanelMenu(r5, r10);
    L5:
        return this.f13124b.onCreatePanelMenu(r5, r10);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int r5) {
        switch(this.f13123a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f13124b.onCreatePanelView(r5);
    L7:
        return this.f13124b.onCreatePanelView(r5);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f13124b.onDetachedFromWindow();
        return;
    L6:
        this.f13124b.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int r5, MenuItem r10) {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        Intrinsics.checkNotNullParameter(r10, "p1");
        return this.f13124b.onMenuItemSelected(r5, r10);
    L5:
        return this.f13124b.onMenuItemSelected(r5, r10);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int r5, Menu r10) {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        Intrinsics.checkNotNullParameter(r10, "p1");
        return this.f13124b.onMenuOpened(r5, r10);
    L5:
        return this.f13124b.onMenuOpened(r5, r10);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int r5, Menu r10) {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f13124b.onPanelClosed(r5, r10);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r10, "p1");
        this.f13124b.onPanelClosed(r5, r10);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int r5, View r10, Menu r11) {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        Intrinsics.checkNotNullParameter(r11, "p2");
        return this.f13124b.onPreparePanel(r5, r10, r11);
    L5:
        return this.f13124b.onPreparePanel(r5, r10, r11);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        switch(this.f13123a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f13124b.onSearchRequested();
    L7:
        return this.f13124b.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams r5) {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f13124b.onWindowAttributesChanged(r5);
        return;
    L6:
        this.f13124b.onWindowAttributesChanged(r5);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r5) {
        switch(this.f13123a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        this.f13124b.onWindowFocusChanged(r5);
        return;
    L6:
        this.f13124b.onWindowFocusChanged(r5);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r5) {
        switch(this.f13123a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f13124b.onWindowStartingActionMode(r5);
    L7:
        return this.f13124b.onWindowStartingActionMode(r5);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent r5) {
        switch(this.f13123a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f13124b.onSearchRequested(r5);
    L7:
        return this.f13124b.onSearchRequested(r5);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r5, int r10) {
        switch(this.f13123a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return this.f13124b.onWindowStartingActionMode(r5, r10);
    L7:
        return this.f13124b.onWindowStartingActionMode(r5, r10);
    }

    public i(com.obric.oui.dialog.v2.alert.f r5, Window.Callback r10) {
        this.f13123a = 0;
        Intrinsics.checkNotNullParameter(r5, "dialog");
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.f13124b = r10;
        this.f13125c = new WeakReference(r5);
    }
}
