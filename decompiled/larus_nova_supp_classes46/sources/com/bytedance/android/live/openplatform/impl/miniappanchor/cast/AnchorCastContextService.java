package com.bytedance.android.live.openplatform.impl.miniappanchor.cast;

import android.os.Bundle;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.api.IOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappcommon.cast.LiveCastContextService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import dp0.b;
import dp0.d;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/cast/AnchorCastContextService;", "Lcom/bytedance/android/live/openplatform/impl/miniappcommon/cast/LiveCastContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorCastContextService extends LiveCastContextService {
    public static final /* synthetic */ int e = 0;
    public Disposable b;
    public b c;
    public d d;

    public static final class a {
        @JvmStatic
        public static void a(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "appId");
            Intrinsics.checkNotNullParameter(r6, "errMsg");
            IHostLiveOpenPlatform r1 = TTLiveSDK.hostService().hostOpenPlatform();
            Bundle r2 = new Bundle();
            r2.putBoolean("key_is_success", false);
            JSONObject r3 = new JSONObject();
            r3.put("errMsg", r6);
            Unit r7 = Unit.INSTANCE;
            r2.putString("key_extra", r3.toString());
            r1.dispatchStaticCommand(r5, "command_live_cast_start", r2);
        }

        @JvmStatic
        public static void b(String r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "appId");
            Intrinsics.checkNotNullParameter(r6, "errMsg");
            IHostLiveOpenPlatform r1 = TTLiveSDK.hostService().hostOpenPlatform();
            Bundle r2 = new Bundle();
            r2.putBoolean("key_is_success", false);
            JSONObject r3 = new JSONObject();
            r3.put("errMsg", r6);
            Unit r7 = Unit.INSTANCE;
            r2.putString("key_extra", r3.toString());
            r1.dispatchStaticCommand(r5, "command_live_cast_stop", r2);
        }
    }

    static {
    }

    public final synchronized dp0.a g() {
        monitor-enter(this);
        dp0.a r0 = h(((IInteractService) k.n(IInteractService.class)).getCurrentScene());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static void f() {
        cp0.d.a r0 = cp0.d.a;
        monitor-enter(cp0.d.class);
        int r2 = qo0.a.a;     // Catch: Throwable -> L21
        StringBuilder r3 = new StringBuilder("clearSwitchingState lock:");     // Catch: Throwable -> L21
        r3.append(cp0.d.b);     // Catch: Throwable -> L21
        r3.append(" lockId:");     // Catch: Throwable -> L21
        cp0.d.b r1 = cp0.d.b;     // Catch: Throwable -> L21
        if (r1 == null) goto L7;
        String r4 = r1.c;     // Catch: Throwable -> L21
    L8:
        r3.append(r4);     // Catch: Throwable -> L21
        qo0.a.c("LiveCastSwitcher", r3.toString());     // Catch: Throwable -> L21
        cp0.d.b r5 = cp0.d.b;     // Catch: Throwable -> L21
        if (r5 == null) goto L13;
        IOpenPlatformAnchorService.a r6 = r5.a;     // Catch: Throwable -> L21
        if (r6 == null) goto L13;
        r6.a();     // Catch: Throwable -> L21
    L13:
        cp0.d.b r7 = cp0.d.b;     // Catch: Throwable -> L21
        if (r7 == null) goto L18;
        IOpenPlatformAnchorService.a r8 = r7.b;     // Catch: Throwable -> L21
        if (r8 == null) goto L18;
        r8.a();     // Catch: Throwable -> L21
    L18:
        cp0.d.b = null;     // Catch: Throwable -> L21
        monitor-exit(cp0.d.class);
        return;
    L7:
        r4 = null;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService
    public final void onDestroy() {
        super.onDestroy();
        this.a = null;
        Disposable r1 = this.b;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        monitor-enter(this);
        this.c = null;     // Catch: Throwable -> L9
        this.d = null;     // Catch: Throwable -> L9
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public AnchorCastContextService(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    public final synchronized dp0.a h(int r2) {
        monitor-enter(this);
        if (r2 == 0) goto L9;
        b r3 = this.c;     // Catch: Throwable -> L15
        if (r3 != null) goto L7;
        r3 = new b(getOpenPlatformContext());     // Catch: Throwable -> L15
        this.c = r3;     // Catch: Throwable -> L15
    L7:
        monitor-exit(this);
        return r3;
    L9:
        d r4 = this.d;     // Catch: Throwable -> L15
        if (r4 != null) goto L13;
        r4 = new d(getOpenPlatformContext());     // Catch: Throwable -> L15
        this.d = r4;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return r4;
    L15:
        th = move-exception;
        throw th;
    }

    public final void i(String r5, LinkScreenCastType r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "appId");
        Intrinsics.checkNotNullParameter(r6, "castType");
        if (cp0.d.a() == false) goto L6;
        a.b(r5, "live cast switching source:".concat(r7));
        f2.c("直播间切换中，请勿手动关闭投屏", 0);
        return;
    L6:
        dp0.a r0 = g();
        int r2 = qo0.a.a;
        qo0.a.c("AnchorCastContextService", "stopLiveCast by Strategy:" + r0 + " source:" + r7);
        r0.i(r5, r6, false);
    }
}
