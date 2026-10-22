package com.bytedance.android.live.effect.sticker.ui.gestureV3;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.sticker.ui.LiveGestureMagicPageAdapter;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/gestureV3/LiveGestureMagicPageAdapterVCD;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/sticker/ui/gestureV3/LiveGestureMagicPageAdapterVCD$LiveGesturePageViewHolder;", "LiveGesturePageViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGestureMagicPageAdapterVCD extends RecyclerView.Adapter<LiveGesturePageViewHolder> {
    public LiveGestureMagicPageAdapter.b a;
    public List<EffectCategoryResponse> b;
    public Context c;
    public final SparseArray<LiveGestureMagicAdapterVCD> d;
    public final Map<Integer, RecyclerView> e;
    public final HashMap<Integer, Integer[]> f;
    public final LiveEffectContextFactoryDelegate$Type g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/sticker/ui/gestureV3/LiveGestureMagicPageAdapterVCD$LiveGesturePageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class LiveGesturePageViewHolder extends RecyclerView.ViewHolder {
        public LiveGesturePageViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public final int getItemCount() {
        if (Lists.isEmpty(this.b) == false) goto L5;
        return 0;
    L5:
        List<EffectCategoryResponse> r0 = this.b;
        if (r0 != null) goto L8;
        return 0;
    L8:
        return r0.size();
    }

    public LiveGestureMagicPageAdapterVCD(LiveEffectContextFactoryDelegate$Type r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.g = r2;
        this.d = new SparseArray();
        this.e = new HashMap();
        this.f = new HashMap();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r11) {
        final LiveGesturePageViewHolder r12 = (LiveGesturePageViewHolder) r9;
        Intrinsics.checkNotNullParameter(r12, "holder");
        List<EffectCategoryResponse> r13 = this.b;
        if (r13 == null) goto L56;
        EffectCategoryResponse r14 = (EffectCategoryResponse) ListProtector.get(r13, r12.getAdapterPosition());
        if (r14 == null) goto L64;
        ImageModel r0 = new ImageModel();
        ArrayList r1 = new ArrayList();
        String r2 = r14.getIcon_selected_url();
        if (r2 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == true) goto L16;
        r1.add(r2);
    L16:
        if (Lists.isEmpty(r1) == false) goto L18;
        ((ImageView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131374931)).setImageResource(2131250484);
    L19:
        ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131384076).setLayoutManager(new LinearLayoutManager(this.c, 0, false));
        if (this.d.get(r12.getAdapterPosition()) != null) goto L22;
        LiveGestureMagicAdapterVCD r3 = new LiveGestureMagicAdapterVCD(this.g);
        r3.c = new f(this);
        ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131384076).addOnScrollListener(new LiveGestureMagicPageAdapterVCD$onBindViewHolder$$inlined$let$lambda$2(this, r12));
        this.d.put(r12.getAdapterPosition(), r3);
    L22:
        LiveGestureMagicAdapterVCD r4 = this.d.get(r12.getAdapterPosition());
        if (((RecyclerView.ViewHolder) r12).itemView.findViewById(2131384076).getAdapter() != null) goto L65;
        ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131384076).setAdapter(r4);
        RecyclerView.Adapter r6 = ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131384076).getAdapter();
        if (r6 == null) goto L55;
        LiveGestureMagicAdapterVCD r7 = (LiveGestureMagicAdapterVCD) r6;
        if (Lists.isEmpty(r14.getTotalEffects()) == true) goto L44;
        r7.f = r14;
        ((ArrayList) r7.e).clear();
        boolean r8 = "heartb".equals(r14.getKey());
        Iterator r15 = r14.getTotalEffects().iterator();
    L30:
        if (r15.hasNext() == false) goto L33;
        Sticker r16 = com.bytedance.android.live.effect.sticker.d.b((Effect) r15.next());
        r16.setDownloaded(r7.a.q(r16));
        r16.setDoubleHandGesture(r8);
        ((ArrayList) r7.e).add(r16);
        goto L30
    L33:
        if (r7.d != null) goto L43;
        LiveEffectContextFactoryDelegate$Type r17 = r7.b;
        List<String> r18 = LiveEffectContext.h;
        Iterator<Sticker> r19 = LiveEffectContext.a.a(r17).a().o(d0.b).iterator();
    L36:
        if (r19.hasNext() == false) goto L43;
        Sticker r21 = r19.next();
        Iterator r22 = ((ArrayList) r7.e).iterator();
    L39:
        if (r22.hasNext() == false) goto L36;
        Sticker r23 = (Sticker) r22.next();
        if (Sticker.equals(r21, r23) == false) goto L39;
        r7.d = r23;
    L43:
        r7.notifyDataSetChanged();
    L44:
        Map<Integer, RecyclerView> r110 = this.e;
        HashMap r111 = (HashMap) r110;
        r111.put(Integer.valueOf(r12.getAdapterPosition()), ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131384076));
        Integer[] r112 = this.f.get(Integer.valueOf(r12.getAdapterPosition()));
        if (r112 != null) goto L47;
        return;
    L47:
        if (r112.length != 2) goto L67;
        RecyclerView.LayoutManager r24 = ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131384076).getLayoutManager();
        if ((r24 instanceof LinearLayoutManager) == true) goto L51;
        r24 = null;
    L51:
        LinearLayoutManager r25 = (LinearLayoutManager) r24;
        if (r25 == null) goto L68;
        r25.scrollToPositionWithOffset(r112[0].intValue(), r112[1].intValue());
        return;
    L68:
        return;
    L67:
        return;
    L55:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.effect.sticker.ui.gestureV3.LiveGestureMagicAdapterVCD");
    L65:
        return;
    L18:
        r0.setUrls(r1);
        ImageUtil.loadImage((ImageView) ((RecyclerView.ViewHolder) r12).itemView.findViewById(2131374931), r0, 0);
        goto L19
    L9:
        if (StringsKt.isBlank(r2) == true) goto L12;
        r5 = false;
        goto L13
    L64:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        this.c = r4.getContext();
        return new LiveGesturePageViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131565905, r4, false));
    }
}
