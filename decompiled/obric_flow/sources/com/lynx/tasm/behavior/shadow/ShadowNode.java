package com.lynx.tasm.behavior.shadow;

import ai.j0;
import android.graphics.Typeface;
import androidx.annotation.Nullable;
import com.bytedance.ies.xelement.text.inlinetruncation.LynxInlineTruncationShadowNode;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.e0;
import com.lynx.tasm.behavior.event.EventTarget$EnableStatus;
import com.lynx.tasm.behavior.event.EventTarget$PointerEventsValue;
import com.lynx.tasm.u0;
import java.util.ArrayList;
import java.util.HashMap;
import pm.a;
import ym.n;

/* JADX INFO: loaded from: classes2.dex */
@e0
public class ShadowNode extends LayoutNode {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f10346j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f10347k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ShadowNode f10348l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b0 f10349m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public n f10350n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10351o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HashMap f10352p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public EventTarget$EnableStatus f10353q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public EventTarget$EnableStatus f10354r;
    public EventTarget$PointerEventsValue s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ReadableMap f10355t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f10356u;

    public ShadowNode() {
        this.f10336c = false;
        this.d = false;
        this.e = false;
        this.g = null;
        this.f10338i = 0;
        this.f10355t = new JavaOnlyMap();
        EventTarget$EnableStatus r5 = EventTarget$EnableStatus.f10246c;
        this.f10353q = r5;
        this.f10354r = r5;
        this.s = EventTarget$PointerEventsValue.f10249c;
        this.f10356u = true;
    }

    public final void b(Typeface r5, int r10) {
        n();
    }

    public final ShadowNode e(int r5) {
        ArrayList r10 = this.f10347k;
        if (r10 == null) goto L7;
        return (ShadowNode) r10.get(r5);
    L7:
        throw new ArrayIndexOutOfBoundsException(j0.h(r5, "Index ", " out of bounds: node has no children"));
    }

    public void f(int r5, ShadowNode r10) {
        if (r10.f10348l != null) goto L10;
        if (this.f10347k != null) goto L7;
        this.f10347k = new ArrayList(4);
    L7:
        this.f10347k.add(r5, r10);
        r10.f10348l = this;
        return;
    L10:
        throw new RuntimeException("Tried to add child that already has a parent! Remove it from its parent first.");
    }

    public final void g(ReadableArray r5) {
        if (this.f10350n != null) goto L5;
        n r10 = new n();
        r10.f23307a = 0;
        r10.f23308b = 0.0f;
        this.f10350n = r10;
    L5:
        if (r5 != null) goto L7;
    L10:
        n r11 = this.f10350n;
        r11.f23307a = 0;
        r11.f23308b = 0.0f;
    L11:
        n();
        return;
    L7:
        if (r5.size() < 2) goto L10;
        n r12 = this.f10350n;
        r12.f23307a = r5.getInt(0);
        n r13 = this.f10350n;
        r13.f23308b = (float) r5.getDouble(1);
        goto L11
    }

    public void h(b0 r5) {
        this.f10349m = r5;
    }

    public void i(HashMap r5) {
        this.f10352p = r5;
    }

    public final int j() {
        ArrayList r5 = this.f10347k;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.size();
    }

    public final LynxContext k() {
        b0 r5 = this.f10349m;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new AssertionError();
    }

    public Object l() {
        return null;
    }

    public boolean m() {
        return this instanceof LynxInlineTruncationShadowNode;
    }

    public final void n() {
        if (this.f10351o == false) goto L6;
        return;
    L6:
        if (m() == true) goto L12;
        if (this.e == true) goto L24;
        this.e = true;
        this.f10334a.h(this.f10335b);
        return;
    L24:
        return;
    L12:
        if (m() == false) goto L19;
        ShadowNode this = this.f10348l;
    L15:
        if (this == null) goto L19;
        if (this.m() == false) goto L19;
        this = this.f10348l;
    L19:
        if (this == null) goto L25;
        this.n();
        return;
    }

    public boolean o() {
        HashMap r5 = this.f10352p;
        if (r5 != null) goto L5;
    L6:
        EventTarget$EnableStatus r10 = this.f10353q;
        EventTarget$EnableStatus r11 = EventTarget$EnableStatus.f10246c;
        if (r10 == r11) goto L9;
        return true;
    L9:
        if (this.f10354r == r11) goto L11;
        return true;
    L11:
        if (this.s != EventTarget$PointerEventsValue.f10249c) goto L19;
        return false;
    L19:
        return true;
    L5:
        if (r5.isEmpty() == true) goto L6;
        return true;
    }

    public void p() {
    }

    public void q() {
    }

    public boolean r() {
        return this instanceof NativeLayoutNodeRef;
    }

    @c0(name = "dataset")
    public void setDataset(@Nullable ReadableMap r5) {
        this.f10355t = r5;
    }

    @c0(name = "event-through")
    public void setEventThrough(@Nullable a r5) {
        if (r5 != null) goto L14;
        this.f10354r = EventTarget$EnableStatus.f10246c;
    L14:
    L7:
        th = move-exception;
        LynxLog.b(2, "lynx_ShadowNode", th.toString());
        this.f10354r = EventTarget$EnableStatus.f10246c;
        return;
    L5:
        if (r5.asBoolean() == false) goto L9;
        EventTarget$EnableStatus r10 = EventTarget$EnableStatus.f10244a;     // Catch: Throwable -> L7
    L10:
        this.f10354r = r10;     // Catch: Throwable -> L7
        return;
    L9:
        r10 = EventTarget$EnableStatus.f10245b;     // Catch: Throwable -> L7
        goto L10
    }

    @c0(name = "enable-touch-pseudo-propagation")
    public void setEventThroughPropagation(a r5) {
        if (r5 != null) goto L11;
        this.f10356u = true;
        return;
    L11:
        this.f10356u = r5.asBoolean();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        LynxLog.b(2, "lynx_ShadowNode", th.toString());
        this.f10356u = true;
    }

    @c0(name = "ignore-focus")
    public void setIgnoreFocus(@Nullable a r5) {
        if (r5 != null) goto L15;
        this.f10353q = EventTarget$EnableStatus.f10246c;
        return;
    L15:
    L8:
        th = move-exception;
        LynxLog.b(2, "lynx_ShadowNode", th.toString());
        this.f10353q = EventTarget$EnableStatus.f10246c;
        return;
    L6:
        if (r5.asBoolean() == false) goto L10;
        EventTarget$EnableStatus r10 = EventTarget$EnableStatus.f10244a;     // Catch: Throwable -> L8
    L11:
        this.f10353q = r10;     // Catch: Throwable -> L8
        return;
    L10:
        r10 = EventTarget$EnableStatus.f10245b;     // Catch: Throwable -> L8
        goto L11
    }

    @c0(name = "pointer-events")
    public void setPointerEvents(int r5) {
        if (r5 >= 0) goto L4;
        return;
    L4:
        if (r5 >= 2) goto L8;
        this.s = EventTarget$PointerEventsValue.values()[r5];
        return;
    }

    @c0(name = "vertical-align")
    public void setVerticalAlign(@Nullable ReadableArray r5) {
        u0 r10 = this.f10349m.K;
        if (r10 == null) goto L5;
        boolean r11 = r10.s;
    L6:
        if (r11 == true) goto L9;
        g(r5);
        return;
    L9:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public String toString() {
        return this.f10346j;
    }
}
