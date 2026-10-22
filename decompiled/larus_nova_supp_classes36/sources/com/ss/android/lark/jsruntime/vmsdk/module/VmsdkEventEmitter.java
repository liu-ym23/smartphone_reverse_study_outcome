package com.ss.android.lark.jsruntime.vmsdk.module;

import com.bytedance.vmsdk.jsbridge.utils.JavaScriptObject;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@JavaScriptObject(name = "VmsdkEventEmitter")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/jsruntime/vmsdk/module/VmsdkEventEmitter;", "Lcom/bytedance/vmsdk/registry/JavaScriptModule;", "emit", "", "eventName", "", "eventData", "", "jsruntime_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public interface VmsdkEventEmitter extends com.bytedance.vmsdk.registry.b {
    void emit(String r1, Object r2);
}
