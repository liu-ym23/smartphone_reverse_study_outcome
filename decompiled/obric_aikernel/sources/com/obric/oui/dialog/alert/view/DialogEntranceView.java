package com.obric.oui.dialog.alert.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "已废弃")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/widget/TextView;", "getTextView", "Landroid/widget/ImageView;", "getImageView", "ivIcon", "Landroid/widget/ImageView;", "tvTitle", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class DialogEntranceView extends ConstraintLayout {
    private final ImageView ivIcon;
    private final TextView tvTitle;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public DialogEntranceView(Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @JvmOverloads
    public DialogEntranceView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, h.o_layout_dialog_entrance, this);
        View r12 = findViewById(f.tv_normal);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.tv_normal)");
        this.tvTitle = (TextView) r12;
        View r13 = findViewById(f.icon);
        Intrinsics.checkNotNullExpressionValue(r13, "findViewById(R.id.icon)");
        this.ivIcon = (ImageView) r13;
    }

    public /* synthetic */ DialogEntranceView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    public final ImageView getImageView() {
        return this.ivIcon;
    }

    public final TextView getTextView() {
        return this.tvTitle;
    }
}
