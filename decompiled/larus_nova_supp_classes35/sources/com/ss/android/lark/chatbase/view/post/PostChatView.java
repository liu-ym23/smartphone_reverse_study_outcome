package com.ss.android.lark.chatbase.view.post;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.PostContentBlock;
import com.ss.android.lark.chat.utils.b0;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import com.ss.android.lark.widget.light.LKUILightTextView;
import mcc.b;
import mcc.c;
import mcc.e;
import mcc.f;
import mcc.g;
import mcc.h;
import mcc.i;
import mcc.l;
import mcc.n;
import mcc.o;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class PostChatView extends ConstraintLayout {
    public boolean A;
    public boolean B;
    public boolean C;
    public PostContentBlock.e D;
    public TextView a;
    public View b;
    public LKUILightTextView c;
    public View d;
    public TextView e;
    public EllipsizeFrameLayout f;
    public LinearLayout g;
    public View h;
    public LinearLayout i;
    public View.OnLongClickListener j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public a m;
    public boolean n;
    public EllipsizeFrameLayout.a o;
    public boolean p;
    public String q;
    public boolean r;
    public String s;
    public String t;
    public String u;
    public boolean v;
    public boolean w;
    public CharSequence x;
    public String y;
    public boolean z;

    public interface a {
        void onClick();
    }

    private CharSequence getShowMoreText() {
        CharSequence r0 = this.x;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return UIHelper.getString(2131891581);
    }

    public LKUILightTextView getContentView() {
        return this.c;
    }

    public View getTitleDivisionView() {
        return this.b;
    }

    public TextView getTitleView() {
        return this.a;
    }

    public PostChatView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        if (this.B == false) goto L7;
        return false;
    L7:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r2);
    }

    public void setAbbreviationsClickListener(mcc.a r2) {
        this.c.setAbbreviationClickListener(r2);
    }

    public void setAtSpanClickListener(b r2) {
        this.c.setAtSpanClickListener(r2);
    }

    public void setAtUserGroupSpanClickListener(c r2) {
        this.c.setAtUserGroupSpanClickListener(r2);
    }

    public void setCodeBlockV2ClickListener(e r2) {
        this.c.setCodeBlockV2SpanCLickListener(r2);
    }

    public void setColumnsClickListener(f r2) {
        this.c.setColumnsSpanClickListener(r2);
    }

    public void setEnableEllipsize(boolean r1) {
        this.n = r1;
    }

    public void setImageClickListener(g r2) {
        this.c.setImageSpanClickListener(r2);
    }

    public void setMaxHeightFactor(EllipsizeFrameLayout.a r1) {
        this.o = r1;
    }

    public void setMentionSpanClickListener(i r2) {
        this.c.setMentionSpanClickListener(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnClickListener(View.OnClickListener r1) {
        super/*android.view.ViewGroup*/.setOnClickListener(r1);
        this.k = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOnLongClickListener(View.OnLongClickListener r1) {
        super/*android.view.ViewGroup*/.setOnLongClickListener(r1);
        this.j = r1;
    }

    public void setOnLongTextClickListener(a r1) {
        this.m = r1;
    }

    public void setPhoneSpanClickListener(l r2) {
        this.c.setPhoneSpanClickListener(r2);
    }

    public void setPreMessageOnClickListener(View.OnClickListener r1) {
        this.l = r1;
    }

    public void setShowMoreText(boolean r1) {
        this.w = r1;
    }

    public void setShowMoreTextOverride(CharSequence r2) {
        this.x = r2;
        TextView r3 = this.e;
        if (r3 == null) goto L6;
        r3.setText(getShowMoreText());
        return;
    }

    public void setShowMoreTextSize(float r3) {
        this.e.setTextSize(0, r3);
    }

    public void setShowMoreViewBg(int r2) {
        this.d.setBackgroundResource(r2);
    }

    public void setSupportJumpToThread(boolean r1) {
        this.A = r1;
    }

    public void setTableClickListener(n r2) {
        this.c.setTableSpanClickListener(r2);
    }

    public void setTextSize(int r2) {
        this.c.setTextSize(r2);
    }

    public void setTitleDivisionViewVisible(int r3) {
        if (this.b.getVisibility() == r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return;
    L8:
        ConstraintSet r1 = new ConstraintSet();
        r1.clone(this);
        r1.setVisibility(2131388859, r3);
        r1.applyTo(this);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setTitleDrawableStart(Drawable r3) {
        this.a.setCompoundDrawablesRelative(r3, null, null, null);
        this.a.setCompoundDrawablePadding(UIHelper.dp2px(8.0f));
    }

    public void setTitleLayoutVisible(boolean r6) {
        boolean r0 = true;
        int r1 = 8;
        if (r6 == false) goto L11;
        if (this.b.getVisibility() == 0) goto L7;
    L14:
        if (r0 == true) goto L16;
        return;
    L16:
        ConstraintSet r2 = new ConstraintSet();
        r2.clone(this);
        if (r6 == false) goto L19;
        int r3 = 0;
    L20:
        r2.setVisibility(2131388859, r3);
        if (r6 == false) goto L23;
        r1 = 0;
    L23:
        r2.setVisibility(2131388772, r1);
        r2.applyTo(this);
        if ((this.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L30;
        if (r6 == false) goto L27;
        float r7 = 8.0f;
    L28:
        int r8 = UIHelper.dp2px(r7);
        ((ViewGroup.MarginLayoutParams) this.f.getLayoutParams()).setMargins(0, r8, 0, 0);
        return;
    L27:
        r7 = 0.0f;
        goto L28
    L30:
        return;
    L19:
        r3 = 8;
        goto L20
    L7:
        if (this.a.getVisibility() != 0) goto L14;
    L9:
        r0 = false;
        goto L14
    L11:
        if (this.b.getVisibility() != 8) goto L14;
        if (this.a.getVisibility() == 8) goto L9;
        goto L9
    }

    public void setTitleTextColor(int r2) {
        this.a.setTextColor(r2);
    }

    public void setTitleTextSize(float r3) {
        this.a.setTextSize(0, r3);
    }

    public void setUrlSpanClickListener(o r2) {
        this.c.setUrlSpanClickListener(r2);
    }

    public void setUsername(String r1) {
        this.y = r1;
    }

    public void setVideoClickListener(h r2) {
        this.c.setMediaSpanClickListener(r2);
    }

    public void setShowMoreViewBg(Drawable r2) {
        this.d.setBackground(r2);
    }

    public PostChatView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PostChatView(Context r8, AttributeSet r9, int r10) {
        super(r8, r9, r10);
        this.o = new EllipsizeFrameLayout.a();
        this.v = false;
        this.w = true;
        this.x = null;
        this.z = false;
        this.A = true;
        this.B = false;
        this.C = false;
        this.D = null;
        TextView r0 = new TextView(r8);
        this.a = r0;
        r0.setId(2131388772);
        zz7.a.c(this.a, 17);
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        ConstraintLayout.LayoutParams r3 = b0.a(-2.0f, -2.0f, 0, 0);
        r3.startToStart = 0;
        r3.endToEnd = 0;
        r3.topToTop = 0;
        r3.horizontalBias = 0.0f;
        addView(this.a, r3);
        View r4 = new View(r8);
        this.b = r4;
        r4.setId(2131388859);
        this.b.setBackgroundColor(UDColorUtils.getColor(r8, 2131103353));
        ConstraintLayout.LayoutParams r5 = b0.a(0.0f, 0.5f, 8, 0);
        r5.startToStart = 0;
        r5.endToEnd = 0;
        r5.topToBottom = 2131388772;
        r5.horizontalBias = 0.0f;
        r5.goneTopMargin = 0;
        addView(this.b, r5);
        EllipsizeFrameLayout r1 = new EllipsizeFrameLayout(r8);
        this.f = r1;
        r1.setId(2131382820);
        this.f.setEnableEllipsize(false);
        ConstraintLayout.LayoutParams r2 = b0.a(-2.0f, -2.0f, 8, 0);
        r2.startToStart = 0;
        r2.endToEnd = 0;
        r2.topToBottom = 2131388859;
        r2.goneTopMargin = 0;
        r2.horizontalBias = 0.0f;
        addView(this.f, r2);
        LinearLayout r6 = new LinearLayout(r8);
        this.g = r6;
        r6.setOrientation(1);
        this.f.addView(this.g, new ViewGroup.LayoutParams(-2, -2));
        LKUILightTextView r11 = new LKUILightTextView(r8);
        this.c = r11;
        r11.setId(2131382819);
        this.g.addView(this.c);
        View r12 = new View(r8);
        this.d = r12;
        r12.setId(2131382826);
        ConstraintLayout.LayoutParams r13 = b0.a(0.0f, 48.0f, 0, 0);
        r13.startToStart = 0;
        r13.endToEnd = 0;
        r13.bottomToBottom = 0;
        this.d.setVisibility(8);
        addView(this.d, r13);
        TextView r14 = new TextView(r8);
        this.e = r14;
        r14.setId(2131382827);
        this.e.setBackgroundResource(2131232615);
        this.e.setGravity(17);
        this.e.setPadding(d.b(r8, 15.0f), d.b(r8, 2.0f), d.b(r8, 15.0f), d.b(r8, 6.0f));
        this.e.setText(2131891581);
        this.e.setVisibility(8);
        zz7.a.c(this.e, 14);
        this.e.setTextColor(d.c(r8, 2131106622));
        this.e.setVisibility(8);
        ConstraintLayout.LayoutParams r15 = b0.a(-2.0f, -2.0f, 0, 3);
        r15.startToStart = 0;
        r15.endToEnd = 0;
        r15.bottomToBottom = 0;
        addView(this.e, r15);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(String r1, Layout r2, CharSequence r3, boolean r4, String r5, String r6, String r7, boolean r8, String r9, boolean r10, boolean r11, boolean r12, boolean r13) {
        this.p = r8;
        this.q = r9;
        this.r = r4;
        this.u = r5;
        this.t = r6;
        this.s = r7;
        this.v = r11;
        this.B = r13;
        this.z = r12;
        if (TextUtils.isEmpty(r1) == false) goto L5;
        setTitleLayoutVisible(false);
    L20:
        this.e.setText(getShowMoreText());
        this.e.setOnClickListener(new com.ss.android.lark.chatbase.view.post.a(this));
        if ((this.f.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        ViewGroup.MarginLayoutParams r14 = (ViewGroup.MarginLayoutParams) this.f.getLayoutParams();
        if (this.p == false) goto L25;
        r14.topMargin = 0;
        this.f.setLayoutParams(r14);
        goto L26
    L25:
        r14.topMargin = 8;
        this.f.setLayoutParams(r14);
    L26:
        this.f.setMaxHeightFactor(this.o);
        this.f.setEllipsizeListener(new c7b.a(this));
        if (r10 == true) goto L29;
        this.f.setEnableEllipsize(this.n);
    L31:
        if (this.B == true) goto L34;
        this.c.setOnClickListener(new c7b.b(this));
        this.c.setOnLongClickListener(new c7b.d(this));
    L34:
        if (this.z == false) goto L38;
        if (r3 != null) goto L37;
        UIUtils.hide(this.c);
    L42:
        if (this.B == true) goto L46;
        setOnClickListener(new c7b.e(this));
        return;
    L46:
        return;
    L37:
        UIUtils.show(this.c);
        this.c.setContentText(r3);
        goto L42
    L38:
        if (r2 != null) goto L40;
        UIUtils.hide(this.c);
        goto L42
    L40:
        UIUtils.show(this.c);
        this.c.setContentLayout(r2);
        goto L42
    L29:
        this.f.setEnableEllipsize(false);
        goto L31
    L5:
        setTitleLayoutVisible(true);
        if (r10 == false) goto L8;
        this.a.setMaxLines(1000);
    L9:
        SpannableStringBuilder r15 = new SpannableStringBuilder();
        if (TextUtils.isEmpty(this.y) == true) goto L12;
        r15.append(this.y).append(": ");
    L12:
        SpannableString r16 = new SpannableString(r1);
        if (this.p == false) goto L15;
        r16.setSpan(new StyleSpan(0), 0, r16.length(), 33);
    L16:
        r15.append(r16);
        this.a.setText(r15);
        if (this.p == true) goto L19;
        this.a.setTextColor(UDColorUtils.getColor(getContext(), 2131106622));
        setTitleDrawableStart(null);
        goto L20
    L19:
        this.a.setPadding(UIUtils.dp2px(getContext(), 1.0f), UIUtils.dp2px(getContext(), 3.0f), UIUtils.dp2px(getContext(), 1.0f), UIUtils.dp2px(getContext(), 3.0f));
        this.a.requestLayout();
        this.a.setTextColor(UDColorUtils.getColor(getContext(), 2131106622));
        setTitleDrawableStart(UDIconUtils.getIconDrawable(getContext(), 2131253635, UDColorUtils.getColor(getContext(), 2131109069), new UDDimension.Dp(zz7.b.f(16.0f))));
        zz7.a.d(this.a, LarkFont.HEADLINE);
        goto L20
    L15:
        r16.setSpan(new StyleSpan(1), 0, r16.length(), 33);
        goto L16
    L8:
        this.a.setMaxLines(2);
        goto L9
    }
}
