package com.larus.voice_setting.voice.dialog;

import com.larus.voice_setting.impl.databinding.LarusDialogOptUserVoiceInfoBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z0 implements com.larus.common_ui.dialog.y0 {
    public final /* synthetic */ LarusDialogOptUserVoiceInfoBinding a;
    public final /* synthetic */ UgcVoiceInfoOptimizeDialog b;

    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.a.n.setText(r2);
        UgcVoiceInfoOptimizeDialog r0 = this.b;
        r0.n = r2;
        if (r0.i == true) goto L5;
        return;
    L5:
        if (r0.q == true) goto L9;
        r0.U90(true);
        this.b.i = false;
        return;
    }

    public z0(LarusDialogOptUserVoiceInfoBinding r1, UgcVoiceInfoOptimizeDialog r2) {
        this.a = r1;
        this.b = r2;
    }
}
