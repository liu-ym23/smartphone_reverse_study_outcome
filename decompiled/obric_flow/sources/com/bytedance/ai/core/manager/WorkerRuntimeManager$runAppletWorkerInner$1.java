package com.bytedance.ai.core.manager;

import android.content.Context;
import com.bytedance.ai.core.base.SessionType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.core.manager.WorkerRuntimeManager", f = "WorkerRuntimeManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {184}, m = "runAppletWorkerInner", n = {"this", "appletId", "application", "conversationId", "botId", "msgId", "replyFor", "sessionType", "traceInfo", "runtime", "traceId", "eventType", "startTime", "loadStartTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "J$0", "J$1"})
final class WorkerRuntimeManager$runAppletWorkerInner$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f2122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f2124c;
    public String d;
    public String e;
    public String f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SessionType f2125h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map f2126i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Ref.ObjectRef f2127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f2128k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f2129l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f2130m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f2131n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f2132o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final /* synthetic */ b f2133p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f2134q;

    public WorkerRuntimeManager$runAppletWorkerInner$1(b r5, ContinuationImpl r10) {
        this.f2133p = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        this.f2132o = r11;
        this.f2134q |= Integer.MIN_VALUE;
        return b.a(this.f2133p, null, null, null, null, null, null, null, null, this);
    }
}
