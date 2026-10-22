package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.chat.common.databinding.LarusLayoutImageCoverEditBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/ImageCoverEditView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutImageCoverEditBinding;", "bindView", "", "viewData", "Lcom/larus/bmhome/chat/layout/widget/ImageCoverEditViewData;", "actionListener", "Lcom/larus/bmhome/chat/layout/widget/IImageCoverEditActionListener;", "setActionListener", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ImageCoverEditView extends LinearLayout {
    public static final /* synthetic */ int b = 0;
    public final LarusLayoutImageCoverEditBinding a;

    public ImageCoverEditView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ImageCoverEditView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setActionListener(final i0 r3) {
        Intrinsics.checkNotNullParameter(r3, "actionListener");
        this.a.e.setOnClickListener(new j0(r3));
        this.a.b.setOnClickListener(new k0(r3));
    }

    public final void a(n0 r3, final i0 r4) {
        Intrinsics.checkNotNullParameter(r3, "viewData");
        if (r4 == null) goto L5;
        this.a.e.setOnClickListener(new l0(r4));
        this.a.b.setOnClickListener(new m0(r4));
    L5:
        Boolean r5 = r3.a;
        Boolean r0 = Boolean.TRUE;
        if (Intrinsics.areEqual(r5, r0) == false) goto L11;
        if (Intrinsics.areEqual(r3.b, r0) == false) goto L11;
        com.larus.utils.e1.x(this.a.e);
        com.larus.utils.e1.x(this.a.b);
        com.larus.utils.e1.x(this.a.f);
        com.larus.utils.e1.o(this.a.d);
        return;
    L11:
        if (Intrinsics.areEqual(r3.a, r0) == false) goto L16;
        if (Intrinsics.areEqual(r3.b, r0) == true) goto L16;
        com.larus.utils.e1.x(this.a.e);
        com.larus.utils.e1.o(this.a.b);
        com.larus.utils.e1.o(this.a.f);
        return;
    L16:
        if (Intrinsics.areEqual(r3.a, r0) == false) goto L18;
    L20:
        com.larus.utils.e1.o(this.a.e);
        com.larus.utils.e1.o(this.a.b);
        return;
    L18:
        if (Intrinsics.areEqual(r3.b, r0) == false) goto L20;
        com.larus.utils.e1.o(this.a.e);
        com.larus.utils.e1.x(this.a.b);
        com.larus.utils.e1.o(this.a.c);
    }

    public ImageCoverEditView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        LayoutInflater.from(r8).inflate(2131562830, this);
        int r11 = 2131374943;
        FrameLayout r2 = (FrameLayout) ViewBindings.findChildViewById(this, 2131374943);
        if (r2 == null) goto L17;
        r11 = 2131374944;
        AppCompatImageView r3 = ViewBindings.findChildViewById(this, 2131374944);
        if (r3 == null) goto L17;
        r11 = 2131374945;
        TextView r4 = (TextView) ViewBindings.findChildViewById(this, 2131374945);
        if (r4 == null) goto L17;
        r11 = 2131374946;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(this, 2131374946);
        if (r5 == null) goto L17;
        r11 = 2131374947;
        AppCompatImageView r6 = ViewBindings.findChildViewById(this, 2131374947);
        if (r6 == null) goto L17;
        r11 = 2131374948;
        if (((TextView) ViewBindings.findChildViewById(this, 2131374948)) == null) goto L17;
        this.a = new LarusLayoutImageCoverEditBinding(this, r2, r3, r4, r5, r6);
        return;
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r11)));
    }

    public /* synthetic */ ImageCoverEditView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
