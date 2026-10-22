package com.obric.aikernel.middleware.api.appcontext.receiver;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f4531a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f4532b = null;

    public static final class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "intent");
            AIKLog r12 = AIKLog.INSTANCE;
            r12.d("MonitorAppDataRemovedManager", "app data cleared " + r11);
            if (Intrinsics.areEqual(r11.getAction(), "android.intent.action.PACKAGE_DATA_CLEARED") == false) goto L12;
            Uri r13 = r11.getData();
            if (r13 == null) goto L7;
            String r14 = r13.getSchemeSpecificPart();
        L8:
            r12.d("MonitorAppDataRemovedManager", "app " + r14 + " data cleared");
            if (Intrinsics.areEqual(r14, AppContext.INSTANCE.getPackageName()) == false) goto L13;
            r12.d("MonitorAppDataRemovedManager", "AIK data cleared, kill process");
            Process.killProcess(Process.myPid());
            return;
        L13:
            return;
        L7:
            r14 = null;
            goto L8
        }
    }

    static {
        f4531a = new b();
        f4532b = new a();
    }

    private b() {
    }

    @SuppressLint({"WrongConstant"})
    public final void a() {
        AIKLog.INSTANCE.d("MonitorAppDataRemovedManager", "start register app data cleared listener");
        IntentFilter r10 = new IntentFilter("android.intent.action.PACKAGE_DATA_CLEARED");
        r10.addDataScheme("package");
        ContextCompat.registerReceiver(AppContext.INSTANCE.getContext(), f4532b, r10, 2);
    }
}
