package com.larus.bot.impl.feature.discover.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bot.impl.databinding.LarusItemBotCardPlaceHolderBinding;
import com.larus.bot.impl.databinding.LarusItemBotDiscoveryBinding;
import com.larus.bot.impl.databinding.LarusItemBotDiscoveryCardBinding;
import com.larus.bot.impl.databinding.LarusItemBotPlaceHolderBinding;
import com.larus.bot.impl.feature.discover.BotItemCardViewHolder;
import com.larus.bot.impl.feature.discover.BotItemViewHolder;
import com.larus.bot.impl.feature.discover.BotLoadMoreViewHolder;
import com.larus.bot.impl.feature.discover.w0;
import com.larus.common_res.common_ui.databinding.LarusItemLoadMoreBinding;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.common_ui.widget.AvatarTagView;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c6;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0017\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002/0B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010'\u001a\u00020!H\u0016J\u000e\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010*J\u000e\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u00061"}, d2 = {"Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverListAdapter;", "Lcom/larus/common_ui/paging/FPagingAdapter;", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "config", "Lcom/larus/common_ui/paging/FPagingAdapter$Config;", "<init>", "(Lcom/larus/common_ui/paging/FPagingAdapter$Config;)V", "helper", "Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverListAdapter$EventHelper;", "getHelper", "()Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverListAdapter$EventHelper;", "setHelper", "(Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverListAdapter$EventHelper;)V", "hasBotCreateButton", "", "getHasBotCreateButton", "()Z", "setHasBotCreateButton", "(Z)V", "loadMoreItem", "showTwoColumns", "listener", "com/larus/bot/impl/feature/discover/adapter/BotDiscoverListAdapter$listener$1", "Lcom/larus/bot/impl/feature/discover/adapter/BotDiscoverListAdapter$listener$1;", "getItemViewType", "", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "data", "distinctDatas", "notifyItemChanged", "botId", "", "removeData", "itemId", "updateLoadMoreStatus", "status", "Companion", "EventHelper", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotDiscoverListAdapter extends FPagingAdapter<RecommendBot, RecyclerView.ViewHolder> {
    public static final /* synthetic */ int k = 0;
    public b f;
    public boolean g;
    public final RecommendBot h;
    public final boolean i;
    public final c j;

    public static final class a {
    }

    public interface b {
        void a(RecommendBot r1, int r2);

        void b(RecommendBot r1, int r2);

        void c(RecommendBot r1, int r2);

        void d(RecommendBot r1);

        void e();
    }

    public static final class c extends c6 {
        public final /* synthetic */ BotDiscoverListAdapter c;

        public c(BotDiscoverListAdapter r1) {
            this.c = r1;
        }

        public final void a(View r2) {
            Intrinsics.checkNotNullParameter(r2, "v");
            Object r3 = r2.getTag();
            if ((r3 instanceof RecommendBot) == false) goto L5;
            RecommendBot r4 = (RecommendBot) r3;
        L6:
            if (r4 == null) goto L11;
            b r0 = this.c.f;
            if (r0 == null) goto L12;
            r0.d(r4);
            return;
        L12:
            return;
        L11:
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    static {
    }

    public final void z2() {
        List r0 = ((FPagingAdapter) this).b;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (((RecommendBot) CollectionsKt.first(((FPagingAdapter) this).b)).p0() == true) goto L27;
        List r2 = ((FPagingAdapter) this).b;
        HashSet r3 = new HashSet();
        ArrayList r4 = new ArrayList();
        Iterator r5 = r2.iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        Object r6 = r5.next();
        if (r3.add(((RecommendBot) r6).o()) == false) goto L15;
        r4.add(r6);
        goto L15
    L19:
        ((ArrayList) ((FPagingAdapter) this).b).clear();
        ((ArrayList) ((FPagingAdapter) this).b).addAll(r4);
        return;
    L27:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public BotDiscoverListAdapter(FPagingAdapter.a r45) {
        Intrinsics.checkNotNullParameter(r45, "config");
        super(r45);
        this.h = new RecommendBot(null, null, null, null, null, 0, 0, 0, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, -1, 7679);
        this.i = z2.a.C0();
        this.j = new c(this);
    }

    public final void H2(String r4) {
        Intrinsics.checkNotNullParameter(r4, "botId");
        Iterator r0 = ((ArrayList) ((FPagingAdapter) this).b).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(((RecommendBot) r0.next()).o(), r4) == true) goto L11;
        r1 = r1 + 1;
    L11:
        if (C2(r1) == false) goto L16;
        notifyItemChanged(r1);
        return;
    L16:
        return;
    L9:
        r1 = -1;
        goto L11
    }

    public final int getItemViewType(int r3) {
        RecommendBot r4 = (RecommendBot) A2(r3);
        if (r4 != null) goto L6;
        return 0;
    L6:
        if (r4.p0() == false) goto L10;
        return 1;
    L10:
        if (Intrinsics.areEqual(r4, this.h) == false) goto L13;
        return 2;
    L13:
        return 0;
    }

    public final void onAttachedToRecyclerView(RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super.onAttachedToRecyclerView(r3);
        final GridLayoutManager r4 = r3.getLayoutManager();
        if ((r4 instanceof GridLayoutManager) == false) goto L6;
        r4.setSpanSizeLookup(new AnonymousClass1(this, r4));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r29, int r30) {
        Intrinsics.checkNotNullParameter(r29, "parent");
        LayoutInflater r3 = LayoutInflater.from(r29.getContext());
        int r5 = 2131388462;
        int r6 = 2131363623;
        if (r30 == 1) goto L84;
        if (r30 == 2) goto L104;
        if (this.i == false) goto L38;
        ConstraintLayout r1 = r3.inflate(2131562511, r29, false);
        ImageView r17 = (ImageView) ViewBindings.findChildViewById(r1, 2131362230);
        if (r17 == null) goto L35;
        SimpleDraweeView r18 = ViewBindings.findChildViewById(r1, 2131363623);
        if (r18 == null) goto L37;
        ConstraintLayout r16 = r1;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r1, 2131364360);
        if (r19 == null) goto L34;
        TextView r20 = (TextView) ViewBindings.findChildViewById(r1, 2131364368);
        if (r20 == null) goto L33;
        LinearLayout r21 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131364369);
        if (r21 != null) goto L19;
        r6 = 2131364369;
        goto L37
    L19:
        if (((LinearLayout) ViewBindings.findChildViewById(r1, 2131364379)) == null) goto L31;
        TextView r22 = (TextView) ViewBindings.findChildViewById(r1, 2131368849);
        if (r22 == null) goto L30;
        r6 = 2131376312;
        AppCompatImageView r23 = ViewBindings.findChildViewById(r1, 2131376312);
        if (r23 == null) goto L37;
        TextView r24 = (TextView) ViewBindings.findChildViewById(r1, 2131380593);
        if (r24 == null) goto L29;
        r6 = 2131380598;
        LinearLayout r25 = (LinearLayout) ViewBindings.findChildViewById(r1, 2131380598);
        if (r25 == null) goto L37;
        return new BotItemCardViewHolder(new LarusItemBotDiscoveryCardBinding(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25));
    L29:
        r6 = 2131380593;
        goto L37
    L30:
        r6 = 2131368849;
        goto L37
    L31:
        r6 = 2131364379;
        goto L37
    L33:
        r6 = 2131364368;
        goto L37
    L34:
        r6 = 2131364360;
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r1.getResources().getResourceName(r6)));
    L35:
        r6 = 2131362230;
        goto L37
    L38:
        View r2 = r3.inflate(2131562510, r29, false);
        ImageView r110 = (ImageView) ViewBindings.findChildViewById(r2, 2131362230);
        if (r110 == null) goto L79;
        FrameLayout r111 = (FrameLayout) ViewBindings.findChildViewById(r2, 2131362231);
        if (r111 == null) goto L78;
        SimpleDraweeView r112 = ViewBindings.findChildViewById(r2, 2131363623);
        if (r112 != null) goto L45;
        r5 = 2131363623;
    L81:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r5)));
    L45:
        if (ViewBindings.findChildViewById(r2, 2131363723) == null) goto L76;
        AvatarTagView r26 = ViewBindings.findChildViewById(r2, 2131363736);
        if (r26 == null) goto L75;
        TextView r27 = (TextView) ViewBindings.findChildViewById(r2, 2131364360);
        if (r27 == null) goto L74;
        TextView r28 = (TextView) ViewBindings.findChildViewById(r2, 2131364368);
        if (r28 == null) goto L73;
        LinearLayout r210 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131364369);
        if (r210 != null) goto L55;
        r5 = 2131364369;
        goto L81
    L55:
        if (ViewBindings.findChildViewById(r2, 2131364379) == null) goto L71;
        TextView r211 = (TextView) ViewBindings.findChildViewById(r2, 2131368849);
        if (r211 == null) goto L70;
        ImageView r212 = (ImageView) ViewBindings.findChildViewById(r2, 2131369222);
        if (r212 == null) goto L69;
        TextView r213 = (TextView) ViewBindings.findChildViewById(r2, 2131380593);
        if (r213 == null) goto L68;
        LinearLayout r214 = (LinearLayout) ViewBindings.findChildViewById(r2, 2131388092);
        if (r214 != null) goto L65;
        r5 = 2131388092;
        goto L81
    L65:
        if (((LinearLayout) ViewBindings.findChildViewById(r2, 2131388462)) == null) goto L81;
        return new BotItemViewHolder(new LarusItemBotDiscoveryBinding((RelativeLayout) r2, r110, r111, r112, r26, r27, r28, r210, r211, r212, r213, r214));
    L68:
        r5 = 2131380593;
        goto L81
    L69:
        r5 = 2131369222;
        goto L81
    L70:
        r5 = 2131368849;
        goto L81
    L71:
        r5 = 2131364379;
        goto L81
    L73:
        r5 = 2131364368;
        goto L81
    L74:
        r5 = 2131364360;
        goto L81
    L75:
        r5 = 2131363736;
        goto L81
    L76:
        r5 = 2131363723;
        goto L81
    L78:
        r5 = 2131362231;
        goto L81
    L79:
        r5 = 2131362230;
        goto L81
    L104:
        return new BotLoadMoreViewHolder(LarusItemLoadMoreBinding.a(r3, r29));
    L84:
        if (this.i == false) goto L90;
        ConstraintLayout r4 = r3.inflate(2131562509, r29, false);
        if (r4 == null) goto L89;
        return new ViewBindingHolder(new LarusItemBotCardPlaceHolderBinding(r4));
    L89:
        throw new NullPointerException("rootView");
    L90:
        View r7 = r3.inflate(2131562513, r29, false);
        View r8 = ViewBindings.findChildViewById(r7, 2131362230);
        if (r8 == null) goto L99;
        View r9 = ViewBindings.findChildViewById(r7, 2131363623);
        if (r9 != null) goto L95;
        r5 = 2131363623;
    L101:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r5)));
    L95:
        if (((LinearLayout) ViewBindings.findChildViewById(r7, 2131388462)) == null) goto L101;
        return new ViewBindingHolder(new LarusItemBotPlaceHolderBinding((RelativeLayout) r7, r8, r9));
    L99:
        r5 = 2131362230;
        goto L101
    }

    public final void D2(RecyclerView.ViewHolder r3, Object r4, final int r5) {
        final RecommendBot r6 = (RecommendBot) r4;
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r6, "data");
        if ((r3 instanceof w0) == false) goto L6;
        w0 r7 = (w0) r3;
        r7.X2(r6);
        View r0 = r7.getRootView();
        r0.setOnClickListener(this.j);
        r0.setTag(r6);
        e1.d(r7.T1(), new su8.a(r6, this, r5));
        return;
    L6:
        if ((r3 instanceof BotLoadMoreViewHolder) == false) goto L24;
        BotLoadMoreViewHolder r8 = (BotLoadMoreViewHolder) r3;
        int r9 = r6.S();
        if (this.g == false) goto L10;
        r8.a.a.setPadding(0, 0, 0, i5.s0());
    L12:
        if (r9 != (-1)) goto L14;
        r8.a.c.setVisibility(8);
        r8.a.b.setVisibility(0);
    L21:
        e1.d(r8.a.b, new su8.b(this));
        return;
    L14:
        if (r9 != 1) goto L16;
        r8.a.c.setVisibility(0);
        r8.a.b.setVisibility(8);
        goto L21
    L16:
        if (r9 != 2) goto L21;
        r8.a.c.setVisibility(8);
        r8.a.b.setVisibility(8);
        goto L21
    L10:
        r8.a.a.setPadding(0, 0, 0, 0);
        goto L12
    }
}
