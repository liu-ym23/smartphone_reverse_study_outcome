package com.obric.framework;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.runtime.utils.d;
import com.obric.aikernel.runtime.utils.e;
import com.obric.aikernel.runtime.utils.i;
import java.io.File;
import java.util.UUID;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: loaded from: classes2.dex */
public final class ObricSecurityPartition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricSecurityPartition f5790a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f5791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f5792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final w<Unit> f5793d = null;

    static {
        f5790a = new ObricSecurityPartition();
        f5792c = i.f5431a.a();
        f5793d = y.b(null, 1, null);
    }

    private ObricSecurityPartition() {
    }

    public static final /* synthetic */ w a() {
        return f5793d;
    }

    @SuppressLint({"SdCardPath"})
    private final synchronized boolean b(Context r10, String r11) {
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L4:
        boolean r12 = false;
        if (f(r10).exists() == true) goto L8;
        monitor-exit(this);
        return false;
    L8:
        File r13 = new File(r11 + "/guard");     // Catch: Throwable -> L28
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L15
        if (r13.exists() == false) goto L12;
        boolean r15 = true;
    L13:
        Object r16 = Result.m32constructorimpl(Boolean.valueOf(r15));     // Catch: Throwable -> L15
    L17:
        Throwable r17 = Result.m35exceptionOrNullimpl(r16);     // Catch: Throwable -> L28
        if (r17 == null) goto L21;
        d.f5417a.e("ObricSecurityPartition", "checkGuardFile failed: " + r17);     // Catch: Throwable -> L28
    L21:
        if (Result.m38isFailureimpl(r16) == false) goto L23;
        r16 = null;
    L23:
        Boolean r18 = (Boolean) r16;     // Catch: Throwable -> L28
        if (r18 == null) goto L26;
        r12 = r18.booleanValue();     // Catch: Throwable -> L28
    L26:
        monitor-exit(this);
        return r12;
    L12:
        r15 = r13.createNewFile();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L28
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L28
        goto L17
    }

    private final void c(File r10, File r11, int r12) {
    L27:
        e = move-exception;
        d.f5417a.e("ObricSecurityPartition", "clearRootEncryptRoot failed, error: " + e + ", " + ExceptionsKt.stackTraceToString(e));
        return;
    L4:
        if (r10.exists() == true) goto L6;
    L17:
        d.f5417a.c("ObricSecurityPartition", "try clean data fbe");     // Catch: Exception -> L27
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L20
        Object r14 = Result.m32constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r11)));     // Catch: Throwable -> L20
    L22:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);     // Catch: Exception -> L27
        if (r15 == null) goto L25;
        d.f5417a.l("ObricSecurityPartition", "delete encrypt root dir failed " + r15);     // Catch: Exception -> L27
    L25:
        d r16 = d.f5417a;     // Catch: Exception -> L27
        r16.c("ObricSecurityPartition", "test data fbe " + r11 + ", exists: " + r11.exists() + ", getMyUserId: " + e.f5420a.a() + ", cachedHostUserId: " + f5791b);     // Catch: Exception -> L27
        a.f5794a.g(r12, f5791b);     // Catch: Exception -> L27
        r16.g("ObricSecurityPartition", "clearRootEncryptRoot success.");     // Catch: Exception -> L27
        return;
    L20:
        th = move-exception;
        Result.Companion r17 = Result.Companion;     // Catch: Exception -> L27
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L27
        goto L22
    L6:
        if (r10.isFile() == false) goto L9;
        r10.delete();     // Catch: Exception -> L27
        goto L17
    L9:
        if (r10.isDirectory() == false) goto L17;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L12
        Object r19 = Result.m32constructorimpl(Boolean.valueOf(FilesKt.deleteRecursively(r10)));     // Catch: Throwable -> L12
    L14:
        Throwable r20 = Result.m35exceptionOrNullimpl(r19);     // Catch: Exception -> L27
        if (r20 == null) goto L17;
        d.f5417a.l("ObricSecurityPartition", "delete salt dir failed " + r20);     // Catch: Exception -> L27
        goto L17
    L12:
        th = move-exception;
        Result.Companion r21 = Result.Companion;     // Catch: Exception -> L27
        r19 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L27
        goto L14
    }

    private final String e() {
        if (f5791b == (-1)) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L10;
        return "/data/fbe/aikernel/" + f5791b;
    L10:
        throw new IllegalStateException("init() must be called first".toString());
    L5:
        r10 = false;
        goto L6
    }

    @SuppressLint({"DefaultLocale"})
    private final File f(Context r10) {
        if (Intrinsics.areEqual(f5792c, i.f5431a.a()) == false) goto L6;
        return new File(String.format("/data/user/%d/%s/files", new Object[]{Integer.valueOf(f5791b), r10.getPackageName()}), "etc/fbe_salt");
    L6:
        return new File(r10.getFilesDir(), "etc/fbe_salt");
    }

    private final synchronized void h(Context r10, int r11, String r12) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (b(r10, r12) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        i(r10, r11, r12);     // Catch: Throwable -> L17
        if (b(r10, r12) == true) goto L15;
        File r13 = f(r10);     // Catch: Throwable -> L17
        if (r13.exists() == false) goto L13;
        r13.delete();     // Catch: Throwable -> L17
        d r14 = d.f5417a;     // Catch: Throwable -> L17
        String r15 = "ObricSecurityPartition";
        String r16 = "salt file not match!";
    L12:
        r14.e(r15, r16);     // Catch: Throwable -> L17
        i(r10, r11, r12);     // Catch: Throwable -> L17
        goto L15
    L13:
        r14 = d.f5417a;     // Catch: Throwable -> L17
        r15 = "ObricSecurityPartition";
        r16 = "salt file not exist!";
    L15:
        monitor-exit(this);
    }

    private final void i(Context r10, int r11, String r12) {
        long r13 = SystemClock.elapsedRealtime();
        File r14 = f(r10);
        if (r14.exists() == true) goto L5;
    L11:
        c(r14, new File(r12), r11);
        String r15 = UUID.randomUUID().toString();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r15, "randomUUID().toString()");     // Catch: Throwable -> L17
        byte[] r16 = r15.getBytes(Charsets.UTF_8);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r16, "this as java.lang.String).getBytes(charset)");     // Catch: Throwable -> L17
        a r17 = a.f5794a;     // Catch: Throwable -> L17
        String r18 = r10.getPackageName();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r18, "context.packageName");     // Catch: Throwable -> L17
        r17.h(r11, r17.b(r18, r16), f5791b);     // Catch: Throwable -> L17
        d.f5417a.e("ObricSecurityPartition", "tryInit  " + e.f5420a.a() + ", cachedHostUserId = " + f5791b);     // Catch: Throwable -> L17
        File r19 = r14.getParentFile();     // Catch: Throwable -> L17
        if (r19 == null) goto L15;
        r19.mkdirs();     // Catch: Throwable -> L17
    L15:
        FilesKt.writeBytes(r14, r16);     // Catch: Throwable -> L17
    L19:
        d r20 = d.f5417a;
        StringBuilder r21 = new StringBuilder();
        String r22 = "case not exists init used time: ";
    L20:
        r21.append(r22);
        r21.append(SystemClock.elapsedRealtime() - r13);
        r20.c("ObricSecurityPartition", r21.toString());
        return;
    L17:
        th = move-exception;
        d.f5417a.l("ObricSecurityPartition", "case not exists init failed: " + th);
        goto L19
    L5:
        if (r14.isFile() == false) goto L11;
        byte[] r23 = FilesKt.readBytes(r14);     // Catch: Throwable -> L8
        a r24 = a.f5794a;     // Catch: Throwable -> L8
        String r25 = r10.getPackageName();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r25, "context.packageName");     // Catch: Throwable -> L8
        r24.h(r11, r24.b(r25, r23), f5791b);     // Catch: Throwable -> L8
    L10:
        r20 = d.f5417a;
        r21 = new StringBuilder();
        r22 = "case exists init used time: ";
    L8:
        th = move-exception;
        d.f5417a.l("ObricSecurityPartition", "case exists init failed: " + th);
        goto L10
    }

    public final Object d(Continuation<? super String> r10) {
        if ((r10 instanceof ObricSecurityPartition$getFBEPath$1) == false) goto L7;
        ObricSecurityPartition$getFBEPath$1 r11 = (ObricSecurityPartition$getFBEPath$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        ObricSecurityPartition this = (ObricSecurityPartition) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L18:
        return this.e();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        ObricSecurityPartition$getFBEPath$2 r16 = new ObricSecurityPartition$getFBEPath$2(null);
        r11.L$0 = this;
        r11.label = 1;
        if (TimeoutKt.c(5000, r16, r11) != r14) goto L18;
        return r14;
    L7:
        r11 = new ObricSecurityPartition$getFBEPath$1(this, r10);
        goto L8
    }

    public final synchronized String g(Context r10, int r11, int r12, String r13) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "context");     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r13, "hostType");     // Catch: Throwable -> L42
        if (f5793d.a() == false) goto L49;
        d.f5417a.l("ObricSecurityPartition", "init() already called, skipping");     // Catch: Throwable -> L42
        String r14 = e();     // Catch: Throwable -> L42
        monitor-exit(this);
        return r14;
    L49:
        f5791b = r12;     // Catch: Throwable -> L35 Exception -> L37
        f5792c = r13;     // Catch: Throwable -> L35 Exception -> L37
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L11
        Object r16 = Result.m32constructorimpl(a.f5794a.e(r11, r12));     // Catch: Throwable -> L11
    L14:
        if (Result.m39isSuccessimpl(r16) == false) goto L16;
        d.f5417a.g("ObricSecurityPartition", "getStorageDir " + ((String) r16));     // Catch: Throwable -> L35 Exception -> L37
    L16:
        Throwable r17 = Result.m35exceptionOrNullimpl(r16);     // Catch: Throwable -> L35 Exception -> L37
        if (r17 == null) goto L20;
        d.f5417a.l("ObricSecurityPartition", "FileEncrypt#getStorageDir not found, fallback to default. " + r17);     // Catch: Throwable -> L35 Exception -> L37
    L20:
        if (Result.m38isFailureimpl(r16) == false) goto L22;
        r16 = null;
    L22:
        String r18 = (String) r16;     // Catch: Throwable -> L35 Exception -> L37
        if (r18 != null) goto L30;
        if (Intrinsics.areEqual(r10.getPackageName(), IAIKernelManager.PACKAGE_NAME_AIK) == false) goto L28;
        r18 = e();     // Catch: Throwable -> L35 Exception -> L37
        goto L30
    L28:
        throw new IllegalAccessError(r10.getPackageName() + " init fbe should not reach here!");     // Catch: Throwable -> L35 Exception -> L37
    L30:
        if (b(r10, r18) == true) goto L32;
        h(r10, r11, r18);     // Catch: Throwable -> L35 Exception -> L37
    L32:
        f5793d.K(Unit.INSTANCE);     // Catch: Throwable -> L42
        monitor-exit(this);
        return r18;
    L11:
        th = move-exception;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L35 Exception -> L37
        r16 = Result.m32constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L35 Exception -> L37
    L37:
        e = move-exception;
        f5793d.G(e);     // Catch: Throwable -> L35
        throw e;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        f5793d.K(Unit.INSTANCE);     // Catch: Throwable -> L42
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;
    }
}
