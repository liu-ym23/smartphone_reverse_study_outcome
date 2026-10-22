package com.larus.contextwindow.impl.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.larus.bmhome.view.actionbar.BaseActionBarHolder;
import com.larus.bmhome.view.actionbar.custom.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w29.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/contextwindow/impl/actionbar/ContextWindowActionBarHolder;", "Lcom/larus/bmhome/view/actionbar/BaseActionBarHolder;", "itemView", "Landroid/view/View;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;", "<init>", "(Landroid/view/View;Lcom/larus/bmhome/view/actionbar/custom/CustomActionBarHolderCallback;)V", "icon", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "usageIconDrawable", "Landroid/graphics/drawable/Drawable;", "bind", "", "item", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContextWindowActionBarHolder extends BaseActionBarHolder {
    public static final /* synthetic */ int e = 0;
    public final t1 a;
    public final ImageView b;
    public final TextView c;
    public final Drawable d;

    public ContextWindowActionBarHolder(View r2, t1 r3) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "callback");
        super(r2);
        this.a = r3;
        this.b = (ImageView) r2.findViewById(2131367877);
        this.c = (TextView) r2.findViewById(2131367896);
        g r4 = g.a;
        Context r5 = r2.getContext();
        r4.getClass();
        this.d = g.a(r5);
    }
}
