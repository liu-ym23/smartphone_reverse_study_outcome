package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.IOaidObserver;
import com.bytedance.bdinstall.callback.event.OaidChangeEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class OaidCallback extends CallbackWrapper<OaidChangeEvent, IOaidObserver> implements Callback<OaidChangeEvent> {
    public OaidCallback(IOaidObserver r3) {
        super((IOaidObserver) ZeusTransformUtils.wrapperContextForParams(r3, IOaidObserver.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: onCall, reason: avoid collision after fix types in other method */
    public void onCall2(OaidChangeEvent r3) {
        IOaidObserver r2 = (IOaidObserver) ZeusTransformUtils.preCheckCast(getListener(), IOaidObserver.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.onOaidLoaded(r3.getOaid());
        return;
    }

    @Override // com.bytedance.bdinstall.callback.Callback
    public /* synthetic */ void onCall(OaidChangeEvent r3) {
        onCall2((OaidChangeEvent) ZeusTransformUtils.preCheckCast(r3, OaidChangeEvent.class, "com.obric.memorydata.plugin"));
    }
}
