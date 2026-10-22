package com.obric.feature.miniapp.widget.depend;

import android.app.Activity;
import com.bytedance.ai.bridge.service.IHostLocationPermissionDepend;
import com.bytedance.ai.bridge.service.OnPermissionGrantCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n1.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/feature/miniapp/widget/depend/ObricLauncherHostLocationPermissionServiceImpl;", "Lcom/bytedance/ai/bridge/service/IHostLocationPermissionDepend;", "<init>", "()V", "Landroid/app/Activity;", "activity", "Ln1/c;", "bridgeContext", "", "bridgeName", "Lcom/bytedance/ai/bridge/service/OnPermissionGrantCallback;", "callback", "", "requestPermission", "(Landroid/app/Activity;Ln1/c;Ljava/lang/String;Lcom/bytedance/ai/bridge/service/OnPermissionGrantCallback;)V", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricLauncherHostLocationPermissionServiceImpl implements IHostLocationPermissionDepend {
    public ObricLauncherHostLocationPermissionServiceImpl() {
    }

    @Override // com.bytedance.ai.bridge.service.IHostLocationPermissionDepend
    public void requestPermission(Activity r5, c r10, String r11, OnPermissionGrantCallback r12) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "bridgeName");
        Intrinsics.checkNotNullParameter(r12, "callback");
        r12.onNotGranted();
    }
}
