package com.larus.business.multitask_management.impl.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.business.multitask_management.impl.databinding.LarusMtmLayoutScreenMenuBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ\u0014\u0010\f\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/business/multitask_management/impl/view/MtmQuickAccessScreenMenu;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "binding", "Lcom/larus/business/multitask_management/impl/databinding/LarusMtmLayoutScreenMenuBinding;", "bindPin", "", "onClick", "Lkotlin/Function0;", "bindUnpin", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MtmQuickAccessScreenMenu extends LinearLayoutCompat {
    public static final /* synthetic */ int b = 0;
    public final LarusMtmLayoutScreenMenuBinding a;

    /* JADX WARN: Multi-variable type inference failed */
    public MtmQuickAccessScreenMenu(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        LinearLayoutCompat r6 = LayoutInflater.from(r5).inflate(2131562972, this, false);
        addView(r6);
        int r0 = 2131380385;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r6, 2131380385);
        if (r1 == null) goto L11;
        r0 = 2131380386;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r6, 2131380386);
        if (r2 == null) goto L11;
        r0 = 2131380387;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r6, 2131380387);
        if (r3 == null) goto L11;
        this.a = new LarusMtmLayoutScreenMenuBinding(r6, r1, r2, r3);
        setOrientation(1);
        setBackgroundResource(v19.c.b(2130970630, null, 2131238896));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
