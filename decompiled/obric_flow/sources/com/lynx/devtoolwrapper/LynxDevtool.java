package com.lynx.devtoolwrapper;

import androidx.annotation.Keep;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.service.ILynxDevToolService;
import java.lang.ref.WeakReference;
import ko.r;
import mm.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LynxDevtool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ILynxDevToolService f9889a;

    @Keep
    private c mOwner;

    public final void a(LynxView r10, LynxTemplateRender r11) {
        TraceEvent.c("LynxDevtool initialized");
        LynxLog.b(2, "LynxDevtool", "Initialize LynxDevtool, lynxDebugEnabled:" + LynxEnv.inst().isLynxDebugEnabled());     // Catch: Exception -> L11
        new WeakReference(r10);     // Catch: Exception -> L11
        new WeakReference(r11);     // Catch: Exception -> L11
        if (LynxEnv.inst().isLynxDebugEnabled() == false) goto L22;
        LynxLog.b(2, "LynxDevtool", "devtoolEnabled:" + LynxEnv.inst().isDevtoolEnabled() + ", logBoxEnabled:" + LynxEnv.inst().isLogBoxEnabled() + ", debuggable:false");     // Catch: Exception -> L11
        f9889a = (ILynxDevToolService) r.g().e(ILynxDevToolService.class);     // Catch: Exception -> L11
        if (LynxEnv.inst().isDevtoolEnabled() == false) goto L14;
        ILynxDevToolService r5 = f9889a;     // Catch: Exception -> L11
        if (r5 == null) goto L14;
        r5.createInspectorOwner(r10, false);     // Catch: Exception -> L11
    L14:
        if (LynxEnv.inst().isLogBoxEnabled() == false) goto L18;
        ILynxDevToolService r12 = f9889a;     // Catch: Exception -> L11
        if (r12 == null) goto L18;
        r12.createLogBox(this);     // Catch: Exception -> L11
        LynxLog.b(2, "LynxDevtool", "LogBox init");     // Catch: Exception -> L11
    L18:
        if (r11 == null) goto L22;
        int r13 = r11.e.f10152u.widthPixels;     // Catch: Exception -> L11
    L22:
        TraceEvent.a(0, "LynxDevtool initialized");
        return;
    L11:
        e = move-exception;
        LynxLog.b(4, "LynxDevtool", "failed to init LynxDevtool: " + e.toString());
        goto L22
    }

    public void b(String r5, JSONObject r10) {
    }
}
