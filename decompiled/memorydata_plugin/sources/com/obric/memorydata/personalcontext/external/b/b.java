package com.obric.memorydata.personalcontext.external.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.personalcontext.external.c;
import com.obric.memorydata.personalcontext.external.e.d;
import com.obric.memorydata.personalcontext.external.f;
import com.obric.memorydata.personalcontext.external.g;
import com.obric.memorydata.personalcontext.external.i;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/callhistory/ExternalCallHistoryObserver;", "Landroid/database/ContentObserver;", "Lcom/obric/memorydata/personalcontext/external/sms/IExternalSmsInitFetcher;", "mContext", "Landroid/content/Context;", "entityIndexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;)V", "getMContext", "()Landroid/content/Context;", "changeInnerRunnable", "Ljava/lang/Runnable;", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "syncOnStart", "changeInner", "changeInnerSlow", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends ContentObserver implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12106a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f12107b;
    private final i c;
    private final Runnable d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/callhistory/ExternalCallHistoryObserver$Companion;", "", "<init>", "()V", "TAG", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12106a = new a(null);
    }

    public b(Context r3, i r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "mContext");
        Intrinsics.checkNotNullParameter(r4, "entityIndexUpdater");
        super(null);
        this.f12107b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r4;
        this.d = new $$Lambda$b$AXmIFwmoPo0AZsrJJduMCo4PJS8(this);
    }

    private static final Unit a(List r8, List r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "page");
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L14;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r13.next(), Map.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get("_id"), String.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.get("last_modified"), String.class, "com.obric.memorydata.plugin");
        Pair r5 = null;
        if (r4 == null) goto L8;
        Long r6 = StringsKt.toLongOrNull(r4);
    L9:
        if (r3 == null) goto L12;
        if (r6 == null) goto L12;
        r5 = TuplesKt.to(r3, r6);
    L12:
        if (r5 == null) goto L4;
        r0.add(r5);
        goto L4
    L8:
        r6 = null;
        goto L9
    L14:
        Map r14 = MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r14.isEmpty() == true) goto L17;
        String r1 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().c().b();
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r7 = s.a().getRawDaoByEntityType(202);
        if (r7 == null) goto L22;
        Object r15 = r7.queryByEntityIdListAndPackageName(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r14.keySet(), Iterable.class, "com.obric.memorydata.plugin")), r1);
        if (r15 == null) goto L22;
    L23:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r16, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L25:
        if (r18.hasNext() == false) goto L27;
        com.obric.memorydata.database.entity.d r19 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r18.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        Pair r20 = TuplesKt.to(r19.getEntityId(), Long.valueOf(r19.getModifyTime()));
        r17.put(r20.getFirst(), r20.getSecond());
        goto L25
    L27:
        Iterator r21 = r14.entrySet().iterator();
    L29:
        if (r21.hasNext() == false) goto L36;
        Map.Entry r22 = (Map.Entry) ZeusTransformUtils.preCheckCast(r21.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.getKey(), String.class, "com.obric.memorydata.plugin");
        long r24 = ((Number) ZeusTransformUtils.preCheckCast(r22.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Long r25 = (Long) ZeusTransformUtils.preCheckCast(r17.get(r23), Long.class, "com.obric.memorydata.plugin");
        if (r25 == null) goto L34;
        if (r25.longValue() == r24) goto L29;
    L34:
        r10.add(r23);
        goto L29
    L36:
        return Unit.INSTANCE;
    L22:
        r15 = CollectionsKt.emptyList();
        goto L23
    L17:
        return Unit.INSTANCE;
    }

    private static final Unit a(List r6, Ref.LongRef r7, List r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "page");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L16;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r11.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get("_id"), String.class, "com.obric.memorydata.plugin");
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("last_modified"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        Long r3 = StringsKt.toLongOrNull(r1);
    L9:
        if (r2 == null) goto L11;
        r9.add(r2);
    L11:
        if (r3 == null) goto L4;
        if (r3.longValue() <= r7.element) goto L4;
        r7.element = r3.longValue();
        goto L4
    L8:
        r3 = null;
        goto L9
    L16:
        return Unit.INSTANCE;
    }

    private static final void a(b r0) {
        r0.b();
    }

    public static /* synthetic */ void lambda$AXmIFwmoPo0AZsrJJduMCo4PJS8(b r0) {
        a(r0);
    }

    public static /* synthetic */ Unit lambda$FRKwPxJDrkcx3WvNHRlvqDP4A70(List r0, List r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$Xj5M0AIKZq58M7Q4ygttgIJEdWg(List r0, Ref.LongRef r1, List r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.memorydata.personalcontext.external.e.d
    public void a() {
        b();
    }

    public final void b() {
        long r1 = System.currentTimeMillis();
        long r5 = g.f12138a.b("call_history");
        if (r5 <= r1) goto L7;
        c();
        g r0 = g.f12138a;
    L5:
        r0.a("call_history", r1);
        return;
    L7:
        final Ref.LongRef r3 = new Ref.LongRef();
        r3.element = r5;
        final List<String> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.personalcontext.external.b.a r10 = com.obric.memorydata.personalcontext.external.b.a.f12104a;
        ContentResolver r11 = this.f12107b.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r11, "getContentResolver(...)");
        r10.a(r11, 2000, new String[]{"_id", "last_modified"}, "last_modified > ? and last_modified <= ?", new String[]{String.valueOf(r5), String.valueOf(r1)}, new $$Lambda$b$Xj5M0AIKZq58M7Q4ygttgIJEdWg(r7, r3));
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r4 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().c().b();
        Long r12 = null;
    L8:
        List r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r14 = s.a().getRawDaoByEntityType(202);
        if (r14 == null) goto L11;
        Cursor r15 = r14.queryByPackageName(new String[]{"entityId", OaidModel.KEY_ID}, r4, 2000, r12);
    L12:
        if (r15 == null) goto L26;
        Closeable r16 = (Closeable) ZeusTransformUtils.preCheckCast(r15, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r17 = (Cursor) ZeusTransformUtils.preCheckCast(r16, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        int r18 = 0;
    L16:
        if (r17.moveToNext() == false) goto L18;
        String r19 = r17.getString(r17.getColumnIndexOrThrow("entityId"));     // Catch: Throwable -> L20
        Long r110 = Long.valueOf(r17.getLong(r17.getColumnIndexOrThrow(OaidModel.KEY_ID)));     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r19);     // Catch: Throwable -> L20
        r13.add(r19);     // Catch: Throwable -> L20
        r18 = r18 + 1;     // Catch: Throwable -> L20
        r12 = r110;
        goto L16
    L18:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L20
        CloseableKt.closeFinally(r16, null);
        int r8 = r18;
    L28:
        if (r13.isEmpty() == true) goto L53;
        Cursor r111 = ZeusProviderTransform.query(this.f12107b.getContentResolver(), CallLog.Calls.CONTENT_URI, new String[]{"_id"}, "_id IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), null, null, "com.obric.memorydata.plugin");
        Set r112 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L45;
        Closeable r113 = (Closeable) ZeusTransformUtils.preCheckCast(r111, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r114 = (Cursor) ZeusTransformUtils.preCheckCast(r113, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L39
    L35:
        if (r114.moveToNext() == false) goto L37;
        String r115 = r114.getString(r114.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L39
        Intrinsics.checkNotNull(r115);     // Catch: Throwable -> L39
        r112.add(r115);     // Catch: Throwable -> L39
        goto L35
    L37:
        Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L39
        CloseableKt.closeFinally(r113, null);
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r113, th);
        throw th;
    L45:
        Iterator r117 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L47:
        if (r117.hasNext() == false) goto L52;
        String r118 = (String) ZeusTransformUtils.preCheckCast(r117.next(), String.class, "com.obric.memorydata.plugin");
        if (r112.contains(r118) == true) goto L47;
        r2.add(r118);
        goto L47
    L52:
        if (r8 >= 2000) goto L8;
    L53:
        this.c.a(r7, 202);
        this.c.b(r2, 202);
        r0 = g.f12138a;
        r1 = r3.element;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);
        throw th;
    L26:
        r8 = 0;
        goto L28
    L11:
        r15 = null;
        goto L12
    }

    public final void c() {
        final List<String> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.personalcontext.external.b.a r4 = com.obric.memorydata.personalcontext.external.b.a.f12104a;
        ContentResolver r5 = this.f12107b.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r5, "getContentResolver(...)");
        r4.a(r5, 2000, new String[]{"_id", "last_modified"}, null, null, new $$Lambda$b$FRKwPxJDrkcx3WvNHRlvqDP4A70(r1));
        List<String> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r7 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().c().b();
        Long r8 = null;
    L3:
        List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r10 = 0;
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r11 = s.a().getRawDaoByEntityType(202);
        if (r11 == null) goto L6;
        Cursor r12 = r11.queryByPackageName(new String[]{"entityId", OaidModel.KEY_ID}, r7, 2000, r8);
    L7:
        if (r12 == null) goto L22;
        Closeable r13 = (Closeable) ZeusTransformUtils.preCheckCast(r12, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r15 = (Cursor) ZeusTransformUtils.preCheckCast(r13, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
    L11:
        if (r15.moveToNext() == false) goto L13;
        String r14 = r15.getString(r15.getColumnIndexOrThrow("entityId"));     // Catch: Throwable -> L15
        Long r16 = Long.valueOf(r15.getLong(r15.getColumnIndexOrThrow(OaidModel.KEY_ID)));     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L15
        r9.add(r14);     // Catch: Throwable -> L15
        r10 = r10 + 1;     // Catch: Throwable -> L15
        r8 = r16;
        goto L11
    L13:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r13, null);
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    L22:
        if (r9.isEmpty() == true) goto L46;
        Cursor r18 = ZeusProviderTransform.query(this.f12107b.getContentResolver(), CallLog.Calls.CONTENT_URI, new String[]{"_id"}, "_id IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), null, null, "com.obric.memorydata.plugin");
        Set r19 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L39;
        Closeable r110 = (Closeable) ZeusTransformUtils.preCheckCast(r18, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r111 = (Cursor) ZeusTransformUtils.preCheckCast(r110, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
    L29:
        if (r111.moveToNext() == false) goto L31;
        String r112 = r111.getString(r111.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L33
        r19.add(r112);     // Catch: Throwable -> L33
        goto L29
    L31:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L33
        CloseableKt.closeFinally(r110, null);
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r110, th);
        throw th;
    L39:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L41:
        if (r20.hasNext() == false) goto L45;
        String r114 = (String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.memorydata.plugin");
        if (r19.contains(r114) == true) goto L41;
        r6.add(r114);
        goto L41
    L45:
        if (r10 >= 2000) goto L3;
    L46:
        this.c.a(r1, 202);
        this.c.b(r6, 202);
        return;
    L6:
        r12 = null;
        goto L7
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r4, Uri r5) {
        super.onChange(r4, r5);
        c.f12108a.a("ExternalCallHistoryObserver", "onChange selfChange=" + r4 + ", uri=" + r5);
        f.f12127a.a().removeCallbacks(this.d);
        f.f12127a.a().postDelay(3000, this.d);
    }
}
