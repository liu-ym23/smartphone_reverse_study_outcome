package com.larus.doc.sdk.impl.v2.plugins.notify;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.doc.sdk.impl.generalbiz.notify.DocStateEvent;
import com.larus.doc.sdk.impl.service.ServiceManager;
import com.larus.office.x;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/notify/DocStateNotifyPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "InnerDocStateChangedHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocStateNotifyPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_NOTIFY_STATE_CHANGED = "biz.notify.docStateChanged";
    public static final Companion Companion = null;
    private static final String TAG = "DocStateNotifyPlugin";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/notify/DocStateNotifyPluginV2$Companion;", "", "<init>", "()V", "TAG", "", "BIZ_NOTIFY_STATE_CHANGED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/notify/DocStateNotifyPluginV2$InnerDocStateChangedHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/larus/doc/sdk/impl/generalbiz/notify/DocStateEvent;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/notify/DocStateNotifyPluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InnerDocStateChangedHandler implements i<DocStateEvent> {
        final /* synthetic */ DocStateNotifyPluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public InnerDocStateChangedHandler(DocStateNotifyPluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(DocStateEvent r5, m r6) {
            ChameleonPluginHost r7 = this.this$0.getHost();
            if (r7 == null) goto L6;
            String r8 = x.a(r7);
            if (r8 == null) goto L6;
        L7:
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("notify doc state changed: isEmpty = ");
            Integer r2 = null;
            if (r5 == null) goto L10;
            Boolean r3 = r5.isEmpty();
        L11:
            r1.append(r3);
            r1.append(", isGenerating = ");
            if (r5 == null) goto L14;
            Boolean r4 = r5.isGenerating();
        L15:
            r1.append(r4);
            r1.append(", contentLength = ");
            if (r5 == null) goto L18;
            r2 = r5.getContentLength();
        L18:
            r1.append(r2);
            r0.i(DocStateNotifyPluginV2.TAG, r1.toString());
            if (r5 == null) goto L22;
            ServiceManager r9 = ServiceManager.INSTANCE;
            r9.getChatService(r8).onDocStateChanged(Intrinsics.areEqual(r5.isEmpty(), Boolean.TRUE));
            r9.getDocState();
            r9.getDocState();
            return;
        L22:
            return;
        L14:
            r4 = null;
            goto L15
        L10:
            r3 = null;
        L6:
            r8 = "";
            goto L7
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((DocStateEvent) r1, r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocStateNotifyPluginV2() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_NOTIFY_STATE_CHANGED, new InnerDocStateChangedHandler(this));
    }
}
