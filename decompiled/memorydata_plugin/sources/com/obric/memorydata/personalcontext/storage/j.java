package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.memorydata.database.entity.fq;
import com.obric.memorydata.database.entity.fx;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.personalcontext.api.EvaluationService;
import com.obric.memorydata.utils.au;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/CallHistoryEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "getRawDbEntityFromEntityIdList", "", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "entitiesIds", "isEnableLazyIndex", "type", "", "isSupportBulkDelete", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class j extends a {
    public j() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v32, types: [T, java.lang.String] */
    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r39, boolean r40) {
        Intrinsics.checkNotNullParameter(r39, "appEntity");
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r39, CallHistoryEntity.class) == false) goto L54;
        Map<String, au> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getTelephones(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        String r8 = com.obric.memorydata.utils.t.f13260a.c(r7);
        r1.put(r7, new au(r8, null));
        r5.add(r8);
        goto L6
    L8:
        List r6 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        String r32 = com.obric.memorydata.utils.t.f13260a.a(r1);
        List<ContactEntity> r9 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getContacts();
        Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = "";
        if (EvaluationService.INSTANCE.isAutoEvaluationMode() == false) goto L29;
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L13;
    L16:
        boolean r12 = true;
    L17:
        if (r12 == true) goto L29;
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L20:
        if (r13.hasNext() == false) goto L37;
        ContactEntity r14 = (ContactEntity) ZeusTransformUtils.preCheckCast(r13.next(), ContactEntity.class, "com.obric.memorydata.plugin");
        List<fx> r15 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao().queryByContactNameAndPhoneNumber(r14.getName(), r14.getTelephones());
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L20;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L25:
        if (r18.hasNext() == false) goto L27;
        r17.add(((fx) ZeusTransformUtils.preCheckCast(r18.next(), fx.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L25
    L27:
        r10.element = ((List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin")).toString();
    L37:
        long r19 = 0;
        String r110 = r39.getId();
        long r111 = r39.getCreateTime();
        long r112 = r39.getLastModifiedTime();
        int r113 = r39.getType();
        long r114 = 0;
        String r115 = r39.get_packageName();
        int r116 = r39.getHashCodeValue();
        String r20 = null;
        String r21 = com.obric.memorydata.utils.u.a(r6);
        String r22 = (String) ZeusTransformUtils.preCheckCast(r10.element, String.class, "com.obric.memorydata.plugin");
        String r23 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getCallType().name();
        int r24 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getDuration();
        String r25 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getTag();
        boolean r26 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).isAIPickup();
        boolean r27 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getHasTranscript();
        String r28 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getTranscript();
        String r29 = null;
        List<String> r30 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getCarriers();
        if (r30 == null) goto L40;
        String r31 = com.obric.memorydata.utils.u.a(r30);
    L41:
        String r33 = null;
        List<String> r34 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getTodoList();
        if (r34 == null) goto L45;
        r2 = com.obric.memorydata.utils.u.a(r34);
    L45:
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new fq(r19, r110, r111, r112, r113, r114, r115, r116, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r33, r32, r2, ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getTranscriptTitle(), ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getSourceNumber(), 655649, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L40:
        r31 = null;
        goto L41
    L13:
        if (r11.isEmpty() == true) goto L16;
        r12 = false;
    L29:
        if (((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getContacts() != null) goto L31;
        T r35 = 0;
    L36:
        r10.element = r35;
        goto L37
    L31:
        List<ContactEntity> r36 = ((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r39, CallHistoryEntity.class, "com.obric.memorydata.plugin")).getContacts();
        Intrinsics.checkNotNull(r36);
        Iterable r37 = (Iterable) ZeusTransformUtils.preCheckCast(r36, Iterable.class, "com.obric.memorydata.plugin");
        Collection r38 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r37, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r41 = r37.iterator();
    L33:
        if (r41.hasNext() == false) goto L35;
        r38.add(((ContactEntity) ZeusTransformUtils.preCheckCast(r41.next(), ContactEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L33
    L35:
        r35 = ((List) ZeusTransformUtils.preCheckCast(r38, List.class, "com.obric.memorydata.plugin")).toString();
        goto L36
    L54:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCallHistoryRawDbDao().queryByEntityIdListAndPackageName(r1, r3);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a() {
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return true;
    }
}
