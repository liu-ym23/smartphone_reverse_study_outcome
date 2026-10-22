package com.obric.memorydata.personalcontext.storage;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import com.obric.memorydata.database.entity.gu;
import com.obric.memorydata.database.entity.gw;
import com.obric.memorydata.database.entity.gy;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/NoteEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isLazyIndex", "", "getRawDbEntityFromEntityId", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "isEnableLazyIndex", "type", "", "delete", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class v extends com.obric.memorydata.personalcontext.storage.a {

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    public v() {
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r34, boolean r35) {
        Intrinsics.checkNotNullParameter(r34, "appEntity");
        if (ZeusTransformUtils.instanceOf(r34, NoteEntity.class) == false) goto L42;
        if (r35 == true) goto L24;
        List<RecordingEntity> r3 = ((NoteEntity) ZeusTransformUtils.preCheckCast(r34, NoteEntity.class, "com.obric.memorydata.plugin")).getRecordings();
        if (r3 == null) goto L24;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r4.hasNext() == false) goto L24;
        RecordingEntity r5 = (RecordingEntity) ZeusTransformUtils.preCheckCast(r4.next(), RecordingEntity.class, "com.obric.memorydata.plugin");
        long r6 = 0;
        String r8 = r5.getId();
        long r9 = r5.getCreateTime();
        long r11 = r5.getLastModifiedTime();
        int r13 = -307;
        String r17 = r5.get_packageName();
        int r18 = r5.getHashCodeValue();
        String r19 = r5.getName();
        String r2 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r5.getFile(), AppEntity.class, "com.obric.memorydata.plugin"));
        int r20 = r5.getDuration();
        FileEntity r7 = r5.getTranscript();
        if (r7 == null) goto L14;
        String r23 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(r7, AppEntity.class, "com.obric.memorydata.plugin"));
    L15:
        String r24 = r5.getSummary();
        List<String> r10 = r5.getTodoList();
        if (r10 == null) goto L18;
        String r30 = com.obric.memorydata.utils.u.a(r10);
    L19:
        List<Integer> r12 = r5.getMarkers();
        if (r12 == null) goto L22;
        String r31 = com.obric.memorydata.utils.u.a(r12);
    L23:
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new gw(r6, r8, r9, r11, r13, 0, r17, r18, r19, r2, r20, r23, r24, r30, r31, r5.getSourceAppName(), r5.getSourceAppPackage(), null, 131105, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
        goto L10
    L22:
        r31 = null;
        goto L23
    L18:
        r30 = null;
        goto L19
    L14:
        r23 = null;
    L24:
        long r14 = 0;
        String r15 = r34.getId();
        long r16 = r34.getCreateTime();
        long r110 = r34.getLastModifiedTime();
        int r111 = r34.getType();
        long r112 = 0;
        String r113 = r34.get_packageName();
        int r114 = r34.getHashCodeValue();
        String r21 = null;
        String r22 = ((NoteEntity) ZeusTransformUtils.preCheckCast(r34, NoteEntity.class, "com.obric.memorydata.plugin")).getTitle();
        String r25 = ((NoteEntity) ZeusTransformUtils.preCheckCast(r34, NoteEntity.class, "com.obric.memorydata.plugin")).getText();
        String r26 = null;
        FormatModeEnum r27 = ((NoteEntity) ZeusTransformUtils.preCheckCast(r34, NoteEntity.class, "com.obric.memorydata.plugin")).getFormatMode();
        if (r27 == null) goto L27;
        String r28 = r27.name();
    L28:
        String r29 = ((NoteEntity) ZeusTransformUtils.preCheckCast(r34, NoteEntity.class, "com.obric.memorydata.plugin")).getNoteFolder();
        boolean r210 = ((NoteEntity) ZeusTransformUtils.preCheckCast(r34, NoteEntity.class, "com.obric.memorydata.plugin")).isFavorite();
        if (((NoteEntity) ZeusTransformUtils.preCheckCast(r34, NoteEntity.class, "com.obric.memorydata.plugin")).getFiles() != null) goto L31;
        String r211 = null;
    L32:
        String r212 = null;
        String r213 = null;
        if (((NoteEntity) ZeusTransformUtils.preCheckCast(r34, NoteEntity.class, "com.obric.memorydata.plugin")).getRecordings() != null) goto L35;
        String r32 = null;
    L47:
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new gu(r14, r15, r16, r110, r111, r112, r113, r114, r21, r22, r25, r26, r28, r29, r210, r211, r212, r213, r32, 198945, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    L35:
        List<RecordingEntity> r0 = ((NoteEntity) ZeusTransformUtils.preCheckCast(r34, NoteEntity.class, "com.obric.memorydata.plugin")).getRecordings();
        Intrinsics.checkNotNull(r0);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r33 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r36 = r1.iterator();
    L37:
        if (r36.hasNext() == false) goto L39;
        r33.add(((RecordingEntity) ZeusTransformUtils.preCheckCast(r36.next(), RecordingEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L37
    L39:
        r32 = ((List) ZeusTransformUtils.preCheckCast(r33, List.class, "com.obric.memorydata.plugin")).toString();
        goto L47
    L31:
        r211 = EntityExtKt.getEntityGson().toJson(((NoteEntity) ZeusTransformUtils.preCheckCast(r34, NoteEntity.class, "com.obric.memorydata.plugin")).getFiles());
        goto L32
    L27:
        r28 = null;
        goto L28
    L42:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean delete(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "entityId");
        Intrinsics.checkNotNullParameter(r13, ObricMemoryConstants.KEY_PACKAGE_NAME);
        com.obric.memorydata.database.a r1 = a(r12, r13);
        if (ZeusTransformUtils.instanceOf(r1, gu.class) == false) goto L22;
        String r2 = ((gu) ZeusTransformUtils.preCheckCast(r1, gu.class, "com.obric.memorydata.plugin")).j();
        List<String> r3 = null;
        if (r2 != null) goto L23;
    L13:
        if (r3 == null) goto L22;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRecordingRawDbDao().queryByEntityIdList(r3), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r0.hasNext() == false) goto L22;
        gw r4 = (gw) ZeusTransformUtils.preCheckCast(r0.next(), gw.class, "com.obric.memorydata.plugin");
        r4.delete();
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getNoteRecordingTextRawDbDao().queryByParentEntityId(r4.getEntityId()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L19:
        if (r5.hasNext() == false) goto L16;
        ((gy) ZeusTransformUtils.preCheckCast(r5.next(), gy.class, "com.obric.memorydata.plugin")).delete();
        goto L19
    L23:
        r3 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r2, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L8 JsonSyntaxException -> L10
        goto L13
    L10:
        e = e;
        IRunLog r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r7 = new StringBuilder();
    L12:
        IRunLog.a.b(r6, "GsonExt", r7.append("toListObj error : ").append(e).toString(), null, 4, null);
    L8:
        e = e;
        r6 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = new StringBuilder();
    L22:
        return super.delete(r12, r13);
    }
}
