package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m extends InputConnectionWrapper {
    public final Editable a;

    public m(TextView r2, InputConnection r3) {
        Intrinsics.checkNotNullParameter(r2, "editText");
        Intrinsics.checkNotNullParameter(r3, "inputConnection");
        super(r3, false);
        this.a = r2.getEditableText();
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r3, int r4) {
        h r0 = h.a;
        if (h.a(this, this.a, r3, r4, false) == false) goto L5;
    L6:
        return true;
    L5:
        if (super.deleteSurroundingText(r3, r4) == true) goto L6;
        return false;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int r3, int r4) {
        h r0 = h.a;
        if (h.a(this, this.a, r3, r4, true) == false) goto L5;
        return true;
    L5:
        if (super.deleteSurroundingTextInCodePoints(r3, r4) == true) goto L10;
        return false;
    L10:
        return true;
    }
}
