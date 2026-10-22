package com.larus.avlink.gallery.migration;

import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.avlink.gallery.storage.GalleryStoragePolicyManager;
import com.larus.avlink.gallery.storage.m;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AlbumMetadataMigrationHelper {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public AlbumMetadataMigrationHelper() {
    }

    static {
        a = LazyKt.lazy(new a());
        b = LazyKt.lazy(new b());
    }

    public static final List a(String r3) {
        List r4 = m.a(r3);     // Catch: Exception -> L16
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));     // Catch: Exception -> L16
        Iterator r5 = r4.iterator();     // Catch: Exception -> L16
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add(((MediaMetadata) r5.next()).getUniqId());     // Catch: Exception -> L16
        goto L4
    L6:
        ArrayList r6 = new ArrayList();     // Catch: Exception -> L16
        Iterator r1 = r0.iterator();     // Catch: Exception -> L16
    L7:
        if (r1.hasNext() == false) goto L27;
        Object r2 = r1.next();     // Catch: Exception -> L16
        if (((String) r2).length() <= 0) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L7;
        r6.add(r2);     // Catch: Exception -> L16
        goto L7
    L12:
        r7 = false;
        goto L13
    L27:
        return r6;
    L16:
        e = move-exception;
        FLogger.a.w("AlbumMetadataMigrationHelper", "Error extracting file IDs from index: " + e.getMessage());
        return CollectionsKt.emptyList();
    }

    public static Object b(Continuation r3) {
        GalleryStoragePolicyManager.a.getClass();
        if (GalleryStoragePolicyManager.m() == true) goto L5;
        Object r4 = BuildersKt.withContext(Dispatchers.getIO(), new AlbumMetadataMigrationHelper$mediaMetadataMigrate$2(null), r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r4;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }
}
