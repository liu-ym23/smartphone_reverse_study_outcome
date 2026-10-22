package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductIntroductionInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductLabelInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductPriceInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductIntroductionLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductLabelLayout;
import com.bytedance.android.live.openplatform.impl.miniappcommon.shelf.view.CommonProductPriceView;
import com.bytedance.android.livesdk.config.ee0;
import com.bytedance.android.livesdk.config.uc1;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0006\n\u000b\f\r\u000e\u000fR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapterV2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/a;", "Landroid/app/Activity;", "g", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity", "a", "b", "OnItemClickListener", "c", "d", "ShelfManagementCardItemViewHolder", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfManagementCardListAdapterV2 extends RecyclerView.Adapter<ShelfManagementCardItemViewHolder> implements com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a {
    public b a;
    public d b;
    public c c;
    public OnItemClickListener d;
    public a e;
    public List<aq0.a> f;
    public final Activity g;
    public final boolean h;

    public interface OnItemClickListener {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapterV2$OnItemClickListener$ClickPosition;", "", "Cover", "Title", "MORE", "REVIEW_REJECTED", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum ClickPosition extends Enum<ClickPosition> {
            public static final ClickPosition Cover = null;
            public static final ClickPosition MORE = null;
            public static final ClickPosition REVIEW_REJECTED = null;
            public static final ClickPosition Title = null;
            public static final /* synthetic */ ClickPosition[] a = null;

            static {
                ClickPosition r1 = new ClickPosition("Cover", 0);
                Cover = r1;
                ClickPosition r2 = new ClickPosition("Title", 1);
                Title = r2;
                ClickPosition r3 = new ClickPosition("MORE", 2);
                MORE = r3;
                ClickPosition r4 = new ClickPosition("REVIEW_REJECTED", 3);
                REVIEW_REJECTED = r4;
                a = new ClickPosition[]{r1, r2, r3, r4};
            }

            public static ClickPosition valueOf(String r1) {
                return (ClickPosition) r27.a.a(ClickPosition.class, r1);
            }

            public static ClickPosition[] values() {
                return (ClickPosition[]) a.clone();
            }

            public ClickPosition(String r1, int r2) {
                super(r1, r2);
            }
        }

        void a(ShelfCardInfo r1, ClickPosition r2, int r3);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ShelfManagementCardItemViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final CheckBox b;
        public final HSImageView c;
        public final TextView d;
        public final LinearLayout e;
        public final TextView f;
        public final TextView g;
        public final TextView h;
        public final TextView i;
        public final TextView j;
        public final CommonProductIntroductionLayout k;
        public final CommonProductLabelLayout l;
        public final CommonProductPriceView m;
        public final /* synthetic */ ShelfManagementCardListAdapterV2 n;

        public ShelfManagementCardItemViewHolder(ShelfManagementCardListAdapterV2 r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.n = r2;
            super(r3);
            this.a = r3.findViewById(2131365166);
            this.b = (CheckBox) r3.findViewById(2131365640);
            this.c = r3.findViewById(2131365170);
            this.d = (TextView) r3.findViewById(2131365182);
            this.e = (LinearLayout) r3.findViewById(2131365174);
            this.f = (TextView) r3.findViewById(2131365225);
            this.g = (TextView) r3.findViewById(2131380331);
            this.h = (TextView) r3.findViewById(2131371405);
            this.i = (TextView) r3.findViewById(2131384490);
            this.j = (TextView) r3.findViewById(2131385888);
            this.k = (CommonProductIntroductionLayout) r3.findViewById(2131383168);
            this.l = (CommonProductLabelLayout) r3.findViewById(2131383170);
            this.m = (CommonProductPriceView) r3.findViewById(2131383174);
        }
    }

    public interface a {
        void a();
    }

    public interface b {
        void a(ShelfCardInfo r1, int r2);
    }

    public interface c {
        void a();

        void c();

        void g();
    }

    public interface d {
        void a(int r1);

        void b(int r1);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final boolean isDraggable() {
        return true;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void c() {
        c r0 = this.c;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void g() {
        c r0 = this.c;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public final int getItemCount() {
        return this.f.size();
    }

    public final Activity getActivity() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ShelfManagementCardListAdapterV2(ShelfManagementActivityV2 r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.g = r2;
        this.h = r3;
        this.f = CollectionsKt.emptyList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, final int r12) {
        final ShelfManagementCardItemViewHolder r13 = (ShelfManagementCardItemViewHolder) r11;
        Intrinsics.checkNotNullParameter(r13, "viewHolder");
        aq0.a r0 = (aq0.a) ListProtector.get(this.f, r12);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, "shelfManagementCardInfo");
        r13.b.setChecked(r0.b);
        r13.b.setOnClickListener(new i(r13, r12));
        cq0.a.a(r13.a, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$2(r13, r12));
        r13.d.setText(String.valueOf(r12 + 1));
        final ShelfCardInfo r1 = r0.a;
        ImageLoader.bindImage(r13.c, r1.h());
        cq0.a.a(r13.c, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$3(r13, r1, r12));
        cq0.a.a(r13.f, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$4(r13, r1, r12));
        if (((uc1) ee0.a.getValue()).s() == false) goto L5;
        r13.g.setVisibility(0);
        cq0.a.a(r13.g, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$5(r13, r1, r12));
        r13.g.post(new j(r13));
    L7:
        if (r13.n.h == true) goto L9;
    L11:
        r13.e.setVisibility(8);
    L12:
        boolean r2 = true;
        boolean r5 = r1.c(true);
        if (r5 == false) goto L15;
        r13.j.setVisibility(0);
        r13.j.setText(r1.b());
    L17:
        if (r13.n.h == true) goto L19;
        r13.i.setVisibility(8);
    L26:
        r13.f.setText(r1.i(null));
        ProductInfo r14 = r1.getProductInfo();
        com.bytedance.android.live.openplatform.api.utils.a r3 = com.bytedance.android.live.openplatform.api.utils.a.a;
        if (r3.h() == false) goto L64;
        if (r14 == null) goto L64;
        r13.h.setVisibility(8);
        if (r3.i() == false) goto L41;
        List<ProductIntroductionInfo> r4 = r14.introductionList;
        if (r4 != null) goto L34;
    L37:
        boolean r6 = true;
    L38:
        if (r6 == true) goto L41;
        CommonProductIntroductionLayout r7 = r13.k;
        List<ProductIntroductionInfo> r8 = r14.introductionList;
        Intrinsics.checkNotNull(r8);
        r7.r(r3.k(r8));
        r13.k.setVisibility(0);
        boolean r9 = true;
    L42:
        if (r5 == false) goto L46;
        if (r9 == false) goto L46;
        r13.l.setVisibility(8);
    L58:
        if (r3.e() == false) goto L63;
        ProductPriceInfo r15 = r14.price;
        if (r15 == null) goto L63;
        CommonProductPriceView r10 = r13.m;
        Intrinsics.checkNotNull(r15);
        r10.b(r15);
        r13.m.setVisibility(0);
        return;
    L63:
        r13.m.setVisibility(8);
        return;
    L46:
        if (r3.j() == false) goto L56;
        List<ProductLabelInfo> r16 = r14.labelList;
        if (r16 != null) goto L50;
    L53:
        if (r2 == true) goto L56;
        CommonProductLabelLayout r17 = r13.l;
        List<ProductLabelInfo> r18 = r14.labelList;
        Intrinsics.checkNotNull(r18);
        r17.r(r3.l(r18));
        r13.l.setVisibility(0);
        goto L58
    L50:
        if (r16.isEmpty() == true) goto L53;
        r2 = false;
    L56:
        r13.l.setVisibility(8);
        goto L58
    L34:
        if (r4.isEmpty() == true) goto L37;
        r6 = false;
    L41:
        r13.k.setVisibility(8);
        r9 = false;
    L64:
        r13.k.setVisibility(8);
        r13.l.setVisibility(8);
        r13.m.setVisibility(8);
        return;
    L19:
        if (r1.G0(-1) == false) goto L22;
        r13.i.setVisibility(0);
        r13.i.setText(s1.B(2131920928));
        r13.i.setTextColor(s1.h(2131107875));
        r13.i.setBackgroundResource(2131252542);
        r13.i.setCompoundDrawablesWithIntrinsicBounds(null, null, s1.m(2131252543), null);
        r13.i.setCompoundDrawablePadding((int) t6.a(((RecyclerView.ViewHolder) r13).itemView.getContext(), 2.0f));
        cq0.a.a(r13.i, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$8(r13, r1, r12));
        goto L26
    L22:
        if (r1.H0(-1) == false) goto L24;
        r13.i.setVisibility(0);
        r13.i.setText(s1.B(2131920929));
        r13.i.setTextColor(s1.h(2131107874));
        r13.i.setBackgroundResource(2131252544);
        r13.i.setCompoundDrawables(null, null, s1.m(2131252543), null);
        r13.i.setCompoundDrawablePadding((int) t6.a(((RecyclerView.ViewHolder) r13).itemView.getContext(), 2.0f));
        r13.i.setOnClickListener(null);
        goto L26
    L24:
        r13.i.setVisibility(8);
        goto L26
    L15:
        r13.j.setVisibility(8);
        goto L17
    L9:
        if (r1.getStatus() != 1) goto L11;
        r13.e.setVisibility(0);
        goto L12
    L5:
        Drawable r19 = s1.m(2131250985);
        r19.setBounds(0, 0, (int) t6.a(((RecyclerView.ViewHolder) r13).itemView.getContext(), 8.0f), (int) t6.a(((RecyclerView.ViewHolder) r13).itemView.getContext(), 8.0f));
        r13.h.setVisibility(0);
        r13.h.setCompoundDrawables(null, null, r19, null);
        cq0.a.a(r13.h, new ShelfManagementCardListAdapterV2$ShelfManagementCardItemViewHolder$onBindViewHolder$7(r13, r1, r12));
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ShelfManagementCardItemViewHolder(this, LayoutInflater.from(r4.getContext()).inflate(2131566964, r4, false));
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void r(RecyclerView.ViewHolder r2, RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "target");
        int r4 = r2.getAdapterPosition();
        int r5 = r3.getAdapterPosition();
        Collections.swap(this.f, r4, r5);
        notifyItemMoved(r4, r5);
        c r6 = this.c;
        if (r6 == null) goto L6;
        r6.a();
        return;
    }
}
