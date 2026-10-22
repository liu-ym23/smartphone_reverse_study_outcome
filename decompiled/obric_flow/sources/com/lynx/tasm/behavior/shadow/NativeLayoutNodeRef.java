package com.lynx.tasm.behavior.shadow;

import androidx.annotation.Nullable;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.LayoutNodeManager;
import com.lynx.tasm.behavior.c0;
import ym.b;
import ym.g;
import ym.i;
import ym.j;
import ym.n;

/* JADX INFO: loaded from: classes2.dex */
public class NativeLayoutNodeRef extends ShadowNode {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10342v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10343w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f10344x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10345y;

    public NativeLayoutNodeRef() {
    }

    public final j a(g r10, i r11) {
        if (this.f10351o == false) goto L13;
        String r12 = this.f10346j;
        if (r12 == null) goto L12;
        String r13 = "measureNativeNode for null, tag: ".concat(r12);
        if (this.f10349m == null) goto L10;
        this.f10349m.b(new LynxError(60401, r13, "", "error"));
    L10:
        return new j(0.0f, 0.0f);
    L12:
        throw new AssertionError();
    L13:
        n r5 = this.f10350n;
        if (r5 != null) goto L16;
    L19:
        long r14 = this.f10334a.b(this.f10335b, r11.f23299a, r11.f23300b.f10341a, r11.f23301c, r11.d.f10341a, r10.f23298a);
        return new j(Float.intBitsToFloat((int) (r14 >> 32)), Float.intBitsToFloat((int) r14));
    L16:
        if (r5.f23307a != 1) goto L19;
        int[] r15 = this.f10334a.f(this.f10335b, r11.f23299a, r11.f23300b.f10341a, r11.f23301c, r11.d.f10341a, r10.f23298a);
        return new j(r15[0], r15[1], r15[2]);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void h(b0 r5) {
        this.f10349m = r5;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean o() {
        throw null;
    }

    public final void s(b r5) {
        if (this.f10351o == false) goto L12;
        String r10 = this.f10346j;
        if (r10 == null) goto L11;
        String r11 = "alignNativeNode for null, tag: ".concat(r10);
        if (this.f10349m == null) goto L14;
        LynxError r12 = new LynxError(60401, r11, "", "error");
        this.f10349m.b(r12);
        return;
    L14:
        return;
    L11:
        throw new AssertionError();
    L12:
        LayoutNodeManager r13 = this.f10334a;
        int r14 = this.f10335b;
        r13.c(r5.f23294b, r5.f23293a, r14);
    }

    @c0(name = "idSelector")
    public void setIdSelector(String r5) {
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    @c0(name = "vertical-align")
    public void setVerticalAlign(@Nullable ReadableArray r5) {
        g(r5);
    }
}
