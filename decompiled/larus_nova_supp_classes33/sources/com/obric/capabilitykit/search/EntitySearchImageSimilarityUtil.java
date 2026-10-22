package com.obric.capabilitykit.search;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import f06.b;
import f06.d;
import g06.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007J.\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/capabilitykit/search/EntitySearchImageSimilarityUtil;", "", "()V", "ENTITY_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "KEY_ENTITY_ID_LIST", "", "KEY_MEMORY_RESPONSE", "KEY_QUERY_TEXT", "METHOD_GET_IMAGES_SIMILARITY", "TAG", "getImagesSimilarityRankByTextFromVectorDB", "Lcom/obric/capabilitykit/search/Response;", "Lcom/obric/capabilitykit/search/Similarity;", "context", "Landroid/content/Context;", "entityIdList", "", "queryText", "innerCall", "uri", "method", "args", "Landroid/os/Bundle;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EntitySearchImageSimilarityUtil {
    private static final Uri ENTITY_URI = null;
    public static final EntitySearchImageSimilarityUtil INSTANCE = null;
    private static final String KEY_ENTITY_ID_LIST = "entity_id_list";
    private static final String KEY_MEMORY_RESPONSE = "memory_response";
    private static final String KEY_QUERY_TEXT = "query_text";
    private static final String METHOD_GET_IMAGES_SIMILARITY = "getImagesSimilarityByTextFromVectorDB";
    private static final String TAG = "ImageSimilarity";

    static {
        INSTANCE = new EntitySearchImageSimilarityUtil();
        ENTITY_URI = UriProtector.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
    }

    private EntitySearchImageSimilarityUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response getImagesSimilarityRankByTextFromVectorDB$default(EntitySearchImageSimilarityUtil r1, Context r2, List r3, String r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r4 = null;
    L9:
        return r1.getImagesSimilarityRankByTextFromVectorDB(r2, r3, r4);
    }

    private final String innerCall(Context r2, Uri r3, String r4, Bundle r5) {
        ContentProviderClient r6 = com_obric_capabilitykit_search_EntitySearchImageSimilarityUtil_android_content_ContentResolver_acquireUnstableContentProviderClient(r2.getContentResolver(), r3);     // Catch: Exception -> L21
        if (r6 != null) goto L27;
        return null;
    L27:
        Bundle r7 = r6.call(r4, null, r5);     // Catch: Throwable -> L8 Throwable -> L10
    L12:
        r6.close();     // Catch: Exception -> L21
        if (r7 != null) goto L15;
        return null;
    L15:
        String r8 = r7.getString(KEY_MEMORY_RESPONSE);     // Catch: Exception -> L21
        if (r8 != null) goto L29;
        return null;
    L29:
        return r8;
    L11:
        r7 = null;
    L8:
        th = move-exception;
        r6.close();     // Catch: Exception -> L21
        throw th;     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.getMessage();
        return null;
    }

    public static /* synthetic */ String innerCall$default(EntitySearchImageSimilarityUtil r0, Context r1, Uri r2, String r3, Bundle r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = new Bundle();
    L6:
        return r0.innerCall(r1, r2, r3, r4);
    }

    public final Response<Similarity> getImagesSimilarityRankByTextFromVectorDB(Context r10, List<String> r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        boolean r0 = true;
        if (r12 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        if (r11 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        if (r3 == true) goto L20;
        Uri r4 = ENTITY_URI;
        Bundle r5 = new Bundle();
        r5.putStringArrayList(KEY_ENTITY_ID_LIST, new ArrayList(r11));
        r5.putString(KEY_QUERY_TEXT, r12);
        String r13 = innerCall(r10, r4, METHOD_GET_IMAGES_SIMILARITY, r5);
        if (r13 != null) goto L24;
    L27:
        if (r0 == false) goto L31;
        return new Response(1, "result is empty", null, 4, null);
    L31:
        return new Response(0, "ok", (Similarity) GsonProtectorUtils.fromJson(new Gson(), r13, Similarity.class));
    L24:
        if (r13.length() == 0) goto L27;
        r0 = false;
        goto L27
    L20:
        return new Response(1, "entityIdList is empty", null, 4, null);
    L14:
        if (r11.isEmpty() == true) goto L17;
        r3 = false;
        goto L18
    L11:
        return new Response(1, "queryText is empty", null, 4, null);
    L5:
        if (r12.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    private static ContentProviderClient com_obric_capabilitykit_search_EntitySearchImageSimilarityUtil_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b();
        a r2 = (a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }
}
