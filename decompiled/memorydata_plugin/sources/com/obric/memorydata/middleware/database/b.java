package com.obric.memorydata.middleware.database;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0096\u0001¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/middleware/database/DatabaseIsolationUtil;", "Lcom/obric/memorydata/middleware/database/IDatabaseIsolationUtil;", "<init>", "()V", "getCachedProfile", "Lcom/obric/memorydata/middleware/database/PersonalDbSplitProfile;", "getLiveRealDatabaseName", "", "logicName", "getRealDatabaseName", "hasValidLiveProfile", "", "registerPersonalDatabase", "", "dbLogicName", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f11646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ a f11647b;

    static {
        f11646a = new b();
    }

    private b() {
        this.f11647b = new a("DatabaseIsolationUtil");
    }

    public i a() {
        return this.f11647b.a();
    }

    public void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dbLogicName");
        this.f11647b.a(r2);
    }

    public String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "logicName");
        return this.f11647b.b(r2);
    }

    public boolean b() {
        return this.f11647b.b();
    }

    public String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "logicName");
        return this.f11647b.c(r2);
    }
}
