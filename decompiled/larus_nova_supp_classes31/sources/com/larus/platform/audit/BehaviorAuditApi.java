package com.larus.platform.audit;

import com.larus.platform.service.AccountService;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class BehaviorAuditApi {
    public static final CoroutineScope a = null;

    static {
        a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    @JvmStatic
    public static final void a(a r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (AccountService.a.isEnterpriseAccount() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(a, null, null, new BehaviorAuditApi$report$1(r7, null), 3, null);
    }

    @JvmStatic
    public static final void b(b r7, Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r8, "extras");
        a(new a(BehaviorAuditOperation.COPY, r7, null, r8, 12));
    }

    @JvmStatic
    public static final void c(b r7, Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r7, "fileInfo");
        Intrinsics.checkNotNullParameter(r8, "extras");
        a(new a(BehaviorAuditOperation.DOWNLOAD, r7, null, r8, 12));
    }
}
