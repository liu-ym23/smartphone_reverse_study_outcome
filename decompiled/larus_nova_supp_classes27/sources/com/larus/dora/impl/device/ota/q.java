package com.larus.dora.impl.device.ota;

import com.larus.common_ui.dialog.p0;
import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class q implements p0 {
    public q() {
    }

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        int r0 = j49.a.a;
        DoraBuryPointManager.a.L("dora_floating_window_click", MapsKt.mapOf(TuplesKt.to("window_content_type", "firmware_update_block_popup_batt")));
    }
}
