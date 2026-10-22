package com.obric.memorydata.personalcontext.external.d;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.index.s;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.external.f;
import com.obric.memorydata.personalcontext.external.g;
import com.obric.memorydata.personalcontext.external.i;
import com.obric.memorydata.personalcontext.external.j;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\"\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00170\u001a0\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/memorydata/personalcontext/external/photo/ExternalPhotoObserver;", "Landroid/database/ContentObserver;", "mContext", "Landroid/content/Context;", "entityIndexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;)V", "getMContext", "()Landroid/content/Context;", "syncRunnable", "Ljava/lang/Runnable;", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "runSyncJob", "getMediaStoreLastGenerationModifiedImageAndVideo", "", "", "getMediaStoreNewAndUpdatedDataEquals", "", "lastModified", "getMediaStoreNewAndUpdatedData", "Lkotlin/Pair;", "getLocalLastGenerationModifiedImageAndVideo", "updateLocalLastGenerationModifiedImageAndVideo", "checkMediaStoreVersion", "getWasPartialAccess", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12119a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f12120b;
    private final i c;
    private final Runnable d;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/photo/ExternalPhotoObserver$Companion;", "", "<init>", "()V", "TAG", "", "EXTERNAL_PHOTO_LAST_GENERATION_MODIFIED", "EXTERNAL_PHOTO_MEDIA_STORE_VERSION", "EXTERNAL_PHOTO_WAS_PARTIAL_ACCESS", "IS_PRIVATE", "SYNC_PAGE_SIZE", "", "getMediaData", "", "resolver", "Landroid/content/ContentResolver;", "idList", TypedValues.CycleType.S_WAVE_OFFSET, "limit", "updateLocalLastGenerationModified", "", "lastModified", "", "updateLocalMediaStoreVersion", "context", "Landroid/content/Context;", "updateWasPartialAccess", "isPartial", "", "isPartialAccess", "getMaxGeneration", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ Set a(a r1, ContentResolver r2, Set r3, int r4, int r5, int r6, Object r7) {
            Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            if ((r6 & 4) == 0) goto L6;
            r4 = 0;
        L6:
            if ((r6 & 8) == 0) goto L9;
            r5 = 5000;
        L9:
            return r1.a(r2, r8, r4, r5);
        }

        public final Set<String> a(ContentResolver r11, Set<String> r12, int r13, int r14) {
            Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r11, "resolver");
            if (r10 != null) goto L5;
            String r15 = "1 == 1";
        L10:
            Bundle r4 = new Bundle();
            r4.putString("android:query-arg-sql-selection", '(' + r15 + ") AND (media_type = ? OR media_type = ?) AND (width IS NOT NULL AND width > 0) AND (height IS NOT NULL AND height > 0) AND (_size IS NOT NULL AND _size > 0)");
            r4.putStringArray("android:query-arg-sql-selection-args", new String[]{"1", "3"});
            r4.putStringArray("android:query-arg-sort-columns", new String[]{"generation_modified"});
            r4.putInt("android:query-arg-sort-direction", 0);
            r4.putInt("android:query-arg-limit", r14);
            r4.putInt("android:query-arg-offset", r13);
            Cursor r16 = ZeusProviderTransform.query(r11, MediaStore.Files.getContentUri("external_primary"), new String[]{"_id"}, r4, null, "com.obric.memorydata.plugin");
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

        public final void a(long r5) {
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("external_photo_last_generation_modified", r5);
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            j.f12142a.a(r2, "external_photo_media_store_version", "ExternalPhotoObserver");
        }

        public final void a(boolean r5) {
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("external_photo_was_partial_access", r5);
        }

        public final boolean b(Context r5) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "context");
            if (Build.VERSION.SDK_INT >= 34) goto L5;
            return false;
        L5:
            if (ContextCompat.checkSelfPermission(r4, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") != 0) goto L7;
            boolean r6 = true;
        L9:
            if (ContextCompat.checkSelfPermission(r4, "android.permission.READ_MEDIA_IMAGES") != 0) goto L11;
            boolean r2 = true;
        L13:
            if (ContextCompat.checkSelfPermission(r4, "android.permission.READ_MEDIA_VIDEO") != 0) goto L15;
            boolean r7 = true;
        L16:
            if (r6 == false) goto L22;
            if (r2 == false) goto L20;
            if (r7 == false) goto L20;
            return false;
        L20:
            return true;
        L22:
            return false;
        L15:
            r7 = false;
            goto L16
        L11:
            r2 = false;
            goto L13
        L7:
            r6 = false;
            goto L9
        }

        public final long c(Context r8) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, "context");
            Bundle r4 = new Bundle();
            r4.putString("android:query-arg-sql-selection", "(media_type = ? OR media_type = ?) AND (width IS NOT NULL AND width > 0) AND (height IS NOT NULL AND height > 0) AND (_size IS NOT NULL AND _size > 0)");
            r4.putStringArray("android:query-arg-sql-selection-args", new String[]{"1", "3"});
            ContentResolver r1 = r7.getContentResolver();
            Cursor r9 = ZeusProviderTransform.query(r1, MediaStore.Files.getContentUri("external_primary"), new String[]{"MAX(generation_modified)"}, r4, null, "com.obric.memorydata.plugin");
            long r2 = 0;
            if (r9 == null) goto L15;
            Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r10, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r0.moveToFirst() == false) goto L8;
            r2 = r0.getLong(0);     // Catch: Throwable -> L10
        L8:
            Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
            CloseableKt.closeFinally(r10, null);
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            CloseableKt.closeFinally(r10, th);
            throw th;
        L15:
            return r2;
        }
    }

    static {
        f12119a = new a(null);
    }

    public e(Context r3, i r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "mContext");
        Intrinsics.checkNotNullParameter(r4, "entityIndexUpdater");
        super(null);
        this.f12120b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r4;
        this.d = new $$Lambda$e$4q2S9Ms5Y5TNLYM0OisT2DM5Rg(this);
    }

    private final List<Long> a(long r8) {
        Bundle r4 = new Bundle();
        r4.putString("android:query-arg-sql-selection", "(generation_modified = ?) AND (media_type = ? OR media_type = ?) AND (width IS NOT NULL AND width > 0) AND (height IS NOT NULL AND height > 0) AND (_size IS NOT NULL AND _size > 0)");
        r4.putStringArray("android:query-arg-sql-selection-args", new String[]{String.valueOf(r8), "1", "3"});
        Cursor r7 = ZeusProviderTransform.query(this.f12120b.getContentResolver(), MediaStore.Files.getContentUri("external_primary"), new String[]{"_id"}, r4, null, "com.obric.memorydata.plugin");
        List<Long> r9 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L16;
        Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r7, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r10, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
    L7:
        if (r1.moveToNext() == false) goto L9;
        r9.add(Long.valueOf(r1.getLong(0)));     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r10, null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L16:
        return r9;
    }

    private static final void a(e r0) {
        r0.a();
    }

    private final List<String> b() {
        d();
        Bundle r4 = new Bundle();
        r4.putString("android:query-arg-sql-selection", "(media_type = ? OR media_type = ?) AND (width IS NOT NULL AND width > 0) AND (height IS NOT NULL AND height > 0) AND (_size IS NOT NULL AND _size > 0)");
        r4.putStringArray("android:query-arg-sql-selection-args", new String[]{"1", "3"});
        ContentResolver r1 = this.f12120b.getContentResolver();
        Cursor r0 = ZeusProviderTransform.query(r1, MediaStore.Files.getContentUri("external_primary"), new String[]{"MAX(generation_modified)"}, r4, null, "com.obric.memorydata.plugin");
        long r2 = 0;
        if (r0 == null) goto L15;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r5 = (Cursor) ZeusTransformUtils.preCheckCast(r3, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r5.moveToFirst() == false) goto L8;
        r2 = r5.getLong(0);     // Catch: Throwable -> L10
    L8:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r3, null);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L15:
        long r7 = c();
        if (r2 <= r7) goto L18;
        Set r8 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    L20:
        List<Pair<String, Long>> r9 = b(r7);
        if (r9.isEmpty() == true) goto L23;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L30:
        if (r12.hasNext() == false) goto L32;
        r11.add((String) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r12.next(), Pair.class, "com.obric.memorydata.plugin")).getFirst(), String.class, "com.obric.memorydata.plugin"));
        goto L30
    L32:
        r8.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r13.hasNext() == false) goto L46;
        long r14 = ((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r13.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue();
    L36:
        if (r13.hasNext() == false) goto L40;
        long r15 = ((Number) ZeusTransformUtils.preCheckCast(((Pair) ZeusTransformUtils.preCheckCast(r13.next(), Pair.class, "com.obric.memorydata.plugin")).getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue();
        if (r14 >= r15) goto L36;
        r14 = r15;
        goto L36
    L40:
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(a(r14), Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L42:
        if (r18.hasNext() == false) goto L44;
        r17.add(String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r18.next(), Number.class, "com.obric.memorydata.plugin")).longValue()));
        goto L42
    L44:
        r8.addAll((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"));
        c(r14);
        r7 = r14;
        goto L20
    L46:
        throw new NoSuchElementException();
    L23:
        if (r8.isEmpty() == false) goto L27;
        return CollectionsKt.emptyList();
    L27:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin"));
    L18:
        return CollectionsKt.emptyList();
    }

    private final List<Pair<String, Long>> b(long r9) {
        Bundle r4 = new Bundle();
        r4.putString("android:query-arg-sql-selection", "(generation_modified > ?) AND (media_type = ? OR media_type = ?) AND (width IS NOT NULL AND width > 0) AND (height IS NOT NULL AND height > 0) AND (_size IS NOT NULL AND _size > 0)");
        r4.putStringArray("android:query-arg-sql-selection-args", new String[]{String.valueOf(r9), "1", "3"});
        r4.putStringArray("android:query-arg-sort-columns", new String[]{"generation_modified"});
        r4.putInt("android:query-arg-sort-direction", 0);
        r4.putInt("android:query-arg-limit", 5000);
        r4.putInt("android:query-arg-offset", 0);
        Cursor r8 = ZeusProviderTransform.query(this.f12120b.getContentResolver(), MediaStore.Files.getContentUri("external_primary"), new String[]{"_id", "generation_modified"}, r4, null, "com.obric.memorydata.plugin");
        List<Pair<String, Long>> r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L16;
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r11, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
    L7:
        if (r1.moveToNext() == false) goto L9;
        r10.add(TuplesKt.to(r1.getString(0), Long.valueOf(r1.getLong(1))));     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r11, null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L16:
        return r10;
    }

    private final long c() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("external_photo_last_generation_modified", 0);
    }

    private final void c(long r5) {
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("external_photo_last_generation_modified", r5);
    }

    private final void d() {
        j.f12142a.a(this.f12120b, "external_photo_media_store_version", "external_photo_last_generation_modified", "ExternalPhotoObserver", "photo");
    }

    private final boolean e() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getBoolean("external_photo_was_partial_access", false);
    }

    /* JADX INFO: renamed from: lambda$-4q2S9Ms5Y5TNLYM0OisT2DM5Rg, reason: not valid java name */
    public static /* synthetic */ void m1068lambda$4q2S9Ms5Y5TNLYM0OisT2DM5Rg(e r0) {
        a(r0);
    }

    public final void a() {
        com.obric.memorydata.personalcontext.external.c.f12108a.a("ExternalPhotoObserver", "runSyncJob");
        long r3 = System.currentTimeMillis();
        int r5 = 301;
        String r1 = g.f12138a.a(301);
        Set r6 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Set r7 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        a r9 = f12119a;
        boolean r10 = r9.b(this.f12120b);
        boolean r11 = e();
        if (r10 == false) goto L6;
        com.obric.memorydata.personalcontext.external.c r12 = com.obric.memorydata.personalcontext.external.c.f12108a;
        String r14 = "runSyncJob: Partial access detected, forcing full sync by resetting generation_modified.";
    L5:
        r12.b("ExternalPhotoObserver", r14);
        c(0);
    L8:
        r9.a(r10);
        Throwable r13 = null;
        Long r15 = null;
    L9:
        Set r16 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r17 = s.a().getRawDaoByEntityType(r5);
        if (r17 == null) goto L12;
        Object r8 = r17.queryByPackageName(new String[]{"entityId", OaidModel.KEY_ID}, r1, 2000, r15);
    L13:
        if (r8 == null) goto L27;
        Closeable r18 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r19 = (Cursor) ZeusTransformUtils.preCheckCast(r18, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        int r110 = 0;
    L17:
        if (r19.moveToNext() == false) goto L19;
        String r111 = r19.getString(r19.getColumnIndexOrThrow("entityId"));     // Catch: Throwable -> L21
        Long r112 = Long.valueOf(r19.getLong(r19.getColumnIndexOrThrow(OaidModel.KEY_ID)));     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r111);     // Catch: Throwable -> L21
        r16.add(r111);     // Catch: Throwable -> L21
        r110 = r110 + 1;     // Catch: Throwable -> L21
        r15 = r112;
        goto L17
    L19:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r18, r13);
        int r20 = r110;
    L29:
        if (r16.isEmpty() == true) goto L38;
        a r114 = f12119a;
        ContentResolver r115 = this.f12120b.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r115, "getContentResolver(...)");
        Set r116 = a.a(r114, r115, r16, 0, 0, 12, null);
        Iterator r117 = r16.iterator();
    L33:
        if (r117.hasNext() == false) goto L37;
        String r118 = (String) ZeusTransformUtils.preCheckCast(r117.next(), String.class, "com.obric.memorydata.plugin");
        if (r116.contains(r118) == true) goto L33;
        r7.add(r118);
        goto L33
    L37:
        if (r20 < 2000) goto L38;
        r5 = 301;
        r13 = null;
    L38:
        r6.addAll((Collection) ZeusTransformUtils.preCheckCast(b(), Collection.class, "com.obric.memorydata.plugin"));
        this.c.a(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")), 301);
        this.c.b(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), 301);
        com.obric.memorydata.personalcontext.external.c.f12108a.b("ExternalPhotoObserver", "runPhotoSyncJob cost time " + (System.currentTimeMillis() - r3));
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);
        throw th;
    L27:
        r20 = 0;
        goto L29
    L12:
        r8 = r13;
        goto L13
    L6:
        if (r11 == false) goto L8;
        r12 = com.obric.memorydata.personalcontext.external.c.f12108a;
        r14 = "runSyncJob: Transition from partial to full access detected, forcing full sync.";
        goto L5
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r3, Uri r4) {
        super.onChange(r3, r4);
        f.f12127a.a().removeCallbacks(this.d);
        f.f12127a.a().postDelay(3000, this.d);
    }
}
