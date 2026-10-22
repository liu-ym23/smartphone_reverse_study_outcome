package com.bytedance.android.live.componentsmarket.impl.components.userlist;

import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.base.model.message.s0;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.room.z;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.room.LiveRoomCacheManager;
import com.bytedance.android.livesdk.message.model.lk;
import com.bytedance.android.livesdk.message.model.mk;
import com.bytedance.android.livesdk.rank.model.CurrentRankListResponse;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import tlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b extends n<IWatchUserListView> implements WeakHandler.IHandler, l {
    public long e;
    public long f;

    public static final class a {
    }

    static {
    }

    public b() {
        new WeakHandler(Looper.getMainLooper(), this);
    }

    public final void detachView() {
        super.detachView();
        new WeakHandler(Looper.getMainLooper(), this);
        this.e = 0;
        this.f = 0;
        ((n) this).d.removeMessageListener(this);
    }

    public final void handleMsg(Message r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        int r0 = r5.what;
        q46.a r1 = ((q46.b) this).a;
        if (r1 != null) goto L6;
        return;
    L6:
        if (r0 != 24) goto L33;
        Object r2 = r5.obj;
        if ((r2 instanceof Exception) == false) goto L15;
        IWatchUserListView r3 = (IWatchUserListView) r1;
        Intrinsics.checkNotNull(r3);
        Object r6 = r5.obj;
        if (r6 == null) goto L13;
        Exception r7 = (Exception) r6;
        r3.ka();
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */");
    L15:
        if ((r2 instanceof BaseResponse) == false) goto L35;
        if (r2 == null) goto L32;
        Object r8 = ((BaseResponse) r2).data;
        if ((r8 instanceof CurrentRankListResponse) == false) goto L36;
        if (r8 == null) goto L30;
        CurrentRankListResponse r9 = (CurrentRankListResponse) r8;
        long r4 = r9.get_total();
        IBroadcastService r11 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r11 == null) goto L23;
        r11.updateGameMsgViewUserCount(Long.valueOf(r4));
    L23:
        IWatchUserListView r12 = (IWatchUserListView) ((q46.b) this).a;
        Intrinsics.checkNotNull(r12);
        r9.get_seats();
        r9.get_ranks();
        r12.v9();
        ALogger.i("updateWatchUser totalCount by interface", String.valueOf(r4));
        if (r9.get_ranks() == null) goto L27;
        List r13 = r9.get_ranks();
        Intrinsics.checkNotNull(r13);
        ALogger.i("updateWatchUser list size by interface", String.valueOf(r13.size()));
    L27:
        if (r9.get_seats() == null) goto L37;
        List r14 = r9.get_seats();
        Intrinsics.checkNotNull(r14);
        ALogger.i("updateWatchUser seats size by interface", String.valueOf(r14.size()));
        return;
    L37:
        return;
    L30:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.rank.model.CurrentRankListResponse");
    L36:
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.network.response.BaseResponse<*, *>");
    L35:
        return;
    }

    public final void onMessage(d r11) {
        Intrinsics.checkNotNullParameter(r11, "message");
        if (((q46.b) this).a != null) goto L5;
        return;
    L5:
        r11.getIntType();
        boolean r0 = r11 instanceof s0;
        if (r0 == false) goto L11;
        if (r0 == true) goto L9;
        r11 = null;
    L9:
        s0 r12 = (s0) r11;
        return;
    L11:
        boolean r1 = r11 instanceof mk;
        if (r1 == true) goto L14;
        boolean r2 = r11 instanceof lk;
        if (r2 == true) goto L43;
        return;
    L43:
        if (((q46.b) this).a == null) goto L77;
        if (r2 == true) goto L46;
        r11 = null;
    L46:
        lk r13 = (lk) r11;
        if (r13 == null) goto L79;
        ArrayList r3 = new ArrayList();
        if (CollectionUtils.isEmpty(r13.getRanks()) == true) goto L55;
        StringBuilder r5 = new StringBuilder("RoomRankMessage : ");
        List r6 = r13.getRanks();
        Intrinsics.checkNotNull(r6);
        r5.append(r6.size());
        ALogger.i("WatchUserPresenter", r5.toString());
        List r4 = r13.getRanks();
        Intrinsics.checkNotNull(r4);
        Iterator r7 = r4.iterator();
        int r8 = 0;
    L53:
        if (r7.hasNext() == false) goto L55;
        lk.b r9 = (lk.b) r7.next();
        com.bytedance.android.livesdk.rank.model.a r14 = new com.bytedance.android.livesdk.rank.model.a();
        r14.d((User) jm2.a.e(r9.getUser()));
        r14.a(r9.getScoreStr());
        r14.b(r9.getProfileHidden());
        r8 = r8 + 1;
        r14.c(r8);
        r3.add(r14);
    L55:
        RoomContext.a r15 = RoomContext.Companion;
        if (RoomContext.a.c(r15, ((n) this).c, 0, 2) == null) goto L62;
        RoomContext r16 = RoomContext.a.c(r15, ((n) this).c, 0, 2);
        if (r16 == null) goto L62;
        com.bytedance.live.datacontext.n r17 = r16.getCurRankMessage();
        if (r17 == null) goto L62;
        r17.setValue(r13);
    L62:
        IRoomService r18 = k.f(IRoomService.class);
        if (r18 == null) goto L70;
        LiveRoomCacheManager r19 = r18.roomCacheManager();
        if (r19 == null) goto L70;
        z r110 = (z) r19.c.get(0L);
        if (r110 == null) goto L70;
        r110.d = r3;
        r110.c = null;
    L70:
        IWatchUserListView r111 = (IWatchUserListView) ((q46.b) this).a;
        Intrinsics.checkNotNull(r111);
        r111.v9();
        return;
    L79:
        return;
    L77:
        return;
    L14:
        if (((q46.b) this).a == null) goto L73;
        if (r1 == true) goto L17;
        r11 = null;
    L17:
        mk r112 = (mk) r11;
        if (r112 == null) goto L78;
        ALogger.i("WatchUserPresenter", "handleNewCountMessage  RoomStatsMessage : " + r112.getDisplayMiddle());
        if (r112.getDisplayVersion() <= this.f) goto L24;
        this.f = r112.getDisplayVersion();
        IWatchUserListView r21 = (IWatchUserListView) ((q46.b) this).a;
        Intrinsics.checkNotNull(r21);
        boolean r22 = r112.is_hidden();
        r112.getDisplayValue();
        r21.e3(r22, r112.getDisplayMiddle(), r112.getDisplayLong(), (int) r112.getDisplayType());
    L31:
        RoomContext.a r23 = RoomContext.Companion;
        if (RoomContext.a.c(r23, null, 0, 3) == null) goto L34;
        RoomContext r24 = RoomContext.a.c(r23, null, 0, 3);
        Intrinsics.checkNotNull(r24);
        r24.getCurStatMessage().setValue(r112);
    L34:
        long r25 = r112.getTotal();
        DataCenter r113 = ((n) this).c;
        if (r113 == null) goto L37;
        r113.put("data_member_count", CastIntegerProtector.valueOf(String.valueOf(r25) + ""));
    L37:
        IBroadcastService r114 = (IBroadcastService) va1.b.a.a.a(IBroadcastService.class);
        if (r114 == null) goto L74;
        r114.updateGameMsgViewUserCount(Long.valueOf(r25));
        return;
    L74:
        return;
    L24:
        if (r112.getDisplayVersion() != this.f) goto L31;
        if (r112.getIncremental() == true) goto L28;
        IWatchUserListView r26 = (IWatchUserListView) ((q46.b) this).a;
        Intrinsics.checkNotNull(r26);
        boolean r27 = r112.is_hidden();
        r112.getDisplayValue();
        r26.e3(r27, r112.getDisplayMiddle(), r112.getDisplayLong(), (int) r112.getDisplayType());
        goto L31
    L28:
        if (r112.getDisplayValue() < this.e) goto L31;
        this.e = r112.getDisplayValue();
        IWatchUserListView r28 = (IWatchUserListView) ((q46.b) this).a;
        Intrinsics.checkNotNull(r28);
        boolean r29 = r112.is_hidden();
        r112.getDisplayValue();
        r28.e3(r29, r112.getDisplayMiddle(), r112.getDisplayLong(), (int) r112.getDisplayType());
        goto L31
    L78:
        return;
    }
}
