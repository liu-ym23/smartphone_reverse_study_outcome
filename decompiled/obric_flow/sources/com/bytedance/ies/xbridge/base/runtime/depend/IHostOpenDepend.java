package com.bytedance.ies.xbridge.base.runtime.depend;

import androidx.annotation.Keep;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import fe.f;
import fe.g;
import fe.h;
import fe.i;
import ke.a;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0004\u0018\u0013\u0006\u000eJ)\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ1\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostOpenDepend;", "", "Lke/a;", "contextProviderFactory", "", "cameraOnly", "Lfe/h;", "scanResultCallback", "", "scanCode", "(Lke/a;ZLfe/h;)V", "", "accessKey", LynxMonitorService.KEY_CHANNEL, "Lfe/i;", "updateGeckoCallback", "enableDownloadAutoRetry", "updateGecko", "(Ljava/lang/String;Ljava/lang/String;Lfe/i;Z)Lkotlin/Unit;", "Lfe/g;", "getGeckoInfoCallback", "getGeckoInfo", "(Ljava/lang/String;Ljava/lang/String;Lfe/g;)Lkotlin/Unit;", "containerId", "Lfe/f;", "listener", "registerGeckoUpdateListener", "(Ljava/lang/String;Lfe/f;)V", "unRegisterGeckoUpdateListener", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostOpenDepend {
    Unit getGeckoInfo(String r5, String r10, g r11);

    void registerGeckoUpdateListener(String r5, f r10);

    void scanCode(a r5, boolean r10, h r11);

    void unRegisterGeckoUpdateListener(String r5);

    Unit updateGecko(String r5, String r10, i r11, boolean r12);
}
