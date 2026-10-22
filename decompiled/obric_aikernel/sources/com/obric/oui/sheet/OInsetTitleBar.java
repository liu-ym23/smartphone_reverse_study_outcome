package com.obric.oui.sheet;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.util.k;
import com.obric.oui.titlebar.OTitleBar;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.c;
import u8.f;
import u8.h;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0002¢\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R(\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R(\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b)\u0010\u000bR(\u0010-\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b,\u0010\u000bR(\u00100\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b/\u0010\u000b¨\u00068"}, d2 = {"Lcom/obric/oui/sheet/OInsetTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "", TypedValues.Custom.S_COLOR, "", "setDividerLineBackground", "Landroid/widget/ImageView;", "<set-?>", "g", "Landroid/widget/ImageView;", "getStartButton0", "()Landroid/widget/ImageView;", "startButton0", "p", "I", "getMEnd1Color", "()I", "setMEnd1Color", "(I)V", "mEnd1Color", "m", "getMStart0Color", "setMStart0Color", "mStart0Color", "Landroid/widget/FrameLayout;", "l", "Landroid/widget/FrameLayout;", "getMRightAction", "()Landroid/widget/FrameLayout;", "setMRightAction", "(Landroid/widget/FrameLayout;)V", "mRightAction", "n", "getMStart1Color", "setMStart1Color", "mStart1Color", "o", "getMEnd0Color", "setMEnd0Color", "mEnd0Color", "i", "getEndButton1", "endButton1", "h", "getStartButton1", "startButton1", "j", "getEndButton0", "endButton0", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OInsetTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f7397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f7398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImageView f7399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f7400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f7401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f7402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7405o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7406p;

    @JvmOverloads
    public OInsetTitleBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OInsetTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OInsetTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        a(r10);
        if (r11 == null) goto L6;
        b(r11);
        return;
    }

    public /* synthetic */ OInsetTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void a(Context r10) {
        FrameLayout.inflate(r10, h.o_view_inset_title_bar, this);
        this.f7397g = (ImageView) findViewById(f.iv_start_0);
        this.f7398h = (ImageView) findViewById(f.iv_start_1);
        this.f7400j = (ImageView) findViewById(f.iv_end_0);
        this.f7399i = (ImageView) findViewById(f.iv_end_1);
        this.f7718c = (TextView) findViewById(f.title);
        View r11 = findViewById(f.fl_right_container);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.fl_right_container)");
        this.f7402l = (FrameLayout) r11;
        this.f7401k = findViewById(f.line);
    }

    private final void b(AttributeSet r10) {
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        TypedArray r12 = r11.getTheme().obtainStyledAttributes(r10, l.OCompoundTitleBar, 0, 0);
        setTitle(r12.getString(l.OCompoundTitleBar_oui_centerText));     // Catch: Throwable -> L6
        setTitleColor(r12.getColor(l.OCompoundTitleBar_oui_centerTextColor, ContextCompat.getColor(getContext(), c.TextPrimary)));     // Catch: Throwable -> L6
        setTitleSizePixel(r12.getDimension(l.OCompoundTitleBar_oui_centerTextSize, com.obric.oui.common.util.f.b(17)));     // Catch: Throwable -> L6
        int r13 = r12.getColor(l.OCompoundTitleBar_oui_dividerColor, ContextCompat.getColor(getContext(), c.LinePrimary));     // Catch: Throwable -> L6
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
        View r11 = this.f7401k;
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

    public final ImageView getEndButton0() {
        return this.f7400j;
    }

    public final ImageView getEndButton1() {
        return this.f7399i;
    }

    public final int getMEnd0Color() {
        return this.f7405o;
    }

    public final int getMEnd1Color() {
        return this.f7406p;
    }

    public final FrameLayout getMRightAction() {
        FrameLayout r10 = this.f7402l;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRightAction");
    L5:
        return r10;
    }

    public final int getMStart0Color() {
        return this.f7403m;
    }

    public final int getMStart1Color() {
        return this.f7404n;
    }

    public final ImageView getStartButton0() {
        return this.f7397g;
    }

    public final ImageView getStartButton1() {
        return this.f7398h;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ImageView r10 = this.f7397g;
        if (r10 == null) goto L5;
        k.c(r10, com.obric.oui.common.util.f.b(40), com.obric.oui.common.util.f.b(44), false, 4, null);
    L5:
        ImageView r11 = this.f7398h;
        if (r11 == null) goto L8;
        k.c(r11, com.obric.oui.common.util.f.b(40), com.obric.oui.common.util.f.b(44), false, 4, null);
    L8:
        ImageView r12 = this.f7400j;
        if (r12 == null) goto L11;
        k.c(r12, com.obric.oui.common.util.f.b(40), com.obric.oui.common.util.f.b(44), false, 4, null);
    L11:
        ImageView r13 = this.f7399i;
        if (r13 == null) goto L15;
        k.c(r13, com.obric.oui.common.util.f.b(40), com.obric.oui.common.util.f.b(44), false, 4, null);
        return;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r10) {
        View r11 = this.f7401k;
        if (r11 == null) goto L6;
        r11.setBackgroundColor(r10);
        return;
    }

    public final void setMEnd0Color(int r10) {
        this.f7405o = r10;
    }

    public final void setMEnd1Color(int r10) {
        this.f7406p = r10;
    }

    public final void setMRightAction(FrameLayout r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.f7402l = r10;
    }

    public final void setMStart0Color(int r10) {
        this.f7403m = r10;
    }

    public final void setMStart1Color(int r10) {
        this.f7404n = r10;
    }
}
