package com.bytedance.android.livesdk.interactivity.comment.input;

import am2.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.profit.privilege.model.danmu.DanmakuTabList;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.provider.v;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0003\u0004\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/DanmakuTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "CancelTabHolder", "a", "b", "TabHolder", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DanmakuTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<com.bytedance.android.live.profit.privilege.model.danmu.b> a;
    public int b;
    public int c;
    public int d;
    public final b e;
    public final boolean f;
    public final boolean g;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/DanmakuTabAdapter$CancelTabHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CancelTabHolder extends RecyclerView.ViewHolder {
        public final View a;

        public CancelTabHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131368516);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/DanmakuTabAdapter$TabHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TabHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final ImageView b;

        public TabHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131368517);
            this.b = (ImageView) r2.findViewById(2131368518);
        }
    }

    public static final class a {
    }

    public interface b {
        void a(com.bytedance.android.live.profit.privilege.model.danmu.b r1);
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DanmakuTabAdapter a;
        public final /* synthetic */ com.bytedance.android.live.profit.privilege.model.danmu.b b;
        public final /* synthetic */ RecyclerView.ViewHolder c;

        public c(DanmakuTabAdapter r1, com.bytedance.android.live.profit.privilege.model.danmu.b r2, RecyclerView.ViewHolder r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (this.b.getStatus() == 0) goto L5;
            f2.c(this.b.getToast(), 0);
            DanmakuTabAdapter.y2(this.a, this.b, "fail");
        L7:
            if (this.a.f == false) goto L9;
            String r4 = "portrait";
        L10:
            com.bytedance.android.livesdk.interactivity.api.monitor.b.b(true, r4, Integer.valueOf(this.b.getStyle()));
            return;
        L9:
            r4 = "landscape";
            goto L10
        L5:
            DanmakuTabAdapter r5 = this.a;
            r5.b = ((TabHolder) this.c).getAdapterPosition();
            this.a.e.a(this.b);
            DanmakuTabAdapter.y2(this.a, this.b, "success");
            goto L7
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ DanmakuTabAdapter a;
        public final /* synthetic */ com.bytedance.android.live.profit.privilege.model.danmu.b b;

        public d(DanmakuTabAdapter r1, com.bytedance.android.live.profit.privilege.model.danmu.b r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            if (this.a.f == false) goto L5;
            String r4 = "portrait";
        L6:
            com.bytedance.android.livesdk.interactivity.api.monitor.b.b(true, r4, -1);
            DanmakuTabAdapter r5 = this.a;
            r5.b = 0;
            r5.e.a(this.b);
            return;
        L5:
            r4 = "landscape";
            goto L6
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public final void A2(DanmakuTabList r6) {
        Intrinsics.checkNotNullParameter(r6, "tabList");
        ((ArrayList) this.a).clear();
        ((ArrayList) this.a).addAll(r6.getList());
        if (this.g == false) goto L12;
        if (this.f == true) goto L7;
        return;
    L7:
        if (((ArrayList) this.a).size() == 4) goto L9;
        return;
    L9:
        if (this.g == false) goto L23;
        this.c = (((s1.y() - (s1.f(12.0f) * 2)) - (s1.f(10.0f) * 3)) - s1.f(78.0f)) / 3;
        return;
    L23:
        return;
    L12:
        if (((com.bytedance.android.live.profit.privilege.model.danmu.b) ListProtector.get(r6.getList(), 0)).getStyle() != 21) goto L15;
        ListProtector.remove(this.a, 0);
    L15:
        if (((ArrayList) this.a).size() < 3) goto L19;
        this.c = ((s1.y() - (s1.f(12.0f) * 2)) - (s1.f(10.0f) * (((ArrayList) this.a).size() - 1))) / ((ArrayList) this.a).size();
        if (PadConfigUtils.a() == false) goto L19;
        this.c = UtilityKotlinExtentionsKt.i(78);
    L19:
        this.d = s1.f(36.0f);
    }

    public final int getItemViewType(int r2) {
        return ((com.bytedance.android.live.profit.privilege.model.danmu.b) ListProtector.get(this.a, r2)).getStyle();
    }

    public final void z2(com.bytedance.android.live.profit.privilege.model.danmu.b r6) {
        if (r6 == null) goto L15;
        Iterator<T> r0 = this.a.iterator();
        int r1 = 0;
    L5:
        if (r0.hasNext() == false) goto L20;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        if (r6.getStyle() != ((com.bytedance.android.live.profit.privilege.model.danmu.b) r2).getStyle()) goto L14;
        if (r6.getStatus() != 0) goto L14;
        this.b = r1;
    L14:
        r1 = r3;
        goto L5
    L20:
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        com.bytedance.android.live.profit.privilege.model.danmu.b r0 = (com.bytedance.android.live.profit.privilege.model.danmu.b) CollectionsKt.getOrNull(this.a, r8);
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 2131249917;
        int r3 = 2131249919;
        if ((r7 instanceof TabHolder) == false) goto L44;
        if (this.c <= 0) goto L10;
        ViewGroup.LayoutParams r1 = ((TabHolder) r7).a.getLayoutParams();
        r1.width = this.c;
    L10:
        TabHolder r4 = (TabHolder) r7;
        ViewGroup.LayoutParams r5 = r4.a.getLayoutParams();
        r5.height = this.d;
        if (r8 == this.b) goto L13;
    L19:
        ImageView r9 = r4.a;
        if (this.g == true) goto L23;
        r3 = 2131249918;
    L23:
        r9.setBackgroundResource(r3);
    L25:
        if (this.f == false) goto L31;
        ImageView r10 = r4.a;
        if (this.g == false) goto L29;
        py.k r6 = r0.getImgV2();
    L30:
        ImageUtil.loadImage(r10, r6, 0);
    L32:
        int r11 = r0.getStatus();
        if (r11 != 0) goto L35;
        r4.b.setVisibility(8);
    L42:
        r7.itemView.setOnClickListener(new c(this, r0, r7));
        return;
    L35:
        if (r11 != 1) goto L37;
        r4.b.setVisibility(0);
        goto L42
    L37:
        if (r11 != 2) goto L42;
        r4.b.setVisibility(8);
        r4.a.setImageAlpha(128);
        goto L42
    L29:
        r6 = r0.getImg();
        goto L30
    L31:
        ImageUtil.loadImage(r4.a, r0.getLandscapeImgV2(), 0);
        goto L32
    L13:
        if (((com.bytedance.android.live.profit.privilege.model.danmu.b) ListProtector.get(this.a, r8)).getStatus() != 0) goto L19;
        ImageView r13 = r4.a;
        if (this.g == true) goto L18;
        r2 = 2131249916;
    L18:
        r13.setBackgroundResource(r2);
        goto L25
    L44:
        if ((r7 instanceof CancelTabHolder) == true) goto L46;
        return;
    L46:
        if (r8 != this.b) goto L48;
        ((CancelTabHolder) r7).a.setBackgroundResource(2131249917);
    L49:
        ((CancelTabHolder) r7).a.setOnClickListener(new d(this, r0));
        return;
    L48:
        ((CancelTabHolder) r7).a.setBackgroundResource(2131249919);
        goto L49
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 == 21) goto L10;
        if (this.f == false) goto L7;
        View r5 = LayoutInflater.from(r3.getContext()).inflate(2131566182, r3, false);
    L15:
        return new TabHolder(r5);
    L7:
        r5 = LayoutInflater.from(r3.getContext()).inflate(2131566183, r3, false);
        goto L15
    L10:
        if (this.f == false) goto L12;
        View r6 = LayoutInflater.from(r3.getContext()).inflate(2131566180, r3, false);
    L14:
        return new CancelTabHolder(r6);
    L12:
        r6 = LayoutInflater.from(r3.getContext()).inflate(2131566181, r3, false);
        goto L14
    }

    public DanmakuTabAdapter(v r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "onItemSelectedListener");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.a = new ArrayList();
        this.d = s1.f(40.0f);
    }

    public static final void y2(DanmakuTabAdapter r4, com.bytedance.android.live.profit.privilege.model.danmu.b r5, String r6) {
        r4.getClass();
        IBaseUser r0 = jc1.k.n(IMiddlewareUserService.class).user().b();
        Pair[] r1 = new Pair[6];
        r1[0] = TuplesKt.to("user_id", r0.getIdString());
        py.d r2 = r0.getUserHonor();
        if (r2 == null) goto L5;
        int r3 = r2.getLevel();
    L6:
        r1[1] = TuplesKt.to("privilege_level", String.valueOf(r3));
        if (r4.f == false) goto L9;
        String r7 = "portrait";
    L10:
        r1[2] = TuplesKt.to("screen_layout", r7);
        r1[3] = TuplesKt.to("click_results", r6);
        r1[4] = TuplesKt.to("danmu_level", String.valueOf(r5.getStyle()));
        r1[5] = TuplesKt.to("results_reason", r5.getToast());
        Map<String, String> r8 = MapsKt.mutableMapOf(r1);
        IInteractivityInjectService r9 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r9 == null) goto L13;
        r9.buildVsRoomLog(null, r8);
    L13:
        j0.l().sendLog("livesdk_danmu_tab_click", r8, new Object[]{IRoom.class, x.class});
        return;
    L9:
        r7 = "landscape";
        goto L10
    L5:
        r3 = 0;
        goto L6
    }
}
