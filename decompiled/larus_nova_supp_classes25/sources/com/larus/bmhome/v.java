package com.larus.bmhome;

import com.larus.platform.api.SocialIMData;
import hza.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class v implements b {
    public final /* synthetic */ Function1<SocialIMData, Unit> a;
    public final /* synthetic */ FlowLarkSocialServiceImpl b;

    public final void a(pza.a r3) {
        Intrinsics.checkNotNullParameter(r3, "item");
        Function1<SocialIMData, Unit> r0 = this.a;
        this.b.getClass();
        r0.invoke(FlowLarkSocialServiceImpl.a(r3));
    }

    public v(com.larus.bmhome.chat.reddot.g r1, FlowLarkSocialServiceImpl r2) {
        this.a = r1;
        this.b = r2;
    }
}
