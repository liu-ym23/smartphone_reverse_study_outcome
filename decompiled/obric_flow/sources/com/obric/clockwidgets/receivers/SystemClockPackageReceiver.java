package com.obric.clockwidgets.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.material.internal.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/clockwidgets/receivers/SystemClockPackageReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "clockwidgets_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SystemClockPackageReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f11264b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f11265a;

    public SystemClockPackageReceiver() {
        this.f11265a = new Handler(Looper.getMainLooper());
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r5, Intent r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r10, "intent");
        Uri r11 = r10.getData();
        if (r11 == null) goto L5;
        String r12 = r11.getSchemeSpecificPart();
    L6:
        if (r12 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r12, "com.obric.clock") == true) goto L11;
        return;
    L11:
        String r13 = r10.getAction();
        if (r13 != null) goto L14;
        return;
    L14:
        BroadcastReceiver.PendingResult r14 = goAsync();
        boolean r15 = false;
        boolean r16 = r10.getBooleanExtra("android.intent.extra.REPLACING", false);
        switch(r13.hashCode()) {
            case 172491798: goto L30;
            case 525384130: goto L25;
            case 1544582882: goto L21;
            case 1580442797: goto L18;
            default: goto L31;
        };
    L31:
        r14.finish();
        return;
    L18:
        if (r13.equals("android.intent.action.PACKAGE_FULLY_REMOVED") == false) goto L31;
    L33:
        this.f11265a.post(new b(r15, r14));
        return;
    L21:
        if (r13.equals("android.intent.action.PACKAGE_ADDED") == false) goto L31;
    L23:
        r15 = true;
        goto L33
    L25:
        if (r13.equals("android.intent.action.PACKAGE_REMOVED") == false) goto L31;
        if (r16 == true) goto L33;
    L30:
        if (r13.equals("android.intent.action.PACKAGE_CHANGED") == true) goto L23;
    L5:
        r12 = null;
        goto L6
    }
}
