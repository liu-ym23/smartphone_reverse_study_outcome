package com.obric.memorydata.memory;

import android.graphics.Bitmap;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u001e2\u0006\u0010$\u001a\u00020\u001fJ5\u0010%\u001a\u00020&2\b\u0010$\u001a\u0004\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020(2\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0*2\u0006\u0010,\u001a\u00020\u0005¢\u0006\u0002\u0010-J\"\u0010.\u001a\u0004\u0018\u00010+2\u0006\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u00102J\"\u00103\u001a\u0004\u0018\u00010+2\u0006\u0010/\u001a\u0002042\b\b\u0002\u00105\u001a\u000206H\u0086@¢\u0006\u0002\u00107J\u0018\u00108\u001a\u0004\u0018\u00010+2\u0006\u0010/\u001a\u000209H\u0087@¢\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u001eJ\u000e\u0010=\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\"0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/obric/memorydata/memory/MemoryBuildHelper;", "", "<init>", "()V", "TAG", "", "KEY_TYPE", "KEY_ACTION", "KEY_RAW_QUERY", "KEY_REWRITE_QUERY", "KEY_SCREEN_TEXT", "KEY_SCREENSHOT", "KEY_SCREENSHOT_URL", "KEY_APP_NAME", "KEY_PACKAGE_NAME", "KEY_USE_CLOUD_MODEL", "KEY_ACTIVITY_NAME", "KEY_ENABLE_DEBUG", "KEY_FIX_INTENT", "KEY_FEATURE_GATES", "KEY_CONTACT_NAME", "KEY_TEXT", "KEY_TIMESTAMP", "AUTO_MEMORY_BUILD_CLIENT_TIMEOUT", "Lcom/obric/memorydata/task/impl/TaskTimeUnit;", "ACTIVE_MEMORY_BUILD_TIMEOUT", "screenshotId", "Ljava/util/concurrent/atomic/AtomicLong;", "screenshotToId", "", "Landroid/graphics/Bitmap;", "", "idToScreenshot", "screenshotRefCount", "", "getScreenshotById", OaidModel.KEY_ID, "taskResultHandle", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "Lorg/json/JSONObject;", "logInfo", "(Ljava/lang/Long;Lcom/obric/memorydata/task/impl/TaskInfo;Lkotlinx/coroutines/CancellableContinuation;Ljava/lang/String;)V", "executeActiveMemoryBuild", "inputData", "Lcom/obric/memorydata/memory/ActiveMemoryBuildInputData;", "timeOut", "(Lcom/obric/memorydata/memory/ActiveMemoryBuildInputData;Lcom/obric/memorydata/task/impl/TaskTimeUnit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeSmartMemoryBuild", "Lcom/obric/memorydata/memory/SmartMemoryBuildInputData;", "useCloudModel", "", "(Lcom/obric/memorydata/memory/SmartMemoryBuildInputData;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeFirstSmartMemoryBuild", "Lcom/obric/memorydata/memory/FirstSmartMemoryBuildInputData;", "(Lcom/obric/memorydata/memory/FirstSmartMemoryBuildInputData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addScreenShot", "screenshot", "removeScreenShot", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f10513a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.memorydata.task.impl.g f10514b = null;
    private static final com.obric.memorydata.task.impl.g c = null;
    private static AtomicLong d;
    private static final Map<Bitmap, Long> e = null;
    private static final Map<Long, Bitmap> f = null;
    private static final Map<Bitmap, Integer> g = null;

    static {
        f10513a = new t();
        f10514b = new com.obric.memorydata.task.impl.g(30, TimeUnit.SECONDS);
        c = new com.obric.memorydata.task.impl.g(20, TimeUnit.SECONDS);
        d = new AtomicLong(0);
        e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        f = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        g = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private t() {
    }

    public final long a(Bitmap r7) {
        Intrinsics.checkNotNullParameter(r7, "screenshot");
        Map<Bitmap, Long> r6 = e;
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(r6.get(r7), Long.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        long r1 = r0.longValue();
    L7:
        if (r1 != (-1)) goto L10;
        r1 = d.getAndIncrement();
        r6.put(r7, Long.valueOf(r1));
        f.put(Long.valueOf(r1), r7);
        Map<Bitmap, Integer> r8 = g;
        int r2 = 1;
    L9:
        r8.put(r7, r2);
    L13:
        return r1;
    L10:
        r8 = g;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r8.get(r7), Integer.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
        r2 = Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() + 1);
        goto L9
    L5:
        r1 = -1;
        goto L7
    }

    public final Bitmap a(long r1) {
        return (Bitmap) ZeusTransformUtils.preCheckCast(f.get(Long.valueOf(r1)), Bitmap.class, "com.obric.memorydata.plugin");
    }

    public final void b(long r7) {
        Map<Long, Bitmap> r6 = f;
        Bitmap r0 = (Bitmap) ZeusTransformUtils.preCheckCast(r6.get(Long.valueOf(r7)), Bitmap.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryBuildHelper", "not exist screenshot id: " + r7, null, 4, null);
        return;
    L6:
        Map<Bitmap, Integer> r1 = g;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(r1.get(r0), Integer.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L14;
        r1.put(r0, Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).intValue() - 1));
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.get(r0), Integer.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.intValue() == 0) goto L14;
        return;
    L14:
        e.remove(r0);
        r6.remove(Long.valueOf(r7));
        r1.remove(r0);
    }
}
