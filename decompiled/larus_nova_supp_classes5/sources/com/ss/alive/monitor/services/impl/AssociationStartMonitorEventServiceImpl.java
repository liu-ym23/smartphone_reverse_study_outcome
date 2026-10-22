package com.ss.alive.monitor.services.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.process.cross.CrossProcessHelper;
import com.bytedance.common.process.cross.IMethodObserver;
import com.bytedance.common.push.BaseJson;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.push.utils.f;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import sqa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class AssociationStartMonitorEventServiceImpl extends BaseJson implements a, IMethodObserver {
    private final String ALOG_TAG;
    private final String ASSOCIATION_START_METHOD_NAME;
    private final String TAG;
    private boolean mEnableReport;
    private boolean mIsActive;
    private ProcessEnum mProcessEnum;

    public String getMethodName() {
        return "onAssociationStartEvent";
    }

    @Override // sqa.a
    public void onUserActive() {
        this.mIsActive = true;
    }

    public AssociationStartMonitorEventServiceImpl(Context r3) {
        this.TAG = "AssociationStartMonitor";
        this.ALOG_TAG = "ALOG_ASSOCIATION_START_MONITOR";
        this.ASSOCIATION_START_METHOD_NAME = "onAssociationStartEvent";
        this.mEnableReport = false;
        ProcessEnum r0 = ToolUtils.getCurProcess(r3);
        this.mProcessEnum = r0;
        if (r0 != ProcessEnum.MAIN) goto L6;
        CrossProcessHelper.getInstance().registerMethodObserver(this);
        this.mIsActive = ToolUtils.isActiveUser(r3);
        return;
    }

    @Override // sqa.a
    public void enableReport(boolean r1) {
        this.mEnableReport = r1;
    }

    @Override // sqa.a
    public void onAssociationStartEvent(pqa.a r3) {
        monitorEvent("association_start_event", r3.b(), null, null);
    }

    public String onMethodCall(ProcessEnum r7, List r8) {
    L21:
        th = move-exception;
        f.e("AssociationStartMonitor", "onMethodCall error : origin processName is " + r7);
        th.printStackTrace();
    L23:
        return null;
    L4:
        if (this.mProcessEnum != ProcessEnum.MAIN) goto L23;
        if (r8.size() != 4) goto L23;
        f.e("AssociationStartMonitor", "recv  rom the chain-start record of " + r7);     // Catch: Throwable -> L21
        String r1 = (String) ListProtector.get(r8, 1);     // Catch: Throwable -> L21
        String r3 = (String) ListProtector.get(r8, 2);     // Catch: Throwable -> L21
        String r4 = (String) ListProtector.get(r8, 3);     // Catch: Throwable -> L21
        String r9 = (String) ListProtector.get(r8, 0);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r1) == false) goto L10;
        JSONObject r5 = null;
    L12:
        if (TextUtils.isEmpty(r3) == false) goto L14;
        JSONObject r2 = null;
    L16:
        if (TextUtils.isEmpty(r4) == false) goto L18;
        JSONObject r6 = null;
    L19:
        monitorEventInternal(r9, r5, r2, r6);     // Catch: Throwable -> L21
        goto L23
    L18:
        r6 = new JSONObject(r4);     // Catch: Throwable -> L21
        goto L19
    L14:
        r2 = new JSONObject(r3);     // Catch: Throwable -> L21
        goto L16
    L10:
        r5 = new JSONObject(r1);     // Catch: Throwable -> L21
        goto L12
    }

    private void monitorEventInternal(String r4, JSONObject r5, JSONObject r6, JSONObject r7) {
        if (this.mProcessEnum == ProcessEnum.MAIN) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        r5 = new JSONObject();
    L7:
        add(r5, EffectConfiguration.KEY_SDK_VERSION, "1.0");
        if (this.mIsActive == false) goto L10;
        long r0 = 1;
    L11:
        add(r5, "is_active", r0);
        f.b("AssociationStartMonitor", "[monitorEventInternal] serviceName is " + r4);
        PushServiceManager.get().getPushExternalService().monitorEvent(r4, r5, r6, r7);
        return;
    L10:
        r0 = 0;
        goto L11
    }

    public void monitorEvent(String r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        if (this.mEnableReport == true) goto L5;
        return;
    L5:
        ProcessEnum r0 = this.mProcessEnum;
        ProcessEnum r1 = ProcessEnum.MAIN;
        if (r0 != r1) goto L8;
        monitorEventInternal(r3, r4, r5, r6);
        return;
    L8:
        ArrayList r2 = new ArrayList();
        r2.add(r3);
        String r7 = "";
        if (r4 != null) goto L11;
        String r8 = "";
    L12:
        r2.add(r8);
        if (r5 != null) goto L15;
        String r9 = "";
    L16:
        r2.add(r9);
        if (r6 == null) goto L20;
        r7 = r6.toString();
    L20:
        r2.add(r7);
        CrossProcessHelper.getInstance().callMethod(r1, "onAssociationStartEvent", r2, true);
        return;
    L15:
        r9 = r5.toString();
        goto L16
    L11:
        r8 = r4.toString();
        goto L12
    }

    @Override // sqa.a
    public void onHookResult(String r3, boolean r4, String r5, long r6) {
        JSONObject r0 = new JSONObject();
        add(r0, "hook_name", r3);
        add(r0, "result", r4);
        add(r0, "msg", r5);
        add(r0, "process", this.mProcessEnum.processSuffix);
        add(r0, "client_time", ToolUtils.currentTimeMillis());
        JSONObject r7 = new JSONObject();
        add(r7, "duration", r6);
        monitorEvent("push_hook_result", r0, r7, null);
    }
}
