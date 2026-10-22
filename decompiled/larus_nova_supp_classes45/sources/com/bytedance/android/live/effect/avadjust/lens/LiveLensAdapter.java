package com.bytedance.android.live.effect.avadjust.lens;

import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/lens/LiveLensAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "AbsSmallItemViewHolder", "LiveSmallItemViewHolder", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLensAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<k90.a> a;
    public int b;
    public a c;
    public final SparseArray<Boolean> d;
    public final Lazy e;
    public final b f;
    public final int g;
    public final LiveEffectContextFactoryDelegate$Type h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/lens/LiveLensAdapter$AbsSmallItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class AbsSmallItemViewHolder extends RecyclerView.ViewHolder {
        public AbsSmallItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/lens/LiveLensAdapter$LiveSmallItemViewHolder;", "Lcom/bytedance/android/live/effect/avadjust/lens/LiveLensAdapter$AbsSmallItemViewHolder;", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LiveSmallItemViewHolder extends AbsSmallItemViewHolder {

        public static final class a {
        }

        static {
        }

        public LiveSmallItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public interface a {
        void a(k90.a r1);
    }

    public static final class b implements LiveSmallItemBeautyHelper.b {
        public final /* synthetic */ LiveLensAdapter a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.notifyDataSetChanged();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void onError() {
        }

        public b(LiveLensAdapter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void a(Sticker r2) {
            Intrinsics.checkNotNullParameter(r2, "sticker");
            ((Handler) this.a.e.getValue()).post(new a(this));
        }
    }

    public final int getItemViewType(int r1) {
        return 0;
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public LiveLensAdapter(int r2, LiveEffectContextFactoryDelegate$Type r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        this.g = r2;
        this.h = r3;
        this.a = new ArrayList();
        this.b = -1;
        this.d = new SparseArray();
        this.e = LazyKt.lazy(LiveLensAdapter$handler$2.INSTANCE);
        this.f = new b(this);
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        if ((r8 instanceof AbsSmallItemViewHolder) == false) goto L23;
        AbsSmallItemViewHolder r11 = (AbsSmallItemViewHolder) r8;
        k90.a r0 = (k90.a) ListProtector.get(this.a, r9);
        if (this.b != r9) goto L7;
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131364341).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390975)).setTextColor(((RecyclerView.ViewHolder) r11).itemView.getContext().getResources().getColor(2131107407));
    L9:
        if (r0.a <= 0) goto L14;
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131375713).setVisibility(0);
        if (this.b != r9) goto L13;
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131375713).setBackgroundResource(2131250480);
    L15:
        TextView r12 = (TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390975);
        r0.getClass();
        r12.setText(null);
        if (r0.getType() != 1) goto L19;
        r0.getClass();
        r0.getClass();
    L21:
        ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new com.bytedance.android.live.effect.avadjust.lens.a(this, r11));
        return;
    L19:
        if (r0.getType() != 0) goto L21;
        ((HSImageView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131376045)).setActualImageResource(2131250467);
        ((ImageView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131376377)).setVisibility(8);
        goto L21
    L13:
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131375713).setBackgroundResource(2131250481);
        goto L15
    L14:
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131375713).setVisibility(8);
        goto L15
    L7:
        this.d.put(r9, Boolean.FALSE);
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131364341).setVisibility(4);
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390975)).setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        return new LiveSmallItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(this.g, r4, false));
    }
}
