package com.obric.memorydata.memory.ui.list;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.sqlite.SQLiteException;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.room.InvalidationTracker;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.SettingsChangeListener;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoZonedDateTime;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.cu;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0003\u0015\u0018\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001d\u001a\u00020\fJ\u0006\u0010\u001e\u001a\u00020\u0005J\b\u0010\u001f\u001a\u00020\u0005H\u0002J \u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\fH\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0011H\u0002J\b\u0010)\u001a\u00020\fH\u0002J\u000e\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005J\b\u0010,\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006-"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationCoordinator;", "", "<init>", "()V", "CHANNEL_ID", "", "NOTIFICATION_ID", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "requests", "Lkotlinx/coroutines/channels/Channel;", "", "started", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ownerId", "scheduledAt", "", "Ljava/lang/Long;", "scheduledGeneration", "observer", "com/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationCoordinator$observer$1", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationCoordinator$observer$1;", "settingsListener", "com/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationCoordinator$settingsListener$1", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationCoordinator$settingsListener$1;", "timeReceiver", "com/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationCoordinator$timeReceiver$1", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationCoordinator$timeReceiver$1;", CommonConsts.APM_INNER_EVENT_COST_START, "evaluate", "evaluateReady", "nextAllowedTime", "now", "last", "config", "Lcom/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationConfig;", "scheduleRetry", "schedule", "", "due", "cancelScheduled", "onScheduledTime", PendingPersonalInfoNotificationTask.KEY_GENERATION, "sendNotification", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final at f11208a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.al f11209b = null;
    private static final kotlinx.coroutines.channels.i<Unit> c = null;
    private static final AtomicBoolean d = null;
    private static String e;
    private static Long f;
    private static String g;
    private static final PendingPersonalInfoNotificationCoordinator$observer$1 h = null;
    private static final a i = null;
    private static final b j = null;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationCoordinator$settingsListener$1", "Lcom/obric/memorydata/middleware/api/settings/SettingsChangeListener;", "onSettingsChanged", "", "key", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements SettingsChangeListener {
        a() {
        }

        @Override // com.obric.memorydata.middleware.api.settings.SettingsChangeListener
        public void onSettingsChanged(String r1) {
            Intrinsics.checkNotNullParameter(r1, "key");
            at.c().mo54trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/memory/ui/list/PendingPersonalInfoNotificationCoordinator$timeReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends PluginBroadcastReceiver {
        b() {
        }

        public void onReceive(Context r2, Intent r3) {
            Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), "context");
            Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
            at.c().mo54trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationCoordinator$observer$1] */
    static {
        f11208a = new at();
        f11209b = kotlinx.coroutines.am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        c = kotlinx.coroutines.channels.l.a(-1, null, null, 6, null);
        d = new AtomicBoolean(false);
        final String[] r0 = {"SemanticState"};
        h = new PendingPersonalInfoNotificationCoordinator$observer$1(r0);
        i = new a();
        j = new b();
    }

    private at() {
    }

    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object, java.time.ZonedDateTime] */
    private final long a(long r5, long r7, as r9) {
        if (r7 <= 0) goto L5;
        r5 = Math.max(r5, r7 + (r9.c() * ((long) 1000)));
    L5:
        ZonedDateTime r4 = Instant.ofEpochMilli(r5).atZone(ZoneId.systemDefault());
        ?? r8 = r4.toLocalDate().atTime(r9.d(), 0).atZone(r4.getZone());
        if (r9.e() != 24) goto L8;
        ChronoZonedDateTime<LocalDate> r10 = r4.toLocalDate().plusDays(1).atStartOfDay(r4.getZone());
    L10:
        if (r4.isBefore((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r8, ChronoZonedDateTime.class, "com.obric.memorydata.plugin")) == false) goto L14;
        Instant r6 = r8.toInstant();
    L16:
        return r6.toEpochMilli();
    L14:
        if (r4.isBefore((ChronoZonedDateTime) ZeusTransformUtils.preCheckCast(r10, ChronoZonedDateTime.class, "com.obric.memorydata.plugin")) == true) goto L17;
        r6 = r8.plusDays(1).toInstant();
        goto L16
    L17:
        return r5;
    L8:
        r10 = r4.toLocalDate().atTime(r9.e(), 0).atZone(r4.getZone());
        goto L10
    }

    private static final Unit a(boolean r1, com.obric.memorydata.middleware.api.logging.g r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$mainTrace");
        r2.a("watermark_saved", Boolean.valueOf(r1));
        return Unit.INSTANCE;
    }

    private final boolean a(long r9) {
        Long r0 = f;
        if (r0 != null) goto L6;
    L8:
        Object r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (ZeusTransformUtils.instanceOf(r1, AlarmManager.class) == false) goto L11;
        AlarmManager r2 = (AlarmManager) ZeusTransformUtils.preCheckCast(r1, AlarmManager.class, "com.obric.memorydata.plugin");
    L13:
        if (r2 != null) goto L15;
    L17:
        boolean r3 = false;
    L18:
        if (r3 == true) goto L21;
        f();
        return false;
    L21:
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().c(PendingPersonalInfoNotificationTask.NAME);
        String r8 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r8, "toString(...)");
        TaskRequest.Builder r4 = new TaskRequest.Builder(PendingPersonalInfoNotificationTask.NAME);
        JSONObject r5 = new JSONObject().put(PendingPersonalInfoNotificationTask.KEY_GENERATION, r8);
        Intrinsics.checkNotNullExpressionValue(r5, "put(...)");
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r4.setInputParam(r5), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay(new com.obric.memorydata.task.impl.g(RangesKt.coerceAtLeast(r9 - System.currentTimeMillis(), 1000), TimeUnit.MILLISECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTriggerExactly(true), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.SINGLE_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        f = Long.valueOf(r9);
        g = r8;
        return true;
    L15:
        if (r2.canScheduleExactAlarms() != true) goto L17;
        r3 = true;
        goto L18
    L11:
        r2 = null;
        goto L13
    L6:
        if (r0.longValue() != r9) goto L8;
        return true;
    }

    public static final /* synthetic */ kotlinx.coroutines.channels.i c() {
        return c;
    }

    private final String d() {
        as r7 = au.f11210a.a();
        PersonalMemoryFrameDb r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
        if (r7.a() == true) goto L5;
    L33:
        f();
        return "DISABLED_OR_MIGRATING";
    L5:
        if (com.obric.memorydata.database.manager.q.f9592a.a(r0.getSemanticStateDao().queryText("migration_phase")) == true) goto L33;
        if (r0.getSemanticMemoryDao().countPendingConfirmation() >= r7.b()) goto L11;
        f();
        return "BELOW_THRESHOLD";
    L11:
        IStore r8 = StoreManager.INSTANCE.getPersonalStore();
        if (r8 != null) goto L15;
        return "ACCOUNT_UNAVAILABLE";
    L15:
        long r9 = System.currentTimeMillis();
        long r1 = a(r9, r8.getLong("personal_info_confidence_last_notify_at", 0), r7);
        if (r1 <= r9) goto L23;
        if (a(r1) == false) goto L20;
        return "WAITING";
    L20:
        return "SCHEDULING_UNAVAILABLE";
    L23:
        if (g() == true) goto L26;
        e();
        return "NOTIFICATION_DISABLED";
    L26:
        final boolean r10 = r8.syncSave("personal_info_confidence_last_notify_at", r9);
        boolean r2 = a(a(r9, r9, r7));
        com.obric.memorydata.middleware.api.logging.o.a((com.obric.memorydata.middleware.api.logging.o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.u.f11636a, com.obric.memorydata.middleware.api.logging.o.class, "com.obric.memorydata.plugin"), "置信度通知已发送", "confirm_decision", null, new $$Lambda$at$Cve9GfcLeG9WXSZdAtazi0Yyv60(r10), null, 20, null);
        if (r10 == true) goto L29;
        return "WATERMARK_SAVE_FAILED";
    L29:
        if (r2 == true) goto L31;
        return "SENT_SCHEDULING_UNAVAILABLE";
    L31:
        return "SENT";
    }

    private final void e() {
        long r0 = System.currentTimeMillis() + ((long) 60000);
        Long r2 = f;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L10:
        r3 = false;
    L11:
        if (r3 == false) goto L13;
        return;
    L13:
        a(r0);
        return;
    L5:
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() > r0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 != true) goto L10;
    L7:
        r4 = false;
        goto L8
    }

    private final void f() {
        if (f == null) goto L5;
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().c(PendingPersonalInfoNotificationTask.NAME);
    L5:
        f = null;
        g = null;
    }

    private final boolean g() {
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Object r1 = r11.getSystemService("notification");
        if (ZeusTransformUtils.instanceOf(r1, NotificationManager.class) == false) goto L5;
        NotificationManager r2 = (NotificationManager) ZeusTransformUtils.preCheckCast(r1, NotificationManager.class, "com.obric.memorydata.plugin");
    L7:
        if (r2 != null) goto L10;
        return false;
    L10:
        if (r2.areNotificationsEnabled() == true) goto L12;
        return false;
    L12:
        r2.createNotificationChannel(new NotificationChannel("personal_info_confidence", (CharSequence) ZeusTransformUtils.preCheckCast(r11.getString(ZeusTransformUtils.mapRes(R.string.memory_pending_personal_info_title, TypedValues.Custom.S_STRING, "memory_pending_personal_info_title")), CharSequence.class, "com.obric.memorydata.plugin"), 4));
        NotificationChannel r3 = r2.getNotificationChannel("personal_info_confidence");
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L20;
        return false;
    L20:
        Intent r5 = new Intent().setClassName(r11.getPackageName(), "com.obric.memorydata.plugin_api.stub.activity.MemoryListActivity").addFlags(335544320).putExtra(MemoryListActivity.ARG_TARGET_CONTAINER_TAB, "PERSONAL_MEMORY");
        Intrinsics.checkNotNullExpressionValue(r5, "putExtra(...)");
        r2.notify(10423, new Notification.Builder(r11, "personal_info_confidence").setSmallIcon(ZeusTransformUtils.mapRes(R.drawable.ic_memory_ai_lab_settings_logo, "drawable", "ic_memory_ai_lab_settings_logo")).setContentTitle((CharSequence) ZeusTransformUtils.preCheckCast(r11.getString(ZeusTransformUtils.mapRes(R.string.memory_pending_notification_title, TypedValues.Custom.S_STRING, "memory_pending_notification_title")), CharSequence.class, "com.obric.memorydata.plugin")).setContentText((CharSequence) ZeusTransformUtils.preCheckCast(r11.getString(ZeusTransformUtils.mapRes(R.string.memory_pending_notification_body, TypedValues.Custom.S_STRING, "memory_pending_notification_body")), CharSequence.class, "com.obric.memorydata.plugin")).setVisibility(0).setContentIntent(PendingIntent.getActivity(r11, 10423, r5, 201326592)).setAutoCancel(true).build());
        return true;
    L15:
        if (r3.getImportance() != 0) goto L17;
        r4 = true;
        goto L18
    L5:
        r2 = null;
        goto L7
    }

    public static /* synthetic */ Unit lambda$Cve9GfcLeG9WXSZdAtazi0Yyv60(boolean r0, com.obric.memorydata.middleware.api.logging.g r1) {
        return a(r0, r1);
    }

    public final synchronized String a(String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, PendingPersonalInfoNotificationTask.KEY_GENERATION);     // Catch: Throwable -> L14
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L12;
        if (Intrinsics.areEqual(r3, g) == false) goto L12;
        f = null;     // Catch: Throwable -> L14
        g = null;     // Catch: Throwable -> L14
        String r4 = b();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r4;
    L12:
        monitor-exit(this);
        return "STALE_SCHEDULE";
    L14:
        th = move-exception;
        throw th;
    }

    public final void a() {
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == true) goto L5;
        return;
    L5:
        if (d.compareAndSet(false, true) == false) goto L10;
        e = UserSettings.INSTANCE.getUserId();
        TaskRegister.f12863a.a(PendingPersonalInfoNotificationTask.NAME, PendingPersonalInfoNotificationTask.class);
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getInvalidationTracker().addObserver((InvalidationTracker.Observer) ZeusTransformUtils.preCheckCast(h, InvalidationTracker.Observer.class, "com.obric.memorydata.plugin"));
        SettingsManager.INSTANCE.registerChangeListener("obric_memory_personal_info_confidence_settings", (SettingsChangeListener) ZeusTransformUtils.preCheckCast(i, SettingsChangeListener.class, "com.obric.memorydata.plugin"));
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        PluginBroadcastReceiver r0 = (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(j, PluginBroadcastReceiver.class, "com.obric.memorydata.plugin");
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.intent.action.TIME_SET");
        r1.addAction("android.intent.action.TIMEZONE_CHANGED");
        Unit r3 = Unit.INSTANCE;
        ZeusTransformUtils.registerReceiver(r10, r0, r1, "com.obric.memorydata.plugin");
        kotlinx.coroutines.i.a(f11209b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PendingPersonalInfoNotificationCoordinator$start$2(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        c.mo54trySendJP2dKIU(Unit.INSTANCE);
        return;
    }

    public final synchronized String b() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (UserSettings.INSTANCE.hasAgreePrivacyAndLogin() == false) goto L20;
        if (Intrinsics.areEqual(e, UserSettings.INSTANCE.getUserId()) == false) goto L20;
        String r0 = d();     // Catch: Exception -> L10 CancellationException -> L12 JSONException -> L14 SQLiteException -> L15 SecurityException -> L16 Throwable -> L22
    L17:
        monitor-exit(this);
        return r0;
    L15:
        e();     // Catch: Throwable -> L22
        r0 = "STORAGE_FAILED";
    L10:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PendingPersonalInfoNotification", "evaluate failed error_class=" + e.getClass().getSimpleName(), null, 4, null);     // Catch: Throwable -> L22
        r0 = "EVALUATE_FAILED";
    L16:
        r0 = "NOTIFICATION_PERMISSION_DENIED";
    L12:
        e = move-exception;
        throw e;     // Catch: Throwable -> L22
    L14:
        r0 = "INVALID_SETTINGS";
    L20:
        monitor-exit(this);
        return "ACCOUNT_UNAVAILABLE";
    }
}
