package com.obric.capabilitykit;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.obric.capabilitykit.logger.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/ProcessUtils;", "", "()V", "TAG", "", "sCurProcessName", "getCurProcessName", "context", "Landroid/content/Context;", "getCurProcessNameFromProc", "isMainProcess", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f7589a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7590b = "ProcessUtils";
    private static volatile String c;

    static {
        f7589a = new h();
    }

    private h() {
    }

    private final String a() {
        BufferedReader r0 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L13
        Ref.IntRef r1 = new Ref.IntRef();     // Catch: Throwable -> L18
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L18
    L5:
        int r3 = r0.read();     // Catch: Throwable -> L18
        r1.element = r3;     // Catch: Throwable -> L18
        if (r3 <= 0) goto L10;
        r2.append((char) r3);     // Catch: Throwable -> L18
        goto L5
    L10:
        Logger.INSTANCE.d(f7590b, "get processName = " + r2);     // Catch: Throwable -> L18
        String r6 = r2.toString();     // Catch: Throwable -> L18
        r0.close();     // Catch: Exception -> L17
    L12:
        return r6;
    L14:
        if (r0 != null) goto L20;
    L16:
        return null;
    L20:
        r0.close();     // Catch: Exception -> L19
    L13:
        r0 = null;
        goto L14
    }

    public final String a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "context");
        String r0 = c;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        return r0;
    L12:
        if (Build.VERSION.SDK_INT < 28) goto L26;
        c = Application.getProcessName();
        Logger.INSTANCE.d(f7590b, "processName = " + c);
    L15:
        return c;
    L26:
        int r1 = Process.myPid();     // Catch: Exception -> L23
        Object r9 = r8.getSystemService("activity");     // Catch: Exception -> L23
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L23
        Iterator<ActivityManager.RunningAppProcessInfo> r10 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r9, ActivityManager.class, "com.obric.memorydata.plugin")).getRunningAppProcesses().iterator();     // Catch: Exception -> L23
    L18:
        if (r10.hasNext() == false) goto L25;
        ActivityManager.RunningAppProcessInfo r3 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r10.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L23
        if (r3.pid != r1) goto L18;
        Logger.INSTANCE.d(f7590b, "processName = " + r3.processName);     // Catch: Exception -> L23
        c = r3.processName;     // Catch: Exception -> L23
        return c;
    L25:
        c = a();
    L23:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public final boolean b(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r4 = a(r6);
        if (r4 != null) goto L5;
    L7:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r4, r6.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (StringsKt.contains$default(r4, ParameterizedMessage.ERROR_MSG_SEPARATOR, false, 2, null) == false) goto L7;
        return false;
    }
}
