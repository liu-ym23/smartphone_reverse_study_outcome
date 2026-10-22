package com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder;

import am2.x;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bw1.e;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.base.model.banner.OperationCard;
import com.bytedance.android.live.base.model.banner.OperationMultipleRoom;
import com.bytedance.android.live.base.model.banner.OperationSingleRoom;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.SingleDrawFeedAdapter;
import com.bytedance.android.livesdk.feed.drawerfeed.singledraw.TabListModel;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.viewmodel.SingleDrawViewModel;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import df6.q;
import df6.r;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/OperationSingleDrawViewHolder;", "Lcom/bytedance/android/livesdk/feed/drawerfeed/singledraw/viewholder/AbsSingleDrawViewHolder;", "a", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OperationSingleDrawViewHolder extends AbsSingleDrawViewHolder {
    public static final /* synthetic */ int x = 0;
    public final String j;
    public boolean k;
    public final SmartImageView l;
    public final ViewGroup m;
    public final SmartImageView n;
    public final SmartImageView o;
    public final SmartImageView p;
    public final SmartImageView q;
    public final FrameLayout r;
    public final LottieAnimationView s;
    public final TextView t;
    public final TextView u;
    public boolean v;
    public OperationCard w;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ OperationSingleDrawViewHolder a;

        public b(OperationSingleDrawViewHolder r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            OperationSingleDrawViewHolder r5 = this.a;
            r5.Y3();
            r5.h.smoothScrollToPosition(r5.getAdapterPosition());
            SingleDrawViewModel r0 = r5.g.c;
            if (r0 == null) goto L11;
            NextLiveData r1 = r0.getOnRoomSelect();
            if (r1 == null) goto L11;
            Room r2 = r5.c;
            if (r2 == null) goto L9;
            Long r3 = Long.valueOf(r2.id);
        L10:
            r1.setValue(r3);
            goto L11
        L9:
            r3 = null;
        L11:
            TabListModel r6 = r5.i;
            if (r6 == null) goto L14;
            r6.setChosenTab(r6.getCurrentTabModel());
        L14:
            r5.V3();
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ OperationSingleDrawViewHolder a;
        public final /* synthetic */ Context b;

        public c(OperationSingleDrawViewHolder r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Room r5 = k.n(IRoomService.class).getCurrentRoomFromRoomContext();
            if (r5 != null) goto L5;
        L7:
            SingleDrawFeedAdapter r6 = this.a.g;
            if (r6 == null) goto L14;
            SingleDrawViewModel r7 = r6.c;
            if (r7 == null) goto L14;
            NextLiveData r8 = r7.getCloseDialog();
            if (r8 == null) goto L14;
            r8.setValue(Boolean.TRUE);
        L14:
            Uri.Builder r9 = UriProtector.parse("sslocal://webcast_room?").buildUpon();
            Room r0 = this.a.c;
            String r1 = null;
            if (r0 == null) goto L17;
            String r2 = r0.getOwnerUserIdString();
        L18:
            r9.appendQueryParameter("user_id", r2);
            r9.appendQueryParameter("isInnerFromDrawer", "true");
            OperationCard r3 = this.a.w;
            if (r3 == null) goto L21;
            String r10 = r3.idStr;
        L22:
            r9.appendQueryParameter("aggregate_banner_id", r10);
            OperationCard r11 = this.a.w;
            if (r11 == null) goto L27;
            OperationMultipleRoom r12 = r11.operationMultipleRoom;
            if (r12 == null) goto L27;
            String r13 = r12.columTitle;
        L28:
            r9.appendQueryParameter("aggregate_column_title", r13);
            Room r14 = this.a.c;
            if (r14 == null) goto L31;
            String r15 = r14.getIdStr();
        L32:
            r9.appendQueryParameter("room_id", r15);
            TabListModel r16 = this.a.i;
            if (r16 == null) goto L37;
            e r17 = r16.getCurrentTabModel();
            if (r17 == null) goto L37;
            r1 = r17.b();
        L37:
            r9.appendQueryParameter("enter_from_merge", r1);
            r9.appendQueryParameter("enter_method", this.a.j);
            r9.appendQueryParameter("operation_type", "group_room");
            ILiveService r18 = TTLiveService.getLiveService();
            if (r18 == null) goto L41;
            r18.handleSchema(this.b, r9.build());
            return;
        L41:
            return;
        L31:
            r15 = null;
        L27:
            r13 = null;
            goto L28
        L21:
            r10 = null;
            goto L22
        L17:
            r2 = null;
            goto L18
        L5:
            if (r5.withAggregateColumn != true) goto L7;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.AbsSingleDrawViewHolder
    public final void X3() {
        OperationCard r0 = this.w;
        o r1 = u.l().c(x.class);
        String r3 = "";
        if (r1 == null) goto L8;
        Map r2 = r1.getMap();
        if (r2 == null) goto L8;
        String r4 = (String) r2.get("enter_from_merge");
        if (r4 == null) goto L8;
    L9:
        Integer r5 = null;
        if (r0 == null) goto L12;
        Integer r6 = r0.type;
    L14:
        if (r6 != null) goto L17;
    L19:
        if (r6 != null) goto L22;
    L24:
        String r7 = "";
    L25:
        LinkedHashMap r8 = new LinkedHashMap();
        Room r9 = this.c;
        if (r9 == null) goto L31;
        User r10 = r9.getOwner();
        if (r10 == null) goto L31;
        String r11 = r10.getIdString();
        if (r11 == null) goto L31;
    L32:
        r8.put("anchor_id", r11);
        Room r12 = this.c;
        if (r12 == null) goto L36;
        String r13 = r12.getIdStr();
        if (r13 == null) goto L36;
    L37:
        r8.put("room_id", r13);
        r8.put("enter_from_merge", r4);
        r8.put("enter_method", "drawer_operation_card");
        r8.put("action_type", "click");
        r8.put("operation_type", r7);
        Room r14 = this.c;
        if (r14 == null) goto L42;
        String r15 = r14.getRequestId();
        if (r15 == null) goto L42;
    L43:
        r8.put("request_id", r15);
        Room r16 = this.c;
        if (r16 == null) goto L49;
        String r17 = r16.getLog_pb();
        if (r17 == null) goto L49;
        r3 = r17;
    L49:
        r8.put("log_pb", r3);
        if (r0 == null) goto L52;
        r5 = r0.type;
    L52:
        if (r5 != null) goto L55;
    L57:
        u.l().sendLog("livesdk_live_show", r8, new Object[0]);
        return;
    L55:
        if (r5.intValue() != 3) goto L57;
        r8.put("is_group_room_outer", "1");
    L42:
        r15 = "";
    L36:
        r13 = "";
    L31:
        r11 = "";
        goto L32
    L22:
        if (r6.intValue() != 3) goto L24;
        r7 = "group_room";
        goto L25
    L17:
        if (r6.intValue() != 2) goto L19;
        r7 = "single_room";
        goto L25
    L12:
        r6 = null;
    L8:
        r4 = "";
        goto L9
    }

    public final void Y3() {
        UtilityKotlinExtentionsKt.w(this.s);
        UtilityKotlinExtentionsKt.w(this.r);
        this.s.playAnimation();
        this.v = true;
    }

    @Override // com.bytedance.android.livesdk.feed.drawerfeed.singledraw.viewholder.AbsSingleDrawViewHolder
    public final void T3(FeedItem r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "feedItem");
        this.d = r8;
        List r10 = null;
        if (r8 == null) goto L5;
        OperationCard r0 = r8.operationCard;
    L6:
        this.w = r0;
        q.b(new r(new r.a(s1.getContext())));
        this.r.setVisibility(8);
        UtilityKotlinExtentionsKt.t(this.s);
        UtilityKotlinExtentionsKt.t(this.r);
        this.s.pauseAnimation();
        this.v = false;
        if (this.k == true) goto L14;
        SingleDrawViewModel r2 = this.g.c;
        if (r2 == null) goto L13;
        NextLiveData r3 = r2.getOnRoomSelect();
        if (r3 == null) goto L13;
        r3.observe(this.g.d, new dw1.a(this));
    L13:
        this.k = true;
    L14:
        OperationCard r4 = this.w;
        if (r4 == null) goto L17;
        Integer r5 = r4.type;
    L19:
        if (r5 != null) goto L22;
    L65:
        OperationCard r6 = this.w;
        if (r6 == null) goto L68;
        Integer r7 = r6.type;
    L69:
        if (r7 != null) goto L72;
    L134:
        U3();
        return;
    L72:
        if (r7.intValue() != 3) goto L134;
        OperationCard r11 = r8.operationCard;
        if (r11 == null) goto L78;
        OperationMultipleRoom r12 = r11.operationMultipleRoom;
        if (r12 == null) goto L78;
        List r13 = r12.rooms;
    L79:
        TextView r14 = this.t;
        OperationCard r15 = this.w;
        if (r15 == null) goto L84;
        OperationMultipleRoom r16 = r15.operationMultipleRoom;
        if (r16 == null) goto L84;
        String r17 = r16.columTitle;
    L85:
        r14.setText(r17);
        this.u.setText(2131916625);
        if (r13 == null) goto L88;
        int r18 = r13.size();
    L90:
        if (r18 >= 4) goto L92;
        return;
    L92:
        if (r13 == null) goto L94;
        Room r19 = (Room) ListProtector.get(r13, 0);
    L95:
        this.c = r19;
        this.l.setVisibility(8);
        ViewGroup r1 = this.m;
        if (r1 == null) goto L99;
        r1.setVisibility(0);
    L99:
        if (r13 == null) goto L105;
        Room r20 = (Room) ListProtector.get(r13, 0);
        if (r20 == null) goto L105;
        py.k r21 = r20.getCover();
        if (r21 == null) goto L105;
        List r22 = r21.getUrls();
    L106:
        df6.u r23 = q.c(new ef6.a(r22));
        r23.t = this.n;
        r23.c();
        if (r13 == null) goto L113;
        Room r24 = (Room) ListProtector.get(r13, 1);
        if (r24 == null) goto L113;
        py.k r25 = r24.getCover();
        if (r25 == null) goto L113;
        List r26 = r25.getUrls();
    L114:
        df6.u r27 = q.c(new ef6.a(r26));
        r27.t = this.o;
        r27.c();
        if (r13 == null) goto L121;
        Room r28 = (Room) ListProtector.get(r13, 2);
        if (r28 == null) goto L121;
        py.k r29 = r28.getCover();
        if (r29 == null) goto L121;
        List r30 = r29.getUrls();
    L122:
        df6.u r31 = q.c(new ef6.a(r30));
        r31.t = this.p;
        r31.c();
        if (r13 == null) goto L129;
        Room r32 = (Room) ListProtector.get(r13, 3);
        if (r32 == null) goto L129;
        py.k r33 = r32.getCover();
        if (r33 == null) goto L129;
        r10 = r33.getUrls();
    L129:
        df6.u r34 = q.c(new ef6.a(r10));
        r34.t = this.q;
        r34.c();
        this.m.setOnClickListener(new c(this, this.f.getContext()));
        Room r35 = k.n(IRoomService.class).getCurrentRoomFromRoomContext();
        if (r35 == null) goto L134;
        if (r35.withAggregateColumn != true) goto L134;
        Y3();
    L121:
        r30 = null;
    L113:
        r26 = null;
    L105:
        r22 = null;
        goto L106
    L94:
        r19 = null;
        goto L95
    L88:
        r18 = -1;
    L84:
        r17 = null;
    L78:
        r13 = null;
        goto L79
    L68:
        r7 = null;
        goto L69
    L22:
        if (r5.intValue() != 2) goto L65;
        OperationCard r36 = r8.operationCard;
        if (r36 == null) goto L28;
        OperationSingleRoom r37 = r36.operationSingleRoom;
        if (r37 == null) goto L28;
        Room r38 = r37.room;
    L29:
        this.c = r38;
        TextView r39 = this.t;
        if (r36 == null) goto L35;
        OperationSingleRoom r40 = r36.operationSingleRoom;
        if (r40 == null) goto L35;
        String r41 = r40.title;
        if (r41 == null) goto L35;
    L38:
        r39.setText(r41);
        TextView r42 = this.u;
        StringBuilder r43 = new StringBuilder("@");
        Room r44 = this.c;
        if (r44 == null) goto L43;
        User r45 = r44.getOwner();
        if (r45 == null) goto L43;
        String r46 = r45.getRemarkNameOrRealNickName();
    L44:
        r43.append(r46);
        r42.setText(r43.toString());
        Room r47 = this.c;
        if (r47 == null) goto L49;
        py.k r48 = r47.getCover();
        if (r48 == null) goto L49;
        r10 = r48.getUrls();
    L49:
        df6.u r49 = q.c(new ef6.a(r10));
        r49.t = this.l;
        r49.c();
        this.l.setOnClickListener(new b(this));
        this.l.setVisibility(0);
        ViewGroup r50 = this.m;
        if (r50 == null) goto L52;
        r50.setVisibility(8);
    L52:
        Room r51 = k.n(IRoomService.class).getCurrentRoomFromRoomContext();
        if (r51 == null) goto L55;
        long r52 = r51.id;
    L56:
        Room r53 = this.c;
        if (r53 == null) goto L134;
        if (r52 != r53.id) goto L134;
        Room r54 = k.n(IRoomService.class).getCurrentRoomFromRoomContext();
        if (r54 == null) goto L134;
        if (r54.withAggregateColumn == true) goto L134;
        Y3();
        goto L134
    L55:
        r52 = 0;
    L43:
        r46 = null;
    L35:
        if (r38 == null) goto L37;
        r41 = r38.getTitle();
        goto L38
    L37:
        r41 = null;
    L28:
        r38 = null;
        goto L29
    L17:
        r5 = null;
        goto L19
    L5:
        r0 = null;
        goto L6
    }

    public OperationSingleDrawViewHolder(View r2, SingleDrawFeedAdapter r3, RecyclerView r4, TabListModel r5) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        super(r2, r3, r4, r5);
        this.j = "drawer_operation_card";
        this.l = r2.findViewById(2131386627);
        this.m = (ViewGroup) r2.findViewById(2131386629);
        this.n = r2.findViewById(2131386631);
        this.o = r2.findViewById(2131386632);
        this.p = r2.findViewById(2131386633);
        this.q = r2.findViewById(2131386634);
        this.r = (FrameLayout) r2.findViewById(2131386630);
        this.s = r2.findViewById(2131386635);
        this.t = (TextView) r2.findViewById(2131386626);
        this.u = (TextView) r2.findViewById(2131386636);
    }
}
