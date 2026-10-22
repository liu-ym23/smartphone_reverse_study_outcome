package com.bytedance.android.live.room.navi.userinfo_p.mvi;

import am2.u;
import am2.x;
import am2.y;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ai.api.model.RechargeCurrentCacheData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserExtra;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.CoreSettingUtil;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profit.fansclub.o;
import com.bytedance.android.live.room.api.userinfo.INavigationProxyService;
import com.bytedance.android.live.room.navi.userinfo_p.utils.c;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.model.FollowLog;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.user.LiveFollowScene;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdk.user.j;
import com.bytedance.android.livesdk.utils.b3;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.x1;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.common.utility.Logger;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.m;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gd0.n;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l81.l;
import l81.q;
import m91.d;
import org.json.JSONObject;
import z91.i;
import zg1.k1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/mvi/UserInfoDataSource;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoDataSource implements Observer<KVData> {
    public final String a;
    public final CompositeDisposable b;
    public e c;
    public boolean d;
    public o e;
    public boolean f;
    public c g;
    public final m91.c h;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ UserInfoDataSource a;
        public final /* synthetic */ Context b;

        public a(UserInfoDataSource r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            IFollowPair r6 = (IFollowPair) r5;
            if (r3.l(this.b) == false) goto L5;
            r3.q(this.b, s1.B(2131911614));
        L5:
            UserInfoDataSource r0 = this.a;
            Context r1 = r0.h.getContext();
            String r3 = null;
            if ((r1 instanceof FragmentActivity) == true) goto L8;
            r1 = null;
        L8:
            FragmentActivity r2 = (FragmentActivity) r1;
            INavigationProxyService r4 = (INavigationProxyService) k.f(INavigationProxyService.class);
            if (r4 == null) goto L16;
            l r7 = r4.getLivePushPermissionHelper();
            if (r7 == null) goto L16;
            IRoom r8 = r0.h.getRoom();
            if (r8 == null) goto L15;
            r3 = r8.getOwnerUserIdString();
        L15:
            r7.W(r2, r3);
        L16:
            UserInfoDataSource.a(this.a, r6);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ UserInfoDataSource a;
        public final /* synthetic */ Context b;

        public b(UserInfoDataSource r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            if (this.a.h.a() == false) goto L7;
            ExceptionUtils.handleException(this.b, r3);
            return;
        }
    }

    public UserInfoDataSource(d r2) {
        Intrinsics.checkNotNullParameter(r2, "userInfoAbility");
        this.h = r2;
        this.a = "UserInfoDataSource";
        this.b = new CompositeDisposable();
    }

    public final void b(boolean r22) {
        if (this.h.a() == true) goto L5;
        return;
    L5:
        e r2 = k.n(IMiddlewareUserService.class).user();
        String r4 = "live_detail";
        if (r2.isLogin() == true) goto L9;
        Bundle r0 = new Bundle();
        r0.putString("enter_from", "live_detail");
        r0.putString("action_type", "follow");
        r0.putString("source", "live");
        r0.putString("v1_source", "follow");
        this.f = true;
        Context r1 = this.h.getContext();
        com.bytedance.android.livesdk.user.l.a r7 = new com.bytedance.android.livesdk.user.l.a();
        r7.a = CoreSettingUtil.getLoginPromptForFollow();
        r7.b = CoreSettingUtil.getLoginImageForFollow();
        r7.e = "live_detail";
        r7.g = "follow";
        r7.d = "live";
        r7.c = 1;
        r2.login(r1, new com.bytedance.android.livesdk.user.l(r7)).subscribe(new h());
        return;
    L9:
        FragmentActivity r8 = this.h.getContext();
        if (r8 != null) goto L13;
        return;
    L13:
        if ((r8 instanceof FragmentActivity) == true) goto L15;
        FragmentActivity r3 = null;
    L16:
        FragmentActivity r5 = r3;
        if (r5 == null) goto L19;
        k.n(IMiddlewareHostApp.class).checkAndShowGuide(r5, "live", r8.getResources().getString(2131911631));
    L19:
        IRoom r9 = this.h.getRoom();
        if (r9 != null) goto L22;
        return;
    L22:
        IBaseUser r10 = r9.getOwner();
        if (r10 != null) goto L25;
        return;
    L25:
        if (r22 == false) goto L74;
        c r12 = this.g;
        if (r12 == null) goto L72;
        IRoom r13 = r12.c;
        if (c1.b(r12.b) == false) goto L52;
        if (r13 == null) goto L32;
        IBaseUser r6 = r13.getOwner();
    L33:
        if (r6 == null) goto L52;
        JSONObject r14 = new JSONObject();
        IBaseUser r15 = r13.getOwner();     // Catch: Exception -> L41
        if (r15 == null) goto L38;
        String r16 = r15.getIdString();     // Catch: Exception -> L41
    L39:
        r14.put("anchor_id", String.valueOf(r16));     // Catch: Exception -> L41
        r14.put("room_id", String.valueOf(r13.getId()));     // Catch: Exception -> L41
    L43:
        ILiveDouPlusService r17 = k.n(ILiveDouPlusService.class);
        HashMap r18 = new HashMap();
        r18.put("ad_extra_data", r14.toString());
        Map r19 = c1.e(r12.b);
        if (r19 != null) goto L46;
    L49:
        r17.logEvent(true, "live_ad", "follow", r18);
        goto L52
    L46:
        if (r19.isEmpty() == true) goto L49;
        r18.putAll(r19);
        goto L49
    L38:
        r16 = null;
    L41:
        e = move-exception;
        ALogger.e(r12.a, "logDouPlusOnWannaFollow", e);
        goto L43
    L32:
        r6 = null;
    L52:
        if (c1.c(r12.b) == false) goto L71;
        if (r13 == null) goto L55;
        IBaseUser r20 = r13.getOwner();
    L56:
        if (r20 == null) goto L71;
        JSONObject r23 = new JSONObject();
        IBaseUser r24 = r13.getOwner();     // Catch: Exception -> L64
        if (r24 == null) goto L61;
        String r25 = r24.getIdString();     // Catch: Exception -> L64
    L62:
        r23.put("anchor_id", String.valueOf(r25));     // Catch: Exception -> L64
        r23.put("room_id", String.valueOf(r13.getId()));     // Catch: Exception -> L64
    L66:
        ILiveDouPlusService r26 = k.n(ILiveDouPlusService.class);
        HashMap r27 = new HashMap();
        r27.put("ad_extra_data", r23.toString());
        Map r28 = c1.f(r12.b);
        if (r28.isEmpty() == true) goto L70;
        r27.putAll(r28);
    L70:
        r26.logEvent(true, "live_ad", "follow", r27);
        b3.a(r12.b, r23);
        goto L71
    L61:
        r25 = null;
    L64:
        e = move-exception;
        ALogger.e(r12.a, "logDouPlusOnWannaFollow", e);
        goto L66
    L55:
        r20 = null;
    L71:
        int r29 = x1.a;
    L73:
        com.bytedance.android.livesdk.user.b.a r30 = new com.bytedance.android.livesdk.user.d.c().c(r10.getIdString());
        r9.getRequestId();
        com.bytedance.android.livesdk.user.d.c r32 = r30.e();
        r32.e();
        com.bytedance.android.livesdk.user.d.c r33 = r32.g("live").h(r9.getId());
        r9.getLabels();
        r33.e();
        com.bytedance.android.livesdk.user.d.c r34 = r33.f(j.b(LiveFollowScene.FANS_CLUB_MESSAGE));
        r34.getClass();
        Observable r35 = r2.e(new com.bytedance.android.livesdk.user.d(r34)).observeOn(AndroidSchedulers.mainThread());
        UserInfoDataSource r36 = this;
        RxUtilKt.c(r35.subscribe(new a(r36, r8), new b(r36, r8)), r36.b);
    L75:
        q r37 = ((INavigationProxyService) k.n(INavigationProxyService.class)).getRechargeServiceExternal();
        if (r37 == null) goto L81;
        RechargeCurrentCacheData r38 = r37.getCurrentRechargeCacheDataObject();
        if (r38 == null) goto L81;
        r38.setFollowed(true);
    L81:
        if (r22 == false) goto L152;
        IRoom r39 = r36.h.getRoom();     // Catch: Exception -> L143
        HashMap r40 = new HashMap();     // Catch: Exception -> L143
        r40.put("growth_deepevent", String.valueOf(1));     // Catch: Exception -> L143
        if (((IMiddlewareBroadcastService) va1.b.a.a.a(IMiddlewareBroadcastService.class)).isPlayingGame() == false) goto L87;
        Object r42 = DataType.TRUE;
    L88:
        r40.put("is_gaming", r42);     // Catch: Exception -> L143
        if (r39 == null) goto L91;
        LiveMode r43 = r39.getStreamType();     // Catch: Exception -> L143
    L92:
        int r44 = h1.a;     // Catch: Exception -> L143
        r40.put("live_type", i1.a(r43));     // Catch: Exception -> L143
        r40.putAll(h1.a(r39));     // Catch: Exception -> L143
        if (r39 == null) goto L97;
        if (r39.getAutoCover() != 0) goto L97;
    L104:
        if (((Boolean) b6.X.getValue()).booleanValue() == false) goto L106;
        Object r45 = DataType.TRUE;
    L107:
        r40.put("is_screen_clear", r45);     // Catch: Exception -> L143
        INavigationProxyService r46 = (INavigationProxyService) k.f(INavigationProxyService.class);     // Catch: Exception -> L143
        if (r46 == null) goto L112;
        l81.a r47 = r46.getAudienceGameContext();     // Catch: Exception -> L143
        if (r47 == null) goto L112;
        Long r48 = r47.getCurrentGameId();     // Catch: Exception -> L143
    L113:
        INavigationProxyService r49 = (INavigationProxyService) k.f(INavigationProxyService.class);     // Catch: Exception -> L143
        if (r49 == null) goto L118;
        l81.a r50 = r49.getAudienceGameContext();     // Catch: Exception -> L143
        if (r50 == null) goto L118;
        String r52 = r50.getCurrentGameName();     // Catch: Exception -> L143
    L119:
        if (r48 == null) goto L122;
        if (r52 == null) goto L122;
        r40.put("game_id", String.valueOf(r48.longValue()));     // Catch: Exception -> L143
        r40.put("game_name", r52);     // Catch: Exception -> L143
    L122:
        r40.put("connection_type", k.n(n.class).getLinkConnectionType());     // Catch: Exception -> L143
        l81.h r53 = ((INavigationProxyService) k.n(INavigationProxyService.class)).getLinkServiceExternal();     // Catch: Exception -> L143
        if (r53 == null) goto L126;
        String r54 = r53.getLinkAnchorCount();     // Catch: Exception -> L143
        if (r54 == null) goto L126;
    L127:
        r40.put("anchor_cnt", r54);     // Catch: Exception -> L143
        com.bytedance.android.livesdk.chatroom.o r55 = z51.a.h(r36.h.getDataCenter(), 2);     // Catch: Exception -> L143
        if (r55 == null) goto L137;
        m r56 = r55.isCleanMode();     // Catch: Exception -> L143
        if (r56 != null) goto L132;
    L134:
        boolean r57 = false;
    L135:
        if (r57 == false) goto L137;
        com.bytedance.android.livesdk.chatroom.o r110 = r55;
    L138:
        r40.put("if_clear_mode", DataType.TRUE);     // Catch: Exception -> L143
        if (r110 != null) goto L141;
        r40.put("if_clear_mode", DataType.FALSE);     // Catch: Exception -> L143
        Unit r58 = Unit.INSTANCE;     // Catch: Exception -> L143
    L141:
        j0 r59 = j0.l();     // Catch: Exception -> L143
        x r60 = new x();     // Catch: Exception -> L143
        r60.a = "live_interact";     // Catch: Exception -> L143
        r60.b = r4;     // Catch: Exception -> L143
        r59.sendLog("livesdk_follow", r40, new Object[]{u.class, new FollowLog("live", r10.getIdString(), 1), r60, IRoom.class, y.class, am2.n.f(), am2.q.class});     // Catch: Exception -> L143
        return;
    L132:
        if (((Boolean) r56.getValue()).booleanValue() != true) goto L134;
        r57 = true;
    L137:
        r110 = null;
    L126:
        r54 = "";
    L118:
        r52 = null;
    L112:
        r48 = null;
        goto L113
    L106:
        r45 = DataType.FALSE;
    L97:
        if (r39 != null) goto L99;
    L101:
        String r62 = "other";
    L102:
        r40.put("cover_type", r62);     // Catch: Exception -> L143
        goto L104
    L99:
        if (r39.getAutoCover() != 1) goto L101;
        r62 = "autocover";
        goto L102
    L91:
        r43 = null;
        goto L92
    L87:
        r42 = DataType.FALSE;
    L143:
        e = move-exception;
        Logger.e(r36.a, e.toString());
        return;
    L152:
        return;
    L72:
        r4 = "live_detail";
        goto L73
    L74:
        r36 = this;
        r4 = "live_detail";
        goto L75
    L15:
        r3 = r8;
        goto L16
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (this.h.a() == false) goto L41;
        if (r5 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r5.getKey()) == true) goto L50;
        String r0 = r5.getKey();
        if (r0.hashCode() == 506917167) goto L12;
        return;
    L12:
        if (r0.equals("data_login_event") == false) goto L43;
        k1 r6 = (k1) r5.getData();
        if (r6 == null) goto L52;
        IRoom r1 = this.h.getRoom();
        if (r1 == null) goto L53;
        DataCenter r2 = this.h.getDataCenter();
        if (r2 != null) goto L23;
        return;
    L23:
        if (r6.a == false) goto L44;
        l81.u r7 = ((INavigationProxyService) k.n(INavigationProxyService.class)).getUserService();
        if (r7 == null) goto L45;
        IBaseUser r3 = r1.getOwner();
        if (r3 == null) goto L30;
        String r8 = r3.getIdString();
        if (r8 == null) goto L30;
    L31:
        Single<BaseResponse<IBaseUser, UserExtra>> r9 = r7.r(r8);
        if (r9 == null) goto L46;
        Single r10 = r9.observeOn(AndroidSchedulers.mainThread());
        if (r10 == null) goto L47;
        Single r12 = r10.map(i.a);
        if (r12 == null) goto L48;
        Disposable r13 = r12.subscribe(new z91.j(this, r2), z91.k.a);
        if (r13 == null) goto L49;
        RxUtilKt.c(r13, this.b);
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L30:
        r8 = DataType.FALSE;
        goto L31
    L45:
        return;
    L44:
        return;
    L53:
        return;
    L52:
        return;
    L43:
        return;
    L50:
        return;
    }

    public static final void a(UserInfoDataSource r6, IFollowPair r7) {
        if (r6.h.a() == false) goto L23;
        if (r7 == null) goto L26;
        IRoom r0 = r6.h.getRoom();
        if (r0 == null) goto L27;
        DataCenter r1 = r6.h.getDataCenter();
        aa1.a r2 = r6.h.b();
        IBaseUser r3 = r0.getOwner();
        if (r3 == null) goto L13;
        r3.setFollowStatus(r7.getFollowStatus());
    L13:
        if (r7.getFollowStatus() == 0) goto L15;
        boolean r4 = true;
    L16:
        r1.put("data_is_followed", Boolean.valueOf(r4));
        if (r7.getFollowStatus() != 0) goto L20;
        r2.getMiddleVm().sendAction(new z91.c());
        r6.d = false;
        return;
    L20:
        if (r6.d == true) goto L25;
        r2.getMiddleVm().sendAction(new z91.d());
        r6.d = true;
        return;
    L25:
        return;
    L15:
        r4 = false;
        goto L16
    L27:
        return;
    L26:
        return;
    }
}
