package com.bytedance.android.live.effect.avadjust;

import android.os.Handler;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.log.ALogger;
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
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0004\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$c;", "AbsSmallItemViewHolder", "LiveSmallItemViewHolder", "a", "b", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveColorAdjustAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ILiveEffectComposerManager.c {
    public final List<Sticker> a;
    public final List<String> b;
    public int c;
    public a d;
    public final SparseArray<Boolean> e;
    public final Lazy f;
    public final c g;
    public final int h;
    public boolean i;
    public final String j;
    public final LiveEffectContextFactoryDelegate$Type k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustAdapter$AbsSmallItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static abstract class AbsSmallItemViewHolder extends RecyclerView.ViewHolder {
        public AbsSmallItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustAdapter$LiveSmallItemViewHolder;", "Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustAdapter$AbsSmallItemViewHolder;", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    public static final class c implements LiveSmallItemBeautyHelper.b {
        public final /* synthetic */ LiveColorAdjustAdapter a;

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

        public c(LiveColorAdjustAdapter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
        public final void a(Sticker r2) {
            Intrinsics.checkNotNullParameter(r2, "sticker");
            ((Handler) this.a.f.getValue()).post(new a(this));
        }
    }

    public final int getItemViewType(int r1) {
        if (r1 != 0) goto L4;
        return 1;
    L4:
        return 0;
    }

    public final int getItemCount() {
        if (((ArrayList) this.a).size() > 0) goto L7;
        return 0;
    L7:
        return ((ArrayList) this.a).size() + 1;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "holder");
        if ((r12 instanceof AbsSmallItemViewHolder) == false) goto L55;
        final int r14 = r13 - 1;
        final AbsSmallItemViewHolder r15 = (AbsSmallItemViewHolder) r12;
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        AnonymousClass2 r1 = AnonymousClass2.INSTANCE;
        if (this.c != r14) goto L7;
        ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131364341).setVisibility(0);
        ((TextView) ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131390975)).setTextColor(((RecyclerView.ViewHolder) r15).itemView.getContext().getResources().getColor(2131107408));
    L8:
        Sticker r2 = (Sticker) ListProtector.get(this.a, r14);
        List<String> r3 = LiveEffectContext.h;
        ILiveEffectComposerManager r4 = LiveEffectContext.a.a(this.k).a();
        String r7 = r2.getEffectId();
        String r8 = "";
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        Sticker.ComposerConfig r9 = r2.getSmallItemConfig();
        if (r9 == null) goto L17;
        String r11 = r9.getTag();
        if (r11 == null) goto L17;
        r8 = r11;
    L17:
        Float r5 = r4.G(r7, r8);
        if (r5 != null) goto L25;
        Sticker.ComposerConfig r6 = r2.getSmallItemConfig();
        if (r6 == null) goto L22;
        Integer r16 = Integer.valueOf(r6.getDefaultValue());
    L23:
        Intrinsics.checkNotNull(r16);
        r5 = Float.valueOf(com.bytedance.android.live.effect.q.d(r2, r16.intValue()));
        ALogger.i("LiveColorAdjustAdapter", "onBindBeautyItemViewHolder uivalue = " + r5);
        goto L25
    L22:
        r16 = null;
    L25:
        if ((!Intrinsics.areEqual(r5, 0.0f)) == false) goto L27;
        ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131375713).setVisibility(0);
    L28:
        UrlModel r17 = r2.getIcon();
        if (r17 == null) goto L31;
        ImageUtil.loadRoundImage((ImageView) ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131376045), new ImageModel(r17.getUri(), r17.getUrlList()));
    L31:
        ((TextView) ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131390975)).setText(r2.getName());
        HashMap r18 = new HashMap();
        r18.put("event_page", this.j);
        r18.put("tab_name", "adjust");
        String r19 = r2.getName();
        if (r19 == null) goto L34;
        String r21 = (String) r18.put("effect_name", r19);
    L34:
        r18.put("live_type", "video_live");
        r18.put("effect_id", r2.getEffectId());
        r18.put("effect_order", String.valueOf(r14));
        com.bytedance.android.live.effect.utils.c.a("livesdk_beauty_panel_item_show", r18, this.j);
        if (LiveEffectContext.a.a(this.k).b().r().q(r2) == false) goto L37;
        ((ImageView) ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131376377)).setVisibility(8);
    L38:
        r0.invoke(r15, r2);
        ((RecyclerView.ViewHolder) r15).itemView.setOnClickListener(new com.bytedance.android.live.effect.avadjust.b(this, r15, r1));
        if (LiveEffectContext.a.a(this.k).b().h().c() == false) goto L50;
        List r22 = ((Sticker) ListProtector.get(this.a, r14)).getTags();
        if (r22 == null) goto L50;
        if (r22.contains("outer_test") != true) goto L50;
        ConstraintLayout r23 = ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131366904);
        if (r23 == null) goto L47;
        r23.setVisibility(0);
    L47:
        View r24 = ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131375762);
        if (r24 == null) goto L53;
        r24.setVisibility(4);
    L53:
        r3.e(((RecyclerView.ViewHolder) r15).itemView, new LiveColorAdjustAdapter$onBindBeautyItemViewHolder$3(this, r14, r15));
        return;
    L50:
        ConstraintLayout r25 = ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131366904);
        if (r25 == null) goto L53;
        r25.setVisibility(4);
        goto L53
    L37:
        ((ImageView) ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131376377)).setVisibility(0);
        l.c(LiveEffectContext.a.a(this.k).b().n(), r2, true);
        goto L38
    L27:
        ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131375713).setVisibility(4);
        goto L28
    L7:
        this.e.put(r14, Boolean.FALSE);
        ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131364341).setVisibility(4);
        ((TextView) ((RecyclerView.ViewHolder) r15).itemView.findViewById(2131390975)).setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        goto L8
    L55:
        if ((r12 instanceof b) == false) goto L63;
        b r110 = (b) r12;
        ((RecyclerView.ViewHolder) r110).itemView.findViewById(2131387878).setChecked(this.i);
        TextView r111 = (TextView) ((RecyclerView.ViewHolder) r110).itemView.findViewById(2131387943);
        if (this.i == false) goto L59;
        int r26 = 2131916440;
    L60:
        r111.setText(s1.B(r26));
        ((RecyclerView.ViewHolder) r110).itemView.findViewById(2131387878).setAccessibilityDelegate(new com.bytedance.android.live.effect.avadjust.c(r110));
        ((RecyclerView.ViewHolder) r110).itemView.findViewById(2131387878).setOnCheckedChangeListener(new d(this, r110));
        return;
    L59:
        r26 = 2131916439;
        goto L60
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        if (r5 != 1) goto L6;
        return new b(LayoutInflater.from(r4.getContext()).inflate(2131565914, r4, false));
    L6:
        return new LiveSmallItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(this.h, r4, false));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List<Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.isEmpty() == false) goto L5;
    L21:
        onBindViewHolder(r2, r3);
        return;
    L5:
        if ((r2 instanceof b) == true) goto L21;
        int r5 = r3 - 1;
        if (r5 >= 0) goto L10;
        return;
    L10:
        if (r5 >= ((ArrayList) this.a).size()) goto L23;
        List<String> r6 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.k).a().B((Sticker) ListProtector.get(this.a, r5)) == false) goto L17;
        View r7 = r2.itemView.findViewById(2131375713);
        if (r7 == null) goto L24;
        r7.setVisibility(0);
        return;
    L24:
        return;
    L17:
        View r8 = r2.itemView.findViewById(2131375713);
        if (r8 == null) goto L26;
        r8.setVisibility(4);
        return;
    L26:
        return;
    }

    public LiveColorAdjustAdapter(int r2, boolean r3, String r4, LiveEffectContextFactoryDelegate$Type r5) {
        Intrinsics.checkNotNullParameter(r4, "eventPage");
        Intrinsics.checkNotNullParameter(r5, "type");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.e = new SparseArray();
        this.f = LazyKt.lazy(LiveColorAdjustAdapter$handler$2.INSTANCE);
        if (this.i == true) goto L5;
        this.c = -1;
    L5:
        this.g = new c(this);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r1, Sticker r2, String r3, float r4) {
        ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r1, Sticker r2, String r3, float r4, HashMap<String, String> r5) {
        if (Intrinsics.areEqual(r1, "live_adjustment") == false) goto L15;
        List<String> r6 = this.b;
        if (r2 == null) goto L7;
        String r7 = r2.getEffectId();
    L8:
        int r8 = CollectionsKt.indexOf(r6, r7);
        if (r8 >= 0) goto L11;
    L13:
        ALogger.i("LiveColorAdjustAdapter", "onChange: index = " + r8);
        return;
    L11:
        if (r8 >= ((ArrayList) this.b).size()) goto L13;
        notifyItemChanged(r8 + 1);
        goto L13
    L7:
        r7 = null;
        goto L8
    }
}
