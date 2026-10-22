package com.larus.xbridge.custom;

import com.ivy.ivykit.api.bridge.core.model.IvyBridgePlatformType;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.miui.easygo.constant.EasyGoDbTable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class s0 extends bx7.c {
    public final String b;

    public static final class a {
    }

    static {
    }

    public abstract Map<String, Object> f(cx7.d r1);

    public s0() {
        Intrinsics.checkNotNullParameter("biz.util.getAuthHeader", EasyGoDbTable.Server.NAME);
        this.b = "biz.util.getAuthHeader";
    }

    public final String getName() {
        return this.b;
    }

    public final void a(dx7.b r7, ux7.d.d r8, IvyBridgePlatformType r9) {
        Intrinsics.checkNotNullParameter(r7, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r8, "callback");
        Intrinsics.checkNotNullParameter(r9, "type");
        FLogger.a.i("BizUtilAuthorization", "handle request, method=" + this.b + ", platform=" + r9);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new BizUtilAuthorizationMethod$handle$1(this, r8, r7, null), 3, null);
    }
}
