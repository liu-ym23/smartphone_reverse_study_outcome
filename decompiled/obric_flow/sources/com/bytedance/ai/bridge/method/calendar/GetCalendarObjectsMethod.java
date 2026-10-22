package com.bytedance.ai.bridge.method.calendar;

import com.bytedance.ai.bridge.calendar.AbsGetCalendarObjectsMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.calendar.remote.CalDavResponse$HrefRelation;
import com.bytedance.ai.utils.c;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.base.a;
import com.lynx.tasm.behavior.ui.utils.e;
import com.lynx.tasm.ui.image.f0;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.e0;
import t1.b;
import t1.d;
import t1.g;
import u1.f;
import w1.i;
import w1.j;
import w1.n;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\f\u0010\u000bJ3\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/GetCalendarObjectsMethod;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarObjectsMethodIDL;", "<init>", "()V", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarObjectsMethodIDL$GetCalendarObjectsParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarObjectsMethodIDL$CalendarEventResultModel;", "callback", "", "getLocalCalendarObject", "(Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarObjectsMethodIDL$GetCalendarObjectsParamModel;Lo1/f;)V", "getRemoteCalendarObject", "Lu1/d;", "davCalendar", "", "Lokhttp3/e0;", "eventList", "getEventDetail", "(Lu1/d;Ljava/util/List;Lo1/f;)V", "", "url", "", "isLocalCalendar", "(Ljava/lang/String;)Z", "Ln1/c;", "bridgeContext", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarObjectsMethodIDL$GetCalendarObjectsParamModel;Lo1/f;)V", "Companion", "t1/d", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGetCalendarObjectsMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GetCalendarObjectsMethod.kt\ncom/bytedance/ai/bridge/method/calendar/GetCalendarObjectsMethod\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,130:1\n1#2:131\n*E\n"})
public final class GetCalendarObjectsMethod extends AbsGetCalendarObjectsMethodIDL {
    private static final int BLOCK_SIZE = 50;
    private static final String COMPONENT_NAME = "VEVENT";
    public static final d Companion = null;
    private static final String LOCAL_CALENDAR = "local://calendar";
    private static final String TAG = "GetCalendarObjectsMethod";

    static {
        Companion = new d();
    }

    public GetCalendarObjectsMethod() {
    }

    public static /* synthetic */ Unit b(ArrayList r5, f r10, CalDavResponse$HrefRelation r11) {
        return getRemoteCalendarObject$lambda$4$lambda$3(r5, r10, r11);
    }

    public static /* synthetic */ Unit c(ArrayList r5, f r10, CalDavResponse$HrefRelation r11) {
        return getEventDetail$lambda$6(r5, r10, r11);
    }

    private final void getEventDetail(u1.d r5, List<e0> r10, o1.f r11) {
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L6
        r12.addAll(r10);     // Catch: Exception -> L6
        List r13 = CollectionsKt.g(r12);     // Catch: Exception -> L6
        ArrayList r14 = new ArrayList();     // Catch: Exception -> L6
        Iterator r15 = r13.iterator();     // Catch: Exception -> L6
    L4:
        if (r15.hasNext() == false) goto L8;
        r5.g((List) r15.next(), new b(r14, 1));     // Catch: Exception -> L6
        goto L4
    L8:
        Intrinsics.checkNotNullParameter(AbsGetCalendarObjectsMethodIDL.CalendarEventResultModel.class, "<this>");     // Catch: Exception -> L6
        BaseModel r16 = e.c(AbsGetCalendarObjectsMethodIDL.CalendarEventResultModel.class);     // Catch: Exception -> L6
        ((AbsGetCalendarObjectsMethodIDL.CalendarEventResultModel) r16).setCalendarEvents(r14);     // Catch: Exception -> L6
        r11.b((ResultModel) r16, "");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        String r17 = f0.d(e, new StringBuilder("exception in getting event detail: "), TAG);
        t0.d r18 = c.f2846a;
        if (r18 == null) goto L13;
        r18.e(TAG, r17);
    L13:
        r11.a(r17);
    }

