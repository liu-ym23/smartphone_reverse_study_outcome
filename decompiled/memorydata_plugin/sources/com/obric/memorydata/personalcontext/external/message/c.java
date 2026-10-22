package com.obric.memorydata.personalcontext.external.message;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.go;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
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
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0006\u0010\u0014\u001a\u00020\u000eJ\u001f\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010\u0019J'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsObserver;", "Landroid/database/ContentObserver;", "Lcom/obric/memorydata/personalcontext/external/sms/IExternalSmsInitFetcher;", "context", "Landroid/content/Context;", "entityIndexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;)V", "getContext", "()Landroid/content/Context;", "changeInnerRunnable", "Ljava/lang/Runnable;", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "syncOnStart", "changeInner", "realSync", "lastSyncTime", "", "currentTime", "(Ljava/lang/Long;J)V", "getUpdateIds", "", "", "(Ljava/lang/Long;J)Ljava/util/List;", "getDeleteIds", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends ContentObserver implements com.obric.memorydata.personalcontext.external.e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f12156b;
    private final i c;
    private final Runnable d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/message/ExternalSmsMmsObserver$Companion;", "", "<init>", "()V", "TAG", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12155a = new a(null);
    }

    public c(Context r3, i r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "entityIndexUpdater");
        super(null);
        this.f12156b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r4;
        this.d = new $$Lambda$c$fBXxPJjpeaGr7e6d91mUQhFP5U(this);
    }

    public static final /* synthetic */ List a(c r0) {
        return r0.c();
    }

    public static final /* synthetic */ List a(c r0, Long r1, long r2) {
        return r0.b(r1, r2);
    }

    private static final Unit a(e r12, List r13, List r14) {
        e r15 = (e) ZeusTransformUtils.wrapperContextForParams(r12, e.class, "com.obric.memorydata.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "page");
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r18.iterator();
    L3:
        Pair r3 = null;
        if (r19.hasNext() == false) goto L24;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r19.next(), Map.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.get(r15.b()), String.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.get(r15.c()), String.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L10;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 == null) goto L10;
        long r8 = r6.longValue();
    L11:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.get(r15.d()), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L16;
        Long r9 = StringsKt.toLongOrNull(r7);
        if (r9 == null) goto L16;
        long r10 = r9.longValue();
    L17:
        long r11 = Math.max(r8, r10);
        if (r4 != null) goto L20;
    L22:
        if (r3 == null) goto L3;
        r0.add(r3);
        goto L3
    L20:
        if (r11 <= 0) goto L22;
        r3 = TuplesKt.to(com.obric.memorydata.personalcontext.external.message.a.c(r4), Long.valueOf(r11));
    L16:
        r10 = 0;
    L10:
        r8 = 0;
        goto L11
    L24:
        Map r110 = MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r110.isEmpty() == true) goto L27;
        String r111 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().c().c();
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r1 = s.a().getRawDaoByEntityType(101);
        if (r1 == null) goto L32;
        Object r112 = r1.queryByEntityIdListAndPackageName(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r110.keySet(), Iterable.class, "com.obric.memorydata.plugin")), r111);
        if (r112 == null) goto L32;
    L33:
        Iterable r113 = (Iterable) ZeusTransformUtils.preCheckCast(r112, Iterable.class, "com.obric.memorydata.plugin");
        Map r20 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r113, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r114 = r113.iterator();
    L35:
        if (r114.hasNext() == false) goto L37;
        com.obric.memorydata.database.entity.d r21 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r114.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        Pair r22 = TuplesKt.to(r21.getEntityId(), r21);
        r20.put(r22.getFirst(), r22.getSecond());
        goto L35
    L37:
        Iterator r115 = r110.entrySet().iterator();
    L39:
        if (r115.hasNext() == false) goto L54;
        Map.Entry r116 = (Map.Entry) ZeusTransformUtils.preCheckCast(r115.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r23 = (String) ZeusTransformUtils.preCheckCast(r116.getKey(), String.class, "com.obric.memorydata.plugin");
        long r24 = ((Number) ZeusTransformUtils.preCheckCast(r116.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
        com.obric.memorydata.database.entity.d r117 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r20.get(r23), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r117 == null) goto L52;
        if (r117.getModifyTime() != r24) goto L52;
        if (ZeusTransformUtils.instanceOf(r117, go.class) == false) goto L47;
        go r118 = (go) ZeusTransformUtils.preCheckCast(r117, go.class, "com.obric.memorydata.plugin");
    L48:
        if (r118 == null) goto L50;
        String r119 = r118.h();
    L51:
        if (r119 != null) goto L39;
    L50:
        r119 = null;
        goto L51
    L47:
        r118 = null;
    L52:
        r16.add(r23);
        goto L39
    L54:
        return Unit.INSTANCE;
    L32:
        r112 = CollectionsKt.emptyList();
        goto L33
    L27:
        return Unit.INSTANCE;
    }

    private static final Unit a(List r12, List r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "page");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L3:
        Pair r3 = null;
        if (r17.hasNext() == false) goto L24;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r17.next(), Map.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.get(com.obric.memorydata.personalcontext.external.message.a.i()), String.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.get("date"), String.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L10;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 == null) goto L10;
        long r8 = r6.longValue();
    L11:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.get("date_sent"), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L16;
        Long r9 = StringsKt.toLongOrNull(r7);
        if (r9 == null) goto L16;
        long r10 = r9.longValue();
    L17:
        long r11 = Math.max(r8, r10);
        if (r4 != null) goto L20;
    L22:
        if (r3 == null) goto L3;
        r0.add(r3);
        goto L3
    L20:
        if (r11 <= 0) goto L22;
        r3 = TuplesKt.to(com.obric.memorydata.personalcontext.external.message.a.a(r4), Long.valueOf(r11));
    L16:
        r10 = 0;
    L10:
        r8 = 0;
        goto L11
    L24:
        Map r18 = MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r18.isEmpty() == true) goto L27;
        String r1 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().c().c();
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r19 = s.a().getRawDaoByEntityType(101);
        if (r19 == null) goto L32;
        Object r20 = r19.queryByEntityIdListAndPackageName(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r18.keySet(), Iterable.class, "com.obric.memorydata.plugin")), r1);
        if (r20 == null) goto L32;
    L33:
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin");
        Map r22 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r21, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r23 = r21.iterator();
    L35:
        if (r23.hasNext() == false) goto L37;
        com.obric.memorydata.database.entity.d r24 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r23.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        Pair r25 = TuplesKt.to(r24.getEntityId(), r24);
        r22.put(r25.getFirst(), r25.getSecond());
        goto L35
    L37:
        Iterator r110 = r18.entrySet().iterator();
    L39:
        if (r110.hasNext() == false) goto L54;
        Map.Entry r26 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r27 = (String) ZeusTransformUtils.preCheckCast(r26.getKey(), String.class, "com.obric.memorydata.plugin");
        long r28 = ((Number) ZeusTransformUtils.preCheckCast(r26.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
        com.obric.memorydata.database.entity.d r29 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r22.get(r27), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L52;
        if (r29.getModifyTime() != r28) goto L52;
        if (ZeusTransformUtils.instanceOf(r29, go.class) == false) goto L47;
        go r30 = (go) ZeusTransformUtils.preCheckCast(r29, go.class, "com.obric.memorydata.plugin");
    L48:
        if (r30 == null) goto L50;
        String r31 = r30.h();
    L51:
        if (r31 != null) goto L39;
    L50:
        r31 = null;
        goto L51
    L47:
        r30 = null;
    L52:
        r14.add(r27);
        goto L39
    L54:
        return Unit.INSTANCE;
    L32:
        r20 = CollectionsKt.emptyList();
        goto L33
    L27:
        return Unit.INSTANCE;
    }

    private final void a(Long r13, long r14) {
        com.obric.memorydata.personalcontext.external.c.f12108a.a("ExternalSmsMmsObserver", "changeInner start");
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ExternalSmsMmsObserver$realSync$1(kotlinx.coroutines.i.b(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ExternalSmsMmsObserver$realSync$deleteItemIdsDeferred$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null), kotlinx.coroutines.i.b(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ExternalSmsMmsObserver$realSync$updateItemIdsDeferred$1(this, r13, r14, null), Function2.class, "com.obric.memorydata.plugin"), 3, null), r14, this, r13, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
    }

    public static final /* synthetic */ i b(c r0) {
        return r0.c;
    }

    private final List<String> b(Long r29, long r30) {
        final List<String> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L5;
        String r12 = "(date > ? AND date <= ?) OR (date_sent > ? AND date_sent <= ?)";
    L7:
        if (r29 == null) goto L9;
        String[] r13 = {r29.toString(), String.valueOf(r30), r29.toString(), String.valueOf(r30)};
    L10:
        if (r29 == null) goto L12;
        String r25 = "(date > ? AND date <= ?) OR (date_sent > ? AND date_sent <= ?)";
    L13:
        if (r29 == null) goto L15;
        long r8 = 1000;
        long r6 = r30 / r8;
        String[] r26 = {String.valueOf(r29.longValue() / r8), String.valueOf(r6), String.valueOf(r29.longValue() / r8), String.valueOf(r6)};
    L16:
        b r7 = b.f12147a;
        ContentResolver r9 = this.f12156b.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r9, "getContentResolver(...)");
        Uri r10 = com.obric.memorydata.personalcontext.external.message.a.a();
        Intrinsics.checkNotNullExpressionValue(r10, "<get-SMS_URI>(...)");
        r7.a(r9, r10, 2000, new String[]{com.obric.memorydata.personalcontext.external.message.a.i(), "date", "date_sent"}, com.obric.memorydata.personalcontext.external.message.a.i(), r12, r13, new $$Lambda$c$3DoKsOx7PXwdPiU0wcJsLJ_f7zY(r2));
        b r5 = b.f12147a;
        ContentResolver r11 = this.f12156b.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r11, "getContentResolver(...)");
        Uri r14 = com.obric.memorydata.personalcontext.external.message.a.b();
        Intrinsics.checkNotNullExpressionValue(r14, "<get-MMS_URI>(...)");
        r5.a(r11, r14, 2000, new String[]{com.obric.memorydata.personalcontext.external.message.a.j(), "date", "date_sent"}, com.obric.memorydata.personalcontext.external.message.a.j(), r25, r26, new $$Lambda$c$8HVW09Qy232_mS2z6qzMp50nMI(r2));
        final e r15 = f.f12159a.a();     // Catch: Exception -> L31
        if (r15 == null) goto L20;
        Uri r16 = r15.a();     // Catch: Exception -> L31
    L21:
        if (r16 == null) goto L33;
        String r17 = r15.c();     // Catch: Exception -> L31
        String r18 = r15.d();     // Catch: Exception -> L31
        if (r29 == null) goto L25;
        String r19 = '(' + r17 + " > ? AND " + r17 + " <= ?) OR (" + r18 + " > ? AND " + r18 + " <= ?)";     // Catch: Exception -> L31
    L26:
        if (r29 == null) goto L28;
        String[] r110 = {r29.toString(), String.valueOf(r30), r29.toString(), String.valueOf(r30)};     // Catch: Exception -> L31
    L29:
        b r20 = b.f12147a;     // Catch: Exception -> L31
        ContentResolver r21 = this.f12156b.getContentResolver();     // Catch: Exception -> L31
        Intrinsics.checkNotNullExpressionValue(r21, "getContentResolver(...)");     // Catch: Exception -> L31
        Uri r22 = r15.a();     // Catch: Exception -> L31
        Intrinsics.checkNotNull(r22);     // Catch: Exception -> L31
        r20.a(r21, r22, 2000, new String[]{r15.b(), r15.c(), r15.d()}, r15.b(), r19, r110, new $$Lambda$c$uVIyIrELu4N5P8Tv60KEBMkpHA8(r15, r2));     // Catch: Exception -> L31
        goto L33
    L28:
        r110 = null;
        goto L29
    L25:
        r19 = null;
    L33:
        return r2;
    L20:
        r16 = null;
    L31:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalSmsMmsObserver", "query rms ids error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L33
    L15:
        r26 = null;
        goto L16
    L12:
        r25 = null;
        goto L13
    L9:
        r13 = null;
        goto L10
    L5:
        r12 = null;
        goto L7
    }

    private static final Unit b(List r12, List r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "page");
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r17 = r16.iterator();
    L3:
        Pair r3 = null;
        if (r17.hasNext() == false) goto L24;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r17.next(), Map.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.get(com.obric.memorydata.personalcontext.external.message.a.j()), String.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r2.get("date"), String.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L10;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 == null) goto L10;
        long r8 = r6.longValue();
    L11:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.get("date_sent"), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L16;
        Long r9 = StringsKt.toLongOrNull(r7);
        if (r9 == null) goto L16;
        long r10 = r9.longValue();
    L17:
        long r11 = Math.max(r8, r10);
        if (r4 != null) goto L20;
    L22:
        if (r3 == null) goto L3;
        r0.add(r3);
        goto L3
    L20:
        if (r11 <= 0) goto L22;
        r3 = TuplesKt.to(com.obric.memorydata.personalcontext.external.message.a.b(r4), Long.valueOf(r11));
    L16:
        r10 = 0;
    L10:
        r8 = 0;
        goto L11
    L24:
        Map r18 = MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r18.isEmpty() == true) goto L27;
        String r1 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().c().c();
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r19 = s.a().getRawDaoByEntityType(101);
        if (r19 == null) goto L32;
        Object r20 = r19.queryByEntityIdListAndPackageName(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r18.keySet(), Iterable.class, "com.obric.memorydata.plugin")), r1);
        if (r20 == null) goto L32;
    L33:
        Iterable r21 = (Iterable) ZeusTransformUtils.preCheckCast(r20, Iterable.class, "com.obric.memorydata.plugin");
        Map r22 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r21, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r23 = r21.iterator();
    L35:
        if (r23.hasNext() == false) goto L37;
        com.obric.memorydata.database.entity.d r24 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r23.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        Pair r25 = TuplesKt.to(r24.getEntityId(), r24);
        r22.put(r25.getFirst(), r25.getSecond());
        goto L35
    L37:
        Iterator r110 = r18.entrySet().iterator();
    L39:
        if (r110.hasNext() == false) goto L54;
        Map.Entry r26 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r27 = (String) ZeusTransformUtils.preCheckCast(r26.getKey(), String.class, "com.obric.memorydata.plugin");
        long r28 = ((Number) ZeusTransformUtils.preCheckCast(r26.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue() * 1000;
        com.obric.memorydata.database.entity.d r29 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r22.get(r27), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r29 == null) goto L52;
        if (r29.getModifyTime() != r28) goto L52;
        if (ZeusTransformUtils.instanceOf(r29, go.class) == false) goto L47;
        go r30 = (go) ZeusTransformUtils.preCheckCast(r29, go.class, "com.obric.memorydata.plugin");
    L48:
        if (r30 == null) goto L50;
        String r31 = r30.h();
    L51:
        if (r31 != null) goto L39;
    L50:
        r31 = null;
        goto L51
    L47:
        r30 = null;
    L52:
        r14.add(r27);
        goto L39
    L54:
        return Unit.INSTANCE;
    L32:
        r20 = CollectionsKt.emptyList();
        goto L33
    L27:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void b(c r0, Long r1, long r2) {
        r0.a(r1, r2);
    }

    private final List<String> c() {
        List<String> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r4 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().c().c();
        Throwable r5 = null;
        Long r0 = null;
    L3:
        List r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List r8 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r9 = s.a().getRawDaoByEntityType(101);
        if (r9 == null) goto L6;
        Object r10 = r9.queryByPackageName(new String[]{"entityId", OaidModel.KEY_ID}, r4, 2000, r0);
    L7:
        if (r10 == null) goto L33;
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r10, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r14 = (Cursor) ZeusTransformUtils.preCheckCast(r11, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        int r15 = 0;
    L11:
        if (r14.moveToNext() == false) goto L25;
        String r1 = r14.getString(r14.getColumnIndexOrThrow("entityId"));     // Catch: Throwable -> L27
        if (r1 != null) goto L15;
        r1 = "";
    L15:
        Long r12 = Long.valueOf(r14.getLong(r14.getColumnIndexOrThrow(OaidModel.KEY_ID)));     // Catch: Throwable -> L27
        String r13 = com.obric.memorydata.personalcontext.external.message.a.g(r1);     // Catch: Throwable -> L27
        if (r13 == null) goto L18;
        r6.add(r13);     // Catch: Throwable -> L27
    L18:
        String r16 = com.obric.memorydata.personalcontext.external.message.a.h(r1);     // Catch: Throwable -> L27
        if (r16 == null) goto L21;
        r7.add(r16);     // Catch: Throwable -> L27
    L21:
        String r3 = com.obric.memorydata.personalcontext.external.message.a.i(r1);     // Catch: Throwable -> L27
        if (r3 == null) goto L24;
        r8.add(r3);     // Catch: Throwable -> L27
    L24:
        r15 = r15 + 1;     // Catch: Throwable -> L27
        r0 = r12;
        goto L11
    L25:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L27
        CloseableKt.closeFinally(r11, r5);
        Long r18 = r0;
    L35:
        if (r6.isEmpty() == false) goto L42;
        if (r7.isEmpty() == false) goto L42;
        if (r8.isEmpty() == false) goto L42;
    L142:
        return r2;
    L42:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L68;
        Cursor r19 = ZeusProviderTransform.query(this.f12156b.getContentResolver(), com.obric.memorydata.personalcontext.external.message.a.a(), new String[]{com.obric.memorydata.personalcontext.external.message.a.i()}, com.obric.memorydata.personalcontext.external.message.a.i() + " IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), null, null, "com.obric.memorydata.plugin");
        Set r20 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L61;
        Closeable r21 = (Closeable) ZeusTransformUtils.preCheckCast(r19, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r22 = (Cursor) ZeusTransformUtils.preCheckCast(r21, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L55
    L48:
        if (r22.moveToNext() == false) goto L53;
        int r23 = r15;
        int r110 = g.f12138a.a(r22, com.obric.memorydata.personalcontext.external.message.a.i(), "ExternalSmsMmsObserver");     // Catch: Throwable -> L55
        if (r110 == (-1)) goto L51;
        String r111 = r22.getString(r110);     // Catch: Throwable -> L55
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L55
        r20.add(r111);     // Catch: Throwable -> L55
    L51:
        r15 = r23;
        goto L48
    L53:
        int r24 = r15;
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L55
        CloseableKt.closeFinally(r21, null);
    L62:
        Iterator r26 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L64:
        if (r26.hasNext() == false) goto L70;
        String r27 = (String) ZeusTransformUtils.preCheckCast(r26.next(), String.class, "com.obric.memorydata.plugin");
        if (r20.contains(r27) == true) goto L64;
        r2.add(com.obric.memorydata.personalcontext.external.message.a.a(r27));
    L70:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L96;
        Cursor r28 = ZeusProviderTransform.query(this.f12156b.getContentResolver(), com.obric.memorydata.personalcontext.external.message.a.b(), new String[]{com.obric.memorydata.personalcontext.external.message.a.j()}, com.obric.memorydata.personalcontext.external.message.a.j() + " IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), null, null, "com.obric.memorydata.plugin");
        Set r29 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L89;
        Closeable r30 = (Closeable) ZeusTransformUtils.preCheckCast(r28, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r31 = (Cursor) ZeusTransformUtils.preCheckCast(r30, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L83
    L76:
        if (r31.moveToNext() == false) goto L81;
        int r32 = g.f12138a.a(r31, com.obric.memorydata.personalcontext.external.message.a.j(), "ExternalSmsMmsObserver");     // Catch: Throwable -> L83
        if (r32 == (-1)) goto L76;
        String r33 = r31.getString(r32);     // Catch: Throwable -> L83
        Intrinsics.checkNotNull(r33);     // Catch: Throwable -> L83
        r29.add(r33);     // Catch: Throwable -> L83
        goto L76
    L81:
        Unit r34 = Unit.INSTANCE;     // Catch: Throwable -> L83
        CloseableKt.closeFinally(r30, null);
    L83:
        th = move-exception;
        throw th;     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        CloseableKt.closeFinally(r30, th);
        throw th;
    L89:
        Iterator r35 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L91:
        if (r35.hasNext() == false) goto L96;
        String r36 = (String) ZeusTransformUtils.preCheckCast(r35.next(), String.class, "com.obric.memorydata.plugin");
        if (r29.contains(r36) == true) goto L91;
        r2.add(com.obric.memorydata.personalcontext.external.message.a.b(r36));
    L96:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == true) goto L152;
    L139:
        Throwable r37 = null;
    L141:
        if (r24 < 2000) goto L142;
        r5 = r37;
        r4 = r4;
        r0 = r18;
        goto L3
    L152:
        e r38 = f.f12159a.a();     // Catch: Exception -> L136
        if (r38 == null) goto L100;
        Uri r112 = r38.a();     // Catch: Exception -> L136
    L101:
        if (r112 == null) goto L139;
        String r39 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null);     // Catch: Exception -> L136
        ContentResolver r210 = this.f12156b.getContentResolver();     // Catch: Exception -> L136
        Uri r310 = r38.a();     // Catch: Exception -> L136
        Intrinsics.checkNotNull(r310);     // Catch: Exception -> L136
        Cursor r40 = ZeusProviderTransform.query(r210, r310, new String[]{r38.b()}, r38.b() + " IN " + r39, null, null, "com.obric.memorydata.plugin");     // Catch: Exception -> L136
        Set r41 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L136
        if (r40 == null) goto L126;
        Closeable r42 = (Closeable) ZeusTransformUtils.preCheckCast(r40, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L136
        Cursor r43 = (Cursor) ZeusTransformUtils.preCheckCast(r42, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L119
    L107:
        if (r43.moveToNext() == false) goto L115;
        int r44 = g.f12138a.a(r43, r38.b(), "ExternalSmsMmsObserver");     // Catch: Throwable -> L113
        if (r44 == (-1)) goto L107;
        String r45 = r43.getString(r44);     // Catch: Throwable -> L113
        Intrinsics.checkNotNull(r45);     // Catch: Throwable -> L113
        r41.add(r45);     // Catch: Throwable -> L113
    L113:
        th = move-exception;
        Throwable r46 = th;
        r37 = null;
    L160:
        throw r46;     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        CloseableKt.closeFinally(r42, r46);     // Catch: Exception -> L134
        throw th;     // Catch: Exception -> L134
    L134:
        e = e;
    L138:
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalSmsMmsObserver", "query exist rms error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L141
    L115:
        Unit r47 = Unit.INSTANCE;     // Catch: Throwable -> L119
        r37 = null;
        CloseableKt.closeFinally(r42, null);     // Catch: Exception -> L134
    L127:
        Iterator r48 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L134
    L129:
        if (r48.hasNext() == false) goto L141;
        String r49 = (String) ZeusTransformUtils.preCheckCast(r48.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L134
        if (r41.contains(r49) == true) goto L129;
        r2.add(com.obric.memorydata.personalcontext.external.message.a.c(r49));     // Catch: Exception -> L134
    L119:
        th = move-exception;
        r37 = null;
        r46 = th;
        goto L160
    L126:
        r37 = null;
        goto L127
    L100:
        r112 = null;
    L136:
        e = e;
        r37 = null;
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        CloseableKt.closeFinally(r21, th);
        throw th;
    L61:
        r24 = r15;
        goto L62
    L68:
        r24 = r15;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L33:
        r18 = r0;
        r15 = 0;
        goto L35
    L6:
        r10 = r5;
        goto L7
    }

    private static final void c(c r0) {
        r0.b();
    }

    public static /* synthetic */ Unit lambda$3DoKsOx7PXwdPiU0wcJsLJ_f7zY(List r0, List r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$8HVW09Qy232_mS2z6qzM-p50nMI, reason: not valid java name */
    public static /* synthetic */ Unit m1075lambda$8HVW09Qy232_mS2z6qzMp50nMI(List r0, List r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$fBXxPJjpeaGr7e-6d91mUQhFP5U, reason: not valid java name */
    public static /* synthetic */ void m1076lambda$fBXxPJjpeaGr7e6d91mUQhFP5U(c r0) {
        c(r0);
    }

    public static /* synthetic */ Unit lambda$uVIyIrELu4N5P8Tv60KEBMkpHA8(e r0, List r1, List r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.memorydata.personalcontext.external.e.d
    public void a() {
        b();
    }

    public final void b() {
        long r0 = System.currentTimeMillis();
        long r2 = g.f12138a.b("message");
        if (r2 <= r0) goto L7;
        Long r3 = null;
    L5:
        a(r3, r0);
        return;
    L7:
        r3 = Long.valueOf(r2);
        goto L5
    }

    public final Context getContext() {
        return this.f12156b;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r3, Uri r4) {
        super.onChange(r3, r4);
        com.obric.memorydata.personalcontext.external.c.f12108a.a("ExternalSmsMmsObserver", "onChanged, uri=" + r4);
        com.obric.memorydata.personalcontext.external.f.f12127a.a().removeCallbacks(this.d);
        com.obric.memorydata.personalcontext.external.f.f12127a.a().postDelay(3000, this.d);
    }
}
