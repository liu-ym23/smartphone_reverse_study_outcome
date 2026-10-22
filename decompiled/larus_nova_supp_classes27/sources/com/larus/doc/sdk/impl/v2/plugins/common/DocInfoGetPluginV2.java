package com.larus.doc.sdk.impl.v2.plugins.common;

import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.JsonObject;
import com.larus.doc.sdk.impl.service.ServiceManager;
import com.larus.office.OfficeInputParam;
import com.larus.office.w;
import com.larus.office.x;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import n39.f;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J \u0010\f\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000eH\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0013H\u0016J\u001c\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00060\u0013H\u0016¨\u0006\u001a"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/common/DocInfoGetPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "Lcom/larus/doc/sdk/api/IDocInfoProvider;", "<init>", "()V", "onAttachToUIContainer", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "getBridgeHandlers", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "getDocVersionId", "callBack", "Lkotlin/Function1;", "", "getIsAudioRecordDoc", "callback", "", "Companion", "InnerGetTrackInfoHandler", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocInfoGetPluginV2 extends OfficeDocumentPlugin implements f {
    private static final String BIZ_GET_TRACK_INFO = "biz.util.getTrackInfo";
    public static final Companion Companion = null;
    private static final String FUNC_GET_DOC_VERSION = "javascript:window.flow.biz.util.getDocVersion";
    private static final String FUNC_GET_IS_AUDIO_RECORD_DOC = "javascript:window.flow.biz.util.isVCUnifiedNote";
    private static final String TAG = "DocInfoGetPluginV2";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/common/DocInfoGetPluginV2$Companion;", "", "<init>", "()V", "TAG", "", "BIZ_GET_TRACK_INFO", "FUNC_GET_DOC_VERSION", "FUNC_GET_IS_AUDIO_RECORD_DOC", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/common/DocInfoGetPluginV2$InnerGetTrackInfoHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Ljava/lang/Void;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/common/DocInfoGetPluginV2;)V", "authType", "Lcom/bytedance/ee/bear/jsbridge/auth/BridgeAuthType;", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "getTraceMap", "", "", "messageId", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class InnerGetTrackInfoHandler implements i<Void> {
        final /* synthetic */ DocInfoGetPluginV2 this$0;

        public static /* synthetic */ Unit a(InnerGetTrackInfoHandler r0, m r1, String r2) {
            return handle$lambda$1(r0, r1, r2);
        }

        public BridgeAuthType authType() {
            return BridgeAuthType.Private;
        }

        public InnerGetTrackInfoHandler(DocInfoGetPluginV2 r1) {
            this.this$0 = r1;
        }

        private final Map<String, String> getTraceMap(String r9) {
            Pair[] r0 = new Pair[7];
            ServiceManager r1 = ServiceManager.INSTANCE;
            OfficeInputParam r2 = r1.getInputParam();
            String r3 = "";
            if (r2 == null) goto L6;
            String r4 = r2.getConversationId();
            if (r4 == null) goto L6;
        L7:
            boolean r5 = false;
            r0[0] = TuplesKt.to("conversationId", r4);
            OfficeInputParam r6 = r1.getInputParam();
            if (r6 == null) goto L11;
            String r7 = r6.getArtifactMetaId();
            if (r7 == null) goto L11;
        L12:
            r0[1] = TuplesKt.to("artifactMetaId", r7);
            OfficeInputParam r8 = r1.getInputParam();
            if (r8 == null) goto L16;
            String r10 = Integer.valueOf(r8.getResourceType()).toString();
            if (r10 == null) goto L16;
        L17:
            r0[2] = TuplesKt.to("artifactType", r10);
            r0[3] = TuplesKt.to("lastMessageId", r9);
            r0[4] = TuplesKt.to("message_id", r9);
            OfficeInputParam r11 = r1.getInputParam();
            if (r11 == null) goto L21;
            String r12 = r11.getFeishuRecordId();
            if (r12 == null) goto L21;
        L22:
            r0[5] = TuplesKt.to("feishu_record_id", r12);
            OfficeInputParam r13 = r1.getInputParam();
            if (r13 == null) goto L26;
            String r14 = r13.getFeishuRecordContentType();
            if (r14 == null) goto L26;
        L27:
            r0[6] = TuplesKt.to("feishu_record_generated_type", r14);
            Map r15 = MapsKt.mutableMapOf(r0);
            DocInfoGetPluginV2 r16 = this.this$0;
            OfficeInputParam r17 = r1.getInputParam();
            String r18 = null;
            if (r17 == null) goto L37;
            String r20 = r17.getRecordScene();
            if (r20 == null) goto L37;
            if ((!StringsKt.isBlank(r20)) == true) goto L35;
            r20 = null;
        L35:
            if (r20 == null) goto L37;
            String r21 = (String) r15.put("record_scene", r20);
        L37:
            OfficeInputParam r22 = r1.getInputParam();
            if (r22 == null) goto L40;
            String r23 = r22.isGeneralAgent();
        L41:
            if (r23 != null) goto L43;
        L44:
            r5 = true;
        L46:
            if ((!r5) == true) goto L49;
            r23 = null;
        L49:
            if (r23 != null) goto L51;
            r23 = "0";
        L51:
            r15.put("is_general_agent", r23);
            OfficeInputParam r24 = r1.getInputParam();
            if (r24 == null) goto L54;
            String r25 = r24.getAgentChatId();
        L55:
            if (r25 == null) goto L58;
            r3 = r25;
        L58:
            r15.put("chat_id", r3);
            w r26 = x.b(r16.getHost());
            if (r26 == null) goto L70;
            OfficeInputParam r27 = r26.a;
            if (r27 == null) goto L70;
            String r28 = r27.getOfflineCreateAttemptId();
            if (r28 == null) goto L70;
            if ((!StringsKt.isBlank(r28)) == false) goto L67;
            r18 = r28;
        L67:
            if (r18 == null) goto L70;
            r15.put("offline_create_attempt_id", r18);
        L70:
            return MapsKt.toMap(r15);
        L54:
            r25 = null;
            goto L55
        L43:
            if (r23.length() != 0) goto L46;
        L40:
            r23 = null;
        L26:
            r14 = "";
        L21:
            r12 = "";
        L16:
            r10 = "";
        L11:
            r7 = "";
        L6:
            r4 = "";
            goto L7
        }

        public void handle(Void r2, final m r3) {
            ChameleonPluginHost r4 = this.this$0.getHost();
            if (r4 == null) goto L6;
            String r5 = x.a(r4);
            if (r5 == null) goto L6;
        L7:
            ServiceManager.INSTANCE.getChatService(r5).getLatestMessageId(new c(this, r3));
            return;
        L6:
            r5 = "";
            goto L7
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((Void) r1, r2);
        }

        private static final Unit handle$lambda$1(InnerGetTrackInfoHandler r2, m r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "messageId");
            JSONObject r0 = new JSONObject();
            Iterator<Map.Entry<String, String>> r5 = r2.getTraceMap(r4).entrySet().iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            Map.Entry<String, String> r6 = r5.next();
            r0.put(r6.getKey(), r6.getValue());
            goto L4
        L6:
            if (r3 == null) goto L8;
            r3.b(r0);
        L8:
            FLogger.a.i(DocInfoGetPluginV2.TAG, "getTrackInfo, json=" + r0);
            return Unit.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(Function1 r0, String r1) {
        getIsAudioRecordDoc$lambda$1(r0, r1);
    }

    public static /* synthetic */ void c(Function1 r0, String r1) {
        getDocVersionId$lambda$0(r0, r1);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocInfoGetPluginV2() {
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_GET_TRACK_INFO, new InnerGetTrackInfoHandler(this));
    }

    @Override // n39.f
    public void getDocVersionId(final Function1<? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callBack");
        SafeJSExecutor.execJS(getHost().getWeb().getWebView(), FUNC_GET_DOC_VERSION, new JsonObject(), new b(r4));
    }

    @Override // n39.f
    public void getIsAudioRecordDoc(final Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        SafeJSExecutor.execJS(getHost().getWeb().getWebView(), FUNC_GET_IS_AUDIO_RECORD_DOC, new JsonObject(), new a(r4));
    }

    private static final void getDocVersionId$lambda$0(Function1 r3, String r4) {
        FLogger.a.i(TAG, "Get doc version: " + r4);
        Intrinsics.checkNotNull(r4);     // Catch: Exception -> L5
        r3.invoke(Integer.valueOf(CastIntegerProtector.parseInt(r4)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r3.invoke(-1);
        FLogger.a.e(TAG, e.getMessage());
    }

    private static final void getIsAudioRecordDoc$lambda$1(Function1 r3, String r4) {
        FLogger.a.i(TAG, "Is audio record doc: " + r4);
        r3.invoke(Boolean.valueOf(Boolean.parseBoolean(r4)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r3.invoke(Boolean.FALSE);
        FLogger.a.e(TAG, e.getMessage());
    }

    public void onAttachToUIContainer(ChameleonPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        if (r1 == null) goto L5;
        String r3 = x.a(r1);
    L6:
        ServiceManager r4 = ServiceManager.INSTANCE;
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r4.setDocInfoProvider(this, r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onDetachFromUIContainer(r2, r3);
        if (r2 == null) goto L5;
        String r4 = x.a(r2);
    L6:
        ServiceManager r0 = ServiceManager.INSTANCE;
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        r0.setDocInfoProvider(null, r4);
        return;
    L5:
        r4 = null;
        goto L6
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((ChameleonPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((ChameleonPluginHost) r1, r2);
    }
}
