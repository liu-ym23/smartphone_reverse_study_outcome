package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.livesdk.r3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends me.drakeet.multitype.b<y, SecondLevelTabItemViewHolder> {
    public final Function1<Context, CustomViewTab> b;
    public final Function1<y, Unit> c;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function1<? super Context, CustomViewTab> r2, Function1<? super y, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "createCustomViewTabAction");
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final void b(RecyclerView.ViewHolder r4, Object r5) {
        SecondLevelTabItemViewHolder r6 = (SecondLevelTabItemViewHolder) r4;
        y r7 = (y) r5;
        Intrinsics.checkNotNullParameter(r6, "viewHolder");
        Intrinsics.checkNotNullParameter(r7, "data");
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "data");
        r6.b = r7;
        CustomViewTab r0 = r6.a;
        if (r0 == null) goto L5;
        r0.setTabName(r7.d);
    L5:
        CustomViewTab r1 = r6.a;
        if (r1 != null) goto L8;
    L12:
        ?? r2 = 0;
        ?? r3 = 0;
        if (r7.j == false) goto L19;
        CustomViewTab r8 = r6.a;
        if ((r8 instanceof View) == false) goto L18;
        r3 = r8;
    L18:
        r3.a(r3, "已选中" + r7.d);
    L25:
        if (r7.j == false) goto L29;
        CustomViewTab r9 = r6.a;
        if (r9 == null) goto L33;
        r9.onSelected(true);
        return;
    L33:
        return;
    L29:
        CustomViewTab r11 = r6.a;
        if (r11 == null) goto L35;
        r11.c4(true);
        return;
    L35:
        return;
    L19:
        CustomViewTab r12 = r6.a;
        if ((r12 instanceof View) == false) goto L23;
        r2 = r12;
    L23:
        r3.a(r2, String.valueOf(r7.d));
        goto L25
    L8:
        if (r7.o == false) goto L10;
        int r13 = 0;
    L11:
        r1.G5(r13);
        goto L12
    L10:
        r13 = 8;
        goto L11
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new SecondLevelTabItemViewHolder((View) this.b.invoke(r3.getContext()), this.c);
    }
}
