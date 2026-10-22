package com.obric.memorydata.memory.provider;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.obric.memorydata.constants.AppInfo;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.memory.calendar.CalenderOpenInfo;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u0019\u001a\u0004\u0018\u0001H\u001a\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001eH\u0002¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020(J\b\u0010)\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0018¨\u0006*"}, d2 = {"Lcom/obric/memorydata/memory/provider/AssistantHybridAbilityProviderUtil;", "", "<init>", "()V", "TAG", "", "AUTHORITY", "METHOD", "KEY_ACTION", "KEY_TARGET", "VALUE_TARGET_CALENDAR", "KEY_PAYLOAD", "KEY_SOURCE_APP_PACKAGE", "KEY_SOURCE_APP_NAME", "KEY_MEMORY_UUID", "KEY_ENTITY_TYPE", "KEY_RESULT", "KEY_EVENT_UUID", "KEY_AUTO_IMPORT", "DEFAULT_TIMEOUT_MS", "", "providerCallExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "callWithTimeout", ExifInterface.GPS_DIRECTION_TRUE, "methodTag", "timeoutMs", "task", "Lkotlin/Function0;", "(Ljava/lang/String;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "createCalendar", "Lcom/obric/memorydata/memory/calendar/CalendarResult;", "memoryCalendar", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "openCalendar", "", "eventUuid", "queryCalendarAutoImportMemory", "", "checkProviderExist", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f10359a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExecutorService f10360b = null;

    static {
        f10359a = new b();
        f10360b = Executors.newSingleThreadExecutor($$Lambda$b$ZpRCTIgWlYYhdrNWAvh6NmY3ao.INSTANCE);
    }

    private b() {
    }

    private final <T> T a(String r10, long r11, Function0<? extends T> r13) {
        final Function0 r14 = (Function0) ZeusTransformUtils.wrapperContextForParams(r13, Function0.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantHybridAbilityProviderUtil", "call " + r10, false, 4, null);     // Catch: Exception -> L5 TimeoutException -> L10
    L15:
        return f10360b.submit(new $$Lambda$b$jD3u9alLYl4DSEyqOLxvDBZEhIE(r14)).get(r11, TimeUnit.MILLISECONDS);
    L10:
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder().append("call ").append(r10).append(" timeout");
    L11:
        IRunLog.a.a(r1, "AssistantHybridAbilityProviderUtil", r9.toString(), null, 4, null);
        return null;
    L5:
        e = move-exception;
        if (ZeusTransformUtils.instanceOf(e, InterruptedException.class) == false) goto L9;
        Thread.currentThread().interrupt();
    L9:
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r9 = new StringBuilder().append("call ").append(r10).append(" exception: ").append(e);
        goto L11
    }

    private static final Object a(Function0 r2) {
        return ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "AssistantProviderThread");
    }

    private static final com.obric.memorydata.memory.calendar.a b(PendingMemoryCalendar r11) {
        ContentResolver r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();     // Catch: Exception -> L20
        Bundle r8 = new Bundle();     // Catch: Exception -> L20
        r8.putString("action", "create_calendar");     // Catch: Exception -> L20
        r8.putString(TypedValues.AttributesType.S_TARGET, "com.flow.calendar");     // Catch: Exception -> L20
        r8.putString("payload", u.a(r11));     // Catch: Exception -> L20
        r8.putString("sourceAppPackage", r11.getSourceAppPackage());     // Catch: Exception -> L20
        r8.putString("sourceAppName", r11.getSourceAppName());     // Catch: Exception -> L20
        String r3 = r11.getMemoryUuid();     // Catch: Exception -> L20
        if (r3 == null) goto L6;
        r8.putString("memoryUuid", r3);     // Catch: Exception -> L20
    L6:
        Integer r12 = r11.getEntityType();     // Catch: Exception -> L20
        if (r12 == null) goto L9;
        r8.putInt("entityType", ((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.memorydata.plugin")).intValue());     // Catch: Exception -> L20
    L9:
        Unit r13 = Unit.INSTANCE;     // Catch: Exception -> L20
        Bundle r14 = ZeusProviderTransform.call(r4, "com.obric.assistant.provider.AssistantHybridAbilityProvider", "send_request_to_mini", null, r8, "com.obric.memorydata.plugin");     // Catch: Exception -> L20
        boolean r5 = true;
        if (r14 != null) goto L12;
    L14:
        r5 = false;
    L15:
        if (r14 == null) goto L17;
        String r15 = r14.getString("eventUuid");     // Catch: Exception -> L20
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantHybridAbilityProviderUtil", "createCalendar result: " + r5 + ", eventUuid: " + r15, false, 4, null);     // Catch: Exception -> L20
        return new com.obric.memorydata.memory.calendar.a(r5, r15);
    L17:
        r15 = null;
        goto L18
    L12:
        if (r14.getInt("result") != 1) goto L14;
    L20:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantHybridAbilityProviderUtil", "createCalendar exception: " + e, null, 4, null);
        return new com.obric.memorydata.memory.calendar.a(false, null);
    }

    private final boolean b() {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager().resolveContentProvider("com.obric.assistant.provider.AssistantHybridAbilityProvider", 0) == null) goto L6;
        return true;
    L6:
        return false;
    }

    private static final boolean c() {
        ContentResolver r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();     // Catch: Exception -> L13
        Bundle r7 = new Bundle();     // Catch: Exception -> L13
        r7.putString("action", "query_auto_import_settings");     // Catch: Exception -> L13
        r7.putString(TypedValues.AttributesType.S_TARGET, "com.flow.calendar");     // Catch: Exception -> L13
        Unit r2 = Unit.INSTANCE;     // Catch: Exception -> L13
        Bundle r4 = ZeusProviderTransform.call(r3, "com.obric.assistant.provider.AssistantHybridAbilityProvider", "send_request_to_mini", null, r7, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        if (r4 == null) goto L6;
        Integer r5 = Integer.valueOf(r4.getInt("autoImport"));     // Catch: Exception -> L13
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantHybridAbilityProviderUtil", "queryCalendarAutoImportMemory autoImport: " + r5, false, 4, null);     // Catch: Exception -> L13
        if (r5 == null) goto L18;
        if (r5.intValue() == 1) goto L20;
        return false;
    L20:
        return true;
    L18:
        return false;
    L6:
        r5 = null;
    L13:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantHybridAbilityProviderUtil", "queryCalendarAutoImportMemory exception: " + e, null, 4, null);
        return false;
    }

    /* JADX INFO: renamed from: lambda$WBO4fxlkJe_gQr5nLHA-XlOGtwU, reason: not valid java name */
    public static /* synthetic */ boolean m747lambda$WBO4fxlkJe_gQr5nLHAXlOGtwU() {
        return c();
    }

    /* JADX INFO: renamed from: lambda$ZpRCTIgWlYYhdrN-WAvh6NmY3ao, reason: not valid java name */
    public static /* synthetic */ Thread m748lambda$ZpRCTIgWlYYhdrNWAvh6NmY3ao(Runnable r0) {
        return a(r0);
    }

    public static /* synthetic */ com.obric.memorydata.memory.calendar.a lambda$d2IoxVL99MkMm0bSpcEYZnR0by4(PendingMemoryCalendar r0) {
        return b(r0);
    }

    public static /* synthetic */ Object lambda$jD3u9alLYl4DSEyqOLxvDBZEhIE(Function0 r0) {
        return a(r0);
    }

    public final com.obric.memorydata.memory.calendar.a a(final PendingMemoryCalendar r10) {
        Intrinsics.checkNotNullParameter(r10, "memoryCalendar");
        if (b() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantHybridAbilityProviderUtil", "createCalendar provider not exist", null, 4, null);
        return new com.obric.memorydata.memory.calendar.a(false, null);
    L6:
        com.obric.memorydata.memory.calendar.a r9 = (com.obric.memorydata.memory.calendar.a) ZeusTransformUtils.preCheckCast(a("createCalendar", 5000, new $$Lambda$b$d2IoxVL99MkMm0bSpcEYZnR0by4(r10)), com.obric.memorydata.memory.calendar.a.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L9;
        return r9;
    L9:
        return new com.obric.memorydata.memory.calendar.a(false, null);
    }

    public final void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "eventUuid");
        Intent r3 = new Intent();
        r3.setComponent(new ComponentName(AppInfo.OAssistant.getPackageName(), "com.obric.miniapp.view.CalendarMiniAppActivity"));
        r3.putExtra("appId", "com.flow.calendar");
        r3.putExtra("pageId", "event");
        r3.putExtra("fromLauncher", true);
        r3.putExtra("pageData", u.a(new CalenderOpenInfo(r4, null, 2, null)));
        com.obric.memorydata.memory.utils.f.f11537a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3);
    }

    public final boolean a() {
        if (b() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantHybridAbilityProviderUtil", "queryCalendarAutoImportMemory provider not exist", null, 4, null);
        return false;
    L6:
        Boolean r8 = (Boolean) ZeusTransformUtils.preCheckCast(a("queryCalendarAutoImportMemory", 5000, $$Lambda$b$WBO4fxlkJe_gQr5nLHAXlOGtwU.INSTANCE), Boolean.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L9;
        return false;
    L9:
        return r8.booleanValue();
    }
}
