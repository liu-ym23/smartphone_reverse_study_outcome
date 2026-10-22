package com.larus.dora.impl.device.settings.gesture;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class q implements IDoraLinkCallback {
    public /* synthetic */ q() {
    }

    public final /* synthetic */ void onBtConnectStateChanged(DoraDevice r1, int r2, int r3) {
        IDoraLinkCallback.-CC.$default$onBtConnectStateChanged(this, r1, r2, r3);
    }

    public final /* synthetic */ void onBtStateChanged(int r1, int r2) {
        IDoraLinkCallback.-CC.$default$onBtStateChanged(this, r1, r2);
    }

    public final /* synthetic */ void onDeviceFound(DoraDevice r1) {
        IDoraLinkCallback.-CC.$default$onDeviceFound(this, r1);
    }

    public final /* synthetic */ void onScanFailed(int r1) {
        IDoraLinkCallback.-CC.$default$onScanFailed(this, r1);
    }

    public final void onDoraLinkStateChanged(DoraDevice r7, int r8, int r9) {
        g49.d.d("DoraGGestureSettingsRepository", "DoraLinkCallback: " + r7 + ", " + r9);
        if (r7 != null) goto L6;
        return;
    L6:
        if (r9 != 2) goto L9;
        DoraGGestureSettingsRepository r10 = DoraGGestureSettingsRepository.a;
        BuildersKt.launch$default((CoroutineScope) DoraGGestureSettingsRepository.k.getValue(), null, null, new DoraGGestureSettingsRepository$init$1$1(null), 3, null);
        return;
    }
}
