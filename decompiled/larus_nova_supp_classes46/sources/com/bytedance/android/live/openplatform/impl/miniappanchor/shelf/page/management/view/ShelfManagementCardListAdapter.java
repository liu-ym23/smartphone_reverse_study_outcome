package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
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
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0005\u0004\u0005\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapter$ShelfManagementCardItemViewHolder;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/a;", "a", "OnItemClickListener", "b", "c", "ShelfManagementCardItemViewHolder", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfManagementCardListAdapter extends RecyclerView.Adapter<ShelfManagementCardItemViewHolder> implements com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a {
    public a a;
    public c b;
    public b c;
    public OnItemClickListener d;
    public boolean e;
    public List<ShelfCardInfo> f;
    public Boolean[] g;
    public final boolean h;

    public interface OnItemClickListener {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapter$OnItemClickListener$ClickPosition;", "", "Cover", "Title", "REVIEW_REJECTED", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum ClickPosition extends Enum<ClickPosition> {
            public static final ClickPosition Cover = null;
            public static final ClickPosition REVIEW_REJECTED = null;
            public static final ClickPosition Title = null;
            public static final /* synthetic */ ClickPosition[] a = null;

            static {
                ClickPosition r1 = new ClickPosition("Cover", 0);
                Cover = r1;
                ClickPosition r2 = new ClickPosition("Title", 1);
                Title = r2;
                ClickPosition r3 = new ClickPosition("REVIEW_REJECTED", 2);
                REVIEW_REJECTED = r3;
                a = new ClickPosition[]{r1, r2, r3};
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

        void a(ShelfCardInfo r1, ClickPosition r2);
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfManagementCardListAdapter$ShelfManagementCardItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class ShelfManagementCardItemViewHolder extends RecyclerView.ViewHolder {
        public final CheckBox a;
        public final HSImageView b;
        public final TextView c;
        public final TextView d;
        public final TextView e;
        public final LinearLayout f;
        public final TextView g;
        public final ImageView h;
        public final CommonProductIntroductionLayout i;
        public final CommonProductLabelLayout j;
        public final CommonProductPriceView k;
        public final /* synthetic */ ShelfManagementCardListAdapter l;

        public ShelfManagementCardItemViewHolder(ShelfManagementCardListAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.l = r2;
            super(r3);
            this.a = (CheckBox) r3.findViewById(2131365640);
            this.b = r3.findViewById(2131365170);
            this.c = (TextView) r3.findViewById(2131365182);
            this.d = (TextView) r3.findViewById(2131365225);
            this.e = (TextView) r3.findViewById(2131371405);
            this.f = (LinearLayout) r3.findViewById(2131365174);
            this.g = (TextView) r3.findViewById(2131384490);
            this.h = (ImageView) r3.findViewById(2131370208);
            this.i = (CommonProductIntroductionLayout) r3.findViewById(2131383168);
            this.j = (CommonProductLabelLayout) r3.findViewById(2131383170);
            this.k = (CommonProductPriceView) r3.findViewById(2131383174);
        }
    }

    public interface a {
        void a(ShelfCardInfo r1);
    }

    public interface b {
        void a();

        void c();

        void g();
    }

    public interface c {
        void a(int r1);

        void b(int r1);
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void c() {
        b r0 = this.c;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void g() {
        b r0 = this.c;
        if (r0 == null) goto L6;
        r0.g();
        return;
    }

    public final int getItemCount() {
        return this.f.size();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final boolean isDraggable() {
        return !this.e;
    }

    public ShelfManagementCardListAdapter(boolean r1) {
        this.h = r1;
        this.f = CollectionsKt.emptyList();
        this.g = new Boolean[0];
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        ShelfManagementCardItemViewHolder r13 = (ShelfManagementCardItemViewHolder) r11;
        Intrinsics.checkNotNullParameter(r13, "viewHolder");
        ShelfCardInfo r0 = (ShelfCardInfo) ListProtector.get(this.f, r12);
        r13.getClass();
        Intrinsics.checkNotNullParameter(r0, "shelfCardInfo");
        r13.a.setChecked(r13.l.g[r12].booleanValue());
        r13.a.setOnClickListener(new d(r13, r12));
        r13.c.setText(String.valueOf(r12 + 1));
        ImageLoader.bindImage(r13.b, r0.h());
        r13.b.setOnClickListener(new e(r13, r0));
        r13.d.setOnClickListener(new f(r13, r0));
        Drawable r14 = s1.m(2131250985);
        r14.setBounds(0, 0, (int) t6.a(((RecyclerView.ViewHolder) r13).itemView.getContext(), 8.0f), (int) t6.a(((RecyclerView.ViewHolder) r13).itemView.getContext(), 8.0f));
        r13.e.setCompoundDrawables(null, null, r14, null);
        r13.e.setOnClickListener(new g(r13, r0));
        if (r13.l.e == false) goto L9;
        r13.a.setVisibility(0);
        r13.h.setVisibility(8);
        ViewGroup.LayoutParams r15 = r13.b.getLayoutParams();
        if (r15 == null) goto L8;
        int r1 = UtilityKotlinExtentionsKt.i(12);
        ((ViewGroup.MarginLayoutParams) r15).leftMargin = r1;
    L12:
        r13.l.getClass();
        if (r13.l.e == false) goto L15;
        r13.e.setVisibility(8);
        r13.b.setEnabled(false);
        r13.d.setEnabled(false);
    L17:
        if (r13.l.h == true) goto L19;
    L21:
        r13.f.setVisibility(8);
    L23:
        if (r13.l.h == true) goto L25;
        r13.g.setVisibility(8);
    L32:
        r13.d.setText(r0.i(null));
        ProductInfo r16 = r0.getProductInfo();
        com.bytedance.android.live.openplatform.api.utils.a r2 = com.bytedance.android.live.openplatform.api.utils.a.a;
        if (r2.h() == false) goto L68;
        if (r16 == null) goto L68;
        r13.e.setVisibility(8);
        if (r2.i() == false) goto L47;
        List<ProductIntroductionInfo> r3 = r16.introductionList;
        if (r3 != null) goto L40;
    L43:
        boolean r4 = true;
    L44:
        if (r4 == true) goto L47;
        CommonProductIntroductionLayout r5 = r13.i;
        List<ProductIntroductionInfo> r6 = r16.introductionList;
        Intrinsics.checkNotNull(r6);
        r5.r(r2.k(r6));
        r13.i.setVisibility(0);
    L49:
        if (r2.j() == false) goto L60;
        List<ProductLabelInfo> r7 = r16.labelList;
        if (r7 != null) goto L53;
    L56:
        boolean r8 = true;
    L57:
        if (r8 == true) goto L60;
        CommonProductLabelLayout r9 = r13.j;
        List<ProductLabelInfo> r10 = r16.labelList;
        Intrinsics.checkNotNull(r10);
        r9.r(r2.l(r10));
        r13.j.setVisibility(0);
    L62:
        if (r2.e() == false) goto L67;
        ProductPriceInfo r17 = r16.price;
        if (r17 == null) goto L67;
        CommonProductPriceView r18 = r13.k;
        Intrinsics.checkNotNull(r17);
        r18.b(r17);
        r13.k.setVisibility(0);
    L69:
        int r19 = ((uc1) ee0.a.getValue()).p();
        if (r19 != 1) goto L72;
        Pair r110 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(116)), Integer.valueOf(UtilityKotlinExtentionsKt.i(116)));
    L79:
        int r20 = ((Number) r110.component1()).intValue();
        int r111 = ((Number) r110.component2()).intValue();
        HSImageView r112 = r13.b;
        ViewGroup.LayoutParams r21 = r112.getLayoutParams();
        r21.width = r20;
        r21.height = r111;
        Unit r113 = Unit.INSTANCE;
        r112.setLayoutParams(r21);
        return;
    L72:
        if (r19 == 2) goto L74;
        r110 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(87)), Integer.valueOf(UtilityKotlinExtentionsKt.i(87)));
        goto L79
    L74:
        MiniAppDataContext.Companion.getClass();
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.d(MiniAppDataContext.a.b()) == false) goto L77;
        r110 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(116)), Integer.valueOf(UtilityKotlinExtentionsKt.i(116)));
        goto L79
    L77:
        r110 = TuplesKt.to(Integer.valueOf(UtilityKotlinExtentionsKt.i(87)), Integer.valueOf(UtilityKotlinExtentionsKt.i(87)));
    L67:
        r13.k.setVisibility(8);
        goto L69
    L53:
        if (r7.isEmpty() == true) goto L56;
        r8 = false;
    L60:
        r13.j.setVisibility(8);
        goto L62
    L40:
        if (r3.isEmpty() == true) goto L43;
        r4 = false;
    L47:
        r13.i.setVisibility(8);
    L68:
        r13.i.setVisibility(8);
        r13.j.setVisibility(8);
        r13.k.setVisibility(8);
        goto L69
    L25:
        if (r0.G0(-1) == false) goto L28;
        r13.g.setVisibility(0);
        r13.g.setText(s1.B(2131920928));
        r13.g.setTextColor(s1.h(2131107875));
        r13.g.setBackgroundResource(2131252542);
        r13.g.setCompoundDrawablesWithIntrinsicBounds(null, null, s1.m(2131252543), null);
        r13.g.setCompoundDrawablePadding((int) t6.a(((RecyclerView.ViewHolder) r13).itemView.getContext(), 2.0f));
        r13.g.setOnClickListener(new h(r13, r0));
        goto L32
    L28:
        if (r0.H0(-1) == false) goto L30;
        r13.g.setVisibility(0);
        r13.g.setText(s1.B(2131920929));
        r13.g.setTextColor(s1.h(2131107874));
        r13.g.setBackgroundResource(2131252544);
        r13.g.setCompoundDrawables(null, null, s1.m(2131252543), null);
        r13.g.setCompoundDrawablePadding((int) t6.a(((RecyclerView.ViewHolder) r13).itemView.getContext(), 2.0f));
        r13.g.setOnClickListener(null);
        goto L32
    L30:
        r13.g.setVisibility(8);
        goto L32
    L19:
        if (r0.getStatus() != 1) goto L21;
        r13.f.setVisibility(0);
        goto L23
    L15:
        r13.e.setVisibility(0);
        r13.b.setEnabled(true);
        r13.d.setEnabled(true);
        goto L17
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        r13.a.setVisibility(8);
        r13.a.setChecked(false);
        r13.h.setVisibility(0);
        ViewGroup.LayoutParams r114 = r13.b.getLayoutParams();
        if (r114 == null) goto L82;
        ((ViewGroup.MarginLayoutParams) r114).leftMargin = 0;
        goto L12
    L82:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ShelfManagementCardItemViewHolder(this, LayoutInflater.from(r4.getContext()).inflate(2131566963, r4, false));
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view.a
    public final void r(RecyclerView.ViewHolder r2, RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "source");
        Intrinsics.checkNotNullParameter(r3, "target");
        int r4 = r2.getAdapterPosition();
        int r5 = r3.getAdapterPosition();
        if (r4 < this.f.size()) goto L5;
        return;
    L5:
        if (r5 >= this.f.size()) goto L11;
        Collections.swap(this.f, r4, r5);
        notifyItemMoved(r4, r5);
        notifyItemRangeChanged(Math.min(r4, r5), Math.abs(r4 - r5) + 1);
        b r6 = this.c;
        if (r6 == null) goto L12;
        r6.a();
        return;
    L12:
        return;
    }
}
