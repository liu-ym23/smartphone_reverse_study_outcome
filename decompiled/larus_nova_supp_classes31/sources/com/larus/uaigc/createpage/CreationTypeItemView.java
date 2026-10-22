package com.larus.uaigc.createpage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.impl.databinding.LarusCreationSelectItemViewBinding;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\rR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/uaigc/createpage/CreationTypeItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusCreationSelectItemViewBinding;", "bindData", "", "title", "", "iconUrl", "iconRes", "", "setAvatarUrl", "avatarUrl", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationTypeItemView extends ConstraintLayout {
    public final LarusCreationSelectItemViewBinding a;

    public CreationTypeItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setAvatarUrl(String r3) {
        Intrinsics.checkNotNullParameter(r3, "avatarUrl");
        e1.x(this.a.b);
        e1.o(this.a.c);
        ImageLoaderKt.u(this.a.b, r3, "community_creation_photo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreationTypeItemView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        LayoutInflater.from(r3).inflate(2131562005, this);
        int r5 = 2131374742;
        SimpleDraweeView r6 = ViewBindings.findChildViewById(this, 2131374742);
        if (r6 == null) goto L11;
        r5 = 2131374743;
        SimpleDraweeView r0 = ViewBindings.findChildViewById(this, 2131374743);
        if (r0 == null) goto L11;
        r5 = 2131388417;
        TextView r1 = (TextView) ViewBindings.findChildViewById(this, 2131388417);
        if (r1 == null) goto L11;
        this.a = new LarusCreationSelectItemViewBinding(this, r6, r0, r1);
        setBackgroundResource(v19.c.b(2130970983, getContext(), 2131240221));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public final void R5(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "title");
        e1.o(this.a.b);
        e1.x(this.a.c);
        this.a.c.setImageResource(r3);
        this.a.d.setText(r2);
    }

    public final void S5(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "iconUrl");
        e1.o(this.a.b);
        e1.x(this.a.c);
        ImageLoaderKt.u(this.a.c, r4, "community_creation_photo");
        this.a.d.setText(r3);
    }
}
