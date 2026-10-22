package com.larus.bmhome.view.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusItemSpeechLanguageBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0015J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u0012J\u0006\u0010\u001c\u001a\u00020\u0012R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/view/item/ItemTextSelectorSubTitle;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/common_res/common_ui/databinding/LarusItemSpeechLanguageBinding;", "binding", "getBinding", "()Lcom/larus/common_res/common_ui/databinding/LarusItemSpeechLanguageBinding;", "init", "", "setMainTitle", "mainTitle", "", "setSubTitle", "subTitle", "setSelected", "selected", "", "showLoading", "hideLoading", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemTextSelectorSubTitle extends ConstraintLayout {
    public LarusItemSpeechLanguageBinding a;

    public final LarusItemSpeechLanguageBinding getBinding() {
        LarusItemSpeechLanguageBinding r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public ItemTextSelectorSubTitle(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        R5(r2, null);
    }

    public final void setMainTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "mainTitle");
        getBinding().c.setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSelected(boolean r2) {
        super/*android.view.ViewGroup*/.setSelected(r2);
        AppCompatImageView r0 = getBinding().d;
        if (r2 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public final void setSubTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "subTitle");
        getBinding().e.setText(r2);
    }

    public ItemTextSelectorSubTitle(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        R5(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r7, AttributeSet r8) {
        LayoutInflater.from(r7).inflate(2131562679, this);
        int r9 = 2131379091;
        ProgressBar r2 = (ProgressBar) ViewBindings.findChildViewById(this, 2131379091);
        if (r2 == null) goto L13;
        r9 = 2131379424;
        TextView r3 = (TextView) ViewBindings.findChildViewById(this, 2131379424);
        if (r3 == null) goto L13;
        r9 = 2131385826;
        AppCompatImageView r4 = ViewBindings.findChildViewById(this, 2131385826);
        if (r4 == null) goto L13;
        r9 = 2131387517;
        TextView r5 = (TextView) ViewBindings.findChildViewById(this, 2131387517);
        if (r5 == null) goto L13;
        this.a = new LarusItemSpeechLanguageBinding(this, r2, r3, r4, r5);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r9)));
    }

    public ItemTextSelectorSubTitle(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        R5(r2, r3);
    }
}
