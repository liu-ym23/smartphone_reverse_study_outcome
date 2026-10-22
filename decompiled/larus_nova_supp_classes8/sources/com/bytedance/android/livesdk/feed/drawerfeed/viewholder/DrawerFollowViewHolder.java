package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.feed.v0;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.announcement.IAnnouncementService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/viewholder/DrawerFollowViewHolder;", "Lcom/bytedance/android/live/core/viewholder/BaseViewHolder;", "Lcom/bytedance/android/live/base/model/feed/FeedItem;", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DrawerFollowViewHolder extends BaseViewHolder<FeedItem> {
    public final HSImageView a;
    public final TextView b;
    public final TextView c;
    public final Lazy d;
    public FeedItem e;

    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        FeedItem r0 = this.e;
        if (r0 == null) goto L15;
        ScheduledLiveItem r1 = r0.scheduledLive;
        if (r1 == null) goto L16;
        int r2 = v0.a;
        ILiveService r3 = TTLiveService.getLiveService();
        if (r3 == null) goto L12;
        ILiveOntologyInfoManager r4 = r3.getLiveOntologyRecord();
        if (r4 == null) goto L12;
        String r5 = r4.getEnterFromMerge();
        if (r5 == null) goto L12;
    L13:
        String r6 = r1.getUidStr();
        Intrinsics.checkNotNullParameter(r5, "drawerPage");
        Intrinsics.checkNotNullParameter(r6, "anchorId");
        HashMap r7 = new HashMap();
        r7.put("anchor_id", r6.toString());
        r7.put("drawer_page", r5);
        r7.put("enter_from_merge", "drawer_follow");
        r7.put("enter_method", "drawer_cover");
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_list_show", r7, new Object[0]);
        return;
    L12:
        r5 = "drawer_null";
        goto L13
    L16:
        return;
    }

    public DrawerFollowViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = r2.findViewById(2131376019);
        this.b = (TextView) r2.findViewById(2131391755);
        this.c = (TextView) r2.findViewById(2131391743);
        TextView r3 = (TextView) r2.findViewById(2131391744);
        this.d = LazyKt.lazy(DrawerFollowViewHolder$announceService$2.INSTANCE);
    }

    public static final void T3(DrawerFollowViewHolder r2, ScheduledLiveItem r3) {
        r2.getClass();
        if (r3 == null) goto L13;
        String r4 = r3.getSecUid();
        if (TextUtils.isEmpty(r4) == false) goto L8;
        r4 = r3.getUidStr().toString();
    L8:
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r4) == true) goto L11;
        r0.put("sec_user_id", r4);
    L11:
        jc1.k.n(IRoomService.class).actionHandler().showUserProfile(r3.getUidStr(), null, r0);
        return;
    }

    public final void bind(Object r6, int r7) {
        FeedItem r8 = (FeedItem) r6;
        this.e = r8;
        if (r8 == null) goto L23;
        ScheduledLiveItem r9 = r8.scheduledLive;
        if (r9 == null) goto L23;
        this.b.setText(r9.getNickName());
        StringBuilder r0 = new StringBuilder();
        String r1 = r9.getScheduledText();
        boolean r2 = false;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
        r0.append(r9.getScheduledText() + '\n');
    L15:
        String r4 = r9.getAnnouncementContent();
        if (r4 != null) goto L18;
    L19:
        r2 = true;
    L20:
        if (r2 == true) goto L22;
        r0.append(r9.getAnnouncementContent());
        ((IAnnouncementService) this.d.getValue()).logAnnouncementShow("more_anchor_list", "more_anchor_list");
    L22:
        this.c.setText(r0);
        ImageUtil.loadRoundImage(this.a, r9.getAvatar());
        goto L23
    L18:
        if (r4.length() != 0) goto L20;
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
    L23:
        ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(new m(this, r8));
        this.a.setOnClickListener(new n(this, r8));
    }
}
