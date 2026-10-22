package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.memorydata.database.entity.hh;
import com.obric.memorydata.database.entity.hj;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/RecordingEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isEnableLazyIndex", "type", "", "delete", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class y extends a {
    public y() {
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r35, boolean r36) {
        Intrinsics.checkNotNullParameter(r35, "appEntity");
        if (ZeusTransformUtils.instanceOf(r35, RecordingEntity.class) == false) goto L17;
        long r4 = 0;
        String r6 = r35.getId();
        long r7 = r35.getCreateTime();
        long r9 = r35.getLastModifiedTime();
        int r11 = r35.getType();
        String r14 = r35.get_packageName();
        int r15 = r35.getHashCodeValue();
        String r16 = ((RecordingEntity) ZeusTransformUtils.preCheckCast(r35, RecordingEntity.class, "com.obric.memorydata.plugin")).getName();
        String r19 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(((RecordingEntity) ZeusTransformUtils.preCheckCast(r35, RecordingEntity.class, "com.obric.memorydata.plugin")).getFile(), AppEntity.class, "com.obric.memorydata.plugin"));
        int r20 = ((RecordingEntity) ZeusTransformUtils.preCheckCast(r35, RecordingEntity.class, "com.obric.memorydata.plugin")).getDuration();
        FileEntity r3 = ((RecordingEntity) ZeusTransformUtils.preCheckCast(r35, RecordingEntity.class, "com.obric.memorydata.plugin")).getTranscript();
        if (r3 == null) goto L7;
        String r21 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r3, AppEntity.class, "com.obric.memorydata.plugin"));
    L8:
        String r22 = ((RecordingEntity) ZeusTransformUtils.preCheckCast(r35, RecordingEntity.class, "com.obric.memorydata.plugin")).getSummary();
        String r23 = null;
        List<String> r5 = ((RecordingEntity) ZeusTransformUtils.preCheckCast(r35, RecordingEntity.class, "com.obric.memorydata.plugin")).getTodoList();
        if (r5 == null) goto L11;
        String r32 = com.obric.memorydata.utils.u.a(r5);
    L12:
        List<Integer> r8 = ((RecordingEntity) ZeusTransformUtils.preCheckCast(r35, RecordingEntity.class, "com.obric.memorydata.plugin")).getMarkers();
        if (r8 == null) goto L15;
        String r33 = com.obric.memorydata.utils.u.a(r8);
    L16:
        long r12 = 0;
        String r110 = r21;
        String r24 = r32;
        String r25 = r33;
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new hh(r4, r6, r7, r9, r11, r12, r14, r15, r16, r19, r20, r110, r22, r23, r24, r25, ((RecordingEntity) ZeusTransformUtils.preCheckCast(r35, RecordingEntity.class, "com.obric.memorydata.plugin")).getSourceAppName(), ((RecordingEntity) ZeusTransformUtils.preCheckCast(r35, RecordingEntity.class, "com.obric.memorydata.plugin")).getSourceAppPackage(), null, null, null, SourceDeviceResolver.f12339a.a(r35), 1843233, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L15:
        r33 = null;
        goto L16
    L11:
        r32 = null;
        goto L12
    L7:
        r21 = null;
        goto L8
    L17:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRecordingRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean delete(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "entityId");
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        com.obric.memorydata.database.a r0 = a(r5, r6);
        if (ZeusTransformUtils.instanceOf(r0, hh.class) == false) goto L5;
        hh r1 = (hh) ZeusTransformUtils.preCheckCast(r0, hh.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L12;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRecordingTextRawDbDao().queryByParentEntityId(r5), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r2.hasNext() == false) goto L12;
        ((hj) ZeusTransformUtils.preCheckCast(r2.next(), hj.class, "com.obric.memorydata.plugin")).delete();
    L12:
        return super.delete(r5, r6);
    L5:
        r1 = null;
        goto L6
    }
}
