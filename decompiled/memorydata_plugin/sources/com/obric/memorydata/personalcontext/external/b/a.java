package com.obric.memorydata.personalcontext.external.b;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.enums.CallTypeEnum;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.memorydata.middleware.api.IAgentServiceProvider;
import com.obric.memorydata.personalcontext.external.g;
import com.obric.memorydata.personalcontext.external.h;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016Jk\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00142&\u0010\u0017\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00190\u0005\u0012\u0004\u0012\u00020\u00110\u0018¢\u0006\u0002\u0010\u001aJ$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000fH\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/callhistory/ExternalCallHistoryDataRequester;", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityDataRequester;", "<init>", "()V", "supportDonateTypes", "", "", "onGetAllEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "contentResolver", "Landroid/content/ContentResolver;", "onGetAllEntityIdData", "Lcom/obric/capabilitykit/sync/EntityIdData;", "onQueryEntities", "entityIds", "", "callHistoryPaginationQuery", "", "pageLimit", "projection", "", "selection", "selectionArgs", "result", "Lkotlin/Function1;", "", "(Landroid/content/ContentResolver;I[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "queryAllEntitiesInner", "callTypeToDesc", "Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "type", "duration", "", "formatNumber", "phoneNumber", "getDonateEntityTypeList", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12104a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f12105b = null;

    static {
        f12104a = new a();
        f12105b = CollectionsKt.listOf(202);
    }

    private a() {
    }

    private final CallTypeEnum a(int r1, long r2) {
        if (r1 == 1) goto L17;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L19;
        if (r1 == 5) goto L19;
        return null;
    L19:
        return CallTypeEnum.INCOMING_CALL_MISSED;
    L13:
        if (r2 <= 0) goto L21;
        return CallTypeEnum.OUTGOING_CALL_ANSWERED;
    L21:
        return CallTypeEnum.OUTGOING_CALL_MISSED;
    L17:
        return CallTypeEnum.INCOMING_CALL_ANSWERED;
    }

    private final String a(String r2) {
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return r2;
    L5:
        String r1 = PhoneNumberUtils.formatNumber(r2, Locale.getDefault().getCountry());
        if (r1 != null) goto L9;
        return r2;
    L9:
        return r1;
    }

    private static final Unit a(List r4, List r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "it");
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        String r2 = (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(r9.next(), Map.class, "com.obric.memorydata.plugin")).get("_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private static final Unit b(List r9, List r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "rows");
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r13.hasNext() == false) goto L34;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r13.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get("_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r0.get("duration"), String.class, "com.obric.memorydata.plugin");
        long r4 = 0;
        if (r3 == null) goto L13;
        Long r5 = StringsKt.toLongOrNull(r3);
        if (r5 == null) goto L13;
        long r6 = r5.longValue();
    L14:
        String r7 = (String) ZeusTransformUtils.preCheckCast(r0.get("type"), String.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L4;
        Integer r8 = StringsKt.toIntOrNull(r7);
        if (r8 == null) goto L4;
        if (f12104a.a(r8.intValue(), r6) == null) goto L4;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r0.get("last_modified"), String.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L26;
        Long r15 = StringsKt.toLongOrNull(r14);
        if (r15 == null) goto L26;
        r4 = r15.longValue();
    L32:
        r11.add(new EntityIdData(r2, 202, r4));
    L26:
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("date"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L29;
        Long r16 = StringsKt.toLongOrNull(r1);
    L30:
        if (r16 == null) goto L32;
        r4 = r16.longValue();
        goto L32
    L29:
        r16 = null;
    L13:
        r6 = 0;
        goto L14
    L34:
        return Unit.INSTANCE;
    }

    private final List<AppEntity> c(ContentResolver r26, List<String> r27) {
        List<String> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        String r13 = "_id IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null);
        Cursor r2 = ZeusProviderTransform.query(r26, CallLog.Calls.CONTENT_URI, new String[]{"_id", "date", "last_modified", "duration", "number", "type", "numberlabel", "geocoded_location"}, r13, null, null, "com.obric.memorydata.plugin");
        List r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L45;
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r4, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
    L6:
        String r6 = null;
        if (r5.moveToNext() == false) goto L36;
        int r7 = r5.getColumnIndex("_id");     // Catch: Throwable -> L38
        int r8 = r5.getColumnIndex("date");     // Catch: Throwable -> L38
        int r9 = r5.getColumnIndex("last_modified");     // Catch: Throwable -> L38
        int r10 = r5.getColumnIndex("duration");     // Catch: Throwable -> L38
        int r11 = r5.getColumnIndex("number");     // Catch: Throwable -> L38
        int r12 = r5.getColumnIndex("type");     // Catch: Throwable -> L38
        int r14 = r5.getColumnIndex("geocoded_location");     // Catch: Throwable -> L38
        int r15 = r5.getColumnIndex("numberlabel");     // Catch: Throwable -> L38
        if (r7 == (-1)) goto L6;
        if (r8 == (-1)) goto L6;
        if (r10 == (-1)) goto L6;
        if (r11 == (-1)) goto L6;
        if (r12 == (-1)) goto L6;
        String r16 = r5.getString(r7);     // Catch: Throwable -> L38
        long r17 = r5.getLong(r8);     // Catch: Throwable -> L38
        if (r9 != (-1)) goto L17;
    L19:
        long r19 = r17;
    L20:
        int r18 = r5.getInt(r10);     // Catch: Throwable -> L38
        String r20 = r5.getString(r11);     // Catch: Throwable -> L38
        int r21 = r5.getInt(r12);     // Catch: Throwable -> L38
        String r22 = r5.getString(r15);     // Catch: Throwable -> L38
        a r110 = f12104a;     // Catch: Throwable -> L38
        CallTypeEnum r23 = r110.a(r21, r18);     // Catch: Throwable -> L38
        if (r14 < 0) goto L23;
        r6 = r5.getString(r14);     // Catch: Throwable -> L38
    L23:
        Intrinsics.checkNotNull(r20);     // Catch: Throwable -> L38
        String r24 = r110.a(r20);     // Catch: Throwable -> L38
        List<String> r25 = CollectionsKt.listOf(r24);     // Catch: Throwable -> L38
        IAgentServiceProvider r111 = g.f12138a.a();     // Catch: Throwable -> L38
        if (r111 == null) goto L28;
        Map<String, String> r112 = r111.getPhoneNumberLocation(r25);     // Catch: Throwable -> L38
        if (r112 == null) goto L28;
        r6 = r112.get(r24);     // Catch: Throwable -> L38
    L28:
        if (r23 == null) goto L6;
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L38
        CallHistoryEntity r28 = new CallHistoryEntity(r16, r17, r19, r25, null, r23, r18);     // Catch: Throwable -> L38
        if (r22 == null) goto L32;
        r28.setTag(r22);     // Catch: Throwable -> L38
    L32:
        String r29 = (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L38
        if (r29 == null) goto L35;
        r28.setCarriers(CollectionsKt.listOf(r29));     // Catch: Throwable -> L38
    L35:
        r3.add(r28);     // Catch: Throwable -> L38
        goto L6
    L17:
        if (r5.isNull(r9) == true) goto L19;
        r19 = r5.getLong(r9);     // Catch: Throwable -> L38
        goto L20
    L36:
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L38
        CloseableKt.closeFinally(r4, null);
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);
        throw th;
    L45:
        return g.f12138a.a((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.memorydata.plugin"), r0);
    }

    public static /* synthetic */ Unit lambda$8cU5DpSD_P1LcqFASLichxwLMRc(List r0, List r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$gVT9M3W3g5dUKFl0kd6hJ5LVUV4(List r0, List r1) {
        return b(r0, r1);
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<Integer> a() {
        return f12105b;
    }

    public final void a(ContentResolver r10, int r11, String[] r12, String r13, String[] r14, Function1<? super List<? extends Map<String, String>>, Unit> r15) {
        Function1<? super List<? extends Map<String, String>>, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "contentResolver");
        Intrinsics.checkNotNullParameter(r12, "projection");
        Intrinsics.checkNotNullParameter(r8, "result");
        g r0 = g.f12138a;
        Uri r2 = CallLog.Calls.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(r2, "CONTENT_URI");
        r0.a(r10, r2, r12, "_id", r11, r13, r14, r8);
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<AppEntity> b(ContentResolver r4, List<String> r5) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "contentResolver");
        Intrinsics.checkNotNullParameter(r3, "entityIds");
        List<AppEntity> r6 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"), 200), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        List<String> r1 = (List) ZeusTransformUtils.preCheckCast(r7.next(), List.class, "com.obric.memorydata.plugin");
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast(f12104a.c(r4, r1), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r6;
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<AppEntity> c(ContentResolver r11) {
        Intrinsics.checkNotNullParameter(r11, "contentResolver");
        final List<String> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        g r1 = g.f12138a;
        Uri r3 = CallLog.Calls.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(r3, "CONTENT_URI");
        r1.a(r11, r3, new String[]{"_id"}, "_id", 200, null, null, new $$Lambda$a$8cU5DpSD_P1LcqFASLichxwLMRc(r0));
        return a(r11, r0);
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<EntityIdData> d(ContentResolver r14) {
        Intrinsics.checkNotNullParameter(r14, "contentResolver");
        final List<EntityIdData> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        a(r14, 2000, new String[]{"_id", "date", "last_modified", "duration", "type"}, null, null, new $$Lambda$a$gVT9M3W3g5dUKFl0kd6hJ5LVUV4(r0));
        return r0;
    }
}
