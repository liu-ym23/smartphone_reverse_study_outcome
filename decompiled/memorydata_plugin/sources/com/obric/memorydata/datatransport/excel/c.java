package com.obric.memorydata.datatransport.excel;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.platform.godzilla.anr.monitor.idletask.ArrayListWrapper;
import com.google.gson.Gson;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.dao.EvaluationSourceDataDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.bu;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ab;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086\bJ+\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\bJ\u001c\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u000bJ\u001e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\rJ\u0016\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/datatransport/excel/ExcelExtraUtils;", "", "<init>", "()V", "TAG", "", "evaluationSourceDataDao", "Lcom/obric/memorydata/database/dao/EvaluationSourceDataDao;", "getEvaluationSourceDataDao", "()Lcom/obric/memorydata/database/dao/EvaluationSourceDataDao;", ChatMessage.TYPE_QUERY, "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/datatransport/excel/ExcelExtra;", "sessionType", "Lcom/obric/memorydata/datatransport/excel/SessionType;", "keyword", "insert", "", "dataList", BuildConfig.CHANNEL, "oldData", "newData", "delete", "dataToDelete", "data_transport_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f9748a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final EvaluationSourceDataDao f9749b = null;

    static {
        f9748a = new c();
        f9749b = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getEvaluationSourceDataDao();
    }

    private c() {
    }

    public final EvaluationSourceDataDao a() {
        return f9749b;
    }

    public final void delete(SessionType r4, b r5) {
        Intrinsics.checkNotNullParameter(r4, "sessionType");
        Intrinsics.checkNotNullParameter(r5, "dataToDelete");
        String r6 = ab.a().toJson(r5);
        EvaluationSourceDataDao r0 = f9749b;     // Catch: Exception -> L5
        String r7 = r4.getValue();     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L5
        r0.deleteBySessionTypeAndExtra(r7, r6);     // Catch: Exception -> L5
        RunLog.INSTANCE.debug("ExcelUtils", "ExcelExtra data deleted successfully.");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        RunLog.INSTANCE.debug("ExcelUtils", "Fail to delete ExcelExtra data: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
    }

    public final void insert(SessionType r33, List<? extends b> r34) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r33, "sessionType");
        Intrinsics.checkNotNullParameter(r0, "dataList");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        String r19 = ab.a().toJson((b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L8
        EvaluationSourceDataDao r1 = f9749b;     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r19);     // Catch: Exception -> L8
        r1.insert(new bu(0, 0, 0, null, null, 0, 0, r33.getValue(), null, null, null, null, r19, 0, null, null, null, null, null, 0, null, 0, 4190079, null));     // Catch: Exception -> L8
    L8:
        e = move-exception;
        RunLog.INSTANCE.debug("ExcelUtils", "Fail to save ExcelExtra data: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        goto L4
    }

    public final /* synthetic */ <T extends b> List<T> query(SessionType r6) {
        Intrinsics.checkNotNullParameter(r6, "sessionType");
        List<bu> r5 = a().queryBySessionType(r6.getValue());
        ArrayListWrapper r7 = (List<T>) ((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        bu r0 = (bu) ZeusTransformUtils.preCheckCast(r8.next(), bu.class, "com.obric.memorydata.plugin");
        Gson r2 = ab.a();     // Catch: Exception -> L10
        String r1 = r0.m();     // Catch: Exception -> L10
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L10
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2.fromJson(r1, (Class) ZeusTransformUtils.preCheckCast(b.class, Class.class, "com.obric.memorydata.plugin")), b.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
        if (r3 == null) goto L4;
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(Boolean.valueOf(r7.add((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"))), Boolean.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        RunLog.INSTANCE.debug("ExcelUtils", "Fail to handle extra string: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        goto L4
    L12:
        return r7;
    }

    public final /* synthetic */ <T extends b> List<T> query(SessionType r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "sessionType");
        Intrinsics.checkNotNullParameter(r9, "keyword");
        List<bu> r7 = a().queryBySessionType(r8.getValue());
        ArrayListWrapper r10 = (List<T>) ((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin"));
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        bu r0 = (bu) ZeusTransformUtils.preCheckCast(r11.next(), bu.class, "com.obric.memorydata.plugin");
    L12:
        e = move-exception;
        RunLog.INSTANCE.debug("ExcelUtils", "Fail to handle extra string: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
        goto L4
    L7:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r0.m(), CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L4;
        Gson r2 = ab.a();     // Catch: Exception -> L12
        String r1 = r0.m();     // Catch: Exception -> L12
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: Exception -> L12
        b r3 = (b) ZeusTransformUtils.preCheckCast(r2.fromJson(r1, (Class) ZeusTransformUtils.preCheckCast(b.class, Class.class, "com.obric.memorydata.plugin")), b.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        if (r3 == null) goto L4;
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(Boolean.valueOf(r10.add((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin"))), Boolean.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        goto L4
    L14:
        return r10;
    }

    public final void update(SessionType r31, b r32, b r33) {
        Intrinsics.checkNotNullParameter(r31, "sessionType");
        Intrinsics.checkNotNullParameter(r32, "oldData");
        Intrinsics.checkNotNullParameter(r33, "newData");
        String r0 = ab.a().toJson(r32);
        String r17 = ab.a().toJson(r33);
        EvaluationSourceDataDao r1 = f9749b;
        String r2 = r31.getValue();
        Intrinsics.checkNotNull(r0);
        bu r3 = r1.queryBySessionTypeAndExtra(r2, r0);
        if (r3 != null) goto L10;
        RunLog.INSTANCE.debug("ExcelUtils", "No matching ExcelExtra data found for update.");
        return;
    L10:
        Intrinsics.checkNotNull(r17);     // Catch: Exception -> L6
        r1.update(bu.a(r3, 0, 0, 0, null, null, 0, 0, r31.getValue(), null, null, null, null, r17, 0, null, null, null, null, null, 0, null, 0, 4190079, null));     // Catch: Exception -> L6
        RunLog.INSTANCE.debug("ExcelUtils", "ExcelExtra data updated successfully.");     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        RunLog.INSTANCE.debug("ExcelUtils", "Fail to update ExcelExtra data: " + ExceptionsKt.stackTraceToString((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin")));
    }
}
