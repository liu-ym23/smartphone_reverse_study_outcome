package com.bytedance.ies.bullet.ui.common.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\f2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/view/AutoRTLImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/graphics/drawable/Drawable;", "background", "", "setBackground", "(Landroid/graphics/drawable/Drawable;)V", "drawable", "setImageDrawable", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class AutoRTLImageView extends AppCompatImageView {
    @JvmOverloads
    public AutoRTLImageView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        int r10 = 6;
        this(r5, null, r10, 0);
    }

    @Override // android.view.View
    public void setBackground(Drawable r5) {
        super.setBackground(r5);
        if (r5 == null) goto L6;
        r5.setAutoMirrored(true);
        return;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(@Nullable Drawable r5) {
        super.setImageDrawable(r5);
        if (r5 == null) goto L6;
        r5.setAutoMirrored(true);
        return;
    }

    @JvmOverloads
    public AutoRTLImageView(Context r5, @Nullable AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 4, 0);
    }

    public /* synthetic */ AutoRTLImageView(Context r5, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r5, r10, 0);
    }

    @JvmOverloads
    public AutoRTLImageView(Context r5, @Nullable AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10, r11);
        Drawable r12 = getDrawable();
        Drawable r13 = getBackground();
        Drawable r14 = getForeground();
        if (r12 == null) goto L5;
        r12.setAutoMirrored(true);
    L5:
        if (r13 == null) goto L7;
        r13.setAutoMirrored(true);
    L7:
        if (r14 == null) goto L10;
        r14.setAutoMirrored(true);
        return;
    }
}
