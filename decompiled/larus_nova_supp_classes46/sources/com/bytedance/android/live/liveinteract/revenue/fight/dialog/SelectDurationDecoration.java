package com.bytedance.android.live.liveinteract.revenue.fight.dialog;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/fight/dialog/SelectDurationDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelectDurationDecoration extends RecyclerView.ItemDecoration {
    public final Paint a;

    public SelectDurationDecoration() {
        Paint r0 = new Paint();
        this.a = r0;
        r0.setAntiAlias(true);
        r0.setColor(ColorProtector.parseColor("#1F161823"));
    }

    public final void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        Intrinsics.checkNotNullParameter(r10, "c");
        Intrinsics.checkNotNullParameter(r11, "parent");
        Intrinsics.checkNotNullParameter(r12, "state");
        super.onDrawOver(r10, r11, r12);
        float r2 = s1.f(48.0f);
        float r13 = r11.getPaddingLeft();
        float r6 = r2 * 2;
        float r14 = r11.getWidth() - r11.getPaddingRight();
        float r7 = 1;
        r10.drawRect(r13, r2, r14, r2 + r7, this.a);
        r10.drawRect(r13, r6, r14, r7 + r6, this.a);
    }
}
