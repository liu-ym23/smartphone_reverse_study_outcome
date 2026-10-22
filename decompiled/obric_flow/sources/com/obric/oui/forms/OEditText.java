package com.obric.oui.forms;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.obric.common.oui.R$color;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0004\u001a!\"#B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/obric/oui/forms/OEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getLeftFadingEdgeStrength", "()F", "getRightFadingEdgeStrength", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "Landroid/view/View$OnTouchListener;", "l", "", "setOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "Landroid/view/View$OnFocusChangeListener;", "getOnFocusChangeListener", "()Landroid/view/View$OnFocusChangeListener;", "setOnFocusChangeListener", "(Landroid/view/View$OnFocusChangeListener;)V", "Lcom/obric/oui/forms/d;", "commitCompletionListener", "Lcom/obric/oui/forms/d;", "getCommitCompletionListener", "()Lcom/obric/oui/forms/d;", "setCommitCompletionListener", "(Lcom/obric/oui/forms/d;)V", "com/obric/oui/forms/e", "com/obric/oui/forms/f", "com/obric/oui/forms/c", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f13245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f13246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f13247c;
    public boolean d;

    @JvmOverloads
    public OEditText(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    public final d getCommitCompletionListener() {
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    public View.OnFocusChangeListener getOnFocusChangeListener() {
        View.OnFocusChangeListener r5 = super.getOnFocusChangeListener();
        if ((r5 instanceof e) == true) goto L5;
        return r5;
    L5:
        return ((e) r5).f13333b;
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r5, int r10) {
        super.onSelectionChanged(r5, r10);
        if (r5 == r10) goto L5;
        boolean r11 = true;
    L7:
        if (this.d == true) goto L11;
        if (r11 == false) goto L12;
        com.lynx.tasm.utils.g.p(3, getContext());
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r11 = false;
        goto L7
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean performLongClick() {
        this.d = true;
        boolean r5 = super.performLongClick();
        this.d = false;
        return r5;
    }

    public final void setCommitCompletionListener(d r5) {
    }

    @Override // android.view.View
    public void setOnFocusChangeListener(View.OnFocusChangeListener r5) {
        if ((r5 instanceof e) == false) goto L5;
        super.setOnFocusChangeListener(r5);
        return;
    L5:
        this.f13245a.f13333b = r5;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener r5) {
        this.f13246b.f13335b = r5;
    }

    @JvmOverloads
    public OEditText(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ OEditText(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public OEditText(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        e r12 = new e();
        this.f13245a = r12;
        f r13 = new f();
        this.f13246b = r13;
        c r14 = new c();
        this.f13247c = r14;
        setOnFocusChangeListener(r12);
        super.setOnTouchListener(r13);
        addTextChangedListener(r14);
        setHighlightColor(r5.getColor(R$color.oui_text_highlight_color));
    }
}
