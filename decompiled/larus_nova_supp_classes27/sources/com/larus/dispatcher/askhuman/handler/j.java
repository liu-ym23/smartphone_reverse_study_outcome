package com.larus.dispatcher.askhuman.handler;

import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.platform.service.p1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j {
    public static final boolean a(bs8.h r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (p1.a.localPcUnavailableInteractionFallbackEnabled() == true) goto L5;
        return false;
    L5:
        GetAllDevicesRepo r0 = GetAllDevicesRepo.a;
        com.larus.bmhome.taskskill.view.b r4 = com.larus.bmhome.taskskill.view.d.a(r3, GetAllDevicesRepo.d(), null);
        if (r4 != null) goto L9;
        return false;
    L9:
        return !(r4 instanceof com.larus.bmhome.taskskill.view.b.a);
    }
}
