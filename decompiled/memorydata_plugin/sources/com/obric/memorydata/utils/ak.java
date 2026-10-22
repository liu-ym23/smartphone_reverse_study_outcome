package com.obric.memorydata.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import com.bytedance.crypto.utils.CryptoConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u0018\u0010\u0019\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0005J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001d2\u0006\u0010\u0010\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/utils/PermissionCheck;", "", "<init>", "()V", "TAG", "", "ANDROID_PACKAGE", "platformSignature", "isRefuse", "", "isRefuseInner", "checkPermission", "callingPkg", "isCallingUidPlatformSigned", "isCallingUidSelf", "isPackageSelfUid", ObricMemoryConstants.KEY_PACKAGE_NAME, "isPackagePlatformSigned", "isPackageSystemApp", "isObricApp", "appInfo", "Landroid/content/pm/ApplicationInfo;", "isPackageObricApp", "getPlatformSignature", "getPackageSignature", "checkPermissionGranted", "permission", "checkCallingPermissionGranted", "getGrantedPermissions", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ak f13164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f13165b;

    static {
        f13164a = new ak();
    }

    private ak() {
    }

    private final boolean d() {
        int r0 = Binder.getCallingUid();
        int r1 = 0;
        if (r0 != 1000) goto L5;
        return false;
    L5:
        String[] r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackagesForUid(r0);
        if (r2 != null) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PermissionCheck", "callingPkg is null, callingUid = " + r0, null, 4, null);
        return true;
    L9:
        Iterator r5 = ArrayIteratorKt.iterator(r2);
    L11:
        if (r5.hasNext() == false) goto L15;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r6);
        if (a(r6) == false) goto L11;
        return false;
    L15:
        int r13 = r2.length;
    L16:
        if (r1 >= r13) goto L18;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PermissionCheck", "refused pkg " + r2[r1] + " , callingUid = " + r0, null, 4, null);
        r1 = r1 + 1;
        goto L16
    L18:
        return true;
    }

    private final String e() {
        String r1 = f13165b;
        if (r1 == null) goto L17;
        return r1;
    L17:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        String r5 = ((ak) ZeusTransformUtils.preCheckCast(this, ak.class, "com.obric.memorydata.plugin")).h("android");     // Catch: Throwable -> L7
        f13165b = r5;     // Catch: Throwable -> L7
        Object r6 = Result.m1421constructorimpl(r5);     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r6);
        if (r3 == null) goto L13;
        RunLog.INSTANCE.error("PermissionCheck", "getPlatformSignature failed", r3);
    L13:
        if (Result.m1427isFailureimpl(r6) == false) goto L16;
        r6 = null;
    L16:
        return (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    private final String h(String r6) {
        PackageInfo r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(r6, 134217728);
        Intrinsics.checkNotNullExpressionValue(r5, "getPackageInfo(...)");
        Signature[] r7 = r5.signingInfo.getApkContentsSigners();
        Intrinsics.checkNotNull(r7);
        byte[] r8 = ((Signature) ZeusTransformUtils.preCheckCast(ArraysKt.first(r7), Signature.class, "com.obric.memorydata.plugin")).toByteArray();
        byte[] r9 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256).digest(r8);
        StringBuilder r10 = new StringBuilder();
        int r0 = r9.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = Integer.toHexString(r9[r1] & 255);
        if (r2.length() != 1) goto L7;
        r10.append('0');
    L7:
        r10.append(r2);
        r1 = r1 + 1;
        goto L3
    L8:
        String r11 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");
        return r11;
    }

    public final boolean a() {
        if (AppContext.INSTANCE.isSsFlavor() == false) goto L11;
        return false;
    L11:
        return d();
    L8:
        e = move-exception;
        RunLog.INSTANCE.error("PermissionCheck", "PermissionCheck exception", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return true;
    }

    public final boolean a(ApplicationInfo r7) {
        Intrinsics.checkNotNullParameter(r7, "appInfo");
        Object r8 = ZeusTransformUtils.forName("android.content.pm.ApplicationInfoEx", "com.obric.memorydata.plugin").getMethod("isObricApp", new Class[]{ApplicationInfo.class}).invoke(null, new Object[]{r7});     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L5
        return ((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L8:
        return false;
    }

    public final boolean a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "callingPkg");
        if (Intrinsics.areEqual(r10, AppContext.INSTANCE.getPackageName()) == false) goto L5;
        return true;
    L5:
        PackageInfo r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(r10, 134217728);
        Intrinsics.checkNotNullExpressionValue(r9, "getPackageInfo(...)");
        SigningInfo r11 = r9.signingInfo;
        if (r11 != null) goto L10;
        IRunLog r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r6 = null;
        int r7 = 4;
        Object r8 = null;
        String r4 = "PermissionCheck";
        String r5 = "signingInfo is null";
    L8:
        IRunLog.a.a(r3, r4, r5, r6, r7, r8);
        return false;
    L10:
        Signature[] r12 = r11.getApkContentsSigners();
        if (r12 != null) goto L13;
    L31:
        r3 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r6 = null;
        r7 = 4;
        r8 = null;
        r4 = "PermissionCheck";
        r5 = "signatures is null or empty";
        goto L8
    L13:
        if (r12.length != 0) goto L15;
        boolean r13 = true;
    L16:
        if (r13 == true) goto L31;
        Iterator r14 = ArrayIteratorKt.iterator(r12);
    L20:
        if (r14.hasNext() == false) goto L30;
        byte[] r15 = MessageDigest.getInstance(CryptoConst.ALGORITHM_SHA256).digest(((Signature) ZeusTransformUtils.preCheckCast(r14.next(), Signature.class, "com.obric.memorydata.plugin")).toByteArray());
        StringBuilder r16 = new StringBuilder();
        int r17 = r15.length;
        int r18 = 0;
    L22:
        if (r18 >= r17) goto L27;
        String r19 = Integer.toHexString(r15[r18] & 255);
        if (r19.length() != 1) goto L26;
        r16.append('0');
    L26:
        r16.append(r19);
        r18 = r18 + 1;
        goto L22
    L27:
        ai r20 = ai.f13162a;
        String r21 = r16.toString();
        Intrinsics.checkNotNullExpressionValue(r21, "toString(...)");
        if (r20.a(r10, r21) == false) goto L20;
        return true;
    L30:
        return false;
    L15:
        r13 = false;
        goto L16
    }

    public final boolean a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "permission");
        if (r2 != null) goto L7;
        return false;
    L7:
        return g(r2).contains(r3);
    }

    public final boolean b() {
        int r0 = Binder.getCallingUid();
        boolean r1 = true;
        if (r0 != 1000) goto L5;
        return true;
    L5:
        String[] r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackagesForUid(r0);
        if (r4 != null) goto L8;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L18;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PermissionCheck", "isCallingUidPlatformSigned failed, packages is empty, uid=" + r0, null, 4, null);
        return false;
    L18:
        String r13 = e();
        if (r13 != null) goto L21;
        return false;
    L21:
        int r2 = r4.length;
        int r6 = 0;
    L22:
        if (r6 >= r2) goto L35;
        String r7 = r4[r6];
        ak r8 = f13164a;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L26
        Object r10 = Result.m1421constructorimpl(Boolean.valueOf(Intrinsics.areEqual(r8.h(r7), r13)));     // Catch: Throwable -> L26
    L29:
        if (Result.m1427isFailureimpl(r10) == false) goto L32;
        r10 = false;
    L32:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L36;
        r6 = r6 + 1;
    L36:
        if (r1 == true) goto L38;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PermissionCheck", "isCallingUidPlatformSigned failed, packages=" + ArraysKt.joinToString$default(r4, null, null, null, 0, null, null, 63, null), null, 4, null);
    L38:
        return r1;
    L26:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L29
    L35:
        r1 = false;
        goto L36
    L8:
        if (r4.length != 0) goto L10;
        boolean r12 = true;
    L11:
        if (r12 == true) goto L14;
        r5 = false;
        goto L15
    L10:
        r12 = false;
        goto L11
    }

    public final boolean b(String r7) {
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        ak r6 = (ak) ZeusTransformUtils.preCheckCast(this, ak.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageUid(r7, 0) != Process.myUid()) goto L6;
        boolean r8 = true;
    L7:
        Object r9 = Result.m1421constructorimpl(Boolean.valueOf(r8));     // Catch: Throwable -> L9
    L11:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r9);
        if (r3 == null) goto L15;
        RunLog.INSTANCE.warn("PermissionCheck", "isPackageSelfUid failed, packageName=" + r7, r3);
    L15:
        if (Result.m1427isFailureimpl(r9) == false) goto L18;
        r9 = false;
    L18:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L6:
        r8 = false;
    L9:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final boolean c() {
        if (Binder.getCallingUid() != Process.myUid()) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean c(String r7) {
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        String r1 = e();
        if (r1 != null) goto L17;
        return false;
    L17:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        Object r6 = Result.m1421constructorimpl(Boolean.valueOf(Intrinsics.areEqual(((ak) ZeusTransformUtils.preCheckCast(this, ak.class, "com.obric.memorydata.plugin")).h(r7), r1)));     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.m1424exceptionOrNullimpl(r6);
        if (r2 == null) goto L13;
        RunLog.INSTANCE.warn("PermissionCheck", "isPackagePlatformSigned failed, packageName=" + r7, r2);
    L13:
        if (Result.m1427isFailureimpl(r6) == false) goto L16;
        r6 = false;
    L16:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    public final boolean d(String r7) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L29;
        return false;
    L29:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L19
        ak r6 = (ak) ZeusTransformUtils.preCheckCast(this, ak.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        ApplicationInfo r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getApplicationInfo(r7, 0);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r8, "getApplicationInfo(...)");     // Catch: Throwable -> L19
        int r9 = r8.flags;     // Catch: Throwable -> L19
        if ((r9 & 1) == 0) goto L14;
    L17:
        Object r10 = Result.m1421constructorimpl(Boolean.valueOf(r2));     // Catch: Throwable -> L19
    L21:
        Throwable r4 = Result.m1424exceptionOrNullimpl(r10);
        if (r4 == null) goto L25;
        RunLog.INSTANCE.warn("PermissionCheck", "isPackageSystemApp failed, packageName=" + r7, r4);
    L25:
        if (Result.m1427isFailureimpl(r10) == false) goto L28;
        r10 = false;
    L28:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L14:
        if ((r9 & 128) != 0) goto L17;
        r2 = false;
    L19:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L21
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean e(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L14;
        return false;
    L14:
        ApplicationInfo r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getApplicationInfo(r5, 0);     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r6, "getApplicationInfo(...)");     // Catch: Throwable -> L13
        return a(r6);
    L16:
        return false;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r1 = false;
        goto L9
    }

    public final boolean f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "permission");
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).checkPermission(r3, Binder.getCallingPid(), Binder.getCallingUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final List<String> g(String r8) {
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
        PackageInfo r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(r8, 4096);     // Catch: Throwable -> L21
        List<String> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r7 == null) goto L30;
        String[] r0 = r7.requestedPermissions;     // Catch: Throwable -> L21
        if (r0 == null) goto L31;
        int r1 = r0.length;     // Catch: Throwable -> L21
        int r2 = 0;
        int r3 = 0;
    L8:
        if (r2 >= r1) goto L32;
        String r4 = r0[r2];     // Catch: Throwable -> L21
        int r5 = r3 + 1;     // Catch: Throwable -> L21
        if (Intrinsics.areEqual(r4, "android.permission.MANAGE_EXTERNAL_STORAGE") == false) goto L17;
        if (Build.VERSION.SDK_INT < 30) goto L20;
        if (Environment.isExternalStorageManager() == false) goto L20;
    L15:
        r9.add(r4);     // Catch: Throwable -> L21
    L20:
        r2 = r2 + 1;
        r3 = r5;
        goto L8
    L17:
        if ((r7.requestedPermissionsFlags[r3] & 2) == 0) goto L20;
        Intrinsics.checkNotNull(r4);     // Catch: Throwable -> L21
        goto L15
    L32:
        return r9;
    L31:
        return r9;
    L30:
        return r9;
    L22:
        return CollectionsKt.emptyList();
    }
}
