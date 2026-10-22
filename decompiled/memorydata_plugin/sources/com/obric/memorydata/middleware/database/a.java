package com.obric.memorydata.middleware.database;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/middleware/database/CommonDatabaseIsolationUtil;", "Lcom/obric/memorydata/middleware/database/IDatabaseIsolationUtil;", "instanceName", "", "<init>", "(Ljava/lang/String;)V", "personalDatabaseSet", "", "getCachedProfile", "Lcom/obric/memorydata/middleware/database/PersonalDbSplitProfile;", "hasValidLiveProfile", "", "registerPersonalDatabase", "", "dbLogicName", "getRealDatabaseName", "logicName", "getLiveRealDatabaseName", "isPersonalDatabase", "toRealDatabaseName", "profileId", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0623a f11644a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11645b;
    private final Set<String> c;

    /* JADX INFO: renamed from: com.obric.memorydata.middleware.database.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/middleware/database/CommonDatabaseIsolationUtil$Companion;", "", "<init>", "()V", "TAG", "", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0623a {
        private C0623a() {
        }

        public /* synthetic */ C0623a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11644a = new C0623a(null);
    }

    public a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "instanceName");
        this.f11645b = r3;
        this.c = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
    }

    private final String a(String r5, String r6) {
        String r4 = ".db";
        boolean r0 = StringsKt.endsWith$default(r5, ".db", false, 2, null);
        StringBuilder r7 = new StringBuilder().append(StringsKt.removeSuffix(r5, (CharSequence) ZeusTransformUtils.preCheckCast(".db", CharSequence.class, "com.obric.memorydata.plugin"))).append('_').append(r6);
        if (r0 == true) goto L7;
        r4 = "";
    L7:
        return r7.append(r4).toString();
    }

    private final boolean d(String r2) {
        Set<String> r0 = this.c;
        monitor-enter(r0);
        boolean r1 = this.c.contains(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public i a() {
        return j.f11664a.a();
    }

    public void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "dbLogicName");
        Set<String> r0 = this.c;
        monitor-enter(r0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "db_iso_DatabaseIsolationUtil", "registerPersonalDatabase instance=" + this.f11645b + ", dbLogicName=" + r10 + ", added=" + this.c.add(r10) + ", registeredCount=" + this.c.size(), false, 4, null);     // Catch: Throwable -> L7
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public String b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "logicName");
        if (d(r5) == true) goto L5;
        return r5;
    L5:
        i r0 = a();
        if (r0.c() == false) goto L9;
        DatabaseIsolationTracker.f11642a.a(this.f11645b, r5, r0.b());
    L9:
        return a(r5, r0.a());
    }

    public boolean b() {
        return !j.f11664a.b().c();
    }

    public String c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "logicName");
        if (d(r2) == true) goto L6;
        return r2;
    L6:
        return a(r2, j.f11664a.b().a());
    }
}
