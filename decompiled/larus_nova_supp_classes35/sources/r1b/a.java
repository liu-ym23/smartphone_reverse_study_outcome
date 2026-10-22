package r1b;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.IModelCmlActivity;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.pluginapi.RouterState;
import com.ss.android.lark.chameleon.pluginapi.WebviewStatus;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Internal$RouterState;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Internal$WebviewState;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$LoadingFinishRequest;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$Status;
import com.ss.android.lark.chameleonv2.lkapi.webview.IWebview$VisibilityState;
import com.ss.android.lark.officesdk.utils.di.j;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends z0b.a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: r1b.a$a, reason: collision with other inner class name */
    public final class C0288a extends AbsChameleonHandler<Unit> {
        public final String a;

        /* JADX INFO: renamed from: r1b.a$a$a, reason: collision with other inner class name */
        public static final class RunnableC0289a implements Runnable {
            public final /* synthetic */ C0288a a;

            public RunnableC0289a(C0288a r1) {
                this.a = r1;
            }

            public final void a() {
                IChameleonHandlerContext r0 = this.a.getContext();
                Activity r1 = null;
                if (r0 == null) goto L7;
                Fragment r2 = r0.getFragment();
                if (r2 == null) goto L7;
                g r3 = f.b(r2);
            L8:
                if (r3 == null) goto L16;
                IChameleonHandlerContext r4 = this.a.getContext();
                if (r4 == null) goto L29;
                Fragment r5 = r4.getFragment();
                if (r5 == null) goto L30;
                g r6 = f.b(r5);
                if (r6 == null) goto L31;
                r6.g(null);
                return;
            L31:
                return;
            L30:
                return;
            L29:
                return;
            L16:
                IChameleonHandlerContext r7 = this.a.getContext();
                if (r7 == null) goto L19;
                Context r8 = r7.getCmlContext();
            L21:
                if ((r8 instanceof Activity) == false) goto L24;
                r1 = (Activity) r8;
            L24:
                if ((r1 instanceof IModelCmlActivity) == false) goto L26;
                r1.onBackPressed();
                return;
            L26:
                if (r1 == null) goto L34;
                r1.finish();
                return;
            L34:
                return;
            L19:
                r8 = null;
            L7:
                r3 = null;
                goto L8
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

        public C0288a() {
            this.a = LKAPIModules.Internal.Webview.Close.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Callback r2) {
            Intrinsics.checkNotNullParameter(r2, "callback");
            UICallbackExecutor.execute(new RunnableC0289a(this));
            r2.success(null);
        }
    }

    public static final class b {
    }

    public final class c extends AbsChameleonHandler<Unit> {
        public final String a;

        public c() {
            this.a = LKAPIModules.Internal.Webview.GetRouterState.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Callback r5) {
            Intrinsics.checkNotNullParameter(r5, "callback");
            IChameleonHandlerContext r0 = getContext();
            Serializable r1 = null;
            if (r0 == null) goto L7;
            IChameleonLoader r2 = r0.getWebviewLoader();
            if (r2 == null) goto L7;
            RouterState<Serializable> r3 = r2.getRouterState();
        L9:
            if (r3 == null) goto L12;
            String r4 = r3.getPath();
            if (r4 == null) goto L12;
        L13:
            if (r3 == null) goto L15;
            r1 = r3.getParams();
        L15:
            r5.success(new IWebview$Internal$RouterState(r4, r1));
            return;
        L12:
            r4 = BuildConfig.FLAVOR;
        L7:
            r3 = null;
            goto L9
        }
    }

    public final class d extends AbsChameleonHandler<Unit> {
        public final String a;

        /* JADX INFO: renamed from: r1b.a$d$a, reason: collision with other inner class name */
        public /* synthetic */ class C0290a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[WebviewStatus.values().length];
                r0[WebviewStatus.Attached.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[WebviewStatus.Visible.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[WebviewStatus.Hidden.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[WebviewStatus.Detached.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public d() {
            this.a = LKAPIModules.Internal.Webview.GetState.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(Callback r6) {
            Intrinsics.checkNotNullParameter(r6, "callback");
            IChameleonHandlerContext r0 = getContext();
            if (r0 == null) goto L8;
            IChameleonLoader r1 = r0.getWebviewLoader();
            if (r1 == null) goto L8;
            WebviewStatus r2 = r1.getStatus();
            if (r2 == null) goto L8;
        L9:
            IChameleonHandlerContext r3 = getContext();
            boolean r4 = false;
            if (r3 == null) goto L16;
            IChameleonLoader r5 = r3.getWebviewLoader();
            if (r5 == null) goto L16;
            if (r5.getVisible() != true) goto L16;
            r4 = true;
        L16:
            if (r4 == false) goto L18;
            IWebview$VisibilityState r7 = IWebview$VisibilityState.Visible;
        L19:
            int r8 = C0290a.a[r2.ordinal()];
            if (r8 != 1) goto L22;
            IWebview$Status r9 = IWebview$Status.Attached;
        L33:
            r6.success(new IWebview$Internal$WebviewState(r7, r9));
            return;
        L22:
            if (r8 != 2) goto L24;
            r9 = IWebview$Status.Visible;
            goto L33
        L24:
            if (r8 != 3) goto L26;
            r9 = IWebview$Status.Hidden;
            goto L33
        L26:
            if (r8 != 4) goto L29;
            r9 = IWebview$Status.Detached;
            goto L33
        L29:
            throw new NoWhenBranchMatchedException();
        L18:
            r7 = IWebview$VisibilityState.Hidden;
        L8:
            r2 = WebviewStatus.Detached;
            goto L9
        }
    }

    public final class e extends AbsChameleonHandler<IWebview$LoadingFinishRequest> {
        public final String a;

        public e() {
            this.a = LKAPIModules.Webview.LoadFinish.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.a;
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IWebview$LoadingFinishRequest r6, Callback r7) {
            IWebview$LoadingFinishRequest r8 = r6;
            Intrinsics.checkNotNullParameter(r8, Keys.API_RETURN_KEY_DATA);
            Intrinsics.checkNotNullParameter(r7, "callback");
            j.e(this.a, "LoadFinishHandler data=" + r8.getLogString() + '}');
            IChameleonHandlerContext r0 = getContext();
            if (r0 == null) goto L15;
            Map<String, u1b.a.C0305a> r1 = u1b.a.a;
            u1b.a.C0305a r2 = u1b.a.a(r0.getSession());
            if (r2 == null) goto L7;
            r2.c(ChameleonOpenTracker.Stage.RENDER, System.currentTimeMillis());
        L7:
            int r3 = r8.getCode();
            if (r3 != 0) goto L12;
            IChameleonLoader r9 = r0.getWebviewLoader();
            if (r9 == null) goto L15;
            r9.onLoadSuccess();
            goto L15
        L12:
            IChameleonLoader r4 = r0.getWebviewLoader();
            if (r4 == null) goto L15;
            r4.onLoadFailed(r3, new Throwable(r8.getErrorMessage()));
        L15:
            r7.success(null);
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> b() {
        return CollectionsKt.arrayListOf(new C0288a[]{new C0288a()});
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> c() {
        return CollectionsKt.arrayListOf(new AbsChameleonHandler[]{new e(), new d(), new c()});
    }

    public a() {
    }
}
