package com.bytedance.android.live.effect.beauty.body;

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
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyAdapter;
import com.bytedance.android.live.effect.beauty.smallitem.LiveSmallSubItemBeautyAdapter;
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
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/body/LiveBodyBeautyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$c;", "a", "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveBodyBeautyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ILiveEffectComposerManager.c {
    public final List<Sticker> a;
    public final List<String> b;
    public int c;
    public a d;
    public final SparseArray<Boolean> e;
    public final SparseArray<Integer> f;
    public final Lazy g;
    public final c h;
    public final boolean i;
    public final int j;
    public final int k;
    public final LiveEffectContextFactoryDelegate$Type l;
    public boolean m;
    public final boolean n;

    public interface a {
        void a(Sticker r1);

        void b(boolean r1);

        void c(Sticker r1);
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
        public final /* synthetic */ LiveBodyBeautyAdapter a;

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

        public c(LiveBodyBeautyAdapter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void a(Sticker r2) {
            Intrinsics.checkNotNullParameter(r2, "sticker");
            ((Handler) this.a.g.getValue()).post(new a(this));
        }
    }

    public final boolean z2() {
        LiveEffectContextFactoryDelegate$Type r0 = this.l;
        if (r0 != LiveEffectContextFactoryDelegate$Type.DEFAULT) goto L5;
    L8:
        return true;
    L5:
        if (r0 == LiveEffectContextFactoryDelegate$Type.LINK) goto L8;
        return false;
    }

    public final int getItemCount() {
        if (z2() == true) goto L6;
        return ((ArrayList) this.a).size();
    L6:
        if (((ArrayList) this.a).size() > 0) goto L11;
        return 0;
    L11:
        return ((ArrayList) this.a).size() + 1;
    }

    public final int getItemViewType(int r2) {
        if (z2() == false) goto L6;
        if (r2 != 0) goto L6;
        return 1;
    L6:
        return 0;
    }

    public final int y2(int r11) {
        int r1 = -1;
        Integer r0 = this.f.get(r11, -1);
        List r12 = ((Sticker) ListProtector.get(this.a, r11)).getSubStickers();
        Integer r2 = null;
        if (r12 == null) goto L21;
        Iterator r13 = r12.iterator();
        int r4 = 0;
    L6:
        if (r13.hasNext() == false) goto L20;
        Sticker r5 = (Sticker) r13.next();
        List<String> r6 = LiveEffectContext.h;
        Iterator<T> r7 = LiveEffectContext.a.a(this.l).a().o(d0.i).iterator();
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
        if ((r17 instanceof LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder) == false) goto L108;
        if (z2() == false) goto L7;
        final int r2 = r18 - 1;
    L8:
        final LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder r1 = (LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder) r17;
        AnonymousClass1 r3 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r4 = AnonymousClass2.INSTANCE;
        if (this.c != r2) goto L19;
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131364341).setVisibility(0);
        if (this.i == false) goto L13;
        int r5 = 2131107408;
    L14:
        ((TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131390975)).setTextColor(((RecyclerView.ViewHolder) r1).itemView.getContext().getResources().getColor(r5));
        if (this.n == false) goto L24;
        View r6 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131391979);
        if (r6 == null) goto L24;
        r6.setSelected(true);
    L24:
        UrlModel r7 = ((Sticker) ListProtector.get(this.a, r2)).getIcon();
        if (r7 == null) goto L27;
        ImageUtil.loadRoundImage((ImageView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131376045), new ImageModel(r7.getUri(), r7.getUrlList()));
    L27:
        ((TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131390975)).setText(((Sticker) ListProtector.get(this.a, r2)).getName());
        Effect r8 = ((Sticker) ListProtector.get(this.a, r2)).getEffect();
        if (r8 != null) goto L30;
    L34:
        boolean r9 = false;
    L35:
        List<String> r11 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.l).b().r().q((Sticker) ListProtector.get(this.a, r2)) == true) goto L40;
        if (r9 == true) goto L40;
        ((ImageView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131376377)).setVisibility(0);
        g.c(LiveEffectContext.a.a(this.l).b().p(), (Sticker) ListProtector.get(this.a, r2));
    L41:
        if (r9 == true) goto L43;
    L68:
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).setVisibility(8);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).setVisibility(0);
        if (this.n == true) goto L71;
        View r12 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131391979);
        if (r12 == null) goto L82;
        r12.setVisibility(4);
    L82:
        if (this.i == true) goto L84;
    L91:
        r3.invoke(r1, ListProtector.get(this.a, r2));
        ((RecyclerView.ViewHolder) r1).itemView.setOnClickListener(new com.bytedance.android.live.effect.beauty.body.c(this, r1, r9, r4));
        if (LiveEffectContext.a.a(this.l).b().h().c() == false) goto L103;
        List r13 = ((Sticker) ListProtector.get(this.a, r2)).getTags();
        if (r13 == null) goto L103;
        if (r13.contains("outer_test") != true) goto L103;
        ConstraintLayout r14 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131366904);
        if (r14 == null) goto L100;
        r14.setVisibility(0);
    L100:
        View r15 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131375762);
        if (r15 == null) goto L106;
        r15.setVisibility(4);
    L106:
        r3.e(((RecyclerView.ViewHolder) r1).itemView, new LiveBodyBeautyAdapter$onBindBeautyItemViewHolder$6(this, r2, r1));
        return;
    L103:
        ConstraintLayout r16 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131366904);
        if (r16 == null) goto L106;
        r16.setVisibility(4);
        goto L106
    L84:
        if (LiveEffectContext.a.a(this.l).a().B((Sticker) ListProtector.get(this.a, r2)) == false) goto L88;
        View r19 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131375713);
        if (r19 == null) goto L91;
        r19.setVisibility(0);
        goto L91
    L88:
        View r21 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131375713);
        if (r21 == null) goto L91;
        r21.setVisibility(4);
        goto L91
    L71:
        if (LiveEffectContext.a.a(this.l).a().E((Sticker) ListProtector.get(this.a, r2)) == false) goto L75;
        View r22 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131391979);
        if (r22 == null) goto L82;
        r22.setVisibility(0);
        goto L82
    L75:
        View r23 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131391979);
        if (r23 == null) goto L82;
        r23.setVisibility(4);
        goto L82
    L43:
        if (this.e.get(r2, Boolean.FALSE).booleanValue() == false) goto L68;
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).setVisibility(0);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).setVisibility(8);
        r1.a = new LiveSmallSubItemBeautyAdapter(this.i, this.k, this.l, this.n);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131387524).setLayoutManager(new LinearLayoutManager(((RecyclerView.ViewHolder) r1).itemView.getContext(), 0, false));
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131387524).setAdapter(r1.a);
        int r24 = y2(r2);
        if (r24 < 0) goto L49;
        LiveSmallSubItemBeautyAdapter r25 = r1.a;
        if (r25 == null) goto L49;
        r25.d = r24;
    L49:
        LiveSmallSubItemBeautyAdapter r26 = r1.a;
        if (r26 == null) goto L55;
        List<Sticker> r110 = ((Sticker) ListProtector.get(this.a, r2)).getSubStickers();
        if (r110 != null) goto L54;
        r110 = new ArrayList();
    L54:
        r26.setData(r110);
    L55:
        LiveSmallSubItemBeautyAdapter r27 = r1.a;
        if (r27 == null) goto L58;
        com.bytedance.android.live.effect.beauty.body.a r111 = new com.bytedance.android.live.effect.beauty.body.a(this, r2);
        Intrinsics.checkNotNullParameter(r111, "listener");
        r27.e = r111;
    L58:
        ((TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).findViewById(2131387525)).setText(((Sticker) ListProtector.get(this.a, r2)).getName());
        ((ImageView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).findViewById(2131387523)).setOnClickListener(new com.bytedance.android.live.effect.beauty.body.b(this, r2, r1));
        List r28 = ((Sticker) ListProtector.get(this.a, r2)).getSubStickers();
        if (r28 == null) goto L82;
        if (r24 > 0) goto L63;
        r24 = 0;
    L63:
        Sticker r29 = (Sticker) ListProtector.get(r28, r24);
        if (r29 == null) goto L82;
        a r31 = this.d;
        if (r31 == null) goto L82;
        r31.a(r29);
    L40:
        ((ImageView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131376377)).setVisibility(8);
        goto L41
    L30:
        if (r8.getEffectType() != 1) goto L34;
        if (CollectionUtils.isEmpty(((Sticker) ListProtector.get(this.a, r2)).getSubStickers()) == true) goto L34;
        r9 = true;
        goto L35
    L13:
        r5 = 2131107407;
        goto L14
    L19:
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).setVisibility(8);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).setVisibility(0);
        this.e.put(r2, Boolean.FALSE);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131364341).setVisibility(4);
        ((TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131390975)).setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        if (this.n == false) goto L24;
        View r32 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131391979);
        if (r32 == null) goto L24;
        r32.setSelected(false);
        goto L24
    L7:
        r2 = r18;
        goto L8
    L108:
        if ((r17 instanceof b) == false) goto L118;
        b r33 = (b) r17;
        ((RecyclerView.ViewHolder) r33).itemView.findViewById(2131387878).setChecked(this.m);
        TextView r34 = (TextView) ((RecyclerView.ViewHolder) r33).itemView.findViewById(2131387943);
        if (this.m == false) goto L112;
        int r35 = 2131916440;
    L113:
        r34.setText(s1.B(r35));
        ((RecyclerView.ViewHolder) r33).itemView.findViewById(2131387878).setAccessibilityDelegate(new d(r33));
        ((RecyclerView.ViewHolder) r33).itemView.findViewById(2131387878).setOnCheckedChangeListener(new e(this, r33));
        if (LiveEffectSettings.LIVE_EFFECT_BEAUTY_FIX_TALKBACK_2025_07.getValue().booleanValue() == false) goto L119;
        ((RecyclerView.ViewHolder) r33).itemView.post(new f(r33));
        return;
    L119:
        return;
    L112:
        r35 = 2131916439;
        goto L113
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (r5 != 1) goto L13;
        if (this.n == false) goto L8;
        int r6 = 2131565894;
    L14:
        return new b(LayoutInflater.from(r4.getContext()).inflate(r6, r4, false));
    L8:
        if (this.i == false) goto L10;
        r6 = 2131565914;
        goto L14
    L10:
        r6 = 2131565913;
        goto L14
    L13:
        return new LiveSmallItemBeautyAdapter.LiveSmallItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(this.j, r4, false));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4, List<Object> r5) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r5, "payloads");
        if (r5.isEmpty() == false) goto L5;
    L41:
        onBindViewHolder(r3, r4);
        return;
    L5:
        if ((r3 instanceof b) == true) goto L41;
        if (z2() == false) goto L10;
        r4 = r4 - 1;
    L10:
        if (r4 >= 0) goto L12;
        return;
    L12:
        if (r4 < ((ArrayList) this.a).size()) goto L15;
        return;
    L15:
        if (this.i == false) goto L17;
    L18:
        List<String> r6 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.l).a().B((Sticker) ListProtector.get(this.a, r4)) == false) goto L31;
        if (this.i == false) goto L26;
        View r7 = r3.itemView.findViewById(2131375713);
        if (r7 == null) goto L26;
        r7.setVisibility(0);
    L26:
        if (this.n == false) goto L45;
        View r8 = r3.itemView.findViewById(2131391979);
        if (r8 == null) goto L46;
        r8.setVisibility(0);
        return;
    L46:
        return;
    L45:
        return;
    L31:
        if (this.i == false) goto L36;
        View r9 = r3.itemView.findViewById(2131375713);
        if (r9 == null) goto L36;
        r9.setVisibility(4);
    L36:
        if (this.n == false) goto L48;
        View r11 = r3.itemView.findViewById(2131391979);
        if (r11 == null) goto L49;
        r11.setVisibility(4);
        return;
    L49:
        return;
    L48:
        return;
    L17:
        if (this.n == true) goto L18;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r1, Sticker r2, String r3, float r4) {
        ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r1, Sticker r2, String r3, float r4, HashMap<String, String> r5) {
        if (Intrinsics.areEqual(r1, "livebody") == false) goto L14;
        List<String> r6 = this.b;
        if (r2 == null) goto L7;
        String r7 = r2.getEffectId();
    L8:
        int r8 = CollectionsKt.indexOf(r6, r7);
        if (r8 >= 0) goto L11;
        return;
    L11:
        if (r8 >= ((ArrayList) this.b).size()) goto L16;
        notifyItemChanged(r8 + 1, "tagValueChangeListener");
        return;
    L16:
        return;
    L7:
        r7 = null;
        goto L8
    }

    public LiveBodyBeautyAdapter(boolean r2, int r3, int r4, LiveEffectContextFactoryDelegate$Type r5, boolean r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "type");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.n = r7;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.e = new SparseArray();
        this.f = new SparseArray();
        this.g = LazyKt.lazy(LiveBodyBeautyAdapter$handler$2.INSTANCE);
        if (this.m == true) goto L5;
        this.c = -1;
    L5:
        this.h = new c(this);
    }
}
