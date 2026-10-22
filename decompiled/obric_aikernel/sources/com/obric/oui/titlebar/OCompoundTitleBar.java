package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.c;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "请使用 OCTitleBar")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00103\u001a\u00020\u0002¢\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\u0015\u0010 \u001a\u0004\u0018\u00010\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b\u001f\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u0015\u0010&\u001a\u0004\u0018\u00010\u00068F@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010\bR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u0015\u0010.\u001a\u0004\u0018\u00010+8F@\u0006¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00066"}, d2 = {"Lcom/obric/oui/titlebar/OCompoundTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "", TypedValues.Custom.S_COLOR, "", "setDividerLineBackground", "Landroid/widget/ImageView;", "getEndButton0", "()Landroid/widget/ImageView;", "endButton0", "Landroid/widget/FrameLayout;", "l", "Landroid/widget/FrameLayout;", "getMRightAction", "()Landroid/widget/FrameLayout;", "setMRightAction", "(Landroid/widget/FrameLayout;)V", "mRightAction", "getEndButton1", "endButton1", "n", "I", "getMStart1Color", "()I", "setMStart1Color", "(I)V", "mStart1Color", "p", "getMEnd1Color", "setMEnd1Color", "mEnd1Color", "getStartButton0", "startButton0", "m", "getMStart0Color", "setMStart0Color", "mStart0Color", "getStartButton1", "startButton1", "o", "getMEnd0Color", "setMEnd0Color", "mEnd0Color", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "divider", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OCompoundTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f7667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f7668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImageView f7669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f7670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f7671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f7672l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7673m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7674n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7675o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7676p;

    @JvmOverloads
    public OCompoundTitleBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OCompoundTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OCompoundTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        a(r10);
        if (r11 == null) goto L6;
        b(r11);
        return;
    }

    public /* synthetic */ OCompoundTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void a(Context r10) {
        FrameLayout.inflate(r10, h.o_view_compound_title_bar, this);
        this.f7667g = (ImageView) findViewById(f.iv_start_0);
        this.f7668h = (ImageView) findViewById(f.iv_start_1);
        this.f7669i = (ImageView) findViewById(f.iv_end_0);
        this.f7670j = (ImageView) findViewById(f.iv_end_1);
        this.f7718c = (TextView) findViewById(f.title);
        View r11 = findViewById(f.fl_right_container);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.fl_right_container)");
        this.f7672l = (FrameLayout) r11;
        this.f7671k = findViewById(f.line);
    }

    private final void b(AttributeSet r10) {
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        TypedArray r12 = r11.getTheme().obtainStyledAttributes(r10, l.OCompoundTitleBar, 0, 0);
        setTitle(r12.getString(l.OCompoundTitleBar_oui_centerText));     // Catch: Throwable -> L6
        setTitleColor(r12.getColor(l.OCompoundTitleBar_oui_centerTextColor, ContextCompat.getColor(getContext(), c.oui_basic_text_1)));     // Catch: Throwable -> L6
        setTitleSizePixel(r12.getDimension(l.OCompoundTitleBar_oui_centerTextSize, com.obric.oui.common.util.f.b(17)));     // Catch: Throwable -> L6
        int r13 = r12.getColor(l.OCompoundTitleBar_oui_dividerColor, ContextCompat.getColor(getContext(), c.oui_basic_text_4));     // Catch: Throwable -> L6
        c(r12.getBoolean(l.OCompoundTitleBar_oui_dividerVisible, false));     // Catch: Throwable -> L6
        setDividerLineBackground(r13);     // Catch: Throwable -> L6
        r12.recycle();
        return;
    L6:
        th = move-exception;
        r12.recycle();
        throw th;
    }

    public void c(boolean r10) {
        View r11 = this.f7671k;
        if (r11 == null) goto L9;
        if (r10 == false) goto L6;
        int r12 = 0;
    L7:
        r11.setVisibility(r12);
        return;
    L6:
        r12 = 8;
        goto L7
    }

    public final View getDivider() {
        return this.f7671k;
    }

    public final ImageView getEndButton0() {
        return this.f7669i;
    }

    public final ImageView getEndButton1() {
        return this.f7670j;
    }

    public final int getMEnd0Color() {
        return this.f7675o;
    }

    public final int getMEnd1Color() {
        return this.f7676p;
    }

    public final FrameLayout getMRightAction() {
        FrameLayout r10 = this.f7672l;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRightAction");
    L5:
        return r10;
    }

    public final int getMStart0Color() {
        return this.f7673m;
    }

    public final int getMStart1Color() {
        return this.f7674n;
    }

    public final ImageView getStartButton0() {
        return this.f7667g;
    }

    public final ImageView getStartButton1() {
        return this.f7668h;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r10) {
        View r11 = this.f7671k;
        if (r11 == null) goto L6;
        r11.setBackgroundColor(r10);
        return;
    }

    public final void setMEnd0Color(int r10) {
        this.f7675o = r10;
    }

    public final void setMEnd1Color(int r10) {
        this.f7676p = r10;
    }

    public final void setMRightAction(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7672l = r10;
    }

    public final void setMStart0Color(int r10) {
        this.f7673m = r10;
    }

    public final void setMStart1Color(int r10) {
        this.f7674n = r10;
    }
}
