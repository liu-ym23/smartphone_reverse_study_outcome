package com.bytedance.android.live.ktv.common.search.view;

import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchGuessWordItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSearchGuessWordItemViewHolder extends RecyclerView.ViewHolder {
    public SpannableString a;
    public s b;
    public final TextView c;
    public final View d;
    public final View e;
    public final Function1<String, Unit> f;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ CommonSearchGuessWordItemViewHolder a;

        public a(CommonSearchGuessWordItemViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            CommonSearchGuessWordItemViewHolder r4 = this.a;
            Function1<String, Unit> r0 = r4.f;
            if (r0 == null) goto L5;
            Unit r5 = (Unit) r0.invoke(String.valueOf(r4.a));
        L5:
            CommonSearchGuessWordItemViewHolder r6 = this.a;
            s r1 = r6.b;
            if (r1 == null) goto L11;
            int r7 = r6.getAdapterPosition();
            pb0.a r2 = pb0.b.a;
            Intrinsics.checkNotNullParameter(r1, "guessWord");
            pb0.a r8 = pb0.b.a;
            if (r8 == null) goto L12;
            r8.m(r7, r1);
            return;
        L12:
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonSearchGuessWordItemViewHolder(Function1<? super String, Unit> r3, View r4) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        super(r4);
        this.f = r3;
        this.c = (TextView) r4.findViewById(2131374049);
        View r5 = r4.findViewById(2131385505);
        this.d = r5;
        View r0 = r4.findViewById(2131384584);
        this.e = r0;
        r4.setOnClickListener(new a(this));
        r5.setVisibility(0);
        r0.setVisibility(8);
        KtvOrderSongThemeManager.c(r5, KtvOrderSongThemeManager.i);
    }
}
