package com.bytedance.android.live.effect.beauty.sticker;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/sticker/LiveBeautyStickerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBeautyStickerItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;

    public LiveBeautyStickerItemDecoration() {
        this.a = 10;
        this.b = 3;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.getItemOffsets(r2, r3, r4, r5);
        int r6 = r4.getChildAdapterPosition(r3);
        if (r6 != 0) goto L5;
        r2.set(s1.f(this.a), 0, 0, 0);
        return;
    L5:
        RecyclerView.Adapter r7 = r4.getAdapter();
        if (r7 == null) goto L8;
        int r8 = r7.getItemCount();
    L10:
        if (r6 != (r8 - 1)) goto L12;
        r2.set(0, 0, s1.f(this.a), 0);
        return;
    L12:
        r2.set(s1.f(this.b), 0, s1.f(this.b), 0);
        return;
    L8:
        r8 = 0;
        goto L10
    }
}
