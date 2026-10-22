package com.bytedance.ai.ex.widget;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/ex/widget/LogAdapter;", "", "<init>", "()V", "Lcom/bytedance/ai/ex/widget/LogProxy;", "impl", "Lcom/bytedance/ai/ex/widget/LogProxy;", "getImpl", "()Lcom/bytedance/ai/ex/widget/LogProxy;", "setImpl", "(Lcom/bytedance/ai/ex/widget/LogProxy;)V", "Ltl/a;", "ivyLog", "Ltl/a;", "getIvyLog", "()Ltl/a;", "Lt0/d;", "aisdkLog", "Lt0/d;", "getAisdkLog", "()Lt0/d;", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LogAdapter {
    public static final LogAdapter INSTANCE = null;
    private static final t0.d aisdkLog = null;
    private static LogProxy impl;
    private static final tl.a ivyLog = null;

    static {
        INSTANCE = new LogAdapter();
        ivyLog = new LogAdapter$ivyLog$1();
        aisdkLog = new LogAdapter$aisdkLog$1();
    }

    private LogAdapter() {
    }

    public final t0.d getAisdkLog() {
        return aisdkLog;
    }

    public final LogProxy getImpl() {
        return impl;
    }

    public final tl.a getIvyLog() {
        return ivyLog;
    }

    public final void setImpl(LogProxy r5) {
        impl = r5;
    }
}
