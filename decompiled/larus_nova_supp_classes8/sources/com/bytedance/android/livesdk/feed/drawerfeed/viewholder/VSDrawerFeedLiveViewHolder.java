package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.chatroom.ui.LiveRoundImageView;
import com.bytedance.android.livesdk.feed.drawerfeed.VSDrawerFeedLiveFragment;
import com.bytedance.android.livesdk.feed.drawerfeed.widget.FixedRatioRelativeLayout;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import io.reactivex.subjects.PublishSubject;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/VSDrawerFeedLiveViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSDrawerFeedLiveViewHolder extends BaseViewHolder<FeedItem> {
    public final LiveRoundImageView a;
    public final TextView b;
    public final TextView c;
    public final FixedRatioRelativeLayout d;
    public final TextView e;
    public final float f;
    public int g;
    public final qv1.c h;
    public Episode i;
    public Room j;

    public final void bind(Object r7, int r8) {
        FeedItem r9 = (FeedItem) r7;
        this.d.setRatio(this.f);
        this.g = r8 + 1;
        this.e.setVisibility(8);
        if (r9 != null) goto L5;
    L13:
        if (r9 == null) goto L19;
        Episode r1 = r9.episode;
        if (r1 == null) goto L19;
        ImageUtil.loadImage(this.a, r1.seasonCoverVertical, 0);
        this.b.setText(r1.showName);
        this.c.setText(r1.drawSubTitle);
        this.i = r9.episode;
        if (TextUtils.isEmpty(r1.seasonTypeName) == true) goto L19;
        this.e.setVisibility(0);
        this.e.setText(r1.seasonTypeName);
    L19:
        if (r9 == null) goto L27;
        qv1.c r0 = this.h;
        if (r0 == null) goto L27;
        VSDrawerFeedLiveFragment r2 = (VSDrawerFeedLiveFragment) r0;
        Episode r3 = r9.episode;
        if (r3 == null) goto L27;
        if (r3.getIdExt() == 0) goto L27;
        Set<Long> r4 = r2.P;
        HashSet r5 = (HashSet) r4;
        r5.add(Long.valueOf(r9.episode.getIdExt()));
    L27:
        this.d.setOnClickListener(new n0(this, r9, r8));
        return;
    L5:
        if (r9.type != 16) goto L13;
        Room r6 = r9.getRoom();
        if (r6 == null) goto L19;
        EpisodeExtraInfo r10 = r6.getEpisodeExtra2();
        if (r10 == null) goto L19;
        ImageUtil.loadImage(this.a, r10.getSeasonCoverVertical(), 0);
        this.b.setText(r10.getShowName());
        this.c.setText(r10.getDrawSubTitle());
        this.j = r9.getRoom();
        if (TextUtils.isEmpty(r10.getSeasonTypeName()) == true) goto L19;
        this.e.setVisibility(0);
        this.e.setText(r10.getSeasonTypeName());
        goto L19
    }

    public VSDrawerFeedLiveViewHolder(View r2, tv1.c r3, com.bytedance.android.livesdk.feed.f r4, FeedDataKey r5, com.bytedance.android.livesdk.feed.j r6, ILiveRoomListDataSource r7, PublishSubject<FeedItem> r8, PublishSubject<Boolean> r9, PublishSubject<Object> r10, PublishSubject<Object> r11, com.bytedance.android.livesdk.feed.h r12, qv1.c r13) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "dislikeRepository");
        Intrinsics.checkNotNullParameter(r4, "feedDataManager");
        Intrinsics.checkNotNullParameter(r5, "feedDataKey");
        Intrinsics.checkNotNullParameter(r6, "feedTabRepository");
        Intrinsics.checkNotNullParameter(r7, "dataSource");
        Intrinsics.checkNotNullParameter(r8, "enterEvent");
        Intrinsics.checkNotNullParameter(r9, "userVisibility");
        Intrinsics.checkNotNullParameter(r10, "resume");
        Intrinsics.checkNotNullParameter(r11, "pause");
        Intrinsics.checkNotNullParameter(r12, "feedParams");
        super(r2);
        this.a = (LiveRoundImageView) r2.findViewById(2131368173);
        this.b = (TextView) r2.findViewById(2131392929);
        this.c = (TextView) r2.findViewById(2131392928);
        this.d = (FixedRatioRelativeLayout) r2.findViewById(2131392931);
        this.e = (TextView) r2.findViewById(2131391706);
        this.f = 0.7619048f;
        this.h = r13;
    }
}
