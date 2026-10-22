package com.bytedance.ai.bridge.method.calendar;

import com.bytedance.ai.bridge.calendar.AbsGetCalendarObjectsMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import e3.d;
import f2.k;
import f3.h;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import k3.c;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n3.b;
import n3.e;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J,\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/GetCalendarObjectsMethod;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarObjectsMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarObjectsMethodIDL$GetCalendarObjectsParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarObjectsMethodIDL$CalendarEventResultModel;", "getLocalCalendarObject", "getRemoteCalendarObject", "getEventDetail", "davCalendar", "Lcom/bytedance/ai/bridge/method/calendar/remote/CalDavClient;", "eventList", "", "Lokhttp3/HttpUrl;", "isLocalCalendar", "", com.bytedance.android.ec.core.event.a.KEY_URL, "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetCalendarObjectsMethod extends AbsGetCalendarObjectsMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public GetCalendarObjectsMethod() {
    }

    public static void b(com.bytedance.ai.bridge.method.calendar.remote.a r10, List r11, h r12) {
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L8
        r0.addAll(r11);     // Catch: Exception -> L8
        List r13 = CollectionsKt.chunked(r0, 50);     // Catch: Exception -> L8
        final ArrayList r1 = new ArrayList();     // Catch: Exception -> L8
        Iterator r14 = r13.iterator();     // Catch: Exception -> L8
    L4:
        if (r14.hasNext() == false) goto L6;
        r10.c((List) r14.next(), new e(r1));     // Catch: Exception -> L8
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(AbsGetCalendarObjectsMethodIDL.a.class, "<this>");     // Catch: Exception -> L8
        BaseModel r15 = c.a(AbsGetCalendarObjectsMethodIDL.a.class);     // Catch: Exception -> L8
        ((AbsGetCalendarObjectsMethodIDL.a) r15).setCalendarEvents(r1);     // Catch: Exception -> L8
        r12.b((ResultModel) r15, "");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        String r16 = "exception in getting event detail: " + e.getMessage();
        g.a.e("GetCalendarObjectsMethod", r16);
        h.a.a(r12, r16, null, null, 14);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [n3.d] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetCalendarObjectsMethodIDL.b r13 = (AbsGetCalendarObjectsMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (Intrinsics.areEqual(r13.getCalendar().getUrl().toLowerCase(), "local://calendar") == true) goto L26;
        int r14 = b.a;
        OkHttpClient r15 = b.a(r13.getUserName(), r13.getPassword());
        HttpUrl r16 = HttpUrl.parse(r13.getCalendar().getUrl());
        if (r16 != null) goto L24;
        h.a.a(r12, "invalid server url", null, null, 14);
        return;
    L24:
        final ArrayList r17 = new ArrayList();     // Catch: Exception -> L20
        com.bytedance.ai.bridge.method.calendar.remote.a r18 = new com.bytedance.ai.bridge.method.calendar.remote.a(r15, r16);     // Catch: Exception -> L20
        Long r19 = r13.getStart();     // Catch: Exception -> L20
        if (r19 == null) goto L13;
        Date r20 = new Date(r19.longValue());     // Catch: Exception -> L20
    L14:
        Long r110 = r13.getEnd();     // Catch: Exception -> L20
        if (r110 == null) goto L17;
        Date r111 = new Date(r110.longValue());     // Catch: Exception -> L20
    L18:
        r18.a(r20, r111, new n3.d(r17));     // Catch: Exception -> L20
        b(r18, r17, r12);     // Catch: Exception -> L20
        return;
    L17:
        r111 = null;
        goto L18
    L13:
        r20 = null;
    L20:
        e = move-exception;
        String r21 = "exception in getting Calendar object: " + e.getMessage();
        g.a.e("GetCalendarObjectsMethod", r21);
        h.a.a(r12, r21, null, null, 14);
        return;
    L26:
        ArrayList r22 = n3.h.d(k.a(), r13.getStart(), r13.getEnd());     // Catch: Exception -> L6
        Intrinsics.checkNotNullParameter(AbsGetCalendarObjectsMethodIDL.a.class, "<this>");     // Catch: Exception -> L6
        BaseModel r112 = c.a(AbsGetCalendarObjectsMethodIDL.a.class);     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type java.util.List<com.bytedance.ai.bridge.calendar.AbsGetCalendarObjectsMethodIDL.CalendarEvent>");     // Catch: Exception -> L6
        ((AbsGetCalendarObjectsMethodIDL.a) r112).setCalendarEvents(r22);     // Catch: Exception -> L6
        r12.b((ResultModel) r112, "");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        String r23 = "Failed to getLocalCalendarObject:" + e.getMessage();
        g.a.e("GetCalendarObjectsMethod", r23);
        h.a.a(r12, r23, null, null, 14);
    }
}
