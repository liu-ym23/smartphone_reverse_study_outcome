package com.larus.slides.sdk.impl.plugins.event;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/slides/sdk/impl/plugins/event/GetTrackInfoPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "GetTrackInfoHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GetTrackInfoPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_GET_TRACK_INFO = "biz.util.getTrackInfo";
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements i<Void> {
        public final ChameleonPluginHost a;
        public JSONObject b;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(ChameleonPluginHost r2) {
            Intrinsics.checkNotNullParameter(r2, "host");
            this.a = r2;
        }

        public final void handle(Object r2, m r3) {
            Void r4 = (Void) r2;
            if (this.b == null) goto L5;
        L9:
            if (r3 == null) goto L12;
            r3.b(this.b);
            return;
        L12:
            return;
        L5:
            if ((this.a.getActivity() instanceof ax9.b) == false) goto L9;
            ax9.b r5 = this.a.getActivity();
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larus.slides.sdk.api.IGetTrackInfo");
            org.json.JSONObject r6 = r5.t9();
            if (r6 == null) goto L9;
            this.b = JSON.parseObject(r6.toString());
            goto L9
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public GetTrackInfoPluginV2() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_GET_TRACK_INFO, new b(getHost()));
    }
}
