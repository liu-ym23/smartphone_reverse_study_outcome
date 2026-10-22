package com.bytedance.sdk.xbridge.cn.runtime.depend;

import androidx.annotation.Keep;
import cj.d;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import gj.f;
import gj.g;
import gj.h;
import gj.i;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0004\u0018\u0014\u0007\u000fJ3\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostOpenDepend;", "", "Lcj/d;", "bridgeContext", "", "cameraOnly", "autoJump", "Lgj/h;", "scanResultCallback", "", "scanCode", "(Lcj/d;ZLjava/lang/Boolean;Lgj/h;)V", "", "accessKey", LynxMonitorService.KEY_CHANNEL, "Lgj/i;", "updateGeckoCallback", "enableDownloadAutoRetry", "updateGecko", "(Ljava/lang/String;Ljava/lang/String;Lgj/i;Z)Lkotlin/Unit;", "Lgj/g;", "getGeckoInfoCallback", "getGeckoInfo", "(Ljava/lang/String;Ljava/lang/String;Lgj/g;)Lkotlin/Unit;", "Lgj/f;", "listener", "registerGeckoUpdateListener", "(Lcj/d;Lgj/f;)V", "unRegisterGeckoUpdateListener", "(Lcj/d;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public interface IHostOpenDepend {
    @Deprecated(message = "No need to inject, Container provide a default implementation", replaceWith = @ReplaceWith(expression = "IHostGeckoDepend", imports = {}))
    Unit getGeckoInfo(String r5, String r10, g r11);

    @Deprecated(message = "No need to inject, Container provide a default implementation", replaceWith = @ReplaceWith(expression = "IHostGeckoDepend", imports = {}))
    void registerGeckoUpdateListener(d r5, f r10);

    void scanCode(d r5, boolean r10, Boolean r11, h r12);

    @Deprecated(message = "No need to inject, Container provide a default implementation", replaceWith = @ReplaceWith(expression = "IHostGeckoDepend", imports = {}))
    void unRegisterGeckoUpdateListener(d r5);

    @Deprecated(message = "No need to inject, Container provide a default implementation", replaceWith = @ReplaceWith(expression = "IHostGeckoDepend", imports = {}))
    Unit updateGecko(String r5, String r10, i r11, boolean r12);
}
