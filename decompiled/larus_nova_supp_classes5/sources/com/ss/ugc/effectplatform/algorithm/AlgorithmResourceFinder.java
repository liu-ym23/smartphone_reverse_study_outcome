package com.ss.ugc.effectplatform.algorithm;

import bytekn.foundation.logger.Logger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel;
import com.ss.ugc.effectplatform.model.algorithm.ModelInfo;
import com.ss.ugc.effectplatform.task.x0;
import com.ss.ugc.effectplatform.util.k;
import com.ss.ugc.effectplatform.util.r;
import com.ss.ugc.effectplatform.util.t;
import hlc.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 $2\u00020\u0001:\u0001%B!\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\"\u0010#J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0014J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0002H\u0014J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceFinder;", "", "", "nameStr", "", "businessId", "modelUri", "", "checkModelMd5", "findResourceUri", "dir", "realFindResourceUri", "isResourceAvailable", "", "markModelUsed", "isExactBuiltInResource", "getBuiltInResourceUrl", "modelName", "errorMessage", "onModelNotFound", "onModelFound", "filePath", "readAssetFileAsString", "", "getEffectHandle", "Lcom/ss/ugc/effectplatform/cache/a;", "algorithmModelCache", "Lcom/ss/ugc/effectplatform/cache/a;", "Lcom/ss/ugc/effectplatform/algorithm/d;", "buildInAssetsManager", "Lcom/ss/ugc/effectplatform/algorithm/d;", "Lhlc/e;", "eventListener", "Lhlc/e;", "<init>", "(Lcom/ss/ugc/effectplatform/cache/a;Lcom/ss/ugc/effectplatform/algorithm/d;Lhlc/e;)V", "Companion", "a", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class AlgorithmResourceFinder {
    public static final a Companion = null;
    public static final String MD5_ERROR = "asset://md5_error";
    public static final String NOT_FOUND = "asset://not_found";
    public static final String RESOURCE_MANAGER_NOT_INITIALIZED = "asset://not_initialized";
    public static final String TAG = "AlgorithmResourceFinder";
    private final com.ss.ugc.effectplatform.cache.a algorithmModelCache;
    private final d buildInAssetsManager;
    private final e eventListener;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public long getEffectHandle() {
        return 0;
    }

    public void onModelFound(String r1) {
    }

    public String findResourceUri(String r4) {
        String r0 = k.d(r4);
        com.ss.ugc.effectplatform.model.d r1 = this.algorithmModelCache.i(r0);
        if (r1 == null) goto L5;
        boolean r2 = true;
    L6:
        String r3 = null;
        if (r2 == false) goto L13;
        int r5 = t.a;
        StringBuilder r6 = new StringBuilder("file://");
        if (r1 == null) goto L11;
        r3 = r1.f;
    L11:
        r6.append(r3);
        return UriProtector.parse(r6.toString()).toString();
    L13:
        if (isExactBuiltInResource(r4) == true) goto L15;
        return null;
    L15:
        return getBuiltInResourceUrl(r4);
    L5:
        r2 = false;
        goto L6
    }

    public String getBuiltInResourceUrl(String r4) {
        d r0 = this.buildInAssetsManager;
        r0.getClass();
        return "asset://model/" + r0.a(r4);
    }

    public boolean isExactBuiltInResource(String r2) {
        return this.buildInAssetsManager.b(r2);
    }

    public final boolean isResourceAvailable(String r3) {
        String r4 = findResourceUri(r3);
        if (r4 != null) goto L5;
    L9:
        return false;
    L5:
        if ((!Intrinsics.areEqual(r4, MD5_ERROR)) == false) goto L9;
        if ((!Intrinsics.areEqual(r4, NOT_FOUND)) == false) goto L9;
        return true;
    }

    public final void markModelUsed(String r2) {
        this.algorithmModelCache.d(k.d(r2));
    }

    public final String readAssetFileAsString(String r2) {
        return this.buildInAssetsManager.f(r2);
    }

    public void onModelNotFound(String r3, String r4) {
        RuntimeException r5 = new RuntimeException("model not found neither in asset nor disk " + r4);
        e r6 = this.eventListener;
        if (r6 == null) goto L6;
        r6.onModelNotFound(null, r5);
        return;
    }

    public AlgorithmResourceFinder(com.ss.ugc.effectplatform.cache.a r1, d r2, e r3) {
        this.algorithmModelCache = r1;
        this.buildInAssetsManager = r2;
        this.eventListener = r3;
    }

    private final boolean checkModelMd5(String r13, int r14, String r15) {
        if (r15 != null) goto L5;
    L26:
        return false;
    L5:
        if (isExactBuiltInResource(r13) == true) goto L26;
        String r1 = k.d(r13);
        String r16 = k.b(r15);
        x0.k.getClass();
        com.ss.ugc.effectplatform.model.c r2 = x0.b(x0.a.a(), r14);
        if (this.algorithmModelCache.k.V == false) goto L9;
        String r3 = bytekn.foundation.utils.c.a(r1);
    L11:
        if (r2 != null) goto L27;
    L18:
        ExtendedUrlModel r17 = null;
    L19:
        if (r17 != null) goto L22;
        Logger.e$default(Logger.INSTANCE, TAG, "expected model info not found in model list - " + r13, null, 4, null);
        return false;
    L22:
        String r18 = r17.getUri();
        if (r.a(r16, r18) == true) goto L26;
        String r19 = r13 + " md5 = " + r16 + " expectedMd5 = " + r18;
        Logger.INSTANCE.d(TAG, "findResourceUri called with nameStr = [" + r13 + "], asset://md5_error\n" + r19);
        onModelNotFound(r1, r19);
        return true;
    L27:
        r17 = r2.a(r3);     // Catch: IllegalArgumentException -> L14
    L14:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "model info not found in model list", e);
        x0.k.getClass();
        ModelInfo r110 = x0.a.a().d(r14, r3, true);
        if (r110 == null) goto L18;
        r17 = r110.getFile_url();
        goto L19
    L9:
        r3 = r1;
        goto L11
    }

    public final String realFindResourceUri(int r12, String r13, String r14) {
        Logger.INSTANCE.d(TAG, "findResourceUri() called with nameStr = [" + r14 + ']');
        String r0 = findResourceUri(r14);
        if (checkModelMd5(r14, r12, r0) == false) goto L9;
        return MD5_ERROR;
    L9:
        if (r0 != null) goto L12;
        Logger.e$default(Logger.INSTANCE, TAG, "findResourceUri called with nameStr = [" + r14 + "], returned result: [asset://not_found]", null, 4, null);
        return NOT_FOUND;
    L12:
        Logger.INSTANCE.d(TAG, "findResourceUri called with nameStr = [" + r14 + "], returned result: [" + r0 + ']');
        onModelFound(r14);
        return r0;
    L7:
        e = move-exception;
        Logger.INSTANCE.e(TAG, "findResourceUri called with nameStr = [" + r14 + "], exception hanppens", e);
        goto L9
    }
}
