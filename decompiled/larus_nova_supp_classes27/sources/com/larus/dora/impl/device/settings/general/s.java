package com.larus.dora.impl.device.settings.general;

import com.larus.common_ui.dialog.p0;
import com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class s implements p0 {
    public final /* synthetic */ GeneralSettingsFragment a;

    @Override // com.larus.common_ui.dialog.p0
    public final void confirm() {
        QuickNoteRepo r0 = QuickNoteRepo.a;
        final GeneralSettingsFragment r1 = this.a;
        Function0 r2 = new r(r1);
        r0.getClass();
        QuickNoteRepo.i(r2);
    }

    public s(GeneralSettingsFragment r1) {
        this.a = r1;
    }
}
