package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.database.entity.fg;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/AlbumEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityByAppEntityAndHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "historyEntity", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isEnableLazyIndex", "type", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c extends a {
    public c() {
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r30, "appEntity");
        long r1 = r30.getCreateTime();
        long r3 = r30.getLastModifiedTime();
        String r6 = null;
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == false) goto L18;
        com.obric.memorydata.database.a r2 = a(r30.getId(), r30.get_packageName());
        if (ZeusTransformUtils.instanceOf(r2, fg.class) == false) goto L7;
        fg r4 = (fg) ZeusTransformUtils.preCheckCast(r2, fg.class, "com.obric.memorydata.plugin");
    L8:
        if (r4 != null) goto L10;
        long r14 = System.currentTimeMillis();
        long r16 = r14;
    L20:
        if (ZeusTransformUtils.instanceOf(r30, AlbumEntity.class) == false) goto L26;
        long r11 = 0;
        String r13 = r30.getId();
        int r18 = r30.getType();
        long r19 = 0;
        String r21 = r30.get_packageName();
        int r22 = r30.getHashCodeValue();
        String r23 = null;
        String r24 = ((AlbumEntity) ZeusTransformUtils.preCheckCast(r30, AlbumEntity.class, "com.obric.memorydata.plugin")).getName();
        FileEntity r5 = ((AlbumEntity) ZeusTransformUtils.preCheckCast(r30, AlbumEntity.class, "com.obric.memorydata.plugin")).getCover();
        if (r5 == null) goto L25;
        r6 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.memorydata.plugin"));
    L25:
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new fg(r11, r13, r14, r16, r18, r19, r21, r22, r23, r24, r6, ((AlbumEntity) ZeusTransformUtils.preCheckCast(r30, AlbumEntity.class, "com.obric.memorydata.plugin")).getMediaCount(), 289, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L26:
        return null;
    L10:
        long r7 = r4.getCreateTime();
        long r8 = r4.getModifyTime();
        long r9 = System.currentTimeMillis();
        if (r7 != 0) goto L13;
        long r10 = r9;
    L14:
        r14 = r10;
        if (r8 != 0) goto L17;
        r16 = r9;
        goto L20
    L17:
        r16 = r8;
        goto L20
    L13:
        r10 = r7;
        goto L14
    L7:
        r4 = null;
        goto L8
    L18:
        r14 = r1;
        r16 = r3;
        goto L20
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAlbumRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.entity.d a(AppEntity r25, com.obric.memorydata.database.a r26) {
        com.obric.memorydata.database.a r1 = (com.obric.memorydata.database.a) ZeusTransformUtils.wrapperContextForParams(r26, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r25, "appEntity");
        if (ZeusTransformUtils.instanceOf(r25, AlbumEntity.class) == true) goto L5;
        return null;
    L5:
        long r6 = 0;
        String r8 = r25.getId();
        long r11 = 0;
        if (r25.getCreateTime() <= 0) goto L9;
        long r9 = r25.getCreateTime();
    L16:
        if (r25.getLastModifiedTime() <= 0) goto L19;
        r11 = r25.getLastModifiedTime();
    L24:
        int r13 = r25.getType();
        long r14 = 0;
        String r16 = r25.get_packageName();
        int r17 = r25.getHashCodeValue();
        String r18 = null;
        String r19 = ((AlbumEntity) ZeusTransformUtils.preCheckCast(r25, AlbumEntity.class, "com.obric.memorydata.plugin")).getName();
        FileEntity r5 = ((AlbumEntity) ZeusTransformUtils.preCheckCast(r25, AlbumEntity.class, "com.obric.memorydata.plugin")).getCover();
        if (r5 == null) goto L27;
        String r20 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.memorydata.plugin"));
    L28:
        com.obric.memorydata.database.a r0 = a(r25, (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new fg(r6, r8, r9, r11, r13, r14, r16, r17, r18, r19, r20, ((AlbumEntity) ZeusTransformUtils.preCheckCast(r25, AlbumEntity.class, "com.obric.memorydata.plugin")).getMediaCount(), 289, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), r1);
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.database.entity.d.class) == true) goto L33;
        return null;
    L33:
        return (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L27:
        r20 = null;
        goto L28
    L19:
        if (ZeusTransformUtils.instanceOf(r1, fg.class) == false) goto L21;
        fg r7 = (fg) ZeusTransformUtils.preCheckCast(r1, fg.class, "com.obric.memorydata.plugin");
    L22:
        if (r7 == null) goto L24;
        r11 = r7.getModifyTime();
        goto L24
    L21:
        r7 = null;
        goto L22
    L9:
        if (ZeusTransformUtils.instanceOf(r1, fg.class) == false) goto L11;
        fg r10 = (fg) ZeusTransformUtils.preCheckCast(r1, fg.class, "com.obric.memorydata.plugin");
    L12:
        if (r10 == null) goto L14;
        r9 = r10.getCreateTime();
        goto L16
    L14:
        r9 = 0;
        goto L16
    L11:
        r10 = null;
        goto L12
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return true;
    }
}
