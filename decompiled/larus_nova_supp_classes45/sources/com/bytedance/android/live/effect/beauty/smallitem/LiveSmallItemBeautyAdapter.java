package com.bytedance.android.live.effect.beauty.smallitem;

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
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$c;", "AbsSmallItemViewHolder", "LiveSmallItemViewHolder", "a", "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSmallItemBeautyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ILiveEffectComposerManager.c {
    public final List<Sticker> a;
    public int b;
    public a c;
    public final SparseArray<Boolean> d;
    public final SparseArray<Integer> e;
    public final Lazy f;
    public final r g;
    public final boolean h;
    public final int i;
    public final int j;
    public final LiveEffectContextFactoryDelegate$Type k;
    public boolean l;
    public final boolean m;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyAdapter$AbsSmallItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class AbsSmallItemViewHolder extends RecyclerView.ViewHolder {
        public LiveSmallSubItemBeautyAdapter a;

        public AbsSmallItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyAdapter$LiveSmallItemViewHolder;", "Lcom/bytedance/android/live/effect/beauty/smallitem/LiveSmallItemBeautyAdapter$AbsSmallItemViewHolder;", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public final boolean z2() {
        LiveEffectContextFactoryDelegate$Type r0 = this.k;
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
        Integer r0 = this.e.get(r11, -1);
        List r12 = ((Sticker) ListProtector.get(this.a, r11)).getSubStickers();
        Integer r2 = null;
        if (r12 == null) goto L21;
        Iterator r13 = r12.iterator();
        int r4 = 0;
    L6:
        if (r13.hasNext() == false) goto L20;
        Sticker r5 = (Sticker) r13.next();
        List<String> r6 = LiveEffectContext.h;
        Iterator<T> r7 = LiveEffectContext.a.a(this.k).a().o(com.bytedance.android.live.effect.api.d0.i).iterator();
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

    public final void A2(View r3, int r4) {
        if (this.h == false) goto L15;
        List<String> r0 = LiveEffectContext.h;
        View r1 = null;
        if (LiveEffectContext.a.a(this.k).a().B((Sticker) ListProtector.get(this.a, r4)) == false) goto L10;
        if (r3 == null) goto L8;
        r1 = r3.findViewById(2131375713);
    L8:
        if (r1 == null) goto L16;
        r1.setVisibility(0);
        return;
    L16:
        return;
    L10:
        if (r3 == null) goto L12;
        r1 = r3.findViewById(2131375713);
    L12:
        if (r1 == null) goto L18;
        r1.setVisibility(4);
        return;
    L18:
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r17, int r18) {
        Intrinsics.checkNotNullParameter(r17, "holder");
        if ((r17 instanceof AbsSmallItemViewHolder) == false) goto L98;
        if (z2() == false) goto L7;
        final int r2 = r18 - 1;
    L8:
        final AbsSmallItemViewHolder r1 = (AbsSmallItemViewHolder) r17;
        AnonymousClass1 r3 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r4 = AnonymousClass2.INSTANCE;
        if (this.b != r2) goto L19;
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131364341).setVisibility(0);
        if (this.h == false) goto L13;
        int r5 = 2131107408;
    L14:
        ((TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131390975)).setTextColor(((RecyclerView.ViewHolder) r1).itemView.getContext().getResources().getColor(r5));
        if (this.m == false) goto L24;
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
        if (LiveEffectContext.a.a(this.k).b().r().q((Sticker) ListProtector.get(this.a, r2)) == true) goto L40;
        if (r9 == true) goto L40;
        ((ImageView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131376377)).setVisibility(0);
        LiveSmallItemBeautyHelper.g(LiveEffectContext.a.a(this.k).b().g(), (Sticker) ListProtector.get(this.a, r2), true, this.m, 4);
    L41:
        if (r9 == true) goto L43;
    L68:
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).setVisibility(8);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).setVisibility(0);
        if (this.m == true) goto L71;
        View r12 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131391979);
        if (r12 == null) goto L81;
        r12.setVisibility(4);
    L81:
        A2(((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068), r2);
        r3.invoke(r1, ListProtector.get(this.a, r2));
        ((RecyclerView.ViewHolder) r1).itemView.setOnClickListener(new u(this, r1, r9, r4));
        if (LiveEffectContext.a.a(this.k).b().h().c() == false) goto L93;
        List r13 = ((Sticker) ListProtector.get(this.a, r2)).getTags();
        if (r13 == null) goto L93;
        if (r13.contains("outer_test") != true) goto L93;
        ConstraintLayout r14 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131366904);
        if (r14 == null) goto L90;
        r14.setVisibility(0);
    L90:
        View r15 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131375762);
        if (r15 == null) goto L96;
        r15.setVisibility(4);
    L96:
        r3.e(((RecyclerView.ViewHolder) r1).itemView, new LiveSmallItemBeautyAdapter$onBindBeautyItemViewHolder$6(this, r2, r1));
        return;
    L93:
        ConstraintLayout r16 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131366904);
        if (r16 == null) goto L96;
        r16.setVisibility(4);
        goto L96
    L71:
        if (LiveEffectContext.a.a(this.k).a().E((Sticker) ListProtector.get(this.a, r2)) == false) goto L75;
        View r19 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131391979);
        if (r19 == null) goto L81;
        r19.setVisibility(0);
        goto L81
    L75:
        View r21 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131391979);
        if (r21 == null) goto L81;
        r21.setVisibility(4);
        goto L81
    L43:
        if (this.d.get(r2, Boolean.FALSE).booleanValue() == false) goto L68;
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).setVisibility(0);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).setVisibility(8);
        r1.a = new LiveSmallSubItemBeautyAdapter(this.h, this.j, this.k, this.m);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131387524).setLayoutManager(new LinearLayoutManager(((RecyclerView.ViewHolder) r1).itemView.getContext(), 0, false));
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131387524).setAdapter(r1.a);
        int r22 = y2(r2);
        if (r22 < 0) goto L49;
        LiveSmallSubItemBeautyAdapter r110 = r1.a;
        if (r110 == null) goto L49;
        r110.d = r22;
    L49:
        LiveSmallSubItemBeautyAdapter r111 = r1.a;
        if (r111 == null) goto L55;
        List<Sticker> r112 = ((Sticker) ListProtector.get(this.a, r2)).getSubStickers();
        if (r112 != null) goto L54;
        r112 = new ArrayList();
    L54:
        r111.setData(r112);
    L55:
        LiveSmallSubItemBeautyAdapter r113 = r1.a;
        if (r113 == null) goto L58;
        s r114 = new s(this, r2);
        Intrinsics.checkNotNullParameter(r114, "listener");
        r113.e = r114;
    L58:
        ((TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).findViewById(2131387525)).setText(((Sticker) ListProtector.get(this.a, r2)).getName());
        ((ImageView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131371913).findViewById(2131387523)).setOnClickListener(new t(this, r2, r1));
        List r115 = ((Sticker) ListProtector.get(this.a, r2)).getSubStickers();
        if (r115 == null) goto L81;
        if (r22 > 0) goto L63;
        r22 = 0;
    L63:
        Sticker r23 = (Sticker) ListProtector.get(r115, r22);
        if (r23 == null) goto L81;
        a r116 = this.c;
        if (r116 == null) goto L81;
        r116.a(r23);
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
        this.d.put(r2, Boolean.FALSE);
        ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131364341).setVisibility(4);
        ((TextView) ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131373068).findViewById(2131390975)).setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        if (this.m == false) goto L24;
        View r24 = ((RecyclerView.ViewHolder) r1).itemView.findViewById(2131391979);
        if (r24 == null) goto L24;
        r24.setSelected(false);
        goto L24
    L7:
        r2 = r18;
        goto L8
    L98:
        if ((r17 instanceof b) == false) goto L108;
        b r25 = (b) r17;
        ((RecyclerView.ViewHolder) r25).itemView.findViewById(2131387878).setChecked(this.l);
        TextView r26 = (TextView) ((RecyclerView.ViewHolder) r25).itemView.findViewById(2131387943);
        if (this.l == false) goto L102;
        int r27 = 2131916440;
    L103:
        r26.setText(s1.B(r27));
        ((RecyclerView.ViewHolder) r25).itemView.findViewById(2131387878).setAccessibilityDelegate(new v(r25));
        ((RecyclerView.ViewHolder) r25).itemView.findViewById(2131387878).setOnCheckedChangeListener(new w(this, r25));
        if (LiveEffectSettings.LIVE_EFFECT_BEAUTY_FIX_TALKBACK_2025_07.getValue().booleanValue() == false) goto L109;
        ((RecyclerView.ViewHolder) r25).itemView.post(new x(r25));
        return;
    L109:
        return;
    L102:
        r27 = 2131916439;
        goto L103
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (r5 != 1) goto L10;
        LayoutInflater r0 = LayoutInflater.from(r4.getContext());
        if (this.h == false) goto L7;
        int r2 = 2131565914;
    L11:
        return new b(r0.inflate(r2, r4, false));
    L7:
        r2 = 2131565913;
        goto L11
    L10:
        return new LiveSmallItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(this.i, r4, false));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.isEmpty() == false) goto L5;
    L16:
        onBindViewHolder(r2, r3);
        return;
    L5:
        if ((r2 instanceof b) == true) goto L16;
        if (z2() == false) goto L10;
        r3 = r3 - 1;
    L10:
        if (r3 >= 0) goto L12;
        return;
    L12:
        if (r3 >= ((ArrayList) this.a).size()) goto L18;
        A2(r2.itemView.findViewById(2131373068), r3);
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r1, Sticker r2, String r3, float r4) {
        ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
    }

    public LiveSmallItemBeautyAdapter(boolean r2, int r3, int r4, LiveEffectContextFactoryDelegate$Type r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "type");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.m = false;
        this.a = new ArrayList();
        this.d = new SparseArray();
        this.e = new SparseArray();
        this.f = LazyKt.lazy(LiveSmallItemBeautyAdapter$handler$2.INSTANCE);
        if (this.l == true) goto L5;
        this.b = -1;
    L5:
        this.g = new r(this);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r5, Sticker r6, String r7, float r8, HashMap<String, String> r9) {
        if (Intrinsics.areEqual(r5, com.bytedance.android.live.effect.api.d0.i) == false) goto L55;
        Iterator r11 = ((ArrayList) this.a).iterator();
        int r12 = 0;
    L6:
        if (r11.hasNext() == false) goto L41;
        Sticker r13 = (Sticker) r11.next();
        String r0 = r13.getEffectId();
        if (r6 == null) goto L10;
        String r2 = r6.getEffectId();
    L11:
        boolean r1 = Intrinsics.areEqual(r0, r2);
        boolean r3 = true;
        if (r1 == true) goto L38;
        Effect r4 = r13.getEffect();
        if (r4 != null) goto L16;
    L37:
        r3 = false;
        goto L38
    L16:
        if (r4.getEffectType() != 1) goto L37;
        List r14 = r13.getSubStickers();
        if (r14 == null) goto L37;
        List r15 = r14;
        if ((r15 instanceof Collection) == true) goto L22;
    L24:
        Iterator r16 = r15.iterator();
    L26:
        if (r16.hasNext() == false) goto L34;
        String r17 = ((Sticker) r16.next()).getEffectId();
        if (r6 == null) goto L30;
        String r18 = r6.getEffectId();
    L32:
        if (Intrinsics.areEqual(r17, r18) == false) goto L26;
        boolean r19 = true;
    L35:
        if (r19 != true) goto L37;
    L30:
        r18 = null;
    L34:
        r19 = false;
        goto L35
    L22:
        if (r15.isEmpty() == false) goto L24;
    L38:
        if (r3 == true) goto L42;
        r12 = r12 + 1;
    L42:
        if (r12 >= 0) goto L44;
        return;
    L44:
        if (r12 < ((ArrayList) this.a).size()) goto L46;
        return;
    L46:
        if (z2() == false) goto L48;
        r12 = r12 + 1;
    L48:
        notifyItemChanged(r12, "tagValueChangeListener");
        return;
    L10:
        r2 = null;
        goto L11
    L41:
        r12 = -1;
        goto L42
    }
}
