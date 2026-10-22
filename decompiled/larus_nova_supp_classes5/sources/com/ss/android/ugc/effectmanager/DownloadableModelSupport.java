package com.ss.android.ugc.effectmanager;

import com.ss.android.ugc.effectmanager.algorithm.AlgorithmModelManager;
import com.ss.android.ugc.effectmanager.algorithm.FetchResourcesListener;
import com.ss.android.ugc.effectmanager.effect.bridge.EffectFetcher;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.knadapt.KNLibraryLoader;
import com.ss.android.ugc.effectmanager.knadapt.ModelListenerAdaptKt;
import com.ss.android.ugc.effectmanager.model.LocalModelInfo;
import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceManager;
import com.ss.ugc.effectplatform.algorithm.b;
import com.ss.ugc.effectplatform.model.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DownloadableModelSupport {
    private static DownloadableModelSupport INSTANCE = null;
    public static final String TAG = "DownloadableModelSupport";
    static DownloadableModelSupportLibraryLoader sLibraryLoader;
    private DownloadableModelConfig config;
    private DownloadableModelSupportResourceFinder knResourceFinder;
    private DownloadableModelSupportEffectFetcher mEffectFetcher;

    public void requestModelInfoBackGround() {
        AlgorithmResourceManager.fetchModelList(0);
    }

    static {
        sLibraryLoader = new DownloadableModelSupportLibraryLoader.SystemLoader();
    }

    public static DownloadableModelSupport getInstance() {
        DownloadableModelSupport r0 = INSTANCE;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("downloadableModelSupport not initialize");
    }

    private DownloadableModelSupportResourceFinder getOrCreateKNResourceFinder() {
        if (this.knResourceFinder != null) goto L15;
        monitor-enter(DownloadableModelSupportResourceFinder.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.knResourceFinder != null) goto L9;
        this.knResourceFinder = new DownloadableModelSupportResourceFinder();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadableModelSupportResourceFinder.class);     // Catch: Throwable -> L11
    L15:
        return this.knResourceFinder;
    }

    public static void loadSo() {
        b.c.a();
    }

    public EffectFetcher getEffectFetcher() {
        if (this.mEffectFetcher != null) goto L6;
        this.mEffectFetcher = new DownloadableModelSupportEffectFetcher();
    L6:
        return this.mEffectFetcher;
    }

    private DownloadableModelSupportResourceFinder getOrCreateResourceFinder() {
        return getOrCreateKNResourceFinder();
    }

    public static boolean isInitialized() {
        return AlgorithmResourceManager.isInitialized();
    }

    public DownloadableModelSupportResourceFinder getResourceFinder() {
        return getOrCreateResourceFinder();
    }

    private DownloadableModelSupport() {
    }

    public static void initialize(DownloadableModelConfig r1) {
        AlgorithmResourceManager.initialize(r1.getKNEffectConfig());
        DownloadableModelSupport r0 = new DownloadableModelSupport();
        INSTANCE = r0;
        r0.config = r1;
    }

    public static void setLibraryLoader(DownloadableModelSupportLibraryLoader r2) {
        AlgorithmResourceManager.Companion.setLibraryLoader(new KNLibraryLoader(r2));
    }

    public List<LocalModelInfo> getLocalModelInfo(List<String> r5) {
        List<d> r6 = AlgorithmResourceManager.getInstance().fetchLocalModelInfo(r5);
        ArrayList r0 = new ArrayList();
        Iterator<d> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        d r1 = r7.next();
        LocalModelInfo r2 = LocalModelInfo.fromFile(r1.f);
        r2.setSize(r1.c());
        r2.setName(r1.b());
        r2.setVersion(r1.d());
        r0.add(r2);
        goto L4
    L6:
        return r0;
    }

    public boolean areRequirementsReady(EffectManager r1, Effect r2) {
        return AlgorithmResourceManager.getInstance().areRequirementsReady(r2);
    }

    public void fetchResourcesNeededByRequirements(String[] r2, IFetchModelListener r3) {
        AlgorithmResourceManager.getInstance().fetchResourcesNeededByRequirements(Arrays.asList(r2), ModelListenerAdaptKt.toKNListener(r3));
    }

    public boolean isEffectReady(EffectManager r2, Effect r3) {
        return AlgorithmResourceManager.getInstance().isEffectReady(r2.getKNEffectPlatform(), r3);
    }

    public boolean isEffectReadyLite(EffectManager r2, Effect r3) {
        return AlgorithmResourceManager.getInstance().isEffectReadyLite(r2.getKNEffectPlatform(), r3);
    }

    public void fetchResourcesNeededByRequirements(List<String> r2, IFetchModelListener r3) {
        AlgorithmResourceManager.getInstance().fetchResourcesNeededByRequirements(r2, ModelListenerAdaptKt.toKNListener(r3));
    }

    public void fetchResourcesByRequirementsAndModelNames(String[] r2, Map<String, List<String>> r3, IFetchResourceListener r4) {
        AlgorithmResourceManager.getInstance().fetchResourcesByRequirementsAndModelNames(r2, r3, IFetchResourceListenerKt.toKNListener(r4));
    }

    public void fetchResourcesWithModelNames(int r2, String[] r3, FetchResourcesListener r4) {
        if (AlgorithmModelManager.isInitialized() == true) goto L5;
        AlgorithmModelManager.initialize(this.config);
    L5:
        AlgorithmModelManager.getInstance().fetchResourcesWithModelNames(r2, r3, r4);
    }

    public boolean isEffectReady(EffectManager r2, Effect r3, boolean r4) {
        return AlgorithmResourceManager.getInstance().isEffectReady(r2.getKNEffectPlatform(), r3, r4);
    }
}
