package com.larus.profile.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.profile.impl.databinding.LarusCommonRedDotImageViewBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J!\u0010\u0013\u001a\u00020\u000f2\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u0015\u001a\u00020\n¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\nH\u0007J\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\""}, d2 = {"Lcom/larus/profile/impl/view/CommonRedDotImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/profile/impl/databinding/LarusCommonRedDotImageViewBinding;", "init", "", "selectResId", "Ljava/lang/Integer;", "unselectResId", "setIconRes", "selectId", "unselectId", "(Ljava/lang/Integer;I)V", "setTabText", "text", "", "updateSelectStatus", "select", "", "updateRedPointVisibility", "visibility", "updateUnreadCount", "count", "getUnreadCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CommonRedDotImageView extends ConstraintLayout {
    public LarusCommonRedDotImageViewBinding a;

    @Deprecated(message = "not use")
    public final void setTabText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
    }

    public final int getUnreadCount() {
        LarusCommonRedDotImageViewBinding r0 = this.a;
        if (r0 == null) goto L9;
        RedDotTextView r1 = r0.d;
        if (r1 == null) goto L9;
        if (r1.getVisibility() != 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 == false) goto L17;
        LarusCommonRedDotImageViewBinding r3 = this.a;
        if (r3 == null) goto L18;
        RedDotTextView r4 = r3.d;
        if (r4 != null) goto L16;
        return 0;
    L16:
        return r4.getRedDotCount();
    L18:
        return 0;
    L17:
        return 0;
    L9:
        r2 = false;
        goto L10
    }

    public CommonRedDotImageView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        R5(r2, null);
    }

    public CommonRedDotImageView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        R5(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r3, AttributeSet r4) {
        LayoutInflater.from(r3).inflate(2131561918, this);
        int r5 = 2131362559;
        if (((Space) ViewBindings.findChildViewById(this, 2131362559)) == null) goto L13;
        r5 = 2131388022;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(this, 2131388022);
        if (r6 == null) goto L13;
        r5 = 2131388046;
        View r0 = ViewBindings.findChildViewById(this, 2131388046);
        if (r0 == null) goto L13;
        r5 = 2131388062;
        RedDotTextView r1 = ViewBindings.findChildViewById(this, 2131388062);
        if (r1 == null) goto L13;
        this.a = new LarusCommonRedDotImageViewBinding(this, r6, r0, r1);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public CommonRedDotImageView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        R5(r2, r3);
    }
}
