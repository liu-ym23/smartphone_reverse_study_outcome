package com.obric.memorydata.task;

import androidx.core.app.NotificationCompat;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.task.impl.PackageTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u00062\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007J\u001e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00062\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J%\u0010\u0017\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\b\u0018\u00010\u00070\u00182\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R:\u0010\t\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00070\nj\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/task/TaskRegister;", "", "<init>", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/lang/Class;", "Lcom/obric/memorydata/task/AbsTask;", "prefixMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "register", "", ActivityLifecycle.NAME, "clazz", "isRegisteredAs", "", "registerPrefix", "prefix", "isPackageTask", "taskName", "registerPackageTask", "getTaskClz", "Lkotlin/Result;", "getTaskClz-IoAF18A", "(Ljava/lang/String;)Ljava/lang/Object;", "TaskNotFoundException", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TaskRegister {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TaskRegister f12863a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Class<? extends AbsTask>> f12864b = null;
    private static final LinkedHashMap<String, Class<? extends AbsTask>> c = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/task/TaskRegister$TaskNotFoundException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", NotificationCompat.CATEGORY_MESSAGE, "", "<init>", "(Ljava/lang/String;)V", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TaskNotFoundException extends IllegalStateException {
        public TaskNotFoundException(String r2) {
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            super(r2);
        }
    }

    static {
        f12863a = new TaskRegister();
        f12864b = new ConcurrentHashMap();
        c = new LinkedHashMap();
    }

    private TaskRegister() {
    }

    private final void c(String r3) {
        ((Map) ZeusTransformUtils.preCheckCast(f12864b, Map.class, "com.obric.memorydata.plugin")).put(r3, PackageTask.class);
    }

    public final void a(String r3, Class<? extends AbsTask> r4) {
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r4, "clazz");
        ((Map) ZeusTransformUtils.preCheckCast(f12864b, Map.class, "com.obric.memorydata.plugin")).put(r3, r4);
    }

    public final boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "taskName");
        Class r1 = (Class) ZeusTransformUtils.preCheckCast(f12864b.get(r2), Class.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return true;
    L7:
        return Intrinsics.areEqual(r1, PackageTask.class);
    }

    public final Object b(String r8) {
        Intrinsics.checkNotNullParameter(r8, ActivityLifecycle.NAME);
        LinkedHashMap<String, Class<? extends AbsTask>> r0 = c;
        monitor-enter(r0);
        Set<Map.Entry<String, Class<? extends AbsTask>>> r1 = r0.entrySet();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r1, "<get-entries>(...)");     // Catch: Throwable -> L28
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L28
    L5:
        Class r3 = null;
        if (r2.hasNext() == false) goto L10;
        Object r4 = r2.next();     // Catch: Throwable -> L28
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L28
        Object r6 = r5.getKey();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r6, "component1(...)");     // Catch: Throwable -> L28
        if (StringsKt.startsWith$default(r8, (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L5;
    L11:
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r7 == null) goto L14;
        r3 = (Class) ZeusTransformUtils.preCheckCast(r7.getValue(), Class.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
    L14:
        monitor-exit(r0);
        if (r3 == null) goto L18;
        Result.Companion r9 = Result.Companion;
        return Result.m1421constructorimpl(r3);
    L18:
        ConcurrentHashMap<String, Class<? extends AbsTask>> r10 = f12864b;
        Class r11 = (Class) ZeusTransformUtils.preCheckCast(r10.get(r8), Class.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L22;
        Result.Companion r12 = Result.Companion;
        return Result.m1421constructorimpl(r11);
    L22:
        c(r8);
        Class r13 = (Class) ZeusTransformUtils.preCheckCast(r10.get(r8), Class.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L26;
        Result.Companion r14 = Result.Companion;
        return Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(new TaskNotFoundException("package not registered"), Throwable.class, "com.obric.memorydata.plugin")));
    L26:
        Result.Companion r15 = Result.Companion;
        return Result.m1421constructorimpl(r13);
    L10:
        r4 = null;
    L28:
        th = move-exception;
        throw th;
    }

    public final boolean b(String r1, Class<? extends AbsTask> r2) {
        Intrinsics.checkNotNullParameter(r1, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r2, "clazz");
        return Intrinsics.areEqual(f12864b.get(r1), r2);
    }

    public final void c(String r3, Class<? extends AbsTask> r4) {
        Intrinsics.checkNotNullParameter(r3, "prefix");
        Intrinsics.checkNotNullParameter(r4, "clazz");
        LinkedHashMap<String, Class<? extends AbsTask>> r2 = c;
        monitor-enter(r2);
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.memorydata.plugin")).put(r3, r4);     // Catch: Throwable -> L7
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r2);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
