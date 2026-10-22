package com.obric.memorydata.database.account_split;

import com.obric.memorydata.database.dao.BaseDao;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\b&\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/database/account_split/PersonalDbSplitTableSpec;", "", "<init>", "()V", "sourceDao", "Lcom/obric/memorydata/database/dao/BaseDao;", "getSourceDao", "()Lcom/obric/memorydata/database/dao/BaseDao;", "targetDao", "getTargetDao", "sourceTableName", "", "getSourceTableName", "()Ljava/lang/String;", "targetTableName", "getTargetTableName", "migrationMarkColumn", "getMigrationMarkColumn", "excludedCopyColumns", "", "getExcludedCopyColumns", "()Ljava/util/Set;", "targetToSourceColumnMappings", "", "getTargetToSourceColumnMappings", "()Ljava/util/Map;", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f8836b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8837a;
    private final Set<String> c;
    private final Map<String, String> d;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/account_split/PersonalDbSplitTableSpec$Companion;", "", "<init>", "()V", "DEFAULT_MIGRATION_MARK_COLUMN", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8836b = new a(null);
    }

    public x() {
        this.f8837a = "personalDbSplitMigrated";
        this.c = SetsKt.setOf("personalDbSplitMigrated");
        this.d = MapsKt.emptyMap();
    }

    public abstract BaseDao<?> e();

    public abstract BaseDao<?> f();

    public String h_() {
        return this.f8837a;
    }

    public final String i() {
        return e().getTableName();
    }

    public final String j() {
        return f().getTableName();
    }

    public Set<String> k() {
        return this.c;
    }

    public Map<String, String> l() {
        return this.d;
    }
}
