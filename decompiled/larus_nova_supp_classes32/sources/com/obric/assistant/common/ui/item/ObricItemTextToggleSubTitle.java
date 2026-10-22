package com.obric.assistant.common.ui.item;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.view.item.ItemTextView;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\rJ\u0006\u0010\u001f\u001a\u00020\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/assistant/common/ui/item/ObricItemTextToggleSubTitle;", "Lcom/larus/bmhome/view/item/ItemTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "setEnabled", NameKeys.UnloadStrategy_No_Strategy, "enabled", NameKeys.UnloadStrategy_No_Strategy, "toggleView", "Lcom/obric/oui/oswitch/OSwitch;", "getToggleView", "()Lcom/obric/oui/oswitch/OSwitch;", "subTitle", "Lcom/obric/oui/text/OTextView;", "getSubTitle", "()Lcom/obric/oui/text/OTextView;", "redDot", "Landroid/widget/ImageView;", "init", "setSubTitle", "subTitleText", NameKeys.UnloadStrategy_No_Strategy, "showRedDot", "disMissRedDot", "utils_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricItemTextToggleSubTitle extends ItemTextView {
    public final OSwitch c;
    public final OTextView d;
    public final ImageView e;

    public final OTextView getSubTitle() {
        return this.d;
    }

    public final OSwitch getToggleView() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricItemTextToggleSubTitle(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        OSwitch r0 = new OSwitch(getContext(), null, 6, 0);
        r0.setId(2131392535);
        r0.setChecked(true);
        this.c = r0;
        OTextView r1 = new OTextView(getContext(), null, 0, 14);
        r1.setId(2131392532);
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), 2131103146));
        r1.setTextSize(0, i5.h());
        r1.setGravity(16);
        this.d = r1;
        ImageView r2 = new ImageView(getContext());
        r2.setId(2131392529);
        r2.setImageResource(2131242313);
        r2.setVisibility(8);
        this.e = r2;
        R5(r6, null);
    }

    public void setEnabled(boolean r2) {
        super.setEnabled(r2);
        this.c.setEnabled(r2);
    }

    public final void setSubTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "subTitleText");
        this.d.setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricItemTextToggleSubTitle(Context r6, AttributeSet r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "attrs");
        super(r6, r7);
        OSwitch r0 = new OSwitch(getContext(), null, 6, 0);
        r0.setId(2131392535);
        r0.setChecked(true);
        this.c = r0;
        OTextView r1 = new OTextView(getContext(), null, 0, 14);
        r1.setId(2131392532);
        r1.setTextColor(ContextCompat.getColor(r1.getContext(), 2131103146));
        r1.setTextSize(0, i5.h());
        r1.setGravity(16);
        this.d = r1;
        ImageView r2 = new ImageView(getContext());
        r2.setId(2131392529);
        r2.setImageResource(2131242313);
        r2.setVisibility(8);
        this.e = r2;
        R5(r6, r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R5(Context r8, AttributeSet r9) {
        TypedArray r10 = r8.obtainStyledAttributes(r9, new int[]{2130972928, 2130972929});
        getTextView().setTextSize(0, i5.q());
        OSwitch r11 = this.c;
        ConstraintLayout.LayoutParams r1 = new ConstraintLayout.LayoutParams(-2, -2);
        r1.topToTop = 0;
        r1.bottomToBottom = 0;
        r1.endToEnd = 0;
        Unit r4 = Unit.INSTANCE;
        addView(r11, r1);
        boolean r12 = true;
        int r2 = r10.getInt(1, 0);
        OSwitch r5 = this.c;
        if (r2 == 0) goto L7;
        if (r2 == 1) goto L6;
        int r3 = 8;
    L8:
        r5.setVisibility(r3);
        ImageView r6 = this.e;
        ConstraintLayout.LayoutParams r7 = new ConstraintLayout.LayoutParams(i5.r0(), i5.r0());
        r7.topToTop = getTextView().getId();
        r7.bottomToBottom = getTextView().getId();
        r7.startToEnd = getTextView().getId();
        r7.setMarginStart(i5.j0());
        addView(r6, r7);
        OTextView r13 = this.d;
        ConstraintLayout.LayoutParams r14 = new ConstraintLayout.LayoutParams(0, -2);
        ((ViewGroup.MarginLayoutParams) r14).width = 0;
        r14.topToBottom = getTextView().getId();
        r14.bottomToBottom = 0;
        r14.startToStart = getTextView().getId();
        r14.endToStart = this.c.getId();
        r14.verticalChainStyle = 2;
        ((ViewGroup.MarginLayoutParams) r14).topMargin = i5.z();
        addView(r13, r14);
        OTextView r15 = this.d;
        String r16 = r10.getString(0);
        if (r16 != null) goto L11;
        r16 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        r15.setText(r16);
        ConstraintLayout.LayoutParams r17 = getTextView().getLayoutParams();
        if ((r17 instanceof ConstraintLayout.LayoutParams) == false) goto L14;
        ConstraintLayout.LayoutParams r18 = r17;
    L15:
        if (r18 == null) goto L24;
        ((ViewGroup.MarginLayoutParams) r18).width = 0;
        r18.topToTop = 0;
        r18.bottomToTop = this.d.getId();
        r18.startToEnd = getImageView().getId();
        r18.endToStart = this.c.getId();
        r18.endToEnd = -1;
        r18.verticalChainStyle = 2;
        if (getImageView().getVisibility() == 0) goto L20;
        r12 = false;
    L20:
        if (r12 == false) goto L22;
        r18.setMarginStart(i5.q());
        r18.setMarginEnd(i5.r0());
    L23:
        getTextView().setGravity(8388611);
        goto L24
    L22:
        r18.setMarginStart(0);
        r18.setMarginEnd(i5.r0());
    L24:
        ConstraintLayout.LayoutParams r19 = this.d.getLayoutParams();
        if ((r19 instanceof ConstraintLayout.LayoutParams) == false) goto L27;
        ConstraintLayout.LayoutParams r20 = r19;
    L28:
        if (r20 == null) goto L30;
        r20.setMarginEnd(i5.r0());
    L30:
        int r21 = i5.h();
        int r0 = i5.r0();
        int r22 = getPaddingTop();
        int r23 = getPaddingBottom();
        FLogger.a.i("updatePaddingRelative", "view:" + getClass().getSimpleName() + ",source:,start:" + r21 + ",top:" + r22 + ",end:" + r0 + ",bottom:" + r23);
        setPaddingRelative(r21, r22, r0, r23);
        setMinHeight(r10.getResources().getDimensionPixelSize(c.b(2130971522, null, 2131167413)));
        r10.recycle();
        return;
    L27:
        r20 = null;
        goto L28
    L14:
        r18 = null;
        goto L15
    L6:
        r3 = 4;
        goto L8
    L7:
        r3 = 0;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricItemTextToggleSubTitle(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "attrs");
        super(r5, r6, r7);
        OSwitch r8 = new OSwitch(getContext(), null, 6, 0);
        r8.setId(2131392535);
        r8.setChecked(true);
        this.c = r8;
        OTextView r9 = new OTextView(getContext(), null, 0, 14);
        r9.setId(2131392532);
        r9.setTextColor(ContextCompat.getColor(r9.getContext(), 2131103146));
        r9.setTextSize(0, i5.h());
        r9.setGravity(16);
        this.d = r9;
        ImageView r10 = new ImageView(getContext());
        r10.setId(2131392529);
        r10.setImageResource(2131242313);
        r10.setVisibility(8);
        this.e = r10;
        R5(r5, r6);
    }
}
