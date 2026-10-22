package com.lynx.tasm;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.BuildConfig;
import com.lynx.jsbridge.LynxModuleFactory;
import com.lynx.jsbridge.LynxModuleWrapper;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.jsbridge.MethodDescriptor;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceRequest;
import com.lynx.tasm.provider.LynxResourceResponse;
import com.lynx.tasm.recording.LynxFrameRecorder;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.UIThreadUtils;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NativeFacade implements EventEmitter.d {
    public c a;
    public q1 b;
    public String c;
    public int d;
    public WeakReference<LynxEngineProxy> e;
    public WeakReference<LynxContext> f;
    public final boolean g;
    public boolean h;
    public LynxModuleFactory i;

    public class a extends LynxResourceCallback<String> {
        public final WeakReference<NativeFacade> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ NativeFacade c;

        /* JADX INFO: renamed from: com.lynx.tasm.NativeFacade$a$a, reason: collision with other inner class name */
        public class RunnableC0049a implements Runnable {
            public final /* synthetic */ LynxResourceResponse a;
            public final /* synthetic */ a b;

            @Override // java.lang.Runnable
            public final void run() {
                this.b.a(this.a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC0049a(a r1, LynxResourceResponse r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        public final void a(LynxResourceResponse<String> r6) {
            NativeFacade r0 = this.a.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if (TextUtils.isEmpty(r6.getData()) == false) goto L10;
            LynxContext r1 = r0.f.get();
            if (r1 == null) goto L10;
            r1.reportResourceError(30400, this.b, "I18nResource", "empty i18n resource return");
            r0.a.c(this.b, NameKeys.UnloadStrategy_No_Strategy, -1);
            return;
        L10:
            r0.a.c(this.b, r6.getData(), r6.getCode());
        }

        @Override // com.lynx.tasm.provider.LynxResourceCallback
        public final void onResponse(LynxResourceResponse<String> r2) {
            super.onResponse(r2);
            if (UIThreadUtils.isOnUiThread() == true) goto L5;
            UIThreadUtils.runOnUiThread(new RunnableC0049a(this, r2));
            return;
        L5:
            a(r2);
        }

        public a(NativeFacade r1, String r2) {
            this.c = r1;
            this.b = r2;
            this.a = new WeakReference(this.c);
        }
    }

    public class b implements Callback {
        public final /* synthetic */ int a;
        public final /* synthetic */ NativeFacade b;

        @Override // com.lynx.react.bridge.Callback
        public final void invoke(Object... r4) {
            if (this.a >= 0) goto L5;
            return;
        L5:
            JavaOnlyMap r0 = new JavaOnlyMap();
            r0.putInt(LynxResourceModule.CODE_KEY, ((Integer) r4[0]).intValue());
            if (r4.length <= 1) goto L8;
            r0.put(LynxResourceModule.DATA_KEY, r4[1]);
        L8:
            c r5 = this.b.a;
            if (r5 == null) goto L12;
            r5.b(this.a, r0);
            return;
        }

        public b(NativeFacade r1, int r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public interface c {
        void a(TemplateBundle r1);

        void b(int r1, JavaOnlyMap r2);

        void c(String r1, String r2, int r3);

        String d(String r1, String r2);

        void e(k8a.a r1);

        void f(HashMap<String, Object> r1);

        void g();

        void h(int r1);

        void i(Map<String, Object> r1);

        void j(boolean r1);

        void k();

        void l(long r1, boolean r3, long r4);

        void m(long r1, boolean r3, long r4);

        void n(JavaOnlyMap r1);

        void o();

        void onDataUpdated();

        void onErrorOccurred(LynxError r1);

        void onReceiveMessageEvent(ReadableMap r1);

        void onRuntimeReady();

        void onUpdateDataWithoutChange();

        void p(String r1, String r2, int r3);

        void q();

        void r();

        void s(long r1, boolean r3, long r4);

        void t(t1 r1);
    }

    private void dispatchOnLoaded() {
        LLog.i("NativeFacade", "native->java dispatchOnLoaded templateSize:" + this.d + " " + b());
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.h(this.d);
        return;
    }

    private void onDataUpdated() {
        LLog.i("NativeFacade", "native->java onDataUpdated " + b());
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.onDataUpdated();
        return;
    }

    private void onRuntimeReady() {
        LLog.i("NativeFacade", "native->java onRuntimeReady " + b());
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.onRuntimeReady();
        return;
    }

    private void onSSRHydrateFinished() {
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    private void onTASMFinishedByNative() {
        LLog.i("NativeFacade", "native->java onTASMFinishedByNative " + b());
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.r();
        return;
    }

    private void onUpdateDataWithoutChange() {
        LLog.i("NativeFacade", "native->java onUpdateDataWithoutChange " + b());
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.onUpdateDataWithoutChange();
        return;
    }

    public final String b() {
        WeakReference<LynxContext> r0 = this.f;
        if (r0 == null) goto L5;
        LynxContext r1 = r0.get();
    L6:
        if (r1 == null) goto L8;
        int r2 = r1.getInstanceId();
    L10:
        if (TextUtils.isEmpty(this.c) == true) goto L12;
        String r3 = this.c;
    L16:
        return "instanceId:" + r2 + " url:" + r3;
    L12:
        if (r1 == null) goto L14;
        r3 = r1.getTemplateUrl();
        goto L16
    L14:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        goto L16
    L8:
        r2 = -1;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public void onRunPipelineFinished() {
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.k();
        return;
    }

    public NativeFacade(boolean r2) {
        this.g = true;
        this.h = false;
        this.i = null;
        this.g = r2;
    }

    private void flushJSBTiming(ReadableMap r4) {
        if (BuildConfig.enable_lite.booleanValue() == false) goto L5;
        return;
    L5:
        c r0 = this.a;
        if (r0 == null) goto L14;
        if (r4 == null) goto L15;
        r0.n(JavaOnlyMap.from(r4.getMap("info").asHashMap()));
        if (r4.getMap("info").getInt("jsb_status_code", 0) == 1) goto L12;
        return;
    L12:
        this.a.i(r4.asHashMap());
        return;
    L15:
        return;
    }

    private void onDynamicComponentPerfReady(ReadableMap r2) {
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.f(r2.asHashMap());
        return;
    }

    private void onPageChanged(boolean r3) {
        LLog.i("NativeFacade", "native->java onPageChanged isFirstScreen:" + r3 + " " + b());
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.j(r3);
        return;
    }

    private void onReceiveMessageEvent(ReadableMap r2) {
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.onReceiveMessageEvent(r2);
        return;
    }

    private void onTemplateBundleReady(TemplateBundle r2) {
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    private void onTimingSetup(ReadableMap r2) {
        q1 r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.onTimingSetup(r2.asHashMap());
    }

    private void startRecording(ReadableMap r6) {
        WeakReference<LynxContext> r7 = this.f;
        if (r7 == null) goto L5;
        LynxContext r8 = r7.get();
    L6:
        if (r8 != null) goto L8;
        return;
    L8:
        final int r0 = r8.getInstanceId();
        if (r0 != (-1)) goto L11;
        return;
    L11:
        DisplayMetrics r9 = r8.getScreenMetrics();
        if (r9 == null) goto L14;
        float r10 = r9.density;
    L15:
        final LynxFrameRecorder r2 = LynxFrameRecorder.k;
        if (r0 >= 0) goto L19;
        r2.getClass();
        return;
    L19:
        if (r10 <= 0.0f) goto L21;
        r2.g.put(Integer.valueOf(r0), Float.valueOf(r10));
    L22:
        final int r11 = r2.j.getAndIncrement();
        r2.d.put(Integer.valueOf(r0), Integer.valueOf(r11));
        r2.b.put(Integer.valueOf(r0), Integer.valueOf(r11));
        r2.c.remove(Integer.valueOf(r0));
        r2.e.put(Integer.valueOf(r0), new LynxFrameRecorder.c());
        r2.a.execute(new com.lynx.tasm.recording.c(r2, r0, r11));
        return;
    L21:
        r2.g.remove(Integer.valueOf(r0));
        goto L22
    L14:
        r10 = 0.0f;
        goto L15
    L5:
        r8 = null;
        goto L6
    }

    private void stopRecording(ReadableMap r2) {
        LynxContext r3 = this.f.get();
        if (r3 != null) goto L5;
        int r4 = -1;
    L6:
        if (r4 != (-1)) goto L8;
        return;
    L8:
        LynxFrameRecorder.k.x(r4);
        return;
    L5:
        r4 = r3.getInstanceId();
        goto L6
    }

    @Override // com.lynx.tasm.EventEmitter.d
    public final boolean a(LynxEvent r17) {
        int r3 = 0;
        if (this.b == null) goto L58;
        if (r17 == null) goto L67;
        LynxContext r2 = this.f.get();
        if (r2 != null) goto L9;
        return false;
    L9:
        if (r2.getLynxUIOwner() == null) goto L66;
        LynxUIOwner r4 = r2.getLynxUIOwner();
        LynxEvent.LynxEventType r5 = r17.getType();
        LynxEvent.LynxEventType r6 = LynxEvent.LynxEventType.kTouch;
        if (r5 == r6) goto L14;
    L39:
        EventTarget r7 = (EventTarget) r17.getTarget();
        if (this.h == false) goto L43;
        if (r7 != null) goto L43;
        r7 = r4.findLynxUIBySign(r17.getTag());
    L43:
        if (r7 != null) goto L46;
        return false;
    L46:
        r2.getLynxView();
        LynxEventDetail r8 = new LynxEventDetail(r17, r7);
        if (r17.getType() != r6) goto L52;
        if ((r17 instanceof LynxTouchEvent) == false) goto L52;
        ((LynxTouchEvent) r17).getMotionEvent();
    L52:
        if (r7.dispatchEvent(r8) == false) goto L54;
        return true;
    L54:
        this.b.onLynxEvent(r8);
        return false;
    L14:
        if ((r17 instanceof LynxTouchEvent) == false) goto L39;
        LynxTouchEvent r9 = (LynxTouchEvent) r17;
        if (r9.getIsMultiTouch() == false) goto L39;
        JavaOnlyMap r10 = r9.getUITouchMap();
        Iterator<Map.Entry<String, Object>> r11 = r10.entrySet().iterator();
    L19:
        if (r11.hasNext() == false) goto L35;
        Map.Entry<String, Object> r12 = r11.next();
        int r13 = CastIntegerProtector.parseInt(r12.getKey());
        EventTarget r14 = (EventTarget) r9.getActiveTargetMap().get(Integer.valueOf(r13));
        if (r14 != null) goto L23;
        r14 = r4.findLynxUIBySign(r13);
    L23:
        if (r14 == null) goto L19;
        HashMap r15 = new HashMap();
        Iterator<Object> r16 = ((JavaOnlyArray) r12.getValue()).iterator();
    L27:
        if (r16.hasNext() == false) goto L29;
        JavaOnlyArray r18 = (JavaOnlyArray) r16.next();
        r15.put((Integer) r18.get(r3), new LynxTouchEvent.a(((Float) r18.get(5)).floatValue(), ((Float) r18.get(6)).floatValue()));
        r3 = 0;
        goto L27
    L29:
        LynxTouchEvent r19 = new LynxTouchEvent(r14.getSign(), r17.getName(), r15);
        r2.getLynxView();
        LynxEventDetail r20 = new LynxEventDetail(r19, r14);
        r9.getMotionEvent();
        if (r14.dispatchEvent(r20) == false) goto L32;
        r11.remove();
    L33:
        r3 = 0;
        goto L19
    L32:
        this.b.onLynxEvent(r20);
        goto L33
    L35:
        if (r10.size() != 0) goto L37;
        return true;
    L37:
        return false;
    L66:
        return false;
    L67:
        return false;
    L58:
        return false;
    }

    public void onLynxEvent(ReadableMap r1) {
        c r2 = this.a;
        if (r2 == null) goto L6;
        r2.o();
        return;
    }

    public void onPageConfigDecoded(ReadableMap r2) {
        if (this.a == null) goto L6;
        t1 r0 = new t1(r2);
        this.a.t(r0);
        this.h = r0.U;
        return;
    }

    public void reportError(LynxError r3) {
        StringBuilder r0 = new StringBuilder("native->java reportError instanceId:");
        LynxContext r1 = this.f.get();
        if (r1 != null) goto L5;
        int r2 = -1;
    L6:
        r0.append(r2);
        r0.append(" url:");
        r0.append(this.c);
        r0.append(" error:");
        if (r3 == null) goto L9;
        Object r4 = Integer.valueOf(r3.getErrorCode());
    L10:
        r0.append(r4);
        LLog.i("NativeFacade", r0.toString());
        c r5 = this.a;
        if (r5 == null) goto L14;
        r5.onErrorOccurred(r3);
        return;
    L14:
        return;
    L9:
        r4 = "null";
        goto L10
    L5:
        r2 = r1.getInstanceId();
        goto L6
    }

    private void onConfigUpdatedByJS(String r3, Object r4) {
        if (r3 == null) goto L18;
        if (r4 != null) goto L5;
        return;
    L5:
        if ((r4 instanceof HashMap) == false) goto L22;
        HashMap r5 = (HashMap) r4;
        if ("theme".equals(r3) == false) goto L20;
        k8a.a r6 = new k8a.a();
        Iterator r7 = r5.entrySet().iterator();
    L11:
        if (r7.hasNext() == false) goto L13;
        Map.Entry r0 = (Map.Entry) r7.next();
        r6.update((String) r0.getKey(), (String) r0.getValue());
        goto L11
    L13:
        c r8 = this.a;
        if (r8 == null) goto L21;
        r8.e(r6);
        return;
    L21:
        return;
    L20:
        return;
    L22:
        return;
    }

    public void getI18nResourceByNative(String r5, String r6) {
        LynxContext r0 = this.f.get();
        if (r0 == null) goto L13;
        d8a.f r1 = r0.getProviderRegistry();
        r1.getClass();
        if (TextUtils.isEmpty("I18N_TEXT") == false) goto L7;
        d8a.k r2 = null;
    L8:
        if (r2 != null) goto L11;
        r0.reportResourceError(30400, r5, "I18nResource", "no i18n provider found");
        return;
    L11:
        Bundle r3 = new Bundle();
        r3.putString("fallbackUrl", r6);
        r2.request(new LynxResourceRequest(r5.toLowerCase(), r3), new a(this, r5));
        return;
    L7:
        r2 = (d8a.k) ((HashMap) r1.a).get("I18N_TEXT");
        goto L8
    }

    public String translateResourceForTheme(String r2, String r3) {
        c r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.d(r2, r3);
    }

    /* JADX INFO: Removed unreachable split cross block B:44:0x00cc */
    public ByteBuffer triggerLepusBridge(String r13, Object r14) {
        j7a.a r0 = j7a.a.a;
        LynxModuleFactory r1 = this.i;
        Object r3 = null;
        if ((r14 instanceof ReadableMap) == true) goto L6;
    L42:
        r0.getClass();
        return j7a.a.b(r3);
    L6:
        if (r1 != null) goto L8;
        LLog.e("LynxLepusModule", "mModuleFactory does not exist!");
        goto L42
    L8:
        ReadableMap r15 = ((ReadableMap) r14).getMap("methodDetail", new JavaOnlyMap());
        String r4 = r15.getString("module", null);
        String r5 = r15.getString("method", null);
        if (r4 == null) goto L42;
        LynxModuleWrapper r2 = r1.b(r4);
        if (r2 != null) goto L14;
        r2 = LynxEnv.inst().getModuleFactory().b(r4);
    L14:
        if (r2 == null) goto L42;
        if (r13.equals("call") == false) goto L19;
    L25:
        boolean r6 = true;
    L26:
        Iterator<MethodDescriptor> r8 = r2.getMethodDescriptors().iterator();
    L28:
        if (r8.hasNext() == false) goto L42;
        MethodDescriptor r9 = r8.next();
        String r10 = r9.getName();
        if (r10 == null) goto L28;
        if (r10.isEmpty() == true) goto L28;
        if (r10.equals(r13) == false) goto L28;
        if (r6 == false) goto L38;
        r3 = r9.getMethod().invoke(r2.getModule(), new Object[]{r5, r15});     // Catch: Exception -> L40
        goto L42
    L38:
        r3 = r9.getMethod().invoke(r2.getModule(), new Object[]{r15});     // Catch: Exception -> L40
    L40:
        e = move-exception;
        LLog.e("LynxLepusModule", "Lepus Module invokeSync: " + e.toString());
        goto L28
    L19:
        if (r13.equals("callSync") == true) goto L25;
        if (r5 != null) goto L22;
    L24:
        r6 = false;
        goto L26
    L22:
        if (r5.length() == 0) goto L24;
        goto L24
    }

    public void triggerLepusBridgeAsync(String r7, Object r8) {
        WeakReference<LynxEngineProxy> r0 = this.e;
        if (r0 == null) goto L5;
        LynxEngineProxy r1 = r0.get();
    L6:
        LynxModuleFactory r2 = this.i;
        if ((r8 instanceof ReadableMap) == false) goto L44;
        if (r2 != null) goto L11;
        LLog.e("LynxLepusModule", "mModuleFactory does not exist!");
        return;
    L11:
        ReadableMap r9 = (ReadableMap) r8;
        ReadableMap r3 = r9.getMap("methodDetail", new JavaOnlyMap());
        String r4 = r3.getString("module", null);
        r3.getString("method", null);
        if (r4 == null) goto L45;
        LynxModuleWrapper r5 = r2.b(r4);
        if (r5 != null) goto L17;
        r5 = LynxEnv.inst().getModuleFactory().b(r4);
    L17:
        if (r5 == null) goto L46;
        boolean r6 = false;
        if (r9.getBoolean("lepusUseUIThread", false) == false) goto L22;
    L24:
        if (r6 == false) goto L38;
        WeakReference r10 = new WeakReference(r5);
        WeakReference r11 = new WeakReference(r1);
        if (LynxThreadPool.e == null) goto L28;
    L37:
        LynxThreadPool.e.execute(new a6a.a(r10, r11, r9, r7));
        return;
    L28:
        monitor-enter(LynxThreadPool.class);
    L34:
        th = move-exception;
        throw th;
    L30:
        if (LynxThreadPool.e != null) goto L32;
        LynxThreadPool.e = LynxThreadPool.c("lepus-bridge-async-thread", 3, 1);     // Catch: Throwable -> L34
    L32:
        monitor-exit(LynxThreadPool.class);     // Catch: Throwable -> L34
        goto L37
    L38:
        a6a.b.a(r5, r1, r9, r7);
        return;
    L22:
        if (r9.getBoolean("useAirThread", false) == false) goto L24;
        r6 = true;
        goto L24
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private void onModuleFunctionInvoked(String r4, String r5, int r6) {
        c r0 = this.a;
        if (r0 == null) goto L11;
        r0.p(r4, r5, r6);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        LynxError r1 = new LynxError(99900, "Callback 'onModuleFunctionInvoked' called after method '" + r5 + "' in module '" + r4 + "' threw an exception: " + e.getMessage());
        r1.setCallStack(CallStackUtil.getStackTraceStringWithLineTrimmed(e));
        reportError(r1);
        return;
    }

    private void onTimingUpdate(ReadableMap r5, ReadableMap r6, String r7) {
        if (this.b != null) goto L5;
        return;
    L5:
        Object r8 = r6.asHashMap().get(r7);
        if ((r8 instanceof HashMap) == true) goto L8;
        return;
    L8:
        HashMap r0 = new HashMap();
        Iterator r9 = ((HashMap) r8).entrySet().iterator();
    L10:
        if (r9.hasNext() == false) goto L16;
        Map.Entry r1 = (Map.Entry) r9.next();
        Object r2 = r1.getKey();
        Object r3 = r1.getValue();
        if ((r2 instanceof String) == false) goto L10;
        if ((r3 instanceof Long) == false) goto L10;
        r0.put((String) r2, (Long) r3);
        goto L10
    L16:
        this.b.onTimingUpdate(r5.asHashMap(), r0, r7);
    }

    private void setEmbeddedTiming(String r8, long r9, String r11) {
        c r0 = this.a;
        if ((r0 instanceof LynxTemplateRender.t) == false) goto L10;
        PerformanceController r1 = LynxTemplateRender.access$1000(((LynxTemplateRender.t) r0).a);
        if (r1.e == false) goto L11;
        if (r8 == null) goto L12;
        r1.n("Timing::Mark", r8, r9, r11);
        r1.k();
        r1.a.c(r8, r9);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void onEventBubble(long r7, boolean r9, long r10) {
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.m(r7, r9, r10);
        return;
    }

    public void onEventCapture(long r7, boolean r9, long r10) {
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.l(r7, r9, r10);
        return;
    }

    public void onEventFire(long r7, boolean r9, long r10) {
        c r0 = this.a;
        if (r0 == null) goto L6;
        r0.s(r7, r9, r10);
        return;
    }

    private void InvokeUIMethod(LynxGetUIResult r9, String r10, JavaOnlyMap r11, int r12) {
        WeakReference<LynxContext> r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        LynxContext r1 = r0.get();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r1.getLynxUIOwner() == null) goto L15;
        b r2 = new b(this, r12);
        int r13 = r9.a.getInt(0);
        int r3 = r1.getInstanceId();
        LynxFrameRecorder r4 = LynxFrameRecorder.k;
        if (r4.k(r3) == false) goto L12;
        long r6 = SystemClock.uptimeMillis();
        r4.p(r3, 108, new LynxFrameRecorder.f(r13, r10, LynxFrameRecorder.v(r11)), r6);
    L12:
        r1.getLynxUIOwner().invokeUIMethodForSelectorQuery(r13, r10, r11, r2);
        return;
    }
}
