package com.ss.android.lark.framework.assembly.rust;

import com.ss.android.lark.abtest.api.ABTestExperimentPlugin;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@ABTestExperimentPlugin
public final class a0 implements hua.a {
    public a0() {
    }

    public final String getBizName() {
        return "Rust_Throughput_Performance";
    }

    public final List<iua.a<?>> a() {
        ArrayList r0 = new ArrayList();
        r0.add(new z());
        return r0;
    }
}
