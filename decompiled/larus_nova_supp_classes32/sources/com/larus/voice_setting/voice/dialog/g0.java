package com.larus.voice_setting.voice.dialog;

import com.larus.voice_setting.impl.databinding.LarusDialogEditUserVoiceInfoBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g0 implements com.larus.common_ui.dialog.y0 {
    public final /* synthetic */ UgcVoiceInfoEditDialog a;
    public final /* synthetic */ LarusDialogEditUserVoiceInfoBinding b;

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "text");
        if (Intrinsics.areEqual(r3, this.a.m) == true) goto L5;
        this.a.q = false;
    L5:
        this.b.k.setText(r3);
        UgcVoiceInfoEditDialog r0 = this.a;
        r0.m = r3;
        if (r0.i == false) goto L9;
        r0.U90(true);
        this.a.i = false;
        return;
    }

    public g0(UgcVoiceInfoEditDialog r1, LarusDialogEditUserVoiceInfoBinding r2) {
        this.a = r1;
        this.b = r2;
    }
}
