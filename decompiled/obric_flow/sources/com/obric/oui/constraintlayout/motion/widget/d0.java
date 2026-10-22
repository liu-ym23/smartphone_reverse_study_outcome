package com.obric.oui.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.MotionScene;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.obric.oui.constraintlayout.widget.Barrier;
import com.obric.oui.constraintlayout.widget.ConstraintHelper;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.constraintlayout.widget.R$id;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MotionLayout f12731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final al.a f12732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c0 f12733c;
    public final ArrayList d;
    public final c0 e;
    public final ArrayList f;
    public final SparseArray g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f12734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SparseIntArray f12735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f12736j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12737k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public MotionEvent f12738l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f12739m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12740n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public x f12741o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f12742p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ug.d f12743q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f12744r;
    public float s;

    public d0(Context r17, MotionLayout r18, int r19) {
        this.f12732b = null;
        this.f12733c = null;
        ArrayList r5 = new ArrayList();
        this.d = r5;
        this.e = null;
        this.f = new ArrayList();
        this.g = new SparseArray();
        this.f12734h = new HashMap();
        this.f12735i = new SparseIntArray();
        this.f12736j = 400;
        this.f12737k = 0;
        this.f12739m = false;
        this.f12740n = false;
        this.f12731a = r18;
        this.f12743q = new ug.d(r18);
        XmlResourceParser r10 = r17.getResources().getXml(r19);
        int r11 = r10.getEventType();     // Catch: IOException -> L15 XmlPullParserException -> L17
        c0 r12 = null;
    L4:
        byte r13 = 1;
        if (r11 == 1) goto L88;
        if (r11 != 2) goto L84;
        String r14 = r10.getName();     // Catch: IOException -> L15 XmlPullParserException -> L17
        switch(r14.hashCode()) {
            case -1349929691: goto L44;
            case -1239391468: goto L41;
            case -687739768: goto L38;
            case 61998586: goto L35;
            case 269306229: goto L32;
            case 312750793: goto L29;
            case 327855227: goto L26;
            case 793277014: goto L23;
            case 1382829617: goto L20;
            case 1942574248: goto L13;
            default: goto L46;
        };     // Catch: IOException -> L15 XmlPullParserException -> L17
    L46:
        r13 = -1;
    L47:
        MotionLayout r15 = this.f12731a;
        switch(r13) {
            case 0: goto L83;
            case 1: goto L69;
            case 2: goto L65;
            case 3: goto L61;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L58;
            case 7: goto L58;
            case 8: goto L55;
            case 9: goto L50;
            default: goto L84;
        };
    L50:
        i0 r16 = new i0(r17, r10);     // Catch: IOException -> L15 XmlPullParserException -> L17
        ug.d r20 = this.f12743q;     // Catch: IOException -> L15 XmlPullParserException -> L17
        ((ArrayList) r20.f22358c).add(r16);     // Catch: IOException -> L15 XmlPullParserException -> L17
        r20.d = null;     // Catch: IOException -> L15 XmlPullParserException -> L17
        int r21 = r16.f12807b;     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (r21 != 4) goto L53;
        ConstraintLayout.getSharedValues().a(r16.f12821u, new j0());     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L84
    L53:
        if (r21 != 5) goto L84;
        ConstraintLayout.getSharedValues().a(r16.f12821u, new j0());     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L84
    L55:
        h r22 = new h(r17, r10);     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (r12 == null) goto L84;
        r12.f12722k.add(r22);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L84
    L58:
        k(r17, r10);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L84
    L59:
        i(r17, r10);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L84
    L60:
        this.f12732b = new al.a(r17, r10);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L84
    L61:
        if (r12 == null) goto L84;
        if (r15.isInEditMode() == true) goto L84;
        r12.f12724m.add(new b0(r17, r12, r10));     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L84
    L65:
        if (r12 != null) goto L67;
        Log.v(MotionScene.TAG, " OnSwipe (" + r17.getResources().getResourceEntryName(r19) + ".xml:" + r10.getLineNumber() + ")");     // Catch: IOException -> L15 XmlPullParserException -> L17
    L67:
        if (r12 == null) goto L84;
        r12.f12723l = new g0(r17, r15, r10);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L84
    L69:
        r12 = new c0(this, r17, r10);     // Catch: IOException -> L15 XmlPullParserException -> L17
        r5.add(r12);     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (this.f12733c != null) goto L77;
        if (r12.f12717b == true) goto L77;
        this.f12733c = r12;     // Catch: IOException -> L15 XmlPullParserException -> L17
        g0 r23 = r12.f12723l;     // Catch: IOException -> L15 XmlPullParserException -> L17
        if (r23 == null) goto L77;
        r23.c(this.f12742p);     // Catch: IOException -> L15 XmlPullParserException -> L17
    L77:
        if (r12.f12717b == false) goto L84;
        if (r12.f12718c != (-1)) goto L81;
        this.e = r12;     // Catch: IOException -> L15 XmlPullParserException -> L17
    L82:
        r5.remove(r12);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L84
    L81:
        this.f.add(r12);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L82
    L83:
        l(r17, r10);     // Catch: IOException -> L15 XmlPullParserException -> L17
        goto L84
    L13:
        if (r14.equals("include") == false) goto L46;
        r13 = 6;
        goto L47
    L20:
        if (r14.equals("StateSet") == false) goto L46;
        r13 = 4;
        goto L47
    L23:
        if (r14.equals(MotionScene.TAG) == false) goto L46;
        r13 = 0;
        goto L47
    L26:
        if (r14.equals("OnSwipe") == false) goto L46;
        r13 = 2;
        goto L47
    L29:
        if (r14.equals("OnClick") == false) goto L46;
        r13 = 3;
        goto L47
    L32:
        if (r14.equals("Transition") == false) goto L46;
    L35:
        if (r14.equals("ViewTransition") == false) goto L46;
        r13 = 9;
        goto L47
    L38:
        if (r14.equals("Include") == false) goto L46;
        r13 = 7;
        goto L47
    L41:
        if (r14.equals("KeyFrameSet") == false) goto L46;
        r13 = 8;
        goto L47
    L44:
        if (r14.equals("ConstraintSet") == false) goto L46;
        r13 = 5;
    L84:
        r11 = r10.next();     // Catch: IOException -> L15 XmlPullParserException -> L17
    L88:
        this.g.put(R$id.motion_base, new com.obric.oui.constraintlayout.widget.d());
        this.f12734h.put("motion_base", Integer.valueOf(R$id.motion_base));
        return;
    L15:
        e = move-exception;
        Log.e(MotionScene.TAG, "Error parsing resource: " + r19, e);
    L17:
        e = move-exception;
        Log.e(MotionScene.TAG, "Error parsing resource: " + r19, e);
        goto L88
    }

    public static int d(Context r5, String r10) {
        if (r10.contains("/") == false) goto L5;
        int r11 = r5.getResources().getIdentifier(r10.substring(r10.indexOf(47) + 1), "id", r5.getPackageName());
    L6:
        if (r11 == (-1)) goto L8;
        return r11;
    L8:
        if (r10.length() > 1) goto L13;
        Log.e(MotionScene.TAG, "error in parsing id");
        return r11;
    L13:
        return Integer.parseInt(r10.substring(1));
    L5:
        r11 = -1;
        goto L6
    }

    public final boolean a(int r10, MotionLayout r11) {
        if (this.f12741o == null) goto L5;
        return false;
    L5:
        Iterator r5 = this.d.iterator();
    L7:
        if (r5.hasNext() == false) goto L36;
        c0 r12 = (c0) r5.next();
        int r13 = r12.f12725n;
        if (r13 == 0) goto L7;
        c0 r14 = this.f12733c;
        if (r14 != r12) goto L17;
        if ((r14.f12729r & 2) != 0) goto L7;
    L17:
        if (r10 != r12.d) goto L27;
        if (r13 == 4) goto L21;
        if (r13 != 2) goto L27;
    L21:
        MotionLayout.TransitionState r15 = MotionLayout.TransitionState.FINISHED;
        r11.setState(r15);
        r11.setTransition(r12);
        if (r12.f12725n != 4) goto L24;
        r11.v(1.0f);
        r11.f12686v0 = null;
        r11.setState(MotionLayout.TransitionState.SETUP);
        r11.setState(MotionLayout.TransitionState.MOVING);
    L25:
        return true;
    L24:
        r11.setProgress(1.0f);
        r11.x(true);
        r11.setState(MotionLayout.TransitionState.SETUP);
        r11.setState(MotionLayout.TransitionState.MOVING);
        r11.setState(r15);
        r11.E();
    L27:
        if (r10 != r12.f12718c) goto L7;
        if (r13 == 3) goto L31;
        if (r13 != 1) goto L7;
    L31:
        MotionLayout.TransitionState r16 = MotionLayout.TransitionState.FINISHED;
        r11.setState(r16);
        r11.setTransition(r12);
        if (r12.f12725n != 3) goto L34;
        r11.v(0.0f);
        r11.setState(MotionLayout.TransitionState.SETUP);
        r11.setState(MotionLayout.TransitionState.MOVING);
    L35:
        return true;
    L34:
        r11.setProgress(0.0f);
        r11.x(true);
        r11.setState(MotionLayout.TransitionState.SETUP);
        r11.setState(MotionLayout.TransitionState.MOVING);
        r11.setState(r16);
        r11.E();
        goto L35
    L36:
        return false;
    }

    public final com.obric.oui.constraintlayout.widget.d b(int r5) {
        al.a r10 = this.f12732b;
        if (r10 == null) goto L7;
        int r11 = r10.d(r5);
        if (r11 == (-1)) goto L7;
        r5 = r11;
    L7:
        SparseArray r12 = this.g;
        if (r12.get(r5) != null) goto L11;
        Log.e(MotionScene.TAG, "Warning could not find ConstraintSet id/" + ym.k.g(this.f12731a.getContext(), r5) + " In MotionScene");
        return (com.obric.oui.constraintlayout.widget.d) r12.get(r12.keyAt(0));
    L11:
        return (com.obric.oui.constraintlayout.widget.d) r12.get(r5);
    }

    public final int c() {
        c0 r5 = this.f12733c;
        if (r5 == null) goto L7;
        return r5.f12719h;
    L7:
        return this.f12736j;
    }

    public final Interpolator e() {
        c0 r5 = this.f12733c;
        int r10 = r5.e;
        if (r10 == (-2)) goto L34;
        if (r10 == (-1)) goto L32;
        if (r10 == 0) goto L30;
        if (r10 == 1) goto L28;
        if (r10 == 2) goto L26;
        if (r10 == 4) goto L24;
        if (r10 == 5) goto L22;
        if (r10 == 6) goto L20;
        return null;
    L20:
        return new AnticipateInterpolator();
    L22:
        return new OvershootInterpolator();
    L24:
        return new BounceInterpolator();
    L26:
        return new DecelerateInterpolator();
    L28:
        return new AccelerateInterpolator();
    L30:
        return new AccelerateDecelerateInterpolator();
    L32:
        return new p(gr.e.d(r5.f), 1);
    L34:
        return AnimationUtils.loadInterpolator(this.f12731a.getContext(), this.f12733c.g);
    }

    public final void f(q r5) {
        c0 r10 = this.f12733c;
        if (r10 != null) goto L11;
        c0 r11 = this.e;
        if (r11 == null) goto L10;
        Iterator r12 = r11.f12722k.iterator();
    L8:
        if (r12.hasNext() == false) goto L18;
        ((h) r12.next()).a(r5);
        goto L8
    L18:
        return;
    L10:
        return;
    L11:
        Iterator r13 = r10.f12722k.iterator();
    L13:
        if (r13.hasNext() == false) goto L15;
        ((h) r13.next()).a(r5);
        goto L13
    }

    public final float g() {
        c0 r5 = this.f12733c;
        if (r5 == null) goto L8;
        g0 r10 = r5.f12723l;
        if (r10 != null) goto L7;
        return 0.0f;
    L7:
        return r10.f12787t;
    L8:
        return 0.0f;
    }

    public final int h() {
        c0 r5 = this.f12733c;
        if (r5 != null) goto L7;
        return -1;
    L7:
        return r5.d;
    }

    public final int i(Context r18, XmlResourceParser r19) {
        com.obric.oui.constraintlayout.widget.d r10 = new com.obric.oui.constraintlayout.widget.d();
        r10.f = false;
        int r11 = r19.getAttributeCount();
        int r12 = 0;
        int r13 = -1;
        int r14 = -1;
    L3:
        if (r12 >= r11) goto L69;
        String r15 = r19.getAttributeName(r12);
        String r16 = r19.getAttributeValue(r12);
        r15.getClass();
        switch(r15.hashCode()) {
            case -1496482599: goto L20;
            case -1153153640: goto L16;
            case 3355: goto L12;
            case 973381616: goto L8;
            default: goto L6;
        };
    L6:
        byte r17 = -1;
    L23:
        switch(r17) {
            case 0: goto L66;
            case 1: goto L75;
            case 2: goto L29;
            case 3: goto L25;
            default: goto L67;
        };
    L25:
        r10.f13071c = r16.split(",");
        int r20 = 0;
    L26:
        String[] r110 = r10.f13071c;
        if (r20 >= r110.length) goto L67;
        r110[r20] = r110[r20].trim();
        r20 = r20 + 1;
        goto L26
    L29:
        r13 = d(r18, r16);
        int r21 = r16.indexOf(47);
        if (r21 < 0) goto L33;
        r16 = r16.substring(r21 + 1);
    L33:
        this.f12734h.put(r16, Integer.valueOf(r13));
        r10.f13069a = ym.k.g(r18, r13);
        goto L67
    L66:
        r14 = d(r18, r16);
        goto L67
    L75:
        r10.d = Integer.parseInt(r16);     // Catch: NumberFormatException -> L36
    L36:
        r16.getClass();
        switch(r16.hashCode()) {
            case -768416914: goto L56;
            case 3317767: goto L52;
            case 3387192: goto L48;
            case 108511772: goto L44;
            case 1954540437: goto L40;
            default: goto L38;
        };
    L38:
        byte r22 = -1;
    L59:
        switch(r22) {
            case 0: goto L65;
            case 1: goto L64;
            case 2: goto L63;
            case 3: goto L62;
            case 4: goto L61;
            default: goto L67;
        };
    L61:
        r10.d = 3;
        goto L67
    L62:
        r10.d = 1;
        goto L67
    L63:
        r10.d = 0;
        goto L67
    L64:
        r10.d = 2;
        goto L67
    L65:
        r10.d = 4;
        goto L67
    L40:
        if (r16.equals("x_right") == false) goto L38;
        r22 = 4;
        goto L59
    L44:
        if (r16.equals("right") == false) goto L38;
        r22 = 3;
        goto L59
    L48:
        if (r16.equals("none") == false) goto L38;
        r22 = 2;
        goto L59
    L52:
        if (r16.equals(OpenPageMethod.ALIGN_LEFT) == false) goto L38;
        r22 = 1;
        goto L59
    L56:
        if (r16.equals("x_left") == false) goto L38;
        r22 = 0;
    L67:
        r12 = r12 + 1;
        goto L3
    L8:
        if (r15.equals("stateLabels") == false) goto L6;
        r17 = 3;
        goto L23
    L12:
        if (r15.equals("id") == false) goto L6;
        r17 = 2;
        goto L23
    L16:
        if (r15.equals("constraintRotate") == false) goto L6;
        r17 = 1;
        goto L23
    L20:
        if (r15.equals("deriveConstraintsFrom") == false) goto L6;
        r17 = 0;
        goto L23
    L69:
        if (r13 == (-1)) goto L74;
        int r5 = this.f12731a.K;
        r10.k(r18, r19);
        if (r14 == (-1)) goto L73;
        this.f12735i.put(r13, r14);
    L73:
        this.g.put(r13, r10);
    L74:
        return r13;
    }

    public final int j(int r10, Context r11) {
        XmlResourceParser r5 = r11.getResources().getXml(r10);
        int r12 = r5.getEventType();     // Catch: IOException -> L12 XmlPullParserException -> L14
    L5:
        if (r12 == 1) goto L29;
        String r13 = r5.getName();     // Catch: IOException -> L12 XmlPullParserException -> L14
        if (2 != r12) goto L16;
        if ("ConstraintSet".equals(r13) == false) goto L16;
        return i(r11, r5);
    L16:
        r12 = r5.next();     // Catch: IOException -> L12 XmlPullParserException -> L14
        goto L5
    L29:
        return -1;
    L12:
        e = move-exception;
        Log.e(MotionScene.TAG, "Error parsing resource: " + r10, e);
        return -1;
    L14:
        e = move-exception;
        Log.e(MotionScene.TAG, "Error parsing resource: " + r10, e);
        return -1;
    }

    public final void k(Context r5, XmlResourceParser r10) {
        TypedArray r11 = r5.obtainStyledAttributes(Xml.asAttributeSet(r10), R$styleable.include);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.include_constraintSet) goto L7;
        j(r11.getResourceId(r14, -1), r5);
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        r11.recycle();
    }

    public final void l(Context r5, XmlResourceParser r10) {
        TypedArray r11 = r5.obtainStyledAttributes(Xml.asAttributeSet(r10), R$styleable.MotionScene);
        int r12 = r11.getIndexCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L13;
        int r14 = r11.getIndex(r13);
        if (r14 != R$styleable.MotionScene_defaultDuration) goto L10;
        int r15 = r11.getInt(r14, this.f12736j);
        this.f12736j = r15;
        if (r15 >= 8) goto L12;
        this.f12736j = 8;
    L12:
        r13 = r13 + 1;
        goto L3
    L10:
        if (r14 != R$styleable.MotionScene_layoutDuringTransition) goto L12;
        this.f12737k = r11.getInteger(r14, 0);
        goto L12
    L13:
        r11.recycle();
    }

    public final void m(int r11, MotionLayout r12) {
        SparseArray r5 = this.g;
        com.obric.oui.constraintlayout.widget.d r10 = (com.obric.oui.constraintlayout.widget.d) r5.get(r11);
        r10.f13070b = r10.f13069a;
        int r13 = this.f12735i.get(r11);
        HashMap r14 = r10.g;
        if (r13 <= 0) goto L35;
        m(r13, r12);
        com.obric.oui.constraintlayout.widget.d r15 = (com.obric.oui.constraintlayout.widget.d) r5.get(r13);
        if (r15 != null) goto L8;
        Log.e(MotionScene.TAG, "ERROR! invalid deriveConstraintsFrom: @id/" + ym.k.g(this.f12731a.getContext(), r13));
        return;
    L8:
        r10.f13070b += "/" + r15.f13070b;
        HashMap r16 = r15.g;
        Iterator r17 = r16.keySet().iterator();
    L10:
        if (r17.hasNext() == false) goto L72;
        Integer r18 = (Integer) r17.next();
        r18.getClass();
        com.obric.oui.constraintlayout.widget.c r19 = (com.obric.oui.constraintlayout.widget.c) r16.get(r18);
        if (r14.containsKey(r18) == true) goto L14;
        r14.put(r18, new com.obric.oui.constraintlayout.widget.c());
    L14:
        com.obric.oui.constraintlayout.widget.c r110 = (com.obric.oui.constraintlayout.widget.c) r14.get(r18);
        if (r110 == null) goto L10;
        lr.g r20 = r110.e;
        if (r20.f19717b == true) goto L20;
        r20.a(r19.e);
    L20:
        lr.i r21 = r110.f13064c;
        if (r21.f19759a == true) goto L23;
        lr.i r22 = r19.f13064c;
        r21.f19759a = r22.f19759a;
        r21.f19760b = r22.f19760b;
        r21.d = r22.d;
        r21.e = r22.e;
        r21.f19761c = r22.f19761c;
    L23:
        lr.j r23 = r110.f;
        if (r23.f19763a == true) goto L26;
        r23.a(r19.f);
    L26:
        lr.h r24 = r110.d;
        if (r24.f19750a == true) goto L29;
        r24.a(r19.d);
    L29:
        Iterator r25 = r19.g.keySet().iterator();
    L31:
        if (r25.hasNext() == false) goto L10;
        String r26 = (String) r25.next();
        if (r110.g.containsKey(r26) == true) goto L31;
        r110.g.put(r26, (lr.b) r19.g.get(r26));
    L72:
        Iterator r111 = r14.values().iterator();
    L74:
        if (r111.hasNext() == false) goto L90;
        com.obric.oui.constraintlayout.widget.c r112 = (com.obric.oui.constraintlayout.widget.c) r111.next();
        if (r112.f13065h == null) goto L74;
        if (r112.f13063b == null) goto L80;
        Iterator r113 = r14.keySet().iterator();
    L83:
        if (r113.hasNext() == false) goto L74;
        com.obric.oui.constraintlayout.widget.c r27 = r10.i(((Integer) r113.next()).intValue());
        String r28 = r27.e.l0;
        if (r28 == null) goto L83;
        if (r112.f13063b.matches(r28) == false) goto L83;
        r112.f13065h.e(r27);
        r27.g.putAll((HashMap) r112.g.clone());
        goto L83
    L80:
        r112.f13065h.e(r10.i(r112.f13062a));
        goto L74
    L90:
        return;
    L35:
        r10.f13070b = ai.j0.q(new StringBuilder(), r10.f13070b, "  layout");
        int r114 = r12.getChildCount();
        int r115 = 0;
    L36:
        if (r115 >= r114) goto L72;
        View r29 = r12.getChildAt(r115);
        ConstraintLayout.LayoutParams r30 = (ConstraintLayout.LayoutParams) r29.getLayoutParams();
        int r31 = r29.getId();
        if (r10.f == false) goto L45;
        if (r31 != (-1)) goto L45;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L45:
        if (r14.containsKey(Integer.valueOf(r31)) == true) goto L47;
        r14.put(Integer.valueOf(r31), new com.obric.oui.constraintlayout.widget.c());
    L47:
        com.obric.oui.constraintlayout.widget.c r32 = (com.obric.oui.constraintlayout.widget.c) r14.get(Integer.valueOf(r31));
        if (r32 == null) goto L71;
        lr.g r33 = r32.e;
        if (r33.f19717b == true) goto L58;
        r32.c(r31, r30);
        if ((r29 instanceof ConstraintHelper) == false) goto L57;
        r33.f19728j0 = ((ConstraintHelper) r29).getReferencedIds();
        if ((r29 instanceof Barrier) == false) goto L57;
        Barrier r34 = (Barrier) r29;
        r33.f19737o0 = r34.getAllowsGoneWidget();
        r33.g0 = r34.getType();
        r33.f19725h0 = r34.getMargin();
    L57:
        r33.f19717b = true;
    L58:
        lr.i r35 = r32.f13064c;
        if (r35.f19759a == true) goto L61;
        r35.f19760b = r29.getVisibility();
        r35.d = r29.getAlpha();
        r35.f19759a = true;
    L61:
        lr.j r36 = r32.f;
        if (r36.f19763a == true) goto L71;
        r36.f19763a = true;
        r36.f19764b = r29.getRotation();
        r36.f19765c = r29.getRotationX();
        r36.d = r29.getRotationY();
        r36.e = r29.getScaleX();
        r36.f = r29.getScaleY();
        float r37 = r29.getPivotX();
        float r38 = r29.getPivotY();
        if (r37 == 0.0d) goto L66;
    L67:
        r36.g = r37;
        r36.f19766h = r38;
    L68:
        r36.f19768j = r29.getTranslationX();
        r36.f19769k = r29.getTranslationY();
        r36.f19770l = r29.getTranslationZ();
        if (r36.f19771m == false) goto L71;
        r36.f19772n = r29.getElevation();
        goto L71
    L66:
        if (r38 == 0.0d) goto L68;
    L71:
        r115 = r115 + 1;
        goto L36
    }

    public final void n(int r10, int r11) {
        al.a r5 = this.f12732b;
        if (r5 == null) goto L12;
        int r12 = r5.d(r10);
        if (r12 != (-1)) goto L8;
        r12 = r10;
    L8:
        int r13 = this.f12732b.d(r11);
        if (r13 != (-1)) goto L13;
    L11:
        r13 = r11;
    L13:
        c0 r14 = this.f12733c;
        if (r14 != null) goto L16;
    L20:
        ArrayList r15 = this.d;
        Iterator r16 = r15.iterator();
    L22:
        if (r16.hasNext() == false) goto L34;
        c0 r17 = (c0) r16.next();
        int r18 = r17.f12718c;
        if (r18 == r13) goto L26;
    L27:
        if (r18 != r11) goto L22;
        if (r17.d != r10) goto L22;
    L30:
        this.f12733c = r17;
        g0 r19 = r17.f12723l;
        if (r19 == null) goto L57;
        r19.c(this.f12742p);
        return;
    L57:
        return;
    L26:
        if (r17.d == r12) goto L30;
    L34:
        c0 r20 = this.e;
        Iterator r21 = this.f.iterator();
    L36:
        if (r21.hasNext() == false) goto L40;
        c0 r22 = (c0) r21.next();
        if (r22.f12718c != r11) goto L36;
        r20 = r22;
        goto L36
    L40:
        c0 r110 = new c0(this, r20);
        r110.d = r12;
        r110.f12718c = r13;
        if (r12 == (-1)) goto L43;
        r15.add(r110);
    L43:
        this.f12733c = r110;
        return;
    L16:
        if (r14.f12718c != r11) goto L20;
        if (r14.d != r10) goto L20;
        return;
    L12:
        r12 = r10;
        goto L11
    }

    public final boolean o() {
        Iterator r5 = this.d.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (((c0) r5.next()).f12723l == null) goto L4;
        return true;
    L8:
        c0 r10 = this.f12733c;
        if (r10 != null) goto L11;
    L13:
        return false;
    L11:
        if (r10.f12723l == null) goto L13;
        return true;
    }
}
