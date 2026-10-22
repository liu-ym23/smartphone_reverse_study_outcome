package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/CalendarOperationMethod;", "Lcom/obric/miniapp/aibridge/AbsCalendarOperationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsCalendarOperationMethodIDL$CalendarOperationParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsCalendarOperationMethodIDL$CalendarOperationResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CalendarOperationMethod extends AbsCalendarOperationMethodIDL {
    public CalendarOperationMethod() {
    }

    public final void handle(e3.d r5, ParamModel r6, f3.h r7) {
        AbsCalendarOperationMethodIDL.a r8 = (AbsCalendarOperationMethodIDL.a) r6;
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "callback");
        int r9 = com.obric.miniapp.calendar.a.a;
        Intrinsics.checkNotNullParameter(r8, "param");
        FLogger.a.i("CalendarHelper", "parse param: " + r8.getJson());
        JsonElement r10 = JsonParser.parseString(r8.getJson());     // Catch: Exception -> L5
    L7:
        if ((r10 instanceof JsonArray) == false) goto L18;
        JsonArray r11 = ((JsonArray) r10).getAsJsonArray();
        ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10));
        Iterator r13 = r11.iterator();
    L10:
        if (r13.hasNext() == false) goto L16;
        JsonObject r1 = (JsonElement) r13.next();
        if ((r1 instanceof JsonObject) == false) goto L14;
        int r3 = com.obric.miniapp.calendar.a.a;
        vka.b r2 = com.obric.miniapp.calendar.a.a(r1);
    L15:
        r12.add(new vka.o(r2));
        goto L10
    L14:
        r2 = new vka.g("");
        goto L15
    L16:
        vka.b r14 = new vka.a(r12);
    L21:
        vka.f r15 = vka.f.a;
        JsonElement r16 = (JsonElement) r14.execute();
        Intrinsics.checkNotNullParameter(AbsCalendarOperationMethodIDL.b.class, "<this>");
        AbsCalendarOperationMethodIDL.b r17 = k3.c.a(AbsCalendarOperationMethodIDL.b.class);
        r17.setResult(r16.toString());
        r7.b(r17, "");
        return;
    L18:
        if ((r10 instanceof JsonObject) == false) goto L20;
        r14 = new vka.o(com.obric.miniapp.calendar.a.a((JsonObject) r10));
        goto L21
    L20:
        r14 = new vka.o(new vka.g("Illegal JSON format"));
    L5:
        r10 = null;
        goto L7
    }
}
