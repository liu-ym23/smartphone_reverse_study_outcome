package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/secondleveltab/SecondLevelTabItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SecondLevelTabItemViewHolder extends RecyclerView.ViewHolder {
    public final CustomViewTab a;
    public y b;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SecondLevelTabItemViewHolder a;
        public final /* synthetic */ Function1 b;

        public a(SecondLevelTabItemViewHolder r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            Function1 r3 = this.b;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke(this.a.b);
            return;
        }
    }

    public SecondLevelTabItemViewHolder(View r4, Function1<? super y, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        if ((r4 instanceof CustomViewTab) == true) goto L5;
        Object r0 = null;
    L6:
        this.a = (CustomViewTab) r0;
        y r1 = this.b;
        if (r1 != null) goto L9;
    L12:
        r4.setOnClickListener(new a(this, r5));
        return;
    L9:
        if (r1.j != true) goto L12;
        if (r5 == null) goto L12;
        Unit r2 = (Unit) r5.invoke(r1);
        goto L12
    L5:
        r0 = r4;
        goto L6
    }
}
