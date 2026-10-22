package com.larus.bot.impl.common.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.impl.databinding.LarusNewBotTagItemViewBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rJ\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\rJ\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bot/impl/common/view/NewBotTagItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/bot/impl/databinding/LarusNewBotTagItemViewBinding;", "setText", "", "tag", "", "setIcon", ShareType.URL, "setTagColor", "color", "setSelected", "selected", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewBotTagItemView extends ConstraintLayout {
    public final LarusNewBotTagItemViewBinding a;

    public NewBotTagItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setIcon(String r3) {
        Intrinsics.checkNotNullParameter(r3, ShareType.URL);
        SimpleDraweeView r0 = this.a.b;
        ImageLoaderKt.u(r0, r3, "bot_tab_item_tag");
        Intrinsics.checkNotNull(r0);
        e1.x(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSelected(boolean r3) {
        super/*android.view.ViewGroup*/.setSelected(r3);
        this.a.d.setSelected(r3);
        if (r3 == false) goto L9;
        if (Build.VERSION.SDK_INT < 28) goto L7;
        Typeface r4 = Typeface.create(this.a.d.getTypeface(), 600, this.a.d.getTypeface().isItalic());
        this.a.d.setTypeface(r4);
    L7:
        e1.x(this.a.c);
        return;
    L9:
        if (Build.VERSION.SDK_INT < 28) goto L11;
        Typeface r5 = Typeface.create(this.a.d.getTypeface(), 600, this.a.d.getTypeface().isItalic());
        this.a.d.setTypeface(r5);
    L11:
        e1.o(this.a.c);
    }

    public final void setTagColor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "color");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r2)));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r3) == false) goto L10;
        r3 = null;
    L10:
        Integer r4 = (Integer) r3;
        if (r4 == null) goto L13;
        int r5 = r4.intValue();
    L14:
        this.a.d.setTextColor(r5);
        this.a.c.setBackgroundColor(r5);
        return;
    L13:
        r5 = -16777216;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        this.a.d.setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NewBotTagItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        LayoutInflater.from(r3).inflate(2131562982, this);
        int r5 = 2131380698;
        if (ViewBindings.findChildViewById(this, 2131380698) == null) goto L13;
        r5 = 2131380699;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(this, 2131380699);
        if (r6 == null) goto L13;
        r5 = 2131380700;
        View r0 = ViewBindings.findChildViewById(this, 2131380700);
        if (r0 == null) goto L13;
        r5 = 2131380701;
        TextView r1 = (TextView) ViewBindings.findChildViewById(this, 2131380701);
        if (r1 == null) goto L13;
        this.a = new LarusNewBotTagItemViewBinding(this, r6, r0, r1);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }
}
