package com.lynx.devtool.logbox;

import a5a.a;
import android.content.Context;
import com.lynx.basedevtool.logbox.LogBoxLogLevel;
import com.lynx.basedevtool.logbox.LogBoxProxy;
import com.lynx.devtoolwrapper.ILynxLogBox;
import com.lynx.devtoolwrapper.LynxDevtool;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxLogBoxWrapper implements ILynxLogBox, a {
    private static final String TAG = "LynxLogBoxWrapper";
    private WeakReference<LynxDevtool> mDevtool;
    private LogBoxProxy mLogBoxProxy;

    @Override // a5a.a
    public String getEntryUrlForLogSrc() {
        LynxDevtool r0 = this.mDevtool.get();
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0.getTemplateUrl();
    }

    @Override // a5a.a
    public Map<String, Object> getLogSources() {
        LynxDevtool r0 = this.mDevtool.get();
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getAllJsSource();
    }

    @Override // com.lynx.devtoolwrapper.ILynxLogBox
    public void onLoadTemplate() {
        this.mLogBoxProxy.reset();
    }

    public LynxLogBoxWrapper(LynxDevtool r3) {
        this.mDevtool = new WeakReference(r3);
        if (r3 == null) goto L5;
        LynxContext r4 = r3.getLynxContext();
    L6:
        LogBoxProxy r0 = new LogBoxProxy(r4, "lynx", this);
        this.mLogBoxProxy = r0;
        r0.registerErrorParser("logbox/lynx-error-parser.js");
        return;
    L5:
        r4 = null;
        goto L6
    }

    @Override // com.lynx.devtoolwrapper.ILynxLogBox
    public void attachContext(Context r2) {
        this.mLogBoxProxy.attachContext(r2);
    }

    @Override // a5a.a
    public String getLogSourceWithFileName(String r8) {
        LynxDevtool r0 = this.mDevtool.get();
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        if (r8.endsWith("main-thread.js") == true) goto L8;
        Iterator<Map.Entry<String, Object>> r2 = getLogSources().entrySet().iterator();
        int r3 = 0;
    L11:
        if (r2.hasNext() == false) goto L17;
        Map.Entry<String, Object> r4 = r2.next();
        String r5 = r4.getKey();
        if (r8.endsWith(r5) == false) goto L11;
        if (r5.length() <= r3) goto L11;
        int r6 = r5.length();
        String r7 = (String) r4.getValue();
        r3 = r6;
        r1 = r7;
        goto L11
    L17:
        return r1;
    L8:
        return r0.getDebugInfoUrl(r8);
    }

    @Override // com.lynx.devtoolwrapper.ILynxLogBox
    public void showLogMessage(LynxError r3) {
        String r0 = r3.getMsg();
        if (r3.getLevel().equals(LynxError.LEVEL_WARN) == false) goto L5;
        LogBoxLogLevel r4 = LogBoxLogLevel.Warn;
    L6:
        sendErrorEventToPerf(r0, r4);
        this.mLogBoxProxy.showLogMessage(r0, r4);
        return;
    L5:
        r4 = LogBoxLogLevel.Error;
        goto L6
    }

    public void sendErrorEventToPerf(String r3, LogBoxLogLevel r4) {
        if (r4 != LogBoxLogLevel.Info) goto L5;
        return;
    L5:
        LynxDevtool r5 = this.mDevtool.get();
        if (r5 != null) goto L13;
        return;
    L13:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L10
        r0.put("error", r3);     // Catch: JSONException -> L10
        r5.onPerfMetricsEvent("lynx_error_event", r0);     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        LLog.e(TAG, e.toString());
    }
}
