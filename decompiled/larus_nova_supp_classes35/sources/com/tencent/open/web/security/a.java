package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.log.SLog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class a extends InputConnectionWrapper {
    public static String a;
    public static boolean b;
    public static boolean c;

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent r4) {
        if (r4.getAction() != 0) goto L5;
        SLog.i("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
        a = String.valueOf((char) r4.getUnicodeChar());
        c = true;
        SLog.d("openSDK_LOG.CaptureInputConnection", "s: " + a);
    L5:
        SLog.d("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + a);
        return super.sendKeyEvent(r4);
    }

    public a(InputConnection r1, boolean r2) {
        super(r1, r2);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence r3, int r4) {
        c = true;
        a = r3.toString();
        SLog.v("openSDK_LOG.CaptureInputConnection", "-->commitText: " + r3.toString());
        return super.commitText(r3, r4);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence r3, int r4) {
        c = true;
        a = r3.toString();
        SLog.v("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + r3.toString());
        return super.setComposingText(r3, r4);
    }
}
