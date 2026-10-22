package com.larus.doc.sdk.impl.v2.plugins.selection;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.doc.sdk.impl.service.ServiceManager;
import com.larus.doc.sdk.impl.v2.plugins.state.FlowDocStatePluginV2;
import com.larus.office.x;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/selection/FlowDocSelectionPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "InnerDoubaoMenuClickHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDocSelectionPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_DOUBAO_MENU_CLICK = "biz.navigation.handleDoubaoMenuClick";
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/selection/FlowDocSelectionPluginV2$Companion;", "", "<init>", "()V", "BIZ_DOUBAO_MENU_CLICK", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/selection/FlowDocSelectionPluginV2$InnerDoubaoMenuClickHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/selection/FlowDocSelectionPluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InnerDoubaoMenuClickHandler implements i<Object> {
        final /* synthetic */ FlowDocSelectionPluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public InnerDoubaoMenuClickHandler(FlowDocSelectionPluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(Object r2, m r3) {
            FlowDocStatePluginV2 r4 = this.this$0.getHost().findPlugin(FlowDocStatePluginV2.class);
            if (r4 == null) goto L5;
            r4.switchToAiEditMode();
        L5:
            String r5 = x.a(this.this$0.getHost());
            ServiceManager r6 = ServiceManager.INSTANCE;
            r6.getChatService(r5).requestChatInputFocus();
            r6.getChatService(r5).setToAiEdit();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public FlowDocSelectionPluginV2() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_DOUBAO_MENU_CLICK, new InnerDoubaoMenuClickHandler(this));
    }
}
