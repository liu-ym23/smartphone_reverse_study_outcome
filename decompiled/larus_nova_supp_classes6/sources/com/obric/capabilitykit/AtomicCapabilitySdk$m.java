package com.obric.capabilitykit;

import android.app.PendingIntent;
import android.content.Intent;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.logger.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import wia.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/capabilitykit/AbstractCapabilityManager;", "it", "", "invoke", "(Lcom/obric/capabilitykit/AbstractCapabilityManager;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class AtomicCapabilitySdk$m extends Lambda implements Function1<n, Unit> {
    public final /* synthetic */ DispatchContext a;
    public final /* synthetic */ Intent b;
    public final /* synthetic */ FloatingIntentParams c;

    public AtomicCapabilitySdk$m(DispatchContext r1, Intent r2, FloatingIntentParams r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        super(1);
    }

    public final void a(n r5) {
        Intrinsics.checkNotNullParameter(r5, "it");
        PendingIntent r6 = AtomicCapabilitySdk.INSTANCE.getFloatingPendingIntentNonBlock(this.a, this.b, this.c);     // Catch: Exception -> L7 PendingIntent.CanceledException -> L9
        if (r6 == null) goto L15;
        r6.send();     // Catch: Exception -> L7 PendingIntent.CanceledException -> L9
    L16:
        return;
    L15:
        return;
    L9:
        e = move-exception;
        Logger r1 = Logger.INSTANCE;
        StringBuilder r2 = new StringBuilder("PendingIntent was canceled: ");
        String r7 = e.getMessage();
    L11:
        r2.append(r7);
        r1.e("AtomicCapabilitySdk", r2.toString());
        return;
    L7:
        e = move-exception;
        r1 = Logger.INSTANCE;
        r2 = new StringBuilder("Error sending PendingIntent: ");
        r7 = e.getMessage();
        goto L11
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        a((n) r1);
        return Unit.INSTANCE;
    }
}
