package com.obric.matrix.platform.sdk.ones.safecushion;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/LaunchCrashCatcher;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "()V", "TAG", "", "exceptionHandler", "attach", "", "detach", "fillThrowableToStr", "e", "", "handleUncaughtException", "", "t", "Ljava/lang/Thread;", "openMarketDetails", "context", "Landroid/content/Context;", "startActivityIfExist", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "uncaughtException", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8123a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Thread.UncaughtExceptionHandler f8124b;

    static {
        f8123a = new a();
    }

    private a() {
    }

    private final String a(Throwable r12) {
        String r11 = r12.getLocalizedMessage();
    L4:
        if (r12.getCause() == null) goto L6;
        r12 = r12.getCause();
        Intrinsics.checkNotNull(r12);
        goto L4
    L6:
        StringBuilder r13 = new StringBuilder().append(r11).append('\n');
        StackTraceElement[] r14 = r12.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(r14, "throwable.stackTrace");
        return r13.append(CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(ArraysKt.take((Object[]) ZeusTransformUtils.preCheckCast(r14, Object[].class, "com.obric.memorydata.plugin"), 3), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\n", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, (Function1) ZeusTransformUtils.preCheckCast(LaunchCrashCatcher$fillThrowableToStr$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), 30, null)).toString();
    }

    private final void a(Thread r3, Throwable r4) {
        d.f8133a.a("StartUp", a(r4), r3);
        Thread.UncaughtExceptionHandler r2 = f8124b;
        if (r2 == null) goto L6;
        r2.uncaughtException(r3, r4);
        return;
    }

    public final boolean a(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Toast.makeText(r6, (CharSequence) ZeusTransformUtils.preCheckCast("修复后进程重启，依旧抓到了崩溃\n没办法了，现在引导去商店升级应用版本", CharSequence.class, "com.obric.memorydata.plugin"), 0).show();     // Catch: Exception -> L5
        Intent r2 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + c.f8131a.a().a().a()));     // Catch: Exception -> L5
        r2.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);     // Catch: Exception -> L5
        ZeusTransformUtils.startActivity(r6, r2, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "t");
        Intrinsics.checkNotNullParameter(r3, "e");
        a(r2, r3);
    }
}
