package com.bytedance.ies.xbridge.base.runtime.depend;

import androidx.annotation.Keep;
import fe.e;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0001\u0004J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostMemoryWaringDepend;", "", "", "containerId", "Lfe/e;", "listener", "", "registerMemoryWaringListener", "(Ljava/lang/String;Lfe/e;)V", "unRegisterMemoryWaringListener", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostMemoryWaringDepend {
    void registerMemoryWaringListener(String r5, e r10);

    void unRegisterMemoryWaringListener(String r5);
}
