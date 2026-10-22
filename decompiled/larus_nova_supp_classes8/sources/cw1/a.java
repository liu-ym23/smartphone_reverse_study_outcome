package cw1;

import android.text.TextUtils;
import bw1.e;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.PlaceHolder;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends e {
    @Override // bw1.e
    public final void c() {
    }

    @Override // bw1.e
    public final String d() {
        if (this.f.getType() != 1) goto L5;
        return "";
    L5:
        String r0 = this.f.g();
        if (r0 != null) goto L9;
        return "";
    L9:
        return r0;
    }

    @Override // bw1.e
    public final long g() {
        return this.f.f();
    }

    public final boolean h() {
        int r0 = this.b.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L18;
        FeedItem r3 = this.b.get(r2);
        if (r3.type != 11) goto L11;
        PlaceHolder r4 = r3.placeHolder;
        if (r4 == null) goto L11;
        if (r4.getType() != 1) goto L11;
        return true;
    L11:
        r2 = r2 + 1;
        goto L3
    L18:
        return false;
    }

    @Override // bw1.e
    public final String b() {
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 == null) goto L8;
        ILiveOntologyInfoManager r1 = r0.getLiveOntologyRecord();
        if (r1 == null) goto L8;
        String r2 = r1.getEnterFromMerge();
        if (r2 == null) goto L8;
    L9:
        String r3 = this.f.j();
        String r4 = this.f.e();
        if (TextUtils.isEmpty(r3) == true) goto L13;
        return r3;
    L13:
        if (TextUtils.isEmpty(r4) == true) goto L16;
        return r4;
    L16:
        if (this.a.contains(r2) == false) goto L20;
        return "drawer_follow";
    L20:
        if (TextUtils.equals(r2, "homepage_fresh") == false) goto L22;
        return "drawer_city";
    L22:
        return "drawer_hot";
    L8:
        r2 = "drawer_null";
        goto L9
    }

    @Override // bw1.e
    public final String f() {
        if (h() == false) goto L24;
        if (this.f.getType() == 1) goto L24;
        StringBuilder r0 = new StringBuilder();
        List<com.bytedance.android.livesdk.feed.feed.e> r3 = this.g.getTabList();
        String r4 = null;
        if (r3 == null) goto L21;
        Iterator<T> r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L17;
        Object r6 = r5.next();
        if (((com.bytedance.android.livesdk.feed.feed.e) r6).getType() == 1) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L10;
    L18:
        com.bytedance.android.livesdk.feed.feed.e r8 = (com.bytedance.android.livesdk.feed.feed.e) r6;
        if (r8 == null) goto L21;
        r4 = r8.j();
        goto L21
    L14:
        r7 = false;
        goto L15
    L17:
        r6 = null;
    L21:
        r0.append(r4);
        r0.append("-drawer_cover");
        return r0.toString();
    L24:
        return this.f.j() + "-drawer_cover";
    }

    @Override // bw1.e
    public final String a(int r6) {
        ILiveService r0 = TTLiveService.getLiveService();
        if (r0 == null) goto L8;
        ILiveOntologyInfoManager r1 = r0.getLiveOntologyRecord();
        if (r1 == null) goto L8;
        String r2 = r1.getInnerUrl();
        if (r2 == null) goto L8;
    L12:
        if (r2 != null) goto L15;
        r2 = "";
    L15:
        if (this.f.getType() != 1) goto L17;
    L16:
        boolean r3 = true;
    L29:
        if (r3 == false) goto L38;
        ILiveService r7 = TTLiveService.getLiveService();
        if (r7 == null) goto L38;
        ILiveOntologyInfoManager r8 = r7.getLiveOntologyRecord();
        if (r8 == null) goto L38;
        if (r8.isEnableReplaceRecommend() != true) goto L38;
        return r2;
    L38:
        if (((Boolean) LiveFeedSettings.DRAWER_MULTI_TAB_USE_RECOMMEND_INNER_URL.getValue()).booleanValue() == false) goto L40;
        return r2;
    L40:
        long r4 = this.f.f();
        UrlBuilder r9 = new UrlBuilder("/webcast/feed/").addParam("source_key", b() + "_drawer_cover").addParam("inner_from_drawer", 1).addParam("need_map", 1);
        if (r4 < 0) goto L44;
        r9.addParam("tab_id", r4);
    L44:
        return r9.build();
    L17:
        r3 = false;
        if (this.b.size() <= r6) goto L29;
        if (r6 < 0) goto L29;
        int r5 = 0;
    L22:
        PlaceHolder r10 = this.b.get(r5).placeHolder;
        if (r10 != null) goto L25;
    L27:
        if (r5 == r6) goto L29;
        r5 = r5 + 1;
        goto L22
    L25:
        if (r10.getType() != 1) goto L27;
    L8:
        com.bytedance.android.livesdk.feed.feed.e r11 = this.g.getFeedTabItem();
        if (r11 == null) goto L11;
        r2 = r11.h();
        goto L12
    L11:
        r2 = null;
        goto L12
    }

    @Override // bw1.e
    public final String e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "backUrl");
        if (this.f.getType() != 1) goto L6;
        return r4;
    L6:
        if (h() == true) goto L8;
        return r4;
    L8:
        if (this.f.getType() != 5) goto L10;
        String r0 = "webcast/appointment/feed/";
    L11:
        String r5 = new UrlBuilder(r0).addParam("source_key", this.f.j() + "_drawer_cover").addParam("need_map", 1).addParam("tab_id", this.f.f()).build();
        if (r5 != null) goto L16;
        return "";
    L16:
        return r5;
    L10:
        r0 = "/webcast/feed/";
        goto L11
    }

    public a(com.bytedance.android.livesdk.feed.feed.e r2, TabListModel r3) {
        Intrinsics.checkNotNullParameter(r2, "itemTab");
        Intrinsics.checkNotNullParameter(r3, "tabListModel");
        super(r2, r3);
    }
}
