package com.bytedance.android.live.profile;

import android.os.SystemClock;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profile.api.service.ILiveProfileProxyService;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.profile.monitor.EndType;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.monitor.TimeType;
import com.bytedance.android.live.profile.p000enum.ProfileMode;
import com.bytedance.android.live.profile.repository.NewProfileApi;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.v;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IOfficialChannelInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rs0.k0;
import rs0.s;
import rs0.u0;
import rs0.v0;
import zg1.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class NewProfileDialogLauncher {
    public static final /* synthetic */ int f = 0;
    public boolean a;
    public boolean b;
    public LiveDialogFragment c;
    public long d;
    public final Function13<ProfileMonitor, FragmentActivity, IRoom, DataCenter, Boolean, IBaseUser, Integer, String, UserProfileEvent, ProfileMode, Long, Function3<? super ProfileMode, ? super com.bytedance.android.live.profile.seeselftransition.b, ? super FragmentManager, Unit>, Function1<? super ProfileMode, Unit>, Consumer<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>>> e;

    public static final class a {
    }

    static {
    }

    public final void b() {
        ALogger.i("NewProfileDialogLauncher", "livesdk_new_profile_dismiss");
        this.b = true;
        if (c() == false) goto L12;
        LiveDialogFragment r0 = this.c;
        if (r0 == null) goto L12;
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L8
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L12;
        com.bytedance.crash.d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L12:
        e(null);
    }

    public final boolean c() {
        LiveDialogFragment r0 = this.c;
        if (r0 == null) goto L7;
        if (r0.isShowing() != true) goto L7;
        return true;
    L7:
        if (this.a == true) goto L12;
        return false;
    L12:
        return true;
    }

    public NewProfileDialogLauncher() {
        this.e = new NewProfileDialogLauncher$success$1(this);
    }

    public final void e(final LiveDialogFragment r3) {
        this.c = r3;
        if (((Boolean) s.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L10;
        Lifecycle r0 = r3.getLifecycle();
        if (r0 == null) goto L11;
        r0.addObserver(new NewProfileDialogLauncher$mNewLiveProfileDialog$1(this, r3));
        return;
    L11:
        return;
    }

    public static final void a(NewProfileDialogLauncher r4, int r5, long r6) {
        r4.getClass();
        long r0 = SystemClock.uptimeMillis();
        LiveMonitor.a r7 = new LiveMonitor.a("ttlive_request_new_profile_time", LiveTracingMonitor.EventModule.common);
        r7.j(r0 - r6);
        r7.l(r5);
        r7.c("live");
        r7.a().report();
    }

    public static void d(long r2, IRoom r4, String r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        long r1 = System.currentTimeMillis() - r2;     // Catch: Throwable -> L11
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L11
        r3.put("api_time_cost", String.valueOf(r1));     // Catch: Throwable -> L11
        r3.put("api_status", r5);     // Catch: Throwable -> L11
        String r6 = String.valueOf(r4.getRoomId());     // Catch: Throwable -> L11
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r3.put("room_id", r6);     // Catch: Throwable -> L11
        r3.put("business_type", "user_profile");     // Catch: Throwable -> L11
        if (((Boolean) v0.a.getValue()).booleanValue() == false) goto L8;
        String r7 = "new";
    L9:
        r3.put("api_version", r7);     // Catch: Throwable -> L11
        j0.l().sendLog("livesdk_room_interface_request_duration", r3, new Object[0]);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L8:
        r7 = "old";
    L11:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final Disposable f(ProfileMonitor r58, FragmentActivity r59, IRoom r60, DataCenter r62, boolean r63, IBaseUser r64, String r65, UserProfileEvent r66, ProfileMode r67, long r68, Function3 r69, Function1 r70, boolean r72) {
        ProfileMonitor r14 = r58;
        IRoom r13 = r60;
        Intrinsics.checkNotNullParameter(r14, "profileMonitor");
        Intrinsics.checkNotNullParameter(r13, "room");
        Intrinsics.checkNotNullParameter(r66, "event");
        Intrinsics.checkNotNullParameter(r67, "requestProfileMode");
        if (this.a == false) goto L6;
        EndType r0 = EndType.NetworkRequesting;
        ProfileMonitor.a r1 = ProfileMonitor.g;
        r14.a(r0, "");
        return null;
    L6:
        if (r59 != null) goto L9;
        EndType r2 = EndType.HostFragmentInfoErr;
        ProfileMonitor.a r3 = ProfileMonitor.g;
        r14.a(r2, "");
        return null;
    L9:
        long r20 = SystemClock.uptimeMillis();
        IBaseUser r4 = r66.user;
        if (r4 != null) goto L12;
        String r5 = r66.getUserIdStr();
    L13:
        if (r5 != null) goto L15;
        r5 = DataType.FALSE;
    L15:
        String r12 = r5;
        IBaseUser r6 = r66.user;
        if (r6 == null) goto L19;
        Intrinsics.checkNotNullParameter(r6, "$this$secUidExt");
        String r7 = r6.getCastSecUid();
        if (r7 == null) goto L19;
    L20:
        this.a = true;
        this.b = false;
        this.d = SystemClock.uptimeMillis();
        ALogger.i("NewProfileDialogLauncher", "livesdk_new_profile_begin_load");
        boolean r32 = r66.isFromOtherIntercomRoom();
        IMiddlewareUserService r8 = k.f(IMiddlewareUserService.class);
        if (r8 == null) goto L26;
        com.bytedance.android.livesdk.user.e r9 = r8.user();
        if (r9 == null) goto L26;
        String r10 = r9.n();
        if (r10 == null) goto L26;
    L27:
        v r15 = os0.b.b(r62);
        long r16 = 0;
        if (Intrinsics.areEqual(r10, r12) == false) goto L55;
        m r17 = r15.h();
        if (r17 == null) goto L55;
        if (((Boolean) r17.getValue()).booleanValue() != true) goto L55;
        m r18 = r15.getProfileStyle();
        if (r18 == null) goto L38;
        Integer r19 = (Integer) r18.getValue();
        if (r19 == null) goto L38;
        int r110 = r19.intValue();
    L39:
        m r22 = r15.g();
        if (r22 == null) goto L44;
        Long r23 = (Long) r22.getValue();
        if (r23 == null) goto L44;
        long r24 = r23.longValue();
    L45:
        m r25 = r15.a();
        if (r25 == null) goto L50;
        Long r26 = (Long) r25.getValue();
        if (r26 == null) goto L50;
        long r27 = r26.longValue();
    L51:
        m r28 = r15.h();
        if (r28 == null) goto L54;
        r28.setValue(Boolean.FALSE);
    L54:
        int r35 = r110;
        long r33 = 1;
        long r37 = r24;
        long r39 = r27;
    L56:
        long r53 = System.currentTimeMillis();
        qs0.e r29 = os0.b.c().getIHostCommerceServiceLive();
        if (r29 == null) goto L59;
        JSONObject r30 = r29.i();
    L60:
        if (r30 != null) goto L62;
        String r34 = "";
        String r210 = r34;
        boolean r36 = false;
    L129:
        r14.d(DataType.IsRefreshRequest, Boolean.valueOf(r72));
        r14.i(TimeType.RequestStart);
        int r211 = com.bytedance.android.live.profile.mysteriousman.a.a(r66);
        r14.d(DataType.TargetDisplayRoleRequest, Integer.valueOf(r211));
        int r38 = gv1.a.a;
        if (((Number) ev1.e.a.getValue()).intValue() <= 0) goto L132;
        boolean r40 = true;
    L133:
        if (r40 == false) goto L135;
        long r46 = 1;
    L137:
        if (b.a == true) goto L139;
    L143:
        boolean r111 = false;
    L145:
        if (vt0.h.b(r10) == false) goto L147;
        long r52 = 2;
    L149:
        if (((Boolean) u0.a.getValue()).booleanValue() == false) goto L169;
        Intrinsics.checkNotNullParameter(r12, "targetUserId");
        Intrinsics.checkNotNullParameter(r13, "room");
        qs0.s r42 = ((ILiveProfileProxyService) k.n(ILiveProfileProxyService.class)).getIMicRoomService();
        if (r42 == null) goto L156;
        if (r42.isMicRoom(r13) != true) goto L156;
        boolean r43 = true;
    L157:
        if (r43 == true) goto L159;
        boolean r44 = false;
    L166:
        if (r44 == false) goto L169;
        long r212 = 3;
    L170:
        u r45 = r66.mCommentReportModel;
        if (r45 == null) goto L173;
        r16 = r45.a();
    L173:
        long r310 = r16;
        String r47 = r66.mClickUserPosition;
        Intrinsics.checkNotNullParameter(r14, "profileMonitor");
        Intrinsics.checkNotNullParameter(r12, "userId");
        Intrinsics.checkNotNullParameter(r13, "room");
        Intrinsics.checkNotNullParameter(r34, "productIds");
        if (r7 != null) goto L176;
    L177:
        r36 = true;
    L178:
        if (r36 == false) goto L187;
        IMiddlewareUserService r48 = k.f(IMiddlewareUserService.class);
        if (r48 == null) goto L186;
        com.bytedance.android.livesdk.user.e r49 = r48.user();
        if (r49 == null) goto L186;
        r7 = r49.a(r12);
        if (r7 != null) goto L187;
    L186:
        r7 = r210;
    L187:
        IBaseUser r50 = r60.getOwner();
        if (r50 == null) goto L190;
        String r54 = r50.getIdString();
    L191:
        IMiddlewareUserService r55 = k.f(IMiddlewareUserService.class);
        if (r55 == null) goto L199;
        com.bytedance.android.livesdk.user.e r56 = r55.user();
        if (r56 == null) goto L199;
        String r57 = r56.a(r54);
        if (r57 == null) goto L199;
        r210 = r57;
    L199:
        IMiddlewareUserService r73 = k.f(IMiddlewareUserService.class);
        if (r73 == null) goto L204;
        com.bytedance.android.livesdk.user.e r74 = r73.user();
        if (r74 == null) goto L204;
        String r75 = r74.n();
    L205:
        Long r76 = (Long) k0.a.getValue();
        r14.d(DataType.OptimizeIdentity, r76);
        r14.d(DataType.IsMyLive, Boolean.valueOf(r111));
        if (ys0.c.a() == false) goto L211;
        ys0.a r77 = (ys0.a) ys0.b.a.getValue();
        NewProfileApi r78 = (NewProfileApi) os0.b.c().getTestHttpClientService(NewProfileApi.class);
        if (r78 == null) goto L226;
        Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> r79 = r78.mockQuery(r77.b(), r77.a());
    L227:
        if (r79 == null) goto L233;
        Single r80 = r79.subscribeOn(Schedulers.io());
        if (r80 == null) goto L233;
        Single r112 = r80.observeOn(AndroidSchedulers.mainThread());
        if (r112 == null) goto L233;
        return r112.subscribe(new g(this, r66, r58, r53, r60, r20, r70, r67, r72, r12, r62, r63, r59, r64, r65, r111, r69), new h(this, r58, r72, r53, r60, r20, r12, r70, r67));
    L233:
        return null;
    L226:
        r79 = null;
        goto L227
    L211:
        if (vt0.h.b(r12) == false) goto L213;
        long r213 = 2;
    L214:
        LinkedHashMap r82 = new LinkedHashMap();
        if (r54 == null) goto L217;
        r82.put("anchor_open_id", r54);
    L217:
        if (r75 == null) goto L219;
        r82.put("user_open_id", r12);
    L219:
        if (r111 == false) goto L223;
        NewProfileApi r214 = (NewProfileApi) com.bytedance.android.live.network.c.b().e(NewProfileApi.class);
        if (r214 == null) goto L226;
        int r311 = r32 ? 1 : 0;
        r79 = r214.queryMyLiveProfile(r7, r210, r60.getId(), r213, r211, r310, r311, r33, r35, "", r37, r39, r68, r34, r76.longValue(), r46, r47, r82, r111);
        goto L227
    L223:
        NewProfileApi r215 = (NewProfileApi) com.bytedance.android.live.network.c.b().e(NewProfileApi.class);
        if (r215 == null) goto L226;
        int r312 = r32 ? 1 : 0;
        r79 = r215.queryOpenProfile(r7, r210, r60.getId(), r213, r211, r310, r312, r33, r35, "", r37, r39, r68, r34, r76.longValue(), r46, r47, r82, r111, r52);
        goto L227
    L213:
        r213 = r212;
    L204:
        r75 = null;
        goto L205
    L190:
        r54 = null;
        goto L191
    L176:
        if (r7.length() != 0) goto L178;
    L159:
        IOfficialChannelInfo r83 = r60.getOfficialChannelInfo();
        if (r83 == null) goto L164;
        IBaseUser r84 = r83.getChannelUser();
        if (r84 == null) goto L164;
        String r85 = r84.getIdString();
    L165:
        r44 = Intrinsics.areEqual(r12, r85);
    L164:
        r85 = null;
    L156:
        r43 = false;
    L169:
        r212 = 0;
        goto L170
    L147:
        r52 = 0;
        goto L149
    L139:
        if (Intrinsics.areEqual(r10, r12) == false) goto L143;
        if ((!Intrinsics.areEqual(r10, r60.getOwnerUserIdString())) == false) goto L143;
        r111 = true;
        goto L145
    L135:
        r46 = 0;
        goto L137
    L132:
        r40 = false;
        goto L133
    L62:
        Object r86 = r30.opt("live_click_products");
        if ((r86 instanceof ArrayList) == true) goto L65;
        r86 = null;
    L65:
        ArrayList r87 = (ArrayList) r86;
        String r113 = r30.optString("live_explain_product");
        Object r88 = r30.opt("live_show_products");
        if ((r88 instanceof ArrayList) == true) goto L68;
        r88 = null;
    L68:
        ArrayList r89 = (ArrayList) r88;
        ArrayList r90 = new ArrayList();
        if (r87 != null) goto L71;
        r210 = "";
    L91:
        if (r113.length() <= 0) goto L93;
        boolean r92 = true;
    L94:
        if (r92 == false) goto L96;
        r90.add(r113);
    L96:
        if (r89 != null) goto L98;
        r36 = false;
    L117:
        Intrinsics.checkNotNullParameter(r90, "$this$toStringStrip");
        Iterator r93 = r90.iterator();
        if (r93.hasNext() == true) goto L120;
        r34 = r210;
        r14 = r14;
    L127:
        if (r34 != null) goto L129;
        r34 = r210;
        goto L129
    L120:
        StringBuilder r94 = new StringBuilder();
        ProfileMonitor r114 = r14;
    L121:
        Object r95 = r93.next();
        if (r95 != r90) goto L124;
        r95 = "(this Collection)";
    L124:
        r94.append(r95);
        if (r93.hasNext() == false) goto L126;
        r94.append(',');
        r114 = r58;
        r13 = r60;
        goto L121
    L126:
        r34 = r94.toString();
        r14 = r114;
        goto L127
    L98:
        if (r89.size() <= 0) goto L102;
        r36 = false;
        if ((ListProtector.get(r89, 0) instanceof String) == false) goto L103;
        boolean r96 = true;
    L104:
        if (r96 == true) goto L107;
        r89 = null;
    L107:
        if (r89 == null) goto L117;
        Iterator r97 = r89.iterator();
    L110:
        if (r97.hasNext() == false) goto L117;
        Object r98 = r97.next();
        if (r98 == null) goto L115;
        r90.add((String) r98);
        goto L110
    L115:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L103:
        r96 = false;
        goto L104
    L102:
        r36 = false;
        goto L103
    L93:
        r92 = false;
        goto L94
    L71:
        if (r87.size() <= 0) goto L75;
        r210 = "";
        if ((ListProtector.get(r87, 0) instanceof String) == false) goto L76;
        boolean r99 = true;
    L77:
        if (r99 == true) goto L80;
        r87 = null;
    L80:
        if (r87 == null) goto L91;
        Iterator r100 = r87.iterator();
    L83:
        if (r100.hasNext() == false) goto L91;
        Object r101 = r100.next();
        if (r101 == null) goto L88;
        r90.add((String) r101);
        goto L83
    L88:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L76:
        r99 = false;
        goto L77
    L75:
        r210 = "";
        goto L76
    L59:
        r30 = null;
    L50:
        r27 = 0;
    L44:
        r24 = 0;
    L38:
        r110 = 0;
    L55:
        r33 = 0;
        r37 = 0;
        r39 = 0;
        r35 = 0;
    L26:
        r10 = "-1";
    L19:
        r7 = r66.secUserId;
        goto L20
    L12:
        r5 = r4.getIdString();
        goto L13
    }

    public static /* synthetic */ Disposable g(NewProfileDialogLauncher r17, ProfileMonitor r18, FragmentActivity r19, IRoom r20, DataCenter r22, boolean r23, IBaseUser r24, String r25, UserProfileEvent r26, ProfileMode r27, long r28, Function3 r29, Function1 r30, int r32) {
        if ((r32 & 512) == 0) goto L5;
        ProfileMode r12 = ProfileMode.NONE;
    L7:
        if ((r32 & 1024) == 0) goto L9;
        long r13 = 0;
    L11:
        if ((r32 & 2048) == 0) goto L13;
        Function3 r14 = null;
    L15:
        if ((r32 & 4096) == 0) goto L17;
        Function1 r15 = null;
    L19:
        return r17.f(r18, r19, r20, r22, r23, r24, r25, r26, r12, r13, r14, r15, false);
    L17:
        r15 = r30;
        goto L19
    L13:
        r14 = r29;
        goto L15
    L9:
        r13 = r28;
        goto L11
    L5:
        r12 = r27;
        goto L7
    }
}
