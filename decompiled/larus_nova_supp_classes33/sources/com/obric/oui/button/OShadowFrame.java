package com.obric.oui.button;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.graphics.ColorUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.common.oea.foundation.animation.token.Token$Bounce;
import com.obric.common.oea.foundation.animation.token.Token$Duration;
import com.obric.oui.color.h0;
import com.obric.oui.common.style.l;
import com.obric.oui.common.style.q;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.material.c;
import com.obric.oui.material.g;
import com.obric.oui.material.p;
import fja.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import vma.i;
import wma.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u001a\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\\J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0004J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH\u0004J\u0012\u0010\u0012\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0014R\"\u0010\u001b\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001f\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\"\u0010&\u001a\u00020\u00018\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u00018\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b'\u0010!\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\"\u0010.\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\"\u00105\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010=\u001a\u0004\u0018\u0001068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010A\u001a\u0004\u0018\u0001068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R*\u0010J\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010B8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010N\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bK\u00100\u001a\u0004\bL\u00102\"\u0004\bM\u00104R*\u0010R\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010B8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bO\u0010E\u001a\u0004\bP\u0010G\"\u0004\bQ\u0010IR\"\u0010V\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bS\u0010\u0016\u001a\u0004\bT\u0010\u0018\"\u0004\bU\u0010\u001aR\"\u0010X\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bW\u00100\u001a\u0004\bX\u00102\"\u0004\bY\u00104R\"\u0010Z\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bZ\u00100\u001a\u0004\bZ\u00102\"\u0004\b[\u00104¨\u0006]"}, d2 = {"Lcom/obric/oui/button/OShadowFrame;", "Lcom/obric/oui/layout/OUIFrameLayout;", "Lcom/obric/oui/material/g;", "", "", "enabled", "", "setEnabled", "Landroid/view/View;", "view", "setBackdropTarget", "", "radius", "setContentSelfBlur", "progress", "setContentShadowAlphaProgress", "", "color", "setBgColor", "setPressColor", "getCurrentPressScaleForAnimation", "k", "I", "getBgColorNormal", "()I", "setBgColorNormal", "(I)V", "bgColorNormal", "l", "getBgColorDisabled", "setBgColorDisabled", "bgColorDisabled", "p", "Lcom/obric/oui/layout/OUIFrameLayout;", "getContentView", "()Lcom/obric/oui/layout/OUIFrameLayout;", "setContentView", "(Lcom/obric/oui/layout/OUIFrameLayout;)V", "contentView", "q", "getContentContainer", "setContentContainer", "contentContainer", "u", "getCurrentTheme", "setCurrentTheme", "currentTheme", "v", "Z", "getEnableMaterial", "()Z", "setEnableMaterial", "(Z)V", "enableMaterial", "", "w", "Ljava/lang/String;", "getMaterialTokenString", "()Ljava/lang/String;", "setMaterialTokenString", "(Ljava/lang/String;)V", "materialTokenString", "x", "getMaterialDisabledTokenString", "setMaterialDisabledTokenString", "materialDisabledTokenString", "", "Lcom/obric/oui/material/c;", "y", "[Lcom/obric/oui/material/c;", "getMaterials", "()[Lcom/obric/oui/material/c;", "setMaterials", "([Lcom/obric/oui/material/c;)V", "materials", "z", "getMaterialApplied", "setMaterialApplied", "materialApplied", "A", "getMaterialsDisabled", "setMaterialsDisabled", "materialsDisabled", "B", "getMaterialSrcType", "setMaterialSrcType", "materialSrcType", "C", "isMaterialFromDrawable", "setMaterialFromDrawable", "isBackdropView", "setBackdropView", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public abstract class OShadowFrame extends OUIFrameLayout implements g {
    public c[] A;
    public int B;
    public boolean C;
    public d h;
    public d i;
    public int j;
    public int k;
    public int l;
    public final float m;
    public float n;
    public final float o;
    public OUIFrameLayout p;
    public OUIFrameLayout q;
    public List<q> r;
    public List<q> s;
    public float t;
    public int u;
    public boolean v;
    public String w;
    public String x;
    public c[] y;
    public boolean z;

    public static final class a {
    }

    static {
    }

    public OShadowFrame(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 14, 0);
    }

    public OShadowFrame(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 12, 0);
    }

    public OShadowFrame(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, r10, 8, 0);
    }

    public abstract void k(Context r1, OUIFrameLayout r2, TypedArray r3);

    public boolean r() {
        return true;
    }

    public final void setBackdropView(boolean r1) {
    }

    public final void f() {
        d r0 = this.h;
        if (r0 == null) goto L6;
        int r2 = d.d;
        r0.a(false);
    L6:
        d r1 = this.i;
        if (r1 == null) goto L10;
        int r3 = d.d;
        r1.a(false);
    L10:
        this.h = null;
        this.i = null;
    }

    public final OUIFrameLayout getContentContainer() {
        OUIFrameLayout r0 = this.q;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        return null;
    }

    public final OUIFrameLayout getContentView() {
        OUIFrameLayout r0 = this.p;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("contentView");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean m() {
        int r0 = this.k;
        if (r0 != 0) goto L7;
        return i.a(this);
    L7:
        if (this.u != 2) goto L9;
    L12:
        return true;
    L9:
        if (h0.b(r0) == true) goto L12;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getCurrentPressScaleForAnimation() {
        return getScaleX();
    }

    public final List<q> i() {
        List r0 = getCurrentShadows();
        if (r0 != null) goto L5;
        return null;
    L5:
        List r1 = r0;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L7:
        if (r3.hasNext() == false) goto L10;
        r2.add(((q) r3.next()).a());
        goto L7
    L10:
        return r2;
    }

    public final void o() {
        f();
        e(this.m);
        List<q> r0 = this.r;
        q r1 = null;
        if (r0 != null) goto L5;
        q r2 = null;
    L6:
        List<q> r3 = this.r;
        if (r3 == null) goto L10;
        r1 = (q) CollectionsKt.getOrNull(r3, 1);
    L10:
        c(r2, r1, false);
        return;
    L5:
        r2 = (q) CollectionsKt.getOrNull(r0, 0);
        goto L6
    }

    public final int getBgColorDisabled() {
        return this.l;
    }

    public final int getBgColorNormal() {
        return this.k;
    }

    public final int getCurrentTheme() {
        return this.u;
    }

    public final boolean getEnableMaterial() {
        return this.v;
    }

    public final boolean getMaterialApplied() {
        return this.z;
    }

    public final String getMaterialDisabledTokenString() {
        return this.x;
    }

    public final int getMaterialSrcType() {
        return this.B;
    }

    public final String getMaterialTokenString() {
        return this.w;
    }

    public final c[] getMaterials() {
        return this.y;
    }

    public final c[] getMaterialsDisabled() {
        return this.A;
    }

    public final void a(int r2) {
        this.B = r2;
        p.g(getContentView(), r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d(int r2) {
        if (this.u == r2) goto L14;
        this.u = r2;
        String r3 = this.w;
        if (r3 == null) goto L8;
        setMaterials(MaterialToken.parseSet(r3, !m()));
    L8:
        String r4 = this.x;
        if (r4 == null) goto L12;
        setMaterialsDisabled(MaterialToken.parseSet(r4, !m()));
    L12:
        t(isEnabled());
        return;
    }

    public boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        boolean r0 = super.dispatchTouchEvent(r3);
        int r4 = r3.getAction();
        if (r4 == 0) goto L9;
        if (r4 != 1) goto L6;
    L8:
        j(false);
    L10:
        return r0;
    L6:
        if (r4 == 3) goto L8;
    L9:
        j(true);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(float r1) {
        setScaleX(r1);
        setScaleY(r1);
    }

    public final void g(boolean r4) {
        ColorUtils.setAlphaComponent(this.k, 48);
        if (h0.a(this.k) == false) goto L9;
        int r0 = com.obric.oui.material.d.a;
        Function1 r1 = MaterialToken.OUI_Bg_Floating_Tinted;
        boolean r5 = !r4;
        c[] r2 = com.obric.oui.material.d.a((c[]) r1.invoke(Boolean.valueOf(r5)), this.k);
        if (this.l == 0) goto L7;
        c[] r6 = com.obric.oui.material.d.a((c[]) r1.invoke(Boolean.valueOf(r5)), this.l);
    L8:
        q(r2, r6);
        return;
    L7:
        r6 = null;
        goto L8
    L9:
        String r3 = this.w;
        if (r3 == null) goto L15;
        boolean r7 = !r4;
        c[] r8 = MaterialToken.parseSet(r3, r7);
        this.y = r8;
        String r9 = this.x;
        if (r9 == null) goto L14;
        this.A = MaterialToken.parseSet(r9, r7);
        return;
    L14:
        this.A = r8;
        return;
    L15:
        Function1 r10 = MaterialToken.OUI_Bg_Floating;
        boolean r11 = !r4;
        q((c[]) r10.invoke(Boolean.valueOf(r11)), (c[]) r10.invoke(Boolean.valueOf(r11)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(boolean r4) {
        if (isEnabled() == true) goto L7;
        b.a("OShadowFrame", "doPressAnim, skip, isEnabled=false");
        return;
    L7:
        if (r() == true) goto L10;
        f();
        return;
    L10:
        b.a("OShadowFrame", Intrinsics.stringPlus("doPressAnim: ", Boolean.valueOf(r4)));
        f();
        float r0 = getCurrentPressScaleForAnimation();
        List<q> r1 = i();
        if (r4 == false) goto L13;
        this.h = s(r0, this.n, r1, this.s);
        return;
    L13:
        this.i = s(r0, this.m, r1, this.r);
    }

    public final List<q> n(float r4) {
        List<q> r0 = this.r;
        if (r0 != null) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = ((ArrayList) r0).iterator();
    L7:
        if (r2.hasNext() == false) goto L10;
        r1.add(h((q) r2.next(), r4));
        goto L7
    L10:
        return r1;
    }

    public void setBackdropTarget(View r3) {
        OUIFrameLayout r0 = getContentView();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        OMaterialHelper.t(r0, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBgColor(int r2) {
        if (this.k == r2) goto L14;
        this.k = r2;
        this.l = r2;
        boolean r3 = h0.b(r2);
        g(r3);
        if (r3 == false) goto L7;
        int r4 = 2;
    L9:
        if (r4 == this.u) goto L12;
        d(r4);
        return;
    L12:
        t(isEnabled());
        return;
    L7:
        r4 = 1;
        goto L9
    }

    public final void setBgColorDisabled(int r1) {
        this.l = r1;
    }

    public final void setBgColorNormal(int r1) {
        this.k = r1;
    }

    public final void setContentContainer(OUIFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.q = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setContentSelfBlur(float r13) {
        OMaterialHelper.r(getContentContainer(), getContentContainer());
        OUIFrameLayout r2 = getContentContainer();
        Context r0 = getContext();
        float[] r1 = com.obric.oui.material.q.a;
        Float r3 = null;
        if (r0 != null) goto L5;
        Resources r4 = null;
    L6:
        if (r4 == null) goto L10;
        DisplayMetrics r5 = WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics());
        if (r5 == null) goto L10;
        Float r6 = Float.valueOf(r5.density);
    L12:
        if (r6 == null) goto L50;
        float r7 = r6.floatValue();
        boolean r8 = false;
        if (Float.isInfinite(r13) == false) goto L17;
    L19:
        boolean r9 = false;
    L20:
        if (r9 == false) goto L50;
        if (r13 < 0.0f) goto L50;
        if (Float.isInfinite(r7) == false) goto L27;
    L29:
        boolean r10 = false;
    L30:
        if (r10 == false) goto L50;
        if (r7 <= 0.0f) goto L50;
        float r11 = r7 * r13;
        if (Float.isInfinite(r11) == false) goto L37;
    L39:
        if (r8 == false) goto L50;
        float[] r12 = com.obric.oui.material.q.a;
        if (r11 < ArraysKt.first(r12)) goto L50;
        if (r11 > ArraysKt.last(r12)) goto L50;
        int r14 = ArraysKt.binarySearch$default(r12, r11, 0, 0, 6, null);
        float[] r15 = com.obric.oui.material.q.b;
        if (r14 < 0) goto L49;
        r3 = Float.valueOf(r15[r14]);
        goto L50
    L49:
        int r16 = (-r14) - 1;
        int r17 = r16 - 1;
        float r18 = r12[r17];
        float r19 = r12[r16];
        float r20 = r15[r17];
        r3 = Float.valueOf(r20 + (((r11 - r18) / (r19 - r18)) * (r15[r16] - r20)));
        goto L50
    L37:
        if (Float.isNaN(r11) == true) goto L39;
        r8 = true;
        goto L39
    L27:
        if (Float.isNaN(r7) == true) goto L29;
        r10 = true;
        goto L30
    L17:
        if (Float.isNaN(r13) == true) goto L19;
        r9 = true;
    L50:
        if (r3 == null) goto L53;
        r13 = r3.floatValue();
    L53:
        OMaterialHelper.o(r2, r13, 1.0f, 0, 0, 1.0f);
        return;
    L10:
        r6 = null;
        goto L12
    L5:
        r4 = r0.getResources();
        goto L6
    }

    public final void setContentShadowAlphaProgress(float r4) {
        float r5 = RangesKt.coerceIn(r4, 0.0f, 1.0f);
        if (this.t != r5) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.t = r5;
        List<q> r1 = this.r;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r5 < 1.0f) goto L14;
        C1(r1);
        return;
    L14:
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = ((ArrayList) r1).iterator();
    L16:
        if (r3.hasNext() == false) goto L18;
        r2.add(h((q) r3.next(), r5));
        goto L16
    L18:
        C1(r2);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setContentView(OUIFrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p = r2;
    }

    public final void setCurrentTheme(int r1) {
        this.u = r1;
    }

    public final void setEnableMaterial(boolean r1) {
        this.v = r1;
    }

    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        getContentView().setEnabled(r2);
        getContentContainer().setEnabled(r2);
        t(r2);
    }

    public final void setMaterialApplied(boolean r1) {
        this.z = r1;
    }

    public final void setMaterialDisabledTokenString(String r1) {
        this.x = r1;
    }

    public final void setMaterialFromDrawable(boolean r1) {
        this.C = r1;
    }

    public final void setMaterialSrcType(int r1) {
        this.B = r1;
    }

    public final void setMaterialTokenString(String r1) {
        this.w = r1;
    }

    public final void setMaterials(c[] r1) {
        this.y = r1;
    }

    public final void setMaterialsDisabled(c[] r1) {
        this.A = r1;
    }

    public void setPressColor(int r2) {
        this.j = r2;
        getContentView().setOverridePressColor(this.j);
        getContentView().m1("OShadowFrame");
    }

    public void t(boolean r5) {
        if (this.z == true) goto L9;
        getContentView().setBorderWidth(0);
        getContentView().setBorderColor(0);
        if (r5 == false) goto L7;
        getContentView().setBackgroundColor(this.k);
        return;
    L7:
        getContentView().setBackgroundColor(this.l);
        return;
    L9:
        if (this.C == false) goto L11;
        return;
    L11:
        getContentView().setBackgroundColor(0);
        if (r5 == false) goto L17;
        c[] r6 = this.y;
        if (r6 == null) goto L25;
        p.d(getContentView(), r6, false, getMaterialSrcType(), 10);
        return;
    L25:
        return;
    L17:
        c[] r7 = this.A;
        if (r7 == null) goto L26;
        p.d(getContentView(), r7, false, getMaterialSrcType(), 10);
        return;
    }

    public static q h(q r3, float r4) {
        q r0 = r3.a();
        r0.a = ColorUtils.setAlphaComponent(r3.a, RangesKt.coerceIn(MathKt.roundToInt(Color.alpha(r3.a) * r4), 0, 255));
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(Context r3, TypedArray r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "typedArray");
        this.B = r4.getInt(7, 2);
        String r5 = r4.getString(4);
        boolean r0 = h0.a(this.k);
        if (r5 != null) goto L6;
        if (r0 == true) goto L6;
        r5 = getResources().getString(2131912817);
    L6:
        this.w = r5;
        boolean r1 = m();
        if (r0 == false) goto L12;
        int r6 = com.obric.oui.material.d.a;
        Function1 r7 = MaterialToken.OUI_Bg_Floating_Tinted;
        boolean r8 = !r1;
        this.y = com.obric.oui.material.d.a((c[]) r7.invoke(Boolean.valueOf(r8)), this.k);
        if (this.l == 0) goto L17;
        this.A = com.obric.oui.material.d.a((c[]) r7.invoke(Boolean.valueOf(r8)), this.l);
    L17:
        if (this.y != null) goto L20;
        this.v = false;
        this.z = false;
        return;
    L20:
        return;
    L12:
        if (this.w == null) goto L17;
        boolean r2 = !r1;
        this.y = MaterialToken.parseSet(r5, r2);
        String r9 = r4.getString(6);
        this.x = r9;
        if (r9 == null) goto L17;
        this.A = MaterialToken.parseSet(r9, r2);
        goto L17
    }

    public final void q(c[] r1, c[] r2) {
        this.y = r1;
        this.A = r2;
        this.w = null;
        this.x = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OShadowFrame(Context r9, AttributeSet r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, 8);
        this.m = 1.0f;
        this.n = 1.0f;
        this.o = 0.01f;
        this.t = 1.0f;
        this.B = 2;
        if (p.b(this) == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.v = r1;
        this.z = r1;
        TypedArray r13 = r9.obtainStyledAttributes(r10, new int[]{2130973365, 2130973366, 2130973374, 2130973381, 2130973383, 2130973385, 2130973386, 2130973389, 2130973391, 2130973392, 2130973394, 2130973395, 2130973396, 2130973397, 2130973398, 2130973400, 2130973401, 2130973403, 2130973404, 2130973406, 2130973407});
        if (this.v == false) goto L11;
        boolean r0 = r13.getBoolean(2, true);
        this.v = r0;
        this.z = r0;
    L11:
        com.obric.oui.common.style.a r2 = null;
        setContentView(new OUIFrameLayout(r9, null, 0, 14));
        setContentContainer(new OUIFrameLayout(r9, null, 0, 14));
        getContentView().setDuplicateParentStateEnabled(true);
        getContentContainer().setDuplicateParentStateEnabled(true);
        this.k = r13.getColor(0, getResources().getColor(2131104798, null));
        this.l = r13.getColor(1, getResources().getColor(2131104798, null));
        if (this.k == 0) goto L14;
        getContentView().setBackgroundColor(this.k);
    L14:
        this.n = r13.getFloat(13, 1.0f);
        setChangeAlphaWhenPress(false);
        int r14 = r13.getDimensionPixelSize(9, 0);
        int r3 = r13.getDimensionPixelSize(10, 0);
        int r5 = r13.getDimensionPixelSize(11, 0);
        int r15 = r13.getDimensionPixelSize(8, 0);
        int r4 = r13.getDimensionPixelSize(14, 0);
        Drawable r6 = r13.getDrawable(5);
        getContentView().setRadius(r4);
        getContentContainer().setPadding(r14, r5, r3, r15);
        getContentContainer().setRadius(r4);
        this.j = r13.getColor(12, 0);
        getContentView().setOverridePressColor(this.j);
        getContentView().m1("OShadowFrame");
        getContentView().addView(getContentContainer(), new FrameLayout.LayoutParams(-1, -1));
        addView(getContentView(), new FrameLayout.LayoutParams(-1, -1));
        setShadowCornerRadius(r4);
        k(r9, getContentContainer(), r13);
        if (r6 == null) goto L17;
        boolean r16 = true;
    L18:
        this.C = r16;
        if (r16 == false) goto L21;
        getContentView().setBackground(r6);
        getContentView().setChangeAlphaWhenPress(false);
        getContentView().setChangeAlphaWhenDisable(false);
    L21:
        int r17 = vma.c.a;
        com.obric.oui.common.style.a r18 = getContentView();
        if (r18 != null) goto L24;
        r18 = null;
    L24:
        if (r18 == null) goto L27;
        r18.setChangeAlphaWhenDisable(false);
    L27:
        com.obric.oui.common.style.a r19 = getContentView();
        if (r19 != null) goto L30;
        r19 = null;
    L30:
        if (r19 == null) goto L33;
        r19.setChangeAlphaWhenEnabledChanged(false);
    L33:
        com.obric.oui.common.style.a r110 = getContentContainer();
        if (r110 == null) goto L37;
        r2 = r110;
    L37:
        if (r2 == null) goto L40;
        r2.setChangeAlphaWhenDisable(false);
    L40:
        setChangeAlphaWhenDisable(false);
        List<q> r111 = l.b(r9, r13, 15);
        if (r111 == null) goto L43;
        this.r = r111;
        Intrinsics.checkNotNull(r111);
        q r112 = (q) CollectionsKt.getOrNull(r111, 0);
        List<q> r113 = this.r;
        Intrinsics.checkNotNull(r113);
        c(r112, (q) CollectionsKt.getOrNull(r113, 1), false);
    L43:
        List<q> r20 = l.b(r9, r13, 16);
        if (r20 == null) goto L46;
        this.s = r20;
    L46:
        r13.recycle();
        setClipChildren(false);
        setClickable(true);
        t(isEnabled());
        return;
    L17:
        r16 = false;
        goto L18
    L5:
        if (OMaterialHelper.l() == false) goto L7;
        r1 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void p(int r2, int r3, String r4, String r5) {
        this.k = r2;
        this.l = r3;
        int r6 = 1;
        if (r4 == null) goto L16;
        if ((!Intrinsics.areEqual(this.w, r4)) == false) goto L8;
        this.w = r4;
        this.y = MaterialToken.parseSet(r4, !m());
    L8:
        String r7 = this.x;
        if (r7 != null) goto L11;
        boolean r8 = true;
    L13:
        if ((!r8) == false) goto L16;
        this.x = r5;
        this.A = MaterialToken.parseSet(r5, !m());
        goto L16
    L11:
        r8 = StringsKt.contentEquals(r7, r5);
    L16:
        if (h0.b(r2) == false) goto L19;
        r6 = 2;
    L19:
        if (r6 == this.u) goto L22;
        d(r6);
        return;
    L22:
        t(isEnabled());
    }

    public final d s(final float r10, final float r11, final List<q> r12, final List<q> r13) {
        com.obric.common.oea.foundation.animation.builder.d.a r0 = new com.obric.common.oea.foundation.animation.builder.d.a();
        com.obric.common.oea.foundation.animation.spec.spring.b r1 = gja.b.c(Token$Bounce.OUI_ANIMATION_BOUNCE_SNAPPY_4, Token$Duration.OUI_ANIMATION_DURATION_MEDIUM_3);
        r1.b = this.o;
        Unit r2 = Unit.INSTANCE;
        r0.b(r10, r11, r1, null);
        Function3<String, Object, Object, Unit> r3 = new OShadowFrame$startPressScaleAnimation$2(this, r10, r11, r12, r13);
        Intrinsics.checkNotNullParameter(r3, "callback");
        r0.d = r3;
        Function2<Boolean, Throwable, Unit> r14 = new OShadowFrame$startPressScaleAnimation$3(this, r13);
        Intrinsics.checkNotNullParameter(r14, "callback");
        r0.e = r14;
        return r0.a().a();
    }

    public /* synthetic */ OShadowFrame(Context r1, AttributeSet r2, int r3, int r4, int r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3, 0);
    }
}
