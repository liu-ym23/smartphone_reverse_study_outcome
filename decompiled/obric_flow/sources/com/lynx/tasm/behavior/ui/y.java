package com.lynx.tasm.behavior.ui;

import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.event.EventTarget$EnableStatus;
import com.lynx.tasm.behavior.n0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class y extends com.lynx.tasm.behavior.b0 {
    public w A;
    public final v B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap f10779v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HashSet f10780w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public HashSet f10781x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RectF f10782y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10783z;

    public y() {
        super("Lynx.UIExposure");
        this.f10782y = null;
        this.A = null;
        this.f10779v = new HashMap();
        this.f10781x = new HashSet();
        this.f10780w = new HashSet();
        this.f10198a = new WeakReference(null);
        this.B = new v(this);
    }

    public static boolean m(RectF r5, RectF r10, float r11) {
        float r12 = 0.0f;
        if (r11 == 0.0f) goto L14;
        RectF r13 = new RectF();
        if (r13.setIntersect(r5, r10) == false) goto L8;
        float r14 = r5.height();
        float r15 = r5.width() * r14;
        float r16 = r13.height();
        r12 = (r13.width() * r16) / r15;
    L8:
        if (r12 < r11) goto L11;
        return true;
    L11:
        return false;
    L14:
        return RectF.intersects(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.b0
    public final void f() {
        boolean r5 = false;
        if (this.f10783z == false) goto L7;
        LynxLog.b(4, "Lynx.UIExposure", "Lynx exposureHandler failed since lynx.stopExposure() is called");
        this.f10208o = false;
        return;
    L7:
        if (this.f == true) goto L10;
        LynxLog.b(4, "Lynx.UIExposure", "Lynx exposureHandler failed since rootView not draw");
        this.f10208o = false;
        return;
    L10:
        UIBody.UIBodyView r10 = e();
        if (r10 != null) goto L15;
        LynxLog.b(4, "Lynx.UIExposure", "Lynx exposureHandler failed since rootView is null");
        this.f10208o = false;
        return;
    L15:
        if (r10.isShown() == false) goto L17;
        boolean r11 = true;
        if (this.f10211r == false) goto L24;
    L27:
        this.f10782y = a(((UIBody) this.f10198a.get()).getLynxContext());
        Iterator r12 = this.f10779v.values().iterator();
    L29:
        if (r12.hasNext() == false) goto L136;
        x r13 = (x) r12.next();
        LynxBaseUI r14 = (LynxBaseUI) r13.f10775a.get();
        if (r14 == null) goto L29;
        if (r14.getHeight() != 0) goto L35;
    L132:
        boolean r15 = false;
    L133:
        if (r15 == false) goto L135;
        this.f10780w.add(r13);
    L135:
        r5 = false;
        r11 = true;
        goto L29
    L35:
        if (r14.getWidth() == 0) goto L132;
        ArrayList r16 = new ArrayList();
        LynxBaseUI r17 = r14;
    L38:
        if (r17 == null) goto L57;
        if (r17 == this.f10198a.get()) goto L57;
        if ((r17 instanceof LynxUI) == false) goto L47;
        if (((LynxUI) r17).isVisible() == false) goto L132;
    L47:
        if (r17.getEnableExposureUIClip() != EventTarget$EnableStatus.f10244a) goto L49;
    L52:
        r16.add(r17);
    L54:
        if (r17.isOverlay() == true) goto L55;
        r17 = (LynxBaseUI) r17.getParent();
        goto L38
    L55:
        boolean r18 = r11;
    L58:
        RectF r19 = b(r14);
        if (r14.getEnableExposureUIMargin() == false) goto L67;
        float r110 = r19.width();
        float r111 = r19.height();
        DisplayMetrics r112 = r14.getLynxContext().f10152u;
        float r113 = com.lynx.tasm.utils.k.e(r14.getExposureUIMarginLeft(), r110, r112);
        float r114 = com.lynx.tasm.utils.k.e(r14.getExposureUIMarginRight(), r110, r112);
        float r20 = com.lynx.tasm.utils.k.e(r14.getExposureUIMarginTop(), r111, r112);
        float r21 = com.lynx.tasm.utils.k.e(r14.getExposureUIMarginBottom(), r111, r112);
        if (((r110 + r113) + r114) > 0.0f) goto L63;
    L66:
        r19 = new RectF();
    L84:
        float r22 = com.lynx.tasm.utils.k.b(r14.getExposureArea());
        Iterator r23 = r16.iterator();
    L86:
        if (r23.hasNext() == false) goto L90;
        if (m(r19, b((LynxBaseUI) r23.next()), r22) == true) goto L86;
    L90:
        RectF r24 = b((LynxBaseUI) this.f10198a.get());
        if (this.f10782y != null) goto L93;
        this.f10782y = a(r14.getLynxContext());
    L93:
        if (r18 == true) goto L95;
        r15 = m(r19, r24, r22);
    L97:
        if (this.f10782y == null) goto L133;
        if (r14.getEnableExposureUIMargin() == true) goto L101;
        float r115 = this.f10782y.left;
        if (r14.getExposureScreenMarginLeft() >= 0.0f) goto L113;
        float r116 = r14.getExposureScreenMarginLeft();
    L114:
        float r117 = r115 - ((int) r116);
        float r118 = this.f10782y.top;
        if (r14.getExposureScreenMarginTop() >= 0.0f) goto L117;
        float r119 = r14.getExposureScreenMarginTop();
    L118:
        float r120 = r118 - ((int) r119);
        float r121 = this.f10782y.right;
        if (r14.getExposureScreenMarginRight() >= 0.0f) goto L121;
        float r122 = r14.getExposureScreenMarginRight();
    L122:
        float r123 = r121 + ((int) r122);
        float r124 = this.f10782y.bottom;
        if (r14.getExposureScreenMarginBottom() >= 0.0f) goto L125;
        float r25 = r14.getExposureScreenMarginBottom();
    L126:
        RectF r26 = new RectF(r117, r120, r123, r124 + ((int) r25));
    L127:
        boolean r27 = m(r19, r26, r22);
        boolean r28 = m(r24, r26, 0.0f);
        if (r15 == false) goto L132;
        if (r27 == false) goto L132;
        if (r28 == false) goto L132;
        r15 = true;
        goto L133
    L125:
        r25 = 0.0f;
        goto L126
    L121:
        r122 = 0.0f;
        goto L122
    L117:
        r119 = 0.0f;
        goto L118
    L113:
        r116 = 0.0f;
        goto L114
    L101:
        if (this.f10782y != null) goto L103;
        this.f10782y = a(r14.getLynxContext());
    L103:
        r26 = new RectF(this.f10782y);
        if ((r14.getExposureScreenMarginRight() + (r14.getExposureScreenMarginLeft() + r26.width())) > 0.0f) goto L106;
    L109:
        r26 = new RectF();
        goto L127
    L106:
        if ((r14.getExposureScreenMarginBottom() + (r14.getExposureScreenMarginTop() + r26.height())) <= 0.0f) goto L109;
        r26.left -= r14.getExposureScreenMarginLeft();
        r26.top -= r14.getExposureScreenMarginTop();
        r26.right = r14.getExposureScreenMarginRight() + r26.right;
        r26.bottom = r14.getExposureScreenMarginBottom() + r26.bottom;
        goto L127
    L95:
        r15 = true;
        goto L97
    L63:
        if (((r111 + r20) + r21) <= 0.0f) goto L66;
        r19.left -= r113;
        r19.top -= r20;
        r19.right += r114;
        r19.bottom += r21;
        goto L84
    L67:
        float r29 = r19.left;
        if (r14.getExposureScreenMarginRight() <= 0.0f) goto L70;
        float r30 = r14.getExposureScreenMarginRight();
    L71:
        r19.left = r29 - r30;
        float r31 = r19.right;
        if (r14.getExposureScreenMarginLeft() <= 0.0f) goto L74;
        float r32 = r14.getExposureScreenMarginLeft();
    L75:
        r19.right = r31 + r32;
        float r33 = r19.top;
        if (r14.getExposureScreenMarginBottom() <= 0.0f) goto L78;
        float r34 = r14.getExposureScreenMarginBottom();
    L79:
        r19.top = r33 - r34;
        float r35 = r19.bottom;
        if (r14.getExposureScreenMarginTop() <= 0.0f) goto L82;
        float r36 = r14.getExposureScreenMarginTop();
    L83:
        r19.bottom = r35 + r36;
        goto L84
    L82:
        r36 = 0.0f;
        goto L83
    L78:
        r34 = 0.0f;
        goto L79
    L74:
        r32 = 0.0f;
        goto L75
    L70:
        r30 = 0.0f;
        goto L71
    L49:
        if (r17.getEnableExposureUIClip() != EventTarget$EnableStatus.f10246c) goto L54;
        if (r17.isScrollContainer() == false) goto L54;
    L57:
        r18 = r5;
        goto L58
    L136:
        HashSet r37 = new HashSet();
        r37.addAll(this.f10781x);
        r37.removeAll(this.f10780w);
        HashSet r38 = new HashSet();
        r38.addAll(this.f10780w);
        r38.removeAll(this.f10781x);
        this.f10781x = this.f10780w;
        this.f10780w = new HashSet();
        l(r37, "disexposure");
        l(r38, "exposure");
        this.f10208o = false;
        return;
    L24:
        if (r10.isLayoutRequested() == false) goto L27;
        this.f10208o = true;
        Choreographer.getInstance().postFrameCallbackDelayed(this.B, this.g);
        return;
    L17:
        if (this.f10210q == false) goto L19;
        l(new HashSet(this.f10781x), "disexposure");
        this.f10781x.clear();
    L19:
        this.f10208o = false;
    }

    public final void i(LynxBaseUI r10, String r11, JavaOnlyMap r12) {
        if (r11 != null) goto L8;
        if (r10.getExposureID() != null) goto L8;
        return;
    L8:
        if (r11 == null) goto L11;
        StringBuilder r5 = com.lynx.tasm.utils.j.d(r11, "_");
        r5.append(r10.getExposureScene());
        r5.append("_");
        r5.append(r10.getExposureID());
        String r13 = r5.toString();
    L12:
        com.lynx.tasm.utils.j.f(new com.bytedance.apm.f(this, r13, r10, r11, r12));
        return;
    L11:
        r13 = r10.getExposureScene() + "_" + r10.getExposureID() + "_" + r10.getSign();
        goto L12
    }

    public final void j(String r5, LynxBaseUI r10) {
        if (r5 != null) goto L8;
        if (r10.getExposureID() != null) goto L8;
        return;
    L8:
        if (r5 == null) goto L10;
        StringBuilder r11 = com.lynx.tasm.utils.j.d(r5, "_");
        r11.append(r10.getExposureScene());
        r11.append("_");
        r11.append(r10.getExposureID());
        String r12 = r11.toString();
    L11:
        com.lynx.tasm.utils.j.f(new ab.b(29, this, false, r12));
        return;
    L10:
        r12 = r10.getExposureScene() + "_" + r10.getExposureID() + "_" + r10.getSign();
        goto L11
    }

    public final void k(HashMap r5) {
        LynxLog.b(2, "Lynx.UIExposure", "stopExposure");
        this.f10783z = true;
        d();
        if (r5 != null) goto L5;
    L10:
        l(this.f10781x, "disexposure");
        this.f10781x.clear();
        return;
    L5:
        if (r5.containsKey("sendEvent") == true) goto L7;
        return;
    L7:
        if (((Boolean) r5.get("sendEvent")).booleanValue() == true) goto L10;
    }

    public final void l(HashSet r22, String r23) {
        if (e() != null) goto L6;
        return;
    L6:
        if (r22.isEmpty() == true) goto L143;
        w r5 = this.A;
        String r10 = "Lynx.UIExposure";
        String r11 = "extra-data";
        String r12 = "UIExposure";
        int r13 = 4;
        if (r5 != null) goto L10;
        LynxLog.b(4, "Lynx.UIExposure", "canSendGlobalEvent check failed since mCallback is null.");
    L41:
        JavaOnlyArray r14 = new JavaOnlyArray();
        HashMap r15 = new HashMap();
        Iterator r16 = r22.iterator();
    L43:
        if (r16.hasNext() == false) goto L83;
        x r17 = (x) r16.next();
        JavaOnlyMap r18 = r17.f10778h;
        JavaOnlyMap r19 = r17.g;
        r16 = r16;
        String r110 = r17.f;
        r12 = r12;
        ReadableMap r20 = r17.e;
        r10 = r10;
        String r21 = r17.f10777c;
        String r24 = r17.f10776b;
        JavaOnlyArray r111 = r14;
        if (r18 == null) goto L82;
        if (r18.containsKey("sendCustom") == false) goto L82;
        JavaOnlyMap r112 = r17.f10778h;
        if (r112.getBoolean("sendCustom") == false) goto L82;
        boolean r113 = r112.containsKey("specifyTarget");
        String r25 = r11;
        WeakReference r26 = r17.f10775a;
        if (r113 == true) goto L53;
    L71:
        LynxBaseUI r27 = (LynxBaseUI) r26.get();
        if (r23 != "exposure") goto L74;
        String r28 = "uiappear";
    L75:
        if (r27 == null) goto L56;
        if (r27.getEvents() == null) goto L56;
        if (r27.getEvents().containsKey(r28) == false) goto L56;
        int r114 = r27.getSign();
        HashMap r115 = new HashMap();
        r115.put("exposure-id", r24);
        r115.put("exposure-scene", r21);
        r115.put("dataset", r20);
        r115.put("unique-id", r110);
        r115.put(r25, r19);
        com.lynx.animax.i r116 = new com.lynx.animax.i(r115, r28, r114, 1);
        r27.getLynxContext().g.b(r116);
        r11 = r25;
        r14 = r111;
    L56:
        r16 = r16;
        r12 = r12;
        r10 = r10;
        r14 = r111;
        r11 = r25;
        goto L43
    L74:
        r28 = "uidisappear";
        goto L75
    L53:
        if (r112.getBoolean("specifyTarget") == false) goto L71;
        LynxBaseUI r29 = (LynxBaseUI) r26.get();
        if (r29 == null) goto L56;
        LynxBaseUI r30 = r29.getExposeReceiveTarget();
        String r31 = r112.getString("bindEventName");
        if (r30 == null) goto L56;
        if (r30.getEvents() == null) goto L56;
        if (r31 == null) goto L56;
        if (r30.getEvents().containsKey(r31) == false) goto L56;
        if (r15.containsKey(r30) == false) goto L70;
        HashMap r32 = (HashMap) r15.get(r30);
        if (r32.containsKey(r31) == false) goto L69;
        ((ArrayList) r32.get(r31)).add(r17);
        goto L56
    L69:
        r32.put(r31, new ArrayList());
        ((ArrayList) r32.get(r31)).add(r17);
        goto L56
    L70:
        HashMap r33 = new HashMap();
        ArrayList r34 = new ArrayList();
        r34.add(r17);
        r33.put(r31, r34);
        r15.put(r30, r33);
    L82:
        String r35 = r11;
        JavaOnlyMap r36 = new JavaOnlyMap();
        r36.put("exposure-id", r24);
        r36.put("exposureID", r24);
        r36.put("exposure-scene", r21);
        r36.put("exposureScene", r21);
        r36.put("sign", String.valueOf(r17.d));
        r36.put("dataSet", r20);
        r36.put("dataset", r20);
        r36.put("unique-id", r110);
        r36.put(r35, r19);
        r111.pushMap(r36);
        r11 = r35;
        r14 = r111;
        goto L43
    L83:
        JavaOnlyArray r37 = r14;
        String r117 = r10;
        String r38 = r11;
        String r118 = r12;
        if (r15.isEmpty() == true) goto L102;
        Iterator r39 = r15.entrySet().iterator();
    L88:
        if (r39.hasNext() == false) goto L102;
        Map.Entry r40 = (Map.Entry) r39.next();
        LynxBaseUI r41 = (LynxBaseUI) r40.getKey();
        Iterator r42 = ((HashMap) r40.getValue()).entrySet().iterator();
    L91:
        if (r42.hasNext() == false) goto L88;
        Map.Entry r43 = (Map.Entry) r42.next();
        String r44 = (String) r43.getKey();
        JavaOnlyArray r45 = new JavaOnlyArray();
        Iterator r46 = ((ArrayList) r43.getValue()).iterator();
    L94:
        if (r46.hasNext() == false) goto L96;
        x r47 = (x) r46.next();
        JavaOnlyMap r119 = new JavaOnlyMap();
        r119.put(r38, r47.g);
        r45.pushMap(r119);
        goto L94
    L96:
        JavaOnlyMap r48 = new JavaOnlyMap();
        if (r23 != "exposure") goto L99;
        boolean r49 = true;
    L100:
        r48.put("isExposure", Boolean.valueOf(r49));
        r48.put("childrenInfo", r45);
        com.lynx.animax.i r50 = new com.lynx.animax.i(r48, r44, r41.getSign(), 1);
        r41.getLynxContext().g.b(r50);
        goto L91
    L99:
        r49 = false;
    L102:
        if (r37.size() <= 0) goto L144;
        JavaOnlyArray r51 = new JavaOnlyArray();
        r51.add(r37);
        w r52 = this.A;
        if (r52 != null) goto L107;
        LynxLog.b(4, r117, "sendEvent failed since mCallback is null.");
        return;
    L107:
        LynxContext r53 = (LynxContext) r52.f10774a.get();
        if (r53 != null) goto L111;
        LynxLog.b(4, r118, "sendGlobalEvent failed since can not get LynxContext.");
        return;
    L111:
        LynxView r54 = r53.k();
        if (r54 != null) goto L115;
        LynxLog.b(4, r118, "sendGlobalEvent failed since can not get LynxView.");
        return;
    L115:
        r54.sendGlobalEvent(r23, r51);
        return;
    L144:
        return;
    L10:
        LynxContext r55 = (LynxContext) r5.f10774a.get();
        if (r55 != null) goto L13;
        LynxLog.b(4, "UIExposure", "canSendGlobalEvent check failed since can not get LynxContext.");
        goto L41
    L13:
        LynxView r56 = r55.k();
        if (r56 != null) goto L17;
        LynxLog.b(4, "UIExposure", "canSendGlobalEvent check failed since can not get LynxView.");
        goto L41
    L17:
        if (r56.enableJSRuntime() == true) goto L41;
        if (r56.enableAirStrictMode() == true) goto L41;
        Iterator r57 = r22.iterator();
    L23:
        if (r57.hasNext() == false) goto L146;
        x r120 = (x) r57.next();
        int r121 = r120.d;
        w r122 = this.A;
        if (r122 != null) goto L27;
        LynxLog.b(r13, "Lynx.UIExposure", "findNode failed since mCallback is null.");
    L33:
        LynxBaseUI r123 = null;
    L35:
        if (r123 == null) goto L23;
        if (r123.getEvents() == null) goto L23;
        if (r123.getEvents().containsKey(r23) == false) goto L23;
        int r124 = r123.getSign();
        HashMap r125 = new HashMap();
        r125.put("exposure-id", r120.f10776b);
        r125.put("exposure-scene", r120.f10777c);
        r125.put("dataset", r120.e);
        r125.put("unique-id", r120.f);
        r125.put("extra-data", r120.g);
        com.lynx.animax.i r126 = new com.lynx.animax.i(r125, r23, r124, 1);
        r123.getLynxContext().g.b(r126);
        r13 = 4;
        goto L23
    L27:
        LynxContext r127 = (LynxContext) r122.f10774a.get();
        if (r127 != null) goto L31;
        LynxLog.b(r13, "UIExposure", "findNode failed since can not get LynxContext.");
        goto L33
    L31:
        if (((n0) r127.f10147o.get()) != null) goto L34;
        LynxLog.b(r13, "UIExposure", "findNode failed since can not get LynxUIOwner.");
        goto L33
    L34:
        r123 = ((n0) r127.f10147o.get()).v(r121);
        goto L35
    L146:
        return;
    }
}
