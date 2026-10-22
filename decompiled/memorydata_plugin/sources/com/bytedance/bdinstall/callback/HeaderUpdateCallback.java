package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.HeaderUpdateListener;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class HeaderUpdateCallback extends CallbackWrapper<HeaderChangeEvent, HeaderUpdateListener> implements Callback<HeaderChangeEvent> {
    public HeaderUpdateCallback(HeaderUpdateListener r3) {
        super((HeaderUpdateListener) ZeusTransformUtils.wrapperContextForParams(r3, HeaderUpdateListener.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: onCall, reason: avoid collision after fix types in other method */
    public void onCall2(HeaderChangeEvent r3) {
        HeaderUpdateListener r2 = (HeaderUpdateListener) ZeusTransformUtils.preCheckCast(getListener(), HeaderUpdateListener.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.onHeaderUpdate(r3.getHeaderCopy());
        return;
    }

    @Override // com.bytedance.bdinstall.callback.Callback
    public /* synthetic */ void onCall(HeaderChangeEvent r3) {
        onCall2((HeaderChangeEvent) ZeusTransformUtils.preCheckCast(r3, HeaderChangeEvent.class, "com.obric.memorydata.plugin"));
    }
}
