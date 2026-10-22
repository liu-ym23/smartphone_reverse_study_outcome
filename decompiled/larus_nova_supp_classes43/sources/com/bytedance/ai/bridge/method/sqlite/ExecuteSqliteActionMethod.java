package com.bytedance.ai.bridge.method.sqlite;

import android.content.Context;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.sqliteop.AbsExecuteSqliteActionMethodIDL;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Applet;
import d3.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J&\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ai/bridge/method/sqlite/ExecuteSqliteActionMethod;", "Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL$ExecuteSqliteActionParamsModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/sqliteop/AbsExecuteSqliteActionMethodIDL$ExecuteSqliteActionResultModel;", "doActon", "appletId", "", "handleAppletIsNull", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExecuteSqliteActionMethod extends AbsExecuteSqliteActionMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public ExecuteSqliteActionMethod() {
    }

    public static void b(String r10, AbsExecuteSqliteActionMethodIDL.a r11, f3.h r12) {
        Context r0 = f2.k.a();     // Catch: Exception -> L4
        SqliteActionManager.a.getClass();     // Catch: Exception -> L4
        SqliteActionManager.a(r0, r10, r11, r12);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r13 = "Exception is ExecuteSqliteActionMethod: " + e.getMessage();
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", r13);
        f3.h.a.a(r12, r13, null, null, 14);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, final f3.h r12) {
        final AbsExecuteSqliteActionMethodIDL.a r13 = (AbsExecuteSqliteActionMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        AppletRuntime r0 = (AppletRuntime) r10.d(AppletRuntime.class);
        if (r0 == null) goto L7;
        Applet r1 = r0.h;
        if (r1 == null) goto L7;
        String r14 = r1.K;
    L8:
        if (r14 != null) goto L10;
    L13:
        boolean r15 = true;
    L14:
        if (r15 == false) goto L19;
        z r16 = (z) r10.d(z.class);
        if (r16 == null) goto L18;
        r16.a(new h(this, r12, r13));
        return;
    L18:
        com.bytedance.ai.utils.g.a.e("ExecuteSqliteActionMethod", "This method is only allowed to be called by applet");
        f3.h.a.a(r12, "This method is only allowed to be called by applet", null, null, 14);
        return;
    L19:
        b(r14, r13, r12);
        return;
    L10:
        if (r14.length() == 0) goto L13;
        r15 = false;
    L7:
        r14 = null;
        goto L8
    }
}
