package com.larus.bmhome.searchmixedmedia;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.video.b;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/searchmixedmedia/MixedMediaDecorationGridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "defaultSpanCount", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MixedMediaDecorationGridItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    public MixedMediaDecorationGridItemDecoration() {
        this.a = 2;
    }

    public final void getItemOffsets(Rect r4, View r5, RecyclerView r6, RecyclerView.State r7) {
        Intrinsics.checkNotNullParameter(r4, "outRect");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "state");
        GridLayoutManager r8 = r6.getLayoutManager();
        if ((r8 instanceof GridLayoutManager) == false) goto L5;
        GridLayoutManager r9 = r8;
    L6:
        if (r9 == null) goto L8;
        int r10 = r9.getSpanCount();
    L9:
        int r11 = r6.getChildAdapterPosition(r5);
        if (r11 != (-1)) goto L13;
        r4.set(0, 0, 0, 0);
        return;
    L13:
        int r12 = r11 % r10;
        Lazy r1 = b.a;
        int r2 = b.b(false);
        if (r12 != 0) goto L16;
        int r3 = r2;
    L18:
        if (r12 == (r10 - 1)) goto L21;
        r2 = 0;
    L21:
        r4.set(r3, 0, r2, 0);
        return;
    L16:
        r3 = 0;
        goto L18
    L8:
        r10 = this.a;
        goto L9
    L5:
        r9 = null;
        goto L6
    }
}
