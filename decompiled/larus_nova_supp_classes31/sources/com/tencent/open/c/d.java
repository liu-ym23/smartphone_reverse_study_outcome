package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.log.SLog;
import com.tencent.open.web.security.SecureJsInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public class d extends b {
    public static boolean a;
    private KeyEvent b;
    private com.tencent.open.web.security.a c;

    public d(Context r1) {
        super(r1);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r3) {
        SLog.d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + a);
        if (a == true) goto L7;
        return super.dispatchKeyEvent(r3);
    L7:
        if (r3.getAction() != 0) goto L39;
        int r0 = r3.getKeyCode();
        if (r0 == 4) goto L37;
        if (r0 == 66) goto L35;
        if (r0 != 67) goto L15;
        com.tencent.open.web.security.a.b = true;
        return super.dispatchKeyEvent(r3);
    L15:
        if (r3.getUnicodeChar() != 0) goto L19;
        return super.dispatchKeyEvent(r3);
    L19:
        if (SecureJsInterface.isPWDEdit == false) goto L31;
        int r1 = r3.getUnicodeChar();
        if (r1 < 33) goto L25;
        if (r1 > 95) goto L25;
    L28:
        KeyEvent r4 = new KeyEvent(0, 17);
        this.b = r4;
        return super.dispatchKeyEvent(r4);
    L25:
        if (r1 < 97) goto L31;
        if (r1 <= 125) goto L28;
    L31:
        return super.dispatchKeyEvent(r3);
    L35:
        return super.dispatchKeyEvent(r3);
    L37:
        return super.dispatchKeyEvent(r3);
    L39:
        return super.dispatchKeyEvent(r3);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r5) {
        SLog.i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection r0 = super.onCreateInputConnection(r5);
        SLog.v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + r0);
        if (r0 == null) goto L6;
        a = true;
        com.tencent.open.web.security.a r1 = new com.tencent.open.web.security.a(super.onCreateInputConnection(r5), false);
        this.c = r1;
        return r1;
    L6:
        a = false;
        return r0;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r3, KeyEvent r4) {
        SLog.d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + a);
        if (a == true) goto L7;
        return super.onKeyDown(r3, r4);
    L7:
        if (r4.getAction() != 0) goto L39;
        int r0 = r4.getKeyCode();
        if (r0 == 4) goto L37;
        if (r0 == 66) goto L35;
        if (r0 != 67) goto L15;
        com.tencent.open.web.security.a.b = true;
        return super.onKeyDown(r3, r4);
    L15:
        if (r4.getUnicodeChar() != 0) goto L19;
        return super.onKeyDown(r3, r4);
    L19:
        if (SecureJsInterface.isPWDEdit == false) goto L31;
        int r1 = r4.getUnicodeChar();
        if (r1 < 33) goto L25;
        if (r1 > 95) goto L25;
    L28:
        KeyEvent r5 = new KeyEvent(0, 17);
        this.b = r5;
        return super.onKeyDown(r5.getKeyCode(), this.b);
    L25:
        if (r1 < 97) goto L31;
        if (r1 <= 125) goto L28;
    L31:
        return super.onKeyDown(r3, r4);
    L35:
        return super.onKeyDown(r3, r4);
    L37:
        return super.onKeyDown(r3, r4);
    L39:
        return super.onKeyDown(r3, r4);
    }
}
