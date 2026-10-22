package com.obric.memorydata.personalcontext.external.file;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.external.f;
import com.obric.memorydata.personalcontext.external.i;
import com.obric.memorydata.personalcontext.external.j;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\"\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/file/ExternalFileObserver;", "Landroid/database/ContentObserver;", "context", "Landroid/content/Context;", "entityIndexUpdater", "Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;", "<init>", "(Landroid/content/Context;Lcom/obric/memorydata/personalcontext/external/ExternalEntityIndexUpdater;)V", "getContext", "()Landroid/content/Context;", "changeInnerRunnable", "Ljava/lang/Runnable;", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "syncData", "getLastGenerationModified", "", "", "getMediaStoreNewAndUpdateData", "Lkotlin/Pair;", "", "lastModified", "getLocalLastGenerationModifiedFile", "updateLocalLastGenerationModifiedFile", "checkMediaStoreVersion", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12136a = null;
    private static final Uri e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f12137b;
    private final i c;
    private final Runnable d;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/external/file/ExternalFileObserver$Companion;", "", "<init>", "()V", "TAG", "", "MEDIA_FILES_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "getMEDIA_FILES_URI$obric_entity_data_collector_obricRelease", "()Landroid/net/Uri;", "Landroid/net/Uri;", "EXTERNAL_FILE_LAST_GENERATION_MODIFIED", "EXTERNAL_FILE_MEDIA_STORE_VERSION", "updateLocalLastGenerationModified", "", "lastModified", "", "updateLocalMediaStoreVersion", "context", "Landroid/content/Context;", "getMaxGeneration", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final Uri a() {
            return e.b();
        }

        public final void a(long r5) {
            IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("external_file_last_generation_modified", r5);
        }

        public final void a(Context r3) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "context");
            j.f12142a.a(r2, "external_file_media_store_version", "ExternalFileObserver");
        }

        public final long b(Context r10) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r11, "context");
            String r5 = b.f12130a.c();
            String[] r6 = b.f12130a.b();
            ContentResolver r2 = r11.getContentResolver();
            Uri r3 = a();
            Cursor r9 = ZeusProviderTransform.query(r2, r3, new String[]{"MAX(generation_modified)"}, r5, r6, null, "com.obric.memorydata.plugin");
            long r4 = 0;
            if (r9 == null) goto L15;
            Closeable r12 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r12, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            if (r0.moveToNext() == false) goto L8;
            r4 = r0.getLong(0);     // Catch: Throwable -> L10
        L8:
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
            CloseableKt.closeFinally(r12, null);
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            CloseableKt.closeFinally(r12, th);
            throw th;
        L15:
            return r4;
        }
    }

    static {
        f12136a = new a(null);
        e = MediaStore.Files.getContentUri("external");
    }

    public e(Context r3, i r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "entityIndexUpdater");
        super(null);
        this.f12137b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        this.c = r4;
        this.d = new $$Lambda$e$gCMcqTyRGTe0HehRns_05sgpgwQ(this);
    }

    public static final /* synthetic */ List a(e r0) {
        return r0.c();
    }

    private final Pair<List<String>, Long> a(long r11) {
        final List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        final Ref.LongRef r1 = new Ref.LongRef();
        r1.element = r11;
        b r4 = b.f12130a;
        ContentResolver r5 = this.f12137b.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r5, "getContentResolver(...)");
        r4.a(r5, r11, new String[]{"_id", "generation_modified"}, new $$Lambda$e$swwfHDgjRqZ187eywMybAe7hB64(r1, r0));
        return TuplesKt.to(r0, Long.valueOf(r1.element));
    }

    private static final Unit a(Ref.LongRef r7, List r8, List r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "paginationResult");
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r12.hasNext() == false) goto L16;
        Map r0 = (Map) ZeusTransformUtils.preCheckCast(r12.next(), Map.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.get("_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.get("generation_modified"), String.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L13;
        Long r3 = StringsKt.toLongOrNull(r1);
        if (r3 == null) goto L13;
        long r4 = r3.longValue();
    L14:
        r7.element = Math.max(r7.element, r4);
        r10.add(r2);
    L13:
        r4 = 0;
        goto L14
    L16:
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Uri b() {
        return e;
    }

    public static final /* synthetic */ i b(e r0) {
        return r0.c;
    }

    private final void b(long r5) {
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save("external_file_last_generation_modified", r5);
    }

    private final List<String> c() {
        e();
        String r4 = b.f12130a.c();
        String[] r5 = b.f12130a.b();
        ContentResolver r1 = this.f12137b.getContentResolver();
        Uri r2 = e;
        Cursor r0 = ZeusProviderTransform.query(r1, r2, new String[]{"MAX(generation_modified)"}, r4, r5, null, "com.obric.memorydata.plugin");
        long r3 = 0;
        if (r0 == null) goto L15;
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(r0, Closeable.class, "com.obric.memorydata.plugin");
        Cursor r7 = (Cursor) ZeusTransformUtils.preCheckCast(r6, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r7.moveToNext() == false) goto L8;
        r3 = r7.getLong(0);     // Catch: Throwable -> L10
    L8:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r6, null);
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    L15:
        long r9 = d();
        if (r3 <= r9) goto L18;
        Pair<List<String>, Long> r10 = a(r9);
        b(((Number) ZeusTransformUtils.preCheckCast(r10.getSecond(), Number.class, "com.obric.memorydata.plugin")).longValue());
        return (List) ZeusTransformUtils.preCheckCast(r10.getFirst(), List.class, "com.obric.memorydata.plugin");
    L18:
        return CollectionsKt.emptyList();
    }

    private static final void c(e r0) {
        r0.a();
    }

    private final long d() {
        return IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getLong("external_file_last_generation_modified", 0);
    }

    private final void e() {
        j.f12142a.a(this.f12137b, "external_file_media_store_version", "external_file_last_generation_modified", "ExternalFileObserver", "file");
    }

    public static /* synthetic */ void lambda$gCMcqTyRGTe0HehRns_05sgpgwQ(e r0) {
        c(r0);
    }

    public static /* synthetic */ Unit lambda$swwfHDgjRqZ187eywMybAe7hB64(Ref.LongRef r0, List r1, List r2) {
        return a(r0, r1, r2);
    }

    public final void a() {
        com.obric.memorydata.personalcontext.external.c.f12108a.a("ExternalFileObserver", "syncData start");
        long r7 = System.currentTimeMillis();
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new ExternalFileObserver$syncData$1(kotlinx.coroutines.i.b(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ExternalFileObserver$syncData$getDeleteIdsDeferred$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null), kotlinx.coroutines.i.b(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new ExternalFileObserver$syncData$getUpdateIdsDeferred$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null), this, r7, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
    }

    public final Context getContext() {
        return this.f12137b;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r4, Uri r5) {
        com.obric.memorydata.personalcontext.external.c.f12108a.a("ExternalFileObserver", "uri changed:uri=" + r5);
        super.onChange(r4, r5);
        f.f12127a.a().removeCallbacks(this.d);
        f.f12127a.a().postDelay(3000, this.d);
    }
}
