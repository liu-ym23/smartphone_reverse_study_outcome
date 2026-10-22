package com.larus.bmhome.chat.list.cell.record;

import com.larus.common_ui.dialog.p0;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class i implements p0 {
    public final /* synthetic */ RecordCardCell a;

    public final void confirm() {
        RecordCardCell r0 = this.a;
        Map r1 = RecordCardCell.m;
        r0.i.a("click record card confirm");
    }

    public i(RecordCardCell r1) {
        this.a = r1;
    }
}
