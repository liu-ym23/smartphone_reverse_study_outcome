package com.obric.aivoice.sdk;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/aivoice/sdk/IAsrListener;", NameKeys.UnloadStrategy_No_Strategy, "onAsrResponse", NameKeys.UnloadStrategy_No_Strategy, "taskId", NameKeys.UnloadStrategy_No_Strategy, "resp", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IAsrListener {
    void onAsrResponse(String r1, String r2);
}
