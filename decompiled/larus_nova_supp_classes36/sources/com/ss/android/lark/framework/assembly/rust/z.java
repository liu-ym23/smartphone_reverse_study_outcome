package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.utils.ApiUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class z extends iua.a<y> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static y a() {
            return (y) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(z.class, true);
        }
    }

    static {
    }

    public final /* bridge */ /* synthetic */ Object getDefault() {
        return null;
    }

    public final boolean isSticky() {
        return true;
    }

    public final iua.b getLarkExperimentInfo() {
        return new iua.b("rust_throughput_experiment", "adjust Rust network request semaphore && thread core size");
    }

    public z() {
    }
}
