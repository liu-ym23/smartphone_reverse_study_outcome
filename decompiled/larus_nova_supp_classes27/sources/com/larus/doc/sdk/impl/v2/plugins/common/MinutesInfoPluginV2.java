package com.larus.doc.sdk.impl.v2.plugins.common;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.doc.sdk.api.model.MinutesInfoModel;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/common/MinutesInfoPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onDetachFromUIContainer", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "Companion", "MinutesInfoHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinutesInfoPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_MINUTES_INFO_CHANGED = "biz.notify.minutesInfoChanged";
    public static final Companion Companion = null;
    private static final String TAG = "MinutesInfoPluginV2";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/common/MinutesInfoPluginV2$Companion;", "", "<init>", "()V", "TAG", "", "BIZ_MINUTES_INFO_CHANGED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/common/MinutesInfoPluginV2$MinutesInfoHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/larus/doc/sdk/api/model/MinutesInfoModel;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/common/MinutesInfoPluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class MinutesInfoHandler implements i<MinutesInfoModel> {
        final /* synthetic */ MinutesInfoPluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public MinutesInfoHandler(MinutesInfoPluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(MinutesInfoModel r4, m r5) {
            FLogger.a.i(MinutesInfoPluginV2.TAG, "onMinutesInfoChanged: " + r4);
            MinutesInfoModel r6 = o39.a.a;
            Object r7 = o39.a.b;
            monitor-enter(r7);
            o39.a.a = r4;     // Catch: Throwable -> L7
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r7);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((MinutesInfoModel) r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public MinutesInfoPluginV2() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_MINUTES_INFO_CHANGED, new MinutesInfoHandler(this));
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r2, r3);
        MinutesInfoModel r4 = o39.a.a;
        Object r5 = o39.a.b;
        monitor-enter(r5);
        o39.a.a = null;     // Catch: Throwable -> L9
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r5);
        FLogger.a.i(TAG, "onDetachFromUIContainer: cleared");
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
