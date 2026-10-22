package com.larus.bmhome.view.item;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.facebook.drawee.view.GenericDraweeView;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\nJ\u0010\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\nH\u0016J\u001e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\nJ\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006."}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "imageView", "Lcom/facebook/drawee/view/GenericDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/GenericDraweeView;", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "init", "", "value", "", ShareType.TEXT, "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "setTextColor", "color", "setTextFontWeight", "weight", "loadImage", ShareType.URL, "", "setImageSrc", "resId", "setImageDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "widthDp", "heightDp", "setEnabled", "enabled", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ItemTextView extends ConstraintLayout {
    public final GenericDraweeView a;
    public final TextView b;

    public final CharSequence getText() {
        return this.b.getText();
    }

    public final GenericDraweeView getImageView() {
        return this.a;
    }

    public final TextView getTextView() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextView(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        GenericDraweeView r0 = new GenericDraweeView(getContext());
        r0.setId(2131392524);
        this.a = r0;
        TextView r1 = new TextView(getContext());
        r1.setId(2131392533);
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), c.b(2130972079, r1.getContext(), 2131103136)));
        r1.setTextSize(0, i5.t());
        r1.setGravity(16);
        this.b = r1;
        R5(r6, null);
    }

    public final void S5(String r4) {
        if (o0.d(null) == false) goto L5;
        ImageLoaderKt.u(this.a, null, "citation_item_icon");
        this.a.setVisibility(0);
    L6:
        ViewGroup.LayoutParams r5 = this.b.getLayoutParams();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        if (this.a.getVisibility() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        r6.setMarginStart(i5.q());
        r6.setMarginEnd(0);
    L13:
        this.b.setLayoutParams(r6);
        return;
    L12:
        r6.setMarginStart(0);
        r6.setMarginEnd(0);
        goto L13
    L9:
        r0 = false;
        goto L10
    L5:
        this.a.setVisibility(8);
        goto L6
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

    public void setImageSrc(int r3) {
        if (r3 <= 0) goto L5;
        this.a.setImageResource(r3);
        this.a.setVisibility(0);
    L6:
        ViewGroup.LayoutParams r4 = this.b.getLayoutParams();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (this.a.getVisibility() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        r5.setMarginStart(i5.q());
        r5.setMarginEnd(0);
    L13:
        this.b.setLayoutParams(r5);
        return;
    L12:
        r5.setMarginStart(0);
        r5.setMarginEnd(0);
        goto L13
    L9:
        r1 = false;
        goto L10
    L5:
        this.a.setVisibility(8);
        goto L6
    }

    public final void setText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.b.setText(r2);
    }

    public final void setTextColor(int r2) {
        this.b.setTextColor(r2);
    }

    public final void setTextFontWeight(int r3) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Typeface r4 = Typeface.create(this.b.getTypeface(), r3, this.b.getTypeface().isItalic());
        this.b.setTypeface(r4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextView(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        super(r6, r7);
        GenericDraweeView r0 = new GenericDraweeView(getContext());
        r0.setId(2131392524);
        this.a = r0;
        TextView r1 = new TextView(getContext());
        r1.setId(2131392533);
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), c.b(2130972079, r1.getContext(), 2131103136)));
        r1.setTextSize(0, i5.t());
        r1.setGravity(16);
        this.b = r1;
        R5(r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r8, AttributeSet r9) {
        TypedArray r10 = r8.obtainStyledAttributes(r9, new int[]{R.attr.textColor, R.attr.text, R.attr.textFontWeight, 2130972009, 2130972012, 2130972013});
        GenericDraweeView r0 = this.a;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(r10.getDimensionPixelSize(5, -2), r10.getDimensionPixelSize(3, -2));
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.startToStart = 0;
        r1.setMargins(0, i5.h(), 0, i5.h());
        Unit r5 = Unit.INSTANCE;
        addView(r0, r1);
        int r2 = r10.getResourceId(4, 0);
        if (r2 <= 0) goto L5;
        this.a.setImageResource(r2);
        this.a.setVisibility(0);
    L6:
        TextView r3 = this.b;
        ConstraintLayout.LayoutParams r4 = new ConstraintLayout.LayoutParams(0, -2);
        r4.topToTop = 0;
        r4.bottomToBottom = 0;
        r4.startToEnd = this.a.getId();
        if (this.a.getVisibility() != 0) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L12;
        r4.setMarginStart(i5.q());
        r4.setMarginEnd(0);
    L13:
        r4.endToEnd = 0;
        addView(r3, r4);
        TextView r7 = this.b;
        String r11 = r10.getString(1);
        if (r11 != null) goto L16;
        r11 = "";
    L16:
        r7.setText(r11);
        this.b.setTextColor(ContextCompat.getColor(r8, c.b(2130972079, r8, 2131103136)));
        if (Build.VERSION.SDK_INT < 28) goto L19;
        this.b.setTypeface(Typeface.create(this.b.getTypeface(), r10.getInteger(2, 400), this.b.getTypeface().isItalic()));
    L19:
        this.b.setSingleLine(false);
        this.b.setMaxLines(2);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        this.b.setTextAlignment(5);
        int r12 = r10.getResources().getDimensionPixelSize(c.b(2130971208, null, 2131166786));
        int r13 = getPaddingTop();
        int r14 = getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r12 + ",top:" + r13 + ",end:" + r12 + ",bottom:" + r14);
        setPaddingRelative(r12, r13, r12, r14);
        setMinHeight(i5.h0());
        r10.recycle();
        return;
    L12:
        r4.setMarginStart(0);
        r4.setMarginEnd(0);
        goto L13
    L9:
        r6 = false;
        goto L10
    L5:
        this.a.setVisibility(8);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextView(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "attrs");
        super(r5, r6, r7);
        GenericDraweeView r8 = new GenericDraweeView(getContext());
        r8.setId(2131392524);
        this.a = r8;
        TextView r9 = new TextView(getContext());
        r9.setId(2131392533);
        r9.setTextColor(ContextCompat.getColor(r9.getContext(), c.b(2130972079, r9.getContext(), 2131103136)));
        r9.setTextSize(0, i5.t());
        r9.setGravity(16);
        this.b = r9;
        R5(r5, r6);
    }
}
