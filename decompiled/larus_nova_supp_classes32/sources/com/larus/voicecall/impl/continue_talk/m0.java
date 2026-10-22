package com.larus.voicecall.impl.continue_talk;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m0 implements com.larus.platform.api.g1.c {
    public final /* synthetic */ ChatContinuousTalkComponent a;
    public final /* synthetic */ xa8.e b;

    public final void onGoSettingsDialogDismiss(boolean r1) {
    }

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
    }

    public m0(ChatContinuousTalkComponent r1, xa8.e r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "grantedList");
        Intrinsics.checkNotNullParameter(r3, "deniedList");
        if (r1 == false) goto L5;
        ChatContinuousTalkComponent r5 = this.a;
        xa8.e r6 = this.b;
        int r7 = ChatContinuousTalkComponent.M;
        r5.p3(r6);
        return;
    L5:
        ChatContinuousTalkComponent r8 = this.a;
        int r9 = ChatContinuousTalkComponent.M;
        r8.getClass();
    }
}
