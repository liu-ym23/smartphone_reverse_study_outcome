package com.obric.memorydata.screencapture.accessibility;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.view.accessibility.AccessibilityNodeInfo;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.screencapture.rule.CacheStrategy;
import com.obric.memorydata.sdk.screencapture.rule.HeifOutputOption;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.obric.memorydata.utils.x;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002-.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ \u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\u001d\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019J \u0010\u001f\u001a\u0004\u0018\u00010\u00012\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\"J\u001a\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010 \u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002J$\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010 \u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000fH\u0002J\u000e\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0005J\b\u0010,\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/memorydata/screencapture/accessibility/ScreenshotManager;", "", "<init>", "()V", "TAG", "", "screenshotCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/SoftReference;", "Lcom/obric/memorydata/screencapture/accessibility/ScreenshotManager$CachedScreenshot;", "mutexMap", "Lkotlinx/coroutines/sync/Mutex;", "CACHE_VALID_DURATION", "", "HEIF_DIMENSION_ALIGNMENT", "", "fallbackPortraitScreenSize", "Lkotlin/Pair;", "generateScreenshotForNode", "", "ruleStatus", "Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleStatus;", "rootNode", "Landroid/view/accessibility/AccessibilityNodeInfo;", "screenshotOption", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "(Lcom/obric/memorydata/screencapture/accessibility/AccessibilityRuleStatus;Landroid/view/accessibility/AccessibilityNodeInfo;Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearScreenshotCache", "getUniqueNodeKey", "getCache", "node", "takeScreenshot", "option", "targetPkg", "(Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "takeHeifScreenshot", "Lcom/obric/memorydata/screencapture/accessibility/ScreenshotManager$HeifCaptureResult;", "heifOutput", "Lcom/obric/memorydata/sdk/screencapture/rule/HeifOutputOption;", "resolveHeifOutputSize", "alignHeifDimension", "size", "removeScreenshotForKey", "key", "clearExpiredCache", "CachedScreenshot", "HeifCaptureResult", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12780a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, SoftReference<a>> f12781b = null;
    private static final ConcurrentHashMap<String, kotlinx.coroutines.sync.a> c = null;
    private static final Pair<Integer, Integer> d = null;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/screencapture/accessibility/ScreenshotManager$CachedScreenshot;", "", "result", "timestamp", "", "<init>", "(Ljava/lang/Object;J)V", "getResult", "()Ljava/lang/Object;", "getTimestamp", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f12782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12783b;

        public a(Object r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "result");
            this.f12782a = r2;
            this.f12783b = r3;
        }

        public final Object a() {
            return this.f12782a;
        }

        public final long b() {
            return this.f12783b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12782a, r8.f12782a) == true) goto L12;
            return false;
        L12:
            if (this.f12783b == r8.f12783b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f12782a.hashCode() * 31) + Long.hashCode(this.f12783b);
        }

        public String toString() {
            return "CachedScreenshot(result=" + this.f12782a + ", timestamp=" + this.f12783b + ')';
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/screencapture/accessibility/ScreenshotManager$HeifCaptureResult;", "", Params.FILE_PATH, "", "isVertical", "", "<init>", "(Ljava/lang/String;Z)V", "getFilePath", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "screen_capture_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12785b;

        public b(String r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, Params.FILE_PATH);
            this.f12784a = r2;
            this.f12785b = r3;
        }

        public final String a() {
            return this.f12784a;
        }

        public final boolean b() {
            return this.f12785b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12784a, r6.f12784a) == true) goto L12;
            return false;
        L12:
            if (this.f12785b == r6.f12785b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f12784a.hashCode() * 31) + Boolean.hashCode(this.f12785b);
        }

        public String toString() {
            return "HeifCaptureResult(filePath=" + this.f12784a + ", isVertical=" + this.f12785b + ')';
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12786a = null;

        static {
            int[] r0 = new int[CacheStrategy.values().length];
            r0[CacheStrategy.NO_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CacheStrategy.CACHE_WITH_ROOT_NODE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CacheStrategy.CACHE_WITH_UNIQUE_NODE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f12786a = r0;
        }
    }

    static {
        f12780a = new e();
        f12781b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = TuplesKt.to(1264, 2800);
    }

    private e() {
    }

    private final int a(int r1) {
        return (RangesKt.coerceAtLeast(r1, 4) / 4) * 4;
    }

    private final b a(ScreenshotOption r11, HeifOutputOption r12) {
        Pair<Integer, Integer> r10 = b(r11, r12);
        String r13 = "screenshot_" + System.currentTimeMillis() + ".heif";
        File r2 = new File(com.obric.memorydata.utils.e.d.f13218a.a());
        if (r2.exists() == true) goto L5;
        r2.mkdirs();
    L5:
        File r3 = new File(r2, r13);
        b r4 = null;
        ParcelFileDescriptor r14 = ParcelFileDescriptor.open(r3, 738197504);     // Catch: Exception -> L24
        com.obric.memorydata.utils.e.b r5 = com.obric.memorydata.utils.e.b.f13208a;     // Catch: Throwable -> L16 Exception -> L18
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L16 Exception -> L18
        if (r5.a(r14, ((Number) ZeusTransformUtils.preCheckCast(r10.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue(), ((Number) ZeusTransformUtils.preCheckCast(r10.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue(), r12.getQp(), r12.getDownScalePreference()) == true) goto L10;
        r3.delete();     // Catch: Throwable -> L16 Exception -> L18
    L29:
    L20:
        r14.close();
        return r4;
    L10:
        String r6 = r3.getAbsolutePath();     // Catch: Throwable -> L16 Exception -> L18
        Intrinsics.checkNotNullExpressionValue(r6, "getAbsolutePath(...)");     // Catch: Throwable -> L16 Exception -> L18
        if (((Number) ZeusTransformUtils.preCheckCast(r10.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue() < ((Number) ZeusTransformUtils.preCheckCast(r10.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue()) goto L13;
        boolean r15 = true;
    L15:
        r4 = new b(r6, r15);     // Catch: Throwable -> L16 Exception -> L18
        goto L29
    L13:
        r15 = false;
    L16:
        th = move-exception;
        r14.close();
        throw th;
    L18:
        e = move-exception;
        r3.delete();     // Catch: Throwable -> L16
        RunLog.INSTANCE.error("ScreenshotManager", "takeHeifScreenshot failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
    L24:
        e = move-exception;
        RunLog.INSTANCE.error("ScreenshotManager", "open heif file failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private final String a(AccessibilityRuleStatus r9, ScreenshotOption r10, AccessibilityNodeInfo r11) {
        int r8 = c.f12786a[r10.getCacheStrategy().getStrategy().ordinal()];
        boolean r0 = true;
        if (r8 != 1) goto L5;
        int r12 = r9.hashCode();
    L28:
        return Integer.toHexString(r12);
    L5:
        if (r8 != 2) goto L7;
        r12 = r11.hashCode();
        goto L28
    L7:
        if (r8 == 3) goto L9;
        return null;
    L9:
        String r13 = r10.getCacheStrategy().getUniqueNodeViewId();
        if (r13 != null) goto L12;
    L17:
        r0 = false;
    L18:
        if (r0 == false) goto L24;
        String r14 = r11.getPackageName() + ":id/" + r10.getCacheStrategy().getUniqueNodeViewId();
        List<AccessibilityNodeInfo> r15 = r11.findAccessibilityNodeInfosByViewId(r14);
        Intrinsics.checkNotNullExpressionValue(r15, "findAccessibilityNodeInfosByViewId(...)");
        AccessibilityNodeInfo r16 = (AccessibilityNodeInfo) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r15), AccessibilityNodeInfo.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L23;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenshotManager", "not found view id " + r14, null, 4, null);
        return null;
    L23:
        return Integer.toHexString(r16.hashCode());
    L24:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenshotManager", "invalid uniqueNodeViewId", null, 4, null);
        return null;
    L12:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L14;
        boolean r17 = true;
    L15:
        if (r17 != true) goto L17;
    L14:
        r17 = false;
        goto L15
    }

    private static final kotlinx.coroutines.sync.a a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return kotlinx.coroutines.sync.c.a(false, 1, null);
    }

    private static final kotlinx.coroutines.sync.a a(Function1 r2, Object r3) {
        return (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
    }

    private final synchronized void a() {
        monitor-enter(this);
        y.a(null, $$Lambda$e$ibVx3_1_SC26HEyLKwqZ72FuI8A.INSTANCE, 1, null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final Pair<Integer, Integer> b(ScreenshotOption r4, HeifOutputOption r5) {
        if (r5.getOutputWidth() > 0) goto L5;
    L7:
        Pair<Integer, Integer> r6 = com.obric.memorydata.utils.e.a.f13206a.c();
        if (r6 != null) goto L11;
        r6 = d;
    L11:
        if (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getConfiguration().orientation != 2) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == false) goto L16;
        r6 = TuplesKt.to(r6.getSecond(), r6.getFirst());
    L16:
        Pair r7 = TuplesKt.to(Integer.valueOf((int) (((Number) ZeusTransformUtils.preCheckCast(r6.getFirst(), Number.class, "com.obric.memorydata.plugin")).floatValue() * r4.getScale())), Integer.valueOf((int) (((Number) ZeusTransformUtils.preCheckCast(r6.getSecond(), Number.class, "com.obric.memorydata.plugin")).floatValue() * r4.getScale())));
    L18:
        return TuplesKt.to(Integer.valueOf(a(((Number) ZeusTransformUtils.preCheckCast(r7.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue())), Integer.valueOf(a(((Number) ZeusTransformUtils.preCheckCast(r7.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue())));
    L13:
        r0 = false;
        goto L14
    L5:
        if (r5.getOutputHeight() <= 0) goto L7;
        r7 = TuplesKt.to(Integer.valueOf(r5.getOutputWidth()), Integer.valueOf(r5.getOutputHeight()));
        goto L18
    }

    private static final Unit b() {
        long r0 = System.currentTimeMillis();
        Set<Map.Entry<String, SoftReference<a>>> r2 = f12781b.entrySet();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-entries>(...)");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L16;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r5 = r4.getKey();
        Intrinsics.checkNotNullExpressionValue(r5, "<get-key>(...)");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        a r7 = (a) ZeusTransformUtils.preCheckCast(((SoftReference) ZeusTransformUtils.preCheckCast(r4.getValue(), SoftReference.class, "com.obric.memorydata.plugin")).get(), a.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L7;
        if ((r0 - r7.b()) < 180000) goto L12;
        boolean r8 = true;
    L13:
        if (r8 == false) goto L4;
        f12781b.remove(r6);
        RunLog r9 = RunLog.INSTANCE;
        StringBuilder r10 = new StringBuilder();
        String r11 = "expired cache cleared (>5min or recycled), key ";
    L8:
        r9.debug("ScreenshotManager", r10.append(r11).append(r6).toString());
        goto L4
    L12:
        r8 = false;
        goto L13
    L7:
        f12781b.remove(r6);
        r9 = RunLog.INSTANCE;
        r10 = new StringBuilder();
        r11 = "cache reference cleared, remove key ";
        goto L8
    L16:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$KbIq2cN5uJBjB-mGzJiC06c1GwE, reason: not valid java name */
    public static /* synthetic */ kotlinx.coroutines.sync.a m1171lambda$KbIq2cN5uJBjBmGzJiC06c1GwE(String r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$ibVx3_1_SC26HEyLKwqZ72FuI8A() {
        return b();
    }

    /* JADX INFO: renamed from: lambda$z6gwyEJWqOH-yXzBybiFcKeFyiU, reason: not valid java name */
    public static /* synthetic */ kotlinx.coroutines.sync.a m1172lambda$z6gwyEJWqOHyXzBybiFcKeFyiU(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public final Object a(AccessibilityRuleStatus r19, AccessibilityNodeInfo r20, ScreenshotOption r21, Continuation<? super Unit> r22) {
        AccessibilityNodeInfo r1 = r20;
        ScreenshotOption r2 = r21;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r22, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, ScreenshotManager$generateScreenshotForNode$1.class) == false) goto L7;
        ScreenshotManager$generateScreenshotForNode$1 r5 = (ScreenshotManager$generateScreenshotForNode$1) ZeusTransformUtils.preCheckCast(r3, ScreenshotManager$generateScreenshotForNode$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L20;
        if (r7 == 1) goto L19;
        if (r7 != 2) goto L18;
        long r0 = r5.J$0;
        kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r5.L$1, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L15
    L49:
        if (r4 == null) goto L51;
        ((Map) ZeusTransformUtils.preCheckCast(f12781b, Map.class, "com.obric.memorydata.plugin")).put(r9, new SoftReference(new a(r4, r0)));     // Catch: Throwable -> L15
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L51:
        kotlinx.coroutines.sync.a r11 = r8;
    L52:
        r11.b(null);
        return Unit.INSTANCE;
    L15:
        th = th;
    L56:
        r8.b(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r12 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r5.L$3, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        String r13 = (String) ZeusTransformUtils.preCheckCast(r5.L$2, String.class, "com.obric.memorydata.plugin");
        r2 = (ScreenshotOption) ZeusTransformUtils.preCheckCast(r5.L$1, ScreenshotOption.class, "com.obric.memorydata.plugin");
        AccessibilityNodeInfo r14 = (AccessibilityNodeInfo) ZeusTransformUtils.preCheckCast(r5.L$0, AccessibilityNodeInfo.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r11 = r12;
        String r15 = r13;
        r1 = r14;
    L60:
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L54
        ConcurrentHashMap<String, SoftReference<a>> r17 = f12781b;     // Catch: Throwable -> L54
        SoftReference r18 = (SoftReference) ZeusTransformUtils.preCheckCast(r17.get(r15), SoftReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
        if (r18 == null) goto L34;
        a r23 = (a) ZeusTransformUtils.preCheckCast(r18.get(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L54
    L37:
        if (r2.getCacheStrategy().getStrategy() == CacheStrategy.NO_CACHE) goto L43;
        if (r23 == null) goto L43;
        if ((r16 - r23.b()) >= 180000) goto L43;
        RunLog.INSTANCE.debug("ScreenshotManager", "has cache for key " + r15);     // Catch: Throwable -> L54
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L54
    L43:
        if (r2.getCacheStrategy().getStrategy() != CacheStrategy.NO_CACHE) goto L45;
        r17.remove(r15);     // Catch: Throwable -> L54
    L45:
        RunLog.INSTANCE.debug("ScreenshotManager", "takeScreenshot for key " + r15 + " option = " + r2);     // Catch: Throwable -> L54
        e r25 = f12780a;     // Catch: Throwable -> L54
        String r26 = r1.getPackageName().toString();     // Catch: Throwable -> L54
        r5.L$0 = r15;     // Catch: Throwable -> L54
        r5.L$1 = r11;     // Catch: Throwable -> L54
        r5.L$2 = null;     // Catch: Throwable -> L54
        r5.L$3 = null;     // Catch: Throwable -> L54
        r5.J$0 = r16;     // Catch: Throwable -> L54
        r5.label = 2;     // Catch: Throwable -> L54
        Object r27 = r25.a(r2, r26, r5);     // Catch: Throwable -> L54
        if (r27 != r6) goto L48;
        return r6;
    L48:
        r9 = r15;
        r8 = r11;
        r4 = r27;
        r0 = r16;
        goto L49
    L34:
        r23 = null;
    L54:
        th = th;
        r8 = r11;
        goto L56
    L20:
        ResultKt.throwOnFailure(r4);
        if (r1 == null) goto L23;
        a();
        r15 = a(r19, r2, r1);
        if (r15 == null) goto L27;
        ConcurrentHashMap<String, kotlinx.coroutines.sync.a> r28 = c;
        final $$Lambda$e$KbIq2cN5uJBjBmGzJiC06c1GwE r29 = $$Lambda$e$KbIq2cN5uJBjBmGzJiC06c1GwE.INSTANCE;
        kotlinx.coroutines.sync.a r30 = r28.computeIfAbsent(r15, new $$Lambda$e$z6gwyEJWqOHyXzBybiFcKeFyiU(r29));
        Intrinsics.checkNotNullExpressionValue(r30, "computeIfAbsent(...)");
        r11 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(r30, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        r5.L$0 = r1;
        r5.L$1 = r2;
        r5.L$2 = r15;
        r5.L$3 = r11;
        r5.label = 1;
        if (r11.a(null, r5) != r6) goto L60;
        return r6;
    L27:
        return Unit.INSTANCE;
    L23:
        return Unit.INSTANCE;
    L7:
        r5 = new ScreenshotManager$generateScreenshotForNode$1(this, r3);
        goto L8
    }

    public final Object a(ScreenshotOption r10, String r11, Continuation<Object> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, ScreenshotManager$takeScreenshot$1.class) == false) goto L7;
        ScreenshotManager$takeScreenshot$1 r0 = (ScreenshotManager$takeScreenshot$1) ZeusTransformUtils.preCheckCast(r13, ScreenshotManager$takeScreenshot$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = true;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        String r15 = (String) ZeusTransformUtils.preCheckCast(r0.L$1, String.class, "com.obric.memorydata.plugin");
        ScreenshotOption r16 = (ScreenshotOption) ZeusTransformUtils.preCheckCast(r0.L$0, ScreenshotOption.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
        r11 = r15;
        r10 = r16;
    L19:
        HeifOutputOption r17 = r10.getHeifOutput();
        if (r17 == null) goto L24;
        RunLog.INSTANCE.debug("ScreenshotManager", "takeScreenshot direct HEIF for " + r11);
        return f12780a.a(r10, r17);
    L24:
        if (r10.getOnlyAppWindow() == false) goto L35;
        RunLog.INSTANCE.debug("ScreenshotManager", "takeScreenshot onlyAppWindow for " + r11);
        Bitmap r18 = com.obric.memorydata.utils.e.c.f13216a.b(r11, r10.getExcludeLayerPackages());
        if (r18 != null) goto L29;
        return null;
    L29:
        if (r10.getScale() == 1.0f) goto L32;
        r3 = false;
    L32:
        if (r3 == false) goto L34;
        return r18;
    L34:
        return x.f13267a.a(r18, r10.getScale());
    L35:
        RunLog.INSTANCE.debug("ScreenshotManager", "takeScreenshot full screen");
        List<String> r19 = r10.getExcludeLayerPackages();
        if (r19 != null) goto L38;
    L40:
        boolean r20 = false;
    L41:
        if (r20 == false) goto L53;
        Bitmap r21 = com.obric.memorydata.utils.e.c.f13216a.b(r11, r10.getExcludeLayerPackages());
        if (r21 != null) goto L46;
        return null;
    L46:
        if (r10.getScale() == 1.0f) goto L49;
        r3 = false;
    L49:
        if (r3 == false) goto L51;
        return r21;
    L51:
        return x.f13267a.a(r21, r10.getScale());
    L53:
        if (r10.getUseHardwareBuffer() == false) goto L57;
        return com.obric.memorydata.utils.e.b.f13208a.a(r10.getScale(), true).getSecond();
    L57:
        return com.obric.memorydata.utils.e.b.f13208a.a(r10.getScale());
    L38:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r19, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) != true) goto L40;
        r20 = true;
        goto L41
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        if (r10.getDelay() <= 0) goto L19;
        long r4 = r10.getDelay();
        r0.L$0 = r10;
        r0.L$1 = r11;
        r0.label = 1;
        if (au.a(r4, r0) != r14) goto L19;
        return r14;
    L7:
        r0 = new ScreenshotManager$takeScreenshot$1(this, r13);
        goto L8
    }

    public final void a(AccessibilityRuleStatus r2, AccessibilityNodeInfo r3, ScreenshotOption r4) {
        Intrinsics.checkNotNullParameter(r2, "ruleStatus");
        Intrinsics.checkNotNullParameter(r4, "screenshotOption");
        if (r3 != null) goto L5;
        return;
    L5:
        String r1 = a(r2, r4, r3);
        if (r1 != null) goto L8;
        return;
    L8:
        f12781b.remove(r1);
        RunLog.INSTANCE.debug("ScreenshotManager", "cache reference cleared, remove key " + r1);
    }

    public final Object b(AccessibilityRuleStatus r2, AccessibilityNodeInfo r3, ScreenshotOption r4) {
        Intrinsics.checkNotNullParameter(r2, "ruleStatus");
        Intrinsics.checkNotNullParameter(r4, "screenshotOption");
        if (r3 != null) goto L5;
        return null;
    L5:
        String r1 = a(r2, r4, r3);
        if (r1 != null) goto L8;
        return null;
    L8:
        SoftReference r5 = (SoftReference) ZeusTransformUtils.preCheckCast(f12781b.get(r1), SoftReference.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L14;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5.get(), a.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L13;
        return null;
    L13:
        return r6.a();
    L14:
        return null;
    }
}
