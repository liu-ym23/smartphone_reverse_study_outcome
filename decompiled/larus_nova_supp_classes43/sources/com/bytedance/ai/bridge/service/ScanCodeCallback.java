package com.bytedance.ai.bridge.service;

import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/ai/bridge/service/ScanCodeCallback;", "", "onSuccess", "", a.KEY_RESULT, "Lcom/bytedance/ai/bridge/service/ScanCodeResult;", "onFail", MessageIndication.MESSAGE_TYPE_MSG, "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ScanCodeCallback {
    void onFail(String r1);

    void onSuccess(ScanCodeResult r1);
}
