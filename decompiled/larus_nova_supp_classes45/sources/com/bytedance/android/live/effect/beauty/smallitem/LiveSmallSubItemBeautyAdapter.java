package com.bytedance.android.live.effect.beauty.smallitem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallSubItemBeautyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallSubItemBeautyAdapter$AbsSmallItemViewHolder;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$c;", "AbsSmallItemViewHolder", "LiveSmallItemVideoViewHolder", "LiveSmallItemViewHolder", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSmallSubItemBeautyAdapter extends RecyclerView.Adapter<AbsSmallItemViewHolder> implements ILiveEffectComposerManager.c {
    public final String a;
    public List<Sticker> b;
    public final List<String> c;
    public int d;
    public a e;
    public final b f;
    public final boolean g;
    public final int h;
    public final LiveEffectContextFactoryDelegate$Type i;
    public final boolean j;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallSubItemBeautyAdapter$AbsSmallItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class AbsSmallItemViewHolder extends RecyclerView.ViewHolder {
        public AbsSmallItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallSubItemBeautyAdapter$LiveSmallItemVideoViewHolder;", "Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallSubItemBeautyAdapter$AbsSmallItemViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LiveSmallItemVideoViewHolder extends AbsSmallItemViewHolder {
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallSubItemBeautyAdapter$LiveSmallItemViewHolder;", "Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallSubItemBeautyAdapter$AbsSmallItemViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LiveSmallItemViewHolder extends AbsSmallItemViewHolder {
        public LiveSmallItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public interface a {
        void a(Sticker r1);
    }

    public static final class b implements LiveSmallItemBeautyHelper.b {
        public final /* synthetic */ LiveSmallSubItemBeautyAdapter a;

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void onError() {
        }

        public b(LiveSmallSubItemBeautyAdapter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void a(Sticker r2) {
            Intrinsics.checkNotNullParameter(r2, "sticker");
            this.a.notifyDataSetChanged();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LiveSmallSubItemBeautyAdapter a;
        public final /* synthetic */ AbsSmallItemViewHolder b;

        public c(LiveSmallSubItemBeautyAdapter r1, AbsSmallItemViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            int r4 = this.b.getAdapterPosition();
            if (r4 >= 0) goto L5;
            return;
        L5:
            if (r4 >= this.a.b.size()) goto L16;
            List<String> r0 = LiveEffectContext.h;
            if (LiveEffectContext.a.a(this.a.i).b().r().q((Sticker) ListProtector.get(this.a.b, r4)) == true) goto L10;
            return;
        L10:
            LiveSmallSubItemBeautyAdapter r1 = this.a;
            r1.d = r4;
            a r2 = r1.e;
            if (r2 == null) goto L13;
            r2.a((Sticker) ListProtector.get(r1.b, r4));
        L13:
            this.a.notifyDataSetChanged();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.smallitem.LiveSmallSubItemBeautyAdapter$onBindViewHolder$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallSubItemBeautyAdapter$AbsSmallItemViewHolder;", "<anonymous parameter 1>", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "invoke"}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function2<AbsSmallItemViewHolder, Sticker, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(2);
        }

        public final void invoke(AbsSmallItemViewHolder r2, Sticker r3) {
            Intrinsics.checkNotNullParameter(r2, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(r3, "<anonymous parameter 1>");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((AbsSmallItemViewHolder) r1, (Sticker) r2);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.smallitem.LiveSmallSubItemBeautyAdapter$onBindViewHolder$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallSubItemBeautyAdapter$AbsSmallItemViewHolder;", "p2", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", "invoke"}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<AbsSmallItemViewHolder, Sticker, Unit> {
        public AnonymousClass2(LiveSmallSubItemBeautyAdapter r8) {
            super(2, r8, LiveSmallSubItemBeautyAdapter.class, "afterBindVideoViewHolder", "afterBindVideoViewHolder(Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallSubItemBeautyAdapter$AbsSmallItemViewHolder;Lcom/bytedance/android/livesdkapi/depend/model/Sticker;)V", 0);
        }

        public final void invoke(AbsSmallItemViewHolder r2, Sticker r3) {
            Intrinsics.checkNotNullParameter(r2, "p1");
            Intrinsics.checkNotNullParameter(r3, "p2");
            ((LiveSmallSubItemBeautyAdapter) ((CallableReference) this).receiver).getClass();
            boolean r4 = r2 instanceof LiveSmallItemViewHolder;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((AbsSmallItemViewHolder) r1, (Sticker) r2);
            return Unit.INSTANCE;
        }
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final void setData(List<Sticker> r4) {
        Intrinsics.checkNotNullParameter(r4, "list");
        this.b = r4;
        ((ArrayList) this.c).clear();
        List<String> r0 = this.c;
        List<Sticker> r5 = r4;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r1.add(((Sticker) r6.next()).getEffectId());
        goto L4
    L6:
        ((ArrayList) r0).addAll(r1);
        notifyDataSetChanged();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        AbsSmallItemViewHolder r4 = (AbsSmallItemViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        if ((r4 instanceof LiveSmallItemViewHolder) == false) goto L6;
        y2(r4, r3, AnonymousClass1.INSTANCE);
        return;
    L6:
        if ((r4 instanceof LiveSmallItemVideoViewHolder) == false) goto L10;
        y2(r4, r3, new AnonymousClass2(this));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        return new LiveSmallItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(this.h, r4, false));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4, List r5) {
        AbsSmallItemViewHolder r6 = (AbsSmallItemViewHolder) r3;
        Intrinsics.checkNotNullParameter(r6, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        if (r5.isEmpty() == false) goto L10;
        Intrinsics.checkNotNullParameter(r6, "holder");
        if ((r6 instanceof LiveSmallItemViewHolder) == false) goto L8;
        y2(r6, r4, AnonymousClass1.INSTANCE);
        return;
    L8:
        if ((r6 instanceof LiveSmallItemVideoViewHolder) == false) goto L23;
        y2(r6, r4, new AnonymousClass2(this));
        return;
    L23:
        return;
    L10:
        if (r4 >= 0) goto L12;
        return;
    L12:
        if (r4 >= this.b.size()) goto L26;
        List<String> r7 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.i).a().E((Sticker) ListProtector.get(this.b, r4)) == false) goto L18;
        View r8 = ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131391979);
        if (r8 == null) goto L27;
        r8.setVisibility(0);
        return;
    L27:
        return;
    L18:
        View r9 = ((RecyclerView.ViewHolder) r6).itemView.findViewById(2131391979);
        if (r9 == null) goto L29;
        r9.setVisibility(4);
        return;
    L29:
        return;
    }

    public final void y2(final AbsSmallItemViewHolder r11, int r12, Function2<? super AbsSmallItemViewHolder, ? super Sticker, Unit> r13) {
        if (this.d != r12) goto L13;
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131364341).setVisibility(0);
        if (this.g == false) goto L7;
        int r0 = 2131107408;
    L8:
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390975)).setTextColor(((RecyclerView.ViewHolder) r11).itemView.getContext().getResources().getColor(r0));
        if (this.j == false) goto L18;
        View r1 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391979);
        if (r1 == null) goto L18;
        r1.setSelected(true);
    L18:
        UrlModel r2 = ((Sticker) ListProtector.get(this.b, r12)).getIcon();
        if (r2 != null) goto L21;
    L24:
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390975)).setText(((Sticker) ListProtector.get(this.b, r12)).getName());
        List<String> r3 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.i).b().r().q((Sticker) ListProtector.get(this.b, r12)) == false) goto L29;
        ((ImageView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131376377)).setVisibility(8);
        if (this.d == r12) goto L35;
        LiveEffectContext.a.a(this.i).a().O(com.bytedance.android.live.effect.api.d0.i, (Sticker) ListProtector.get(this.b, r12), this.a + "_onBindViewHolderReal");
    L35:
        if (this.j == true) goto L37;
        View r4 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391979);
        if (r4 == null) goto L47;
        r4.setVisibility(4);
    L47:
        r13.invoke(r11, ListProtector.get(this.b, r12));
        ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new c(this, r11));
        if (LiveEffectContext.a.a(this.i).b().h().c() == false) goto L59;
        List r14 = ((Sticker) ListProtector.get(this.b, r12)).getTags();
        if (r14 == null) goto L59;
        if (r14.contains("outer_test") != true) goto L59;
        ConstraintLayout r15 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131366904);
        if (r15 == null) goto L56;
        r15.setVisibility(0);
    L56:
        View r16 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131375762);
        if (r16 == null) goto L62;
        r16.setVisibility(4);
    L62:
        r3.e(((RecyclerView.ViewHolder) r11).itemView, new LiveSmallSubItemBeautyAdapter$onBindViewHolderReal$3(r11));
        return;
    L59:
        ConstraintLayout r17 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131366904);
        if (r17 == null) goto L62;
        r17.setVisibility(4);
        goto L62
    L37:
        if (LiveEffectContext.a.a(this.i).a().E((Sticker) ListProtector.get(this.b, r12)) == false) goto L41;
        View r5 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391979);
        if (r5 == null) goto L47;
        r5.setVisibility(0);
        goto L47
    L41:
        View r6 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391979);
        if (r6 == null) goto L47;
        r6.setVisibility(4);
        goto L47
    L29:
        ((ImageView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131376377)).setVisibility(0);
        LiveSmallItemBeautyHelper r7 = LiveEffectContext.a.a(this.i).b().g();
        Sticker r8 = (Sticker) ListProtector.get(this.b, r12);
        if (this.d != r12) goto L32;
        boolean r9 = true;
    L33:
        r7.f(r8, r9, this.f, this.j);
        goto L35
    L32:
        r9 = false;
        goto L33
    L21:
        if (this.j == false) goto L23;
        ImageUtil.loadRoundImageWithRadius((ImageView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131376045), new ImageModel(r2.getUri(), r2.getUrlList()), s1.f(8.0f));
        goto L24
    L23:
        ImageUtil.loadRoundImage((ImageView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131376045), new ImageModel(r2.getUri(), r2.getUrlList()));
        goto L24
    L7:
        r0 = 2131107407;
        goto L8
    L13:
        ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131364341).setVisibility(4);
        ((TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390975)).setTextColor(ColorProtector.parseColor("#B3ffffff"));
        if (this.j == false) goto L18;
        View r18 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131391979);
        if (r18 == null) goto L18;
        r18.setSelected(false);
        goto L18
    }

    public LiveSmallSubItemBeautyAdapter(boolean r2, int r3, LiveEffectContextFactoryDelegate$Type r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.a = "LiveSmallSubItemBeautyAdapter";
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.f = new b(this);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r1, Sticker r2, String r3, float r4) {
        ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r1, Sticker r2, String r3, float r4, HashMap<String, String> r5) {
        if (Intrinsics.areEqual(r1, com.bytedance.android.live.effect.api.d0.i) == false) goto L14;
        List<String> r6 = this.c;
        if (r2 == null) goto L7;
        String r7 = r2.getEffectId();
    L8:
        int r8 = CollectionsKt.indexOf(r6, r7);
        if (r8 >= 0) goto L11;
        return;
    L11:
        if (r8 >= ((ArrayList) this.c).size()) goto L16;
        notifyItemChanged(r8, "tagValueChangeListener");
        return;
    L16:
        return;
    L7:
        r7 = null;
        goto L8
    }
}
