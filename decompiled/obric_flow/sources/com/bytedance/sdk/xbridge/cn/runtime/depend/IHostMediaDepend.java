package com.bytedance.sdk.xbridge.cn.runtime.depend;

import android.content.Context;
import androidx.annotation.Keep;
import com.lynx.jsbridge.LynxResourceModule;
import hj.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostMediaDepend;", "", "Landroid/content/Context;", "context", "Lhj/a;", LynxResourceModule.PARAMS_KEY, "Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IChooseMediaResultCallback;", "callback", "", "handleJsInvoke", "(Landroid/content/Context;Lhj/a;Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IChooseMediaResultCallback;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostMediaDepend {
    void handleJsInvoke(Context r5, a r10, IChooseMediaResultCallback r11);
}
