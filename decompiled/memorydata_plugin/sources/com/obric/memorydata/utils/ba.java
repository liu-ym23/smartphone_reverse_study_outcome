package com.obric.memorydata.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.TaskInfo;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.zetetic.database.sqlcipher.SQLiteDatabase;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u001a\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a\n\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\u0006\u0010\t\u001a\u00020\n\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\fH\u0002\u001a\b\u0010\r\u001a\u00020\u0006H\u0007\u001a\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\n\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\n\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007\u001a\n\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0007\u001a\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u001a\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0001H\u0007\u001a\u000f\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u0014H\u0086\u0010\u001a\f\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u0014\u001a\f\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u00020\u0014\u001a\n\u0010\u001e\u001a\u00020\u0019*\u00020\u0014\u001a\n\u0010\u001f\u001a\u00020\u001b*\u00020\u0014\u001a\n\u0010 \u001a\u00020\u001d*\u00020\u0014\u001a\u0014\u0010!\u001a\u00020\n*\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0007\u001a,\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0019H\u0007\u001a \u0010*\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u00012\b\b\u0002\u0010,\u001a\u00020\u0006\u001a\"\u0010*\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0001\u0010-\u001a\u00020\u00062\b\b\u0002\u0010,\u001a\u00020\u0006\u001a\u000e\u0010.\u001a\u00020%2\u0006\u0010)\u001a\u00020\u0019\u001a\u0006\u0010/\u001a\u00020\n\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"TAG", "", "DOUBAO_APPLET_CLASS_NAME_PREFIX", "getCurrentTopActivity", "Landroid/content/ComponentName;", "getCurrentTopTaskId", "", "()Ljava/lang/Integer;", "getCurrentTopActivityIgnoreFreeform", "isFront", "", "isFreeformTask", "Landroid/app/TaskInfo;", "getCurrentTaskNumActivities", "getCurrentTopActivityIgnoreAssistantAndFreeform", "getCurrentTopActivityIgnoreAssistantNoneAppletAndFreeform", "getCurrentTopActivityIgnoreMyselfAndFreeform", "getSecondTopPackageNameOrFirst", "getForegroundAppPackageName", "context", "Landroid/content/Context;", "getAllImageFiles", "", "directoryPath", "findActivity", "Landroid/app/Activity;", "findComponentActivity", "Landroidx/activity/ComponentActivity;", "findFragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "requireActivity", "requireComponentActivity", "requireFragmentActivity", "safeStartActivity", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "copyTextToClipboard", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, AnnotatedPrivateKey.LABEL, "toastText", "activity", "showToast", NotificationCompat.CATEGORY_MESSAGE, "pos", "resId", "checkAndDismissKeyguard", "isKeyguardLocked", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ba {
    public static final ComponentName a() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("activity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningTaskInfo> r1 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r0, ActivityManager.class, "com.obric.memorydata.plugin")).getRunningTasks(1);
        if (r1 == null) goto L7;
        ActivityManager.RunningTaskInfo r2 = (ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r1, 0), ActivityManager.RunningTaskInfo.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        return r2.topActivity;
    L7:
        return null;
    }

    public static final String a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Object r6 = r5.getSystemService("activity");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<ActivityManager.RunningAppProcessInfo> r7 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r6, ActivityManager.class, "com.obric.memorydata.plugin")).getRunningAppProcesses().iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        ActivityManager.RunningAppProcessInfo r0 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r7.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");
        if (r0.importance != 100) goto L4;
        return r0.pkgList[0];
    L9:
        return null;
    }

    public static final void a(Activity r8) {
        Activity r9 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "activity");
        Object r0 = r9.getSystemService("keyguard");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        KeyguardManager r1 = (KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskUtil", "checkAndDismissKeyguard: " + r1.isKeyguardLocked(), false, 4, null);
        if (r1.isKeyguardLocked() == false) goto L6;
        r1.requestDismissKeyguard(r9, null);
        return;
    }

    public static final void a(Context r2, int r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        String r6 = r5.getString(r3);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(...)");
        a(r5, r6, r4);
    }

    public static /* synthetic */ void a(Context r1, int r2, int r3, int r4, Object r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        if ((r4 & 4) == 0) goto L5;
        r3 = 80;
    L5:
        a(r6, r2, r3);
    }

    public static final void a(Context r11, String r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r12, NotificationCompat.CATEGORY_MESSAGE);
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b(r14), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        new com.obric.oui.toast.a((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"), r12, r13, false, null, 0, 48, null).d();
        return;
    L5:
        Toast.makeText(r14, (CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), 0).show();
    }

    public static /* synthetic */ void a(Context r1, String r2, int r3, int r4, Object r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        if ((r4 & 4) == 0) goto L5;
        r3 = 80;
    L5:
        a(r6, r2, r3);
    }

    public static final void a(String r3, String r4, String r5, Activity r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r6, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        Intrinsics.checkNotNullParameter(r4, AnnotatedPrivateKey.LABEL);
        Intrinsics.checkNotNullParameter(r5, "toastText");
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("clipboard");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) ZeusTransformUtils.preCheckCast(r0, ClipboardManager.class, "com.obric.memorydata.plugin")).setPrimaryClip(ClipData.newPlainText((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")));
        if (r7 == null) goto L5;
        Object r8 = ZeusTransformUtils.preCheckCast(r7, Context.class, "com.obric.memorydata.plugin");
    L6:
        a((Context) r8, r5, 0, 4, null);
        return;
    L5:
        r8 = ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public static /* synthetic */ void a(String r1, String r2, String r3, Activity r4, int r5, Object r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        if ((r5 & 8) == 0) goto L5;
        r7 = null;
    L5:
        a(r1, r2, r3, r7);
    }

    private static final boolean a(TaskInfo r5) {
        Method r2 = TaskInfo.class.getDeclaredMethod("isFreeform", new Class[0]);     // Catch: Exception -> L5
        r2.setAccessible(true);     // Catch: Exception -> L5
        Object r6 = r2.invoke(r5, new Object[0]);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L5
        return ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("TaskUtil", "isFreeformTask", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    public static final boolean a(Context r9, Intent r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r10, MemorySourceLinkType.INTENT);
    L15:
        e = e;
        RunLog r3 = RunLog.INSTANCE;
        StringBuilder r4 = new StringBuilder();
        String r5 = "Activity not found: ";
    L17:
        r3.error("TaskUtil", r4.append(r5).append(r10).toString(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    L13:
        e = e;
        r3 = RunLog.INSTANCE;
        r4 = new StringBuilder();
        r5 = "Permission denied to start activity: ";
    L11:
        e = e;
        r3 = RunLog.INSTANCE;
        r4 = new StringBuilder();
        r5 = "Unknown error starting activity: ";
        goto L17
    L4:
        if (r10.resolveActivity(r11.getPackageManager()) != null) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskUtil", "No Activity found to handle intent: " + r10, null, 4, null);     // Catch: Exception -> L11 SecurityException -> L13 ActivityNotFoundException -> L15
        return false;
    L6:
        if (((Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b(r11), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin")) != null) goto L8;
        r10.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);     // Catch: Exception -> L11 SecurityException -> L13 ActivityNotFoundException -> L15
    L8:
        ZeusTransformUtils.startActivity(r11, r10, "com.obric.memorydata.plugin");     // Catch: Exception -> L11 SecurityException -> L13 ActivityNotFoundException -> L15
        return true;
    }

    public static final Activity b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
    L4:
        if (ZeusTransformUtils.instanceOf(r3, Activity.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, ContextWrapper.class) == false) goto L9;
        r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r3, ContextWrapper.class, "com.obric.memorydata.plugin")).getBaseContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "getBaseContext(...)");
        goto L4
    L9:
        return null;
    L13:
        return (Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.memorydata.plugin");
    }

    public static final ComponentName b() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("activity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningTaskInfo> r1 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r0, ActivityManager.class, "com.obric.memorydata.plugin")).getRunningTasks(5);
        if (r1 == null) goto L18;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        Object r3 = r2.next();
        ActivityManager.RunningTaskInfo r4 = (ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r3, ActivityManager.RunningTaskInfo.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r4);
        if ((!a((TaskInfo) ZeusTransformUtils.preCheckCast(r4, TaskInfo.class, "com.obric.memorydata.plugin"))) == false) goto L6;
    L11:
        ActivityManager.RunningTaskInfo r5 = (ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r3, ActivityManager.RunningTaskInfo.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L14;
        return null;
    L14:
        return r5.topActivity;
    L10:
        r3 = null;
        goto L11
    L18:
        return null;
    }

    public static final int c() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("activity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningTaskInfo> r1 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r0, ActivityManager.class, "com.obric.memorydata.plugin")).getRunningTasks(1);
        if (r1 == null) goto L8;
        ActivityManager.RunningTaskInfo r2 = (ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r1, 0), ActivityManager.RunningTaskInfo.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.numActivities;
    L8:
        return 0;
    }

    public static final ComponentName d() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("activity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningTaskInfo> r1 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r0, ActivityManager.class, "com.obric.memorydata.plugin")).getRunningTasks(5);
        if (r1 == null) goto L39;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r2.hasNext() == false) goto L28;
        Object r3 = r2.next();
        ActivityManager.RunningTaskInfo r4 = (ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r3, ActivityManager.RunningTaskInfo.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r4);
        boolean r6 = true;
        if (a((TaskInfo) ZeusTransformUtils.preCheckCast(r4, TaskInfo.class, "com.obric.memorydata.plugin")) == true) goto L25;
        String r5 = AppInfo.OAssistant.getPackageName();
        ComponentName r8 = r4.topActivity;
        if (r8 == null) goto L12;
        String r9 = r8.getPackageName();
    L14:
        if (Intrinsics.areEqual(r5, r9) == false) goto L26;
        ComponentName r7 = r4.topActivity;
        if (r7 == null) goto L22;
        String r10 = r7.getClassName();
        if (r10 == null) goto L22;
        if (StringsKt.startsWith$default(r10, "com.obric.miniapp", false, 2, null) != true) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == false) goto L25;
    L22:
        r11 = false;
    L26:
        if (r6 == false) goto L6;
    L29:
        ActivityManager.RunningTaskInfo r12 = (ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r3, ActivityManager.RunningTaskInfo.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L32;
        return null;
    L32:
        return r12.topActivity;
    L12:
        r9 = null;
    L25:
        r6 = false;
        goto L26
    L28:
        r3 = null;
        goto L29
    L39:
        return null;
    }

    public static final ComponentName e() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("activity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningTaskInfo> r1 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r0, ActivityManager.class, "com.obric.memorydata.plugin")).getRunningTasks(5);
        if (r1 == null) goto L29;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r2.hasNext() == false) goto L19;
        Object r3 = r2.next();
        ActivityManager.RunningTaskInfo r4 = (ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r3, ActivityManager.RunningTaskInfo.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r4);
        if (a((TaskInfo) ZeusTransformUtils.preCheckCast(r4, TaskInfo.class, "com.obric.memorydata.plugin")) == true) goto L16;
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageName();
        ComponentName r6 = r4.topActivity;
        if (r6 == null) goto L12;
        String r7 = r6.getPackageName();
    L14:
        if (Intrinsics.areEqual(r5, r7) == true) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L6;
    L20:
        ActivityManager.RunningTaskInfo r9 = (ActivityManager.RunningTaskInfo) ZeusTransformUtils.preCheckCast(r3, ActivityManager.RunningTaskInfo.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L23;
        return null;
    L23:
        return r9.topActivity;
    L12:
        r7 = null;
    L16:
        r8 = false;
        goto L17
    L19:
        r3 = null;
        goto L20
    L29:
        return null;
    }

    public static final boolean f() {
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("keyguard");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return ((KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.memorydata.plugin")).isKeyguardLocked();
    }
}
