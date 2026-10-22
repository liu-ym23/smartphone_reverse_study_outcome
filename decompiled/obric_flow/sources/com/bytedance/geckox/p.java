package com.bytedance.geckox;

import android.os.Handler;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.keva.Keva;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f4771a = null;

    static {
        f4771a = new ArrayList();
    }

    public static String a(String r5, String r10, String r11) {
        if (StringsKt.k(r11, ".gkfsf") == false) goto L6;
    L12:
        return r11;
    L6:
        if (c(r5, r10) == false) goto L12;
        if (com.bytedance.gkfs.storage.d.f4923c.get() == true) goto L12;
        return io.reactivex.internal.observers.h.b(r11, ".gkfsf");
    }

    public static void b(Function0 r5) {
        if (d() == true) goto L6;
        return;
    L6:
        if (com.bytedance.gkfs.a.f4812c.get() == true) goto L8;
        return;
    L8:
        Keva r10 = Keva.getRepo("gkfs_clean", 1);
        monitor-enter(r10);
        String r11 = r10.getStringJustDisk("is_cleaned_3470", "0");     // Catch: Throwable -> L23
        if (r11 == null) goto L36;
        int r12 = r11.hashCode();     // Catch: Throwable -> L23
        if (r12 == 49) goto L26;
        if (r12 != 50) goto L36;
        if (r11.equals("2") == false) goto L36;
        r5.invoke();     // Catch: Throwable -> L23
        monitor-exit(r10);
        return;
    L26:
        if (r11.equals(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L36;
        ArrayList r13 = f4771a;     // Catch: Throwable -> L23
        monitor-enter(r13);     // Catch: Throwable -> L23
        r13.add(r5);     // Catch: Throwable -> L33
        monitor-exit(r13);     // Catch: Throwable -> L23
        monitor-exit(r10);
        return;
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L36:
        r10.storeStringJustDisk("is_cleaned_3470", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Throwable -> L23
        ArrayList r14 = f4771a;     // Catch: Throwable -> L23
        monitor-enter(r14);     // Catch: Throwable -> L23
        r14.add(r5);     // Catch: Throwable -> L43
        monitor-exit(r14);     // Catch: Throwable -> L23
        monitor-exit(r10);
        o r15 = new o(r10, 0);
        ((Handler) com.bytedance.gkfs.c.f4815b.getValue()).post(r15);
        return;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public static boolean c(String r5, String r10) {
        if (d() == true) goto L5;
        return false;
    L5:
        c r11 = b.f4736a;
        AppSettingsManager$IGeckoAppSettings r12 = r11.a();
        if (r12 == null) goto L9;
        r11.d = r12.getGkFSTestChannels();
    L9:
        if (((Map) r11.d) != null) goto L11;
        GeckoLogger.a("getGkFSTestChannels: null");
    L11:
        Map r13 = (Map) r11.d;
        if (r13 == null) goto L20;
        List r14 = (List) r13.get(r5);
        if (r14 == null) goto L16;
        Boolean r15 = Boolean.valueOf(r14.contains(r10));
    L17:
        if (r15 == null) goto L20;
        return r15.booleanValue();
    L16:
        r15 = null;
    L20:
        return false;
    }

    public static boolean d() {
        c r5 = b.f4736a;
        AppSettingsManager$IGeckoAppSettings r10 = r5.a();
        if (r10 == null) goto L5;
        r5.f4740a = r10.isGkFSEnable();
    L5:
        GeckoLogger.a("getGkFSEnable: " + r5.f4740a);
        return r5.f4740a;
    }
}
