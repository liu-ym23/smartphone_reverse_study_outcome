package android.app;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ActivityManagerEx {
    public ActivityManagerEx() {
    }

    public static ActivityManagerEx getInstance() {
        return null;
    }

    public boolean registerDisplayInfoCallbackEx(IDisplayInfoCallbackEx r2) {
        IDisplayInfoCallbackEx r1 = (IDisplayInfoCallbackEx) ZeusTransformUtils.wrapperContextForParams(r2, IDisplayInfoCallbackEx.class, "com.obric.memorydata.plugin");
        return false;
    }

    public boolean unregisterDisplayInfoCallbackEx(IDisplayInfoCallbackEx r2) {
        IDisplayInfoCallbackEx r1 = (IDisplayInfoCallbackEx) ZeusTransformUtils.wrapperContextForParams(r2, IDisplayInfoCallbackEx.class, "com.obric.memorydata.plugin");
        return false;
    }
}
