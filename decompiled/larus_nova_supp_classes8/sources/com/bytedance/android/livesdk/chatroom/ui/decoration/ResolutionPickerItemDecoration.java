package com.bytedance.android.livesdk.chatroom.ui.decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/decoration/ResolutionPickerItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResolutionPickerItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final Paint b;

    public ResolutionPickerItemDecoration() {
        this.a = UtilityKotlinExtentionsKt.i(1);
        Paint r1 = new Paint();
        r1.setAntiAlias(true);
        r1.setColor(s1.h(2131107287));
        Unit r0 = Unit.INSTANCE;
        this.b = r1;
    }

    public final void onDraw(Canvas r12, RecyclerView r13, RecyclerView.State r14) {
        Intrinsics.checkNotNullParameter(r12, "c");
        Intrinsics.checkNotNullParameter(r13, "parent");
        Intrinsics.checkNotNullParameter(r14, "state");
        super.onDraw(r12, r13, r14);
        int r15 = r13.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r15) goto L8;
        View r2 = r13.getChildAt(r1);
        if (r13.getChildAdapterPosition(r2) == 0) goto L7;
        r12.drawRect(0, r2.getTop() - this.a, r13.getWidth(), r2.getTop(), this.b);
    L7:
        r1 = r1 + 1;
        goto L3
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.getItemOffsets(r2, r3, r4, r5);
        if (r4.getChildAdapterPosition(r3) == 0) goto L6;
        r2.top = this.a;
        return;
    }
}
