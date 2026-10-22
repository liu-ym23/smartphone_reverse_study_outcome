package com.ss.android.lark.framework.assembly.rust;

import com.bytedance.lark.rustclient.internal.DefaultRustClientDefinition;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.statistics.Statistics;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class n extends DefaultRustClientDefinition {
    public final e5c.b d;

    public final boolean b() {
        return DevEnvUtil.isDevelopPackage(com.larksuite.framework.utils.b.a);
    }

    public final String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
        return f0.a(r2);
    }

    public final void c(JSONObject r4) {
        Intrinsics.checkNotNullParameter("lark_rust_ffi_userid_check_dev", "eventName");
        Intrinsics.checkNotNullParameter(r4, "eventParams");
        this.d.a(com.larksuite.framework.utils.b.a);
        Statistics.sendEvent("lark_rust_ffi_userid_check_dev", r4);
    }

    @Inject
    public n(e5c.b r2, Set<com.bytedance.lark.rustclient.api.o> r3) {
        Intrinsics.checkNotNullParameter(r2, "simpleMode");
        Intrinsics.checkNotNullParameter(r3, "asyncCallbackExecutorGroups");
        super(r3);
        this.d = r2;
    }
}
