package com.bytedance.android.live.profile.usecase;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.c0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.NewProfileInfoViewModel;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.interactivity.service.model.ICommunityMainRoom;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.x1;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdk.widget.z0;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomGameDataChannelConfig;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f implements ut0.b {
    public boolean a;
    public boolean b;
    public final MutableLiveData<Integer> c;
    public final com.bytedance.android.live.profile.usecase.a d;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ f a;
        public final /* synthetic */ NewProfileUser b;
        public final /* synthetic */ DataCenter c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ ps0.b e;
        public final /* synthetic */ String f;
        public final /* synthetic */ NewProfileUser g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ IRoom j;

        public b(f r1, NewProfileUser r2, DataCenter r3, Context r4, ps0.b r5, String r6, NewProfileUser r7, String r8, String r9, IRoom r10, String r12) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r10, int r12) {
            boolean r13 = com.bytedance.android.live.revenue.core.util.h.a;
            RechargeCurrentCacheData r14 = ((com.bytedance.android.live.recharge.k) com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.recharge.k.class)).getCurrentRechargeCacheDataObject();
            boolean r0 = false;
            if (r14 == null) goto L5;
            r14.setFollowed(false);
        L5:
            r10.dismiss();
            if (this.b.followInfo != null) goto L8;
            return;
        L8:
            DataCenter r15 = this.c;
            if (r15 == null) goto L29;
            NewProfileTrackUseCase r1 = this.a.d.getLogUseCase();
            Context r2 = this.d;
            ps0.b r3 = this.e;
            String r4 = this.f;
            r1.getClass();
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r15, "mDataCenter");
            Intrinsics.checkNotNullParameter(r3, "room");
            Intrinsics.checkNotNullParameter(r4, "userId");
            if ((!Intrinsics.areEqual(r4, r3.getOwnerUserIdStr())) == true) goto L29;
            if (c1.b(r15) == false) goto L22;
            JSONObject r5 = new JSONObject();
            r5.put("anchor_id", r3.getOwnerUserIdStr().toString());     // Catch: JSONException -> L18
            r5.put("room_id", r3.getId());     // Catch: JSONException -> L18
        L20:
            ILiveDouPlusService r7 = jc1.k.n(ILiveDouPlusService.class);
            os0.c r8 = new os0.c();
            r8.a(r5);
            r8.b(c1.e(r15));
            r7.logEvent(true, "live_ad", "follow_cancel", r8.a);
        L18:
            e = move-exception;
            e.printStackTrace();
        L22:
            if (c1.c(r15) == false) goto L29;
            JSONObject r6 = new JSONObject();
            r6.put("anchor_id", r3.getOwnerUserIdStr().toString());     // Catch: JSONException -> L26
            r6.put("room_id", r3.getId());     // Catch: JSONException -> L26
        L28:
            ILiveDouPlusService r9 = jc1.k.n(ILiveDouPlusService.class);
            os0.c r16 = new os0.c();
            r16.a(r6);
            r16.b(c1.f(r15));
            r9.logEvent(true, "live_ad", "follow_cancel", r16.a);
        L26:
            e = move-exception;
            e.printStackTrace();
        L29:
            NewProfileTrackUseCase r17 = this.a.d.getLogUseCase();
            boolean r18 = !this.g.isFollowing();
            c0 r19 = this.g.followInfo;
            if (r19 != null) goto L32;
        L34:
            r17.w(r18, r0, this.h, this.i);
            f r110 = this.a;
            FragmentActivity r111 = this.d;
            this.b.followInfo.getFollowStatus();
            String r20 = this.f;
            long r22 = this.e.getId();
            r110.getClass();
            if ((r111 instanceof Fragment) == false) goto L37;
            FragmentActivity r23 = ((Fragment) r111).getActivity();
        L39:
            if ((r111 instanceof Activity) == false) goto L41;
            r23 = (Activity) r111;
        L41:
            if (r23 == null) goto L57;
            com.bytedance.android.livesdk.user.m.c r112 = new com.bytedance.android.livesdk.user.m.c().c(r20);
            r112.d();
            com.bytedance.android.livesdk.user.m.c r113 = r112.f(r22);
            UserProfileEvent r24 = r110.d.getUserProfileEvent();
            if (r24 == null) goto L47;
            HashMap r25 = r24.getExtraFollowParams();
            if (r25 == null) goto L47;
        L48:
            com.bytedance.android.livesdk.user.m.c r114 = r113.e(r25);
            r114.getClass();
            Disposable r115 = jc1.k.n(IMiddlewareUserService.class).user().A(new com.bytedance.android.livesdk.user.m(r114)).subscribe(new j(r110), k.a);
            if (r115 == null) goto L56;
            r r116 = r110.d.getNewProfileRequestManager();
            r116.getClass();
            Intrinsics.checkNotNullParameter(r115, "disposable");
            r116.a.add(r115);
            return;
        L56:
            return;
        L47:
            r25 = com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_DEFAULT);
            goto L48
        L57:
            return;
        L37:
            r23 = null;
            goto L39
        L32:
            if (r19.getFollowStatus() != 3) goto L34;
            r0 = true;
            goto L34
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            r1.dismiss();
        }
    }

    static {
    }

    @Override // ut0.b
    public final MutableLiveData b() {
        return this.c;
    }

    public f(com.bytedance.android.live.profile.usecase.a r2) {
        Intrinsics.checkNotNullParameter(r2, "profileViewModel");
        this.d = r2;
        this.c = new MutableLiveData();
    }

    @Override // ut0.b
    public final void a(int r2) {
        if (r2 == 0) goto L4;
    L6:
        this.d.getTargetUser().setFollowStatus(r2);
        if (this.d.loadUserSuccess() == false) goto L10;
        this.c.postValue(Integer.valueOf(r2));
        return;
    L10:
        return;
    L4:
        if (this.b == false) goto L6;
        r2 = 3;
        goto L6
    }

    @Override // ut0.b
    public final void c(boolean r3) {
        ALogger.i(NewProfileInfoViewModel.TAG, "init_user_follow_back=" + r3);
        this.b = r3;
    }

    @Override // ut0.b
    public final void d(Context r17, String r18, String r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "clickPosition");
        Intrinsics.checkNotNullParameter(r19, "mFromSource");
        NewProfileUser r8 = this.d.getTargetUser();
        q r2 = this.d.getPageTypeUseCase();
        ps0.b r6 = this.d.getRoom();
        String r7 = this.d.getTargetUser().baseProfileInfo.getIdStr();
        DataCenter r4 = this.d.getRoomDataCenter();
        IRoom r12 = this.d.getLiveRoom();
        if (r2.c == false) goto L7;
        String r3 = "live_anchor_c_audience";
    L5:
        String r13 = r3;
        if (r8.isFollowing() == true) goto L123;
        if (r4 == null) goto L45;
        this.d.getLogUseCase().getClass();
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r4, "mDataCenter");
        Intrinsics.checkNotNullParameter(r6, "room");
        Intrinsics.checkNotNullParameter(r7, "userId");
        if ((!Intrinsics.areEqual(r7, r6.getOwnerUserIdStr())) == true) goto L45;
        if (c1.b(r4) == false) goto L32;
        JSONObject r5 = new JSONObject();
        r5.put("anchor_id", r6.getOwnerUserIdStr().toString());     // Catch: JSONException -> L28
        r5.put("room_id", r6.getId());     // Catch: JSONException -> L28
    L30:
        os0.b.c().getLiveRoomEventParamUtils().handleLiveAdExtraData(r5);
        ILiveDouPlusService r0 = jc1.k.n(ILiveDouPlusService.class);
        os0.c r14 = new os0.c();
        r14.a(r5);
        r14.b(c1.e(r4));
        r0.logEvent(true, "live_ad", "follow", r14.a);
    L28:
        e = move-exception;
        e.printStackTrace();
    L32:
        if (c1.c(r4) == false) goto L43;
        JSONObject r9 = new JSONObject();
        IBaseUser r1 = r6.getOwner();     // Catch: JSONException -> L40
        if (r1 == null) goto L37;
        String r10 = r1.getIdString();     // Catch: JSONException -> L40
    L38:
        r9.put("anchor_id", r10);     // Catch: JSONException -> L40
        r9.put("room_id", String.valueOf(r6.getId()));     // Catch: JSONException -> L40
    L42:
        os0.b.c().getLiveRoomEventParamUtils().handleLiveAdExtraData(r9);
        ILiveDouPlusService r15 = jc1.k.n(ILiveDouPlusService.class);
        os0.c r16 = new os0.c();
        r16.a(r9);
        r16.b(c1.f(r4));
        boolean r20 = true;
        r15.logEvent(true, "live_ad", "follow", r16.a);
    L44:
        int r22 = x1.a;
    L46:
        NewProfileTrackUseCase r23 = this.d.getLogUseCase();
        boolean r24 = r8.isFollowing() ^ r20;
        c0 r25 = r8.followInfo;
        if (r25 != null) goto L49;
    L51:
        boolean r26 = false;
    L52:
        r23.w(r24, r26, r19, r18);
        NewProfileTrackUseCase r27 = this.d.getLogUseCase();
        r27.getClass();
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L109
        IRoom r29 = r27.g.getRoom().b();     // Catch: Throwable -> L109
        if ((r29 instanceof IRoom) == true) goto L56;
        IRoom r30 = null;
    L57:
        IRoom r32 = r30;     // Catch: Throwable -> L109
        if (r32 == null) goto L111;
        ICommunityMainRoom r33 = r32.castTo(ICommunityMainRoom.class);     // Catch: Throwable -> L109
        if (r33 == null) goto L111;
        IRoomGameData r34 = r33.getRoomGameData();     // Catch: Throwable -> L109
        if (r34 == null) goto L111;
        IRoomGameDataChannelConfig r35 = r34.getRoomGameDataChannelConfig();     // Catch: Throwable -> L109
        if (r35 == null) goto L111;
        String r36 = r35.getGameId();     // Catch: Throwable -> L109
        if (r36 != null) goto L69;
    L72:
        boolean r37 = true;
    L73:
        if (r37 == true) goto L111;
        String r38 = r35.getFusionTagId();     // Catch: Throwable -> L109
        if (r38 != null) goto L77;
    L80:
        boolean r39 = true;
    L81:
        if (r39 == true) goto L111;
        if ((!Intrinsics.areEqual(r27.g.getTargetUser().baseProfileInfo.getIdStr(), r32.getAnchorId())) == true) goto L111;
        HashMap r40 = new HashMap();     // Catch: Throwable -> L109
        String r42 = r35.getGameId();     // Catch: Throwable -> L109
        String r43 = "";
        if (r42 != null) goto L90;
        r42 = "";
    L90:
        r40.put("game_id", r42);     // Catch: Throwable -> L109
        r40.put("action_type", "follow");     // Catch: Throwable -> L109
        String r44 = am2.n.f().c();     // Catch: Throwable -> L109
        if (r44 != null) goto L94;
    L99:
        String r45 = DataType.FALSE;
    L100:
        r40.put("is_ads", r45);     // Catch: Throwable -> L109
        String r46 = r32.getAnchorId();     // Catch: Throwable -> L109
        if (r46 != null) goto L103;
        r46 = "";
    L103:
        r40.put("host_id", r46);     // Catch: Throwable -> L109
        r40.put("content_id", String.valueOf(r32.getId()));     // Catch: Throwable -> L109
        r40.put("scene", DataType.FALSE);     // Catch: Throwable -> L109
        String r47 = r32.getRequestId();     // Catch: Throwable -> L109
        if (r47 == null) goto L107;
        r43 = r47;
    L107:
        r40.put(Constants.Keys.REQ_ID, r43);     // Catch: Throwable -> L109
        os0.b.c().getIHostGameCP().a(r40);     // Catch: Throwable -> L109
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L109
        goto L111
    L94:
        if (r44.length() != 0) goto L96;
        boolean r110 = true;
    L97:
        if (r110 == true) goto L99;
        r45 = DataType.TRUE;
        goto L100
    L96:
        r110 = false;
        goto L97
    L77:
        if (r38.length() == 0) goto L80;
        r39 = false;
        goto L81
    L69:
        if (r36.length() == 0) goto L72;
        r37 = false;
    L111:
        r6.getRequestId();
        long r48 = r6.getId();
        r6.getLabels();
        if (this.a == true) goto L135;
        this.a = true;
        com.bytedance.android.livesdk.user.b.c r49 = new com.bytedance.android.livesdk.user.b.c().c(r7).e();
        r49.e();
        com.bytedance.android.livesdk.user.b.c r50 = r49.g(r13).h(r48);
        r50.e();
        UserProfileEvent r52 = this.d.getUserProfileEvent();
        if (r52 == null) goto L118;
        HashMap r53 = r52.getExtraFollowParams();
        if (r53 == null) goto L118;
    L119:
        com.bytedance.android.livesdk.user.b.c r54 = r50.f(r53);
        r54.getClass();
        Disposable r55 = jc1.k.n(IMiddlewareUserService.class).user().B(new com.bytedance.android.livesdk.user.b(r54)).subscribe(new g(this), new h(this), new i(this));
        if (r55 == null) goto L133;
        r r56 = this.d.getNewProfileRequestManager();
        r56.getClass();
        Intrinsics.checkNotNullParameter(r55, "disposable");
        r56.a.add(r55);
        return;
    L133:
        return;
    L118:
        r53 = com.bytedance.android.livesdk.user.j.b(LiveFollowScene.PROFILE_DEFAULT);
        goto L119
    L135:
        return;
    L56:
        r30 = r29;
    L109:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L111
    L49:
        if (r25.getFollowStatus() != 3) goto L51;
        r26 = true;
        goto L52
    L37:
        r10 = null;
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L43:
        r20 = true;
    L45:
        r20 = true;
        goto L46
    L123:
        if (Intrinsics.areEqual("anchor_recommend", r18) == false) goto L125;
        return;
    L125:
        z0.a().getClass();
        x0.b r111 = z0.b(r17);
        r111.l(2131919781);
        r111.i(0, 2131920806, new b(this, r8, r4, r17, r6, r7, r8, r19, r18, r12, r13));
        r111.i(1, 2131915442, c.a);
        r111.n();
        return;
    L7:
        if (r2.b == false) goto L10;
        r3 = "live_audience_c_anchor";
        goto L5
    L10:
        if (r2.d == false) goto L13;
        r3 = "right_anchor";
        goto L5
    L13:
        if (r2.e == false) goto L15;
        r3 = "link_room_fight";
        goto L5
    L15:
        r3 = "live_audience_c_audience";
        goto L5
    }
}
