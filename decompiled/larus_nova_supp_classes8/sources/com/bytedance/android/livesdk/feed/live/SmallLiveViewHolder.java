package com.bytedance.android.livesdk.feed.live;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.fragment.FeedLiveFragment;
import com.bytedance.android.livesdk.feed.j;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.subjects.PublishSubject;
import tv1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SmallLiveViewHolder extends CommonLiveViewHolder {
    public static int D = -1;

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void c4(FeedItem r6) {
        Bundle r0 = new Bundle();
        String r1 = this.c.b;
        e r2 = this.h;
        if (r2 == null) goto L7;
        r1 = r2.e();
        if (TextUtils.isEmpty(r1) == false) goto L7;
        r1 = "live_merge_null";
    L7:
        r0.putString("source", r1);
        Bundle r3 = new Bundle();
        r3.putString("live_source", "live_small_picture");
        r3.putString("subtab", r1);
        r0.putBundle("live.intent.extra.ENTER_LIVE_EXTRA_V1", r3);
        r0.putString("log_pb", r6.logPb);
        r0.putString("request_id", r6.resId);
        r0.putString("enter_from", "live");
        e r4 = this.h;
        if (r4 == null) goto L10;
        r0.putLong("live.intent.extra.USER_FROM", r4.l());
    L10:
        r0.putString("enter_from_merge", r1);
        if (r6.isRecommendCard == false) goto L14;
        r0.putString("enter_from_merge_recommend", "pop_card");
    L14:
        if (TextUtils.isEmpty(r6.liveReason) == true) goto L17;
        r0.putString("live_reason", r6.liveReason);
    L17:
        if (r6.getRoom() != null) goto L19;
    L21:
        r0.putString("enter_method", "live_cover");
        Y3(r6, true, "small_picture", r0);
        return;
    L19:
        if (TextUtils.isEmpty(r6.getRoom().getItemExplicitInfo()) == true) goto L21;
        r0.putString("live_recommend_info", r6.getRoom().getItemExplicitInfo());
        goto L21
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void d4(ImageModel r2) {
        if (r2 != null) goto L4;
        f4(0, 0);
        return;
    L4:
        f4(r2.width, r2.height);
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder
    public final void a4(ImageModel r3, Room r4) {
        f4(r3.getWidth(), r3.getHeight());
        super.a4(r3, r4);
    }

    public final void f4(int r3, int r4) {
        if (D > 0) goto L5;
        D = (UIUtils.getScreenWidth(((RecyclerView.ViewHolder) this).itemView.getContext()) - 3) / 2;
    L5:
        if (r3 <= 0) goto L9;
        if (r4 <= 0) goto L9;
        int r0 = (D * r4) / r3;
    L10:
        ViewGroup.LayoutParams r5 = this.s.getLayoutParams();
        int r6 = r5.width;
        int r1 = D;
        if (r6 == r1) goto L13;
    L15:
        r5.width = r1;
        r5.height = r0;
        this.s.setLayoutParams(r5);
        return;
    L13:
        if (r5.height != r0) goto L15;
        return;
    L9:
        r0 = D;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final void U3(FeedItem r1, Room r2, int r3) {
        super.U3(r1, r2, r3);
        e4(this.w, 8);
    }

    public SmallLiveViewHolder(View r1, c r2, f r3, FeedDataKey r4, j r5, ILiveRoomListDataSource r6, PublishSubject r7, PublishSubject r8, FeedLiveFragment r9) {
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }
}
