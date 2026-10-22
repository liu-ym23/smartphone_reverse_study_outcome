package m0b;

import android.content.Context;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.IChameleonHandlerContext;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.di.core.deps.JsEngineKind;
import com.ss.android.lark.officesdk.utils.di.g;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import ntb.i;
import ntb.l;
import vv4.m;
import z0b.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class a implements AbsChameleonJsRuntime {
    public Context a;
    public ChameleonBizType b;
    public final List<AbsChameleonService> c;
    public boolean d;
    public final b e;

    /* JADX INFO: renamed from: m0b.a$a, reason: collision with other inner class name */
    public static final class C0253a {
    }

    public final class b implements IChameleonHandlerContext {
        public final /* synthetic */ a a;

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final String getSession() {
            return BuildConfig.FLAVOR;
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final String getBizName() {
            ChameleonBizType r0 = this.a.b;
            if (r0 == null) goto L6;
            String r1 = r0.getType();
            if (r1 == null) goto L6;
            return r1;
        L6:
            return BuildConfig.FLAVOR;
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final Context getCmlContext() {
            return this.a.a;
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final ChameleonConfig getChameleonConfig() {
            return IChameleonHandlerContext.DefaultImpls.getChameleonConfig(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final Fragment getFragment() {
            return IChameleonHandlerContext.DefaultImpls.getFragment(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final WebView getWebview() {
            return IChameleonHandlerContext.DefaultImpls.getWebview(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final IChameleonLoader getWebviewLoader() {
            return IChameleonHandlerContext.DefaultImpls.getWebviewLoader(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final void destroyWebview() {
            IChameleonHandlerContext.DefaultImpls.destroyWebview(this);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final void reloadWebview() {
            IChameleonHandlerContext.DefaultImpls.reloadWebview(this);
        }

        public b(a r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final <T extends m> T getWebService(Class<T> r1) {
            return (T) IChameleonHandlerContext.DefaultImpls.getWebService(this, r1);
        }

        @Override // com.ss.android.lark.chameleon.IChameleonHandlerContext
        public final <T extends Serializable> void sendEvent(String r2, T r3) {
            Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
            Intrinsics.checkNotNullParameter(r3, Keys.API_RETURN_KEY_DATA);
            this.a.getClass();
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void destroy() {
        this.d = false;
        Iterator r0 = ((ArrayList) this.c).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((AbsChameleonService) r0.next()).onDetach(this.e);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void run() {
        DependencyContainer r0 = DependencyContainer.a;
        l r1 = DependencyContainer.a(l.class, null);
        this.d = true;
        Iterator r2 = ((ArrayList) this.c).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        AbsChameleonService r3 = (AbsChameleonService) r2.next();
        r3.onAttach(this.e);
        Iterator<AbsChameleonHandler<?>> r4 = r3.getBridgeHandlers().iterator();
    L7:
        if (r4.hasNext() == false) goto L4;
        r4.next().setContext(this.e);
        goto L7
    }

    @Inject
    public a() {
        this.c = new ArrayList();
        this.e = new b(this);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void registerService(AbsChameleonService r3) {
        Intrinsics.checkNotNullParameter(r3, "service");
        ((ArrayList) this.c).add(r3);
        if (this.d == false) goto L8;
        r3.onAttach(this.e);
        Iterator<AbsChameleonHandler<?>> r4 = r3.getBridgeHandlers().iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        r4.next().setContext(this.e);
        goto L6
    L10:
        return;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void init(Context r3, String r4, ChameleonBizType r5) {
        Intrinsics.checkNotNullParameter(r3, "mContext");
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "bizType");
        this.a = r3;
        this.b = r5;
        DependencyContainer r6 = DependencyContainer.a;
        l r7 = DependencyContainer.a(l.class, null);
        if (r7 != null) goto L5;
    L7:
        j.b("CML_TAG_ChameleonJsRuntimeImpl", "init, LKAPIDependency is null");
    L8:
        int r8 = g.a;
        if (g.a.a("ccm.mobile.chameleon.use_quickjs") == false) goto L11;
        JsEngineKind r9 = JsEngineKind.QUICKJS;
    L12:
        i r10 = DependencyContainer.a(i.class, null);
        if (r10 == null) goto L16;
        r5.getType();
        r10.B();
        return;
    L16:
        return;
    L11:
        JsEngineKind r11 = JsEngineKind.QUICKJS;
        goto L12
    L5:
        if ((r7.R() instanceof AbsChameleonService) == false) goto L7;
        List<AbsChameleonService> r0 = this.c;
        f r12 = r7.R();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.ss.android.lark.chameleon.AbsChameleonService");
        ((ArrayList) r0).add(r12);
        goto L8
    }
}
