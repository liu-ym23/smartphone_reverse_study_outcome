package com.bytedance.android.live.liveinteract.linksecurity;

import android.util.Log;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.y;
import com.bytedance.android.live.core.utils.rxutils.z;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class LinkSecurityMonitor {
    public static final /* synthetic */ int f = 0;
    public b a;
    public final CompositeDisposable b;
    public final c c;
    public final LinkSecurityMonitor$anchorBroadcastEndObserver$1 d;
    public final Set<Integer> e;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final Map<String, String> c;
        public final String d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L14;
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
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
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
            Map<String, String> r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
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
            return "SecurityMonitorInfo(biz=" + this.a + ", sense=" + this.b + ", params=" + this.c + ", timeStamp=" + this.d + ")";
        }

        public b(String r2, String r3, Map<String, String> r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "biz");
            Intrinsics.checkNotNullParameter(r3, "sense");
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r5, "timeStamp");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class c extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public final DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA);
        }

        public c() {
        }
    }

    public static final class d<T> implements ObservableOnSubscribe {
        public final /* synthetic */ DataCenter a;

        public static final class a implements ttc.c {
            public final /* synthetic */ d a;
            public final /* synthetic */ Observer b;

            public a(d r1, b r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void cancel() {
                DataCenter r0 = this.a.a;
                if (r0 == null) goto L6;
                r0.removeObserver(this.b);
                return;
            }
        }

        public static final class b<T> implements Observer {
            public final /* synthetic */ ObservableEmitter a;

            public b(ObservableEmitter r1) {
                this.a = r1;
            }

            public final void onChanged(Object r4) {
                KVData r5 = (KVData) r4;
                if (r5 == null) goto L6;
                Iterable r6 = (List) r5.getData();
                if (r6 == null) goto L6;
            L7:
                Iterator<T> r7 = r6.iterator();
            L8:
                Object r1 = null;
                if (r7.hasNext() == false) goto L16;
                T r0 = r7.next();
                IBaseUser r2 = ((ILinkPlayerInfoBridge) r0).getUser();
                if (r2 == null) goto L14;
                r1 = r2.getIdString();
            L14:
                if (Intrinsics.areEqual(r1, k.n(IMiddlewareUserService.class).user().n()) == false) goto L8;
                r1 = r0;
            L16:
                ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r1;
                if (r3 == null) goto L19;
                this.a.onNext(r3);
                return;
            L19:
                ALogger.e("LinkSecurityMonitor", "can not find self in online list info");
                return;
            L6:
                r6 = new ArrayList();
                goto L7
            }
        }

        public d(DataCenter r1) {
            this.a = r1;
        }

        public final void subscribe(ObservableEmitter<ILinkPlayerInfoBridge> r4) {
            Intrinsics.checkNotNullParameter(r4, "emmiter");
            b r0 = new b(r4);
            DataCenter r1 = this.a;
            if (r1 == null) goto L5;
            r1.observe("data_online_changed_list", r0);
        L5:
            r4.setCancellable(new a(this, r0));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LinkSecurityMonitor a;

        public e(LinkSecurityMonitor r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            y r5 = (y) r4;
            ILinkPlayerInfoBridge r0 = (ILinkPlayerInfoBridge) r5.a;
            ILinkPlayerInfoBridge r6 = (ILinkPlayerInfoBridge) r5.b;
            Set<Integer> r1 = this.a.e;
            if (r0 == null) goto L5;
            Integer r2 = Integer.valueOf(r0.getSilenceStatus());
        L7:
            if (CollectionsKt.contains(r1, r2) == true) goto L12;
            if (this.a.e.contains(Integer.valueOf(r6.getSilenceStatus())) == false) goto L12;
            LinkSecurityMonitor r3 = this.a;
            r3.i(r0, r6, r3.a);
        L12:
            if (r0 == null) goto L16;
            if (r0.getLinkType() != 2) goto L16;
            return;
        L16:
            if (r6.getLinkType() != 2) goto L20;
            LinkSecurityMonitor r7 = this.a;
            r7.h(r0, r6, r7.a);
            return;
        L20:
            return;
        L5:
            r2 = null;
            goto L7
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r2) {
            ALogger.e("LinkSecurityMonitor", (Throwable) r2);
        }
    }

    static {
    }

    public abstract String f();

    public abstract void g();

    public abstract void h(ILinkPlayerInfoBridge r1, ILinkPlayerInfoBridge r2, b r3);

    public abstract void i(ILinkPlayerInfoBridge r1, ILinkPlayerInfoBridge r2, b r3);

    public static boolean b() {
        return ((Boolean) vm2.d.m3.getValue(null, vm2.d.a[218(0xda, float:3.05E-43)])).booleanValue();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.liveinteract.linksecurity.LinkSecurityMonitor$anchorBroadcastEndObserver$1] */
    public LinkSecurityMonitor() {
        this.b = new CompositeDisposable();
        this.c = new c();
        this.d = new LinkSecurityMonitor$anchorBroadcastEndObserver$1(this);
        this.e = SetsKt.setOf(new Integer[]{1, 2, 3, 4});
    }

    public final void j() {
        if (b() == true) goto L5;
        return;
    L5:
        DataCenter r0 = m.i().getDataCenter();
        if (r0 == null) goto L9;
        r0.observe("cmd_anchor_broadcast_end", this.d);
        return;
    }

    public final void l() {
        if (b() == true) goto L6;
        return;
    L6:
        if (((Boolean) vm2.d.n3.getValue(null, vm2.d.a[219(0xdb, float:3.07E-43)])).booleanValue() == true) goto L8;
        return;
    L8:
        this.b.clear();
    }

    public static void a(Map r2) {
        if (b() == true) goto L5;
        return;
    L5:
        r2.put("scene", String.valueOf(je0.d.f()));
        Integer r0 = je0.d.h();
        if (r0 == null) goto L8;
        r2.put("ui_layout", String.valueOf(r0.intValue()));
    L8:
        r2.put("play_mode", u0.b());
        r2.put("stack_track", Log.getStackTraceString(new Throwable()));
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L12;
        String r1 = "anchor";
    L15:
        r2.put("role", r1);
        r2.put("is_self_singer", String.valueOf(je0.d.G()));
        return;
    L12:
        if (hd0.c.f().h() == false) goto L14;
        r1 = "guest";
        goto L15
    L14:
        r1 = "user";
        goto L15
    }

    public final void k(DataCenter r4) {
        if (b() == true) goto L6;
        return;
    L6:
        if (((Boolean) vm2.d.n3.getValue(null, vm2.d.a[219(0xdb, float:3.07E-43)])).booleanValue() == true) goto L8;
        return;
    L8:
        l();
        RxUtilKt.c(Observable.create(new d(r4)).compose(new z()).subscribe(new e(this), f.a), this.b);
    }

    public final void c(String r10, Map<String, String> r11, com.bytedance.android.live.core.privacy.av.api.b r12, com.bytedance.android.live.core.privacy.av.api.a r13) {
        Intrinsics.checkNotNullParameter(r10, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r11);
        String r1 = f();
        DateFormat r2 = this.c.get();
        if (r2 == null) goto L8;
        String r3 = r2.format(new Date());
    L9:
        this.a = new b(r1, r10, r11, String.valueOf(r3));
        q60.a.d.d(f(), r10, r11, r12, r13);
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final void d(String r10, Map<String, String> r11, com.bytedance.android.live.core.privacy.av.api.b r12, com.bytedance.android.live.core.privacy.av.api.a r13) {
        Intrinsics.checkNotNullParameter(r10, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r11);
        String r1 = f();
        DateFormat r2 = this.c.get();
        if (r2 == null) goto L8;
        String r3 = r2.format(new Date());
    L9:
        this.a = new b(r1, r10, r11, String.valueOf(r3));
        q60.a.d.c(f(), r10, r11, r12, r13);
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final void e(String r10, Map<String, String> r11, com.bytedance.android.live.core.privacy.av.api.b r12, com.bytedance.android.live.core.privacy.av.api.a r13) {
        Intrinsics.checkNotNullParameter(r10, "sense");
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        Intrinsics.checkNotNullParameter(r13, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r11);
        String r1 = f();
        DateFormat r2 = this.c.get();
        if (r2 == null) goto L8;
        String r3 = r2.format(new Date());
    L9:
        this.a = new b(r1, r10, r11, String.valueOf(r3));
        q60.a.d.e(f(), r10, r11, r12, r13);
        return;
    L8:
        r3 = null;
        goto L9
    }
}
