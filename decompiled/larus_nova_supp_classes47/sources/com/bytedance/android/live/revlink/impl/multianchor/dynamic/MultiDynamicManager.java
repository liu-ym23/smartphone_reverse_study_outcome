package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.multianchor.utils.x;
import com.bytedance.android.live.revlink.impl.settings.dynamic.LinkMultiDynamicSettingsKt;
import com.bytedance.android.live.revlink.scopeui.LynxBizType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import w20.ae;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class MultiDynamicManager implements com.bytedance.android.live.revlink.impl.lynxcontainer.a {
    public static final /* synthetic */ int x = 0;
    public final CompositeDisposable a;
    public final HashMap<String, zy0.b> b;
    public final HashMap<String, com.bytedance.android.live.revlink.impl.lynxcontainer.b> c;
    public final HashMap<String, ArrayList<JSONObject>> d;
    public final ArrayList<String> e;
    public final MutableLiveData<JSONObject> f;
    public final ArrayList<JSONObject> g;
    public final MultiDynamicLayoutManager h;
    public zy0.b i;
    public boolean j;
    public IRoom k;
    public com.bytedance.android.live.revlink.impl.multianchor.service.h l;
    public final MultiDynamicManager$screenChangeObserver$1 m;
    public final Lazy n;
    public final HashMap<String, LiveData<?>> o;
    public final MultiRegisterViewListenContext p;
    public final Map<String, LiveData<Pair<String, JSONObject>>> q;
    public final MultiDynamicManager$sendDataToLynxObserver$1 r;
    public final Function0<Integer> s;
    public final x51.a t;
    public final com.bytedance.android.livesdk.revenue.service.room.c u;
    public final com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d v;
    public final h w;

    public static final class a {
        public zy0.b a;

        public a() {
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ zy0.b a;
        public final /* synthetic */ String b;

        public c(zy0.b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            xy0.a<?> r0 = this.a.g();
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isDisposed() == true) goto L9;
            r0.sendJsEvent(this.b, r4);
            return;
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
            jy0.b.b("MultiDynamicManager", "sendJsEvent error", (Throwable) r3);
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void e() {
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void k() {
    }

    public final void o() {
        this.j = true;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r1 = this.v;
        if (r1 == null) goto L7;
        LiveData<Boolean> r2 = r1.getChangeScreenEvent();
        if (r2 == null) goto L7;
        r2.observeForever(this.m);
    L7:
        f31.i r3 = null;
        if (Intrinsics.areEqual(this.w, h.b.b) == false) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r4 = this.v;
        if (r4 == null) goto L12;
        MultiEnterRoomTracer r5 = r4.e();
    L13:
        if (r5 == null) goto L16;
        i97.a r6 = i97.a.a;
        r5.p = System.currentTimeMillis();
        goto L16
    L12:
        r5 = null;
    L16:
        if ((true ^ Intrinsics.areEqual(this.w, h.a.b)) == true) goto L19;
        y41.f r0 = y41.f.N;
        r0.getClass();
        if (((Boolean) y41.f.D.getValue(r0, y41.f.a[28])).booleanValue() == false) goto L19;
    L20:
        MultiDynamicLayoutManager r7 = this.h;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r8 = r7.e;
        if (r8 == null) goto L25;
        LiveData<f31.i> r9 = r8.getWindowStatus();
        if (r9 == null) goto L25;
        r9.observeForever(r7.c);
    L25:
        MultiDynamicLayoutManager$windowStatusObserver$1 r10 = r7.c;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r12 = r7.e;
        if (r12 == null) goto L30;
        LiveData<f31.i> r13 = r12.getWindowStatus();
        if (r13 == null) goto L30;
        r3 = (f31.i) r13.getValue();
    L30:
        r10.a(r3);
        this.p.a();
        Iterator<String> r14 = this.o.keySet().iterator();
    L32:
        if (r14.hasNext() == false) goto L36;
        LiveData<Pair<String, JSONObject>> r15 = this.q.get(r14.next());
        if (r15 == null) goto L32;
        x.e(r15, this.r);
        goto L32
    L36:
        return;
    L19:
        ((Number) this.s.invoke()).intValue();
        p();
        goto L20
    }

    public final void q() {
        this.j = false;
        Iterator<String> r0 = this.o.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        String r1 = r0.next();
        LiveData<Pair<String, JSONObject>> r2 = this.q.get(r1);
        if (r2 == null) goto L4;
        r2.removeObserver(this.r);
        goto L4
    L8:
        this.a.clear();
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r3 = this.v;
        if (r3 == null) goto L13;
        LiveData<Boolean> r4 = r3.getChangeScreenEvent();
        if (r4 == null) goto L13;
        r4.removeObserver(this.m);
    L13:
        Iterator<T> r5 = this.b.values().iterator();
    L15:
        if (r5.hasNext() == false) goto L19;
        zy0.b r6 = (zy0.b) r5.next();
        if (r6 == null) goto L15;
        r6.dispose();
        goto L15
    L19:
        this.b.clear();
        this.c.clear();
        this.d.clear();
        MultiDynamicLayoutManager r7 = this.h;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r8 = r7.e;
        if (r8 == null) goto L24;
        LiveData<f31.i> r9 = r8.getWindowStatus();
        if (r9 == null) goto L24;
        r9.removeObserver(r7.c);
    L24:
        r7.a.clear();
        r7.d.removeAll();
        this.p.b();
        this.i = null;
        this.k = null;
    }

    public static String r() {
        if (com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.g() == false) goto L6;
        return "H5_revenueInteractData";
    L6:
        return "H5_webcastNotification";
    }

    public final void p() {
        if ((!Intrinsics.areEqual(this.w, h.b.b)) == false) goto L7;
        if (this.k != null) goto L7;
        return;
    L7:
        if (this.j == true) goto L10;
        return;
    L10:
        if (this.i == null) goto L13;
        return;
    L13:
        if (((Number) this.s.invoke()).intValue() != 7) goto L15;
        final boolean r0 = true;
    L16:
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r2 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.m;
        r2.getClass();
        if (r0 == false) goto L22;
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r3 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r3.getClass();
        ReadOnlyProperty r4 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.D;
        KProperty[] r5 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.a;
        if (((Boolean) r4.getValue(r3, r5[28])).booleanValue() == false) goto L21;
        String r6 = (String) com.bytedance.android.live.revlink.impl.settings.dynamic.a.E.getValue(r3, r5[29]);
    L23:
        this.i = n((com.bytedance.android.live.revlink.impl.lynxcontainer.b) GsonProtectorUtils.fromJson(l97.a.a, r6, TypesJVMKt.getJavaType(Reflection.typeOf(com.bytedance.android.live.revlink.impl.lynxcontainer.b.class))), true, new MultiDynamicManager$checkAndLoadCentral$1(this, r0));
        return;
    L21:
        r6 = r2.a().m8();
        goto L23
    L22:
        r6 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.e(false);
        goto L23
    L15:
        r0 = false;
        goto L16
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void a(List<String> r2) {
        List<String> r0 = r2;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator<String> r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        v(com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r3.next()));
        goto L13
    L15:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final String c(List<String> r4) {
        JSONObject r0 = new JSONObject();
        List<String> r1 = r4;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        Iterator<String> r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L22;
        String r3 = r5.next();
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r6 = this.v;
        if (r6 == null) goto L19;
        String r7 = r6.f(r3);
        if (r7 == null) goto L19;
    L20:
        r0.put(r3, r7);
    L19:
        r7 = "";
        goto L20
    L22:
        return r0.toString();
    L11:
        return r0.toString();
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final JSONObject f(List<String> r4) {
        JSONObject r0 = new JSONObject();
        List<String> r1 = r4;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return r0;
    L11:
        Iterator<String> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L20;
        String r3 = r5.next();
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r6 = this.v;
        if (r6 == null) goto L18;
        String r7 = r6.f(r3);
        if (r7 == null) goto L18;
    L19:
        r0.put(r3, r7);
    L18:
        r7 = "";
        goto L19
    L20:
        return r0;
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void g(List<String> r4) {
        List<String> r0 = r4;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator<String> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r2 = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r5.next());
        this.c.put(r2.o(), r2);
        goto L13
    L15:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void h(List<String> r5) {
        List<String> r0 = r5;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator<String> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L19;
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r2 = com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r6.next());
        this.c.remove(r2.o());
        zy0.b r3 = this.b.remove(r2.o());
        if (r3 == null) goto L13;
        MultiDynamicLayoutManager r4 = this.h;
        String r7 = r2.o();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "tag");
        r4.d.d(r7, r3);
        if (r3.isDisposed() == true) goto L13;
        r3.dispose();
        goto L13
    L19:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void i(List<String> r4) {
        List<String> r0 = r4;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator<T> r5 = r4.iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        String r2 = (String) r5.next();
        Intrinsics.checkNotNullParameter(r2, "$this$toLynxViewParams");
        n(com.bytedance.android.live.revlink.impl.lynxcontainer.d.a(r2), false, null);
        goto L13
    L15:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void l(CallContext r2) {
        Intrinsics.checkNotNullParameter(r2, "callContext");
        this.p.d(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final int m(ae r7) {
        Intrinsics.checkNotNullParameter(r7, "params");
        List r0 = r7.b;
        int r1 = 0;
        if (r0 == null) goto L11;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        String r3 = (String) r2.next();
        JSONObject r4 = new JSONObject();
        r4.put("type", "message_from_other");
        r4.put("from", r7.a);
        r4.put(Constants.Keys.DATA, r7.c);
        if (this.b.get(r3) == null) goto L9;
        u(this.b.get(r3), r(), r4.toString());
        goto L6
    L9:
        r1 = 1;
    L11:
        return r1;
    }

    public final void v(com.bytedance.android.live.revlink.impl.lynxcontainer.b r3) {
        zy0.b r0 = this.b.get(r3.o());
        if (r0 != null) goto L5;
        return;
    L5:
        this.h.a(r3, r0);
        this.c.put(r3.o(), r3);
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void b(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "event");
        Intrinsics.checkNotNullParameter(r5, "action");
        JSONObject r0 = new JSONObject();
        r0.put("type", r4);
        r0.put(Constants.Keys.DATA, r5);
        Iterator<Map.Entry<String, com.bytedance.android.live.revlink.impl.lynxcontainer.b>> r6 = this.c.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Map.Entry<String, com.bytedance.android.live.revlink.impl.lynxcontainer.b> r7 = r6.next();
        String r1 = r7.getKey();
        com.bytedance.android.live.revlink.impl.lynxcontainer.b r8 = r7.getValue();
        u(this.b.get(r1), r(), r0.toString());
        goto L4
    }

    @Override // com.bytedance.android.live.revlink.impl.lynxcontainer.a
    public final void d(CallContext r2, List<String> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "tags");
        this.p.c(r2, r3);
    }

    public final boolean s(com.bytedance.android.live.revlink.impl.lynxcontainer.b r4, String r5) {
        if (Intrinsics.areEqual(this.w, h.a.b) == false) goto L13;
        if (r4 == null) goto L20;
        List<String> r6 = r4.n();
        if (r6 != null) goto L8;
        return false;
    L8:
        if (r6.contains(r5) == true) goto L10;
        return false;
    L10:
        if (ArraysKt.contains(com.bytedance.android.live.revlink.impl.settings.dynamic.a.H.a(), r5) == true) goto L23;
        return true;
    L23:
        return false;
    L20:
        return false;
    L13:
        if (r4 == null) goto L24;
        List<String> r7 = r4.n();
        if (r7 != null) goto L17;
        return false;
    L17:
        if (r7.contains(r5) != true) goto L26;
        return true;
    L26:
        return false;
    L24:
        return false;
    }

    public final boolean t(com.bytedance.android.live.revlink.impl.lynxcontainer.b r9, Function1<? super Boolean, Unit> r10) {
        if (this.j == true) goto L6;
        jy0.b.c("MultiDynamicManager", "block card load success for not in lifecycle for " + r9.o(), null, 4);
        return true;
    L6:
        this.e.remove(r9.o());
        this.c.put(r9.o(), r9);
        zy0.b r0 = this.b.get(r9.o());
        if (r0 == null) goto L9;
        e.getType(r0);
    L9:
        zy0.b r1 = this.b.get(r9.o());
        jy0.b.c("MultiDynamicManager", r9.o() + " lynx load success ", null, 4);
        this.h.a(r9, r1);
        zy0.b r2 = this.b.get(r9.o());
        if (r2 == null) goto L27;
        Map<String, LiveData<Pair<String, JSONObject>>> r4 = this.q;
        if (r4 == null) goto L27;
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<Map.Entry<String, LiveData<Pair<String, JSONObject>>>> r6 = r4.entrySet().iterator();
    L16:
        if (r6.hasNext() == false) goto L20;
        Map.Entry<String, LiveData<Pair<String, JSONObject>>> r7 = r6.next();
        if (s(r9, r7.getKey()) == false) goto L16;
        r5.put(r7.getKey(), r7.getValue());
        goto L16
    L20:
        Iterator r8 = r5.entrySet().iterator();
    L22:
        if (r8.hasNext() == false) goto L27;
        Map.Entry r12 = (Map.Entry) r8.next();
        String r13 = (String) r12.getKey();
        Pair r14 = (Pair) ((LiveData) r12.getValue()).getValue();
        if (r14 == null) goto L22;
        String r15 = (String) r14.component1();
        u(r2, r(), ((JSONObject) r14.component2()).toString());
        jy0.b.c("MultiDynamicManager", "send data " + r15 + " to view " + r9.o(), null, 4);
    L27:
        HybridType r3 = HybridType.H5;
        String r16 = r9.e();
        String r17 = r9.o();
        Intrinsics.checkNotNullParameter(r16, "lynxUrl");
        Intrinsics.checkNotNullParameter(r17, "tag");
        ArrayList<JSONObject> r18 = this.d.get(r17);
        if (r18 == null) goto L33;
        Iterator<T> r19 = r18.iterator();
    L31:
        if (r19.hasNext() == false) goto L33;
        u(this.b.get(r17), r(), ((JSONObject) r19.next()).toString());
    L33:
        this.d.remove(r17);
        this.h.getClass();
        Intrinsics.checkNotNullParameter(r16, "lynxUrl");
        if (r10 == null) goto L49;
        Unit r20 = (Unit) r10.invoke(Boolean.TRUE);
        return false;
    L49:
        return false;
    }

    public static final void j(MultiDynamicManager r5, boolean r6, boolean r7) {
        if (Intrinsics.areEqual(r5.w, h.b.b) == false) goto L27;
        com.bytedance.android.live.revlink.impl.monitor.b r0 = null;
        MultiEnterRoomTracer r1 = null;
        if (r7 == false) goto L16;
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r8 = r5.v;
        if (r8 == null) goto L9;
        r1 = r8.e();
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        if (r1.q != 0) goto L31;
        if (r6 == false) goto L32;
        i97.a r9 = i97.a.a;
        r1.q = System.currentTimeMillis();
        return;
    L32:
        return;
    L31:
        return;
    L16:
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r10 = r5.v;
        if (r10 == null) goto L19;
        r0 = r10.a();
    L19:
        if (r0 != null) goto L21;
        return;
    L21:
        if (r0.a != 0) goto L33;
        if (r6 == false) goto L34;
        i97.a r12 = i97.a.a;
        r0.a = System.currentTimeMillis();
        return;
    L34:
        return;
    L33:
        return;
    }

    public final zy0.b n(com.bytedance.android.live.revlink.impl.lynxcontainer.b r16, boolean r17, Function2<? super zy0.b, ? super Boolean, Unit> r18) {
        x0 r0 = new x0(r16.e());
        x0 r1 = r0.d("url");
        Iterator r2 = CollectionsKt.toList(r16.d()).iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        String r3 = (String) r2.next();
        com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r4 = this.v;
        if (r4 == null) goto L9;
        String r5 = r4.f(r3);
        if (r5 == null) goto L9;
    L10:
        r1.b(r3, r5);
    L9:
        r5 = "";
        goto L10
    L11:
        com.bytedance.android.live.revlink.impl.settings.dynamic.b r6 = com.bytedance.android.live.revlink.impl.settings.dynamic.b.m;
        boolean r7 = r6.a().getDebugMode();
        String r8 = DataType.TRUE;
        if (r7 == false) goto L14;
        r1.b("debug_mode", DataType.TRUE);
    L14:
        r1.b("load_source", String.valueOf(this.w.a));
        h r9 = this.w;
        if (Intrinsics.areEqual(r9, h.b.b) == false) goto L18;
        boolean r10 = r6.a().N1();
    L21:
        if (d51.c.A0.o().G1() == false) goto L24;
        r1.b("pk_prop_card_enable", DataType.TRUE);
    L24:
        if (r10 == false) goto L26;
        r1.b("control_native_enable", DataType.TRUE);
    L26:
        r1.b("live_pk_enable_double_lynx_mic", DataType.TRUE);
        r1.b("live_pk_enable_lynx_double_link_score", DataType.TRUE);
        r1.b("live_pk_enable_lynx_interact_comment", DataType.TRUE);
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r12 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        boolean r13 = r12.g();
        String r14 = DataType.FALSE;
        if (r13 == false) goto L29;
        String r15 = DataType.TRUE;
    L30:
        r1.b("live_revenue_interact_dynamic_data_format", r15);
        if (r12.b() == false) goto L33;
        String r19 = DataType.TRUE;
    L34:
        r1.b("live_pk_enable_lynx_anchor_mic_panel", r19);
        if (r12.c() == false) goto L37;
        String r20 = DataType.TRUE;
    L38:
        r1.b("panel_list_opt", r20);
        if (r41.f.a == false) goto L41;
        String r22 = DataType.TRUE;
    L42:
        r1.b("support_nine_linker", r22);
        if (y41.f.N.c() == false) goto L45;
        String r23 = DataType.TRUE;
    L46:
        r1.b("live_multi_pk_sofa_opt", r23);
        r1.b("android_use_scope", DataType.TRUE);
        r1.b("android_merge_data_source", DataType.TRUE);
        r1.b("android_kmp", DataType.TRUE);
        r1.b("interact_merge_scene", DataType.TRUE);
        b03.a r24 = b03.a.a;
        if (PadConfigUtils.a() == false) goto L49;
        String r25 = DataType.TRUE;
    L50:
        r1.b("is_pad", r25);
        r1.b("interact_time_cnt", String.valueOf(LinkMultiDynamicSettingsKt.a()));
        com.bytedance.android.livesdk.revenue.service.room.c r26 = this.u;
        boolean r27 = true;
        String r110 = null;
        if (r26 == null) goto L73;
        if (((Number) this.s.invoke()).intValue() != 1) goto L73;
        IBaseUser r111 = r26.getRoomContext().getCommonRoom().getOwnerKt();
        if (r111 == null) goto L58;
        String r112 = r111.getIdString();
    L59:
        r1.b("anchor_id", r112);
        IBaseUser r113 = r26.getRoomContext().getCommonRoom().getOwnerKt();
        if (r113 == null) goto L62;
        Intrinsics.checkNotNullParameter(r113, "$this$secUidExt");
        String r114 = r113.getCastSecUid();
    L63:
        r1.b("sec_anchor_id", r114);
        r1.b("user_id", r26.getRoomContext().getCommonUser().getIdString());
        r1.b("sec_user_id", o.a(r26.getRoomContext().getCommonUser()));
        r1.b("room_id", r26.getRoomContext().getCommonRoom().getIdStr());
        r1.b("load_source", DataType.FALSE);
        if (r12.e() == false) goto L66;
        String r28 = DataType.TRUE;
    L67:
        r1.b("control_native_enable", r28);
        if (r26.getRoomContext().getCommonIsAnchor() == true) goto L71;
        r8 = DataType.FALSE;
    L71:
        r1.b("is_anchor", r8);
        goto L73
    L66:
        r28 = DataType.FALSE;
        goto L67
    L62:
        r114 = null;
        goto L63
    L58:
        r112 = null;
    L73:
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.i.getValue(r12, com.bytedance.android.live.revlink.impl.settings.dynamic.a.a[7])).booleanValue() == false) goto L83;
        String r29 = r1.a("business_type");
        if (r29 != null) goto L77;
    L80:
        boolean r30 = true;
    L81:
        if (r30 == false) goto L83;
        r1.b("business_type", "rev_link");
        goto L83
    L77:
        if (StringsKt.isBlank(r29) == true) goto L80;
        r30 = false;
    L83:
        IRoom r32 = this.k;
        if (r32 == null) goto L96;
        IBaseUser r33 = r32.getOwnerKt();
        if (r33 == null) goto L88;
        r110 = iz.a.a(r33);
    L88:
        r1.b("anchor_id", r110);
        String r34 = r32.getIdStr();
        if (r34.length() == 0) goto L92;
        r27 = false;
    L92:
        if (r27 == true) goto L95;
        r14 = r34;
    L95:
        r1.b("room_id", r14);
    L96:
        this.e.add(r16.o());
        a r35 = new a();
        zy0.b r36 = this.t.c(LynxBizType.DynamicCentral, this.w, r0.c(), new MultiDynamicManager$addLynxView$hybridCard$1(this, r16, r18, r35, r17));
        r35.a = r36;
        this.b.put(r16.o(), r36);
        if (r36 == null) goto L101;
        xy0.a<?> r37 = r36.g();
        if (r37 == null) goto L101;
        r37.load();
    L101:
        return r36;
    L49:
        r25 = DataType.FALSE;
        goto L50
    L45:
        r23 = DataType.FALSE;
        goto L46
    L41:
        r22 = DataType.FALSE;
        goto L42
    L37:
        r20 = DataType.FALSE;
        goto L38
    L33:
        r19 = DataType.FALSE;
        goto L34
    L29:
        r15 = DataType.FALSE;
        goto L30
    L18:
        if (Intrinsics.areEqual(r9, h.a.b) == false) goto L103;
        r10 = r6.a().h7();
        goto L21
    L103:
        throw new NoWhenBranchMatchedException();
    }

    public final void u(zy0.b r2, String r3, String r4) {
        if (this.j == true) goto L5;
        return;
    L5:
        if (r2 != null) goto L8;
        return;
    L8:
        if (((Boolean) this.n.getValue()).booleanValue() == true) goto L13;
        xy0.a<?> r5 = r2.g();
        if (r5 == null) goto L20;
        r5.sendJsEvent(r3, r4);
        return;
    L20:
        return;
    L13:
        xy0.a<?> r0 = r2.g();
        if (r0 != null) goto L16;
        return;
    L16:
        if (r0.isDisposed() == true) goto L22;
        com.bytedance.revenue.platform.api.core.rx.l r1 = com.bytedance.revenue.platform.api.core.rx.l.a;
        Observable r6 = Observable.just(r4);
        int r7 = p.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(r6.observeOn(Schedulers.single()).subscribe(new c(r2, r3), d.a), this.a);
        return;
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiDynamicManager$sendDataToLynxObserver$1] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.live.revlink.impl.multianchor.dynamic.MultiDynamicManager$screenChangeObserver$1] */
    public MultiDynamicManager(Function0<Integer> r2, x51.a r3, com.bytedance.android.livesdk.revenue.service.room.c r4, com.bytedance.android.live.revlink.impl.multianchor.dynamic.context.d r5, h r6) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "linkLynxCentralService");
        Intrinsics.checkNotNullParameter(r6, "loadSource");
        this.s = r2;
        this.t = r3;
        this.u = r4;
        this.v = r5;
        this.w = r6;
        this.a = new CompositeDisposable();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = new ArrayList();
        this.f = new MutableLiveData();
        this.g = new ArrayList();
        this.h = new MultiDynamicLayoutManager(r3, r5, new MultiDynamicManager$layoutManager$1(this));
        this.m = new MultiDynamicManager$screenChangeObserver$1(this);
        this.n = LazyKt.lazy(MultiDynamicManager$isMeasureOpt$2.INSTANCE);
        if (r5 == null) goto L6;
        HashMap<String, LiveData<?>> r7 = r5.b();
        if (r7 == null) goto L6;
    L7:
        this.o = r7;
        this.p = new MultiRegisterViewListenContext(r7);
        if (r5 == null) goto L11;
        Map<String, LiveData<Pair<String, JSONObject>>> r8 = r5.h();
        if (r8 == null) goto L11;
    L12:
        this.q = r8;
        this.r = new MultiDynamicManager$sendDataToLynxObserver$1(this);
        return;
    L11:
        r8 = new HashMap();
    L6:
        r7 = new HashMap();
        goto L7
    }
}
