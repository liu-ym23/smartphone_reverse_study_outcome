package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import d3.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/SetAdditionalContextMethod;", "Lcom/bytedance/ai/bridge/method/router/AbsSetAdditionalContextMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/router/AbsSetAdditionalContextMethodIDL$SetAdditionalContextParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/router/AbsSetAdditionalContextMethodIDL$SetAdditionalContextResultModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetAdditionalContextMethod extends AbsSetAdditionalContextMethodIDL {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.WORKER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ContainerType.WIDGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ContainerType.PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public SetAdditionalContextMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, f3.h r12) {
        AbsSetAdditionalContextMethodIDL.a r13 = (AbsSetAdditionalContextMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        a0 r0 = r10.getContainerContext();
        if (r0 == null) goto L5;
        ContainerType r1 = r0.getContainerType();
    L6:
        com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;
        StringBuilder r15 = new StringBuilder("call start, containerType=");
        r15.append(r1);
        r15.append(", contextLen=");
        r15.append(r13.getAdditionalContext().length());
        r15.append(", appletId=");
        a0 r16 = r10.getContainerContext();
        if (r16 == null) goto L9;
        String r17 = r16.getAppletId();
    L10:
        r15.append(r17);
        r14.i("AISDK_JSB_SetAdditionalContextMethod", r15.toString());
        if (r1 != null) goto L13;
        int r18 = -1;
    L15:
        if (r18 != 1) goto L17;
        AppletRuntime r19 = (AppletRuntime) r10.d(AppletRuntime.class);
        if (r19 == null) goto L32;
        r19.E(r13.getAdditionalContext(), r13.getBotId());
        r14.i("AISDK_JSB_SetAdditionalContextMethod", "call success, containerType=WORKER");
        Intrinsics.checkNotNullParameter(AbsSetAdditionalContextMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsSetAdditionalContextMethodIDL.b.class), "");
        return;
    L32:
        StringBuilder r110 = new StringBuilder("call failed, errNo=");
        f3.a r111 = f3.a.f;
        r110.append(r111.a);
        r110.append(", msg=Failed to get AppletRuntime");
        r14.e("AISDK_JSB_SetAdditionalContextMethod", r110.toString());
        f3.h.a.a(r12, "Failed to get AppletRuntime", r111, null, 10);
        return;
    L17:
        if (r18 != 2) goto L19;
        WidgetContainer r112 = (WidgetContainer) r10.d(WidgetContainer.class);
        if (r112 == null) goto L28;
        r112.v(r13.getAdditionalContext(), r13.getBotId());
        r14.i("AISDK_JSB_SetAdditionalContextMethod", "call success, containerType=WIDGET");
        Intrinsics.checkNotNullParameter(AbsSetAdditionalContextMethodIDL.b.class, "<this>");
        r12.b((ResultModel) k3.c.a(AbsSetAdditionalContextMethodIDL.b.class), "");
        return;
    L28:
        StringBuilder r113 = new StringBuilder("call failed, errNo=");
        f3.a r114 = f3.a.f;
        r113.append(r114.a);
        r113.append(", msg=Failed to get WidgetContainer");
        r14.e("AISDK_JSB_SetAdditionalContextMethod", r113.toString());
        f3.h.a.a(r12, "Failed to get WidgetContainer", r114, null, 10);
        return;
    L19:
        if (r18 == 3) goto L21;
        StringBuilder r115 = new StringBuilder("call failed, errNo=");
        f3.a r116 = f3.a.g;
        r115.append(r116.a);
        r115.append(", msg=container type error");
        r14.e("AISDK_JSB_SetAdditionalContextMethod", r115.toString());
        f3.h.a.a(r12, "container type error", r116, null, 10);
        return;
    L21:
        k2.j r117 = (k2.j) r10.d(k2.j.class);
        if (r117 == null) goto L24;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.a), null, null, new SetAdditionalContextMethod$handle$3$1(r117, r13, r12, null), 3, null);
        return;
    L24:
        StringBuilder r118 = new StringBuilder("call failed, errNo=");
        f3.a r119 = f3.a.f;
        r118.append(r119.a);
        r118.append(", msg=Failed to get AIContainerView");
        r14.e("AISDK_JSB_SetAdditionalContextMethod", r118.toString());
        f3.h.a.a(r12, "Failed to get AIContainerView", r119, null, 10);
        return;
    L13:
        r18 = b.a[r1.ordinal()];
        goto L15
    L9:
        r17 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
