package com.obric.assistant.settings.autogui;

import com.larus.account.base.api.ILoginService;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentSettingsIDL;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a() {
        KClass r0 = Reflection.getOrCreateKotlinClass(IAgentSettingsIDL.class);     // Catch: Exception -> L8 CancellationException -> L12
        int r1 = com.obric.aiagent.assistant.idl.l.a;     // Catch: Exception -> L8 CancellationException -> L12
        Intrinsics.checkNotNullParameter(r0, "<this>");     // Catch: Exception -> L8 CancellationException -> L12
        com.obric.aiagent.ipc.utils.g.a.getClass();     // Catch: Exception -> L8 CancellationException -> L12
        IAgentSettingsIDL r2 = com.obric.aiagent.ipc.utils.g.b(IAgentSettingsIDL.class);     // Catch: Exception -> L8 CancellationException -> L12
        if (r2 == null) goto L10;
    L6:
        if (r2.isAutoGuiInstall() != true) goto L10;
        return true;
    L10:
        return false;
    L12:
        e = move-exception;
        throw e;
    L8:
        e = move-exception;
        FLogger.a.w("AutoGuiSettingsEntryGate", "isAutoGuiInstalled failed. " + e.getMessage(), e);
        goto L10
    }

    public static boolean b() {
        ILoginService r0 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r0 == null) goto L9;
        q38.a r1 = r0.getAccountInfo();
        if (r1 == null) goto L9;
        if (r1.g != true) goto L9;
        return true;
    L9:
        return false;
    }
}
