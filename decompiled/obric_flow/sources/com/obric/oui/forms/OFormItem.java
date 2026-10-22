package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.obric.common.oui.R$style;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/forms/OFormItem;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/obric/oui/text/OTextView;", "getLabelView", "()Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/forms/OInputView;", "getInputView", "()Lcom/obric/oui/forms/OInputView;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFormItem extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OTextView f13251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OInputView f13252b;

    @JvmOverloads
    public OFormItem(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    public final OInputView getInputView() {
        return this.f13252b;
    }

    public final OTextView getLabelView() {
        return this.f13251a;
    }

    @JvmOverloads
    public OFormItem(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OFormItem(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OFormItem(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        OTextView r5 = new OTextView(new ContextThemeWrapper(r10, R$style.Label_L), null, 0, 14);
        this.f13251a = r5;
        OInputView r13 = new OInputView(r10, null, 6, 0);
        this.f13252b = r13;
        setGravity(16);
        TypedArray r14 = r10.obtainStyledAttributes(r11, R.styleable.LinearLayoutCompat, r12, 0);
        int r15 = r14.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (r15 < 0) goto L5;
        setGravity(r15);
    L5:
        r14.recycle();
        addView(r5);
        addView(r13);
        r13.setShowLabel(false);
        ViewGroup.LayoutParams r16 = r5.getLayoutParams();
        if (r16 == null) goto L24;
        LinearLayoutCompat.LayoutParams r17 = (LinearLayoutCompat.LayoutParams) r16;
        if (getOrientation() != 0) goto L10;
        int r18 = com.lynx.tasm.utils.a.B(72, this);
    L11:
        ((LinearLayout.LayoutParams) r17).width = r18;
        ((LinearLayout.LayoutParams) r17).height = -2;
        r5.setLayoutParams(r17);
        r5.setText("label");
        r13.setHint("hint");
        ViewGroup.LayoutParams r19 = r13.getLayoutParams();
        if (r19 == null) goto L22;
        LinearLayoutCompat.LayoutParams r20 = (LinearLayoutCompat.LayoutParams) r19;
        ((LinearLayout.LayoutParams) r20).weight = 1.0f;
        ((LinearLayout.LayoutParams) r20).width = -1;
        ((LinearLayout.LayoutParams) r20).height = -2;
        if (getOrientation() != 1) goto L17;
        ((LinearLayout.LayoutParams) r20).topMargin = com.lynx.tasm.utils.a.B(8, this);
    L19:
        r13.setLayoutParams(r20);
        return;
    L17:
        if (getOrientation() != 0) goto L19;
        r20.setMarginStart(com.lynx.tasm.utils.a.B(12, this));
        ((LinearLayout.LayoutParams) r20).leftMargin = com.lynx.tasm.utils.a.B(12, this);
        goto L19
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
    L10:
        r18 = -1;
        goto L11
    L24:
        throw new NullPointerException("null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
    }
}
