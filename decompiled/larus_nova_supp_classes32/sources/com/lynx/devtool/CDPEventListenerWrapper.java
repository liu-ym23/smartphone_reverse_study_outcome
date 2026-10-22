package com.lynx.devtool;

import com.lynx.devtoolwrapper.CDPEventListener;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CDPEventListenerWrapper {
    private WeakReference<CDPEventListener> listenerRef;

    public CDPEventListenerWrapper(CDPEventListener r2) {
        this.listenerRef = new WeakReference(r2);
    }

    public void onEvent(String r2) {
        CDPEventListener r0 = this.listenerRef.get();
        if (r0 == null) goto L6;
        r0.onEvent(r2);
        return;
    }
}
