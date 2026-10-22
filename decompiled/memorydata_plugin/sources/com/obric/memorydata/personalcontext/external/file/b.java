package com.obric.memorydata.personalcontext.external.file;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.memorydata.personalcontext.external.g;
import com.obric.memorydata.personalcontext.external.h;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00072\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002JQ\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\n2&\u0010!\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050#0\u0007\u0012\u0004\u0012\u00020\u001d0\"¢\u0006\u0002\u0010$J8\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050&2\u0006\u0010'\u001a\u00020\u00152\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010&2\b\b\u0002\u0010)\u001a\u00020\b2\b\b\u0002\u0010*\u001a\u00020\bJ\u001c\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0080\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u00060"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/file/ExternalFileDataRequester;", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityDataRequester;", "<init>", "()V", "TAG", "", "supportDonateTypes", "", "", "TARGET_MIME_TYPES", "", "getTARGET_MIME_TYPES$obric_entity_data_collector_obricRelease", "()[Ljava/lang/String;", "[Ljava/lang/String;", "FORMAT_CLAUSE", "getFORMAT_CLAUSE$obric_entity_data_collector_obricRelease", "()Ljava/lang/String;", "PROJECTION", "onGetAllEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "contentResolver", "Landroid/content/ContentResolver;", "onQueryEntities", "entityIds", "onGetAllEntityIdData", "Lcom/obric/capabilitykit/sync/EntityIdData;", "getDonateEntityTypeList", "queryEntitiesInnerByIds", "filePaginationQueryByGeneration", "", "lastModifyGeneration", "", "projection", "result", "Lkotlin/Function1;", "", "(Landroid/content/ContentResolver;J[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getFiles", "", "resolver", "idList", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "isHiddenFile", "", "displayName", "path", "FileColumnMap", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12130a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f12131b = null;
    private static final String[] c = null;
    private static final String d = null;
    private static final String[] e = null;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/file/ExternalFileDataRequester$FileColumnMap;", "", "cursor", "Landroid/database/Cursor;", "<init>", "(Landroid/database/Cursor;)V", "idIndex", "", "getIdIndex", "()I", "dateAddedIndex", "getDateAddedIndex", "dateModifiedIndex", "getDateModifiedIndex", "displayNameIndex", "getDisplayNameIndex", "mimeTypeIndex", "getMimeTypeIndex", "sizeIndex", "getSizeIndex", "pathIndex", "getPathIndex", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f12132a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f12133b;
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final int g;

        public a(Cursor r4) {
            Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r4, Cursor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "cursor");
            this.f12132a = g.f12138a.a(r5, "_id", "ExternalFileDataRequester");
            this.f12133b = g.f12138a.a(r5, "date_added", "ExternalFileDataRequester");
            this.c = g.f12138a.a(r5, "date_modified", "ExternalFileDataRequester");
            this.d = g.f12138a.a(r5, "_display_name", "ExternalFileDataRequester");
            this.e = g.f12138a.a(r5, "mime_type", "ExternalFileDataRequester");
            this.f = g.f12138a.a(r5, "_size", "ExternalFileDataRequester");
            this.g = g.f12138a.a(r5, "_data", "ExternalFileDataRequester");
        }

        public final int a() {
            return this.f12132a;
        }

        public final int b() {
            return this.f12133b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public final int f() {
            return this.f;
        }

        public final int g() {
            return this.g;
        }
    }

    static {
        f12130a = new b();
        f12131b = CollectionsKt.listOf(Integer.valueOf(EntityType.FILE));
        String[] r10 = {"application/pdf", "text/plain", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "text/csv"};
        c = r10;
        d = "(mime_type IN (" + ArraysKt.joinToString$default(r10, (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$b$HqwoVOOf4794NLgdjYZTMB9_ak.INSTANCE, 30, null) + "))";
        e = new String[]{"_id", "_display_name", "mime_type", "_size", "date_added", "date_modified", "_data"};
    }

    private b() {
    }

    private static final CharSequence a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Set a(b r1, ContentResolver r2, Set r3, int r4, int r5, int r6, Object r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r5 = 2000;
    L9:
        return r1.a(r2, r8, r4, r5);
    }

    private static final Unit a(List r7, List r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "rows");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L19;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r11.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get("_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        if (f12130a.a((String) ZeusTransformUtils.preCheckCast(r0.get("_display_name"), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.get("_data"), String.class, "com.obric.memorydata.plugin")) == true) goto L4;
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

    private final List<AppEntity> c(ContentResolver r25, List<String> r26) {
        Cursor r0 = ZeusProviderTransform.query(r25, e.f12136a.a(), e, "_id IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null), null, null, "com.obric.memorydata.plugin");
        List<AppEntity> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L28;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        a r4 = new a(r0);     // Catch: Throwable -> L22
    L6:
        String r5 = null;
        if (r1.moveToNext() == false) goto L20;
        int r6 = r4.a();     // Catch: Throwable -> L22
        if (r1.isNull(r6) == false) goto L11;
        Long r7 = null;
    L12:
        if (r7 == null) goto L6;
        long r8 = r7.longValue();     // Catch: Throwable -> L22
        long r9 = r1.getLong(r4.b());     // Catch: Throwable -> L22
        long r10 = r1.getLong(r4.c());     // Catch: Throwable -> L22
        long r14 = com.obric.memorydata.personalcontext.collector.e.f12066a.a(r9, r10);     // Catch: Throwable -> L22
        long r16 = r10 * 1000;     // Catch: Throwable -> L22
        String r11 = r1.getString(r4.d());     // Catch: Throwable -> L22
        String r23 = r1.getString(r4.e());     // Catch: Throwable -> L22
        long r19 = r1.getLong(r4.f());     // Catch: Throwable -> L22
        Uri r21 = MediaStore.Files.getContentUri("external", r8);     // Catch: Throwable -> L22
        if (r4.g() == (-1)) goto L16;
        r5 = r1.getString(r4.g());     // Catch: Throwable -> L22
    L16:
        boolean r12 = f12130a.a(r11, r5);     // Catch: Throwable -> L22
        com.obric.memorydata.personalcontext.external.c.f12108a.a("ExternalFileDataRequester", "queryFilesByIds, id = " + r8 + ", isHiddenFile = " + r12 + ", path = " + r5);     // Catch: Throwable -> L22
        if (r12 == true) goto L6;
        String r13 = String.valueOf(r8);     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r21);     // Catch: Throwable -> L22
        r2.add(new FileEntity(r13, r14, r16, r11, r19, r21, FileTypeEnum.FILE, r23));     // Catch: Throwable -> L22
        goto L6
    L11:
        r7 = Long.valueOf(r1.getLong(r6));     // Catch: Throwable -> L22
        goto L12
    L20:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L22
        CloseableKt.closeFinally(r3, null);
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L28:
        return r2;
    }

    /* JADX INFO: renamed from: lambda$HqwoVOOf479-4NLgdjYZTMB9_ak, reason: not valid java name */
    public static /* synthetic */ CharSequence m1070lambda$HqwoVOOf4794NLgdjYZTMB9_ak(String r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$mCSfy12TmbiCyVsec5JxgLfdbOA(List r0, List r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<Integer> a() {
        return f12131b;
    }

    public final Set<String> a(ContentResolver r11, Set<String> r12, int r13, int r14) {
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "resolver");
        if (r10 != null) goto L5;
        String r15 = "(1 == 1)";
    L10:
        Bundle r4 = new Bundle();
        r4.putString("android:query-arg-sql-selection", r15 + " AND " + d);
        r4.putStringArray("android:query-arg-sql-selection-args", c);
        r4.putInt("android:query-arg-sort-direction", 0);
        r4.putInt("android:query-arg-limit", r14);
        r4.putInt("android:query-arg-offset", r13);
        Cursor r16 = ZeusProviderTransform.query(r11, e.f12136a.a(), new String[]{"_id"}, r4, null, "com.obric.memorydata.plugin");
        Set<String> r17 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L24;
        Closeable r18 = (Closeable) ZeusTransformUtils.preCheckCast(r16, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r19 = (Cursor) ZeusTransformUtils.preCheckCast(r18, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
    L15:
        if (r19.moveToNext() == false) goto L17;
        String r0 = r19.getString(0);     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r0, "getString(...)");     // Catch: Throwable -> L19
        r17.add(r0);     // Catch: Throwable -> L19
        goto L15
    L17:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r18, null);
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);
        throw th;
    L24:
        return r17;
    L5:
        if (r10.isEmpty() == true) goto L7;
        r15 = "(_id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + "))";
        goto L10
    L7:
        return SetsKt.emptySet();
    }

    public final void a(ContentResolver r11, long r12, String[] r14, Function1<? super List<? extends Map<String, String>>, Unit> r15) {
        Function1<? super List<? extends Map<String, String>>, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r15, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "contentResolver");
        Intrinsics.checkNotNullParameter(r14, "projection");
        Intrinsics.checkNotNullParameter(r9, "result");
        String r7 = "(generation_modified > ?) and " + d;
        String[] r8 = (String[]) ZeusTransformUtils.preCheckCast(ArraysKt.plus(new String[]{String.valueOf(r12)}, c), String[].class, "com.obric.memorydata.plugin");
        g r1 = g.f12138a;
        Uri r3 = e.f12136a.a();
        Intrinsics.checkNotNullExpressionValue(r3, "<get-MEDIA_FILES_URI>(...)");
        r1.a(r11, r3, r14, "_id", 2000, r7, r8, r9);
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<AppEntity> b(ContentResolver r5, List<String> r6) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "contentResolver");
        Intrinsics.checkNotNullParameter(r4, "entityIds");
        if (r4.isEmpty() == true) goto L5;
        List<AppEntity> r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"), 200), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r7.addAll((Collection) ZeusTransformUtils.preCheckCast(f12130a.c(r5, (List) ZeusTransformUtils.preCheckCast(r1.next(), List.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin"));
        goto L8
    L10:
        com.obric.memorydata.personalcontext.external.c.f12108a.a("ExternalFileDataRequester", "onQueryEntities, ids size=" + r4.size() + ", entities size=" + r7.size());
        return r7;
    L5:
        return CollectionsKt.emptyList();
    }

    public final String[] b() {
        return c;
    }

    public final String c() {
        return d;
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<AppEntity> c(ContentResolver r8) {
        Intrinsics.checkNotNullParameter(r8, "contentResolver");
        List<AppEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L3:
        Set<String> r3 = a(r8, null, r1, 2000);
        if (r3.isEmpty() == true) goto L8;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(b(r8, CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"))), Collection.class, "com.obric.memorydata.plugin"));
        if (r3.size() < 2000) goto L8;
        r1 = r1 + 2000;
    L8:
        return r0;
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<EntityIdData> d(ContentResolver r10) {
        Intrinsics.checkNotNullParameter(r10, "contentResolver");
        final List<EntityIdData> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        g r0 = g.f12138a;
        Uri r2 = e.f12136a.a();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-MEDIA_FILES_URI>(...)");
        r0.a(r10, r2, new String[]{"_id", "date_modified", "_display_name", "_data"}, "_id", 2000, d, c, new $$Lambda$b$mCSfy12TmbiCyVsec5JxgLfdbOA(r9));
        return r9;
    }
}
