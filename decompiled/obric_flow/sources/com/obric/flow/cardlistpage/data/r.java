package com.obric.flow.cardlistpage.data;

import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.XmlResourceParser;
import com.obric.flow.cardlistpage.base.BaseCardModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f11508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppWidgetManager f11509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppWidgetHost f11510c;

    public r(Context r5, AppWidgetManager r10, AppWidgetHost r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "appWidgetManager");
        Intrinsics.checkNotNullParameter(r11, "appWidgetHost");
        this.f11508a = r5;
        this.f11509b = r10;
        this.f11510c = r11;
    }

    public final Object a(int r31, ContinuationImpl r32) {
        r r5 = this;
        if ((r32 instanceof MinusOneWidgetInitializer$initDefaultWidgetsIfNeeded$1) == false) goto L7;
        MinusOneWidgetInitializer$initDefaultWidgetsIfNeeded$1 r10 = (MinusOneWidgetInitializer$initDefaultWidgetsIfNeeded$1) r32;
        int r11 = r10.label;
        if ((r11 & Integer.MIN_VALUE) == 0) goto L7;
        r10.label = r11 - Integer.MIN_VALUE;
    L8:
        Object r12 = r10.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r10.label;
        com.bytedance.ies.bullet.service.base.c r15 = com.obric.flow.cardlistpage.c.f11462b;
        int r16 = 2;
        if (r14 == 0) goto L22;
        if (r14 == 1) goto L17;
        if (r14 == 2) goto L16;
        if (r14 != 3) goto L15;
        Iterator r17 = (Iterator) r10.L$2;
        List<AppWidgetProviderInfo> r18 = (List) r10.L$1;
        r r19 = (r) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L103:
        if (r17.hasNext() == false) goto L120;
        WidgetCardTemplate r20 = (WidgetCardTemplate) r17.next();
        ComponentName r21 = new ComponentName(r20.getPackageName(), r20.getClassName());
        Intrinsics.checkNotNull(r18);
        Iterator<T> r22 = r18.iterator();
    L106:
        if (r22.hasNext() == false) goto L110;
        Object r110 = r22.next();
        if (Intrinsics.areEqual(((AppWidgetProviderInfo) r110).provider, r21) == false) goto L106;
    L112:
        if (((AppWidgetProviderInfo) r110) == null) goto L103;
        int r23 = r19.f11510c.allocateAppWidgetId();
        if (r19.f11509b.bindAppWidgetIdIfAllowed(r23, r21) == false) goto L115;
        WidgetCardModel r24 = new WidgetCardModel(td.d.c(), String.valueOf(r23), r20.getSpanX(), r20.getSpanY(), r20.getLabel(), "", false, Boxing.boxInt(r20.getOrder()), Boxing.boxLong(System.currentTimeMillis()), Boxing.boxLong(System.currentTimeMillis()));
        com.obric.flow.cardlistpage.c r25 = r15.f();
        r10.L$0 = r19;
        r10.L$1 = r18;
        r10.L$2 = r17;
        r10.L$3 = null;
        r10.L$4 = null;
        r10.label = 3;
        if (r25.a(r24, r10) != r13) goto L103;
        return r13;
    L115:
        r19.f11510c.deleteAppWidgetId(r23);
        goto L103
    L110:
        r110 = null;
        goto L112
    L120:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        Iterator r26 = (Iterator) r10.L$4;
        Set r27 = (Set) r10.L$3;
        List<AppWidgetProviderInfo> r28 = (List) r10.L$2;
        p r111 = (p) r10.L$1;
        r r112 = (r) r10.L$0;
        ResultKt.throwOnFailure(r12);
    L92:
        if (r26.hasNext() == false) goto L101;
        q r29 = (q) r26.next();
        if (r27.contains(r29.f11505a) == true) goto L92;
        if (Intrinsics.areEqual(r29.f11505a, TravelCardModel.ORIGINAL_ID) == false) goto L92;
        long r30 = System.currentTimeMillis();
        String r113 = td.d.c();
        Integer r210 = Boxing.boxInt(r29.e);
        Long r211 = Boxing.boxLong(r30);
        Long r212 = Boxing.boxLong(r30);
        TravelCardModel r114 = new TravelCardModel(r113, null, r29.f11507c, r29.d, r29.f, "", true, r210, r211, r212, 2, null);
        com.obric.flow.cardlistpage.c r33 = r15.f();
        r10.L$0 = r112;
        r10.L$1 = r111;
        r10.L$2 = r28;
        r10.L$3 = r27;
        r10.L$4 = r26;
        r10.label = 2;
        if (r33.a(r114, r10) != r13) goto L92;
        return r13;
    L101:
        r17 = CollectionsKt.sortedWith(r111.f11503a, new ca.d(16)).iterator();
        r18 = r28;
        r19 = r112;
        goto L103
    L17:
        List<AppWidgetProviderInfo> r34 = (List) r10.L$2;
        p r35 = (p) r10.L$1;
        r r36 = (r) r10.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L20
        List<AppWidgetProviderInfo> r37 = r34;
        r5 = r36;
    L79:
        Object r38 = Result.m124constructorimpl((List) r12);     // Catch: Throwable -> L81
    L83:
        List r39 = CollectionsKt.emptyList();
        if (Result.m130isFailureimpl(r38) == false) goto L86;
        r38 = r39;
    L86:
        Iterable r40 = (Iterable) r38;
        ArrayList r41 = new ArrayList(CollectionsKt.h(r40));
        Iterator r42 = r40.iterator();
    L88:
        if (r42.hasNext() == false) goto L90;
        r41.add(((BaseCardModel) r42.next()).getOriginalId());
        goto L88
    L90:
        Set r43 = CollectionsKt.toSet(r41);
        r112 = r5;
        r111 = r35;
        r28 = r37;
        r26 = CollectionsKt.sortedWith(r35.f11504b, new ca.d(15)).iterator();
        r27 = r43;
    L81:
        Throwable th2 = th;
    L82:
        Result.Companion r44 = Result.Companion;
        r38 = Result.m124constructorimpl(ResultKt.createFailure(th2));
    L20:
        th2 = th;
        r37 = r34;
        r5 = r36;
        goto L82
    L22:
        ResultKt.throwOnFailure(r12);
        Intrinsics.checkNotNullParameter("MinusOneWidgetInitializer", "tag");
        Intrinsics.checkNotNullParameter("initDefaultWidgetsIfNeeded", "msg");
        org.koin.core.a r115 = su.a.f22013b;
        if (r115 == null) goto L124;
        ((ju.b) r115.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MinusOneWidgetInitializer", "initDefaultWidgetsIfNeeded");
        XmlResourceParser r45 = r5.f11508a.getResources().getXml(r31);
        ArrayList r46 = new ArrayList();
        ArrayList r116 = new ArrayList();
        int r117 = r45.getEventType();     // Catch: Throwable -> L48
    L26:
        if (r117 == 1) goto L69;
        if (r117 != r16) goto L67;
        String r118 = r45.getName();     // Catch: Throwable -> L48
        if (Intrinsics.areEqual(r118, "widget") == false) goto L51;
        String r119 = r45.getAttributeValue(null, "packageName");     // Catch: Throwable -> L48
        if (r119 != null) goto L34;
        String r120 = "";
    L35:
        String r121 = r45.getAttributeValue(null, "className");     // Catch: Throwable -> L48
        if (r121 != null) goto L38;
        String r213 = "";
    L39:
        int r214 = r45.getAttributeIntValue(null, "spanX", 4);     // Catch: Throwable -> L48
        int r215 = r45.getAttributeIntValue(null, "spanY", 1);     // Catch: Throwable -> L48
        int r216 = r45.getAttributeIntValue(null, "order", 0);     // Catch: Throwable -> L48
        String r47 = r45.getAttributeValue(null, "label");     // Catch: Throwable -> L48
        if (r47 != null) goto L42;
        String r217 = "";
    L44:
        if (r120.length() <= 0) goto L67;
        if (r213.length() <= 0) goto L67;
        r46.add(new WidgetCardTemplate(r120, r213, r214, r215, r217, r216));     // Catch: Throwable -> L48
        goto L67
    L42:
        r217 = r47;
        goto L44
    L38:
        r213 = r121;
        goto L39
    L34:
        r120 = r119;
        goto L35
    L51:
        if (Intrinsics.areEqual(r118, "externalCard") == false) goto L67;
        String r122 = r45.getAttributeValue(null, "originalId");     // Catch: Throwable -> L48
        if (r122 != null) goto L55;
        String r123 = "";
    L56:
        String r124 = r45.getAttributeValue(null, "viewClass");     // Catch: Throwable -> L48
        if (r124 != null) goto L59;
        String r218 = "";
    L60:
        int r219 = r45.getAttributeIntValue(null, "spanX", 4);     // Catch: Throwable -> L48
        int r220 = r45.getAttributeIntValue(null, "spanY", 4);     // Catch: Throwable -> L48
        int r221 = r45.getAttributeIntValue(null, "order", 0);     // Catch: Throwable -> L48
        String r48 = r45.getAttributeValue(null, "label");     // Catch: Throwable -> L48
        if (r48 != null) goto L63;
        String r222 = "";
    L65:
        if (r123.length() <= 0) goto L67;
        r116.add(new q(r123, r218, r219, r220, r222, r221));     // Catch: Throwable -> L48
        goto L67
    L63:
        r222 = r48;
        goto L65
    L59:
        r218 = r124;
        goto L60
    L55:
        r123 = r122;
    L67:
        r117 = r45.next();     // Catch: Throwable -> L48
        r16 = 2;
        goto L26
    L69:
        r45.close();
        r35 = new p(r46, r116);
        if (r46.isEmpty() == true) goto L72;
    L75:
        r37 = r5.f11509b.getInstalledProviders();
        Result.Companion r49 = Result.Companion;     // Catch: Throwable -> L81
        m r50 = m.f11499a;     // Catch: Throwable -> L81
        r10.L$0 = r5;     // Catch: Throwable -> L81
        r10.L$1 = r35;     // Catch: Throwable -> L81
        r10.L$2 = r37;     // Catch: Throwable -> L81
        r10.label = 1;     // Catch: Throwable -> L81
        r12 = r50.a(r10);     // Catch: Throwable -> L81
        if (r12 != r13) goto L79;
        return r13;
    L72:
        if (r116.isEmpty() == false) goto L75;
        return Unit.INSTANCE;
    L48:
        th = move-exception;
        r45.close();
        throw th;
    L124:
        throw new IllegalStateException("KoinApplication has not been started");
    L7:
        r10 = new MinusOneWidgetInitializer$initDefaultWidgetsIfNeeded$1(r5, r32);
        goto L8
    }
}
