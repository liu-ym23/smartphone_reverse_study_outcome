package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.behavior.ui.utils.g;
import com.lynx.tasm.fontface.f;
import com.lynx.tasm.utils.DeviceUtils;
import java.util.ArrayList;
import ym.k;
import zm.b;
import zm.g0;
import zm.h;
import zm.i;
import zm.l;
import zm.q;

/* JADX INFO: loaded from: classes2.dex */
public class InlineTextShadowNode extends BaseTextShadowNode {
    public int K;
    public g L;
    public boolean M;

    public InlineTextShadowNode() {
        this.K = 0;
        this.M = false;
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode, com.lynx.tasm.behavior.shadow.ShadowNode
    public final void h(b0 r5) {
        super.h(r5);
        this.L = new g(r5);
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public final boolean m() {
        return true;
    }

    @c0(defaultInt = 0, name = "background-color")
    public void setBackgroundColor(int r5) {
        if (this.K == r5) goto L6;
        this.K = r5;
        n();
        return;
    }

    @c0(name = "background-image")
    public void setBackgroundImage(@Nullable ReadableArray r5) {
        n();
        if (r5 != null) goto L6;
        this.M = false;
        return;
    L6:
        this.L.d().e.b(r5, null);
        this.M = true;
    }

    @c0(name = "background-position")
    public void setBackgroundPosition(@Nullable ReadableArray r5) {
        this.L.g(r5);
        n();
    }

    @c0(name = "background-repeat")
    public void setBackgroundRepeat(@Nullable ReadableArray r5) {
        this.L.h(r5);
        n();
    }

    @c0(name = "background-size")
    public void setBackgroundSize(@Nullable ReadableArray r5) {
        this.L.i(r5);
        n();
    }

    @d0(names = {"border-radius", "border-top-left-radius", "border-top-right-radius", "border-bottom-right-radius", "border-bottom-left-radius"})
    public void setBorderRadius(int r5, @Nullable ReadableArray r10) {
        this.L.l(r5, r10);
        n();
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void setTextAlign(int r5) {
        super.setTextAlign(r5);
        if (this.A == false) goto L6;
        LynxLog.b(4, "InlineTextShadowNode", "inline-text will no longer support text-align in future, set on root text instead");
        return;
    }

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    @c0(name = "vertical-align")
    public void setVerticalAlign(@Nullable ReadableArray r5) {
        g(r5);
    }

    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public final void t(int r11, int r12, ArrayList r13) {
        super.t(r11, r12, r13);
        if (o() == false) goto L6;
        r13.add(new b(r11, r12, new h(this.f10335b, this.f10352p, this.f10353q, this.f10356u, this.f10354r, this.s, this.f10355t)));
    L6:
        if (this.K == 0) goto L9;
        r13.add(new b(r11, r12, new BackgroundColorSpan(this.K)));
    L9:
        if (this.M == false) goto L11;
        r13.add(new b(r11, r12, new l(r11, r12, this.L)));
    L11:
        q r5 = this.f10357v;
        if (k.b(r5.f23523n) == true) goto L15;
        r13.add(new b(r11, r12, new AbsoluteSizeSpan(Math.round(r5.f23523n))));
    L15:
        if (TextUtils.isEmpty(r5.f23529u) == true) goto L22;
        String r10 = r5.f23529u;
        int r14 = r5.d();
        Typeface r15 = g0.c(k(), r10, r14);
        if (r15 != null) goto L19;
        f.f10866a.a(k(), r10, r14, new zm.c0(this));
        r15 = DeviceUtils.b();
    L20:
        r13.add(new b(r11, r12, new i(r15)));
        return;
    L19:
        r5.A = true;
        goto L20
    }
}
