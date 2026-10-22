package com.bytedance.ai.bridge.method.calendar;

import com.bytedance.ai.bridge.calendar.AbsGetCalendarEventDetailMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.calendar.remote.CalDavResponse$HrefRelation;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.base.a;
import com.lynx.tasm.behavior.ui.utils.e;
import com.lynx.tasm.ui.image.f0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.e0;
import okhttp3.internal.http.StatusLine;
import t0.d;
import t1.c;
import u1.f;
import w1.b;
import w1.i;
import w1.j;
import w1.n;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/GetCalendarEventDetailMethod;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL$GetCalendarEventDetailParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL$CalendarEventResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarEventDetailMethodIDL$GetCalendarEventDetailParamModel;Lo1/f;)V", "Companion", "t1/c", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGetCalendarEventDetailMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GetCalendarEventDetailMethod.kt\ncom/bytedance/ai/bridge/method/calendar/GetCalendarEventDetailMethod\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,85:1\n1863#2,2:86\n*S KotlinDebug\n*F\n+ 1 GetCalendarEventDetailMethod.kt\ncom/bytedance/ai/bridge/method/calendar/GetCalendarEventDetailMethod\n*L\n31#1:86,2\n*E\n"})
public final class GetCalendarEventDetailMethod extends AbsGetCalendarEventDetailMethodIDL {
    public static final c Companion = null;
    private static final String TAG = "GetCalendarDetailMethod";

    static {
        Companion = new c();
    }

    public GetCalendarEventDetailMethod() {
    }

    public static /* synthetic */ Unit b(ArrayList r5, f r10, CalDavResponse$HrefRelation r11) {
        return handle$lambda$5$lambda$3(r5, r10, r11);
    }

    private static final Unit handle$lambda$5$lambda$3(ArrayList r10, f r11, CalDavResponse$HrefRelation r12) {
        Intrinsics.checkNotNullParameter(r11, "response");
        Intrinsics.checkNotNullParameter(r12, "relation");
        if (r12 != CalDavResponse$HrefRelation.f1811b) goto L38;
        boolean r13 = r11.b();
        e0 r5 = r11.f22234b;
        if (r13 == false) goto L32;
        b r14 = (b) r11.a(b.class);
        String r15 = null;
        if (r14 == null) goto L9;
        String r16 = r14.f22678a;
    L11:
        if (r16 != null) goto L17;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L16;
        r17.d(TAG, "Ignoring multi-get response without calendar-data");
    L16:
        return Unit.INSTANCE;
    L17:
        j r18 = (j) r11.a(j.class);
        if (r18 == null) goto L20;
        String r19 = r18.f22691a;
    L21:
        n r20 = (n) r11.a(n.class);
        if (r20 == null) goto L24;
        String r21 = r20.f22698a;
    L25:
        i r22 = (i) r11.a(i.class);
        if (r22 == null) goto L28;
        r15 = r22.f22689a;
    L28:
        StringBuilder r23 = a.e("get event.eTag: ", r19, ", scheduleTag: ", r21, ", contentType: ");
        r23.append(r15);
        r23.append(", href: ");
        r23.append(r5);
        String r24 = r23.toString();
        Intrinsics.checkNotNullParameter(TAG, "tag");
        d r25 = com.bytedance.ai.utils.c.f2846a;
        if (r25 == null) goto L31;
        r25.d(TAG, r24);
    L31:
        r10.add(new AbsGetCalendarEventDetailMethodIDL.CalendarEvent(r19, r5.f20644j, StringsKt.trim(r16).toString(), r21));
        goto L38
    L24:
        r21 = null;
        goto L25
    L20:
        r19 = null;
        goto L21
    L9:
        r16 = null;
        goto L11
    L32:
        StatusLine r26 = r11.f22235c;
        if (r26 == null) goto L38;
        if (r26.code != 404) goto L38;
        r10.add(new AbsGetCalendarEventDetailMethodIDL.CalendarEvent("N/A", r5.f20644j, "", null, 8, null));
    L38:
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsGetCalendarEventDetailMethodIDL.GetCalendarEventDetailParamModel) r10, r11);
    }

    public void handle(n1.c r10, AbsGetCalendarEventDetailMethodIDL.GetCalendarEventDetailParamModel r11, o1.f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        OkHttpClient r5 = oo.j.e(r11.getUserName(), r11.getPassword());
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r11.getEventUrls().iterator();
    L4:
        if (r15.hasNext() == false) goto L9;
        e0 r16 = e0.h((String) r15.next());
        if (r16 == null) goto L4;
        r13.add(r16);
        goto L4
    L9:
        if (r13.isEmpty() == false) goto L25;
        Intrinsics.checkNotNullParameter(AbsGetCalendarEventDetailMethodIDL.CalendarEventResultModel.class, "<this>");
        BaseModel r17 = e.c(AbsGetCalendarEventDetailMethodIDL.CalendarEventResultModel.class);
        ((AbsGetCalendarEventDetailMethodIDL.CalendarEventResultModel) r17).setCalendarEvents(r14);
        r12.b((ResultModel) r17, "");
        return;
    L25:
        e0 r18 = e0.h(r11.getCalendar().getUrl());     // Catch: Exception -> L16
        if (r18 == null) goto L18;
        u1.d r19 = new u1.d(r5, r18);     // Catch: Exception -> L16
        ArrayList r20 = new ArrayList();     // Catch: Exception -> L16
        r19.g(r13, new t1.b(r20, 0));     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(AbsGetCalendarEventDetailMethodIDL.CalendarEventResultModel.class, "<this>");     // Catch: Exception -> L16
        BaseModel r21 = e.c(AbsGetCalendarEventDetailMethodIDL.CalendarEventResultModel.class);     // Catch: Exception -> L16
        ((AbsGetCalendarEventDetailMethodIDL.CalendarEventResultModel) r21).setCalendarEvents(r20);     // Catch: Exception -> L16
        r12.b((ResultModel) r21, "");     // Catch: Exception -> L16
        return;
    L18:
        r12.a("invalid server url");     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        String r22 = f0.d(e, new StringBuilder("exception in getting Calendar event detail: "), TAG);
        d r23 = com.bytedance.ai.utils.c.f2846a;
        if (r23 == null) goto L23;
        r23.e(TAG, r22);
    L23:
        r12.a(r22);
    }
}
