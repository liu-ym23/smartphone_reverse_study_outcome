package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bot.impl.databinding.LarusItemBotGenBgSelectItemBinding;
import com.larus.bot.impl.databinding.LarusLayoutBotEditErrorLayBinding;
import com.larus.utils.e1;
import com.lynx.lottieadapter.LottieAdapterView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\u001a\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\nH\u0016J\u0014\u0010\u001d\u001a\u00020\u000e2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R7\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006 "}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "dataList", "", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectViewHolder$BgSelectItemData;", "onItemClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "setOnItemClick", "(Lkotlin/jvm/functions/Function1;)V", "onItemLongClick", "getOnItemLongClick", "setOnItemLongClick", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "refreshData", "data", "DiffCallback", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BgSelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<BgSelectViewHolder.a> a;
    public Function1<? super Integer, Unit> b;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldItems", "", "Lcom/larus/bot/impl/feature/edit/feature/bgimage/aigen/img2img/select/BgSelectViewHolder$BgSelectItemData;", "newItems", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.Callback {
        public final List<BgSelectViewHolder.a> a;
        public final List<BgSelectViewHolder.a> b;

        public final boolean areItemsTheSame(int r1, int r2) {
            if (r1 != r2) goto L4;
            return true;
        L4:
            return false;
        }

        public final int getNewListSize() {
            return this.b.size();
        }

        public final int getOldListSize() {
            return this.a.size();
        }

        public DiffCallback(List<BgSelectViewHolder.a> r2, List<BgSelectViewHolder.a> r3) {
            Intrinsics.checkNotNullParameter(r2, "oldItems");
            Intrinsics.checkNotNullParameter(r3, "newItems");
            this.a = r2;
            this.b = r3;
        }

        public final boolean areContentsTheSame(int r3, int r4) {
            BgSelectViewHolder.a r5 = (BgSelectViewHolder.a) ListProtector.get(this.b, r4);
            BgSelectViewHolder.a r6 = (BgSelectViewHolder.a) ListProtector.get(this.a, r3);
            if (r5.a == r6.a) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(r5.e, r6.e) == false) goto L9;
            if (Intrinsics.areEqual(r5.g, r6.g) == false) goto L9;
            return true;
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public BgSelectAdapter() {
        this.a = CollectionsKt.emptyList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r14, final int r15) {
        Intrinsics.checkNotNullParameter(r14, "holder");
        final BgSelectViewHolder.a r0 = (BgSelectViewHolder.a) CollectionsKt.getOrNull(this.a, r15);
        if (r0 == null) goto L28;
        Uri r2 = null;
        if ((r14 instanceof BgSelectViewHolder) == false) goto L7;
        final BgSelectViewHolder r1 = (BgSelectViewHolder) r14;
    L8:
        if (r1 == null) goto L28;
        Intrinsics.checkNotNullParameter(r0, "data");
        if (r0.a == false) goto L12;
        r1.a.c.getHierarchy().setPlaceholderImage(2131102539);
        e1.o(r1.a.d);
        e1.o(r1.a.g);
        e1.x(r1.a.b.a);
        LarusItemBotGenBgSelectItemBinding r3 = r1.a;
        r3.b.c.setText(r3.a.getContext().getString(2131906093));
        goto L28
    L12:
        r1.a.c.getHierarchy().setPlaceholderImage(2131239857);
        e1.x(r1.a.c);
        e1.o(r1.a.b.a);
        boolean r4 = false;
        if (r15 != 0) goto L15;
        qu8.b.e("display_image", "gen_bg_by_prompt_with_img", false);
    L15:
        SimpleDraweeView r5 = r1.a.c;
        String r6 = r0.b;
        if (r6 == null) goto L18;
        r2 = UriProtector.parse(r6);
    L18:
        com.larus.bot.impl.common.util.h.b(r5, r2, "bg_select_view_holder", false, null, null, new m(r0, r1, r15), 60);
        if (r0.b != null) goto L28;
        if (r0.g == null) goto L28;
        if (r1.a.d.getVisibility() != 0) goto L25;
        r4 = true;
    L25:
        if (r4 == true) goto L27;
        e1.x(r1.a.d);
        e1.o(r1.a.g);
        r1.a.e.setRepeatMode(1);
        r1.a.e.setRepeatCount(-1);
        r1.a.e.setAnimation("lottie/ai_img_loading.json");
        r1.a.e.playAnimation();
    L27:
        r1.a.f.setText(r1.a.a.getContext().getString(2131906092) + ' ' + r0.g + '%');
        goto L28
    L7:
        r1 = null;
    L28:
        e1.d(r14.itemView, new a(this, r15));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "parent");
        View r13 = LayoutInflater.from(r11.getContext()).inflate(2131562512, r11, false);
        int r0 = 2131371759;
        View r1 = ViewBindings.findChildViewById(r13, 2131371759);
        if (r1 == null) goto L17;
        LarusLayoutBotEditErrorLayBinding r4 = LarusLayoutBotEditErrorLayBinding.a(r1);
        r0 = 2131374931;
        SimpleDraweeView r5 = ViewBindings.findChildViewById(r13, 2131374931);
        if (r5 == null) goto L17;
        r0 = 2131383311;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r13, 2131383311);
        if (r6 == null) goto L17;
        r0 = 2131383320;
        LottieAdapterView r7 = ViewBindings.findChildViewById(r13, 2131383320);
        if (r7 == null) goto L17;
        r0 = 2131383332;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, 2131383332);
        if (r8 == null) goto L17;
        r0 = 2131393018;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r13, 2131393018);
        if (r9 == null) goto L17;
        return new BgSelectViewHolder(new LarusItemBotGenBgSelectItemBinding((FrameLayout) r13, r4, r5, r6, r7, r8, r9));
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
