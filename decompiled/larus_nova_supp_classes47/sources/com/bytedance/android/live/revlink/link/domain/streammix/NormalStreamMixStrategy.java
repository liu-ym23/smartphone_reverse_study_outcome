package com.bytedance.android.live.revlink.link.domain.streammix;

import android.graphics.RectF;
import com.bytedance.android.live.revlink.impl.pk.utils.r;
import com.bytedance.android.live.revlink.impl.utils.s;
import com.bytedance.android.live.revlink.impl.utils.u;
import com.bytedance.android.live.revlink.link.core.service.AnchorUILayoutManager;
import com.bytedance.android.live.revlink.link.core.service.n;
import com.bytedance.android.live.revlink.link.core.service.p;
import com.bytedance.android.live.revlink.link.core.service.q;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import com.bytedance.android.live.revlink.link.streaminteract.biz.StreamMixDescriptor;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fr2.p0;
import gr2.k;
import gr2.m;
import gr2.o;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class NormalStreamMixStrategy extends p0 implements com.bytedance.android.live.revlink.link.biz.service.a {
    public static final /* synthetic */ int k = 0;
    public p b;
    public final CompositeDisposable c;
    public b d;
    public final HashMap<String, Boolean> e;
    public final f f;
    public final AnchorUILayoutManager g;
    public final RevLinkDomainAnchorService h;
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g i;
    public final com.bytedance.android.livesdk.revenue.service.room.c j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.domain.streammix.NormalStreamMixStrategy$attach$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Unit> {
        public AnonymousClass1(NormalStreamMixStrategy r8) {
            super(0, r8, NormalStreamMixStrategy.class, "refreshMixStrategy", "refreshMixStrategy()V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m947invoke() {
            NormalStreamMixStrategy r0 = (NormalStreamMixStrategy) ((CallableReference) this).receiver;
            int r1 = NormalStreamMixStrategy.k;
            r0.d5();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m947invoke();
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final IConfig.e L() {
        AnchorUILayoutManager r0 = this.g;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r1 = getContext();
        Intrinsics.checkNotNullParameter(r0, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r1, "context");
        o51.e r2 = r0.e;
        if ((r2 instanceof o51.e.C0283e) == false) goto L10;
        if (r2 == null) goto L9;
        if (((o51.e.C0283e) r2).e == false) goto L10;
        return new r();
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.link.core.UILayout.Full_RECORD");
    L10:
        if (r1 == null) goto L14;
        s r3 = r1.getRevLinkCommonUtil();
        if (r3 == null) goto L14;
        IRoom r4 = r3.a();
    L15:
        if (r4 == null) goto L68;
        IRoomSpecificSceneTypeInfo r5 = r4.getSceneTypeInfo();
        if (r5 == null) goto L68;
        if (r5.isLandscapeVerticalRoom() != 1) goto L68;
        IAnchorData r6 = IRoomKt_androidKt.getAnchorDataKt(r4);
        if (r6 == null) goto L24;
        String r7 = r6.getFrameScale();
        if (r7 == null) goto L24;
    L25:
        List r8 = StringsKt.split$default(r7, new String[]{":"}, false, 0, 6, null);
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L27:
        if (r10.hasNext() == false) goto L32;
        Integer r12 = StringsKt.toIntOrNull((String) r10.next());
        if (r12 == null) goto L27;
        r9.add(r12);
        goto L27
    L32:
        if (r9.size() == 2) goto L34;
        IConfig.e.f1.getClass();
        return IConfig.e.a.d;
    L34:
        Integer r13 = (Integer) ListProtector.get(r9, 0);
        if (r13 == null) goto L37;
        float r14 = r13.intValue();
    L38:
        Integer r15 = (Integer) ListProtector.get(r9, 1);
        if (r15 == null) goto L41;
        float r16 = r15.intValue();
    L43:
        if (r14 != 0.0f) goto L45;
    L67:
        IConfig.e.f1.getClass();
        return IConfig.e.a.d;
    L45:
        if (r16 == 0.0f) goto L67;
        float r17 = r14 / r16;
        IConfig.e.f1.getClass();
        IConfig.e r18 = IConfig.e.a.f;
        float r19 = 1.0f;
        if (r18 == null) goto L50;
        float r20 = r18.getWidth();
    L51:
        if (r18 == null) goto L53;
        float r22 = r18.getHeight();
    L55:
        if (r17 == (r20 / r22)) goto L77;
        r18 = IConfig.e.a.g;
        if (r18 == null) goto L60;
        float r23 = r18.getWidth();
    L61:
        if (r18 == null) goto L64;
        r19 = r18.getHeight();
    L64:
        if (r17 == (r23 / r19)) goto L77;
        return IConfig.e.a.d;
    L60:
        r23 = 1.0f;
    L77:
        return r18;
    L53:
        r22 = 1.0f;
        goto L55
    L50:
        r20 = 1.0f;
        goto L51
    L41:
        r16 = 0.0f;
        goto L43
    L37:
        r14 = 0.0f;
    L24:
        r7 = "";
    L68:
        IConfig.e.f1.getClass();
        return IConfig.e.a.d;
    L14:
        r4 = null;
        goto L15
    }

    public final void d5() {
        o51.e r0 = this.g.e;
        if ((r0 instanceof o51.e.g) == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L17;
        b r2 = this.d;
        if (r2 != null) goto L15;
    L16:
        this.d = new com.bytedance.android.live.revlink.link.domain.streammix.a(getContext(), this.j, L(), this.h, this.g);
        return;
    L15:
        if ((r2 instanceof com.bytedance.android.live.revlink.link.domain.streammix.a) == false) goto L16;
    L17:
        if (r1 == true) goto L25;
        b r3 = this.d;
        if (r3 != null) goto L21;
    L22:
        this.d = new i(getContext(), this.g, this.h, this.j, L());
        return;
    L21:
        if ((r3 instanceof i) == false) goto L22;
        return;
    L25:
        return;
    L5:
        if ((r0 instanceof o51.e.i) == true) goto L10;
        if ((r0 instanceof o51.e.h) == true) goto L10;
        r1 = false;
        goto L11
    }

    public final void attach() {
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.j(getContext().d.i, new AnonymousClass1(this)), this.c);
        d5();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.a, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g getContext() {
        return this.i;
    }

    public final String c5(List<? extends IRegion> r22) {
        p r0 = this.b;     // Catch: Exception -> L83
        if (r0 != null) goto L18;
        Iterator<T> r1 = r22.iterator();     // Catch: Exception -> L83
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();     // Catch: Exception -> L83
        if (Intrinsics.areEqual(((IRegion) r2).getInteractId(), getContext().Zl()) == false) goto L7;
    L12:
        IRegion r3 = (IRegion) r2;     // Catch: Exception -> L83
        if (r3 == null) goto L17;
        o r4 = r3.C4(0.0d, 0.0d);     // Catch: Exception -> L83
        if (r4 == null) goto L17;
        r4.D3(1.0d, 1.0d);     // Catch: Exception -> L83
    L17:
        return "";
    L11:
        r2 = null;
        goto L12
    L18:
        Map<String, n> r5 = r0.a;     // Catch: Exception -> L83
        LinkedHashMap r6 = new LinkedHashMap(MapsKt.mapCapacity(r5.size()));     // Catch: Exception -> L83
        Iterator<T> r7 = r5.entrySet().iterator();     // Catch: Exception -> L83
    L20:
        if (r7.hasNext() == false) goto L22;
        Object r8 = r7.next();     // Catch: Exception -> L83
        r6.put(((Map.Entry) r8).getKey(), ((n) ((Map.Entry) r8).getValue()).b);     // Catch: Exception -> L83
        goto L20
    L22:
        Map<String, n> r9 = r0.a;     // Catch: Exception -> L83
        LinkedHashMap r10 = new LinkedHashMap(MapsKt.mapCapacity(r9.size()));     // Catch: Exception -> L83
        Iterator<T> r12 = r9.entrySet().iterator();     // Catch: Exception -> L83
    L24:
        if (r12.hasNext() == false) goto L26;
        Object r13 = r12.next();     // Catch: Exception -> L83
        r10.put(((Map.Entry) r13).getKey(), ((n) ((Map.Entry) r13).getValue()).c);     // Catch: Exception -> L83
        goto L24
    L26:
        Map<String, n> r14 = r0.a;     // Catch: Exception -> L83
        LinkedHashMap r15 = new LinkedHashMap(MapsKt.mapCapacity(r14.size()));     // Catch: Exception -> L83
        Iterator<T> r16 = r14.entrySet().iterator();     // Catch: Exception -> L83
    L28:
        if (r16.hasNext() == false) goto L30;
        Object r17 = r16.next();     // Catch: Exception -> L83
        r15.put(((Map.Entry) r17).getKey(), ((n) ((Map.Entry) r17).getValue()).d);     // Catch: Exception -> L83
        goto L28
    L30:
        Map<String, n> r18 = r0.a;     // Catch: Exception -> L83
        LinkedHashMap r19 = new LinkedHashMap(MapsKt.mapCapacity(r18.size()));     // Catch: Exception -> L83
        Iterator<T> r20 = r18.entrySet().iterator();     // Catch: Exception -> L83
    L32:
        if (r20.hasNext() == false) goto L34;
        Object r23 = r20.next();     // Catch: Exception -> L83
        r19.put(((Map.Entry) r23).getKey(), ((n) ((Map.Entry) r23).getValue()).a);     // Catch: Exception -> L83
        goto L32
    L34:
        Map r24 = K(r0.b, r22);     // Catch: Exception -> L83
        LinkedHashMap r25 = new LinkedHashMap(MapsKt.mapCapacity(r24.size()));     // Catch: Exception -> L83
        Iterator r26 = r24.entrySet().iterator();     // Catch: Exception -> L83
    L36:
        if (r26.hasNext() == false) goto L38;
        Object r27 = r26.next();     // Catch: Exception -> L83
        r25.put(((Map.Entry) r27).getKey(), ((n) ((Pair) ((Map.Entry) r27).getValue()).getFirst()).b);     // Catch: Exception -> L83
        goto L36
    L38:
        LinkedHashMap r110 = new LinkedHashMap(MapsKt.mapCapacity(r24.size()));     // Catch: Exception -> L83
        Iterator r28 = r24.entrySet().iterator();     // Catch: Exception -> L83
    L40:
        if (r28.hasNext() == false) goto L42;
        Object r29 = r28.next();     // Catch: Exception -> L83
        r110.put(((Map.Entry) r29).getKey(), ((n) ((Pair) ((Map.Entry) r29).getValue()).getFirst()).c);     // Catch: Exception -> L83
        goto L40
    L42:
        LinkedHashMap r111 = new LinkedHashMap(MapsKt.mapCapacity(r24.size()));     // Catch: Exception -> L83
        Iterator r30 = r24.entrySet().iterator();     // Catch: Exception -> L83
    L44:
        if (r30.hasNext() == false) goto L46;
        Object r32 = r30.next();     // Catch: Exception -> L83
        r111.put(((Map.Entry) r32).getKey(), ((n) ((Pair) ((Map.Entry) r32).getValue()).getFirst()).d);     // Catch: Exception -> L83
        goto L44
    L46:
        LinkedHashMap r33 = new LinkedHashMap(MapsKt.mapCapacity(r24.size()));     // Catch: Exception -> L83
        Iterator r34 = r24.entrySet().iterator();     // Catch: Exception -> L83
    L48:
        if (r34.hasNext() == false) goto L50;
        Object r112 = r34.next();     // Catch: Exception -> L83
        r33.put(((Map.Entry) r112).getKey(), ((n) ((Pair) ((Map.Entry) r112).getValue()).getFirst()).a);     // Catch: Exception -> L83
        goto L48
    L50:
        LinkedHashMap r113 = new LinkedHashMap(MapsKt.mapCapacity(r24.size()));     // Catch: Exception -> L83
        Iterator r35 = r24.entrySet().iterator();     // Catch: Exception -> L83
    L52:
        if (r35.hasNext() == false) goto L54;
        Object r36 = r35.next();     // Catch: Exception -> L83
        r113.put(((Map.Entry) r36).getKey(), (qr2.a) ((Pair) ((Map.Entry) r36).getValue()).getSecond());     // Catch: Exception -> L83
        goto L52
    L54:
        o51.e r37 = this.g.e;     // Catch: Exception -> L83
        IConfig.e r114 = L();     // Catch: Exception -> L83
        t51.c r38 = r0.d;     // Catch: Exception -> L83
        IConfig.e r39 = L();     // Catch: Exception -> L83
        if ((r37 instanceof o51.e.C0283e) == true) goto L57;
    L65:
        float r115 = 0.5625f;
    L66:
        StreamMixDescriptor r116 = new StreamMixDescriptor(r10, r110, r114, r38, r115);     // Catch: Exception -> L83
        k41.b r117 = StreamMixDescriptor.a.a(r116, L());     // Catch: Exception -> L83
        f0(r22, r6, r10, r117, r19);     // Catch: Exception -> L83
        L0(r22, r25, r113, r110, r117);     // Catch: Exception -> L83
        d r40 = this.f.a(r22, r117, r15, r111, r116);     // Catch: Exception -> L83
        if ((r37 instanceof o51.e.C0283e) == true) goto L69;
    L71:
        d r118 = r40;
    L72:
        b r42 = this.d;     // Catch: Exception -> L83
        if (r42 == null) goto L76;
        String r43 = r42.X(r22, r15, r116, r117, r118);     // Catch: Exception -> L83
        if (r43 == null) goto L76;
    L78:
        if ((r37 instanceof o51.e.C0283e) == true) goto L80;
    L82:
        return r43;
    L80:
        if (((o51.e.C0283e) r37).e == false) goto L82;
        f5(r22);     // Catch: Exception -> L83
    L76:
        r43 = "";
        goto L78
    L69:
        if (((o51.e.C0283e) r37).e == false) goto L71;
        RectF r44 = new RectF(0.0f, 0.0f, 1.0f, 1.0f);     // Catch: Exception -> L83
        JSONArray r45 = r40.a;     // Catch: Exception -> L83
        int r46 = r40.b;     // Catch: Exception -> L83
        Intrinsics.checkNotNullParameter(r45, "mixGrids");     // Catch: Exception -> L83
        Intrinsics.checkNotNullParameter(r44, "contentRectF");     // Catch: Exception -> L83
        r118 = new d(r45, r46, r44);     // Catch: Exception -> L83
        goto L72
    L57:
        if (((o51.e.C0283e) r37).e == true) goto L65;
        if (r39 == null) goto L60;
        float r47 = r39.getWidth();     // Catch: Exception -> L83
    L61:
        if (r39 == null) goto L63;
        float r48 = r39.getHeight();     // Catch: Exception -> L83
    L64:
        r115 = r47 / r48;     // Catch: Exception -> L83
        goto L66
    L63:
        r48 = 1.0f;
        goto L64
    L60:
        r47 = 1.0f;
    L83:
        return "";
    }

    public final void f5(List<? extends IRegion> r18) {
        String r0 = getContext().Zl();
        Pair<Integer, Integer> r1 = u.f();
        if (r1 != null) goto L5;
        r1 = new Pair(0, 0);
    L5:
        int r3 = ((Number) r1.getFirst()).intValue();
        int r4 = ((Number) r1.getSecond()).intValue();
        if (u.f() != null) goto L8;
        double r7 = com.bytedance.android.live.revlink.impl.settings.live.b.p.c();
    L16:
        double r9 = ((((double) 13) * r7) * ((Number) r1.getFirst()).doubleValue()) / ((double) (((Number) r1.getSecond()).intValue() * 9));
        double r5 = 1;
        double r12 = r5 - r7;
        double r15 = r7;
        double r13 = (((((Number) r1.getFirst()).doubleValue() * r12) * ((double) r4)) / ((double) r3)) / ((Number) r1.getSecond()).doubleValue();
        Iterator r2 = ((ArrayList) r18).iterator();
    L18:
        if (r2.hasNext() == false) goto L24;
        IRegion r6 = (IRegion) r2.next();
        if (Intrinsics.areEqual(r6.getInteractId(), r0) == false) goto L22;
        r6.C4(0.0d, (r5 - r13) / ((double) 2)).D3(r12, r13);
        r6.m2();
        double r8 = r15;
    L23:
        r15 = r8;
        goto L18
    L22:
        r8 = r15;
        r6.C4(r12, (r5 - r9) / ((double) 2)).D3(r8, r9);
        goto L23
    L24:
        return;
    L8:
        Pair<Integer, Integer> r10 = u.f();
        if (r10 != null) goto L11;
        r10 = new Pair(0, 0);
    L11:
        double r14 = ((double) ((Number) r10.getSecond()).intValue()) / ((double) ((Number) r10.getFirst()).intValue());
        r7 = r14 / (1.7777777777777777d + r14);
        com.bytedance.android.live.revlink.impl.settings.live.b r16 = com.bytedance.android.live.revlink.impl.settings.live.b.p;
        r16.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.b.n.getValue(r16, com.bytedance.android.live.revlink.impl.settings.live.b.a[12])).booleanValue() == true) goto L14;
    L15:
        r7 = r16.c();
        goto L16
    L14:
        if (r7 <= 1) goto L16;
        goto L15
    }

    public static Map K(List r8, List r9) {
        ArrayList r0 = new ArrayList();
        Iterator r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L25;
        IRegion r1 = (IRegion) r10.next();
        qr2.a r2 = n41.a.a(r1.getInteractId());
        Pair r3 = null;
        if (r2 == null) goto L22;
        Iterator r4 = r8.iterator();
    L10:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        if (((n) r5).a.f != r2.c) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L10;
    L18:
        n r7 = (n) r5;
        if (r7 == null) goto L22;
        r3 = TuplesKt.to(r1.getInteractId(), TuplesKt.to(r7, r2));
        goto L22
    L14:
        r6 = false;
        goto L15
    L17:
        r5 = null;
    L22:
        if (r3 == null) goto L4;
        r0.add(r3);
        goto L4
    L25:
        return MapsKt.toMap(r0);
    }

    public final boolean S(m r2, k r3) {
        b r0 = this.d;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.S(r2, r3);
    }

    public final String L3(int r2, int r3, List<? extends IRegion> r4) {
        Intrinsics.checkNotNullParameter(r4, "regions");
        return c5(r4);
    L5:
        th = move-exception;
        jy0.b.c("NormalStreamMixStrategy", "mixStream crashed with " + ExceptionsKt.stackTraceToString(th), null, 4);
        return "";
    }

    public NormalStreamMixStrategy(AnchorUILayoutManager r7, RevLinkDomainAnchorService r8, com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r9, com.bytedance.android.livesdk.revenue.service.room.c r10) {
        Intrinsics.checkNotNullParameter(r7, "uiLayoutManager");
        Intrinsics.checkNotNullParameter(r8, "domainService");
        Intrinsics.checkNotNullParameter(r9, "context");
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.c = new CompositeDisposable();
        this.e = new HashMap();
        this.f = new f(getContext(), r7, L(), new NormalStreamMixStrategy$mixSeiInfoGenerator$1(this), new NormalStreamMixStrategy$mixSeiInfoGenerator$2(this));
    }

    public final void L0(List r6, Map r7, Map r8, Map r9, k41.b r10) {
        Iterator r12 = r6.iterator();
    L4:
        if (r12.hasNext() == false) goto L32;
        IRegion r0 = (IRegion) r12.next();
        LinkedHashMap r2 = (LinkedHashMap) r8;
        qr2.a r1 = (qr2.a) r2.get(r0.getInteractId());
        LinkedHashMap r3 = (LinkedHashMap) r9;
        t51.b r4 = (t51.b) r3.get(r0.getInteractId());
        LinkedHashMap r5 = (LinkedHashMap) r7;
        t51.e r13 = (t51.e) r5.get(r0.getInteractId());
        if (r1 == null) goto L4;
        if (r4 == null) goto L4;
        if (r13 == null) goto L4;
        r10.b(r0, r0.getInteractId());
        b r14 = this.d;
        if (r14 == null) goto L14;
        r14.T(r0);
    L14:
        if (r1.d == false) goto L16;
        IRegion.Status r15 = IRegion.Status.BACKGROUND;
    L17:
        r0.J1(r15);
        boolean r16 = true;
        if (r1.e != 1) goto L20;
        IRegion.Type r17 = IRegion.Type.VIDEO;
    L21:
        r0.l1(r17);
        if (r1.f == 0) goto L24;
        boolean r18 = true;
    L25:
        r0.S3(r18);
        b r19 = this.d;
        if (r19 != null) goto L28;
    L30:
        r16 = false;
    L31:
        r0.i3(r16);
        r0.w3(0);
        goto L4
    L28:
        if (r19.V(r0) != true) goto L30;
    L24:
        r18 = false;
        goto L25
    L20:
        r17 = IRegion.Type.AUDIO;
        goto L21
    L16:
        r15 = IRegion.Status.FOREGROUND;
        goto L17
    }

    public final void f0(List r9, Map r10, Map r12, k41.b r13, Map r14) {
        Iterator r0 = r9.iterator();
    L4:
        if (r0.hasNext() == false) goto L45;
        IRegion r1 = (IRegion) r0.next();
        LinkedHashMap r3 = (LinkedHashMap) r12;
        t51.b r2 = (t51.b) r3.get(r1.getInteractId());
        LinkedHashMap r4 = (LinkedHashMap) r10;
        t51.e r5 = (t51.e) r4.get(r1.getInteractId());
        boolean r6 = false;
        if (r2 == null) goto L44;
        if (r5 == null) goto L44;
        r13.b(r1, r1.getInteractId());
        b r7 = this.d;
        if (r7 == null) goto L12;
        ((ArrayList) r9).size();
        r7.W(r1);
    L12:
        r1.l1(IRegion.Type.VIDEO);
        b r8 = this.d;
        if (r8 != null) goto L15;
    L17:
        boolean r15 = false;
    L18:
        r1.i3(r15);
        b r16 = this.d;
        if (r16 == null) goto L21;
        r16.U(r1);
    L21:
        LinkedHashMap r17 = (LinkedHashMap) r14;
        q r18 = (q) r17.get(r1.getInteractId());
        if (r18 == null) goto L24;
        int r19 = r18.g;
    L25:
        r1.w3(r19);
        String r20 = r1.getInteractId();
        Intrinsics.checkNotNullParameter(r20, "interactId");
        if (this.e.containsKey(r20) == false) goto L33;
        Boolean r22 = this.e.get(r20);
        if (r22 == null) goto L33;
        if (r22.booleanValue() == false) goto L32;
        IRegion.Status r23 = IRegion.Status.BACKGROUND;
    L34:
        r1.J1(r23);
        boolean r24 = this.h.c(r1.getInteractId());
        Boolean r25 = null;
        s51.c r26 = RevLinkDomainAnchorService.f(this.h, null, r1.getInteractId(), 1);
        if (r26 == null) goto L38;
        r25 = Boolean.valueOf(com.bytedance.android.live.revlink.link.domain.mic.component.m.a(r26));
    L38:
        if (r1.getInteractId() == getContext().Zl()) goto L4;
        if (Intrinsics.areEqual(r25, Boolean.TRUE) == true) goto L42;
        if (r24 == true) goto L42;
    L43:
        r1.S3(r6);
    L42:
        r6 = true;
        goto L43
    L32:
        r23 = IRegion.Status.FOREGROUND;
    L33:
        r23 = IRegion.Status.FOREGROUND;
        goto L34
    L24:
        r19 = 0;
        goto L25
    L15:
        if (r8.V(r1) != true) goto L17;
        r15 = true;
    L44:
        r1.i3(false);
        r1.C4(1.0d, 1.0d).D3(0.1d, 0.1d);
        goto L4
    }
}
