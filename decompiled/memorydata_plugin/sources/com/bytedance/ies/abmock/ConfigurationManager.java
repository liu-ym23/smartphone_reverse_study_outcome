package com.bytedance.ies.abmock;

import android.app.Application;
import com.bytedance.ies.abmock.datacenter.DataStorageProvider;
import com.bytedance.ies.abmock.datacenter.j;
import com.bytedance.ies.abmock.datacenter.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ConfigurationManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ConfigurationManager f2654b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f2655a;
    private Application c;
    private volatile k d;
    private volatile k e;
    private volatile Boolean f;
    private final Map<String, List<Object>> g;
    private final ConcurrentLinkedDeque<Object> h;
    private final Set<Object> i;
    private final Set<Object> j;
    private a k;
    private final DataStorageProvider.a l;

    public static final enum ChunkUpdateState extends Enum<ChunkUpdateState> {
        private static final /* synthetic */ ChunkUpdateState[] $VALUES = null;
        public static final ChunkUpdateState FINISH = null;
        public static final ChunkUpdateState FIRST = null;
        public static final ChunkUpdateState FIRST_FINISH = null;
        public static final ChunkUpdateState MIDDLE = null;

        static {
            ChunkUpdateState r0 = new ChunkUpdateState("FIRST_FINISH", 0);
            FIRST_FINISH = r0;
            ChunkUpdateState r1 = new ChunkUpdateState("FIRST", 1);
            FIRST = r1;
            ChunkUpdateState r3 = new ChunkUpdateState("MIDDLE", 2);
            MIDDLE = r3;
            ChunkUpdateState r5 = new ChunkUpdateState("FINISH", 3);
            FINISH = r5;
            $VALUES = new ChunkUpdateState[]{r0, r1, r3, r5};
        }

        private ChunkUpdateState(String r1, int r2) {
            super(r1, r2);
        }

        public static ChunkUpdateState valueOf(String r2) {
            return (ChunkUpdateState) ZeusTransformUtils.preCheckCast(Enum.valueOf(ChunkUpdateState.class, r2), ChunkUpdateState.class, "com.obric.memorydata.plugin");
        }

        public static ChunkUpdateState[] values() {
            return (ChunkUpdateState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ChunkUpdateState[].class, "com.obric.memorydata.plugin");
        }
    }

    private ConfigurationManager() {
        this.g = new HashMap();
        this.h = new ConcurrentLinkedDeque();
        this.i = new HashSet();
        this.j = new HashSet();
        this.f2655a = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.l = $$Lambda$ConfigurationManager$1Jb2x8LUr4HALAe6hsOxe4UnzU.INSTANCE;
        this.f2655a.allowCoreThreadTimeOut(true);
    }

    public static ConfigurationManager a() {
        if (f2654b != null) goto L15;
        monitor-enter(ConfigurationManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2654b != null) goto L9;
        f2654b = new ConfigurationManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ConfigurationManager.class);     // Catch: Throwable -> L11
    L15:
        return f2654b;
    }

    static /* synthetic */ k a(ConfigurationManager r0) {
        return r0.d;
    }

    private static /* synthetic */ void a(DataStorageProvider.StorageType r1) {
        if (r1 != DataStorageProvider.StorageType.CONFIG) goto L5;
    L6:
        j.f2688a.a();
        return;
    L5:
        if (r1 == DataStorageProvider.StorageType.UNREGISTER_CONFIG) goto L6;
    }

    /* JADX INFO: renamed from: lambda$1Jb2x8LUr4HAL-Ae6hsOxe4UnzU, reason: not valid java name */
    public static /* synthetic */ void m91lambda$1Jb2x8LUr4HALAe6hsOxe4UnzU(DataStorageProvider.StorageType r0) {
        a(r0);
    }

    public void a(Application r5, g r6, boolean r7) {
        Application r8 = (Application) ZeusTransformUtils.wrapperContextForParams(r5, Application.class, "com.obric.memorydata.plugin");
        long r0 = System.nanoTime();
        this.c = r8;
        this.d = r6;
        d.a().a(new AnonymousClass1(this));
        b.a().a(r6, r8, Boolean.valueOf(r7));
        d.b r9 = new d.b().a("config_center_init").a(System.nanoTime() - r0);
        d.a().a(r9);
        com.bytedance.ies.abmock.datacenter.e.a().a(this.l);
    }

    public boolean b() {
        if (this.f != null) goto L6;
        this.f = Boolean.valueOf(this.d.a());
    L6:
        return this.f.booleanValue();
    }

    public com.bytedance.ies.abmock.datacenter.a.a c() {
        return this.d.b();
    }

    public k d() {
        return this.e;
    }

    public a e() {
        return this.k;
    }
}
