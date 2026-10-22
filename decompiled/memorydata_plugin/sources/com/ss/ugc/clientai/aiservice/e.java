package com.ss.ugc.clientai.aiservice;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H$J\b\u0010\u0018\u001a\u00020\u0004H$J\b\u0010\u0019\u001a\u00020\u0015H$J\u000e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\tH\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ss/ugc/clientai/aiservice/BaseAIEngine;", "Lcom/ss/ugc/clientai/aiservice/AIEngine;", "()V", "isStarted", "", "()Z", "setStarted", "(Z)V", "lastResult", "Lcom/ss/ugc/clientai/aiservice/AIPredictResult;", "getLastResult", "()Lcom/ss/ugc/clientai/aiservice/AIPredictResult;", "setLastResult", "(Lcom/ss/ugc/clientai/aiservice/AIPredictResult;)V", "listener", "Lcom/ss/ugc/clientai/aiservice/OnAIEngineListener;", "getListener", "()Lcom/ss/ugc/clientai/aiservice/OnAIEngineListener;", "setListener", "(Lcom/ss/ugc/clientai/aiservice/OnAIEngineListener;)V", "doFeed", "", "input", "Lcom/ss/ugc/clientai/aiservice/AIPredictInput;", "doStart", "doStop", "feed", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "updatePredictResult", "result", "AIEngineFeeder", "service-ohr_release"}, k = 1, mv = {1, 4, 1})
public abstract class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f15782b;
    private d c;

    public e() {
        this.c = new d(d.f15779a.a());
    }

    public abstract void a();

    public abstract void a(c r1);

    public void a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c = r2;
    }

    @Override // com.ss.ugc.clientai.aiservice.a
    public void a(f r3) {
        this.f15782b = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");
    }

    public void a(boolean r1) {
        this.f15781a = r1;
    }

    @Override // com.ss.ugc.clientai.aiservice.a
    public final void b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        if (e() == true) goto L5;
        return;
    L5:
        a(r2);
    }

    public final void b(d r2) {
        Intrinsics.checkNotNullParameter(r2, "result");
        a(r2);
        f r1 = f();
        if (r1 == null) goto L6;
        r1.a(r2);
        return;
    }

    public abstract boolean b();

    @Override // com.ss.ugc.clientai.aiservice.a
    public final void c() {
        if (e() == false) goto L5;
        return;
    L5:
        a(b());
    }

    @Override // com.ss.ugc.clientai.aiservice.a
    public final void d() {
        if (e() == true) goto L5;
        return;
    L5:
        a(false);
        a();
    }

    @Override // com.ss.ugc.clientai.aiservice.a
    public boolean e() {
        return this.f15781a;
    }

    public f f() {
        return this.f15782b;
    }
}
