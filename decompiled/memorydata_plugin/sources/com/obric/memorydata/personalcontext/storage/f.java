package com.obric.memorydata.personalcontext.storage;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.fm;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\fH\u0016J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\fH\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\fH\u0002¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/AuditoryRecordingEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "delete", "getRawDbEntityFromEntityIdList", "", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "entitiesIds", "isSupportBulkDelete", "isEnableLazyIndex", "type", "", "bulkDelete", "parseRequestTime", "", "extraData", "(Ljava/lang/String;)Ljava/lang/Long;", "parseDid", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends a {
    public f() {
    }

    private final Long a(String r5) {
        Object r1 = null;
        if (r5 != null) goto L5;
    L32:
        return null;
    L5:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L32;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        f r4 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        JSONObject r6 = new JSONObject(r5);     // Catch: Throwable -> L24
        if (r6.has("requestTime") == true) goto L13;
    L21:
        Long r7 = null;
    L22:
        Object r8 = Result.m1421constructorimpl(r7);     // Catch: Throwable -> L24
    L27:
        if (Result.m1427isFailureimpl(r8) == true) goto L31;
        r1 = r8;
    L31:
        return (Long) ZeusTransformUtils.preCheckCast(r1, Long.class, "com.obric.memorydata.plugin");
    L13:
        if (r6.isNull("requestTime") == true) goto L21;
        Object r9 = r6.opt("requestTime");     // Catch: Throwable -> L24
        if (ZeusTransformUtils.instanceOf(r9, Number.class) == false) goto L19;
        r7 = Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L24
        goto L22
    L19:
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L21;
        r7 = StringsKt.toLongOrNull(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L27
    }

    private final String b(String r6) {
        Object r1 = null;
        if (r6 == null) goto L39;
        boolean r4 = true;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        r6 = null;
    L8:
        if (r6 == null) goto L39;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L31
        f r5 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        JSONObject r7 = new JSONObject(r6);     // Catch: Throwable -> L31
        if (r7.has("did") == true) goto L13;
    L28:
        String r8 = null;
    L29:
        Object r9 = Result.m1421constructorimpl(r8);     // Catch: Throwable -> L31
    L34:
        if (Result.m1427isFailureimpl(r9) == true) goto L38;
        r1 = r9;
    L38:
        return (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L13:
        if (r7.isNull("did") == true) goto L28;
        Object r10 = r7.opt("did");     // Catch: Throwable -> L31
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L18;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
    L19:
        if (r11 == null) goto L28;
        r8 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).toString();     // Catch: Throwable -> L31
        if (r8 == null) goto L28;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).length() > 0) goto L26;
        r4 = false;
    L26:
        if (r4 == false) goto L28;
    L18:
        r11 = null;
    L31:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L39:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r36, boolean r37) {
        Intrinsics.checkNotNullParameter(r36, "appEntity");
        if (ZeusTransformUtils.instanceOf(r36, AuditoryRecordingEntity.class) == false) goto L17;
        String r7 = r36.getId();
        long r8 = r36.getCreateTime();
        long r10 = r36.getLastModifiedTime();
        int r12 = r36.getType();
        String r15 = r36.get_packageName();
        int r16 = r36.getHashCodeValue();
        String r17 = ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r36, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getName();
        int r18 = ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r36, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getState();
        String r21 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r36, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getFile(), AppEntity.class, "com.obric.memorydata.plugin"));
        int r22 = ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r36, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getDuration();
        FileEntity r4 = ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r36, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getTranscript();
        if (r4 == null) goto L7;
        String r23 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r4, AppEntity.class, "com.obric.memorydata.plugin"));
    L8:
        String r24 = ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r36, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getSummary();
        List<String> r5 = ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r36, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getTodoList();
        if (r5 == null) goto L11;
        String r33 = com.obric.memorydata.utils.u.a(r5);
    L12:
        List<Integer> r6 = ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r36, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getMarkers();
        if (r6 == null) goto L15;
        String r34 = com.obric.memorydata.utils.u.a(r6);
    L16:
        String r25 = r23;
        String r26 = r33;
        String r27 = r34;
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new fj(0, r7, r8, r10, r12, 0, r15, r16, r17, r18, r21, r22, r25, r24, r26, r27, ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r36, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getSourceAppName(), ((AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r36, AuditoryRecordingEntity.class, "com.obric.memorydata.plugin")).getSourceAppPackage(), a(r36.getExtraData()), b(r36.getExtraData()), null, null, 3145761, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L15:
        r34 = null;
        goto L16
    L11:
        r33 = null;
        goto L12
    L7:
        r23 = null;
        goto L8
    L17:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<String> a(List<String> r7, int r8, String r9) {
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "entitiesIds");
        Intrinsics.checkNotNullParameter(r9, ObricMemoryConstants.KEY_PACKAGE_NAME);
        List<String> r0 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingTextRawDbDao().queryEntityIdByParentEntityIds(r10);
        a r1 = com.obric.memorydata.personalcontext.q.a(com.obric.memorydata.personalcontext.q.f12255a, -313, false, 2, null);
        if (r1 == null) goto L6;
        r1.a(r0, -313, r9);
    L6:
        return super.a(r10, r8, r9);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().queryByEntityIdListAndPackageName(r1, r3);
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
        if (ZeusTransformUtils.instanceOf(r0, fj.class) == false) goto L5;
        fj r1 = (fj) ZeusTransformUtils.preCheckCast(r0, fj.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 == null) goto L12;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingTextRawDbDao().queryByParentEntityId(r5), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r2.hasNext() == false) goto L12;
        ((fm) ZeusTransformUtils.preCheckCast(r2.next(), fm.class, "com.obric.memorydata.plugin")).delete();
    L12:
        return super.delete(r5, r6);
    L5:
        r1 = null;
        goto L6
    }
}
