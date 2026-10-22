package com.bytedance.ai.bridge.method.calendar;

import com.bytedance.ai.bridge.calendar.AbsSyncCalendarMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.calendar.remote.CalDavResponse$HrefRelation;
import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import com.bytedance.ai.utils.c;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.base.a;
import com.lynx.tasm.behavior.ui.utils.e;
import com.lynx.tasm.ui.image.f0;
import java.util.ArrayList;
import java.util.Arrays;
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
import okhttp3.internal.http.StatusLine;
import t1.l;
import u1.d;
import u1.f;
import w1.b;
import w1.i;
import w1.j;
import w1.n;
import w1.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JU\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/SyncCalendarMethod;", "Lcom/bytedance/ai/bridge/calendar/AbsSyncCalendarMethodIDL;", "<init>", "()V", "Lu1/d;", "davCalendar", "Ljava/util/ArrayList;", "Lcom/bytedance/ai/bridge/calendar/AbsSyncCalendarMethodIDL$CalendarEvent;", "Lkotlin/collections/ArrayList;", "calendarEventList", "", "syncToken", "", "Lokhttp3/e0;", "eventList", "Lo1/f;", "Lcom/bytedance/ai/bridge/calendar/AbsSyncCalendarMethodIDL$SyncResultModel;", "callback", "", "getEventDetail", "(Lu1/d;Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/List;Lo1/f;)V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/calendar/AbsSyncCalendarMethodIDL$SyncCalendarParamModel;", LynxResourceModule.PARAMS_KEY, "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/calendar/AbsSyncCalendarMethodIDL$SyncCalendarParamModel;Lo1/f;)V", "", "Lcom/bytedance/ai/bridge/method/calendar/remote/Property$NodeInfo;", "syncProperties", "[Lcom/bytedance/ai/bridge/method/calendar/remote/Property$NodeInfo;", "Companion", "t1/l", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSyncCalendarMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SyncCalendarMethod.kt\ncom/bytedance/ai/bridge/method/calendar/SyncCalendarMethod\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,136:1\n808#2,11:137\n*S KotlinDebug\n*F\n+ 1 SyncCalendarMethod.kt\ncom/bytedance/ai/bridge/method/calendar/SyncCalendarMethod\n*L\n63#1:137,11\n*E\n"})
public final class SyncCalendarMethod extends AbsSyncCalendarMethodIDL {
    private static final int BLOCK_SIZE = 50;
    public static final l Companion = null;
    private static final String TAG = "SyncCalendarMethod";
    private final Property$NodeInfo[] syncProperties;

    static {
        Companion = new l();
    }

    public SyncCalendarMethod() {
        this.syncProperties = new Property$NodeInfo[]{b.f22677b, j.f22690b, n.f22697b};
    }

    public static /* synthetic */ Unit b(AbsSyncCalendarMethodIDL.SyncCalendarParamModel r5, ArrayList r10, ArrayList r11, f r12, CalDavResponse$HrefRelation r13) {
        return handle$lambda$2$lambda$0(r5, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit c(ArrayList r5, f r10, CalDavResponse$HrefRelation r11) {
        return getEventDetail$lambda$4(r5, r10, r11);
    }

    private final void getEventDetail(d r5, ArrayList<AbsSyncCalendarMethodIDL.CalendarEvent> r10, String r11, List<e0> r12, o1.f r13) {
        ArrayList r14 = new ArrayList();     // Catch: Exception -> L6
        r14.addAll(r12);     // Catch: Exception -> L6
        Iterator r15 = CollectionsKt.g(r14).iterator();     // Catch: Exception -> L6
    L4:
        if (r15.hasNext() == false) goto L8;
        r5.g((List) r15.next(), new t1.b(r10, 4));     // Catch: Exception -> L6
        goto L4
    L8:
        Intrinsics.checkNotNullParameter(AbsSyncCalendarMethodIDL.SyncResultModel.class, "<this>");     // Catch: Exception -> L6
        BaseModel r16 = e.c(AbsSyncCalendarMethodIDL.SyncResultModel.class);     // Catch: Exception -> L6
        AbsSyncCalendarMethodIDL.SyncResultModel r17 = (AbsSyncCalendarMethodIDL.SyncResultModel) r16;     // Catch: Exception -> L6
        r17.setSyncToken(r11);     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.util.List<com.bytedance.ai.bridge.calendar.AbsSyncCalendarMethodIDL.CalendarEvent>");     // Catch: Exception -> L6
        r17.setCalendarEvents(r10);     // Catch: Exception -> L6
        r13.b((ResultModel) r16, "");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        String r18 = f0.d(e, new StringBuilder("exception in getting event detail: "), TAG);
        t0.d r19 = c.f2846a;
        if (r19 == null) goto L13;
        r19.e(TAG, r18);
    L13:
        r13.a(r18);
    }

    private static final Unit getEventDetail$lambda$4(ArrayList r10, f r11, CalDavResponse$HrefRelation r12) {
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
        t0.d r17 = c.f2846a;
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
        t0.d r25 = c.f2846a;
        if (r25 == null) goto L31;
        r25.d(TAG, r24);
    L31:
        r10.add(new AbsSyncCalendarMethodIDL.CalendarEvent(r19, r5.f20644j, StringsKt.trim(r16).toString(), r21));
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
        r10.add(new AbsSyncCalendarMethodIDL.CalendarEvent("N/A", r5.f20644j, "", null, 8, null));
    L38:
        return Unit.INSTANCE;
    }

    private static final Unit handle$lambda$2$lambda$0(AbsSyncCalendarMethodIDL.SyncCalendarParamModel r5, List r10, ArrayList r11, f r12, CalDavResponse$HrefRelation r13) {
        Intrinsics.checkNotNullParameter(r12, "response");
        Intrinsics.checkNotNullParameter(r13, "relation");
        if (r12.b() == false) goto L26;
        j r14 = (j) r12.a(j.class);
        String r15 = null;
        if (r14 == null) goto L7;
        String r16 = r14.f22691a;
    L8:
        b r17 = (b) r12.a(b.class);
        if (r17 == null) goto L11;
        String r18 = r17.f22678a;
    L12:
        n r19 = (n) r12.a(n.class);
        if (r19 == null) goto L15;
        String r20 = r19.f22698a;
    L16:
        e0 r21 = r12.f22234b;
        if (r18 == null) goto L19;
    L21:
        String r22 = r21.f20644j;
        if (r18 == null) goto L24;
        r15 = StringsKt.trim(r18).toString();
    L24:
        r11.add(new AbsSyncCalendarMethodIDL.CalendarEvent(r16, r22, r15, r20));
        goto L26
    L19:
        if (r5.getShowDetail() == false) goto L21;
        r10.add(r21);
        goto L26
    L15:
        r20 = null;
        goto L16
    L11:
        r18 = null;
        goto L12
    L7:
        r16 = null;
    L26:
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsSyncCalendarMethodIDL.SyncCalendarParamModel) r10, r11);
    }

