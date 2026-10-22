package com.obric.memorydata.personalcontext.collector;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.DeadSystemException;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.aj;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\rJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\rJ\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\r2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\rJ\u001c\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/MediaFileEntitySupplier;", "Lcom/obric/capabilitykit/EntitySupplier;", "<init>", "()V", "TAG", "", "MEDIA_FILE_QUERY_FULL_DATA_PAGE_SIZE", "", "TARGET_MIME_TYPES", "", "[Ljava/lang/String;", "FORMAT_CLAUSE", "getMediaFileDataByTimeStamp", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "startTimeStamp", "", "hasPermission", "", "getNeedRequestPermissions", "getAllMediaFileData", "(Ljava/lang/Long;)Ljava/util/List;", "getAllMediaFileIdData", "Lcom/obric/capabilitykit/sync/EntityIdData;", "queryFilesByIds", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "contentResolver", "Landroid/content/ContentResolver;", "ids", "isHiddenFile", "displayName", "path", "provideAllEntities", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h implements EntitySupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f12071a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f12072b = null;
    private static final String c = null;

    static {
        f12071a = new h();
        String[] r10 = {"text/plain", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/msword", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/vnd.ms-powerpoint", "application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/pdf", "text/csv"};
        f12072b = r10;
        c = "mime_type IN (" + ArraysKt.joinToString$default(r10, (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$h$My98GvuaI9qpEQ6SUi8cBf76NLo.INSTANCE, 30, null) + ')';
    }

    private h() {
    }

    private static final CharSequence a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ List a(h r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.a(r1);
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

    private final boolean a(String r12, String r13) {
        if (r12 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        if (r14 == false) goto L10;
        return true;
    L10:
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L13;
    L16:
        boolean r16 = true;
    L17:
        if (r16 == false) goto L19;
        return false;
    L19:
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new String[]{File.separator}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r17, Collection.class) == true) goto L22;
    L24:
        Iterator r18 = r17.iterator();
    L26:
        if (r18.hasNext() == false) goto L36;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin");
        if (StringsKt.startsWith$default(r19, ".", false, 2, null) == true) goto L30;
    L34:
        boolean r110 = false;
    L35:
        if (r110 == false) goto L26;
        return true;
    L30:
        if (Intrinsics.areEqual(r19, ".") == true) goto L34;
        if (Intrinsics.areEqual(r19, "..") == true) goto L34;
        r110 = true;
    L36:
        return false;
    L22:
        if (((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L24;
    L13:
        if (r15.length() == 0) goto L16;
        r16 = false;
        goto L17
    L5:
        if (StringsKt.startsWith$default(r12, ".", false, 2, null) != true) goto L7;
        r14 = true;
        goto L8
    }

    private static final CharSequence b(long r1) {
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    private static final Unit b(List r7, List r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "rows");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L19;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r11.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get("_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        if (f12071a.a((String) ZeusTransformUtils.preCheckCast(r0.get("_display_name"), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.get("_data"), String.class, "com.obric.memorydata.plugin")) == true) goto L4;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("date_modified"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L16;
        Long r3 = StringsKt.toLongOrNull(r1);
        if (r3 == null) goto L16;
        long r4 = r3.longValue() * 1000;
    L17:
        r9.add(new EntityIdData(r2, EntityType.FILE, r4));
    L16:
        r4 = 0;
        goto L17
    L19:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$4geQaZiB77evE0ljuw-v-reSoog, reason: not valid java name */
    public static /* synthetic */ CharSequence m1061lambda$4geQaZiB77evE0ljuwvreSoog(long r0) {
        return b(r0);
    }

    public static /* synthetic */ Unit lambda$BTSKqHqpvnw6qaiTRib20INUKSM(List r0, List r1) {
        return b(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$LZADQUBCr-2vo8Z3xHX564ZFv3s, reason: not valid java name */
    public static /* synthetic */ Unit m1062lambda$LZADQUBCr2vo8Z3xHX564ZFv3s(List r0, List r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ CharSequence lambda$My98GvuaI9qpEQ6SUi8cBf76NLo(String r0) {
        return a(r0);
    }

    public final List<AppEntity> a(long r1) {
        return a(Long.valueOf(r1));
    }

    public final List<FileEntity> a(ContentResolver r29, List<Long> r30) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r29, "contentResolver");
        Intrinsics.checkNotNullParameter(r0, "ids");
        if (a() == false) goto L5;
        List<FileEntity> r3 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        String[] r6 = {"_id", "date_added", "date_modified", "_display_name", "mime_type", "_size", "_data"};
        Uri r5 = MediaStore.Files.getContentUri("external");
        String r7 = "_id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$h$4geQaZiB77evE0ljuwvreSoog.INSTANCE, 30, null) + ')';
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L47;
        r8.add(String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r2.next(), Number.class, "com.obric.memorydata.plugin")).longValue()));
        goto L8
    L47:
        Cursor r4 = ZeusProviderTransform.query(r29, r5, r6, r7, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin"), null, "com.obric.memorydata.plugin");     // Catch: DeadSystemException -> L40
        if (r4 == null) goto L42;
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.memorydata.plugin");     // Catch: DeadSystemException -> L40
        Cursor r10 = (Cursor) ZeusTransformUtils.preCheckCast(r9, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
    L16:
        if (r10.moveToNext() == false) goto L27;
        int r11 = r10.getColumnIndexOrThrow("_id");     // Catch: Throwable -> L33
        int r12 = r10.getColumnIndexOrThrow("date_added");     // Catch: Throwable -> L33
        int r13 = r10.getColumnIndexOrThrow("date_modified");     // Catch: Throwable -> L33
        int r14 = r10.getColumnIndexOrThrow("_display_name");     // Catch: Throwable -> L33
        int r15 = r10.getColumnIndexOrThrow("mime_type");     // Catch: Throwable -> L33
        int r16 = r10.getColumnIndexOrThrow("_size");     // Catch: Throwable -> L33
        int r17 = r10.getColumnIndex("_data");     // Catch: Throwable -> L33
        long r18 = r10.getLong(r11);     // Catch: Throwable -> L33
        long r19 = r10.getLong(r12);     // Catch: Throwable -> L33
        Closeable r210 = r9;
        long r20 = r10.getLong(r13);     // Catch: Throwable -> L31
        long r110 = e.f12066a.a(r19, r20);     // Catch: Throwable -> L31
        long r21 = r20 * 1000;     // Catch: Throwable -> L31
        String r22 = r10.getString(r14);     // Catch: Throwable -> L31
        String r27 = r10.getString(r15);     // Catch: Throwable -> L31
        long r23 = r10.getLong(r16);     // Catch: Throwable -> L31
        Uri r25 = MediaStore.Files.getContentUri("external", r18);     // Catch: Throwable -> L31
        if (r17 == (-1)) goto L22;
        String r24 = r10.getString(r17);     // Catch: Throwable -> L31
    L23:
        boolean r26 = f12071a.a(r22, r24);     // Catch: Throwable -> L31
        RunLog.INSTANCE.debug("MediaFileEntitySupplier", "queryFilesByIds, id = " + r18 + ", isHiddenFile = " + r26 + ", path = " + r24);     // Catch: Throwable -> L31
        if (r26 == true) goto L25;
        String r111 = String.valueOf(r18);     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r22);     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r25);     // Catch: Throwable -> L31
        FileEntity r28 = new FileEntity(r111, r110, r21, r22, r23, r25, FileTypeEnum.FILE, r27);     // Catch: Throwable -> L31
        r28.set_packageName(BuildConfig.LIBRARY_PACKAGE_NAME);     // Catch: Throwable -> L31
        r3.add(r28);     // Catch: Throwable -> L31
    L25:
        r9 = r210;
        goto L16
    L22:
        r24 = null;
    L31:
        th = th;
        r9 = r210;
    L34:
        Throwable r31 = th;
        throw r31;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        CloseableKt.closeFinally(r9, r31);     // Catch: DeadSystemException -> L40
        throw th;     // Catch: DeadSystemException -> L40
    L27:
        r210 = r9;
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r210, null);     // Catch: DeadSystemException -> L40
    L33:
        th = th;
    L42:
        return r3;
    L40:
        e = move-exception;
        RunLog.INSTANCE.error("MediaFileEntitySupplier", "queryFilesByIds error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L42
    L5:
        return CollectionsKt.emptyList();
    }

    public final List<AppEntity> a(Long r11) {
        if (a() == false) goto L5;
        String r10 = c;
        if (r11 == null) goto L9;
        long r1 = r11.longValue() / ((long) 1000);
        r10 = "(date_added >= " + r1 + " OR date_modified >= " + r1 + ") AND (" + r10 + ')';
    L9:
        String r6 = r10;
        final List r12 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        ContentResolver r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();     // Catch: DeadSystemException -> L12
        Intrinsics.checkNotNullExpressionValue(r2, "getContentResolver(...)");     // Catch: DeadSystemException -> L12
        Uri r3 = MediaStore.Files.getContentUri("external");     // Catch: DeadSystemException -> L12
        Intrinsics.checkNotNullExpressionValue(r3, "getContentUri(...)");     // Catch: DeadSystemException -> L12
        aj.a(r2, r3, new String[]{"_id"}, "_id", 100, r6, f12072b, new $$Lambda$h$LZADQUBCr2vo8Z3xHX564ZFv3s(r12));     // Catch: DeadSystemException -> L12
    L14:
        List<AppEntity> r13 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L16:
        if (r15.hasNext() == false) goto L18;
        r4.add(Long.valueOf(Long.parseLong((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin"))));
        goto L16
    L18:
        Iterator r16 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 100), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r16.hasNext() == false) goto L22;
        List<Long> r5 = (List) ZeusTransformUtils.preCheckCast(r16.next(), List.class, "com.obric.memorydata.plugin");
        h r7 = f12071a;
        ContentResolver r8 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r8, "getContentResolver(...)");
        r13.addAll((Collection) ZeusTransformUtils.preCheckCast(r7.a(r8, r5), Collection.class, "com.obric.memorydata.plugin"));
        goto L20
    L22:
        return r13;
    L12:
        e = move-exception;
        RunLog.INSTANCE.error("MediaFileEntitySupplier", "getAllMediaFileData, paginationQuery throw DeadSystemException", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L14
    L5:
        return CollectionsKt.emptyList();
    }

    public final boolean a() {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(b(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        boolean r0 = true;
    L4:
        if (r5.hasNext() == false) goto L10;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L4;
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2) == 0) goto L4;
        r0 = false;
        goto L4
    L10:
        return r0;
    }

    public final List<String> b() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        String r1 = "android.permission.MANAGE_EXTERNAL_STORAGE";
    L7:
        return CollectionsKt.listOf(r1);
    L5:
        r1 = "android.permission.READ_EXTERNAL_STORAGE";
        goto L7
    }

    public final List<EntityIdData> c() {
        final List<EntityIdData> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        ContentResolver r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver();     // Catch: DeadSystemException -> L5
        Intrinsics.checkNotNullExpressionValue(r2, "getContentResolver(...)");     // Catch: DeadSystemException -> L5
        Uri r3 = MediaStore.Files.getContentUri("external");     // Catch: DeadSystemException -> L5
        Intrinsics.checkNotNullExpressionValue(r3, "getContentUri(...)");     // Catch: DeadSystemException -> L5
        aj.a(r2, r3, new String[]{"_id", "date_modified", "_display_name", "_data"}, "_id", 100, c, f12072b, new $$Lambda$h$BTSKqHqpvnw6qaiTRib20INUKSM(r10));     // Catch: DeadSystemException -> L5
    L7:
        return r10;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("MediaFileEntitySupplier", "getAllMediaFileIdData, paginationQuery throw DeadSystemException", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L7
    }

    @Override // com.obric.capabilitykit.EntitySupplier
    public List<AppEntity> provideAllEntities() {
        return a(this, null, 1, null);
    }
}
