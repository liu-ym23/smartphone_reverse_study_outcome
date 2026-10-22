package com.obric.matrix.platform.sdk.ones.safecushion.a;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/util/AppUtil;", "", "()V", "sCurProcessName", "", "getCurProcessName", "context", "Landroid/content/Context;", "isMainOrSafeProcess", "", "isMainProcess", "isProcessConsideredBackground", "importance", "", "isProcessInBackground", "isSafeModeProcess", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8125a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f8126b;

    static {
        f8125a = new a();
    }

    private a() {
    }

    private final boolean a(int r6) {
        if (Build.VERSION.SDK_INT < 35) goto L9;
        if (r6 == 100) goto L13;
        if (r6 == 200) goto L13;
        if (r6 == 125) goto L13;
        return true;
    L13:
        return false;
    L9:
        if (r6 == 100) goto L13;
        if (r6 == 200) goto L13;
        return true;
    }

    public final boolean a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        String r5 = d(r7);
        if (r5 != null) goto L5;
    L7:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r5, r7.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(ParameterizedMessage.ERROR_MSG_SEPARATOR, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L7;
        return false;
    }

    public final boolean b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r2 = d(r4);
        if (r2 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r2, r4.getPackageName() + ":safecushion");
    }

    public final boolean c(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        String r0 = d(r7);
        if (r0 != null) goto L5;
        return true;
    L5:
        Object r8 = r7.getSystemService("activity");
        if (ZeusTransformUtils.instanceOf(r8, ActivityManager.class) == false) goto L8;
        ActivityManager r9 = (ActivityManager) ZeusTransformUtils.preCheckCast(r8, ActivityManager.class, "com.obric.memorydata.plugin");
    L9:
        if (r9 != null) goto L11;
        return true;
    L11:
        List<ActivityManager.RunningAppProcessInfo> r10 = r9.getRunningAppProcesses();
        if (r10 != null) goto L14;
        return true;
    L14:
        Iterator<ActivityManager.RunningAppProcessInfo> r11 = r10.iterator();
    L16:
        if (r11.hasNext() == false) goto L21;
        ActivityManager.RunningAppProcessInfo r3 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r11.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r3.processName, r0) == false) goto L16;
        return a(r3.importance);
    L21:
        return true;
    L8:
        r9 = null;
        goto L9
    }

    public final String d(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        String r6 = f8126b;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        return r6;
    L12:
        if (Build.VERSION.SDK_INT < 28) goto L40;
        String r7 = Application.getProcessName();
        f8126b = r7;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L16;
    L17:
        r2 = true;
    L18:
        if (r2 == true) goto L40;
        return f8126b;
    L16:
        if (r8.length() != 0) goto L18;
    L40:
        int r9 = Process.myPid();     // Catch: Exception -> L37
        Object r10 = r4.getSystemService("activity");     // Catch: Exception -> L37
        if (ZeusTransformUtils.instanceOf(r10, ActivityManager.class) == false) goto L25;
        ActivityManager r11 = (ActivityManager) ZeusTransformUtils.preCheckCast(r10, ActivityManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L37
    L26:
        if (r11 != null) goto L28;
        return null;
    L28:
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = r11.getRunningAppProcesses().iterator();     // Catch: Exception -> L37
    L30:
        if (r12.hasNext() == false) goto L44;
        ActivityManager.RunningAppProcessInfo r13 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r12.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L37
        if (r13.pid != r9) goto L30;
        com.obric.matrix.platform.sdk.ones.internal.b.b.b("Process", "processName = " + r13.processName, null, 4, null);     // Catch: Exception -> L37
        String r14 = r13.processName;     // Catch: Exception -> L37
        f8126b = r14;     // Catch: Exception -> L37
        return r14;
    L44:
        return (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L25:
        r11 = null;
    L37:
        e = move-exception;
        e.printStackTrace();
        return (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.memorydata.plugin");
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }
}
