package com.bytedance.android.live.anchormodelink.gift;

import android.graphics.PointF;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.animation.k0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.MultiLinkScriptInfo;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomInteractEmoji;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TaskState;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.n;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.o;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.s;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.o0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements k0.c, tf0.h {
    public static final /* synthetic */ int f = 0;
    public ArrayList<ILinkPlayerInfoBridge> a;
    public final CompositeDisposable b;
    public final c c;
    public final DataCenter d;
    public final d e;

    /* JADX INFO: renamed from: com.bytedance.android.live.anchormodelink.gift.a$a, reason: collision with other inner class name */
    public static final class C0007a<T> implements Comparator<T> {
        public C0007a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((ILinkPlayerInfoBridge) r1).getUserPosition()), Integer.valueOf(((ILinkPlayerInfoBridge) r2).getUserPosition()));
        }
    }

    public static final class b {
    }

    public static final class c implements iy.i {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // iy.i
        public final void a(List<? extends ILinkPlayerInfoBridge> r4) {
            a r0 = this.a;
            ArrayList<ILinkPlayerInfoBridge> r5 = (ArrayList) r4;
            if (r5 == null) goto L7;
            r0.getClass();
            if (r5.size() <= 1) goto L7;
            CollectionsKt.sortWith(r5, new com.bytedance.android.live.anchormodelink.gift.b());
        L7:
            r0.a = r5;
        }
    }

    static {
    }

    public final boolean a() {
        return true;
    }

    public final void b(int r1) {
    }

    public final boolean c() {
        return true;
    }

    public final PointF d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return null;
    }

    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
    }

    public a(DataCenter r4, d r5) {
        Intrinsics.checkNotNullParameter(r5, "giftManager");
        this.d = r4;
        this.e = r5;
        this.b = new CompositeDisposable();
        c r6 = new c(this);
        this.c = r6;
        ArrayList<ILinkPlayerInfoBridge> r0 = r5.a;
        if (r0 != null) goto L5;
    L7:
        this.a = r0;
        Intrinsics.checkNotNullParameter(r6, "listener");
        r5.b.add(r6);
        return;
    L5:
        if (r0.size() <= 1) goto L7;
        CollectionsKt.sortWith(r0, new C0007a());
        goto L7
    }

    public final void g(final com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r9, JsonObject r11, final com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r12, n r13, o r14, String r15) {
        JsonObject r0 = new JsonObject();
        h2 r1 = r9.k;
        String r2 = "";
        if (r1 == null) goto L6;
        String r3 = String.valueOf(r1.getId());
        if (r3 == null) goto L6;
    L7:
        r0.addProperty("id", r3);
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        r0.addProperty("base_dir", r15);
        r0.add("extra", r11);
        r0.add("to_users", GsonProtectorUtils.toJsonTree(new Gson(), r9.c).getAsJsonArray());
        String r16 = r9.b;
        if (r16 != null) goto L14;
        r16 = "";
    L14:
        r0.addProperty("from_user", r16);
        JsonObject r17 = new JsonObject();
        PointF r18 = r14.a;
        if (r18 == null) goto L17;
        Number r19 = Float.valueOf(r18.x);
    L18:
        r17.addProperty("x", Float.valueOf(s1.G(r19.intValue())));
        PointF r110 = r14.a;
        if (r110 == null) goto L21;
        Number r111 = Float.valueOf(r110.y);
    L22:
        r17.addProperty("y", Float.valueOf(s1.G(r111.intValue())));
        r0.add("from_center", r17);
        JsonObject r112 = new JsonObject();
        JsonObject r113 = new JsonObject();
        if (r13 == null) goto L25;
        int r5 = r13.b;
    L26:
        r113.addProperty("w", Integer.valueOf(r5));
        if (r13 == null) goto L29;
        int r6 = r13.c;
    L30:
        r113.addProperty("h", Integer.valueOf(r6));
        Unit r7 = Unit.INSTANCE;
        r112.add("size", r113);
        JsonObject r114 = new JsonObject();
        if (r13 == null) goto L35;
        PointF r8 = r13.a;
        if (r8 == null) goto L35;
        Number r21 = Float.valueOf(r8.x);
    L36:
        r114.addProperty("x", r21);
        if (r13 == null) goto L41;
        PointF r4 = r13.a;
        if (r4 == null) goto L41;
        Number r22 = Float.valueOf(r4.y);
    L42:
        r114.addProperty("y", r22);
        if (r13 == null) goto L45;
        Number r23 = Float.valueOf(r13.d);
    L46:
        r114.addProperty("w", r23);
        if (r13 == null) goto L49;
        Number r24 = Float.valueOf(r13.e);
    L50:
        r114.addProperty("h", r24);
        r112.add("render_frame", r114);
        r112.addProperty("enable_random_effect", Boolean.valueOf(vm2.d.F()));
        if (r13 == null) goto L53;
        Integer r115 = r13.f;
    L54:
        r112.addProperty("effect_level", r115);
        r112.addProperty("random_timestamp", Long.valueOf(r9.f));
        o0 r116 = r14.c;
        if (r116 == null) goto L64;
        k r117 = r116.getTrayDynamicImg();
        if (r117 == null) goto L64;
        List<String> r118 = r117.getUrls();
        if (r118 == null) goto L64;
        String r119 = (String) CollectionsKt.getOrNull(r118, 0);
        if (r119 == null) goto L64;
        r2 = r119;
    L64:
        r112.addProperty("tray_image_url", r2);
        s r120 = r9.m;
        if (r120 == null) goto L67;
        int r121 = r120.a();
    L68:
        r112.addProperty("default_angle", Integer.valueOf(r121));
        r0.add(NewBroadcastMonitor.STAGE.EFFECT, r112);
        final long r122 = System.currentTimeMillis();
        com.bytedance.android.live.liveinteract.animation.i.a("DynamicCenteGiftController", "executeFlyMicAnimation start");
        iy.g r123 = jc1.k.n(IInteractService.class).getDynamicCenterService(this.d);
        if (r123 == null) goto L72;
        r123.Dh("sendFlymicGift", r0, new DynamicCenteGiftController$buildAndExecuteTask$1(r122, r12, r9));
        return;
    L72:
        return;
    L67:
        r121 = Integer.MIN_VALUE;
        goto L68
    L53:
        r115 = null;
        goto L54
    L49:
        r24 = 0;
        goto L50
    L45:
        r23 = 0;
    L41:
        r22 = 0;
    L35:
        r21 = 0;
        goto L36
    L29:
        r6 = 0;
        goto L30
    L25:
        r5 = 0;
        goto L26
    L21:
        r111 = 0;
        goto L22
    L17:
        r19 = 0;
    L6:
        r3 = "";
        goto L7
    }

    public final void f(final dq2.n r15, final com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r16, final n r17, TalkRoomInteractEmoji r18, final String r19, MultiLinkScriptInfo r21, final o r22) {
        Intrinsics.checkNotNullParameter(r16, "giftInfo");
        Intrinsics.checkNotNullParameter(r22, "positionInfo");
        final int r6 = r16.d;
        ArrayList<ILinkPlayerInfoBridge> r1 = this.a;
        if (r1 != null) goto L5;
        r1 = new ArrayList();
    L5:
        Intrinsics.checkNotNullParameter(r1, "$this$toUserIdList");
        ArrayList r4 = new ArrayList();
        Iterator<ILinkPlayerInfoBridge> r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L13;
        IBaseUser r7 = r2.next().getUser();
        if (r7 == null) goto L7;
        String r8 = r7.getIdString();
        if (r8 == null) goto L7;
        r4.add(r8);
        goto L7
    L13:
        List r3 = r22.b;
        com.bytedance.android.live.liveinteract.animation.i.a("DynamicCenteGiftController", "executeFlyMicAnimation .gift:" + r16 + ".onlineList:" + r4 + ", receiverList:" + r3);
        List r9 = CollectionsKt.toList(CollectionsKt.intersect(r3, CollectionsKt.toSet(r4)));
        if (r9.isEmpty() == false) goto L17;
        com.bytedance.android.live.liveinteract.animation.i.a("DynamicCenteGiftController", "executeFlyMicAnimation#no receiver.gift:" + r16 + ".onlineList:" + r4 + ",receiverList:" + r3);
        r15.c(r16, TaskState.CANCEL);
        MultiLinkEventModule r0 = yc0.a.a;
        yc0.b.a r5 = new yc0.b.a();
        Intrinsics.checkNotNullParameter("no_receiver", "reason");
        r5.a = "no_receiver";
        r5.e = r16;
        r5.b = r16.k;
        yc0.a.b(new yc0.b(r5));
        return;
    L17:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r16.c = r9;
        if (TextUtils.isEmpty(r19) == false) goto L22;
        if (r18 != null) goto L22;
        com.bytedance.android.live.liveinteract.animation.i.a("DynamicCenteGiftController", "executeFlyMicAnimation#no resources.gift:" + r16);
        r15.c(r16, TaskState.CANCEL);
        MultiLinkEventModule r11 = yc0.a.a;
        yc0.b.a r12 = new yc0.b.a();
        Intrinsics.checkNotNullParameter("no_resource", "reason");
        r12.a = "no_resource";
        r12.e = r16;
        r12.b = r16.k;
        yc0.a.b(new yc0.b(r12));
        return;
    L22:
        if (r18 != null) goto L34;
        e r13 = new e();
        Intrinsics.checkNotNull(r19);
        CompositeDisposable r14 = this.b;
        Function2<Boolean, JsonObject, Unit> r110 = new DynamicCenteGiftController$executeFlyMicAnimation$1(this, r16, r15, r17, r22, r6, r19);
        Intrinsics.checkNotNullParameter(r19, "path");
        Intrinsics.checkNotNullParameter("extra.json", "name");
        Intrinsics.checkNotNullParameter(r14, "dis");
        Intrinsics.checkNotNullParameter(r110, "onResult");
        String r23 = r19 + "extra.json";
        LruCache<String, JsonObject> r24 = j.a;
        Intrinsics.checkNotNullParameter(r23, "key");
        if (TextUtils.isEmpty(r23) == true) goto L28;
        JsonObject r25 = j.a.get(r23);
        if (r25 == null) goto L28;
        JsonObject r26 = r25.deepCopy();
    L30:
        if (r26 == null) goto L32;
        r110.invoke(Boolean.TRUE, r26);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#hit cache key:".concat(r23));
        return;
    L32:
        r14.add(Observable.create(new f(r13, r23)).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new g(r110, r23), new h(r110, r23)));
        return;
    L28:
        r26 = null;
        goto L30
    L34:
        com.bytedance.android.live.liveinteract.animation.i.a("DynamicCenteGiftController", "executeFlyMicAnimation#exe sync success.gift:" + r16 + ",data:" + r18);
        g(r16, GsonProtectorUtils.toJsonTree(new Gson(), r18).getAsJsonObject(), r15, r17, r22, r19);
    }
}
