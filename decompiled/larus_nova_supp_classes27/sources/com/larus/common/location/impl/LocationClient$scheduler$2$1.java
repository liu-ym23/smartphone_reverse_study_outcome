package com.larus.common.location.impl;

import com.larus.platform.model.LocateScene;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class LocationClient$scheduler$2$1 extends FunctionReferenceImpl implements Function2<LocateScene, Boolean, Boolean> {
    public LocationClient$scheduler$2$1(Object r8) {
        super(2, r8, LocationClient.class, "canContinueAutoPoll", "canContinueAutoPoll(Lcom/larus/platform/model/LocateScene;Z)Z", 0);
    }

    public final Boolean invoke(LocateScene r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        Iterator r0 = ((LocationClient) ((CallableReference) this).receiver).g.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Boolean r1 = ((l48.c) r0.next()).a(r3, r4);
        if (r1 == null) goto L4;
        boolean r5 = r1.booleanValue();
    L15:
        return Boolean.valueOf(r5);
    L9:
        if (r3.canTriggerPoll(r4) == true) goto L11;
    L13:
        r5 = false;
        goto L15
    L11:
        if (r3.canTriggerPoll(true) == true) goto L13;
        r5 = true;
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((LocateScene) r1, ((Boolean) r2).booleanValue());
    }
}
