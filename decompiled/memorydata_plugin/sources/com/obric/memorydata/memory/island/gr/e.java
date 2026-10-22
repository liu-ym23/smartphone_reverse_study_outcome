package com.obric.memorydata.memory.island.gr;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.flow.ad;
import kotlinx.coroutines.flow.ak;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\tJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\tH\u0007J(\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0007J\u001c\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0007J\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\fJ\u0006\u0010\"\u001a\u00020\u0016J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\tH\u0003J\u0012\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010'\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/island/gr/IslandNotificationManager;", "", "<init>", "()V", "TAG", "", "CHANNEL_ID", "CHANNEL_NAME", "appContext", "Landroid/content/Context;", "mSessionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/memory/island/gr/IslandSession;", "", "getMSessionMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "sessionLock", "Lkotlinx/coroutines/sync/Mutex;", "islandTaskFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "context", "requireContext", "createSession", "", "session", "updateWidget", "targetWidget", "Lcom/obric/memorydata/memory/island/gr/IslandWidget;", "updateSession", "destroySession", "destroyAllSessions", "sendNotify", "extractNotifTitle", "expandData", "Lcom/obric/memorydata/memory/island/gr/ITemplateData;", "extractNotifText", "getNotificationManager", "Landroid/app/NotificationManager;", "ensureChannel", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f10211a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Context f10212b;
    private static final ConcurrentHashMap<IslandSession, Long> c = null;
    private static final kotlinx.coroutines.sync.a d = null;
    private static final ad<Function1<Continuation<? super Unit>, Object>> e = null;

    static {
        f10211a = new e();
        c = new ConcurrentHashMap();
        d = kotlinx.coroutines.sync.c.a(false, 1, null);
        e = ak.a(0, 64, null, 5, null);
        i.a(am.a(ba.a().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(cu.a(null, 1, null), CoroutineContext.class, "com.obric.memorydata.plugin"))), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandNotificationManager$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private e() {
    }

    public static final /* synthetic */ NotificationManager a(e r2, Context r3) {
        return r2.b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    private final String a(b r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
        String r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_island_memory_assistant, TypedValues.Custom.S_STRING, "memory_island_memory_assistant"));
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        boolean r2 = false;
        if (ZeusTransformUtils.instanceOf(r7, MemoryExpandedTemplate.class) == false) goto L16;
        String r0 = ((MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(r7, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin")).getBaseInfo().getContent();
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
    L8:
        r2 = true;
    L9:
        if (r2 == false) goto L37;
        String r8 = ((MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(r7, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin")).getBaseInfo().getTitle();
        if (r8 != null) goto L36;
        return r5;
    L36:
        return r8;
    L37:
        return r0;
    L7:
        if (StringsKt.isBlank(r4) == false) goto L9;
    L16:
        if (ZeusTransformUtils.instanceOf(r7, CalendarExpandedTemplate.class) == false) goto L27;
        r0 = ((CalendarExpandedTemplate) ZeusTransformUtils.preCheckCast(r7, CalendarExpandedTemplate.class, "com.obric.memorydata.plugin")).getIconTextInfo().getContent();
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L20;
    L21:
        r2 = true;
    L22:
        if (r2 == false) goto L37;
        r8 = ((CalendarExpandedTemplate) ZeusTransformUtils.preCheckCast(r7, CalendarExpandedTemplate.class, "com.obric.memorydata.plugin")).getIconTextInfo().getTitle();
        if (r8 != null) goto L36;
        return r5;
    L20:
        if (StringsKt.isBlank(r9) == false) goto L22;
    L27:
        if (ZeusTransformUtils.instanceOf(r7, NormalExpandedTemplate.class) == false) goto L38;
        r0 = ((NormalExpandedTemplate) ZeusTransformUtils.preCheckCast(r7, NormalExpandedTemplate.class, "com.obric.memorydata.plugin")).getIconTextInfo().getContent();
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L31;
    L32:
        r2 = true;
    L33:
        if (r2 == false) goto L37;
        r8 = ((NormalExpandedTemplate) ZeusTransformUtils.preCheckCast(r7, NormalExpandedTemplate.class, "com.obric.memorydata.plugin")).getIconTextInfo().getTitle();
        if (r8 != null) goto L36;
        return r5;
    L31:
        if (StringsKt.isBlank(r10) == false) goto L33;
    L38:
        return r5;
    }

    public static final /* synthetic */ void a(e r2, IslandSession r3, Context r4) {
        r2.c(r3, (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"));
    }

    private final NotificationManager b(Context r2) {
        Object r1 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getSystemService(NotificationManager.class);
        Intrinsics.checkNotNullExpressionValue(r1, "getSystemService(...)");
        return (NotificationManager) ZeusTransformUtils.preCheckCast(r1, NotificationManager.class, "com.obric.memorydata.plugin");
    }

    private final String b(b r6) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (ZeusTransformUtils.instanceOf(r5, MemoryExpandedTemplate.class) == false) goto L16;
        CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(((MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin")).getBaseInfo().getContent(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
    L8:
        r1 = true;
    L9:
        if (r1 == true) goto L42;
        String r8 = ((MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin")).getBaseInfo().getTitle();
        if (r8 != null) goto L41;
        return "";
    L41:
        return r8;
    L42:
        return "";
    L7:
        if (StringsKt.isBlank(r7) == false) goto L9;
    L16:
        if (ZeusTransformUtils.instanceOf(r5, CalendarExpandedTemplate.class) == false) goto L28;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(((CalendarExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, CalendarExpandedTemplate.class, "com.obric.memorydata.plugin")).getIconTextInfo().getContent(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L20;
    L21:
        r1 = true;
    L22:
        if (r1 == true) goto L44;
        r8 = ((CalendarExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, CalendarExpandedTemplate.class, "com.obric.memorydata.plugin")).getIconTextInfo().getTitle();
        if (r8 != null) goto L41;
        return "";
    L44:
        return "";
    L20:
        if (StringsKt.isBlank(r9) == false) goto L22;
    L28:
        if (ZeusTransformUtils.instanceOf(r5, NormalExpandedTemplate.class) == false) goto L39;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(((NormalExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, NormalExpandedTemplate.class, "com.obric.memorydata.plugin")).getIconTextInfo().getContent(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L32;
    L33:
        r1 = true;
    L34:
        if (r1 == true) goto L46;
        r8 = ((NormalExpandedTemplate) ZeusTransformUtils.preCheckCast(r5, NormalExpandedTemplate.class, "com.obric.memorydata.plugin")).getIconTextInfo().getTitle();
        if (r8 != null) goto L41;
        return "";
    L46:
        return "";
    L32:
        if (StringsKt.isBlank(r10) == false) goto L34;
    L39:
        return " ";
    }

    public static final /* synthetic */ ad c() {
        return e;
    }

    private final void c(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        NotificationChannel r0 = new NotificationChannel("memory_island_channel", (CharSequence) ZeusTransformUtils.preCheckCast("Memory Island", CharSequence.class, "com.obric.memorydata.plugin"), 4);
        b(r6).createNotificationChannel(r0);
        return;
    }

    private final void c(IslandSession r14, Context r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");
        c(r16);
        IslandWidget r0 = r14.getCollapseWidget();
        b r2 = null;
        if (r0 == null) goto L5;
        b r1 = r0.getTemplateData();
    L6:
        if (r1 == null) goto L9;
        Bundle r3 = r1.getPics();
        if (r3 == null) goto L9;
    L10:
        IslandWidget r4 = r14.getSmallCollapseWidget();
        if (r4 == null) goto L13;
        b r5 = r4.getTemplateData();
    L14:
        if (r5 == null) goto L17;
        Bundle r6 = r5.getPics();
        if (r6 == null) goto L17;
    L18:
        IslandWidget r7 = r14.getExpandWidget();
        if (r7 == null) goto L21;
        r2 = r7.getTemplateData();
    L21:
        if (r2 == null) goto L24;
        Bundle r8 = r2.getPics();
        if (r8 == null) goto L24;
    L25:
        if (r2 == null) goto L28;
        Bundle r9 = r2.getActions();
        if (r9 == null) goto L28;
    L29:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandNotifMgr", "sendNotify: taskId=" + r14.getTaskId() + ", business=" + r14.getBusiness(), false, 4, null);
        RunLog r10 = RunLog.INSTANCE;
        StringBuilder r11 = new StringBuilder().append("sendNotify: collapsePics keys=");
        Set<String> r12 = r3.keySet();
        Intrinsics.checkNotNullExpressionValue(r12, "keySet(...)");
        r10.debug("IslandNotifMgr", r11.append(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin"))).toString());
        RunLog r13 = RunLog.INSTANCE;
        StringBuilder r17 = new StringBuilder().append("sendNotify: smallCollapsePics keys=");
        Set<String> r18 = r6.keySet();
        Intrinsics.checkNotNullExpressionValue(r18, "keySet(...)");
        r13.debug("IslandNotifMgr", r17.append(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin"))).toString());
        RunLog r19 = RunLog.INSTANCE;
        StringBuilder r20 = new StringBuilder().append("sendNotify: expandPics keys=");
        Set<String> r110 = r8.keySet();
        Intrinsics.checkNotNullExpressionValue(r110, "keySet(...)");
        StringBuilder r21 = r20.append(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.memorydata.plugin"))).append(", expandActions keys=");
        Set<String> r111 = r9.keySet();
        Intrinsics.checkNotNullExpressionValue(r111, "keySet(...)");
        r19.debug("IslandNotifMgr", r21.append(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r111, Iterable.class, "com.obric.memorydata.plugin"))).toString());
        String r22 = a(r2);
        String r23 = b(r2);
        RunLog.INSTANCE.debug("IslandNotifMgr", "sendNotify: notifTitle=" + r22 + ", notifContent=" + r23);
        NotificationCompat.Builder r24 = new NotificationCompat.Builder(r16, "memory_island_channel").setSmallIcon(r14.getSmallIconResId()).setContentTitle((CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin")).setContentText((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin"));
        boolean r25 = true;
        NotificationCompat.Builder r26 = r24.setOngoing(true);
        Intrinsics.checkNotNullExpressionValue(r26, "setOngoing(...)");
        PendingIntent r27 = r14.getIntent();
        if (r27 == null) goto L32;
        r26.setContentIntent(r27);
    L32:
        Bundle r28 = new Bundle();
        r28.putAll(r3);
        r28.putAll(r6);
        r28.putAll(r8);
        RunLog r29 = RunLog.INSTANCE;
        StringBuilder r30 = new StringBuilder().append("sendNotify: allPics keys=");
        Set<String> r31 = r28.keySet();
        Intrinsics.checkNotNullExpressionValue(r31, "keySet(...)");
        r29.debug("IslandNotifMgr", r30.append(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r31, Iterable.class, "com.obric.memorydata.plugin"))).toString());
        CharSequence r32 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.getTicker(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r32 != null) goto L35;
    L38:
        boolean r33 = true;
    L39:
        if (r33 == true) goto L51;
        CharSequence r34 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.getTickerPic(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r34 != null) goto L43;
    L46:
        boolean r35 = true;
    L47:
        if (r35 == true) goto L51;
        if (r14.getTickerPicResId() == null) goto L51;
        String r36 = r14.getTickerPic();
        c r37 = c.f10208a;
        Integer r38 = r14.getTickerPicResId();
        Intrinsics.checkNotNull(r38);
        r28.putParcelable(r36, (Parcelable) ZeusTransformUtils.preCheckCast(r37.a(r16, r38.intValue()), Parcelable.class, "com.obric.memorydata.plugin"));
        goto L51
    L43:
        if (r34.length() == 0) goto L46;
        r35 = false;
    L51:
        CharSequence r39 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.getAodTitle(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r39 != null) goto L54;
    L57:
        boolean r40 = true;
    L58:
        if (r40 == true) goto L70;
        CharSequence r41 = (CharSequence) ZeusTransformUtils.preCheckCast(r14.getAodPic(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r41 != null) goto L62;
    L65:
        if (r25 == true) goto L70;
        if (r14.getAodPicResId() == null) goto L70;
        String r42 = r14.getAodPic();
        c r43 = c.f10208a;
        Integer r44 = r14.getAodPicResId();
        Intrinsics.checkNotNull(r44);
        r28.putParcelable(r42, (Parcelable) ZeusTransformUtils.preCheckCast(r43.a(r16, r44.intValue()), Parcelable.class, "com.obric.memorydata.plugin"));
        goto L70
    L62:
        if (r41.length() == 0) goto L65;
        r25 = false;
    L70:
        if (Build.VERSION.SDK_INT >= 23) goto L79;
    L77:
        Bundle r45 = new Bundle();
        r45.putBundle("miui.focus.actions", r9);
        r45.putBundle("miui.focus.pics", r28);
        r26.addExtras(r45);
        JSONObject r46 = r14.toJSONObject();
        JSONObject r47 = new JSONObject();
        r47.put("param_v2", r46);
        String r48 = r47.toString(4);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandNotifMgr", "sendNotify: \nfocusParam=\n" + r48, false, 4, null);
        Notification r49 = r26.build();
        Intrinsics.checkNotNullExpressionValue(r49, "build(...)");
        r49.extras.putString("miui.focus.param", r48);
        b(r16).notify((int) r14.getTaskId(), r49);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandNotifMgr", "sendNotify: notification sent, id=" + ((int) r14.getTaskId()), false, 4, null);
        return;
    L79:
        Icon r50 = f.f10213a.b();     // Catch: Exception -> L75
        if (r50 == null) goto L77;
        r28.putParcelable("miui.focus.pic_calendar_icon", (Parcelable) ZeusTransformUtils.preCheckCast(r50, Parcelable.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L75
    L75:
        e = move-exception;
        RunLog.INSTANCE.debug("IslandNotifMgr", "sendNotify: getCalendarIconOverride not available: " + e.getMessage());
        goto L77
    L54:
        if (r39.length() == 0) goto L57;
        r40 = false;
        goto L58
    L35:
        if (r32.length() == 0) goto L38;
        r33 = false;
    L28:
        r9 = new Bundle();
    L24:
        r8 = new Bundle();
    L17:
        r6 = new Bundle();
        goto L18
    L13:
        r5 = null;
    L9:
        r3 = new Bundle();
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a d() {
        return d;
    }

    public final ConcurrentHashMap<IslandSession, Long> a() {
        return c;
    }

    public final void a(Context r7) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        f10212b = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandNotifMgr", "init: context=" + r6.getClass().getSimpleName(), false, 4, null);
    }

    public final void a(IslandSession r7) {
        Intrinsics.checkNotNullParameter(r7, "session");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandNotifMgr", "destroySession: taskId=" + r7.getTaskId(), false, 4, null);
        e.a(new IslandNotificationManager$destroySession$1(r7, null));
    }

    public final boolean a(IslandSession r7, Context r8) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "session");
        Intrinsics.checkNotNullParameter(r6, "context");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandNotifMgr", "createSession: business=" + r7.getBusiness(), false, 4, null);
        e.a(new IslandNotificationManager$createSession$1(r7, r6, null));
        return true;
    }

    public final Context b() {
        Context r1 = f10212b;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("IslandNotificationManager.init() not called");
    }

    public final void b(IslandSession r7, Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "session");
        if (r9 != null) goto L5;
        r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandNotifMgr", "updateSession: taskId=" + r7.getTaskId(), false, 4, null);
        e.a(new IslandNotificationManager$updateSession$1(r7, r9, null));
    }
}
