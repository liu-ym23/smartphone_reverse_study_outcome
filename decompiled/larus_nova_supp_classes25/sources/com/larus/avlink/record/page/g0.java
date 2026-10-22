package com.larus.avlink.record.page;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g0 implements com.larus.common_ui.dialog.p0 {
    public final /* synthetic */ RecordMinutesFragment a;
    public final /* synthetic */ i0 b;

    public final void confirm() {
        RecordMinutesFragment r0 = this.a;
        int r1 = RecordMinutesFragment.n;
        r0.U90().deleteRecordItem(Action.DELETE, this.b);
    }

    public g0(RecordMinutesFragment r1, i0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
