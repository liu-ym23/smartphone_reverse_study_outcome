package com.bytedance.ai.bridge.method.hybridmonitor;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.hybridMonitor.AbsCustomReportMethodIDL;
import com.bytedance.pia.core.utils.i;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import n1.c;
import o1.f;
import z1.a;
import z1.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/hybridmonitor/CustomReportMethod;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL$CustomEventDataModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL$EmptyMessageModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/hybridMonitor/AbsCustomReportMethodIDL$CustomEventDataModel;Lo1/f;)V", "Companion", "z1/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomReportMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomReportMethod.kt\ncom/bytedance/ai/bridge/method/hybridmonitor/CustomReportMethod\n+ 2 AIBridgeContextExt.kt\ncom/bytedance/ai/bridge/context/AIBridgeContextExtKt\n*L\n1#1,34:1\n3#2:35\n*S KotlinDebug\n*F\n+ 1 CustomReportMethod.kt\ncom/bytedance/ai/bridge/method/hybridmonitor/CustomReportMethod\n*L\n22#1:35\n*E\n"})
public final class CustomReportMethod extends AbsCustomReportMethodIDL {
    public static final a Companion = null;
    private static final String TAG = "HybridMonitor";

    static {
        Companion = new a();
    }

    public CustomReportMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsCustomReportMethodIDL.CustomEventDataModel) r10, r11);
    }

    public void handle(c r5, AbsCustomReportMethodIDL.CustomEventDataModel r10, f r11) {
        String r12 = "";
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        b r13 = (b) ((n1.a) r5).b(b.class);
        if (r13 != null) goto L15;
        r11.a("hybrid monitor not initialized");
        return;
    L15:
        r13.a(i.d(r10.toJson()));     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter(AbsCustomReportMethodIDL.EmptyMessageModel.class, "<this>");     // Catch: Exception -> L8
        r11.b((ResultModel) e.c(AbsCustomReportMethodIDL.EmptyMessageModel.class), "");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Intrinsics.checkNotNullParameter(TAG, "tag");
        Intrinsics.checkNotNullParameter("custom report failed", "msg");
        a1.a.f43a.e(TAG, "custom report failed", e);
        String r14 = e.getMessage();
        if (r14 == null) goto L13;
        r12 = r14;
    L13:
        r11.a(r12);
    }
}
