package com.ss.ugc.effectplatform.algorithm;

import bytekn.foundation.io.file.FileManager;
import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import hlc.e;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001\"B)\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0011\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0082 J\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/ss/ugc/effectplatform/algorithm/AlgorithmModelResourceFinder;", "Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceFinder;", "", "modelName", "", "mobModelFound", "errorMsg", "mobModelNotFound", "", "effectHandle", "nativeCreateResourceFinder", "getNativeResourceFinder", "nameStr", "", "isExactBuiltInResource", "getBuiltInResourceUrl", "errorMessage", "onModelNotFound", "onModelFound", "Lcom/ss/ugc/effectplatform/cache/a;", "algorithmModelCache", "Lcom/ss/ugc/effectplatform/cache/a;", "Lcom/ss/ugc/effectplatform/algorithm/d;", "buildInAssetsManager", "Lcom/ss/ugc/effectplatform/algorithm/d;", "Lhlc/e;", "eventListener", "Lhlc/e;", "Lcom/ss/ugc/effectplatform/EffectConfig;", "effectConfig", "Lcom/ss/ugc/effectplatform/EffectConfig;", "<init>", "(Lcom/ss/ugc/effectplatform/cache/a;Lcom/ss/ugc/effectplatform/algorithm/d;Lhlc/e;Lcom/ss/ugc/effectplatform/EffectConfig;)V", "Companion", "a", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class AlgorithmModelResourceFinder extends AlgorithmResourceFinder {
    public static final a Companion = null;
    private static final String TAG = "ResourceFinder";
    private static final ConcurrentHashMap<String, Boolean> modelsNotFoundRecord = null;
    private final com.ss.ugc.effectplatform.cache.a algorithmModelCache;
    private final d buildInAssetsManager;
    private final EffectConfig effectConfig;
    private final e eventListener;

    public static final class a {
        public a() {
        }
    }

    private final native long nativeCreateResourceFinder(long r1);

    static {
        Companion = new a();
        modelsNotFoundRecord = new ConcurrentHashMap();
    }

    public final long getNativeResourceFinder() {
        b.c.a();
        return nativeCreateResourceFinder(0);
    }

    private final void mobModelFound(String r5) {
        EffectConfig r0 = this.effectConfig;
        klc.a r1 = (klc.a) r0.v.a;
        if (r1 == null) goto L6;
        klc.b.j(r1, true, r0, r5, "");
        return;
    }

    @JvmStatic
    public static final void modelNotFound(String r7) {
        Companion.getClass();
        Logger.e$default(Logger.INSTANCE, TAG, "modelNotFound:nameStr=" + r7, null, 4, null);
        AlgorithmResourceManager.Companion.getInstance().getResourceFinder().onModelNotFound(r7, AlgorithmResourceFinder.NOT_FOUND);
    }

    @Override // com.ss.ugc.effectplatform.algorithm.AlgorithmResourceFinder
    public String getBuiltInResourceUrl(String r4) {
        d r0 = this.buildInAssetsManager;
        String r1 = (String) r0.c.get(r4);
        if (r1 != null) goto L11;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = "";
        r0.d(r4, new BuiltInResourceManager.getMappingModelUrlWithoutVersion.2(r0, r4, r2));
        if ((!StringsKt.isBlank((String) r2.element)) == true) goto L10;
        String r3 = "asset://model/" + r4;
        r0.c.put(r4, r3);
        return r3;
    L10:
        return (String) r2.element;
    L11:
        return r1;
    }

    @Override // com.ss.ugc.effectplatform.algorithm.AlgorithmResourceFinder
    public boolean isExactBuiltInResource(String r6) {
        d r0 = this.buildInAssetsManager;
        Boolean r1 = (Boolean) r0.b.get(r6);
        if (r1 != null) goto L25;
        boolean r2 = true;
        if (r0.d(r6, new BuiltInResourceManager.existMappingModelWithoutVersion.2(r0, r6)) == false) goto L8;
        return true;
    L8:
        String r3 = "model/" + r6;
        boolean r4 = false;
        if (r0.g(r3) == false) goto L23;
    L20:
        r0.b.put(r6, Boolean.valueOf(r4));
        return r4;
    L23:
        bytekn.foundation.io.file.b r5 = r0.e(r3);     // Catch: Throwable -> L18 Exception -> L22
        if (r5 != null) goto L15;
        r2 = false;
    L15:
        if (r5 == null) goto L17;
        FileManager.b(r5);
    L17:
        r4 = r2;
        goto L20
    L18:
        th = move-exception;
        throw th;
    L25:
        return r1.booleanValue();
    }

    @Override // com.ss.ugc.effectplatform.algorithm.AlgorithmResourceFinder
    public void onModelFound(String r1) {
        mobModelFound(r1);
    }

    @JvmStatic
    public static final String findResourceUri(String r6, String r7) {
        Companion.getClass();
        AlgorithmResourceManager.Companion r0 = AlgorithmResourceManager.Companion;
        if (r0.isInitialized() == true) goto L5;
        return AlgorithmResourceFinder.RESOURCE_MANAGER_NOT_INITIALIZED;
    L5:
        int r1 = b0.a.a;
        long r2 = System.currentTimeMillis();
        String r8 = r0.getInstance().getResourceFinder().realFindResourceUri(0, r6, r7);
        int r3 = e.a;
        Logger.INSTANCE.d("checkEffect", "findResourceUri name: " + r7 + ", result: " + r8 + ", time cost: " + (System.currentTimeMillis() - r2) + " ms");
        return r8;
    }

    private final void mobModelNotFound(String r4, String r5) {
        ConcurrentHashMap<String, Boolean> r0 = modelsNotFoundRecord;
        if (r0.contains(r4) == false) goto L5;
        return;
    L5:
        r0.put(r4, Boolean.TRUE);
        EffectConfig r1 = this.effectConfig;
        klc.a r2 = (klc.a) r1.v.a;
        if (r2 == null) goto L9;
        klc.b.j(r2, false, r1, r4, r5);
        return;
    }

    @Override // com.ss.ugc.effectplatform.algorithm.AlgorithmResourceFinder
    public void onModelNotFound(String r1, String r2) {
        super.onModelNotFound(r1, r2);
        mobModelNotFound(r1, r2);
    }

    public AlgorithmModelResourceFinder(com.ss.ugc.effectplatform.cache.a r1, d r2, e r3, EffectConfig r4) {
        super(r1, r2, r3);
        this.algorithmModelCache = r1;
        this.buildInAssetsManager = r2;
        this.eventListener = r3;
        this.effectConfig = r4;
    }
}
