package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.HeaderUpdateListener;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;

/* JADX INFO: loaded from: classes.dex */
public class HeaderUpdateCallback extends CallbackWrapper<HeaderChangeEvent, HeaderUpdateListener> implements Callback<HeaderChangeEvent> {
    public HeaderUpdateCallback(HeaderUpdateListener r10) {
        super(r10);
    }

    /* JADX INFO: renamed from: onCall, reason: avoid collision after fix types in other method */
    public void onCall2(HeaderChangeEvent r10) {
        HeaderUpdateListener r11 = getListener();
        if (r11 == null) goto L6;
        r11.onHeaderUpdate(r10.getHeaderCopy());
        return;
    }

    @Override // com.bytedance.bdinstall.callback.Callback
    public /* bridge */ /* synthetic */ void onCall(HeaderChangeEvent r10) {
        onCall2(r10);
    }
}
