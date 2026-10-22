package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.service.IPcDevicePanelService;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class SkillComponent$j implements IPcDevicePanelService.a {
    public final /* synthetic */ SkillComponent a;

    @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService.a
    public final void a() {
        FLogger.a.i("SkillComponent", "[openDevicePanel] panel closed");
    }

    @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService.a
    public final void c() {
        this.a.R4(null);
    }

    public SkillComponent$j(SkillComponent r1) {
        this.a = r1;
    }

    @Override // com.larus.bmhome.taskskill.service.IPcDevicePanelService.a
    public final void b(be8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "device");
        this.a.R4(r2);
    }
}
