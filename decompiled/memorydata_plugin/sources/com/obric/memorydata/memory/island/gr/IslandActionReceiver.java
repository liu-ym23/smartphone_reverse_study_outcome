package com.obric.memorydata.memory.island.gr;

import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/IslandActionReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onReceive", "", "context", "Landroid/content/Context;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "handleCardClick", "handleCalendarCancel", "handleCalendarConfirm", "handleOpenCalendar", "eventUuid", "", "openEventWithTimeExtras", "", "eventId", "", "parseDurationToMillis", "duration", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IslandActionReceiver extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10201a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final al f10202b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/IslandActionReceiver$Companion;", "", "<init>", "()V", "TAG", "", "ACTION_CARD_CLICK", "ACTION_CALENDAR_CANCEL", "ACTION_CALENDAR_CONFIRM", "ACTION_OPEN_CALENDAR", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f10201a = new a(null);
    }

    public IslandActionReceiver() {
        this.f10202b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")));
    }

    private final long a(String r7) {
        MatchResult r8 = Regex.find$default(new Regex("P(?:T)?(\\d+)([SMHD])"), (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);     // Catch: Exception -> L34
        if (r8 != null) goto L6;
        return ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
    L6:
        long r2 = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r8.getGroupValues().get(1), String.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L34
        String r6 = (String) ZeusTransformUtils.preCheckCast(r8.getGroupValues().get(2), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L34
        int r9 = r6.hashCode();     // Catch: Exception -> L34
        if (r9 == 68) goto L28;
        if (r9 == 72) goto L24;
        if (r9 == 77) goto L20;
        if (r9 == 83) goto L16;
        return ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
    L16:
        if (r6.equals("S") == false) goto L37;
        long r10 = 1000;
    L31:
        long r3 = r2 * r10;
    L33:
        return r3;
    L37:
        return ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
    L20:
        if (r6.equals("M") == false) goto L38;
        r10 = 60000;
        goto L31
    L38:
        return ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
    L24:
        if (r6.equals(i.n) == false) goto L39;
        r3 = r2 * ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;     // Catch: Exception -> L34
        goto L33
    L39:
        return ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
    L28:
        if (r6.equals(com.tom_roush.pdfbox.pdmodel.a.c.a.f16161b) == false) goto L40;
        r10 = WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        goto L31
    L40:
        return ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
    L41:
        return ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
    }

    public static final /* synthetic */ al a(IslandActionReceiver r0) {
        return r0.f10202b;
    }

    private final void a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleCalendarCancel: 用户点击了取消/忽略日历", false, 4, null);
        kotlinx.coroutines.i.a(this.f10202b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandActionReceiver$handleCalendarCancel$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void a(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("IslandActionReceiver", "handleCardClick: starting coroutine");
        kotlinx.coroutines.i.a(this.f10202b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandActionReceiver$handleCardClick$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void a(Context r18, String r19) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleOpenCalendar: eventUuid=" + r19, false, 4, null);
        kotlinx.coroutines.i.a(this.f10202b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandActionReceiver$handleOpenCalendar$1(r19, this, r2, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15, types: [long] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v2, types: [long] */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v3, types: [long] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8, types: [long] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2, types: [long] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v3, types: [long] */
    /* JADX WARN: Type inference failed for: r14v5, types: [android.content.ContentResolver, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8, types: [long] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.lang.StringBuilder] */
    private final boolean a(Context r22, long r23) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r22, Context.class, "com.obric.memorydata.plugin");
        String r6 = null;
        ?? r12 = "dtend";
        Uri r15 = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, r23);     // Catch: Exception -> L44
        Intrinsics.checkNotNullExpressionValue(r15, "withAppendedId(...)");     // Catch: Exception -> L44
        ?? r14 = r0.getContentResolver();     // Catch: Exception -> L44
        Cursor r1 = ZeusProviderTransform.query(r14, r15, new String[]{"dtstart", "dtend", "duration"}, null, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L44
        if (r1 == null) goto L39;
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r1, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L44
        Cursor r2 = (Cursor) ZeusTransformUtils.preCheckCast(r11, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L32
        if (r2.moveToFirst() == false) goto L23;
        r12 = r2.getLong(0);     // Catch: Throwable -> L32
    L21:
        th = move-exception;
        Throwable r7 = th;
        r14 = 0;
        r12 = r12;
    L85:
        throw r7;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r11, r7);     // Catch: Exception -> L42
        throw th;     // Catch: Exception -> L42
    L10:
        if (r2.isNull(1) == false) goto L12;
        r14 = 0;
    L74:
    L19:
        Throwable th = th;
    L31:
        r7 = th;
        r12 = r12;
        r14 = r14;
        goto L85
    L15:
        if (r2.isNull(2) == false) goto L17;
        String r3 = null;
    L18:
        String r8 = r3;
        r12 = r12;
        r14 = r14;
    L78:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r11, null);     // Catch: Exception -> L27
        r6 = r8;
        ?? r13 = r12;
        ?? r16 = r14;
    L40:
        RunLog.INSTANCE.debug("IslandActionReceiver", "openEventWithTimeExtras: queried dtStart=" + r13 + ", dtEnd=" + r16 + ", duration=" + r6);     // Catch: Exception -> L42
        ?? r17 = r13;
        ?? r18 = r16;
    L47:
        ?? r19 = r17;
        if (r17 > 0) goto L51;
        r19 = System.currentTimeMillis();
    L51:
        ?? r110 = r18;
        if (r18 > 0) goto L65;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L57;
    L60:
        boolean r9 = true;
    L61:
        if (r9 == true) goto L63;
        Intrinsics.checkNotNull(r6);
        long r10 = a(r6);
    L64:
        r110 = r19 + r10;
        goto L65
    L63:
        r10 = ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS;
        goto L64
    L57:
        if (r5.length() == 0) goto L60;
        r9 = false;
    L65:
        RunLog.INSTANCE.debug("IslandActionReceiver", "openEventWithTimeExtras: computed beginTime=" + r19 + ", endTime=" + r110);
        Uri r20 = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, r23);
        Intrinsics.checkNotNullExpressionValue(r20, "withAppendedId(...)");
        ?? r21 = new Intent("android.intent.action.VIEW");
        r21.setData(r20);
        r21.putExtra("beginTime", r19);
        r21.putExtra("endTime", r110);
        r21.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        RunLog.INSTANCE.debug("IslandActionReceiver", "openEventWithTimeExtras: starting intent uri=" + r20 + ", begin=" + r19 + ", end=" + r110);
        ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r21, "com.obric.memorydata.plugin");     // Catch: Exception -> L68 ActivityNotFoundException -> L70
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "openEventWithTimeExtras: calendar activity started for eventId=" + r23, false, 4, null);     // Catch: Exception -> L68 ActivityNotFoundException -> L70
        return true;
    L70:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "openEventWithTimeExtras: ActivityNotFoundException for eventId=" + r23 + ": " + e.getMessage(), null, 4, null);
    L72:
        return false;
    L68:
        e = move-exception;
        RunLog.INSTANCE.error("IslandActionReceiver", "openEventWithTimeExtras: startActivity failed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L27:
        e = e;
        r6 = r8;
    L46:
        RunLog.INSTANCE.warn("IslandActionReceiver", "openEventWithTimeExtras: query event failed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r17 = r12;
        r18 = r14;
    L29:
        th = th;
        r6 = r8;
        goto L31
    L17:
        r3 = r2.getString(2);     // Catch: Throwable -> L19
        goto L18
    L12:
        r14 = r2.getLong(1);     // Catch: Throwable -> L21
        goto L74
    L23:
        r8 = null;
        r12 = 0;
        r14 = 0;
    L32:
        th = move-exception;
        r7 = th;
        r12 = 0;
        r14 = 0;
        goto L85
    L39:
        r13 = 0;
        r16 = 0;
    L42:
        e = e;
    L44:
        e = e;
        r12 = 0;
        r14 = 0;
        goto L46
    }

    public static final /* synthetic */ boolean a(IslandActionReceiver r2, Context r3, long r4) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    private final void b(Context r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleCalendarConfirm: 用户点击了添加到日历", false, 4, null);
        kotlinx.coroutines.i.a(this.f10202b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandActionReceiver$handleCalendarConfirm$1(r16, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public void onReceive(Context r18, Intent r19) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r19, MemorySourceLinkType.INTENT);
        String r4 = r19.getAction();
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r5 = new StringBuilder().append("onReceive: action=").append(r4).append(", extras=");
        Bundle r7 = r19.getExtras();
        if (r7 == null) goto L8;
        Set<String> r8 = r7.keySet();
        if (r8 == null) goto L8;
        String r9 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, null, 63, null);
        if (r9 == null) goto L8;
    L9:
        IRunLog.a.a(r6, "IslandActionReceiver", r5.append(r9).toString(), false, 4, null);
        if (r4 != null) goto L12;
    L30:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "onReceive: unknown action=" + r4 + ", ignoring", null, 4, null);
        return;
    L12:
        switch(r4.hashCode()) {
            case -1762761229: goto L27;
            case 1589878343: goto L23;
            case 1645645115: goto L19;
            case 2082609899: goto L15;
            default: goto L30;
        };
    L15:
        if (r4.equals("com.obric.memorydata.ACTION_OPEN_CALENDAR") == false) goto L30;
        String r1 = r19.getStringExtra("event_uuid");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "onReceive: dispatching to handleOpenCalendar, eventUuid=" + r1, false, 4, null);
        a(r2, r1);
        return;
    L19:
        if (r4.equals("com.obric.memorydata.ACTION_ISLAND_CARD_CLICK") == false) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "onReceive: dispatching to handleCardClick", false, 4, null);
        a(r2);
        return;
    L23:
        if (r4.equals("com.obric.memorydata.ACTION_CALENDAR_CONFIRM") == false) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "onReceive: dispatching to handleCalendarConfirm", false, 4, null);
        b(r2);
        return;
    L27:
        if (r4.equals("com.obric.memorydata.ACTION_CALENDAR_CANCEL") == false) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "onReceive: dispatching to handleCalendarCancel", false, 4, null);
        a();
        return;
    L8:
        r9 = "none";
        goto L9
    }
}
