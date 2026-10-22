package com.bytedance.android.live.openplatform.impl.miniappcommon.launch;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.tetris.widgets.y;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.utils.SchemaInfo;
import com.bytedance.android.live.openplatform.impl.base.context.ContextServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.applog.MiniAppAppLogContextService;
import com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveOpenPlatform;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveMiniAppService;
import com.bytedance.android.livehostapi.business.depend.openplatform.IAppStatusListener;
import com.bytedance.android.livehostapi.business.depend.openplatform.MiniAppInstance;
import com.bytedance.android.livesdk.config.al;
import com.bytedance.android.livesdk.config.q90;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.l;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import w20.lc;
import zg1.s1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@ContextServiceImpl(audienceService = "com.bytedance.android.live.openplatform.impl.miniappaudience.launch.AudienceLaunchContextServiceV2", liveAnchorService = "com.bytedance.android.live.openplatform.impl.miniappcommon.launch.CommonLaunchContextService", previewAnchorService = "com.bytedance.android.live.openplatform.impl.miniappanchor.launch.PreviewAnchorLaunchContextServiceV2")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J.\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappcommon/launch/CommonLaunchContextService;", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContextService;", "Lkotlin/Function0;", "", "onLoginSuccess", "openMiniAppWithLogin", "", "schema", "onSuccess", "doOpenMicroApp", "", "state", "miniAppScreenStateChange", "notifyRoomLoggerManager", "Lw20/lc$a;", "params", "openMicroApp", "Lcom/bytedance/android/live/openplatform/api/utils/SchemaInfo$a;", "schemaInfoBuilder", "appendCommonParams", "", "miniAppLaunchTime", "J", "Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;", "openPlatformContext", "<init>", "(Lcom/bytedance/android/live/openplatform/impl/base/context/OpenPlatformContext;)V", "Companion", "a", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CommonLaunchContextService extends OpenPlatformContextService {
    public static final a Companion = null;
    private static final String TAG = "CommonLaunchContextService";
    private long miniAppLaunchTime;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements IAppStatusListener {
        public final /* synthetic */ CommonLaunchContextService a;
        public final /* synthetic */ Function0 b;

        public final void onLaunchFail(String r2) {
            Intrinsics.checkNotNullParameter(r2, "errMsg");
        }

        public final void onAppExit() {
            OpenPlatformContext r0 = CommonLaunchContextService.access$getOpenPlatformContext$p(this.a);
            if (r0 == null) goto L10;
            ((MiniAppContext) r0).tryClearMiniAppInstance(MiniAppContext.StopType.ON_APP_EXIT);
            ILiveMiniAppService r1 = k.f(ILiveMiniAppService.class);
            if (r1 == null) goto L7;
            r1.setMiniAppActivityStatue(false);
        L7:
            ((MiniAppAppLogContextService) CommonLaunchContextService.access$getOpenPlatformContext$p(this.a).getService(MiniAppAppLogContextService.class)).reportMiniAppClose(System.currentTimeMillis() - CommonLaunchContextService.access$getMiniAppLaunchTime$p(this.a));
            return;
        L10:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext");
        }

        public final void onLaunchSuccess(MiniAppInstance r4) {
            Intrinsics.checkNotNullParameter(r4, "miniAppInstance");
            CommonLaunchContextService.access$setMiniAppLaunchTime$p(this.a, System.currentTimeMillis());
            OpenPlatformContext r0 = CommonLaunchContextService.access$getOpenPlatformContext$p(this.a);
            if (r0 == null) goto L9;
            ((MiniAppContext) r0).setMiniAppInstance(r4);
            ((MiniAppAppLogContextService) CommonLaunchContextService.access$getOpenPlatformContext$p(this.a).getService(MiniAppAppLogContextService.class)).reportMiniAppShow();
            Function0 r5 = this.b;
            if (r5 == null) goto L10;
            Unit r6 = (Unit) r5.invoke();
            return;
        L10:
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappcommon.context.MiniAppContext");
        }

        public final void onScreenStateChange(int r2) {
            CommonLaunchContextService.access$miniAppScreenStateChange(this.a, r2);
            CommonLaunchContextService.access$notifyRoomLoggerManager(this.a, r2);
        }

        public b(CommonLaunchContextService r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public c(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IBaseUser r3 = (IBaseUser) r2;
            qo0.a.c(CommonLaunchContextService.TAG, "login success");
            this.a.invoke();
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            qo0.a.b(CommonLaunchContextService.TAG, "login fail", (Throwable) r3);
        }
    }

    static {
        Companion = new a();
    }

    public CommonLaunchContextService(OpenPlatformContext r3) {
        Intrinsics.checkNotNullParameter(r3, "openPlatformContext");
        super(r3);
        this.miniAppLaunchTime = -1;
    }

    public static final /* synthetic */ long access$getMiniAppLaunchTime$p(CommonLaunchContextService r2) {
        return r2.miniAppLaunchTime;
    }

    public static final /* synthetic */ OpenPlatformContext access$getOpenPlatformContext$p(CommonLaunchContextService r0) {
        return r0.getOpenPlatformContext();
    }

    private final void miniAppScreenStateChange(int r5) {
        if (((Boolean) al.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        switch(r5) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L20;
        };
    L7:
        xs2.b.a().post(new y(true, 4));
        xs2.b.a().post(new y(true, 8));
        return;
    L8:
        xs2.b.a().post(new y(false, 4));
        xs2.b.a().post(new y(false, 8));
        return;
    L9:
        xs2.b.a().post(new y(false, 4));
        return;
    L10:
        xs2.b.a().post(new y(false, 8));
        return;
    L11:
        xs2.b.a().post(new y(true, 8));
        return;
    L12:
        xs2.b.a().post(new y(true, 4));
        return;
    }

    private final void notifyRoomLoggerManager(int r3) {
        if (((Boolean) q90.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        switch(r3) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L19;
        };
    L7:
        xs2.b.a().post(new s1(6));
        return;
    L8:
        xs2.b.a().post(new s1(5));
        return;
    L9:
        xs2.b.a().post(new s1(4));
        return;
    L10:
        xs2.b.a().post(new s1(3));
        return;
    L11:
        xs2.b.a().post(new s1(2));
        return;
    L12:
        xs2.b.a().post(new s1(1));
        return;
    }

    private final void openMiniAppWithLogin(Function0<Unit> r5) {
        if (k.n(IUserService.class).user().isLogin() == true) goto L5;
        f r0 = k.n(IUserService.class).user();
        Context r1 = getOpenPlatformContext().getContext();
        l.a r2 = new l.a();
        r2.a = com.bytedance.android.live.core.utils.s1.B(2131915990);
        r2.d = "open_platform";
        r2.c = -1;
        autoDispose(r0.login(r1, new l(r2)).subscribe(new c(r5), d.a));
        return;
    L5:
        r5.invoke();
    }

    public void appendCommonParams(SchemaInfo.a r4) {
        Intrinsics.checkNotNullParameter(r4, "schemaInfoBuilder");
        int r0 = ((IInteractService) k.n(IInteractService.class)).getCurrentScene();
        if (r0 != 0) goto L5;
        r4.b("live_category", "single");
    L13:
        if (((IInteractService) k.n(IInteractService.class)).isLinkCasting() == false) goto L16;
        r4.b("if_mp_live_projection", "1");
        return;
    L16:
        return;
    L5:
        if (r0 != 8) goto L7;
        r4.b("live_category", "1v6");
        goto L13
    L7:
        if (r0 != 12) goto L13;
        r4.b("live_category", "party");
        goto L13
    }

    public static final /* synthetic */ void access$miniAppScreenStateChange(CommonLaunchContextService r0, int r1) {
        r0.miniAppScreenStateChange(r1);
    }

    public static final /* synthetic */ void access$notifyRoomLoggerManager(CommonLaunchContextService r0, int r1) {
        r0.notifyRoomLoggerManager(r1);
    }

    public static final /* synthetic */ void access$setMiniAppLaunchTime$p(CommonLaunchContextService r0, long r1) {
        r0.miniAppLaunchTime = r1;
    }

    private final void doOpenMicroApp(String r3, Function0<Unit> r4) {
        ILiveMiniAppService r0 = k.f(ILiveMiniAppService.class);
        if (r0 == null) goto L5;
        r0.setMiniAppActivityStatue(true);
    L5:
        SchemaInfo.a r1 = new SchemaInfo.a(r3);
        appendCommonParams(r1);
        IHostLiveOpenPlatform r2 = TTLiveSDK.hostService().hostOpenPlatform();
        SchemaInfo r5 = r1.c();
        if (r5 == null) goto L11;
        String r6 = r5.h();
        if (r6 == null) goto L11;
        r3 = r6;
    L11:
        r2.openMiniApp(r3, new b(this, r4));
    }

    public static final /* synthetic */ void access$doOpenMicroApp(CommonLaunchContextService r0, String r1, Function0 r2) {
        r0.doOpenMicroApp(r1, r2);
    }

    public void openMicroApp(final String r1, lc.a r2, final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "schema");
        openMiniAppWithLogin(new AnonymousClass1(this, r1, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void doOpenMicroApp$default(CommonLaunchContextService r0, String r1, Function0 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        r0.doOpenMicroApp(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doOpenMicroApp");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void openMicroApp$default(CommonLaunchContextService r1, String r2, lc.a r3, Function0 r4, int r5, Object r6) {
        if (r6 != null) goto L12;
        if ((r5 & 2) == 0) goto L7;
        r3 = null;
    L7:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        r1.openMicroApp(r2, r3, r4);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openMicroApp");
    }
}
