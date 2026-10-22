package com.larus.bmhome.chat.view.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusLayoutShareFooterBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/view/share/ShareFooterView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusLayoutShareFooterBinding;", "setTitle", "", "title", "", "setSubTitle", "subTitle", "setQRCode", "bitmap", "Landroid/graphics/Bitmap;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareFooterView extends ConstraintLayout {
    public final LarusLayoutShareFooterBinding a;

    public ShareFooterView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ShareFooterView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setQRCode(Bitmap r2) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        this.a.c.setImageBitmap(r2);
    }

    public final void setSubTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "subTitle");
        this.a.d.setText(r2);
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "title");
        this.a.e.setText(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShareFooterView(Context r7, AttributeSet r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "context");
        super(r7, r8, r9);
        LayoutInflater.from(r7).inflate(2131562886, this);
        int r10 = 2131373140;
        if (((ImageView) ViewBindings.findChildViewById(this, 2131373140)) == null) goto L19;
        r10 = 2131373141;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(this, 2131373141);
        if (r2 == null) goto L19;
        r10 = 2131373145;
        if (ViewBindings.findChildViewById(this, 2131373145) == null) goto L19;
        r10 = 2131373146;
        if (ViewBindings.findChildViewById(this, 2131373146) == null) goto L19;
        r10 = 2131373149;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(this, 2131373149);
        if (r3 == null) goto L19;
        r10 = 2131373152;
        TextView r4 = (TextView) ViewBindings.findChildViewById(this, 2131373152);
        if (r4 == null) goto L19;
        r10 = 2131373154;
        TextView r5 = (TextView) ViewBindings.findChildViewById(this, 2131373154);
        if (r5 == null) goto L19;
        this.a = new LarusLayoutShareFooterBinding(this, r2, r3, r4, r5);
        return;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r10)));
    }

    public /* synthetic */ ShareFooterView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
