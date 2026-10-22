package com.bytedance.ai.applet.login;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ai/applet/login/BaseLoginCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ai/applet/login/INativeLoginCard;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseLoginCardView extends ConstraintLayout {
    public BaseLoginCardView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        AttributeSet r11 = null;
        this(r10, r11, 6, 0);
    }

    public BaseLoginCardView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 4, 0);
    }

    public abstract /* synthetic */ void setAcceptListener(View.OnClickListener r1);

    public abstract /* synthetic */ void setRejectListener(View.OnClickListener r1);

    public BaseLoginCardView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
    }

    public /* synthetic */ BaseLoginCardView(Context r1, AttributeSet r10, int r11, int r12) {
        if ((r11 & 2) == 0) goto L5;
        r10 = null;
    L5:
        this(r1, r10, 0);
    }
}
