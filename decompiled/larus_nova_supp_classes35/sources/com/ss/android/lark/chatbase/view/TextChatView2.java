package com.ss.android.lark.chatbase.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chat.core.view.TextChatView;
import com.ss.android.lark.chat.utils.b0;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import com.ss.android.lark.widget.light.LKUILightTextView;
import mcc.i;
import mcc.l;
import mcc.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TextChatView2 extends ConstraintLayout {
    public LKUILightTextView a;
    public View b;
    public TextView c;
    public CharSequence d;
    public EllipsizeFrameLayout e;
    public LinearLayout f;
    public View g;
    public LinearLayout h;
    public TextChatView.a i;
    public boolean j;
    public CharSequence k;
    public boolean l;

    public void setTextColor(int r1) {
    }

    private CharSequence getShowMoreText() {
        CharSequence r0 = this.d;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return UIHelper.getString(2131891581);
    }

    public LKUILightTextView getLightTextView() {
        return this.a;
    }

    public CharSequence getText() {
        return this.k;
    }

    public TextChatView2(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r2) {
        if (this.l == false) goto L7;
        return false;
    L7:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r2);
    }

    public void setAbbreviationClickListener(mcc.a r2) {
        this.a.setAbbreviationClickListener(r2);
    }

    public void setAtSpanClickListener(mcc.b r2) {
        this.a.setAtSpanClickListener(r2);
    }

    public void setAtUserGroupSpanClickListener(mcc.c r2) {
        this.a.setAtUserGroupSpanClickListener(r2);
    }

    public void setDisableTouchEvent(boolean r1) {
        this.l = r1;
    }

    public void setEnableEllipsize(boolean r2) {
        this.e.setEnableEllipsize(r2);
    }

    public void setMaxHeightFactor(EllipsizeFrameLayout.a r2) {
        this.e.setMaxHeightFactor(r2);
    }

    public void setMentionSpanClickListener(i r2) {
        this.a.setMentionSpanClickListener(r2);
    }

    public void setOnShoreMoreClickListener(TextChatView.a r1) {
        this.i = r1;
    }

    public void setPhoneSpanClickListener(l r2) {
        this.a.setPhoneSpanClickListener(r2);
    }

    public void setRenderWithCharSequence(boolean r1) {
        this.j = r1;
    }

    public void setShowMoreTextOverride(CharSequence r1) {
        this.d = r1;
    }

    public void setShowMoreTextSize(float r3) {
        this.c.setTextSize(0, r3);
    }

    public void setShowMoreViewBg(int r2) {
        this.b.setBackgroundResource(r2);
    }

    public void setText(CharSequence r1) {
        this.k = r1;
    }

    public void setTextSize(float r2) {
        this.a.setTextSize((int) r2);
    }

    public void setUrlSpanClickListener(o r2) {
        this.a.setUrlSpanClickListener(r2);
    }

    public TextChatView2(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextChatView2(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        this.d = null;
        this.j = false;
        this.k = null;
        this.l = false;
        EllipsizeFrameLayout r10 = new EllipsizeFrameLayout(r7);
        this.e = r10;
        r10.setId(2131382820);
        this.e.setEnableEllipsize(false);
        ConstraintLayout.LayoutParams r1 = b0.a(-2.0f, -2.0f, 0, 0);
        r1.startToStart = 0;
        r1.endToEnd = 0;
        r1.topToTop = 0;
        r1.horizontalBias = 0.0f;
        addView(this.e, r1);
        LinearLayout r2 = new LinearLayout(r7);
        this.f = r2;
        r2.setOrientation(1);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-2, -2);
        this.e.addView(this.f, r3);
        this.a = new LKUILightTextView(r7);
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, -2);
        this.a.setId(2131379959);
        this.f.addView(this.a, r4);
        View r5 = new View(r7);
        this.b = r5;
        r5.setId(2131382826);
        ConstraintLayout.LayoutParams r6 = b0.a(0.0f, 48.0f, 0, 0);
        r6.startToStart = 0;
        r6.endToEnd = 0;
        r6.bottomToBottom = 2131382820;
        this.b.setVisibility(8);
        addView(this.b, r6);
        TextView r11 = new TextView(r7);
        this.c = r11;
        r11.setId(2131382827);
        this.c.setBackgroundResource(2131232615);
        this.c.setGravity(17);
        this.c.setPadding(y9c.d.b(r7, 15.0f), 0, y9c.d.b(r7, 15.0f), y9c.d.b(r7, 5.0f));
        this.c.setText(2131891581);
        this.c.setVisibility(8);
        zz7.a.c(this.c, 14);
        this.c.setTextColor(y9c.d.c(r7, 2131106622));
        ConstraintLayout.LayoutParams r12 = b0.a(-2.0f, -2.0f, 0, -5);
        r12.startToStart = 0;
        r12.endToEnd = 0;
        r12.bottomToBottom = 2131382820;
        addView(this.c, r12);
    }

    public final void R5(Layout r3, Drawable r4, boolean r5, EllipsizeFrameLayout.a r6) {
        this.c.setText(getShowMoreText());
        this.b.setBackground(r4);
        this.c.setOnClickListener(new e(this));
        this.e.setMaxHeightFactor(r6);
        this.e.setEnableEllipsize(r5);
        this.e.setEllipsizeListener(new d(this));
        boolean r7 = this.j;
        if (r3 != null) goto L5;
        UIUtils.hide(this.a);
        return;
    L5:
        UIUtils.show(this.a);
        this.a.setContentLayout(r3);
    }
}
