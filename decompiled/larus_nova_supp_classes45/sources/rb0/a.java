package rb0;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.ktv.common.api.KtvMvApi;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.ktvapi.model.mv.k;
import com.bytedance.android.livesdk.message.model.KtvTypetv;
import com.bytedance.android.livesdk.message.model.od;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements com.bytedance.android.livesdk.ktvapi.model.mv.f {
    public k a;
    public final CompositeDisposable b;
    public long c;
    public long d;
    public boolean e;
    public final NextLiveData<List<od>> f;
    public final NextLiveData<ArrayList<od>> g;
    public final NextLiveData<od> h;
    public Long i;
    public Long j;
    public boolean k;
    public final int l;
    public String m;
    public final long n;
    public final String o;
    public final long p;

    /* JADX INFO: renamed from: rb0.a$a, reason: collision with other inner class name */
    public static final class C0271a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ Function1 b;

        public b(a r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.network.response.e r5 = (com.bytedance.android.live.network.response.e) r4;
            List r0 = (List) this.a.f.getValue();
            if (r0 != null) goto L5;
            r0 = new ArrayList();
        L5:
            List r1 = ((com.bytedance.android.livesdk.ktvapi.model.mv.b) ((ExtraResponse) r5).data).a();
            if (r1 != null) goto L8;
            r1 = new ArrayList();
        L8:
            List r2 = a.l(this.a, r0, r1);
            this.a.f.setValue(r2);
            a r3 = this.a;
            r3.i = Long.valueOf(System.currentTimeMillis());
            Function1 r6 = this.b;
            if (r6 == null) goto L12;
            Unit r7 = (Unit) r6.invoke(((ExtraResponse) r5).data);
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function1 a;

        public c(Function1 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            Function1 r4 = this.a;
            if (r4 == null) goto L5;
            Unit r5 = (Unit) r4.invoke(null);
        L5:
            ALogger.i("OpusMvModel", "changeMv success");
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public d(a r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            com.bytedance.android.live.network.response.a r5 = (com.bytedance.android.live.network.response.a) r4;
            int r6 = this.b;
            KtvTypetv r0 = KtvTypetv.KTVMVType_OFFICIAl;
            if (r6 != r0.ordinal()) goto L6;
            a r7 = this.a;
            r7.m = this.c;
        L6:
            if (this.b != r0.ordinal()) goto L8;
            LiveData r8 = this.a.f;
        L9:
            List r9 = (List) r8.getValue();
            if (r9 == null) goto L21;
            Iterator<T> r11 = r9.iterator();
        L13:
            if (r11.hasNext() == false) goto L17;
            T r1 = r11.next();
            if (Intrinsics.areEqual(((od) r1).f(), this.c) == false) goto L13;
        L18:
            od r2 = (od) r1;
            if (r2 == null) goto L21;
            this.a.h.postValue(r2);
            goto L21
        L17:
            r1 = null;
        L21:
            ALogger.i("OpusMvModel", "chooseMv success");
            return;
        L8:
            r8 = this.a.g;
            goto L9
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
            f2.b(2131918456, 0);
            ALogger.i("OpusMvModel", "chooseMv failed " + ((Throwable) r3).getMessage());
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
            com.bytedance.android.live.network.response.a r3 = (com.bytedance.android.live.network.response.a) r2;
            ALogger.i("OpusMvModel", "playMv success");
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            ALogger.i("OpusMvModel", "playMv error");
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Function1 c;

        public h(a r1, boolean r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            this.a.k = false;
            ALogger.i("requestMvList", "logid:" + ((ExtraResponse) r8).logId);
            com.bytedance.android.livesdk.ktvapi.model.mv.a r9 = (com.bytedance.android.livesdk.ktvapi.model.mv.a) ((ExtraResponse) r8).data;
            a r0 = this.a;
            r0.c = 0;
            r0.d = r9.b();
            this.a.e = r9.a();
            ArrayList r1 = (ArrayList) this.a.g.getValue();
            if (r1 != null) goto L6;
            r1 = new ArrayList();
        L6:
            if (this.b == true) goto L13;
            List r2 = (List) this.a.f.getValue();
            if (r2 != null) goto L10;
            r2 = new ArrayList();
        L10:
            List r3 = r9.d();
            if (r3 == null) goto L13;
            this.a.f.setValue(a.l(this.a, r2, r3));
            this.a.i = Long.valueOf(System.currentTimeMillis());
        L13:
            ALogger.i("requestMvList", "personalMVList:" + r9.e() + "---");
            ALogger.i("requestMvList", "cursor:" + r9.b() + "---" + r9.c() + "---" + r9.a());
            Collection r4 = r9.e();
            if (r4 != null) goto L16;
            r4 = new ArrayList();
        L16:
            Iterator<T> r5 = r4.iterator();
        L18:
            if (r5.hasNext() == false) goto L23;
            od r6 = (od) r5.next();
            if (r6.e() != KtvTypetv.KTVMVType_Unknown.ordinal()) goto L18;
            r6.i(KtvTypetv.KTVMVType_PERSONAL.ordinal());
            goto L18
        L23:
            if (this.b == false) goto L25;
            r1.clear();
        L25:
            r1.addAll(r4);
            this.a.g.setValue(r1);
            this.a.j = Long.valueOf(System.currentTimeMillis());
            Function1 r11 = this.c;
            if (r11 == null) goto L34;
            Unit r12 = (Unit) r11.invoke(r9);
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ a a;
        public final /* synthetic */ Function1 b;

        public i(a r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Throwable r3 = (Throwable) r2;
            this.a.k = false;
            ALogger.i("OpusMvModel", "getMVList error");
            Function1 r4 = this.b;
            if (r4 == null) goto L6;
            Unit r5 = (Unit) r4.invoke(null);
            return;
        }
    }

    static {
    }

    public final void h() {
        com.bytedance.android.live.ktv.common.util.g.f("playMv:" + this.p + "，needPlay" + this.o);
        this.b.add(((KtvMvApi) com.bytedance.android.live.network.c.b().e(KtvMvApi.class)).startPlayMv(this.n, this.p, d5.c(this.o), this.o).compose(RxUtil.rxSchedulerHelper()).subscribe(f.a, g.a));
    }

    public final void release() {
        com.bytedance.android.live.ktv.common.util.g.f("model release");
        CompositeDisposable r0 = this.b;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public final NextLiveData<od> e() {
        return this.h;
    }

    public final NextLiveData<List<od>> f() {
        return this.f;
    }

    public final long getMId() {
        return this.p;
    }

    public final String getSingerId() {
        return this.o;
    }

    public final k i() {
        return this.a;
    }

    public final NextLiveData<ArrayList<od>> j() {
        return this.g;
    }

    public static void m(od r2) {
        r2.getClass();
        if (r2.e() != KtvTypetv.KTVMVType_Unknown.ordinal()) goto L6;
        r2.i(KtvTypetv.KTVMVType_OFFICIAl.ordinal());
        return;
    }

    public final void a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void c(Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r12, "cb");
        long r0 = System.currentTimeMillis();
        Long r2 = this.j;
        if (r2 == null) goto L5;
        long r5 = r2.longValue();
    L6:
        boolean r3 = false;
        if ((r0 - r5) <= this.l) goto L9;
        boolean r6 = true;
    L10:
        Long r7 = this.i;
        if (r7 == null) goto L13;
        long r8 = r7.longValue();
    L15:
        if ((r0 - r8) <= this.l) goto L17;
        r3 = true;
    L17:
        com.bytedance.android.live.ktv.common.util.g.f("opusMvExpired:" + r6 + "，officeMvExpired:" + r3);
        if (r6 == false) goto L21;
        if (r3 == false) goto L21;
        k(true, null);
        return;
    L21:
        if (r3 == false) goto L23;
        b(true, null);
        NextLiveData<ArrayList<od>> r13 = this.g;
        r13.setValue(r13.getValue());
        return;
    L23:
        if (r6 == false) goto L28;
        this.c = 0;
        this.d = 0;
        ArrayList r14 = (ArrayList) this.g.getValue();
        if (r14 == null) goto L27;
        r14.clear();
    L27:
        n(true, null);
        NextLiveData<List<od>> r15 = this.f;
        r15.setValue(r15.getValue());
        return;
    L28:
        r12.invoke();
        return;
    L13:
        r8 = 0;
        goto L15
    L9:
        r6 = false;
        goto L10
    L5:
        r5 = 0;
        goto L6
    }

    public final void g(od r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        this.h.postValue(r3);
        if (r3.e() != KtvTypetv.KTVMVType_OFFICIAl.ordinal()) goto L6;
        this.m = r3.f();
        return;
    }

    public final void b(boolean r4, Function1<? super com.bytedance.android.livesdk.ktvapi.model.mv.b, Unit> r5) {
        com.bytedance.android.live.ktv.common.util.g.f("changeMv");
        ArrayList r0 = new ArrayList();
        if (r4 == true) goto L10;
        List r6 = (List) this.f.getValue();
        if (r6 == null) goto L10;
        Iterator r7 = r6.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        r0.add(((od) r7.next()).f());
    L10:
        Disposable r8 = ((KtvMvApi) com.bytedance.android.live.network.c.b().e(KtvMvApi.class)).changeMv(this.n, r0).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r5), new c(r5));
        this.b.add(r8);
    }

    public final void k(boolean r4, Function1<? super com.bytedance.android.livesdk.ktvapi.model.mv.a, Unit> r5) {
        if (this.k == false) goto L5;
        return;
    L5:
        if (r4 == false) goto L12;
        this.c = 0;
        this.d = 0;
        ArrayList r0 = (ArrayList) this.g.getValue();
        if (r0 == null) goto L9;
        r0.clear();
    L9:
        List r1 = (List) this.f.getValue();
        if (r1 == null) goto L12;
        r1.clear();
    L12:
        ALogger.i("requestMvList", "minCursor:" + this.c + "，maxCursor：" + this.d);
        if (this.e == true) goto L16;
        if (r4 == true) goto L16;
        return;
    L16:
        n(false, r5);
    }

    public final void n(boolean r12, Function1<? super com.bytedance.android.livesdk.ktvapi.model.mv.a, Unit> r13) {
        IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L5;
        boolean r9 = r0.isNeedProtectUnderage();
    L6:
        com.bytedance.android.live.ktv.common.util.g.f("requestRemoteMvList:" + this.d);
        this.k = true;
        this.b.add(((KtvMvApi) com.bytedance.android.live.network.c.b().e(KtvMvApi.class)).getMVList(this.n, this.c, this.d, 18, r9, "ktv_mode").compose(RxUtil.rxSchedulerHelper()).subscribe(new h(this, r12, r13), new i(this, r13)));
        return;
    L5:
        r9 = false;
        goto L6
    }

    public a(long r2, String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "singerId");
        this.n = r2;
        this.o = r4;
        this.p = r5;
        this.a = new k(r5, r4);
        this.b = new CompositeDisposable();
        this.e = true;
        this.f = new NextLiveData();
        this.g = new NextLiveData();
        this.h = new NextLiveData();
        this.l = ((Number) vm2.h.I1.getValue(null, vm2.h.a[137(0x89, float:1.92E-43)])).intValue();
        com.bytedance.android.live.ktv.common.util.g.f("model init." + r4 + "--" + r5);
    }

    public static final List l(a r8, List r9, List r11) {
        String r12 = r8.m;
        ArrayList r0 = new ArrayList();
        LinkedHashMap r1 = new LinkedHashMap();
        List r13 = r11;
        Iterator r2 = r13.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        od r3 = (od) r2.next();
        m(r3);
        String r5 = r3.f();
        if ((true ^ StringsKt.isBlank(r5)) == false) goto L4;
        r1.put(r5, r3);
        goto L4
    L8:
        LinkedHashMap r4 = new LinkedHashMap();
        List r14 = r9;
        Iterator r6 = r14.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        od r7 = (od) r6.next();
        m(r7);
        String r15 = r7.f();
        if ((!StringsKt.isBlank(r15)) == false) goto L10;
        r4.put(r15, r7);
        goto L10
    L14:
        if (r12 == null) goto L20;
        od r16 = (od) r1.get(r12);
        if (r16 != null) goto L18;
        r16 = (od) r4.get(r12);
    L18:
        if (r16 == null) goto L20;
        r0.add(r16);
    L20:
        Iterator r17 = r13.iterator();
    L21:
        boolean r18 = false;
        if (r17.hasNext() == false) goto L40;
        od r19 = (od) r17.next();
        m(r19);
        String r21 = r19.f();
        if ((!StringsKt.isBlank(r21)) == false) goto L21;
        if (r12 == null) goto L29;
        if ((!Intrinsics.areEqual(r21, r12)) == false) goto L21;
    L29:
        if (r0.isEmpty() == true) goto L37;
        Iterator r22 = r0.iterator();
    L33:
        if (r22.hasNext() == false) goto L37;
        if (Intrinsics.areEqual(((od) r22.next()).f(), r21) == false) goto L33;
    L38:
        if (r18 == false) goto L21;
        r0.add(r19);
    L37:
        r18 = true;
        goto L38
    L40:
        Iterator r23 = r14.iterator();
    L42:
        if (r23.hasNext() == false) goto L57;
        od r24 = (od) r23.next();
        m(r24);
        String r110 = r24.f();
        if ((!StringsKt.isBlank(r110)) == false) goto L42;
        if (r0.isEmpty() == true) goto L54;
        Iterator r25 = r0.iterator();
    L50:
        if (r25.hasNext() == false) goto L54;
        if (Intrinsics.areEqual(((od) r25.next()).f(), r110) == false) goto L50;
        boolean r111 = false;
    L55:
        if (r111 == false) goto L42;
        r0.add(r24);
    L54:
        r111 = true;
        goto L55
    L57:
        return r0;
    }

    public final void d(String r13, int r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r13, "videoId");
        com.bytedance.android.live.ktv.common.util.g.f("chooseMv:" + r13 + "，needPlay" + r15);
        this.b.add(((KtvMvApi) com.bytedance.android.live.network.c.b().e(KtvMvApi.class)).chooseMv(this.n, this.p, d5.c(this.o), this.o, r13, r14, r15).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r14, r13), e.a));
    }
}
