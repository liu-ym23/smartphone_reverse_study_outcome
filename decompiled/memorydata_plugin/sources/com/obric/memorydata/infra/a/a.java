package com.obric.memorydata.infra.a;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006RP\u0010\u0004\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/infra/util/SimpleTaskLoggerMap;", "", "<init>", "()V", "sampleLoggerTaskSet", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "kotlin.jvm.PlatformType", "", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "registerSimpleTask", "", "taskName", "isSimpleTask", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9875a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap.KeySetView<String, Boolean> f9876b = null;

    static {
        f9875a = new a();
        f9876b = ConcurrentHashMap.newKeySet();
    }

    private a() {
    }

    public final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskName");
        f9876b.add(r1);
    }

    public final boolean b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "taskName");
        if (AppContext.INSTANCE.isLocalTest() == false) goto L7;
        return false;
    L7:
        return f9876b.contains(r1);
    }
}
