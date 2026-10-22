package com.bytedance.android.live.effect.beauty.makeups;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/makeups/LiveMakeupsBeautyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/makeups/LiveMakeupsBeautyAdapter$LiveMakeupsViewHolder;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$c;", "LiveMakeupsViewHolder", "a", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMakeupsBeautyAdapter extends RecyclerView.Adapter<LiveMakeupsViewHolder> implements ILiveEffectComposerManager.c {
    public final List<Sticker> a;
    public final List<String> b;
    public int c;
    public a d;
    public final Handler e;
    public final b f;
    public final int g;
    public final LiveEffectContextFactoryDelegate$Type h;
    public final boolean i;
    public final boolean j;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/makeups/LiveMakeupsBeautyAdapter$LiveMakeupsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class LiveMakeupsViewHolder extends RecyclerView.ViewHolder {
        public LiveMakeupsViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
        }
    }

    public interface a {
        void a(Sticker r1);
    }

    public static final class b implements com.bytedance.android.live.effect.beauty.makeups.a.b {
        public final /* synthetic */ LiveMakeupsBeautyAdapter a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
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

        @Override // com.bytedance.android.live.effect.beauty.makeups.a.b
        public final void onError() {
        }

        public b(LiveMakeupsBeautyAdapter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.effect.beauty.makeups.a.b
        public final void a(Sticker r2) {
            Intrinsics.checkNotNullParameter(r2, "sticker");
            this.a.e.post(new a(this));
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ LiveMakeupsBeautyAdapter a;
        public final /* synthetic */ LiveMakeupsViewHolder b;
        public final /* synthetic */ int c;

        public c(LiveMakeupsBeautyAdapter r1, LiveMakeupsViewHolder r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveMakeupsBeautyAdapter r3 = this.a;
            int r0 = r3.c;
            if (r0 >= 0) goto L5;
        L7:
            this.a.c = this.b.getAdapterPosition();
            LiveMakeupsBeautyAdapter r4 = this.a;
            int r1 = r4.c;
            if (r1 >= 0) goto L10;
            return;
        L10:
            if (r1 <= ((ArrayList) r4.a).size()) goto L13;
            return;
        L13:
            if (this.c != 0) goto L17;
            a r5 = this.a.d;
            if (r5 == null) goto L23;
            r5.a(null);
        L23:
            LiveMakeupsBeautyAdapter r6 = this.a;
            r6.notifyItemChanged(r6.c);
            return;
        L17:
            LiveMakeupsBeautyAdapter r7 = this.a;
            Sticker r8 = (Sticker) ListProtector.get(r7.a, r7.c - 1);
            List<String> r9 = LiveEffectContext.h;
            if (LiveEffectContext.a.a(this.a.h).b().r().q(r8) == true) goto L20;
            return;
        L20:
            a r11 = this.a.d;
            if (r11 == null) goto L23;
            r11.a(r8);
            goto L23
        L5:
            if (r0 >= r3.getItemCount()) goto L7;
            LiveMakeupsBeautyAdapter r12 = this.a;
            r12.notifyItemChanged(r12.c);
            goto L7
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size() + 1;
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((LiveMakeupsViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        return new LiveMakeupsViewHolder(LayoutInflater.from(r4.getContext()).inflate(this.g, r4, false));
    }

    public final void y2(final LiveMakeupsViewHolder r14, final int r15) {
        Intrinsics.checkNotNullParameter(r14, "viewHolder");
        if (this.c != r15) goto L13;
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131364341).setVisibility(0);
        if (this.j == false) goto L7;
        int r0 = 2131107408;
    L8:
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131390975)).setTextColor(((RecyclerView.ViewHolder) r14).itemView.getContext().getResources().getColor(r0));
        if (this.i == false) goto L19;
        View r1 = ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131391979);
        if (r1 == null) goto L19;
        r1.setSelected(true);
    L19:
        if (r15 != 0) goto L25;
        ((ImageView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131376377)).setVisibility(8);
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131390975)).setText(s1.B(2131916415));
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131376045).setImageResource(2131250494);
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131375762).setVisibility(8);
        if (this.i == false) goto L73;
        View r2 = ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131391979);
        if (r2 == null) goto L73;
        r2.setVisibility(4);
    L73:
        ((RecyclerView.ViewHolder) r14).itemView.setOnClickListener(new c(this, r14, r15));
        r3.e(((RecyclerView.ViewHolder) r14).itemView, new AnonymousClass4(this, r15, r14));
        return;
    L25:
        Sticker r9 = (Sticker) ListProtector.get(this.a, r15 - 1);
        UrlModel r11 = r9.getIcon();
        if (r11 != null) goto L28;
    L31:
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131390975)).setText(r9.getName());
        List<String> r3 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.h).b().r().q(r9) == false) goto L34;
        ((ImageView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131376377)).setVisibility(8);
    L35:
        Effect r4 = r9.getEffect();
        if (r4 == null) goto L49;
        ((d) LiveEffectContext.a.a(this.h).b().f()).getClass();
        Intrinsics.checkNotNullParameter(r4, NewBroadcastMonitor.STAGE.EFFECT);
        List r5 = r4.getTags();
        List r6 = r5;
        if (r6 != null) goto L40;
    L43:
        boolean r7 = true;
    L44:
        if (r7 == false) goto L46;
    L47:
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131375762).setVisibility(8);
        goto L49
    L46:
        if (r5.contains("new") == true) goto L49;
    L40:
        if (r6.isEmpty() == true) goto L43;
        r7 = false;
    L49:
        if (LiveEffectContext.a.a(this.h).b().h().c() == false) goto L57;
        List r8 = r9.getTags();
        if (r8 == null) goto L57;
        if (r8.contains("outer_test") != true) goto L57;
        ConstraintLayout r12 = ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131366904);
        if (r12 == null) goto L61;
        r12.setVisibility(0);
    L61:
        if (this.i == true) goto L63;
        View r13 = ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131391979);
        if (r13 == null) goto L73;
        r13.setVisibility(4);
        goto L73
    L63:
        if (LiveEffectContext.a.a(this.h).a().E(r9) == false) goto L67;
        View r16 = ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131391979);
        if (r16 == null) goto L73;
        r16.setVisibility(0);
        goto L73
    L67:
        View r17 = ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131391979);
        if (r17 == null) goto L73;
        r17.setVisibility(4);
    L57:
        ConstraintLayout r18 = ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131366904);
        if (r18 == null) goto L61;
        r18.setVisibility(4);
        goto L61
    L34:
        ((ImageView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131376377)).setVisibility(0);
        ((d) LiveEffectContext.a.a(this.h).b().f()).d(r9);
        goto L35
    L28:
        if (this.i == false) goto L30;
        ImageUtil.loadRoundImageWithRadius((ImageView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131376045), new ImageModel(r11.getUri(), r11.getUrlList()), s1.f(8.0f));
        goto L31
    L30:
        ImageUtil.loadRoundImage((ImageView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131376045), new ImageModel(r11.getUri(), r11.getUrlList()));
        goto L31
    L7:
        r0 = 2131107407;
        goto L8
    L13:
        ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131364341).setVisibility(4);
        ((TextView) ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131390975)).setTextColor(ColorProtector.parseColor("#B3FFFFFF"));
        if (this.i == false) goto L19;
        View r19 = ((RecyclerView.ViewHolder) r14).itemView.findViewById(2131391979);
        if (r19 == null) goto L19;
        r19.setSelected(false);
        goto L19
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        LiveMakeupsViewHolder r5 = (LiveMakeupsViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.isEmpty() == false) goto L5;
        y2(r5, r3);
        return;
    L5:
        if (r3 > 0) goto L7;
        return;
    L7:
        if (r3 > ((ArrayList) this.a).size()) goto L23;
        List<String> r6 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.h).a().E((Sticker) ListProtector.get(this.a, r3 - 1)) == false) goto L14;
        View r7 = ((RecyclerView.ViewHolder) r5).itemView.findViewById(2131391979);
        if (r7 == null) goto L20;
        r7.setVisibility(0);
        return;
    L20:
        return;
    L14:
        View r8 = ((RecyclerView.ViewHolder) r5).itemView.findViewById(2131391979);
        if (r8 == null) goto L22;
        r8.setVisibility(4);
        return;
    L22:
        return;
    }

    public LiveMakeupsBeautyAdapter(int r2, LiveEffectContextFactoryDelegate$Type r3, boolean r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "type");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.e = new Handler(Looper.getMainLooper());
        this.f = new b(this);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r1, Sticker r2, String r3, float r4) {
        ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r1, Sticker r2, String r3, float r4, HashMap<String, String> r5) {
        if (Intrinsics.areEqual(r1, d0.k) == false) goto L14;
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
}
