package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0015R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/MmTrialGradientTextView;", "Lcom/ss/android/lark/officesdk/minutes/ui/foundation/widget/LineHeightTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "startColor", "endColor", "lastWidth", "", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmTrialGradientTextView extends LineHeightTextView {
    public final int e;
    public final int f;
    public float g;

    public MmTrialGradientTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MmTrialGradientTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r12) {
        Intrinsics.checkNotNullParameter(r12, "canvas");
        if (this.e != 0) goto L5;
    L14:
        getPaint().setShader(null);
    L15:
        super/*android.widget.TextView*/.onDraw(r12);
        return;
    L5:
        if (this.f == 0) goto L14;
        float r3 = getPaint().measureText(getText().toString());
        if (r3 <= 0.0f) goto L15;
        if (r3 != this.g) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == true) goto L15;
        this.g = r3;
        getPaint().setShader(new LinearGradient(r3, 0.0f, 0.0f, 0.0f, new int[]{this.e, this.f}, null, Shader.TileMode.CLAMP));
        goto L15
    L11:
        r0 = false;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmTrialGradientTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setText(r2.getString(2131893509));
        this.e = ContextCompat.getColor(r2, 2131103945);
        this.f = ContextCompat.getColor(r2, 2131103944);
        setBackground(com.ss.android.lark.officesdk.minutes.ui.style.b.a(r2).q(r2));
        setEllipsize(TextUtils.TruncateAt.END);
    }

    public /* synthetic */ MmTrialGradientTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
