package com.bytedance.ies.xelement.input;

import android.text.Spannable;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.bytedance.ai.event.MessageIndication;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f6447a;

    public static boolean a(Spannable r5) {
        Intrinsics.checkNotNullParameter(r5, MessageIndication.CONTENT_TYPE_TEXT);
        int r10 = BaseInputConnection.getComposingSpanStart(r5);
        int r11 = BaseInputConnection.getComposingSpanEnd(r5);
        if (r10 == (-1)) goto L7;
        if (r11 == (-1)) goto L9;
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r5, int r10) {
        if (r5 != 1) goto L11;
        if (r10 != 0) goto L11;
        k r11 = this.f6447a;
        if (r11 == null) goto L11;
        Intrinsics.checkNotNull(r11);
        if (((r) r11).a() == false) goto L11;
        return true;
    L11:
        return super.deleteSurroundingText(r5, r10);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.getKeyCode() != 67) goto L13;
        if (r5.getAction() != 0) goto L13;
        k r10 = this.f6447a;
        if (r10 == null) goto L13;
        Intrinsics.checkNotNull(r10);
        if (((r) r10).a() == false) goto L13;
        return true;
    L13:
        return super.sendKeyEvent(r5);
    }
}
