package com.obric.memorydata.migration.sdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationObserver;", "", "onEvent", "", "event", "Lcom/obric/memorydata/migration/sdk/MigrationEvent;", "Companion", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11982a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f11983b = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/migration/sdk/MigrationObserver$Companion;", "", "<init>", "()V", "None", "Lcom/obric/memorydata/migration/sdk/MigrationObserver;", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f11984a = null;

        static {
            f11984a = new a();
        }

        private a() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        public static final /* synthetic */ void a(p r0) {
            b(r0);
        }

        private static void b(p r1) {
            Intrinsics.checkNotNullParameter(r1, "it");
        }
    }

    static {
        f11982a = a.f11984a;
        f11983b = $$Lambda$ZpM4MxAdQkmK1Yrz3PQQnaa6z7Y.INSTANCE;
    }

    void onEvent(p r1);
}
