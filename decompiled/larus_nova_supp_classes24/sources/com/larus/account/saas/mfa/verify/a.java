package com.larus.account.saas.mfa.verify;

import com.larus.home.impl.sdk.b;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public static final CoroutineScope a = null;

    static {
        a = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static void a(b r9) {
        Intrinsics.checkNotNullParameter("flow_mfa_remote_connect_pc", "scene");
        Intrinsics.checkNotNullParameter("flow_mfa_template_common", "template");
        Intrinsics.checkNotNullParameter(r9, "callback");
        BuildersKt.launch$default(a, null, null, new MfaVerifyManager$startVerify$1("flow_mfa_remote_connect_pc", "flow_mfa_template_common", r9, null), 3, null);
    }
}
