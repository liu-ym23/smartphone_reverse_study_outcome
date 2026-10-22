package com.obric.memorydata.middleware.impl.log;

import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u0000H\u0007J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\"\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\"\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016JG\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\u001eH\u0082\bJ\b\u0010\u001f\u001a\u00020\u0005H\u0002J%\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u00052\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0#H\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/memorydata/middleware/impl/log/RunLogImpl;", "Lcom/obric/memorydata/middleware/api/log/IRunLog;", "<init>", "()V", "TAG_PREFIX", "", "MAX_LENGTH", "", "formatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "Ljava/time/format/DateTimeFormatter;", "getInst", "debugLocalTest", "", LocationMonitorConst.TAG, "message", "data", "", "debug", "info", "printLogcat", "", "warn", "trace", "", "error", "doLogWith", "logLevel", "log", "Lkotlin/Function2;", "getCurrentTimestamp", "splitAndProcess", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "process", "Lkotlin/Function1;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RunLogImpl implements IRunLog {
    public static final RunLogImpl INSTANCE = null;
    private static final int MAX_LENGTH = 2048;
    private static final String TAG_PREFIX = "MeD_";
    private static final DateTimeFormatter formatter = null;

    static {
        INSTANCE = new RunLogImpl();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
    }

    private RunLogImpl() {
    }

    public static final /* synthetic */ String access$getCurrentTimestamp(RunLogImpl r0) {
        return r0.getCurrentTimestamp();
    }

    private final void doLogWith(String r6, String r7, int r8, Throwable r9, Function2<? super String, ? super String, Unit> r10) {
        Function2 r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r10, Function2.class, "com.obric.memorydata.plugin");
        String r12 = TAG_PREFIX + r6;
        if (r9 != null) goto L5;
        String r0 = r7;
    L6:
        int r3 = 0;
        if (com.ss.android.agilelogger.a.a() == true) goto L36;
        String r5 = "[cache][" + access$getCurrentTimestamp(this) + "] " + r0;
        if (r5.length() > 2048) goto L12;
        b.f11751a.a(new c(r8, r12, r5));
    L15:
        if (AppContext.INSTANCE.isDebug() == true) goto L19;
        if (r8 == 6) goto L19;
        if (r8 == 5) goto L19;
        return;
    L19:
        if (r8 == 4) goto L31;
        if (r8 == 5) goto L28;
        if (r8 == 6) goto L25;
        if (r9 == null) goto L24;
        Log.d(r12, r7, r9);
        return;
    L24:
        Log.d(r12, r7);
        return;
    L25:
        if (r9 == null) goto L27;
        Log.e(r12, r7, r9);
        return;
    L27:
        Log.e(r12, r7);
        return;
    L28:
        if (r9 == null) goto L30;
        Log.w(r12, r7, r9);
        return;
    L30:
        Log.w(r12, r7);
        return;
    L31:
        if (r9 == null) goto L33;
        Log.i(r12, r7, r9);
        return;
    L33:
        Log.i(r12, r7);
        return;
    L12:
        if (r3 >= r5.length()) goto L15;
        int r13 = Math.min(r3 + 2048, r5.length());
        String r1 = r5.substring(r3, r13);
        Intrinsics.checkNotNullExpressionValue(r1, "substring(...)");
        b.f11751a.a(new c(r8, r12, r1));
        r3 = r13;
        goto L12
    L36:
        if (r7.length() > 2048) goto L39;
        r11.invoke(r12, r7);
        return;
    L39:
        if (r3 >= r7.length()) goto L52;
        int r14 = Math.min(r3 + 2048, r7.length());
        String r15 = r7.substring(r3, r14);
        Intrinsics.checkNotNullExpressionValue(r15, "substring(...)");
        r11.invoke(r12, r15);
        r3 = r14;
        goto L39
    L52:
        return;
    L5:
        r0 = r7 + '\n' + Log.getStackTraceString(r9);
        goto L6
    }

    static /* synthetic */ void doLogWith$default(RunLogImpl r3, String r4, String r5, int r6, Throwable r7, Function2 r8, int r9, Object r10) {
        Function2 r11 = (Function2) ZeusTransformUtils.wrapperContextForParams(r8, Function2.class, "com.obric.memorydata.plugin");
        if ((r9 & 8) == 0) goto L5;
        r7 = null;
    L5:
        String r12 = TAG_PREFIX + r4;
        if (r7 != null) goto L8;
        String r13 = r5;
    L9:
        int r1 = 0;
        if (com.ss.android.agilelogger.a.a() == true) goto L39;
        String r14 = "[cache][" + access$getCurrentTimestamp(r3) + "] " + r13;
        if (r14.length() > 2048) goto L15;
        b.f11751a.a(new c(r6, r12, r14));
    L18:
        if (AppContext.INSTANCE.isDebug() == true) goto L22;
        if (r6 == 6) goto L22;
        if (r6 == 5) goto L22;
        return;
    L22:
        if (r6 == 4) goto L34;
        if (r6 == 5) goto L31;
        if (r6 == 6) goto L28;
        if (r7 == null) goto L27;
        Log.d(r12, r5, r7);
        return;
    L27:
        Log.d(r12, r5);
        return;
    L28:
        if (r7 == null) goto L30;
        Log.e(r12, r5, r7);
        return;
    L30:
        Log.e(r12, r5);
        return;
    L31:
        if (r7 == null) goto L33;
        Log.w(r12, r5, r7);
        return;
    L33:
        Log.w(r12, r5);
        return;
    L34:
        if (r7 == null) goto L36;
        Log.i(r12, r5, r7);
        return;
    L36:
        Log.i(r12, r5);
        return;
    L15:
        if (r1 >= r14.length()) goto L18;
        int r15 = Math.min(r1 + 2048, r14.length());
        String r16 = r14.substring(r1, r15);
        Intrinsics.checkNotNullExpressionValue(r16, "substring(...)");
        b.f11751a.a(new c(r6, r12, r16));
        r1 = r15;
        goto L15
    L39:
        if (r5.length() > 2048) goto L42;
        r11.invoke(r12, r5);
        return;
    L42:
        if (r1 >= r5.length()) goto L55;
        int r17 = Math.min(r1 + 2048, r5.length());
        String r18 = r5.substring(r1, r17);
        Intrinsics.checkNotNullExpressionValue(r18, "substring(...)");
        r11.invoke(r12, r18);
        r1 = r17;
        goto L42
    L55:
        return;
    L8:
        r13 = r5 + '\n' + Log.getStackTraceString(r7);
        goto L9
    }

    private final String getCurrentTimestamp() {
        String r1 = LocalDateTime.now().format(formatter);
        Intrinsics.checkNotNullExpressionValue(r1, "format(...)");
        return r1;
    }

    @JvmStatic
    public static final RunLogImpl getInst() {
        return INSTANCE;
    }

    private final void splitAndProcess(String r3, Function1<? super String, Unit> r4) {
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if (r3.length() > 2048) goto L6;
        r2.invoke(r3);
        return;
    L6:
        int r5 = 0;
    L8:
        if (r5 >= r3.length()) goto L10;
        int r0 = Math.min(r5 + 2048, r3.length());
        String r6 = r3.substring(r5, r0);
        Intrinsics.checkNotNullExpressionValue(r6, "substring(...)");
        r2.invoke(r6);
        r5 = r0;
        goto L8
    }

    @Override // com.obric.memorydata.middleware.api.log.IRunLog
    public void debug(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r8, "message");
        String r9 = TAG_PREFIX + r7;
        int r2 = 0;
        if (com.ss.android.agilelogger.a.a() == true) goto L14;
        String r6 = "[cache][" + access$getCurrentTimestamp(this) + "] " + r8;
        if (r6.length() > 2048) goto L8;
        b.f11751a.a(new c(3, r9, r6));
    L11:
        if (AppContext.INSTANCE.isDebug() == false) goto L19;
        Log.d(r9, r8);
        return;
    L19:
        return;
    L8:
        if (r2 >= r6.length()) goto L11;
        int r0 = Math.min(r2 + 2048, r6.length());
        String r3 = r6.substring(r2, r0);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        b.f11751a.a(new c(3, r9, r3));
        r2 = r0;
        goto L8
    L14:
        if (r8.length() > 2048) goto L17;
        com.ss.android.agilelogger.a.b(r9, r8);
        return;
    L17:
        if (r2 >= r8.length()) goto L24;
        int r10 = Math.min(r2 + 2048, r8.length());
        String r1 = r8.substring(r2, r10);
        Intrinsics.checkNotNullExpressionValue(r1, "substring(...)");
        com.ss.android.agilelogger.a.b(r9, r1);
        r2 = r10;
        goto L17
    }

    @Override // com.obric.memorydata.middleware.api.log.IRunLog
    public void debugLocalTest(String r2, String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "message");
        if (AppContext.INSTANCE.isLocalTest() == false) goto L11;
        StringBuilder r5 = new StringBuilder().append(r3).append(": ");
        if (r4 == null) goto L8;
        String r6 = u.a(r4);
        if (r6 == null) goto L8;
    L9:
        debug(r2, r5.append(r6).toString());
        return;
    L8:
        r6 = "";
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.log.IRunLog
    public void error(String r7, String r8, Throwable r9) {
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r8, "message");
        String r10 = TAG_PREFIX + r7;
        if (r9 != null) goto L5;
        String r0 = r8;
    L6:
        int r3 = 0;
        if (com.ss.android.agilelogger.a.a() == true) goto L19;
        String r6 = "[cache][" + access$getCurrentTimestamp(this) + "] " + r0;
        if (r6.length() > 2048) goto L12;
        b.f11751a.a(new c(6, r10, r6));
    L14:
        AppContext.INSTANCE.isDebug();
        if (r9 == null) goto L17;
        Log.e(r10, r8, r9);
        return;
    L17:
        Log.e(r10, r8);
        return;
    L12:
        if (r3 >= r6.length()) goto L14;
        int r1 = Math.min(r3 + 2048, r6.length());
        String r4 = r6.substring(r3, r1);
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
        b.f11751a.a(new c(6, r10, r4));
        r3 = r1;
        goto L12
    L19:
        if (r8.length() > 2048) goto L24;
        if (r9 == null) goto L22;
        com.ss.android.agilelogger.a.b(r10, r8, r9);
        return;
    L22:
        com.ss.android.agilelogger.a.e(r10, r8);
        return;
    L24:
        if (r3 >= r8.length()) goto L38;
        int r11 = Math.min(r3 + 2048, r8.length());
        String r2 = r8.substring(r3, r11);
        Intrinsics.checkNotNullExpressionValue(r2, "substring(...)");
        if (r9 == null) goto L28;
        com.ss.android.agilelogger.a.b(r10, r2, r9);
    L29:
        r3 = r11;
        goto L24
    L28:
        com.ss.android.agilelogger.a.e(r10, r2);
        goto L29
    L38:
        return;
    L5:
        r0 = r8 + '\n' + Log.getStackTraceString(r9);
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.log.IRunLog
    public void info(String r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r7, "message");
        String r9 = TAG_PREFIX + r6;
        int r2 = 0;
        if (com.ss.android.agilelogger.a.a() == true) goto L14;
        String r5 = "[cache][" + access$getCurrentTimestamp(this) + "] " + r7;
        if (r5.length() > 2048) goto L8;
        b.f11751a.a(new c(4, r9, r5));
    L11:
        if (AppContext.INSTANCE.isDebug() == false) goto L26;
    L12:
        Log.i(r9, r7);
        return;
    L26:
        return;
    L8:
        if (r2 >= r5.length()) goto L11;
        int r10 = Math.min(r2 + 2048, r5.length());
        String r3 = r5.substring(r2, r10);
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        b.f11751a.a(new c(4, r9, r3));
        r2 = r10;
        goto L8
    L14:
        if (r7.length() > 2048) goto L20;
        com.ss.android.agilelogger.a.c(r9, r7);
        if (AppContext.INSTANCE.isLocalTest() == true) goto L33;
        if (r8 == true) goto L12;
        return;
    L33:
        return;
    L20:
        if (r2 >= r7.length()) goto L35;
        int r11 = Math.min(r2 + 2048, r7.length());
        String r0 = r7.substring(r2, r11);
        Intrinsics.checkNotNullExpressionValue(r0, "substring(...)");
        com.ss.android.agilelogger.a.c(r9, r0);
        if (AppContext.INSTANCE.isLocalTest() == true) goto L25;
        if (r8 == false) goto L25;
        Log.i(r9, r0);
    L25:
        r2 = r11;
        goto L20
    }

    @Override // com.obric.memorydata.middleware.api.log.IRunLog
    public void warn(String r7, String r8, Throwable r9) {
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r8, "message");
        String r10 = TAG_PREFIX + r7;
        if (r9 != null) goto L5;
        String r0 = r8;
    L6:
        int r3 = 0;
        if (com.ss.android.agilelogger.a.a() == true) goto L19;
        String r6 = "[cache][" + access$getCurrentTimestamp(this) + "] " + r0;
        if (r6.length() > 2048) goto L12;
        b.f11751a.a(new c(5, r10, r6));
    L14:
        AppContext.INSTANCE.isDebug();
        if (r9 == null) goto L17;
        Log.w(r10, r8, r9);
        return;
    L17:
        Log.w(r10, r8);
        return;
    L12:
        if (r3 >= r6.length()) goto L14;
        int r1 = Math.min(r3 + 2048, r6.length());
        String r4 = r6.substring(r3, r1);
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
        b.f11751a.a(new c(5, r10, r4));
        r3 = r1;
        goto L12
    L19:
        if (r8.length() > 2048) goto L24;
        if (r9 == null) goto L22;
        com.ss.android.agilelogger.a.a(r10, r8, r9);
        return;
    L22:
        com.ss.android.agilelogger.a.d(r10, r8);
        return;
    L24:
        if (r3 >= r8.length()) goto L38;
        int r11 = Math.min(r3 + 2048, r8.length());
        String r2 = r8.substring(r3, r11);
        Intrinsics.checkNotNullExpressionValue(r2, "substring(...)");
        if (r9 == null) goto L28;
        com.ss.android.agilelogger.a.a(r10, r2, r9);
    L29:
        r3 = r11;
        goto L24
    L28:
        com.ss.android.agilelogger.a.d(r10, r2);
        goto L29
    L38:
        return;
    L5:
        r0 = r8 + '\n' + Log.getStackTraceString(r9);
        goto L6
    }
}
