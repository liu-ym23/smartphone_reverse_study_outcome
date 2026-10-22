package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.memorydata.database.entity.hc;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/PhotoFaceEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isEnableLazyIndex", "type", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class x extends a {
    public x() {
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r21, "appEntity");
        if (ZeusTransformUtils.instanceOf(r21, PhotoFaceEntity.class) == true) goto L5;
        return null;
    L5:
        long r4 = 0;
        String r6 = r21.getId();
        long r7 = r21.getCreateTime();
        long r9 = r21.getLastModifiedTime();
        int r11 = r21.getType();
        long r12 = 0;
        String r14 = r21.get_packageName();
        int r15 = r21.getHashCodeValue();
        String r16 = ((PhotoFaceEntity) ZeusTransformUtils.preCheckCast(r21, PhotoFaceEntity.class, "com.obric.memorydata.plugin")).getName();
        FileEntity r0 = ((PhotoFaceEntity) ZeusTransformUtils.preCheckCast(r21, PhotoFaceEntity.class, "com.obric.memorydata.plugin")).getAvatar();
        if (r0 == null) goto L8;
        String r17 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r0, AppEntity.class, "com.obric.memorydata.plugin"));
    L10:
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new hc(r4, r6, r7, r9, r11, r12, r14, r15, r16, r17, 33, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L8:
        r17 = null;
        goto L10
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoFaceRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return true;
    }
}
