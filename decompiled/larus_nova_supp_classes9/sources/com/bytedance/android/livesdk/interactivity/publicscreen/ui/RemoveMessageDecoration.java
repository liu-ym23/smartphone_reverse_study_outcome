package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/ui/RemoveMessageDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RemoveMessageDecoration extends RecyclerView.ItemDecoration {
    public final a a;

    public interface a {
    }

    public RemoveMessageDecoration(z r2) {
        Intrinsics.checkNotNullParameter(r2, "removedMsgHandler");
        this.a = r2;
    }

    public final void onDrawOver(Canvas r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r3, "c");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        super.onDrawOver(r3, r4, r5);
        if (r4.getChildCount() > 0) goto L5;
        return;
    L5:
        View r6 = r4.getChildAt(r4.getChildCount() - 1);
        if (r6 != null) goto L8;
        return;
    L8:
        int r7 = u42.g.a;
        Intrinsics.checkNotNullParameter(r6, "view");
        Object r8 = r6.getTag(2131389712);
        if ((r8 instanceof u42.b) == true) goto L11;
        r8 = null;
    L11:
        u42.b r9 = (u42.b) r8;
        if ((r9 instanceof y92.a) == false) goto L18;
        a r10 = this.a;
        long r0 = ((y92.a) r9).d;
        TextMessageWidget r11 = ((z) r10).a;
        if (r11.f.hasMessages(5) == true) goto L19;
        r11.f.sendEmptyMessageDelayed(5, r0);
        return;
    L19:
        return;
    }
}
