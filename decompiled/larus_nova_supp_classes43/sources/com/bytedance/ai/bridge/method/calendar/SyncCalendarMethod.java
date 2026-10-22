package com.bytedance.ai.bridge.method.calendar;

import com.bytedance.ai.bridge.calendar.AbsSyncCalendarMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.calendar.remote.Property;
import com.bytedance.ai.utils.g;
import e3.d;
import f3.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import k3.c;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import n3.j;
import n3.k;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import p3.b;
import p3.o;
import p3.v;
import p3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016JN\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/SyncCalendarMethod;", "Lcom/bytedance/ai/bridge/calendar/AbsSyncCalendarMethodIDL;", "<init>", "()V", "syncProperties", "", "Lcom/bytedance/ai/bridge/method/calendar/remote/Property$NodeInfo;", "[Lcom/bytedance/ai/bridge/method/calendar/remote/Property$NodeInfo;", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/calendar/AbsSyncCalendarMethodIDL$SyncCalendarParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/calendar/AbsSyncCalendarMethodIDL$SyncResultModel;", "getEventDetail", "davCalendar", "Lcom/bytedance/ai/bridge/method/calendar/remote/CalDavClient;", "calendarEventList", "Ljava/util/ArrayList;", "Lcom/bytedance/ai/bridge/calendar/AbsSyncCalendarMethodIDL$CalendarEvent;", "Lkotlin/collections/ArrayList;", "syncToken", "", "eventList", "", "Lokhttp3/HttpUrl;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SyncCalendarMethod extends AbsSyncCalendarMethodIDL {
    public static final /* synthetic */ int c = 0;
    public final Property.NodeInfo[] b;

    public static final class a {
    }

    static {
    }

    public SyncCalendarMethod() {
        this.b = new Property.NodeInfo[]{b.c, o.c, v.c};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [n3.j] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        final AbsSyncCalendarMethodIDL.a r13 = (AbsSyncCalendarMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        int r1 = n3.b.a;     // Catch: Exception -> L21
        OkHttpClient r14 = n3.b.a(r13.getUserName(), r13.getPassword());     // Catch: Exception -> L21
        HttpUrl r15 = HttpUrl.parse(r13.getCalendar().getUrl());     // Catch: Exception -> L21
        if (r15 == null) goto L19;
        com.bytedance.ai.bridge.method.calendar.remote.a r16 = new com.bytedance.ai.bridge.method.calendar.remote.a(r14, r15);     // Catch: Exception -> L21
        final ArrayList r17 = new ArrayList();     // Catch: Exception -> L21
        final ArrayList r18 = new ArrayList();     // Catch: Exception -> L21
        String r19 = r13.getCalendar().getSyncToken();     // Catch: Exception -> L21
        Property.NodeInfo[] r20 = this.b;     // Catch: Exception -> L21
        List r21 = r16.h(r19, (Property.NodeInfo[]) Arrays.copyOf(r20, r20.length), new j(r13, r18, r17));     // Catch: Exception -> L21
        ArrayList r22 = new ArrayList();     // Catch: Exception -> L21
        Iterator r23 = r21.iterator();     // Catch: Exception -> L21
    L7:
        if (r23.hasNext() == false) goto L11;
        Object r24 = r23.next();     // Catch: Exception -> L21
        if ((r24 instanceof x) == false) goto L7;
        r22.add(r24);     // Catch: Exception -> L21
        goto L7
    L11:
        x r25 = (x) CollectionsKt.firstOrNull(r22);     // Catch: Exception -> L21
        if (r25 == null) goto L14;
        String r26 = r25.b;     // Catch: Exception -> L21
    L16:
        if (r18.isEmpty() == false) goto L18;
        Intrinsics.checkNotNullParameter(AbsSyncCalendarMethodIDL.b.class, "<this>");     // Catch: Exception -> L21
        BaseModel r27 = c.a(AbsSyncCalendarMethodIDL.b.class);     // Catch: Exception -> L21
        AbsSyncCalendarMethodIDL.b r28 = (AbsSyncCalendarMethodIDL.b) r27;     // Catch: Exception -> L21
        r28.setSyncToken(r26);     // Catch: Exception -> L21
        r28.setCalendarEvents(r17);     // Catch: Exception -> L21
        r12.b((ResultModel) r27, "");     // Catch: Exception -> L21
        return;
    L18:
        b(r16, r17, r26, r18, r12);     // Catch: Exception -> L21
        return;
    L14:
        r26 = null;
        goto L16
    L19:
        h.a.a(r12, "invalid server url", null, null, 14);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        String r29 = "exception in synchronizing calendar: " + e.getMessage();
        g.a.e("SyncCalendarMethod", r29);
        h.a.a(r12, r29, null, null, 14);
    }

    public static void b(com.bytedance.ai.bridge.method.calendar.remote.a r10, final ArrayList r11, String r12, List r13, h r14) {
        ArrayList r0 = new ArrayList();     // Catch: Exception -> L8
        r0.addAll(r13);     // Catch: Exception -> L8
        Iterator r15 = CollectionsKt.chunked(r0, 50).iterator();     // Catch: Exception -> L8
    L4:
        if (r15.hasNext() == false) goto L6;
        r10.c((List) r15.next(), new k(r11));     // Catch: Exception -> L8
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(AbsSyncCalendarMethodIDL.b.class, "<this>");     // Catch: Exception -> L8
        BaseModel r16 = c.a(AbsSyncCalendarMethodIDL.b.class);     // Catch: Exception -> L8
        AbsSyncCalendarMethodIDL.b r17 = (AbsSyncCalendarMethodIDL.b) r16;     // Catch: Exception -> L8
        r17.setSyncToken(r12);     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type java.util.List<com.bytedance.ai.bridge.calendar.AbsSyncCalendarMethodIDL.CalendarEvent>");     // Catch: Exception -> L8
        r17.setCalendarEvents(r11);     // Catch: Exception -> L8
        r14.b((ResultModel) r16, "");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        String r18 = "exception in getting event detail: " + e.getMessage();
        g.a.e("SyncCalendarMethod", r18);
        h.a.a(r14, r18, null, null, 14);
    }
}
