package com.larus.avlink.gallery.storage;

import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;
import w88.o;
import w88.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class GalleryStoragePolicyManager {
    public static final GalleryStoragePolicyManager a = null;
    public static final MutexImpl b = null;
    public static final Lazy c = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaLifecycleState.values().length];
            r0[MediaLifecycleState.FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public GalleryStoragePolicyManager() {
    }

    static {
        a = new GalleryStoragePolicyManager();
        b = kotlinx.coroutines.sync.b.a();
        c = LazyKt.lazy(new e());
    }

    public static boolean m() {
        String r0 = AccountService.a.getUserId();
        if (r0.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r0 = "default";
    L9:
        return ((Keva) c.getValue()).getBoolean("dora_gallery_storage_database_migrated_".concat(r0), false);
    L5:
        r1 = false;
        goto L6
    }

    public static List f(File r7) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L22
        if (r7.exists() == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r7.isFile() == true) goto L9;
        File[] r1 = r7.listFiles();     // Catch: Throwable -> L22
        if (r1 == null) goto L19;
        Collection r2 = new ArrayList();     // Catch: Throwable -> L22
        int r3 = r1.length;     // Catch: Throwable -> L22
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L20;
        File r5 = r1[r4];     // Catch: Throwable -> L22
        if (r5.isDirectory() == false) goto L17;
        List r6 = CollectionsKt.listOf(r5);     // Catch: Throwable -> L22
        GalleryStoragePolicyManager r8 = a;     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L22
        r8.getClass();     // Catch: Throwable -> L22
        List r9 = CollectionsKt.plus(r6, f(r5));     // Catch: Throwable -> L22
    L18:
        CollectionsKt.addAll(r2, r9);     // Catch: Throwable -> L22
        r4 = r4 + 1;     // Catch: Throwable -> L22
        goto L13
    L17:
        r9 = CollectionsKt.listOf(r5);     // Catch: Throwable -> L22
    L20:
        Object r10 = Result.constructor-impl(r2);     // Catch: Throwable -> L22
    L24:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L29;
        FLogger.a.e("GalleryStoragePolicyManager", "childrenRecursively failed, path=" + r7.getAbsolutePath(), r11);
        r10 = CollectionsKt.emptyList();
    L29:
        return (List) r10;
    L19:
        r2 = CollectionsKt.emptyList();     // Catch: Throwable -> L22
        goto L20
    L9:
        return CollectionsKt.listOf(r7);
    L22:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    }

    public static void i(File r10) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L31
        if (r10.exists() == true) goto L6;
        return;
    L6:
        if (r10.isFile() == true) goto L43;
        File[] r2 = r10.listFiles();     // Catch: Throwable -> L31
        if (r2 == null) goto L27;
        int r3 = r2.length;     // Catch: Throwable -> L31
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L26;
        File r5 = r2[r4];     // Catch: Throwable -> L31
        if (r5.isDirectory() == false) goto L25;
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L31
        i(r5);     // Catch: Throwable -> L31
        File[] r6 = r5.listFiles();     // Catch: Throwable -> L31
        if (r6 == null) goto L22;
        boolean r7 = true;
        if (r6.length != 0) goto L19;
        boolean r8 = true;
    L20:
        if (r8 != true) goto L22;
    L23:
        if (r7 == false) goto L25;
        boolean r9 = r5.delete();     // Catch: Throwable -> L31
        FLogger.a.i("GalleryStoragePolicyManager", "delete empty dir result=" + r9 + ", path=" + r5.getAbsolutePath());     // Catch: Throwable -> L31
        goto L25
    L19:
        r8 = false;
    L22:
        r7 = false;
    L25:
        r4 = r4 + 1;     // Catch: Throwable -> L31
        goto L11
    L26:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L28:
        Object r12 = Result.constructor-impl(r11);     // Catch: Throwable -> L31
    L33:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L44;
        FLogger.a.e("GalleryStoragePolicyManager", "cleanupEmptyDirs failed, path=" + r10.getAbsolutePath(), r13);
        return;
    L44:
        return;
    L27:
        r11 = null;
        goto L28
    L43:
        return;
    L31:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }

    public static Object j(Continuation r3) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GalleryStoragePolicyManager$cleanupFallback$2(null), r3);
    }

    public static boolean n(File r7) {
        String r8 = r7.getAbsolutePath();
        com.larus.avlink.gallery.e.a.getClass();
        List r0 = CollectionsKt.listOf(new File[]{com.larus.avlink.gallery.e.c(), com.larus.avlink.gallery.e.g(), com.larus.avlink.gallery.e.f(), com.larus.avlink.gallery.e.e(), com.larus.avlink.gallery.e.d(), new PolarisFileWrapper(com.larus.avlink.gallery.e.b(), "failed")});
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L26;
        String r2 = ((File) r1.next()).getAbsolutePath();
        if (Intrinsics.areEqual(r8, r2) == true) goto L16;
        Intrinsics.checkNotNull(r8);
        if (StringsKt.startsWith$default(r8, r2 + File.separator, false, 2, null) == true) goto L16;
        boolean r3 = false;
    L17:
        if (r3 == false) goto L9;
        return true;
    L16:
        r3 = true;
        goto L17
    L26:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public static Long r(File r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(Long.valueOf(r4.lastModified()));     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L11;
        FLogger.a.e("GalleryStoragePolicyManager", "safeLastModified failed, path=" + r4.getAbsolutePath(), r2);
        r1 = null;
    L11:
        return (Long) r1;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static long s(File r6) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        if (r6.isFile() == false) goto L6;
        long r3 = r6.length();     // Catch: Throwable -> L9
    L7:
        Object r4 = Result.constructor-impl(Long.valueOf(r3));     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L16;
        FLogger.a.e("GalleryStoragePolicyManager", "safeLength failed, path=" + r6.getAbsolutePath(), r5);
        r4 = 0L;
    L16:
        return ((Number) r4).longValue();
    L6:
        r3 = 0;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static n t(List r8) {
        LinkedHashSet r0 = new LinkedHashSet();
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator r9 = CollectionsKt.distinct(r8).iterator();
    L4:
        if (r9.hasNext() == false) goto L19;
        String r2 = (String) r9.next();
        if (StringsKt.isBlank(r2) == true) goto L4;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r2);
        r0.add(r3.getAbsolutePath());
        if (r3.isDirectory() == true) goto L12;
        if (StringsKt.endsWith$default(r2, File.separator, false, 2, null) == false) goto L4;
    L12:
        GalleryStoragePolicyManager r4 = a;
        String r5 = r3.getAbsolutePath();
        char r6 = File.separatorChar;
        r4.getClass();
        int r7 = r5.length();
    L13:
        if (r7 <= 0) goto L17;
        int r10 = r7 - 1;
        if (r5.charAt(r10) != r6) goto L17;
        r7 = r10;
    L17:
        r1.add(r5.substring(0, r7));
        goto L4
    L19:
        return new n(r0, r1);
    }

    public static long u(File r7) {
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        if (r7.exists() == true) goto L7;
        return 0;
    L7:
        if (r7.isFile() == false) goto L10;
        a.getClass();     // Catch: Throwable -> L16
        return s(r7);
    L10:
        a.getClass();     // Catch: Throwable -> L16
        Iterator r3 = f(r7).iterator();     // Catch: Throwable -> L16
        long r4 = 0;
    L12:
        if (r3.hasNext() == false) goto L14;
        File r5 = (File) r3.next();     // Catch: Throwable -> L16
        a.getClass();     // Catch: Throwable -> L16
        r4 = r4 + s(r5);     // Catch: Throwable -> L16
        goto L12
    L14:
        Object r6 = Result.constructor-impl(Long.valueOf(r4));     // Catch: Throwable -> L16
    L18:
        Throwable r8 = Result.exceptionOrNull-impl(r6);
        if (r8 == null) goto L23;
        FLogger.a.e("GalleryStoragePolicyManager", "totalSize failed, path=" + r7.getAbsolutePath(), r8);
        r6 = 0L;
    L23:
        return ((Number) r6).longValue();
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    public final Object l(Continuation<? super Set<String>> r7) {
        if ((r7 instanceof GalleryStoragePolicyManager$getInProgressSourcePaths$1) == false) goto L7;
        GalleryStoragePolicyManager$getInProgressSourcePaths$1 r0 = (GalleryStoragePolicyManager$getInProgressSourcePaths$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        GalleryStoragePolicyManager r4 = (GalleryStoragePolicyManager) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L55
    L21:
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L55
        Iterator r9 = ((Iterable) r8).iterator();     // Catch: Throwable -> L55
    L23:
        if (r9.hasNext() == false) goto L27;
        Object r6 = r9.next();     // Catch: Throwable -> L55
        if (((MediaMetadata) r6).isInProgress() == false) goto L23;
        r5.add(r6);     // Catch: Throwable -> L55
        goto L23
    L27:
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L55
        Iterator r11 = r5.iterator();     // Catch: Throwable -> L55
    L29:
        if (r11.hasNext() == false) goto L33;
        String r12 = ((MediaMetadata) r11.next()).getDownloadFilePath();     // Catch: Throwable -> L55
        if (r12 == null) goto L29;
        r10.add(r12);     // Catch: Throwable -> L55
        goto L29
    L33:
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L55
        Iterator r14 = r10.iterator();     // Catch: Throwable -> L55
    L35:
        if (r14.hasNext() == false) goto L39;
        Object r15 = r14.next();     // Catch: Throwable -> L55
        if ((!StringsKt.isBlank((String) r15)) == false) goto L35;
        r13.add(r15);     // Catch: Throwable -> L55
        goto L35
    L39:
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));     // Catch: Throwable -> L55
        Iterator r17 = r13.iterator();     // Catch: Throwable -> L55
    L41:
        if (r17.hasNext() == false) goto L43;
        r16.add(new PolarisFileWrapper((String) r17.next()));     // Catch: Throwable -> L55
        goto L41
    L43:
        ArrayList r18 = new ArrayList();     // Catch: Throwable -> L55
        Iterator r19 = r16.iterator();     // Catch: Throwable -> L55
    L45:
        if (r19.hasNext() == false) goto L49;
        Object r20 = r19.next();     // Catch: Throwable -> L55
        r4.getClass();     // Catch: Throwable -> L55
        if (p((File) r20, null) == false) goto L45;
        r18.add(r20);     // Catch: Throwable -> L55
        goto L45
    L49:
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));     // Catch: Throwable -> L55
        Iterator r22 = r18.iterator();     // Catch: Throwable -> L55
    L51:
        if (r22.hasNext() == false) goto L53;
        r21.add(((File) r22.next()).getAbsolutePath());     // Catch: Throwable -> L55
        goto L51
    L53:
        Object r23 = Result.constructor-impl(CollectionsKt.toSet(r21));     // Catch: Throwable -> L55
    L57:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L86;
        FLogger.a.e("GalleryStoragePolicyManager", "getInProgressSourcePaths: load metadata failed", r24);
        return SetsKt.emptySet();
    L86:
        return r23;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L55
        AlbumDataBaseHelper r26 = AlbumDataBaseHelper.a;     // Catch: Throwable -> L55
        r0.L$0 = this;     // Catch: Throwable -> L55
        r0.label = 1;     // Catch: Throwable -> L55
        r8 = r26.m(r0);     // Catch: Throwable -> L55
        if (r8 != r2) goto L20;
        return r2;
    L20:
        r4 = this;
    L55:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new GalleryStoragePolicyManager$getInProgressSourcePaths$1(this, r7);
        goto L8
    }

    public static final Object a(GalleryStoragePolicyManager r18, Continuation r19) {
        GalleryStoragePolicyManager r0 = r18;
        r18.getClass();
        if ((r19 instanceof GalleryStoragePolicyManager$cleanupOrphanTempFiles$1) == false) goto L7;
        GalleryStoragePolicyManager$cleanupOrphanTempFiles$1 r2 = (GalleryStoragePolicyManager$cleanupOrphanTempFiles$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 != 1) goto L15;
        r0 = (GalleryStoragePolicyManager) r2.L$0;
        ResultKt.throwOnFailure(r1);     // Catch: Throwable -> L26
    L20:
        ArrayList r6 = new ArrayList();     // Catch: Throwable -> L26
        Iterator r7 = ((Iterable) r1).iterator();     // Catch: Throwable -> L26
    L22:
        if (r7.hasNext() == false) goto L24;
        CollectionsKt.addAll(r6, ((MediaMetadata) r7.next()).getAllFilePaths());     // Catch: Throwable -> L26
        goto L22
    L24:
        r0.getClass();     // Catch: Throwable -> L26
        Object r8 = Result.constructor-impl(t(r6));     // Catch: Throwable -> L26
    L28:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 != null) goto L64;
        n r10 = (n) r8;
        long r11 = System.currentTimeMillis();
        com.larus.avlink.gallery.e.a.getClass();
        List r12 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(com.larus.avlink.gallery.e.c(), new com.larus.avlink.gallery.storage.a()), TuplesKt.to(com.larus.avlink.gallery.e.g(), new b()), TuplesKt.to(com.larus.avlink.gallery.e.f(), new c()), TuplesKt.to(com.larus.avlink.gallery.e.e(), new d())});
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L32:
        if (r14.hasNext() == false) goto L63;
        Pair r15 = (Pair) r14.next();
        File r16 = (File) r15.component1();
        Function1 r17 = (Function1) r15.component2();
        GalleryStoragePolicyManager r110 = a;
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L56
        r110.getClass();     // Catch: Throwable -> L56
        List r112 = f(r16);     // Catch: Throwable -> L56
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L56
        Iterator r114 = r112.iterator();     // Catch: Throwable -> L56
    L36:
        if (r114.hasNext() == false) goto L54;
        Object r115 = r114.next();     // Catch: Throwable -> L56
        File r116 = (File) r115;     // Catch: Throwable -> L56
        if (((Boolean) r17.invoke(r116)).booleanValue() == true) goto L40;
    L51:
        boolean r117 = false;
    L52:
        if (r117 == false) goto L36;
        r113.add(r115);     // Catch: Throwable -> L56
        goto L36
    L40:
        if (r116.isFile() == false) goto L51;
        if (o(r116, r10) == true) goto L51;
        Long r118 = r(r116);     // Catch: Throwable -> L56
        if (r118 != null) goto L46;
    L48:
        boolean r119 = false;
    L49:
        if (r119 == false) goto L51;
        r117 = true;
        goto L52
    L46:
        if ((r11 - r118.longValue()) <= 86400000) goto L48;
        r119 = true;
        goto L49
    L54:
        Object r20 = Result.constructor-impl(r113);     // Catch: Throwable -> L56
    L58:
        Throwable r120 = Result.exceptionOrNull-impl(r20);
        if (r120 == null) goto L62;
        FLogger.a.e("GalleryStoragePolicyManager", "cleanupOrphanTempFiles: scan dir failed, path=" + r16.getAbsolutePath(), r120);
        r20 = CollectionsKt.emptyList();
    L62:
        CollectionsKt.addAll(r13, (Iterable) r20);
    L56:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L63:
        o r21 = k(CollectionsKt.take(CollectionsKt.sortedWith(r13, new g()), DoraCallStateCode.DORA_OB_USER_END), "orphan_temp", false, null);
        com.larus.avlink.gallery.e.a.getClass();
        i(com.larus.avlink.gallery.e.f());
        i(com.larus.avlink.gallery.e.g());
        return r21;
    L64:
        FLogger.a.e("GalleryStoragePolicyManager", "cleanupOrphanTempFiles: load metadata failed", r9);
        return new o(0, 0, "orphan_temp_skip_metadata_failed");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r1);
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L26
        AlbumDataBaseHelper r23 = AlbumDataBaseHelper.a;     // Catch: Throwable -> L26
        r2.L$0 = r0;     // Catch: Throwable -> L26
        r2.label = 1;     // Catch: Throwable -> L26
        r1 = r23.m(r2);     // Catch: Throwable -> L26
        if (r1 != r4) goto L20;
        return r4;
    L26:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r2 = new GalleryStoragePolicyManager$cleanupOrphanTempFiles$1(r0, r19);
        goto L8
    }

    public static final Object b(GalleryStoragePolicyManager r13, Continuation r14) {
        r13.getClass();
        if ((r14 instanceof GalleryStoragePolicyManager$cleanupSourceFilesLocked$1) == false) goto L7;
        GalleryStoragePolicyManager$cleanupSourceFilesLocked$1 r0 = (GalleryStoragePolicyManager$cleanupSourceFilesLocked$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r4 = r0.J$1;
        long r5 = r0.J$0;
        p r16 = (p) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L18:
        Set r17 = (Set) r15;
        com.larus.avlink.gallery.e.a.getClass();
        List r6 = f(com.larus.avlink.gallery.e.c());
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L20:
        if (r8.hasNext() == false) goto L24;
        Object r9 = r8.next();
        a.getClass();
        if (p((File) r9, null) == false) goto L20;
        r7.add(r9);
        goto L20
    L24:
        ArrayList r10 = new ArrayList();
        Iterator r11 = r7.iterator();
    L26:
        if (r11.hasNext() == false) goto L30;
        Object r12 = r11.next();
        if (r17.contains(((File) r12).getAbsolutePath()) == true) goto L26;
        r10.add(r12);
        goto L26
    L30:
        List r18 = CollectionsKt.sortedWith(r10, new h());
        ArrayList r19 = new ArrayList();
        Iterator r20 = r18.iterator();
    L32:
        if (r20.hasNext() == false) goto L41;
        Object r21 = r20.next();
        a.getClass();
        Long r110 = r((File) r21);
        if (r110 != null) goto L36;
    L38:
        boolean r111 = false;
    L39:
        if (r111 == false) goto L32;
        r19.add(r21);
        goto L32
    L36:
        if ((r5 - r110.longValue()) <= r4) goto L38;
        r111 = true;
        goto L39
    L41:
        Set r22 = CollectionsKt.toSet(r19);
        ArrayList r23 = new ArrayList();
        Iterator r24 = r18.iterator();
    L43:
        if (r24.hasNext() == false) goto L47;
        Object r25 = r24.next();
        if (r22.contains((File) r25) == true) goto L43;
        r23.add(r25);
        goto L43
    L47:
        ArrayList r26 = new ArrayList();
        Ref.LongRef r27 = new Ref.LongRef();
        Iterator r28 = r23.iterator();
        long r29 = 0;
    L49:
        if (r28.hasNext() == false) goto L51;
        File r30 = (File) r28.next();
        a.getClass();
        r29 = r29 + s(r30);
        goto L49
    L51:
        r27.element = r29;
        Iterator r31 = r23.iterator();
    L53:
        if (r31.hasNext() == false) goto L57;
        File r32 = (File) r31.next();
        if (r27.element <= r16.b) goto L53;
        r26.add(r32);
        long r33 = r27.element;
        a.getClass();
        r27.element = r33 - s(r32);
        goto L53
    L57:
        Set r34 = SetsKt.plus(r22, r26);
        HashSet r35 = new HashSet();
        ArrayList r36 = new ArrayList();
        Iterator r37 = r34.iterator();
    L59:
        if (r37.hasNext() == false) goto L64;
        Object r38 = r37.next();
        if (r35.add(((File) r38).getAbsolutePath()) == false) goto L59;
        r36.add(r38);
        goto L59
    L64:
        return k(r36, "source_policy(expired=" + r22.size() + ", over_limit=" + r26.size() + ", retention_days=" + r16.a + ", max_bytes=" + r16.b + ", protected=" + r17.size() + ')', true, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        Lazy r112 = c;
        int r39 = ((Keva) r112.getValue()).getInt("dora_gallery_storage_pack_retention_days", 3);
        long r40 = ((Keva) r112.getValue()).getLong("dora_gallery_storage_pack_max_bytes", 3221225472L);
        int r113 = RangesKt.coerceIn(r39, 1, 30);
        p r41 = new p(r113, RangesKt.coerceIn(r40, 104857600, 21474836480L));
        r5 = System.currentTimeMillis();
        long r42 = (((((long) r113) * 24) * 60) * 60) * 1000;
        r0.L$0 = r41;
        r0.J$0 = r5;
        r0.J$1 = r42;
        r0.label = 1;
        r15 = r13.l(r0);
        if (r15 == r2) goto L96;
        r16 = r41;
        r4 = r42;
        goto L18
    L96:
        return r2;
    L7:
        r0 = new GalleryStoragePolicyManager$cleanupSourceFilesLocked$1(r13, r14);
        goto L8
    }

    public static Object g(MediaMetadata r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GalleryStoragePolicyManager$cleanupAfterSync$2(r3, null), r4);
    }

    public static boolean o(File r5, n r6) {
        String r7 = r5.getAbsolutePath();
        if (r6.a.contains(r7) == true) goto L23;
        Set<String> r8 = r6.b;
        if ((r8 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L15;
        String r0 = (String) r9.next();
        Intrinsics.checkNotNull(r7);
        if (StringsKt.startsWith$default(r7, r0 + File.separator, false, 2, null) == false) goto L11;
        boolean r10 = true;
    L16:
        if (r10 == true) goto L24;
        return false;
    L24:
        return true;
    L15:
        r10 = false;
        goto L16
    L7:
        if (r8.isEmpty() == false) goto L9;
    L23:
        return true;
    }

    public static boolean p(File r6, MediaMetadata r7) {
        com.larus.avlink.gallery.e.a.getClass();
        String r0 = com.larus.avlink.gallery.e.c().getAbsolutePath();
        String r1 = r6.getAbsolutePath();
        if (Intrinsics.areEqual(r1, r0) == true) goto L8;
        Intrinsics.checkNotNull(r1);
        if (StringsKt.startsWith$default(r1, r0 + File.separator, false, 2, null) == true) goto L8;
        boolean r2 = false;
    L9:
        if (r2 == true) goto L12;
        return false;
    L12:
        if (StringsKt.equals(FilesKt.getExtension(r6), "pack", true) == false) goto L15;
        return true;
    L15:
        if (StringsKt.equals(FilesKt.getExtension(r6), "mp4", true) == false) goto L29;
        if (r7 == null) goto L31;
        String r3 = r7.getDownloadFilePath();
        if (r3 != null) goto L22;
    L24:
        boolean r8 = false;
    L25:
        if (r8 == false) goto L29;
        int r9 = com.larus.avlink.gallery.j.a;
        if (com.larus.avlink.gallery.j.c(r7.getMediaType()) == false) goto L29;
        return true;
    L22:
        if (Intrinsics.areEqual(new PolarisFileWrapper(r3).getAbsolutePath(), r6.getAbsolutePath()) != true) goto L24;
        r8 = true;
        goto L25
    L31:
        return true;
    L29:
        return false;
    L8:
        r2 = true;
        goto L9
    }

    public static w88.n d(String r4, List r5, Function1 r6) {
        ArrayList r0 = new ArrayList();
        Iterator r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        File r1 = (File) r7.next();
        a.getClass();
        CollectionsKt.addAll(r0, f(r1));
        goto L4
    L6:
        ArrayList r8 = new ArrayList();
        Iterator r2 = r0.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        Object r3 = r2.next();
        if (((Boolean) r6.invoke(r3)).booleanValue() == false) goto L8;
        r8.add(r3);
        goto L8
    L12:
        Iterator r9 = r8.iterator();
        long r10 = 0;
    L14:
        if (r9.hasNext() == false) goto L16;
        File r11 = (File) r9.next();
        a.getClass();
        r10 = r10 + s(r11);
        goto L14
    L16:
        int r12 = 0;
        if (r8.isEmpty() == true) goto L28;
        Iterator r13 = r8.iterator();
    L21:
        if (r13.hasNext() == false) goto L28;
        if (((File) r13.next()).isFile() == false) goto L21;
        r12 = r12 + 1;
        if (r12 >= 0) goto L21;
        CollectionsKt.throwCountOverflow();
    L28:
        return new w88.n(r4, r10, r12);
    }

    public static /* synthetic */ w88.n e(GalleryStoragePolicyManager r1, String r2, List r3) {
        Function1 r0 = new f();
        r1.getClass();
        return d(r2, r3, r0);
    }

    public static Object h(MediaMetadata r3, String r4, ContinuationImpl r5) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GalleryStoragePolicyManager$cleanupDeletedMedia$2(r3, r4, null), r5);
    }

    public static o k(List r10, String r11, boolean r12, String r13) {
        HashSet r0 = new HashSet();
        ArrayList r1 = new ArrayList();
        Iterator r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        Object r2 = r14.next();
        if (r0.add(((File) r2).getAbsolutePath()) == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        Iterator r15 = r1.iterator();
        int r3 = 0;
        long r4 = 0;
    L10:
        if (r15.hasNext() == false) goto L37;
        File r5 = (File) r15.next();
        GalleryStoragePolicyManager r6 = a;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L31
        r6.getClass();     // Catch: Throwable -> L31
        if (n(r5) == false) goto L14;
        if (r12 == true) goto L20;
        if (p(r5, null) == false) goto L20;
        q(r5, r11, "skip_source", 0, r13);     // Catch: Throwable -> L31
    L20:
        if (r5.exists() == false) goto L10;
        long r8 = u(r5);     // Catch: Throwable -> L31
        if (r5.isDirectory() == false) goto L25;
        boolean r9 = FilesKt.deleteRecursively(r5);     // Catch: Throwable -> L31
    L26:
        if (r9 == false) goto L28;
        r3 = r3 + 1;     // Catch: Throwable -> L31
        r4 = r4 + r8;     // Catch: Throwable -> L31
        q(r5, r11, "success", r8, r13);     // Catch: Throwable -> L31
    L29:
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L10;
        FLogger.a.e("GalleryStoragePolicyManager", "delete file failed, path=" + r5.getAbsolutePath() + ", reason=" + r11, r17);
        a.getClass();
        q(r5, r11, "exception", 0, r13);
        goto L10
    L28:
        q(r5, r11, "failed", r8, r13);     // Catch: Throwable -> L31
        goto L29
    L25:
        r9 = r5.delete();     // Catch: Throwable -> L31
        goto L26
    L14:
        q(r5, r11, "reject_invalid_path", 0, r13);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L37:
        return new o(r3, r4, r11);
    }

    public static final o c(GalleryStoragePolicyManager r2, List r3, String r4, boolean r5, String r6) {
        r2.getClass();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r3.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r0 = r8.next();
        if ((!StringsKt.isBlank((String) r0)) == false) goto L4;
        r7.add(r0);
        goto L4
    L8:
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r10 = r7.iterator();
    L10:
        if (r10.hasNext() == false) goto L13;
        r9.add(new PolarisFileWrapper((String) r10.next()));
        goto L10
    L13:
        return k(r9, r4, r5, r6);
    }

    public static void q(File r8, String r9, String r10, long r11, String r13) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("file_action=delete, media_id=");
        if (r13 != null) goto L5;
        r13 = "";
    L5:
        r1.append(r13);
        r1.append(", stage=");
        String r14 = r8.getAbsolutePath();
        Intrinsics.checkNotNull(r14);
        com.larus.avlink.gallery.e.a.getClass();
        if (StringsKt.startsWith$default(r14, com.larus.avlink.gallery.e.c().getAbsolutePath(), false, 2, null) == false) goto L11;
        String r7 = "pack";
        if (StringsKt.equals(FilesKt.getExtension(r8), "pack", true) == false) goto L11;
    L34:
        r1.append(r7);
        r1.append(", path=");
        r1.append(r8.getAbsolutePath());
        r1.append(", size=");
        r1.append(r11);
        r1.append(", result=");
        r1.append(r10);
        r1.append(", reason=");
        r1.append(r9);
        r0.i("GalleryStoragePolicyManager", r1.toString());
        return;
    L11:
        if (StringsKt.startsWith$default(r14, com.larus.avlink.gallery.e.c().getAbsolutePath(), false, 2, null) == false) goto L16;
        if (p(r8, null) == false) goto L16;
        r7 = "source";
    L16:
        if (StringsKt.startsWith$default(r14, com.larus.avlink.gallery.e.c().getAbsolutePath(), false, 2, null) == false) goto L19;
        r7 = "downloads";
        goto L34
    L19:
        if (StringsKt.startsWith$default(r14, com.larus.avlink.gallery.e.g().getAbsolutePath(), false, 2, null) == false) goto L22;
        r7 = "temp";
        goto L34
    L22:
        if (StringsKt.startsWith$default(r14, com.larus.avlink.gallery.e.f().getAbsolutePath(), false, 2, null) == false) goto L25;
        r7 = "processing";
        goto L34
    L25:
        if (StringsKt.startsWith$default(r14, com.larus.avlink.gallery.e.e().getAbsolutePath(), false, 2, null) == false) goto L28;
        r7 = "processed";
        goto L34
    L28:
        if (StringsKt.startsWith$default(r14, com.larus.avlink.gallery.e.d().getAbsolutePath(), false, 2, null) == false) goto L30;
        r7 = "final";
        goto L34
    L30:
        r7 = "failed";
        if (StringsKt.startsWith$default(r14, new PolarisFileWrapper(com.larus.avlink.gallery.e.b(), "failed").getAbsolutePath(), false, 2, null) == true) goto L34;
        r7 = "unknown";
        goto L34
    }
}
