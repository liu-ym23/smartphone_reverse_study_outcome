package com.bytedance.ai.bridge.service;

import com.bytedance.android.ec.core.event.a;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/service/OnPermissionCallback;", "", "onResult", "", "allGranted", "", a.KEY_RESULT, "", "", "Lcom/bytedance/ai/bridge/service/PermissionState;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OnPermissionCallback {
    void onResult(boolean r1, Map<String, ? extends PermissionState> r10);
}