    public void handle(n1.c r10, AbsSyncCalendarMethodIDL.SyncCalendarParamModel r11, o1.f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        OkHttpClient r13 = oo.j.e(r11.getUserName(), r11.getPassword());     // Catch: Exception -> L11
        e0 r5 = e0.h(r11.getCalendar().getUrl());     // Catch: Exception -> L11
        if (r5 == null) goto L24;
        d r14 = new d(r13, r5);     // Catch: Exception -> L11
        ArrayList<AbsSyncCalendarMethodIDL.CalendarEvent> r15 = new ArrayList();     // Catch: Exception -> L11
        ArrayList r16 = new ArrayList();     // Catch: Exception -> L11
        String r17 = r11.getCalendar().getSyncToken();     // Catch: Exception -> L11
        Property$NodeInfo[] r18 = this.syncProperties;     // Catch: Exception -> L11
        List r19 = r14.b(r17, (Property$NodeInfo[]) Arrays.copyOf(r18, r18.length), new t1.e(r11, r16, r15));     // Catch: Exception -> L11
        ArrayList r20 = new ArrayList();     // Catch: Exception -> L11
        Iterator r21 = ((ArrayList) r19).iterator();     // Catch: Exception -> L11
    L7:
        if (r21.hasNext() == false) goto L13;
        Object r22 = r21.next();     // Catch: Exception -> L11
        if ((r22 instanceof o) == false) goto L7;
        r20.add(r22);     // Catch: Exception -> L11
        goto L7
    L13:
        o r23 = (o) CollectionsKt.firstOrNull(r20);     // Catch: Exception -> L11
        if (r23 == null) goto L17;
        String r24 = r23.f22700a;     // Catch: Exception -> L11
    L16:
        String r25 = r24;
        if (r16.isEmpty() == false) goto L22;
        Intrinsics.checkNotNullParameter(AbsSyncCalendarMethodIDL.SyncResultModel.class, "<this>");     // Catch: Exception -> L11
        BaseModel r26 = e.c(AbsSyncCalendarMethodIDL.SyncResultModel.class);     // Catch: Exception -> L11
        AbsSyncCalendarMethodIDL.SyncResultModel r27 = (AbsSyncCalendarMethodIDL.SyncResultModel) r26;     // Catch: Exception -> L11
        r27.setSyncToken(r25);     // Catch: Exception -> L11
        r27.setCalendarEvents(r15);     // Catch: Exception -> L11
        r12.b((ResultModel) r26, "");     // Catch: Exception -> L11
        return;
    L22:
        getEventDetail(r14, r15, r25, r16, r12);     // Catch: Exception -> L11
        return;
    L17:
        r24 = null;
        goto L16
    L24:
        r12.a("invalid server url");     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        String r28 = f0.d(e, new StringBuilder("exception in synchronizing calendar: "), TAG);
        t0.d r29 = c.f2846a;
        if (r29 == null) goto L29;
        r29.e(TAG, r28);
    L29:
        r12.a(r28);
    }
}
