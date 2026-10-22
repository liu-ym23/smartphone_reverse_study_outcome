package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/feedback/KtvFeedbackTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "selected", "", "setSelected", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvFeedbackTextView extends AppCompatTextView {
    public static final int a = 0;
    public static final int b = 0;

    public static final class a {
    }

    public KtvFeedbackTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KtvFeedbackTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    static {
        a = UtilityKotlinExtentionsKt.i(10);
        b = UtilityKotlinExtentionsKt.i(6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSelected(boolean r1) {
        super/*android.widget.TextView*/.setSelected(r1);
        if (r1 == false) goto L5;
        KtvOrderSongThemeManager.c(this, KtvOrderSongThemeManager.A);
        KtvOrderSongThemeManager.d(this, KtvOrderSongThemeManager.C);
        return;
    L5:
        KtvOrderSongThemeManager.c(this, KtvOrderSongThemeManager.B);
        KtvOrderSongThemeManager.d(this, KtvOrderSongThemeManager.D);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KtvFeedbackTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setSelected(false);
        int r5 = a;
        int r6 = b;
        setPadding(r5, r6, r5, r6);
        setTextSize(12.0f);
    }

    public /* synthetic */ KtvFeedbackTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
