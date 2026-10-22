package com.obric.memorydata.memory.lab;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.ar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u001d\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019J\u0018\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/memory/lab/AILabApprovalNotificationHelper;", "", "<init>", "()V", "TAG", "", "NOTIFICATION_CHANNEL_ID", "NOTIFICATION_CHANNEL_NAME", "NOTIFICATION_ID", "", "SMALL_ICON_USE_APP_ICON", "STATUS_BAR_USE_APP_ICON", "MEMORY_SETTINGS_STUB_ACTIVITY", "CONTEXT_AWARENESS_SETTINGS_STUB_ACTIVITY", "PROACTIVE_ACTIVITY", "sendApprovalNotification", "", "context", "Landroid/content/Context;", "permissionName", "buildApprovalNotificationIntent", "Landroid/content/Intent;", "resolveApprovalNotificationTargetActivity", "hasContextAwarenessEntry", "", "resolveApprovalNotificationTargetActivity$memory_obricRelease", "getPermissionDisplayName", "buildNotificationId", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10245a = null;

    static {
        f10245a = new b();
    }

    private b() {
    }

    private final int a(String r1) {
        return Math.abs(r1.hashCode() % 1000) + 1001;
    }

    private final Intent b(Context r3, String r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        boolean r5 = ar.c();
        Intent r0 = new Intent();
        r0.setClassName(r2.getPackageName(), f10245a.a(r4, r5));
        r0.addFlags(335544320);
        return r0;
    }

    private final String c(Context r3, String r4) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        switch(r4.hashCode()) {
            case -1425020527: goto L18;
            case -33328734: goto L14;
            case 11238574: goto L10;
            case 1347676212: goto L6;
            default: goto L23;
        };
    L23:
        return r4;
    L6:
        if (r4.equals("screen_memory") == false) goto L24;
        int r5 = R.string.ailab_settings_screen_memory;
        String r6 = "ailab_settings_screen_memory";
    L21:
        String r7 = r2.getString(ZeusTransformUtils.mapRes(r5, TypedValues.Custom.S_STRING, r6));
        Intrinsics.checkNotNullExpressionValue(r7, "getString(...)");
        return r7;
    L24:
        return r4;
    L10:
        if (r4.equals("voice_memory") == false) goto L25;
        r5 = R.string.ailab_settings_voice_memory;
        r6 = "ailab_settings_voice_memory";
        goto L21
    L25:
        return r4;
    L14:
        if (r4.equals("ai_proactive_agent") == false) goto L26;
        r5 = R.string.memory_settings_ai_proactive_agent_title;
        r6 = "memory_settings_ai_proactive_agent_title";
        goto L21
    L26:
        return r4;
    L18:
        if (r4.equals("auto_memory") == false) goto L27;
        r5 = R.string.memory_settings_smart_memory_pro_title;
        r6 = "memory_settings_smart_memory_pro_title";
        goto L21
    L27:
        return r4;
    }

    public final String a(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "permissionName");
        int r2 = r3.hashCode();
        if (r2 == (-33328734)) goto L18;
        if (r2 == 11238574) goto L13;
        if (r2 == 1347676212) goto L10;
        return "com.obric.memorydata.plugin_api.stub.activity.MemorySettingsActivity";
    L10:
        if (r3.equals("screen_memory") == false) goto L22;
    L15:
        if (r4 == false) goto L23;
        return "com.obric.memorydata.plugin_api.stub.activity.ContextAwarenessSettingsActivity";
    L23:
        return "com.obric.memorydata.plugin_api.stub.activity.MemorySettingsActivity";
    L22:
        return "com.obric.memorydata.plugin_api.stub.activity.MemorySettingsActivity";
    L13:
        if (r3.equals("voice_memory") == true) goto L15;
        return "com.obric.memorydata.plugin_api.stub.activity.MemorySettingsActivity";
    L18:
        if (r3.equals("ai_proactive_agent") == false) goto L27;
        return "com.obric.aiproactive.ui.ProactiveStartupActivity";
    L27:
        return "com.obric.memorydata.plugin_api.stub.activity.MemorySettingsActivity";
    }

    public final void a(Context r12, String r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r13, "permissionName");
        Object r3 = r14.getSystemService("notification");     // Catch: IllegalArgumentException -> L12 SecurityException -> L14
        if (ZeusTransformUtils.instanceOf(r3, NotificationManager.class) == false) goto L6;
        NotificationManager r4 = (NotificationManager) ZeusTransformUtils.preCheckCast(r3, NotificationManager.class, "com.obric.memorydata.plugin");     // Catch: IllegalArgumentException -> L12 SecurityException -> L14
    L7:
        if (r4 != null) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabApprovalNotificationHelper", "send approval notification failed: NotificationManager missing", null, 4, null);     // Catch: IllegalArgumentException -> L12 SecurityException -> L14
        return;
    L10:
        r4.createNotificationChannel(new NotificationChannel("ai_lab_notification_channel", (CharSequence) ZeusTransformUtils.preCheckCast("AI_Lab_Notification", CharSequence.class, "com.obric.memorydata.plugin"), 3));     // Catch: IllegalArgumentException -> L12 SecurityException -> L14
        Notification.Builder r15 = new Notification.Builder(r14, "ai_lab_notification_channel").setSmallIcon(ZeusTransformUtils.mapRes(R.drawable.ic_memory_ai_lab_settings_logo, "drawable", "ic_memory_ai_lab_settings_logo")).setContentTitle((CharSequence) ZeusTransformUtils.preCheckCast(r14.getString(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval_done_notification, TypedValues.Custom.S_STRING, "ailab_settings_approval_done_notification"), new Object[]{c(r14, r13)}), CharSequence.class, "com.obric.memorydata.plugin")).setContentText((CharSequence) ZeusTransformUtils.preCheckCast(r14.getString(ZeusTransformUtils.mapRes(R.string.ailab_settings_approval_done_notification_subTitle, TypedValues.Custom.S_STRING, "ailab_settings_approval_done_notification_subTitle")), CharSequence.class, "com.obric.memorydata.plugin")).setContentIntent(PendingIntent.getActivity(r14, r13.hashCode(), b(r14, r13), 201326592)).setAutoCancel(true).setShowWhen(true);     // Catch: IllegalArgumentException -> L12 SecurityException -> L14
        r15.getExtras().putBoolean("small_icon_use_app_icon", false);     // Catch: IllegalArgumentException -> L12 SecurityException -> L14
        r15.getExtras().putBoolean("status_bar_use_app_icon", false);     // Catch: IllegalArgumentException -> L12 SecurityException -> L14
        Notification r16 = r15.build();     // Catch: IllegalArgumentException -> L12 SecurityException -> L14
        Intrinsics.checkNotNullExpressionValue(r16, "build(...)");     // Catch: IllegalArgumentException -> L12 SecurityException -> L14
        r4.notify(a(r13), r16);     // Catch: IllegalArgumentException -> L12 SecurityException -> L14
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AILabApprovalNotificationHelper", "send approval notification success, permissionName=" + r13, false, 4, null);     // Catch: IllegalArgumentException -> L12 SecurityException -> L14
        return;
    L6:
        r4 = null;
    L12:
        e = move-exception;
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r17 = new StringBuilder().append("send approval notification failed: ");
        String r11 = e.getMessage();
    L16:
        IRunLog.a.b(r5, "AILabApprovalNotificationHelper", r17.append(r11).toString(), null, 4, null);
        return;
    L14:
        e = move-exception;
        r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r17 = new StringBuilder().append("send approval notification failed: ");
        r11 = e.getMessage();
        goto L16
    }
}
