package com.ss.ugc.effectplatform.algorithm;

import bytekn.foundation.logger.Logger;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.EffectPlatform;
import com.ss.ugc.effectplatform.cache.j;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.repository.AlgorithmRepository;
import com.ss.ugc.effectplatform.task.q1;
import com.ss.ugc.effectplatform.task.x0;
import com.ss.ugc.effectplatform.util.k;
import com.ss.ugc.effectplatform.util.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u0001:\u0001=B\u0011\b\u0002\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b;\u0010<J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u000b\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ*\u0010\u0016\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0014\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0014\u0018\u00010\u0013JE\u0010\u001a\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00172\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0013¢\u0006\u0004\b\u001a\u0010\u001bJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010JC\u0010\"\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\b\u0010!\u001a\u0004\u0018\u00010 2\u0014\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0014\u0018\u00010\u0013¢\u0006\u0004\b\"\u0010#J\u0016\u0010&\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010'\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$2\u0006\u0010\r\u001a\u00020\fR\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u00105R\u0017\u00107\u001a\u0002068\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceManager;", "", "Lcom/ss/ugc/effectplatform/algorithm/a;", "getEffectFetcherInternal", "Lcom/ss/ugc/effectplatform/algorithm/AlgorithmModelResourceFinder;", "getResourceFinder", "Lcom/ss/ugc/effectplatform/algorithm/g;", "customResourceFinder", "", "setCustomResourceFinder", "getCustomResourceFinder", "getEffectFetcher", "Lcom/ss/ugc/effectplatform/model/Effect;", "effect", "", "areRequirementsReady", "", "", "requirements", "Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;", "", "listener", "fetchResourcesNeededByRequirements", "", "modelNames", "", "fetchResourcesByRequirementsAndModelNames", "([Ljava/lang/String;Ljava/util/Map;Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;)V", "Lcom/ss/ugc/effectplatform/model/d;", "fetchLocalModelInfo", "", "businessId", "Lcom/ss/ugc/effectplatform/a;", "abTest", "fetchResourcesWithModelNames", "(I[Ljava/lang/String;Lcom/ss/ugc/effectplatform/a;Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;)V", "Lcom/ss/ugc/effectplatform/EffectPlatform;", "effectPlatform", "isEffectReady", "isEffectReadyLite", "Lcom/ss/ugc/effectplatform/cache/a;", "algorithmModelCache", "Lcom/ss/ugc/effectplatform/cache/a;", "Lcom/ss/ugc/effectplatform/algorithm/d;", "buildInAssetsManager", "Lcom/ss/ugc/effectplatform/algorithm/d;", "resourceFinder", "Lcom/ss/ugc/effectplatform/algorithm/AlgorithmModelResourceFinder;", "effectFetcher", "Lcom/ss/ugc/effectplatform/algorithm/a;", "Lcom/ss/ugc/effectplatform/repository/AlgorithmRepository;", "algorithmRepository", "Lcom/ss/ugc/effectplatform/repository/AlgorithmRepository;", "Lcom/ss/ugc/effectplatform/algorithm/g;", "Lcom/ss/ugc/effectplatform/EffectConfig;", "effectConfig", "Lcom/ss/ugc/effectplatform/EffectConfig;", "getEffectConfig", "()Lcom/ss/ugc/effectplatform/EffectConfig;", "<init>", "(Lcom/ss/ugc/effectplatform/EffectConfig;)V", "Companion", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class AlgorithmResourceManager {
    public static final Companion Companion = null;
    private static AlgorithmResourceManager INSTANCE;
    private static f libraryLoader;
    private final com.ss.ugc.effectplatform.cache.a algorithmModelCache;
    private final AlgorithmRepository algorithmRepository;
    private d buildInAssetsManager;
    private g customResourceFinder;
    private final EffectConfig effectConfig;
    private a effectFetcher;
    private AlgorithmModelResourceFinder resourceFinder;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007J\b\u0010\n\u001a\u00020\tH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007R*\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceManager$Companion;", "", "Lcom/ss/ugc/effectplatform/EffectConfig;", "config", "", "initialize", "", "bussinessId", "fetchModelList", "Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceManager;", "getInstance", "", "isInitialized", "Lcom/ss/ugc/effectplatform/algorithm/f;", "value", "libraryLoader", "Lcom/ss/ugc/effectplatform/algorithm/f;", "getLibraryLoader", "()Lcom/ss/ugc/effectplatform/algorithm/f;", "setLibraryLoader", "(Lcom/ss/ugc/effectplatform/algorithm/f;)V", "INSTANCE", "Lcom/ss/ugc/effectplatform/algorithm/AlgorithmResourceManager;", "<init>", "()V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final AlgorithmResourceManager getInstance() {
            AlgorithmResourceManager r0 = AlgorithmResourceManager.access$getINSTANCE$cp();
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new IllegalStateException("AlgorithmManager has not initialized,call AlgorithmManager#initialize first!");
        }

        public final f getLibraryLoader() {
            return AlgorithmResourceManager.access$getLibraryLoader$cp();
        }

        @JvmStatic
        public final boolean isInitialized() {
            if (AlgorithmResourceManager.access$getINSTANCE$cp() == null) goto L5;
            return true;
        L5:
            return false;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final void fetchModelList(int r4) {
            x0.k.getClass();
            if (x0.h.get("biz_" + r4) != null) goto L8;
            q1 r0 = getInstance().getEffectConfig().D;
            if (r0 == null) goto L9;
            r0.a(new a(r4, q.a()));
            return;
        L9:
            return;
        }

        @JvmStatic
        public final synchronized void initialize(EffectConfig r3) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (AlgorithmResourceManager.access$getINSTANCE$cp() != null) goto L9;
            AlgorithmResourceManager.access$setINSTANCE$cp(new AlgorithmResourceManager(r3, null));     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L9:
            throw new IllegalStateException("Duplicate initialization");     // Catch: Throwable -> L10
        }

        public final void setLibraryLoader(f r2) {
            AlgorithmResourceManager.access$setLibraryLoader$cp(r2);
            f r0 = b.a;
            b.a = r2;
        }

        public static /* synthetic */ void fetchModelList$default(Companion r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = 0;
        L5:
            r0.fetchModelList(r1);
        }
    }

    @JvmStatic
    public static final void fetchModelList(int r1) {
        Companion.fetchModelList(r1);
    }

    @JvmStatic
    public static final AlgorithmResourceManager getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final synchronized void initialize(EffectConfig r2) {
        monitor-enter(AlgorithmResourceManager.class);
        Companion.initialize(r2);     // Catch: Throwable -> L7
        monitor-exit(AlgorithmResourceManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return Companion.isInitialized();
    }

    public final g getCustomResourceFinder() {
        return null;
    }

    static {
        Companion = new Companion(null);
        libraryLoader = f.a.a;
    }

    private final a getEffectFetcherInternal() {
        a r0 = this.effectFetcher;
        if (r0 != null) goto L7;
        EffectConfig r1 = this.effectConfig;
        x0.k.getClass();
        a r2 = new a(r1, x0.a.b(r1), this.buildInAssetsManager, this.algorithmModelCache);
        this.effectFetcher = r2;
        return r2;
    L7:
        return r0;
    }

    public final AlgorithmModelResourceFinder getResourceFinder() {
        AlgorithmModelResourceFinder r0 = this.resourceFinder;
        if (r0 != null) goto L7;
        com.ss.ugc.effectplatform.cache.a r1 = this.algorithmModelCache;
        d r2 = this.buildInAssetsManager;
        this.effectConfig.getClass();
        AlgorithmModelResourceFinder r3 = new AlgorithmModelResourceFinder(r1, r2, null, this.effectConfig);
        this.resourceFinder = r3;
        return r3;
    L7:
        return r0;
    }

    public final a getEffectFetcher() {
        return getEffectFetcherInternal();
    }

    public static final /* synthetic */ AlgorithmResourceManager access$getINSTANCE$cp() {
        return INSTANCE;
    }

    public static final /* synthetic */ f access$getLibraryLoader$cp() {
        return libraryLoader;
    }

    public final EffectConfig getEffectConfig() {
        return this.effectConfig;
    }

    private AlgorithmResourceManager(EffectConfig r8) {
        this.effectConfig = r8;
        this.buildInAssetsManager = new d(r8.G, r8.I, r8.c0);
        z.b<String, j> r0 = com.ss.ugc.effectplatform.cache.h.a;
        j r1 = com.ss.ugc.effectplatform.cache.h.a(r8.K);
        if (r1 != null) goto L5;
    L8:
        com.ss.ugc.effectplatform.cache.a r2 = new com.ss.ugc.effectplatform.cache.a(r8, r8.K, r8.j, r8.Q.hashCode(), this.buildInAssetsManager);
        this.algorithmModelCache = r2;
        String r3 = r8.K;
        com.ss.ugc.effectplatform.cache.h.a.put(r3, r2);
    L10:
        if (AlgorithmRepository.g == null) goto L12;
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        AlgorithmRepository.g = new AlgorithmRepository(r8);
    L16:
        if (r8.T == false) goto L20;
        Object r9 = r8.G;
        if (r9 == null) goto L20;
        com.ss.ugc.effectplatform.preload.b.d.getClass();
        com.ss.ugc.effectplatform.preload.b.a.a(r9);
    L20:
        this.algorithmRepository = AlgorithmRepository.a.a();
        return;
    L12:
        r4 = false;
        goto L13
    L5:
        if ((r1 instanceof com.ss.ugc.effectplatform.cache.a) == false) goto L8;
        this.algorithmModelCache = (com.ss.ugc.effectplatform.cache.a) r1;
        goto L10
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(AlgorithmResourceManager r0) {
        INSTANCE = r0;
    }

    public static final /* synthetic */ void access$setLibraryLoader$cp(f r0) {
        libraryLoader = r0;
    }

    public final boolean areRequirementsReady(Effect r2) {
        return this.algorithmRepository.a(r2);
    }

    public final List<com.ss.ugc.effectplatform.model.d> fetchLocalModelInfo(List<String> r11) {
        AlgorithmRepository r0 = this.algorithmRepository;
        r0.getClass();
        List<String> r12 = r11;
        int r1 = 0;
        boolean r2 = true;
        if (r12 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L43;
        Object[] r13 = r12.toArray(new String[0]);
        if (r13 == null) goto L38;
        EffectConfig r4 = r0.f;
        String[] r14 = i.d((String[]) r13, r4.t, r4.G);
        com.ss.ugc.effectplatform.task.algorithm.c r5 = r0.d().a;
        EffectConfig r6 = r5.l;
        d r7 = r5.j;
        com.ss.ugc.effectplatform.cache.a r8 = r5.k;
        hlc.a r9 = r6.N;
        new AtomicInteger(0);
        new AtomicInteger(0);
        Collections.synchronizedList(new ArrayList());
        if (r14 != null) goto L16;
    L22:
        if (r2 == true) goto L44;
        ArrayList r10 = new ArrayList();
        int r15 = r14.length;
    L25:
        if (r1 >= r15) goto L36;
        String r16 = r14[r1];
        com.ss.ugc.effectplatform.model.d r17 = r8.i(k.d(r16));
        if (r17 == null) goto L29;
        r10.add(r17);
    L34:
        r1 = r1 + 1;
        goto L25
    L29:
        boolean r18 = r7.b(r16);
        if (r18 == false) goto L32;
        Logger.INSTANCE.d("effect_platform", "model: " + r16 + " is built in resource");
    L32:
        if (r18 == false) goto L34;
        int r19 = com.ss.ugc.effectplatform.model.d.g;
        StringBuilder r20 = new StringBuilder("file:///android_");
        r20.append("asset://model/" + r7.a(r16));
        com.ss.ugc.effectplatform.model.d r21 = new com.ss.ugc.effectplatform.model.d(r20.toString());
        String r22 = k.f(r16);
        int r23 = k.e(r16);
        r21.b = r22;
        r21.d = r23;
        r10.add(r21);
        goto L34
    L36:
        return r10;
    L44:
        return new ArrayList();
    L16:
        if (r14.length != 0) goto L18;
        boolean r24 = true;
    L19:
        if (r24 == true) goto L22;
        r2 = false;
        goto L22
    L18:
        r24 = false;
        goto L19
    L38:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    L43:
        return new ArrayList();
    L5:
        if (r12.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    public final void setCustomResourceFinder(g r1) {
        monitor-enter(this);
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ AlgorithmResourceManager(EffectConfig r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    public final void fetchResourcesNeededByRequirements(List<String> r5, IEffectPlatformBaseListener<String[]> r6) {
        AlgorithmRepository r0 = this.algorithmRepository;
        q1 r1 = r0.f.D;
        if (r1 == null) goto L6;
        r1.a(new com.ss.ugc.effectplatform.repository.b(r0, r5, r6, q.a()));
        return;
    }

    public final boolean isEffectReady(EffectPlatform r1, Effect r2) {
        return r1.isEffectReady(r2);
    }

    public final boolean isEffectReadyLite(EffectPlatform r1, Effect r2) {
        return r1.isEffectReadyLite(r2);
    }

    public final void fetchResourcesByRequirementsAndModelNames(String[] r9, Map<String, ? extends List<String>> r10, IEffectPlatformBaseListener<Long> r11) {
        AlgorithmRepository r1 = this.algorithmRepository;
        q1 r6 = r1.f.D;
        if (r6 == null) goto L6;
        r6.a(new com.ss.ugc.effectplatform.repository.a(r1, r9, r10, r11, q.a()));
        return;
    }

    public final void fetchResourcesWithModelNames(int r2, String[] r3, com.ss.ugc.effectplatform.a r4, IEffectPlatformBaseListener<String[]> r5) {
        this.algorithmRepository.c(r2, r3, r4, r5);
    }
}
