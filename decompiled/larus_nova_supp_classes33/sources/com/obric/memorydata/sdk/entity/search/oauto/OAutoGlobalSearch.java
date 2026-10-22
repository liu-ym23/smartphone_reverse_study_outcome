package com.obric.memorydata.sdk.entity.search.oauto;

import android.content.Context;
import android.os.Bundle;
import com.obric.memorydata.sdk.MemoryResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pka.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/oauto/OAutoGlobalSearch;", "", "<init>", "()V", "searchByQUResult", "Lcom/obric/memorydata/sdk/entity/search/oauto/OAutoSearchResult;", "context", "Landroid/content/Context;", "quResult", "", "isVoiceQuery", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OAutoGlobalSearch {
    public static final OAutoGlobalSearch INSTANCE = null;

    static {
        INSTANCE = new OAutoGlobalSearch();
    }

    private OAutoGlobalSearch() {
    }

    public final OAutoSearchResult searchByQUResult(Context r5, String r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        a r1 = a.a;
        JSONObject r2 = new JSONObject();
        r2.put("quResult", r6);
        if (r7 == false) goto L5;
        String r8 = "VOICE";
    L6:
        r2.put("interactionType", r8);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        Bundle r9 = new Bundle();
        r9.putString("oAutoGlobalSearchExecutorParams", r2.toString());
        MemoryResponse r10 = a.c(r5, "oAutoGlobalSearchIntent", r9);
        OAutoSearchResult r11 = (OAutoSearchResult) r10.c;
        if (r10.a != 0) goto L11;
        if (r11 == null) goto L11;
        return r11;
    L11:
        return new OAutoSearchResult(r10.a, r10.b, null);
    L5:
        r8 = "TEXT";
        goto L6
    }
}
