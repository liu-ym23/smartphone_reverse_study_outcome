package dp0;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.liveinteract.api.IInteractService;
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
public final class b extends dp0.a {

    public static final class a implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ String b;

        public a(b r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ((IInteractService) k.n(IInteractService.class)).onProgramHide();
            String r0 = this.b;
            if (r0 != null) goto L5;
        L6:
            String r1 = this.b;
            if (r1 != null) goto L9;
            return;
        L9:
            if (StringsKt.startsWith$default(r1, "api-exitMiniProgram", false, 2, null) != true) goto L13;
        L10:
            OpenPlatformContext r2 = this.a.a;
            LiveCastEventHelper.CastScene r3 = LiveCastEventHelper.CastScene.MULTI;
            int r4 = LiveCastEventHelper.a;
            Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
            Intrinsics.checkNotNullParameter(r3, "castScene");
            LiveCastEventHelper.c("livesdk_anchor_screenprojection_cancel_button_click", LiveCastEventHelper.a(r2, r3));
            return;
        L13:
            return;
        L5:
            if (StringsKt.startsWith$default(r0, "capsule_btn", false, 2, null) == true) goto L10;
            goto L6
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

    /* JADX INFO: renamed from: dp0.b$b, reason: collision with other inner class name */
    public static final class RunnableC0200b implements Runnable {
        public static final RunnableC0200b a = null;

        static {
            a = new RunnableC0200b();
        }

        public RunnableC0200b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((IInteractService) k.n(IInteractService.class)).onProgramShow();     // Catch: Throwable -> L4
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
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ boolean d;

        public c(String r1, int r2, int r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            IInteractService r1 = (IInteractService) k.n(IInteractService.class);
            LinkScreenCastType r2 = LinkScreenCastType.CAST_TYPE_MINI_APP;
            String r3 = this.a;
            int r4 = this.b;
            int r5 = this.c;
            AnchorMiniAppDataContext.Companion.getClass();
            AnchorMiniAppDataContext r0 = AnchorMiniAppDataContext.a.a();
            if (r0 == null) goto L15;
            n<ShelfInfo> r6 = r0.m618getShelfInfo();
            if (r6 == null) goto L15;
            ShelfInfo r7 = (ShelfInfo) r6.getValue();
            if (r7 == null) goto L15;
            ShelfMicroAppInfo r8 = r7.appInfo;
            if (r8 == null) goto L15;
            ImageModel r9 = r8.icon;
            if (r9 == null) goto L15;
            List r10 = r9.getUrls();
            if (r10 == null) goto L15;
            String r11 = (String) CollectionsKt.firstOrNull(r10);
        L16:
            r1.startLinkCast(r2, r3, r4, r5, null, r11, this.d);
            return;
        L15:
            r11 = null;
            goto L16
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

    @Override // dp0.a
    public final boolean a() {
        return ((IInteractService) k.n(IInteractService.class)).isLinkCasting();
    }

    @Override // dp0.a
    public final void g() {
        Intrinsics.checkNotNullParameter("", "errMsg");
        ((IInteractService) k.n(IInteractService.class)).onProgramFrameErr();
    }

    public b(OpenPlatformContext r2) {
        Intrinsics.checkNotNullParameter(r2, "openPlatformContext");
        super(r2);
    }

    @Override // dp0.a
    public final void f(String r2, LinkScreenCastType r3) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "castType");
        i0.c().post(RunnableC0200b.a);
    }

    @Override // dp0.a
    public final void b(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "appName");
        ((IInteractService) k.n(IInteractService.class)).logMiniAppShareIconClick(r2, r3, r4);
        if (r4 == false) goto L6;
        LiveCastEventHelper.b(this.a, LiveCastEventHelper.CastScene.MULTI);
        return;
    }

    @Override // dp0.a
    public final void c(String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "appName");
        ((IInteractService) k.n(IInteractService.class)).logMiniAppShareIconShow(r2, r3, r4);
        if (r4 == true) goto L6;
        OpenPlatformContext r5 = this.a;
        LiveCastEventHelper.CastScene r6 = LiveCastEventHelper.CastScene.MULTI;
        int r7 = LiveCastEventHelper.a;
        Intrinsics.checkNotNullParameter(r5, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r6, "castScene");
        LiveCastEventHelper.c("livesdk_anchor_screenprojection_to_liveroom_button_show", LiveCastEventHelper.a(r5, r6));
        return;
    }

    @Override // dp0.a
    public final void d(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "appName");
        Intrinsics.checkNotNullParameter(r4, "action");
        int r5 = d.b;
        if (Intrinsics.areEqual(r4, "start_cast_btn_click") == false) goto L5;
        OpenPlatformContext r6 = this.a;
        LiveCastEventHelper.CastScene r7 = LiveCastEventHelper.CastScene.MULTI;
        int r8 = LiveCastEventHelper.a;
        Intrinsics.checkNotNullParameter(r6, "openPlatformContext");
        Intrinsics.checkNotNullParameter(r7, "castScene");
        LiveCastEventHelper.c("livesdk_anchor_screenprojection_start_button_click", LiveCastEventHelper.a(r6, r7));
        return;
    L5:
        Intrinsics.areEqual(r4, "cancel_cast_btn_click");
    }

    @Override // dp0.a
    public final void e(String r2, LinkScreenCastType r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "castType");
        i0.c().post(new a(this, r4));
    }

    @Override // dp0.a
    public final void i(String r2, LinkScreenCastType r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r3, "castType");
        ((IInteractService) k.n(IInteractService.class)).stopLinkCast(LinkScreenCastType.CAST_TYPE_MINI_APP, r2, r4);
    }

    @Override // dp0.a
    public final void h(String r2, int r3, int r4, LinkScreenCastType r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "appId");
        Intrinsics.checkNotNullParameter(r5, "castType");
        i0.c().post(new c(r2, r3, r4, r6));
    }
}
