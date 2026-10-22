package com.suite.lark.platform.component.cta;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final void a(Activity r8, LifecycleOwner r9, String r10, String r11, String r12, String r13, goc.a r14) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r10, "featureKey");
        Intrinsics.checkNotNullParameter(r11, "scene");
        Intrinsics.checkNotNullParameter(r12, "checkpointTenantId");
        Intrinsics.checkNotNullParameter(r13, "checkpointUserId");
        b r1 = new b(r10, r11, r12, r13);
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "lifecycleOwner");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r9), null, null, new CTADialogPresenter$fetchStuckSpotAndShowDialog$1(r1, r14, r8, null), 3, null);
    }

    public static /* synthetic */ void b(Activity r9, LifecycleOwner r10, String r11, String r12, String r13, String r14, int r15) {
        if ((r15 & 16) == 0) goto L5;
        String r6 = "0";
    L7:
        if ((r15 & 32) == 0) goto L9;
        String r7 = "0";
    L10:
        a(r9, r10, r11, r12, r6, r7, null);
        return;
    L9:
        r7 = r14;
        goto L10
    L5:
        r6 = r13;
        goto L7
    }
}
