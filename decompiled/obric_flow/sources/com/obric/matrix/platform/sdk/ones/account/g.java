package com.obric.matrix.platform.sdk.ones.account;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements ServiceConnection {
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r5, IBinder r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_SERVICE);
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter("onServiceConnected: ", "msg");
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter("onServiceConnected: ", "msg");
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter("onServiceConnected: ", "msg");
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter("onServiceConnected: ", "msg");
        AtomicBoolean r11 = h.f11894a;
        int r12 = c.f11887a;
        if (r10 == null) goto L13;
        IInterface r13 = r10.queryLocalInterface("com.obric.matrix.platform.sdk.ones.account.IAccountService");
        if (r13 != null) goto L8;
        return;
    L8:
        if ((r13 instanceof d) == false) goto L12;
        d r14 = (d) r13;
        return;
    L12:
        return;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r10) {
        Intrinsics.checkNotNullParameter(r10, "name");
        String r11 = "onServiceDisconnected: name=" + r10;
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        AtomicBoolean r12 = h.f11894a;
        if (h.f11894a.get() == false) goto L12;
    L6:
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter("startBindService: ", "msg");
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter("startBindService: ", "msg");
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter("startBindService: ", "msg");
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter("startBindService: ", "msg");
        Intent r13 = new Intent();
        r13.setClassName("com.obric.matrix", "com.obric.matrix.account.service.OAccountService");
        if (((Application) a.f11886a.getValue()).getApplicationContext().bindService(r13, h.d, 1) == true) goto L14;
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter("startBindService: failed", "msg");
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter("startBindService: failed", "msg");
        Intrinsics.checkNotNullParameter("AccountSDK_OAccount", "tag");
        Intrinsics.checkNotNullParameter("startBindService: failed", "msg");
        com.lynx.jsbridge.a.r("AccountSDK_OAccount", "startBindService: failed");
        return;
    L14:
        return;
    L12:
        h.f11895b.await(WsConstants.EXIT_DELAY_TIME, TimeUnit.MILLISECONDS);     // Catch: Exception -> L10
    L11:
        throw new AccountException(PointerIconCompat.TYPE_HAND, "account init timeout", null, 4, null);
    }
}
