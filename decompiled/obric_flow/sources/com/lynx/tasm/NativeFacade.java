package com.lynx.tasm;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.room.solver.CodeGenScope;
import com.lynx.base.log.LynxLog;
import com.lynx.devtoolwrapper.LynxDevtoolGlobalHelper;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.jsbridge.MethodDescriptor;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.CalledByNative;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.utils.CallStackUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class NativeFacade {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f10047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p0 f10048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f10049c;
    public WeakReference d;
    public final boolean e;
    public LynxModuleFactory f;

    public NativeFacade(boolean r5) {
        this.f = null;
        this.e = r5;
    }

    @CalledByNative
    private void InvokeUIMethod(LynxGetUIResult r5, String r10, JavaOnlyMap r11, int r12) {
        WeakReference r13 = this.d;
        if (r13 == null) goto L24;
        LynxContext r14 = (LynxContext) r13.get();
        if (r14 != null) goto L8;
        return;
    L8:
        if (((com.lynx.tasm.behavior.n0) r14.f10147o.get()) == null) goto L22;
        al.a r15 = new al.a(this, r12);
        LynxBaseUI r16 = ((com.lynx.tasm.behavior.n0) r14.f10147o.get()).v(r5.f10002a.getInt(0));
        if (r16 != null) goto L12;
        r15.invoke(new Object[]{6, "node does not have a LynxUI"});
        return;
    L12:
        if (TraceController.g == false) goto L14;
        String r17 = "UIOwner.invokeUIMethodForSelectorQuery." + r16.getTagName() + "." + r10;
        TraceEvent.c(r17);
    L15:
        com.lynx.tasm.behavior.utils.c.a(r16, r10, r11, r15);
        if (TraceController.g == false) goto L23;
        TraceEvent.a(0, r17);
        return;
    L23:
        return;
    L14:
        r17 = null;
        goto L15
    L22:
        return;
    }

    @CalledByNative
    private void dispatchOnLoaded() {
        f0 r5 = this.f10047a;
        if (r5 == null) goto L25;
        xm.i r10 = xm.f.f23173a;
        UIBody.UIBodyView r11 = r5.f10842a.f10041v;
        r10.getClass();
        AtomicInteger r12 = new AtomicInteger(0);
        Iterator r13 = r10.f23176c.keySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        LynxUI r14 = (LynxUI) r13.next();
        if (r14.getLynxContext().f10145m.f10385a != r11) goto L6;
        r12.incrementAndGet();
        r14.execEnterAnim(new xm.e(r12));
        goto L6
    L10:
        r12.get();
        LynxTemplateRender r15 = r5.f10842a;
        if (r15.f10033m == null) goto L16;
        LynxLog.b(2, "LynxTemplateRender", "dispatchLoadSuccess templateSize in " + r15.toString());
        if (r15.f10033m == null) goto L16;
        r15.f0("Client.onLoadSuccess");
        r15.f10033m.onLoadSuccess();
        LynxTemplateRender.j0("Client.onLoadSuccess");
    L16:
        r5.f10842a.R = "update";
        if (LynxTemplateRender.a(r5.f10842a) == null) goto L26;
        LynxTemplateRender.a(r5.f10842a).getClass();
        return;
    L26:
        return;
    }

    @CalledByNative
    private void flushJSBTiming(ReadableMap r5) {
        f0 r10 = this.f10047a;
        if (r10 == null) goto L23;
        if (r5 == null) goto L25;
        JavaOnlyMap r11 = new JavaOnlyMap(r5.getMap("info").asHashMap());
        p0 r12 = r10.f10842a.f10033m;
        if (r12 == null) goto L10;
        r12.onJSBInvoked(r11);
    L10:
        if (r5.getMap("info").getInt("jsb_status_code", 0) != 1) goto L26;
        f0 r13 = this.f10047a;
        HashMap<String, Object> r14 = r5.asHashMap();
        p0 r15 = r13.f10842a.f10033m;
        if (r15 == null) goto L16;
        r15.onCallJSBFinished(r14);
    L16:
        if (LynxDevtoolGlobalHelper.getInstance().isRemoteDebugAvailable() == false) goto L24;
        b0 r16 = r13.f10842a.e;
        if (r16 == null) goto L20;
        int r17 = r16.A;
    L21:
        LynxDevtoolGlobalHelper.getInstance().onPerfMetricsEvent("lynxsdk_jsb_timing", new JSONObject(r14), r17);
        return;
    L20:
        r17 = -1;
        goto L21
    L24:
        return;
    L26:
        return;
    L25:
        return;
    }

    @CalledByNative
    private void onConfigUpdatedByJS(String r5, Object r10) {
        if (r5 == null) goto L42;
        if (r10 != null) goto L5;
        return;
    L5:
        if ((r10 instanceof HashMap) == false) goto L46;
        HashMap r11 = (HashMap) r10;
        if ("theme".equals(r5) == false) goto L44;
        mo.a r12 = new mo.a();
        r12.f20155a = new HashMap();
        Iterator r13 = r11.entrySet().iterator();
    L11:
        if (r13.hasNext() == false) goto L22;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        String r16 = (String) r14.getValue();
        if (r15 == null) goto L11;
        if (r15.isEmpty() == true) goto L11;
        if (r15.startsWith(CodeGenScope.CLASS_PROPERTY_PREFIX) == true) goto L11;
        if (r16 == null) goto L20;
        r12.f20155a.put(r15, r16);
        goto L11
    L20:
        r12.f20155a.remove(r15);
        goto L11
    L22:
        f0 r17 = this.f10047a;
        if (r17 == null) goto L45;
        LynxTemplateRender r18 = r17.f10842a;
        mo.a r19 = r18.f10043x;
        if (r19 != null) goto L28;
        r18.f10043x = r12;
        return;
    L28:
        r19.f20155a = r12.f20155a;
        return;
    L45:
        return;
    L44:
        return;
    L46:
        return;
    }

    @CalledByNative
    private void onDataUpdated() {
        f0 r5 = this.f10047a;
        if (r5 == null) goto L8;
        LynxTemplateRender r10 = r5.f10842a;
        if (r10.f10033m == null) goto L9;
        r10.f0("Client.onDataUpdated");
        r10.f10033m.onDataUpdated();
        r10.getClass();
        LynxTemplateRender.j0("Client.onDataUpdated");
        return;
    L9:
        return;
    }

    @CalledByNative
    private void onDynamicComponentPerfReady(ReadableMap r5) {
        f0 r10 = this.f10047a;
        if (r10 == null) goto L8;
        HashMap<String, Object> r11 = r5.asHashMap();
        LynxTemplateRender r12 = r10.f10842a;
        if (r12.f10033m == null) goto L9;
        r12.f0("Client.onDynamicComponentPerf");
        r12.f10033m.onDynamicComponentPerfReady(r11);
        r12.getClass();
        LynxTemplateRender.j0("Client.onDynamicComponentPerf");
        return;
    L9:
        return;
    }

    @CalledByNative
    private void onModuleFunctionInvoked(String r5, String r10, int r11) {
        f0 r12 = this.f10047a;
        if (r12 == null) goto L13;
        LynxTemplateRender r13 = r12.f10842a;     // Catch: Exception -> L8
        if (r13.f10033m == null) goto L14;
        r13.f0("Client.onModuleMethodInvoked");     // Catch: Exception -> L8
        r13.f10033m.onModuleMethodInvoked(r5, r10, r11);     // Catch: Exception -> L8
        r13.getClass();     // Catch: Exception -> L8
        LynxTemplateRender.j0("Client.onModuleMethodInvoked");     // Catch: Exception -> L8
        return;
    L14:
        return;
    L8:
        e = move-exception;
        LynxError r14 = new LynxError(99900, androidx.room.jarjarred.org.antlr.runtime.a.o(e, com.lynx.tasm.base.a.e("Callback 'onModuleFunctionInvoked' called after method '", r10, "' in module '", r5, "' threw an exception: ")), "", "error");
        String r15 = CallStackUtil.getStackTraceStringWithLineTrimmed(e);
        r14.g = null;
        r14.f9999n = r15;
        reportError(r14);
        return;
    }

    @CalledByNative
    private void onPageChanged(boolean r10) {
        f0 r5 = this.f10047a;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r10 == false) goto L15;
        d0 r11 = r5.f10842a.f10016a;
        r11.getClass();
        LynxLog.b(2, "LynxTemplateRender", "onFirstScreen");
        com.lynx.tasm.behavior.i r12 = ((LynxTemplateRender) r11.f10837a).O;
        if (r12 == null) goto L47;
        com.lynx.tasm.behavior.n0 r13 = ((LynxUIRenderer) r12).f10161b;
        if (r13 == null) goto L47;
        r13.f10293k = false;
    L47:
        com.lynx.tasm.utils.j.a().post(new c0(r11, 0));     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L15:
        d0 r14 = r5.f10842a.f10016a;
        r14.getClass();
        LynxLog.b(2, "LynxTemplateRender", "onPageUpdate");     // Catch: Throwable -> L19
        com.lynx.tasm.utils.j.a().post(new c0(r14, 1));     // Catch: Throwable -> L19
        if (LynxTemplateRender.a((LynxTemplateRender) r14.f10837a) == null) goto L21;
        LynxTemplateRender.a((LynxTemplateRender) r14.f10837a).getClass();     // Catch: Throwable -> L19
    L21:
        LynxTemplateRender r15 = (LynxTemplateRender) r14.f10837a;     // Catch: Throwable -> L19
        if (r15.E == false) goto L25;
        return;
    L25:
        if (PerformanceController.k() == false) goto L56;
        r15.E = true;     // Catch: Throwable -> L19
        WeakReference r16 = new WeakReference(r15);     // Catch: Throwable -> L19
        if (PerformanceController.f10929i < 0) goto L30;
        long r17 = PerformanceController.f10929i;     // Catch: Throwable -> L19
    L38:
        long r18 = r17 * 1000;
        com.lynx.tasm.utils.j.a().postDelayed(new ab.b(23, r15, false, r16), r18);     // Catch: Throwable -> L19
        return;
    L30:
        String r19 = LynxEnv.inst().getMemoryAcquisitionDelaySec();     // Catch: Throwable -> L19
        if (r19 != null) goto L33;
    L37:
        r17 = 2;
        goto L38
    L33:
        if (r19.isEmpty() == true) goto L37;
        r17 = Long.parseLong(r19);     // Catch: Throwable -> L19 NumberFormatException -> L44
        PerformanceController.f10929i = r17;     // Catch: Throwable -> L19 NumberFormatException -> L43
        goto L38
    L56:
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
    }

    @CalledByNative
    private void onReceiveMessageEvent(ReadableMap r5) {
        f0 r10 = this.f10047a;
        if (r10 == null) goto L8;
        LynxTemplateRender r11 = r10.f10842a;
        if (LynxTemplateRender.a(r11) == null) goto L9;
        LynxTemplateRender.a(r11).getClass();
        return;
    L9:
        return;
    }

    @CalledByNative
    private void onRuntimeReady() {
        f0 r5 = this.f10047a;
        if (r5 == null) goto L8;
        LynxTemplateRender r10 = r5.f10842a;
        if (r10.f10033m == null) goto L9;
        r10.f0("Client.onRuntimeReady");
        r10.f10033m.onRuntimeReady();
        r10.getClass();
        LynxTemplateRender.j0("Client.onRuntimeReady");
        return;
    L9:
        return;
    }

    @CalledByNative
    private void onSSRHydrateFinished() {
        f0 r5 = this.f10047a;
        if (r5 == null) goto L8;
        i r10 = r5.f10842a.f10027i;
        if (r10 == null) goto L9;
        r10.f10879a = LynxSSRHelper$SSRHydrateStatus.f;
        return;
    L9:
        return;
    }

    @CalledByNative
    private void onTASMFinishedByNative() {
        f0 r5 = this.f10047a;
        if (r5 == null) goto L8;
        LynxTemplateRender r10 = r5.f10842a;
        if (r10.f10033m == null) goto L9;
        r10.f0("Client.onTASMFinishedByNative");
        r5.f10842a.f10033m.onTASMFinishedByNative();
        r5.f10842a.getClass();
        r5.f10842a.getClass();
        LynxTemplateRender.j0("Client.onTASMFinishedByNative");
        return;
    L9:
        return;
    }

    @CalledByNative
    private void onTemplateBundleReady(TemplateBundle r5) {
        f0 r10 = this.f10047a;
        if (r10 == null) goto L8;
        LynxTemplateRender r11 = r10.f10842a;
        if (r11.f10033m == null) goto L9;
        r11.f0("Client.onTemplateBundleReady");
        r11.f10033m.onTemplateBundleReady(r5);
        r11.getClass();
        LynxTemplateRender.j0("Client.onTemplateBundleReady");
        return;
    L9:
        return;
    }

    @CalledByNative
    private void onTimingSetup(ReadableMap r5) {
        p0 r10 = this.f10048b;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.onTimingSetup(r5.asHashMap());
    }

    @CalledByNative
    private void onTimingUpdate(ReadableMap r5, ReadableMap r10, String r11) {
        if (this.f10048b == null) goto L25;
        Object r12 = r10.asHashMap().get(r11);
        if ((r12 instanceof HashMap) == true) goto L8;
        return;
    L8:
        HashMap r13 = new HashMap();
        Iterator r14 = ((HashMap) r12).entrySet().iterator();
    L10:
        if (r14.hasNext() == false) goto L16;
        Map.Entry r15 = (Map.Entry) r14.next();
        Object r16 = r15.getKey();
        Object r17 = r15.getValue();
        if ((r16 instanceof String) == false) goto L10;
        if ((r17 instanceof Long) == false) goto L10;
        r13.put((String) r16, (Long) r17);
        goto L10
    L16:
        this.f10048b.onTimingUpdate(r5.asHashMap(), r13, r11);
        return;
    }

    @CalledByNative
    private void onUpdateDataWithoutChange() {
        f0 r5 = this.f10047a;
        if (r5 == null) goto L8;
        LynxTemplateRender r10 = r5.f10842a;
        if (r10.f10033m == null) goto L9;
        r10.f0("Client.onUpdateDataWithoutChange");
        r10.f10033m.onUpdateDataWithoutChange();
        r10.getClass();
        LynxTemplateRender.j0("Client.onUpdateDataWithoutChange");
        return;
    L9:
        return;
    }

    @CalledByNative
    public void getI18nResourceByNative(String r5, String r10) {
        LynxContext r11 = (LynxContext) this.d.get();
        if (r11 == null) goto L13;
        x0 r12 = r11.f10153v;
        r12.getClass();
        if (TextUtils.isEmpty("I18N_TEXT") == false) goto L7;
        fo.h r13 = null;
    L8:
        if (r13 != null) goto L11;
        r11.f(r5, "I18nResource", new LynxError(30400, "no i18n provider found", "", "error"));
        return;
    L11:
        new Bundle().putString("fallbackUrl", r10);
        r13.a(new com.lynx.tasm.behavior.ui.utils.n(r5.toLowerCase(), 0), new s0(this, r5));
        return;
    L7:
        r13 = (fo.h) ((HashMap) r12.f10812a).get("I18N_TEXT");
        goto L8
    }

    @CalledByNative
    public void onEventBubble(long r5, boolean r10, long r11) {
        f0 r12 = this.f10047a;
        if (r12 == null) goto L12;
        LynxTemplateRender r13 = r12.f10842a;
        b0 r14 = r13.e;
        if (r14 != null) goto L7;
        return;
    L7:
        if (((com.lynx.tasm.behavior.n0) r14.f10147o.get()) == null) goto L14;
        LynxBaseUI r15 = ((com.lynx.tasm.behavior.n0) r13.e.f10147o.get()).a((int) r5);
        if (r15 == null) goto L15;
        r15.onEventBubble(r10, r11);
        return;
    L15:
        return;
    L14:
        return;
    }

    @CalledByNative
    public void onEventCapture(long r5, boolean r10, long r11) {
        f0 r12 = this.f10047a;
        if (r12 == null) goto L12;
        LynxTemplateRender r13 = r12.f10842a;
        b0 r14 = r13.e;
        if (r14 != null) goto L7;
        return;
    L7:
        if (((com.lynx.tasm.behavior.n0) r14.f10147o.get()) == null) goto L14;
        LynxBaseUI r15 = ((com.lynx.tasm.behavior.n0) r13.e.f10147o.get()).a((int) r5);
        if (r15 == null) goto L15;
        r15.onEventCapture(r10, r11);
        return;
    L15:
        return;
    L14:
        return;
    }

    @CalledByNative
    public void onEventFire(long r5, boolean r10, long r11) {
        f0 r12 = this.f10047a;
        if (r12 == null) goto L12;
        LynxTemplateRender r13 = r12.f10842a;
        b0 r14 = r13.e;
        if (r14 != null) goto L7;
        return;
    L7:
        if (((com.lynx.tasm.behavior.n0) r14.f10147o.get()) == null) goto L14;
        LynxBaseUI r15 = ((com.lynx.tasm.behavior.n0) r13.e.f10147o.get()).a((int) r5);
        if (r15 == null) goto L15;
        r15.onEventFire(r10, r11);
        return;
    L15:
        return;
    L14:
        return;
    }

    @CalledByNative
    public void onLynxEvent(ReadableMap r5) {
        f0 r10 = this.f10047a;
        if (r10 == null) goto L6;
        boolean r11 = LynxTemplateRender.f10015m0;
        r10.f10842a.getClass();
        return;
    }

    @CalledByNative
    public void onPageConfigDecoded(ReadableMap r5) {
        f0 r10 = this.f10047a;
        if (r10 == null) goto L6;
        u0 r11 = new u0(r5);
        LynxTemplateRender r12 = r10.f10842a;
        r12.getClass();
        u0.a(r11, r12.e, r12.O);
        return;
    }

    @CalledByNative
    public void onRunPipelineFinished() {
    }

    @CalledByNative
    public void reportError(LynxError r5) {
        f0 r10 = this.f10047a;
        if (r10 == null) goto L6;
        r10.f10842a.onErrorOccurred(r5);
        return;
    }

    @CalledByNative
    public String translateResourceForTheme(String r5, String r10) {
        if (this.f10047a == null) goto L5;
        LynxEnv.inst().getThemeResourceProviderProvider();
    L5:
        return null;
    }

    /* JADX INFO: Removed unreachable split cross block B:45:0x00c9 */
    @CalledByNative
    public ByteBuffer triggerLepusBridge(String r10, Object r11) {
        boolean r5 = kn.b.f18686a;
        LynxModuleFactory r12 = this.f;
        Object r13 = null;
        if ((r11 instanceof ReadableMap) == false) goto L44;
        if (r12 != null) goto L8;
        LynxLog.b(4, "LynxLepusModule", "mModuleFactory does not exist!");
        goto L44
    L8:
        ReadableMap r14 = ((ReadableMap) r11).getMap("methodDetail", new JavaOnlyMap());
        String r15 = r14.getString("module", null);
        String r16 = r14.getString("method", null);
        if (r15 == null) goto L44;
        LynxModuleWrapper r17 = r12.a(r15);
        if (r17 != null) goto L14;
        r17 = LynxEnv.inst().getModuleFactory().a(r15);
    L14:
        if (r17 == null) goto L44;
        if (r10.equals(NotificationCompat.CATEGORY_CALL) == false) goto L19;
    L25:
        boolean r18 = true;
    L26:
        Iterator<MethodDescriptor> r19 = r17.getMethodDescriptors().iterator();
    L28:
        if (r19.hasNext() == false) goto L44;
        MethodDescriptor r20 = r19.next();
        String r21 = r20.getName();
        if (r21 == null) goto L28;
        if (r21.isEmpty() == true) goto L28;
        if (r21.equals(r10) == false) goto L28;
        if (r18 == false) goto L40;
        r13 = r20.getMethod().invoke(r17.getModule(), new Object[]{r16, r14});     // Catch: Exception -> L38
        goto L44
    L40:
        r13 = r20.getMethod().invoke(r17.getModule(), new Object[]{r14});     // Catch: Exception -> L38
    L38:
        e = move-exception;
        LynxLog.b(4, "LynxLepusModule", "Lepus Module invokeSync: " + e.toString());
        goto L28
    L19:
        if (r10.equals("callSync") == true) goto L25;
        if (r16 != null) goto L22;
    L24:
        r18 = false;
        goto L26
    L22:
        if (r16.length() == 0) goto L24;
    L44:
        return kn.b.b(r13);
    }

    @CalledByNative
    public void triggerLepusBridgeAsync(String r10, Object r11) {
        WeakReference r5 = this.f10049c;
        if (r5 == null) goto L5;
        LynxEngineProxy r12 = (LynxEngineProxy) r5.get();
    L6:
        LynxModuleFactory r13 = this.f;
        if ((r11 instanceof ReadableMap) == false) goto L43;
        if (r13 != null) goto L11;
        LynxLog.b(4, "LynxLepusModule", "mModuleFactory does not exist!");
        return;
    L11:
        ReadableMap r14 = (ReadableMap) r11;
        ReadableMap r15 = r14.getMap("methodDetail", new JavaOnlyMap());
        String r16 = r15.getString("module", null);
        r15.getString("method", null);
        if (r16 == null) goto L44;
        LynxModuleWrapper r17 = r13.a(r16);
        if (r17 != null) goto L17;
        r17 = LynxEnv.inst().getModuleFactory().a(r16);
    L17:
        if (r17 != null) goto L20;
        return;
    L20:
        if (r14.getBoolean("lepusUseUIThread", false) == false) goto L22;
    L37:
        sk.a.b(r17, r12, r14, r10);
        return;
    L22:
        if (r14.getBoolean("useAirThread", false) == false) goto L37;
        WeakReference r18 = new WeakReference(r17);
        WeakReference r19 = new WeakReference(r12);
        if (mn.h.e == null) goto L26;
    L36:
        mn.h.e.execute(new com.bytedance.apm.e(r18, r19, r14, r10));
        return;
    L26:
        monitor-enter(mn.h.class);
    L30:
        th = move-exception;
        throw th;
    L28:
        if (mn.h.e != null) goto L32;
        mn.h.e = mn.h.e(3, 1, "lepus-bridge-async-thread");     // Catch: Throwable -> L30
    L32:
        monitor-exit(mn.h.class);     // Catch: Throwable -> L30
        goto L36
    L44:
        return;
    L43:
        return;
    L5:
        r12 = null;
        goto L6
    }
}
