package com.bytedance.android.live.revlink.impl.pk.dialog.presenter;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revlink.impl.pk.dialog.contract.InteractDialogPKSearchContract$View;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPKSearchFragment;
import com.bytedance.android.live.revlink.impl.pk.utils.SearchSourceFlag;
import com.bytedance.android.livesdk.link.model.IRivalExtraInfo;
import com.bytedance.android.livesdk.link.model.IRivalRankRecommendResponse;
import com.bytedance.android.livesdk.link.model.u6;
import com.bytedance.android.livesdk.link.model.x8;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class j extends x31.i {
    public final com.bytedance.android.live.revenuelink.connect.f A;
    public final g B;
    public final i11.b C;
    public final f D;
    public final boolean E;
    public final MutableLiveData<List<String>> d;
    public final MutableLiveData<List<x8>> e;
    public final MutableLiveData<u6> f;
    public final MutableLiveData<IRivalRankRecommendResponse> g;
    public final MutableLiveData<Boolean> h;
    public final List<MutableLiveData<?>> i;
    public List<String> j;
    public final List<x8> k;
    public IRivalExtraInfo l;
    public String m;
    public boolean n;
    public boolean o;
    public final MutableLiveData<Boolean> p;
    public final MutableLiveData<Boolean> q;
    public String r;
    public int s;
    public int t;
    public final boolean u;
    public final SearchSourceFlag v;
    public final yz0.l w;
    public final CompositeDisposable x;
    public boolean y;
    public final String z;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ j a;
        public final /* synthetic */ int b;

        public a(j r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            ExtraResponse r5 = (ExtraResponse) r4;
            j r0 = this.a;
            r0.o = false;
            r0.n = ((u6) r5.data).getHasMore();
            this.a.r = ((u6) r5.data).getSearchId();
            j r1 = this.a;
            r1.getClass();
            r1.s += this.b;
            List<x8> r2 = r1.k;
            List r3 = ((u6) r5.data).getAnchorInfo();
            if (r3 != null) goto L6;
            r3 = CollectionsKt.emptyList();
        L6:
            ((ArrayList) r2).addAll(r3);
            ((InteractDialogPKSearchContract$View) this.a.c).ga0((u6) r5.data);
            j r6 = this.a;
            r6.e.postValue(r6.k);
            this.a.f.postValue(r5.data);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ j a;

        public b(j r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            j r0 = this.a;
            r0.o = false;
            MutableLiveData<Boolean> r1 = r0.p;
            Boolean r2 = Boolean.FALSE;
            r1.postValue(r2);
            this.a.q.postValue(r2);
            this.a.d(r4);
            ((InteractDialogPKSearchContract$View) this.a.c).fa0(r4);
            this.a.e.postValue(null);
            this.a.f.postValue(null);
        }
    }

    public final void b() {
        ((com.bytedance.android.livesdk.common.c) this).a = null;
        ((ArrayList) this.k).clear();
        this.n = true;
        this.s = 0;
        this.r = "";
        com.bytedance.android.live.revenuelink.connect.f r1 = this.A;
        if (r1 == null) goto L5;
        r1.removeLinkOutListener(7, this.B);
        this.A.removeLinkOutListener(1, this.B);
    L5:
        i11.b r0 = this.C;
        if (r0 == null) goto L8;
        r0.l(this.D);
    L8:
        this.x.clear();
    }

    public static Map f() {
        return (Map) l51.a.e0.getValue(null, l51.a.a[64]);
    }

    public final void e() {
        this.j.clear();
        Map r0 = f();
        r0.put(String.valueOf(this.z), this.j);
        l51.a.N(r0);
        this.d.postValue(this.j);
    }

    public final int g() {
        if (this.E == false) goto L5;
    L8:
        return 1;
    L5:
        if (this.v == SearchSourceFlag.INVITE_LINKING) goto L8;
        return 0;
    }

    public final void h() {
        Map r0 = f();
        String r1 = this.z;
        if (r1 == null) goto L8;
        if (r0.containsKey(r1) == false) goto L8;
        Object r2 = r0.get(this.z.toString());
        Intrinsics.checkNotNull(r2);
        this.j = (List) r2;
    L14:
        this.d.postValue(this.j);
        return;
    L8:
        if (this.z == null) goto L14;
        if (r0.isEmpty() == false) goto L14;
        com.bytedance.tools.kcp.spongepreference.runtime.a r3 = l51.a.f0;
        KProperty[] r4 = l51.a.a;
        if (Lists.isEmpty((List) r3.getValue(null, r4[65])) == true) goto L14;
        this.j = (List) r3.getValue(null, r4[65]);
        r0.put(this.z.toString(), this.j);
        l51.a.N(r0);
        ArrayList r5 = new ArrayList();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r3.setValue(null, r4[65], r5);
        goto L14
    }

    public final void i(LifecycleOwner r3) {
        Iterator r0 = ((ArrayList) this.i).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        MutableLiveData r1 = (MutableLiveData) r0.next();
        Intrinsics.checkNotNull(r3);
        r1.removeObservers(r3);
        goto L4
    }

    public j(InteractPKSearchFragment r17, boolean r18, SearchSourceFlag r19) {
        Intrinsics.checkNotNullParameter(r19, "searchSourceFlag");
        super(r17);
        this.E = r18;
        MutableLiveData<List<String>> r2 = new MutableLiveData();
        this.d = r2;
        MutableLiveData<List<x8>> r3 = new MutableLiveData();
        this.e = r3;
        MutableLiveData<u6> r4 = new MutableLiveData();
        this.f = r4;
        MutableLiveData<IRivalRankRecommendResponse> r5 = new MutableLiveData();
        this.g = r5;
        MutableLiveData<Boolean> r6 = new MutableLiveData();
        this.h = r6;
        ArrayList r7 = new ArrayList();
        this.i = r7;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.m = "";
        this.n = true;
        MutableLiveData<Boolean> r10 = new MutableLiveData();
        this.p = r10;
        MutableLiveData<Boolean> r12 = new MutableLiveData();
        this.q = r12;
        this.r = "";
        this.v = SearchSourceFlag.UNDEFINE;
        yz0.l r8 = (yz0.l) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.l.class);
        this.w = r8;
        CompositeDisposable r13 = new CompositeDisposable();
        this.x = r13;
        this.z = iz.a.a(com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b());
        com.bytedance.android.live.revenuelink.connect.f r14 = com.bytedance.android.live.revlink.impl.global.b.a();
        this.A = r14;
        g r15 = new g(this);
        this.B = r15;
        f r16 = new f(this);
        this.D = r16;
        this.v = r19;
        SearchSourceFlag r9 = SearchSourceFlag.MAIN_LINK;
        if (r19 != r9) goto L5;
    L8:
        boolean r110 = true;
    L9:
        this.u = r110;
        r7.add(r3);
        r7.add(r2);
        r7.add(r10);
        r7.add(r4);
        r7.add(r12);
        r7.add(r5);
        r7.add(r6);
        if (r8 == null) goto L13;
        com.bytedance.android.live.revenue.common.message.b.T.getClass();
        r13.add(yz0.h.a.a(r8, com.bytedance.android.live.revenue.common.message.b.b, false, 4).subscribe(new e(this)));
    L13:
        if (r14 == null) goto L25;
        if (r19 != r9) goto L16;
        boolean r20 = true;
    L18:
        if (r20 == false) goto L21;
        r14.addLinkOutListener(7, r15);
        goto L25
    L21:
        if (r19 != SearchSourceFlag.INVITE_LINKING) goto L23;
        r14.addLinkOutListener(7, r15);
        goto L25
    L23:
        r14.addLinkOutListener(7, r15);
        goto L25
    L16:
        r20 = false;
    L25:
        if (com.bytedance.android.live.revlink.impl.global.b.N() == null) goto L28;
        com.bytedance.android.live.revlink.impl.pk.service.b r1 = com.bytedance.android.live.revlink.impl.global.b.N();
        Intrinsics.checkNotNull(r1);
        i11.b r22 = r1.getLinkUserCenter();
        this.C = r22;
        Intrinsics.checkNotNull(r22);
        r22.i(r16);
        return;
    L28:
        return;
    L5:
        if (r19 == SearchSourceFlag.INVITE_LINKING) goto L8;
        r110 = false;
        goto L9
    }

    public final void j(String r10, int r12, int r13, String r14, boolean r15, String r16) {
        Intrinsics.checkNotNullParameter(r10, "queryWord");
        Intrinsics.checkNotNullParameter(r14, "searchId");
        Intrinsics.checkNotNullParameter(r16, "activityName");
        if (r15 == false) goto L16;
        this.d.setValue(null);
        Iterator<String> r2 = this.j.iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        String r3 = r2.next();
        if (r3 == null) goto L6;
        if (Intrinsics.areEqual(r3, r10) == false) goto L6;
        this.j.remove(r10);
    L12:
        ListProtector.add(this.j, 0, r10);
        if (this.j.size() <= 10) goto L15;
        List<String> r4 = this.j;
        ListProtector.remove(r4, r4.size() - 1);
    L15:
        Map r5 = f();
        r5.put(String.valueOf(this.z), this.j);
        l51.a.N(r5);
        this.m = r10;
        this.s = 0;
        this.t = r13;
        this.n = true;
        this.r = "";
        ((ArrayList) this.k).clear();
    L18:
        if (this.n == true) goto L20;
        return;
    L20:
        if (this.o == true) goto L38;
        this.o = true;
        this.p.postValue(Boolean.valueOf(r15));
        if (this.u == false) goto L24;
        int r8 = 2;
    L25:
        Observable<ExtraResponse<u6, Extra>> r17 = r31.b.a(r31.a.a).J(r10, r12, r13, r14, r16, r8);
        if (r17 == null) goto L39;
        ObservableSubscribeProxy r18 = (ObservableSubscribeProxy) r17.as(c());
        if (r18 == null) goto L40;
        r18.subscribe(new a(this, r13), new b(this));
        return;
    L40:
        return;
    L39:
        return;
    L24:
        r8 = 0;
        goto L25
    L38:
        return;
    L16:
        this.q.postValue(Boolean.valueOf(this.n));
        goto L18
    }
}
