package com.obric.memorydata.personalcontext.external.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\r\u0010\u0014\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0015J\u0006\u0010\u0016\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/contacts/ExternalContactsObserver;", "Landroid/database/ContentObserver;", "Lcom/obric/memorydata/personalcontext/external/sms/IExternalSmsInitFetcher;", "mContext", "Landroid/content/Context;", "entityIndexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;)V", "getMContext", "()Landroid/content/Context;", "changeInnerRunnable", "Ljava/lang/Runnable;", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "syncOnStart", "changeInner", "changeInner$obric_entity_data_collector_obricRelease", "changeInnerSlow", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends ContentObserver implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f12112b;
    private final i c;
    private final Runnable d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/contacts/ExternalContactsObserver$Companion;", "", "<init>", "()V", "TAG", "", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12111a = new a(null);
    }

    public b(Context r3, i r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "mContext");
        Intrinsics.checkNotNullParameter(r4, "entityIndexUpdater");
        super(null);
        this.f12112b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r4;
        this.d = new $$Lambda$b$C8YOo56fKkHIz_hIFx0E64S7XZg(this);
    }

    private static final Unit a(List r8, Ref.LongRef r9, List r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "systemPage");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L4:
        if (r14.hasNext() == false) goto L14;
        Map r2 = (Map) ZeusTransformUtils.preCheckCast(r14.next(), Map.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.get("_id"), String.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.get("contact_last_updated_timestamp"), String.class, "com.obric.memorydata.plugin");
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
        Map r15 = MapsKt.toMap((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r15.isEmpty() == true) goto L17;
        String r1 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().c().a();
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r7 = s.a().getRawDaoByEntityType(201);
        if (r7 == null) goto L22;
        Object r16 = r7.queryByEntityIdListAndPackageName(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r15.keySet(), Iterable.class, "com.obric.memorydata.plugin")), r1);
        if (r16 == null) goto L22;
    L23:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Map r18 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r17, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L25:
        if (r19.hasNext() == false) goto L27;
        com.obric.memorydata.database.entity.d r20 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r19.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        Pair r21 = TuplesKt.to(r20.getEntityId(), Long.valueOf(r20.getModifyTime()));
        r18.put(r21.getFirst(), r21.getSecond());
        goto L25
    L27:
        Iterator r110 = r15.entrySet().iterator();
    L29:
        if (r110.hasNext() == false) goto L39;
        Map.Entry r22 = (Map.Entry) ZeusTransformUtils.preCheckCast(r110.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r23 = (String) ZeusTransformUtils.preCheckCast(r22.getKey(), String.class, "com.obric.memorydata.plugin");
        long r24 = ((Number) ZeusTransformUtils.preCheckCast(r22.getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Long r25 = (Long) ZeusTransformUtils.preCheckCast(r18.get(r23), Long.class, "com.obric.memorydata.plugin");
        if (r25 != null) goto L33;
    L34:
        r11.add(r23);
    L36:
        if (r24 <= r9.element) goto L29;
        r9.element = r24;
        goto L29
    L33:
        if (r25.longValue() == r24) goto L36;
    L39:
        return Unit.INSTANCE;
    L22:
        r16 = CollectionsKt.emptyList();
        goto L23
    L17:
        return Unit.INSTANCE;
    }

    private static final Unit a(Ref.LongRef r7, List r8, List r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "paginationResult");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L18;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r12.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get("_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("contact_last_updated_timestamp"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        Long r3 = Long.valueOf(Long.parseLong(r1));
    L12:
        if (r3 != null) goto L14;
    L16:
        r10.add(r2);
        goto L4
    L14:
        if (r3.longValue() <= r7.element) goto L16;
        r7.element = r3.longValue();
        goto L16
    L11:
        r3 = null;
        goto L12
    L18:
        return Unit.INSTANCE;
    }

    private static final void a(b r0) {
        r0.b();
    }

    private static final Unit b(Ref.LongRef r7, List r8, List r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "paginationResult");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L18;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r12.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get("contact_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("contact_deleted_timestamp"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L11;
        Long r3 = Long.valueOf(Long.parseLong(r1));
    L12:
        if (r3 != null) goto L14;
    L16:
        r10.add(r2);
        goto L4
    L14:
        if (r3.longValue() <= r7.element) goto L16;
        r7.element = r3.longValue();
        goto L16
    L11:
        r3 = null;
        goto L12
    L18:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$6ZeO99RoCT9h0pXN8v7vJ6dwI4I(Ref.LongRef r0, List r1, List r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$C8YOo56fKkHIz_hIFx0E64S7XZg(b r0) {
        a(r0);
    }

    public static /* synthetic */ Unit lambda$Uh1ebBsrfdC_osk7afPiM5Hjc50(Ref.LongRef r0, List r1, List r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$tYqPgVfU7EgMHRfJbs2RvMIOEAs(List r0, Ref.LongRef r1, List r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.memorydata.personalcontext.external.e.d
    public void a() {
        b();
    }

    public final void b() {
        long r1 = System.currentTimeMillis();
        long r5 = g.f12138a.b("contacts");
        long r8 = g.f12138a.b("contacts_delete");
        if (r5 <= r1) goto L5;
    L15:
        c();
        g.f12138a.a("contacts", r1);
        g r0 = g.f12138a;
    L13:
        r0.a("contacts_delete", r1);
        return;
    L5:
        if (r8 > r1) goto L15;
        final Ref.LongRef r3 = new Ref.LongRef();
        r3.element = r5;
        final List<String> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String[] r13 = {String.valueOf(r5), String.valueOf(r1)};
        com.obric.memorydata.personalcontext.external.c.a r14 = com.obric.memorydata.personalcontext.external.c.a.f12109a;
        ContentResolver r15 = this.f12112b.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r15, "getContentResolver(...)");
        r14.a(r15, 2000, new String[]{"_id", "contact_last_updated_timestamp"}, "contact_last_updated_timestamp > ? and contact_last_updated_timestamp <= ?", r13, new $$Lambda$b$Uh1ebBsrfdC_osk7afPiM5Hjc50(r3, r10));
        final List<String> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        final Ref.LongRef r12 = new Ref.LongRef();
        r12.element = r8;
        String[] r11 = {String.valueOf(r8), String.valueOf(r1)};
        g r22 = g.f12138a;
        ContentResolver r2 = this.f12112b.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r2, "getContentResolver(...)");
        Uri r4 = ContactsContract.DeletedContacts.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(r4, "CONTENT_URI");
        r22.a(r2, r4, new String[]{"contact_id", "contact_deleted_timestamp"}, "contact_id", 2000, "contact_deleted_timestamp > ? and contact_deleted_timestamp <= ?", r11, new $$Lambda$b$6ZeO99RoCT9h0pXN8v7vJ6dwI4I(r12, r6));
        this.c.a(r10, 201);
        this.c.b(r6, 201);
        if (r10.isEmpty() == true) goto L10;
    L12:
        g.f12138a.a("contacts", r3.element);
        r0 = g.f12138a;
        r1 = r12.element;
        goto L13
    L10:
        if (r6.isEmpty() == false) goto L12;
        c.f12108a.b("ExternalContactsObserver", "onChange updatedIds is empty, deletedIds is empty, run changeInnerSlow");
        c();
        goto L12
    }

    public final void c() {
        final List<String> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        final Ref.LongRef r2 = new Ref.LongRef();
        com.obric.memorydata.personalcontext.external.c.a r4 = com.obric.memorydata.personalcontext.external.c.a.f12109a;
        ContentResolver r5 = this.f12112b.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r5, "getContentResolver(...)");
        r4.a(r5, 2000, new String[]{"_id", "contact_last_updated_timestamp"}, null, null, new $$Lambda$b$tYqPgVfU7EgMHRfJbs2RvMIOEAs(r1, r2));
        List<String> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String r7 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().c().a();
        Long r8 = null;
    L3:
        List r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r10 = s.a().getRawDaoByEntityType(201);
        if (r10 == null) goto L6;
        Cursor r11 = r10.queryByPackageName(new String[]{"entityId", OaidModel.KEY_ID}, r7, 2000, r8);
    L7:
        if (r11 == null) goto L21;
        Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r11, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r13 = (Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        int r16 = 0;
    L11:
        if (r13.moveToNext() == false) goto L13;
        String r14 = r13.getString(r13.getColumnIndexOrThrow("entityId"));     // Catch: Throwable -> L15
        Long r15 = Long.valueOf(r13.getLong(r13.getColumnIndexOrThrow(OaidModel.KEY_ID)));     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L15
        r9.add(r14);     // Catch: Throwable -> L15
        r16 = r16 + 1;     // Catch: Throwable -> L15
        r8 = r15;
        goto L11
    L13:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r12, null);
        int r18 = r16;
    L23:
        if (r9.isEmpty() == true) goto L47;
        Cursor r19 = ZeusProviderTransform.query(this.f12112b.getContentResolver(), ContactsContract.Contacts.CONTENT_URI, new String[]{"_id"}, "_id IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), null, null, "com.obric.memorydata.plugin");
        Set r110 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L40;
        Closeable r111 = (Closeable) ZeusTransformUtils.preCheckCast(r19, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r112 = (Cursor) ZeusTransformUtils.preCheckCast(r111, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
    L30:
        if (r112.moveToNext() == false) goto L32;
        String r113 = r112.getString(r112.getColumnIndexOrThrow("_id"));     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L34
        r110.add(r113);     // Catch: Throwable -> L34
        goto L30
    L32:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L34
        CloseableKt.closeFinally(r111, null);
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        CloseableKt.closeFinally(r111, th);
        throw th;
    L40:
        Iterator r20 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L42:
        if (r20.hasNext() == false) goto L46;
        String r115 = (String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.memorydata.plugin");
        if (r110.contains(r115) == true) goto L42;
        r6.add(r115);
        goto L42
    L46:
        if (r18 >= 2000) goto L3;
    L47:
        this.c.a(r1, 201);
        this.c.b(r6, 201);
        long r0 = System.currentTimeMillis();
        g r3 = g.f12138a;
        if (r2.element <= 0) goto L50;
        long r21 = r2.element;
    L51:
        r3.a("contacts", r21);
        g.f12138a.a("contacts_delete", r0);
        return;
    L50:
        r21 = r0;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L21:
        r18 = 0;
        goto L23
    L6:
        r11 = null;
        goto L7
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r4, Uri r5) {
        super.onChange(r4, r5);
        c.f12108a.a("ExternalContactsObserver", "onChange selfChange=" + r4 + ", uri=" + r5);
        f.f12127a.a().removeCallbacks(this.d);
        f.f12127a.a().postDelay(3000, this.d);
    }
}
