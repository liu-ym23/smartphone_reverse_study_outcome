package com.ss.ugc.live.sdk.msg.unify.business;

import com.ss.ugc.live.sdk.msg.data.SdkResponse;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWEventData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d {
    public final UMGWEventData a;
    public final List<tlc.d> b;
    public final com.ss.ugc.live.sdk.msg.data.c c;
    public final SdkResponse d;

    /* JADX WARN: Multi-variable type inference failed */
    public d(UMGWEventData r2, List<? extends tlc.d> r3, com.ss.ugc.live.sdk.msg.data.c r4, SdkResponse r5) {
        Intrinsics.checkNotNullParameter(r2, "eventData");
        Intrinsics.checkNotNullParameter(r3, "decodeMessage");
        Intrinsics.checkNotNullParameter(r4, "sdkStat");
        Intrinsics.checkNotNullParameter(r5, "response");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
