package com.larus.community.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import c29.a;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_ui.widget.roundlayout.RoundConstraintLayout;
import com.larus.community.impl.databinding.LarusCommunityCreationHeadItemBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.e1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r29.f;
import sq9.v;
import sq9.x;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\n\u0010\u0017\u001a\u00020\u000b*\u00020\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/community/impl/view/CreationHeadItemView;", "Lcom/larus/common_ui/widget/roundlayout/RoundConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationHeadItemBinding;", "setCreationHeadItemData", "", "instructionDTO", "Lcom/larus/platform/model/creation/InstructionDTO;", "setAvatarWhiteUrl", "url", "", "zoomOutAnimation", "view", "Landroid/view/View;", "scaleSize", "", "zoomInAnimation", "bounceWhenPressedItem", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationHeadItemView extends RoundConstraintLayout {
    public static final /* synthetic */ int d = 0;
    public final LarusCommunityCreationHeadItemBinding c;

    public CreationHeadItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setAvatarWhiteUrl(String r3) {
        Intrinsics.checkNotNullParameter(r3, "url");
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        e1.x(this.c.b);
        e1.o(this.c.d);
        return;
    L8:
        e1.x(this.c.d);
        e1.o(this.c.b);
        ImageLoaderKt.u(this.c.d, r3, "creation_tab");
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setCreationHeadItemData(x r3) {
        Intrinsics.checkNotNullParameter(r3, "instructionDTO");
        this.c.c.setText(r3.c());
        v r4 = r3.a();
        if (r4 == null) goto L8;
        String r5 = r4.a();
        if (r5 == null) goto L9;
        ImageLoaderKt.u(this.c.b, r5, "creation_tab");
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationHeadItemView(Context r4, AttributeSet r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5);
        LayoutInflater.from(r4).inflate(2131561940, this);
        int r6 = 2131362397;
        SimpleDraweeView r0 = ViewBindings.findChildViewById(this, 2131362397);
        if (r0 == null) goto L11;
        r6 = 2131362398;
        AppCompatTextView r1 = ViewBindings.findChildViewById(this, 2131362398);
        if (r1 == null) goto L11;
        r6 = 2131363753;
        SimpleDraweeView r2 = ViewBindings.findChildViewById(this, 2131363753);
        if (r2 == null) goto L11;
        this.c = new LarusCommunityCreationHeadItemBinding(this, r0, r1, r2);
        getDelegate().d(12);
        getDelegate().i(c7.b(Double.valueOf(0.5d)));
        getDelegate().g(ContextCompat.getColor(r4, 2131103159));
        getDelegate().h(ContextCompat.getColor(r4, 2131103159));
        a r7 = getDelegate();
        int r3 = ContextCompat.getColor(r4, 2131102545);
        int r8 = ContextCompat.getColor(r4, 2131102545);
        r7.s = false;
        r7.e = r3;
        r7.g = r8;
        r7.c();
        Intrinsics.checkNotNullParameter(this, "<this>");
        setOnTouchListener(new f(this, this));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r6)));
    }
}
