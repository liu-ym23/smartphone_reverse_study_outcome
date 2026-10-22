package rp0;

import android.os.Bundle;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends vq0.a {
    public e(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r5) {
        String r0 = "";
        if (((AnchorShelfContextService) this.a.getService(AnchorShelfContextService.class)).isMounted() == false) goto L14;
        qo0.a.c("OnLiveBizStopCastEventListener", "ON_LIVE_BIZ_STOP_CAST");
        AnchorCastContextService r6 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        MiniAppInstance r2 = this.a.getMiniAppInstance();
        if (r2 == null) goto L7;
        String r3 = r2.getAppId();
    L8:
        if (r3 == null) goto L11;
        r0 = r3;
    L11:
        r6.i(r0, LinkScreenCastType.CAST_TYPE_MINI_APP, "user trigger");
        AnchorCastContextService r7 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        r7.a = null;
        Disposable r8 = r7.b;
        if (r8 == null) goto L22;
        r8.dispose();
    L22:
        return null;
    L7:
        r3 = null;
        goto L8
    L14:
        f2.c("将应用添加到直播后才可操作", 0);
        int r9 = AnchorCastContextService.e;
        MiniAppInstance r10 = this.a.getMiniAppInstance();
        if (r10 == null) goto L17;
        String r11 = r10.getAppId();
    L18:
        if (r11 == null) goto L21;
        r0 = r11;
    L21:
        AnchorCastContextService.a.b(r0, "app is not mounted");
        goto L22
    L17:
        r11 = null;
        goto L18
    }
}
