package com.bytedance.android.live.effect.beauty.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.beauty.makeups.LiveMakeupsBeautyAdapter;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0010R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/filter/LiveComposerFilterAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/effect/beauty/filter/LiveComposerFilterAdapter$ComposerFilterViewHolder;", "Lcom/bytedance/android/live/effect/api/ILiveEffectComposerManager$c;", "Landroid/content/Context;", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "g", "Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "getType", "()Lcom/bytedance/android/live/effect/api/LiveEffectContextFactoryDelegate$Type;", "type", "ComposerFilterViewHolder", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveComposerFilterAdapter extends RecyclerView.Adapter<ComposerFilterViewHolder> implements ILiveEffectComposerManager.c {
    public final List<Sticker> a;
    public final List<String> b;
    public boolean c;
    public int d;
    public final com.bytedance.android.live.effect.beauty.filter.a e;
    public final Context f;
    public final LiveEffectContextFactoryDelegate$Type g;
    public final int h;
    public final LiveMakeupsBeautyAdapter.a i;
    public final String j;
    public final boolean k;
    public final boolean l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/filter/LiveComposerFilterAdapter$ComposerFilterViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ComposerFilterViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final SimpleDraweeView b;
        public final TextView c;
        public final View d;
        public final View e;
        public final View f;
        public final View g;

        public ComposerFilterViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131364341);
            this.b = r2.findViewById(2131376045);
            this.c = (TextView) r2.findViewById(2131390975);
            this.d = r2.findViewById(2131376377);
            this.e = r2.findViewById(2131375762);
            this.f = r2.findViewById(2131366904);
            this.g = r2.findViewById(2131391979);
        }
    }

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ LiveComposerFilterAdapter a;
        public final /* synthetic */ Sticker b;
        public final /* synthetic */ int c;

        public a(LiveComposerFilterAdapter r1, Sticker r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            LiveComposerFilterAdapter r3 = this.a;
            if (r3.c == false) goto L6;
            r3.i.a(this.b);
            LiveComposerFilterAdapter r4 = this.a;
            r4.notifyItemChanged(r4.d);
            this.a.notifyItemChanged(this.c);
            LiveComposerFilterAdapter r5 = this.a;
            r5.d = this.c;
            return;
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public final Context getContext() {
        return this.f;
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.g;
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        y2((ComposerFilterViewHolder) r1, r2);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ComposerFilterViewHolder(LayoutInflater.from(this.f).inflate(this.h, r4, false));
    }

    public final void y2(final ComposerFilterViewHolder r11, int r12) {
        Intrinsics.checkNotNullParameter(r11, "holder");
        Sticker r0 = (Sticker) ListProtector.get(this.a, r12);
        List<String> r1 = LiveEffectContext.h;
        ILiveEffectComposerManager r2 = LiveEffectContext.a.a(this.g).a();
        String r3 = d0.a;
        Sticker r4 = (Sticker) CollectionsKt.firstOrNull(r2.o(r3));
        if (r4 == null) goto L6;
        String r5 = r4.getResourceId();
        if (r5 == null) goto L6;
    L7:
        final boolean r6 = Intrinsics.areEqual(r5, r0.getResourceId());
        if (r6 == false) goto L19;
        r11.a.setVisibility(0);
        if (this.l == false) goto L12;
        int r7 = 2131107408;
    L13:
        r11.c.setTextColor(s1.h(r7));
        if (this.k == false) goto L18;
        View r8 = r11.g;
        if (r8 == null) goto L18;
        r8.setSelected(true);
    L18:
        this.d = r12;
    L25:
        if (r0.getEffect() != null) goto L31;
        r11.d.setVisibility(4);
        r11.c.setText(s1.B(2131916415));
        r11.b.setImageResource(2131250494);
        r11.e.setVisibility(4);
        r11.f.setVisibility(4);
        if (this.k == false) goto L68;
        View r9 = r11.g;
        if (r9 == null) goto L68;
        r9.setVisibility(4);
    L68:
        ((RecyclerView.ViewHolder) r11).itemView.setOnClickListener(new a(this, r0, r12));
        r3.e(((RecyclerView.ViewHolder) r11).itemView, new AnonymousClass3(r6, r11));
        return;
    L31:
        UrlModel r13 = r0.getIcon();
        if (r13 != null) goto L34;
    L37:
        r11.c.setText(r0.getName());
        if (LiveEffectContext.a.a(this.g).b().r().q(r0) == false) goto L40;
        r11.d.setVisibility(4);
    L47:
        List<String> r14 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.g).b().h().c() == false) goto L54;
        List r15 = r0.getTags();
        if (r15 == null) goto L54;
        if (r15.contains("outer_test") != true) goto L54;
        r11.f.setVisibility(0);
    L56:
        if (this.k == true) goto L58;
        View r16 = r11.g;
        if (r16 == null) goto L68;
        r16.setVisibility(4);
        goto L68
    L58:
        if (LiveEffectContext.a.a(this.g).a().E(r0) == false) goto L62;
        View r17 = r11.g;
        if (r17 == null) goto L68;
        r17.setVisibility(0);
        goto L68
    L62:
        View r18 = r11.g;
        if (r18 == null) goto L68;
        r18.setVisibility(4);
    L54:
        r11.f.setVisibility(4);
        goto L56
    L40:
        r11.d.setVisibility(0);
        LiveComposerFilterHelper r19 = LiveEffectContext.a.a(this.g).b().m();
        String r21 = this.j;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r0, "sticker");
        Intrinsics.checkNotNullParameter(r21, "page");
        if (LiveEffectContext.a.a(r19.d).b().r().q(r0) == false) goto L46;
        Iterator r22 = ((ArrayList) r19.c).iterator();
    L44:
        if (r22.hasNext() == false) goto L47;
        ((com.bytedance.android.live.effect.beauty.makeups.a.b) r22.next()).a(r0);
        goto L44
    L46:
        LiveEffectContext.a.a(r19.d).b().r().g(r3, r0, new i(r19));
        goto L47
    L34:
        if (this.k == false) goto L36;
        ImageUtil.loadRoundImageWithRadius(r11.b, new ImageModel(r13.getUri(), r13.getUrlList()), s1.f(8.0f));
        goto L37
    L36:
        ImageUtil.loadRoundImage(r11.b, new ImageModel(r13.getUri(), r13.getUrlList()));
        goto L37
    L12:
        r7 = 2131107407;
        goto L13
    L19:
        r11.a.setVisibility(4);
        r11.c.setTextColor(s1.h(2131107401));
        if (this.k == false) goto L25;
        View r23 = r11.g;
        if (r23 == null) goto L25;
        r23.setSelected(false);
    L6:
        r5 = "";
        goto L7
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        ComposerFilterViewHolder r5 = (ComposerFilterViewHolder) r2;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r4, "payloads");
        if (r4.isEmpty() == false) goto L5;
        y2(r5, r3);
        return;
    L5:
        if (r3 >= 0) goto L7;
        return;
    L7:
        if (r3 >= ((ArrayList) this.a).size()) goto L23;
        List<String> r6 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.g).a().E((Sticker) ListProtector.get(this.a, r3)) == false) goto L14;
        View r7 = r5.g;
        if (r7 == null) goto L20;
        r7.setVisibility(0);
        return;
    L20:
        return;
    L14:
        View r8 = r5.g;
        if (r8 == null) goto L22;
        r8.setVisibility(4);
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.b
    public final void F(String r1, Sticker r2, String r3, float r4) {
        ILiveEffectComposerManager.c.a.a(this, r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.c
    public final void u2(String r1, Sticker r2, String r3, float r4, HashMap<String, String> r5) {
        if (Intrinsics.areEqual(r1, d0.a) == false) goto L14;
        List<String> r6 = this.b;
        if (r2 == null) goto L7;
        String r7 = r2.getEffectId();
    L8:
        int r8 = CollectionsKt.indexOf(r6, r7);
        if (r8 >= 0) goto L11;
        return;
    L11:
        if (r8 >= ((ArrayList) this.b).size()) goto L16;
        notifyItemChanged(r8, "tagValueChangeListener");
        return;
    L16:
        return;
    L7:
        r7 = null;
        goto L8
    }

    public LiveComposerFilterAdapter(Context r2, LiveEffectContextFactoryDelegate$Type r3, int r4, LiveComposerFilterFragment$filterAdapter$2.a r5, String r6, boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r5, "selectItemChangeListener");
        Intrinsics.checkNotNullParameter(r6, "page");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = r6;
        this.k = r7;
        this.l = r8;
        if (r4 != (-1)) goto L8;
        if (r8 == false) goto L6;
        int r9 = 2131565902;
    L7:
        this.h = r9;
        goto L8
    L6:
        r9 = 2131565901;
    L8:
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = true;
        this.e = new com.bytedance.android.live.effect.beauty.filter.a(this);
    }
}
