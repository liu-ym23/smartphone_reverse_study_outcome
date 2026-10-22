package com.obric.capabilitykit;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import com.obric.capabilitykit.entity.EntityContextHolder;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0003J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/capabilitykit/PackageUtils;", "", "()V", "NOVA_PKG_NAME", "", "NOVA_SIGNATURE", "TAG", "checkSignature", "", "callingPkg", "checkSignatureApi28Plus", "checkSignatureLegacy", "isMemoryPackageName", "pkgName", "isPrivilegedApp", "packageName", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class PackageUtils {
    public static final PackageUtils INSTANCE = null;
    public static final String NOVA_PKG_NAME = "com.larus.nova";
    private static final String NOVA_SIGNATURE = "ff04b47ec9dd20b79f758af67a184926db00ac55cfd2a01e03fba9a1dca9de2a";
    private static final String TAG = "PersonalContextPackageUtils";

    static {
        INSTANCE = new PackageUtils();
    }

    private PackageUtils() {
    }

    private final boolean checkSignatureApi28Plus(String r11) {
        SigningInfo r12 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getPackageInfo(r11, 134217728).signingInfo;     // Catch: Exception -> L27
        if (r12 != null) goto L6;
        return false;
    L6:
        Signature[] r13 = r12.getApkContentsSigners();     // Catch: Exception -> L27
        if (r13 == null) goto L26;
        if (r13.length != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L26;
        int r2 = r13.length;     // Catch: Exception -> L27
        int r3 = 0;
    L15:
        if (r3 >= r2) goto L26;
        byte[] r4 = r13[r3].toByteArray();     // Catch: Exception -> L27
        byte[] r5 = MessageDigest.getInstance("SHA-256").digest(r4);     // Catch: Exception -> L27
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L27
        int r7 = r5.length;     // Catch: Exception -> L27
        int r8 = 0;
    L17:
        if (r8 >= r7) goto L23;
        String r9 = Integer.toHexString(r5[r8] & 255);     // Catch: Exception -> L27
        if (r9.length() != 1) goto L21;
        r6.append('0');     // Catch: Exception -> L27
    L21:
        r6.append(r9);     // Catch: Exception -> L27
        r8 = r8 + 1;     // Catch: Exception -> L27
        goto L17
    L23:
        if (Intrinsics.areEqual(r6.toString(), NOVA_SIGNATURE) == true) goto L24;
        r3 = r3 + 1;
        goto L15
    L24:
        return true;
    L11:
        r1 = false;
    L26:
        return false;
    }

    private final boolean checkSignatureLegacy(String r11) {
        Signature[] r12 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getPackageInfo(r11, 64).signatures;     // Catch: Exception -> L24
        if (r12 == null) goto L23;
        if (r12.length != 0) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == true) goto L23;
        int r2 = r12.length;     // Catch: Exception -> L24
        int r3 = 0;
    L12:
        if (r3 >= r2) goto L23;
        byte[] r4 = r12[r3].toByteArray();     // Catch: Exception -> L24
        byte[] r5 = MessageDigest.getInstance("SHA-256").digest(r4);     // Catch: Exception -> L24
        StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L24
        int r7 = r5.length;     // Catch: Exception -> L24
        int r8 = 0;
    L14:
        if (r8 >= r7) goto L20;
        String r9 = Integer.toHexString(r5[r8] & 255);     // Catch: Exception -> L24
        if (r9.length() != 1) goto L18;
        r6.append('0');     // Catch: Exception -> L24
    L18:
        r6.append(r9);     // Catch: Exception -> L24
        r8 = r8 + 1;     // Catch: Exception -> L24
        goto L14
    L20:
        if (Intrinsics.areEqual(r6.toString(), NOVA_SIGNATURE) == true) goto L21;
        r3 = r3 + 1;
        goto L12
    L21:
        return true;
    L8:
        r1 = false;
    L23:
        return false;
    }

    public final boolean checkSignature(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(r4, EntityContextHolder.INSTANCE.getPackageName()) == false) goto L15;
        return true;
    L15:
        if (isMemoryPackageName(r4) == true) goto L18;
        return false;
    L18:
        if (isPrivilegedApp(r4) == true) goto L22;
        return false;
    L22:
        if (Build.VERSION.SDK_INT < 28) goto L25;
        return checkSignatureApi28Plus(r4);
    L25:
        return checkSignatureLegacy(r4);
    L5:
        if (r4.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final boolean isMemoryPackageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pkgName");
        return Intrinsics.areEqual(NOVA_PKG_NAME, r2);
    }

    public final boolean isPrivilegedApp(String r4) {
        Intrinsics.checkNotNullParameter(r4, "packageName");
        ApplicationInfo r5 = EntityContextHolder.INSTANCE.getContext().getPackageManager().getApplicationInfo(r4, 0);     // Catch: Throwable -> L7
        Field r1 = ApplicationInfo.class.getDeclaredField("privateFlags");     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        if ((r1.getInt(r5) & 8) == 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        return false;
    }
}
