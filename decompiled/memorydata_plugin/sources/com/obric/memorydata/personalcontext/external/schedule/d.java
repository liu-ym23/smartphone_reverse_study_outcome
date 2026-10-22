package com.obric.memorydata.personalcontext.external.schedule;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.CalendarContract;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.utils.aj;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/schedule/ExternalScheduleObserver;", "Landroid/database/ContentObserver;", "context", "Landroid/content/Context;", "entityIndexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;)V", "changeInnerRunnableMonth", "Ljava/lang/Runnable;", "changeInnerRunnableYear", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "syncData", "changeInnerSlow", "timeRangeMs", "", "getUpdateIds", "", "", "getDeleteIds", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12166a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f12167b;
    private final com.obric.memorydata.personalcontext.external.i c;
    private final Runnable d;
    private final Runnable e;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/schedule/ExternalScheduleObserver$Companion;", "", "<init>", "()V", "TAG", "", "ONE_MONTH_MS", "", "ONE_YEAR_MS", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12166a = new a(null);
    }

    public d(Context r4, com.obric.memorydata.personalcontext.external.i r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r5, "entityIndexUpdater");
        super(new Handler(Looper.getMainLooper()));
        this.f12167b = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.c = r5;
        this.d = new $$Lambda$d$M3ZC8DWAcpL6XeTQMx6KYKG4sG4(this);
        this.e = new $$Lambda$d$cis4mG6l3qICPSdLNPq0OTSTwfw(this);
    }

    public static final /* synthetic */ List a(d r0) {
        return r0.b();
    }

    public static final /* synthetic */ List a(d r0, long r1) {
        return r0.b(r1);
    }

    private static final Unit a(List r3, List r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "systemPage");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        String r0 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r7.next(), Map.class, "com.obric.memorydata.plugin")).get("_id"), String.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        r5.add(r0);
        goto L4
    L10:
        return Unit.INSTANCE;
    }

    private final void a(long r16) {
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleObserver", "changeInnerSlow start, timeRangeMs=" + r16);
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ExternalScheduleObserver$changeInnerSlow$1(kotlinx.coroutines.i.b(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ExternalScheduleObserver$changeInnerSlow$deleteItemIdsDeferred$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null), kotlinx.coroutines.i.b(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ExternalScheduleObserver$changeInnerSlow$updateItemIdsDeferred$1(this, r16, null), Function2.class, "com.obric.memorydata.plugin"), 3, null), System.currentTimeMillis(), this, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
    }

    public static final /* synthetic */ com.obric.memorydata.personalcontext.external.i b(d r0) {
        return r0.c;
    }

    private final List<String> b() {
        List<String> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r2 = com.obric.memorydata.personalcontext.external.g.f12138a.a(402);     // Catch: Exception -> L55
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r4 = s.a().getRawDaoByEntityType(402);     // Catch: Exception -> L55
        Long r6 = null;
    L4:
        List r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55
        int r8 = 0;
        if (r4 == null) goto L8;
        Cursor r12 = r4.queryByPackageName(new String[]{"entityId", OaidModel.KEY_ID}, r2, 2000, r6);     // Catch: Exception -> L55
    L9:
        if (r12 == null) goto L26;
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55
        Cursor r14 = (Cursor) ZeusTransformUtils.preCheckCast(r13, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
    L13:
        if (r14.moveToNext() == false) goto L15;
        String r9 = r14.getString(r14.getColumnIndexOrThrow("entityId"));     // Catch: Throwable -> L18
        Long r15 = Long.valueOf(r14.getLong(r14.getColumnIndexOrThrow(OaidModel.KEY_ID)));     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L18
        r7.add(r9);     // Catch: Throwable -> L18
        r8 = r8 + 1;     // Catch: Throwable -> L18
        r6 = r15;
        goto L13
    L15:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L55
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Exception -> L55
        throw th;     // Catch: Exception -> L55
    L26:
        if (r7.isEmpty() == true) goto L57;
        Cursor r11 = ZeusProviderTransform.query(this.f12167b.getContentResolver(), CalendarContract.Events.CONTENT_URI, new String[]{"_id"}, "_id IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L55
        Set r16 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55
        if (r11 == null) goto L45;
        Closeable r17 = (Closeable) ZeusTransformUtils.preCheckCast(r11, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55
        Cursor r18 = (Cursor) ZeusTransformUtils.preCheckCast(r17, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
    L33:
        if (r18.moveToNext() == false) goto L35;
        String r19 = r18.getString(r18.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L38
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L38
        r16.add(r19);     // Catch: Throwable -> L38
        goto L33
    L35:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L38
        CloseableKt.closeFinally(r17, null);     // Catch: Exception -> L55
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: Exception -> L55
        throw th;     // Catch: Exception -> L55
    L45:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L55
    L47:
        if (r20.hasNext() == false) goto L53;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L55
        if (r16.contains(r21) == true) goto L47;
        r1.add(r21);     // Catch: Exception -> L55
        goto L47
    L53:
        if (r8 >= 2000) goto L4;
    L57:
        return r1;
    L8:
        r12 = null;
    L55:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleObserver", "getDeleteIds failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L57
    }

    private final List<String> b(long r16) {
        final List<String> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L5
        long r5 = r3 - r16;     // Catch: Exception -> L5
        long r4 = r3 + r16;     // Catch: Exception -> L5
        String[] r13 = {String.valueOf(r5), String.valueOf(r4), String.valueOf(r5), String.valueOf(r4)};     // Catch: Exception -> L5
        ContentResolver r7 = this.f12167b.getContentResolver();     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r7, "getContentResolver(...)");     // Catch: Exception -> L5
        Uri r8 = CalendarContract.Events.CONTENT_URI;     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r8, "CONTENT_URI");     // Catch: Exception -> L5
        aj.a(r7, r8, new String[]{"_id"}, "_id", 2000, "dtstart >= ? AND dtstart <= ? OR (dtend >= ? AND dtend <= ? OR dtend IS NULL)", r13, new $$Lambda$d$n3fJdic7zTTmHvSEe1sAY5fXQU(r1));     // Catch: Exception -> L5
    L7:
        return r1;
    L5:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleObserver", "getUpdateIds failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L7
    }

    private static final void c(d r2) {
        r2.a(2592000000L);
    }

    private static final void d(d r2) {
        r2.a(31536000000L);
    }

    public static /* synthetic */ void lambda$M3ZC8DWAcpL6XeTQMx6KYKG4sG4(d r0) {
        c(r0);
    }

    public static /* synthetic */ void lambda$cis4mG6l3qICPSdLNPq0OTSTwfw(d r0) {
        d(r0);
    }

    /* JADX INFO: renamed from: lambda$n3fJdic7-zTTmHvSEe1sAY5fXQU, reason: not valid java name */
    public static /* synthetic */ Unit m1078lambda$n3fJdic7zTTmHvSEe1sAY5fXQU(List r0, List r1) {
        return a(r0, r1);
    }

    public final void a() {
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleObserver", "syncData started");
        com.obric.memorydata.personalcontext.external.f.f12127a.a().postDelay(0, this.e);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r3, Uri r4) {
        super.onChange(r3, r4);
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalScheduleObserver", "onChange uri: " + r4);
        com.obric.memorydata.personalcontext.external.f.f12127a.a().removeCallbacks(this.d);
        com.obric.memorydata.personalcontext.external.f.f12127a.a().postDelay(3000, this.d);
    }
}
