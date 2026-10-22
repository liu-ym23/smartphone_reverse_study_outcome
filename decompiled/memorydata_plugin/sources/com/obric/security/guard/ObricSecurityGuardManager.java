package com.obric.security.guard;

import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ObricSecurityGuardManager {
    public ObricSecurityGuardManager() {
    }

    public void bdSettingsEventEnd(Context r1, int r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public void bdSettingsEventStart(Context r1, int r2, Bundle r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public void registerSettingsEventObserver(IObricSettingsEventObserver r2) {
        IObricSettingsEventObserver r1 = (IObricSettingsEventObserver) ZeusTransformUtils.wrapperContextForParams(r2, IObricSettingsEventObserver.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }

    public void unregisterSettingsEventObserver(IObricSettingsEventObserver r2) {
        IObricSettingsEventObserver r1 = (IObricSettingsEventObserver) ZeusTransformUtils.wrapperContextForParams(r2, IObricSettingsEventObserver.class, "com.obric.memorydata.plugin");
        throw new RuntimeException("Stub!!");
    }
}
