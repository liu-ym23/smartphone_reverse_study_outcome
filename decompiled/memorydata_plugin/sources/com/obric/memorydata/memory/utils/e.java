package com.obric.memorydata.memory.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u001f\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/memory/utils/MemoryTaskUtils;", "", "<init>", "()V", "TAG", "", "MEMORY_TASK_ACTIVITY_PREFIXES", "", "clearAllMemoryAppTasks", "", "context", "Landroid/content/Context;", "clearOtherMemoryAppTasks", "currentTaskId", "", "clearMemoryAppTasksInternal", "skipTaskId", "(Landroid/content/Context;Ljava/lang/Integer;)V", "isMemoryTask", "", "taskInfo", "Landroid/app/ActivityManager$RecentTaskInfo;", "matchesMemoryActivity", "className", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f11535a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<String> f11536b = null;

    static {
        f11535a = new e();
        f11536b = CollectionsKt.listOf(new String[]{"com.obric.memorydata.memory.ui.", "com.obric.memorydata.plugin_api.stub.activity."});
    }

    private e() {
    }

    private final void a(Context r14, Integer r15) {
        ActivityManager r13 = (ActivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin")).getSystemService(ActivityManager.class), ActivityManager.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L5;
        return;
    L5:
        List<ActivityManager.AppTask> r16 = r13.getAppTasks();
        Intrinsics.checkNotNullExpressionValue(r16, "getAppTasks(...)");
        Iterator r17 = ((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r17.hasNext() == false) goto L45;
        ActivityManager.AppTask r18 = (ActivityManager.AppTask) ZeusTransformUtils.preCheckCast(r17.next(), ActivityManager.AppTask.class, "com.obric.memorydata.plugin");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Object r2 = Result.m1421constructorimpl(r18.getTaskInfo());     // Catch: Throwable -> L11
    L14:
        if (Result.m1427isFailureimpl(r2) == false) goto L16;
        r2 = null;
    L16:
        ActivityManager.RecentTaskInfo r3 = (ActivityManager.RecentTaskInfo) ZeusTransformUtils.preCheckCast(r2, ActivityManager.RecentTaskInfo.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        if (r15 == null) goto L23;
        if (r3.id == r15.intValue()) goto L7;
    L23:
        ComponentName r4 = r3.baseActivity;
        String r5 = "unknown";
        if (r4 == null) goto L27;
        String r6 = r4.getClassName();
        if (r6 == null) goto L27;
    L28:
        ComponentName r7 = r3.topActivity;
        if (r7 == null) goto L35;
        String r8 = r7.getClassName();
        if (r8 == null) goto L35;
        r5 = r8;
    L35:
        if (f11535a.a(r3) == false) goto L36;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTaskUtils", "remove memory task before killing plugin process, taskId=" + r3.id + ", base=" + r6 + ", top=" + r5, false, 4, null);
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L40
        r18.finishAndRemoveTask();     // Catch: Throwable -> L40
        Object r19 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L42:
        Throwable r110 = Result.m1424exceptionOrNullimpl(r19);
        if (r110 == null) goto L7;
        RunLog.INSTANCE.error("MemoryTaskUtils", "remove task failed, taskId=" + r3.id, r110);
    L40:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L42
    L36:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTaskUtils", "skip non-memory task before killing plugin process, taskId=" + r3.id + ", base=" + r6 + ", top=" + r5, false, 4, null);
    L27:
        r6 = "unknown";
    L11:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final boolean a(ActivityManager.RecentTaskInfo r3) {
        ComponentName r0 = r3.baseActivity;
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getClassName();
    L7:
        if (a(r2) == true) goto L15;
        ComponentName r4 = r3.topActivity;
        if (r4 == null) goto L12;
        r1 = r4.getClassName();
    L12:
        if (a(r1) == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        r2 = null;
        goto L7
    }

    private final boolean a(String r7) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        return false;
    L11:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(f11536b, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L14;
    L16:
        Iterator r10 = r9.iterator();
    L18:
        if (r10.hasNext() == false) goto L21;
        if (StringsKt.startsWith$default(r7, (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L18;
        return true;
    L21:
        return false;
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L16;
    L5:
        if (r6.length() == 0) goto L8;
        r8 = false;
        goto L9
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        a(r4, null);
    }

    public final void a(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        a(r5, Integer.valueOf(r4));
    }
}
