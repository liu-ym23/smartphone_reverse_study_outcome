package l1c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.e;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a extends k1c.a<Map<Biz, ? extends Double>> implements Application.ActivityLifecycleCallbacks, y {
    public static final boolean o = false;
    public static final Double[] p = null;
    public static final HashMap<Biz, Set<String>> q = null;
    public static final Map<String, Integer> r = null;
    public Handler d;
    public final HashMap<Biz, Double> e;
    public final HashMap<Biz, Double> f;
    public final HashMap<Biz, Double> g;
    public final HashMap<Biz, Double> h;
    public final C0163a i;
    public C0163a j;
    public C0163a k;
    public C0163a l;
    public int m;
    public com.ss.android.lark.storage.kv.repo.a n;

    /* JADX INFO: renamed from: l1c.a$a, reason: collision with other inner class name */
    public static final class C0163a {
        public long a;
        public HashMap<String, Integer> b;

        public C0163a() {
            this(null);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof C0163a) == true) goto L8;
            return false;
        L8:
            C0163a r9 = (C0163a) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r9.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "BizCountData(timeStamp=" + this.a + ", bizCountMap=" + this.b + ')';
        }

        public C0163a(Object r3) {
            HashMap<String, Integer> r4 = new HashMap();
            Intrinsics.checkNotNullParameter(r4, "bizCountMap");
            this.a = 0;
            this.b = r4;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ String b;

        public c(a r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            a r0 = this.a;
            String r7 = this.b;
            r0.getClass();
            List r1 = StringsKt.split$default(r7, new String[]{"."}, false, 0, 6, null);
            StringBuilder r2 = new StringBuilder();
            int r5 = 0;
            if (r1.size() < 2) goto L19;
            int r3 = 5;
            int r8 = 0;
        L7:
            if (r8 >= (r1.size() - 1)) goto L16;
            r2.append((String) ListProtector.get(r1, r8));
            Integer r9 = a.r.get(r2.toString());
            if (r9 == null) goto L12;
            r3 = r9.intValue();
        L12:
            if (r8 == (r3 - 1)) goto L16;
            r2.append(".");
            r8 = r8 + 1;
        L16:
            if (StringsKt.endsWith$default(r2, ".", false, 2, null) == false) goto L18;
            r7 = r2.substring(0, r2.length() - 1).toString();
            goto L19
        L18:
            r7 = r2.toString();
        L19:
            Iterator<Map.Entry<Biz, Set<String>>> r4 = a.q.entrySet().iterator();
        L21:
            if (r4.hasNext() == false) goto L25;
            Map.Entry<Biz, Set<String>> r6 = r4.next();
            if (r6.getValue().contains(r7) == false) goto L21;
            Biz r10 = r6.getKey();
        L27:
            if (r10 != null) goto L30;
            Log.e("BizFrequencyDetector", "biz not found, packageName:" + r7, null, true);
            return;
        L30:
            Integer r11 = this.a.i.b.get(r10.name());
            if (r11 == null) goto L33;
            r5 = r11.intValue();
        L33:
            int r12 = r5 + 1;
            this.a.i.b.put(r10.name(), Integer.valueOf(r12));
            Log.d("BizFrequencyDetector", "biz:" + r10 + ", packageName:" + r7 + ", count:" + r12);
            return;
        L25:
            r10 = null;
            goto L27
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void a() {
            a r3 = this.a;
            if (r3.m != r3.i.hashCode()) goto L20;
            return;
        L20:
            this.a.i.a = System.currentTimeMillis();     // Catch: Exception -> L11
            com.ss.android.lark.storage.kv.repo.c r4 = this.a.n;     // Catch: Exception -> L11
            if (r4 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("mUserStorage");     // Catch: Exception -> L11
            r4 = null;
        L9:
            r4.putString("user_biz_frequency_count_last", new Gson().toJson(this.a.i));     // Catch: Exception -> L11
            a r5 = this.a;     // Catch: Exception -> L11
            r5.m = r5.i.hashCode();     // Catch: Exception -> L11
        L14:
            if (a.o == false) goto L22;
            StringBuilder r6 = new StringBuilder("save recorded biz frequency:");
            com.ss.android.lark.storage.kv.repo.c r7 = this.a.n;
            if (r7 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("mUserStorage");
            r7 = null;
        L18:
            r6.append(r7.getString("user_biz_frequency_count_last", null));
            Log.i("BizFrequencyDetector", r6.toString());
            return;
        L22:
            return;
        L11:
            e = move-exception;
            Log.e("BizFrequencyDetector", "save user_biz_frequency_count_last error!", e, true);
            goto L14
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    static {
        o = android.util.Log.isLoggable("BizFrequencyDetector", 3);
        p = new Double[]{Double.valueOf(0.5d), Double.valueOf(0.3d), Double.valueOf(0.2d)};
        q = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(Biz.Messenger, SetsKt.setOf(new String[]{"com.ss.android.lark.main.app", "com.suite.lark.splash", "com.ss.android.lark.chatthread", "com.ss.android.lark.mergeforward", "com.ss.android.lark.threadmergeforward", "com.ss.android.lark.threadwindow", "com.ss.android.lark.post", "com.ss.android.lark.threaddetail", "com.ss.android.lark.favorite", "com.ss.android.lark.share_group", "com.ss.android.lark.tour", "com.ss.android.lark.tab", "com.ss.android.lark.chat.chatwindow", "com.ss.android.lark.chatfold", "com.ss.android.lark.chat.forwardpreview", "com.ss.android.lark.chat.chatpreview", "com.ss.android.lark.customStatus", "com.ss.android.lark.chatwindow", "com.ss.android.lark.create", "com.ss.android.lark.chatsetting", "com.ss.android.lark.member_manage", "com.ss.android.lark.ck", "com.ss.ugc.android.editor", "com.ss.android.lark.feed", "com.ss.android.lark.sticker", "com.ss.android.lark.keyboard", "com.ss.android.lark.ai", "com.ss.android.lark.pin", "com.ss.android.lark.locationmessage", "com.ss.android.lark.oncall", "com.ss.android.lark.forwardv2", "com.ss.android.lark.readstate", "com.ss.android.lark.money", "com.ss.android.lark.chat.preview", "com.ss.android.lark.edu", "com.ss.android.lark.phone", "com.ss.android.lark.widget.richtext", "com.larksuite.framework.apiplugin.core", "com.ss.android.lark.replyinthread", "com.ss.android.lark.flag", "com.ss.android.lark.ding", "com.ss.android.lark.cameraview", "com.ss.android.lark.myai", "com.ss.android.lark.chat.embedded", "com.ss.android.lark.threadpreview", "com.ss.android.lark.replyinthreadpreview"})), TuplesKt.to(Biz.Search, SetsKt.setOf(new String[]{"com.ss.android.lark.search", "com.ss.android.lark.searchcommon"})), TuplesKt.to(Biz.Calendar, SetsKt.setOf("com.ss.android.lark.calendar")), TuplesKt.to(Biz.Docs, SetsKt.setOf(new String[]{"com.ss.android.lark.main.widget.doc", "com.bytedance.ee.bear"})), TuplesKt.to(Biz.Driver, SetsKt.setOf("")), TuplesKt.to(Biz.Mail, SetsKt.setOf("com.ss.android.lark.mail")), TuplesKt.to(Biz.OpenPlatform, SetsKt.setOf(new String[]{"com.ss.android.lark.applock", "com.bytedance.lark.lynxlib.bullet", "com.ss.android.appcenter.business", "com.ss.android.openbusiness.activity", "com.ss.android.openbusiness.bot", "com.ss.android.lark.message", "com.ss.android.lark.vote", "com.ss.android.lark.openplatform", "com.ss.android.lark.gadget", "com.tt.miniapp", "com.bytedance.lark.webview.container", "com.ss.android.lark.meego", "com.larksuite.component.blockit", "com.bytedance.mira", "com.bytedance.lynx", "com.larksuite.component.dybrid", "com.bytedance.ee.larkbrand", "com.bytedance.ee.ref.card", "com.tt.miniapp.settings", "com.tt.miniapp.about", "com.larksuite.component.webview.container"})), TuplesKt.to(Biz.UserGrowth, SetsKt.setOf(new String[]{"com.ss.android.lark.profile", "com.ss.android.lark.contact", "com.ss.android.lark.collaboration", "com.ss.android.lark.ug", "com.ss.android.lark.mine", "com.ss.android.lark.share", "com.ss.android.lark.invitation", "com.ss.android.lark.team", "com.ss.android.lark.thirdshare", "com.tencent.connect.common", "com.sina.weibo.sdk", "com.ss.android.lark.invite_new_tenant"})), TuplesKt.to(Biz.VideoConference, SetsKt.setOf(new String[]{"com.ss.android.lark.chat.video", "com.ss.android.lark.voip", "com.ss.android.vc", "com.ss.android.lark.mm", "com.ss.android.lark.live"})), TuplesKt.to(Biz.Moments, SetsKt.setOf("com.ss.android.lark.moments")), TuplesKt.to(Biz.Core, SetsKt.setOf(new String[]{"com.ss.android.lark.integrator", "com.tencent.tauth", "com.ss.android.lark.main.router", "com.ss.android.lark.upgrade", "com.larksuite.component.ui.dialog", "com.ss.android.lark.passport", "com.ss.lark.android.passport", "com.ss.android.lark.simple", "com.ss.android.lark.setting", "com.ss.android.lark.multitask", "com.ss.android.lark.guide", "com.ss.android.lark.notification", "com.ss.android.lark.qrcode", "com.ss.android.lark.filedetailplugin", "com.ss.android.lark.filedetail", "com.ss.android.lark.file", "com.bytedance.ee.android.file", "com.ss.android.lark.leanmode", "com.ss.android.lark.imageocr", "com.ss.lark.android.avatar", "com.ss.android.lark.widget.photo_picker", "com.ss.android.lark.widget.photo", "com.ss.android.lark.conditional", "com.ss.android.lark.security", "com.ss.android.lark.authorization", "com.larksuite.component.safemode.ui", "com.ss.android.lark.device", "com.android.ttcjpaysdk", "com.ss.android.lark.custom", "com.ss.android.lark.diskmanage", "com.ss.android.lark.base", "com.bytedance.bdturing", "com.bytedance.push", "pub.devrel.easypermissions", "com.ss.android.caijing.cjpay", "com.vivo.push.sdk", "com.facebook.react", "com.huawei.hms", "com.xiaomi.mipush.sdk", "com.ss.android.lark.photoeditor", "com.ss.android.lark.album", "com.ss.android.bytedcert.activities", "com.ss.android.lark.maintab", "com.ss.android.bytedcert.permission", "com.bytedance.fido_sdk.activity"})), TuplesKt.to(Biz.Todo, SetsKt.setOf(new String[]{"com.ss.android.lark.main.widget.todo", "com.ss.android.lark.main.widget.ui", "com.ss.android.lark.todo"}))});
        r = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("com.ss.android.lark.main", 7), TuplesKt.to("com.ss.android.lark.chat", 6), TuplesKt.to("com.bytedance.ee.bear", 4), TuplesKt.to("com.ss.android.vc", 4), TuplesKt.to("com.vivo.push.sdk", 4), TuplesKt.to("com.bytedance.ee.larkbrand", 4), TuplesKt.to("com.larksuite.component.blockit", 4), TuplesKt.to("com.ss.android.lark.widget", 6), TuplesKt.to("com.tencent.connect.common", 4), TuplesKt.to("com.larksuite.component.dybrid", 4), TuplesKt.to("com.android.ttcjpaysdk", 3), TuplesKt.to("com.bytedance.bdturing", 3), TuplesKt.to("com.bytedance.push", 3), TuplesKt.to("pub.devrel.easypermissions", 3), TuplesKt.to("com.bytedance.mira", 3), TuplesKt.to("com.bytedance.lynx", 3), TuplesKt.to("com.facebook.react", 3), TuplesKt.to("com.xiaomi.mipush.sdk", 4), TuplesKt.to("com.sina.weibo.sdk", 4), TuplesKt.to("com.huawei.hms", 3), TuplesKt.to("com.tencent.tauth", 3)});
    }

    public a() {
        this.e = new HashMap();
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new C0163a(null);
        this.j = new C0163a(null);
        this.k = new C0163a(null);
        this.l = new C0163a(null);
    }

    @Override // k1c.a
    public final Map<Biz, ? extends Double> n() {
        return this.e;
    }

    public static HashMap p(HashMap... r8) {
        HashMap r0 = new HashMap();
        int r1 = r8.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L13;
        Iterator r4 = r8[r3].entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r5 = (Map.Entry) r4.next();
        Object r6 = r5.getKey();
        Integer r7 = (Integer) r0.get(r5.getKey());
        if (r7 == null) goto L10;
        int r9 = r7.intValue();
    L11:
        r0.put(r6, Integer.valueOf(r9 + ((Number) r5.getValue()).intValue()));
        goto L6
    L10:
        r9 = 0;
        goto L11
    L12:
        r3 = r3 + 1;
        goto L3
    L13:
        return r0;
    }

    public final void f(y.a r2, y.a r3) {
        Intrinsics.checkNotNullParameter(r2, "oldState");
        Intrinsics.checkNotNullParameter(r3, "newState");
        if (r3.c == false) goto L5;
        return;
    L5:
        if (r2.c == false) goto L12;
        Handler r4 = this.d;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mWorkerHandler");
        r4 = null;
    L9:
        r4.post(new d(this));
        return;
    }

    @Override // k1c.a, k1c.b
    public final void j(Context r23, e1c.d r24) {
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r24, "manager");
        super.j(r23, r24);
        this.d = CoreThreadPool.newThreadHandler("BizFrequencyDetector");
        Integer r4 = 0;
        this.n = LarkKVStorage.p(new com.ss.android.lark.storage.a("core"), "preload_config", false);
        LarkContext.getApplication().registerActivityLifecycleCallbacks(this);
        AppLifecycle.a.a.c(this);
        C0163a r2 = (C0163a) r("user_biz_frequency_count_last", C0163a.class);
        int r5 = CollectionsKt.sumOfInt(r2.b.values());
        Iterator<T> r6 = r2.b.keySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        String r7 = (String) r6.next();
        HashMap<Biz, Double> r8 = this.f;
        Intrinsics.checkNotNull(r7);
        Biz r9 = Biz.valueOf(r7);
        Integer r10 = r2.b.get(r7);
        if (r10 == null) goto L8;
        Number r11 = Double.valueOf(((double) r10.intValue()) / ((double) r5));
    L9:
        r8.put(r9, Double.valueOf(r11.doubleValue()));
        goto L4
    L8:
        r11 = r4;
        goto L9
    L10:
        this.j = (C0163a) r("user_biz_frequency_count_day_one", C0163a.class);
        this.k = (C0163a) r("user_biz_frequency_count_day_two", C0163a.class);
        this.l = (C0163a) r("user_biz_frequency_count_day_three", C0163a.class);
        int r12 = CollectionsKt.sumOfInt(this.j.b.values());
        Iterator<T> r13 = this.j.b.keySet().iterator();
    L12:
        if (r13.hasNext() == false) goto L18;
        String r14 = (String) r13.next();
        HashMap<Biz, Double> r15 = this.g;
        Intrinsics.checkNotNull(r14);
        Biz r16 = Biz.valueOf(r14);
        Integer r17 = this.j.b.get(r14);
        if (r17 == null) goto L16;
        Integer r25 = r4;
        Number r3 = Double.valueOf(((double) r17.intValue()) / ((double) r12));
    L17:
        r15.put(r16, Double.valueOf(r3.doubleValue()));
        r4 = r25;
        goto L12
    L16:
        r25 = r4;
        r3 = r25;
        goto L17
    L18:
        Integer r26 = r4;
        HashMap r18 = p(new HashMap[]{this.j.b, this.k.b, this.l.b});
        int r19 = CollectionsKt.sumOfInt(r18.values());
        Iterator r110 = r18.keySet().iterator();
    L20:
        if (r110.hasNext() == false) goto L27;
        String r111 = (String) r110.next();
        HashMap<Biz, Double> r112 = this.h;
        Intrinsics.checkNotNull(r111);
        Biz r113 = Biz.valueOf(r111);
        Integer r114 = (Integer) r18.get(r111);
        if (r114 == null) goto L24;
        Number r20 = Double.valueOf(((double) r114.intValue()) / ((double) r19));
    L25:
        r112.put(r113, Double.valueOf(r20.doubleValue()));
        r110 = r110;
        r18 = r18;
        goto L20
    L24:
        r20 = r26;
        goto L25
    L27:
        if (this.l.a != 0) goto L32;
        Biz[] r21 = Biz.values();
        int r22 = r21.length;
        int r27 = 0;
    L29:
        if (r27 >= r22) goto L31;
        this.h.put(r21[r27], Double.valueOf(0.5d));
        r27 = r27 + 1;
        goto L29
    L31:
        Log.i("BizFrequencyDetector", "initLastBizFrequency not up to 3 days, use default configure.");
    L32:
        Log.i("BizFrequencyDetector", "initLastBizFrequency ThreeDayBizCount, firstDay:" + this.j + ", secondDay:" + this.k + ", thirdDay:" + this.l);
        HashMap<Biz, Double> r115 = this.f;
        Double[] r116 = p;
        Pair[] r117 = {new Pair(r115, r116[0]), new Pair(this.g, r116[1]), new Pair(this.h, r116[2])};
        int r28 = 0;
    L34:
        if (r28 >= 3) goto L43;
        Pair r118 = r117[r28];
        Iterator r119 = ((Map) r118.getFirst()).entrySet().iterator();
    L37:
        if (r119.hasNext() == false) goto L42;
        Map.Entry r120 = (Map.Entry) r119.next();
        HashMap<Biz, Double> r121 = this.e;
        Object r122 = r120.getKey();
        Double r29 = this.e.get(r120.getKey());
        if (r29 != null) goto L41;
        r29 = r26;
    L41:
        r121.put((Biz) r122, Double.valueOf(r29.doubleValue() + (((Number) r120.getValue()).doubleValue() * ((Number) r118.getSecond()).doubleValue())));
        goto L37
    L42:
        r28 = r28 + 1;
        goto L34
    L43:
        Log.d("BizFrequencyDetector", "initLastBizFrequency mTotalBizFrequencyMap:" + this.e);
        C0163a r30 = this.j;
        C0163a r31 = this.k;
        long r123 = r2.a;
        if (r123 == 0) goto L80;
        com.ss.android.lark.storage.kv.repo.c r124 = null;
        if (e.a(r123, r30.a) == false) goto L53;
        HashMap<String, Integer> r32 = p(new HashMap[]{r30.b, r2.b});
        Intrinsics.checkNotNullParameter(r32, "<set-?>");
        r30.b = r32;
        com.ss.android.lark.storage.kv.repo.c r33 = this.n;
        if (r33 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("mUserStorage");
    L52:
        r124.putString("user_biz_frequency_count_day_one", GsonProtectorUtils.toJson(new Gson(), r30));
        Log.d("BizFrequencyDetector", "saveRecentBizCount, firstDay:" + r30);
        return;
    L51:
        r124 = r33;
        goto L52
    L53:
        com.ss.android.lark.storage.kv.repo.c r125 = this.n;
        if (r125 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mUserStorage");
        r125 = null;
    L56:
        r125.putString("user_biz_frequency_count_day_one", GsonProtectorUtils.toJson(new Gson(), r2));
        com.ss.android.lark.storage.kv.repo.c r34 = this.n;
        if (r34 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("mUserStorage");
        r34 = null;
    L59:
        r34.putString("user_biz_frequency_count_day_two", GsonProtectorUtils.toJson(new Gson(), r30));
        com.ss.android.lark.storage.kv.repo.c r35 = this.n;
        if (r35 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("mUserStorage");
    L63:
        r124.putString("user_biz_frequency_count_day_three", GsonProtectorUtils.toJson(new Gson(), r31));
        Log.d("BizFrequencyDetector", "saveRecentBizCount, firstDay:" + r2 + ", secondDay:" + r30 + ", thirdDay:" + r31);
        return;
    L62:
        r124 = r35;
        goto L63
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        String r4 = r2.getComponentName().getClassName();
        Handler r5 = this.d;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mWorkerHandler");
        r5 = null;
    L5:
        r5.post(new c(this, r4));
    }

    public final <T> T r(String r4, Class<T> r5) {
        T r0 = r5.newInstance();
        com.ss.android.lark.storage.kv.repo.c r1 = this.n;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mUserStorage");
        r1 = null;
    L5:
        String r6 = r1.getString(r4, null);
        if (TextUtils.isEmpty(r6) == false) goto L14;
        Log.i("BizFrequencyDetector", "getLocalBizFrequency is empty!");
        return r0;
    L14:
        return (T) new Gson().fromJson(r6, r5);
    L11:
        e = move-exception;
        Log.d("BizFrequencyDetector", "getLocalBizCount:" + e.getMessage());
        return r0;
    }
}
