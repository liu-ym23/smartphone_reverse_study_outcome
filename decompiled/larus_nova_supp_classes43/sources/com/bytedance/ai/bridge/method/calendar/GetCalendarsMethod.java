package com.bytedance.ai.bridge.method.calendar;

import com.bytedance.ai.bridge.calendar.AbsGetCalendarsMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.calendar.remote.Property;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n3.g;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import p3.b;
import p3.d;
import p3.f;
import p3.h;
import p3.k;
import p3.r;
import p3.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J,\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/GetCalendarsMethod;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL;", "<init>", "()V", "homeSetProperties", "", "Lcom/bytedance/ai/bridge/method/calendar/remote/Property$NodeInfo;", "[Lcom/bytedance/ai/bridge/method/calendar/remote/Property$NodeInfo;", "collectionProperties", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$GetCalendarsParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$CalendarResultModel;", "getCalendarList", "httpClient", "Lokhttp3/OkHttpClient;", "urlList", "", "Lokhttp3/HttpUrl;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetCalendarsMethod extends AbsGetCalendarsMethodIDL {
    public static final /* synthetic */ int d = 0;
    public final Property.NodeInfo[] b;
    public final Property.NodeInfo[] c;

    public static final class a {
    }

    static {
    }

    public GetCalendarsMethod() {
        Property.NodeInfo r10 = h.c;
        Property.NodeInfo r11 = t.c;
        this.b = new Property.NodeInfo[]{r10, r11, d.c};
        this.c = new Property.NodeInfo[]{r10, r.c, r11, k.c, b.c, f.c};
    }

    public final void b(OkHttpClient r10, List<HttpUrl> r11, f3.h<AbsGetCalendarsMethodIDL.a> r12) {
        final ArrayList r0 = new ArrayList();
        ArrayList r13 = (ArrayList) r11;
        if (r13.isEmpty() == false) goto L14;
        Intrinsics.checkNotNullParameter(AbsGetCalendarsMethodIDL.a.class, "<this>");
        BaseModel r14 = c.a(AbsGetCalendarsMethodIDL.a.class);
        ((AbsGetCalendarsMethodIDL.a) r14).setCalendars(r0);
        r12.b((ResultModel) r14, "");
        return;
    L14:
        Iterator r15 = r13.iterator();     // Catch: Exception -> L11
    L7:
        if (r15.hasNext() == false) goto L9;
        com.bytedance.ai.bridge.method.calendar.remote.a r16 = new com.bytedance.ai.bridge.method.calendar.remote.a(r10, (HttpUrl) r15.next());     // Catch: Exception -> L11
        Property.NodeInfo[] r1 = this.c;     // Catch: Exception -> L11
        r16.g(1, (Property.NodeInfo[]) Arrays.copyOf(r1, r1.length), new g(r0));     // Catch: Exception -> L11
        goto L7
    L9:
        Intrinsics.checkNotNullParameter(AbsGetCalendarsMethodIDL.a.class, "<this>");     // Catch: Exception -> L11
        BaseModel r17 = c.a(AbsGetCalendarsMethodIDL.a.class);     // Catch: Exception -> L11
        ((AbsGetCalendarsMethodIDL.a) r17).setCalendars(r0);     // Catch: Exception -> L11
        r12.b((ResultModel) r17, "");     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        String r18 = "exception in getting Calendar: " + e.getMessage();
        com.bytedance.ai.utils.g.a.e("GetCalendarsMethod", r18);
        f3.h.a.a(r12, r18, null, null, 14);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, final f3.h r12) {
        AbsGetCalendarsMethodIDL.b r13 = (AbsGetCalendarsMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        int r14 = n3.b.a;
        OkHttpClient r15 = n3.b.a(r13.getUserName(), r13.getPassword());
        HttpUrl r16 = HttpUrl.parse(r13.getServerUrl());
        if (r16 != null) goto L10;
        f3.h.a.a(r12, "invalid server url", null, null, 14);
        return;
    L10:
        final com.bytedance.ai.bridge.method.calendar.remote.a r17 = new com.bytedance.ai.bridge.method.calendar.remote.a(r15, r16);     // Catch: Exception -> L6
        final ArrayList r18 = new ArrayList();     // Catch: Exception -> L6
        Property.NodeInfo[] r19 = this.b;     // Catch: Exception -> L6
        r17.g(0, (Property.NodeInfo[]) Arrays.copyOf(r19, r19.length), new n3.f(r17, r12, r18));     // Catch: Exception -> L6
        b(r15, r18, r12);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        String r20 = "exception in getting Calendar home set: " + e.getMessage();
        com.bytedance.ai.utils.g.a.e("GetCalendarsMethod", r20);
        f3.h.a.a(r12, r20, null, null, 14);
    }
}
