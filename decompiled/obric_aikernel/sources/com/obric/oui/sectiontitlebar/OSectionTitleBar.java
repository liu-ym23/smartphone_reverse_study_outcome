package com.obric.oui.sectiontitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.oui.text.OTextView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.e;
import u8.f;
import u8.h;
import u8.k;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001#B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006J\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0006¨\u0006$"}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;", "Landroid/widget/LinearLayout;", "", "text", "", "setTitleText", "", "resId", "setTitleStyle", "", "size", "setTitleTextSize", TypedValues.Custom.S_COLOR, "setTitleTextColor", "Landroid/view/View;", "view", "setCustomEndView", "defaultCustomEnd", "setDefaultCustomEndView", "getCustomEndView", "Lcom/obric/oui/text/OTextView;", "getEndDetail", "setDetailEndText", "Landroid/graphics/drawable/Drawable;", "drawable", "setTailIcon", "defaultTailIcon", "setDefaultTailIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OSectionTitleBar extends LinearLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f7238i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f7239j = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TextView f7240c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final FrameLayout f7241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ImageView f7242h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OSectionTitleBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OSectionTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OSectionTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        setOrientation(0);
        LayoutInflater.from(r10).inflate(h.o_section_title_bar, this, true);
        View r13 = findViewById(f.container);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.container)");
        LinearLayout r14 = (LinearLayout) r13;
        View r15 = findViewById(f.titleTextView);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.titleTextView)");
        this.f7240c = (TextView) r15;
        View r16 = findViewById(f.custom_end_container);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.custom_end_container)");
        this.f7241g = (FrameLayout) r16;
        View r17 = findViewById(f.tail_icon);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.tail_icon)");
        this.f7242h = (ImageView) r17;
        TypedArray r18 = r10.getTheme().obtainStyledAttributes(r11, l.SectionTitleBar, 0, 0);
        Intrinsics.checkNotNullExpressionValue(r18, "context.theme.obtainStyl…           0, 0\n        )");
        int r19 = l.SectionTitleBar_sectionTitle_titleText;     // Catch: Throwable -> L32
        if (r18.hasValue(r19) == false) goto L6;
        setTitleText(r18.getString(r19));     // Catch: Throwable -> L32
    L6:
        int r20 = l.SectionTitleBar_sectionTitle_titleStyle;     // Catch: Throwable -> L32
        if (r18.hasValue(r20) == false) goto L9;
        setTitleStyle(r18.getResourceId(r20, k.OSectionTitleBar_S));     // Catch: Throwable -> L32
    L9:
        int r21 = l.SectionTitleBar_sectionTitle_customEnd;     // Catch: Throwable -> L32
        if (r18.hasValue(r21) == false) goto L12;
        setCustomEndView(r18.getResourceId(r21, 0));     // Catch: Throwable -> L32
    L12:
        int r22 = l.SectionTitleBar_sectionTitle_defaultCustomEnd;     // Catch: Throwable -> L32
        if (r18.hasValue(r22) == false) goto L15;
        setDefaultCustomEndView(r18.getInt(r22, 0));     // Catch: Throwable -> L32
    L15:
        int r23 = l.SectionTitleBar_sectionTitle_detailEndText;     // Catch: Throwable -> L32
        if (r18.hasValue(r23) == false) goto L18;
        setDetailEndText(r18.getString(r23));     // Catch: Throwable -> L32
    L18:
        int r24 = l.SectionTitleBar_sectionTitle_showCustomEnd;     // Catch: Throwable -> L32
        if (r18.hasValue(r24) == false) goto L21;
        a(r18.getBoolean(r24, false));     // Catch: Throwable -> L32
    L21:
        int r25 = l.SectionTitleBar_sectionTitle_tail;     // Catch: Throwable -> L32
        if (r18.hasValue(r25) == false) goto L24;
        setTailIcon(r18.getResourceId(r25, 0));     // Catch: Throwable -> L32
    L24:
        int r26 = l.SectionTitleBar_sectionTitle_defaultTail;     // Catch: Throwable -> L32
        if (r18.hasValue(r26) == false) goto L27;
        setDefaultTailIcon(r18.getInt(r26, 0));     // Catch: Throwable -> L32
    L27:
        int r27 = l.SectionTitleBar_sectionTitle_showTail;     // Catch: Throwable -> L32
        if (r18.hasValue(r27) == false) goto L30;
        b(r18.getBoolean(r27, false));     // Catch: Throwable -> L32
    L30:
        r18.recycle();
        return;
    L32:
        th = move-exception;
        r18.recycle();
        throw th;
    }

    public /* synthetic */ OSectionTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public final void a(boolean r10) {
        int r11 = this.f7241g.getChildCount();
        int r12 = 8;
        FrameLayout r13 = this.f7241g;
        if (r11 == 0) goto L6;
        if (r10 == false) goto L6;
        r12 = 0;
    L6:
        r13.setVisibility(r12);
    }

    public final void b(boolean r10) {
        Drawable r11 = this.f7242h.getDrawable();
        int r12 = 8;
        ImageView r13 = this.f7242h;
        if (r11 == null) goto L6;
        if (r10 == false) goto L6;
        r12 = 0;
    L6:
        r13.setVisibility(r12);
    }

    public final View getCustomEndView() {
        if (this.f7241g.getChildCount() != 0) goto L5;
        return null;
    L5:
        return this.f7241g.getChildAt(0);
    }

    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L6;
        View r10 = getCustomEndView();
        Objects.requireNonNull(r10, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        return (OTextView) r10;
    L6:
        return null;
    }

    public final void setCustomEndView(int r10) {
        this.f7241g.removeAllViews();
        if (r10 != 0) goto L9;
    L6:
        a(false);
        return;
    L9:
        LinearLayout.inflate(getContext(), r10, this.f7241g);     // Catch: Exception -> L8
    }

    public final void setCustomEndView(View r10) {
        this.f7241g.removeAllViews();
        if (r10 == null) goto L5;
        this.f7241g.addView(r10);
        return;
    L5:
        a(false);
    }

    public final void setDefaultCustomEndView(int r10) {
        this.f7241g.removeAllViews();
        if (r10 != f7238i) goto L5;
        setCustomEndView(h.o_section_titlebar_custom_end_detail);
        return;
    L5:
        a(false);
    }

    public final void setDefaultTailIcon(int r10) {
        if (r10 != f7239j) goto L5;
        setTailIcon(getResources().getDrawable(e.o_section_titlebar_tail_icon_arrow));
        return;
    L5:
        b(false);
    }

    public final void setDetailEndText(CharSequence r10) {
        setDefaultCustomEndView(f7238i);
        if ((getCustomEndView() instanceof OTextView) == false) goto L6;
        View r11 = getCustomEndView();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        ((OTextView) r11).setText(r10);
        return;
    }

    public final void setTailIcon(int r10) {
        if (r10 == 0) goto L4;
        this.f7242h.setImageResource(r10);
        return;
    L4:
        this.f7242h.setImageDrawable(null);
        b(false);
    }

    public final void setTailIcon(Drawable r10) {
        if (r10 == null) goto L4;
        this.f7242h.setImageDrawable(r10);
        return;
    L4:
        b(false);
    }

    public final void setTitleStyle(int r10) {
        this.f7240c.setTextAppearance(r10);
    }

    public final void setTitleText(CharSequence r10) {
        this.f7240c.setText(r10);
    }

    public final void setTitleTextColor(int r10) {
        this.f7240c.setTextColor(r10);
    }

    public final void setTitleTextSize(float r10) {
        this.f7240c.setTextSize(r10);
    }
}
