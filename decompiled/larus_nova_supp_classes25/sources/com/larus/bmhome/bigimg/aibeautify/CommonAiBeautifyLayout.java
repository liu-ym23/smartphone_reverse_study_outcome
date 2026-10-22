package com.larus.bmhome.bigimg.aibeautify;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.image.databinding.LarusLayoutBigImageAibeautifyBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/bigimg/aibeautify/CommonAiBeautifyLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/image/databinding/LarusLayoutBigImageAibeautifyBinding;", "setLayoutEnable", "", "enable", "", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CommonAiBeautifyLayout extends ConstraintLayout {
    public final LarusLayoutBigImageAibeautifyBinding a;

    public CommonAiBeautifyLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CommonAiBeautifyLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void setLayoutEnable(boolean r2) {
        this.a.c.setEnabled(r2);
        AppCompatTextView r0 = this.a.b;
        if (r2 == false) goto L5;
        float r3 = 1.0f;
    L6:
        r0.setAlpha(r3);
        return;
    L5:
        r3 = 0.3f;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonAiBeautifyLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131562745, this);
        int r5 = 2131362378;
        AppCompatTextView r6 = ViewBindings.findChildViewById(this, 2131362378);
        if (r6 == null) goto L9;
        r5 = 2131362379;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(this, 2131362379);
        if (r7 == null) goto L9;
        this.a = new LarusLayoutBigImageAibeautifyBinding(this, r6, r7);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r5)));
    }

    public /* synthetic */ CommonAiBeautifyLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
