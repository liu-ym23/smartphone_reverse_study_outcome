package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.IInstallListener;
import com.bytedance.bdinstall.callback.event.InstallFinishEvent;

/* JADX INFO: loaded from: classes.dex */
public class InstallFinishCallback extends CallbackWrapper<InstallFinishEvent, IInstallListener> implements Callback<InstallFinishEvent> {
    public InstallFinishCallback(IInstallListener r10) {
        super(r10);
    }

    /* JADX INFO: renamed from: onCall, reason: avoid collision after fix types in other method */
    public void onCall2(InstallFinishEvent r10) {
        IInstallListener r11 = getListener();
        if (r11 == null) goto L6;
        r11.installFinished(r10.getInfo());
        return;
    }

    @Override // com.bytedance.bdinstall.callback.Callback
    public /* bridge */ /* synthetic */ void onCall(InstallFinishEvent r10) {
        onCall2(r10);
    }
}
