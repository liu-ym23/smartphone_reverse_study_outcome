package rp0;

import android.os.Bundle;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.AnchorCastContextService;
import com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.AnchorShelfContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends vq0.a {
    public d(MiniAppContext r2) {
        Intrinsics.checkNotNullParameter(r2, "miniAppContext");
        super(r2);
    }

    public final Bundle onEvent(Bundle r11) {
        if (((AnchorShelfContextService) this.a.getService(AnchorShelfContextService.class)).isMounted() == false) goto L30;
        if (r11 == null) goto L37;
        int r0 = r11.getInt("cast_width");
        int r12 = r11.getInt("cast_height");
        qo0.a.c("OnLiveBizStartCastEventListener", "ON_LIVE_BIZ_START_CAST");
        AnchorCastContextService r3 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        MiniAppInstance r4 = this.a.getMiniAppInstance();
        if (r4 == null) goto L8;
        String r5 = r4.getAppId();
    L9:
        if (r5 != null) goto L11;
        r5 = "";
    L11:
        String r9 = r5;
        LinkScreenCastType r7 = LinkScreenCastType.CAST_TYPE_MINI_APP;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r9, "appId");
        Intrinsics.checkNotNullParameter(r7, "castType");
        if (cp0.d.a() == false) goto L14;
        int r13 = AnchorCastContextService.e;
        AnchorCastContextService.a.a(r9, "live cast switching");
        f2.c("直播间切换中，请勿手动开启投屏", 0);
    L18:
        AnchorCastContextService r14 = (AnchorCastContextService) this.a.getService(AnchorCastContextService.class);
        MiniAppInstance r1 = this.a.getMiniAppInstance();
        if (r1 == null) goto L22;
        String r2 = r1.getAppId();
        if (r2 == null) goto L22;
    L23:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r2, "appId");
        r14.a = new uq0.a(r2, "", MapsKt.emptyMap());
        Disposable r6 = r14.b;
        if (r6 == null) goto L26;
        r6.dispose();
    L26:
        r14.b = du2.a.b(0, 1, TimeUnit.SECONDS).subscribe(new cp0.a(r14), cp0.b.a, cp0.c.a);
    L22:
        r2 = "";
        goto L23
    L14:
        dp0.a r8 = r3.g();
        qo0.a.c("AnchorCastContextService", "startLiveCast by Strategy:" + r8);
        r8.h(r9, r0, r12, r7, false);
        cp0.d r10 = cp0.d.c;
        monitor-enter(r10);
        Intrinsics.checkNotNullParameter(r9, "appId");     // Catch: Throwable -> L27
        cp0.d.a = new cp0.d.a(r9, r0, r12);     // Catch: Throwable -> L27
        monitor-exit(r10);
    L27:
        th = move-exception;
        throw th;
    L8:
        r5 = null;
    L37:
        return null;
    L30:
        f2.c("将应用添加到直播后才可操作", 0);
        int r15 = AnchorCastContextService.e;
        MiniAppInstance r16 = this.a.getMiniAppInstance();
        if (r16 == null) goto L33;
        String r17 = r16.getAppId();
    L34:
        if (r17 != null) goto L36;
        r17 = "";
    L36:
        AnchorCastContextService.a.a(r17, "app is not mounted");
        goto L37
    L33:
        r17 = null;
        goto L34
    }
}
