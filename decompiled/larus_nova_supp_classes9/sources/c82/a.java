package c82;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.livehostapi.platform.depend.im.ILiveIMDynamicView;
import com.bytedance.android.livesdk.config.tn;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends FrameLayout implements ILiveIMDynamicView, IHybridComponent.a {
    public final HybridCard a;
    public boolean b;
    public final Function2<Integer, Integer, Unit> c;

    /* JADX INFO: renamed from: c82.a$a, reason: collision with other inner class name */
    public static final class C0008a {
    }

    public static final class b extends b7.a {
        public b() {
        }

        public final void onBeforeOpenContainer() {
            super.onBeforeOpenContainer();
        }

        public final void onContainerInitEnd() {
            super.onContainerInitEnd();
        }

        public final void onContainerInitStart() {
            super.onContainerInitStart();
        }

        public final void onPrepareComponentEnd() {
            super.onPrepareComponentEnd();
        }

        public final void onPrepareComponentStart() {
            super.onPrepareComponentStart();
        }

        public final void onPrepareInitDataEnd() {
            super.onPrepareInitDataEnd();
        }

        public final void onPrepareTemplateStart() {
            super.onPrepareTemplateStart();
        }

        public final void onRelease() {
            super.onRelease();
        }

        public final void onLoadSuccess(View r1) {
            super.onLoadSuccess(r1);
        }

        public final void onPrepareTemplateEnd(boolean r1) {
            super.onPrepareTemplateEnd(r1);
        }

        public final boolean onFallback(int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "errorMessage");
            int r0 = b82.a.a;
            b82.a.a("on hybrid fall back. code " + r3 + ",  msg : " + r4, null);
            return super.onFallback(r3, r4);
        }

        public final void onInnerFallback(int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "errorMessage");
            int r0 = b82.a.a;
            b82.a.a("on hybrid inner im fall back. code " + r3 + ",  msg : " + r4, null);
            super.onInnerFallback(r3, r4);
        }

        public final void onLoadStart(View r1, boolean r2) {
            super.onLoadStart(r1, r2);
        }

        public final void onAttachView(View r2, IHybridComponent.HybridType r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "view");
            Intrinsics.checkNotNullParameter(r3, "hybridType");
            super.onAttachView(r2, r3, r4);
        }

        public final void onContainerError(View r3, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r5, "errorMessage");
            int r0 = b82.a.a;
            b82.a.a("on hybrid onContainerError im fall back. view: " + r3 + " code  " + r4 + ",  msg : " + r5, null);
            super.onContainerError(r3, r4, r5);
        }

        public final void onPrepareInitDataStart(String r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "scheme");
            Intrinsics.checkNotNullParameter(r3, "fallbackUrl");
            super.onPrepareInitDataStart(r2, r3, r4);
        }
    }

    static {
    }

    public View getView() {
        return this;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void release() {
        if (((Boolean) tn.a.getValue()).booleanValue() == false) goto L5;
        return;
    L5:
        HybridCard r0 = this.a;
        if (r0 == null) goto L9;
        r0.release();
        return;
    }

    public final boolean getInited() {
        return this.b;
    }

    public final Function2<Integer, Integer, Unit> getSizeChangeCallback() {
        return this.c;
    }

    public final void onJSBridgeCreated(y6.c r3) {
        Intrinsics.checkNotNullParameter(r3, "manager");
        r3.registerMethod("setIMCardSize", new a82.a(this));
    }

    public final void setInited(boolean r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r3, Function2<? super Integer, ? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.c = r4;
        b r5 = new b();
        IBrowserService r0 = k.f(IBrowserService.class);
        if (r0 == null) goto L5;
        HybridCard r6 = r0.getHybridCard(r3, x6.a.d(BuildConfig.FLAVOR), r5);
    L6:
        this.a = r6;
        if (r6 == null) goto L10;
        addView(r6);
        r6.setJSBridgeListener(this);
        return;
    L10:
        return;
    L5:
        r6 = null;
        goto L6
    }

    public final void load(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "fallbackUrl");
        HybridCard r1 = this.a;
        if (r1 == null) goto L6;
        Intrinsics.checkNotNullParameter(r4, "url");
        r1.a(UriProtector.parse("sslocal://webcast_lynxview?hybrid_type=lynx").buildUpon().appendQueryParameter("url", r4).appendQueryParameter("fallback_url", r5).build(), null);
        return;
    }
}
