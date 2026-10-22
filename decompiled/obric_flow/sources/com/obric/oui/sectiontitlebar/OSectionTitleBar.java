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
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u0011J\u0015\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u0011J\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b#\u0010\u000eJ\u0017\u0010&\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010'J\u0015\u0010&\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b&\u0010\u0011J\u0015\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0006¢\u0006\u0004\b)\u0010\u0011¨\u0006*"}, d2 = {"Lcom/obric/oui/sectiontitlebar/OSectionTitleBar;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", MessageIndication.CONTENT_TYPE_TEXT, "", "setTitleText", "(Ljava/lang/CharSequence;)V", "resId", "setTitleStyle", "(I)V", "", "size", "setTitleTextSize", "(F)V", "color", "setTitleTextColor", "Landroid/view/View;", "view", "setCustomEndView", "(Landroid/view/View;)V", "defaultCustomEnd", "setDefaultCustomEndView", "getCustomEndView", "()Landroid/view/View;", "Lcom/obric/oui/text/OTextView;", "getEndDetail", "()Lcom/obric/oui/text/OTextView;", "setDetailEndText", "Landroid/graphics/drawable/Drawable;", "drawable", "setTailIcon", "(Landroid/graphics/drawable/Drawable;)V", "defaultTailIcon", "setDefaultTailIcon", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSectionTitleBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f14291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f14292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f14293c;

    @JvmOverloads
    public OSectionTitleBar(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final void a(boolean r5) {
        FrameLayout r10 = this.f14292b;
        int r11 = 8;
        if (r10.getChildCount() == 0) goto L7;
        if (r5 == false) goto L6;
        r11 = 0;
    L6:
        r10.setVisibility(r11);
        return;
    L7:
        r10.setVisibility(8);
    }

    public final void b(boolean r5) {
        ImageView r10 = this.f14293c;
        int r11 = 8;
        if (r10.getDrawable() == null) goto L7;
        if (r5 == false) goto L6;
        r11 = 0;
    L6:
        r10.setVisibility(r11);
        return;
    L7:
        r10.setVisibility(8);
    }

    public final View getCustomEndView() {
        FrameLayout r5 = this.f14292b;
        if (r5.getChildCount() != 0) goto L5;
        return null;
    L5:
        return r5.getChildAt(0);
    }

    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L10;
        View r5 = getCustomEndView();
        if (r5 == null) goto L9;
        return (OTextView) r5;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L10:
        return null;
    }

    public final void setCustomEndView(View r5) {
        FrameLayout r10 = this.f14292b;
        r10.removeAllViews();
        if (r5 == null) goto L5;
        r10.addView(r5);
        return;
    L5:
        a(false);
    }

    public final void setDefaultCustomEndView(int r5) {
        this.f14292b.removeAllViews();
        if (r5 != 0) goto L5;
        setCustomEndView(R$layout.o_section_titlebar_custom_end_detail);
        return;
    L5:
        a(false);
    }

    public final void setDefaultTailIcon(int r5) {
        if (r5 != 0) goto L4;
        setTailIcon(getResources().getDrawable(R$drawable.o_section_titlebar_tail_icon_arrow));
        return;
    L4:
        b(false);
    }

    public final void setDetailEndText(CharSequence r5) {
        setDefaultCustomEndView(0);
        if ((getCustomEndView() instanceof OTextView) == false) goto L9;
        View r10 = getCustomEndView();
        if (r10 == null) goto L8;
        ((OTextView) r10).setText(r5);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    }

    public final void setTailIcon(Drawable r5) {
        if (r5 == null) goto L4;
        this.f14293c.setImageDrawable(r5);
        return;
    L4:
        b(false);
    }

    public final void setTitleStyle(int r5) {
        this.f14291a.setTextAppearance(r5);
    }

    public final void setTitleText(CharSequence r5) {
        this.f14291a.setText(r5);
    }

    public final void setTitleTextColor(int r5) {
        this.f14291a.setTextColor(r5);
    }

    public final void setTitleTextSize(float r5) {
        this.f14291a.setTextSize(r5);
    }

    @JvmOverloads
    public OSectionTitleBar(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OSectionTitleBar(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    public final void setTailIcon(int r5) {
        ImageView r10 = this.f14293c;
        if (r5 == 0) goto L5;
        r10.setImageResource(r5);
        return;
    L5:
        r10.setImageDrawable(null);
        b(false);
    }

    @JvmOverloads
    public OSectionTitleBar(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        setOrientation(0);
        LayoutInflater.from(r5).inflate(R$layout.o_section_title_bar, this, true);
        LinearLayout r12 = (LinearLayout) findViewById(R$id.container);
        this.f14291a = (TextView) findViewById(R$id.titleTextView);
        this.f14292b = (FrameLayout) findViewById(R$id.custom_end_container);
        this.f14293c = (ImageView) findViewById(R$id.tail_icon);
        TypedArray r13 = r5.getTheme().obtainStyledAttributes(r10, R$styleable.SectionTitleBar, 0, 0);
    L6:
        th = move-exception;
        r13.recycle();
        throw th;
    L4:
        if (r13.hasValue(R$styleable.SectionTitleBar_sectionTitle_titleText) == false) goto L9;
        setTitleText(r13.getString(R$styleable.SectionTitleBar_sectionTitle_titleText));     // Catch: Throwable -> L6
    L9:
        if (r13.hasValue(R$styleable.SectionTitleBar_sectionTitle_titleStyle) == false) goto L12;
        setTitleStyle(r13.getResourceId(R$styleable.SectionTitleBar_sectionTitle_titleStyle, R$style.OSectionTitleBar_S));     // Catch: Throwable -> L6
    L12:
        if (r13.hasValue(R$styleable.SectionTitleBar_sectionTitle_customEnd) == false) goto L15;
        setCustomEndView(r13.getResourceId(R$styleable.SectionTitleBar_sectionTitle_customEnd, 0));     // Catch: Throwable -> L6
    L15:
        if (r13.hasValue(R$styleable.SectionTitleBar_sectionTitle_defaultCustomEnd) == false) goto L18;
        setDefaultCustomEndView(r13.getInt(R$styleable.SectionTitleBar_sectionTitle_defaultCustomEnd, 0));     // Catch: Throwable -> L6
    L18:
        if (r13.hasValue(R$styleable.SectionTitleBar_sectionTitle_detailEndText) == false) goto L21;
        setDetailEndText(r13.getString(R$styleable.SectionTitleBar_sectionTitle_detailEndText));     // Catch: Throwable -> L6
    L21:
        if (r13.hasValue(R$styleable.SectionTitleBar_sectionTitle_showCustomEnd) == false) goto L24;
        a(r13.getBoolean(R$styleable.SectionTitleBar_sectionTitle_showCustomEnd, false));     // Catch: Throwable -> L6
    L24:
        if (r13.hasValue(R$styleable.SectionTitleBar_sectionTitle_tail) == false) goto L27;
        setTailIcon(r13.getResourceId(R$styleable.SectionTitleBar_sectionTitle_tail, 0));     // Catch: Throwable -> L6
    L27:
        if (r13.hasValue(R$styleable.SectionTitleBar_sectionTitle_defaultTail) == false) goto L30;
        setDefaultTailIcon(r13.getInt(R$styleable.SectionTitleBar_sectionTitle_defaultTail, 0));     // Catch: Throwable -> L6
    L30:
        if (r13.hasValue(R$styleable.SectionTitleBar_sectionTitle_showTail) == false) goto L32;
        b(r13.getBoolean(R$styleable.SectionTitleBar_sectionTitle_showTail, false));     // Catch: Throwable -> L6
    L32:
        r13.recycle();
    }

    public final void setCustomEndView(int r5) {
        FrameLayout r10 = this.f14292b;
        r10.removeAllViews();
        if (r5 != 0) goto L9;
    L6:
        a(false);
        return;
    L9:
        View.inflate(getContext(), r5, r10);     // Catch: Exception -> L8
    }
}
