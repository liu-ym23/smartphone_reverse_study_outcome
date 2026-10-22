package com.larus.bmhome.view.item;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\nJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001a¨\u0006#"}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextDescView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textView", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "descView", "getDescView", "init", "", "value", "", ShareType.TEXT, "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "setTextColor", "color", "descText", "getDescText", "setDescText", "setEnabled", "enabled", "", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemTextDescView extends ConstraintLayout {
    public final TextView a;
    public final TextView b;

    public final CharSequence getDescText() {
        return this.b.getText();
    }

    public final CharSequence getText() {
        return this.a.getText();
    }

    public final TextView getDescView() {
        return this.b;
    }

    public final TextView getTextView() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextDescView(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        TextView r0 = new TextView(getContext());
        r0.setId(2131392533);
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), c.b(2130972079, r0.getContext(), 2131103136)));
        r0.setTextSize(0, i5.t());
        r0.setGravity(16);
        this.a = r0;
        TextView r1 = new TextView(getContext());
        r1.setId(2131392522);
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), c.b(2130972082, r1.getContext(), 2131103146)));
        r1.setTextSize(0, i5.t());
        r1.setGravity(8388629);
        this.b = r1;
        R5(r7, null);
    }

    public final void setDescText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.b.setText(r2);
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

    public final void setText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this.a.setText(r2);
    }

    public final void setTextColor(int r2) {
        this.a.setTextColor(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextDescView(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "attrs");
        super(r7, r8);
        TextView r0 = new TextView(getContext());
        r0.setId(2131392533);
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), c.b(2130972079, r0.getContext(), 2131103136)));
        r0.setTextSize(0, i5.t());
        r0.setGravity(16);
        this.a = r0;
        TextView r1 = new TextView(getContext());
        r1.setId(2131392522);
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), c.b(2130972082, r1.getContext(), 2131103146)));
        r1.setTextSize(0, i5.t());
        r1.setGravity(8388629);
        this.b = r1;
        R5(r7, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r8, AttributeSet r9) {
        TypedArray r10 = r8.obtainStyledAttributes(r9, new int[]{R.attr.textColor, R.attr.text, R.attr.textFontWeight, 2130971118});
        TextView r0 = this.a;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, -2);
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.startToStart = 0;
        Unit r4 = Unit.INSTANCE;
        addView(r0, r1);
        TextView r2 = this.a;
        String r5 = r10.getString(1);
        String r6 = "";
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r2.setText(r5);
        this.a.setTextColor(r10.getColor(0, ContextCompat.getColor(r8, c.b(2130972079, r8, 2131103136))));
        if (Build.VERSION.SDK_INT < 28) goto L8;
        this.a.setTypeface(Typeface.create(this.a.getTypeface(), r10.getInteger(2, 400), this.a.getTypeface().isItalic()));
    L8:
        this.a.setMaxLines(1);
        this.a.setEllipsize(TextUtils.TruncateAt.END);
        TextView r11 = this.b;
        ConstraintLayout.LayoutParams r3 = new ConstraintLayout.LayoutParams(0, -2);
        r3.topToTop = 0;
        r3.bottomToBottom = 0;
        r3.startToEnd = this.a.getId();
        r3.endToEnd = 0;
        r3.setMarginStart(i5.q());
        addView(r11, r3);
        TextView r12 = this.b;
        String r7 = r10.getString(3);
        if (r7 == null) goto L12;
        r6 = r7;
    L12:
        r12.setText(r6);
        this.b.setMaxLines(1);
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        int r13 = r10.getResources().getDimensionPixelSize(c.b(2130971208, null, 2131166786));
        int r14 = getPaddingTop();
        int r15 = getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r13 + ",top:" + r14 + ",end:" + r13 + ",bottom:" + r15);
        setPaddingRelative(r13, r14, r13, r15);
        setMinHeight(i5.h0());
        r10.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextDescView(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        super(r6, r7, r8);
        TextView r9 = new TextView(getContext());
        r9.setId(2131392533);
        r9.setTextColor(ContextCompat.getColor(r9.getContext(), c.b(2130972079, r9.getContext(), 2131103136)));
        r9.setTextSize(0, i5.t());
        r9.setGravity(16);
        this.a = r9;
        TextView r10 = new TextView(getContext());
        r10.setId(2131392522);
        r10.setTextColor(ContextCompat.getColor(r10.getContext(), c.b(2130972082, r10.getContext(), 2131103146)));
        r10.setTextSize(0, i5.t());
        r10.setGravity(8388629);
        this.b = r10;
        R5(r6, r7);
    }
}
