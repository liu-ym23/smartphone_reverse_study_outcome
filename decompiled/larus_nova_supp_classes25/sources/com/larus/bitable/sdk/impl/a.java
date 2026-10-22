package com.larus.bitable.sdk.impl;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.i;
import com.larus.office.OfficeInputParam;
import com.larus.office.h;
import com.larus.office.w;
import fo9.b;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements hk5.a {
    public final /* synthetic */ b a;
    public final /* synthetic */ h b;
    public final /* synthetic */ OfficeInputParam c;
    public final /* synthetic */ BitableSdkServiceImpl d;

    public final void onOpenFailedBeforeHost() {
    }

    public final void onAttachToHost(PluginHost r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginHost");
        w r0 = new w();
        r0.a = this.c;
        r3.registerHostAbility(r0);
        r3.registerHostAbility(new an9.a(this.a));
        h r1 = this.b;
        if (r1 == null) goto L8;
        BitableSdkServiceImpl r2 = this.d;
        r3.registerHostAbility(r1);
        Iterator<T> r4 = r2.D(r1).iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        r3.registerHostAbility((i) r4.next());
        goto L6
    L10:
        return;
    }

    public a(b r1, h r2, OfficeInputParam r3, BitableSdkServiceImpl r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
