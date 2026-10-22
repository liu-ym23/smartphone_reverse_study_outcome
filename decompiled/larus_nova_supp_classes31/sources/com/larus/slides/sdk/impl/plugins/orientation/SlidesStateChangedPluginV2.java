package com.larus.slides.sdk.impl.plugins.orientation;

import androidx.fragment.app.FragmentActivity;
import ax9.e;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.slides.sdk.api.orientation.SlidesStateModel;
import com.larus.slides.sdk.api.orientation.SlidesStates;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/slides/sdk/impl/plugins/orientation/SlidesStateChangedPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "SlidesStateChangedHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesStateChangedPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_HANDLER_NAME = "biz.notify.slidesStateChanged";
    public static final a Companion = null;
    private static final String TAG = "SlidesStateChangedPlugin";

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<SlidesStateModel> {
        public final /* synthetic */ SlidesStateChangedPluginV2 a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(SlidesStateChangedPluginV2 r1) {
            this.a = r1;
        }

        public final void handle(Object r3, m r4) {
            SlidesStateModel r5 = (SlidesStateModel) r3;
            FLogger.a.i(SlidesStateChangedPluginV2.TAG, "handle data:" + GsonProtectorUtils.toJson(new Gson(), r5));
            if ((SlidesStateChangedPluginV2.access$getActivity(this.a) instanceof e) == false) goto L11;
            e r6 = SlidesStateChangedPluginV2.access$getActivity(this.a);
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.larus.slides.sdk.api.ISupportChangeScreenConfigPage");
            e r7 = r6;
            if (r5 == null) goto L8;
            String r8 = r5.getStates();
            if (r8 == null) goto L8;
        L9:
            r7.iT(r8);
            return;
        L8:
            r8 = SlidesStates.EMPTY.getStates();
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SlidesStateChangedPluginV2() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(SlidesStateChangedPluginV2 r0) {
        return r0.getActivity();
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_HANDLER_NAME, new b(this));
    }
}
