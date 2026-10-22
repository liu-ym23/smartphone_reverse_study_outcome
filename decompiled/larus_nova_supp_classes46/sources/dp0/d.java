package dp0;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcast.api.model.t;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfMicroAppInfo;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.cast.strategy.LiveCastEventHelper;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d extends dp0.a {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    public static final class b implements Runnable {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.n(IBroadcastService.class).minimizeCast();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            IMiddlewareBroadcastService.b.a(k.n(IBroadcastService.class));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: dp0.d$d, reason: collision with other inner class name */
    public static final class RunnableC0201d implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;

        public RunnableC0201d(d r1, String r2, int r3, int r4) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            qo0.a.c("SingleCastStrategy", "request startLiveCast");
            t r0 = new t();
            r0.a = 2;
            String r1 = this.b;
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.b = r1;
            r0.c = this.a.a.getContext();
            AnchorMiniAppDataContext.Companion.getClass();
            AnchorMiniAppDataContext r2 = AnchorMiniAppDataContext.a.a();
            if (r2 == null) goto L15;
            n<ShelfInfo> r3 = r2.m618getShelfInfo();
            if (r3 == null) goto L15;
            ShelfInfo r4 = (ShelfInfo) r3.getValue();
            if (r4 == null) goto L15;
            ShelfMicroAppInfo r5 = r4.appInfo;
            if (r5 == null) goto L15;
            ImageModel r6 = r5.icon;
            if (r6 == null) goto L15;
            List r7 = r6.getUrls();
            if (r7 == null) goto L15;
            String r8 = (String) CollectionsKt.firstOrNull(r7);
        L15:
            k.n(IBroadcastService.class).startCast(r0);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // dp0.a
    public final boolean a() {
        return k.n(IBroadcastService.class).isCasting();
    }

    @Override // dp0.a
    public final void g() {
        Intrinsics.checkNotNullParameter("", "errMsg");
        qo0.a.c("SingleCastStrategy", "sendLiveCastError errMsg:");
        k.n(IBroadcastService.class).stopCast(0);
    }

    public d(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    @Override // dp0.a
    public final void f(String r2, LinkScreenCastType r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "castType");
        int r4 = qo0.a.a;
        qo0.a.c("SingleCastStrategy", "resumeLiveCast appId:".concat(r2));
        i0.c().post(c.a);
    }

    @Override // dp0.a
    public final void b(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "appName");
        int r5 = qo0.a.a;
        qo0.a.a("SingleCastStrategy", "logLiveCastButtonClick appId:" + r2 + " cancel:" + r4);
        if (r4 == false) goto L6;
        LiveCastEventHelper.b(this.a, LiveCastEventHelper.CastScene.SINGLE);
        return;
    }

    @Override // dp0.a
    public final void c(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "appName");
        int r5 = qo0.a.a;
        qo0.a.a("SingleCastStrategy", "logLiveCastButtonShow appId:" + r2 + " cancel:" + r4);
        if (r4 == true) goto L6;
        OpenPlatformContext r6 = this.a;
        LiveCastEventHelper.CastScene r7 = LiveCastEventHelper.CastScene.SINGLE;
        int r8 = LiveCastEventHelper.a;
        Intrinsics.checkNotNullParameter(r6, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r7, "castScene");
        LiveCastEventHelper.c("livesdk_anchor_screenprojection_to_liveroom_button_show", LiveCastEventHelper.a(r6, r7));
        return;
    }

    @Override // dp0.a
    public final void d(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "appName");
        Intrinsics.checkNotNullParameter(r4, "action");
        if (Intrinsics.areEqual(r4, "start_cast_btn_click") == false) goto L6;
        OpenPlatformContext r5 = this.a;
        LiveCastEventHelper.CastScene r6 = LiveCastEventHelper.CastScene.SINGLE;
        int r7 = LiveCastEventHelper.a;
        Intrinsics.checkNotNullParameter(r5, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r6, "castScene");
        LiveCastEventHelper.c("livesdk_anchor_screenprojection_start_button_click", LiveCastEventHelper.a(r5, r6));
        return;
    L6:
        if (Intrinsics.areEqual(r4, "cancel_cast_btn_click") == false) goto L10;
        int r8 = qo0.a.a;
        qo0.a.a("SingleCastStrategy", "logLiveCastDialogAction appId:" + r2 + " action:" + r4);
        return;
    }

    @Override // dp0.a
    public final void e(String r4, LinkScreenCastType r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "appId");
        Intrinsics.checkNotNullParameter(r5, "castType");
        int r7 = qo0.a.a;
        qo0.a.c("SingleCastStrategy", "pauseLiveCast appId:".concat(r4));
        i0.c().post(b.a);
        if (r6 != null) goto L5;
    L6:
        if (r6 != null) goto L8;
        return;
    L8:
        if (StringsKt.startsWith$default(r6, "api-exitMiniProgram", false, 2, null) != true) goto L12;
    L9:
        OpenPlatformContext r8 = this.a;
        LiveCastEventHelper.CastScene r9 = LiveCastEventHelper.CastScene.SINGLE;
        int r10 = LiveCastEventHelper.a;
        Intrinsics.checkNotNullParameter(r8, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r9, "castScene");
        LiveCastEventHelper.c("livesdk_anchor_screenprojection_cancel_button_click", LiveCastEventHelper.a(r8, r9));
        return;
    L12:
        return;
    L5:
        if (StringsKt.startsWith$default(r6, "capsule_btn", false, 2, null) == true) goto L9;
        goto L6
    }

    @Override // dp0.a
    public final void i(String r1, LinkScreenCastType r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "appId");
        Intrinsics.checkNotNullParameter(r2, "castType");
        qo0.a.c("SingleCastStrategy", "request stopLiveCast");
        k.n(IBroadcastService.class).stopCast(0);
    }

    @Override // dp0.a
    public final void h(String r1, int r2, int r3, LinkScreenCastType r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "appId");
        Intrinsics.checkNotNullParameter(r4, "castType");
        i0.c().post(new RunnableC0201d(this, r1, r2, r3));
    }
}
