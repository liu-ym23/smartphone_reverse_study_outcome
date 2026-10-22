package com.bytedance.ai.bridge.service;

import android.app.Activity;
import com.bytedance.android.ec.core.event.a;
import e3.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostLocationPermissionDepend;", "", "requestPermission", "", a.VALUE_ACTIVITY, "Landroid/app/Activity;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "bridgeName", "", "callback", "Lcom/bytedance/ai/bridge/service/OnPermissionGrantCallback;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IHostLocationPermissionDepend {
    void requestPermission(Activity r1, d r10, String r11, OnPermissionGrantCallback r12);
}
