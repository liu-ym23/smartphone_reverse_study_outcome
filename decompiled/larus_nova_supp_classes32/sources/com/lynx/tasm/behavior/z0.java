package com.lynx.tasm.behavior;

import com.lynx.devtoolwrapper.CDPResultCallback;
import com.lynx.devtoolwrapper.LynxBaseInspectorOwner;
import com.lynx.tasm.base.LLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z0 implements CDPResultCallback {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ JSONObject b;
    public final /* synthetic */ LynxBaseInspectorOwner c;
    public final /* synthetic */ b1 d;

    @Override // com.lynx.devtoolwrapper.CDPResultCallback
    public final void onResult(String r5) {
        b1.a(this.d, this.a, this.b, this.c, r5);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("LynxTouchEventDispatcher", "setAttributeByInvokeCDP error:" + e.toString());
    }

    public z0(b1 r1, JSONObject r2, JSONObject r3, LynxBaseInspectorOwner r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
