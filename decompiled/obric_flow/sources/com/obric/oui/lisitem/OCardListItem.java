package com.obric.oui.lisitem;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.event.MessageIndication;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$styleable;
import com.obric.oui.checkbox.OCheckBoxLayout;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.common.style.OStateGradientDrawable;
import com.obric.oui.common.style.i;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.obric.oui.image.OImageAppIcon;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000f¢\u0006\u0004\b\u000e\u0010\u0010J\r\u0010\u0011\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0010J\u0015\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\rJ\r\u0010\u001e\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u0006¢\u0006\u0004\b \u0010\u001fJ\r\u0010!\u001a\u00020\u0001¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0001¢\u0006\u0004\b#\u0010\"J\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*J\u0015\u0010)\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0006¢\u0006\u0004\b)\u0010\rJ\u0015\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0006¢\u0006\u0004\b-\u0010\rJ\u000f\u0010.\u001a\u0004\u0018\u00010'¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106J\u0015\u00105\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0006¢\u0006\u0004\b5\u0010\rJ\u0017\u00107\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b7\u00106J\u0015\u00107\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0006¢\u0006\u0004\b7\u0010\rJ\r\u00109\u001a\u000208¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u0004\u0018\u00010;¢\u0006\u0004\b?\u0010@J\r\u0010B\u001a\u00020A¢\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010;¢\u0006\u0004\bD\u0010>J\u000f\u0010E\u001a\u0004\u0018\u00010;¢\u0006\u0004\bE\u0010@J\r\u0010F\u001a\u00020A¢\u0006\u0004\bF\u0010CJ\r\u0010H\u001a\u00020G¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\bJ\u0010*J\u0015\u0010J\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010\rJ\u0015\u0010L\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020\u0006¢\u0006\u0004\bL\u0010\rJ\u000f\u0010M\u001a\u0004\u0018\u00010'¢\u0006\u0004\bM\u0010/J\u000f\u0010N\u001a\u0004\u0018\u000100¢\u0006\u0004\bN\u00102J\u000f\u0010P\u001a\u0004\u0018\u00010O¢\u0006\u0004\bP\u0010QJ\u000f\u0010S\u001a\u0004\u0018\u00010R¢\u0006\u0004\bS\u0010TJ\u000f\u0010U\u001a\u0004\u0018\u00010A¢\u0006\u0004\bU\u0010CJ\u0017\u0010V\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\bV\u00106J\u0015\u0010V\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0006¢\u0006\u0004\bV\u0010\rJ\u0015\u0010X\u001a\u00020\u000b2\u0006\u0010W\u001a\u00020\u0006¢\u0006\u0004\bX\u0010\rJ\r\u0010Y\u001a\u000208¢\u0006\u0004\bY\u0010:J\u0015\u0010[\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u0014¢\u0006\u0004\b[\u0010\u0017J\u0015\u0010\\\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020\u0014¢\u0006\u0004\b\\\u0010\u0017J\u0017\u0010]\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b]\u0010*J\u0015\u0010]\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u0006¢\u0006\u0004\b]\u0010\rJ\r\u0010_\u001a\u00020^¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u0004\u0018\u00010'¢\u0006\u0004\ba\u0010/J\u0017\u0010d\u001a\u00020\u000b2\b\u0010c\u001a\u0004\u0018\u00010b¢\u0006\u0004\bd\u0010eJ\u0017\u0010g\u001a\u00020\u000b2\b\u0010c\u001a\u0004\u0018\u00010f¢\u0006\u0004\bg\u0010hJ\u0017\u0010j\u001a\u00020\u000b2\u0006\u0010i\u001a\u00020\u0014H\u0016¢\u0006\u0004\bj\u0010\u0017R*\u0010p\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\u000f8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010\u0012\"\u0004\bo\u0010\u0010R*\u0010s\u001a\u00020\u00142\u0006\u0010k\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010\u001b\"\u0004\bt\u0010\u0017¨\u0006u"}, d2 = {"Lcom/obric/oui/lisitem/OCardListItem;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "color", "", "setBgColor", "(I)V", "setContentColor", "Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "getContentColor", "()Landroid/content/res/ColorStateList;", "setContentMarkColor", "", "checked", "setContentChecked", "(Z)V", Constant.ClientMessageType.SHOW, "setShowCardBg", "getShowCardBg", "()Z", "type", "setCardType", "getCardType", "()I", "getCardPosition", "getCardRoot", "()Landroid/widget/FrameLayout;", "getCardContainer", "Lcom/obric/oui/lisitem/OUICardConstraintLayout;", "getContentContainer", "()Lcom/obric/oui/lisitem/OUICardConstraintLayout;", "Landroid/view/View;", "view", "setCustomStartView", "(Landroid/view/View;)V", "resId", "defaultCustomStart", "setDefaultCustomStartView", "getCustomStartView", "()Landroid/view/View;", "Lcom/obric/oui/checkbox/OCheckBoxLayout;", "getStartCheckBox", "()Lcom/obric/oui/checkbox/OCheckBoxLayout;", "Landroid/graphics/drawable/Drawable;", "drawable", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "setAppIcon", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "", MessageIndication.CONTENT_TYPE_TEXT, "setTitle", "(Ljava/lang/CharSequence;)V", "getTitle", "()Ljava/lang/CharSequence;", "Lcom/obric/oui/text/OTextView;", "getTitleView", "()Lcom/obric/oui/text/OTextView;", "setSubTitle", "getSubTitle", "getSubTitleView", "Landroid/widget/LinearLayout;", "getTitleContainer", "()Landroid/widget/LinearLayout;", "setCustomEndView", "defaultCustomEnd", "setDefaultCustomEndView", "getCustomEndView", "getEndCheckBox", "Lcom/obric/oui/oswitch/OSwitch;", "getEndSwitch", "()Lcom/obric/oui/oswitch/OSwitch;", "Lcom/obric/oui/checkbox/OCheckMark;", "getEndMark", "()Lcom/obric/oui/checkbox/OCheckMark;", "getEndDetail", "setTailIcon", "defaultTailIcon", "setDefaultTailIcon", "getTailIconView", "enable", "setEnableSwipeDivider", "setEnableSwipe", "setSwipeView", "Lcom/obric/oui/swipeaction/OSwipeLayout;", "getSwipeLayout", "()Lcom/obric/oui/swipeaction/OSwipeLayout;", "getSwipeView", "Landroid/view/View$OnClickListener;", "listener", "setOnContentClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnLongClickListener;", "setOnContentLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "enabled", "setEnabled", "value", "G", "Landroid/content/res/ColorStateList;", "getContentContainerBgColor", "setContentContainerBgColor", "contentContainerBgColor", "H", "Z", "isMark", "setMark", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OCardListItem extends FrameLayout {
    public static final /* synthetic */ int I = 0;
    public int A;
    public boolean B;
    public int C;
    public int D;
    public int E;
    public int F;
    public ColorStateList G;
    public boolean H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f13541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13543c;
    public final FrameLayout d;
    public final OUIFrameLayout e;
    public final OUICardConstraintLayout f;
    public final OStateGradientDrawable g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ColorStateList f13544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ColorStateList f13545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f13546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FrameLayout f13547k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ImageView f13548l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public OImageAppIcon f13549m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinearLayout f13550n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OTextView f13551o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f13552p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final OTextView f13553q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f13554r;
    public final FrameLayout s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ImageView f13555t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final View f13556u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.ai.widget.contianer.c f13557v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f13558w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f13559x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final OSwipeLayout f13560y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final FrameLayout f13561z;

    @JvmOverloads
    public OCardListItem(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public static void c(View r5, boolean r10) {
        if ((r5 instanceof ViewGroup) == false) goto L7;
        ViewGroup r11 = (ViewGroup) r5;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L9;
        int r14 = r13 + 1;
        View r15 = r11.getChildAt(r13);
        r15.setEnabled(r10);
        c(r15, r10);
        r13 = r14;
        goto L5
    L9:
        return;
    }

    public static void h(OCardListItem r10, int r11) {
        if (r11 != 1) goto L5;
        boolean r5 = true;
    L6:
        int r12 = r10.F;
        LinearLayout r13 = r10.f13550n;
        if (r12 != r11) goto L19;
        if (r12 != 1) goto L14;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        if (r14 == null) goto L13;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        ((ViewGroup.MarginLayoutParams) r15).width = 0;
        r15.W = false;
        r15.L = 0;
        r13.setLayoutParams(r15);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L14:
        ViewGroup.LayoutParams r16 = r13.getLayoutParams();
        if (r16 == null) goto L18;
        ConstraintLayout.LayoutParams r17 = (ConstraintLayout.LayoutParams) r16;
        ((ViewGroup.MarginLayoutParams) r17).width = -2;
        r17.W = true;
        r17.L = 1;
        r13.setLayoutParams(r17);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L19:
        if (r12 < 0) goto L25;
        if (r12 == r11) goto L25;
        View r18 = r13.findViewById(R$id.custom_title_container);
        if (r18 == null) goto L25;
        r13.removeView(r18);
    L25:
        r10.F = r11;
        if (r11 == 0) goto L38;
        if (r11 == 1) goto L37;
        r10.F = -1;
        View r19 = r13.findViewById(R$id.custom_title_container);
        if (r19 == null) goto L32;
        r13.removeView(r19);
    L32:
        ViewGroup.LayoutParams r20 = r13.getLayoutParams();
        if (r20 == null) goto L36;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
        ((ViewGroup.MarginLayoutParams) r21).width = -2;
        r21.W = true;
        r21.L = 1;
        r13.setLayoutParams(r21);
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L37:
        r10.g(R$layout.o_card_list_item_custom_title_detail, r5);
        return;
    L38:
        r10.g(R$layout.o_card_list_item_custom_title_icon, r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public static void i(OCardListItem r5, CharSequence r10) {
        r5.getClass();
        r5.E = com.lynx.tasm.utils.a.B(168, r5);
        if ((r5.getCustomEndView() instanceof OTextView) == false) goto L9;
        View r11 = r5.getCustomEndView();
        if (r11 == null) goto L8;
        ((OTextView) r11).setText(r10);
    L16:
        r5.e();
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L9:
        r5.setDefaultCustomEndView(3);
        if ((r5.getCustomEndView() instanceof OTextView) == false) goto L16;
        View r12 = r5.getCustomEndView();
        if (r12 == null) goto L15;
        ((OTextView) r12).setText(r10);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    }

    public final void a() {
        int r5 = R$id.o_list_item_app_icon;
        FrameLayout r10 = this.f13547k;
        OImageAppIcon r11 = (OImageAppIcon) r10.findViewById(r5);
        this.f13549m = r11;
        int r12 = 0;
        if (r11 != null) goto L5;
        AttributeSet r13 = null;
        OImageAppIcon r14 = new OImageAppIcon(getContext(), r13, 6, r12);
        r14.setId(R$id.o_list_item_app_icon);
        r14.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f13549m = r14;
        r10.addView(r14);
        return;
    L5:
        r11.setVisibility(0);
    }

    public final void b() {
        OUICardConstraintLayout r5 = this.f;
        if (r5.hasOnClickListeners() == false) goto L5;
    L8:
        r5.setBackground(this.g);
        return;
    L5:
        if (r5.hasOnLongClickListeners() == true) goto L8;
        r5.setBackground(null);
    }

    public final void d() {
        if (this.f13542b == false) goto L5;
        int r5 = com.lynx.tasm.utils.a.B(12, this);
    L6:
        OStateGradientDrawable r10 = this.g;
        if (r10 == null) goto L10;
        r10.setSolidColors(getContentContainerBgColor());
    L10:
        if (r10 == null) goto L13;
        r10.setCornerRadius(r5);
    L13:
        b();
        if (this.f13542b == false) goto L16;
        int r11 = com.lynx.tasm.utils.a.B(12, this);
    L17:
        boolean r12 = this.f13542b;
        if (r12 == false) goto L20;
        int r13 = r11;
    L21:
        if (r12 == true) goto L24;
        r11 = 0;
    L24:
        i r14 = this.f13560y.f13532b;
        r14.E = r13;
        r14.F = 0;
        r14.G = r11;
        r14.H = 0;
        r14.E(r14.U, r14.C, r14.T);
        if (this.f13556u.getVisibility() != 0) goto L28;
        m();
        return;
    L28:
        return;
    L20:
        r13 = 0;
        goto L21
    L16:
        r11 = com.lynx.tasm.utils.a.B(20, this);
        goto L17
    L5:
        r5 = com.lynx.tasm.utils.a.B(20, this);
        goto L6
    }

    public final void e() {
        FrameLayout r5 = this.s;
        if (r5.getVisibility() != 0) goto L39;
        View r10 = getCustomEndView();
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        ViewGroup.MarginLayoutParams r12 = null;
        if ((r11 instanceof ConstraintLayout.LayoutParams) == false) goto L7;
        ConstraintLayout.LayoutParams r13 = (ConstraintLayout.LayoutParams) r11;
    L8:
        if (r10 == null) goto L18;
        if ((r10.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L18;
        ViewGroup.LayoutParams r14 = r10.getLayoutParams();
        if (r14 == null) goto L16;
        ((FrameLayout.LayoutParams) r14).gravity = GravityCompat.END;
        goto L18
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L18:
        if ((r10 instanceof OTextView) == false) goto L36;
        OTextView r15 = (OTextView) r10;
        if (TextUtils.isEmpty(r15.getText()) == true) goto L36;
        if (r13 == null) goto L24;
        r13.P = this.E;
    L24:
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        r12 = (ViewGroup.MarginLayoutParams) r16;
    L27:
        if (r12 == null) goto L35;
        int r17 = r12.leftMargin;
        int r18 = r12.topMargin;
        if (this.f13555t.getVisibility() != 0) goto L33;
        int r19 = 0;
    L34:
        r12.setMargins(r17, r18, com.lynx.tasm.utils.a.B(r19, this), r12.bottomMargin);
        goto L35
    L33:
        r19 = 6;
    L35:
        r15.setLayoutParams(r12);
        return;
    L36:
        if (r13 == null) goto L47;
        r13.P = -2;
        return;
    L47:
        return;
    L7:
        r13 = null;
        goto L8
    L39:
        ViewGroup.LayoutParams r20 = r5.getLayoutParams();
        if (r20 == null) goto L44;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
        r21.P = -2;
        r5.setLayoutParams(r21);
        return;
    L44:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void f() {
        int r5 = this.f13546j.getVisibility();
        LinearLayout r10 = this.f13550n;
        if (r5 == 8) goto L8;
        if ((getCustomStartView() instanceof OCheckBoxLayout) == true) goto L8;
    L10:
        r10.setPadding(0, r10.getPaddingTop(), r10.getPaddingRight(), r10.getPaddingBottom());
    L12:
        if (this.f13556u.getVisibility() != 0) goto L14;
        m();
    L14:
        requestLayout();
        return;
    L8:
        if (this.f13547k.getVisibility() != 8) goto L10;
        r10.setPadding(com.lynx.tasm.utils.a.B(12, this), r10.getPaddingTop(), r10.getPaddingRight(), r10.getPaddingBottom());
        goto L12
    }

    public final void g(int r5, boolean r10) {
        ViewGroup r11 = this.f13550n;
        if (r5 != 0) goto L18;
        return;
    L18:
        int r12 = 0;
        View r13 = LayoutInflater.from(getContext()).inflate(r5, r11, false);     // Catch: Exception -> L17
        if (r13 == null) goto L7;
        r11.addView(r13, 0);     // Catch: Exception -> L17
    L7:
        ViewGroup.LayoutParams r14 = r11.getLayoutParams();     // Catch: Exception -> L17
        if (r14 == null) goto L15;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;     // Catch: Exception -> L17
        if (r10 == true) goto L13;
        r12 = -2;
    L13:
        ((ViewGroup.MarginLayoutParams) r15).width = r12;     // Catch: Exception -> L17
        boolean r16 = !r10;     // Catch: Exception -> L17
        r15.W = r16;     // Catch: Exception -> L17
        r15.L = r16 ? 1 : 0;     // Catch: Exception -> L17
        r11.setLayoutParams(r15);     // Catch: Exception -> L17
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");     // Catch: Exception -> L17
    }

    public final FrameLayout getCardContainer() {
        return this.e;
    }

    public final int getCardPosition() {
        return this.C;
    }

    public final FrameLayout getCardRoot() {
        return this.d;
    }

    public final int getCardType() {
        return this.D;
    }

    public final ColorStateList getContentColor() {
        return getContentContainerBgColor();
    }

    public final OUICardConstraintLayout getContentContainer() {
        return this.f;
    }

    public final ColorStateList getContentContainerBgColor() {
        return this.G;
    }

    public final View getCustomEndView() {
        FrameLayout r5 = this.s;
        if (r5.getChildCount() != 0) goto L5;
        return null;
    L5:
        return r5.getChildAt(0);
    }

    public final View getCustomStartView() {
        FrameLayout r5 = this.f13546j;
        if (r5.getChildCount() != 0) goto L5;
        return null;
    L5:
        return r5.getChildAt(0);
    }

    public final OCheckBoxLayout getEndCheckBox() {
        if ((getCustomEndView() instanceof OCheckBoxLayout) == false) goto L10;
        View r5 = getCustomEndView();
        if (r5 == null) goto L9;
        return (OCheckBoxLayout) r5;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
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

    public final OCheckMark getEndMark() {
        if ((getCustomEndView() instanceof OCheckMark) == false) goto L10;
        View r5 = getCustomEndView();
        if (r5 == null) goto L9;
        return (OCheckMark) r5;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckMark");
    L10:
        return null;
    }

    public final OSwitch getEndSwitch() {
        if ((getCustomEndView() instanceof OSwitch) == false) goto L10;
        View r5 = getCustomEndView();
        if (r5 == null) goto L9;
        return (OSwitch) r5;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.oswitch.OSwitch");
    L10:
        return null;
    }

    public final ImageView getIconView() {
        return this.f13548l;
    }

    public final boolean getShowCardBg() {
        return this.f13542b;
    }

    public final OCheckBoxLayout getStartCheckBox() {
        if ((getCustomStartView() instanceof OCheckBoxLayout) == false) goto L10;
        View r5 = getCustomStartView();
        if (r5 == null) goto L9;
        return (OCheckBoxLayout) r5;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.checkbox.OCheckBoxLayout");
    L10:
        return null;
    }

    public final CharSequence getSubTitle() {
        return this.f13553q.getText();
    }

    public final OTextView getSubTitleView() {
        return this.f13553q;
    }

    public final OSwipeLayout getSwipeLayout() {
        return this.f13560y;
    }

    public final View getSwipeView() {
        FrameLayout r5 = this.f13561z;
        if (r5.getChildCount() != 0) goto L5;
        return null;
    L5:
        return r5.getChildAt(0);
    }

    public final ImageView getTailIconView() {
        return this.f13555t;
    }

    public final CharSequence getTitle() {
        return this.f13551o.getText();
    }

    public final LinearLayout getTitleContainer() {
        return this.f13550n;
    }

    public final OTextView getTitleView() {
        return this.f13551o;
    }

    public final void j(boolean r5) {
        if (r5 == false) goto L4;
        int r10 = 0;
    L5:
        this.s.setVisibility(r10);
        e();
        return;
    L4:
        r10 = 8;
        goto L5
    }

    public final void k(boolean r5) {
        if (r5 == false) goto L4;
        int r10 = 0;
    L5:
        View r11 = this.f13556u;
        r11.setVisibility(r10);
        if (r5 == true) goto L8;
        return;
    L8:
        if (this.B == false) goto L10;
        float r12 = this.A;
    L11:
        r11.setTranslationX(r12);
        m();
        return;
    L10:
        r12 = 0.0f;
        goto L11
    L4:
        r10 = 8;
        goto L5
    }

    public final void l(boolean r5) {
        if (r5 == false) goto L4;
        int r10 = 0;
    L5:
        this.f13555t.setVisibility(r10);
        e();
        return;
    L4:
        r10 = 8;
        goto L5
    }

    public final void m() {
        a r5 = new a(this, 0);
        this.f13556u.post(r5);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        OStateGradientDrawable r5 = this.g;
        if (r5 == null) goto L6;
        r5.endAnimation();
    L6:
        com.bytedance.ai.widget.contianer.c r10 = this.f13557v;
        this.f13546j.addOnLayoutChangeListener(r10);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        this.E = com.lynx.tasm.utils.a.B(168, this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.ai.widget.contianer.c r5 = this.f13557v;
        this.f13546j.removeOnLayoutChangeListener(r5);
    }

    public final void setAppIcon(Drawable r5) {
        this.f13548l.setVisibility(8);
        a();
        if (r5 == null) goto L8;
        OImageAppIcon r10 = this.f13549m;
        if (r10 == null) goto L13;
        r10.setImageDrawable(r5);
    L13:
        if (this.f13556u.getVisibility() != 0) goto L16;
        m();
        return;
    L16:
        return;
    L8:
        OImageAppIcon r11 = this.f13549m;
        if (r11 == null) goto L13;
        r11.setImageDrawable(null);
        goto L13
    }

    public final void setBgColor(int r5) {
        c r10 = this.f13541a;
        r10.d = r5;
        boolean r11 = r10.f13603c;
        r10.a(r10.e, r11, false);
    }

    @JvmOverloads
    public final void setCardPosition(int r5) {
        this.C = r5;
        c r10 = this.f13541a;
        r10.a(r5, r10.f13603c, false);
    }

    public final void setCardType(int r10) {
        this.D = r10;
        FrameLayout r5 = this.f13546j;
        LinearLayout r11 = this.f13550n;
        FrameLayout r12 = this.f13547k;
        OUICardConstraintLayout r13 = this.f;
        if (r10 == 0) goto L18;
        if (r10 != 1) goto L6;
        r13.setPaddingRelative(0, 0, com.lynx.tasm.utils.a.B(4, this), 0);
        r13.setMinimumHeight(com.lynx.tasm.utils.a.B(60, this));
        r11.setVisibility(0);
        ViewGroup.LayoutParams r14 = r5.getLayoutParams();
        if (r14 == null) goto L17;
        ConstraintLayout.LayoutParams r15 = (ConstraintLayout.LayoutParams) r14;
        ((ViewGroup.MarginLayoutParams) r15).width = -2;
        r5.setLayoutParams(r15);
        ViewGroup.LayoutParams r16 = r12.getLayoutParams();
        r16.width = com.lynx.tasm.utils.a.B(60, this);
        r16.height = com.lynx.tasm.utils.a.B(60, this);
        r12.setLayoutParams(r16);
        r12.setPadding(com.lynx.tasm.utils.a.B(12, this), com.lynx.tasm.utils.a.B(12, this), com.lynx.tasm.utils.a.B(12, this), com.lynx.tasm.utils.a.B(12, this));
    L21:
        ImageView r17 = this.f13548l;
        r17.setClipToOutline(true);
        r17.setOutlineProvider(new br.c(this, 6));
        r17.invalidateOutline();
        if (this.f13556u.getVisibility() != 0) goto L27;
        m();
        return;
    L27:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L6:
        if (r10 != 2) goto L21;
        r13.setPaddingRelative(0, 0, 0, 0);
        r13.setMinimumHeight(0);
        r11.setVisibility(8);
        ViewGroup.LayoutParams r18 = r5.getLayoutParams();
        if (r18 == null) goto L12;
        ConstraintLayout.LayoutParams r19 = (ConstraintLayout.LayoutParams) r18;
        ((ViewGroup.MarginLayoutParams) r19).width = -1;
        r5.setLayoutParams(r19);
        r5.setVisibility(0);
        f();
        goto L21
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L18:
        r13.setPaddingRelative(0, 0, com.lynx.tasm.utils.a.B(4, this), 0);
        r13.setMinimumHeight(com.lynx.tasm.utils.a.B(48, this));
        r11.setVisibility(0);
        ViewGroup.LayoutParams r20 = r5.getLayoutParams();
        if (r20 == null) goto L26;
        ConstraintLayout.LayoutParams r21 = (ConstraintLayout.LayoutParams) r20;
        ((ViewGroup.MarginLayoutParams) r21).width = -2;
        r5.setLayoutParams(r21);
        ViewGroup.LayoutParams r22 = r12.getLayoutParams();
        r22.width = com.lynx.tasm.utils.a.B(48, this);
        r22.height = com.lynx.tasm.utils.a.B(48, this);
        r12.setLayoutParams(r22);
        r12.setPadding(com.lynx.tasm.utils.a.B(10, this), com.lynx.tasm.utils.a.B(10, this), com.lynx.tasm.utils.a.B(10, this), com.lynx.tasm.utils.a.B(10, this));
        goto L21
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    public final void setContentChecked(boolean r5) {
        OUICardConstraintLayout r10 = this.f;
        if (r5 == false) goto L10;
        r10.setSelected(true);
        if (getContentContainerBgColor().isStateful() == true) goto L12;
        OStateGradientDrawable r11 = this.g;
        if (r11 == null) goto L14;
        r11.setColor(getResources().getColor(R$color.oui_state_overlay_pressed));
        return;
    L14:
        return;
    L12:
        return;
    L10:
        r10.setSelected(false);
    }

    public final void setContentColor(int r5) {
        setContentColor(ColorStateList.valueOf(r5));
    }

    public final void setContentContainerBgColor(ColorStateList r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        if (Intrinsics.areEqual(this.G, r5) == true) goto L9;
        this.G = r5;
        OStateGradientDrawable r10 = this.g;
        if (r10 == null) goto L10;
        r10.setSolidColors(r5);
        return;
    L10:
        return;
    }

    public final void setContentMarkColor(ColorStateList r5) {
        this.f13545i = r5;
        if (r5 != null) goto L6;
        setContentContainerBgColor(this.f13544h);
        return;
    }

    public final void setCustomEndView(View r5) {
        FrameLayout r10 = this.s;
        r10.removeAllViews();
        if (r5 != null) goto L6;
    L13:
        e();
        return;
    L6:
        if ((r5.getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r11 = r5.getParent();
        if (r11 == null) goto L11;
        ((ViewGroup) r11).removeView(r5);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L12:
        r10.addView(r5);
        goto L13
    }

    public final void setCustomStartView(View r5) {
        FrameLayout r10 = this.f13546j;
        r10.removeAllViews();
        if (r5 == null) goto L6;
        r10.addView(r5);
    L6:
        if (this.f13556u.getVisibility() != 0) goto L9;
        m();
        return;
    }

    public final void setDefaultCustomEndView(int r5) {
        this.s.removeAllViews();
        if (r5 != 0) goto L5;
        setCustomEndView(R$layout.o_card_list_item_custom_end_checkbox);
        return;
    L5:
        if (r5 != 1) goto L7;
        setCustomEndView(R$layout.o_card_list_item_custom_end_switch);
        return;
    L7:
        if (r5 != 2) goto L9;
        setCustomEndView(R$layout.o_card_list_item_custom_end_mark);
        return;
    L9:
        if (r5 != 3) goto L11;
        setCustomEndView(R$layout.o_card_list_item_custom_end_detail);
        return;
    L11:
        if (r5 == 4) goto L13;
        setCustomEndView(null);
        return;
    L13:
        setCustomEndView(R$layout.o_card_list_item_custom_end_handle);
    }

    public final void setDefaultCustomStartView(int r5) {
        this.f13546j.removeAllViews();
        if (r5 != 0) goto L6;
        setCustomStartView(R$layout.o_card_list_item_custom_start_checkbox);
    L6:
        if (this.f13556u.getVisibility() != 0) goto L9;
        m();
        return;
    }

    public final void setDefaultTailIcon(int r5) {
        if (r5 != 0) goto L4;
        setTailIcon(getResources().getDrawable(R$drawable.o_card_list_item_tail_icon_arrow));
        return;
    L4:
        if (r5 != 1) goto L10;
        setTailIcon(getResources().getDrawable(R$drawable.o_card_list_item_tail_icon_chevron));
        return;
    }

    public final void setEnableSwipe(boolean r5) {
        this.f13560y.setSwipeEnabled(r5);
        if (r5 == false) goto L5;
        int r10 = 0;
    L6:
        this.f13561z.setVisibility(r10);
        return;
    L5:
        r10 = 8;
        goto L6
    }

    public final void setEnableSwipeDivider(boolean r5) {
        this.B = r5;
        View r10 = this.f13556u;
        if (r10.getVisibility() == 0) goto L5;
        return;
    L5:
        if (this.B == false) goto L7;
        float r11 = this.A;
    L8:
        r10.setTranslationX(r11);
        return;
    L7:
        r11 = 0.0f;
        goto L8
    }

    @Override // android.view.View
    public void setEnabled(boolean r5) {
        super.setEnabled(r5);
        this.f.setEnabled(r5);
        FrameLayout r10 = this.f13546j;
        r10.setEnabled(r5);
        this.f13547k.setEnabled(r5);
        this.f13548l.setEnabled(r5);
        OImageAppIcon r11 = this.f13549m;
        if (r11 == null) goto L6;
        r11.setEnabled(r5);
    L6:
        this.f13550n.setEnabled(r5);
        this.f13551o.setEnabled(r5);
        this.f13553q.setEnabled(r5);
        FrameLayout r12 = this.s;
        r12.setEnabled(r5);
        this.f13555t.setEnabled(r5);
        this.f13560y.setEnabled(r5);
        c(r10, r5);
        c(r12, r5);
        c(this.f13561z, r5);
    }

    @JvmOverloads
    public final void setEndDetailText(CharSequence r5) {
        i(this, r5);
    }

    public final void setIcon(Drawable r5) {
        ImageView r10 = this.f13548l;
        r10.setVisibility(0);
        OImageAppIcon r11 = this.f13549m;
        if (r11 == null) goto L6;
        r11.setVisibility(8);
    L6:
        if (r5 == null) goto L8;
        r10.setImageDrawable(r5);
    L10:
        if (this.f13556u.getVisibility() != 0) goto L13;
        m();
        return;
    L13:
        return;
    L8:
        r10.setImageDrawable(null);
        goto L10
    }

    public final void setMark(boolean r5) {
        if (this.H == r5) goto L12;
        this.H = r5;
        if (r5 == false) goto L10;
        ColorStateList r10 = this.f13545i;
        if (r10 == null) goto L14;
        setContentContainerBgColor(r10);
        return;
    L14:
        return;
    L10:
        setContentContainerBgColor(this.f13544h);
        return;
    }

    public final void setOnContentClickListener(View.OnClickListener r5) {
        this.f.setOnClickListener(r5);
        b();
    }

    public final void setOnContentLongClickListener(View.OnLongClickListener r5) {
        this.f.setOnLongClickListener(r5);
        b();
    }

    public final void setShowCardBg(boolean r5) {
        this.f13542b = r5;
        d();
        boolean r10 = this.f13542b;
        c r11 = this.f13541a;
        r11.a(r11.e, r10, false);
    }

    public final void setSubTitle(CharSequence r5) {
        this.f13553q.setText(r5);
    }

    public final void setSwipeView(View r5) {
        FrameLayout r10 = this.f13561z;
        r10.removeAllViews();
        if (r5 == null) goto L6;
        r10.addView(r5);
        return;
    }

    public final void setTailIcon(Drawable r5) {
        if (r5 == null) goto L5;
        this.f13555t.setImageDrawable(r5);
        return;
    }

    public final void setTitle(CharSequence r5) {
        this.f13551o.setText(r5);
    }

    @JvmOverloads
    public OCardListItem(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public final void setContentColor(ColorStateList r5) {
        Intrinsics.checkNotNullParameter(r5, "color");
        setContentContainerBgColor(r5);
    }

    public final void setTailIcon(int r5) {
        ImageView r10 = this.f13555t;
        if (r5 == 0) goto L5;
        r10.setImageResource(r5);
        return;
    L5:
        r10.setImageDrawable(null);
    }

    public /* synthetic */ OCardListItem(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    public final void setSwipeView(int r5) {
        FrameLayout r10 = this.f13561z;
        r10.removeAllViews();
        if (r5 == 0) goto L9;
        View.inflate(getContext(), r5, r10);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @JvmOverloads
    public OCardListItem(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f13542b = true;
        this.f13543c = getResources().getColor(R$color.oui_fill_list_item_card);
        this.g = new OStateGradientDrawable();
        this.f13544h = getResources().getColorStateList(R$color.o_card_list_item_content_bg_color);
        this.f13552p = getResources().getColor(R$color.oui_basic_text_1);
        this.f13554r = getResources().getColor(R$color.oui_basic_text_3);
        this.f13558w = -1;
        this.f13559x = -1;
        this.B = true;
        this.F = -1;
        this.G = this.f13544h;
        this.E = com.lynx.tasm.utils.a.B(168, this);
        setClipChildren(false);
        setClipToPadding(false);
        if (getLayoutParams() != null) goto L5;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    L5:
        View r13 = LayoutInflater.from(r10).inflate(R$layout.o_card_list_item_layout, this, true);
        if (r13 == null) goto L113;
        FrameLayout r14 = (FrameLayout) r13;
        FrameLayout r15 = (FrameLayout) findViewById(R$id.card_list_item_root);
        this.d = r15;
        r15.setClickable(true);
        OUIFrameLayout r16 = (OUIFrameLayout) findViewById(R$id.card_container);
        this.e = r16;
        r16.setChangeAlphaWhenPress(false);
        r16.setChangeAlphaWhenDisable(false);
        OUICardConstraintLayout r5 = (OUICardConstraintLayout) findViewById(R$id.content_container);
        this.f = r5;
        r5.setChangeAlphaWhenPress(false);
        r5.setChangeAlphaWhenDisable(true);
        FrameLayout r17 = (FrameLayout) findViewById(R$id.custom_start_container);
        this.f13546j = r17;
        FrameLayout r18 = (FrameLayout) findViewById(R$id.icon_container);
        this.f13547k = r18;
        this.f13548l = (ImageView) findViewById(R$id.icon);
        this.f13550n = (LinearLayout) findViewById(R$id.title_container);
        OTextView r19 = (OTextView) findViewById(R$id.title);
        this.f13551o = r19;
        OTextView r20 = (OTextView) findViewById(R$id.sub_title);
        this.f13553q = r20;
        this.s = (FrameLayout) findViewById(R$id.custom_end_container);
        this.f13555t = (ImageView) findViewById(R$id.tail_icon);
        this.f13556u = findViewById(R$id.card_divider);
        this.f13557v = new com.bytedance.ai.widget.contianer.c(this, 4);
        OSwipeLayout r21 = (OSwipeLayout) findViewById(R$id.swipe_layout);
        this.f13560y = r21;
        r21.setChangeAlphaWhenPress(false);
        r21.setChangeAlphaWhenDisable(false);
        r21.setSwipeEnabled(false);
        r21.f14599p.add(new b(this));
        this.f13561z = (FrameLayout) findViewById(R$id.swip_container);
        if (r11 == null) goto L108;
        TypedArray r22 = getContext().obtainStyledAttributes(r11, R$styleable.OCardListItemContainer);
    L14:
        th = move-exception;
        r22.recycle();
        throw th;
    L12:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_showCardBg) == false) goto L16;
        this.f13542b = r22.getBoolean(R$styleable.OCardListItemContainer_ocardlistitem_showCardBg, true);     // Catch: Throwable -> L14
    L16:
        this.f13543c = r22.getColor(R$styleable.OCardListItemContainer_ocardlistitem_bgColor, getResources().getColor(R$color.oui_fill_list_item_card));     // Catch: Throwable -> L14
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_contentColorList) == false) goto L23;
        ColorStateList r110 = r22.getColorStateList(R$styleable.OCardListItemContainer_ocardlistitem_contentColorList);     // Catch: Throwable -> L14
        if (r110 != null) goto L21;
        r110 = getResources().getColorStateList(R$color.o_card_list_item_content_bg_color);     // Catch: Throwable -> L14
    L21:
        this.f13544h = r110;     // Catch: Throwable -> L14
        setContentContainerBgColor(r110);     // Catch: Throwable -> L14
    L23:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_cardType) == false) goto L26;
        this.D = r22.getInt(R$styleable.OCardListItemContainer_ocardlistitem_cardType, 0);     // Catch: Throwable -> L14
    L26:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_cardPosition) == false) goto L29;
        this.C = r22.getInt(R$styleable.OCardListItemContainer_ocardlistitem_cardPosition, 0);     // Catch: Throwable -> L14
    L29:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_customStart) == false) goto L32;
        setCustomStartView(r22.getResourceId(R$styleable.OCardListItemContainer_ocardlistitem_customStart, 0));     // Catch: Throwable -> L14
    L32:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_defaultCustomStart) == false) goto L35;
        setDefaultCustomStartView(r22.getInt(R$styleable.OCardListItemContainer_ocardlistitem_defaultCustomStart, 0));     // Catch: Throwable -> L14
    L35:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_icon) == false) goto L38;
        setIcon(r22.getResourceId(R$styleable.OCardListItemContainer_ocardlistitem_icon, 0));     // Catch: Throwable -> L14
    L38:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_title) == false) goto L40;
        setTitle(r22.getString(R$styleable.OCardListItemContainer_ocardlistitem_title));     // Catch: Throwable -> L14
    L40:
        this.f13552p = r22.getColor(R$styleable.OCardListItemContainer_ocardlistitem_titleColor, getResources().getColor(R$color.oui_basic_text_1));     // Catch: Throwable -> L14
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_subTitle) == false) goto L43;
        setSubTitle(r22.getString(R$styleable.OCardListItemContainer_ocardlistitem_subTitle));     // Catch: Throwable -> L14
    L43:
        this.f13554r = r22.getColor(R$styleable.OCardListItemContainer_ocardlistitem_subTitleColor, getResources().getColor(R$color.oui_basic_text_3));     // Catch: Throwable -> L14
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_defaultCustomTitle) == false) goto L47;
        h(this, r22.getInt(R$styleable.OCardListItemContainer_ocardlistitem_defaultCustomTitle, 0));     // Catch: Throwable -> L14
    L47:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_customEnd) == false) goto L50;
        setCustomEndView(r22.getResourceId(R$styleable.OCardListItemContainer_ocardlistitem_customEnd, 0));     // Catch: Throwable -> L14
    L50:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_defaultCustomEnd) == false) goto L53;
        setDefaultCustomEndView(r22.getInt(R$styleable.OCardListItemContainer_ocardlistitem_defaultCustomEnd, 0));     // Catch: Throwable -> L14
    L53:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_endDetailText) == false) goto L56;
        i(this, r22.getString(R$styleable.OCardListItemContainer_ocardlistitem_endDetailText));     // Catch: Throwable -> L14
    L56:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_tailIcon) == false) goto L59;
        setTailIcon(r22.getResourceId(R$styleable.OCardListItemContainer_ocardlistitem_tailIcon, 0));     // Catch: Throwable -> L14
    L59:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_defaultTailIcon) == false) goto L61;
        setDefaultTailIcon(r22.getInt(R$styleable.OCardListItemContainer_ocardlistitem_defaultTailIcon, 0));     // Catch: Throwable -> L14
    L61:
        int r23 = 8;
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_showCustomStart) == false) goto L69;
        if (r22.getBoolean(R$styleable.OCardListItemContainer_ocardlistitem_showCustomStart, false) == false) goto L66;
        int r111 = 0;
    L67:
        r17.setVisibility(r111);     // Catch: Throwable -> L14
        f();     // Catch: Throwable -> L14
        goto L69
    L66:
        r111 = 8;
    L69:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_showIcon) == false) goto L76;
        if (r22.getBoolean(R$styleable.OCardListItemContainer_ocardlistitem_showIcon, false) == false) goto L73;
        int r112 = 0;
    L74:
        r18.setVisibility(r112);     // Catch: Throwable -> L14
        f();     // Catch: Throwable -> L14
        goto L76
    L73:
        r112 = 8;
    L76:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_showTitle) == false) goto L88;
        boolean r113 = r22.getBoolean(R$styleable.OCardListItemContainer_ocardlistitem_showTitle, false);     // Catch: Throwable -> L14
        CharSequence r24 = getTitle();     // Catch: Throwable -> L14
        if (r24 != null) goto L80;
    L86:
        r19.setVisibility(8);     // Catch: Throwable -> L14
        goto L88
    L80:
        if (r24.length() == 0) goto L86;
        if (r113 == false) goto L84;
        int r114 = 0;
    L85:
        r19.setVisibility(r114);     // Catch: Throwable -> L14
        goto L88
    L84:
        r114 = 8;
    L88:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_showSubTitle) == false) goto L99;
        boolean r115 = r22.getBoolean(R$styleable.OCardListItemContainer_ocardlistitem_showSubTitle, false);     // Catch: Throwable -> L14
        CharSequence r25 = getSubTitle();     // Catch: Throwable -> L14
        if (r25 != null) goto L92;
    L97:
        r20.setVisibility(8);     // Catch: Throwable -> L14
        goto L99
    L92:
        if (r25.length() == 0) goto L97;
        if (r115 == false) goto L96;
        r23 = 0;
    L96:
        r20.setVisibility(r23);     // Catch: Throwable -> L14
    L99:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_showCustomEnd) == false) goto L102;
        j(r22.getBoolean(R$styleable.OCardListItemContainer_ocardlistitem_showCustomEnd, false));     // Catch: Throwable -> L14
    L102:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_showTailIcon) == false) goto L105;
        l(r22.getBoolean(R$styleable.OCardListItemContainer_ocardlistitem_showTailIcon, false));     // Catch: Throwable -> L14
    L105:
        if (r22.hasValue(R$styleable.OCardListItemContainer_ocardlistitem_showDivider) == false) goto L107;
        k(r22.getBoolean(R$styleable.OCardListItemContainer_ocardlistitem_showDivider, false));     // Catch: Throwable -> L14
    L107:
        r22.recycle();
    L108:
        d();
        setCardType(this.D);
        int r26 = this.f13552p;
        int r116 = this.f13554r;
        this.f13552p = r26;
        this.f13554r = r116;
        r19.setTextColor(r26);
        r20.setTextColor(this.f13554r);
        this.f13541a = new c(r16, this.f13542b, this.f13543c, this.C);
        return;
    L113:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final void setCustomEndView(int r5) {
        FrameLayout r10 = this.s;
        r10.removeAllViews();
        if (r5 != 0) goto L8;
    L5:
        e();
        return;
    L8:
        View.inflate(getContext(), r5, r10);     // Catch: Exception -> L7
        goto L5
    }

    public final void setCustomStartView(int r5) {
        FrameLayout r10 = this.f13546j;
        r10.removeAllViews();
        if (r5 == 0) goto L6;
        View.inflate(getContext(), r5, r10);     // Catch: Exception -> L9
    L6:
        if (this.f13556u.getVisibility() != 0) goto L12;
        m();
        return;
    }

    public final void setAppIcon(int r5) {
        this.f13548l.setVisibility(8);
        a();
        if (r5 == 0) goto L8;
        OImageAppIcon r10 = this.f13549m;
        if (r10 == null) goto L13;
        r10.setImageResource(r5);
    L13:
        if (this.f13556u.getVisibility() != 0) goto L16;
        m();
        return;
    L16:
        return;
    L8:
        OImageAppIcon r11 = this.f13549m;
        if (r11 == null) goto L13;
        r11.setImageDrawable(null);
        goto L13
    }

    public final void setIcon(int r5) {
        ImageView r10 = this.f13548l;
        r10.setVisibility(0);
        OImageAppIcon r11 = this.f13549m;
        if (r11 == null) goto L6;
        r11.setVisibility(8);
    L6:
        if (r5 == 0) goto L8;
        r10.setImageResource(r5);
    L10:
        if (this.f13556u.getVisibility() != 0) goto L13;
        m();
        return;
    L13:
        return;
    L8:
        r10.setImageDrawable(null);
        goto L10
    }
}
