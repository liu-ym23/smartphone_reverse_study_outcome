package com.obric.memorydata.union.build;

import com.google.gson.reflect.TypeToken;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.fa;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.entity.iy;
import com.obric.memorydata.database.entity.iz;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryIslandService;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.sdk.memory.State;
import com.obric.memorydata.utils.GsonUtil;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "V1 Handler 仅为旧版兼容入口，新链路统一使用 SemanticBridge → MemoryStorageBridgeAPIImpl.insertSemanticEntity。", replaceWith = @ReplaceWith(expression = "UnionSemanticHandlerV2", imports = {}))
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J/\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/union/build/UnionSemanticHandler;", "", "data", "", "<init>", "(Ljava/lang/String;)V", "handle", "", "processItem", "", "index", "", "item", "Lcom/obric/memorydata/union/build/UnionSemanticData;", "syncRelevantDataIfNeeded", "entityId", "isInsert", "sourceProductType", "(Lcom/obric/memorydata/union/build/UnionSemanticData;Ljava/lang/String;ZLjava/lang/Integer;)V", "Companion", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13101a = null;
    private static final Map<String, Integer> c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13102b;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/union/build/UnionSemanticHandler$Companion;", "", "<init>", "()V", "TAG", "", "BUSINESS_TYPE_OAUTO", "BUSINESS_TYPE_SEMANTIC_MEMORY_UPDATE", "BUSINESS_TYPE_MAP", "", "", "getMainProductTypeFromOldProductType", "productType", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "getProactiveProductTypeFromOldProductType", "(Ljava/lang/Integer;)I", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final Integer a(Integer r1) {
            if (r1 != null) goto L6;
            return null;
        L6:
            if (n.b().values().contains(r1) == false) goto L9;
            return r1;
        L9:
            if (r1.intValue() != 11) goto L13;
            int r0 = 1001;
        L12:
            return Integer.valueOf(r0);
        L13:
            r0 = 1003;
            goto L12
        }

        public final int b(Integer r2) {
            if (r2 != null) goto L6;
            return 0;
        L6:
            if (n.b().values().contains(r2) == false) goto L9;
            return 0;
        L9:
            return r2.intValue();
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonUtil$fromJsonArray$2$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends UnionSemanticData>> {
        public b() {
        }
    }

    static {
        f13101a = new a(null);
        c = e.f13072a.a();
    }

    public n(String r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.f13102b = r2;
    }

    private final void a(UnionSemanticData r17, String r18, boolean r19, Integer r20) {
        String r0 = r17.getMainSourceEntityId();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r19 == true) goto L7;
        return;
    L7:
        iy r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUpdateProactiveSemanticRelevantDataDao().queryBySemanticId(r0);
        if (r1 != null) goto L10;
        return;
    L10:
        String r2 = r1.e();
        String r3 = null;
        if (r2 == null) goto L27;
        boolean r4 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L19;
        r2 = null;
    L19:
        if (r2 == null) goto L27;
        if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveSemanticRelevantDataDao().queryFirstBySourceScreenshot(r2) != null) goto L24;
        r4 = false;
    L24:
        if (r4 == true) goto L27;
        r3 = r2;
        goto L27
    L15:
        r5 = false;
    L27:
        fa r6 = new fa(0, r18, r1.c(), r1.d(), r3, r1.f(), r1.g(), r1.h(), f13101a.b(r20), 1, null);
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveSemanticRelevantDataDao().insert(r6);
        com.obric.memorydata.database.c.f.f8859a.a(r6);
    }

    private final boolean a(int r60, UnionSemanticData r61) {
        if (r61 != null) goto L6;
        return false;
    L6:
        if (com.obric.memorydata.utils.b.a(r61.getType()) == false) goto L8;
    L141:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticHandler", "item data is invalid: " + r61, null, 4, null);
        return false;
    L8:
        if (com.obric.memorydata.utils.b.a(r61.getTagPath()) == true) goto L141;
        if (com.obric.memorydata.utils.b.a(r61.getKeyPhrase()) == true) goto L141;
        if (com.obric.memorydata.utils.b.a(r61.getDescription()) == true) goto L14;
    L16:
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r61.getEntityId(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L19;
    L22:
        boolean r3 = true;
    L23:
        long r6 = System.currentTimeMillis();
        boolean r4 = Intrinsics.areEqual(r61.getBusinessType(), "semantic_memory_update");
        if (r3 == false) goto L33;
        if (r4 == false) goto L28;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticHandler", "semantic_memory_update item must have userEdit", null, 4, null);
        return false;
    L28:
        StringBuilder r8 = new StringBuilder();
        Long r9 = r61.getCreateTime();
        if (r9 == null) goto L31;
        long r10 = r9.longValue();
    L32:
        String r11 = r8.append(r10).append("_-401").toString();
    L34:
        MemoryEntity r50 = null;
        if (r3 == true) goto L37;
        ip r5 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityId(r11);
    L38:
        String r15 = j.a(r61.getType(), r61.getTagPath());
        if (r5 != null) goto L41;
        boolean r51 = false;
    L51:
        if (r4 == false) goto L53;
        String r12 = r61.getKeyPhrase();
    L54:
        String r13 = r12;
        if (r4 == false) goto L63;
        String r14 = r61.getMainSourceEntityId();
        if (r14 == null) goto L63;
        iz r16 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getUpdateUnionSemanticMemoryDao().queryByEntityId(r14);
        if (r16 == null) goto L61;
        Integer r17 = Integer.valueOf(r16.q());
    L62:
        Integer r18 = r17;
    L64:
        String r19 = "";
        if (r5 == null) goto L90;
        r5.a(r61.getType());
        r5.b(r15);
        r5.c(r61.getKeyPhrase());
        String r7 = r61.getDescription();
        if (r7 != null) goto L69;
        r7 = "";
    L69:
        r5.d(r7);
        r5.e(r13);
        String r20 = r61.getSources();
        if (r20 == null) goto L73;
        r19 = r20;
    L73:
        r5.f(r19);
        Integer r21 = r61.getEvidenceCount();
        if (r21 == null) goto L76;
        int r22 = r21.intValue();
    L77:
        r5.a(r22);
        if (r4 == false) goto L84;
        Boolean r23 = r61.getUserEdit();
        if (r23 == null) goto L82;
        boolean r24 = r23.booleanValue();
    L83:
        r5.a(r24);
    L89:
        ip r52 = r5;
    L123:
        if (com.obric.memorydata.union.build.storage.h.a(com.obric.memorydata.union.build.storage.h.f13122a, r52, CollectionsKt.listOfNotNull(r61.getEntityId()), null, 4, null) == false) goto L131;
        RunLog.INSTANCE.debug("UnionSemanticHandler", "index success");
        if (r4 == false) goto L130;
        if (r5 != null) goto L128;
        boolean r25 = true;
    L129:
        a(r61, r11, r25, r18);
        goto L130
    L128:
        r25 = false;
    L130:
        EntityManager.INSTANCE.launchIndexTask();
    L131:
        if (r60 == 0) goto L133;
    L140:
        return true;
    L133:
        if (Intrinsics.areEqual(r61.getBusinessType(), "oauto") == false) goto L140;
        if (r5 == null) goto L136;
        if (r51 == false) goto L140;
    L136:
        MemoryIslandService r0 = MemoryIslandService.INSTANCE;
        String r1 = r52.getEntityId();
        int r26 = State.SUCCESS_NEW.ordinal();
        MemoryEntity r27 = iq.a(r52);
        if (r5 == null) goto L139;
        r50 = iq.a(r5);
    L139:
        r0.showMemory(r1, r26, r27, r50);
        goto L140
    L82:
        r24 = r5.g();
        goto L83
    L84:
        Integer r28 = (Integer) ZeusTransformUtils.preCheckCast(c.get(r61.getBusinessType()), Integer.class, "com.obric.memorydata.plugin");
        if (r28 == null) goto L87;
        int r29 = r28.intValue();
    L88:
        r5.b(r29);
        goto L89
    L87:
        r29 = 0;
        goto L88
    L76:
        r22 = 1;
        goto L77
    L90:
        Long r110 = r61.getCreateTime();
        if (r110 == null) goto L93;
        long r111 = r110.longValue();
    L94:
        Long r112 = r61.getModifyTime();
        if (r112 == null) goto L97;
        r6 = r112.longValue();
    L97:
        String r210 = AppContext.INSTANCE.getPackageName();
        String r211 = r61.getType();
        String r212 = r61.getKeyPhrase();
        String r113 = r61.getDescription();
        if (r113 != null) goto L100;
        String r213 = "";
    L101:
        String r114 = r61.getSources();
        if (r114 != null) goto L104;
        String r214 = "";
    L105:
        Boolean r30 = r61.getUserEdit();
        if (r30 == null) goto L108;
        boolean r215 = r30.booleanValue();
    L109:
        Integer r31 = r61.getEvidenceCount();
        if (r31 == null) goto L112;
        int r32 = r31.intValue();
    L113:
        if (r4 == false) goto L117;
        Integer r33 = f13101a.a(r18);
        if (r33 != null) goto L119;
    L120:
        int r34 = 0;
    L121:
        r52 = new ip(0, r11, r111, r6, NetError.ERR_CACHE_READ_FAILURE, 0, r210, 0, null, r211, r15, r212, r213, r13, r214, r215, r32, r34, false, false, 0.0f, null, null, null, null, null, 0, null, 0, null, null, 0, -261855, null);
    L119:
        r34 = r33.intValue();
        goto L121
    L117:
        r33 = (Integer) ZeusTransformUtils.preCheckCast(c.get(r61.getBusinessType()), Integer.class, "com.obric.memorydata.plugin");
        if (r33 == null) goto L120;
    L112:
        r32 = 1;
        goto L113
    L108:
        r215 = false;
        goto L109
    L104:
        r214 = r114;
        goto L105
    L100:
        r213 = r113;
        goto L101
    L93:
        r111 = r6;
        goto L94
    L61:
        r17 = null;
    L63:
        r18 = null;
        goto L64
    L53:
        r12 = r61.getKeyPhrase() + ',' + r61.getDescription();
        goto L54
    L41:
        if (Intrinsics.areEqual(r61.getType(), r5.a()) == true) goto L43;
    L48:
        boolean r35 = true;
    L49:
        r51 = r35;
        goto L51
    L43:
        if (Intrinsics.areEqual(r61.getKeyPhrase(), r5.c()) == false) goto L48;
        if (Intrinsics.areEqual(r15, r5.b()) == false) goto L48;
        r35 = false;
        goto L49
    L37:
        r5 = null;
        goto L38
    L31:
        r10 = r6;
        goto L32
    L33:
        r11 = r61.getEntityId();
        Intrinsics.checkNotNull(r11);
        goto L34
    L19:
        if (r2.length() == 0) goto L22;
        r3 = false;
        goto L23
    L14:
        if (Intrinsics.areEqual(r61.getBusinessType(), "semantic_memory_update") == true) goto L16;
        goto L16
    }

    public static final /* synthetic */ Map b() {
        return c;
    }

    public final void a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticHandler", "start handle data length: " + this.f13102b.length(), false, 4, null);
        GsonUtil r0 = GsonUtil.INSTANCE;
        String r1 = this.f13102b;
        List r2 = null;
        boolean r3 = true;
        int r4 = 0;
        if (r1 != null) goto L5;
    L13:
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L16;
    L19:
        if (r3 == false) goto L22;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UnionSemanticHandler", "handle error, items is null or empty", null, 4, null);
        return;
    L22:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L24:
        if (r6.hasNext() == false) goto L29;
        Object r7 = r6.next();
        int r8 = r4 + 1;
        if (r4 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        a(r4, (UnionSemanticData) ZeusTransformUtils.preCheckCast(r7, UnionSemanticData.class, "com.obric.memorydata.plugin"));
        r4 = r8;
        goto L24
    L29:
        return;
    L16:
        if (r5.isEmpty() == true) goto L19;
        r3 = false;
        goto L19
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r9 = true;
    L8:
        if (r9 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        r2 = (List) ZeusTransformUtils.preCheckCast(GsonUtil.INSTANCE.getGSON().fromJson(r1, new b().getType()), List.class, "com.obric.memorydata.plugin");
        goto L13
    L7:
        r9 = false;
        goto L8
    }
}
