package com.bytedance.android.live.liveinteract.jsbridge.method;

import com.bytedance.android.live.browser.jsbridge.base.LiveCloudCollaborateActionResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import w20.m2;
import w20.na;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0 extends m2<na, LiveCloudCollaborateActionResultModel> {
    public e0() {
    }

    public final void invoke(Object r4, CallContext r5) {
        na r6 = (na) r4;
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r7 = r6.getType();
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        JsonObject r8 = r6.a();
        if (r8 == null) goto L12;
        JsonElement r9 = r8.get("is_accept");
        if (r9 == null) goto L12;
        boolean r1 = true;
        if (r9.getAsBoolean() != true) goto L12;
    L13:
        ALogger.i("LiveCloudCollaborateActionMethod", "type = " + r7 + ", is_accept=" + r1);
        if (Intrinsics.areEqual(r7, "acceptCloudCollaborateInvite") == false) goto L20;
        IInteractService r10 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r10 == null) goto L20;
        z30.b r11 = r10.getCloudGroupLiveService();
        if (r11 == null) goto L20;
        r11.a(r1, "");
    L20:
        LiveCloudCollaborateActionResultModel r12 = new LiveCloudCollaborateActionResultModel();
        r12.a(LiveCloudCollaborateActionResultModel.Code.Success);
        Unit r13 = Unit.INSTANCE;
        finishWithResult(r12);
        return;
    L12:
        r1 = false;
        goto L13
    }
}
