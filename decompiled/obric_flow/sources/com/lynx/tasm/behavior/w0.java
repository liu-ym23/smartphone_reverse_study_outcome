package com.lynx.tasm.behavior;

import android.util.SparseArray;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.PropBundle;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class w0 extends LayoutContext {
    public final com.lynx.tasm.b0 d;
    public final ym.f e;
    public final c f;
    public final x0 g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LayoutNodeManager f10809h;

    public w0(com.lynx.tasm.b0 r5, c r10, ym.f r11) {
        this.f10135a = 0;
        this.f10137c = 0;
        this.d = r5;
        this.g = new x0(0);
        this.f = r10;
        this.e = r11;
        LayoutNodeManager r12 = new LayoutNodeManager();
        r12.f10138a = 0;
        this.f10809h = r12;
        b(this);
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void attachLayoutNodeManager(long r5) {
        this.f10809h.f10138a = r5;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final int createNode(int r10, String r11, PropBundle r12, ReadableMapBuffer r13, boolean r14) {
        ReadableArray r5 = null;
        if (r12 == null) goto L5;
        ReadableMap r15 = r12.getProps();
    L6:
        if (r12 == null) goto L8;
        r5 = r12.getEventHandlers();
    L8:
        ShadowNode r16 = this.f.a(r11).d();
        if (r16 == null) goto L12;
        int r17 = 4;
    L14:
        r16.f10335b = r10;
        r16.f10346j = r11;
        r16.h(this.d);
        r16.f10334a = this.f10809h;
        r16.i(on.a.a(r5));
        ((SparseArray) this.g.f10812a).put(r16.f10335b, r16);
        if (r15 == null) goto L26;
        com.lynx.tasm.behavior.utils.l.b(r16, new y0(r15, r13));     // Catch: Exception -> L19
        r16.p();     // Catch: Exception -> L19
    L19:
        e = move-exception;
        String r18 = r16.f10346j;
        if (r18 == null) goto L24;
        LynxLog.b(4, "lynx_ShadowNode", "Catch exception for tag: ".concat(r18));
        ((com.lynx.tasm.b0) r16.k()).o(e);
        goto L26
    L24:
        throw new AssertionError();
    L26:
        if (this.f10136b == true) goto L29;
        r16.c();
    L29:
        if (r16.m() == false) goto L31;
        r17 = r17 | 2;
    L31:
        if (r14 == true) goto L33;
    L36:
        return r17;
    L33:
        if (r16.r() == false) goto L36;
        return r17 | 32;
    L12:
        if (r14 == false) goto L37;
        r17 = 1;
        r16 = new NativeLayoutNodeRef();
        goto L14
    L37:
        return 1;
    L5:
        r15 = null;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void destroyNodes(int[] r10) {
        int r5 = r10.length;
        int r11 = 0;
    L3:
        if (r11 >= r5) goto L8;
        int r12 = r10[r11];
        x0 r13 = this.g;
        ShadowNode r14 = (ShadowNode) ((SparseArray) r13.f10812a).get(r12);
        ((SparseArray) r13.f10812a).remove(r12);
        if (r14 == null) goto L7;
        r14.f10351o = true;
        r14.q();
        r14.f10334a = null;
    L7:
        r11 = r11 + 1;
        goto L3
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void detachNativePtr() {
        super.detachNativePtr();
        x0 r5 = this.g;
        if (r5 == null) goto L12;
        SparseArray r10 = (SparseArray) r5.f10812a;
        if (r10 != null) goto L7;
        return;
    L7:
        if (r10.size() <= 0) goto L15;
        int r11 = 0;
    L10:
        if (r11 >= r10.size()) goto L16;
        ShadowNode r12 = (ShadowNode) r10.valueAt(r11);
        r12.f10351o = true;
        r12.q();
        r12.f10334a = null;
        r11 = r11 + 1;
        goto L10
    L16:
        return;
    L15:
        return;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void dispatchOnLayout(int r5, int r10, int r11, int r12, int r13) {
        ((ShadowNode) ((SparseArray) this.g.f10812a).get(r5)).e = false;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void dispatchOnLayoutBefore(int r5) {
        ((ShadowNode) ((SparseArray) this.g.f10812a).get(r5)).d();
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final Object getExtraBundle(int r5) {
        ShadowNode r10 = (ShadowNode) ((SparseArray) this.g.f10812a).get(r5);
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.l();
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void insertNode(int r5, int r10, int r11) {
        x0 r12 = this.g;
        ShadowNode r13 = (ShadowNode) ((SparseArray) r12.f10812a).get(r5);
        ShadowNode r14 = (ShadowNode) ((SparseArray) r12.f10812a).get(r10);
        if (r11 != (-1)) goto L10;
        r11 = r13.j();
    L10:
        r13.f(r11, r14);     // Catch: ArrayIndexOutOfBoundsException -> L7
    L8:
        r13.n();
        return;
    L7:
        StringBuilder r15 = ai.j0.v("Add child out of bounds, parentSignature: ", r5, r11, ", index: ", ", childSignature: ");
        r15.append(r10);
        LynxLog.b(3, "ShadowNodeOwner", r15.toString());
        goto L8
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void moveNode(int r5, int r10, int r11, int r12) {
        x0 r13 = this.g;
        ShadowNode r14 = (ShadowNode) ((SparseArray) r13.f10812a).get(r5);
        ShadowNode r15 = (ShadowNode) ((SparseArray) r13.f10812a).get(r10);
        ArrayList r16 = r14.f10347k;
        if (r16 == null) goto L7;
        ((ShadowNode) r16.remove(r11)).f10348l = null;
        r14.f(r12, r15);
        return;
    L7:
        throw new ArrayIndexOutOfBoundsException(ai.j0.h(r11, "Index ", " out of bounds: node has no children"));
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void removeNode(int r5, int r10, int r11) {
        ShadowNode r12 = (ShadowNode) ((SparseArray) this.g.f10812a).get(r5);
        if (r12 == null) goto L14;
        ArrayList r13 = r12.f10347k;     // Catch: ArrayIndexOutOfBoundsException -> L11
        if (r13 == null) goto L10;
        ((ShadowNode) r13.remove(r11)).f10348l = null;     // Catch: ArrayIndexOutOfBoundsException -> L11
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException("Index " + r11 + " out of bounds: node has no children");     // Catch: ArrayIndexOutOfBoundsException -> L11
    L11:
        StringBuilder r14 = ai.j0.v("Remove child out of bounds, parentSignature: ", r5, r11, ", index: ", ", childSignature: ");
        r14.append(r10);
        LynxLog.b(3, "ShadowNodeOwner", r14.toString());
        return;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void scheduleLayout() {
        if (this.f10136b == false) goto L5;
        return;
    L5:
        a6.a r5 = new a6.a(this, 29);
        this.e.h(r5);
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void setFontFaces(ReadableMap r10) {
        com.lynx.tasm.b0 r5 = this.d;
        ReadableMap r11 = r10.getMap("fontfaces");
        if (r11 != null) goto L6;
        r5.getClass();
        return;
    L6:
        HashMap r12 = r5.f;
        monitor-enter(r12);
        ReadableMapKeySetIterator r13 = r11.keySetIterator();     // Catch: Throwable -> L15
    L10:
        if (r13.hasNextKey() == false) goto L17;
        String r14 = r13.nextKey();     // Catch: Throwable -> L15
        ReadableMap r15 = r11.getMap(r14);     // Catch: Throwable -> L15
        if (r15 == null) goto L10;
        r5.f.put(r14, r15);     // Catch: Throwable -> L15
        goto L10
    L17:
        monitor-exit(r12);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.behavior.LayoutContext
    public final void updateProps(int r5, PropBundle r10, ReadableMapBuffer r11) {
        ReadableArray r12 = null;
        if (r10 == null) goto L5;
        ReadableMap r13 = r10.getProps();
    L6:
        if (r10 == null) goto L8;
        r12 = r10.getEventHandlers();
    L8:
        ShadowNode r14 = (ShadowNode) ((SparseArray) this.g.f10812a).get(r5);
        if (r14 == null) goto L24;
        if (r13 != null) goto L25;
    L20:
        if (r12 == null) goto L27;
        r14.i(on.a.a(r12));
        return;
    L27:
        return;
    L25:
        com.lynx.tasm.behavior.utils.l.b(r14, new y0(r13, r11));     // Catch: Exception -> L14
        r14.p();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        String r15 = r14.f10346j;
        if (r15 == null) goto L19;
        LynxLog.b(4, "lynx_ShadowNode", "Catch exception for tag: ".concat(r15));
        ((com.lynx.tasm.b0) r14.k()).o(e);
        goto L20
    L19:
        throw new AssertionError();
    L24:
        throw new RuntimeException(com.lynx.jsbridge.a.d(r5, "Trying to update non-existent view with tag "));
    L5:
        r13 = null;
        goto L6
    }
}
