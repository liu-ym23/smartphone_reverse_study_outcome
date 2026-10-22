package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import com.obric.memorydata.database.entity.fx;
import com.obric.memorydata.database.entity.gd;
import com.obric.memorydata.database.entity.go;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J&\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\r\u001a\u00020\fH\u0016J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/MessageEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "getRawDbEntityFromEntityIdList", "", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "entitiesIds", "bulkDelete", "type", "", "isSupportBulkDelete", "isEnableLazyIndex", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class t extends a {
    public t() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v32, types: [T, java.lang.String] */
    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r34, boolean r35) {
        Intrinsics.checkNotNullParameter(r34, "appEntity");
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r34, MessageEntity.class) == false) goto L58;
        Map<String, au> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(((MessageEntity) ZeusTransformUtils.preCheckCast(r34, MessageEntity.class, "com.obric.memorydata.plugin")).getTelephones(), Iterable.class, "com.obric.memorydata.plugin");
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
        String r30 = com.obric.memorydata.utils.t.f13260a.a(r1);
        List<ContactEntity> r9 = ((MessageEntity) ZeusTransformUtils.preCheckCast(r34, MessageEntity.class, "com.obric.memorydata.plugin")).getContacts();
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
        String r110 = r34.getId();
        long r111 = r34.getCreateTime();
        long r112 = r34.getLastModifiedTime();
        int r113 = r34.getType();
        long r114 = 0;
        String r115 = r34.get_packageName();
        int r116 = r34.getHashCodeValue();
        String r20 = null;
        String r21 = com.obric.memorydata.utils.u.a(r6);
        String r22 = ((MessageEntity) ZeusTransformUtils.preCheckCast(r34, MessageEntity.class, "com.obric.memorydata.plugin")).getText();
        String r23 = null;
        String r24 = null;
        if (((MessageEntity) ZeusTransformUtils.preCheckCast(r34, MessageEntity.class, "com.obric.memorydata.plugin")).getFiles() != null) goto L40;
        String r25 = null;
    L41:
        String r26 = (String) ZeusTransformUtils.preCheckCast(r10.element, String.class, "com.obric.memorydata.plugin");
        MessageTypeEnum r27 = ((MessageEntity) ZeusTransformUtils.preCheckCast(r34, MessageEntity.class, "com.obric.memorydata.plugin")).getMessageType();
        if (r27 == null) goto L44;
        String r28 = r27.name();
    L45:
        MessageStatusTypeEnum r0 = ((MessageEntity) ZeusTransformUtils.preCheckCast(r34, MessageEntity.class, "com.obric.memorydata.plugin")).getMessageStatusType();
        if (r0 == null) goto L49;
        r2 = r0.name();
    L49:
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new go(r19, r110, r111, r112, r113, r114, r115, r116, r20, r21, r22, r23, r24, r25, r26, r28, r2, null, r30, 137505, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L44:
        r28 = null;
        goto L45
    L40:
        r25 = EntityExtKt.getEntityGson().toJson(((MessageEntity) ZeusTransformUtils.preCheckCast(r34, MessageEntity.class, "com.obric.memorydata.plugin")).getFiles());
        goto L41
    L13:
        if (r11.isEmpty() == true) goto L16;
        r12 = false;
    L29:
        if (((MessageEntity) ZeusTransformUtils.preCheckCast(r34, MessageEntity.class, "com.obric.memorydata.plugin")).getContacts() != null) goto L31;
        T r29 = 0;
    L36:
        r10.element = r29;
        goto L37
    L31:
        List<ContactEntity> r31 = ((MessageEntity) ZeusTransformUtils.preCheckCast(r34, MessageEntity.class, "com.obric.memorydata.plugin")).getContacts();
        Intrinsics.checkNotNull(r31);
        Iterable r32 = (Iterable) ZeusTransformUtils.preCheckCast(r31, Iterable.class, "com.obric.memorydata.plugin");
        Collection r33 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r36 = r32.iterator();
    L33:
        if (r36.hasNext() == false) goto L35;
        r33.add(((ContactEntity) ZeusTransformUtils.preCheckCast(r36.next(), ContactEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L33
    L35:
        r29 = ((List) ZeusTransformUtils.preCheckCast(r33, List.class, "com.obric.memorydata.plugin")).toString();
        goto L36
    L58:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMessageRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<String> a(List<String> r9, int r10, String r11) {
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "entitiesIds");
        Intrinsics.checkNotNullParameter(r11, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (r12.isEmpty() == true) goto L5;
        List<String> r8 = super.a(r12, r10, r11);
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r13.hasNext() == false) goto L10;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        gd.f9146a.a(r3, r10, r11, null, CollectionsKt.emptyList());
        goto L8
    L10:
        return r8;
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMessageRawDbDao().queryByEntityIdListAndPackageName(r1, r3);
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
