package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.LiveOpenFeatureSearchFragmentV3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SearchHistoryViewBinderV3 extends b<String, ViewHolder> {
    public final SearchHistoryViewBinder.a b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/SearchHistoryViewBinderV3$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final /* synthetic */ SearchHistoryViewBinderV3 b;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ ViewHolder a;

            public a(ViewHolder r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                ViewHolder r3 = this.a;
                Object r4 = ListProtector.get(((me.drakeet.multitype.b) r3.b).a.a, r3.getAdapterPosition());
                if (r4 == null) goto L7;
                SearchHistoryViewBinder.a r0 = this.a.b.b;
                r0.b((String) r4);
                return;
            L7:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ ViewHolder a;

            public b(ViewHolder r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                if (this.a.getAdapterPosition() < 0) goto L9;
                ViewHolder r3 = this.a;
                Object r4 = ListProtector.get(((me.drakeet.multitype.b) r3.b).a.a, r3.getAdapterPosition());
                if (r4 == null) goto L8;
                SearchHistoryViewBinder.a r0 = this.a.b.b;
                r0.a((String) r4);
                return;
            L8:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
        }

        public ViewHolder(SearchHistoryViewBinderV3 r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.b = r2;
            super(r3);
            this.a = (TextView) r3.findViewById(2131374414);
            ((ImageView) r3.findViewById(2131374396)).setOnClickListener(new a(this));
            r3.setOnClickListener(new b(this));
        }
    }

    public SearchHistoryViewBinderV3(LiveOpenFeatureSearchFragmentV3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mSearchHistoryAction");
        this.b = r2;
    }

    public final void b(RecyclerView.ViewHolder r2, Object r3) {
        ViewHolder r4 = (ViewHolder) r2;
        String r5 = (String) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        Intrinsics.checkNotNullParameter(r5, "item");
        r4.a.setText(r5);
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new ViewHolder(this, r4.inflate(2131567085, r5, false));
    }
}
