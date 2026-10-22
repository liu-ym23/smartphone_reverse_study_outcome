package zn8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.mainbot.impl.databinding.LarusMdVideoGroupTallBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o implements a {
    public final LarusMdVideoGroupTallBinding a;
    public final Lazy b;
    public final Lazy c;

    @Override // zn8.a
    public final MarkdownSourceImageView getCiciSourceIcon() {
        return this.a.d;
    }

    @Override // zn8.a
    public final ViewGroup getContentView() {
        return this.a.a;
    }

    @Override // zn8.a
    public final SimpleDraweeView getCoverView() {
        return this.a.b;
    }

    @Override // zn8.a
    public final SimpleDraweeView getDySourceLabelView() {
        return this.a.c;
    }

    @Override // zn8.a
    public final TextView getTitleView() {
        return this.a.f;
    }

    @Override // zn8.a
    public final TextView getTvImageCaption() {
        return this.a.e;
    }

    @Override // zn8.a
    public final int getWidgetHeight() {
        return ((Number) this.b.getValue()).intValue();
    }

    @Override // zn8.a
    public final int getWidgetWidth() {
        return ((Number) this.c.getValue()).intValue();
    }

    public o(Context r9, ViewGroup r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "parent");
        View r11 = LayoutInflater.from(r9).inflate(2131562959, r10, false);
        r10.addView(r11);
        int r12 = 2131379743;
        SimpleDraweeView r3 = ViewBindings.findChildViewById(r11, 2131379743);
        if (r3 == null) goto L15;
        r12 = 2131379745;
        SimpleDraweeView r4 = ViewBindings.findChildViewById(r11, 2131379745);
        if (r4 == null) goto L15;
        LinearLayout r2 = (LinearLayout) r11;
        r12 = 2131387008;
        MarkdownSourceImageView r5 = ViewBindings.findChildViewById(r11, 2131387008);
        if (r5 == null) goto L15;
        r12 = 2131390049;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131390049);
        if (r6 == null) goto L15;
        r12 = 2131392247;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r11, 2131392247);
        if (r7 == null) goto L15;
        this.a = new LarusMdVideoGroupTallBinding(r2, r3, r4, r5, r6, r7);
        this.b = LazyKt.lazy(new m(this));
        this.c = LazyKt.lazy(new n(this));
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
