package com.obric.assistant.system;

import android.app.ActivityManager;
import android.app.TaskStackListener;
import android.content.ComponentName;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.keyguard.KeyguardService;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import el9.a;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import lha.g;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0016J\u0017\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\"\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010!\u001a\u0004\u0018\u00010 2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\f\u0010\"\u001a\u00020\u001a*\u00020\u000eH\u0002J\u001c\u0010#\u001a\u00020\u00112\b\u0010$\u001a\u0004\u0018\u00010\u000e2\b\u0010%\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010)\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010 2\u0006\u0010'\u001a\u00020(H\u0002J\u0017\u0010+\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020 H\u0002¢\u0006\u0002\u0010-J\u0017\u0010.\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020 H\u0002¢\u0006\u0002\u0010-J\u001f\u0010/\u001a\u0004\u0018\u00010(2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\u00112\u0006\u0010\b\u001a\u000206H\u0003J\u001f\u00107\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\b8J\u001d\u00109\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010:\u001a\u00020(H\u0000¢\u0006\u0002\b;R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/obric/assistant/system/TaskStackServiceImpl;", "Lcom/obric/assistant/system/ITaskStackService;", "<init>", "()V", "activityManager", "Landroid/app/ActivityManager;", "getActivityManager", "()Landroid/app/ActivityManager;", "taskStackListener", "Lcom/obric/assistant/system/MyTaskStackListener;", "systemTaskStackListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/assistant/system/ITaskStackListener;", "componentName", "Landroid/content/ComponentName;", "previousComponentName", "init", "", "registerTaskStackListener", "listener", "unregisterTaskStackListener", "getTopComponentName", "getTopComponentNameExcludingIgnoredActivities", "getPreviousTopComponentName", "updateTopAppInfo", "isOnChange", "", "updateTopAppInfo$impl_mainlandRelease", "findTopComponentName", "excludeIgnoredActivities", "tasks", "", "Landroid/app/ActivityManager$RunningTaskInfo;", "findDefaultDisplayTask", "isIgnoredTopActivityComponent", "notifyListeners", "fromTop", "toTop", "notifyTaskCreated", DBDefinition.TASK_ID, "", "shouldDispatchTaskCreated", "findRunningTaskByTaskId", "readTaskDisplayId", "taskInfo", "(Landroid/app/ActivityManager$RunningTaskInfo;)Ljava/lang/Integer;", "readTaskId", "readIntField", "target", "", "fieldName", "", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Integer;", "registerSystemTaskStackListener", "Landroid/app/TaskStackListener;", "onTaskCreated", "onTaskCreated$impl_mainlandRelease", "onTaskDisplayChanged", "newDisplayId", "onTaskDisplayChanged$impl_mainlandRelease", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskStackServiceImpl implements ITaskStackService {
    public ActivityManager a;
    public final MyTaskStackListener b;
    public final CopyOnWriteArrayList<g> c;
    public volatile ComponentName d;
    public volatile ComponentName e;

    static {
    }

    public final ComponentName e() {
        ComponentName r0 = g(true);
        if (r0 != null) goto L18;
        ComponentName r1 = this.d;
        if (r1 != null) goto L7;
    L9:
        r1 = null;
    L10:
        if (r1 != null) goto L19;
        ComponentName r2 = this.e;
        if (r2 == null) goto L17;
        if (Intrinsics.areEqual(r2, KeyguardService.a.getHelperActivityComponentName()) == true) goto L17;
        return r2;
    L17:
        return null;
    L19:
        return r1;
    L7:
        if (Intrinsics.areEqual(r1, KeyguardService.a.getHelperActivityComponentName()) == true) goto L9;
    L18:
        return r0;
    }

    public final ActivityManager h() {
        ActivityManager r0 = this.a;
        if (r0 == null) goto L11;
        return r0;
    L11:
        Object r1 = AppHost.a.getApplication().getSystemService("activity");     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L7
        ActivityManager r2 = (ActivityManager) r1;     // Catch: Throwable -> L7
    L9:
        this.a = r2;
        return r2;
    L7:
        th = move-exception;
        FLogger.a.e("TaskStackService", "get ActivityManager exception", th);
        r2 = null;
        goto L9
    }

    public final void init() {
        TaskStackListener r0 = this.b;
        Class r2 = f("android.app.ActivityTaskManager");     // Catch: Exception -> L5
        Method r3 = r2.getDeclaredMethod("getInstance", new Class[0]);     // Catch: Exception -> L5
        r3.setAccessible(true);     // Catch: Exception -> L5
        Object r4 = r3.invoke(null, new Object[0]);     // Catch: Exception -> L5
        Method r5 = r2.getDeclaredMethod("registerTaskStackListener", new Class[]{f("android.app.TaskStackListener")});     // Catch: Exception -> L5
        r5.setAccessible(true);     // Catch: Exception -> L5
        r5.invoke(r4, new Object[]{r0});     // Catch: Exception -> L5
        FLogger.a.i("TaskStackService", "registerTaskStackListener success!");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.a.e("TaskStackService", "registerTaskStackListener failed!", e);
    }

    public TaskStackServiceImpl() {
        this.b = new MyTaskStackListener(this);
        this.c = new CopyOnWriteArrayList();
    }

    public final ComponentName b() {
        return this.e;
    }

    public final ComponentName c() {
        return this.d;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class f(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static void j(TaskStackServiceImpl r7) {
        boolean r0 = false;
        ComponentName r1 = r7.g(false);
        if (r1 != null) goto L5;
    L7:
        if (r0 == true) goto L24;
        r7.e = r7.d;
        FLogger.a.i("TaskStackService", "onTaskStackChanged isOnChange: true from topActivity: " + r7.d + ", to topActivity: " + r1);
        ComponentName r2 = r7.d;
        Iterator<g> r3 = r7.c.iterator();
    L10:
        if (r3.hasNext() == false) goto L16;
        r3.next().onChange(r2, r1);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        FLogger.a.e("TaskStackService", "notify listener error", th);
        goto L10
    L16:
        r7.d = r1;
        return;
    L24:
        return;
    L5:
        if (r1.equals(r7.d) != true) goto L7;
        r0 = true;
        goto L7
    }

    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.c.remove(r2);
    }

    public final void d(g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.c.contains(r2) == true) goto L6;
        this.c.add(r2);
        return;
    }

    public final ComponentName g(boolean r8) {
        ActivityManager r1 = h();     // Catch: Throwable -> L7
        if (r1 == null) goto L9;
        List<ActivityManager.RunningTaskInfo> r2 = r1.getRunningTasks(5);     // Catch: Throwable -> L7
    L10:
        List<ActivityManager.RunningTaskInfo> r3 = r2;
        if (r3 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L20;
        return null;
    L20:
        if (r8 == true) goto L39;
        Iterator<T> r9 = r2.iterator();
    L23:
        if (r9.hasNext() == false) goto L33;
        Object r5 = r9.next();
        Integer r6 = i((ActivityManager.RunningTaskInfo) r5, "displayId");
        if (r6 != null) goto L27;
    L30:
        boolean r7 = true;
    L31:
        if (r7 == false) goto L23;
    L34:
        ActivityManager.RunningTaskInfo r10 = (ActivityManager.RunningTaskInfo) r5;
        if (r10 != null) goto L37;
        r10 = (ActivityManager.RunningTaskInfo) CollectionsKt.getOrNull(r2, 0);
    L37:
        if (r10 != null) goto L78;
        return null;
    L78:
        return r10.topActivity;
    L27:
        if (r6.intValue() == 0) goto L30;
        r7 = false;
        goto L31
    L33:
        r5 = null;
        goto L34
    L39:
        Iterator<ActivityManager.RunningTaskInfo> r11 = r2.iterator();
    L41:
        if (r11.hasNext() == false) goto L53;
        ActivityManager.RunningTaskInfo r12 = r11.next();
        Integer r13 = i(r12, "displayId");
        if (r13 == null) goto L47;
        if (r13.intValue() != 0) goto L41;
    L47:
        ComponentName r14 = r12.topActivity;
        if (r14 == null) goto L41;
        if (Intrinsics.areEqual(r14, KeyguardService.a.getHelperActivityComponentName()) == true) goto L41;
        return r14;
    L53:
        ActivityManager.RunningTaskInfo r15 = (ActivityManager.RunningTaskInfo) CollectionsKt.getOrNull(r2, 0);
        if (r15 == null) goto L80;
        ComponentName r16 = r15.topActivity;
        if (r16 != null) goto L58;
        return null;
    L58:
        if (Intrinsics.areEqual(r16, KeyguardService.a.getHelperActivityComponentName()) == false) goto L60;
        return null;
    L60:
        return r16;
    L80:
        return null;
    L13:
        if (r3.isEmpty() == true) goto L16;
        r4 = false;
    L9:
        r2 = null;
    L7:
        th = move-exception;
        FLogger.a.e("TaskStackService", "getRunningTasks failed", th);
        goto L9
    }

    public static Integer i(Object r1, String r2) {
        return Integer.valueOf(r1.getClass().getField(r2).getInt(r1));
    L4:
        return null;
    }
}
