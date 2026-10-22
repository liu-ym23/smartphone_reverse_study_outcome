package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.GenderEnum;
import com.obric.capabilitykit.entity.meta.MetaAddress;
import com.obric.capabilitykit.entity.meta.MetaAnniversary;
import com.obric.capabilitykit.entity.meta.MetaCredentialNumber;
import com.obric.capabilitykit.entity.meta.MetaEmailAddress;
import com.obric.capabilitykit.entity.meta.MetaInstantMessaging;
import com.obric.capabilitykit.entity.meta.MetaRelationship;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.memorydata.database.entity.fx;
import com.obric.memorydata.database.manager.MemoryDbEngine;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/ContactEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isEnableLazyIndex", "type", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l extends a {
    public l() {
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r48, boolean r49) {
        Intrinsics.checkNotNullParameter(r48, "appEntity");
        String r2 = null;
        if (ZeusTransformUtils.instanceOf(r48, ContactEntity.class) == false) goto L54;
        Map<String, au> r1 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        ContactEntity r3 = (ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin");
        List<MetaTelephone> r5 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getTelephones();
        if (r5 == null) goto L11;
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L10;
        MetaTelephone r9 = (MetaTelephone) ZeusTransformUtils.preCheckCast(r8.next(), MetaTelephone.class, "com.obric.memorydata.plugin");
        String r10 = com.obric.memorydata.utils.t.f13260a.c(r9.getTelephone());
        r1.put(r9.getTelephone(), new au(r10, r9.getContactType()));
        r7.add(MetaTelephone.copy$default(r9, r10, null, 2, null));
        goto L8
    L10:
        List<MetaTelephone> r11 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
    L12:
        r3.setTelephones(r11);
        String r43 = com.obric.memorydata.utils.t.f13260a.a(r1);
        long r12 = 0;
        String r13 = r48.getId();
        long r14 = r48.getCreateTime();
        long r15 = r48.getLastModifiedTime();
        int r16 = r48.getType();
        long r17 = 0;
        String r18 = r48.get_packageName();
        int r19 = r48.getHashCodeValue();
        String r110 = null;
        String r111 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getName();
        List<MetaTelephone> r4 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getTelephones();
        if (r4 == null) goto L15;
        String r20 = com.obric.memorydata.utils.u.a(r4);
    L16:
        String r21 = null;
        FileEntity r22 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getAvatar();
        if (r22 == null) goto L19;
        String r23 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r22, AppEntity.class, "com.obric.memorydata.plugin"));
    L20:
        String r24 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getNote();
        GenderEnum r25 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getGender();
        if (r25 == null) goto L23;
        String r26 = r25.name();
    L24:
        List<MetaCredentialNumber> r27 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getCredentialNumbers();
        if (r27 == null) goto L27;
        String r28 = com.obric.memorydata.utils.u.a(r27);
    L28:
        String r29 = null;
        List<MetaEmailAddress> r30 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getEmails();
        if (r30 == null) goto L31;
        String r210 = com.obric.memorydata.utils.u.a(r30);
    L32:
        String r211 = null;
        List<MetaAddress> r31 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getAddresses();
        if (r31 == null) goto L35;
        String r212 = com.obric.memorydata.utils.u.a(r31);
    L36:
        String r32 = null;
        String r33 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getCompany();
        List<MetaInstantMessaging> r34 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getInstantMessagings();
        if (r34 == null) goto L39;
        String r35 = com.obric.memorydata.utils.u.a(r34);
    L40:
        List<MetaAnniversary> r36 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getAnniversaries();
        if (r36 == null) goto L43;
        String r37 = com.obric.memorydata.utils.u.a(r36);
    L44:
        String r38 = null;
        String r39 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getVoip();
        List<MetaRelationship> r40 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getRelationShips();
        if (r40 == null) goto L47;
        String r310 = com.obric.memorydata.utils.u.a(r40);
    L48:
        String r311 = null;
        String r312 = null;
        String r313 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getDepartment();
        String r41 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getJobTitle();
        String r42 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getSubNote();
        List<String> r0 = ((ContactEntity) ZeusTransformUtils.preCheckCast(r48, ContactEntity.class, "com.obric.memorydata.plugin")).getWebsites();
        if (r0 == null) goto L52;
        r2 = com.obric.memorydata.utils.u.a(r0);
    L52:
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new fx(r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r20, r21, r23, r24, r26, r28, r29, r210, r211, r212, r32, r33, r35, r37, r38, r39, r310, r311, r312, r313, r41, r42, r2, r43, 420808993, 0, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L47:
        r310 = null;
        goto L48
    L43:
        r37 = null;
        goto L44
    L39:
        r35 = null;
        goto L40
    L35:
        r212 = null;
        goto L36
    L31:
        r210 = null;
        goto L32
    L27:
        r28 = null;
        goto L28
    L23:
        r26 = null;
        goto L24
    L19:
        r23 = null;
        goto L20
    L15:
        r20 = null;
        goto L16
    L11:
        r11 = null;
        goto L12
    L54:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getContactRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return true;
    }
}
