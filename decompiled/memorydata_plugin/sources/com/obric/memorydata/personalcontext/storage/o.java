package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.database.entity.ge;
import com.obric.memorydata.database.entity.gg;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\fH\u0016J\u001e\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000f2\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/FileEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "getRawDbEntityFromEntityIdList", "", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "entitiesIds", "isSupportBulkDelete", "isEnableLazyIndex", "type", "", "delete", "bulkDelete", "bulkDeleteFileTextEntities", "", "parentEntityIds", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class o extends com.obric.memorydata.personalcontext.storage.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12346a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/FileEntityStorage$Companion;", "", "<init>", "()V", "FILE_TEXT_PARENT_QUERY_BATCH_SIZE", "", "FILE_TEXT_DELETE_BATCH_SIZE", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12346a = new a(null);
    }

    public o() {
    }

    private final void b(List<String> r8, String r9) {
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), 900), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L13;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getFileTextRawDbDao().queryEntityIdByParentEntityIds((List) ZeusTransformUtils.preCheckCast(r7.next(), List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"), 2000), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r10.hasNext() == false) goto L4;
        List<String> r1 = (List) ZeusTransformUtils.preCheckCast(r10.next(), List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L7;
        com.obric.memorydata.personalcontext.storage.a r2 = com.obric.memorydata.personalcontext.q.a(com.obric.memorydata.personalcontext.q.f12255a, -308, false, 2, null);
        if (r2 == null) goto L7;
        r2.a(r1, -308, r9);
        goto L7
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r28, boolean r29) {
        Intrinsics.checkNotNullParameter(r28, "appEntity");
        if (ZeusTransformUtils.instanceOf(r28, FileEntity.class) == false) goto L5;
        String r5 = r28.getId();
        long r6 = r28.getCreateTime();
        long r8 = r28.getLastModifiedTime();
        int r10 = r28.getType();
        String r13 = r28.get_packageName();
        int r14 = r28.getHashCodeValue();
        String r15 = ((FileEntity) ZeusTransformUtils.preCheckCast(r28, FileEntity.class, "com.obric.memorydata.plugin")).getFileName();
        long r16 = ((FileEntity) ZeusTransformUtils.preCheckCast(r28, FileEntity.class, "com.obric.memorydata.plugin")).getFileSize();
        String r4 = ((FileEntity) ZeusTransformUtils.preCheckCast(r28, FileEntity.class, "com.obric.memorydata.plugin")).getContentUrl().toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new ge(0, r5, r6, r8, r10, 0, r13, r14, r15, r16, r4, ((FileEntity) ZeusTransformUtils.preCheckCast(r28, FileEntity.class, "com.obric.memorydata.plugin")).getFileType().name(), ((FileEntity) ZeusTransformUtils.preCheckCast(r28, FileEntity.class, "com.obric.memorydata.plugin")).getMimeType(), null, null, null, null, 122913, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getFileRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<String> a(List<String> r3, int r4, String r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "entitiesIds");
        Intrinsics.checkNotNullParameter(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (r6.isEmpty() == true) goto L5;
        b(r6, r5);
        return super.a(r6, r4, r5);
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getFileRawDbDao().queryByEntityIdListAndPackageName(r1, r3);
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

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean delete(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "entityId");
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        com.obric.memorydata.database.a r0 = a(r5, r6);
        if (ZeusTransformUtils.instanceOf(r0, ge.class) == false) goto L5;
        ge r1 = (ge) ZeusTransformUtils.preCheckCast(r0, ge.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L12;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getFileTextRawDbDao().queryByParentEntityId(r5), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r2.hasNext() == false) goto L12;
        ((gg) ZeusTransformUtils.preCheckCast(r2.next(), gg.class, "com.obric.memorydata.plugin")).delete();
    L12:
        return super.delete(r5, r6);
    L5:
        r1 = null;
        goto L6
    }
}
