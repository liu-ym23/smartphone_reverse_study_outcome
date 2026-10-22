package com.larus.uaigc.template;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.uaigc.impl.databinding.LarusButtonSameTemplateBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/uaigc/template/SameTemplateButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusButtonSameTemplateBinding;", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusButtonSameTemplateBinding;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SameTemplateButton extends FrameLayout {
    public final LarusButtonSameTemplateBinding a;

    public final LarusButtonSameTemplateBinding getBinding() {
        return this.a;
    }

    public SameTemplateButton(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public SameTemplateButton(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        View r5 = LayoutInflater.from(r3).inflate(2131561856, this, false);
        addView(r5);
        int r6 = 2131369142;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131369142)) == null) goto L10;
        LinearLayout r7 = (LinearLayout) r5;
        if (((ImageView) ViewBindings.findChildViewById(r5, 2131374931)) == null) goto L8;
        this.a = new LarusButtonSameTemplateBinding(r7);
        return;
    L8:
        r6 = 2131374931;
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
