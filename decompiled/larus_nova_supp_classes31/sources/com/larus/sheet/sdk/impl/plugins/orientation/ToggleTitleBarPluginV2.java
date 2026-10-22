package com.larus.sheet.sdk.impl.plugins.orientation;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.sheet.sdk.api.orientation.TitleBarStates;
import com.larus.sheet.sdk.api.orientation.ToggleTitleBarModel;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pw9.e;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/sheet/sdk/impl/plugins/orientation/ToggleTitleBarPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "ToggleTitleBarHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ToggleTitleBarPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_HANDLER_NAME = "biz.util.toggleTitlebar";
    public static final a Companion = null;
    private static final String TAG = "ToggleTitleBarPluginV2";

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<ToggleTitleBarModel> {
        public final /* synthetic */ ToggleTitleBarPluginV2 a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(ToggleTitleBarPluginV2 r1) {
            this.a = r1;
        }

        public final void handle(Object r3, m r4) {
            ToggleTitleBarModel r5 = (ToggleTitleBarModel) r3;
            FLogger.a.i(ToggleTitleBarPluginV2.TAG, "handle data:" + GsonProtectorUtils.toJson(new Gson(), r5));
            if ((ToggleTitleBarPluginV2.access$getActivity(this.a) instanceof e) == false) goto L12;
            e r6 = ToggleTitleBarPluginV2.access$getActivity(this.a);
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.larus.sheet.sdk.api.ISupportChangeScreenConfigPage");
            e r7 = r6;
            if (r5 == null) goto L9;
            Integer r8 = r5.getStates();
            if (r8 == null) goto L9;
            int r9 = r8.intValue();
        L10:
            r7.d4(r9);
            return;
        L9:
            r9 = TitleBarStates.VISIBLE.getStates();
            goto L10
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public ToggleTitleBarPluginV2() {
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(ToggleTitleBarPluginV2 r0) {
        return r0.getActivity();
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_HANDLER_NAME, new b(this));
    }
}
