package com.lynx.tasm.behavior.ui;

import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.devtoolwrapper.LogBoxLogLevel;
import com.lynx.devtoolwrapper.LynxBaseInspectorController;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.e0;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.n;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h extends e0 {
    public boolean A;
    public e B;
    public final c C;
    public final HashMap<String, f> v;
    public HashSet<f> w;
    public HashSet<f> x;
    public RectF y;
    public boolean z;

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ LynxBaseUI b;
        public final /* synthetic */ String c;
        public final /* synthetic */ JavaOnlyMap d;
        public final /* synthetic */ JavaOnlyMap e;
        public final /* synthetic */ h f;

        public final void a() {
            h r0 = this.f;
            if (r0.z == false) goto L5;
        L7:
            this.f.v.put(this.a, new f(this.b, this.c, this.d, this.e));
            return;
        L5:
            if (r0.v.isEmpty() == false) goto L7;
            this.f.b();
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(h r1, String r2, LynxBaseUI r3, String r4, JavaOnlyMap r5, JavaOnlyMap r6) {
            this.f = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ h b;

        public final void a() {
            if (this.b.v.get(this.a) != null) goto L6;
            return;
        L6:
            if (this.b.v.get(this.a).a.get() == null) goto L9;
            this.b.v.remove(this.a);
        L9:
            if (this.b.v.isEmpty() == false) goto L12;
            h r0 = this.b;
            r0.getClass();
            UIThreadUtils.runOnUiThreadImmediately(new i(r0));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(h r1, String r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public static class c implements Choreographer.FrameCallback {
        public final WeakReference<h> a;

        public c(h r2) {
            this.a = new WeakReference(r2);
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r1) {
            h r2 = this.a.get();
            if (r2 == null) goto L6;
            r2.i();
            return;
        }
    }

    public static class d implements e {
        public final WeakReference<LynxContext> a;

        public d(WeakReference<LynxContext> r1) {
            this.a = r1;
        }
    }

    public interface e {
    }

    public static class f {
        public final WeakReference<LynxBaseUI> a;
        public final String b;
        public final String c;
        public final int d;
        public final ReadableMap e;
        public final String f;
        public final JavaOnlyMap g;
        public final JavaOnlyMap h;

        public final HashMap<String, Object> a() {
            HashMap<String, Object> r0 = new HashMap();
            r0.put("exposure-id", this.b);
            r0.put("exposure-scene", this.c);
            r0.put("dataset", this.e);
            r0.put("unique-id", this.f);
            r0.put("extra-data", this.g);
            return r0;
        }

        public final int hashCode() {
            LynxBaseUI r0 = this.a.get();
            if (r0 != null) goto L5;
            return 0;
        L5:
            return r0.hashCode();
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L21:
            return false;
        L8:
            if (f.class != r5.getClass()) goto L21;
            f r6 = (f) r5;
            if (this.d == r6.d) goto L13;
        L19:
            return false;
        L13:
            if (this.c.equals(r6.c) == false) goto L19;
            if (this.b.equals(r6.b) == false) goto L19;
            if (this.f.equals(r6.f) == false) goto L19;
            return true;
        }

        public f(LynxBaseUI r3, String r4, JavaOnlyMap r5, JavaOnlyMap r6) {
            this.a = new WeakReference(r3);
            if (r3.getExposureID() != null) goto L5;
            this.b = NameKeys.UnloadStrategy_No_Strategy;
        L7:
            if (r3.getExposureScene() != null) goto L9;
            this.c = NameKeys.UnloadStrategy_No_Strategy;
        L10:
            this.d = r3.getSign();
            this.e = r3.getDataset();
            if (r4 != null) goto L14;
            r4 = NameKeys.UnloadStrategy_No_Strategy;
        L14:
            this.f = r4;
            if (r5 == null) goto L17;
            JavaOnlyMap r7 = JavaOnlyMap.from(r5);
        L18:
            this.g = r7;
            this.h = r6;
            return;
        L17:
            r7 = new JavaOnlyMap();
            goto L18
        L9:
            this.c = r3.getExposureScene();
            goto L10
        L5:
            this.b = r3.getExposureID();
            goto L7
        }
    }

    public h() {
        super("Lynx.UIExposure");
        this.y = null;
        this.B = null;
        this.v = new HashMap();
        this.x = new HashSet();
        this.w = new HashSet();
        this.a = new WeakReference(null);
        this.C = new c(this);
        this.A = true;
    }

    @Override // com.lynx.tasm.behavior.e0
    public final void i() {
        if (this.z == false) goto L7;
        LLog.e("Lynx.UIExposure", "Lynx exposureHandler failed since lynx.stopExposure() is called");
        this.o = false;
        return;
    L7:
        if (this.f == true) goto L10;
        LLog.e("Lynx.UIExposure", "Lynx exposureHandler failed since rootView not draw");
        this.o = false;
        return;
    L10:
        UIBody.UIBodyView r1 = f();
        if (r1 != null) goto L15;
        LLog.e("Lynx.UIExposure", "Lynx exposureHandler failed since rootView is null");
        this.o = false;
        return;
    L15:
        if (r1.isShown() == true) goto L22;
        if (this.q == false) goto L19;
        q(new HashSet(this.x), "disexposure");
        this.x.clear();
    L19:
        this.o = false;
        return;
    L22:
        if (this.r == false) goto L24;
    L27:
        this.y = g(this.a.get().getLynxContext());
        Iterator<f> r2 = this.v.values().iterator();
    L29:
        if (r2.hasNext() == false) goto L136;
        f r3 = r2.next();
        LynxBaseUI r6 = r3.a.get();
        if (r6 == null) goto L29;
        if (r6.getHeight() != 0) goto L35;
    L132:
        boolean r7 = false;
    L133:
        if (r7 == false) goto L29;
        this.w.add(r3);
        goto L29
    L35:
        if (r6.getWidth() == 0) goto L132;
        ArrayList r8 = new ArrayList();
        LynxBaseUI r9 = r6;
    L38:
        if (r9 == null) goto L57;
        if (r9 == this.a.get()) goto L57;
        if ((r9 instanceof LynxUI) == false) goto L47;
        if (((LynxUI) r9).isVisible() == false) goto L132;
    L47:
        if (r9.getEnableExposureUIClip() != EventTarget.EnableStatus.Enable) goto L49;
    L52:
        r8.add(r9);
    L54:
        if (r9.isOverlay() == true) goto L55;
        r9 = (LynxBaseUI) r9.getParent();
        goto L38
    L55:
        boolean r10 = true;
    L58:
        RectF r11 = d(r6);
        if (r6.getEnableExposureUIMargin() == false) goto L67;
        float r12 = r11.width();
        float r13 = r11.height();
        DisplayMetrics r14 = r6.getLynxContext().getScreenMetrics();
        float r15 = n.e(r6.getExposureUIMarginLeft(), r12, r14);
        float r16 = n.e(r6.getExposureUIMarginRight(), r12, r14);
        float r5 = n.e(r6.getExposureUIMarginTop(), r13, r14);
        float r4 = n.e(r6.getExposureUIMarginBottom(), r13, r14);
        if (((r12 + r15) + r16) > 0.0f) goto L63;
    L66:
        r11 = new RectF();
    L84:
        float r17 = n.a(r6.getExposureArea(), 0.0f);
        Iterator r18 = r8.iterator();
    L86:
        if (r18.hasNext() == false) goto L90;
        if (n(r11, d((LynxBaseUI) r18.next()), r17) == true) goto L86;
    L90:
        RectF r19 = d(this.a.get());
        if (this.y != null) goto L93;
        this.y = g(r6.getLynxContext());
    L93:
        if (r10 == true) goto L95;
        r7 = n(r11, r19, r17);
    L97:
        if (this.y == null) goto L133;
        if (r6.getEnableExposureUIMargin() == true) goto L101;
        float r110 = this.y.left;
        if (r6.getExposureScreenMarginLeft() >= 0.0f) goto L113;
        float r111 = r6.getExposureScreenMarginLeft();
    L114:
        float r112 = r110 - ((int) r111);
        float r113 = this.y.top;
        if (r6.getExposureScreenMarginTop() >= 0.0f) goto L117;
        float r114 = r6.getExposureScreenMarginTop();
    L118:
        float r115 = r113 - ((int) r114);
        float r116 = this.y.right;
        if (r6.getExposureScreenMarginRight() >= 0.0f) goto L121;
        float r117 = r6.getExposureScreenMarginRight();
    L122:
        float r118 = r116 + ((int) r117);
        float r119 = this.y.bottom;
        if (r6.getExposureScreenMarginBottom() >= 0.0f) goto L125;
        float r20 = r6.getExposureScreenMarginBottom();
    L126:
        RectF r21 = new RectF(r112, r115, r118, r119 + ((int) r20));
    L127:
        boolean r22 = n(r11, r21, r17);
        boolean r23 = n(r19, r21, 0.0f);
        if (r7 == false) goto L132;
        if (r22 == false) goto L132;
        if (r23 == false) goto L132;
        r7 = true;
        goto L133
    L125:
        r20 = 0.0f;
        goto L126
    L121:
        r117 = 0.0f;
        goto L122
    L117:
        r114 = 0.0f;
        goto L118
    L113:
        r111 = 0.0f;
        goto L114
    L101:
        if (this.y != null) goto L103;
        this.y = g(r6.getLynxContext());
    L103:
        r21 = new RectF(this.y);
        if (((r21.width() + r6.getExposureScreenMarginLeft()) + r6.getExposureScreenMarginRight()) > 0.0f) goto L106;
    L109:
        r21 = new RectF();
        goto L127
    L106:
        if (((r21.height() + r6.getExposureScreenMarginTop()) + r6.getExposureScreenMarginBottom()) <= 0.0f) goto L109;
        r21.left -= r6.getExposureScreenMarginLeft();
        r21.top -= r6.getExposureScreenMarginTop();
        r21.right += r6.getExposureScreenMarginRight();
        r21.bottom += r6.getExposureScreenMarginBottom();
        goto L127
    L95:
        r7 = true;
        goto L97
    L63:
        if (((r13 + r5) + r4) <= 0.0f) goto L66;
        r11.left -= r15;
        r11.top -= r5;
        r11.right += r16;
        r11.bottom += r4;
        goto L84
    L67:
        float r24 = r11.left;
        if (r6.getExposureScreenMarginRight() <= 0.0f) goto L70;
        float r25 = r6.getExposureScreenMarginRight();
    L71:
        r11.left = r24 - r25;
        float r26 = r11.right;
        if (r6.getExposureScreenMarginLeft() <= 0.0f) goto L74;
        float r27 = r6.getExposureScreenMarginLeft();
    L75:
        r11.right = r26 + r27;
        float r28 = r11.top;
        if (r6.getExposureScreenMarginBottom() <= 0.0f) goto L78;
        float r29 = r6.getExposureScreenMarginBottom();
    L79:
        r11.top = r28 - r29;
        float r30 = r11.bottom;
        if (r6.getExposureScreenMarginTop() <= 0.0f) goto L82;
        float r31 = r6.getExposureScreenMarginTop();
    L83:
        r11.bottom = r30 + r31;
        goto L84
    L82:
        r31 = 0.0f;
        goto L83
    L78:
        r29 = 0.0f;
        goto L79
    L74:
        r27 = 0.0f;
        goto L75
    L70:
        r25 = 0.0f;
        goto L71
    L49:
        if (r9.getEnableExposureUIClip() != EventTarget.EnableStatus.Undefined) goto L54;
        if (r9.isScrollContainer() == false) goto L54;
    L57:
        r10 = false;
        goto L58
    L136:
        HashSet<f> r32 = new HashSet();
        r32.addAll(this.x);
        r32.removeAll(this.w);
        HashSet<f> r33 = new HashSet();
        r33.addAll(this.w);
        r33.removeAll(this.x);
        this.x = this.w;
        this.w = new HashSet();
        q(r32, "disexposure");
        q(r33, "exposure");
        this.o = false;
        return;
    L24:
        if (r1.isLayoutRequested() == false) goto L27;
        c r34 = this.C;
        this.o = true;
        Choreographer.getInstance().postFrameCallbackDelayed(r34, this.g);
    }

    public final void p() {
        if (this.A == true) goto L6;
        return;
    L6:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L8;
        r("Lynx.UIExposure: resumeExposure", LogBoxLogLevel.Info.ordinal());
    L8:
        LLog.i("Lynx.UIExposure", "resumeExposure");
        this.z = false;
        b();
    }

    public final void s(HashMap<String, Object> r3) {
        if (this.A == true) goto L6;
        return;
    L6:
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L8;
        r("Lynx.UIExposure: stopExposure", LogBoxLogLevel.Info.ordinal());
    L8:
        LLog.i("Lynx.UIExposure", "stopExposure");
        this.z = true;
        c();
        if (r3 != null) goto L11;
    L14:
        q(this.x, "disexposure");
        this.x.clear();
        return;
    L11:
        if (r3.containsKey("sendEvent") == true) goto L13;
        return;
    L13:
        if (((Boolean) r3.get("sendEvent")).booleanValue() == true) goto L14;
    }

    public final void o(LynxBaseUI r3, String r4) {
        if (this.A == true) goto L5;
        return;
    L5:
        if (r4 != null) goto L9;
        if (r3.getExposureID() != null) goto L9;
        return;
    L9:
        if (r4 == null) goto L11;
        String r5 = r4 + "_" + r3.getExposureScene() + "_" + r3.getExposureID();
    L12:
        UIThreadUtils.runOnUiThreadImmediately(new b(this, r5));
        return;
    L11:
        r5 = r3.getExposureScene() + "_" + r3.getExposureID() + "_" + r3.getSign();
        goto L12
    }

    public final void q(HashSet<f> r17, String r18) {
        if (f() != null) goto L6;
        return;
    L6:
        if (r17.isEmpty() == true) goto L118;
        e r2 = this.B;
        if (r2 != null) goto L10;
        LLog.e("Lynx.UIExposure", "canSendGlobalEvent check failed since mCallback is null.");
    L22:
        boolean r3 = true;
    L23:
        if (r3 == false) goto L98;
        JavaOnlyArray r4 = new JavaOnlyArray();
        HashMap r7 = new HashMap();
        Iterator<f> r8 = r17.iterator();
    L26:
        if (r8.hasNext() == false) goto L69;
        f r9 = r8.next();
        if (LynxEnv.inst().isHighlightTouchEnabled() == false) goto L30;
        r("Lynx.UIExposure: sendEvent [" + r18 + "] [" + r9.c + "] [" + r9.b + "] [" + r9.f + "] [" + r9.d + "]", LogBoxLogLevel.Info.ordinal());
    L30:
        JavaOnlyMap r12 = r9.h;
        if (r12 == null) goto L67;
        if (r12.containsKey("sendCustom") == false) goto L67;
        if (r9.h.getBoolean("sendCustom") == false) goto L67;
        if (r9.h.containsKey("specifyTarget") == false) goto L57;
        if (r9.h.getBoolean("specifyTarget") == false) goto L57;
        LynxBaseUI r10 = r9.a.get();
        if (r10 == null) goto L26;
        LynxBaseUI r11 = r10.getExposeReceiveTarget();
        String r13 = r9.h.getString("bindEventName");
        if (r11 == null) goto L26;
        if (r11.getEvents() == null) goto L26;
        if (r13 == null) goto L26;
        if (r11.getEvents().containsKey(r13) == false) goto L26;
        if (r7.containsKey(r11) == true) goto L52;
        HashMap r14 = new HashMap();
        ArrayList r15 = new ArrayList();
        r15.add(r9);
        r14.put(r13, r15);
        r7.put(r11, r14);
        goto L26
    L52:
        HashMap r16 = (HashMap) r7.get(r11);
        if (r16.containsKey(r13) == true) goto L54;
        r16.put(r13, new ArrayList());
        ((ArrayList) r16.get(r13)).add(r9);
        goto L26
    L54:
        ((ArrayList) r16.get(r13)).add(r9);
    L57:
        LynxBaseUI r19 = r9.a.get();
        if (r18 != "exposure") goto L60;
        String r110 = "uiappear";
    L61:
        if (r19 == null) goto L26;
        if (r19.getEvents() == null) goto L26;
        if (r19.getEvents().containsKey(r110) == false) goto L26;
        r19.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(r19.getSign(), r110, r9.a()));
        goto L26
    L60:
        r110 = "uidisappear";
    L67:
        JavaOnlyMap r111 = new JavaOnlyMap();
        r111.put("exposure-id", r9.b);
        r111.put("exposureID", r9.b);
        r111.put("exposure-scene", r9.c);
        r111.put("exposureScene", r9.c);
        r111.put("sign", String.valueOf(r9.d));
        r111.put("dataSet", r9.e);
        r111.put("dataset", r9.e);
        r111.put("unique-id", r9.f);
        r111.put("extra-data", r9.g);
        r4.pushMap(r111);
        goto L26
    L69:
        if (r7.isEmpty() == true) goto L87;
        Iterator r20 = r7.entrySet().iterator();
    L73:
        if (r20.hasNext() == false) goto L87;
        Map.Entry r21 = (Map.Entry) r20.next();
        LynxBaseUI r22 = (LynxBaseUI) r21.getKey();
        Iterator r23 = ((HashMap) r21.getValue()).entrySet().iterator();
    L76:
        if (r23.hasNext() == false) goto L73;
        Map.Entry r112 = (Map.Entry) r23.next();
        String r113 = (String) r112.getKey();
        JavaOnlyArray r114 = new JavaOnlyArray();
        Iterator r115 = ((ArrayList) r112.getValue()).iterator();
    L79:
        if (r115.hasNext() == false) goto L81;
        f r116 = (f) r115.next();
        JavaOnlyMap r5 = new JavaOnlyMap();
        r5.put("extra-data", r116.g);
        r114.pushMap(r5);
        goto L79
    L81:
        JavaOnlyMap r6 = new JavaOnlyMap();
        if (r18 != "exposure") goto L84;
        boolean r117 = true;
    L85:
        r6.put("isExposure", Boolean.valueOf(r117));
        r6.put("childrenInfo", r114);
        r22.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(r22.getSign(), r113, r6));
        goto L76
    L84:
        r117 = false;
    L87:
        if (r4.size() <= 0) goto L167;
        JavaOnlyArray r24 = new JavaOnlyArray();
        r24.add(r4);
        e r25 = this.B;
        if (r25 != null) goto L91;
        LLog.e("Lynx.UIExposure", "sendEvent failed since mCallback is null.");
        return;
    L91:
        LynxContext r26 = ((d) r25).a.get();
        if (r26 != null) goto L94;
        LLog.e("UIExposure", "sendGlobalEvent failed since can not get LynxContext.");
        return;
    L94:
        UIBody.UIBodyView r27 = r26.getBodyView();
        if (r27 != null) goto L97;
        LLog.e("UIExposure", "sendGlobalEvent failed since can not get UIBodyView.");
        return;
    L97:
        r27.sendGlobalEvent(r18, r24);
        return;
    L167:
        return;
    L98:
        Iterator<f> r28 = r17.iterator();
    L100:
        if (r28.hasNext() == false) goto L172;
        f r29 = r28.next();
        int r30 = r29.d;
        e r31 = this.B;
        if (r31 != null) goto L104;
        LLog.e("Lynx.UIExposure", "findNode failed since mCallback is null.");
    L110:
        LynxBaseUI r32 = null;
    L112:
        if (r32 == null) goto L100;
        if (r32.getEvents() == null) goto L100;
        if (r32.getEvents().containsKey(r18) == false) goto L100;
        r32.getLynxContext().getEventEmitter().sendCustomEvent(new m7a.a(r32.getSign(), r18, r29.a()));
        goto L100
    L104:
        LynxContext r33 = ((d) r31).a.get();
        if (r33 != null) goto L108;
        LLog.e("UIExposure", "findNode failed since can not get LynxContext.");
        goto L110
    L108:
        if (r33.getLynxUIOwner() != null) goto L111;
        LLog.e("UIExposure", "findNode failed since can not get LynxUIOwner.");
        goto L110
    L111:
        r32 = r33.getLynxUIOwner().getNode(r30);
        goto L112
    L172:
        return;
    L10:
        LynxContext r34 = ((d) r2).a.get();
        if (r34 != null) goto L13;
        LLog.e("UIExposure", "canSendGlobalEvent check failed since can not get LynxContext.");
        goto L22
    L13:
        LynxView r35 = r34.getLynxView();
        if (r35 != null) goto L17;
        LLog.e("UIExposure", "canSendGlobalEvent check failed since can not get LynxView.");
        goto L22
    L17:
        if (r35.enableJSRuntime() == true) goto L22;
        if (r35.enableAirStrictMode() == true) goto L22;
        r3 = false;
        goto L23
    }

    public final void r(String r2, int r3) {
        LynxView r0 = (LynxView) f();
        if (r0 != null) goto L5;
        return;
    L5:
        LynxBaseInspectorController r1 = r0.getBaseInspectorController();
        if (r1 != null) goto L8;
        return;
    L8:
        r1.showMessageOnConsole(r2, r3);
    }

    public static boolean n(RectF r2, RectF r3, float r4) {
        float r0 = 0.0f;
        if (r4 == 0.0f) goto L13;
        RectF r1 = new RectF();
        if (r1.setIntersect(r2, r3) == false) goto L8;
        float r5 = r2.height() * r2.width();
        r0 = (r1.height() * r1.width()) / r5;
    L8:
        if (r0 < r4) goto L10;
        return true;
    L10:
        return false;
    L13:
        return RectF.intersects(r2, r3);
    }

    public final void m(LynxBaseUI r9, String r10, JavaOnlyMap r11, JavaOnlyMap r12) {
        if (this.A == true) goto L5;
        return;
    L5:
        if (r10 != null) goto L9;
        if (r9.getExposureID() != null) goto L9;
        return;
    L9:
        if (r10 == null) goto L11;
        String r0 = r10 + "_" + r9.getExposureScene() + "_" + r9.getExposureID();
    L12:
        UIThreadUtils.runOnUiThreadImmediately(new a(this, r0, r9, r10, r11, r12));
        return;
    L11:
        r0 = r9.getExposureScene() + "_" + r9.getExposureID() + "_" + r9.getSign();
        goto L12
    }
}
