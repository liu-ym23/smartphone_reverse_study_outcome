package com.obric.miniapp.aibridge;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/obric/miniapp/aibridge/OpenMemoryDetailMethod;", "Lcom/obric/miniapp/aibridge/AbsOpenMemoryDetailMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsOpenMemoryDetailMethodIDL$CheckMemoryExistParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsOpenMemoryDetailMethodIDL$CheckMemoryExistResultModel;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenMemoryDetailMethod extends AbsOpenMemoryDetailMethodIDL {

    public static final class a {
    }

    static {
    }

    public OpenMemoryDetailMethod() {
    }

    public final void handle(e3.d r7, ParamModel r8, f3.h r9) {
        AbsOpenMemoryDetailMethodIDL.a r10 = (AbsOpenMemoryDetailMethodIDL.a) r8;
        Intrinsics.checkNotNullParameter(r7, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "callback");
        ContentResolver r0 = AppHost.a.getApplication().getContentResolver();     // Catch: Exception -> L15
        Uri r1 = UriProtector.parse("content://com.obric.memorydata.memory.provider");     // Catch: Exception -> L15
        Bundle r3 = new Bundle();     // Catch: Exception -> L15
        r3.putString("uuid", r10.getMemoryUuid());     // Catch: Exception -> L15
        r3.putInt("entityType", r10.getEntityType());     // Catch: Exception -> L15
        Unit r11 = Unit.INSTANCE;     // Catch: Exception -> L15
        Bundle r12 = r0.call(r1, "openMemoryDetail", null, r3);     // Catch: Exception -> L15
        int r2 = 1;
        if (r12 != null) goto L6;
    L8:
        boolean r13 = false;
    L9:
        Intrinsics.checkNotNullParameter(AbsOpenMemoryDetailMethodIDL.b.class, "<this>");     // Catch: Exception -> L15
        AbsOpenMemoryDetailMethodIDL.b r4 = k3.c.a(AbsOpenMemoryDetailMethodIDL.b.class);     // Catch: Exception -> L15
        AbsOpenMemoryDetailMethodIDL.b r5 = r4;     // Catch: Exception -> L15
        if (r13 == true) goto L13;
        r2 = 0;
    L13:
        r5.setResult(r2);     // Catch: Exception -> L15
        r9.b(r4, "");     // Catch: Exception -> L15
        return;
    L6:
        if (r12.getBoolean(WindowEvent.Params.RESULT, false) != true) goto L8;
        r13 = true;
    L15:
        e = move-exception;
        f3.h.a.a(r9, "OpenMemoryDetailMethod error: " + e.getMessage(), null, null, 14);
    }
}