    private static final Unit getEventDetail$lambda$6(ArrayList r10, f r11, CalDavResponse$HrefRelation r12) {
        Intrinsics.checkNotNullParameter(r11, "response");
        Intrinsics.checkNotNullParameter(r12, "relation");
        if (r12 != CalDavResponse$HrefRelation.f1811b) goto L34;
        if (r11.b() == false) goto L34;
        w1.b r13 = (w1.b) r11.a(w1.b.class);
        String r5 = null;
        if (r13 == null) goto L9;
        String r14 = r13.f22678a;
    L11:
        if (r14 != null) goto L17;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r15 = c.f2846a;
        if (r15 == null) goto L16;
        r15.d(TAG, "Ignoring multi-get response without calendar-data");
    L16:
        return Unit.INSTANCE;
    L17:
        j r16 = (j) r11.a(j.class);
        if (r16 == null) goto L21;
        String r17 = r16.f22691a;
        if (r17 == null) goto L21;
    L22:
        n r18 = (n) r11.a(n.class);
        if (r18 == null) goto L25;
        String r19 = r18.f22698a;
    L26:
        i r20 = (i) r11.a(i.class);
        if (r20 == null) goto L29;
        r5 = r20.f22689a;
    L29:
        StringBuilder r21 = a.e("get event.eTag: ", r17, ", scheduleTag: ", r19, ", contentType: ");
        r21.append(r5);
        r21.append(", href: ");
        e0 r22 = r11.f22234b;
        r21.append(r22);
        String r23 = r21.toString();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r24 = c.f2846a;
        if (r24 == null) goto L32;
        r24.d(TAG, r23);
    L32:
        r10.add(new AbsGetCalendarObjectsMethodIDL.CalendarEvent(r17, r22.f20644j, StringsKt.trim(r14).toString(), r19));
        goto L34
    L25:
        r19 = null;
    L21:
        r17 = "N/A";
        goto L22
    L9:
        r14 = null;
    L34:
        return Unit.INSTANCE;
    }

    private final void getLocalCalendarObject(AbsGetCalendarObjectsMethodIDL.GetCalendarObjectsParamModel r5, o1.f r10) {
        Long r11 = r5.getStart();     // Catch: Exception -> L4
        Long r12 = r5.getEnd();     // Catch: Exception -> L4
        ArrayList r13 = g.b(s0.c.a(), r11, r12);     // Catch: Exception -> L4
        Intrinsics.checkNotNullParameter(AbsGetCalendarObjectsMethodIDL.CalendarEventResultModel.class, "<this>");     // Catch: Exception -> L4
        BaseModel r14 = e.c(AbsGetCalendarObjectsMethodIDL.CalendarEventResultModel.class);     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type java.util.List<com.bytedance.ai.bridge.calendar.AbsGetCalendarObjectsMethodIDL.CalendarEvent>");     // Catch: Exception -> L4
        ((AbsGetCalendarObjectsMethodIDL.CalendarEventResultModel) r14).setCalendarEvents(r13);     // Catch: Exception -> L4
        r10.b((ResultModel) r14, "");     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r15 = f0.d(e, new StringBuilder("Failed to getLocalCalendarObject:"), TAG);
        t0.d r16 = c.f2846a;
        if (r16 == null) goto L8;
        r16.e(TAG, r15);
    L8:
        r10.a(r15);
    }

    private final void getRemoteCalendarObject(AbsGetCalendarObjectsMethodIDL.GetCalendarObjectsParamModel r10, o1.f r11) {
        OkHttpClient r5 = oo.j.e(r10.getUserName(), r10.getPassword());
        e0 r12 = e0.h(r10.getCalendar().getUrl());
        if (r12 != null) goto L22;
        r11.a("invalid server url");
        return;
    L22:
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L7
        u1.d r14 = new u1.d(r5, r12);     // Catch: Exception -> L7
        Long r15 = r10.getStart();     // Catch: Exception -> L7
        Date r16 = null;
        if (r15 == null) goto L9;
        Date r17 = new Date(r15.longValue());     // Catch: Exception -> L7
    L10:
        Long r18 = r10.getEnd();     // Catch: Exception -> L7
        if (r18 == null) goto L13;
        r16 = new Date(r18.longValue());     // Catch: Exception -> L7
    L13:
        r14.f(r17, r16, new b(r13, 2));     // Catch: Exception -> L7
        getEventDetail(r14, r13, r11);     // Catch: Exception -> L7
        return;
    L9:
        r17 = null;
    L7:
        e = move-exception;
        String r19 = f0.d(e, new StringBuilder("exception in getting Calendar object: "), TAG);
        t0.d r20 = c.f2846a;
        if (r20 == null) goto L18;
        r20.e(TAG, r19);
    L18:
        r11.a(r19);
    }

    private static final Unit getRemoteCalendarObject$lambda$4$lambda$3(List r5, f r10, CalDavResponse$HrefRelation r11) {
        Intrinsics.checkNotNullParameter(r10, "response");
        Intrinsics.checkNotNullParameter(r11, "relation");
        if (r11 != CalDavResponse$HrefRelation.f1811b) goto L8;
        if (r10.b() == false) goto L8;
        r5.add(r10.f22234b);
    L8:
        return Unit.INSTANCE;
    }

    private final boolean isLocalCalendar(String r5) {
        return Intrinsics.areEqual(r5.toLowerCase(), LOCAL_CALENDAR);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsGetCalendarObjectsMethodIDL.GetCalendarObjectsParamModel) r10, r11);
    }

    public void handle(n1.c r5, AbsGetCalendarObjectsMethodIDL.GetCalendarObjectsParamModel r10, o1.f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (isLocalCalendar(r10.getCalendar().getUrl()) == false) goto L6;
        getLocalCalendarObject(r10, r11);
        return;
    L6:
        getRemoteCalendarObject(r10, r11);
    }
}
