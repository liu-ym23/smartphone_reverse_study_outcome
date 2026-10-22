package com.larus.dora.impl.device.settings.media;

import com.larus.common_ui.dialog.p0;
import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import com.larus.dora.impl.sysinfo.DoraSystemInfoManager;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class x implements p0 {
    public final /* synthetic */ FlowDoraVideoRecordConfig a;
    public final /* synthetic */ MediaSettingsFragment b;
    public final /* synthetic */ int c;
    public final /* synthetic */ MediaReelDialogFragment d;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        FlowDoraVideoRecordConfig r0 = this.a.a();
        int r1 = this.c;
        r0.a = 180;
        r0.b = r1;
        MediaSettingsFragment r2 = this.b;
        int r3 = MediaSettingsFragment.h;
        r2.Z90().syncVideoRecordCfg(r0);
        DoraSystemInfoManager r4 = DoraSystemInfoManager.a;
        DoraSystemInfoManager.g(180);
        DoraSystemInfoManager.i(this.c);
        this.d.dismissAllowingStateLoss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L12;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public x(FlowDoraVideoRecordConfig r1, MediaSettingsFragment r2, int r3, MediaReelDialogFragment r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
