package com.larus.doc.sdk.impl.v2.plugins.aiedit;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.larus.doc.sdk.impl.generalbiz.rewrite.PartialRewriteManager;
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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010\r\u001a\u00020\u00072\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/aiedit/AIEditStatePluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "aiEditState", "", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Companion", "DocAIEditStateHandler", "GetAIEditStateHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIEditStatePluginV2 extends OfficeDocumentPlugin {
    private static final int AI_EDIT_STATE_DEFAULT = 0;
    private static final int AI_EDIT_STATE_REWRITING = 2;
    private static final int AI_EDIT_STATE_THINKING = 1;
    private static final String BIZ_GET_AI_EDIT_STATE = "biz.util.getAIEditState";
    private static final String BIZ_LOADING_DOC_SET_STATE = "biz.util.updateAIEditState";
    public static final Companion Companion = null;
    private static final String JSB_TAG = "OfficeJSB";
    private static final String TAG = "AIEditStatePlugin";
    private int aiEditState;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/aiedit/AIEditStatePluginV2$Companion;", "", "<init>", "()V", "TAG", "", "JSB_TAG", "BIZ_LOADING_DOC_SET_STATE", "BIZ_GET_AI_EDIT_STATE", "AI_EDIT_STATE_DEFAULT", "", "AI_EDIT_STATE_THINKING", "AI_EDIT_STATE_REWRITING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/aiedit/AIEditStatePluginV2$DocAIEditStateHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/larus/doc/sdk/impl/v2/plugins/aiedit/DocStateData;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/aiedit/AIEditStatePluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class DocAIEditStateHandler implements i<DocStateData> {
        final /* synthetic */ AIEditStatePluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public DocAIEditStateHandler(AIEditStatePluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(DocStateData r7, m r8) {
            if (r7 == null) goto L30;
            Integer r9 = r7.getState();     // Catch: Exception -> L25
            if (r9 == null) goto L31;
            AIEditStatePluginV2 r3 = this.this$0;     // Catch: Exception -> L25
            int r10 = r9.intValue();     // Catch: Exception -> L25
            FLogger r4 = FLogger.a;     // Catch: Exception -> L25
            r4.i(AIEditStatePluginV2.TAG, "handleLoadingDocState state: " + r10);     // Catch: Exception -> L25
            StringBuilder r5 = new StringBuilder("FE->Native biz.util.updateAIEditState source=AIEditStatePluginV2 state=");     // Catch: Exception -> L25
            r5.append(r10);     // Catch: Exception -> L25
            r5.append(" hasCallback=");     // Catch: Exception -> L25
            if (r8 == null) goto L9;
            boolean r11 = true;
        L10:
            r5.append(r11);     // Catch: Exception -> L25
            r4.i(AIEditStatePluginV2.JSB_TAG, r5.toString());     // Catch: Exception -> L25
            ChameleonPluginHost r12 = r3.getHost();     // Catch: Exception -> L25
            if (r12 == null) goto L14;
            String r13 = x.a(r12);     // Catch: Exception -> L25
            if (r13 == null) goto L14;
        L15:
            if (r10 == 0) goto L20;
            if (r10 == 1) goto L20;
            if (r10 == 2) goto L20;
            int r2 = AIEditStatePluginV2.access$getAiEditState$p(r3);     // Catch: Exception -> L25
        L21:
            AIEditStatePluginV2.access$setAiEditState$p(r3, r2);     // Catch: Exception -> L25
            ServiceManager.INSTANCE.getLoadingDocStateService(r13).onUpdateState(Integer.valueOf(r10));     // Catch: Exception -> L25
            if (r10 != 1) goto L32;
            PartialRewriteManager.INSTANCE.notifyTrackInfoUpdate();     // Catch: Exception -> L25
            return;
        L32:
            return;
        L20:
            r2 = r10;
        L14:
            r13 = "";
            goto L15
        L9:
            r11 = false;
            goto L10
        L31:
            return;
        L25:
            e = move-exception;
            FLogger.a.e(AIEditStatePluginV2.TAG, "handleLoadingDocState failed: " + e.getMessage());
            return;
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((DocStateData) r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/aiedit/AIEditStatePluginV2$GetAIEditStateHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/aiedit/AIEditStatePluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class GetAIEditStateHandler implements i<Object> {
        final /* synthetic */ AIEditStatePluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public GetAIEditStateHandler(AIEditStatePluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(Object r3, m r4) {
            FLogger r5 = FLogger.a;
            StringBuilder r0 = new StringBuilder("FE->Native biz.util.getAIEditState source=AIEditStatePluginV2 returnState=");
            r0.append(AIEditStatePluginV2.access$getAiEditState$p(this.this$0));
            r0.append(" hasCallback=");
            if (r4 == null) goto L5;
            boolean r1 = true;
        L6:
            r0.append(r1);
            r5.i(AIEditStatePluginV2.JSB_TAG, r0.toString());
            if (r4 == null) goto L10;
            JSONObject r6 = new JSONObject();
            r6.put("state", Integer.valueOf(AIEditStatePluginV2.access$getAiEditState$p(this.this$0)));
            r4.b(r6);
            return;
        L10:
            return;
        L5:
            r1 = false;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public AIEditStatePluginV2() {
    }

    public static final /* synthetic */ int access$getAiEditState$p(AIEditStatePluginV2 r0) {
        return r0.aiEditState;
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_LOADING_DOC_SET_STATE, new DocAIEditStateHandler(this));
        r3.put(BIZ_GET_AI_EDIT_STATE, new GetAIEditStateHandler(this));
    }

    public static final /* synthetic */ void access$setAiEditState$p(AIEditStatePluginV2 r0, int r1) {
        r0.aiEditState = r1;
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r1, r2);
    }
}
