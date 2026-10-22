package com.obric.datatransfer.client;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.UserManager;
import com.bytedance.common.utility.device.SystemPropertiesUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.obric.datatransfer.logger.TransferLogger;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b {
    public static final /* synthetic */ int d = 0;
    public final Context a;
    public final String b;
    public final TransferLogger c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.datatransfer.client.b$b, reason: collision with other inner class name */
    public interface InterfaceC0039b {
        void onComplete(int r1, int r2);

        void onProgress(int r1, int r2);
    }

    static {
    }

    public final void b() {
        int r0 = 0;
    L4:
        if (r0 >= 30) goto L20;
        r0 = r0 + 1;
        TransferLogger.c(this.c, "Waiting for sys.boot_completed...");
        String r1 = SystemPropertiesUtils.getSystemProperty("sys.boot_completed");     // Catch: Exception -> L18
        if (r1 == null) goto L20;
        if (Intrinsics.areEqual(r1, "1") == true) goto L11;
        Thread.sleep(1000);     // Catch: InterruptedException -> L16
    L16:
        e = move-exception;
        this.c.d("Interrupted while waiting for boot completed", e);
        goto L20
    L11:
        TransferLogger.c(this.c, "sys.boot_completed is 1");     // Catch: Exception -> L18
    L18:
        e = move-exception;
        this.c.b("Failed to get sys.boot_completed", e);
    L20:
        TransferLogger.c(this.c, "Boot completed after " + r0 + " retries");
    }

    public final void c() {
        UserManager r0 = (UserManager) this.a.getSystemService(UserManager.class);
        int r1 = 0;
    L4:
        if (r0.isUserUnlocked() == true) goto L12;
        if (r1 >= 30) goto L12;
        r1 = r1 + 1;
        TransferLogger.c(this.c, "Waiting for user unlock...");
        Thread.sleep(1000);     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        this.c.d("Interrupted while waiting for user unlock", e);
    L12:
        TransferLogger.c(this.c, "User unlocked, CE storage available after " + r1 + " retries");
    }

    public b(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "authority");
        this.a = r2;
        this.b = r3;
        com.obric.datatransfer.logger.a r4 = TransferLogger.b;
        this.c = TransferLogger.a.a("DataTransferClient");
    }

    public static ParcelFileDescriptor a(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r10;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r20, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r20, r21, "r");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }
}
