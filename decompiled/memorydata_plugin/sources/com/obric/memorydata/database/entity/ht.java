package com.obric.memorydata.database.entity;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J&\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\bH\u0016¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/database/entity/RawVideoFrameIndexExtend;", "Lcom/obric/memorydata/database/index/DecoratedEntityIndex;", "delegate", "Lcom/obric/memorydata/database/index/BaseEntityIndex;", "<init>", "(Lcom/obric/memorydata/database/index/BaseEntityIndex;)V", "getNeedUpdateColumns", "", "", "oldRawEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "newRawEntity", "getAllColumns", "getPendingTaskColumns", "assignmentAssociateField", "", "oldEntity", "newEntity", "changeColumns", "", "generateIndexPendingTask", "", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "columnName", "entity", "executeIndexPendingTask", "", "updateField", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ht extends com.obric.memorydata.database.index.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9194a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/entity/RawVideoFrameIndexExtend$Companion;", "", "<init>", "()V", "COLUMN_CAPTION", "", "COLUMN_OCR", "COLUMN_TAG", "COLUMN_PHOTO_ENTITY_ID", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9194a = new a(null);
    }

    public ht(com.obric.memorydata.database.index.e r3) {
        com.obric.memorydata.database.index.e r4 = (com.obric.memorydata.database.index.e) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.database.index.e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "delegate");
        super(r4);
    }

    private static final Unit a(ht r4, d r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "it");
        IAppEntityRawDbDao<? extends d> r0 = r4.getRawDao();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawVideoFrameEntity>");
        List<T> r7 = r0.queryByEntityId(((hr) ZeusTransformUtils.preCheckCast(r5, hr.class, "com.obric.memorydata.plugin")).getEntityId(), ((hr) ZeusTransformUtils.preCheckCast(r5, hr.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        hr r8 = (hr) ZeusTransformUtils.preCheckCast(r7.get(0), hr.class, "com.obric.memorydata.plugin");
        r8.a(r4.getEntityIndexHelperInstance().a(r8.d(), r6));
        r0.update(r8);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit a(ht r26, d r27, List r28) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "tags");
        IAppEntityRawDbDao<? extends d> r3 = r26.getRawDao();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawVideoFrameEntity>");
        List<T> r4 = r3.queryByEntityId(((hr) ZeusTransformUtils.preCheckCast(r27, hr.class, "com.obric.memorydata.plugin")).getEntityId(), ((hr) ZeusTransformUtils.preCheckCast(r27, hr.class, "com.obric.memorydata.plugin")).getPackageName());
        boolean r6 = true;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L14;
        List r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        gs r9 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaTagRawDbDao().queryOneRecord(r7, ((hr) ZeusTransformUtils.preCheckCast(r27, hr.class, "com.obric.memorydata.plugin")).getPackageName());
        if (r9 != null) goto L10;
        long r15 = System.currentTimeMillis();
        gs r10 = new gs(0, gd.f9146a.a(), r15, r15, NetError.ERR_UNKNOWN_URL_SCHEME, 0, ((hr) ZeusTransformUtils.preCheckCast(r27, hr.class, "com.obric.memorydata.plugin")).getPackageName(), 0, ((hr) ZeusTransformUtils.preCheckCast(r27, hr.class, "com.obric.memorydata.plugin")).getType(), r7, 33, null);
        com.obric.memorydata.database.a r8 = (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r10, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        boolean r11 = true;
        com.obric.memorydata.database.a.C0451a.a(r8, false, 1, null);
        r9 = r10;
    L11:
        r5.add(r9.getEntityId());
        r6 = r11;
        goto L6
    L10:
        r11 = r6;
        goto L11
    L12:
        hr r0 = (hr) ZeusTransformUtils.preCheckCast(r4.get(0), hr.class, "com.obric.memorydata.plugin");
        r0.c(r5.toString());
        r3.update(r0);
    L14:
        return Unit.INSTANCE;
    }

    private static final Unit b(ht r6, d r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "it");
        IAppEntityRawDbDao<? extends d> r0 = r6.getRawDao();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.memorydata.database.dao.IAppEntityRawDbDao<com.obric.memorydata.database.entity.RawVideoFrameEntity>");
        List<T> r9 = r0.queryByEntityId(((hr) ZeusTransformUtils.preCheckCast(r7, hr.class, "com.obric.memorydata.plugin")).getEntityId(), ((hr) ZeusTransformUtils.preCheckCast(r7, hr.class, "com.obric.memorydata.plugin")).getPackageName());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        hr r10 = (hr) ZeusTransformUtils.preCheckCast(r9.get(0), hr.class, "com.obric.memorydata.plugin");
        r6.getEntityIndexHelperInstance().a(r10.getId(), r6.buildKeywordIndexMap((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.memorydata.plugin")));
        r10.b(r6.getEntityIndexHelperInstance().a(r10.e(), r8));
        r0.update(r10);
        r6.getEntityIndexHelperInstance().b(r10.getId(), r6.buildKeywordIndexMap((d) ZeusTransformUtils.preCheckCast(r10, d.class, "com.obric.memorydata.plugin")));
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$m6tX0Ay7XhoZwzxfciD9IvrYWFI(ht r0, d r1, List r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$mKWrvS2E5o608hVU0Ei35qu2ZG4(ht r0, d r1, String r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$tYSin-IB3NZVC5eB0oZUMuJ4UL4, reason: not valid java name */
    public static /* synthetic */ Unit m551lambda$tYSinIB3NZVC5eB0oZUMuJ4UL4(ht r0, d r1, String r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public void assignmentAssociateField(d r3, d r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "oldEntity");
        Intrinsics.checkNotNullParameter(r4, "newEntity");
        Intrinsics.checkNotNullParameter(r6, "changeColumns");
        super.assignmentAssociateField(r3, r4, r6);
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, hr.class) == false) goto L20;
        if (ZeusTransformUtils.instanceOf(r4, hr.class) == false) goto L18;
        if (r6.contains("caption") == true) goto L12;
        ((hr) ZeusTransformUtils.preCheckCast(r4, hr.class, "com.obric.memorydata.plugin")).a(((hr) ZeusTransformUtils.preCheckCast(r3, hr.class, "com.obric.memorydata.plugin")).d());
    L12:
        if (r6.contains("ocr") == true) goto L15;
        ((hr) ZeusTransformUtils.preCheckCast(r4, hr.class, "com.obric.memorydata.plugin")).b(((hr) ZeusTransformUtils.preCheckCast(r3, hr.class, "com.obric.memorydata.plugin")).e());
    L15:
        if (r6.contains(LocationMonitorConst.TAG) == true) goto L22;
        ((hr) ZeusTransformUtils.preCheckCast(r4, hr.class, "com.obric.memorydata.plugin")).c(((hr) ZeusTransformUtils.preCheckCast(r3, hr.class, "com.obric.memorydata.plugin")).i());
        return;
    L22:
        return;
    L18:
        throw new IllegalStateException("Check failed.".toString());
    L20:
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public boolean executeIndexPendingTask(final d r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "entity");
        Intrinsics.checkNotNullParameter(r9, "updateField");
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == false) goto L31;
        if (ZeusTransformUtils.instanceOf(r8, hr.class) == false) goto L29;
        int r0 = r9.hashCode();
        if (r0 == 109854) goto L24;
        if (r0 == 114586) goto L19;
        if (r0 != 552573414) goto L31;
        if (r9.equals("caption") == false) goto L31;
        Function1<? super String, Unit> r6 = new $$Lambda$ht$tYSinIB3NZVC5eB0oZUMuJ4UL4(this, r8);
        return getEntityIndexHelperInstance().b(r8, "caption", null, "", r6);
    L19:
        if (r9.equals(LocationMonitorConst.TAG) == false) goto L31;
        Function1<? super List<String>, Unit> r10 = new $$Lambda$ht$m6tX0Ay7XhoZwzxfciD9IvrYWFI(this, r8);
        return getEntityIndexHelperInstance().a(r8, null, r10);
    L24:
        if (r9.equals("ocr") == false) goto L31;
        Function1<? super String, Unit> r7 = new $$Lambda$ht$mKWrvS2E5o608hVU0Ei35qu2ZG4(this, r8);
        return getEntityIndexHelperInstance().a(r8, "ocr", null, "common1", r7);
    L29:
        throw new IllegalStateException("Check failed.".toString());
    L31:
        return super.executeIndexPendingTask(r8, r9);
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public List<cd> generateIndexPendingTask(String r25, d r26) {
        Intrinsics.checkNotNullParameter(r25, "columnName");
        Intrinsics.checkNotNullParameter(r26, "entity");
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == false) goto L46;
        if (ZeusTransformUtils.instanceOf(r26, hr.class) == false) goto L44;
        int r0 = r25.hashCode();
        if (r0 == 109854) goto L34;
        if (r0 == 114586) goto L24;
        if (r0 != 552573414) goto L46;
        if (r25.equals("caption") == false) goto L46;
        ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).f();
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L22;
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L22;
        return CollectionsKt.listOf(new cd(0, ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getId(), ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getType(), ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r25, "caption", 0, 0, null, false, 0, 0, 32353, null));
    L22:
        return CollectionsKt.emptyList();
    L24:
        if (r25.equals(LocationMonitorConst.TAG) == false) goto L46;
        ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).f();
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L32;
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L32;
        return CollectionsKt.listOf(new cd(0, ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getId(), ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getType(), ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r25, LocationMonitorConst.TAG, 0, 0, null, false, 0, 0, 32353, null));
    L32:
        return CollectionsKt.emptyList();
    L34:
        if (r25.equals("ocr") == false) goto L46;
        ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).f();
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L42;
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L42;
        return CollectionsKt.listOf(new cd(0, ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getId(), ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getType(), ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getTimestamp(), ((hr) ZeusTransformUtils.preCheckCast(r26, hr.class, "com.obric.memorydata.plugin")).getCreateTime(), 0, 0, r25, "ocr", 0, 0, null, false, 0, 0, 32353, null));
    L42:
        return CollectionsKt.emptyList();
    L44:
        throw new IllegalStateException("Check failed.".toString());
    L46:
        return super.generateIndexPendingTask(r25, r26);
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public Set<String> getAllColumns() {
        Set<String> r2 = super.getAllColumns();
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == false) goto L5;
        r2.add(LocationMonitorConst.TAG);
    L5:
        return r2;
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public Set<String> getNeedUpdateColumns(d r2, d r3) {
        Intrinsics.checkNotNullParameter(r2, "oldRawEntity");
        Intrinsics.checkNotNullParameter(r3, "newRawEntity");
        Set<String> r1 = super.getNeedUpdateColumns(r2, r3);
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L5;
    L8:
        return r1;
    L5:
        if (r1.contains("photoEntityId") == false) goto L7;
        r1.add("caption");
        r1.add("ocr");
        r1.add(LocationMonitorConst.TAG);
        goto L8
    L7:
        r1.remove("caption");
        r1.remove("ocr");
        goto L8
    }

    @Override // com.obric.memorydata.database.index.p, com.obric.memorydata.database.index.e
    public Set<String> getPendingTaskColumns() {
        Set<String> r2 = super.getPendingTaskColumns();
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == false) goto L5;
        r2.add(LocationMonitorConst.TAG);
    L5:
        return r2;
    }
}
