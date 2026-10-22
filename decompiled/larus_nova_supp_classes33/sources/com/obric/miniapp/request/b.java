package com.obric.miniapp.request;

import android.os.Bundle;
import com.larus.home.api.main.IPrivacyService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    static {
    }

    public static Bundle a(Bundle r14) {
        Intrinsics.checkNotNullParameter(r14, "args");
        String r1 = r14.getString("action");
        boolean r6 = false;
        if (Intrinsics.areEqual(r1, "create_calendar") == false) goto L25;
        c r2 = new c();
        Intrinsics.checkNotNullParameter(r14, "args");
        String r0 = r14.getString("target");
        if (r0 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        FLogger.a.e("NewMemoryRequest", "invalid target");
        return null;
    L13:
        String r4 = r14.getString("sourceAppPackage");
        if (r4 == null) goto L23;
        IPrivacyService r5 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);
        if (r5 != null) goto L18;
    L20:
        if (r6 == false) goto L23;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new NewMemoryRequest$handle$1$1(r4, null), 3, null);
        goto L23
    L18:
        if (r5.a() != true) goto L20;
        r6 = true;
    L23:
        return (Bundle) BuildersKt.runBlocking$default(null, new NewMemoryRequest$handle$2(r0, r2, r14.getString("payload"), null), 1, null);
    L7:
        if (r0.length() == 0) goto L10;
        r3 = false;
        goto L11
    L25:
        if (Intrinsics.areEqual(r1, "query_auto_import_settings") == false) goto L36;
        i r7 = new i();
        Intrinsics.checkNotNullParameter(r14, "args");
        String r15 = r14.getString("target");
        if (r15 != null) goto L29;
    L30:
        r6 = true;
    L31:
        if (r6 == false) goto L34;
        FLogger.a.e("QueryImportSettingsRequest", "invalid target");
        return null;
    L34:
        return (Bundle) BuildersKt.runBlocking$default(null, new QueryImportSettingsRequest$handle$1(r15, r7, null), 1, null);
    L29:
        if (r15.length() != 0) goto L31;
    L36:
        if (Intrinsics.areEqual(r1, "query_day_type") == false) goto L46;
        g r8 = new g();
        Intrinsics.checkNotNullParameter(r14, "args");
        String r9 = r14.getString("target");
        if (r9 != null) goto L40;
    L41:
        r6 = true;
    L42:
        if (r6 == false) goto L45;
        FLogger.a.e("queryHolidays", "invalid target");
        return null;
    L45:
        return (Bundle) BuildersKt.runBlocking$default(null, new QueryDayTypeRequest$handle$1(r14, r9, r8, null), 1, null);
    L40:
        if (r9.length() != 0) goto L42;
    L46:
        FLogger.a.e("MiniAppRequestHandler", "invalid action");
        return null;
    }
}
