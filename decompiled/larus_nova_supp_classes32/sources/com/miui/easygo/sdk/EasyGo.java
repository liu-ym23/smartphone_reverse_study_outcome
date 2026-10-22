package com.miui.easygo.sdk;

import android.content.Context;
import android.os.Bundle;
import com.miui.easygo.callback.IEasyGoCallback;
import com.miui.easygo.manager.EasyGoManager;
import com.miui.easygo.sdk.constant.EasyGoCode;
import com.miui.easygo.sdk.module.EasyGoRet;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class EasyGo {
    private static final String TAG = "EasyGo";
    private EasyGoManager mEasyGoManager;

    public final void release() {
        EasyGoManager r0 = this.mEasyGoManager;
        if (r0 == null) goto L6;
        r0.release();
        return;
    }

    public EasyGo(Context r2) {
        this.mEasyGoManager = null;
        if (getRomSupStatus(r2) != 0) goto L6;
        this.mEasyGoManager = new EasyGoManager(r2);
        return;
    }

    private List<Integer> assembleInitFailRet(String[] r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return Collections.nCopies(r2.length, 507);
    }

    private int getRomSupStatus(Context r3) {
        return new EasyGoManager(r3).getRomSupStatus(r3, "1.0.2");
    L4:
        return EasyGoCode.InitializedErrCode.UNKNOWN_ERR;
    L8:
        return 506;
    L6:
        return EasyGoCode.InitializedErrCode.PERMISSION_DENIED;
    }

    public final List<Integer> init(String[] r2) {
        EasyGoManager r0 = this.mEasyGoManager;
        if (r0 != null) goto L6;
        return assembleInitFailRet(r2);
    L6:
        return r0.init(r2);
    }

    public final EasyGoRet invokeSync(String r2, String r3, JSONObject r4, Bundle r5) {
        EasyGoManager r0 = this.mEasyGoManager;
        if (r0 != null) goto L6;
        return new EasyGoRet(507, new Bundle());
    L6:
        return r0.invokeSync(r2, r3, r4, r5);
    }

    public final void invokeAsync(String r7, String r8, JSONObject r9, Bundle r10, IEasyGoCallback r11) {
        EasyGoManager r0 = this.mEasyGoManager;
        if (r0 == null) goto L6;
        r0.invokeAsync(r7, r8, r9, r10, r11);
        return;
    }
}
