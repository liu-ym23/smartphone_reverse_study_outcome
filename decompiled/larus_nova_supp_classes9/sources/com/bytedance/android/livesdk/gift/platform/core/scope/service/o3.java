package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o3 implements com.bytedance.android.scope.o {
    public float a;
    public Disposable b;
    public final com.bytedance.android.livesdk.gift.configmodel.n2 c;
    public boolean d;
    public boolean e;
    public final yz0.k f;
    public final SendGiftRelationService g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ o3 a;
        public final /* synthetic */ Ref.ObjectRef b;

        public a(o3 r1, Ref.ObjectRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            Ref.ObjectRef r4 = this.b;
            r4.element = new JSONObject();
            o3 r5 = this.a;
            if (r5.d == true) goto L5;
            r5.d = true;
            r5.a((JSONObject) this.b.element);
        L5:
            this.a.c((JSONObject) this.b.element);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ rq2.a a;
        public final /* synthetic */ Ref.ObjectRef b;

        public b(rq2.a r1, Ref.ObjectRef r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.append((JSONObject) this.b.element);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ o3 a;

        public c(o3 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            o3 r5 = this.a;
            if (r5.e == true) goto L12;
            r5.e = true;
            i12.e r6 = i12.o.b();
            if (r6 == null) goto L7;
            Object r7 = com.bytedance.android.scope.m.e.d(r6, f0.class);
        L8:
            f0 r8 = (f0) r7;
            if (r8 == null) goto L13;
            r8.a();
            return;
        L13:
            return;
        L7:
            r7 = null;
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

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e implements Action {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void run() {
        }
    }

    public final void onStart() {
        if (this.c.e() == true) goto L5;
        return;
    L5:
        rq2.a r0 = vh6.c.b(rq2.a.class);
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        r1.element = new JSONObject();
        if (this.c.a() > 0) goto L8;
        return;
    L8:
        if (this.c.d() <= 0) goto L12;
        this.b = Observable.interval(this.c.a(), this.c.d(), TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).doOnNext(new a(this, r1)).observeOn(Schedulers.io()).doOnNext(new b(r0, r1)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.a, e.a);
        return;
    }

    public final void onStop() {
        Disposable r0 = this.b;
        if (r0 == null) goto L10;
        Intrinsics.checkNotNull(r0);
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.b;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void a(JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "rootData");
        IFeatureService r0 = jc1.k.f(IFeatureService.class);
        String r1 = null;
        if (r0 == null) goto L7;
        z90.a r2 = r0.getFeatureManager();
        if (r2 == null) goto L7;
        JSONObject r3 = (JSONObject) r2.getFeature("user_features", new JSONObject());
    L8:
        IRoom r4 = this.f.getRoom();
        JSONObject r5 = new JSONObject();
        if (r4 != null) goto L29;
    L18:
        if (r3 == null) goto L20;
        r3.put("send_gift_relation_cnt", this.g.a.size());     // Catch: Exception -> L28
    L20:
        if (r3 == null) goto L22;
        r3.put("consume_level", ay1.b.u());     // Catch: Exception -> L28
    L22:
        IUtilsCommonService r6 = jc1.k.f(IUtilsCommonService.class);     // Catch: Exception -> L28
        if (r6 == null) goto L25;
        float r7 = r6.deviceScoreHelperGetScore(false);     // Catch: Exception -> L28
    L26:
        this.a = r7;     // Catch: Exception -> L28
        JSONObject r9 = new JSONObject();     // Catch: Exception -> L28
        r9.put("device_score", Float.valueOf(this.a));     // Catch: Exception -> L28
        r8.put("device_feature", r9);     // Catch: Exception -> L28
        r8.put("room_common_feature", r5);     // Catch: Exception -> L28
        r8.put("user_common_feature", r3);     // Catch: Exception -> L28
        return;
    L31:
        return;
    L25:
        r7 = -1.0f;
        goto L26
    L29:
        r5.putOpt("room_id", Long.valueOf(r4.getRoomId()));     // Catch: Exception -> L28
        IBaseUser r10 = r4.getOwner();     // Catch: Exception -> L28
        if (r10 == null) goto L13;
        Integer r11 = Integer.valueOf(r10.getGender());     // Catch: Exception -> L28
    L14:
        r5.putOpt("anchor_gender", r11);     // Catch: Exception -> L28
        IBaseUser r13 = r4.getOwner();     // Catch: Exception -> L28
        if (r13 == null) goto L17;
        r1 = r13.getCity();     // Catch: Exception -> L28
    L17:
        r5.putOpt("anchor_city", r1);     // Catch: Exception -> L28
        r5.putOpt("live_mode", Integer.valueOf(r4.getStreamType().ordinal()));     // Catch: Exception -> L28
        r5.putOpt("is_commerce", Boolean.valueOf(this.f.e4()));     // Catch: Exception -> L28
        r5.putOpt("is_game", Boolean.valueOf(this.f.isGameRoom()));     // Catch: Exception -> L28
        goto L18
    L13:
        r11 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void c(JSONObject r9) {
        Intrinsics.checkNotNullParameter(r9, "rootData");
        JSONObject r0 = new JSONObject();
        IRoom r1 = this.f.getRoom();
        JSONObject r2 = new JSONObject();
        if (r1 != null) goto L33;
    L24:
        r0.put("send_gift_relation_cnt", this.g.a.size());     // Catch: Exception -> L32
        IRechargeService r3 = jc1.k.f(IRechargeService.class);     // Catch: Exception -> L32
        if (r3 == null) goto L29;
        zv0.f r4 = r3.rechargeCenter();     // Catch: Exception -> L32
        if (r4 == null) goto L29;
        long r5 = r4.getAvailableDiamonds();     // Catch: Exception -> L32
    L30:
        r0.put("available", r5);     // Catch: Exception -> L32
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L32
        com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class).setFeatureParams(r6);     // Catch: Exception -> L32
        r9.put("room_realtime_feature", r2);     // Catch: Exception -> L32
        r9.put("context_features", r6);     // Catch: Exception -> L32
        r9.put("user_realtime_feature", r0);     // Catch: Exception -> L32
        return;
    L35:
        return;
    L29:
        r5 = 0;
        goto L30
    L33:
        r2.putOpt("room_id", Long.valueOf(r1.getRoomId()));     // Catch: Exception -> L32
        r2.putOpt("room_user_count", Long.valueOf(r1.getUserCount()));     // Catch: Exception -> L32
        IRoomStats r7 = r1.getStats();     // Catch: Exception -> L32
        Long r8 = null;
        if (r7 == null) goto L7;
        Integer r10 = Integer.valueOf(r7.getTotalUser());     // Catch: Exception -> L32
    L8:
        r2.putOpt("room_total_user_count", r10);     // Catch: Exception -> L32
        IBaseUser r11 = r1.getOwner();     // Catch: Exception -> L32
        if (r11 == null) goto L13;
        py.j r13 = r11.getFollowInfo();     // Catch: Exception -> L32
        if (r13 == null) goto L13;
        Long r14 = Long.valueOf(r13.getFollowerCount());     // Catch: Exception -> L32
    L14:
        r2.putOpt("anchor_fans_count", r14);     // Catch: Exception -> L32
        IBaseUser r15 = r1.getOwner();     // Catch: Exception -> L32
        if (r15 == null) goto L19;
        py.j r16 = r15.getFollowInfo();     // Catch: Exception -> L32
        if (r16 == null) goto L19;
        r8 = Long.valueOf(r16.getFollowStatus());     // Catch: Exception -> L32
    L19:
        r2.putOpt("follow_status", r8);     // Catch: Exception -> L32
        boolean r17 = true;
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene() > 1) goto L23;
        r17 = false;
    L23:
        r2.putOpt("is_multi", Boolean.valueOf(r17));     // Catch: Exception -> L32
    L13:
        r14 = null;
        goto L14
    L7:
        r10 = null;
        goto L8
    }

    public o3(yz0.k r2, SendGiftRelationService r3) {
        Intrinsics.checkNotNullParameter(r2, "roomDataService");
        Intrinsics.checkNotNullParameter(r3, "sendGiftRelationService");
        this.f = r2;
        this.g = r3;
        this.a = -1.0f;
        this.c = (com.bytedance.android.livesdk.gift.configmodel.n2) com.bytedance.android.livesdk.gift.platform.core.h.i0.getValue(null, com.bytedance.android.livesdk.gift.platform.core.h.a[59]);
    }
}
