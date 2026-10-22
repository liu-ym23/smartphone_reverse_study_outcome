package com.lynx.debugrouter;

import android.view.View;
import com.lynx.debugrouter.log.LLog;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DebugRouterSlot {
    private static final String TAG = "DebugRouterSlot";
    private DebugRouterSlotDelegate mDelegate;
    private boolean mPlugged;
    private int mSessionId;
    private String mType;

    public void clearScreenCastCache() {
    }

    public String getTemplateUrl() {
        DebugRouterSlotDelegate r0 = this.mDelegate;
        if (r0 != null) goto L5;
        return "___UNKNOWN___";
    L5:
        if (r0.getTemplateUrl() != null) goto L7;
        return "___UNKNOWN___";
    L7:
        return this.mDelegate.getTemplateUrl();
    }

    public View getTemplateView() {
        DebugRouterSlotDelegate r0 = this.mDelegate;
        if (r0 == null) goto L11;
        return (View) r0.getClass().getMethod("getTemplateView", new Class[0]).invoke(this.mDelegate, new Object[0]);
    L6:
        LLog.e(TAG, "failed to invoke getTemplateView");
        return null;
    L11:
        return null;
    }

    public void pull() {
        if (this.mPlugged == false) goto L6;
        DebugRouter.getInstance().pull(this.mSessionId);
        this.mPlugged = false;
        return;
    }

    public void dispatchDocumentUpdated() {
        sendDataAsync("CDP", MessageAssembler.assembleDispatchDocumentUpdated());
    }

    public int plug() {
        pull();
        int r0 = DebugRouter.getInstance().plug(this);
        this.mSessionId = r0;
        this.mPlugged = true;
        return r0;
    }

    public String getType() {
        return this.mType;
    }

    public DebugRouterSlot(DebugRouterSlotDelegate r2) {
        this.mType = NameKeys.UnloadStrategy_No_Strategy;
        this.mDelegate = r2;
    }

    public void dispatchFrameNavigated(String r2) {
        sendDataAsync("CDP", MessageAssembler.assembleDispatchFrameNavigated(r2));
    }

    public void dispatchScreencastVisibilityChanged(boolean r2) {
        sendDataAsync("CDP", MessageAssembler.assembleDispatchScreencastVisibilityChanged(r2));
    }

    public void send(String r2) {
        DebugRouter.getInstance().send(r2);
    }

    public void sendAsync(String r2) {
        DebugRouter.getInstance().sendAsync(r2);
    }

    public void setType(String r1) {
        this.mType = r1;
    }

    public void onMessage(String r2, String r3) {
        DebugRouterSlotDelegate r0 = this.mDelegate;
        if (r0 == null) goto L6;
        r0.onMessage(r2, r3);
        return;
    }

    public void sendData(String r3, String r4) {
        DebugRouter.getInstance().sendData(r3, this.mSessionId, r4);
    }

    public void sendDataAsync(String r3, String r4) {
        DebugRouter.getInstance().sendDataAsync(r3, this.mSessionId, r4);
    }

    public void sendScreenCast(String r2, Map<String, Float> r3) {
        sendDataAsync("CDP", MessageAssembler.assembleScreenCastFrame(this.mSessionId, r2, r3));
    }

    public void sendData(String r3, String r4, int r5) {
        DebugRouter.getInstance().sendData(r3, this.mSessionId, r4, r5);
    }

    public void sendDataAsync(String r3, String r4, int r5) {
        DebugRouter.getInstance().sendDataAsync(r3, this.mSessionId, r4, r5);
    }
}
