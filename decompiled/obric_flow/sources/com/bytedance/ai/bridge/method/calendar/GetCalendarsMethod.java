package com.bytedance.ai.bridge.method.calendar;

import androidx.room.jarjarred.org.antlr.runtime.a;
import com.bytedance.ai.bridge.calendar.AbsGetCalendarsMethodIDL;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.method.calendar.remote.CalDavResponse$HrefRelation;
import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import com.bytedance.ai.utils.c;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.ui.image.f0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.e0;
import oo.j;
import t1.f;
import w1.b;
import w1.d;
import w1.e;
import w1.h;
import w1.l;
import w1.m;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ai/bridge/method/calendar/GetCalendarsMethod;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL;", "<init>", "()V", "Lokhttp3/OkHttpClient;", "httpClient", "", "Lokhttp3/e0;", "urlList", "Lo1/f;", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$CalendarResultModel;", "callback", "", "getCalendarList", "(Lokhttp3/OkHttpClient;Ljava/util/List;Lo1/f;)V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$GetCalendarsParamModel;", LynxResourceModule.PARAMS_KEY, "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/calendar/AbsGetCalendarsMethodIDL$GetCalendarsParamModel;Lo1/f;)V", "", "Lcom/bytedance/ai/bridge/method/calendar/remote/Property$NodeInfo;", "homeSetProperties", "[Lcom/bytedance/ai/bridge/method/calendar/remote/Property$NodeInfo;", "collectionProperties", "Companion", "t1/f", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GetCalendarsMethod extends AbsGetCalendarsMethodIDL {
    public static final f Companion = null;
    private static final String TAG = "GetCalendarsMethod";
    private final Property$NodeInfo[] collectionProperties;
    private final Property$NodeInfo[] homeSetProperties;

    static {
        Companion = new f();
    }

    public GetCalendarsMethod() {
        Property$NodeInfo r5 = w1.f.f22683b;
        Property$NodeInfo r10 = m.f22694b;
        this.homeSetProperties = new Property$NodeInfo[]{r5, r10, d.f22680b};
        this.collectionProperties = new Property$NodeInfo[]{r5, l.f22693b, r10, h.f22686b, b.f22677b, e.f22681b};
    }

    public static /* synthetic */ Unit b(u1.d r5, o1.f r10, ArrayList r11, u1.f r12, CalDavResponse$HrefRelation r13) {
        return handle$lambda$2$lambda$1(r5, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit c(ArrayList r5, u1.f r10, CalDavResponse$HrefRelation r11) {
        return getCalendarList$lambda$4(r5, r10, r11);
    }

    private final void getCalendarList(OkHttpClient r10, List<e0> r11, o1.f r12) {
        ArrayList r5 = new ArrayList();
        if (r11.isEmpty() == false) goto L19;
        Intrinsics.checkNotNullParameter(AbsGetCalendarsMethodIDL.CalendarResultModel.class, "<this>");
        BaseModel r13 = com.lynx.tasm.behavior.ui.utils.e.c(AbsGetCalendarsMethodIDL.CalendarResultModel.class);
        ((AbsGetCalendarsMethodIDL.CalendarResultModel) r13).setCalendars(r5);
        r12.b((ResultModel) r13, "");
        return;
    L19:
        Iterator<e0> r14 = r11.iterator();     // Catch: Exception -> L10
    L8:
        if (r14.hasNext() == false) goto L12;
        u1.d r15 = new u1.d(r10, r14.next());     // Catch: Exception -> L10
        Property$NodeInfo[] r16 = this.collectionProperties;     // Catch: Exception -> L10
        r15.e(1, (Property$NodeInfo[]) Arrays.copyOf(r16, r16.length), new t1.b(r5, 3));     // Catch: Exception -> L10
        goto L8
    L12:
        Intrinsics.checkNotNullParameter(AbsGetCalendarsMethodIDL.CalendarResultModel.class, "<this>");     // Catch: Exception -> L10
        BaseModel r17 = com.lynx.tasm.behavior.ui.utils.e.c(AbsGetCalendarsMethodIDL.CalendarResultModel.class);     // Catch: Exception -> L10
        ((AbsGetCalendarsMethodIDL.CalendarResultModel) r17).setCalendars(r5);     // Catch: Exception -> L10
        r12.b((ResultModel) r17, "");     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        String r18 = f0.d(e, new StringBuilder("exception in getting Calendar: "), TAG);
        t0.d r19 = c.f2846a;
        if (r19 == null) goto L17;
        r19.e(TAG, r18);
    L17:
        r12.a(r18);
    }

    private static final Unit getCalendarList$lambda$4(ArrayList r10, u1.f r11, CalDavResponse$HrefRelation r12) {
        Intrinsics.checkNotNullParameter(r11, "response");
        Intrinsics.checkNotNullParameter(r12, "relation");
        if (r12 != CalDavResponse$HrefRelation.f1811b) goto L27;
        if (r11.b() == false) goto L27;
        m r13 = (m) r11.a(m.class);
        if (r13 == null) goto L27;
        LinkedHashSet r14 = r13.f22696a;
        if (r14 == null) goto L27;
        if (r14.contains(m.f) != true) goto L27;
        w1.f r15 = (w1.f) r11.a(w1.f.class);
        if (r15 == null) goto L16;
        String r16 = r15.f22684a;
        if (r16 == null) goto L16;
    L17:
        e0 r5 = r11.f22234b;
        h r17 = (h) r11.a(h.class);
        if (r17 == null) goto L21;
        String r18 = r17.f22687a;
        if (r18 == null) goto L21;
    L22:
        String r19 = null;
        String r20 = r5.f20644j;
        int r21 = 8;
        String r22 = r16;
        String r23 = r18;
        AbsGetCalendarsMethodIDL.Calendar r24 = new AbsGetCalendarsMethodIDL.Calendar(r22, r20, r23, r19, r21, null);
        String r110 = a.v(com.lynx.tasm.base.a.e("discover calendar:' ", r16, "' (CTag: ", r18, "), url: "), r20, TAG, "tag");
        t0.d r111 = c.f2846a;
        if (r111 == null) goto L25;
        r111.d(TAG, r110);
    L25:
        r10.add(r24);
    L21:
        r18 = "N/A";
    L16:
        r16 = "UnnamedCalendar";
    L27:
        return Unit.INSTANCE;
    }

    private static final Unit handle$lambda$2$lambda$1(u1.d r5, o1.f r10, List r11, u1.f r12, CalDavResponse$HrefRelation r13) {
        Intrinsics.checkNotNullParameter(r12, "response");
        Intrinsics.checkNotNullParameter(r13, "<unused var>");
        if (r12.b() == false) goto L17;
        d r14 = (d) r12.a(d.class);
        if (r14 == null) goto L22;
        LinkedList r15 = r14.f22692a;
        if (r15.isEmpty() == true) goto L22;
        e0 r16 = r5.f22222b.j((String) CollectionsKt.first(r15));
        if (r16 == null) goto L11;
        e0 r17 = com.lynx.jsbridge.a.i(r16);
    L12:
        String r18 = "Calendar Home Set URL: " + r17;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r19 = c.f2846a;
        if (r19 == null) goto L15;
        r19.d(TAG, r18);
    L15:
        if (r17 == null) goto L22;
        r11.add(r17);
        goto L22
    L11:
        r17 = null;
    L22:
        return Unit.INSTANCE;
    L17:
        String r20 = "Failed to get calendar home set " + r12.f22235c;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        t0.d r21 = c.f2846a;
        if (r21 == null) goto L20;
        r21.e(TAG, r20);
    L20:
        r10.a(r20);
        goto L22
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, o1.f r11) {
        handle(r5, (AbsGetCalendarsMethodIDL.GetCalendarsParamModel) r10, r11);
    }

    public void handle(n1.c r5, AbsGetCalendarsMethodIDL.GetCalendarsParamModel r10, o1.f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        OkHttpClient r12 = j.e(r10.getUserName(), r10.getPassword());
        e0 r13 = e0.h(r10.getServerUrl());
        if (r13 != null) goto L14;
        r11.a("invalid server url");
        return;
    L14:
        u1.d r14 = new u1.d(r12, r13);     // Catch: Exception -> L6
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L6
        Property$NodeInfo[] r16 = this.homeSetProperties;     // Catch: Exception -> L6
        r14.e(0, (Property$NodeInfo[]) Arrays.copyOf(r16, r16.length), new t1.e(r14, r11, r15));     // Catch: Exception -> L6
        getCalendarList(r12, r15, r11);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        String r17 = f0.d(e, new StringBuilder("exception in getting Calendar home set: "), TAG);
        t0.d r18 = c.f2846a;
        if (r18 == null) goto L10;
        r18.e(TAG, r17);
    L10:
        r11.a(r17);
    }
}
