package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.enums.CountdownStatusEnum;
import com.obric.memorydata.database.entity.fz;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/CountdownEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isEnableLazyIndex", "type", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class m extends a {
    public m() {
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r25, "appEntity");
        if (ZeusTransformUtils.instanceOf(r25, CountdownEntity.class) == false) goto L9;
        long r4 = 0;
        String r6 = r25.getId();
        long r7 = r25.getCreateTime();
        long r9 = r25.getLastModifiedTime();
        int r11 = r25.getType();
        long r12 = 0;
        String r14 = r25.get_packageName();
        int r15 = r25.getHashCodeValue();
        String r16 = null;
        long r17 = ((CountdownEntity) ZeusTransformUtils.preCheckCast(r25, CountdownEntity.class, "com.obric.memorydata.plugin")).getCountdownSeconds();
        String r19 = ((CountdownEntity) ZeusTransformUtils.preCheckCast(r25, CountdownEntity.class, "com.obric.memorydata.plugin")).getLabel();
        CountdownStatusEnum r0 = ((CountdownEntity) ZeusTransformUtils.preCheckCast(r25, CountdownEntity.class, "com.obric.memorydata.plugin")).getStatus();
        if (r0 == null) goto L7;
        String r20 = r0.name();
    L11:
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new fz(r4, r6, r7, r9, r11, r12, r14, r15, r16, r17, r19, r20, null, 4385, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L7:
        r20 = null;
        goto L11
    L9:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCountdownRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return false;
    }
}
