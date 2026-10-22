package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.IInstallListener;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class InstallFinishCallback extends CallbackWrapper<InstallFinishEvent, IInstallListener> implements Callback<InstallFinishEvent> {
    public InstallFinishCallback(IInstallListener r3) {
        super((IInstallListener) ZeusTransformUtils.wrapperContextForParams(r3, IInstallListener.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: onCall, reason: avoid collision after fix types in other method */
    public void onCall2(InstallFinishEvent r3) {
        IInstallListener r2 = (IInstallListener) ZeusTransformUtils.preCheckCast(getListener(), IInstallListener.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r2.installFinished(r3.getInfo());
        return;
    }

    @Override // com.bytedance.bdinstall.callback.Callback
    public /* synthetic */ void onCall(InstallFinishEvent r3) {
        onCall2((InstallFinishEvent) ZeusTransformUtils.preCheckCast(r3, InstallFinishEvent.class, "com.obric.memorydata.plugin"));
    }
}
