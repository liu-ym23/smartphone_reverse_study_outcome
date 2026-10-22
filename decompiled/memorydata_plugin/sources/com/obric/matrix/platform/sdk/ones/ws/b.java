package com.obric.matrix.platform.sdk.ones.ws;

import android.util.Log;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.matrix.proto.Response;
import com.obric.matrix.proto.ResponseBody;
import com.obric.matrix.proto.SubscribeWsMsgResponse;
import com.obric.matrix.proto.SubscribeWsStatusResponse;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0012\n\u0002\u0010$\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u001b\u001e\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jh\u0010%\u001a\u00020\f2`\u0010&\u001a\\\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u000fJ\u0010\u0010'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010\u0019J\u001c\u0010)\u001a\u00020\f2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\f0*H\u0007J\u0006\u0010\u0017\u001a\u00020\u0015J{\u0010+\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\b\u00100\u001a\u0004\u0018\u00010\u00042\b\u00101\u001a\u0004\u0018\u00010\u00042\b\u00102\u001a\u0004\u0018\u00010\n2&\u00103\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000104j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u0001`5H\u0000¢\u0006\u0002\b6J\u000e\u00107\u001a\u00020\f2\u0006\u00108\u001a\u000209J*\u00107\u001a\u00020\f2\u0006\u00108\u001a\u0002092\u001a\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010\f0#Jh\u0010;\u001a\u00020\f2`\u0010&\u001a\\\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u000fJ(\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020>2\u0018\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\f0#J&\u0010?\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\bJd\u0010B\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\b2<\u0010:\u001a8\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(C\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\f0#j\u0002`EJ¼\u0001\u0010F\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2^\u0010G\u001aZ\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`H2<\u0010:\u001a8\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(C\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\f0#j\u0002`EJd\u0010I\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\b2<\u0010:\u001a8\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(C\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\f0#j\u0002`EJ~\u0010J\u001a\u00020\f2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2^\u0010&\u001aZ\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007j\u0004\u0018\u0001`HJ\u0012\u0010K\u001a\u00020\f2\n\b\u0002\u00108\u001a\u0004\u0018\u000109J.\u0010K\u001a\u00020\f2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\u001a\u0010:\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010\f0#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000Rj\u0010\u0005\u001a^\u0012\u0004\u0012\u00020\u0004\u0012T\u0012R\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\f0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000Rn\u0010\r\u001ab\u0012^\u0012\\\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\"\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020$\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper;", "", "()V", "TAG", "", "iWsMsgListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function9;", "", "", "", "", "", "iWsStatusListeners", "", "Lkotlin/Function4;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "channelType", "connectionState", "channelId", "", "isConnected", "isWsConnected", "wsBridge", "Lcom/obric/matrix/platform/sdk/ones/ws/IWsBridge;", "wsMsgCallbackFromMatrix", "com/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper$wsMsgCallbackFromMatrix$1", "Lcom/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper$wsMsgCallbackFromMatrix$1;", "wsStatusCallbackFromMatrix", "com/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper$wsStatusCallbackFromMatrix$1", "Lcom/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper$wsStatusCallbackFromMatrix$1;", "wsStatusReceiverFromMatrix", "Lcom/obric/matrix/platform/sdk/ones/ws/WsStatusReceiver;", "wsStatusSubscribeResultCallBack", "Lkotlin/Function2;", "Lcom/obric/matrix/proto/Response;", "addWsStatusListener", "listener", CommonConsts.APM_INNER_EVENT_COST_INIT, "iWsBridge", "isSupportMatrixWs", "Lkotlin/Function1;", "onWsMsgReceivedByProvider", "seqId", "logId", "service", "method", "encoding", "type", "payload", "headers", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "onWsMsgReceivedByProvider$sdk_platform_ones_release", "removeSubscribeWsStatus", "context", "Landroid/content/Context;", "subscribeResultCallBack", "removeWsStatusListener", "sendWsMsg", "wsMessageInfo", "Lcom/obric/matrix/proto/WsMessageInfo;", "subscribeWsMsg", ObricMemoryConstants.KEY_PACKAGE_NAME, "opt", "subscribeWsMsgByBroadCast", "success", ChatMessage.TYPE_RESPONSE, "Lcom/obric/matrix/platform/sdk/ones/ws/SubscribeResultCallBack;", "subscribeWsMsgByCallBack", "wsMsgCallBack", "Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgCallBack;", "subscribeWsMsgByProvider", "subscribeWsMsgWithCallback", "subscribeWsStatus", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8148a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.obric.matrix.platform.sdk.ones.ws.a f8149b;
    private static final List<Function4<Integer, Integer, Integer, Boolean, Unit>> c = null;
    private static final ConcurrentHashMap<String, Function9<Integer, Long, Long, Integer, Integer, String, String, byte[], Map<String, String>, Unit>> d = null;
    private static final a e = null;
    private static boolean f;
    private static final C0406b g = null;
    private static final d h = null;
    private static Function2<? super Boolean, ? super Response, Unit> i;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper$wsMsgCallbackFromMatrix$1", "Lcom/obric/matrix/platform/sdk/ones/SendCMDResultCallback;", "onResult", "", "cmd", "", ChatMessage.TYPE_RESPONSE, "Lcom/obric/matrix/proto/Response;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements com.obric.matrix.platform.sdk.ones.c {
        a() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.c
        public void a(int r18, Response r19) {
            Intrinsics.checkNotNullParameter(r19, ChatMessage.TYPE_RESPONSE);
            ResponseBody r0 = r19.body;
            if (r0 == null) goto L10;
            SubscribeWsMsgResponse r1 = r0.subscribeWsMsgResponse;
            if (r1 == null) goto L11;
            ConcurrentHashMap r2 = b.a();
            Integer r3 = r1.wsMessageInfo.service;
            Intrinsics.checkNotNullExpressionValue(r3, "it.wsMessageInfo.service");
            int r4 = ((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue();
            Integer r5 = r1.wsMessageInfo.method;
            Intrinsics.checkNotNullExpressionValue(r5, "it.wsMessageInfo.method");
            Function9 r7 = (Function9) ZeusTransformUtils.preCheckCast(r2.get(c.a(r4, ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).intValue())), Function9.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L12;
            Integer r8 = r1.wsMessageInfo.channelId;
            Intrinsics.checkNotNullExpressionValue(r8, "it.wsMessageInfo.channelId");
            Long r9 = r1.wsMessageInfo.seqId;
            Intrinsics.checkNotNullExpressionValue(r9, "it.wsMessageInfo.seqId");
            Long r10 = r1.wsMessageInfo.logId;
            Intrinsics.checkNotNullExpressionValue(r10, "it.wsMessageInfo.logId");
            Integer r11 = r1.wsMessageInfo.service;
            Intrinsics.checkNotNullExpressionValue(r11, "it.wsMessageInfo.service");
            Integer r12 = r1.wsMessageInfo.method;
            Intrinsics.checkNotNullExpressionValue(r12, "it.wsMessageInfo.method");
            r7.invoke(r8, r9, r10, r11, r12, r1.wsMessageInfo.payloadEncoding, r1.wsMessageInfo.payloadType, r1.wsMessageInfo.payload.toByteArray(), r1.wsMessageInfo.headers);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.ws.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/platform/sdk/ones/ws/MatrixWsHelper$wsStatusCallbackFromMatrix$1", "Lcom/obric/matrix/platform/sdk/ones/SendCMDResultCallback;", "onResult", "", "cmd", "", ChatMessage.TYPE_RESPONSE, "Lcom/obric/matrix/proto/Response;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0406b implements com.obric.matrix.platform.sdk.ones.c {
        C0406b() {
        }

        @Override // com.obric.matrix.platform.sdk.ones.c
        public void a(int r8, Response r9) {
            Intrinsics.checkNotNullParameter(r9, ChatMessage.TYPE_RESPONSE);
            ResponseBody r7 = r9.body;
            if (r7 == null) goto L10;
            SubscribeWsStatusResponse r10 = r7.subscribeWsStatusResponse;
            if (r10 == null) goto L10;
            Log.d("MatrixWsHelper", "wsStatusCallbackFromMatrix # onResult() called with subscribeWsStatusResponse = " + r10);
            b r11 = b.f8148a;
            Boolean r12 = r10.isConnected;
            Intrinsics.checkNotNullExpressionValue(r12, "it.isConnected");
            b.a(r12.booleanValue());
            Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(b.c(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L8:
            if (r13.hasNext() == false) goto L10;
            Function4 r1 = (Function4) ZeusTransformUtils.preCheckCast(r13.next(), Function4.class, "com.obric.memorydata.plugin");
            Integer r3 = r10.channelType;
            Intrinsics.checkNotNullExpressionValue(r3, "it.channelType");
            Integer r4 = r10.connectionState;
            Intrinsics.checkNotNullExpressionValue(r4, "it.connectionState");
            Integer r5 = r10.channelId;
            Intrinsics.checkNotNullExpressionValue(r5, "it.channelId");
            Boolean r6 = r10.isConnected;
            Intrinsics.checkNotNullExpressionValue(r6, "it.isConnected");
            r1.invoke(r3, r4, r5, r6);
        L10:
            Function2 r14 = b.b();
            if (r14 == null) goto L22;
            ResponseBody r15 = r9.body;
            if (r15 == null) goto L15;
            SubscribeWsStatusResponse r16 = r15.subscribeWsStatusResponse;
        L16:
            if (r16 == null) goto L18;
            boolean r17 = true;
        L19:
            r14.invoke(Boolean.valueOf(r17), r9);
            b r18 = b.f8148a;
            b.a(null);
            return;
        L18:
            r17 = false;
            goto L19
        L15:
            r16 = null;
            goto L16
        }
    }

    static {
        f8148a = new b();
        c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        d = new ConcurrentHashMap();
        e = new a();
        g = new C0406b();
        h = new d((Function4) ZeusTransformUtils.preCheckCast(MatrixWsHelper$wsStatusReceiverFromMatrix$1.INSTANCE, Function4.class, "com.obric.memorydata.plugin"));
    }

    private b() {
    }

    public static final /* synthetic */ ConcurrentHashMap a() {
        return d;
    }

    public static final /* synthetic */ void a(Function2 r2) {
        i = (Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(boolean r0) {
        f = r0;
    }

    public static final /* synthetic */ Function2 b() {
        return i;
    }

    public static final /* synthetic */ List c() {
        return c;
    }

    public final void a(int r16, long r17, long r19, int r21, int r22, String r23, String r24, byte[] r25, HashMap<String, String> r26) {
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("MatrixWsHelper", "onWsMsgReceivedByProvider() called with: channelId = " + r16 + ", seqId = " + r17 + ", logId = " + r19 + ", service = " + r21 + ", method = " + r22 + ", encoding = " + r23 + ", type = " + r24 + ", payload = " + r25 + ", headers = " + r26 + ", wsBridge is " + f8149b, null, 4, null);
        com.obric.matrix.platform.sdk.ones.ws.a r2 = f8149b;
        if (r2 == null) goto L6;
        r2.a(r16, r17, r19, r21, r22, r23, r24, r25, (Map) ZeusTransformUtils.preCheckCast(r26, Map.class, "com.obric.memorydata.plugin"));
        return;
    }
}
