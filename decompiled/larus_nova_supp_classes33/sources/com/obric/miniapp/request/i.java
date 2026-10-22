package com.obric.miniapp.request;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.google.gson.JsonObject;
import d3.w;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class i {
    public int a;

    public static final class a {
    }

    static {
    }

    public i() {
        this.a = 2;
    }

    public static final void a(final i r8, final w r9, final CompletableDeferred r10) {
        r8.getClass();
        r9.c(new ProtocolMessage("applet.queryImportSetting", new JsonObject(), null, new TargetEntity(TargetEntity.Scope.Main, TargetEntity.Target.Self, 4), ProtocolMessage.Type.Call, 36), new QueryImportSettingsRequest$executeFunction$1(r10), new QueryImportSettingsRequest$executeFunction$2(r8, r9, r10), null);
    }
}
