package com.larus.xbridge.custom;

import com.google.gson.Gson;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.mainbot.api.IFlowMainBot;
import com.larus.mainbot.api.miniartifact.MiniArtifactInputContent;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.getMiniArtifactInputContent";
    }

    public o() {
    }

    public final void a(dx7.b r7, ux7.d.d r8, IvyBridgePlatformType r9) {
        Intrinsics.checkNotNullParameter(r7, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r8, "callback");
        Intrinsics.checkNotNullParameter(r9, "type");
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L14
        String r11 = r7.getString("mini_artifact_user_input_info_id");     // Catch: Throwable -> L14
        MiniArtifactInputContent r12 = IFlowMainBot.a.i8(r11);     // Catch: Throwable -> L14
        if (r12 != null) goto L7;
        LinkedHashMap r3 = new LinkedHashMap();     // Catch: Throwable -> L14
        r3.put(LynxResourceModule.CODE_KEY, 0);     // Catch: Throwable -> L14
        r3.put("msg", "input info is null");     // Catch: Throwable -> L14
        r8.invoke(r3);     // Catch: Throwable -> L14
    L8:
        FLogger r13 = FLogger.a;     // Catch: Throwable -> L14
        StringBuilder r2 = new StringBuilder("app.getMiniArtifactInputContent id = ");     // Catch: Throwable -> L14
        r2.append(r11);     // Catch: Throwable -> L14
        r2.append(" content = ");     // Catch: Throwable -> L14
        if (r12 == null) goto L11;
        String r14 = r12.getContent();     // Catch: Throwable -> L14
    L12:
        r2.append(r14);     // Catch: Throwable -> L14
        r13.i("AppGetMiniArtifactUserInputMethod", r2.toString());     // Catch: Throwable -> L14
        Object r15 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L22;
        FLogger.a.e("AppGetMiniArtifactUserInputMethod", "app.getMiniArtifactInputContent error = " + r16);
        return;
    L22:
        return;
    L11:
        r14 = null;
        goto L12
    L7:
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Throwable -> L14
        r4.put(LynxResourceModule.CODE_KEY, 1);     // Catch: Throwable -> L14
        r4.put(LynxResourceModule.DATA_KEY, new JSONObject(new Gson().toJson(r12)));     // Catch: Throwable -> L14
        r8.invoke(r4);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    }
}
