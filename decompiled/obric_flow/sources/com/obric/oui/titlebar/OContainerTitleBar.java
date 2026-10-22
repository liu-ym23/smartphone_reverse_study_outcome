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
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\rR\"\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\rR\"\u0010\u001b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011\"\u0004\b\u001a\u0010\rR\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\rR\u0013\u0010#\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0013\u0010%\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0013\u0010)\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010+\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b*\u0010\"¨\u0006,"}, d2 = {"Lcom/obric/oui/titlebar/OContainerTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "", "setDividerLineBackground", "(I)V", "g", "I", "getMStart0Color", "()I", "setMStart0Color", "mStart0Color", "h", "getMStart1Color", "setMStart1Color", "mStart1Color", "i", "getMEnd0Color", "setMEnd0Color", "mEnd0Color", "j", "getMEnd1Color", "setMEnd1Color", "mEnd1Color", "Landroid/widget/ImageView;", "getStartButton0", "()Landroid/widget/ImageView;", "startButton0", "getStartButton1", "startButton1", "Landroid/widget/FrameLayout;", "getEndContainer", "()Landroid/widget/FrameLayout;", "endContainer", "getEndButton", "endButton", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OContainerTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f14788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f14789c;
    public final FrameLayout d;
    public final ImageView e;
    public final View f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f14790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14792j;

    @JvmOverloads
    public OContainerTitleBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final ImageView getEndButton() {
        return this.e;
    }

    public final FrameLayout getEndContainer() {
        return this.d;
    }

    public final int getMEnd0Color() {
        return this.f14791i;
    }

    public final int getMEnd1Color() {
        return this.f14792j;
    }

    public final int getMStart0Color() {
        return this.g;
    }

    public final int getMStart1Color() {
        return this.f14790h;
    }

    public final ImageView getStartButton0() {
        return this.f14788b;
    }

    public final ImageView getStartButton1() {
        return this.f14789c;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r5) {
        View r10 = this.f;
        if (r10 == null) goto L7;
        r10.setBackgroundColor(r5);
        return;
    }

    public final void setMEnd0Color(int r5) {
        this.f14791i = r5;
    }

    public final void setMEnd1Color(int r5) {
        this.f14792j = r5;
    }

    public final void setMStart0Color(int r5) {
        this.g = r5;
    }

    public final void setMStart1Color(int r5) {
        this.f14790h = r5;
    }

    @JvmOverloads
    public OContainerTitleBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OContainerTitleBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OContainerTitleBar(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        View.inflate(r5, R$layout.o_view_container_title_bar, this);
        this.f14788b = (ImageView) findViewById(R$id.iv_start_0);
        this.f14789c = (ImageView) findViewById(R$id.iv_start_1);
        this.d = (FrameLayout) findViewById(R$id.end_container);
        this.e = (ImageView) findViewById(R$id.iv_end_1);
        this.f14819a = (TextView) findViewById(R$id.title);
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
