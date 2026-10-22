package com.obric.memorydata.recommend.screenshotupload.sampling;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.impl.settings.AppSettingsManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0003J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/ScreenshotSamplingCoordinator;", "", "intervalMs", "", "nowProvider", "Lkotlin/Function0;", "<init>", "(JLkotlin/jvm/functions/Function0;)V", "getIntervalMs", "()J", "lastCaptureMsByPackage", "Ljava/util/concurrent/ConcurrentHashMap;", "", "shouldRunLowPriorityCapture", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "nowMs", "recordCapture", "", "timestampMs", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12588b;
    private final Function0<Long> c;
    private final ConcurrentHashMap<String, Long> d;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/ScreenshotSamplingCoordinator$Companion;", "", "<init>", "()V", "DEFAULT_INTERVAL_MS", "", "getDEFAULT_INTERVAL_MS", "()J", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final long a() {
            return AppSettingsManager.INSTANCE.getRecommendSettings().getScreenshotSamplingIntervalSeconds() * 1000;
        }
    }

    static {
        f12587a = new a(null);
    }

    public e() {
        this(0, null, 3, null);
    }

    public e(long r3, Function0<Long> r5) {
        Function0<Long> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "nowProvider");
        this.f12588b = r3;
        this.c = r6;
        this.d = new ConcurrentHashMap();
    }

    public /* synthetic */ e(long r2, Function0 r4, int r5, DefaultConstructorMarker r6) {
        Function0 r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = f12587a.a();
    L6:
        if ((r5 & 2) == 0) goto L8;
        r7 = $$Lambda$e$LKlqnDXgMfex0xnj8Ke2u9QKI7Y.INSTANCE;
    L8:
        this(r2, r7);
    }

    private static final long a() {
        return System.currentTimeMillis();
    }

    public static /* synthetic */ long lambda$LKlqnDXgMfex0xnj8Ke2u9QKI7Y() {
        return a();
    }

    public final void a(String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return;
    L5:
        Long r5 = Long.valueOf(r4);
        ((Map) ZeusTransformUtils.preCheckCast(this.d, Map.class, "com.obric.memorydata.plugin")).put(r3, r5);
    }

    public final boolean a(String r4, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return false;
    L5:
        Long r3 = (Long) ZeusTransformUtils.preCheckCast(this.d.get(r4), Long.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
        return true;
    L8:
        if ((r5 - r3.longValue()) >= r7) goto L10;
        return false;
    L10:
        return true;
    }
}
