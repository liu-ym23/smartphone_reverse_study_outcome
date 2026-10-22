package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.IOaidObserver;
import com.bytedance.bdinstall.callback.event.OaidChangeEvent;

/* JADX INFO: loaded from: classes.dex */
public class OaidCallback extends CallbackWrapper<OaidChangeEvent, IOaidObserver> implements Callback<OaidChangeEvent> {
    public OaidCallback(IOaidObserver r10) {
        super(r10);
    }

    /* JADX INFO: renamed from: onCall, reason: avoid collision after fix types in other method */
    public void onCall2(OaidChangeEvent r10) {
        IOaidObserver r11 = getListener();
        if (r11 == null) goto L6;
        r11.onOaidLoaded(r10.getOaid());
        return;
    }

    @Override // com.bytedance.bdinstall.callback.Callback
    public /* bridge */ /* synthetic */ void onCall(OaidChangeEvent r10) {
        onCall2(r10);
    }
}
