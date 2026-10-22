package com.larus.slides.sdk.impl.plugins.cot;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import ex9.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0003\n\u000b\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/larus/slides/sdk/impl/plugins/cot/RenderFinishPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "RenderFinishHandler", "RenderStartHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RenderFinishPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_RENDER_FINISH = "biz.util.onSlidesRenderFinish";
    private static final String BIZ_RENDER_START = "biz.util.onSlidesRenderStart";
    public static final a Companion = null;
    private static final String TAG = "RenderFinishPluginV2";

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<Void> {
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b() {
        }

        public final void handle(Object r2, m r3) {
            Void r4 = (Void) r2;
            FLogger.a.i(RenderFinishPluginV2.TAG, "RenderFinishHandler notifyRenderFinish");
            e.a().b();
        }
    }

    public final class c implements i<Void> {
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public c() {
        }

        public final void handle(Object r2, m r3) {
            Void r4 = (Void) r2;
            FLogger.a.i(RenderFinishPluginV2.TAG, "RenderStartHandler notifyRenderStart");
            e.a().c();
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public RenderFinishPluginV2() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_RENDER_FINISH, new b());
        r3.put(BIZ_RENDER_START, new c());
    }
}
