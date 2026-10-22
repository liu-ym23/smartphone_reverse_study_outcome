package com.obric.feature.miniapp.widget.jsb;

import android.util.Log;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/GetSystemTimeMethod;", "Lcom/obric/feature/miniapp/widget/jsb/AbsGetSystemTimeMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/obric/feature/miniapp/widget/jsb/AbsGetSystemTimeMethodIDL$GetSystemTimeParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/obric/feature/miniapp/widget/jsb/AbsGetSystemTimeMethodIDL$GetSystemTimeResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/obric/feature/miniapp/widget/jsb/AbsGetSystemTimeMethodIDL$GetSystemTimeParamModel;Lo1/f;)V", "Companion", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGetSystemTimeMethod.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GetSystemTimeMethod.kt\ncom/obric/feature/miniapp/widget/jsb/GetSystemTimeMethod\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,44:1\n1#2:45\n*E\n"})
public final class GetSystemTimeMethod extends AbsGetSystemTimeMethodIDL {
    public static final Companion Companion = null;
    public static final String METHOD_NAME = "obric.getSystemTime";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/feature/miniapp/widget/jsb/GetSystemTimeMethod$Companion;", "", "<init>", "()V", "METHOD_NAME", "", "widget-sdk-4l_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public GetSystemTimeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsGetSystemTimeMethodIDL.GetSystemTimeParamModel) r10, r11);
    }

    public void handle(c r5, AbsGetSystemTimeMethodIDL.GetSystemTimeParamModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        Log.d(METHOD_NAME, "call jsb getSystemTime");
        Intrinsics.checkNotNullParameter(AbsGetSystemTimeMethodIDL.GetSystemTimeResultModel.class, "<this>");
        BaseModel r12 = e.c(AbsGetSystemTimeMethodIDL.GetSystemTimeResultModel.class);
        ((AbsGetSystemTimeMethodIDL.GetSystemTimeResultModel) r12).setData(String.valueOf(System.currentTimeMillis()));
        r11.b((ResultModel) r12, "");
    }
}
