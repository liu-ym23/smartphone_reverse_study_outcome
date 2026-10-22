package com.larus.asr;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ChatBottomSpeakerComponent$g implements com.larus.platform.api.g1.c {
    public final /* synthetic */ Function2<Boolean, Boolean, Unit> a;
    public final /* synthetic */ ChatBottomSpeakerComponent b;

    public final void onGoSettingsDialogDismiss(boolean r1) {
    }

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChatBottomSpeakerComponent$g(Function2<? super Boolean, ? super Boolean, Unit> r1, ChatBottomSpeakerComponent r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "grantedList");
        Intrinsics.checkNotNullParameter(r3, "deniedList");
        this.a.invoke(Boolean.valueOf(r1), Boolean.TRUE);
        com.larus.bmhome.instruction.g r5 = this.b.vc();
        if (r5 == null) goto L6;
        r5.Ot();
        return;
    }
}
