package com.obric.oui.sheet;

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
import com.obric.oui.titlebar.OTitleBar;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR(\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R(\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R(\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010+\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\rR\"\u0010/\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010\rR\"\u00103\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b1\u0010)\"\u0004\b2\u0010\rR\"\u00107\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010'\u001a\u0004\b5\u0010)\"\u0004\b6\u0010\r¨\u00068"}, d2 = {"Lcom/obric/oui/sheet/OInsetTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "", "setDividerLineBackground", "(I)V", "Landroid/widget/ImageView;", "<set-?>", "b", "Landroid/widget/ImageView;", "getStartButton0", "()Landroid/widget/ImageView;", "startButton0", "c", "getStartButton1", "startButton1", "d", "getEndButton1", "endButton1", "e", "getEndButton0", "endButton0", "Landroid/widget/FrameLayout;", "g", "Landroid/widget/FrameLayout;", "getMRightAction", "()Landroid/widget/FrameLayout;", "setMRightAction", "(Landroid/widget/FrameLayout;)V", "mRightAction", "h", "I", "getMStart0Color", "()I", "setMStart0Color", "mStart0Color", "i", "getMStart1Color", "setMStart1Color", "mStart1Color", "j", "getMEnd0Color", "setMEnd0Color", "mEnd0Color", "k", "getMEnd1Color", "setMEnd1Color", "mEnd1Color", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OInsetTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f14423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f14424c;
    public final ImageView d;
    public final ImageView e;
    public final View f;
    public FrameLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f14428k;

    @JvmOverloads
    public OInsetTitleBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final ImageView getEndButton0() {
        return this.e;
    }

    public final ImageView getEndButton1() {
        return this.d;
    }

    public final int getMEnd0Color() {
        return this.f14427j;
    }

    public final int getMEnd1Color() {
        return this.f14428k;
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
        return this.f14425h;
    }

    public final int getMStart1Color() {
        return this.f14426i;
    }

    public final ImageView getStartButton0() {
        return this.f14423b;
    }

    public final ImageView getStartButton1() {
        return this.f14424c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageView r5 = this.f14423b;
        if (r5 == null) goto L6;
        com.lynx.tasm.utils.d.o(r5, com.lynx.tasm.utils.a.u(40), com.lynx.tasm.utils.a.u(44), false);
    L6:
        ImageView r10 = this.f14424c;
        if (r10 == null) goto L10;
        com.lynx.tasm.utils.d.o(r10, com.lynx.tasm.utils.a.u(40), com.lynx.tasm.utils.a.u(44), false);
    L10:
        ImageView r11 = this.e;
        if (r11 == null) goto L14;
        com.lynx.tasm.utils.d.o(r11, com.lynx.tasm.utils.a.u(40), com.lynx.tasm.utils.a.u(44), false);
    L14:
        ImageView r12 = this.d;
        if (r12 == null) goto L19;
        com.lynx.tasm.utils.d.o(r12, com.lynx.tasm.utils.a.u(40), com.lynx.tasm.utils.a.u(44), false);
        return;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r5) {
        View r10 = this.f;
        if (r10 == null) goto L7;
        r10.setBackgroundColor(r5);
        return;
    }

    public final void setMEnd0Color(int r5) {
        this.f14427j = r5;
    }

    public final void setMEnd1Color(int r5) {
        this.f14428k = r5;
    }

    public final void setMRightAction(FrameLayout r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.g = r5;
    }

    public final void setMStart0Color(int r5) {
        this.f14425h = r5;
    }

    public final void setMStart1Color(int r5) {
        this.f14426i = r5;
    }

    @JvmOverloads
    public OInsetTitleBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OInsetTitleBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OInsetTitleBar(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        View.inflate(r5, R$layout.o_view_inset_title_bar, this);
        this.f14423b = (ImageView) findViewById(R$id.iv_start_0);
        this.f14424c = (ImageView) findViewById(R$id.iv_start_1);
        this.e = (ImageView) findViewById(R$id.iv_end_0);
        this.d = (ImageView) findViewById(R$id.iv_end_1);
        this.f14819a = (TextView) findViewById(R$id.title);
        setMRightAction((FrameLayout) findViewById(R$id.fl_right_container));
        this.f = findViewById(R$id.line);
        if (r10 == null) goto L17;
        int r12 = 0;
        TypedArray r13 = getContext().getTheme().obtainStyledAttributes(r10, R$styleable.OCompoundTitleBar, 0, 0);
        setTitle(r13.getString(R$styleable.OCompoundTitleBar_oui_centerText));     // Catch: Throwable -> L14
        setTitleColor(r13.getColor(R$styleable.OCompoundTitleBar_oui_centerTextColor, ContextCompat.getColor(getContext(), R$color.TextPrimary)));     // Catch: Throwable -> L14
        setTitleSizePixel(r13.getDimension(R$styleable.OCompoundTitleBar_oui_centerTextSize, com.lynx.tasm.utils.a.u(17)));     // Catch: Throwable -> L14
        int r14 = r13.getColor(R$styleable.OCompoundTitleBar_oui_dividerColor, ContextCompat.getColor(getContext(), R$color.LinePrimary));     // Catch: Throwable -> L14
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
