package com.obric.memorydata.datatransport.transfer.buildmemory;

import com.obric.memorydata.database.aging.ScreenshotAttachmentAgingCheckpointStore;
import com.obric.memorydata.database.dao.RawObservationDao;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.ha;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\t"}, d2 = {"resetRawObservationImportStateAfterMemoryBuildImport", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "resetRawObservationScreenshotForImport", "Lcom/obric/memorydata/database/entity/RawObservationEntity;", "entity", "clearMissingViewTreePath", "", "payload", "data_transport_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class a {
    public static final RawObservationEntity a(RawObservationEntity r21) {
        Intrinsics.checkNotNullParameter(r21, "entity");
        if (Intrinsics.areEqual(r21.getSource(), "screenshot") == true) goto L6;
        return null;
    L6:
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(ha.f9173a.a(r21), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        return null;
    L8:
        String r14 = ha.f9173a.a(a(r21.getPayload()), "");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(ha.f9173a.c(r21), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L11;
        String r1 = "PENDING";
    L13:
        return RawObservationEntity.copy$default(r21, 0, null, null, 0, 0, 0, r14, null, RawObservationEntity.STATE_WAIT_MEDIA, r1, 0, 0, 191, null);
    L11:
        r1 = "NONE";
        goto L13
    }

    public static final z<Unit> a() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        RawObservationDao r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawObservationDao();     // Catch: Throwable -> L14
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2.queryAll(), Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L14
    L5:
        if (r5.hasNext() == false) goto L9;
        RawObservationEntity r6 = a((RawObservationEntity) ZeusTransformUtils.preCheckCast(r5.next(), RawObservationEntity.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L14
        if (r6 == null) goto L5;
        r4.add(r6);     // Catch: Throwable -> L14
        goto L5
    L9:
        List r7 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L12;
        r2.updateAll(r7);     // Catch: Throwable -> L14
    L12:
        ScreenshotAttachmentAgingCheckpointStore.f8838a.a();     // Catch: Throwable -> L14
        Object r8 = Result.m1421constructorimpl(new z.b(Unit.INSTANCE));     // Catch: Throwable -> L14
    L16:
        Throwable r9 = Result.m1424exceptionOrNullimpl(r8);
        if (r9 == null) goto L21;
        r8 = (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.OTHER, "导入后重置 RawObservation 状态失败: " + r9.getMessage(), r9)), z.class, "com.obric.memorydata.plugin");
    L21:
        return (z) ZeusTransformUtils.preCheckCast(r8, z.class, "com.obric.memorydata.plugin");
    L14:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    }

    private static final String a(String r3) {
        String r0 = ha.f9173a.b(r3);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return r3;
    L5:
        if (new File(r0).isFile() == false) goto L8;
        return r3;
    L8:
        return ha.f9173a.b(r3, "");
    }
}
