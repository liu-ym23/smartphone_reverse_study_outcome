package com.larus.cdm.impl;

import android.content.Context;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import com.larus.dora.impl.alive.DoraKeepAliveViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import oy8.e;
import py8.b;
import py8.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class FlowCompanionDeviceAssociatorImpl implements e {
    public final Context a;
    public final Fragment b;
    public final ActivityResultLauncher<IntentSenderRequest> c;
    public boolean d;
    public final FlowCompanionDeviceAssociatorImpl$resultCallback$1 e;

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.activity.result.ActivityResultCallback, com.larus.cdm.impl.FlowCompanionDeviceAssociatorImpl$resultCallback$1] */
    public FlowCompanionDeviceAssociatorImpl(Fragment r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        ?? r0 = new FlowCompanionDeviceAssociatorImpl$resultCallback$1();
        this.e = r0;
        this.a = r3.requireContext();
        this.b = r3;
        this.c = r3.registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), r0);
    }

    @Override // oy8.e
    public final void a(String r4, String r5, DoraKeepAliveViewModel.b r6) {
        Intrinsics.checkNotNullParameter(r4, "macAddress");
        Intrinsics.checkNotNullParameter(r5, "sn");
        b r0 = h.a(this.a);
        if (r0.b(r4) == false) goto L7;
        r6.c(r4);
        return;
    L7:
        if (this.d == false) goto L10;
        FLogger.a.w("flow_cdm", "Association already in progress.");
        return;
    L10:
        this.d = true;
        r0.c(r4, new FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1(this, r6, r4, r5));     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        FLogger.a.e("flow_cdm", "Error initiating association", e);
        this.d = false;
        r6.a("Initiation error: " + e.getMessage());
    }
}
