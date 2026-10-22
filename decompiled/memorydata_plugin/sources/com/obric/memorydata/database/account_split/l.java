package com.obric.memorydata.database.account_split;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.backup.a.a;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 1*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004:\u000212B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H&¢\u0006\u0002\u0010\u0019J\u0015\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u001cJ6\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u001e\u0010!\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\"J\"\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00010#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010#2\u0006\u0010&\u001a\u00020\u0011J$\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010(2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010(2\u0006\u0010 \u001a\u00020\u0011H\u0002J\u0016\u0010)\u001a\u00020\u001e2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010(H\u0002J\u0015\u0010*\u001a\u00020+2\u0006\u0010\u001b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010/J\u001c\u00100\u001a\b\u0012\u0004\u0012\u00028\u00010#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010#H\u0016R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR6\u0010\u000f\u001a*\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u0010j\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/memorydata/database/account_split/LegacyBackupPersonalDbSplitTableSpec;", "S", "B", "Lcom/obric/memorydata/database/backup/entity/AbstractBackUpDbEntity;", "Lcom/obric/memorydata/database/account_split/PersonalDbSplitTableSpec;", "<init>", "()V", "backupDao", "Lcom/obric/memorydata/database/backup/dao/BackupUserScopedDao;", "getBackupDao", "()Lcom/obric/memorydata/database/backup/dao/BackupUserScopedDao;", "hasIndex", "", "getHasIndex", "()Z", "migrations", "Ljava/util/LinkedHashMap;", "", "Lcom/obric/memorydata/database/account_split/LegacyBackupPersonalDbSplitTableSpec$BackupMigrationConfig;", "Lkotlin/collections/LinkedHashMap;", "sourceEntityToBackupEntity", AILabCheckPermissionTask.KEY_SOURCE, "userId", "", "backupDbVersion", "(Ljava/lang/Object;Ljava/lang/String;I)Lcom/obric/memorydata/database/backup/entity/AbstractBackUpDbEntity;", "backupEntityToSourceEntity", "backup", "(Lcom/obric/memorydata/database/backup/entity/AbstractBackUpDbEntity;)Ljava/lang/Object;", "migrationTo", "", "fromVersion", "toVersion", "migration", "Lkotlin/Function1;", "", "migrateBackupEntitiesToLatest", "backups", "latestDbVersion", "increaseBackupVersion", "", "validateDuplicateIds", "backupEntityToAppEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "(Lcom/obric/memorydata/database/backup/entity/AbstractBackUpDbEntity;)Lcom/obric/capabilitykit/entity/app/AppEntity;", "rawEntityToAppEntity", "raw", "(Ljava/lang/Object;)Lcom/obric/capabilitykit/entity/app/AppEntity;", "filterBackupsBeforeRestore", "Companion", "BackupMigrationConfig", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class l<S, B extends com.obric.memorydata.database.backup.a.a<S>> extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8814a = null;
    private final LinkedHashMap<Integer, a<S>> c;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J!\u0010\u000f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00070\u0006HÆ\u0003J;\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042 \b\u0002\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR)\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/database/account_split/LegacyBackupPersonalDbSplitTableSpec$BackupMigrationConfig;", "S", "", "toVersion", "", "migration", "Lkotlin/Function1;", "", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "getToVersion", "()I", "getMigration", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function1<List<? extends S>, List<S>> f8816b;

        public a(int r3, Function1<? super List<? extends S>, ? extends List<? extends S>> r4) {
            Function1<List<? extends S>, List<S>> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "migration");
            this.f8815a = r3;
            this.f8816b = r5;
        }

        public final int a() {
            return this.f8815a;
        }

        public final Function1<List<? extends S>, List<S>> b() {
            return this.f8816b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f8815a == r6.f8815a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8816b, r6.f8816b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f8815a) * 31) + this.f8816b.hashCode();
        }

        public String toString() {
            return "BackupMigrationConfig(toVersion=" + this.f8815a + ", migration=" + this.f8816b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/account_split/LegacyBackupPersonalDbSplitTableSpec$Companion;", "", "<init>", "()V", "MIN_MIGRATION_VERSION", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0015\u0010\u0002\u001a\u00028\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements Grouping<B, Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f8817a;

        public c(Iterable r3) {
            this.f8817a = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.collections.Grouping
        public Long keyOf(B r2) {
            return Long.valueOf(((com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin")).c());
        }

        @Override // kotlin.collections.Grouping
        public Iterator<B> sourceIterator() {
            return this.f8817a.iterator();
        }
    }

    static {
        f8814a = new b(null);
    }

    public l() {
        this.c = new LinkedHashMap();
    }

    private final Iterable<B> a(Iterable<? extends B> r6, int r7) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r6, Iterable.class, "com.obric.memorydata.plugin");
        boolean r1 = false;
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L7:
        Iterator r8 = r5.iterator();
    L9:
        if (r8.hasNext() == false) goto L6;
        if (((com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r8.next(), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin")).b() < r7) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L9;
    L15:
        if (r1 == false) goto L23;
        Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r10 = r5.iterator();
    L18:
        if (r10.hasNext() == false) goto L21;
        com.obric.memorydata.database.backup.a.a r2 = (com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.database.backup.a.a r4 = r2.a(r2.d(), r2.a(), r7);
        r4.a(r2.c());
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type B of com.obric.memorydata.database.account_split.LegacyBackupPersonalDbSplitTableSpec");
        r9.add(r4);
        goto L18
    L21:
        return (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
    L23:
        throw new IllegalArgumentException(("Invalid default migration target version: " + r7).toString());
    L13:
        r3 = false;
    L6:
        r1 = true;
        goto L15
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private final void a(Iterable<? extends B> r9) {
        Iterable r8 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r8.iterator();
    L3:
        boolean r2 = false;
        if (r11.hasNext() == false) goto L10;
        Object r1 = r11.next();
        if (((com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r1, com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin")).c() <= 0) goto L8;
        r2 = true;
    L8:
        if (r2 == false) goto L3;
        r10.add(r1);
        goto L3
    L10:
        Map r12 = GroupingKt.eachCount((Grouping) ZeusTransformUtils.preCheckCast(new c((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Grouping.class, "com.obric.memorydata.plugin"));
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator r14 = r12.entrySet().iterator();
    L12:
        if (r14.hasNext() == false) goto L19;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Number) ZeusTransformUtils.preCheckCast(r3.getValue(), Number.class, "com.obric.memorydata.plugin")).intValue() <= 1) goto L16;
        boolean r4 = true;
    L17:
        if (r4 == false) goto L12;
        r13.put(r3.getKey(), r3.getValue());
        goto L12
    L16:
        r4 = false;
        goto L17
    L19:
        Set r15 = ((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin")).keySet();
        if (r15.isEmpty() == false) goto L23;
        return;
    L23:
        throw new IllegalArgumentException(("Duplicate backup ids found: " + r15).toString());
    }

    public AppEntity a(B r1) {
        Intrinsics.checkNotNullParameter(r1, "backup");
        throw new IllegalStateException("hasIndex=false".toString());
    }

    public abstract B a(S r1, String r2, int r3);

    public List<B> a(List<? extends B> r2) {
        List<B> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "backups");
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<B> a(List<? extends B> r12, int r13) {
        List<B> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "backups");
        if (r14.isEmpty() == false) goto L5;
    L97:
        return r14;
    L5:
        if (this.c.isEmpty() == true) goto L97;
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r1 = r0.iterator();
    L8:
        int r5 = 76;
        if (r1.hasNext() == false) goto L15;
        com.obric.memorydata.database.backup.a.a r4 = (com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin");
        if (r4.b() == 0) goto L14;
        r5 = r4.b();
    L14:
        r2.add(Integer.valueOf(r5));
        goto L8
    L15:
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r3.hasNext() == false) goto L96;
        int r6 = ((Number) ZeusTransformUtils.preCheckCast(r3.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
    L19:
        if (r3.hasNext() == false) goto L23;
        int r7 = ((Number) ZeusTransformUtils.preCheckCast(r3.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (r6 <= r7) goto L19;
        r6 = r7;
        goto L19
    L23:
        Collection<a<S>> r8 = this.c.values();
        Intrinsics.checkNotNullExpressionValue(r8, "<get-values>(...)");
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r9.hasNext() == false) goto L94;
        int r10 = ((a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.memorydata.plugin")).a();
    L27:
        if (r9.hasNext() == false) goto L31;
        int r11 = ((a) ZeusTransformUtils.preCheckCast(r9.next(), a.class, "com.obric.memorydata.plugin")).a();
        if (r10 >= r11) goto L27;
        r10 = r11;
        goto L27
    L31:
        if (r6 < r10) goto L33;
        return r14;
    L33:
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        if (r15.hasNext() == false) goto L92;
        int r16 = ((com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin")).b();
    L37:
        if (r15.hasNext() == false) goto L41;
        int r17 = ((com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin")).b();
        if (r16 <= r17) goto L37;
        r16 = r17;
        goto L37
    L41:
        if (r16 >= 76) goto L43;
        r16 = 76;
    L43:
        if (r16 >= r13) goto L90;
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L45:
        boolean r21 = false;
        if (r20.hasNext() == false) goto L55;
        Object r22 = r20.next();
        com.obric.memorydata.database.backup.a.a r23 = (com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r22, com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin");
        if (r23.b() != 0) goto L50;
        int r24 = 76;
    L51:
        if (r24 != r16) goto L53;
        r21 = true;
    L53:
        if (r21 == false) goto L45;
        r19.add(r22);
        goto L45
    L50:
        r24 = r23.b();
        goto L51
    L55:
        Set r25 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r25.isEmpty() == true) goto L87;
        a r26 = (a) ZeusTransformUtils.preCheckCast(this.c.get(Integer.valueOf(r16)), a.class, "com.obric.memorydata.plugin");
        if (r26 == null) goto L61;
        int r27 = r26.a();
    L62:
        if (r27 > r13) goto L64;
        r21 = true;
    L64:
        if (r21 == false) goto L89;
        if (r26 == null) goto L79;
        Function1<List<? extends S>, List<S>> r28 = r26.b();
        if (r28 == null) goto L79;
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin");
        Collection r30 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r29, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r31 = r29.iterator();
    L70:
        if (r31.hasNext() == false) goto L72;
        r30.add(((com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r31.next(), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin")).d());
        goto L70
    L72:
        List r32 = (List) ZeusTransformUtils.preCheckCast(r28.invoke((List) ZeusTransformUtils.preCheckCast(r30, List.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
        if (r32 == null) goto L79;
        Iterable r33 = (Iterable) ZeusTransformUtils.preCheckCast(r32, Iterable.class, "com.obric.memorydata.plugin");
        Collection r34 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r33, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r35 = r33.iterator();
    L76:
        if (r35.hasNext() == false) goto L78;
        r34.add(a(r35.next(), ((com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(CollectionsKt.first((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin")), com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin")).a(), r27));
        goto L76
    L78:
        Iterable r36 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r34, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
    L80:
        a(r36);
        Iterable r110 = (Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin");
        Collection r37 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r111 = r110.iterator();
    L82:
        if (r111.hasNext() == false) goto L86;
        Object r38 = r111.next();
        if (r25.contains((com.obric.memorydata.database.backup.a.a) ZeusTransformUtils.preCheckCast(r38, com.obric.memorydata.database.backup.a.a.class, "com.obric.memorydata.plugin")) == true) goto L82;
        r37.add(r38);
        goto L82
    L86:
        r14 = CollectionsKt.plus((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r37, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin"), r36);
        a((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin"));
    L79:
        r36 = a((Iterable) ZeusTransformUtils.preCheckCast(r25, Iterable.class, "com.obric.memorydata.plugin"), r27);
        goto L80
    L89:
        throw new IllegalArgumentException(("Invalid migration target version " + r27).toString());
    L61:
        r27 = r16 + 1;
    L87:
        r16 = r16 + 1;
        goto L43
    L90:
        return r14;
    L92:
        throw new NoSuchElementException();
    L94:
        throw new NoSuchElementException();
    L96:
        throw new NoSuchElementException();
    }

    public final void a(int r6, int r7, Function1<? super List<? extends S>, ? extends List<? extends S>> r8) {
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "migration");
        boolean r0 = true;
        if (r7 <= r6) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L17;
        if (this.c.get(Integer.valueOf(r6)) == null) goto L11;
        r0 = false;
    L11:
        if (r0 == false) goto L15;
        ((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(r6), new a(r7, r9));
        return;
    L15:
        throw new IllegalStateException(("Duplicate migration path from version " + r6).toString());
    L17:
        throw new IllegalArgumentException(("Invalid migration path: " + r6 + " -> " + r7).toString());
    L5:
        r3 = false;
        goto L6
    }

    public abstract boolean d();

    public abstract com.obric.memorydata.database.backup.dao.e<B> g();
}
