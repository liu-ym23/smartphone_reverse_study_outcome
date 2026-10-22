package com.bytedance.ai.bridge.method.calendar;

import com.bytedance.ai.bridge.calendar.AbsGetCalendarEventDetailMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.utils.g;
import e3.d;
import f3.h;
import java.util.ArrayList;
import java.util.Iterator;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n3.b;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/GetCalendarEventDetailMethod;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL$GetCalendarEventDetailParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL$CalendarEventResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetCalendarEventDetailMethod extends AbsGetCalendarEventDetailMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public GetCalendarEventDetailMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetCalendarEventDetailMethodIDL.b r13 = (AbsGetCalendarEventDetailMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        int r14 = b.a;
        OkHttpClient r15 = b.a(r13.getUserName(), r13.getPassword());
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        Iterator<T> r16 = r13.getEventUrls().iterator();
    L4:
        if (r16.hasNext() == false) goto L9;
        HttpUrl r17 = HttpUrl.parse((String) r16.next());
        if (r17 == null) goto L4;
        r0.add(r17);
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L21;
        Intrinsics.checkNotNullParameter(AbsGetCalendarEventDetailMethodIDL.a.class, "<this>");
        BaseModel r18 = c.a(AbsGetCalendarEventDetailMethodIDL.a.class);
        ((AbsGetCalendarEventDetailMethodIDL.a) r18).setCalendarEvents(r1);
        r12.b((ResultModel) r18, "");
        return;
    L21:
        HttpUrl r19 = HttpUrl.parse(r13.getCalendar().getUrl());     // Catch: Exception -> L17
        if (r19 == null) goto L15;
        com.bytedance.ai.bridge.method.calendar.remote.a r20 = new com.bytedance.ai.bridge.method.calendar.remote.a(r15, r19);     // Catch: Exception -> L17
        final ArrayList r21 = new ArrayList();     // Catch: Exception -> L17
        r20.c(r0, new n3.c(r21));     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter(AbsGetCalendarEventDetailMethodIDL.a.class, "<this>");     // Catch: Exception -> L17
        BaseModel r22 = c.a(AbsGetCalendarEventDetailMethodIDL.a.class);     // Catch: Exception -> L17
        ((AbsGetCalendarEventDetailMethodIDL.a) r22).setCalendarEvents(r21);     // Catch: Exception -> L17
        r12.b((ResultModel) r22, "");     // Catch: Exception -> L17
    L20:
        return;
    L15:
        h.a.a(r12, "invalid server url", null, null, 14);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        String r23 = "exception in getting Calendar event detail: " + e.getMessage();
        g.a.e("GetCalendarDetailMethod", r23);
        h.a.a(r12, r23, null, null, 14);
    }
}
