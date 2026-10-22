package com.larus.doc.sdk.impl.v2.plugins.notify;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.google.gson.annotations.SerializedName;
import com.larus.doc.sdk.impl.service.ServiceManager;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.office.x;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0002J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\u0014"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocCreateRequestNotifyPluginV2;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "buildFailedCreateDocResp", "Lcom/alibaba/fastjson/JSONObject;", "msg", "parseCreateDocResp", "createDocResp", "GetCreateDocRespHandler", "NotifyOfflineCreateStateHandler", "OfflineCreateFailHandler", "OfflineCreateStateParams", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfflineDocCreateRequestNotifyPluginV2 extends OfficeDocumentPlugin {
    private static final String BIZ_GET_CREATE_DOC_RESP = "biz.util.getCreateDocResp";
    private static final String BIZ_NOTIFY_OFFLINE_CREATE_STATE = "biz.util.notifyOfflineCreateState";
    private static final String BIZ_OFFLINE_CREATE_FAIL = "biz.util.offlineCreateFail";
    private static final int CREATE_DOC_RESP_CODE_FAILED = -1;
    public static final Companion Companion = null;
    private static final int OFFLINE_CREATE_STATE_LINKED = 1;
    private static final String TAG = "OfflineDocCreateRequestNotifyPluginV2";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocCreateRequestNotifyPluginV2$Companion;", "", "<init>", "()V", "TAG", "", "BIZ_GET_CREATE_DOC_RESP", "BIZ_NOTIFY_OFFLINE_CREATE_STATE", "BIZ_OFFLINE_CREATE_FAIL", "OFFLINE_CREATE_STATE_LINKED", "", "CREATE_DOC_RESP_CODE_FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocCreateRequestNotifyPluginV2$GetCreateDocRespHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocCreateRequestNotifyPluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class GetCreateDocRespHandler implements i<Object> {
        final /* synthetic */ OfflineDocCreateRequestNotifyPluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public GetCreateDocRespHandler(OfflineDocCreateRequestNotifyPluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(Object r11, m r12) {
            ChameleonPluginHost r13 = this.this$0.getHost();
            if (r13 == null) goto L6;
            String r14 = x.a(r13);
            if (r14 == null) goto L6;
        L7:
            FLogger r0 = FLogger.a;
            r0.i(OfflineDocCreateRequestNotifyPluginV2.TAG, "handle get create doc resp, docLogicKey=".concat(r14));
            ChameleonPluginHost r1 = this.this$0.getHost();
            if (r1 == null) goto L12;
            Fragment r2 = r1.getFragment();
            if (r2 == null) goto L12;
            CoroutineScope r4 = LifecycleOwnerKt.getLifecycleScope(r2);
        L13:
            if (r4 != null) goto L18;
            r0.e(OfflineDocCreateRequestNotifyPluginV2.TAG, "get create doc resp failed, missing lifecycleScope, docLogicKey=".concat(r14));
            if (r12 == null) goto L20;
            r12.b(OfflineDocCreateRequestNotifyPluginV2.access$buildFailedCreateDocResp(this.this$0, "lifecycle_scope_not_ready"));
            return;
        L20:
            return;
        L18:
            BuildersKt.launch$default(r4, Dispatchers.getIO(), null, new OfflineDocCreateRequestNotifyPluginV2$GetCreateDocRespHandler$handle$1(r14, r12, this.this$0, null), 2, null);
            return;
        L12:
            r4 = null;
        L6:
            r14 = "";
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocCreateRequestNotifyPluginV2$NotifyOfflineCreateStateHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocCreateRequestNotifyPluginV2$OfflineCreateStateParams;", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocCreateRequestNotifyPluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class NotifyOfflineCreateStateHandler implements i<OfflineCreateStateParams> {
        final /* synthetic */ OfflineDocCreateRequestNotifyPluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public NotifyOfflineCreateStateHandler(OfflineDocCreateRequestNotifyPluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(OfflineCreateStateParams r5, m r6) {
            if (r5 == null) goto L4;
            Integer r7 = r5.getState();
        L5:
            ChameleonPluginHost r0 = this.this$0.getHost();
            if (r0 == null) goto L9;
            String r1 = x.a(r0);
            if (r1 == null) goto L9;
        L10:
            FLogger.a.i(OfflineDocCreateRequestNotifyPluginV2.TAG, "handle notify offline create state, docLogicKey=" + r1 + ", state=" + r7);
            boolean r2 = true;
            if (r7 != null) goto L14;
        L16:
            if (r6 == null) goto L26;
            JSONObject r3 = new JSONObject();
            if (r7 != null) goto L21;
        L23:
            r2 = false;
        L24:
            r3.put(FlowDoraConnectReason.SUCCESS, Boolean.valueOf(r2));
            r6.b(r3);
            return;
        L21:
            if (r7.intValue() != 1) goto L23;
        L26:
            return;
        L14:
            if (r7.intValue() != 1) goto L16;
            ServiceManager.INSTANCE.getOperationService(r1).notifyOfflineCreateState(r7.intValue());
        L9:
            r1 = "";
            goto L10
        L4:
            r7 = null;
            goto L5
        }

        public /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
            handle((OfflineCreateStateParams) r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocCreateRequestNotifyPluginV2$OfflineCreateFailHandler;", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "", "<init>", "(Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocCreateRequestNotifyPluginV2;)V", "handle", "", "data", "callback", "Lcom/bytedance/ee/bear/jsbridge/CallBackFunction;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class OfflineCreateFailHandler implements i<Object> {
        final /* synthetic */ OfflineDocCreateRequestNotifyPluginV2 this$0;

        @Nullable
        public /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return null;
        }

        public OfflineCreateFailHandler(OfflineDocCreateRequestNotifyPluginV2 r1) {
            this.this$0 = r1;
        }

        public void handle(Object r4, m r5) {
            ChameleonPluginHost r6 = this.this$0.getHost();
            if (r6 == null) goto L6;
            String r7 = x.a(r6);
            if (r7 == null) goto L6;
        L7:
            FLogger.a.i(OfflineDocCreateRequestNotifyPluginV2.TAG, "handle offline create fail, docLogicKey=".concat(r7));
            ServiceManager.INSTANCE.getOperationService(r7).offlineCreateFail();
            if (r5 == null) goto L11;
            JSONObject r8 = new JSONObject();
            r8.put(FlowDoraConnectReason.SUCCESS, Boolean.TRUE);
            r5.b(r8);
            return;
        L11:
            return;
        L6:
            r7 = "";
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/notify/OfflineDocCreateRequestNotifyPluginV2$OfflineCreateStateParams;", "", "<init>", "()V", "state", "", "getState", "()Ljava/lang/Integer;", "setState", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OfflineCreateStateParams {

        @SerializedName("state")
        private Integer state;

        public OfflineCreateStateParams() {
        }

        public final Integer getState() {
            return this.state;
        }

        public final void setState(Integer r1) {
            this.state = r1;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public OfflineDocCreateRequestNotifyPluginV2() {
    }

    private final JSONObject buildFailedCreateDocResp(String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("code", -1);
        r0.put("msg", r4);
        return r0;
    }

    private final JSONObject parseCreateDocResp(String r6) {
        if (r6 != null) goto L4;
    L7:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L22;
        JSONObject r7 = new JSONObject();
        r7.put("code", -1);
        r7.put("msg", "create_document_response_empty");
        return r7;
    L22:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        Object r2 = Result.constructor-impl(JSON.parseObject(r6));     // Catch: Throwable -> L14
    L16:
        Throwable r4 = Result.exceptionOrNull-impl(r2);
        Object r3 = r2;
        if (r4 == null) goto L21;
        JSONObject r5 = new JSONObject();
        r5.put("code", -1);
        r5.put("msg", r6);
        r3 = r5;
    L21:
        return (JSONObject) r3;
    L14:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L4:
        if (StringsKt.isBlank(r6) == true) goto L7;
        r0 = false;
        goto L9
    }

    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.ss.android.lark.chameleon.AbsChameleonPlugin*/.getBridgeHandlers(r3);
        r3.put(BIZ_GET_CREATE_DOC_RESP, new GetCreateDocRespHandler(this));
        r3.put(BIZ_NOTIFY_OFFLINE_CREATE_STATE, new NotifyOfflineCreateStateHandler(this));
        r3.put(BIZ_OFFLINE_CREATE_FAIL, new OfflineCreateFailHandler(this));
    }

    public static final /* synthetic */ JSONObject access$buildFailedCreateDocResp(OfflineDocCreateRequestNotifyPluginV2 r0, String r1) {
        return r0.buildFailedCreateDocResp(r1);
    }

    public static final /* synthetic */ JSONObject access$parseCreateDocResp(OfflineDocCreateRequestNotifyPluginV2 r0, String r1) {
        return r0.parseCreateDocResp(r1);
    }
}
