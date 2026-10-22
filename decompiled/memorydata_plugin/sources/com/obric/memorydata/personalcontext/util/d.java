package com.obric.memorydata.personalcontext.util;

import android.util.LruCache;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0012\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005J$\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J \u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006("}, d2 = {"Lcom/obric/memorydata/personalcontext/util/EmbeddingToVector;", "", "<init>", "()V", "TAG", "", "TEXT_EMBEDDING_TYPE", "", "CLIP_TEXT_EMBEDDING_TYPE", "VLM_TEXT_EMBEDDING_TYPE", "INSTRUCTION_TEXT", "textVlmLock", "Ljava/util/concurrent/locks/ReentrantLock;", "MEM_CACHE_MAX_SIZE", "MEM_CACHE_TTL_MS", "", "cacheLock", "embeddingMemCache", "com/obric/memorydata/personalcontext/util/EmbeddingToVector$embeddingMemCache$1", "Lcom/obric/memorydata/personalcontext/util/EmbeddingToVector$embeddingMemCache$1;", "textEmbeddingToVector", "", ChatMessage.TYPE_QUERY, "useVlm", "", "foregroundCallerPkg", "clipTextEmbeddingToVector", "textEmbeddingToVectorByVlm", "textEmbeddingToVectorByModel", "clipTextEmbeddingToVectorByModel", "queryEmbeddingVectorFromCache", "type", "insertEmbeddingVectorToCache", "", "vector", "cacheKey", "fromFloatArray", EventBody.KEY_VALUE, "toFloatArray", "CacheValue", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f12365a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ReentrantLock f12366b = null;
    private static final Object c = null;
    private static final b d = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/EmbeddingToVector$CacheValue;", "", "vector", "", "cachedAtMs", "", "<init>", "([FJ)V", "getVector", "()[F", "getCachedAtMs", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float[] f12367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12368b;

        public a(float[] r2, long r3) {
            Intrinsics.checkNotNullParameter(r2, "vector");
            this.f12367a = r2;
            this.f12368b = r3;
        }

        public final float[] a() {
            return this.f12367a;
        }

        public final long b() {
            return this.f12368b;
        }

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12367a, r8.f12367a) == true) goto L12;
            return false;
        L12:
            if (this.f12368b == r8.f12368b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f12367a) * 31) + Long.hashCode(this.f12368b);
        }

        public String toString() {
            return "CacheValue(vector=" + Arrays.toString(this.f12367a) + ", cachedAtMs=" + this.f12368b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"com/obric/memorydata/personalcontext/util/EmbeddingToVector$embeddingMemCache$1", "Landroid/util/LruCache;", "", "Lcom/obric/memorydata/personalcontext/util/EmbeddingToVector$CacheValue;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends LruCache<String, a> {
        b() {
            super(30);
        }
    }

    static {
        f12365a = new d();
        f12366b = new ReentrantLock(true);
        c = new Object();
        d = new b();
    }

    private d() {
    }

    private final void a(String r5, int r6, float[] r7) {
        long r0 = System.currentTimeMillis();
        String r4 = b(r5, r6);
        Object r8 = c;
        monitor-enter(r8);
        b r9 = d;     // Catch: Throwable -> L7
        float[] r10 = Arrays.copyOf(r7, r7.length);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r10, "copyOf(...)");     // Catch: Throwable -> L7
        a r11 = (a) ZeusTransformUtils.preCheckCast(r9.put(r4, new a(r10, r0)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r8);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ float[] a(d r0, String r1, boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = null;
    L6:
        return r0.b(r1, r2, r3);
    }

    private final float[] a(String r7, int r8) {
        long r0 = System.currentTimeMillis();
        String r6 = b(r7, r8);
        Object r9 = c;
        monitor-enter(r9);
        b r10 = d;     // Catch: Throwable -> L17
        a r2 = (a) ZeusTransformUtils.preCheckCast(r10.get(r6), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r2 != null) goto L10;
        monitor-exit(r9);
        return null;
    L10:
        if ((r0 - r2.b()) <= 600000) goto L14;
        r10.remove(r6);     // Catch: Throwable -> L17
        monitor-exit(r9);
        return null;
    L14:
        float[] r11 = r2.a();     // Catch: Throwable -> L17
        float[] r12 = Arrays.copyOf(r11, r11.length);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r12, "copyOf(...)");     // Catch: Throwable -> L17
        monitor-exit(r9);
        return r12;
    L17:
        th = move-exception;
        throw th;
    }

    private final float[] a(String r21, String r22) {
        long r4 = System.currentTimeMillis();
        float[] r7 = a(r21, 3);
        if (r7 == null) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EmbeddingToVector", "textEmbeddingToVectorByVlm query from memory cache success, cost: " + (System.currentTimeMillis() - r4) + "ms", false, 4, null);
    L6:
        if (r7 == null) goto L8;
        return r7;
    L8:
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(r22, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L11;
    L14:
        boolean r13 = true;
    L15:
        if (r13 == true) goto L34;
        ReentrantLock r14 = f12366b;
        r14.lock();
        float[] r0 = a(r21, 3);     // Catch: Throwable -> L31
        if (r0 == null) goto L21;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EmbeddingToVector", "textEmbeddingToVectorByVlm query from memory cache success, cost: " + (System.currentTimeMillis() - r4) + "ms", false, 4, null);     // Catch: Throwable -> L31
        r7 = r0;
    L21:
        if (r7 == null) goto L24;
        r14.unlock();
        return r7;
    L24:
        float[] r1 = (float[]) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EmbeddingToVector$textEmbeddingToVectorByVlm$realTimeVector$1(r21, r22, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), float[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r1 == null) goto L27;
        r7 = r1;
    L27:
        if (r1 == null) goto L29;
        f12365a.a(r21, 3, r1);     // Catch: Throwable -> L31
    L29:
        r14.unlock();
        return r7;
    L31:
        th = move-exception;
        f12366b.unlock();
        throw th;
    L34:
        float[] r2 = (float[]) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EmbeddingToVector$textEmbeddingToVectorByVlm$realTimeVector$2(r21, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), float[].class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L37;
        return r7;
    L37:
        return r2;
    L11:
        if (r12.length() == 0) goto L14;
        r13 = false;
        goto L15
    L5:
        r7 = null;
        goto L6
    }

    private final String b(String r1, int r2) {
        return r2 + '|' + r1;
    }

    private final float[] b(String r13, String r14) {
        long r0 = System.currentTimeMillis();
        float[] r12 = a(r13, 1);
        if (r12 == null) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EmbeddingToVector", "textEmbeddingToVectorByModel query from memory cache success, cost: " + (System.currentTimeMillis() - r0) + "ms", false, 4, null);
    L6:
        if (r12 == null) goto L8;
        return r12;
    L8:
        float[] r15 = (float[]) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EmbeddingToVector$textEmbeddingToVectorByModel$realTimeVector$1(r13, r14, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), float[].class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L11;
        r12 = r15;
    L11:
        if (r15 == null) goto L13;
        f12365a.a(r13, 1, r15);
    L13:
        return r12;
    L5:
        r12 = null;
        goto L6
    }

    private final float[] c(String r13, String r14) {
        long r0 = System.currentTimeMillis();
        float[] r12 = a(r13, 2);
        if (r12 == null) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EmbeddingToVector", "clipTextEmbeddingToVectorByModel query from memory cache success, cost: " + (System.currentTimeMillis() - r0) + "ms", false, 4, null);
    L6:
        if (r12 == null) goto L8;
        return r12;
    L8:
        float[] r15 = (float[]) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new EmbeddingToVector$clipTextEmbeddingToVectorByModel$realTimeVector$1(r13, r14, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), float[].class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L11;
        r12 = r15;
    L11:
        if (r15 == null) goto L13;
        f12365a.a(r13, 2, r15);
    L13:
        return r12;
    L5:
        r12 = null;
        goto L6
    }

    public final float[] a(String r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, ChatMessage.TYPE_QUERY);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EmbeddingToVector", "textEmbeddingToVector query is empty", null, 4, null);
        return null;
    L10:
        if (r11 == false) goto L19;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L14;
    L17:
        return null;
    L14:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L17;
        return a("生成和以下描述相近的文字和图片：" + r10, r12);
    L19:
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L22;
        return null;
    L22:
        return b(r10, r12);
    L5:
        r0 = false;
        goto L7
    }

    public final float[] b(String r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, ChatMessage.TYPE_QUERY);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "EmbeddingToVector", "clipTextEmbeddingToVector query is empty", null, 4, null);
        return null;
    L10:
        if (r11 == false) goto L19;
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L14;
    L17:
        return null;
    L14:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L17;
        return a("生成和以下描述相近的文字和图片：" + r10, r12);
    L19:
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L22;
        return null;
    L22:
        return c(r10, r12);
    L5:
        r0 = false;
        goto L7
    }
}
