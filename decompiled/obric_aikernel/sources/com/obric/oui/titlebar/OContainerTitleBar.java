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
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u00198F@\u0006¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\u0015\u0010\"\u001a\u0004\u0018\u00010\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010\u0017R\u0015\u0010$\u001a\u0004\u0018\u00010\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\u0017¨\u0006,"}, d2 = {"Lcom/obric/oui/titlebar/OContainerTitleBar;", "Lcom/obric/oui/titlebar/OTitleBar;", "", TypedValues.Custom.S_COLOR, "", "setDividerLineBackground", "m", "I", "getMStart1Color", "()I", "setMStart1Color", "(I)V", "mStart1Color", "n", "getMEnd0Color", "setMEnd0Color", "mEnd0Color", "o", "getMEnd1Color", "setMEnd1Color", "mEnd1Color", "Landroid/widget/ImageView;", "getStartButton1", "()Landroid/widget/ImageView;", "startButton1", "Landroid/widget/FrameLayout;", "getEndContainer", "()Landroid/widget/FrameLayout;", "endContainer", "l", "getMStart0Color", "setMStart0Color", "mStart0Color", "getStartButton0", "startButton0", "getEndButton", "endButton", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OContainerTitleBar extends OTitleBar {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f7677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f7678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private FrameLayout f7679i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f7680j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f7681k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f7682l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7683m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7684n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7685o;

    @JvmOverloads
    public OContainerTitleBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OContainerTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OContainerTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        a(r10);
        if (r11 == null) goto L6;
        b(r11);
        return;
    }

    public /* synthetic */ OContainerTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void a(Context r10) {
        FrameLayout.inflate(r10, h.o_view_container_title_bar, this);
        this.f7677g = (ImageView) findViewById(f.iv_start_0);
        this.f7678h = (ImageView) findViewById(f.iv_start_1);
        this.f7679i = (FrameLayout) findViewById(f.end_container);
        this.f7680j = (ImageView) findViewById(f.iv_end_1);
        this.f7718c = (TextView) findViewById(f.title);
        this.f7681k = findViewById(f.line);
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
        View r11 = this.f7681k;
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

    public final ImageView getEndButton() {
        return this.f7680j;
    }

    public final FrameLayout getEndContainer() {
        return this.f7679i;
    }

    public final int getMEnd0Color() {
        return this.f7684n;
    }

    public final int getMEnd1Color() {
        return this.f7685o;
    }

    public final int getMStart0Color() {
        return this.f7682l;
    }

    public final int getMStart1Color() {
        return this.f7683m;
    }

    public final ImageView getStartButton0() {
        return this.f7677g;
    }

    public final ImageView getStartButton1() {
        return this.f7678h;
    }

    @Override // com.obric.oui.titlebar.OTitleBar
    public void setDividerLineBackground(int r10) {
        View r11 = this.f7681k;
        if (r11 == null) goto L6;
        r11.setBackgroundColor(r10);
        return;
    }

    public final void setMEnd0Color(int r10) {
        this.f7684n = r10;
    }

    public final void setMEnd1Color(int r10) {
        this.f7685o = r10;
    }

    public final void setMStart0Color(int r10) {
        this.f7682l = r10;
    }

    public final void setMStart1Color(int r10) {
        this.f7683m = r10;
    }
}
