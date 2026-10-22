package com.bytedance.android.livesdk.interactivity.comment.input;

import am2.x;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/ScreenChatTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "SeparatorHolder", "TabHolder", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScreenChatTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final /* synthetic */ int b = 0;
    public int a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/ScreenChatTabAdapter$SeparatorHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SeparatorHolder extends RecyclerView.ViewHolder {
        public final View a;

        public SeparatorHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131385208);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/input/ScreenChatTabAdapter$TabHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TabHolder extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final ImageView b;

        public TabHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131385206);
            this.b = (ImageView) r2.findViewById(2131385207);
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ScreenChatTabAdapter a;
        public final /* synthetic */ com.bytedance.android.live.profit.privilege.model.danmu.b b;
        public final /* synthetic */ RecyclerView.ViewHolder c;

        public b(ScreenChatTabAdapter r1, com.bytedance.android.live.profit.privilege.model.danmu.b r2, RecyclerView.ViewHolder r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            if (this.b.getStatus() == 0) goto L13;
            f2.c(this.b.getToast(), 0);
            ScreenChatTabAdapter r9 = this.a;
            com.bytedance.android.live.profit.privilege.model.danmu.b r2 = this.b;
            int r3 = ScreenChatTabAdapter.b;
            r9.getClass();
            IBaseUser r10 = jc1.k.n(IMiddlewareUserService.class).user().b();
            Pair[] r4 = new Pair[6];
            r4[0] = TuplesKt.to("user_id", r10.getIdString());
            py.d r11 = r10.getUserHonor();
            if (r11 == null) goto L7;
            int r13 = r11.getLevel();
        L8:
            r4[1] = TuplesKt.to("privilege_level", String.valueOf(r13));
            r4[2] = TuplesKt.to("screen_layout", "landscape");
            r4[3] = TuplesKt.to("click_results", "fail");
            r4[4] = TuplesKt.to("danmu_level", String.valueOf(r2.getStyle()));
            r4[5] = TuplesKt.to("results_reason", r2.getToast());
            Map<String, String> r14 = MapsKt.mutableMapOf(r4);
            IInteractivityInjectService r5 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r5 == null) goto L11;
            r5.buildVsRoomLog(null, r14);
        L11:
            j0.l().sendLog("livesdk_danmu_tab_click", r14, new Object[]{IRoom.class, x.class});
            return;
        L7:
            r13 = 0;
            goto L8
        L13:
            this.a.a = ((TabHolder) this.c).getAdapterPosition();
            this.a.getClass();
            throw null;
        }
    }

    static {
    }

    public final int getItemCount() {
        throw null;
    }

    public final int getItemViewType(int r2) {
        return ((com.bytedance.android.live.profit.privilege.model.danmu.b) ListProtector.get(null, r2)).getStyle();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        com.bytedance.android.live.profit.privilege.model.danmu.b r1 = (com.bytedance.android.live.profit.privilege.model.danmu.b) CollectionsKt.getOrNull(null, r7);
        if (r1 != null) goto L6;
        return;
    L6:
        if ((r6 instanceof TabHolder) == true) goto L8;
        return;
    L8:
        if (r7 == this.a) goto L10;
    L12:
        ((TabHolder) r6).a.setBackgroundResource(2131249919);
    L13:
        ImageUtil.loadImage(((TabHolder) r6).a, r1.getLandscapeImg(), 0);
        int r0 = r1.getStatus();
        if (r0 != 0) goto L16;
        ((TabHolder) r6).b.setVisibility(8);
    L23:
        r6.itemView.setOnClickListener(new b(this, r1, r6, r7));
        return;
    L16:
        if (r0 != 1) goto L18;
        ((TabHolder) r6).b.setVisibility(0);
        goto L23
    L18:
        if (r0 != 2) goto L23;
        TabHolder r2 = (TabHolder) r6;
        r2.b.setVisibility(8);
        r2.a.setImageAlpha(128);
        goto L23
    L10:
        if (((com.bytedance.android.live.profit.privilege.model.danmu.b) ListProtector.get(null, r7)).getStatus() != 0) goto L12;
        ((TabHolder) r6).a.setBackgroundResource(2131249917);
        goto L13
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 == 20) goto L6;
        return new TabHolder(LayoutInflater.from(r3.getContext()).inflate(2131567408, r3, false));
    L6:
        return new SeparatorHolder(LayoutInflater.from(r3.getContext()).inflate(2131567410, r3, false));
    }
}
