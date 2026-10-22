package com.obric.memorydata.personalcontext.util;

import com.obric.memorydata.database.index.t;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/util/EmbeddingStateUtil;", "", "<init>", "()V", "TAG", "", "VLM", "LITTLE_MODEL", "cachedVEmbeddingState", "Lcom/obric/memorydata/personalcontext/util/EmbeddingState;", "lock", "Ljava/util/concurrent/locks/Lock;", "canUseVlmEmbedding", "", "getEmbeddingState", "getEmbeddingTypeForQuery", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12363a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile EmbeddingState f12364b;
    private static final Lock c = null;

    static {
        f12363a = new c();
        c = (Lock) ZeusTransformUtils.preCheckCast(new ReentrantLock(), Lock.class, "com.obric.memorydata.plugin");
    }

    private c() {
    }

    public final boolean a() {
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L5;
        return false;
    L5:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L8;
        return false;
    L8:
        return DeviceInfoState.INSTANCE.isSupportVLMEmbedding();
    }

    public final EmbeddingState b() {
        EmbeddingState r0 = f12364b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Lock r1 = c;
        r1.lock();
        EmbeddingState r2 = f12364b;     // Catch: Throwable -> L18
        if (r2 == null) goto L10;
        r1.unlock();
        return r2;
    L10:
        boolean r3 = a();     // Catch: Throwable -> L18
        boolean r4 = t.f9438a.c();     // Catch: Throwable -> L18
        if (r3 == true) goto L13;
        f12364b = EmbeddingState.USE_LITTLE_MODEL;     // Catch: Throwable -> L18
        EmbeddingState r5 = EmbeddingState.USE_LITTLE_MODEL;     // Catch: Throwable -> L18
    L16:
        r1.unlock();
        return r5;
    L13:
        if (r4 == false) goto L15;
        f12364b = EmbeddingState.USE_VLM;     // Catch: Throwable -> L18
        r5 = EmbeddingState.USE_VLM;     // Catch: Throwable -> L18
        goto L16
    L15:
        r5 = EmbeddingState.USE_VLM_AND_LITTLE_MODEL;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        c.unlock();
        throw th;
    }

    public final String c() {
        if (b() != EmbeddingState.USE_VLM) goto L5;
        return "vlm";
    L5:
        return "little_model";
    }
}
