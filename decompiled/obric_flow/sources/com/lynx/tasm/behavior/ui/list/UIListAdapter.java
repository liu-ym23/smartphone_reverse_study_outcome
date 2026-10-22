package com.lynx.tasm.behavior.ui.list;

import ai.g0;
import androidx.recyclerview.widget.RecyclerView;
import bi.e;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxTemplateRender;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.i;
import com.lynx.tasm.utils.j;
import en.m;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class UIListAdapter extends RecyclerView.Adapter<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f10529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f10530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UIList f10531c;
    public boolean d;
    public boolean e;
    public boolean f;
    public JavaOnlyArray g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JavaOnlyArray f10532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public JavaOnlyArray f10533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public JavaOnlyArray f10534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public JavaOnlyArray f10535k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JavaOnlyArray f10536l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JavaOnlyArray f10537m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public JavaOnlyArray f10538n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g0 f10539o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10540p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public JavaOnlyArray f10541q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HashMap f10542r;
    public final m s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final m f10543t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f10544u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap f10545v;

    public UIListAdapter(UIList r5) {
        this.d = false;
        this.e = false;
        this.f = false;
        this.f10540p = 0;
        this.s = new m(this, 0);
        this.f10543t = new m(this, 1);
        this.f10544u = new ArrayList();
        this.f10545v = new HashMap();
        this.f10529a = new HashMap();
        this.f10530b = new HashMap();
        g0 r10 = new g0();
        r10.g = this;
        this.f10539o = r10;
        this.f10531c = r5;
    }

    public final void a(JavaOnlyMap r10) {
        JavaOnlyArray r5 = this.g;
        if (r5 != null) goto L5;
    L9:
        boolean r11 = false;
    L10:
        if (r10 != null) goto L12;
        return;
    L12:
        if (r10.isEmpty() == true) goto L80;
        ReadableArray r12 = r10.getArray("itemkeys");
        if ((r12 instanceof JavaOnlyArray) == false) goto L17;
        this.f10541q = (JavaOnlyArray) r12;
    L17:
        this.f10542r = new HashMap();
        int r13 = 0;
    L19:
        if (r13 >= this.f10541q.size()) goto L21;
        this.f10542r.put(this.f10541q.getString(r13), Integer.valueOf(r13));
        r13 = r13 + 1;
        goto L19
    L21:
        ReadableArray r14 = r10.getArray("fullspan");
        if ((r14 instanceof JavaOnlyArray) == false) goto L24;
        this.f10532h = (JavaOnlyArray) r14;
    L24:
        ReadableArray r15 = r10.getArray("viewTypes");
        if ((r15 instanceof JavaOnlyArray) == false) goto L27;
        this.g = (JavaOnlyArray) r15;
    L27:
        ReadableArray r16 = r10.getArray("stickyTop");
        if ((r16 instanceof JavaOnlyArray) == false) goto L30;
        this.f10533i = (JavaOnlyArray) r16;
    L30:
        ReadableArray r17 = r10.getArray("stickyBottom");
        if ((r17 instanceof JavaOnlyArray) == false) goto L33;
        this.f10534j = (JavaOnlyArray) r17;
    L33:
        boolean r18 = r10.getArray("estimatedHeight") instanceof JavaOnlyArray;
        ReadableArray r19 = r10.getArray("estimatedHeightPx");
        if ((r19 instanceof JavaOnlyArray) == false) goto L36;
        this.f10535k = (JavaOnlyArray) r19;
    L36:
        boolean r20 = r10.getBoolean("diffable");
        this.d = r10.getBoolean("newarch");
        int r21 = 0;
    L38:
        if (r21 >= this.g.size()) goto L43;
        String r22 = this.g.getString(r21);
        HashMap r23 = this.f10529a;
        if (r23.containsKey(r22) == true) goto L42;
        r23.put(r22, Integer.valueOf(r23.size()));
    L42:
        r21 = r21 + 1;
        goto L38
    L43:
        if (r11 == true) goto L69;
        if (r20 == false) goto L69;
        if (this.e == false) goto L69;
        ReadableMap r24 = r10.getMap("diffResult");
        if (r24 == null) goto L50;
        r24.size();
    L50:
        g0 r25 = this.f10539o;
        r25.getClass();
        r25.f209a = r24.getArray("insertions");
        r25.f210b = r24.getArray("removals");
        r25.f211c = r24.getArray("updateFrom");
        r25.d = r24.getArray("updateTo");
        r25.e = r24.getArray("moveFrom");
        r25.f = r24.getArray("moveTo");
        if (g0.b((ReadableArray) r25.f209a) == false) goto L53;
    L62:
        ((UIListAdapter) r25.g).e = false;
    L63:
        boolean r26 = c();
        m r27 = this.s;
        if (r26 == false) goto L67;
        j.a().post(r27);
        return;
    L67:
        r27.run();
        return;
    L53:
        if (g0.b((ReadableArray) r25.f210b) == true) goto L62;
        if (g0.b((ReadableArray) r25.f211c) == true) goto L62;
        if (g0.b((ReadableArray) r25.d) == true) goto L62;
        if (g0.b((ReadableArray) r25.e) == true) goto L62;
        if (g0.b((ReadableArray) r25.f) == false) goto L63;
    L69:
        this.f10545v.clear();
        boolean r28 = c();
        m r29 = this.f10543t;
        if (r28 == false) goto L73;
        j.a().post(r29);
        return;
    L73:
        r29.run();
        return;
    L80:
        return;
    L5:
        if (this.f10532h == null) goto L9;
        if (r5.size() != this.f10532h.size()) goto L9;
        r11 = true;
        goto L10
    }

    public final void b(UIComponent r5) {
        if (r5 == null) goto L29;
        UIList r10 = this.f10531c;
        if (r10.I == null) goto L19;
        if (r10 == null) goto L12;
        RecyclerView r11 = r10.g();
        if (r11 == null) goto L12;
        int r12 = 0;
    L10:
        if (r12 >= r11.getChildCount()) goto L12;
        r11.getChildAt(r12);
        r12 = r12 + 1;
    L12:
        e r13 = r10.I;
        if (r13 == null) goto L19;
        if (r13.b(r5.f10770b) == false) goto L19;
        com.lynx.tasm.behavior.ui.utils.e.i(new StringBuilder("recycleHolderComponent the component is used. itemKey :"), r5.f10770b, 2, "UIList");
        return;
    L19:
        if (this.f == false) goto L24;
        i r14 = r10.f10502a;
        int r15 = r10.getSign();
        int r16 = r5.getSign();
        LynxTemplateRender r17 = (LynxTemplateRender) r14.f10879a;
        if (r17 == null) goto L30;
        r17.c0(r15, r16);
        return;
    L30:
        return;
    L24:
        i r18 = r10.f10502a;
        int r19 = r10.getSign();
        int r20 = r5.getSign();
        LynxTemplateRender r21 = (LynxTemplateRender) r18.f10879a;
        if (r21 == null) goto L31;
        r21.T(r19, r20);
        return;
    L31:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c() {
        if (this.d == false) goto L12;
        UIList r5 = this.f10531c;
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r5.getView() != 0) goto L9;
        return false;
    L9:
        if (((RecyclerView) r5.getView()).isComputingLayout() == false) goto L16;
        return true;
    L16:
        return false;
    L12:
        return false;
    }
}
