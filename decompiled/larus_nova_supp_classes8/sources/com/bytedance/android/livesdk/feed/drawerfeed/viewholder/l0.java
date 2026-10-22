package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.follow.ScheduledLiveItem;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l0 extends me.drakeet.multitype.b<FeedItem, DrawerLiveHistoryViewHolder> {
    public final Function1<FeedItem, Unit> b;
    public final IDrawerFeedAction c;

    public l0(Function1<? super FeedItem, Unit> r2, IDrawerFeedAction r3) {
        Intrinsics.checkNotNullParameter(r2, "deleteAction");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r8, Object r9) {
        DrawerLiveHistoryViewHolder r10 = (DrawerLiveHistoryViewHolder) r8;
        FeedItem r11 = (FeedItem) r9;
        Intrinsics.checkNotNullParameter(r10, "holder");
        Intrinsics.checkNotNullParameter(r11, "item");
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "data");
        r10.h = r11;
        HSImageView r0 = r10.e;
        ScheduledLiveItem r1 = r11.scheduledLive;
        Room r2 = null;
        if (r1 == null) goto L5;
        ImageModel r3 = r1.getAvatar();
    L6:
        ImageUtil.loadRoundImage(r0, r3);
        HSImageView r4 = r10.e;
        if (r4 == null) goto L9;
        r4.setImportantForAccessibility(2);
    L9:
        TextView r5 = r10.f;
        String r6 = "";
        if (r5 == null) goto L18;
        ScheduledLiveItem r7 = r11.scheduledLive;
        if (r7 == null) goto L16;
        String r12 = r7.getNickName();
        if (r12 == null) goto L16;
    L17:
        r5.setText(r12);
    L16:
        r12 = "";
    L18:
        TextView r13 = r10.g;
        if (r13 == null) goto L27;
        ScheduledLiveItem r14 = r11.scheduledLive;
        if (r14 == null) goto L25;
        String r15 = r14.getNickName();
        if (r15 == null) goto L25;
    L26:
        r13.setText(r15);
    L25:
        r15 = "";
    L27:
        ScheduledLiveItem r16 = r11.scheduledLive;
        if (r16 != null) goto L30;
    L41:
        HSImageView r17 = r10.d;
        ScheduledLiveItem r18 = r11.scheduledLive;
        if (r18 == null) goto L44;
        ImageModel r19 = r18.getAvatar();
    L45:
        ImageLoader.bindImage(r17, r19, new l3(15));
        View r20 = r10.b;
        if (r20 == null) goto L48;
        r20.setVisibility(0);
    L48:
        View r21 = r10.a;
        if (r21 == null) goto L51;
        r21.setVisibility(8);
    L51:
        LinkedHashMap r22 = new LinkedHashMap();
        FeedItem r23 = r10.h;
        if (r23 == null) goto L56;
        ScheduledLiveItem r24 = r23.scheduledLive;
        if (r24 == null) goto L56;
        r2 = r24.getRoom();
    L56:
        if (r2 != null) goto L58;
        String r25 = "0";
    L59:
        r22.put("history_is_on_live", r25);
        r22.put("enter_from_merge", "drawer_hot");
        r22.put("enter_method", "live_history_card");
        IUserService r26 = jc1.k.f(IUserService.class);
        if (r26 == null) goto L65;
        com.bytedance.android.livesdk.user.f r27 = r26.user();
        if (r27 == null) goto L65;
        String r28 = r27.n();
        if (r28 == null) goto L65;
    L66:
        r22.put("user_id", r28);
        FeedItem r29 = r10.h;
        if (r29 == null) goto L72;
        ScheduledLiveItem r30 = r29.scheduledLive;
        if (r30 == null) goto L72;
        String r31 = r30.getUidStr();
        if (r31 == null) goto L72;
    L73:
        r22.put("anchor_id", r31);
        FeedItem r32 = r10.h;
        if (r32 == null) goto L83;
        ScheduledLiveItem r33 = r32.scheduledLive;
        if (r33 == null) goto L83;
        Room r34 = r33.getRoom();
        if (r34 == null) goto L83;
        String r35 = r34.getIdStr();
        if (r35 == null) goto L83;
        r6 = r35;
    L83:
        r22.put("room_id", r6);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_history_anchor_show", r22, new Object[0]);
        FeedItem r36 = r10.h;
        if (r36 == null) goto L94;
        ScheduledLiveItem r37 = r36.scheduledLive;
        if (r37 != null) goto L88;
        return;
    L88:
        if (r37.getRoom() == null) goto L96;
        String r38 = jc1.k.n(IHostBusiness.class).createBtmId(jc1.k.n(IHostBusiness.class).getBtmIdByWidget("livesdk_live_drawer_widget"), ((RecyclerView.ViewHolder) r10).itemView);
        if (TextUtils.isEmpty(r38) == true) goto L92;
        r22.put("btm_id", r38);
    L92:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_show", r22, new Object[0]);
        return;
    L96:
        return;
    L94:
        return;
    L72:
        r31 = "";
    L65:
        r28 = "";
        goto L66
    L58:
        r25 = "1";
        goto L59
    L44:
        r19 = null;
        goto L45
    L30:
        if (r16.getRoom() == null) goto L41;
        HSImageView r39 = r10.d;
        ScheduledLiveItem r40 = r11.scheduledLive;
        if (r40 == null) goto L34;
        ImageModel r41 = r40.getAvatar();
    L35:
        ImageLoader.bindImage(r39, r41);
        View r42 = r10.b;
        if (r42 == null) goto L38;
        r42.setVisibility(8);
    L38:
        View r43 = r10.a;
        if (r43 == null) goto L51;
        r43.setVisibility(0);
        goto L51
    L34:
        r41 = null;
        goto L35
    L5:
        r3 = null;
        goto L6
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new DrawerLiveHistoryViewHolder(r3.inflate(2131565972, r4, false), this.b, this.c);
    }
}
