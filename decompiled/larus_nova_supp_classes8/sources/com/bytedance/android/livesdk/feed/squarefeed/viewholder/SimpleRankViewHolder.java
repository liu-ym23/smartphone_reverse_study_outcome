package com.bytedance.android.livesdk.feed.squarefeed.viewholder;

import android.view.View;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.rank.a;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.FormatUtils;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.IFeedActionCallback;
import com.bytedance.android.livesdk.feed.h;
import com.bytedance.android.livesdk.feed.openui.view.SimpleLiveView;
import com.bytedance.android.livesdk.feed.services.AppointmentService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.LiveCoverConfig;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kw1.c;
import ww1.l;
import ww1.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class SimpleRankViewHolder extends BaseViewHolder<a> {
    public static final /* synthetic */ int d = 0;
    public final SimpleLiveView a;
    public final h b;
    public final PublishSubject<Boolean> c;

    public final void T3() {
        SimpleLiveView r0 = this.a;
        r0.getClass();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("enter_from_merge", r0.b);
        r1.put("enter_method", "main_tab");
        Room r2 = r0.a;
        String r3 = "";
        if (r2 == null) goto L6;
        String r4 = r2.getOwnerUserIdString();
        if (r4 == null) goto L6;
    L7:
        r1.put("anchor_id", r4);
        Room r5 = r0.a;
        Long r6 = null;
        if (r5 == null) goto L10;
        Long r7 = Long.valueOf(r5.id);
    L11:
        r1.put("room_id", String.valueOf(r7));
        r1.put("action_type", "click");
        Room r8 = r0.a;
        if (r8 == null) goto L15;
        String r9 = r8.getRequestId();
        if (r9 == null) goto L15;
    L16:
        r1.put("request_id", r9);
        Room r10 = r0.a;
        if (r10 == null) goto L22;
        String r11 = r10.getLog_pb();
        if (r11 == null) goto L22;
        r3 = r11;
    L22:
        r1.put("log_pb", r3);
        Room r12 = r0.a;
        if (r12 == null) goto L25;
        RoomExtra r13 = r12.getExtra();
    L27:
        if (r13 == null) goto L41;
        Room r14 = r0.a;
        if (r14 == null) goto L34;
        RoomExtra r15 = r14.getExtra();
        if (r15 == null) goto L34;
        if (r15.getXiguaUid() == 0) goto L41;
    L34:
        Room r16 = r0.a;
        if (r16 == null) goto L39;
        RoomExtra r17 = r16.getExtra();
        if (r17 == null) goto L39;
        Long r18 = Long.valueOf(r17.getXiguaUid());
    L40:
        r1.put("xg_uid", String.valueOf(r18));
    L39:
        r18 = null;
    L41:
        Room r19 = r0.a;
        if (r19 != null) goto L44;
    L45:
        if (r19 == null) goto L47;
        r6 = Long.valueOf(r19.appId);
    L47:
        r1.put("anchor_aid", String.valueOf(r6));
    L48:
        c.d("livesdk_live_show", r1);
        return;
    L44:
        if (r19.appId == 0) goto L48;
    L25:
        r13 = null;
    L15:
        r9 = "";
        goto L16
    L10:
        r7 = null;
    L6:
        r4 = "";
        goto L7
    }

    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        T3();
    }

    public final void bind(Object r11, int r12) {
        a r13 = (a) r11;
        SimpleLiveView r0 = this.a;
        String r14 = this.b.d40();
        if (this.b.getFeedType() != FeedType.FOLLOW_FEED) goto L6;
        String r1 = "homepage_follow";
    L9:
        LiveCoverConfig r7 = this.b.kG();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r13, "rankItem");
        Intrinsics.checkNotNullParameter(r14, "feedUrl");
        User r2 = r13.d();
        r0.e = r14;
        r0.a = r13.a();
        com.bytedance.android.live.base.model.rank.c r15 = r13.c();
        if (r15 == null) goto L12;
        long r3 = r15.d();
    L14:
        if (r3 >= AppointmentService.SOURCE_UNDEFINED) goto L16;
        String r16 = String.valueOf(r3);
    L17:
        String r6 = r16;
        r0.b = r1;
        com.bytedance.android.live.base.model.rank.c r17 = r13.c();
        String r4 = null;
        if (r17 == null) goto L20;
        ImageModel r18 = r17.a();
    L21:
        com.bytedance.android.live.base.model.rank.c r5 = r13.c();
        if (r5 == null) goto L24;
        r4 = r5.c();
    L24:
        r0.c(r2, r18, r4, r13.b(), r6, r7);
        PublishSubject<Boolean> r19 = this.c;
        if (r19 == null) goto L28;
        register(r19.subscribe(new l(this), new m()));
        return;
    L28:
        return;
    L20:
        r18 = null;
        goto L21
    L16:
        r16 = FormatUtils.format("%.1f", new Object[]{Double.valueOf((r3 * 1.0d) / 10000.0d)}) + "w";
        goto L17
    L12:
        r3 = 0;
        goto L14
    L6:
        if (this.b.getFeedType() != FeedType.HOT_FEED) goto L8;
        r1 = "live_search_section";
        goto L9
    L8:
        r1 = "homepage_hot";
        goto L9
    }

    public SimpleRankViewHolder(View r1, PublishSubject r2, h r3, IFeedActionCallback r4) {
        super(r1);
        this.a = (SimpleLiveView) r1.findViewById(2131378252);
        this.c = r2;
        this.b = r3;
    }
}
