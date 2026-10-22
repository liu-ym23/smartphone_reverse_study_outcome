package com.obric.memorydata.personalcontext.external.d;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.personalcontext.external.g;
import com.obric.memorydata.personalcontext.external.h;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0002J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/photo/ExternalPhotoDataRequester;", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityDataRequester;", "<init>", "()V", "TAG", "", "supportDonateTypes", "", "", "MEDIA_QUERY_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "Landroid/net/Uri;", "MEDIA_SELECTION", "MEDIA_SELECTION_ARGS", "", "[Ljava/lang/String;", "onQueryEntities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "contentResolver", "Landroid/content/ContentResolver;", "entityIds", "onGetAllEntities", "getDonateEntityTypeList", "onGetAllEntityIdData", "Lcom/obric/capabilitykit/sync/EntityIdData;", "queryByIds", "ids", "convertPackageAppName", ObricMemoryConstants.KEY_PACKAGE_NAME, "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f12114a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Integer> f12115b = null;
    private static final Uri c = null;
    private static final String d = null;
    private static final String[] e = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12116a = null;

        static {
            int[] r0 = new int[AssetTypeEnum.values().length];
            r0[AssetTypeEnum.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f12116a = r0;
        }
    }

    static {
        f12114a = new b();
        f12115b = CollectionsKt.listOf(301);
        c = MediaStore.Files.getContentUri("external_primary");
        d = "(media_type = ? OR media_type = ?) AND (width IS NOT NULL AND width > 0) AND (height IS NOT NULL AND height > 0) AND (_size IS NOT NULL AND _size > 0)";
        e = new String[]{"1", "3"};
    }

    private b() {
    }

    private final String a(String r5) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
    L8:
        boolean r6 = true;
    L10:
        if (r6 == false) goto L20;
        return "";
    L20:
        PackageManager r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();     // Catch: Exception -> L17
        if (r7 != null) goto L15;
        return "";
    L15:
        ApplicationInfo r8 = r7.getApplicationInfo(r5, 0);     // Catch: Exception -> L17
        Intrinsics.checkNotNullExpressionValue(r8, "getApplicationInfo(...)");     // Catch: Exception -> L17
        return r7.getApplicationLabel(r8).toString();
    L17:
        e = move-exception;
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalPhotoDataRequester", "convertPackageAppName: ", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return "";
    L5:
        if (r4.length() == 0) goto L8;
        r6 = false;
        goto L10
    }

    private static final Unit a(List r7, List r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "rows");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L16;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r11.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get("_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("date_modified"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L13;
        Long r3 = StringsKt.toLongOrNull(r1);
        if (r3 == null) goto L13;
        long r4 = r3.longValue() * 1000;
    L14:
        r9.add(new EntityIdData(r2, 301, r4));
    L13:
        r4 = 0;
        goto L14
    L16:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v29, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r37v1 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v16 */
    private final List<AppEntity> c(ContentResolver r37, List<String> r38) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.memorydata.plugin");
        if (r0.isEmpty() == true) goto L5;
        String r1 = "_id IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, null, 56, null);
        Bundle r2 = new Bundle();
        r2.putString("android:query-arg-sql-selection", '(' + r1 + ") AND " + d);
        r2.putStringArray("android:query-arg-sql-selection-args", e);
        r2.putStringArray("android:query-arg-sort-columns", new String[]{"generation_modified"});
        ?? r3 = 0;
        r2.putInt("android:query-arg-sort-direction", 0);
        r2.putInt("android:query-arg-offset", 0);
        Cursor r4 = ZeusProviderTransform.query(r37, c, new String[]{"_id", "_data", "_display_name", "_size", "media_type", "date_added", "date_modified", "mime_type", "title", "resolution", "bucket_id", "owner_package_name", "datetaken"}, r2, null, "com.obric.memorydata.plugin");
        List<AppEntity> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L66;
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r7 = (Cursor) ZeusTransformUtils.preCheckCast(r6, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
        int r8 = r7.getColumnIndex("datetaken");     // Catch: Throwable -> L60
        ?? r9 = r7;
    L11:
        if (r9.moveToNext() == false) goto L58;
        String r10 = r9.getString(r3);     // Catch: Throwable -> L60
        String r11 = r9.getString(1);     // Catch: Throwable -> L60
        if (r11 != null) goto L16;
        String r14 = "";
    L18:
        String r12 = r9.getString(2);     // Catch: Throwable -> L60
        if (r12 != null) goto L21;
        String r13 = "";
    L22:
        long r19 = r9.getLong(3);     // Catch: Throwable -> L60
        int r15 = r9.getInt(4);     // Catch: Throwable -> L60
        long r16 = r9.getLong(5);     // Catch: Throwable -> L60
        long r17 = r9.getLong(6);     // Catch: Throwable -> L60
        String r18 = r9.getString(7);     // Catch: Throwable -> L60
        if (r18 != null) goto L25;
        r18 = "";
    L25:
        String r20 = r9.getString(8);     // Catch: Throwable -> L60
        if (r20 != null) goto L28;
        String r21 = "";
    L29:
        String r22 = r9.getString(9);     // Catch: Throwable -> L60
        if (r22 != null) goto L32;
        String r23 = "";
    L33:
        String r24 = r9.getString(10);     // Catch: Throwable -> L60
        String r25 = r9.getString(11);     // Catch: Throwable -> L60
        if (r8 == (-1)) goto L36;
        long r27 = r9.getLong(r8);     // Catch: Throwable -> L60
    L38:
        if (r27 <= 0) goto L40;
        long r31 = r27;
    L41:
        String r110 = f12114a.a(r25);     // Catch: Throwable -> L60
        if (r15 != 3) goto L44;
    L47:
        AssetTypeEnum r26 = AssetTypeEnum.VIDEO;     // Catch: Throwable -> L60
    L49:
        if (a.f12116a[r26.ordinal()] != 1) goto L51;
        Uri r28 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L60
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L60
        long r111 = Long.parseLong(r10);     // Catch: Throwable -> L60
    L52:
        Uri r29 = ContentUris.withAppendedId(r28, r111);     // Catch: Throwable -> L60
        Intrinsics.checkNotNull(r29);     // Catch: Throwable -> L60
        long r34 = r17 * 1000;     // Catch: Throwable -> L60
        ?? r39 = r9;
        int r310 = r8;
        String r30 = r14;
        FileEntity r33 = new FileEntity(r10, r31, r34, r13, r19, r29, FileTypeEnum.FILE, r18);     // Catch: Throwable -> L60
        if (r24 != null) goto L56;
        List r32 = CollectionsKt.emptyList();     // Catch: Throwable -> L60
    L57:
        PhotoEntity r112 = new PhotoEntity(r10, r31, r34, r21, r33, r26, r32, r23, r19, false);     // Catch: Throwable -> L60
        r112.setSourcePackageName(r25);     // Catch: Throwable -> L60
        r112.setSourceAppName(r110);     // Catch: Throwable -> L60
        r112.setExtraData(new JSONObject().put(Params.FILE_PATH, r30).toString());     // Catch: Throwable -> L60
        r5.add(r112);     // Catch: Throwable -> L60
        r9 = r39;
        r8 = r310;
        r3 = 0;
        goto L11
    L56:
        r32 = CollectionsKt.listOf(new AlbumEntity(r24, 0, 0, "", null));     // Catch: Throwable -> L60
        goto L57
    L51:
        r28 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;     // Catch: Throwable -> L60
        Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L60
        r111 = Long.parseLong(r10);     // Catch: Throwable -> L60
        goto L52
    L44:
        if (StringsKt.startsWith$default(r18, "video", r3, 2, null) == true) goto L47;
        r26 = AssetTypeEnum.PHOTO;     // Catch: Throwable -> L60
        goto L49
    L40:
        r31 = r16 * 1000;     // Catch: Throwable -> L60
        goto L41
    L36:
        r27 = 0;
        goto L38
    L32:
        r23 = r22;
        goto L33
    L28:
        r21 = r20;
        goto L29
    L21:
        r13 = r12;
        goto L22
    L16:
        r14 = r11;
        goto L18
    L58:
        Unit r35 = Unit.INSTANCE;     // Catch: Throwable -> L60
        CloseableKt.closeFinally(r6, null);
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    L66:
        return r5;
    L5:
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: renamed from: lambda$OXFp-_9Ywk4TvONrv13eto4W_gk, reason: not valid java name */
    public static /* synthetic */ Unit m1066lambda$OXFp_9Ywk4TvONrv13eto4W_gk(List r0, List r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<Integer> a() {
        return f12115b;
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
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast(f12114a.c(r4, r1), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r6;
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<AppEntity> c(ContentResolver r8) {
        Intrinsics.checkNotNullParameter(r8, "contentResolver");
        List<AppEntity> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L3:
        Set<String> r3 = e.f12119a.a(r8, null, r1, 5000);
        if (r3.isEmpty() == true) goto L8;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(b(r8, CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"))), Collection.class, "com.obric.memorydata.plugin"));
        if (r3.size() < 5000) goto L8;
        r1 = r1 + 5000;
    L8:
        return r0;
    }

    @Override // com.obric.memorydata.personalcontext.external.h
    public List<EntityIdData> d(ContentResolver r10) {
        Intrinsics.checkNotNullParameter(r10, "contentResolver");
        final List<EntityIdData> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        g r0 = g.f12138a;
        Uri r2 = c;
        Intrinsics.checkNotNullExpressionValue(r2, "MEDIA_QUERY_URI");
        r0.a(r10, r2, new String[]{"_id", "date_modified"}, "_id", 5000, d, e, new $$Lambda$b$OXFp_9Ywk4TvONrv13eto4W_gk(r9));
        return r9;
    }
}
