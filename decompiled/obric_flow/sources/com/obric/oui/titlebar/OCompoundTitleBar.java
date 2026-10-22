package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "请使用 OCTitleBar")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\rR\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\rR\"\u0010#\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0017\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\rR\"\u0010'\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0017\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\rR\u0013\u0010+\u001a\u0004\u0018\u00010(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0013\u0010-\u001a\u0004\u0018\u00010(8F¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0013\u0010/\u001a\u0004\u0018\u00010(8F¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0013\u00101\u001a\u0004\u0018\u00010(8F¢\u0006\u0006\u001a\u0004\b0\u0010*R\u0013\u00105\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/obric/oui/titlebar/OCompoundTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "", "setDividerLineBackground", "(I)V", "Landroid/widget/FrameLayout;", "g", "Landroid/widget/FrameLayout;", "getMRightAction", "()Landroid/widget/FrameLayout;", "setMRightAction", "(Landroid/widget/FrameLayout;)V", "mRightAction", "h", "I", "getMStart0Color", "()I", "setMStart0Color", "mStart0Color", "i", "getMStart1Color", "setMStart1Color", "mStart1Color", "j", "getMEnd0Color", "setMEnd0Color", "mEnd0Color", "k", "getMEnd1Color", "setMEnd1Color", "mEnd1Color", "Landroid/widget/ImageView;", "getStartButton0", "()Landroid/widget/ImageView;", "startButton0", "getStartButton1", "startButton1", "getEndButton0", "endButton0", "getEndButton1", "endButton1", "Landroid/view/View;", "getDivider", "()Landroid/view/View;", "divider", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCompoundTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f14782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f14783c;
    public final ImageView d;
    public final ImageView e;
    public final View f;
    public FrameLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14787k;

    @JvmOverloads
    public OCompoundTitleBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final View getDivider() {
        return this.f;
    }

    public final ImageView getEndButton0() {
        return this.d;
    }

    public final ImageView getEndButton1() {
        return this.e;
    }

    public final int getMEnd0Color() {
        return this.f14786j;
    }

    public final int getMEnd1Color() {
        return this.f14787k;
    }

    public final FrameLayout getMRightAction() {
        FrameLayout r5 = this.g;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("mRightAction");
        return null;
    }

    public final int getMStart0Color() {
        return this.f14784h;
    }

    public final int getMStart1Color() {
        return this.f14785i;
    }

    public final ImageView getStartButton0() {
        return this.f14782b;
    }

    public final ImageView getStartButton1() {
        return this.f14783c;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r5) {
        View r10 = this.f;
        if (r10 == null) goto L7;
        r10.setBackgroundColor(r5);
        return;
    }

    public final void setMEnd0Color(int r5) {
        this.f14786j = r5;
    }

    public final void setMEnd1Color(int r5) {
        this.f14787k = r5;
    }

    public final void setMRightAction(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.g = r5;
    }

    public final void setMStart0Color(int r5) {
        this.f14784h = r5;
    }

    public final void setMStart1Color(int r5) {
        this.f14785i = r5;
    }

    @JvmOverloads
    public OCompoundTitleBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OCompoundTitleBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OCompoundTitleBar(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        View.inflate(r5, R$layout.o_view_compound_title_bar, this);
        this.f14782b = (ImageView) findViewById(R$id.iv_start_0);
        this.f14783c = (ImageView) findViewById(R$id.iv_start_1);
        this.d = (ImageView) findViewById(R$id.iv_end_0);
        this.e = (ImageView) findViewById(R$id.iv_end_1);
        this.f14819a = (TextView) findViewById(R$id.title);
        setMRightAction((FrameLayout) findViewById(R$id.fl_right_container));
        this.f = findViewById(R$id.line);
        if (r10 == null) goto L17;
        int r12 = 0;
        TypedArray r13 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OCompoundTitleBar, 0, 0);
        setTitle(r13.getString(R$styleable.OCompoundTitleBar_oui_centerText));     // Catch: Throwable -> L14
        setTitleColor(r13.getColor(R$styleable.OCompoundTitleBar_oui_centerTextColor, ContextCompat.getColor(getContext(), R$color.oui_basic_text_1)));     // Catch: Throwable -> L14
        setTitleSizePixel(r13.getDimension(R$styleable.OCompoundTitleBar_oui_centerTextSize, com.lynx.tasm.utils.a.u(17)));     // Catch: Throwable -> L14
        int r14 = r13.getColor(R$styleable.OCompoundTitleBar_oui_dividerColor, ContextCompat.getColor(getContext(), R$color.oui_basic_text_4));     // Catch: Throwable -> L14
        boolean r15 = r13.getBoolean(R$styleable.OCompoundTitleBar_oui_dividerVisible, false);     // Catch: Throwable -> L14
        View r16 = this.f;     // Catch: Throwable -> L14
        if (r16 == null) goto L12;
        if (r15 == true) goto L11;
        r12 = 8;
    L11:
        r16.setVisibility(r12);     // Catch: Throwable -> L14
    L12:
        setDividerLineBackground(r14);     // Catch: Throwable -> L14
        r13.recycle();
        return;
    L14:
        th = move-exception;
        r13.recycle();
        throw th;
    }
}
