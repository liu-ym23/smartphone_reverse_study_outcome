package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.obric.memorydata.plugin.R;
import com.obric.oui.common.util.h;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/forms/OFormItem;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vInput", "Lcom/obric/oui/forms/OInputView;", "vLabel", "Lcom/obric/oui/text/OTextView;", "getInputView", "getLabelView", "initViews", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFormItem extends LinearLayoutCompat {
    private final OInputView vInput;
    private final OTextView vLabel;

    public OFormItem(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OFormItem(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public OFormItem(Context r10, AttributeSet r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r12);
        OTextView r0 = new OTextView((Context) ZeusTransformUtils.preCheckCast(new ContextThemeWrapper(r13, ZeusTransformUtils.mapRes(R.style.Label_L, "style", "Label_L")), Context.class, "com.obric.memorydata.plugin"), null, 0, null, 14, null);
        this.vLabel = r0;
        OInputView r8 = new OInputView(r13, null, 0, 6, null);
        this.vInput = r8;
        setGravity(16);
        TypedArray r15 = r13.obtainStyledAttributes(r14, R.styleable.LinearLayoutCompat, r12, 0);
        int r16 = r15.getInt(ZeusTransformUtils.mapRes(R.styleable.LinearLayoutCompat_android_gravity, "styleable", "LinearLayoutCompat_android_gravity"), -1);
        if (r16 < 0) goto L5;
        setGravity(r16);
    L5:
        r15.recycle();
        addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        addView((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.memorydata.plugin"));
        initViews();
    }

    public /* synthetic */ OFormItem(Context r2, AttributeSet r3, int r4, int r5, DefaultConstructorMarker r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    private final void initViews() {
        this.vInput.setShowLabel(false);
        View r0 = (View) ZeusTransformUtils.preCheckCast(this.vLabel, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
        ViewGroup.LayoutParams r2 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r1, LinearLayoutCompat.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        LinearLayoutCompat.LayoutParams r4 = (LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r2, LinearLayoutCompat.LayoutParams.class, "com.obric.memorydata.plugin");
        if (getOrientation() != 0) goto L5;
        int r5 = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 72);
    L6:
        r4.width = r5;
        r4.height = -2;
        r0.setLayoutParams(r2);
        this.vLabel.setText((CharSequence) ZeusTransformUtils.preCheckCast(AnnotatedPrivateKey.LABEL, CharSequence.class, "com.obric.memorydata.plugin"));
        this.vInput.setHint("hint");
        View r3 = (View) ZeusTransformUtils.preCheckCast(this.vInput, View.class, "com.obric.memorydata.plugin");
        ViewGroup.LayoutParams r6 = r3.getLayoutParams();
        Objects.requireNonNull(r6, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
        ViewGroup.LayoutParams r7 = (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast((LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r6, LinearLayoutCompat.LayoutParams.class, "com.obric.memorydata.plugin"), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin");
        LinearLayoutCompat.LayoutParams r8 = (LinearLayoutCompat.LayoutParams) ZeusTransformUtils.preCheckCast(r7, LinearLayoutCompat.LayoutParams.class, "com.obric.memorydata.plugin");
        r8.weight = 1.0f;
        r8.width = -1;
        r8.height = -2;
        if (getOrientation() != 1) goto L10;
        r8.topMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 8);
    L12:
        r3.setLayoutParams(r7);
        return;
    L10:
        if (getOrientation() != 0) goto L12;
        r8.setMarginStart(h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12));
        r8.leftMargin = h.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.memorydata.plugin"), 12);
        goto L12
    L5:
        r5 = -1;
        goto L6
    }

    public final OInputView getInputView() {
        return this.vInput;
    }

    public final OTextView getLabelView() {
        return this.vLabel;
    }
}
