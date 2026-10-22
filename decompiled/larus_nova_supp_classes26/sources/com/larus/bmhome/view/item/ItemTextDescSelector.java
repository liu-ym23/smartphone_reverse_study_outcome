package com.larus.bmhome.view.item;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.common_res.common_ui.databinding.LarusItemTextDescSelectorBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\nR\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00138F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006#"}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextDescSelector;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/common_res/common_ui/databinding/LarusItemTextDescSelectorBinding;", "binding", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusItemTextDescSelectorBinding;", "init", "", "", ShareType.TEXT, "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "descText", "getDescText", "setDescText", "setSelected", "selected", "", "showLoading", "hideLoading", "setTextFontWeight", "weight", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemTextDescSelector extends ConstraintLayout {
    public LarusItemTextDescSelectorBinding a;

    public final LarusItemTextDescSelectorBinding getBinding() {
        LarusItemTextDescSelectorBinding r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final CharSequence getDescText() {
        return getBinding().d.getText();
    }

    public final CharSequence getText() {
        return getBinding().b.getText();
    }

    public ItemTextDescSelector(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        R5(r2, null);
    }

    public final void setDescText(CharSequence r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        getBinding().d.setText(r3);
        TextView r0 = getBinding().d;
        int r1 = 0;
        if (r3.length() <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L9;
        r1 = 8;
    L9:
        r0.setVisibility(r1);
        return;
    L5:
        r4 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSelected(boolean r2) {
        super/*android.view.ViewGroup*/.setSelected(r2);
        ImageView r0 = getBinding().c;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        getBinding().b.setText(r2);
    }

    public final void setTextFontWeight(int r3) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Typeface r4 = Typeface.create(getBinding().b.getTypeface(), r3, getBinding().b.getTypeface().isItalic());
        getBinding().b.setTypeface(r4);
        return;
    }

    public ItemTextDescSelector(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        R5(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r5, AttributeSet r6) {
        LayoutInflater.from(r5).inflate(2131562693, this);
        int r0 = 2131367728;
        if (ViewBindings.findChildViewById(this, 2131367728) == null) goto L22;
        r0 = 2131379091;
        if (((ProgressBar) ViewBindings.findChildViewById(this, 2131379091)) == null) goto L22;
        r0 = 2131379424;
        TextView r1 = (TextView) ViewBindings.findChildViewById(this, 2131379424);
        if (r1 == null) goto L22;
        r0 = 2131385826;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(this, 2131385826);
        if (r2 == null) goto L22;
        r0 = 2131387517;
        TextView r3 = (TextView) ViewBindings.findChildViewById(this, 2131387517);
        if (r3 == null) goto L22;
        this.a = new LarusItemTextDescSelectorBinding(this, r1, r2, r3);
        TypedArray r7 = r5.obtainStyledAttributes(r6, new int[]{R.attr.text, 2130971117});
        TextView r8 = getBinding().b;
        String r4 = r7.getString(0);
        String r9 = "";
        if (r4 != null) goto L15;
        r4 = "";
    L15:
        r8.setText(r4);
        TextView r10 = getBinding().d;
        String r11 = r7.getString(1);
        if (r11 == null) goto L19;
        r9 = r11;
    L19:
        r10.setText(r9);
        return;
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r0)));
    }

    public ItemTextDescSelector(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        R5(r2, r3);
    }
}
