package com.bytedance.ai.bridge.method.log;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n1.c;
import o1.f;
import z2.d;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ai/bridge/method/log/ReportAppLogMethod;", "Lcom/bytedance/ai/bridge/method/log/AbsReportAppLogMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/log/AbsReportAppLogMethodIDL$ReportAppLogParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/log/AbsReportAppLogMethodIDL$ReportAppLogResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/log/AbsReportAppLogMethodIDL$ReportAppLogParamModel;Lo1/f;)V", "Companion", "b2/a", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ReportAppLogMethod extends AbsReportAppLogMethodIDL {
    public static final b2.a Companion = null;
    private static final String EVENT_KEY_BOT_ID = "bot_id";
    private static final String EVENT_KEY_MESSGE_ID = "message_id";

    static {
        Companion = new b2.a();
    }

    public ReportAppLogMethod() {
    }

    public static final /* synthetic */ String access$getEVENT_KEY_BOT_ID$cp() {
        return EVENT_KEY_BOT_ID;
    }

    public static final /* synthetic */ String access$getEVENT_KEY_MESSGE_ID$cp() {
        return EVENT_KEY_MESSGE_ID;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsReportAppLogMethodIDL.ReportAppLogParamModel) r10, r11);
    }

    public void handle(c r5, AbsReportAppLogMethodIDL.ReportAppLogParamModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        AtomicBoolean r12 = d.f23373a;
        d.b(r10.getEventName(), new a(r5, r10));
        Intrinsics.checkNotNullParameter(AbsReportAppLogMethodIDL.ReportAppLogResultModel.class, "<this>");
        r11.b((ResultModel) e.c(AbsReportAppLogMethodIDL.ReportAppLogResultModel.class), "");
    }
}
