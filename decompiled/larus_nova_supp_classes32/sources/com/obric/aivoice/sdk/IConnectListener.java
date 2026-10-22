package com.obric.aivoice.sdk;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/obric/aivoice/sdk/IConnectListener;", NameKeys.UnloadStrategy_No_Strategy, "onServerConnected", NameKeys.UnloadStrategy_No_Strategy, "onServerDisconnected", "voicesdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IConnectListener {
    void onServerConnected();

    void onServerDisconnected();
}
