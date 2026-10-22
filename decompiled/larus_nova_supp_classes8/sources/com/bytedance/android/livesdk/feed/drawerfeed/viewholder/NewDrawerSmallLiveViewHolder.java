package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.config.jr;
import com.bytedance.android.livesdk.feed.LiveDrawerFeedCategoryFragment;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ILiveRoomListDataSource;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class NewDrawerSmallLiveViewHolder extends DrawerSmallLiveViewHolder {
    public int Z;
    public final qv1.b k0;
    public final Map<String, String> p0;

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerSmallLiveViewHolder, com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final String V3() {
        com.bytedance.android.livesdk.feed.h r0 = this.m;
        if (r0 == null) goto L10;
        if (r0.wg() == null) goto L10;
        String r1 = this.m.wg().j();
        if (TextUtils.isEmpty(r1) == true) goto L10;
        return r1;
    L10:
        return super.V3();
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerCommonLiveViewHolder
    public final boolean f4() {
        com.bytedance.android.livesdk.feed.feed.e r0 = this.h;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getType() == 3) goto L7;
        return false;
    L7:
        if (this.k0.Or(this.Z) == true) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerSmallLiveViewHolder
    public final String i4() {
        if (this.G == false) goto L6;
        return "drawer_cell";
    L6:
        return "drawer_cover";
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerSmallLiveViewHolder
    public final String k4() {
        if (TextUtils.isEmpty(this.k0.eu()) == true) goto L7;
        return "";
    L7:
        return this.k0.eu();
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerSmallLiveViewHolder
    public final boolean m4() {
        com.bytedance.android.livesdk.feed.j r0 = this.l;
        if (r0 == null) goto L15;
        FeedDataKey r2 = this.c;
        if (r2 == null) goto L19;
        com.bytedance.android.livesdk.feed.feed.e r1 = r0.d(r2.c);
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r1.p() == true) goto L12;
        return false;
    L12:
        if (this.k0.Or(this.Z) == true) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    L15:
        return false;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerSmallLiveViewHolder
    public final boolean r4() {
        if (jr.a.getValue().booleanValue() == true) goto L5;
        return false;
    L5:
        com.bytedance.android.livesdk.feed.feed.e r0 = this.h;
        if (r0 == null) goto L11;
        if (r0.getType() != 3) goto L11;
        return false;
    L11:
        return super.r4();
    }

    @Override // com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final String W3() {
        if (TTLiveService.getLiveService() == null) goto L5;
        String r0 = TTLiveService.getLiveService().getLiveOntologyRecord().getInnerUrl();
    L7:
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r0 = this.k0.bg().h();
    L10:
        if (this.k0.Or(this.Z) == false) goto L15;
        if (TTLiveService.getLiveService().getLiveOntologyRecord().isEnableReplaceRecommend() == false) goto L15;
        return r0;
    L15:
        if (((Boolean) LiveFeedSettings.DRAWER_MULTI_TAB_USE_RECOMMEND_INNER_URL.getValue()).booleanValue() == false) goto L17;
        return r0;
    L17:
        com.bytedance.android.livesdk.feed.j r1 = this.l;
        long r2 = -1;
        if (r1 == null) goto L24;
        FeedDataKey r3 = this.c;
        if (r3 == null) goto L24;
        com.bytedance.android.livesdk.feed.feed.e r4 = r1.d(r3.c);
        if (r4 == null) goto L24;
        r2 = r4.f();
    L24:
        UrlBuilder r5 = new UrlBuilder("/webcast/feed/").addParam("source_key", V3() + "_drawer_cover").addParam("inner_from_drawer", 1).addParam("need_map", 1);
        if (r2 < 0) goto L28;
        r5.addParam("tab_id", r2);
    L28:
        return r5.build();
    L5:
        r0 = "";
        goto L7
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerSmallLiveViewHolder
    public final HashMap<String, String> j4() {
        HashMap<String, String> r0 = super.j4();
        com.bytedance.android.livesdk.feed.j r1 = this.l;
        if (r1 != null) goto L5;
        return r0;
    L5:
        com.bytedance.android.livesdk.feed.feed.e r2 = r1.d(this.c.c);
        if (r2 != null) goto L8;
        return r0;
    L8:
        String r3 = "0";
        if (r2.p() == false) goto L16;
        if (this.k0.Or(this.Z) == false) goto L13;
        String r4 = "0";
    L14:
        r0.put("is_fans", r4);
        goto L16
    L13:
        r4 = "1";
    L16:
        if (r2.r() == false) goto L18;
    L23:
        r0.putAll(this.p0);
        return r0;
    L18:
        if (r2.p() == true) goto L23;
        if (this.k0.Or(this.Z) == false) goto L22;
        r3 = "1";
    L22:
        r0.put("is_hot", r3);
        goto L23
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerSmallLiveViewHolder, com.bytedance.android.livesdk.feed.drawerfeed.viewholder.DrawerCommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.CommonLiveViewHolder, com.bytedance.android.livesdk.feed.live.BaseLiveViewHolder
    public final void U3(FeedItem r1, Room r2, int r3) {
        this.Z = r3;
        super.U3(r1, r2, r3);
    }

    public NewDrawerSmallLiveViewHolder(View r1, tv1.c r2, com.bytedance.android.livesdk.feed.f r3, FeedDataKey r4, com.bytedance.android.livesdk.feed.j r5, ILiveRoomListDataSource r6, PublishSubject r7, PublishSubject r8, ViewGroup r9, Map r10, LiveDrawerFeedCategoryFragment r11, LiveDrawerFeedCategoryFragment r12) {
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        this.Z = 0;
        this.j = true;
        this.k0 = r12;
        this.p0 = r10;
    }
}
