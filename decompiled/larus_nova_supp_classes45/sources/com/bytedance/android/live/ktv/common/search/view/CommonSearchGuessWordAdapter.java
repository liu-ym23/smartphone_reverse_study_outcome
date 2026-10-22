package com.bytedance.android.live.ktv.common.search.view;

import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchGuessWordAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/ktv/common/search/view/CommonSearchGuessWordItemViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonSearchGuessWordAdapter extends RecyclerView.Adapter<CommonSearchGuessWordItemViewHolder> {
    public final List<SpannableString> a;
    public final List<s> b;
    public final boolean c;
    public final Function1<String, Unit> d;

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonSearchGuessWordAdapter(boolean r2, Function1<? super String, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "clickAction");
        this.c = r2;
        this.d = r3;
        this.a = new ArrayList();
        this.b = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        CommonSearchGuessWordItemViewHolder r6 = (CommonSearchGuessWordItemViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        SpannableString r0 = (SpannableString) ListProtector.get(this.a, r5);
        s r7 = (s) ListProtector.get(this.b, r5);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "content");
        Intrinsics.checkNotNullParameter(r7, "guessWord");
        r6.a = r0;
        r6.b = r7;
        r6.c.setText(r0);
        int r1 = KtvOrderSongThemeManager.a;
        KtvOrderSongThemeManager.d(r6.c, KtvOrderSongThemeManager.f);
        int r8 = r6.getAdapterPosition();
        pb0.a r2 = pb0.b.a;
        Intrinsics.checkNotNullParameter(r7, "guessWord");
        pb0.a r3 = pb0.b.a;
        if (r3 == null) goto L6;
        r3.s(r8, r7);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Function1<String, Unit> r0 = this.d;
        LayoutInflater r1 = LayoutInflater.from(r5.getContext());
        if (this.c == false) goto L5;
        int r2 = 2131566464;
    L7:
        return new CommonSearchGuessWordItemViewHolder(r0, r1.inflate(r2, r5, false));
    L5:
        r2 = 2131566463;
        goto L7
    }
}
