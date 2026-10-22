package com.bytedance.android.live.service;

import com.bytedance.android.live.manager.LivePlatformExpWorkshop;
import com.bytedance.android.live.room.api.experience.service.IPlatformExpService;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/service/PlatformExpService;", "Lcom/bytedance/android/live/room/api/experience/service/IPlatformExpService;", "Ld61/a;", "expCtx", "Lf61/a;", "provideWorkshop", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PlatformExpService implements IPlatformExpService {
    public PlatformExpService() {
        k.l(IPlatformExpService.class, this);
    }

    @Override // com.bytedance.android.live.room.api.experience.service.IPlatformExpService
    public f61.a provideWorkshop(d61.a r2) {
        Intrinsics.checkNotNullParameter(r2, "expCtx");
        return new LivePlatformExpWorkshop(r2);
    }
}
