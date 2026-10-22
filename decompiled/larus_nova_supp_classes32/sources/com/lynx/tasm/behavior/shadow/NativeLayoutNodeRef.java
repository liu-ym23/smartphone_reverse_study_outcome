package com.lynx.tasm.behavior.shadow;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.event.EventsListener;
import java.util.Map;
import y6a.b;
import y6a.g;
import y6a.j;
import y6a.k;
import y6a.n;
import z6a.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NativeLayoutNodeRef extends ShadowNode {
    public int v;
    public int w;
    public int x;
    public int y;
    public String z;

    public static class a extends h {
        public a(int r1, Map<String, EventsListener> r2, EventTarget.EnableStatus r3, boolean r4, EventTarget.EnableStatus r5, EventTarget.PointerEventsValue r6, ReadableMap r7) {
            super(r1, r2, r3, r4, r5, r6, r7);
        }
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean r() {
        throw null;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean z() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final h A() {
        return new a(this.b, this.p, this.q, this.u, this.r, this.s, this.t);
    }

    public NativeLayoutNodeRef() {
    }

    public final void C(b r4) {
        if (this.o == false) goto L6;
        v("alignNativeNode for null, tag: ".concat(n()));
        return;
    L6:
        this.a.a(this.b, r4.b, r4.a);
    }

    @LynxProp(name = "idSelector")
    public void setIdSelector(String r1) {
        this.z = r1;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    @LynxProp(name = "vertical-align")
    public void setVerticalAlign(ReadableArray r1) {
        y(r1);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void w(LynxContext r1) {
        this.m = r1;
    }

    public final k D(g r10, j r11) {
        if (this.o == false) goto L6;
        v("measureNativeNode for null, tag: ".concat(n()));
        return new k(0.0f, 0.0f);
    L6:
        n r0 = this.n;
        if (r0 != null) goto L9;
    L12:
        long r12 = this.a.g(this.b, r11.a, r11.b.intValue(), r11.c, r11.d.intValue(), r10.a);
        return new k(Float.intBitsToFloat((int) ((r12 >> 32) & (-1))), Float.intBitsToFloat((int) (r12 & (-1))));
    L9:
        if (r0.a != 1) goto L12;
        int[] r13 = this.a.h(this.b, r11.a, r11.b.intValue(), r11.c, r11.d.intValue(), r10.a);
        return new k(r13[0], r13[1], r13[2]);
    }

    public final k E(g r8, j r9) {
        if (this.o == false) goto L6;
        v("measureNativeNode for null, tag: ".concat(n()));
        return new k(0.0f, 0.0f);
    L6:
        int[] r10 = this.a.h(this.b, r9.a, r9.b.intValue(), r9.c, r9.d.intValue(), r8.a);
        return new k(r10[0], r10[1], r10[2]);
    }
}
