package com.bytedance.sdk.xbridge.cn.runtime.depend;

import androidx.annotation.Keep;
import cj.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001:\u0001\u0004J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostHeadSetDepend;", "", "Lcj/d;", "bridgeContext", "Lgj/d;", "listener", "", "registerHeadSetListener", "(Lcj/d;Lgj/d;)V", "unRegisterHeadSetListener", "(Lcj/d;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostHeadSetDepend {
    void registerHeadSetListener(d r5, gj.d r10);

    void unRegisterHeadSetListener(d r5);
}
