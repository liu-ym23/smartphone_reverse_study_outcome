package com.obric.miniapp.request;

import android.os.Bundle;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.google.gson.JsonObject;
import com.larus.home.api.main.IPrivacyService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import d3.w;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class SearchCalendarRequest {
    public int a;

    public static final class a {
    }

    static {
    }

    public SearchCalendarRequest() {
        this.a = 2;
    }

    public final Bundle b(Bundle r15) {
        Intrinsics.checkNotNullParameter(r15, "args");
        IPrivacyService r0 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L11;
        return null;
    L11:
        String r3 = r15.getString("eventUuid");
        if (r3 == null) goto L14;
        JsonObject r16 = new JsonObject();
        r16.addProperty("eventUuid", r3);
    L22:
        FLogger.a.d("SearchCalendarRequest", "params: " + r16);
        if (r16 != null) goto L25;
        return null;
    L25:
        return (Bundle) BuildersKt.runBlocking$default(null, new SearchCalendarRequest$handle$1$1(this, r16, null), 1, null);
    L14:
        String r5 = r15.getString("keyword");
        long r7 = r15.getLong("start");
        long r10 = r15.getLong("end");
        if (r5 != null) goto L17;
    L21:
        FLogger.a.w("SearchCalendarRequest", "invalid args: eventId: " + r3 + ", keyword: " + r5 + ", start: " + r7 + ", end: " + r10);
        r16 = null;
        goto L22
    L17:
        if (r7 == 0) goto L21;
        if (r10 == 0) goto L21;
        r16 = new JsonObject();
        r16.addProperty("keyword", r5);
        r16.addProperty("start", Long.valueOf(r7));
        r16.addProperty("end", Long.valueOf(r10));
        goto L22
    L5:
        if (r0.a() != true) goto L7;
        r1 = true;
        goto L9
    }

    public static final void a(final SearchCalendarRequest r8, final w r9, final JsonObject r10, final CompletableDeferred r11) {
        r8.getClass();
        r9.c(new ProtocolMessage("applet.calendar.search", r10, null, new TargetEntity(TargetEntity.Scope.Main, TargetEntity.Target.Self, 4), ProtocolMessage.Type.Call, 36), new SearchCalendarRequest$executeFunction$1(r11), new SearchCalendarRequest$executeFunction$2(r8, r9, r10, r11), null);
    }
}
