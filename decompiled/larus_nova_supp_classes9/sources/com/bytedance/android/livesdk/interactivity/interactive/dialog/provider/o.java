package com.bytedance.android.livesdk.interactivity.interactive.dialog.provider;

import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements VSInputPanelSectionContainer.b {
    public final /* synthetic */ j.b a;

    public o(j.b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputPanelSectionContainer.b
    public final void a(VSInputSectionType r2, VSInputSectionType r3) {
        Intrinsics.checkNotNullParameter(r2, "previousType");
        Intrinsics.checkNotNullParameter(r3, "currentSectionType");
        this.a.c(r3);
    }
}
