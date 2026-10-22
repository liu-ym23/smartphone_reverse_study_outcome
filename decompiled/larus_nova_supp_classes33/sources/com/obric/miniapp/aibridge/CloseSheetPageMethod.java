package com.obric.miniapp.aibridge;

import android.app.Activity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.miniapp.sheet.MiniAppSheetRegistry;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002¨\u0006\u0014"}, d2 = {"Lcom/obric/miniapp/aibridge/CloseSheetPageMethod;", "Lcom/obric/miniapp/aibridge/AbsCloseSheetPageMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsCloseSheetPageMethodIDL$CloseSheetPageParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsCloseSheetPageMethodIDL$CloseSheetPageResultModel;", "resolveActivity", "Landroid/app/Activity;", "resolveTargetViewId", "", "stringValue", "Lcom/google/gson/JsonObject;", "key", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CloseSheetPageMethod extends AbsCloseSheetPageMethodIDL {
    public CloseSheetPageMethod() {
    }

    public static String b(JsonObject r1, String r2) {
        JsonElement r3 = r1.get(r2);
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isJsonPrimitive() == true) goto L8;
        return null;
    L8:
        if (r3.getAsJsonPrimitive().isString() == false) goto L14;
        String r4 = r3.getAsString();
        Intrinsics.checkNotNull(r4);
        if ((!StringsKt.isBlank(r4)) == true) goto L12;
        return null;
    L12:
        return r4;
    L14:
        return null;
    }

    public final void handle(e3.d r6, ParamModel r7, f3.h r8) {
        AbsCloseSheetPageMethodIDL.a r9 = (AbsCloseSheetPageMethodIDL.a) r7;
        Intrinsics.checkNotNullParameter(r6, "bridgeContext");
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r8, "callback");
        Activity r0 = r6.getOwnerActivity();
        if (r0 != null) goto L8;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r1 = AppletRuntimeManager.d;
        if (r1 == null) goto L7;
        r0 = r1.currentActivity();
        goto L8
    L7:
        r0 = null;
    L8:
        String r2 = r9.getViewId();
        boolean r3 = true;
        if (r2 != null) goto L11;
    L15:
        JsonObject r4 = r9.getContext();
        if (r4 == null) goto L18;
        r2 = b(r4, "viewId");
    L19:
        if (r2 != null) goto L33;
        JsonObject r10 = r9.getContext();
        if (r10 == null) goto L23;
        String r11 = b(r10, "containerId");
    L24:
        if (r11 != null) goto L35;
        d3.a0 r12 = r6.getContainerContext();
        if (r12 == null) goto L32;
        r11 = r12.getContainerId();
        if (r11 == null) goto L32;
        if ((!StringsKt.isBlank(r11)) == true) goto L35;
    L32:
        r11 = null;
    L35:
        if (r11 != null) goto L37;
    L40:
        boolean r5 = true;
    L42:
        if (r5 == true) goto L44;
        String r13 = MiniAppSheetRegistry.INSTANCE.dismissWithViewId(r11, r0);
    L47:
        if (r13 != null) goto L49;
    L52:
        if (r3 == false) goto L54;
        f3.h.a.a(r8, "sheet page not found", null, null, 14);
        return;
    L54:
        Intrinsics.checkNotNullParameter(AbsCloseSheetPageMethodIDL.b.class, "<this>");
        AbsCloseSheetPageMethodIDL.b r14 = k3.c.a(AbsCloseSheetPageMethodIDL.b.class);
        r14.setViewId(r13);
        r8.b(r14, "");
        return;
    L49:
        if (StringsKt.isBlank(r13) == true) goto L52;
        r3 = false;
        goto L52
    L44:
        if (r0 != null) goto L46;
        f3.h.a.a(r8, "No available activity context", null, null, 14);
        return;
    L46:
        r13 = MiniAppSheetRegistry.INSTANCE.dismissLatestWithViewId(r0);
        goto L47
    L37:
        if (StringsKt.isBlank(r11) == true) goto L40;
        r5 = false;
        goto L42
    L23:
        r11 = null;
    L33:
        r11 = r2;
        goto L35
    L18:
        r2 = null;
        goto L19
    L11:
        if ((!StringsKt.isBlank(r2)) == true) goto L14;
        r2 = null;
    L14:
        if (r2 != null) goto L33;
        goto L15
    }
}
