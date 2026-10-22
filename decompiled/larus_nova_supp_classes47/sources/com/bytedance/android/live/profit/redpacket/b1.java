package com.bytedance.android.live.profit.redpacket;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.platform.hybrid.api.shareview.ShareViewCard;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.revenue.sti.IRevIconModel;
import com.bytedance.android.livesdk.revenue.sti.RevStiElementType;
import com.bytedance.android.livesdkapi.performance.ILiveReleasable;
import com.bytedance.android.livesdkapi.service.ILiveOptManager;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import io.reactivex.functions.Consumer;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import zg1.q2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b1 extends com.bytedance.android.live.revenue.common.a<h1> {
    public static final boolean m = false;
    public zy0.b f;
    public zy0.b g;
    public ShareViewCard h;
    public final c i;
    public final ny0.a j;
    public final yz0.k k;
    public final LuckyBoxClientService l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ b1 a;

        public b(b1 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((q2) r3).a != 0) goto L9;
            b1 r4 = this.a;
            r4.getClass();
            l01.d r0 = (l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class);
            if (r0.isLogin() == true) goto L7;
            r0.z4(r4.getContext(), RedpacketClientIconModel$wannaSend$1.INSTANCE);
            return;
        L7:
            ((cv0.b) ny0.a.C0280a.a(r4.j, Reflection.getOrCreateKotlinClass(cv0.b.class))).openSendLuckyBoxView();
            return;
        }
    }

    public static final class c implements ILiveReleasable {
        public c() {
        }

        public final void releaseByFixer() {
        }
    }

    static {
        m = ((Boolean) i1.r.getValue(null, i1.a[15])).booleanValue();
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void g() {
        LuckyBoxClientService r0 = this.l;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "iconModel");
        r0.b = this;
        Iterator r1 = ((ArrayList) r0.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((Function1) r1.next()).invoke(this);
        goto L4
    L6:
        ((ArrayList) r0.a).clear();
        bindModel(xs2.b.a().b(q2.class).subscribe(new b(this)));
        ILiveOptManager r2 = jc1.k.f(ILiveOptManager.class);
        if (r2 == null) goto L11;
        r2.bindReleasable(null, this.i);
        return;
    }

    public final void onClick() {
        int r0 = h.a;
        bindModel(RxUtilKt.r(h.a(this.k.getRoom()), "RedpacketClientIconModel"));
        if (((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).isLogin() == true) goto L5;
        ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).z4(getContext(), RedpacketClientIconModel$login$1.INSTANCE);
        return;
    L5:
        ((cv0.b) ny0.a.C0280a.a(this.j, Reflection.getOrCreateKotlinClass(cv0.b.class))).openGrabLuckyBoxView();
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void onDestroy() {
        ALogger.i("RedpacketClientIconModel", "RedpacketClientIconModel.onDestroy");
        zy0.b r0 = this.f;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        zy0.b r1 = this.g;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        ShareViewCard r2 = this.h;
        if (r2 == null) goto L11;
        r2.c();
    L11:
        StringBuilder r3 = new StringBuilder("shortTouchCard ");
        zy0.b r4 = this.f;
        if (r4 == null) goto L16;
        View r5 = r4.c();
        if (r5 == null) goto L16;
        String r6 = r5.getClass().getSimpleName();
    L17:
        r3.append(r6);
        ALogger.i("RedpacketClientIconModel", r3.toString());
        return;
    L16:
        r6 = null;
        goto L17
    }

    public final xr2.h getViewForState(Object r22) {
        h1 r7 = (h1) r22;
        Intrinsics.checkNotNullParameter(r7, "state");
        View r8 = null;
        if ((r7 instanceof h1.b) == false) goto L23;
        xr2.g r9 = createIconTemplate(xr2.g.class);
        xr2.g r10 = r9;
        r10.setRotated(Boolean.FALSE);
        r10.setResizeContentView(Boolean.TRUE);
        long r12 = System.currentTimeMillis();
        RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1 r13 = new RedpacketClientIconModel$getViewForState$$inlined$apply$lambda$1(r10, r12, this, r7);
        ReadOnlyProperty r0 = i1.s;
        KProperty[] r1 = i1.a;
        if (((Boolean) r0.getValue(null, r1[16])).booleanValue() == true) goto L8;
        r13.m213invoke();
    L13:
        if (r10.getContentView() == null) goto L22;
        View r2 = r10.getView();
        if ((r2 instanceof ViewGroup) == false) goto L18;
        r8 = r2;
    L18:
        ViewGroup r14 = (ViewGroup) r8;
        if (r14 == null) goto L22;
        r3.h(r14);
    L22:
        return r9;
    L8:
        ShareViewCard r3 = new ShareViewCard(getContext());
        r10.setContentView(r3.a);
        View r4 = r10.getContentView();
        if (r4 == null) goto L11;
        r4.setOnClickListener(new e1(r10, this));
    L11:
        r3.a(new com.bytedance.android.live.revenue.platform.hybrid.api.shareview.d(UriProtector.parse((String) i1.o.getValue(null, r1[12])), MapsKt.mapOf(new Pair[]{TuplesKt.to("timestamp", String.valueOf(r12)), TuplesKt.to(Constants.Keys.DATA, ((h1.b) r7).c)}), new f1(r10, r13), null, 56));
        Unit r5 = Unit.INSTANCE;
        this.h = r3;
        goto L13
    L23:
        return null;
    }

    @Override // com.bytedance.android.live.revenue.common.a
    public final void onShowTempState(int r4) {
        if (r4 != 1) goto L19;
        Class r5 = com.bytedance.android.live.profit.redpacket.model.h.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r0 = vh7.b.a;
        Object r1 = r0.get(r5);
        if (r1 != null) goto L14;
        r1 = r5.getConstructor(new Class[0]);
        if (r1 == null) goto L13;
        Object r6 = r0.putIfAbsent(r5, r1);
        if (r6 == null) goto L14;
        r1 = r6;
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L14:
        Object r7 = ((SerializableObjectJsonAdapterBase) ((Constructor) r1).newInstance(new Object[0])).createInstance();
        if (r7 == null) goto L18;
        com.bytedance.android.live.profit.redpacket.model.h r8 = (com.bytedance.android.live.profit.redpacket.model.h) r7;
        r8.y1();
        this.l.c.onNext(r8);
        return;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profit.redpacket.model.ObserveLuckyBoxShortTouchTempStateResponse");
    }

    public final IRevIconModel.a getEntryViewForState(Object r12, Object r13) {
        h1 r14 = (h1) r12;
        h1 r15 = (h1) r13;
        Intrinsics.checkNotNullParameter(r14, "state");
        StringBuilder r16 = new StringBuilder("RedpacketClientIconModel.getEntryViewForState: ");
        r16.append(r14.getClass().getSimpleName());
        r16.append("+ ");
        boolean r1 = r14 instanceof h1.b;
        if (r1 == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        r16.append(r4);
        ALogger.i("RedpacketClientIconModel", r16.toString());
        View r17 = null;
        Integer r18 = null;
        if (r1 == false) goto L81;
        h1.b r19 = (h1.b) r14;
        if (r19.a == true) goto L13;
        return null;
    L13:
        if (m == false) goto L63;
        IRevIconModel.a r0 = inflateEntryView(2131567278);
        View r2 = r0.a;
        if (r2 == null) goto L62;
        ViewGroup r3 = (ViewGroup) r2;
        String r110 = r19.c;
        Intrinsics.checkNotNullParameter(r3, "rootView");
        Intrinsics.checkNotNullParameter(r110, "luckyBoxInitData");
        d r111 = (d) GsonHelper.get().fromJson(r110, new a0().getType());     // Catch: Exception -> L82
        TextView r5 = (TextView) r3.findViewById(2131367087);     // Catch: Exception -> L82
        if (r111 == null) goto L20;
        String r6 = String.valueOf(r111.a());     // Catch: Exception -> L82
    L21:
        r5.setText(r6);     // Catch: Exception -> L82
        ViewGroup r7 = (ViewGroup) r3.findViewById(2131363653);     // Catch: Exception -> L82
        HSImageView r8 = r3.findViewById(2131367089);     // Catch: Exception -> L82
        if (r8 == null) goto L25;
        py.k r9 = com.bytedance.android.livesdk.utils.r3.a();     // Catch: Exception -> L82
        Intrinsics.checkNotNullParameter(r8, "$this$bindImage");     // Catch: Exception -> L82
        ImageLoader.bindImage(r8, r9);     // Catch: Exception -> L82
    L25:
        LayoutInflater r10 = LayoutInflater.from(r3.getContext());     // Catch: Exception -> L82
        if (r111 == null) goto L28;
        List<String> r112 = r111.b();     // Catch: Exception -> L82
    L29:
        if (r112 == null) goto L34;
        List<String> r113 = r112;     // Catch: Exception -> L82
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));     // Catch: Exception -> L82
        Iterator<T> r114 = r113.iterator();     // Catch: Exception -> L82
    L32:
        if (r114.hasNext() == false) goto L35;
        String r22 = (String) r114.next();     // Catch: Exception -> L82
        py.k r23 = vh7.f.c(py.k.class);     // Catch: Exception -> L82
        r23.setUrls(CollectionsKt.listOf(r22));     // Catch: Exception -> L82
        r20.add(r23);     // Catch: Exception -> L82
    L35:
        if (r20 == null) goto L38;
        r18 = Integer.valueOf(r20.size());     // Catch: Exception -> L82
    L38:
        if (r18 != null) goto L41;
    L43:
        if (r18 != null) goto L46;
    L48:
        r10.inflate(2131567281, r7);     // Catch: Exception -> L82
    L49:
        Integer[] r115 = {2131363624, 2131363625, 2131363626};     // Catch: Exception -> L82
        if (r20 == null) goto L60;
        List r116 = CollectionsKt.zip(r20, r115);     // Catch: Exception -> L82
        if (r116 == null) goto L60;
        Iterator r117 = r116.iterator();     // Catch: Exception -> L82
    L54:
        if (r117.hasNext() == false) goto L60;
        Pair r118 = (Pair) r117.next();     // Catch: Exception -> L82
        py.k r24 = (py.k) r118.component1();     // Catch: Exception -> L82
        HSImageView r119 = r7.findViewById(((Number) r118.component2()).intValue());     // Catch: Exception -> L82
        if (r119 == null) goto L54;
        Intrinsics.checkNotNullParameter(r119, "$this$bindImage");     // Catch: Exception -> L82
        ImageLoader.bindImage(r119, r24);     // Catch: Exception -> L82
        goto L54
    L46:
        if (r18.intValue() != 2) goto L48;
        r10.inflate(2131567280, r7);     // Catch: Exception -> L82
        goto L49
    L41:
        if (r18.intValue() != 1) goto L43;
        r10.inflate(2131567279, r7);     // Catch: Exception -> L82
        goto L49
    L34:
        r20 = null;
        goto L35
    L28:
        r112 = null;
        goto L29
    L20:
        r6 = null;
    L60:
        r3.setOnClickListener(new d1(this));
        return r0;
    L62:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L63:
        com.bytedance.android.live.revenue.common.x0 r25 = new com.bytedance.android.live.revenue.common.x0((String) i1.p.getValue(null, i1.a[13]));
        r25.d("url").b("timestamp", String.valueOf(System.currentTimeMillis()));
        ALogger.i("RedpacketClientIconModel", "RedpacketClientIconModel.getEntryViewForState: " + r25.c());
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r26 = ((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).q8(getContext(), r25.c(), RedpacketClientIconModel$getEntryViewForState$2.INSTANCE);
        if (r26 == null) goto L72;
        String r120 = r19.c;
        xy0.a<?> r27 = r26.g();
        if (r27 == null) goto L68;
        r27.updateGlobalProps(MapsKt.mapOf(TuplesKt.to("data_from_native", r120)));
    L68:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a.b r121 = r26.d;
        if (r121 == null) goto L71;
        r121.load(null, null);
    L71:
        r26.c.setOnClickListener(new c1(this));
        Unit r122 = Unit.INSTANCE;
    L73:
        this.g = r26;
        IRevIconModel.a r123 = inflateEntryView(2131567282);
        View r28 = r123.a;
        if (r28 == null) goto L80;
        ViewGroup r29 = (ViewGroup) r28;
        zy0.b r30 = this.g;
        if (r30 == null) goto L78;
        r17 = r30.c();
    L78:
        r29.addView(r17);
        ALogger.i("RedpacketClientIconModel", "RedpacketClientIconModel.getEntryViewForState: ".concat(r123.a.getClass().getSimpleName()));
        return r123;
    L80:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L72:
        r26 = null;
        goto L73
    L81:
        return null;
    L5:
        if (((h1.b) r14).a == false) goto L7;
        r4 = true;
        goto L8
    }

    public b1(ny0.a r3, yz0.k r4, LuckyBoxClientService r5) {
        Intrinsics.checkNotNullParameter(r3, "rpcService");
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        Intrinsics.checkNotNullParameter(r5, "clientService");
        super(h1.a.a, RevStiElementType.RegularLuckyBox.getTypeId());
        this.j = r3;
        this.k = r4;
        this.l = r5;
        new PropertyOwner(Unit.INSTANCE);
        this.i = new c();
    }

    public final void c(Object r1, Object r2, xr2.h r3) {
        h1 r4 = (h1) r1;
        Intrinsics.checkNotNullParameter((h1) r2, "curState");
    }
}
