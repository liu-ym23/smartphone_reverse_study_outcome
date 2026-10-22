package com.bytedance.android.livesdk.feed.drawerfeed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.paging.adapter.PagingAdapter;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.feed.LiveDrawerCategoryAdapter;
import com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter;
import com.bytedance.android.livesdk.feed.drawerfeed.utils.FeedItemDiffChecker;
import com.bytedance.android.livesdk.feed.drawerfeed.viewholder.VSDrawerFeedLiveViewHolder;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.BaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Map;
import ju2.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import qv1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class DrawerFeedLiveAdapter extends BaseFeedAdapter {
    public final h p;
    public final String q;
    public final Function0<Unit> r;

    public final int getEmptyResId() {
        String r0 = this.q;
        if (r0 != null) goto L5;
        return 2131565973;
    L5:
        if (r0 != null) goto L8;
        return 2131565973;
    L8:
        if (r0.equals("vs_drawer") == false) goto L11;
        return 2131566010;
    L11:
        return 2131565973;
    }

    @Override // com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter
    public final int E2(int r4) {
        RoomContext r0 = RoomContext.getShared();
        if (r4 != 15) goto L5;
    L50:
        if (r0 == null) goto L55;
        if (r0.isVSSpecialDrawer() == false) goto L55;
        return 2131565984;
    L55:
        if (this.p.Ay() == false) goto L58;
        return 2131565985;
    L58:
        return 2131566258;
    L5:
        if (r4 == 1) goto L50;
        if (r4 != (-1)) goto L12;
        return 2131565981;
    L12:
        if (r4 != 17) goto L14;
        return 2131565989;
    L14:
        if (r4 != 16) goto L17;
        return 2131565989;
    L17:
        if (r4 != 3) goto L19;
        return 2131566257;
    L19:
        if (r4 != 6) goto L21;
        return 2131566007;
    L21:
        if (r4 != 19) goto L23;
        return 2131565160;
    L23:
        if (r4 != 24) goto L25;
        return 2131565980;
    L25:
        if (r4 != 27) goto L27;
        return 2131565984;
    L27:
        if (r4 == 10000001) goto L37;
        switch(r4) {
            case 1001: goto L60;
            case 1002: goto L35;
            case 1003: goto L33;
            case 1004: goto L31;
            default: goto L30;
        };
    L31:
        return 2131566266;
    L33:
        return 2131567663;
    L35:
        return 2131567662;
    L60:
        return 2131566007;
    L30:
        return invalidateType();
    L37:
        return 2131565968;
    }

    public final RecyclerView.ViewHolder createCustomErrorViewHolder(ViewGroup r4) {
        View r5 = LayoutInflater.from(r4.getContext()).inflate(2131565974, r4, false);
        r5.setBackgroundColor(0);
        return new LiveDrawerCategoryAdapter.ErrorViewHolder(r5, getViewModel());
    }

    @Override // com.bytedance.android.livesdk.feed.adapter.BaseFeedAdapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r18) {
        super.onViewAttachedToWindow(r18);
        if ((r18 instanceof VSDrawerFeedLiveViewHolder) == false) goto L64;
        VSDrawerFeedLiveViewHolder r1 = (VSDrawerFeedLiveViewHolder) r18;
        if (r1.i == null) goto L49;
        HashMap r2 = new HashMap();
        r2.put("drawer_page", "homepage_hot");
        r2.put("enter_from_merge", "drawer_hot");
        r2.put("enter_method", "drawer_cover");
        r2.put("order", String.valueOf(r1.g));
        Episode r13 = r1.i;
        if (r13 == null) goto L39;
        int r14 = f.M;
        Intrinsics.checkNotNullParameter(r13, "episode");
        f r15 = new f();
        String r16 = r13.itemId;
        if (r16 != null) goto L12;
        r16 = "";
    L12:
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r15.c = r16;
        String r3 = String.valueOf(r13.roomId);
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r15.d = r3;
        String r4 = String.valueOf(r13.getIdExt());
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r15.e = r4;
        String r5 = EpisodeExtKt.getOwnerIdString(r13);
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r15.f = r5;
        String r6 = r13.seasonId;
        if (r6 != null) goto L18;
        r6 = "";
    L18:
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r15.g = r6;
        EpisodeMod r7 = r13.episodeMod;
        if (r7 == null) goto L21;
        int r8 = ((BaseEpisodeMod) r7).episodeStage;
    L22:
        r15.E = r8;
        if (r7 == null) goto L25;
        int r9 = ((BaseEpisodeMod) r7).episodeType;
    L26:
        r15.G = r9;
        if (r7 == null) goto L29;
        int r10 = ((BaseEpisodeMod) r7).episodeSubType;
    L30:
        r15.H = r10;
        if (r7 == null) goto L33;
        int r11 = ((BaseEpisodeMod) r7).episodeRecordType;
    L34:
        r15.I = r11;
        if (r13.isStreamVideoType() == false) goto L37;
        String r12 = "instant_replay";
    L38:
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r15.D = r12;
    L40:
        c r17 = r1.h;
        if (r17 == null) goto L43;
        DataCenter r19 = (DataCenter) ((VSDrawerFeedLiveFragment) r17).H.getDataCenter();
    L45:
        if (r19 == null) goto L47;
        c r20 = r1.h;
        Intrinsics.checkNotNull(r20);
        com.bytedance.android.livesdk.vs.f.a(((VSDrawerFeedLiveFragment) r20).H.getDataCenter()).d("vs_video_show", r2, new Object[]{r15});
        goto L49
    L47:
        com.bytedance.android.livesdk.vs.f.c.d("vs_video_show", r2, new Object[]{r15});
        goto L49
    L43:
        r19 = null;
        goto L45
    L37:
        r12 = "normal";
        goto L38
    L33:
        r11 = -1;
        goto L34
    L29:
        r10 = -1;
        goto L30
    L25:
        r9 = -1;
        goto L26
    L21:
        r8 = -1;
        goto L22
    L39:
        r15 = null;
    L49:
        if (r1.j == null) goto L64;
        HashMap r21 = new HashMap();
        r21.put("drawer_page", "homepage_hot");
        r21.put("enter_from_merge", "drawer_hot");
        r21.put("enter_method", "drawer_cover");
        r21.put("order", String.valueOf(r1.g));
        Room r22 = r1.j;
        if (r22 == null) goto L54;
        int r23 = f.M;
        f r24 = f.a.a(r22);
    L55:
        c r25 = r1.h;
        if (r25 == null) goto L58;
        DataCenter r26 = (DataCenter) ((VSDrawerFeedLiveFragment) r25).H.getDataCenter();
    L60:
        if (r26 == null) goto L62;
        c r27 = r1.h;
        Intrinsics.checkNotNull(r27);
        com.bytedance.android.livesdk.vs.f.a(((VSDrawerFeedLiveFragment) r27).H.getDataCenter()).d("vs_livesdk_live_show", r21, new Object[]{r24});
        goto L64
    L62:
        com.bytedance.android.livesdk.vs.f.c.d("vs_livesdk_live_show", r21, new Object[]{r24});
        goto L64
    L58:
        r26 = null;
        goto L60
    L54:
        r24 = null;
    L64:
        if (r18.getLayoutPosition() != 0) goto L67;
        this.r.invoke();
        return;
    }

    public final RecyclerView.ViewHolder createFooterViewHolder(ViewGroup r3, int r4) {
        if (RoomContext.getShared() == null) goto L11;
        if (RoomContext.getShared().isVSRoom() == false) goto L11;
        if (RoomContext.getShared().isVSSpecialDrawer() == false) goto L11;
        return new PagingAdapter.EndViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565351, r3, false));
    L11:
        return new PagingAdapter.EndViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131565350, r3, false));
    }

    public final RecyclerView.ViewHolder createLoadingViewHolder(ViewGroup r3, int r4) {
        RoomContext r0 = RoomContext.getShared();
        if (r0 == null) goto L13;
        if (r0.isVSRoom() == false) goto L13;
        if (r0.isVSSpecialDrawer() == false) goto L13;
        if (r4 != (-1091576149)) goto L13;
        return createCustomErrorViewHolder(r3);
    L13:
        return super/*com.bytedance.android.live.core.paging.adapter.PagingAdapter*/.createLoadingViewHolder(r3, r4);
    }

    public final void onBindLoadingViewHolder(RecyclerView.ViewHolder r1, int r2) {
        super/*com.bytedance.android.live.core.paging.adapter.PagingAdapter*/.onBindLoadingViewHolder(r1, r2);
        if ((r1 instanceof LiveDrawerCategoryAdapter.ErrorViewHolder) == false) goto L6;
        ((LiveDrawerCategoryAdapter.ErrorViewHolder) r1).T3();
        return;
    }

    public DrawerFeedLiveAdapter(FeedItemDiffChecker r1, Map r2, com.bytedance.android.livesdk.feed.f r3, h r4, String r5, Function0 r6) {
        if (r1 != null) goto L4;
        DiffUtil.ItemCallback r7 = new BaseFeedAdapter.ItemComparator();
    L4:
        super(r7, r2, r3);
        this.p = r4;
        this.q = r5;
        this.r = r6;
    }
}
