package com.bytedance.android.live.service.prerequest;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserProfileDataResp;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.profile.NewProfileDialogLauncher;
import com.bytedance.android.live.profile.monitor.ProfileMonitor;
import com.bytedance.android.live.profile.repository.NewProfileApi;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kc0.j;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import rs0.k0;
import rs0.q0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements com.bytedance.android.live.service.prerequest.a {
    public final CompositeDisposable a;
    public final Map<String, BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> b;
    public final Map<String, Boolean> c;
    public final Map<String, Integer> d;
    public h e;
    public final List<String> f;
    public final C0223b g;
    public final o h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.service.prerequest.b$b, reason: collision with other inner class name */
    public static final class C0223b implements kc0.f {
        public final /* synthetic */ b a;

        public C0223b(b r1) {
            this.a = r1;
        }

        public final void a(List<String> r4) {
            Intrinsics.checkNotNullParameter(r4, "userIds");
            this.a.getClass();
            if (b.f() == true) goto L5;
            return;
        L5:
            m r0 = this.a.h.getRoom();
            if (r0 == null) goto L13;
            IRoom r1 = (IRoom) r0.getValue();
            if (r1 == null) goto L13;
            if (r1.isMergeVSRoom() != true) goto L13;
            return;
        L13:
            if (((ss0.d) q0.a.getValue()).c() == false) goto L20;
            ((ArrayList) this.a.f).clear();
            ((ArrayList) this.a.f).addAll(r4);
            Iterator r5 = ((ArrayList) this.a.f).iterator();
        L16:
            if (r5.hasNext() == false) goto L26;
            String r2 = (String) r5.next();
            if (((LinkedHashMap) this.a.b).get(r2) != null) goto L16;
            this.a.g(r2, false);
            ALogger.i("NewUserProfile_ProfilePre", "PreRequestManager onLinkAnchorsChanged, preRequest anchorId : " + r2);
            goto L16
        L26:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;

        public c(b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            BaseResponse r8 = (BaseResponse) r7;
            ALogger.i("NewUserProfile_ProfilePre", "进房预请求mock成功");
            ProfileMonitor.a r9 = ProfileMonitor.g;
            String r0 = this.b;
            IMiddlewareUserService r1 = k.f(IMiddlewareUserService.class);
            String r2 = null;
            if (r1 == null) goto L7;
            com.bytedance.android.livesdk.user.e r3 = r1.user();
            if (r3 == null) goto L7;
            String r4 = r3.n();
        L8:
            String r5 = String.valueOf(r4);
            m r6 = this.a.h.getRoom();
            if (r6 == null) goto L15;
            IRoom r10 = (IRoom) r6.getValue();
            if (r10 == null) goto L15;
            IBaseUser r12 = r10.getOwner();
            if (r12 == null) goto L15;
            r2 = r12.getIdString();
        L15:
            String r13 = String.valueOf(r2);
            m r14 = this.a.h.getRoom();
            if (r14 == null) goto L20;
            IRoom r15 = (IRoom) r14.getValue();
            if (r15 == null) goto L20;
            long r16 = r15.getRoomId();
        L21:
            r9.getClass();
            ProfileMonitor.a.b(r0, r5, r13, r16, "");
            return;
        L20:
            r16 = 0;
        L7:
            r4 = null;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            StringBuilder r0 = new StringBuilder("进房预请求mock失败，error: ");
            if (r4 == null) goto L5;
            String r5 = r4.getMessage();
        L6:
            r0.append(r5);
            ALogger.e("NewUserProfile_ProfilePre", r0.toString());
            return;
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;

        public e(b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            BaseResponse r9 = (BaseResponse) r8;
            ALogger.i("NewUserProfile_ProfilePre", "进房预请求成功: 预请求uid   " + this.b);
            ((HashMap) this.a.b).put(this.b, r9);
            ProfileMonitor.a r0 = ProfileMonitor.g;
            String r1 = this.b;
            IMiddlewareUserService r2 = k.f(IMiddlewareUserService.class);
            String r3 = null;
            if (r2 == null) goto L7;
            com.bytedance.android.livesdk.user.e r4 = r2.user();
            if (r4 == null) goto L7;
            String r5 = r4.n();
        L8:
            String r6 = String.valueOf(r5);
            m r7 = this.a.h.getRoom();
            if (r7 == null) goto L15;
            IRoom r10 = (IRoom) r7.getValue();
            if (r10 == null) goto L15;
            IBaseUser r12 = r10.getOwner();
            if (r12 == null) goto L15;
            r3 = r12.getIdString();
        L15:
            String r13 = String.valueOf(r3);
            m r14 = this.a.h.getRoom();
            if (r14 == null) goto L20;
            IRoom r15 = (IRoom) r14.getValue();
            if (r15 == null) goto L20;
            long r16 = r15.getRoomId();
        L21:
            String r17 = r9.logId;
            if (r17 != null) goto L24;
            r17 = "";
        L24:
            r0.getClass();
            ProfileMonitor.a.b(r1, r6, r13, r16, r17);
            return;
        L20:
            r16 = 0;
        L7:
            r5 = null;
            goto L8
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;

        public f(b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            Throwable r10 = (Throwable) r9;
            StringBuilder r0 = new StringBuilder("PreRequestManager request error: ");
            if (r10 == null) goto L5;
            String r2 = r10.getMessage();
        L6:
            r0.append(r2);
            r0.append(' ');
            ALogger.e("NewUserProfile_ProfilePre", r0.toString());
            ProfileMonitor.a r1 = ProfileMonitor.g;
            String r3 = this.b;
            IMiddlewareUserService r4 = k.f(IMiddlewareUserService.class);
            if (r4 == null) goto L11;
            com.bytedance.android.livesdk.user.e r5 = r4.user();
            if (r5 == null) goto L11;
            String r6 = r5.n();
        L12:
            String r7 = String.valueOf(r6);
            m r8 = this.a.h.getRoom();
            if (r8 == null) goto L19;
            IRoom r12 = (IRoom) r8.getValue();
            if (r12 == null) goto L19;
            IBaseUser r13 = r12.getOwner();
            if (r13 == null) goto L19;
            String r14 = r13.getIdString();
        L20:
            String r15 = String.valueOf(r14);
            m r16 = this.a.h.getRoom();
            if (r16 == null) goto L25;
            IRoom r17 = (IRoom) r16.getValue();
            if (r17 == null) goto L25;
            long r18 = r17.getRoomId();
        L27:
            if ((r10 instanceof CustomApiServerException) == true) goto L29;
            r10 = null;
        L29:
            CustomApiServerException r19 = (CustomApiServerException) r10;
            if (r19 == null) goto L33;
            String r20 = r19.getXTtLogId();
            if (r20 == null) goto L33;
        L34:
            r1.getClass();
            Intrinsics.checkNotNullParameter(r3, "preRequestUid");
            Intrinsics.checkNotNullParameter(r7, "currentId");
            Intrinsics.checkNotNullParameter(r15, "anchorId");
            Intrinsics.checkNotNullParameter(r20, "logId");
            Map r22 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("pre_uid", String.valueOf(r3)), TuplesKt.to("current_id", r7), TuplesKt.to("anchor_id", r15), TuplesKt.to("room_id", String.valueOf(r18)), TuplesKt.to("log_id", r20)});
            ProfileMonitor.a.a(r22);
            j0.l().sendLog("livesdk_profile_pre_request_fail", r22, new Object[0]);
            return;
        L33:
            r20 = "";
        L25:
            r18 = 0;
        L19:
            r14 = null;
        L11:
            r6 = null;
            goto L12
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
    }

    public static boolean f() {
        return ((ss0.d) q0.a.getValue()).b();
    }

    public b(o r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        this.h = r2;
        this.a = new CompositeDisposable();
        this.b = new LruHashMap(10);
        this.c = new HashMap();
        this.d = new HashMap();
        this.f = new ArrayList();
        this.g = new C0223b(this);
    }

    @Override // com.bytedance.android.live.service.prerequest.a
    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return ((ArrayList) this.f).contains(r2);
    }

    @Override // com.bytedance.android.live.service.prerequest.a
    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        ((HashMap) this.b).remove(r2);
    }

    @Override // com.bytedance.android.live.service.prerequest.a
    public final Pair<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>, Integer> d(String r12) {
        Intrinsics.checkNotNullParameter(r12, "userId");
        Integer r0 = (Integer) ((HashMap) this.d).get(r12);
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        int r2 = r1 + 1;
        ((HashMap) this.d).put(r12, Integer.valueOf(r2));
        BaseResponse r3 = (BaseResponse) ((LinkedHashMap) this.b).get(r12);
        String r5 = null;
        if (((ArrayList) this.f).contains(r12) == false) goto L12;
        boolean r4 = com.bytedance.android.live.revenue.core.util.h.a;
        if (com.bytedance.android.live.revenue.core.util.h.d(j.class).getRevLinkControlService().n() == true) goto L12;
        return TuplesKt.to(null, Integer.valueOf(r2));
    L12:
        if (r3 == null) goto L36;
        if (Intrinsics.areEqual((Boolean) ((HashMap) this.c).get(r12), Boolean.FALSE) == false) goto L36;
        ProfileMonitor.a r6 = ProfileMonitor.g;
        IMiddlewareUserService r7 = k.f(IMiddlewareUserService.class);
        if (r7 == null) goto L20;
        com.bytedance.android.livesdk.user.e r8 = r7.user();
        if (r8 == null) goto L20;
        String r9 = r8.n();
    L21:
        String r10 = String.valueOf(r9);
        m r13 = this.h.getRoom();
        if (r13 == null) goto L28;
        IRoom r14 = (IRoom) r13.getValue();
        if (r14 == null) goto L28;
        IBaseUser r15 = r14.getOwner();
        if (r15 == null) goto L28;
        r5 = r15.getIdString();
    L28:
        String r16 = String.valueOf(r5);
        m r17 = this.h.getRoom();
        if (r17 == null) goto L33;
        IRoom r18 = (IRoom) r17.getValue();
        if (r18 == null) goto L33;
        long r19 = r18.getRoomId();
    L34:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r12, "preRequestUid");
        Intrinsics.checkNotNullParameter(r10, "currentId");
        Intrinsics.checkNotNullParameter(r16, "anchorId");
        Map r110 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("pre_uid", r12), TuplesKt.to("current_id", r10), TuplesKt.to("anchor_id", r16), TuplesKt.to("room_id", String.valueOf(r19))});
        ProfileMonitor.a.a(r110);
        j0.l().sendLog("livesdk_profile_pre_request_hit", r110, new Object[0]);
    L33:
        r19 = 0;
    L20:
        r9 = null;
    L36:
        return TuplesKt.to(r3, Integer.valueOf(r2));
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.service.prerequest.a
    public final boolean c(IRoom r6, UserProfileEvent r7) {
        Intrinsics.checkNotNullParameter(r6, "room");
        Intrinsics.checkNotNullParameter(r7, "event");
        if (f() == true) goto L5;
        return false;
    L5:
        IBaseUser r0 = r7.user;
        if (r0 != null) goto L8;
        String r8 = r7.getUserIdStr();
    L9:
        String r1 = r6.getOwnerUserIdString();
        IMiddlewareUserService r2 = k.f(IMiddlewareUserService.class);
        if (r2 == null) goto L14;
        com.bytedance.android.livesdk.user.e r3 = r2.user();
        if (r3 == null) goto L14;
        String r4 = r3.n();
    L16:
        if (((ss0.d) q0.a.getValue()).c() == false) goto L24;
        if ((!Intrinsics.areEqual(r4, r1)) == true) goto L20;
        return false;
    L20:
        if (r6.isMergeVSRoom() == true) goto L32;
        return true;
    L32:
        return false;
    L24:
        if (Intrinsics.areEqual(r8, r1) == true) goto L26;
        return false;
    L26:
        if ((!Intrinsics.areEqual(r4, r1)) == true) goto L28;
        return false;
    L28:
        if (r6.isMergeVSRoom() == true) goto L35;
        return true;
    L35:
        return false;
    L14:
        r4 = null;
        goto L16
    L8:
        r8 = r0.getIdString();
        goto L9
    }

    @Override // com.bytedance.android.live.service.prerequest.a
    public final void e(String r3, BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra> r4) {
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "response");
        if (f() == true) goto L5;
        return;
    L5:
        if (((ss0.d) q0.a.getValue()).g() == false) goto L10;
        Map<String, Boolean> r0 = this.c;
        HashMap r1 = (HashMap) r0;
        r1.put(r3, Boolean.TRUE);
        ALogger.i("NewUserProfile_ProfilePre", "缓存更新成功，uid :  ".concat(r3));
        ((HashMap) this.b).put(r3, r4);
        return;
    }

    public final void g(String r46, boolean r47) {
        Integer r2 = (Integer) ((HashMap) this.d).get(r46);
        boolean r3 = false;
        if (r2 == null) goto L5;
        int r4 = r2.intValue();
    L6:
        if (r4 <= 0) goto L10;
        ALogger.i("NewUserProfile_ProfilePre", "pre request return: getCacheCount = " + r4 + ", isRecycled = " + this.c);
        return;
    L10:
        if (ys0.c.a() == false) goto L23;
        ys0.a r5 = (ys0.a) ys0.b.a.getValue();
        NewProfileApi r6 = (NewProfileApi) os0.b.c().getTestHttpClientService(NewProfileApi.class);
        if (r6 == null) goto L178;
        Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> r7 = r6.mockQuery(r5.b(), r5.a());
        if (r7 == null) goto L179;
        Single r8 = r7.subscribeOn(Schedulers.io());
        if (r8 == null) goto L180;
        Single r9 = r8.observeOn(AndroidSchedulers.mainThread());
        if (r9 == null) goto L181;
        Disposable r1 = r9.subscribe(new c(this, r46), d.a);
        if (r1 == null) goto L182;
        RxUtilKt.c(r1, this.a);
        return;
    L182:
        return;
    L181:
        return;
    L180:
        return;
    L179:
        return;
    L178:
        return;
    L23:
        m r10 = this.h.getRoom();
        Single<BaseResponse<UserProfileDataResp, UserProfileDataResp.UserProfileExtra>> r12 = null;
        if (r10 == null) goto L30;
        IRoom r13 = (IRoom) r10.getValue();
        if (r13 == null) goto L30;
        IBaseUser r14 = r13.getOwner();
        if (r14 == null) goto L30;
        String r15 = r14.getIdString();
    L31:
        boolean r16 = TextUtils.equals(r46, r15);
        if (r16 == false) goto L104;
        qs0.e r17 = os0.b.c().getIHostCommerceServiceLive();
        if (r17 == null) goto L36;
        JSONObject r18 = r17.i();
    L37:
        if (r18 == null) goto L101;
        int r19 = NewProfileDialogLauncher.f;
        Object r20 = r18.opt("live_click_products");
        if ((r20 instanceof ArrayList) == true) goto L42;
        r20 = null;
    L42:
        ArrayList r22 = (ArrayList) r20;
        String r23 = r18.optString("live_explain_product");
        Object r24 = r18.opt("live_show_products");
        if ((r24 instanceof ArrayList) == true) goto L45;
        r24 = null;
    L45:
        ArrayList r25 = (ArrayList) r24;
        ArrayList r110 = new ArrayList();
        if (r22 == null) goto L66;
        if (r22.size() > 0) goto L50;
    L52:
        boolean r111 = false;
    L53:
        if (r111 == true) goto L56;
        r22 = null;
    L56:
        if (r22 == null) goto L66;
        Iterator r26 = r22.iterator();
    L59:
        if (r26.hasNext() == false) goto L66;
        Object r112 = r26.next();
        if (r112 == null) goto L64;
        r110.add((String) r112);
        goto L59
    L64:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L50:
        if ((ListProtector.get(r22, 0) instanceof String) == false) goto L52;
        r111 = true;
    L66:
        if (r23.length() <= 0) goto L68;
        boolean r27 = true;
    L69:
        if (r27 == false) goto L71;
        r110.add(r23);
    L71:
        if (r25 != null) goto L73;
    L90:
        Iterator r28 = r110.iterator();
        if (r28.hasNext() == true) goto L93;
        String r29 = "";
    L100:
        if (r29 == null) goto L101;
    L102:
        String r38 = r29;
    L105:
        if (r16 == false) goto L109;
        if (r47 == false) goto L108;
        String r30 = "pre_request_manager_predict";
    L110:
        String r43 = r30;
        NewProfileApi r113 = (NewProfileApi) com.bytedance.android.live.network.c.b().e(NewProfileApi.class);
        if (r113 != null) goto L113;
    L164:
        if (r12 == null) goto L183;
        Single r32 = r12.subscribeOn(Schedulers.io());
        if (r32 == null) goto L184;
        Single r33 = r32.observeOn(AndroidSchedulers.mainThread());
        if (r33 == null) goto L185;
        Disposable r34 = r33.subscribe(new e(this, r46), new f(this, r46));
        if (r34 == null) goto L186;
        RxUtilKt.c(r34, this.a);
        return;
    L186:
        return;
    L185:
        return;
    L184:
        return;
    L183:
        return;
    L113:
        if (r46 == null) goto L117;
        Long r35 = StringsKt.toLongOrNull(r46);
        if (r35 == null) goto L117;
        long r114 = r35.longValue();
    L118:
        m r36 = this.h.getRoom();
        if (r36 == null) goto L129;
        IRoom r37 = (IRoom) r36.getValue();
        if (r37 == null) goto L129;
        IBaseUser r39 = r37.getOwner();
        if (r39 == null) goto L129;
        String r40 = r39.getIdString();
        if (r40 == null) goto L129;
        Long r42 = StringsKt.toLongOrNull(r40);
        if (r42 == null) goto L129;
        long r115 = r42.longValue();
    L130:
        m r44 = this.h.getRoom();
        if (r44 == null) goto L140;
        IRoom r45 = (IRoom) r44.getValue();
        if (r45 == null) goto L140;
        IBaseUser r48 = r45.getOwner();
        if (r48 == null) goto L140;
        Intrinsics.checkNotNullParameter(r48, "$this$secUidExt");
        String r49 = r48.getCastSecUid();
        if (r49 == null) goto L140;
        String r116 = r49;
    L141:
        m r50 = this.h.getRoom();
        if (r50 == null) goto L146;
        IRoom r52 = (IRoom) r50.getValue();
        if (r52 == null) goto L146;
        long r117 = r52.getRoomId();
    L147:
        IMiddlewareUserService r53 = k.f(IMiddlewareUserService.class);
        if (r53 == null) goto L156;
        com.bytedance.android.livesdk.user.e r54 = r53.user();
        if (r54 == null) goto L156;
        String r55 = r54.n();
        if (r55 == null) goto L156;
        Long r56 = StringsKt.toLongOrNull(r55);
        if (r56 == null) goto L156;
        long r210 = r56.longValue();
    L157:
        long r310 = ((Long) k0.a.getValue()).longValue();
        int r57 = gv1.a.a;
        if (((Number) ev1.e.a.getValue()).intValue() <= 0) goto L160;
        r3 = true;
    L160:
        if (r3 == false) goto L162;
        long r410 = 1;
    L163:
        r12 = r113.queryOpenPreloadProfile(r114, "", r115, r116, r117, r210, 0, 0, 0, 0, 0, 0, "", 0, 0, 0, r38, r310, r410, r43, false);
        goto L164
    L162:
        r410 = 0;
    L156:
        r210 = 0;
    L146:
        r117 = 0;
    L140:
        r116 = "";
    L129:
        r115 = 0;
    L117:
        r114 = 0;
        goto L118
    L108:
        r30 = "pre_request_manager";
        goto L110
    L109:
        r30 = "pre_request_other_anchor";
        goto L110
    L93:
        StringBuilder r58 = new StringBuilder();
    L94:
        Object r59 = r28.next();
        if (r59 != r110) goto L97;
        r59 = "(this Collection)";
    L97:
        r58.append(r59);
        if (r28.hasNext() == false) goto L99;
        r58.append(',');
        goto L94
    L99:
        r29 = r58.toString();
        goto L100
    L73:
        if (r25.size() > 0) goto L75;
    L77:
        boolean r60 = false;
    L78:
        if (r60 == true) goto L81;
        r25 = null;
    L81:
        if (r25 == null) goto L90;
        Iterator r62 = r25.iterator();
    L84:
        if (r62.hasNext() == false) goto L90;
        Object r63 = r62.next();
        if (r63 == null) goto L89;
        r110.add((String) r63);
        goto L84
    L89:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L75:
        if ((ListProtector.get(r25, 0) instanceof String) == false) goto L77;
        r60 = true;
        goto L78
    L68:
        r27 = false;
    L101:
        r29 = "";
        goto L102
    L36:
        r18 = null;
        goto L37
    L104:
        r38 = "";
    L30:
        r15 = null;
        goto L31
    L5:
        r4 = 0;
        goto L6
    }
}
