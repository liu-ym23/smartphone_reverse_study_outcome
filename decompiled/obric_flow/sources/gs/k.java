package gs;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.provider.Settings;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.material.n;
import com.obric.oui.tab.OTabLayoutBase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends OUILinearLayout implements com.obric.oui.material.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public j f17205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f17206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f17207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f17208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f17209l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f17210m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f17211n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f17212o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.obric.oui.material.c[] f17213p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.obric.oui.material.c[] f17214q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.obric.oui.material.c[] f17215r;
    public final boolean s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public jp.d f17216t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public jp.d f17217u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ OTabLayoutBase f17218v;

    public k(OTabLayoutBase r5, Context r10, boolean r11, com.obric.oui.material.c[] r12, com.obric.oui.material.c[] r13) {
        this.f17218v = r5;
        super(r10);
        this.f17211n = 1;
        this.s = true;
        this.f17212o = r11;
        this.f17214q = r12;
        this.f17215r = r13;
        this.f17213p = r12;
        setEnableShadowWidthRadius(true);
        if (r5.f14667s0 == null) goto L5;
        boolean r14 = true;
    L6:
        setChangeAlphaWhenPress(r14);
        setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenSelected(false);
        if (r5.f14667s0 == null) goto L9;
        setOverridePressColor(ContextCompat.getColor(r10, R$color.oui_basic_fill_element_2));
        i("OTabLayoutBase");
    L9:
        int r15 = r5.D;
        if (r15 == 0) goto L12;
        ViewCompat.setBackground(this, AppCompatResources.getDrawable(r10, r15));
    L12:
        ViewCompat.setPaddingRelative(this, r5.f14674w, r5.f14676x, r5.f14678y, r5.f14680z);
        setMinimumWidth(r5.f14672v);
        setGravity(17);
        setOrientation(1);
        setClickable(true);
        ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND));
        if (this.f17212o == false) goto L16;
        r(isSelected());
        return;
    L16:
        return;
    L5:
        r14 = false;
        goto L6
    }

    @Override // com.obric.oui.material.d
    public final void a(int r5) {
        if (this.f17212o == true) goto L5;
        return;
    L5:
        n.p(r5, this);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        boolean r10 = super.dispatchTouchEvent(r5);
        int r11 = r5.getActionMasked();
        if (r11 != 0) goto L5;
        o(getCurrentShadows(), true);
    L21:
        return r10;
    L5:
        if (r11 != 1) goto L7;
        o(getCurrentShadows(), false);
        goto L21
    L7:
        if (r11 != 3) goto L21;
        if (this.f17212o == false) goto L18;
        jp.d r12 = this.f17216t;
        if (r12 == null) goto L14;
        r12.a(false);
    L14:
        jp.d r13 = this.f17217u;
        if (r13 == null) goto L17;
        r13.a(false);
    L17:
        setScaleX(1.0f);
        setScaleY(1.0f);
        r(isSelected());
        goto L21
    L18:
        o(getCurrentShadows(), false);
        goto L21
    }

    public final void e(boolean r5) {
        if (this.s == false) goto L10;
        if (this.f17212o == false) goto L8;
        if (r5 == false) goto L8;
        n.q(2, 1, this);
        return;
    L8:
        n.q(0, 0, this);
        return;
    L10:
        if (this.f17212o == false) goto L13;
        if (r5 == false) goto L13;
        n.q(3, 1, this);
        return;
    L13:
        n.q(0, 0, this);
    }

    public int getContentWidth() {
        TextView r5 = this.f17206i;
        boolean r10 = true;
        if (r5 != null) goto L5;
    L7:
        boolean r11 = false;
        int r12 = 0;
        int r13 = 0;
    L8:
        ImageView r14 = this.f17207j;
        if (r14 != null) goto L11;
    L19:
        r10 = r11;
    L20:
        View r15 = this.f17208k;
        if (r15 == null) goto L32;
        if (r15.getVisibility() != 0) goto L32;
        int r16 = this.f17208k.getLeft();
        if (r10 == false) goto L27;
        r16 = Math.min(r12, r16);
    L27:
        r12 = r16;
        int r17 = this.f17208k.getRight();
        if (r10 == false) goto L30;
        r17 = Math.max(r13, r17);
    L30:
        r13 = r17;
    L32:
        return r13 - r12;
    L11:
        if (r14.getVisibility() != 0) goto L19;
        if (r11 == false) goto L14;
        r12 = Math.min(r12, this.f17207j.getLeft());
    L15:
        if (r11 == false) goto L18;
        int r18 = Math.max(r13, this.f17207j.getRight());
    L17:
        r13 = r18;
        goto L20
    L18:
        r18 = this.f17207j.getRight();
        goto L17
    L14:
        r12 = this.f17207j.getLeft();
        goto L15
    L5:
        if (r5.getVisibility() != 0) goto L7;
        int r19 = this.f17206i.getLeft();
        r13 = this.f17206i.getRight();
        r12 = r19;
        r11 = true;
        goto L8
    }

    public j getTab() {
        return this.f17205h;
    }

    public TextView getTextView() {
        return this.f17206i;
    }

    public final void n() {
        com.obric.oui.common.style.m r5 = com.obric.oui.common.style.m.f12515h;
        l(r5.a(), r5.a(), false);
    }

    public final void o(List r5, boolean r10) {
        if (isEnabled() == false) goto L20;
        OTabLayoutBase r11 = this.f17218v;
        if (r11.f14667s0 == null) goto L22;
        jp.d r12 = this.f17216t;
        if (r12 == null) goto L10;
        r12.a(false);
    L10:
        jp.d r13 = this.f17217u;
        if (r13 == null) goto L13;
        r13.a(false);
    L13:
        if (r10 == false) goto L15;
        List<com.obric.oui.common.style.m> r14 = getCurrentShadows();
        this.f17216t = com.obric.oui.common.style.n.c(this, getScaleX(), 0.98f, r14, r11.f14667s0);
        return;
    L15:
        if (r5 != null) goto L18;
        r5 = getCurrentShadows();
    L18:
        this.f17217u = com.obric.oui.common.style.n.c(this, getScaleX(), 1.0f, r11.f14667s0, r5);
        return;
    L22:
        return;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent r5) {
        super.onInitializeAccessibilityEvent(r5);
        r5.setClassName(ActionBar.Tab.class.getName());
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r5) {
        super.onInitializeAccessibilityNodeInfo(r5);
        r5.setClassName(ActionBar.Tab.class.getName());
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r12, int r13) {
        int r5 = View.MeasureSpec.getSize(r12);
        int r10 = View.MeasureSpec.getMode(r12);
        OTabLayoutBase r11 = this.f17218v;
        int r14 = r11.getTabMaxWidth();
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) this.f17206i.getLayoutParams();
        if (r14 <= 0) goto L7;
        if (r10 == 0) goto L6;
        if (r5 <= r14) goto L7;
    L6:
        r12 = View.MeasureSpec.makeMeasureSpec(r11.E, Integer.MIN_VALUE);
    L7:
        super.onMeasure(r12, r13);
        if (this.f17206i == null) goto L36;
        getResources();
        float r16 = r11.B;
        int r17 = this.f17211n;
        int r18 = r11.f14670u;
        int r19 = r11.f14668t;
        ImageView r20 = this.f17207j;
        if (r20 == null) goto L15;
        if (r20.getVisibility() != 0) goto L15;
        r17 = 1;
    L15:
        if (this.f17206i != null) goto L17;
    L21:
        float r21 = this.f17206i.getTextSize();
        int r22 = this.f17206i.getLineCount();
        int r110 = TextViewCompat.getMaxLines(this.f17206i);
        if (r16 != r21) goto L26;
        if (r110 < 0) goto L37;
        if (r17 != r110) goto L26;
        return;
    L37:
        return;
    L26:
        if (r11.K != 1) goto L34;
        if (r16 <= r21) goto L34;
        if (r22 != 1) goto L34;
        Layout r23 = this.f17206i.getLayout();
        if (r23 != null) goto L32;
        return;
    L32:
        if (((r16 / r23.getPaint().getTextSize()) * r23.getLineWidth(0)) <= ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) goto L34;
        return;
    L34:
        this.f17206i.setTextSize(0, r16);
        this.f17206i.setMaxLines(r17);
        r15.topMargin = r18;
        r15.leftMargin = r19;
        r15.rightMargin = r19;
        this.f17206i.setLayoutParams(r15);
        super.onMeasure(r12, r13);
        return;
    L17:
        if (isSelected() == false) goto L21;
        float r24 = r11.C;
        if (r24 <= 0.0f) goto L21;
        r16 = r24;
        r18 = 0;
        r19 = 0;
        goto L21
    }

    public final void p() {
        OTabLayoutBase r5 = this.f17218v;
        if (r5.D == 0) goto L5;
        ViewCompat.setBackground(this, AppCompatResources.getDrawable(getContext(), r5.D));
    L6:
        setOutlineProvider(null);
        return;
    L5:
        setBackground(null);
        goto L6
    }

    @Override // android.view.View
    public final boolean performClick() {
        boolean r5 = super.performClick();
        if (this.f17205h == null) goto L12;
        if (r5 == true) goto L6;
        playSoundEffect(0);
    L6:
        FastOutSlowInInterpolator r10 = OTabLayoutBase.F0;
        this.f17218v.getClass();
        j r11 = this.f17205h;
        OTabLayoutBase r12 = r11.f;
        if (r12 == null) goto L11;
        r12.s(r11, true);
        com.lynx.tasm.utils.g.p(1, getContext());
        return true;
    L11:
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
    L12:
        return r5;
    }

    public final void q() {
        j r5 = this.f17205h;
        if (r5 == null) goto L5;
        View r10 = r5.e;
    L6:
        OTabLayoutBase r11 = this.f17218v;
        boolean r12 = true;
        if (r10 == null) goto L29;
        ViewParent r13 = r10.getParent();
        if (r13 == this) goto L13;
        if (r13 == null) goto L12;
        ((ViewGroup) r13).removeView(r10);
    L12:
        addView(r10);
    L13:
        this.f17208k = r10;
        TextView r14 = this.f17206i;
        if (r14 == null) goto L16;
        r14.setVisibility(8);
    L16:
        ImageView r15 = this.f17207j;
        if (r15 == null) goto L19;
        r15.setVisibility(8);
        this.f17207j.setImageDrawable(null);
    L19:
        TextView r16 = (TextView) r10.findViewById(R$id.title);
        this.f17209l = r16;
        if (r16 == null) goto L26;
        r16.setDuplicateParentStateEnabled(true);
        this.f17211n = TextViewCompat.getMaxLines(this.f17209l);
        if (r11.D0 != null) goto L26;
        if (this.f17206i == null) goto L26;
        r11.D0 = this.f17209l.getTypeface();
    L26:
        ImageView r17 = (ImageView) r10.findViewById(R.id.icon);
        this.f17210m = r17;
        if (r17 == null) goto L34;
        r17.setDuplicateParentStateEnabled(true);
    L34:
        if (this.f17208k == null) goto L36;
        TextView r18 = this.f17209l;
        if (r18 == null) goto L52;
    L53:
        s(r18, this.f17210m);
    L54:
        if (r5 == null) goto L62;
        OTabLayoutBase r19 = r5.f;
        if (r19 == null) goto L61;
        if (r19.getSelectedTabPosition() != r5.d) goto L62;
    L63:
        setSelected(r12);
        return;
    L61:
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
    L62:
        r12 = false;
        goto L63
    L52:
        if (this.f17210m == null) goto L54;
    L36:
        if (this.f17207j != null) goto L39;
        ImageView r20 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, this, false);
        addView(r20, 0);
        this.f17207j = r20;
        r20.setDuplicateParentStateEnabled(true);
    L39:
        if (this.f17206i != null) goto L45;
        TextView r21 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, this, false);
        addView(r21, new LinearLayout.LayoutParams(-1, -2));
        this.f17206i = r21;
        r21.setMaxLines(1);
        this.f17206i.setDuplicateParentStateEnabled(true);
        this.f17211n = TextViewCompat.getMaxLines(this.f17206i);
        if (r11.D0 != null) goto L45;
        TextView r22 = this.f17206i;
        if (r22 == null) goto L45;
        r11.D0 = r22.getTypeface();
    L45:
        this.f17206i.setAllCaps(false);
        ColorStateList r23 = r11.A;
        if (r23 == null) goto L48;
        this.f17206i.setTextColor(r23);
    L48:
        s(this.f17206i, this.f17207j);
        goto L54
    L29:
        View r24 = this.f17208k;
        if (r24 == null) goto L32;
        removeView(r24);
        this.f17208k = null;
    L32:
        this.f17209l = null;
        this.f17210m = null;
        goto L34
    L5:
        r10 = null;
        goto L6
    }

    public final void r(boolean r10) {
        if (this.f17212o == true) goto L6;
        p();
        n();
        e(false);
        return;
    L6:
        if (r10 == false) goto L10;
        com.obric.oui.material.c[] r5 = this.f17215r;
        if (r5 == null) goto L10;
    L11:
        this.f17213p = r5;
        if (r5 == null) goto L50;
        int r11 = (int) com.lynx.tasm.utils.a.t(getContext(), 99.0f);
        setShadowCornerRadius(r11);
        setRadius(r11);
        OTabLayoutBase r12 = this.f17218v;
        if (r12.f14667s0 == null) goto L21;
        com.obric.oui.common.style.g r13 = (com.obric.oui.common.style.g) getAlphaHelper();
        if (r13.f12468r == r11) goto L21;
        r13.f12468r = r11;
        View r14 = (View) r13.f12455a.get();
        if (r14 != null) goto L20;
        ps.a.c("OUIAlphaHelper", "setRadius: owner is null");
        goto L21
    L20:
        r13.c(r14);
    L21:
        boolean r15 = this.s;
        if (r15 == false) goto L24;
        int r16 = 2;
    L25:
        com.obric.oui.common.style.m r17 = null;
        if (r15 == false) goto L28;
        a.a.x(this, this.f17213p, false, r16, null);
    L29:
        com.obric.oui.material.c[] r18 = this.f17213p;
        if (r18 != null) goto L32;
    L41:
        n();
    L42:
        GradientDrawable r19 = new GradientDrawable();
        r19.setShape(0);
        r19.setCornerRadius(com.lynx.tasm.utils.a.t(getContext(), 99.0f));
        r19.setColor(0);
        setBackground(r19);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        e(true);
        if (r10 == false) goto L52;
        ArrayList r20 = r12.f14667s0;
        if (r20 == null) goto L53;
        com.obric.oui.common.style.m r21 = (com.obric.oui.common.style.m) r20.get(0);
        if (r12.f14667s0.size() <= 1) goto L49;
        r17 = (com.obric.oui.common.style.m) r12.f14667s0.get(1);
    L49:
        l(r21, r17, false);
        return;
    L53:
        return;
    L52:
        return;
    L32:
        if (r18.length == 0) goto L41;
        Context r22 = getContext();
        Integer r23 = n.f13677a;
        com.obric.oui.material.c r24 = this.f17213p[Math.max(0, Math.min(this.f17213p.length - 1, Settings.Global.getInt(r22.getContentResolver(), "obric_current_effect_id", 2) - 1))];
        if (r24 == null) goto L41;
        es.a[] r25 = r24.f13613i;
        if (r25 == null) goto L41;
        if (r25.length <= 0) goto L41;
    L28:
        a.a.z(this, this.f17213p, false, null);
        goto L29
    L24:
        r16 = 3;
        goto L25
    L50:
        p();
        n();
        e(false);
        return;
    L10:
        r5 = this.f17214q;
        goto L11
    }

    public final void s(TextView r10, ImageView r11) {
        j r5 = this.f17205h;
        CharSequence r12 = null;
        if (r5 == null) goto L5;
        Drawable r13 = r5.f17202a;
    L6:
        if (r5 == null) goto L8;
        CharSequence r14 = r5.f17203b;
    L9:
        if (r5 == null) goto L11;
        CharSequence r15 = r5.f17204c;
    L12:
        int r16 = 0;
        if (r11 == null) goto L18;
        if (r13 == null) goto L16;
        r11.setImageDrawable(r13);
        r11.setVisibility(0);
        setVisibility(0);
    L17:
        r11.setContentDescription(r15);
        goto L18
    L16:
        r11.setVisibility(8);
        r11.setImageDrawable(null);
    L18:
        boolean r17 = TextUtils.isEmpty(r14);
        if (r10 == null) goto L24;
        if (r17 == true) goto L22;
        r10.setText(r14);
        r10.setVisibility(0);
        setVisibility(0);
    L23:
        r10.setContentDescription(r15);
        goto L24
    L22:
        r10.setVisibility(8);
        r10.setText(null);
    L24:
        if (r11 == null) goto L33;
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r11.getLayoutParams();
        if (r17 == true) goto L31;
        if (r11.getVisibility() != 0) goto L31;
        r16 = this.f17218v.m(8);
    L31:
        if (r16 == r18.bottomMargin) goto L33;
        r18.bottomMargin = r16;
        r11.requestLayout();
    L33:
        if (r17 == false) goto L36;
        r12 = r15;
    L36:
        TooltipCompat.setTooltipText(this, r12);
        return;
    L11:
        r15 = null;
        goto L12
    L8:
        r14 = null;
        goto L9
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.obric.oui.material.d
    public void setBackdropTarget(View r5) {
        if (this.f17212o == true) goto L5;
        return;
    L5:
        n.r(r5, this);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, android.view.View
    public void setSelected(boolean r10) {
        isSelected();
        super.setSelected(r10);
        r(r10);
        TextView r5 = this.f17206i;
        if (r5 == null) goto L19;
        OTabLayoutBase r11 = this.f17218v;
        if (r10 == false) goto L9;
        float r12 = r11.C;
        if (r12 <= 0.0f) goto L9;
        r5.setTextSize(0, r12);
    L10:
        TextView r13 = this.f17206i;
        if (r10 == false) goto L16;
        Typeface r14 = r11.D0;
        if (r11.E0 != null) goto L15;
        r11.E0 = Typeface.create(r14, 500, false);
    L15:
        Typeface r15 = r11.E0;
    L17:
        r13.setTypeface(r15);
        return;
    L16:
        r15 = r11.D0;
    L9:
        r5.setTextSize(0, r11.B);
        goto L10
    }

    public void setTab(@Nullable j r5) {
        if (r5 == this.f17205h) goto L6;
        this.f17205h = r5;
        q();
        return;
    }
}
