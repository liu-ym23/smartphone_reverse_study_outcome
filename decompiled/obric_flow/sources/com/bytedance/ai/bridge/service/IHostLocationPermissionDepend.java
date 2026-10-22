package com.bytedance.ai.bridge.service;

import android.app.Activity;
import androidx.annotation.Keep;
import kotlin.Metadata;
import n1.c;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostLocationPermissionDepend;", "", "Landroid/app/Activity;", "activity", "Ln1/c;", "bridgeContext", "", "bridgeName", "Lcom/bytedance/ai/bridge/service/OnPermissionGrantCallback;", "callback", "", "requestPermission", "(Landroid/app/Activity;Ln1/c;Ljava/lang/String;Lcom/bytedance/ai/bridge/service/OnPermissionGrantCallback;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IHostLocationPermissionDepend {
    void requestPermission(Activity r5, c r10, String r11, OnPermissionGrantCallback r12);
}
