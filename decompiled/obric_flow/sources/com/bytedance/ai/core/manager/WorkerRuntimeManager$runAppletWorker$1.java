package com.bytedance.ai.core.manager;

import com.bytedance.ai.core.base.SessionType;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager", f = "WorkerRuntimeManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {368, 100, 119}, m = "runAppletWorker", n = {"this", "appletId", "application", "conversationId", "botId", "msgId", "replyFor", "sessionType", "traceInfo", "$this$withLock_u24default$iv", "this", "appletId", "application", "conversationId", "botId", "msgId", "replyFor", "sessionType", "traceInfo", "$this$withLock_u24default$iv", "runtime", "deferred", "existingDeferred", "this", "appletId", "$this$withLock_u24default$iv", "runtime", "deferred"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$0", "L$1", "L$2", "L$3", "L$4"})
final class WorkerRuntimeManager$runAppletWorker$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f2097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f2099c;
    public Serializable d;
    public Object e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SessionType f2100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map f2101i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public kotlinx.coroutines.sync.a f2102j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Ref.ObjectRef f2103k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public r f2104l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public r f2105m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public /* synthetic */ Object f2106n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ b f2107o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f2108p;

    public WorkerRuntimeManager$runAppletWorker$1(b r5, ContinuationImpl r10) {
        this.f2107o = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        this.f2106n = r11;
        this.f2108p |= Integer.MIN_VALUE;
        return this.f2107o.b(null, null, null, null, null, null, null, null, this);
    }
}
