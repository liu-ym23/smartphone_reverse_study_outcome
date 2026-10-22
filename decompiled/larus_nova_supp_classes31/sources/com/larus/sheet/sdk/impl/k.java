package com.larus.sheet.sdk.impl;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.larus.office.OfficeInputParam;
import com.larus.office.w;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k implements hk5.a {
    public final /* synthetic */ an9.a a;
    public final /* synthetic */ com.larus.office.h b;
    public final /* synthetic */ OfficeInputParam c;

    public final void onOpenFailedBeforeHost() {
    }

    public final void onAttachToHost(PluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginHost");
        w r0 = new w();
        r0.a = this.c;
        r3.registerHostAbility(r0);
        r3.registerHostAbility(this.a);
        r3.registerHostAbility(this.b);
    }

    public k(an9.a r1, com.larus.office.h r2, OfficeInputParam r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
