package com.bytedance.android.livesdk.interactivity.publicscreen.plugin;

import com.bytedance.android.live.base.model.message.c4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.l;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.listener.ShowArea;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.n;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.x;
import com.bytedance.android.livesdk.interactivity.api.settings.config.q0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends x implements s42.b {
    public static final /* synthetic */ int v = 0;
    public final boolean b;
    public final Set<String> c;
    public final int d;
    public final int e;
    public int f;
    public List<String> g;
    public List<String> h;
    public List<String> i;
    public List<String> j;
    public List<String> k;
    public int l;
    public int m;
    public int n;
    public int o;
    public List<String> p;
    public List<String> q;
    public List<String> r;
    public List<String> s;
    public List<String> t;
    public Disposable u;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L16;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.e, r4.e) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r13 = (r9 + r11) * 31;
            String r14 = this.e;
            if (r14 == null) goto L22;
            r1 = r14.hashCode();
        L22:
            return r13 + r1;
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "MessageInfo(id=" + this.a + ", type=" + this.b + ", userId=" + this.c + ", username=" + this.d + ", serverSendTime=" + this.e + ")";
        }

        public final String getType() {
            return this.b;
        }

        public b(String r2, String r3, String r4, String r5, String r6) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r4, "userId");
            Intrinsics.checkNotNullParameter(r5, "username");
            Intrinsics.checkNotNullParameter(r6, "serverSendTime");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ d a;

        public c(d r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.u();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.publicscreen.plugin.d$d, reason: collision with other inner class name */
    public static final class C0190d<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;
        public final /* synthetic */ List d;
        public final /* synthetic */ List e;
        public final /* synthetic */ List f;
        public final /* synthetic */ int g;
        public final /* synthetic */ int h;
        public final /* synthetic */ int i;
        public final /* synthetic */ int j;
        public final /* synthetic */ boolean k;
        public final /* synthetic */ long l;

        public C0190d(String r1, List r2, List r3, List r4, List r5, List r6, int r7, int r8, int r9, int r10, boolean r11, long r13) {
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
            this.k = r11;
            this.l = r13;
        }

        public final void accept(Object r28) {
            Integer r1 = (Integer) r28;
            HashMap r2 = new HashMap();
            r2.put("receive_message_user_id", this.a);
            r2.put("message_id_list", CollectionsKt.joinToString$default(this.b, ",", null, null, 0, null, null, 62, null));
            r2.put("message_type_list", CollectionsKt.joinToString$default(this.c, ",", null, null, 0, null, null, 62, null));
            r2.put("message_timestamp_list", this.d.toString());
            r2.put("message_user_id_list", CollectionsKt.joinToString$default(this.e, ",", null, null, 0, null, null, 62, null));
            r2.put("message_user_nickname_list", CollectionsKt.joinToString$default(this.f, "<sep>", null, null, 0, null, null, 62, null));
            r2.put("message_number", String.valueOf(this.g));
            r2.put("comment_action_number", String.valueOf(this.h));
            r2.put("send_gift_action_number", String.valueOf(this.i));
            r2.put("interactive_action_number", String.valueOf(this.j));
            if (this.k == false) goto L5;
            String r3 = "1";
        L6:
            r2.put("is_anchor", r3);
            j0.l().sendLog("livesdk_screen_message_client_reception_summary", r2, new Object[]{IRoom.class, am2.x.class});
            ALogger.i("PublicScreenStatisticsPlugin", "reportReceiveStatistics. number=" + this.g + ", commentCnt=" + this.h + " sendGiftCnt=" + this.i + " interactiveActionCnt=" + this.j + " cost=" + (System.currentTimeMillis() - this.l));
            return;
        L5:
            r3 = "0";
            goto L6
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            SafetyGuard.a("reportReceiveStatistics error", (Throwable) r3, null);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ List a;
        public final /* synthetic */ List b;
        public final /* synthetic */ List c;
        public final /* synthetic */ List d;
        public final /* synthetic */ List e;
        public final /* synthetic */ boolean f;
        public final /* synthetic */ int g;
        public final /* synthetic */ long h;

        public f(List r1, List r2, List r3, List r4, List r5, boolean r6, int r7, long r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void accept(Object r28) {
            Integer r1 = (Integer) r28;
            HashMap r2 = new HashMap();
            r2.put("message_id_list", CollectionsKt.joinToString$default(this.a, ",", null, null, 0, null, null, 62, null));
            r2.put("message_type_list", CollectionsKt.joinToString$default(this.b, ",", null, null, 0, null, null, 62, null));
            r2.put("message_timestamp_list", CollectionsKt.joinToString$default(this.c, ",", null, null, 0, null, null, 62, null));
            r2.put("message_user_id_list", CollectionsKt.joinToString$default(this.d, ",", null, null, 0, null, null, 62, null));
            r2.put("message_user_nickname_list", CollectionsKt.joinToString$default(this.e, "<sep>", null, null, 0, null, null, 62, null));
            if (this.f == false) goto L5;
            String r3 = "1";
        L6:
            r2.put("is_anchor", r3);
            j0.l().sendLog("livesdk_screen_message_show_summary_detail_user", r2, new Object[]{IRoom.class, am2.x.class});
            ALogger.i("PublicScreenStatisticsPlugin", "reportShowStatistics showCnt=" + this.g + " cost=" + (System.currentTimeMillis() - this.h));
            return;
        L5:
            r3 = "0";
            goto L6
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r3) {
            SafetyGuard.a("reportShowStatistics error", (Throwable) r3, null);
        }
    }

    static {
    }

    @Override // s42.b
    public final void f() {
    }

    @Override // s42.b
    public final void g() {
    }

    @Override // s42.b
    public final void h(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // s42.b
    public final void m(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r1) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void q() {
        ALogger.i("PublicScreenStatisticsPlugin", "onUnload");
        Intrinsics.checkNotNullParameter(this, "listener");
        n r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeMessageListener(this);
    L5:
        Disposable r1 = this.u;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.u = null;
        u();
    }

    public final void s() {
        long r13 = System.currentTimeMillis();
        IMiddlewareUserService r1 = k.f(IMiddlewareUserService.class);
        if (r1 == null) goto L8;
        com.bytedance.android.livesdk.user.e r2 = r1.user();
        if (r2 == null) goto L8;
        String r3 = r2.n();
        if (r3 == null) goto L8;
    L9:
        String r4 = r3;
        boolean r14 = this.b;
        int r8 = this.l;
        int r9 = this.m;
        int r10 = this.n;
        int r11 = this.o;
        List<String> r5 = this.p;
        List<String> r6 = this.q;
        List<String> r7 = this.r;
        List<String> r15 = this.s;
        List<String> r16 = this.t;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        Observable.just(1).observeOn(Schedulers.computation()).subscribe(new C0190d(r4, r5, r6, r7, r15, r16, r8, r9, r10, r11, r14, r13), e.a);
        return;
    L8:
        r3 = BuildConfig.FLAVOR;
        goto L9
    }

    public final void u() {
        ALogger.i("PublicScreenStatisticsPlugin", "tryReport receiveCnt=" + this.l + " showCnt=" + this.f);
        if (this.l <= 0) goto L6;
        s();
    L6:
        if (this.f <= 0) goto L9;
        t();
        return;
    }

    public final void t() {
        long r8 = System.currentTimeMillis();
        boolean r6 = this.b;
        int r7 = this.f;
        List<String> r1 = this.g;
        List<String> r2 = this.h;
        List<String> r3 = this.i;
        List<String> r4 = this.j;
        List<String> r5 = this.k;
        this.f = 0;
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        Observable.just(1).observeOn(Schedulers.computation()).subscribe(new f(r1, r2, r3, r4, r5, r6, r7, r8), g.a);
    }

    @Override // s42.b
    public final void a(t r2) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r2, "message");
    }

    @Override // s42.b
    public final void i(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r6) {
        Intrinsics.checkNotNullParameter(r6, "message");
        b r7 = r(r6);
        if (r7 != null) goto L5;
        return;
    L5:
        String r0 = r7.a;
        String r1 = r7.b;
        String r2 = r7.c;
        String r3 = r7.d;
        String r8 = r7.e;
        ((ArrayList) this.p).add(r0);
        ((ArrayList) this.q).add(r1);
        ((ArrayList) this.r).add(r8);
        ((ArrayList) this.s).add(r2);
        ((ArrayList) this.t).add(r3);
        switch(r1.hashCode()) {
            case -1975915993: goto L27;
            case -1441604104: goto L24;
            case -414786051: goto L21;
            case -350533872: goto L18;
            case 41447196: goto L15;
            case 799725124: goto L12;
            case 1441356910: goto L9;
            default: goto L29;
        };
    L29:
        int r9 = this.l + 1;
        this.l = r9;
        if (r9 < this.d) goto L33;
        s();
        return;
    L33:
        return;
    L9:
        if (r1.equals("WebcastItemShareMessage") == false) goto L29;
    L28:
        this.o++;
        goto L29
    L12:
        if (r1.equals("WebcastGiftMessage") == false) goto L29;
    L25:
        this.n++;
        goto L29
    L15:
        if (r1.equals("WebcastChatMessage") == false) goto L29;
        this.m++;
        goto L29
    L18:
        if (r1.equals("WebcastVideoShareMessage") == false) goto L29;
    L21:
        if (r1.equals("WebcastLikeMessage") == false) goto L29;
    L24:
        if (r1.equals("GiftGroupMessage") == false) goto L29;
    L27:
        if (r1.equals("WebcastSocialMessage") == false) goto L29;
        goto L28
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.x
    public final void p(l r3) {
        Intrinsics.checkNotNullParameter(r3, "publicScreenContext");
        ALogger.i("PublicScreenStatisticsPlugin", "onLoad");
        Intrinsics.checkNotNullParameter(this, "listener");
        n r4 = this.a;
        if (r4 == null) goto L6;
        r4.addMessageListener(this);
    L6:
        if (this.e <= 0) goto L12;
        Disposable r5 = this.u;
        if (r5 == null) goto L10;
        r5.dispose();
    L10:
        this.u = Observable.interval(this.e, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
        return;
    }

    public final b r(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r15) {
        i r0 = r15.s();
        b r1 = null;
        if (r0 == null) goto L5;
        Long r2 = r0.e;
        String r3 = r0.f;
        IBaseUser r4 = r0.f();
        Long r5 = r0.g;
    L14:
        if (Intrinsics.areEqual(r3, "GiftGroupMessage") == false) goto L16;
        r3 = "WebcastGiftMessage";
    L16:
        boolean r7 = true;
        if (Intrinsics.areEqual(r3, "WebcastRoomMessage") == false) goto L26;
        c4 r6 = r15.b;
        if ((r6 instanceof c4) == true) goto L21;
        r6 = null;
    L21:
        c4 r8 = r6;
        if (r8 == null) goto L26;
        if (r8.isGiftTypeMessage() != true) goto L26;
        String r10 = "WebcastGiftMessage";
    L27:
        if (r10 != null) goto L29;
    L32:
        if (r7 == false) goto L34;
    L67:
        return r1;
    L34:
        if (this.c.contains(r10) == false) goto L67;
        if (r15.A() == false) goto L41;
        ALogger.i("PublicScreenStatisticsPlugin", "filter self message. id=" + r2 + " type=" + r10);
        return null;
    L41:
        if (r4 == null) goto L46;
        String r9 = r4.getIdString();
        if (r9 == null) goto L46;
        String r11 = r9;
    L47:
        if (r4 == null) goto L52;
        String r13 = r4.getNickName();
        if (r13 == null) goto L52;
        String r14 = r13;
    L54:
        if (r2 == null) goto L59;
        String r16 = String.valueOf(r2.longValue());
        if (r16 == null) goto L59;
        String r17 = r16;
    L60:
        if (r5 == null) goto L65;
        String r18 = String.valueOf(r5.longValue());
        if (r18 == null) goto L65;
        String r19 = r18;
    L66:
        r1 = new b(r17, r10, r11, r14, r19);
    L65:
        r19 = BuildConfig.FLAVOR;
    L59:
        r17 = BuildConfig.FLAVOR;
    L52:
        r14 = BuildConfig.FLAVOR;
    L46:
        r11 = BuildConfig.FLAVOR;
        goto L47
    L29:
        if (r10.length() == 0) goto L32;
        r7 = false;
    L26:
        r10 = r3;
        goto L27
    L5:
        T r20 = r15.b;
        if (r20 == 0) goto L8;
        r2 = Long.valueOf(r20.getMessageId());
    L9:
        if (r20 == 0) goto L11;
        r3 = r20.getMessageMethod();
    L12:
        r4 = r15.x();
        r5 = Long.valueOf(r20.getTimestamp());
        goto L14
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    }

    public d(q0 r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        boolean r4 = a0.d(r3, false);
        this.b = r4;
        if (r4 == false) goto L9;
        List<String> r5 = r2.a();
        if (r5 == null) goto L8;
        Set<String> r6 = CollectionsKt.toSet(r5);
        if (r6 == null) goto L8;
    L14:
        this.c = r6;
        this.d = r2.c();
        this.e = r2.d();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.p = new ArrayList();
        this.q = new ArrayList();
        this.r = new ArrayList();
        this.s = new ArrayList();
        this.t = new ArrayList();
        return;
    L8:
        r6 = SetsKt.emptySet();
        goto L14
    L9:
        List<String> r7 = r2.b();
        if (r7 == null) goto L13;
        r6 = CollectionsKt.toSet(r7);
        if (r6 != null) goto L14;
    L13:
        r6 = SetsKt.emptySet();
        goto L14
    }

    @Override // s42.b
    public final void j(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r5, ShowArea r6) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r6, "showArea");
        b r7 = r(r5);
        if (r7 != null) goto L5;
        return;
    L5:
        String r8 = r7.a;
        String r0 = r7.b;
        String r1 = r7.c;
        String r9 = r7.d;
        String r2 = String.valueOf(com.ss.ugc.live.sdk.msg.utils.f.a());
        ((ArrayList) this.i).add(r2);
        ((ArrayList) this.g).add(r8);
        ((ArrayList) this.h).add(r0);
        ((ArrayList) this.j).add(r1);
        ((ArrayList) this.k).add(r9);
        int r10 = this.f + 1;
        this.f = r10;
        if (r10 < this.d) goto L9;
        t();
        return;
    }
}
