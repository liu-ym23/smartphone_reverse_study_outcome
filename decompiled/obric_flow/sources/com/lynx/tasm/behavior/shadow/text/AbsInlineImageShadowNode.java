package com.lynx.tasm.behavior.shadow.text;

import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.lynx.animax.i;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.text.a;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.g;
import com.lynx.tasm.behavior.ui.utils.l;
import java.util.HashMap;
import ym.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsInlineImageShadowNode extends BaseTextShadowNode {
    public boolean K;
    public boolean L;
    public int M;
    public g N;

    public AbsInlineImageShadowNode() {
        this.M = 0;
    }

    public final void B(int r5, int r10) {
        if (this.K == true) goto L5;
        return;
    L5:
        i r11 = new i(this.f10335b, "load");
        r11.a("height", Integer.valueOf(r10));
        r11.a("width", Integer.valueOf(r5));
        k().g.b(r11);
    }

    public void C(a r5) {
        n r10 = this.f10350n;
        if (r10 == null) goto L6;
        int r11 = r10.f23307a;
        float r12 = r10.f23308b;
        r5.f23456a = r11;
        r5.f23457b = r12;
        return;
    }

    public final void D(String r5) {
        if (this.L == true) goto L5;
        return;
    L5:
        i r10 = new i(this.f10335b, "error");
        r10.a("errMsg", r5);
        k().g.b(r10);
    }

    public abstract a E();

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final void i(HashMap r5) {
        this.f10352p = r5;
        if (r5 == null) goto L6;
        this.K = r5.containsKey("load");
        this.L = r5.containsKey("error");
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean m() {
        return true;
    }

    @c0(defaultInt = 0, name = "background-color")
    public void setBackgroundColor(int r5) {
        this.M = r5;
    }

    @d0(customType = "Color", names = {"border-left-color", "border-right-color", "border-top-color", "border-bottom-color"})
    public void setBorderColor(int r5, Integer r10) {
        if (this.N != null) goto L5;
        this.N = new g(k());
    L5:
        g r11 = this.N;
        int r12 = LynxBaseUI.SPACING_TYPES[r5 + 1];
        r11.getClass();
        float r13 = 1.0E21f;
        if (r10 != null) goto L8;
        float r14 = 1.0E21f;
    L9:
        if (r10 == null) goto L12;
        r13 = r10.intValue() >>> 24;
    L12:
        BackgroundDrawable r15 = (BackgroundDrawable) r11.d();
        if (r15.f10709i != null) goto L15;
        r15.f10709i = new l(0.0f);
    L15:
        r15.f10709i.b(r14, r12);
        if (r15.f10710j != null) goto L18;
        r15.f10710j = new l(255.0f);
    L18:
        r15.f10710j.b(r13, r12);
        return;
    L8:
        r14 = r10.intValue() & ViewCompat.MEASURED_SIZE_MASK;
        goto L9
    }

    @d0(names = {"border-radius", "border-top-left-radius", "border-top-right-radius", "border-bottom-right-radius", "border-bottom-left-radius"})
    public void setBorderRadius(int r5, @Nullable ReadableArray r10) {
        if (this.N != null) goto L5;
        this.N = new g(k());
    L5:
        this.N.l(r5, r10);
    }

    @d0(defaultInt = -1, names = {"border-style", "border-left-style", "border-right-style", "border-top-style", "border-bottom-style"})
    public void setBorderStyle(int r5, int r10) {
        if (this.N != null) goto L5;
        this.N = new g(k());
    L5:
        this.N.j(LynxBaseUI.SPACING_TYPES[r5], r10);
    }

    @d0(names = {"border-width", "border-left-width", "border-right-width", "border-top-width", "border-bottom-width"})
    public void setBorderWidth(int r5, int r10) {
        if (this.N != null) goto L5;
        this.N = new g(k());
    L5:
        this.N.d().b(LynxBaseUI.SPACING_TYPES[r5], r10);
    }

    @c0(name = "mode")
    public abstract void setMode(String r5);

    @c0(name = "src")
    public abstract void setSource(@Nullable String r5);

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    @c0(name = "vertical-align")
    public void setVerticalAlign(@Nullable ReadableArray r5) {
        g(r5);
    }
}
