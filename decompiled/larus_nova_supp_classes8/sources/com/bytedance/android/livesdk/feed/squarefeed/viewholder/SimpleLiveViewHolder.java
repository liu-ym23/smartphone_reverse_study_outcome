package com.bytedance.android.livesdk.feed.squarefeed.viewholder;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder;
import com.bytedance.android.livesdk.feed.openui.view.SimpleLiveView;
import com.bytedance.android.livesdk.g;
import com.bytedance.android.livesdk.utils.p1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SimpleLiveViewHolder extends CommonLiveViewHolder {
    public final View D;
    public final SimpleLiveView E;

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final String V3() {
        if (this.m.getFeedType() != FeedType.FOLLOW_FEED) goto L7;
        return "homepage_follow";
    L7:
        if (this.m.getFeedType() != FeedType.HOT_FEED) goto L10;
        return "live_search_section";
    L10:
        return "live_channel";
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void c4(FeedItem r7) {
        Bundle r0 = new Bundle();
        Bundle r1 = new Bundle();
        r1.putString("live_source", "live_big_picture");
        String r2 = this.c.b;
        if (r2.contains("live") == false) goto L9;
        e r4 = this.h;
        if (r4 == null) goto L9;
        r2 = r4.e();
        if (TextUtils.isEmpty(r2) == false) goto L9;
        r2 = "live_merge_null";
    L9:
        r1.putString("subtab", r2);
        r0.putString("source", r2);
        r0.putBundle("live.intent.extra.ENTER_LIVE_EXTRA_V1", r1);
        r0.putString("log_pb", r7.logPb);
        r0.putString("request_id", r7.resId);
        e r3 = this.h;
        if (r3 == null) goto L12;
        r0.putLong("live.intent.extra.USER_FROM", r3.l());
    L12:
        r0.putString("enter_from", "live");
        r0.putString("enter_from_merge", r2);
        if (r7.isRecommendCard == false) goto L16;
        r0.putString("enter_from_merge_recommend", "pop_card");
    L16:
        if (TextUtils.isEmpty(r7.liveReason) == true) goto L18;
        r0.putString("live_reason", r7.liveReason);
    L18:
        r0.putString("enter_method", "live_cover");
        Y3(r7, true, "big_picture", r0);
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final void U3(FeedItem r9, Room r10, int r11) {
        super.U3(r9, r10, r11);
        UIUtils.setViewVisibility(this.t, 8);
        UIUtils.setViewVisibility(this.D, 8);
        UIUtils.setViewVisibility(this.s, 8);
        this.E.setVisibility(0);
        k r12 = null;
        ((RecyclerView.ViewHolder) this).itemView.setOnLongClickListener(null);
        ((Boolean) g.a.getValue()).booleanValue();
        SimpleLiveView r0 = this.E;
        String r13 = this.m.d40();
        String r1 = V3();
        LiveCoverConfig r7 = this.m.kG();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r10, "room");
        Intrinsics.checkNotNullParameter(r13, "feedUrl");
        r0.a = r10;
        r0.e = r13;
        r0.b = r1;
        User r2 = r10.getOwner();
        if (r10.isMediaRoom() == false) goto L8;
        User r14 = r10.getOwner();
        if (r14 == null) goto L7;
        String r15 = r14.getRealNickName();
    L9:
        String r3 = r15;
    L10:
        String r6 = p1.b(r10);
        k r16 = r10.getContentLabel();
        if ((r16 instanceof ImageModel) == false) goto L14;
        r12 = r16;
    L14:
        r0.c(r2, (ImageModel) r12, r3, 0, r6, r7);
        return;
    L7:
        r3 = null;
        goto L10
    L8:
        r15 = r10.getTitle();
        goto L9
    }

    public SimpleLiveViewHolder(View r11, FeedDataKey r12, PublishSubject<Boolean> r13, h r14, IFeedActionCallback r15) {
        super(r11, null, null, r12, null, null, null, r13, r14);
        this.D = r11.findViewById(2131367812);
        this.E = (SimpleLiveView) r11.findViewById(2131378252);
    }
}
