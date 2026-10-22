package com.obric.lifelog.data;

import androidx.core.view.InputDeviceCompat;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.memorydata.database.entity.LifelogEntity;
import com.obric.memorydata.database.entity.gd;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.EntityManager;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/obric/lifelog/data/LifelogIndexHandler;", "", "jsonData", "", "<init>", "(Ljava/lang/String;)V", "handle", "", "parseLifelogData", "", "Lcom/obric/lifelog/data/Lifelog;", "json", "parseSingleLifelog", "jsonObject", "Lorg/json/JSONObject;", "processSingleLifelog", "lifelog", "findLifelogByTimestamp", "Lcom/obric/memorydata/database/entity/LifelogEntity;", "uid", "", "addLifelog", "updateLifelog", "existingEntity", "newLifelog", "createIndexTask", "entity", "updateIndexTask", "Companion", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8053b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/lifelog/data/LifelogIndexHandler$Companion;", "", "<init>", "()V", "TAG", "", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f8052a = new a(null);
    }

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonData");
        this.f8053b = r2;
    }

    private final Lifelog a(JSONObject r13) {
        long r1 = r13.getLong("timestamp");
        long r3 = r13.getLong("uid");
        String r5 = r13.getString("title");
        Intrinsics.checkNotNullExpressionValue(r5, "getString(...)");
        String r7 = r13.optString("contentAM", "");
        Intrinsics.checkNotNullExpressionValue(r7, "optString(...)");
        String r8 = r13.optString("contentPM", "");
        Intrinsics.checkNotNullExpressionValue(r8, "optString(...)");
        String r9 = r13.optString("finalContent", "");
        Intrinsics.checkNotNullExpressionValue(r9, "optString(...)");
        String r10 = r13.optString("imageUrl", "");
        Intrinsics.checkNotNullExpressionValue(r10, "optString(...)");
        return new Lifelog(r1, r3, r5, r7, r8, r9, r10, r13.optInt("retryTime", 0), r13.getInt("status"));
    }

    private final LifelogEntity a(final long r2) {
        return (LifelogEntity) ZeusTransformUtils.preCheckCast(y.a(new $$Lambda$c$Ow_nIFi1choyYyv9Sc4GvyAwfB0(r2), new $$Lambda$c$DNHpz4IG6Ih3ebQp0HCOts7Fm5k(r2)), LifelogEntity.class, "com.obric.memorydata.plugin");
    }

    private static final LifelogEntity a(long r7, Exception r9) {
        Intrinsics.checkNotNullParameter(r9, "it");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogIndexHandler", "Error querying lifelog by unique timestamp " + r7 + ": " + r9.getMessage(), null, 4, null);
        return null;
    }

    private final List<Lifelog> a(String r7) {
        JSONArray r1 = new JSONArray(r7);     // Catch: JSONException -> L7
        List<Lifelog> r2 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L7
        int r3 = 0;
        int r4 = r1.length();     // Catch: JSONException -> L7
    L4:
        if (r3 >= r4) goto L17;
        JSONObject r5 = r1.getJSONObject(r3);     // Catch: JSONException -> L7
        Intrinsics.checkNotNull(r5);     // Catch: JSONException -> L7
        r2.add(a(r5));     // Catch: JSONException -> L7
        r3 = r3 + 1;
        goto L4
    L17:
        return r2;
    L7:
        return CollectionsKt.listOf(a(new JSONObject(r7)));
    L9:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogIndexHandler", "Failed to parse lifelog JSON: " + e.getMessage(), null, 4, null);
        return CollectionsKt.emptyList();
    }

    private static final Unit a(Lifelog r7, Exception r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifelogIndexHandler", "Failed to update lifelog for uid " + r7.getUid() + ": " + r8.getMessage(), null, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit a(c r5) {
        List<Lifelog> r0 = r5.a(r5.f8053b);
        RunLog.INSTANCE.debug("LifelogIndexHandler", "Parsed " + r0.size() + " lifelog records");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r5.a((Lifelog) ZeusTransformUtils.preCheckCast(r1.next(), Lifelog.class, "com.obric.memorydata.plugin"));
        goto L4
    L7:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L10;
        EntityManager.INSTANCE.launchIndexTask();
    L10:
        return Unit.INSTANCE;
    }

    private static final Unit a(c r0, LifelogEntity r1) {
        r0.b(r1);
        return Unit.INSTANCE;
    }

    private static final Unit a(Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        RunLog.INSTANCE.error("LifelogIndexHandler", "Error processing lifelog data: " + r4.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    private final void a(Lifelog r3) {
        LifelogEntity r0 = a(r3.getTimestamp());
        if (r0 == null) goto L5;
        a(r0, r3);
        return;
    L5:
        b(r3);
    }

    private final void a(LifelogEntity r4) {
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
        RunLog.INSTANCE.debug("LifelogIndexHandler", "Created index task for lifelog: " + r4.getId());
    }

    private final void a(LifelogEntity r19, final Lifelog r20) {
        final LifelogEntity r0 = LifelogEntity.copy$default(r19, 0, null, 0, System.currentTimeMillis(), 0, 0, null, 0, null, r20, null, 1527, null);
        y.a(new $$Lambda$c$kz28KTkHSeG3iqA6Z4m44TZ8T1s(r20), new $$Lambda$c$k1LfTdBduQZQcWl14UPKA3p6thQ(this, r0));
    }

    private static final LifelogEntity b(long r1) {
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getLifelogDao().queryByTimestamp(r1);
    }

    private final void b(Lifelog r20) {
        long r6 = System.currentTimeMillis();
        String r3 = gd.f9146a.a();
        int r12 = (r20.getTitle() + r20.getFinalContent()).hashCode();
        a(new LifelogEntity(0, r3, r6, r6, EntityType.LIFE_LOG, r20.getTimestamp(), AppContext.INSTANCE.getPackageName(), r12, UUID.randomUUID().toString(), r20, null, InputDeviceCompat.SOURCE_GAMEPAD, null));
    }

    private final void b(LifelogEntity r4) {
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
        RunLog.INSTANCE.debug("LifelogIndexHandler", "Updated index for lifelog: " + r4.getId());
    }

    public static /* synthetic */ LifelogEntity lambda$DNHpz4IG6Ih3ebQp0HCOts7Fm5k(long r0) {
        return b(r0);
    }

    public static /* synthetic */ LifelogEntity lambda$Ow_nIFi1choyYyv9Sc4GvyAwfB0(long r0, Exception r2) {
        return a(r0, r2);
    }

    public static /* synthetic */ Unit lambda$QvoEk6E_CZYFy_EEy6pQatU6CEU(c r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$eMyqu3Gkdsc_BVSIdwTDtMOZvrY(Exception r0) {
        return a(r0);
    }

    public static /* synthetic */ Unit lambda$k1LfTdBduQZQcWl14UPKA3p6thQ(c r0, LifelogEntity r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$kz28KTkHSeG3iqA6Z4m44TZ8T1s(Lifelog r0, Exception r1) {
        return a(r0, r1);
    }

    public final void a() {
        y.a($$Lambda$c$eMyqu3Gkdsc_BVSIdwTDtMOZvrY.INSTANCE, new $$Lambda$c$QvoEk6E_CZYFy_EEy6pQatU6CEU(this));
    }
}
