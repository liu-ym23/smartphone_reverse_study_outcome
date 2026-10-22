package androidx.core.content;

import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class UnusedAppRestrictionsBackportCallback {
    private IUnusedAppRestrictionsBackportCallback mCallback;

    public UnusedAppRestrictionsBackportCallback(IUnusedAppRestrictionsBackportCallback r3) {
        this.mCallback = (IUnusedAppRestrictionsBackportCallback) ZeusTransformUtils.wrapperContextForParams(r3, IUnusedAppRestrictionsBackportCallback.class, "com.obric.memorydata.plugin");
    }

    public void onResult(boolean r1, boolean r2) {
        this.mCallback.onIsPermissionRevocationEnabledForAppResult(r1, r2);
    }
}
