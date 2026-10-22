package com.bytedance.android.livesdk.feed.live;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdk.feed.j;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.common.utility.UIUtils;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import kw1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LargeLiveViewHolder extends CommonLiveViewHolder {
    public static int D = -1;

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
        if (TextUtils.isEmpty(r7.liveReason) == true) goto L19;
        r0.putString("live_reason", r7.liveReason);
    L19:
        if (r7.getRoom() != null) goto L21;
    L23:
        r0.putString("enter_method", "live_cover");
        Y3(r7, true, "big_picture", r0);
        return;
    L21:
        if (TextUtils.isEmpty(r7.getRoom().getItemExplicitInfo()) == true) goto L23;
        r0.putString("live_recommend_info", r7.getRoom().getItemExplicitInfo());
        goto L23
    }

    @Override // com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final void U3(FeedItem r1, Room r2, int r3) {
        super.U3(r1, r2, r3);
        if (TextUtils.isEmpty(r2.getDistanceCity()) == true) goto L6;
        this.x.setText(r2.getDistanceCity());
    L9:
        if (D > 0) goto L11;
        D = UIUtils.getScreenWidth(this.s.getContext());
    L11:
        HSImageView r4 = this.s;
        int r5 = D;
        r4.setLayoutParams(new RelativeLayout.LayoutParams(r5, r5));
        return;
    L6:
        if (TextUtils.isEmpty(r2.getDistance()) == true) goto L9;
        this.x.setText(r2.getDistance());
        HashMap r6 = new HashMap();
        r6.put("event_belong", "live_function");
        r6.put("event_page", "city");
        r6.put("event_type", "show");
        c.d("boost_info_show", r6);
        goto L9
    }

    public LargeLiveViewHolder(View r1, tv1.c r2, f r3, FeedDataKey r4, j r5, ILiveRoomListDataSource r6, PublishSubject r7, PublishSubject r8, h r9) {
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }
}
