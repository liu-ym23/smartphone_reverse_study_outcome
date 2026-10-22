package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.PanelOperationState;
import com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.UgcGiftDialogViewModel;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\tR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftSaleAdapter;", "Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/BaseUgcGiftAdapter;", "Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftSaleAdapter$InteractGiftViewHolder;", "Landroid/content/Context;", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "InteractGiftViewHolder", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UgcGiftSaleAdapter extends BaseUgcGiftAdapter<InteractGiftViewHolder> {
    public final List<com.bytedance.android.livesdk.gift.platform.core.preview.b> a;
    public List<Long> b;
    public final List<Long> c;
    public int d;
    public String e;
    public final Context f;
    public final RecyclerView g;
    public final UgcGiftDialogViewModel h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/core/preview/view/UgcGiftSaleAdapter$InteractGiftViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class InteractGiftViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int h = 0;
        public final View a;
        public final HSImageView b;
        public final TextView c;
        public final TextView d;
        public final Lazy e;
        public final TextView f;
        public final /* synthetic */ UgcGiftSaleAdapter g;

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
                UgcGiftSaleAdapter r7 = r11.g;
                int r8 = r7.d;
                String r9 = r7.e;
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
                com.bytedance.android.livesdk.gift.platform.core.preview.a.c("livesdk_interactive_gift_panel_gift_click", r15);
            L26:
                r15.put("live_type", "video_live");
                r15.put("anchor_id", vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class).getCurrentUserId());
                com.bytedance.android.livesdk.gift.platform.core.preview.a.d("livesdk_interactive_gift_panel_gift_click", r15);
                goto L27
            L17:
                r18 = "live";
            L27:
                RecyclerView.LayoutManager r23 = r11.g.g.getLayoutManager();
                if ((r23 instanceof LinearLayoutManager) == true) goto L30;
                return;
            L30:
                if (r11.getAdapterPosition() == (-1)) goto L37;
                r23.smoothScrollToPosition(r11.g.g, new RecyclerView.State(), r11.getAdapterPosition());
                return;
            }
        }

        public final t V3() {
            return (t) this.e.getValue();
        }

        public final b U3(long r4) {
            PanelOperationState r0 = (PanelOperationState) this.g.h.d.a;
            if (h.a[r0.ordinal()] == 1) goto L6;
            return new b(2131251974, 2131917630, new UgcGiftSaleAdapter$InteractGiftViewHolder$getConfig$3(this));
        L6:
            if (this.g.b.contains(Long.valueOf(r4)) == false) goto L9;
            return new b(2131251974, 2131917628, new UgcGiftSaleAdapter$InteractGiftViewHolder$getConfig$1(this));
        L9:
            return new b(2131251979, 2131917629, new UgcGiftSaleAdapter$InteractGiftViewHolder$getConfig$2(this));
        }

        public InteractGiftViewHolder(UgcGiftSaleAdapter r2, final View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.g = r2;
            super(r3);
            this.a = r3.findViewById(2131367792);
            this.b = r3.findViewById(2131373729);
            this.c = (TextView) r3.findViewById(2131373743);
            this.d = (TextView) r3.findViewById(2131368992);
            this.e = LazyKt.lazy(new UgcGiftSaleAdapter$InteractGiftViewHolder$selectView$2(r3));
            this.f = (TextView) r3.findViewById(2131388148);
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
            V3().c(0);
            V3().e();
            this.a.setVisibility(8);
            r8.f = true;
            V3().a(U3(r8.a));
            if (this.g.d != 1) goto L17;
            com.bytedance.android.livesdk.gift.platform.core.preview.f.a().a();
            V3().d();
            com.bytedance.android.livesdk.gift.platform.core.preview.f.a().f(r8.b, r8.a, new UgcGiftSaleAdapter$InteractGiftViewHolder$applySelect$1(this));
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
            this.a.setVisibility(0);
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftAdapter
    public final void A2() {
        this.h.a(this.b, this.c, PanelOperationState.Top);
        Iterator r0 = ((ArrayList) this.a).iterator();
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((com.bytedance.android.livesdk.gift.platform.core.preview.b) r0.next()).f == true) goto L10;
        r2 = r2 + 1;
    L10:
        Integer r3 = Integer.valueOf(r2);
        if (r3.intValue() < 0) goto L13;
        r1 = true;
    L13:
        RecyclerView.ViewHolder r4 = null;
        if (r1 == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L32;
        int r5 = r3.intValue();
        RecyclerView.ViewHolder r6 = this.g.findViewHolderForAdapterPosition(r5);
        if ((r6 instanceof InteractGiftViewHolder) == false) goto L22;
        r4 = r6;
    L22:
        InteractGiftViewHolder r7 = (InteractGiftViewHolder) r4;
        if (r7 == null) goto L33;
        com.bytedance.android.livesdk.gift.platform.core.preview.b r8 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) CollectionsKt.getOrNull(this.a, r5);
        if (r8 == null) goto L27;
        long r9 = r8.a;
    L28:
        r7.V3().a(r7.U3(r9));
        return;
    L27:
        r9 = 0;
        goto L28
    L33:
        return;
    L32:
        return;
    L9:
        r2 = -1;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftAdapter
    public final void B2() {
        Iterator r0 = ((ArrayList) this.a).iterator();
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (((com.bytedance.android.livesdk.gift.platform.core.preview.b) r0.next()).f == true) goto L10;
        r2 = r2 + 1;
    L10:
        Integer r3 = Integer.valueOf(r2);
        if (r3.intValue() < 0) goto L13;
        r1 = true;
    L13:
        RecyclerView.ViewHolder r4 = null;
        if (r1 == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L32;
        int r5 = r3.intValue();
        RecyclerView.ViewHolder r6 = this.g.findViewHolderForAdapterPosition(r5);
        if ((r6 instanceof InteractGiftViewHolder) == false) goto L22;
        r4 = r6;
    L22:
        InteractGiftViewHolder r7 = (InteractGiftViewHolder) r4;
        if (r7 == null) goto L33;
        com.bytedance.android.livesdk.gift.platform.core.preview.b r8 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) CollectionsKt.getOrNull(this.a, r5);
        if (r8 == null) goto L27;
        long r9 = r8.a;
    L28:
        r7.V3().a(r7.U3(r9));
        return;
    L27:
        r9 = 0;
        goto L28
    L33:
        return;
    L32:
        return;
    L9:
        r2 = -1;
        goto L10
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public final Context getContext() {
        return this.f;
    }

    public final void C2(int r7) {
        List<Long> r0 = this.b;
        if (r0.size() < 4) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        ((Number) ListProtector.remove(r0, CollectionsKt.getLastIndex(r0))).longValue();
    L11:
        com.bytedance.android.livesdk.gift.platform.core.preview.b r2 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) CollectionsKt.getOrNull(this.a, r7);
        if (r2 == null) goto L14;
        ListProtector.add(this.b, 0, Long.valueOf(r2.a));
    L14:
        com.bytedance.android.livesdk.gift.platform.core.preview.i.a(this.a, r7, 0);
        notifyDataSetChanged();
        int r8 = ToastUtil.a;
        ToastUtil.b(s1.B(2131917641), 0);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        InteractGiftViewHolder r10 = (InteractGiftViewHolder) r8;
        Intrinsics.checkNotNullParameter(r10, "holder");
        com.bytedance.android.livesdk.gift.platform.core.preview.b r11 = (com.bytedance.android.livesdk.gift.platform.core.preview.b) CollectionsKt.getOrNull(this.a, r9);
        if (r11 == null) goto L12;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "gift");
        r10.c.setText(r11.c);
        r10.d.setVisibility(0);
        r10.d.setText(String.valueOf(r11.d) + " " + r3.c());
        r10.d.requestLayout();
        py.k r0 = r11.e;
        if (r0 == null) goto L7;
        ImageLoader.bindImage(r10.b, r0, s1.j(2131168604), s1.j(2131168604));
    L7:
        r10.V3().b(r11.e, r11.c, String.valueOf(r11.d) + " " + r3.c(), r10.U3(r11.a));
        r10.T3(r11.f, r11);
        if (r10.g.b.contains(Long.valueOf(r11.a)) == false) goto L10;
        r10.f.setVisibility(0);
        r10.f.setText(s1.B(2131917643));
        r10.f.setTextColor(s1.h(2131108461));
        r10.f.setBackground(s1.m(2131250722));
        return;
    L10:
        r10.f.setVisibility(8);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new InteractGiftViewHolder(this, LayoutInflater.from(r3.getContext()).inflate(2131566205, r3, false));
    }

    public UgcGiftSaleAdapter(Context r2, RecyclerView r3, UgcGiftDialogViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.e = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.preview.view.BaseUgcGiftAdapter
    public final void y2(com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.a r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "ugcGiftData");
        Intrinsics.checkNotNullParameter(r4, "clickFrom");
        this.d = r3;
        this.e = r4;
        ((ArrayList) this.c).clear();
        this.b.clear();
        this.b.addAll(r2.c);
        List<Long> r5 = this.c;
        ArrayList r6 = (ArrayList) r5;
        r6.addAll(r2.d);
        List<com.bytedance.android.livesdk.gift.platform.core.preview.b> r7 = r2.a;
        ((ArrayList) this.a).clear();
        ArrayList r8 = (ArrayList) this.a;
        r8.addAll(r7);
        notifyDataSetChanged();
    }
}
