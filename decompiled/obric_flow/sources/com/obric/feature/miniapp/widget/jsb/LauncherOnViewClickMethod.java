package com.obric.feature.miniapp.widget.jsb;

import android.util.Log;
import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/LauncherOnViewClickMethod;", "Lcom/obric/feature/miniapp/widget/jsb/AbsLauncherOnViewClickMethodIDL;", "<init>", "()V", "", "mustRunInMain", "()Z", "Ln1/c;", "bridgeContext", "Lcom/obric/feature/miniapp/widget/jsb/AbsLauncherOnViewClickMethodIDL$OnViewClickMethodParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/obric/feature/miniapp/widget/jsb/AbsLauncherOnViewClickMethodIDL$OnViewClickMethodResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/obric/feature/miniapp/widget/jsb/AbsLauncherOnViewClickMethodIDL$OnViewClickMethodParamModel;Lo1/f;)V", "Companion", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LauncherOnViewClickMethod extends AbsLauncherOnViewClickMethodIDL {
    public static final Companion Companion = null;
    public static final String METHOD_NAME = "obric.onViewClick";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/LauncherOnViewClickMethod$Companion;", "", "<init>", "()V", "METHOD_NAME", "", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LauncherOnViewClickMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsLauncherOnViewClickMethodIDL.OnViewClickMethodParamModel) r10, r11);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, o1.a
    public boolean mustRunInMain() {
        return true;
    }

    public void handle(c r10, AbsLauncherOnViewClickMethodIDL.OnViewClickMethodParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        if (Intrinsics.areEqual(r11.getViewId(), "root_container") == true) goto L6;
        Log.w("OMiniApp-OnViewClick", "ignore unsupported viewId=" + r11.getViewId() + ", templateId=" + r11.getTemplateId());
        String r5 = r11.getViewId();
        StringBuilder r13 = new StringBuilder("unsupported viewId: ");
        r13.append(r5);
        String r14 = r13.toString();
        Intrinsics.checkNotNullParameter(AbsLauncherOnViewClickMethodIDL.OnViewClickMethodResultModel.class, "<this>");
        r12.c(r14, (ResultModel) e.c(AbsLauncherOnViewClickMethodIDL.OnViewClickMethodResultModel.class));
        return;
    L6:
        View r15 = ((n1.a) r10).a();
        if (r15 != null) goto L25;
        Intrinsics.checkNotNullParameter(AbsLauncherOnViewClickMethodIDL.OnViewClickMethodResultModel.class, "<this>");
        r12.c("not found engine view", (ResultModel) e.c(AbsLauncherOnViewClickMethodIDL.OnViewClickMethodResultModel.class));
        return;
    L25:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L12
        Object r17 = Result.m124constructorimpl(Boolean.valueOf(r15.performClick()));     // Catch: Throwable -> L12
    L14:
        Throwable r18 = Result.m127exceptionOrNullimpl(r17);
        if (r18 == null) goto L17;
        Log.e("OMiniApp-OnViewClick", "performClick failed for root_container", r18);
    L17:
        Boolean r19 = Boolean.FALSE;
        if (Result.m130isFailureimpl(r17) == false) goto L21;
        r17 = r19;
    L21:
        if (((Boolean) r17).booleanValue() == false) goto L23;
        Intrinsics.checkNotNullParameter(AbsLauncherOnViewClickMethodIDL.OnViewClickMethodResultModel.class, "<this>");
        r12.b((ResultModel) e.c(AbsLauncherOnViewClickMethodIDL.OnViewClickMethodResultModel.class), "");
        return;
    L23:
        Intrinsics.checkNotNullParameter(AbsLauncherOnViewClickMethodIDL.OnViewClickMethodResultModel.class, "<this>");
        r12.c("performClick returned false", (ResultModel) e.c(AbsLauncherOnViewClickMethodIDL.OnViewClickMethodResultModel.class));
        return;
    L12:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L14
    }
}
