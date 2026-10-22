package com.obric.memorydata.recommend.settings;

import com.obric.memorydata.database.entity.BlockMemoryContentEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.database.manager.PersonalMemoryFrameDb;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/recommend/settings/BlockMemoryRuleSnapshotReader;", "", "hasValidProfile", "Lkotlin/Function0;", "", "isPersonalDatabaseCurrent", "queryCustomRules", "", "Lcom/obric/memorydata/database/entity/BlockMemoryContentEntity;", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getSnapshots", "Lcom/obric/memorydata/recommend/BlockMemoryRuleSnapshot;", "defaultContents", "", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12602a = null;
    private static final g e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0<Boolean> f12603b;
    private final Function0<Boolean> c;
    private final Function0<List<BlockMemoryContentEntity>> d;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/recommend/settings/BlockMemoryRuleSnapshotReader$Companion;", "", "<init>", "()V", "TAG", "", "currentUserReader", "Lcom/obric/memorydata/recommend/settings/BlockMemoryRuleSnapshotReader;", "getCurrentUserSnapshots", "", "Lcom/obric/memorydata/recommend/BlockMemoryRuleSnapshot;", "defaultContents", "isPersonalDatabaseReadyForCurrentProfile", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        private final boolean a() {
            PersonalMemoryFrameDb r7 = MemoryDbEngine.INSTANCE.getPersonalDbEngine();
            String r0 = com.obric.memorydata.middleware.database.b.f11646a.c(MemoryDbEngine.USER_LOGIC_DB_NAME);
            String r8 = r7.getOpenHelper().getDatabaseName();
            if (r8 != null) goto L5;
            r8 = "";
        L5:
            boolean r9 = Intrinsics.areEqual(r8, r0);
            if (r9 == true) goto L8;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "BlockMemoryRuleSnapshotReader", "[code=block_rule_personal_db_mismatch] Provider returns default rules only", null, 4, null);
        L8:
            return r9;
        }

        public static final /* synthetic */ boolean a(a r0) {
            return r0.a();
        }

        public final List<com.obric.memorydata.recommend.a> a(List<String> r2) {
            List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "defaultContents");
            return g.a().a(r1);
        }
    }

    static {
        f12602a = new a(null);
        e = new g($$Lambda$g$k_6iq7qS1RedTDlc5YbclM7Q8WM.INSTANCE, $$Lambda$g$VfJCINOqcsKwoQKTjNlDF3pfUIk.INSTANCE, $$Lambda$g$u4aiI8of1DA5SuAUxapE7Cj608.INSTANCE);
    }

    public g(Function0<Boolean> r3, Function0<Boolean> r4, Function0<? extends List<BlockMemoryContentEntity>> r5) {
        Function0<Boolean> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function0<Boolean> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function0<List<BlockMemoryContentEntity>> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "hasValidProfile");
        Intrinsics.checkNotNullParameter(r7, "isPersonalDatabaseCurrent");
        Intrinsics.checkNotNullParameter(r8, "queryCustomRules");
        this.f12603b = r6;
        this.c = r7;
        this.d = r8;
    }

    public static final /* synthetic */ g a() {
        return e;
    }

    private static final boolean b() {
        return com.obric.memorydata.middleware.database.b.f11646a.b();
    }

    private static final boolean c() {
        return a.a(f12602a);
    }

    private static final List d() {
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getBlockMemoryContentDao().queryAll();
    }

    public static /* synthetic */ boolean lambda$VfJCINOqcsKwoQKTjNlDF3pfUIk() {
        return c();
    }

    public static /* synthetic */ boolean lambda$k_6iq7qS1RedTDlc5YbclM7Q8WM() {
        return b();
    }

    /* JADX INFO: renamed from: lambda$u4aiI8of1D-A5SuAUxapE7Cj608, reason: not valid java name */
    public static /* synthetic */ List m1132lambda$u4aiI8of1DA5SuAUxapE7Cj608() {
        return d();
    }

    public final List<com.obric.memorydata.recommend.a> a(List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "defaultContents");
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f12603b.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        List<BlockMemoryContentEntity> r3 = (List) ZeusTransformUtils.preCheckCast(this.d.invoke(), List.class, "com.obric.memorydata.plugin");
    L12:
        return f.f12601a.a(r5, r3);
    L10:
        r3 = CollectionsKt.emptyList();
        goto L12
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.c.invoke(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        r0 = true;
        goto L8
    }
}
