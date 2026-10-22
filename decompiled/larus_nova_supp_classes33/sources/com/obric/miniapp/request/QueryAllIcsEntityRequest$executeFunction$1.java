package com.obric.miniapp.request;

import android.os.Bundle;
import androidx.core.util.Consumer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/obric/miniapp/request/QueryAllIcsEntityRequest$executeFunction$1", "Landroidx/core/util/Consumer;", "Lcom/google/gson/JsonObject;", "accept", "", "resultObj", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueryAllIcsEntityRequest$executeFunction$1 implements Consumer<JsonObject> {
    public QueryAllIcsEntityRequest$executeFunction$1() {
        throw null;
    }

    public final void accept(Object r8) {
        JsonObject r9 = (JsonObject) r8;
        Intrinsics.checkNotNullParameter(r9, "resultObj");
        JsonElement r10 = r9.get("data");     // Catch: Exception -> L16
        if (r10 == null) goto L15;
        JsonObject r11 = r10.getAsJsonObject();     // Catch: Exception -> L16
        if (r11 == null) goto L21;
        JsonElement r4 = r11.get(WindowEvent.Params.RESULT);     // Catch: Exception -> L16
        if (r4 == null) goto L10;
        String r5 = r4.toString();     // Catch: Exception -> L16
    L11:
        FLogger.a.i("QueryAllIcsEntityRequest", "QueryAllIcsEntityRequest result: " + HttpExtKt.p(r11));     // Catch: Exception -> L16
        if (r5 == null) goto L20;
        new Bundle().putString(WindowEvent.Params.RESULT, r5);     // Catch: Exception -> L16
        throw null;     // Catch: Exception -> L16
    L20:
        throw null;     // Catch: Exception -> L16
    L10:
        r5 = null;
        goto L11
    L21:
        throw null;     // Catch: Exception -> L16
    L15:
        throw null;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        FLogger.a.e("QueryAllIcsEntityRequest", "parse result error: " + e.getMessage());
        throw null;
    }
}
