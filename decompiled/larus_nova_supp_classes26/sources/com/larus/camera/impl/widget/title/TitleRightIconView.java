package com.larus.camera.impl.widget.title;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.camera.impl.databinding.LarusLayoutTitleRightIconViewBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u0011J\u001f\u0010\u0012\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\u0002\b\u0011J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/camera/impl/widget/title/TitleRightIconView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/camera/impl/databinding/LarusLayoutTitleRightIconViewBinding;", "setHint", "", "func", "Lkotlin/Function1;", "Landroid/widget/TextView;", "Lkotlin/ExtensionFunctionType;", "setIcon", "Landroid/widget/ImageView;", "useCenteredCircularIcon", "iconSize", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleRightIconView extends LinearLayout {
    public final LarusLayoutTitleRightIconViewBinding a;

    public TitleRightIconView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TitleRightIconView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setHint(Function1<? super TextView, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "func");
        r2.invoke(this.a.b);
    }

    public final void setIcon(Function1<? super ImageView, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "func");
        r2.invoke(this.a.c);
    }

    public TitleRightIconView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        View r5 = LayoutInflater.from(r2).inflate(2131562897, this, false);
        addView(r5);
        int r6 = 2131374360;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r5, 2131374360);
        if (r7 == null) goto L9;
        r6 = 2131374718;
        ImageView r0 = (ImageView) ViewBindings.findChildViewById(r5, 2131374718);
        if (r0 == null) goto L9;
        this.a = new LarusLayoutTitleRightIconViewBinding((LinearLayout) r5, r7, r0);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }

    public /* synthetic */ TitleRightIconView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
