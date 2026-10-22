package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.capabilitykit.common.Ext;
import com.obric.matrix.proto.MATRIX_CMD;
import com.obric.matrix.proto.Response;
import com.obric.memorydata.database.entity.ChatMessage;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.l;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JL\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u001a\u0010\u001b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\r\u0010&\u001a\u00020\u0019H\u0000¢\u0006\u0002\b'J@\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u001a\u0010\u001b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u001c2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J2\u0010+\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u001d0\u001cH\u0002J \u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\"\u0010-\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010.\u001a\u00020*2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0018\u0010/\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*J*\u00100\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010.\u001a\u00020*2\u0006\u00101\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\"\u00102\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0015\u00103\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0007H\u0000¢\u0006\u0002\b4J\r\u00105\u001a\u00020\u0019H\u0000¢\u0006\u0002\b6Jf\u00107\u001a\u00020\u0019*\u0004\u0018\u0001082\u0006\u0010\u001a\u001a\u00020\u00072\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010<2:\b\u0002\u0010=\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0019\u0018\u00010>H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0011j\b\u0012\u0004\u0012\u00020\u0007`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0011j\b\u0012\u0004\u0012\u00020\u0007`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/CmdManager;", "", "()V", "ACTION_BY_SDK", "", "AUTHORITY", "DEFAULT_CALLBACK_TIMEOUT", "", "KEY_MATRIX_CMD", "KEY_PENDING_INTENT", "KEY_REQUEST_BYTE_ARRAY", "KEY_RESPONSE_BYTE_ARRAY", "KEY_RESULT_RECEIVER", "SEND_CMD_BY_PROVIDER", "SEND_CMD_BY_PROVIDER_URI", "TAG", "forceUseOldBindSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mCustomTimeout", "notTimeoutCmdSet", "sendCmdTimeout", "useBinderCMDList", "", "handleSendCMDByBinderFail", "", "cmd", "emitter", "Lio/reactivex/MaybeEmitter;", "Lkotlin/Pair;", "Lcom/obric/matrix/proto/Response;", "sendCMDResultCallback", "Lcom/obric/matrix/platform/sdk/ones/SendCMDResultCallback;", "errorCode", DTraitConstant.ERROR, "handlerSendCmdException", "it", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "init$sdk_platform_ones_release", "sendCMDByBind", Ext.KEY_REQUEST, "Lcom/obric/matrix/proto/Request;", "sendCMDByIntentService", "sendCmd", "sendCmdForceUseBinder", "newRequest", "sendCmdSync", "sendCmdWithTimeout", LocationMonitorConst.TIMEOUT, "sendCmdWithoutTimeout", "setCustomTimeout", "setCustomTimeout$sdk_platform_ones_release", "updateConfig", "updateConfig$sdk_platform_ones_release", "invokeAsyncSafely", "Lcom/obric/matrix/platform/server/IServerBroker;", "bytes", "", "callback", "Lcom/obric/matrix/platform/server/IServerCallback;", "onError", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8113a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f8114b;
    private static final HashSet<Integer> c = null;
    private static List<Integer> d;
    private static HashSet<Integer> e;

    /* JADX INFO: renamed from: com.obric.matrix.platform.sdk.ones.internal.tunnel.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/platform/sdk/ones/internal/tunnel/CmdManager$sendCMDByBind$1", "Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/ServiceConnectCallback;", "onResult", "", "isConnected", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0403a {
    }

    static {
        f8113a = new a();
        f8114b = 35;
        c = SetsKt.hashSetOf(new Integer[]{Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_STATUS.getValue()), Integer.valueOf(MATRIX_CMD.CMD_SUBSCRIBE_WS_MSG_BY_CALLBACK.getValue()), Integer.valueOf(MATRIX_CMD.CMD_PRIVATE_START_PICO_LINKS.getValue())});
        d = CollectionsKt.listOf(Integer.valueOf(MATRIX_CMD.CMD_SEND_WS_MESSAGE.getValue()));
        e = new HashSet();
    }

    private a() {
    }

    private final void a(int r10, l<Pair<Integer, Response>> r11, com.obric.matrix.platform.sdk.ones.c r12, int r13, String r14) {
        l r9 = (l) ZeusTransformUtils.wrapperContextForParams(r11, l.class, "com.obric.memorydata.plugin");
        com.obric.matrix.platform.sdk.ones.c r15 = (com.obric.matrix.platform.sdk.ones.c) ZeusTransformUtils.wrapperContextForParams(r12, com.obric.matrix.platform.sdk.ones.c.class, "com.obric.memorydata.plugin");
        String r2 = null;
        com.obric.matrix.platform.sdk.ones.internal.b.b.a("CmdManager", "handleBinderCallFail, errorCode: " + r13 + ", errorMsg: " + r14, null, 4, null);
        Response r16 = new Response.a().b(Integer.valueOf(r13)).a(r14).a();
        com.obric.matrix.platform.sdk.ones.internal.a.a r3 = com.obric.matrix.platform.sdk.ones.internal.a.a.f8105a;
        Context r17 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.matrix.platform.sdk.ones.b.f8082a.a(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L5;
        r2 = r17.getPackageName();
    L5:
        if (r2 != null) goto L7;
        String r6 = "";
    L8:
        Intrinsics.checkNotNullExpressionValue(r16, ChatMessage.TYPE_RESPONSE);
        r3.a(r10, 1, r6, r16, null);
        if (r9 == null) goto L11;
        r9.onSuccess(new Pair(Integer.valueOf(r10), r16));
    L11:
        if (r15 == null) goto L14;
        r15.a(r10, r16);
        return;
    L14:
        return;
    L7:
        r6 = r2;
        goto L8
    }

    public static final /* synthetic */ void a(a r8, int r9, l r10, com.obric.matrix.platform.sdk.ones.c r11, int r12, String r13) {
        r8.a(r9, (l) ZeusTransformUtils.wrapperContextForParams(r10, l.class, "com.obric.memorydata.plugin"), (com.obric.matrix.platform.sdk.ones.c) ZeusTransformUtils.wrapperContextForParams(r11, com.obric.matrix.platform.sdk.ones.c.class, "com.obric.memorydata.plugin"), r12, r13);
    }
}
