package com.larus.bmhome.view.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.share.panel.ShareType;
import it8.a;
import it8.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010$\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020#J\b\u0010(\u001a\u00020%H\u0002J\u001f\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010-J\u0015\u0010.\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020%2\u0006\u0010*\u001a\u00020+J\b\u00101\u001a\u00020%H\u0002J\b\u00102\u001a\u00020%H\u0002J\u0006\u00103\u001a\u00020%J\u0006\u00104\u001a\u00020#J\u0006\u00105\u001a\u00020%J\u0006\u00106\u001a\u00020%J'\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020\n2\u0006\u0010*\u001a\u0002092\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020#H\u0002J\u000e\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020\nJ\u0006\u0010?\u001a\u00020%J\u000e\u0010@\u001a\u00020%2\u0006\u0010*\u001a\u000209J\u0006\u0010A\u001a\u00020%R&\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextArrow;", "Lcom/larus/bmhome/view/item/ItemTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "style", "getStyle", "()I", "setStyle", "(I)V", "subTextView", "Landroid/widget/TextView;", "getSubTextView", "()Landroid/widget/TextView;", "arrowView", "Landroid/widget/ImageView;", "getArrowView", "()Landroid/widget/ImageView;", "redDot", "waringImg", "loadingView", "Landroid/widget/ProgressBar;", "iconView", "getIconView", "setIconView", "(Landroid/widget/ImageView;)V", "isLongSubText", "", "init", "", "setVisible", "visible", "updateSubTextviewMaxWidth", "setSubText", ShareType.TEXT, "", "textColor", "(Ljava/lang/CharSequence;Ljava/lang/Integer;)V", "setSubTextColor", "(Ljava/lang/Integer;)V", "socialSetSubText", "setGrayStyle", "setOriginStyle", "showLoading", "isLoading", "resetTextColor", "hideLoading", "showIconWithText", "icon", "", "(ILjava/lang/String;Ljava/lang/Integer;)V", "updateLongSubTextLayout", "compact", "showWaringDot", "sourceId", "disMissWardingImg", "showRedDot", "disMissRedDot", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ItemTextArrow extends ItemTextView {
    public static final /* synthetic */ int k = 0;
    public int c;
    public final TextView d;
    public final ImageView e;
    public final ImageView f;
    public final ImageView g;
    public final ProgressBar h;
    public ImageView i;
    public boolean j;

    public static /* synthetic */ void T5(ItemTextArrow r0) {
        setVisible$lambda$14(r0);
    }

    public final void U5() {
        this.f.setVisibility(8);
        ConstraintLayout.LayoutParams r0 = this.d.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r1.setMarginEnd(0);
    L8:
        this.d.setLayoutParams(r1);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void V5() {
        ImageView r0 = this.i;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.g.setVisibility(8);
        k6(false);
        this.d.setVisibility(0);
        this.h.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5() {
        this.d.setTextColor(ContextCompat.getColor(getContext(), c.b(2130972081, getContext(), 2131103143)));
    }

    public final void c6() {
        ImageView r0 = this.i;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        k6(false);
        this.d.setVisibility(8);
        this.h.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n6() {
        int r0 = ((((getWidth() - getImageView().getWidth()) - this.e.getWidth()) - i5.h()) - (i5.q() * 2)) / 2;
        this.d.setMaxWidth(r0);
    }

    public final ImageView getArrowView() {
        return this.e;
    }

    public final ImageView getIconView() {
        return this.i;
    }

    public final int getStyle() {
        return this.c;
    }

    public final TextView getSubTextView() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextArrow(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7);
        this.c = 1;
        TextView r0 = new TextView(getContext());
        r0.setId(2131392531);
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), c.b(2130972081, r0.getContext(), 2131103143)));
        r0.setTextSize(0, i5.t());
        r0.setGravity(16);
        this.d = r0;
        ImageView r1 = new ImageView(getContext());
        r1.setId(2131392521);
        r1.setImageResource(c.b(2130971641, r1.getContext(), 2131240848));
        r1.setVisibility(0);
        this.e = r1;
        ImageView r2 = new ImageView(getContext());
        r2.setId(2131392529);
        r2.setImageResource(2131242313);
        r2.setVisibility(8);
        this.f = r2;
        ImageView r3 = new ImageView(getContext());
        r3.setId(2131392537);
        r3.setVisibility(8);
        this.g = r3;
        ProgressBar r4 = new ProgressBar(getContext(), null, 0, 2131954353);
        r4.setId(2131392526);
        r4.setVisibility(8);
        this.h = r4;
        R5(r7, null);
    }

    private static final void setVisible$lambda$14(ItemTextArrow r0) {
        r0.n6();
    }

    public final void i6(String r3) {
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        k6(false);
        this.f.setVisibility(0);
        ConstraintLayout.LayoutParams r0 = this.d.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L5;
        ConstraintLayout.LayoutParams r1 = r0;
    L6:
        if (r1 == null) goto L8;
        r1.endToStart = this.f.getId();
        r1.setMarginEnd(i5.r0());
    L8:
        this.d.setLayoutParams(r1);
        this.d.setText(r3);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void k6(boolean r5) {
        if (this.j == true) goto L5;
        return;
    L5:
        ConstraintLayout.LayoutParams r0 = this.d.getLayoutParams();
        if ((r0 instanceof ConstraintLayout.LayoutParams) == false) goto L8;
        ConstraintLayout.LayoutParams r1 = r0;
    L9:
        if (r1 != null) goto L11;
    L37:
        this.d.setLayoutParams(r1);
        return;
    L11:
        if (r5 == false) goto L13;
        int r2 = -2;
    L14:
        ((ViewGroup.MarginLayoutParams) r1).width = r2;
        int r3 = -1;
        if (r5 == false) goto L17;
        int r4 = -1;
    L18:
        r1.startToEnd = r4;
        r1.startToStart = -1;
        if (r5 == false) goto L21;
        int r6 = 0;
    L22:
        r1.setMarginStart(r6);
        boolean r7 = true;
        if (this.e.getVisibility() != 0) goto L25;
        boolean r8 = true;
    L26:
        if (r8 == false) goto L28;
        int r9 = this.e.getId();
    L29:
        r1.endToStart = r9;
        if (this.e.getVisibility() == 0) goto L33;
        r7 = false;
    L33:
        if (r7 == true) goto L36;
        r3 = 0;
    L36:
        r1.endToEnd = r3;
        r1.setMarginEnd(0);
        goto L37
    L28:
        r9 = -1;
        goto L29
    L25:
        r8 = false;
        goto L26
    L21:
        r6 = i5.h();
        goto L22
    L17:
        r4 = getTextView().getId();
        goto L18
    L13:
        r2 = 0;
        goto L14
    L8:
        r1 = null;
        goto L9
    }

    public final void setIconView(ImageView r1) {
        this.i = r1;
    }

    public final void setStyle(int r2) {
        this.c = r2;
        if (r2 != 0) goto L5;
        getImageView().setAlpha(0.5f);
        getTextView().setAlpha(0.3f);
        this.d.setAlpha(0.6f);
        this.e.setAlpha(0.6f);
        this.h.setVisibility(8);
        return;
    L5:
        if (r2 != 1) goto L11;
        getImageView().setAlpha(1.0f);
        getTextView().setAlpha(1.0f);
        this.d.setAlpha(1.0f);
        this.e.setAlpha(1.0f);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setSubTextColor(Integer r5) {
        TextView r0 = this.d;
        if (r5 == null) goto L5;
        int r6 = r5.intValue();
    L6:
        r0.setTextColor(r6);
        return;
    L5:
        r6 = ContextCompat.getColor(getContext(), c.b(2130972081, getContext(), 2131103143));
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setVisible(boolean r2) {
        if (r2 == false) goto L4;
        int r0 = 0;
    L5:
        setVisibility(r0);
        if (r2 == true) goto L8;
        return;
    L8:
        if (this.d.getMaxWidth() > 0) goto L12;
        post(new b(this));
        return;
    L12:
        return;
    L4:
        r0 = 8;
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextArrow(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "attrs");
        super(r7, r8);
        this.c = 1;
        TextView r0 = new TextView(getContext());
        r0.setId(2131392531);
        r0.setTextColor(ContextCompat.getColor(r0.getContext(), c.b(2130972081, r0.getContext(), 2131103143)));
        r0.setTextSize(0, i5.t());
        r0.setGravity(16);
        this.d = r0;
        ImageView r1 = new ImageView(getContext());
        r1.setId(2131392521);
        r1.setImageResource(c.b(2130971641, r1.getContext(), 2131240848));
        r1.setVisibility(0);
        this.e = r1;
        ImageView r2 = new ImageView(getContext());
        r2.setId(2131392529);
        r2.setImageResource(2131242313);
        r2.setVisibility(8);
        this.f = r2;
        ImageView r3 = new ImageView(getContext());
        r3.setId(2131392537);
        r3.setVisibility(8);
        this.g = r3;
        ProgressBar r4 = new ProgressBar(getContext(), null, 0, 2131954353);
        r4.setId(2131392526);
        r4.setVisibility(8);
        this.h = r4;
        R5(r7, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R5(Context r10, AttributeSet r11) {
        TypedArray r12 = r10.obtainStyledAttributes(r11, new int[]{2130972036, 2130972317, 2130972318});
        boolean r1 = r12.getBoolean(0, false);
        this.j = r1;
        boolean r2 = r12.getBoolean(2, false);
        ImageView r3 = this.e;
        ConstraintLayout.LayoutParams r4 = new ConstraintLayout.LayoutParams(-2, -2);
        r4.topToTop = 0;
        r4.bottomToBottom = 0;
        r4.endToEnd = 0;
        Unit r6 = Unit.INSTANCE;
        addView(r3, r4);
        ImageView r5 = this.f;
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(i5.r0(), i5.r0());
        r7.topToTop = 0;
        r7.bottomToBottom = 0;
        r7.endToStart = this.e.getId();
        addView(r5, r7);
        TextView r8 = this.d;
        ConstraintLayout.LayoutParams r9 = new ConstraintLayout.LayoutParams(-2, -2);
        r9.topToTop = 0;
        r9.bottomToBottom = 0;
        boolean r13 = true;
        if (this.e.getVisibility() != 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L8;
        int r15 = this.e.getId();
    L9:
        r9.endToStart = r15;
        if (r1 == false) goto L12;
        ((ViewGroup.MarginLayoutParams) r9).width = 0;
        r9.startToEnd = getTextView().getId();
        r9.setMarginStart(i5.h());
        this.d.setGravity(8388629);
        this.d.setTextAlignment(6);
        this.d.setMaxLines(1);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
    L12:
        if (r2 == false) goto L14;
        this.d.setTextDirection(3);
    L14:
        addView(r8, r9);
        ImageView r0 = this.g;
        ConstraintLayout.LayoutParams r16 = new ConstraintLayout.LayoutParams(-2, -2);
        r16.topToTop = 0;
        r16.bottomToBottom = 0;
        r16.endToStart = this.d.getId();
        addView(r0, r16);
        ProgressBar r17 = this.h;
        ConstraintLayout.LayoutParams r18 = new ConstraintLayout.LayoutParams(i5.m(), i5.m());
        r18.topToTop = 0;
        r18.bottomToBottom = 0;
        if (this.e.getVisibility() != 0) goto L17;
        boolean r19 = true;
    L18:
        if (r19 == false) goto L20;
        r18.endToStart = this.e.getId();
    L21:
        addView(r17, r18);
        TextView r20 = this.d;
        r20.setEllipsize(TextUtils.TruncateAt.END);
        r20.setSingleLine(true);
        String r21 = r12.getString(1);
        if (r21 != null) goto L24;
        r21 = "";
    L24:
        r20.setText(r21);
        r20.setGravity(8388613);
        if (r1 == true) goto L27;
        post(new a(this));
    L27:
        TextView r22 = getTextView();
        if (r1 == false) goto L30;
        int r23 = -2;
    L31:
        ConstraintLayout.LayoutParams r24 = new ConstraintLayout.LayoutParams(r23, -2);
        r24.topToTop = 0;
        r24.bottomToBottom = 0;
        r24.startToEnd = getImageView().getId();
        if (getImageView().getVisibility() != 0) goto L34;
        boolean r25 = true;
    L35:
        if (r25 == false) goto L37;
        r24.setMarginStart(i5.q());
        r24.setMarginEnd(0);
    L38:
        if (r1 == false) goto L40;
    L52:
        r22.setLayoutParams(r24);
        r12.recycle();
        return;
    L40:
        if (this.d.getVisibility() != 0) goto L42;
        boolean r26 = true;
    L43:
        if (r26 == false) goto L46;
        r24.endToStart = this.d.getId();
        r24.setMarginEnd(i5.h());
        goto L52
    L46:
        if (this.e.getVisibility() == 0) goto L49;
        r13 = false;
    L49:
        if (r13 == false) goto L51;
        r24.endToStart = this.e.getId();
        goto L52
    L51:
        r24.endToEnd = 0;
        goto L52
    L42:
        r26 = false;
        goto L43
    L37:
        r24.setMarginStart(0);
        r24.setMarginEnd(0);
        goto L38
    L34:
        r25 = false;
        goto L35
    L30:
        r23 = 0;
        goto L31
    L20:
        r18.endToEnd = 0;
        goto L21
    L17:
        r19 = false;
        goto L18
    L8:
        r15 = 0;
        goto L9
    L5:
        r14 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z5(CharSequence r5, Integer r6) {
        Intrinsics.checkNotNullParameter(r5, ShareType.TEXT);
        ImageView r0 = this.i;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        k6(false);
        this.d.setText(r5);
        TextView r7 = this.d;
        if (r6 == null) goto L8;
        int r8 = r6.intValue();
    L9:
        r7.setTextColor(r8);
        ConstraintLayout.LayoutParams r9 = this.d.getLayoutParams();
        if ((r9 instanceof ConstraintLayout.LayoutParams) == false) goto L12;
        ConstraintLayout.LayoutParams r10 = r9;
    L13:
        if (r10 == null) goto L15;
        r10.setMarginEnd(0);
    L15:
        this.d.setLayoutParams(r10);
        return;
    L12:
        r10 = null;
        goto L13
    L8:
        r8 = ContextCompat.getColor(getContext(), c.b(2130972081, getContext(), 2131103143));
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b6(String r6, Integer r7) {
        Intrinsics.checkNotNullParameter(r6, ShareType.TEXT);
        if (this.j == false) goto L6;
        k6(true);
    L6:
        if (this.i != null) goto L8;
        ImageView r0 = new ImageView(getContext());
        r0.setId(2131392523);
        this.i = r0;
        ConstraintLayout.LayoutParams r2 = new ConstraintLayout.LayoutParams(i5.m(), i5.m());
        r2.topToTop = 0;
        r2.bottomToBottom = 0;
        r2.endToStart = this.d.getId();
        r2.setMarginEnd(i5.z());
        Unit r3 = Unit.INSTANCE;
        addView(r0, r2);
    L8:
        ImageView r1 = this.i;
        if (r1 == null) goto L11;
        r1.setImageResource(2131241532);
    L11:
        this.h.setVisibility(8);
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        ImageView r4 = this.i;
        if (r4 == null) goto L14;
        r4.setVisibility(0);
    L14:
        this.d.setVisibility(0);
        if (r7 == null) goto L17;
        this.d.setTextColor(r7.intValue());
    L17:
        this.d.setText(r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ItemTextArrow(Context r6, AttributeSet r7, int r8) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        super(r6, r7, r8);
        this.c = 1;
        TextView r9 = new TextView(getContext());
        r9.setId(2131392531);
        r9.setTextColor(ContextCompat.getColor(r9.getContext(), c.b(2130972081, r9.getContext(), 2131103143)));
        r9.setTextSize(0, i5.t());
        r9.setGravity(16);
        this.d = r9;
        ImageView r10 = new ImageView(getContext());
        r10.setId(2131392521);
        r10.setImageResource(c.b(2130971641, r10.getContext(), 2131240848));
        r10.setVisibility(0);
        this.e = r10;
        ImageView r11 = new ImageView(getContext());
        r11.setId(2131392529);
        r11.setImageResource(2131242313);
        r11.setVisibility(8);
        this.f = r11;
        ImageView r12 = new ImageView(getContext());
        r12.setId(2131392537);
        r12.setVisibility(8);
        this.g = r12;
        ProgressBar r13 = new ProgressBar(getContext(), null, 0, 2131954353);
        r13.setId(2131392526);
        r13.setVisibility(8);
        this.h = r13;
        R5(r6, r7);
    }
}
