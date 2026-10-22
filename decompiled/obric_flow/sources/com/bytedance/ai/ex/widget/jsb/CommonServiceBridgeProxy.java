package com.bytedance.ai.ex.widget.jsb;

import android.app.Application;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.ipc.AppletData;
import com.bytedance.ai.ipc.AppletFunctionType;
import com.bytedance.ai.ipc.client.IPCClientManager;
import com.bytedance.ai.ipc.utils.GsonUtil;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jp\u0010\u0012\u001a\u00020\u0011\"\b\b\u0000\u0010\u0004*\u00020\u0001\"\b\b\u0001\u0010\u0006*\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/ex/widget/jsb/CommonServiceBridgeProxy;", "", "<init>", "()V", "Param", "Lcom/bytedance/ai/bridge/core/model/idl/ResultModel;", "Result", "", "messageId", "methodName", LynxResourceModule.PARAMS_KEY, "Ljava/lang/Class;", "paramsC", "appletId", "resultC", "Lo1/f;", "callback", "", "handler", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;Lo1/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonServiceBridgeProxy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonServiceBridgeProxy.kt\ncom/bytedance/ai/ex/widget/jsb/CommonServiceBridgeProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
public final class CommonServiceBridgeProxy {
    public static final CommonServiceBridgeProxy INSTANCE = null;

    static {
        INSTANCE = new CommonServiceBridgeProxy();
    }

    private CommonServiceBridgeProxy() {
    }

    public final <Param, Result extends ResultModel> Object handler(String r13, String r14, Param r15, Class<Param> r16, String r17, final Class<Result> r18, final f r19, Continuation<? super Unit> r20) {
        IPCClientManager r5 = IPCClientManager.INSTANCE;
        u0.a r10 = s0.a.f21800c;
        if (r10 == null) goto L5;
        Application r11 = r10.f22194a;
    L6:
        AppletFunctionType r12 = AppletFunctionType.JSB_TYPE;
        String r21 = UUID.randomUUID().toString();
        JsonObject r22 = ObricBridgeKt.getAnnotatedFieldsJson(r15, r16);
        Object r23 = r5.sendData(r11, r13, r12, r14, new AppletData(r21, GsonUtil.INSTANCE.toJson(r22), r17, null, 8, null), new AnonymousClass3(r19, r18), r20);
        if (r23 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r23;
    L10:
        return Unit.INSTANCE;
    L5:
        r11 = null;
        goto L6
    }
}
