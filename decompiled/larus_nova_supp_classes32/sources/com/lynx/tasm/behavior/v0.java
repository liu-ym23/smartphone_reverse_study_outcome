package com.lynx.tasm.behavior;

import android.util.SparseArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.PropBundle;
import com.lynx.tasm.event.EventsListener;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class v0 extends LayoutContext {
    public final LynxContext d;
    public final y6a.f e;
    public final c f;
    public final w0 g;
    public final LayoutNodeManager h;

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void scheduleLayout() {
        if (this.b == false) goto L5;
        return;
    L5:
        this.e.a(new u0(this));
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void detachNativePtr() {
        super.detachNativePtr();
        w0 r0 = this.g;
        if (r0 == null) goto L12;
        SparseArray<ShadowNode> r1 = r0.a;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.size() <= 0) goto L15;
        int r2 = 0;
    L10:
        if (r2 >= r1.size()) goto L16;
        ShadowNode r3 = r1.valueAt(r2);
        r3.o = true;
        r3.t();
        r3.a = null;
        r2 = r2 + 1;
        goto L10
    L16:
        return;
    L15:
        return;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void attachLayoutNodeManager(long r2) {
        this.h.a = r2;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void destroyNodes(int[] r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        int r2 = r6[r1];
        w0 r3 = this.g;
        ShadowNode r4 = r3.a.get(r2);
        r3.a.remove(r2);
        if (r4 == null) goto L7;
        r4.o = true;
        r4.t();
        r4.a = null;
    L7:
        r1 = r1 + 1;
        goto L3
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void dispatchOnLayoutBefore(int r2) {
        this.g.a(r2).g();
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final Object getExtraBundle(int r2) {
        ShadowNode r3 = this.g.a(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.m();
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void setFontFaces(ReadableMap r3) {
        this.d.setFontFaces(r3.getMap("fontfaces"));
    }

    public v0(LynxContext r1, c r2, y6a.f r3) {
        this.d = r1;
        this.g = new w0();
        this.f = r2;
        this.e = r3;
        this.h = new LayoutNodeManager();
        a(this);
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void insertNode(int r4, int r5, int r6) {
        ShadowNode r0 = this.g.a(r4);
        ShadowNode r1 = this.g.a(r5);
        if (r0 == null) goto L18;
        if (r1 != null) goto L7;
        return;
    L7:
        if (r6 != (-1)) goto L9;
    L10:
        r6 = r0.l();
    L16:
        r0.j(r1, r6);     // Catch: ArrayIndexOutOfBoundsException -> L13
    L14:
        r0.q();
        return;
    L13:
        LLog.w("ShadowNodeOwner", "Add child out of bounds, parentSignature: " + r4 + ", index: " + r6 + ", childSignature: " + r5);
        goto L14
    L9:
        if (r6 <= r0.l()) goto L16;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public void removeNode(int r5, int r6, int r7) {
        ShadowNode r0 = this.g.a(r5);
        if (r0 != null) goto L5;
        return;
    L5:
        ShadowNode r1 = this.g.a(r6);
        int r2 = -1;
        if (r1 == null) goto L11;
        ArrayList<ShadowNode> r3 = r0.k;
        if (r3 == null) goto L11;
        r2 = r3.indexOf(r1);
    L11:
        if (r2 < 0) goto L17;
        r7 = r2;
    L17:
        r0.u(r7);     // Catch: ArrayIndexOutOfBoundsException -> L15
        return;
    L15:
        LLog.w("ShadowNodeOwner", "Remove child out of bounds, parentSignature: " + r5 + ", index: " + r7 + ", childSignature: " + r6);
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void updateProps(int r3, PropBundle r4, ReadableMapBuffer r5) {
        ReadableArray r0 = null;
        if (r4 == null) goto L5;
        ReadableMap r1 = r4.getProps();
    L6:
        if (r4 == null) goto L8;
        r0 = r4.getEventHandlers();
    L8:
        ShadowNode r6 = this.g.a(r3);
        if (r6 == null) goto L16;
        if (r1 == null) goto L12;
        r6.B(new x0(r1, r5));
    L12:
        if (r0 == null) goto L17;
        r6.x(EventsListener.convertEventListeners(r0));
        return;
    L17:
        return;
    L16:
        throw new RuntimeException("Trying to update non-existent view with tag " + r3);
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final int createNode(int r4, String r5, PropBundle r6, ReadableMapBuffer r7, boolean r8) {
        ReadableArray r0 = null;
        if (r6 == null) goto L5;
        ReadableMap r1 = r6.getProps();
    L6:
        if (r6 == null) goto L8;
        r0 = r6.getEventHandlers();
    L8:
        ShadowNode r9 = this.f.c(r5).createShadowNode();
        if (r9 == null) goto L11;
        int r2 = 4;
    L14:
        r9.b = r4;
        r9.j = r5;
        r9.w(this.d);
        r9.a = this.h;
        r9.x(EventsListener.convertEventListeners(r0));
        this.g.a.put(r9.b, r9);
        if (r1 == null) goto L18;
        r9.B(new x0(r1, r7));
    L18:
        if (this.b == true) goto L21;
        r9.e();
    L21:
        if (r9.p() == false) goto L23;
        r2 = r2 | 2;
    L23:
        if (r8 == true) goto L25;
        return r2;
    L25:
        if (r9.z() == true) goto L27;
        return r2;
    L27:
        return r2 | 32;
    L11:
        r2 = 1;
        if (r8 == false) goto L28;
        r9 = new NativeLayoutNodeRef();
        goto L14
    L28:
        return 1;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void dispatchOnLayout(int r1, int r2, int r3, int r4, int r5) {
        this.g.a(r1).f(r4, r5);
    }
}
