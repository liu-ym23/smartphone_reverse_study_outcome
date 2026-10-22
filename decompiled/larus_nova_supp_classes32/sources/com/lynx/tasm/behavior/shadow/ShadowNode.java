package com.lynx.tasm.behavior.shadow;

import com.bytedance.ies.xelement.text.emoji.LynxEmojiShadowNode;
import com.bytedance.ies.xelement.text.inlinetruncation.LynxInlineTruncationShadowNode;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.utils.PropsUpdater;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.event.EventsListener;
import com.obric.aivoice.core.data.NameKeys;
import f6a.a;
import java.util.ArrayList;
import java.util.Map;
import y6a.n;
import z6a.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class ShadowNode extends LayoutNode {
    public String j;
    public ArrayList<ShadowNode> k;
    public ShadowNode l;
    public LynxContext m;
    public n n;
    public boolean o;
    public Map<String, EventsListener> p;
    public EventTarget.EnableStatus q;
    public EventTarget.EnableStatus r;
    public EventTarget.PointerEventsValue s;
    public ReadableMap t;
    public boolean u;

    public Object m() {
        return null;
    }

    public boolean p() {
        return this instanceof LynxInlineTruncationShadowNode;
    }

    public void s() {
    }

    public void t() {
    }

    public boolean z() {
        return this instanceof LynxEmojiShadowNode;
    }

    public h A() {
        return new h(this.b, this.p, this.q, this.u, this.r, this.s, this.t);
    }

    public final LynxContext getContext() {
        LynxContext r0 = this.m;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new AssertionError();
    }

    public final int l() {
        ArrayList<ShadowNode> r0 = this.k;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    public final String n() {
        String r0 = this.j;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new AssertionError();
    }

    public void q() {
        if (this.o == false) goto L6;
        return;
    L6:
        if (p() == true) goto L12;
        if (this.e == true) goto L24;
        this.e = true;
        this.a.f(this.b);
        return;
    L24:
        return;
    L12:
        if (p() == true) goto L14;
        ShadowNode r0 = this;
    L19:
        if (r0 == null) goto L25;
        r0.q();
        return;
    L25:
        return;
    L14:
        r0 = this.l;
    L15:
        if (r0 == null) goto L19;
        if (r0.p() == false) goto L19;
        r0 = r0.l;
        goto L15
    }

    public boolean r() {
        Map<String, EventsListener> r0 = this.p;
        if (r0 != null) goto L5;
    L6:
        EventTarget.EnableStatus r1 = this.q;
        EventTarget.EnableStatus r2 = EventTarget.EnableStatus.Undefined;
        if (r1 == r2) goto L9;
    L14:
        return true;
    L9:
        if (this.r != r2) goto L14;
        if (this.s != EventTarget.PointerEventsValue.Unset) goto L14;
        return false;
    L5:
        if (r0.isEmpty() == false) goto L14;
        goto L6
    }

    public ShadowNode() {
        this.t = new JavaOnlyMap();
        EventTarget.EnableStatus r0 = EventTarget.EnableStatus.Undefined;
        this.q = r0;
        this.r = r0;
        this.s = EventTarget.PointerEventsValue.Unset;
        this.u = true;
    }

    public final boolean o() {
        if (p() == true) goto L13;
        boolean r0 = this.e;
        if (r0 == false) goto L8;
        return r0;
    L8:
        if (this.a.e(this.b) == false) goto L11;
        this.e = true;
    L11:
        return this.e;
    L13:
        if (p() == true) goto L15;
        ShadowNode r1 = this;
    L20:
        if (r1 != null) goto L22;
        return false;
    L22:
        return r1.o();
    L15:
        r1 = this.l;
    L16:
        if (r1 == null) goto L20;
        if (r1.p() == false) goto L20;
        r1 = r1.l;
        goto L16
    }

    public String toString() {
        return this.j;
    }

    public final void B(x0 r3) {
        PropsUpdater.d(this, r3);     // Catch: Exception -> L4
        s();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("lynx_ShadowNode", "Catch exception for tag: ".concat(n()));
        getContext().handleException(e);
    }

    public final ShadowNode k(int r4) {
        ArrayList<ShadowNode> r0 = this.k;
        if (r0 == null) goto L7;
        return (ShadowNode) ListProtector.get(r0, r4);
    L7:
        throw new ArrayIndexOutOfBoundsException("Index " + r4 + " out of bounds: node has no children");
    }

    @LynxProp(name = "dataset")
    public void setDataset(ReadableMap r1) {
        this.t = r1;
    }

    @LynxProp(name = "event-through")
    public void setEventThrough(a r2) {
        if (r2 != null) goto L13;
        this.r = EventTarget.EnableStatus.Undefined;
    L13:
    L10:
        th = move-exception;
        LLog.i("lynx_ShadowNode", th.toString());
        this.r = EventTarget.EnableStatus.Undefined;
        return;
    L5:
        if (r2.asBoolean() == false) goto L7;
        EventTarget.EnableStatus r3 = EventTarget.EnableStatus.Enable;     // Catch: Throwable -> L10
    L8:
        this.r = r3;     // Catch: Throwable -> L10
        return;
    L7:
        r3 = EventTarget.EnableStatus.Disable;     // Catch: Throwable -> L10
        goto L8
    }

    @LynxProp(name = "enable-touch-pseudo-propagation")
    public void setEventThroughPropagation(a r3) {
        if (r3 != null) goto L11;
        this.u = true;
        return;
    L11:
        this.u = r3.asBoolean();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        LLog.i("lynx_ShadowNode", th.toString());
        this.u = true;
    }

    @LynxProp(name = "ignore-focus")
    public void setIgnoreFocus(a r2) {
        if (r2 != null) goto L14;
        this.q = EventTarget.EnableStatus.Undefined;
        return;
    L14:
    L11:
        th = move-exception;
        LLog.i("lynx_ShadowNode", th.toString());
        this.q = EventTarget.EnableStatus.Undefined;
        return;
    L6:
        if (r2.asBoolean() == false) goto L8;
        EventTarget.EnableStatus r3 = EventTarget.EnableStatus.Enable;     // Catch: Throwable -> L11
    L9:
        this.q = r3;     // Catch: Throwable -> L11
        return;
    L8:
        r3 = EventTarget.EnableStatus.Disable;     // Catch: Throwable -> L11
        goto L9
    }

    @LynxProp(name = "pointer-events")
    public void setPointerEvents(int r2) {
        if (r2 >= EventTarget.PointerEventsValue.Auto.ordinal()) goto L5;
        return;
    L5:
        if (r2 >= EventTarget.PointerEventsValue.Unset.ordinal()) goto L9;
        this.s = EventTarget.PointerEventsValue.values()[r2];
        return;
    }

    @LynxProp(name = "vertical-align")
    public void setVerticalAlign(ReadableArray r2) {
        if (this.m.isTextRefactorEnabled() == true) goto L6;
        y(r2);
        return;
    }

    public final void u(int r4) {
        ArrayList<ShadowNode> r0 = this.k;
        if (r0 == null) goto L7;
        ((ShadowNode) ListProtector.remove(r0, r4)).l = null;
        return;
    L7:
        throw new ArrayIndexOutOfBoundsException("Index " + r4 + " out of bounds: node has no children");
    }

    public final void v(String r5) {
        if (this.m == null) goto L6;
        LynxError r0 = new LynxError(60401, r5, NameKeys.UnloadStrategy_No_Strategy, "error");
        this.m.handleLynxError(r0);
        return;
    }

    public void w(LynxContext r1) {
        this.m = r1;
    }

    public void x(Map<String, EventsListener> r1) {
        this.p = r1;
    }

    public final void y(ReadableArray r4) {
        if (this.n != null) goto L6;
        this.n = new n();
    L6:
        if (r4 != null) goto L8;
    L11:
        n r5 = this.n;
        r5.a = 0;
        r5.b = 0.0f;
    L12:
        q();
        return;
    L8:
        if (r4.size() < 2) goto L11;
        n r1 = this.n;
        r1.a = r4.getInt(0);
        n r0 = this.n;
        r0.b = (float) r4.getDouble(1);
        goto L12
    }

    public void j(ShadowNode r3, int r4) {
        if (r3.l != null) goto L10;
        if (this.k != null) goto L7;
        this.k = new ArrayList(4);
    L7:
        ListProtector.add(this.k, r4, r3);
        r3.l = this;
        return;
    L10:
        throw new RuntimeException("Tried to add child that already has a parent! Remove it from its parent first.");
    }
}
