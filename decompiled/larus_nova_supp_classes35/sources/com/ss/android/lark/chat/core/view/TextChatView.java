package com.ss.android.lark.chat.core.view;

import a08.b;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.widget.EllipsizeFrameLayout;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.richtext.RichTextView;
import mcc.i;
import y9c.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TextChatView extends ConstraintLayout {
    public RichTextView a;
    public View b;
    public TextView c;
    public EllipsizeFrameLayout d;

    public interface a {
        void onClick();
    }

    public void setOnShoreMoreClickListener(a r1) {
    }

    public RichTextView getRichTextView() {
        return this.a;
    }

    public TextChatView(Context r2) {
        this(r2, null);
    }

    public void setAbbreviationClickListener(LinkEmojiTextView.e r2) {
        this.a.setAbbreviationListener(r2);
    }

    public void setAtStringClickListener(LinkEmojiTextView.f r2) {
        this.a.setAtStringClickListner(r2);
    }

    public void setEmojiSize(int r2) {
        int r0 = DesktopUtil.a;
        this.a.setEmojIconSize(r2);
    }

    public void setEnableEllipsize(boolean r2) {
        this.d.setEnableEllipsize(r2);
    }

    public void setMaxHeightFactor(EllipsizeFrameLayout.a r2) {
        this.d.setMaxHeightFactor(r2);
    }

    public void setMentionStringClickListener(i r2) {
        this.a.setMentionListener(r2);
    }

    public void setPhoneStringClickListener(LinkEmojiTextView.h r2) {
        this.a.setPhoneStringClickListener(r2);
    }

    public void setRichTextClickListener(RichTextView.d r2) {
        this.a.setRichTextListener(r2);
    }

    public void setShowMoreTextSize(float r3) {
        TextView r0 = this.c;
        r0.setTextSize(0, b.a(r3, r0.getContext()));
    }

    public void setShowMoreViewBg(Drawable r2) {
        this.b.setBackground(r2);
    }

    public void setTextColor(int r2) {
        this.a.setTextColor(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextSize(float r3) {
        this.a.setTextSize(b.a(r3, getContext()));
    }

    public void setUrlStringClickListener(LinkEmojiTextView.i r2) {
        this.a.setUrlStringClickListner(r2);
    }

    public void setUseNewAtStyle(boolean r2) {
        this.a.setUseNewAtStyle(r2);
    }

    public TextChatView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TextChatView(Context r7, AttributeSet r8, int r9) {
        super(r7, r8, r9);
        EllipsizeFrameLayout r10 = new EllipsizeFrameLayout(r7);
        this.d = r10;
        r10.setId(2131382820);
        this.d.setEnableEllipsize(false);
        ConstraintLayout.LayoutParams r1 = z4b.a.a(r7, -2.0f, -2.0f, 0);
        r1.startToStart = 0;
        r1.endToEnd = 0;
        r1.topToTop = 0;
        r1.horizontalBias = 0.0f;
        addView(this.d, r1);
        RichTextView r2 = new RichTextView(r7);
        this.a = r2;
        r2.setId(2131379959);
        DesktopUtil.a(getContext());
        this.a.setTextSize(zz7.b.h(getContext(), 17));
        this.a.setEmojIconSize(zz7.b.g(r7, 20));
        this.d.addView(this.a);
        View r3 = new View(r7);
        this.b = r3;
        r3.setId(2131382826);
        this.b.setVisibility(8);
        ConstraintLayout.LayoutParams r4 = z4b.a.a(r7, 0.0f, 48.0f, 0);
        r4.startToStart = 0;
        r4.endToEnd = 0;
        r4.bottomToBottom = 2131382820;
        addView(this.b, r4);
        TextView r5 = new TextView(r7);
        this.c = r5;
        r5.setId(2131382827);
        this.c.setBackgroundResource(2131232615);
        this.c.setGravity(17);
        this.c.setPadding(d.b(r7, 15.0f), 0, d.b(r7, 15.0f), d.b(r7, 5.0f));
        this.c.setText(2131891581);
        zz7.a.c(this.c, 14);
        this.c.setTextColor(d.c(r7, 2131106622));
        this.c.setVisibility(8);
        ConstraintLayout.LayoutParams r11 = z4b.a.a(r7, -2.0f, -2.0f, -5);
        r11.startToStart = 0;
        r11.endToEnd = 0;
        r11.bottomToBottom = 2131382820;
        addView(this.c, r11);
    }
}
