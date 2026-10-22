package com.lynx.xelement.input;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnectionWrapper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends InputConnectionWrapper {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.lynx.xelement.input.a$a, reason: collision with other inner class name */
    public interface InterfaceC0069a {
    }

    public a() {
        super(null, true);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        if (r3.getKeyCode() != 67) goto L6;
        r3.getAction();
    L6:
        return super.sendKeyEvent(r3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence r1, int r2) {
        return super.commitText(r1, r2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r2, int r3) {
        return super.deleteSurroundingText(r2, r3);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean setComposingRegion(int r1, int r2) {
        return super.setComposingRegion(r1, r2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence r1, int r2) {
        return super.setComposingText(r1, r2);
    }
}
