package com.obric.miniapp.aibridge;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/miniapp/aibridge/ShowDatePickerMethod;", "Lcom/obric/miniapp/aibridge/AbsShowDatePickerMethodIDL;", "<init>", "()V", "mustRunInMain", "", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsShowDatePickerMethodIDL$ShowDatePickerParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsShowDatePickerMethodIDL$ShowDatePickerResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowDatePickerMethod extends AbsShowDatePickerMethodIDL {
    public final boolean mustRunInMain() {
        return true;
    }

    public ShowDatePickerMethod() {
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.miniapp.aibridge.a0] */
    public final void handle(e3.d r20, ParamModel r21, final f3.h r22) {
        AbsShowDatePickerMethodIDL.a r0 = (AbsShowDatePickerMethodIDL.a) r21;
        Intrinsics.checkNotNullParameter(r20, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r22, "callback");
        Activity r2 = AppHost.a.a().getCurrentActivity();
        if ((r2 instanceof Context) == false) goto L5;
        Activity r6 = r2;
    L7:
        if (r6 != null) goto L9;
        f3.h.a.a(r22, "No available activity context", null, null, 14);
        return;
    L9:
        String r7 = r0.getType();
        if (r7 != null) goto L12;
        f3.h.a.a(r22, "type is required", null, null, 14);
        return;
    L12:
        String r8 = r0.getTitle();
        JSONObject r9 = r0.getDefaultValue();
        JSONObject r10 = r0.getYearRange();
        List<String> r11 = r0.getCustomOptions();
        String r3 = r0.is24Hour();
        boolean r5 = false;
        if (r3 == null) goto L17;
        Boolean r4 = StringsKt.toBooleanStrictOrNull(r3);
        if (r4 == null) goto L17;
        boolean r12 = r4.booleanValue();
    L18:
        String r13 = r0.getShowTimeLabels();
        if (r13 == null) goto L23;
        Boolean r14 = StringsKt.toBooleanStrictOrNull(r13);
        if (r14 == null) goto L23;
        boolean r15 = r14.booleanValue();
    L24:
        String r16 = r0.getWidth();
        if (r16 == null) goto L27;
        Integer r17 = StringsKt.toIntOrNull(r16);
    L28:
        String r18 = r0.getHeight();
        if (r18 == null) goto L31;
        Integer r19 = StringsKt.toIntOrNull(r18);
    L32:
        Long r110 = r0.getMinTimestamp();
        Long r111 = r0.getMaxTimestamp();
        if (Intrinsics.areEqual(r7, "custom_repeat") == false) goto L50;
        List<String> r1 = r11;
        if (r1 != null) goto L37;
    L38:
        r5 = true;
    L39:
        if (r5 == false) goto L50;
        f3.h.a.a(r22, "customOptions is required for custom_repeat type", null, null, 14);
        return;
    L37:
        if (r1.isEmpty() == false) goto L39;
    L50:
        com.obric.miniapp.utils.a0.p(com.obric.miniapp.utils.a0.a, r6, r7, r8, r9, r10, r11, r12, r15, r17, r19, r110, r111, new a0(r22));     // Catch: Throwable -> L43
        return;
    L43:
        th = move-exception;
        String r23 = "showDatePicker failed";
        FLogger.a.e("ShowDatePickerMethod", "showDatePicker failed", th);
        String r24 = th.getMessage();
        if (r24 == null) goto L48;
        r23 = r24;
    L48:
        f3.h.a.a(r22, r23, null, null, 14);
        return;
    L31:
        r19 = null;
        goto L32
    L27:
        r17 = null;
    L23:
        r15 = true;
    L17:
        r12 = false;
        goto L18
    L5:
        r6 = null;
        goto L7
    }
}
