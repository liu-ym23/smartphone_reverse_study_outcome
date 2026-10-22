package com.obric.memorydata.sdk.entity.search.oauto;

import android.content.Context;
import com.obric.memorydata.sdk.MemoryResponse;
import com.obric.memorydata.sdk.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/oauto/OAutoGlobalSearch;", "", "<init>", "()V", "searchByQUResult", "Lcom/obric/memorydata/sdk/entity/search/oauto/OAutoSearchResult;", "context", "Landroid/content/Context;", "quResult", "", "isVoiceQuery", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OAutoGlobalSearch {
    public static final OAutoGlobalSearch INSTANCE = null;

    static {
        INSTANCE = new OAutoGlobalSearch();
    }

    private OAutoGlobalSearch() {
    }

    public final OAutoSearchResult searchByQUResult(Context r4, String r5, boolean r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        b r7 = b.f12829a;
        JSONObject r1 = new JSONObject();
        r1.put("quResult", r5);
        if (r6 == false) goto L5;
        String r8 = "VOICE";
    L6:
        r1.put("interactionType", r8);
        MemoryResponse<OAutoSearchResult> r9 = r7.a(r1, r3);
        OAutoSearchResult r10 = (OAutoSearchResult) ZeusTransformUtils.preCheckCast(r9.getData(), OAutoSearchResult.class, "com.obric.memorydata.plugin");
        if (r9.getCode() != 0) goto L11;
        if (r10 == null) goto L11;
        return r10;
    L11:
        return new OAutoSearchResult(r9.getCode(), r9.getMessage(), null);
    L5:
        r8 = "TEXT";
        goto L6
    }
}
