package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.xelement.input.n;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import w8.f;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0002ghB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000e\u001a\u00020\r2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u000e\u001a\u00020\r2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010¢\u0006\u0004\b\u000e\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010'\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u00168\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR$\u0010.\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010\u0015R.\u00106\u001a\u0004\u0018\u00010\u00062\b\u0010/\u001a\u0004\u0018\u00010\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R*\u0010:\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u001f\u001a\u0004\b8\u0010!\"\u0004\b9\u0010#R*\u0010>\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u001f\u001a\u0004\b<\u0010!\"\u0004\b=\u0010#R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010I\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bG\u0010!\"\u0004\bH\u0010#R$\u0010L\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bJ\u0010!\"\u0004\bK\u0010#R$\u0010O\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bM\u0010!\"\u0004\bN\u0010#R$\u0010R\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bP\u0010!\"\u0004\bQ\u0010#R$\u0010X\u001a\u00020S2\u0006\u0010/\u001a\u00020S8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010[\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bY\u0010!\"\u0004\bZ\u0010#R$\u0010^\u001a\u00020S2\u0006\u0010/\u001a\u00020S8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\\\u0010U\"\u0004\b]\u0010WR\u0011\u0010`\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b_\u0010!R$\u0010d\u001a\u00020\u00062\u0006\u0010a\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bb\u0010!\"\u0004\bc\u0010#R\u0013\u0010f\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\be\u0010,¨\u0006i"}, d2 = {"Lcom/obric/oui/picker/reels/views/WheelView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "", "entries", "", "setEntries", "([Ljava/lang/String;)V", "", "(Ljava/util/List;)V", "", "tag", "setTagText", "(Ljava/lang/CharSequence;)V", "", "u", "Z", "getShowDivider", "()Z", "setShowDivider", "(Z)V", "showDivider", "v", "I", "getHighlightConorRadiusPx", "()I", "setHighlightConorRadiusPx", "(I)V", "highlightConorRadiusPx", "cyclic", "w", "isCyclic", "setCyclic", "x", "Ljava/lang/CharSequence;", "getWheelTagText", "()Ljava/lang/CharSequence;", "setWheelTagText", "wheelTagText", "value", "y", "Ljava/lang/Integer;", "getTagGap", "()Ljava/lang/Integer;", "setTagGap", "(Ljava/lang/Integer;)V", "tagGap", "z", "getSelectedTextColor", "setSelectedTextColor", "selectedTextColor", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getNormalTextColor", "setNormalTextColor", "normalTextColor", "Lcom/obric/oui/picker/reels/views/a;", "B", "Lcom/obric/oui/picker/reels/views/a;", "getOnWheelChangedListener", "()Lcom/obric/oui/picker/reels/views/a;", "setOnWheelChangedListener", "(Lcom/obric/oui/picker/reels/views/a;)V", "onWheelChangedListener", "getStartIndex", "setStartIndex", "startIndex", "getItemCount", "setItemCount", "itemCount", "getItemHeightPx", "setItemHeightPx", "itemHeightPx", "getSelectedItemHeightPx", "setSelectedItemHeightPx", "selectedItemHeightPx", "", "getTextSizePx", "()F", "setTextSizePx", "(F)V", "textSizePx", "getTextColor", "setTextColor", "textColor", "getSelectedTextSizePxProp", "setSelectedTextSizePxProp", "selectedTextSizePxProp", "getItemSize", "itemSize", "index", "getCurrentIndex", "setCurrentIndex", "currentIndex", "getCurrentItem", "currentItem", "com/obric/oui/picker/reels/views/d", "com/obric/oui/picker/reels/views/e", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WheelView extends FrameLayout {
    public static final /* synthetic */ int C = 0;
    public int A;
    public a B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f14042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f14043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f14044c;
    public final d d;
    public int e;
    public float f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f14045h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f14046i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f14047j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14048k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14049l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14050m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f14051n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14052o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14053p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14054q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14055r;
    public boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f14056t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f14057u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f14058v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14059w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public CharSequence f14060x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Integer f14061y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f14062z;

    @JvmOverloads
    public WheelView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static /* synthetic */ void a(WheelView r5) {
        m112setItems$lambda6(r5);
    }

    /* JADX INFO: renamed from: setItems$lambda-6, reason: not valid java name */
    private static final void m112setItems$lambda6(WheelView r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.requestLayout();
        RecyclerView r10 = r5.f14042a;
        if (r10.getHeight() <= 0) goto L7;
        r10.setPadding(r10.getPaddingLeft(), 0, r10.getPaddingRight(), 0);
    L7:
        if (r5.f14054q == (-1)) goto L9;
        r5.c();
        return;
    L9:
        r5.h();
    }

    public final int b(int r5) {
        int r10 = this.d.f14078b.size();
        if (r10 != 0) goto L7;
        return -1;
    L7:
        if (this.f14059w == false) goto L12;
        int r11 = r5 % r10;
        if (r11 < 0) goto L14;
        return r11;
    L14:
        return r11 + r10;
    L12:
        return r5 - f();
    }

    public final void c() {
        int r5 = this.f14054q;
        if (r5 != (-1)) goto L6;
        return;
    L6:
        if (this.d.f14078b.size() != 0) goto L9;
        return;
    L9:
        if (this.f14042a.getChildCount() != 0) goto L11;
        return;
    L11:
        this.f14054q = -1;
        d(r5, false);
    }

    public final void d(int r10, boolean r11) {
        RecyclerView r5 = this.f14042a;
        r5.Z();
        if (r11 == false) goto L18;
        this.f14052o = true;
        this.f14055r = r10;
        b r12 = this.f14044c;
        int r13 = 0;
        if (r12.f14070u != 0) goto L7;
    L14:
        int r14 = r13;
        if (r14 == 0) goto L20;
        if (r14 == 0) goto L21;
        this.f14052o = true;
        com.obric.oui.popover.d r15 = new com.obric.oui.popover.d();
        r15.f14128a = 0.61f;
        this.f14042a.W(0, r14, r15, 400, false);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        if (r12.w() == 0) goto L14;
        if (r12.f14073x == false) goto L12;
        int r16 = RangesKt.coerceIn(r10, 0, r12.w() - 1);
    L13:
        r13 = MathKt.roundToInt((r16 * r12.f14070u) - r12.f14071v);
        goto L14
    L12:
        int r17 = r12.f14074y;
        r16 = RangesKt.coerceIn(r10, r17, RangesKt.coerceAtLeast((r12.w() - r12.f14074y) - 1, r17));
        goto L13
    L18:
        this.f14052o = true;
        r5.V(r10);
        post(new androidx.core.content.res.a(r10, 5, this));
    }

    public final int e() {
        b r5 = this.f14044c;
        int r10 = 0;
        if (r5.f14070u != 0) goto L5;
    L11:
        int r11 = -1;
    L12:
        if (r11 == (-1)) goto L14;
        return r11;
    L14:
        RecyclerView r12 = this.f14042a;
        int r13 = ((r12.getHeight() + r12.getPaddingTop()) - r12.getPaddingBottom()) / 2;
        int r14 = r12.getChildCount();
        View r15 = null;
        float r16 = Float.MAX_VALUE;
    L15:
        if (r10 >= r14) goto L23;
        r10 = r10 + 1;
        View r17 = r12.getChildAt(r10);
        if (r17 == null) goto L15;
        float r18 = Math.abs(((r17.getBottom() + r17.getTop()) / 2.0f) - r13);
        if (r18 >= r16) goto L15;
        r15 = r17;
        r16 = r18;
        goto L15
    L23:
        if (r15 != null) goto L26;
        return -1;
    L26:
        return r12.D(r15);
    L5:
        if (r5.w() == 0) goto L11;
        int r19 = MathKt.roundToInt(r5.f14071v / r5.f14070u);
        if (r5.f14073x == false) goto L10;
        r11 = RangesKt.coerceIn(r19, 0, r5.w() - 1);
        goto L12
    L10:
        int r20 = r5.f14074y;
        r11 = RangesKt.coerceIn(r19, r20, RangesKt.coerceAtLeast((r5.w() - r5.f14074y) - 1, r20));
        goto L12
    }

    public final int f() {
        return RangesKt.coerceAtLeast((this.g + 2) / 2, 1);
    }

    public final boolean g(int r5) {
        if (r5 >= 0) goto L5;
        return false;
    L5:
        if (r5 >= this.d.f14078b.size()) goto L9;
        return true;
    L9:
        return false;
    }

    public final int getCurrentIndex() {
        int r5 = e();
        if (r5 != (-1)) goto L5;
        return 0;
    L5:
        int r10 = b(r5);
        if (g(r10) == true) goto L8;
        return 0;
    L8:
        return r10;
    }

    public final CharSequence getCurrentItem() {
        int r5 = getCurrentIndex();
        return (CharSequence) CollectionsKt.getOrNull(this.d.f14078b, r5);
    }

    public final int getHighlightConorRadiusPx() {
        return this.f14058v;
    }

    public final int getItemCount() {
        return this.g;
    }

    public final int getItemHeightPx() {
        return this.e;
    }

    public final int getItemSize() {
        return this.d.f14078b.size();
    }

    public final int getNormalTextColor() {
        return this.A;
    }

    public final a getOnWheelChangedListener() {
        return this.B;
    }

    public final int getSelectedItemHeightPx() {
        return this.e;
    }

    public final int getSelectedTextColor() {
        return this.f14062z;
    }

    public final float getSelectedTextSizePxProp() {
        return this.f14047j;
    }

    public final boolean getShowDivider() {
        return this.f14057u;
    }

    public final int getStartIndex() {
        return this.f14053p;
    }

    public final Integer getTagGap() {
        return this.f14061y;
    }

    public final int getTextColor() {
        return this.A;
    }

    public final float getTextSizePx() {
        return this.f14046i;
    }

    public final CharSequence getWheelTagText() {
        return this.f14060x;
    }

    public final void h() {
        int r5 = this.d.f14078b.size();
        if (r5 != 0) goto L5;
        return;
    L5:
        int r10 = RangesKt.coerceIn(this.f14053p, 0, r5 - 1);
        if (this.f14059w == false) goto L9;
        int r11 = (r5 * 1000) / 2;
    L10:
        this.f14054q = r11 + r10;
        if (this.f14042a.getChildCount() <= 0) goto L14;
        c();
        return;
    L14:
        return;
    L9:
        r11 = f();
        goto L10
    }

    public final void i(int r5) {
        int r10 = getCurrentIndex();
        k(r5, false);
        int r11 = this.d.f14078b.size();
        if (r11 <= 0) goto L22;
        int r12 = RangesKt.coerceIn(r5, 0, r11 - 1);
        if (r10 == r12) goto L23;
        a r13 = this.B;
        if (r13 == null) goto L13;
        yr.a r14 = (yr.a) ((f) r13).f22816a;
        androidx.core.view.inputmethod.a r15 = r14.f23323i;
        if (r15 == null) goto L13;
        r15.b(r14.f23319a, r12);
    L13:
        a r16 = this.B;
        if (r16 == null) goto L20;
        yr.a r17 = (yr.a) ((f) r16).f22816a;
        androidx.core.view.inputmethod.a r18 = r17.f23323i;
        if (r18 == null) goto L20;
        r18.b(r17.f23319a, r12);
    L20:
        this.f14050m = r12;
        return;
    L23:
        return;
    }

    public final void j(List r10, Integer r11) {
        this.f14055r = -1;
        if (r11 != null) goto L5;
        Integer r12 = null;
    L10:
        if (r12 == null) goto L13;
        this.f14053p = r12.intValue();
    L13:
        d r5 = this.d;
        boolean r13 = Intrinsics.areEqual(r5.f14078b, r10);
        RecyclerView r14 = this.f14042a;
        if (r13 == true) goto L16;
        r14.Z();
        Intrinsics.checkNotNullParameter(r10, "data");
        ArrayList r15 = r5.f14078b;
        r15.clear();
        r15.addAll(r10);
        r5.notifyDataSetChanged();
    L16:
        TextView r16 = new TextView(getContext());
        r16.setTextSize(22.0f);
        TextPaint r17 = r16.getPaint();
        this.f = 0.0f;
        Iterator r18 = r10.iterator();
    L18:
        if (r18.hasNext() == false) goto L22;
        float r19 = r17.measureText(((CharSequence) r18.next()).toString());
        if (r19 <= this.f) goto L18;
        this.f = r19;
        goto L18
    L22:
        TextView r20 = this.f14043b;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if ((r21 instanceof ViewGroup.MarginLayoutParams) == false) goto L29;
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) r21;
        int r23 = (int) (this.f / 2.0f);
        Integer r24 = this.f14061y;
        if (r24 != null) goto L27;
        int r25 = 0;
    L28:
        r22.setMarginStart((r25 * 2) + r23);
        r20.setLayoutParams(r21);
        goto L29
    L27:
        r25 = r24.intValue();
    L29:
        if (r12 != null) goto L31;
    L42:
        post(new com.obric.oui.lisitem.a(this, 1));
        return;
    L31:
        if (r10.isEmpty() == true) goto L42;
        if (r13 == true) goto L41;
        int r110 = r12.intValue();
        int r26 = r10.size();
        int r111 = RangesKt.coerceIn(r110, 0, r26 - 1);
        if (this.f14059w == false) goto L37;
        int r27 = (r26 * 1000) / 2;
    L38:
        this.f14054q = r27 + r111;
        if (r14.getChildCount() <= 0) goto L42;
        c();
        goto L42
    L37:
        r27 = f();
        goto L38
    L41:
        k(r12.intValue(), false);
        goto L42
    L5:
        int r112 = r11.intValue();
        if (r10.isEmpty() == true) goto L9;
        r112 = RangesKt.coerceIn(r112, 0, r10.size() - 1);
    L9:
        r12 = Integer.valueOf(r112);
        goto L10
    }

    public final void k(int r10, boolean r11) {
        this.f14054q = -1;
        this.f14055r = -1;
        d r5 = this.d;
        int r12 = r5.f14078b.size();
        if (r12 != 0) goto L6;
        this.f14053p = r10;
        return;
    L6:
        int r13 = RangesKt.coerceIn(r10, 0, r12 - 1);
        this.f14053p = r13;
        if (this.f14059w == false) goto L25;
        int r14 = e();
        if (this.f14042a.getChildCount() <= 0) goto L24;
        if (r14 == (-1)) goto L24;
        int r15 = r5.getItemCount();
        int r16 = (r14 - (r14 % r12)) + r13;
        Ref.IntRef r17 = new Ref.IntRef();
        r17.element = r16;
        Ref.IntRef r18 = new Ref.IntRef();
        r18.element = Math.abs(r16 - r14);
        int r19 = r16 - r12;
        if (r19 < 0) goto L17;
        if (r19 >= r15) goto L17;
        int r20 = Math.abs(r19 - r14);
        if (r20 >= r18.element) goto L17;
        r17.element = r19;
        r18.element = r20;
    L17:
        int r21 = r16 + r12;
        if (r21 < 0) goto L23;
        if (r21 >= r15) goto L23;
        int r22 = Math.abs(r21 - r14);
        if (r22 >= r18.element) goto L23;
        r17.element = r21;
        r18.element = r22;
    L23:
        int r23 = r17.element;
    L26:
        d(r23, r11);
        return;
    L24:
        r23 = r13 + ((r12 * 1000) / 2);
        goto L26
    L25:
        r23 = r13 + f();
        goto L26
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.f14048k = com.lynx.tasm.utils.a.B(28, this);
        requestLayout();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + (getPaddingTop() + ((int) (((this.e / ((float) Math.tan(0.5235988f))) * 2.0f) + this.e))), BasicMeasure.EXACTLY);
        int r11 = View.MeasureSpec.getMode(r5);
        int r12 = View.MeasureSpec.getSize(r5);
        int r13 = Math.max((int) (this.f + this.f14048k), getMinimumWidth());
        if (r11 == Integer.MIN_VALUE) goto L6;
        if (r11 == 1073741824) goto L7;
        r12 = r13;
    L7:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r12, BasicMeasure.EXACTLY), r10);
        return;
    L6:
        r12 = Math.min(r13, r12);
        goto L7
    }

    public final void setCurrentIndex(int r5) {
        i(r5);
    }

    public final void setCyclic(boolean r5) {
        this.f14059w = r5;
        b r10 = this.f14044c;
        r10.f14073x = r5;
        if (r5 == false) goto L5;
        int r11 = 0;
    L6:
        r10.f14074y = r11;
        requestLayout();
        return;
    L5:
        r11 = f();
        goto L6
    }

    public final void setEntries(String... r5) {
        Intrinsics.checkNotNullParameter(r5, "entries");
        j(ArraysKt.toList(r5), null);
    }

    public final void setHighlightConorRadiusPx(int r5) {
        this.f14058v = r5;
    }

    public final void setItemCount(int r5) {
        this.g = r5;
        if (this.f14059w == false) goto L5;
        int r10 = 0;
    L6:
        this.f14044c.f14074y = r10;
        requestLayout();
        return;
    L5:
        r10 = f();
        goto L6
    }

    public final void setItemHeightPx(int r5) {
        this.e = r5;
        this.d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setNormalTextColor(int r5) {
        this.A = r5;
        this.f14044c.f14067q = r5;
        this.f14042a.requestLayout();
    }

    public final void setOnWheelChangedListener(a r5) {
        this.B = r5;
    }

    public final void setSelectedItemHeightPx(int r5) {
        this.e = r5;
        this.d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setSelectedTextColor(int r5) {
        this.f14062z = r5;
        this.f14044c.f14066p = r5;
        this.f14042a.requestLayout();
    }

    public final void setSelectedTextSizePxProp(float r5) {
        this.f14047j = r5;
        this.f14045h = Math.max(this.f14046i, r5);
        this.d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setShowDivider(boolean r5) {
        this.f14057u = r5;
    }

    public final void setStartIndex(int r5) {
        this.f14053p = r5;
        d r10 = this.d;
        if (r10.f14078b.size() <= 0) goto L6;
        k(RangesKt.coerceIn(r5, 0, r10.f14078b.size() - 1), false);
        return;
    }

    public final void setTagGap(Integer r5) {
        this.f14061y = r5;
        requestLayout();
    }

    public final void setTagText(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        this.f14060x = r5;
        TextView r10 = this.f14043b;
        if (r5 != null) goto L5;
    L8:
        r10.setVisibility(8);
        return;
    L5:
        if (r5.length() == 0) goto L8;
        r10.setVisibility(0);
        r10.setText(this.f14060x);
    }

    public final void setTextColor(int r5) {
        setNormalTextColor(r5);
    }

    public final void setTextSizePx(float r5) {
        this.f14046i = r5;
        this.f14045h = Math.max(r5, this.f14047j);
        this.d.notifyDataSetChanged();
        requestLayout();
    }

    public final void setWheelTagText(CharSequence r5) {
        this.f14060x = r5;
    }

    @JvmOverloads
    public WheelView(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ WheelView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final void setEntries(List<String> r5) {
        if (r5 != null) goto L5;
        List r10 = 0;
    L9:
        if (r10 != 0) goto L11;
        r10 = CollectionsKt.emptyList();
    L11:
        j(r10, null);
        return;
    L5:
        r10 = new ArrayList(CollectionsKt.h(r5));
        Iterator<T> r11 = r5.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        r10.add((String) r11.next());
        goto L7
    }

    @JvmOverloads
    public WheelView(Context r18, AttributeSet r19, int r20) {
        Intrinsics.checkNotNullParameter(r18, "context");
        super(r18, r19, r20);
        b r5 = new b(r18);
        this.f14044c = r5;
        d r10 = new d(this);
        this.d = r10;
        this.e = com.lynx.tasm.utils.a.A(50.0f, this);
        this.g = 5;
        this.f14045h = com.lynx.tasm.utils.a.D(22.0f, this);
        this.f14046i = com.lynx.tasm.utils.a.D(22.0f, this);
        this.f14047j = com.lynx.tasm.utils.a.D(22.0f, this);
        this.f14049l = -1;
        this.f14050m = -1;
        this.f14054q = -1;
        this.f14055r = -1;
        this.f14058v = com.lynx.tasm.utils.a.B(8, this);
        this.f14062z = ContextCompat.getColor(r18, R$color.oui_accent_6_bg);
        this.A = ContextCompat.getColor(r18, R$color.oui_basic_text_1);
        as.b r11 = new as.b(this, 2);
        this.f14048k = com.lynx.tasm.utils.a.B(28, this);
        View.inflate(r18, R$layout.o_wheel_view, this);
        setTagGap(Integer.valueOf(com.lynx.tasm.utils.a.B(2, this)));
        RecyclerView r12 = (RecyclerView) findViewById(R$id.recycler);
        this.f14042a = r12;
        this.f14043b = (TextView) findViewById(R$id.tv_tag);
        r12.setLayoutManager(r5);
        r5.f14074y = f();
        r12.setAdapter(r10);
        r12.setClipToPadding(false);
        r12.setOverScrollMode(0);
        r12.i(r11);
        r12.getViewTreeObserver().addOnGlobalLayoutListener(new n(this, 2));
        TypedArray r13 = getContext().obtainStyledAttributes(r19, R$styleable.OWheelView);
        boolean r14 = r13.getBoolean(R$styleable.OWheelView_oui_wheelCyclic, false);
        int r15 = r13.getInt(R$styleable.OWheelView_oui_wheelStartIndex, 0);
        int r16 = r13.getInt(R$styleable.OWheelView_oui_wheelItemCount, 5);
        int r17 = r13.getDimensionPixelOffset(R$styleable.OWheelView_oui_wheelItemHeight, com.lynx.tasm.utils.a.B(50, this));
        int r21 = r13.getDimensionPixelSize(R$styleable.OWheelView_oui_wheelTextSize, com.lynx.tasm.utils.a.A(22.0f, this));
        int r22 = r13.getDimensionPixelSize(R$styleable.OWheelView_oui_wheelTextSize, com.lynx.tasm.utils.a.A(14.0f, this));
        int r110 = r13.getColor(R$styleable.OWheelView_oui_wheelTextColor, ContextCompat.getColor(getContext(), com.obric.common.res.R$color.oui_basic_text_1));
        int r111 = r13.getColor(R$styleable.OWheelView_oui_wheelSelectedTextColor, ContextCompat.getColor(getContext(), com.obric.common.res.R$color.oui_accent_6_bg));
        int r23 = r13.getDimensionPixelSize(R$styleable.OWheelView_oui_wheelSelectedTextSize, com.lynx.tasm.utils.a.A(22.0f, this));
        CharSequence[] r112 = r13.getTextArray(R$styleable.OWheelView_oui_wheelEntries);
        if (r112 != null) goto L5;
        ArrayList r113 = null;
    L8:
        r13.recycle();
        setCyclic(r14);
        this.f14053p = r15;
        this.g = r16;
        this.e = r17;
        float r24 = r21;
        this.f14046i = r24;
        float r25 = r23;
        this.f14047j = r25;
        this.f14045h = RangesKt.coerceAtLeast(r25, r24);
        setSelectedTextColor(r111);
        TextView r26 = this.f14043b;
        r26.setTextSize(0, r22);
        r26.setTextColor(r110);
        if (r113 == null) goto L11;
        j(r113, null);
        return;
    L11:
        h();
        return;
    L5:
        r113 = new ArrayList(r112.length);
        int r114 = r112.length;
        int r115 = 0;
    L6:
        if (r115 >= r114) goto L8;
        r113.add(r112[r115].toString());
        r115 = r115 + 1;
        goto L6
    }
}
