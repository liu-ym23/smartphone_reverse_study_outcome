package com.obric.memorydata.migration.sdk;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationLog;", "", "<init>", "()V", "TAG", "", "i", "", "message", "e", "t", "", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f11981a = null;

    static {
        f11981a = new t();
    }

    private t() {
    }

    public static /* synthetic */ void a(t r0, String r1, Throwable r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.a(r1, r2);
    }

    public final void a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "message");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryDataMigration", r7, false, 4, null);
    }

    public final void a(String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r4, "message");
        RunLog r3 = RunLog.INSTANCE;
        StringBuilder r6 = new StringBuilder().append(r4);
        if (r5 == null) goto L8;
        String r0 = r5.getMessage();
        if (r0 == null) goto L8;
        String r1 = ", err=" + r0;
        if (r1 == null) goto L8;
    L9:
        r3.error("MemoryDataMigration", r6.append(r1).toString(), r5);
        return;
    L8:
        r1 = "";
        goto L9
    }
}
