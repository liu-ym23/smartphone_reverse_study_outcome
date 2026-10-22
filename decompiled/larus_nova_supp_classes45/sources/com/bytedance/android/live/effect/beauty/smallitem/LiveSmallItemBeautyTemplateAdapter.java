package com.bytedance.android.live.effect.beauty.smallitem;

import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
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
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyTemplateAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$c;", "AbsSmallItemViewHolder", "LiveSmallItemViewHolder", "a", "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSmallItemBeautyTemplateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ILiveEffectComposerManager.c {
    public final List<Sticker> a;
    public final List<String> b;
    public final Map<String, List<Integer>> c;
    public int d;
    public a e;
    public final SparseArray<Boolean> f;
    public final SparseArray<Integer> g;
    public final Lazy h;
    public LiveSmallSubItemBeautyAdapter i;
    public final c j;
    public final int k;
    public final int l;
    public final LiveEffectContextFactoryDelegate$Type m;
    public boolean n;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyTemplateAdapter$AbsSmallItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class AbsSmallItemViewHolder extends RecyclerView.ViewHolder {
        public LiveSmallSubItemBeautyAdapter a;

        public AbsSmallItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyTemplateAdapter$LiveSmallItemViewHolder;", "Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyTemplateAdapter$AbsSmallItemViewHolder;", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
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
        void a(Sticker r1);

        void b(boolean r1);

        void c(int r1);

        void d(Sticker r1, int r2);
    }

    public static final class b extends RecyclerView.ViewHolder {

        public static final class a {
        }

        static {
        }

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public static final class c implements LiveSmallItemBeautyHelper.b {
        public final /* synthetic */ LiveSmallItemBeautyTemplateAdapter a;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;

            public a(c r1) {
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

        public c(LiveSmallItemBeautyTemplateAdapter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void a(Sticker r2) {
            Intrinsics.checkNotNullParameter(r2, "sticker");
            ((Handler) this.a.h.getValue()).post(new a(this));
        }
    }

    public final int getItemViewType(int r1) {
        return r1;
    }

    public final int getItemCount() {
        if (((ArrayList) this.a).size() > 0) goto L7;
        return 0;
    L7:
        return ((ArrayList) this.a).size() + 1;
    }

    public final int y2(int r11) {
        int r1 = -1;
        Integer r0 = this.g.get(r11, -1);
        List r12 = ((Sticker) ListProtector.get(this.a, r11)).getSubStickers();
        Integer r2 = null;
        if (r12 == null) goto L21;
        Iterator r13 = r12.iterator();
        int r4 = 0;
    L6:
        if (r13.hasNext() == false) goto L20;
        Sticker r5 = (Sticker) r13.next();
        List<String> r6 = LiveEffectContext.h;
        Iterator<T> r7 = LiveEffectContext.a.a(this.m).a().o(com.bytedance.android.live.effect.api.d0.i).iterator();
    L9:
        if (r7.hasNext() == false) goto L13;
        Object r8 = r7.next();
        if (Intrinsics.areEqual(((Sticker) r8).getEffectId(), r5.getEffectId()) == false) goto L9;
    L14:
        if (r8 == null) goto L16;
        boolean r9 = true;
    L17:
        if (r9 == true) goto L18;
        r4 = r4 + 1;
        goto L6
    L18:
        r1 = r4;
        goto L20
    L16:
        r9 = false;
        goto L17
    L13:
        r8 = null;
    L20:
        r2 = Integer.valueOf(r1);
    L21:
        if (r2 == null) goto L26;
        if (r2.intValue() < 0) goto L26;
        r0 = r2;
    L26:
        return r0.intValue();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r17, int r18) {
        Intrinsics.checkNotNullParameter(r17, "holder");
        if ((r17 instanceof AbsSmallItemViewHolder) == false) goto L94;
        final int r2 = r18 - 1;
        final AbsSmallItemViewHolder r1 = (AbsSmallItemViewHolder) r17;
        AnonymousClass1 r3 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r4 = AnonymousClass2.INSTANCE;
        if (this.d != r2) goto L12;
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131364341).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131390975)).setTextColor(((RecyclerView.ViewHolder) r1).itemView.getContext().getResources().getColor(2131107407));
        View r5 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068);
        if (r5 == null) goto L9;
        View r6 = r5.findViewById(2131391979);
    L10:
        if (r6 == null) goto L18;
        r6.setSelected(true);
    L18:
        UrlModel r7 = ((Sticker) ListProtector.get(this.a, r2)).getIcon();
        if (r7 == null) goto L21;
        ImageUtil.loadRoundImageWithRadius((ImageView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131376045), new ImageModel(r7.getUri(), r7.getUrlList()), s1.f(8.0f));
    L21:
        ((TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131390975)).setText(((Sticker) ListProtector.get(this.a, r2)).getName());
        Effect r8 = ((Sticker) ListProtector.get(this.a, r2)).getEffect();
        if (r8 != null) goto L24;
    L28:
        boolean r9 = false;
    L29:
        List<String> r11 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.m).b().r().q((Sticker) ListProtector.get(this.a, r2)) == true) goto L34;
        if (r9 == true) goto L34;
        ((ImageView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131376377)).setVisibility(0);
        LiveSmallItemBeautyHelper.g(LiveEffectContext.a.a(this.m).b().g(), (Sticker) ListProtector.get(this.a, r2), true, true, 4);
    L35:
        if (r9 == true) goto L37;
    L62:
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).setVisibility(8);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).setVisibility(0);
    L63:
        r3.invoke(r1, ListProtector.get(this.a, r2));
        ((RecyclerView.ViewHolder) r1).itemView.setOnClickListener(new g0(this, r1, r9, r4));
        if (LiveEffectContext.a.a(this.m).b().h().c() == false) goto L75;
        List r12 = ((Sticker) ListProtector.get(this.a, r2)).getTags();
        if (r12 == null) goto L75;
        if (r12.contains("outer_test") != true) goto L75;
        ConstraintLayout r13 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131366904);
        if (r13 == null) goto L72;
        r13.setVisibility(0);
    L72:
        View r14 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131375762);
        if (r14 == null) goto L79;
        r14.setVisibility(4);
    L79:
        if (LiveEffectContext.a.a(this.m).a().E((Sticker) ListProtector.get(this.a, r2)) == false) goto L86;
        View r15 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068);
        if (r15 == null) goto L83;
        View r16 = r15.findViewById(2131391979);
    L84:
        if (r16 == null) goto L92;
        r16.setVisibility(0);
    L92:
        r3.e(((RecyclerView.ViewHolder) r1).itemView, new LiveSmallItemBeautyTemplateAdapter$onBindBeautyItemViewHolder$6(this, r2, r1));
        return;
    L83:
        r16 = null;
        goto L84
    L86:
        View r19 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068);
        if (r19 == null) goto L89;
        View r21 = r19.findViewById(2131391979);
    L90:
        if (r21 == null) goto L92;
        r21.setVisibility(4);
        goto L92
    L89:
        r21 = null;
    L75:
        ConstraintLayout r22 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131366904);
        if (r22 == null) goto L79;
        r22.setVisibility(4);
        goto L79
    L37:
        if (this.f.get(r2, Boolean.FALSE).booleanValue() == false) goto L62;
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).setVisibility(0);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).setVisibility(8);
        LiveSmallSubItemBeautyAdapter r23 = new LiveSmallSubItemBeautyAdapter(false, this.l, this.m, true);
        r1.a = r23;
        this.i = r23;
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131387524).setLayoutManager(new LinearLayoutManager(((RecyclerView.ViewHolder) r1).itemView.getContext(), 0, false));
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131387524).setAdapter(r1.a);
        int r24 = y2(r2);
        if (r24 < 0) goto L43;
        LiveSmallSubItemBeautyAdapter r25 = r1.a;
        if (r25 == null) goto L43;
        r25.d = r24;
    L43:
        LiveSmallSubItemBeautyAdapter r26 = r1.a;
        if (r26 == null) goto L49;
        List<Sticker> r110 = ((Sticker) ListProtector.get(this.a, r2)).getSubStickers();
        if (r110 != null) goto L48;
        r110 = new ArrayList();
    L48:
        r26.setData(r110);
    L49:
        LiveSmallSubItemBeautyAdapter r27 = r1.a;
        if (r27 == null) goto L52;
        e0 r111 = new e0(this, r2);
        Intrinsics.checkNotNullParameter(r111, "listener");
        r27.e = r111;
    L52:
        ((TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).findViewById(2131387525)).setText(((Sticker) ListProtector.get(this.a, r2)).getName());
        ((ImageView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).findViewById(2131387523)).setOnClickListener(new f0(this, r2, r1));
        List r28 = ((Sticker) ListProtector.get(this.a, r2)).getSubStickers();
        if (r28 == null) goto L63;
        if (r24 > 0) goto L57;
        r24 = 0;
    L57:
        Sticker r29 = (Sticker) ListProtector.get(r28, r24);
        if (r29 == null) goto L63;
        a r31 = this.e;
        if (r31 == null) goto L63;
        r31.a(r29);
    L34:
        ((ImageView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131376377)).setVisibility(8);
        goto L35
    L24:
        if (r8.getEffectType() != 1) goto L28;
        if (CollectionUtils.isEmpty(((Sticker) ListProtector.get(this.a, r2)).getSubStickers()) == true) goto L28;
        r9 = true;
        goto L29
    L9:
        r6 = null;
        goto L10
    L12:
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).setVisibility(8);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).setVisibility(0);
        this.f.put(r2, Boolean.FALSE);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131364341).setVisibility(4);
        ((TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131390975)).setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        View r32 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068);
        if (r32 == null) goto L15;
        View r33 = r32.findViewById(2131391979);
    L16:
        if (r33 == null) goto L18;
        r33.setSelected(false);
        goto L18
    L15:
        r33 = null;
        goto L16
    L94:
        if ((r17 instanceof b) == false) goto L102;
        b r34 = (b) r17;
        ((RecyclerView.ViewHolder) r34).itemView.findViewById(2131387878).setChecked(this.n);
        TextView r35 = (TextView) ((RecyclerView.ViewHolder) r34).itemView.findViewById(2131387943);
        if (this.n == false) goto L98;
        int r36 = 2131916440;
    L99:
        r35.setText(s1.B(r36));
        ((RecyclerView.ViewHolder) r34).itemView.findViewById(2131387878).setOnCheckedChangeListener(new h0(this, r34));
        return;
    L98:
        r36 = 2131916439;
        goto L99
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (r5 != 0) goto L6;
        return new b(LayoutInflater.from(r4.getContext()).inflate(2131565894, r4, false));
    L6:
        return new LiveSmallItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(this.k, r4, false));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        if (r5.isEmpty() == false) goto L5;
    L25:
        onBindViewHolder(r3, r4);
        return;
    L5:
        if ((r3 instanceof b) == true) goto L25;
        int r6 = r4 - 1;
        if (r6 >= 0) goto L10;
        return;
    L10:
        if (r6 >= ((ArrayList) this.a).size()) goto L27;
        List<String> r7 = LiveEffectContext.h;
        View r0 = null;
        if (LiveEffectContext.a.a(this.m).a().E((Sticker) ListProtector.get(this.a, r6)) == false) goto L19;
        View r8 = r3.itemView.findViewById(2131373068);
        if (r8 == null) goto L17;
        r0 = r8.findViewById(2131391979);
    L17:
        if (r0 == null) goto L28;
        r0.setVisibility(0);
        return;
    L28:
        return;
    L19:
        View r9 = r3.itemView.findViewById(2131373068);
        if (r9 == null) goto L22;
        r0 = r9.findViewById(2131391979);
    L22:
        if (r0 == null) goto L30;
        r0.setVisibility(4);
        return;
    L30:
        return;
    }

    public LiveSmallItemBeautyTemplateAdapter(int r2, int r3, LiveEffectContextFactoryDelegate$Type r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "type");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r5;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
        this.f = new SparseArray();
        this.g = new SparseArray();
        this.h = LazyKt.lazy(LiveSmallItemBeautyTemplateAdapter$handler$2.INSTANCE);
        if (this.n == true) goto L5;
        this.d = -1;
    L5:
        this.j = new c(this);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r1, Sticker r2, String r3, float r4) {
        ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r8, Sticker r9, String r11, float r12, HashMap<String, String> r13) {
        if (Intrinsics.areEqual(r8, com.bytedance.android.live.effect.api.d0.i) == false) goto L64;
        Map<String, List<Integer>> r14 = this.c;
        String r0 = null;
        if (r9 == null) goto L7;
        String r1 = r9.getEffectId();
    L8:
        if (r14 == null) goto L63;
        if (r14.containsKey(r1) == false) goto L17;
        Map<String, List<Integer>> r15 = this.c;
        if (r9 == null) goto L14;
        r0 = r9.getEffectId();
    L14:
        List r16 = (List) ((LinkedHashMap) r15).get(r0);
        List r17 = r16;
        if (r16 != null) goto L51;
        r17 = CollectionsKt.emptyList();
    L51:
        Iterator r18 = r17.iterator();
    L53:
        if (r18.hasNext() == false) goto L59;
        int r2 = ((Number) r18.next()).intValue();
        if (r2 < 0) goto L53;
        if (r2 >= ((ArrayList) this.b).size()) goto L53;
        notifyItemChanged(r2 + 1, "tagValueChangeListener");
        goto L53
    L59:
        LiveSmallSubItemBeautyAdapter r19 = this.i;
        if (r19 == null) goto L79;
        ILiveEffectComposerManager.c.a.a(r19, r8, r9, r11, r12);
        return;
    L79:
        return;
    L17:
        Iterable r110 = CollectionsKt.withIndex(this.b);
        ArrayList r3 = new ArrayList();
        Iterator r111 = r110.iterator();
    L19:
        if (r111.hasNext() == false) goto L41;
        Object r4 = r111.next();
        IndexedValue r5 = (IndexedValue) r4;
        String r6 = (String) r5.getValue();
        if (r9 == null) goto L23;
        String r7 = r9.getEffectId();
    L24:
        boolean r21 = Intrinsics.areEqual(r6, r7);
        boolean r22 = true;
        if (r21 == true) goto L39;
        List r23 = ((Sticker) ListProtector.get(this.a, r5.getIndex())).getSubStickers();
        if (r23 == null) goto L38;
        List r24 = r23;
        ArrayList r25 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));
        Iterator r26 = r24.iterator();
    L30:
        if (r26.hasNext() == false) goto L32;
        r25.add(((Sticker) r26.next()).getEffectId());
        goto L30
    L32:
        if (r9 == null) goto L34;
        String r27 = r9.getEffectId();
    L36:
        if (CollectionsKt.contains(r25, r27) != true) goto L38;
    L34:
        r27 = null;
    L38:
        r22 = false;
    L39:
        if (r22 == false) goto L19;
        r3.add(r4);
        goto L19
    L23:
        r7 = null;
        goto L24
    L41:
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r28 = r3.iterator();
    L43:
        if (r28.hasNext() == false) goto L45;
        r112.add(Integer.valueOf(((IndexedValue) r28.next()).getIndex()));
        goto L43
    L45:
        Map<String, List<Integer>> r29 = this.c;
        if (r9 == null) goto L49;
        String r31 = r9.getEffectId();
        if (r31 == null) goto L49;
    L50:
        r29.put(r31, r112);
        r17 = r112;
    L49:
        r31 = "";
        goto L50
    L63:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    L7:
        r1 = null;
        goto L8
    }
}
