package com.larus.sheet.sdk.impl.plugins.chat_input;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sw9.g;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/sheet/sdk/impl/plugins/chat_input/SheetChatInputVisibilityPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "UpdateChatInputVisibilityHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SheetChatInputVisibilityPlugin extends OfficeDocumentPlugin {
    private static final String BIZ_UPDATE_CHAT_INPUT_VISIBILITY = "biz.util.updateChatInputVisibility";
    public static final a Companion = null;
    private static final String TAG = "SheetChatInputVisibilityPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b implements i<UpdateChatInputVisibilityData> {
        public b() {
        }

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public final void handle(Object r3, m r4) {
            UpdateChatInputVisibilityData r5 = (UpdateChatInputVisibilityData) r3;
            if (r5 == null) goto L7;
            Boolean r6 = r5.getVisible();
            if (r6 == null) goto L7;
            boolean r7 = r6.booleanValue();
        L8:
            FLogger.a.i(SheetChatInputVisibilityPlugin.TAG, "Got update chat input visibility data: " + r7);
            g.a().c(r7);
            return;
        L7:
            r7 = false;
            goto L8
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public SheetChatInputVisibilityPlugin() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_UPDATE_CHAT_INPUT_VISIBILITY, new b());
    }
}
