package com.bytedance.android.live.search.impl.search;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.config.br0;
import com.google.gson.JsonObject;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    public static final /* synthetic */ int k = 0;
    public boolean a;
    public long b;
    public String c;
    public boolean d;
    public long e;
    public String f;
    public ra1.e g;
    public Disposable h;
    public final e i;
    public final qa1.d<ra1.f> j;

    public static final class a {
    }

    public static final class b implements qa1.a {
        public final /* synthetic */ h a;

        @Override // qa1.a
        public final void a() {
            h r0 = this.a;
            r0.a = false;
            qa1.d<ra1.f> r1 = r0.j;
            new JsonObject();
            r1.r6();
        }

        public b(h r1) {
            this.a = r1;
        }

        @Override // qa1.a
        public final void c(Throwable r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "exception");
            h r0 = this.a;
            r0.a = false;
            if (r4 == false) goto L5;
            r0.j.cF(new Exception(r3));
            return;
        L5:
            r0.j.q10(new Exception(r3));
        }

        @Override // qa1.a
        public final void b(ra1.b r4, boolean r5, String r6) {
            Intrinsics.checkNotNullParameter(r4, "response");
            Intrinsics.checkNotNullParameter(r6, "keyWord");
            h r0 = this.a;
            r0.a = false;
            r0.d = true;
            List<ra1.f> r1 = r4.f();
            if (r1 != null) goto L5;
        L12:
            if (r5 == true) goto L17;
            this.a.j.r6();
            return;
        L17:
            return;
        L5:
            if ((!r1.isEmpty()) == true) goto L8;
            r1 = null;
        L8:
            if (r1 == null) goto L12;
            if (r5 == false) goto L11;
            h r7 = this.a;
            r7.g = r4.k(r7.g);
            h r8 = this.a;
            r8.j.C6(r1, r8.d);
            return;
        L11:
            this.a.g = r4.a();
            h r9 = this.a;
            r9.j.Hm(r1, r9.d, r6, true);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ h a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public c(h r1, long r2, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        public final void accept(Object r8) {
            ra1.e r9 = (ra1.e) r8;
            long r0 = this.b;
            h r2 = this.a;
            if (r0 != r2.e) goto L54;
            r2.g = r9.a();
            h r1 = this.a;
            boolean r3 = false;
            r1.a = false;
            r1.d = r9.d();
            this.a.b = r9.c();
            this.a.c = r9.e();
            if (r9.i() != 2483) goto L8;
        L40:
            qa1.d<ra1.f> r4 = this.a.j;
            if (r9.i() != 2483) goto L43;
            r3 = true;
        L43:
            r4.dH(r3);
            return;
        L8:
            if ("hit_limit".equals(r9.j()) == true) goto L40;
            this.a.j.Ac(r9.g(), r9.e());
            List<ra1.f> r5 = r9.f();
            if (r5 != null) goto L13;
        L30:
            h r6 = this.a;
            Integer r7 = (Integer) br0.a.getValue();
            if (r7 != null) goto L34;
        L39:
            r6.j.r6();
            return;
        L34:
            if (r7.intValue() != 1) goto L39;
            if (r9.h() == false) goto L38;
            r6.i.b(false, this.c);
            r6.a = true;
            return;
        L38:
            r6.j.r6();
            return;
        L13:
            if ((!r5.isEmpty()) == true) goto L16;
            r5 = null;
        L16:
            if (r5 == null) goto L30;
            Iterator<T> r10 = r5.iterator();
        L19:
            if (r10.hasNext() == false) goto L29;
            ra1.f r12 = (ra1.f) r10.next();
            ra1.a r13 = r12.a();
            if (r13 == null) goto L23;
            String r14 = r9.e();
            Intrinsics.checkNotNullParameter(r14, "<set-?>");
            r13.a = r14;
        L23:
            ra1.a r15 = r12.a();
            if (r15 == null) goto L19;
            JsonObject r16 = r9.g();
            if (r16 != null) goto L28;
            r16 = new JsonObject();
        L28:
            Intrinsics.checkNotNullParameter(r16, "<set-?>");
            r15.b = r16;
            goto L19
        L29:
            h r17 = this.a;
            r17.j.Hm(r5, r17.d, this.c, false);
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ h a;

        public d(h r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            h r0 = this.a;
            r0.a = false;
            r0.j.q10(new Exception((Throwable) r3));
        }
    }

    static {
    }

    public h(qa1.d<ra1.f> r2) {
        Intrinsics.checkNotNullParameter(r2, "presenterCallback");
        this.j = r2;
        this.c = "";
        this.d = true;
        this.f = "normal_search";
        this.i = new e(new b(this));
    }

    public final void a(String r16, String r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r16, "keyWord");
        if (this.a == false) goto L12;
        Disposable r2 = this.h;
        if (r2 == null) goto L12;
        if (r2.isDisposed() == true) goto L12;
        Disposable r3 = this.h;
        if (r3 == null) goto L12;
        r3.dispose();
    L12:
        if (TextUtils.isEmpty(r17) == true) goto L17;
        if (r17 != null) goto L15;
        String r4 = "";
    L16:
        this.f = r4;
        goto L17
    L15:
        r4 = r17;
    L17:
        String r5 = "normal_search";
        if (Intrinsics.areEqual("default_search_keyword", r17) == false) goto L20;
        this.f = "normal_search";
    L20:
        e r1 = this.i;
        if (r18 == false) goto L23;
        int r6 = 10;
    L24:
        r1.b = r6;
        if (r18 == false) goto L27;
        String r7 = "homepage_fresh-live_cover";
    L28:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r1.c = r7;
        this.a = true;
        long r13 = this.e + 1;
        this.e = r13;
        this.b = 0;
        this.j.showLoading();
        ILiveSearchApi r8 = (ILiveSearchApi) com.bytedance.android.live.network.c.b().e(ILiveSearchApi.class);
        long r9 = this.b;
        if (TextUtils.isEmpty(this.f) == true) goto L32;
        r5 = this.f;
    L32:
        String r10 = r5;
        String r12 = jc1.k.n(IHostBusiness.class).getNeedPersonalRecommend();
        if (r12 != null) goto L35;
        r12 = DataType.TRUE;
    L35:
        this.h = r8.searchLiveList("https://search.amemv.com/aweme/v1/live/search/", r9, r16, 12, r10, "aweme_live_square", "", r12, jc1.k.n(IHostBusiness.class).getCurrentBcmChain()).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(this, r13, r16), new d(this));
        return;
    L27:
        r7 = "live_merge-live_cover";
        goto L28
    L23:
        r6 = 21;
        goto L24
    }
}
