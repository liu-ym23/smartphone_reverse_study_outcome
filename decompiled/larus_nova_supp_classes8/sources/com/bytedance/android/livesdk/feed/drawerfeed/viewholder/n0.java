package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n0 implements View.OnClickListener {
    public final /* synthetic */ VSDrawerFeedLiveViewHolder a;
    public final /* synthetic */ FeedItem b;

    public n0(VSDrawerFeedLiveViewHolder r1, FeedItem r2, int r3) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        VSDrawerFeedLiveViewHolder r11 = this.a;
        FeedItem r0 = this.b;
        r11.getClass();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.episode == null) goto L7;
    L9:
        String r5 = null;
        if (r0.type != 16) goto L33;
        Room r1 = r0.getRoom();
        Bundle r2 = new Bundle();
        r2.putString(VSConstants.EXTRA_VS_ENTER_FROM_MERGE, "drawer_hot");
        r2.putString(VSConstants.EXTRA_VS_ENTER_METHOD, "drawer_cover");
        r2.putString(VSConstants.EXTRA_VS_DRAWER_ORDER, String.valueOf(r11.g));
        r2.putString(VSConstants.EXTRA_VS_DRAWER_PAGE, "homepage_hot");
        VSDataContext.Companion.getClass();
        VSDataContext r12 = VSDataContext.a.a();
        if (r12 != null) goto L14;
    L22:
        ILiveService r13 = TTLiveService.getLiveService();
        if (r13 == null) goto L27;
        ILiveOntologyInfoManager r14 = r13.getLiveOntologyRecord();
        if (r14 == null) goto L27;
        r5 = r14.getVSInnerUrl();
    L27:
        r2.putString("live.intent.extra.FEED_URL", r5);
        r2.putInt(VSConstants.EXTRA_ITEM_TYPE, VSConstants.VS_FIRST_SHOW);
        if (r1 == null) goto L30;
        r2.putLong(VSConstants.EXTRA_ITEM_ID, r1.id);
    L30:
        r2.putSerializable(VSConstants.EXTRA_VS_EPISODE, GsonProtectorUtils.toJson(GsonHelper.get(), r1, Room.class));
        if (r1 == null) goto L55;
        xs2.b.a().post(new JumpToOtherRoomEvent(r1.id, "", r2));
    L55:
        xs2.b.a().post(new uv1.e(0));
        return;
    L14:
        if (r12.getEpisode() == null) goto L22;
        String r3 = VSConstants.EXTRA_VS_FROM_EPISODE_ID;
        com.bytedance.live.datacontext.n r15 = r12.getEpisode();
        if (r15 == null) goto L20;
        Episode r16 = (Episode) r15.getValue();
        if (r16 == null) goto L20;
        String r17 = r16.idStr;
    L21:
        r2.putString(r3, r17);
    L20:
        r17 = null;
        goto L21
    L33:
        Episode r4 = r0.episode;
        Bundle r6 = new Bundle();
        r6.putString(VSConstants.EXTRA_VS_ENTER_FROM_MERGE, "drawer_hot");
        r6.putString(VSConstants.EXTRA_VS_ENTER_METHOD, "drawer_cover");
        r6.putString(VSConstants.EXTRA_VS_DRAWER_ORDER, String.valueOf(r11.g));
        r6.putString(VSConstants.EXTRA_VS_DRAWER_PAGE, "homepage_hot");
        VSDataContext.Companion.getClass();
        VSDataContext r18 = VSDataContext.a.a();
        if (r18 != null) goto L36;
    L44:
        ILiveService r19 = TTLiveService.getLiveService();
        if (r19 == null) goto L49;
        ILiveOntologyInfoManager r110 = r19.getLiveOntologyRecord();
        if (r110 == null) goto L49;
        r5 = r110.getVSInnerUrl();
    L49:
        r6.putString("live.intent.extra.FEED_URL", r5);
        r6.putInt(VSConstants.EXTRA_ITEM_TYPE, VSConstants.VS_EPISODE);
        if (r4 == null) goto L52;
        r6.putLong(VSConstants.EXTRA_ITEM_ID, r4.getId());
    L52:
        r6.putSerializable(VSConstants.EXTRA_VS_EPISODE, GsonProtectorUtils.toJson(GsonHelper.get(), r4, Episode.class));
        if (r4 == null) goto L55;
        xs2.b.a().post(new JumpToOtherRoomEvent(r4.getId(), "", r6));
        goto L55
    L36:
        if (r18.getEpisode() == null) goto L44;
        String r7 = VSConstants.EXTRA_VS_FROM_EPISODE_ID;
        com.bytedance.live.datacontext.n r111 = r18.getEpisode();
        if (r111 == null) goto L42;
        Episode r112 = (Episode) r111.getValue();
        if (r112 == null) goto L42;
        String r113 = r112.idStr;
    L43:
        r6.putString(r7, r113);
    L42:
        r113 = null;
        goto L43
    L7:
        if (r0.getRoom() != null) goto L9;
    }
}
