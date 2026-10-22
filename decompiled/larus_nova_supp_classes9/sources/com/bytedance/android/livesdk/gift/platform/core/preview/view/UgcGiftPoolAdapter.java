package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.UgcGiftPoolViewModel;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftPoolAdapter;", "Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/BaseUgcGiftAdapter;", "Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftPoolAdapter$InteractGiftViewHolder;", "InteractGiftViewHolder", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UgcGiftPoolAdapter extends BaseUgcGiftAdapter<InteractGiftViewHolder> {
    public final List<com.bytedance.android.livesdk.gift.platform.core.preview.b> a;
    public List<com.bytedance.android.livesdk.gift.platform.core.preview.b> b;
    public List<Long> c;
    public List<Long> d;
    public int e;
    public String f;
    public final RecyclerView g;
    public final UgcGiftPoolViewModel h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftPoolAdapter$InteractGiftViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class InteractGiftViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int h = 0;
        public final View a;
        public final HSImageView b;
        public final TextView c;
        public final TextView d;
        public final TextView e;
        public final Lazy f;
        public final /* synthetic */ UgcGiftPoolAdapter g;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ InteractGiftViewHolder a;

            public a(InteractGiftViewHolder r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r10) {
                InteractGiftViewHolder r11 = this.a;
                Iterator r0 = ((ArrayList) r11.g.a).iterator();
                int r2 = 0;
            L4:
                if (r0.hasNext() == false) goto L12;
                Object r3 = r0.next();
                int r4 = r2 + 1;
                if (r2 >= 0) goto L8;
                CollectionsKt.throwIndexOverflow();
            L8:
                com.bytedance.android.livesdk.gift.platform.core.preview.b r5 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) r3;
                if (r5.f == false) goto L11;
                r5.f = false;
                r11.g.notifyItemChanged(r2);
            L11:
                r2 = r4;
                goto L4
            L12:
                com.bytedance.android.livesdk.gift.platform.core.preview.b r1 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) CollectionsKt.getOrNull(r11.g.a, r11.getAdapterPosition());
                if (r1 == null) goto L27;
                r11.T3(true, r1);
                com.bytedance.android.livesdk.gift.platform.core.preview.a r6 = com.bytedance.android.livesdk.gift.platform.core.preview.a.a;
                UgcGiftPoolAdapter r7 = r11.g;
                int r8 = r7.e;
                String r9 = r7.f;
                long r13 = r1.a;
                int r14 = r11.getAdapterPosition();
                r6.getClass();
                Intrinsics.checkNotNullParameter(r9, "request_page");
                LinkedHashMap r15 = new LinkedHashMap();
                int r16 = (r14 / 4) + 1;
                int r17 = (r14 % 4) + 1;
                if (r8 != 1) goto L17;
                String r18 = "live_take_page";
            L18:
                r15.put("event_page", r18);
                r15.put("request_page", r9);
                r15.put("gift_id", String.valueOf(r13));
                r15.put("row_location", String.valueOf(r16));
                r15.put("column_location", String.valueOf(r17));
                yz0.k r19 = com.bytedance.android.livesdk.gift.platform.core.utils.u.h();
                if (r19 == null) goto L26;
                IRoom r20 = r19.getRoom();
                if (r20 == null) goto L26;
                String r21 = r20.getAnchorId();
                if (r21 != null) goto L25;
                r21 = BuildConfig.FLAVOR;
            L25:
                r15.put("anchor_id", r21);
                r15.put("room_id", String.valueOf(r20.getRoomId()));
                com.bytedance.android.livesdk.gift.platform.core.preview.a.c("livesdk_interactive_gift_panel_gift_library_gift_click", r15);
            L26:
                r15.put("live_type", "video_live");
                r15.put("anchor_id", vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).getCurrentUserId());
                com.bytedance.android.livesdk.gift.platform.core.preview.a.d("livesdk_interactive_gift_panel_gift_library_gift_click", r15);
                goto L27
            L17:
                r18 = "live";
            L27:
                RecyclerView.LayoutManager r23 = r11.g.g.getLayoutManager();
                if ((r23 instanceof LinearLayoutManager) == false) goto L34;
                r23.smoothScrollToPosition(r11.g.g, new RecyclerView.State(), r11.getAdapterPosition());
                return;
            }
        }

        public final t V3() {
            return (t) this.f.getValue();
        }

        public final b U3(long r5) {
            List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r0 = this.g.b;
            ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L7;
            r1.add(Long.valueOf(((com.bytedance.android.livesdk.gift.platform.core.preview.b) r2.next()).a));
            goto L4
        L7:
            if (r1.contains(Long.valueOf(r5)) == false) goto L10;
            return new b(2131251974, 2131917630, new UgcGiftPoolAdapter$InteractGiftViewHolder$getConfig$2(this));
        L10:
            return new b(2131248758, 2131917636, new UgcGiftPoolAdapter$InteractGiftViewHolder$getConfig$3(this));
        }

        public InteractGiftViewHolder(UgcGiftPoolAdapter r2, final View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.g = r2;
            super(r3);
            this.a = r3.findViewById(2131367792);
            this.b = r3.findViewById(2131373729);
            this.c = (TextView) r3.findViewById(2131373743);
            this.d = (TextView) r3.findViewById(2131368992);
            this.e = (TextView) r3.findViewById(2131388148);
            this.f = LazyKt.lazy(new UgcGiftPoolAdapter$InteractGiftViewHolder$selectView$2(r3));
            r3.setOnClickListener(new a(this));
        }

        public final void T3(boolean r7, com.bytedance.android.livesdk.gift.platform.core.preview.b r8) {
            if (r7 == false) goto L14;
            t r9 = V3();
            if (r9.a == false) goto L9;
            UgcGiftSelectView r10 = r9.b;
            if (r10 == null) goto L9;
            int r11 = r10.getVisibility();
        L10:
            if (r11 == 0) goto L16;
            r8.f = true;
            V3().a(U3(r8.a));
            V3().c(0);
            V3().e();
            this.a.setVisibility(8);
            if (this.g.e != 1) goto L17;
            com.bytedance.android.livesdk.gift.platform.core.preview.f.a().a();
            V3().d();
            com.bytedance.android.livesdk.gift.platform.core.preview.f.a().f(r8.b, r8.a, new UgcGiftPoolAdapter$InteractGiftViewHolder$applySelect$1(this));
            return;
        L17:
            return;
        L16:
            return;
        L9:
            r11 = 8;
            goto L10
        L14:
            V3().c(8);
            V3().getClass();
            V3().f();
            this.a.setVisibility(0);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftAdapter
    public final void z2(List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r2, "data");
        ArrayList r0 = (ArrayList) this.a;
        r0.addAll(r2);
        notifyItemInserted(getItemCount());
    }

    public UgcGiftPoolAdapter(RecyclerView r2, UgcGiftPoolViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.g = r2;
        this.h = r3;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = CollectionsKt.emptyList();
        this.d = new ArrayList();
        this.f = BuildConfig.FLAVOR;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        InteractGiftViewHolder r10 = (InteractGiftViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        com.bytedance.android.livesdk.gift.platform.core.preview.b r11 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) CollectionsKt.getOrNull(this.a, r9);
        if (r11 == null) goto L17;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "gift");
        r10.c.setAlpha(1.0f);
        r10.c.setText(r11.c);
        r10.d.setVisibility(0);
        r10.d.setText(String.valueOf(r11.d) + " " + r3.c());
        r10.d.requestLayout();
        py.k r0 = r11.e;
        if (r0 == null) goto L7;
        ImageLoader.bindImage(r10.b, r0, s1.j(2131168604), s1.j(2131168604));
    L7:
        r10.V3().b(r11.e, r11.c, String.valueOf(r11.d), r10.U3(r11.a));
        r10.T3(r11.f, r11);
        r10.a.setBackgroundResource(2131251972);
        List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r1 = r10.g.b;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L9:
        if (r3.hasNext() == false) goto L12;
        r2.add(Long.valueOf(((com.bytedance.android.livesdk.gift.platform.core.preview.b) r3.next()).a));
        goto L9
    L12:
        if (r2.contains(Long.valueOf(r11.a)) == false) goto L14;
        r10.e.setVisibility(0);
        r10.e.setText(s1.B(2131917627));
        r10.e.setTextColor(s1.h(2131108459));
        r10.e.setBackground(s1.m(2131250719));
        return;
    L14:
        r10.e.setVisibility(8);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new InteractGiftViewHolder(this, LayoutInflater.from(r3.getContext()).inflate(2131566205, r3, false));
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftAdapter
    public final void y2(com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.a r7, int r8, String r9) {
        Intrinsics.checkNotNullParameter(r7, "ugcGiftData");
        Intrinsics.checkNotNullParameter(r9, "clickFrom");
        Iterator<T> r0 = r7.b.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((com.bytedance.android.livesdk.gift.platform.core.preview.b) r1).f == false) goto L4;
    L9:
        if (r1 != null) goto L20;
        Iterator<T> r2 = r7.b.iterator();
    L12:
        if (r2.hasNext() == false) goto L20;
        com.bytedance.android.livesdk.gift.platform.core.preview.b r3 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) r2.next();
        List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r4 = r7.a;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L15:
        if (r6.hasNext() == false) goto L18;
        r5.add(Long.valueOf(((com.bytedance.android.livesdk.gift.platform.core.preview.b) r6.next()).a));
        goto L15
    L18:
        if (r5.contains(Long.valueOf(r3.a)) == true) goto L12;
        r3.f = true;
    L20:
        this.b = CollectionsKt.toMutableList(r7.a);
        this.c = r7.c;
        this.e = r8;
        this.f = r9;
        ArrayList r10 = new ArrayList();
        this.d = r10;
        r10.addAll(r7.d);
        List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r11 = r7.b;
        ((ArrayList) this.a).clear();
        ArrayList r13 = (ArrayList) this.a;
        r13.addAll(r11);
        notifyDataSetChanged();
        return;
    L8:
        r1 = null;
        goto L9
    }
}
