package com.larus.setting.impl.thirdpartyaccount.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.setting.impl.databinding.LarusItemMusicAccountBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0012J\u0006\u0010\u001a\u001a\u00020\u0012R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/setting/impl/thirdpartyaccount/view/ItemTextSelectorSubTitle;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/larus/setting/impl/databinding/LarusItemMusicAccountBinding;", "binding", "getBinding", "()Lcom/larus/setting/impl/databinding/LarusItemMusicAccountBinding;", "init", "", "setTitle", "mainTitle", "", "setSelected", "selected", "", "showLoading", "hideLoading", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ItemTextSelectorSubTitle extends ConstraintLayout {
    public LarusItemMusicAccountBinding a;

    public final LarusItemMusicAccountBinding getBinding() {
        LarusItemMusicAccountBinding r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        LarusItemMusicAccountBinding r0 = getBinding();
        ImageView r1 = r0.d;
        if (isSelected() == false) goto L5;
        float r2 = 1.0f;
    L6:
        r1.setAlpha(r2);
        r0.b.setAlpha(0.0f);
        getBinding().a.postInvalidate();
        return;
    L5:
        r2 = 0.0f;
        goto L6
    }

    public ItemTextSelectorSubTitle(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        S5(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSelected(boolean r2) {
        super/*android.view.ViewGroup*/.setSelected(r2);
        ImageView r0 = getBinding().d;
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L6:
        r0.setAlpha(r3);
        getBinding().a.postInvalidate();
        return;
    L5:
        r3 = 0.0f;
        goto L6
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "mainTitle");
        getBinding().c.setText(r2);
    }

    public ItemTextSelectorSubTitle(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        S5(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Context r3, AttributeSet r4) {
        LayoutInflater.from(r3).inflate(2131562595, this);
        int r5 = 2131377341;
        if (((LinearLayout) ViewBindings.findChildViewById(this, 2131377341)) == null) goto L13;
        r5 = 2131379091;
        ProgressBar r6 = (ProgressBar) ViewBindings.findChildViewById(this, 2131379091);
        if (r6 == null) goto L13;
        r5 = 2131379424;
        TextView r0 = (TextView) ViewBindings.findChildViewById(this, 2131379424);
        if (r0 == null) goto L13;
        r5 = 2131385826;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(this, 2131385826);
        if (r1 == null) goto L13;
        this.a = new LarusItemMusicAccountBinding(this, r6, r0, r1);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public ItemTextSelectorSubTitle(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        S5(r2, r3);
    }
}
