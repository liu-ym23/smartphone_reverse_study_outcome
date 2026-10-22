package com.larus.xbridge.custom;

import com.google.gson.Gson;
import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.mainbot.api.IFlowMainBot;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class w1 extends bx7.c {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "app.readyForMiniArtifactProductFinished";
    }

    public w1() {
    }

    public final void a(dx7.b r6, ux7.d.d r7, IvyBridgePlatformType r8) {
        Intrinsics.checkNotNullParameter(r6, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r7, "callback");
        Intrinsics.checkNotNullParameter(r8, "type");
        int r9 = r6.getInt(LynxResourceModule.CODE_KEY);
        String r0 = r6.getString("mini_artifact_title");
        String r1 = r6.getString("mini_artifact_id");
        String r10 = r6.getString("track_params");
        Map r11 = (Map) new Gson().fromJson(r10, new x1().getType());     // Catch: Exception -> L5
    L6:
        IFlowMainBot r2 = (IFlowMainBot) ServiceManager.get().getService(IFlowMainBot.class);
        if (r2 == null) goto L9;
        r2.a(new ik9.d(r0, r1, r11));
    L9:
        FLogger.a.i("ReadyForMiniArtifactProductFinishedMethod", "ReadyForMiniArtifactProductFinishedMethod, code: " + r9 + ", title: " + r0 + ", artifactId: " + r1 + ", eventMap: " + r11);
        bx7.c.d(this, r7, new LinkedHashMap());
        return;
    L5:
        r11 = null;
        goto L6
    }
}
