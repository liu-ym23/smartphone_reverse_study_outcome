package com.larus.bmhome.view.item;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\nJ\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/larus/bmhome/view/item/ItemLongTextArrow;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "arrowView", "getArrowView", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "init", "", "setText", ShareType.TEXT, "", "setTextColor", "color", "setImageSrc", "resId", "setEnabled", "enabled", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ItemLongTextArrow extends ConstraintLayout {
    public final ImageView a;
    public final ImageView b;
    public final TextView c;

    public final ImageView getArrowView() {
        return this.b;
    }

    public final ImageView getImageView() {
        return this.a;
    }

    public final TextView getTextView() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemLongTextArrow(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        ImageView r0 = new ImageView(getContext());
        r0.setId(2131392524);
        this.a = r0;
        ImageView r1 = new ImageView(getContext());
        r1.setId(2131392521);
        r1.setImageResource(c.b(2130971641, r1.getContext(), 2131240848));
        r1.setVisibility(0);
        this.b = r1;
        TextView r2 = new TextView(getContext());
        r2.setId(2131392533);
        r2.setTextColor(ContextCompat.getColor(r2.getContext(), c.b(2130972079, r2.getContext(), 2131103136)));
        r2.setTextSize(0, i5.t());
        r2.setGravity(16);
        this.c = r2;
        R5(r7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnabled(boolean r2) {
        if (r2 == false) goto L4;
        float r0 = 1.0f;
    L5:
        setAlpha(r0);
        super/*android.view.ViewGroup*/.setEnabled(r2);
        return;
    L4:
        r0 = 0.3f;
        goto L5
    }

    public final void setImageSrc(int r2) {
        this.a.setImageResource(r2);
    }

    public final void setText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        this.c.setText(r2);
    }

    public final void setTextColor(int r2) {
        this.c.setTextColor(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemLongTextArrow(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "attrs");
        super(r7, r8);
        ImageView r0 = new ImageView(getContext());
        r0.setId(2131392524);
        this.a = r0;
        ImageView r1 = new ImageView(getContext());
        r1.setId(2131392521);
        r1.setImageResource(c.b(2130971641, r1.getContext(), 2131240848));
        r1.setVisibility(0);
        this.b = r1;
        TextView r2 = new TextView(getContext());
        r2.setId(2131392533);
        r2.setTextColor(ContextCompat.getColor(r2.getContext(), c.b(2130972079, r2.getContext(), 2131103136)));
        r2.setTextSize(0, i5.t());
        r2.setGravity(16);
        this.c = r2;
        R5(r7, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r7, AttributeSet r8) {
        TypedArray r9 = r7.obtainStyledAttributes(r8, new int[]{R.attr.textColor, R.attr.text, R.attr.textFontWeight, 2130972009, 2130972012, 2130972013});
        ImageView r0 = this.a;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(r9.getDimensionPixelSize(5, -2), r9.getDimensionPixelSize(3, -2));
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.startToStart = 0;
        r1.setMargins(0, i5.h(), 0, i5.h());
        Unit r4 = Unit.INSTANCE;
        addView(r0, r1);
        int r2 = r9.getResourceId(4, 0);
        if (r2 <= 0) goto L5;
        this.a.setImageResource(r2);
        this.a.setVisibility(0);
    L6:
        ImageView r3 = this.b;
        ConstraintLayout.LayoutParams r5 = new ConstraintLayout.LayoutParams(-2, -2);
        r5.topToTop = 0;
        r5.bottomToBottom = 0;
        r5.endToEnd = 0;
        addView(r3, r5);
        TextView r6 = this.c;
        ConstraintLayout.LayoutParams r10 = new ConstraintLayout.LayoutParams(0, -2);
        r10.topToTop = 0;
        r10.bottomToBottom = 0;
        r10.endToStart = this.b.getId();
        r10.startToEnd = this.a.getId();
        r10.setMarginStart(i5.q());
        r10.setMarginEnd(0);
        ((ViewGroup.MarginLayoutParams) r10).bottomMargin = i5.h();
        ((ViewGroup.MarginLayoutParams) r10).topMargin = i5.h();
        addView(r6, r10);
        TextView r11 = this.c;
        String r12 = r9.getString(1);
        if (r12 != null) goto L9;
        r12 = "";
    L9:
        r11.setText(r12);
        this.c.setTextColor(r9.getColor(0, ContextCompat.getColor(r7, c.b(2130972079, r7, 2131103136))));
        if (Build.VERSION.SDK_INT < 28) goto L12;
        this.c.setTypeface(Typeface.create(this.c.getTypeface(), r9.getInteger(2, 400), this.c.getTypeface().isItalic()));
    L12:
        int r13 = r9.getResources().getDimensionPixelSize(c.b(2130971208, null, 2131166786));
        int r14 = getPaddingTop();
        int r15 = getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r13 + ",top:" + r14 + ",end:" + r13 + ",bottom:" + r15);
        setPaddingRelative(r13, r14, r13, r15);
        setMinHeight(i5.h0());
        r9.recycle();
        return;
    L5:
        this.a.setVisibility(8);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemLongTextArrow(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        super(r6, r7, r8);
        ImageView r9 = new ImageView(getContext());
        r9.setId(2131392524);
        this.a = r9;
        ImageView r10 = new ImageView(getContext());
        r10.setId(2131392521);
        r10.setImageResource(c.b(2130971641, r10.getContext(), 2131240848));
        r10.setVisibility(0);
        this.b = r10;
        TextView r11 = new TextView(getContext());
        r11.setId(2131392533);
        r11.setTextColor(ContextCompat.getColor(r11.getContext(), c.b(2130972079, r11.getContext(), 2131103136)));
        r11.setTextSize(0, i5.t());
        r11.setGravity(16);
        this.c = r11;
        R5(r6, r7);
    }
}
