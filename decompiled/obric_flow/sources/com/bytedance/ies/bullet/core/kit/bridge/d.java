package com.bytedance.ies.bullet.core.kit.bridge;

import ai.j0;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Function1 f5339j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Function1 f5340k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.bullet.core.e f5341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1 f5342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rb.b f5343c;
    public final LinkedHashMap d;
    public final LinkedHashMap e;
    public final Lazy f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5344h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1 f5345i;

    static {
        f5339j = BridgeRegistry$Companion$SCOPE_SPLITER$1.f5330a;
        f5340k = BridgeRegistry$Companion$SCOPE_JOINER$1.f5329a;
    }

    public d(com.bytedance.ies.bullet.core.e r5, List r10, Function1 r11, rb.b r12) {
        Intrinsics.checkNotNullParameter(r10, "scopeProviderFactories");
        Intrinsics.checkNotNullParameter(r11, "bridgeProvider");
        Intrinsics.checkNotNullParameter(r12, "contextProviderFactory");
        this.f5341a = r5;
        this.f5342b = r11;
        this.f5343c = r12;
        this.d = new LinkedHashMap();
        this.e = new LinkedHashMap();
        this.f = LazyKt.lazy(BridgeRegistry$bridgeMergeOps$2.f5331a);
        Iterator r13 = r10.iterator();
        if (r13.hasNext() == true) goto L6;
        return;
    L6:
        if (r13.next() != null) goto L10;
        Intrinsics.checkNotNullParameter(null, "scopeProviderFactory");
        Intrinsics.checkNotNullParameter(r12, "contextProviderFactory");
        throw null;
    L10:
        throw new ClassCastException();
    }

    public final void a(b r5) {
        Intrinsics.checkNotNullParameter(r5, "bridge");
        LinkedHashMap r10 = this.e;
        if (r10.containsKey(r5.g()) == false) goto L7;
        b r11 = (b) r10.get(r5.g());
        if (r11 == null) goto L7;
        r11.release();
    L7:
        r10.put(r5.g(), r5);
    }

    public final void b(String r5, JSONObject r10, com.bytedance.ies.bullet.lynx.bridge.c r11, com.bytedance.ies.bullet.lynx.bridge.a r12) {
        Intrinsics.checkNotNullParameter(r5, "funcName");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r12, "reject");
        if (this.g == false) goto L5;
        return;
    L5:
        new BridgeRegistry$handle$impl$1(this).invoke(r5, r10, r11, r12);
    }

    public final void d(final Function2 r5) {
        Intrinsics.checkNotNullParameter(r5, "handler");
        Function2<List<Object>, b, Unit> r10 = new BridgeRegistry$iterateWithFuncName$1(r5);
        Intrinsics.checkNotNullParameter(r10, "handler");
        Iterator r11 = this.d.entrySet().iterator();
        if (r11.hasNext() == true) goto L9;
        Iterator r12 = f().entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        Map.Entry r13 = (Map.Entry) r12.next();
        r10.mo2invoke(CollectionsKt.emptyList(), r13.getValue());
        goto L6
    L8:
        return;
    L9:
        ((Map.Entry) r11.next()).getValue().getClass();
        throw new ClassCastException();
    }

    public final LinkedHashMap f() {
        LinkedHashMap r5 = this.e;
        if (this.f5344h == true) goto L31;
        com.bytedance.ies.bullet.core.e r10 = this.f5341a;
        if (r10 == null) goto L9;
        com.bytedance.ies.bullet.service.monitor.b r11 = r10.f5293c;
        if (r11 == null) goto L9;
        r11.u();
    L9:
        List r12 = (List) this.f5342b.invoke(this.f5343c);
        StringBuilder r13 = new StringBuilder();
        StringBuilder r14 = new StringBuilder();
        Iterator r15 = r12.iterator();
    L11:
        if (r15.hasNext() == false) goto L16;
        b r16 = (b) r15.next();
        r13.append(r16.g());
        StringsKt.b(r13);
        b r17 = (b) r5.get(r16.g());
        if (r17 == null) goto L15;
        r14.append(r17.g());
        StringsKt.b(r14);
        r17.release();
    L15:
        r5.put(r16.g(), r16);
        goto L11
    L16:
        Iterator r18 = ((List) this.f.getValue()).iterator();
    L18:
        if (r18.hasNext() == false) goto L26;
        d r19 = ((a) r18.next()).f5334a;
        LinkedHashMap r20 = new LinkedHashMap();
        Iterator r21 = r19.f().entrySet().iterator();
    L21:
        if (r21.hasNext() == false) goto L18;
        Map.Entry r22 = (Map.Entry) r21.next();
        if (r5.containsKey(r22.getKey()) == true) goto L24;
        r20.put(r22.getKey(), MapsKt.mapOf(TuplesKt.to("has_been_registered", Boolean.FALSE)));
        r5.put(r22.getKey(), r22.getValue());
        goto L21
    L24:
        r20.put(r22.getKey(), MapsKt.mapOf(new Pair[]{TuplesKt.to("has_been_registered", Boolean.TRUE), TuplesKt.to("useOthersOnConflict", Boolean.FALSE)}));
        ((b) r22.getValue()).release();
        goto L21
    L26:
        if (r10 == null) goto L30;
        com.bytedance.ies.bullet.service.monitor.b r23 = r10.f5293c;
        if (r23 == null) goto L30;
        r23.v();
    L30:
        this.f5344h = true;
    L31:
        return r5;
    }

    @Override // com.bytedance.ies.bullet.service.base.m
    public final void release() {
        LinkedHashMap r5 = this.d;
        Iterator r10 = r5.entrySet().iterator();
        if (r10.hasNext() == true) goto L10;
        LinkedHashMap r11 = this.e;
        Iterator r12 = r11.entrySet().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        ((b) ((Map.Entry) r12.next()).getValue()).release();
        goto L6
    L8:
        r5.clear();
        r11.clear();
        this.g = true;
        return;
    L10:
        j0.A(((Map.Entry) r10.next()).getValue());
        throw null;
    }
}
