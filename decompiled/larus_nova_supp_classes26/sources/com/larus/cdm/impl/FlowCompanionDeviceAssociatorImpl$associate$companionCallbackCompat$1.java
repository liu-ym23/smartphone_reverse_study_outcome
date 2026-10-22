package com.larus.cdm.impl;

import android.companion.AssociationInfo;
import android.content.IntentSender;
import androidx.activity.result.IntentSenderRequest;
import androidx.lifecycle.Lifecycle;
import com.larus.dora.impl.alive.DoraKeepAliveViewModel;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import oy8.c;
import py8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1 implements a {
    public final /* synthetic */ FlowCompanionDeviceAssociatorImpl a;
    public final /* synthetic */ c b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;

    @Override // py8.a
    public final void a(CharSequence r4) {
        FLogger.a.i("flow_cdm", "[onFailure] " + r4);
        this.a.d = false;
        c r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r4);
        return;
    }

    @Override // py8.a
    public final void b(IntentSender r9) {
        Intrinsics.checkNotNullParameter(r9, "intentSender");
        FLogger r0 = FLogger.a;
        r0.d("flow_cdm", "[onAssociationPending] " + r9);
        final FlowCompanionDeviceAssociatorImpl r1 = this.a;
        FlowCompanionDeviceAssociatorImpl$resultCallback$1 r3 = r1.e;
        final c r5 = this.b;
        final String r6 = this.c;
        final String r7 = this.d;
        r3.a = new FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1$onAssociationPending$1(r1, r5, r6, r7);
        if (r1.b.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r0.w("flow_cdm", "[onAssociationPending] Context not valid to launch.");
        c r10 = this.b;
        if (r10 == null) goto L17;
        r10.a("Lifecycle state is not valid.");
    L17:
        this.a.d = false;
        return;
    L19:
        c r2 = this.b;     // Catch: Throwable -> L9
        if (r2 == null) goto L7;
        r2.b(r9);     // Catch: Throwable -> L9
    L7:
        this.a.c.launch(new IntentSenderRequest.Builder(r9).build());     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        FLogger.a.e("flow_cdm", "[onAssociationPending] Launch failed", th);
        c r4 = this.b;
        if (r4 == null) goto L13;
        r4.a("Launch failed: " + th.getMessage());
    L13:
        this.a.d = false;
    }

    @Override // py8.a
    public final void c(AssociationInfo r4) {
        Intrinsics.checkNotNullParameter(r4, "associationInfo");
        FLogger.a.i("flow_cdm", "[onAssociationCreated] " + r4);
        this.a.d = false;
        c r5 = this.b;
        if (r5 == null) goto L6;
        r5.c(this.c);
        return;
    }

    public FlowCompanionDeviceAssociatorImpl$associate$companionCallbackCompat$1(FlowCompanionDeviceAssociatorImpl r1, DoraKeepAliveViewModel.b r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
