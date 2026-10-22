package com.obric.oui.forms;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.obric.oui.text.OTextView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/forms/OFormItem;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "", "initViews", "Lcom/obric/oui/text/OTextView;", "getLabelView", "Lcom/obric/oui/forms/OInputView;", "getInputView", "vInput", "Lcom/obric/oui/forms/OInputView;", "vLabel", "Lcom/obric/oui/text/OTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OFormItem extends LinearLayoutCompat {
    private final OInputView vInput;
    private final OTextView vLabel;

    @JvmOverloads
    public OFormItem(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OFormItem(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OFormItem(Context r17, AttributeSet r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        super(r17, r18, r19);
        OTextView r15 = new OTextView(new ContextThemeWrapper(r17, k.Label_L), null, 0, null, 14, null);
        this.vLabel = r15;
        OInputView r10 = new OInputView(r17, null, 0, 6, null);
        this.vInput = r10;
        setGravity(16);
        TypedArray r11 = r17.obtainStyledAttributes(r18, R.styleable.LinearLayoutCompat, r19, 0);
        int r12 = r11.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (r12 < 0) goto L5;
        setGravity(r12);
    L5:
        r11.recycle();
        addView(r15);
        addView(r10);
        initViews();
    }

    public /* synthetic */ OFormItem(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    private final void initViews() {
        this.vInput.setShowLabel(false);
        OTextView r10 = this.vLabel;
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        Objects.requireNonNull(r11, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
        LinearLayoutCompat.LayoutParams r12 = (LinearLayoutCompat.LayoutParams) r11;
        if (getOrientation() != 0) goto L5;
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        int r14 = MathKt.roundToInt(TypedValue.applyDimension(1, 72, r13.getDisplayMetrics()));
    L6:
        ((LinearLayout.LayoutParams) r12).width = r14;
        ((LinearLayout.LayoutParams) r12).height = -2;
        r10.setLayoutParams(r12);
        this.vLabel.setText("label");
        this.vInput.setHint("hint");
        OInputView r15 = this.vInput;
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        Objects.requireNonNull(r16, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
        LinearLayoutCompat.LayoutParams r17 = (LinearLayoutCompat.LayoutParams) r16;
        ((LinearLayout.LayoutParams) r17).weight = 1.0f;
        ((LinearLayout.LayoutParams) r17).width = -1;
        ((LinearLayout.LayoutParams) r17).height = -2;
        if (getOrientation() != 1) goto L10;
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        ((LinearLayout.LayoutParams) r17).topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 8, r18.getDisplayMetrics()));
    L12:
        r15.setLayoutParams(r17);
        return;
    L10:
        if (getOrientation() != 0) goto L12;
        float r19 = 12;
        Resources r20 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r20, "Resources.getSystem()");
        r17.setMarginStart(MathKt.roundToInt(TypedValue.applyDimension(1, r19, r20.getDisplayMetrics())));
        Resources r21 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r21, "Resources.getSystem()");
        ((LinearLayout.LayoutParams) r17).leftMargin = MathKt.roundToInt(TypedValue.applyDimension(1, r19, r21.getDisplayMetrics()));
        goto L12
    L5:
        r14 = -1;
        goto L6
    }

    public final OInputView getInputView() {
        return this.vInput;
    }

    public final OTextView getLabelView() {
        return this.vLabel;
    }
}
