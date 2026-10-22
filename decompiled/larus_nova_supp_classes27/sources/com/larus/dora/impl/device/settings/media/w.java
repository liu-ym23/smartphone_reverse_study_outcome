package com.larus.dora.impl.device.settings.media;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class w implements com.larus.common_ui.dialog.u {
    public final /* synthetic */ MediaSettingsFragment a;

    @Override // com.larus.common_ui.dialog.u
    public final void cancel() {
        g49.d.d("MediaSettingsFragment", "record location dialog cancel");
        MediaSettingsFragment r0 = this.a;
        int r1 = MediaSettingsFragment.h;
        r0.Z90().onRecordLocationAlwaysAllowDialogCancel();
    }

    public w(MediaSettingsFragment r1) {
        this.a = r1;
    }
}
