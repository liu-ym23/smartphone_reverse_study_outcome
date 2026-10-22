package com.obric.memorydata.personalcontext.poison;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u0004\u0018\u00010\u0005\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u0002H\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n¢\u0006\u0002\u0010\u000bJ-\u0010\f\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u0002H\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\n¢\u0006\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/personalcontext/poison/EntityPoisonRecallSnapshotPreparer;", "", "<init>", "()V", LBSLightLocationTraceLogger.PREPARE, "Lcom/obric/capabilitykit/entity/app/AppEntity;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "entity", "dao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "(Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;)Lcom/obric/capabilitykit/entity/app/AppEntity;", "materialize", "(Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;)Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "MAX_BACKFILL_ATTEMPTS", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f12254a = null;

    static {
        f12254a = new g();
    }

    private g() {
    }

    public final <T extends com.obric.memorydata.database.entity.d> AppEntity a(T r3, IAppEntityRawDbDao<T> r4) {
        IAppEntityRawDbDao<T> r5 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "entity");
        Intrinsics.checkNotNullParameter(r5, "dao");
        com.obric.memorydata.database.entity.d r2 = b(r3, r5);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.convertToAppEntity();
    }

    public final <T extends com.obric.memorydata.database.entity.d> T b(T r13, IAppEntityRawDbDao<T> r14) {
        IAppEntityRawDbDao r12 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r14, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "entity");
        Intrinsics.checkNotNullParameter(r12, "dao");
        int r9 = 0;
    L4:
        if (r9 >= 2) goto L28;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r13.getContentHash(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L13;
        AppEntity r3 = r13.convertToAppEntity();
        if (r3 == null) goto L16;
        String r11 = a.f12244a.a(r3);
        if (r11 == null) goto L19;
        if (r12.backfillContentHashIfAbsent(r13.getId(), r13.getModifyTime(), r13.getTimestamp(), r11) > 0) goto L22;
        r13 = (T) ZeusTransformUtils.preCheckCast(r12.queryById(r13.getId()), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L26;
        r9 = r9 + 1;
        goto L4
    L26:
        return null;
    L22:
        r13.setContentHash(r11);
        return r13;
    L19:
        return r13;
    L16:
        return null;
    L13:
        return r13;
    L8:
        if (StringsKt.isBlank(r1) == true) goto L11;
        r2 = false;
        goto L12
    L28:
        return r13;
    }
}
