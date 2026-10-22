package com.obric.memorydata.memory.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Parcelable;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capability.schedulekit.JobResultWrapper;
import com.obric.capabilitykit.common.execution.IntentExecutionRecord;
import com.obric.capabilitykit.common.execution.JobResult;
import com.obric.capabilitykit.common.intent.CalendarShowScheduleParams;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.MessagesShowMessageParams;
import com.obric.capabilitykit.common.intent.PhoneShowCallHistoryParams;
import com.obric.capabilitykit.common.intent.RecorderShowRecordingParams;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.bo;
import com.obric.memorydata.database.entity.bt;
import com.obric.memorydata.database.entity.cr;
import com.obric.memorydata.database.entity.ct;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.ig;
import com.obric.memorydata.database.entity.ih;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.intent.TargetEntity;
import com.obric.memorydata.memory.ui.detail.ImageViewerActivity;
import com.obric.memorydata.memory.ui.list.MemoryTab;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ!\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u0007J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0007J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0007J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0019\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u001e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010\n\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u0004\u0018\u00010 2\u0006\u0010\n\u001a\u00020\u0007J\u0018\u0010)\u001a\u0004\u0018\u00010 2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010*\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\u0006\u0010+\u001a\u00020 H\u0086@¢\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020\t2\u0006\u0010+\u001a\u00020 H\u0086@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\"2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u0018\u00104\u001a\u00020\t2\u0006\u00100\u001a\u0002012\u0006\u00105\u001a\u000206H\u0007J\u000e\u00107\u001a\u00020\"2\u0006\u0010+\u001a\u00020 J\u001e\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\tJ\u000e\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020:J\u0016\u0010?\u001a\u00020\u00072\u0006\u0010>\u001a\u00020:2\u0006\u0010<\u001a\u00020\tJ\u0016\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\tJ\u0016\u0010D\u001a\u00020\t2\u0006\u0010E\u001a\u00020:2\u0006\u0010F\u001a\u00020:J,\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00070H2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020J0H2\b\u0010K\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010LJ,\u0010M\u001a\b\u0012\u0004\u0012\u00020 0H2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020J0H2\b\u0010K\u001a\u0004\u0018\u00010\u0007H\u0086@¢\u0006\u0002\u0010LJ\u0012\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010R\u001a\u0004\u0018\u00010QJ\u000e\u0010S\u001a\u00020T2\u0006\u00100\u001a\u000201J\u000e\u0010U\u001a\u00020T2\u0006\u00100\u001a\u000201R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/obric/memorydata/memory/utils/MemoryUtils;", "", "<init>", "()V", "imageViewerLaunchGate", "Lcom/obric/memorydata/memory/ui/detail/ImageViewerLaunchGate;", "TAG", "", "isMemoryEntityExist", "", "memoryEntityId", "type", "", "(Ljava/lang/String;Ljava/lang/Integer;)Z", "queryMemoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "memoryEntity", "queryMemoryEntityByUUID", Api.KEY_UUID, "queryAudioMemory", "Lcom/obric/memorydata/database/entity/RawAuditoryRecordingEntity;", "audioMemoryId", "queryScreenMemory", "Lcom/obric/capabilitykit/entity/app/ProactiveMemoryEntity;", "entityId", "queryAutoMemoryProEntity", "Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "hasOldMemoryEntityCalendarExtracted", "getTab", "Lcom/obric/memorydata/memory/ui/list/MemoryTab;", "inputAppEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "markOldMemoryEntityCalendarExtracted", "", "memoryEntityToCalendar", "Lcom/obric/memorydata/database/entity/MemoryEntityToCalendar;", "viewSourceAppEntity", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSourceAppEntity", "viewAppEntity", "appEntity", "(Landroid/app/Activity;Lcom/obric/capabilitykit/entity/app/AppEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "viewAppEntityByIntentSDK", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "viewImage", "context", "Landroid/content/Context;", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "safeStartActivity", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "viewAuditoryMemoryDetail", "getTimeStringFromTimestamp", "startTimeStamp", "", "endTimeStamp", "isShowDate", "timestampToTimeLineDate", "timestamp", "timestampToCardTimeString", "getDateStringFromTimestamp", "date", "Ljava/time/LocalDate;", "useRelativeDate", "isSameHour", "timestamp1", "timestamp2", "deleteByEntities", "", "entities", "Lcom/obric/memorydata/memory/intent/TargetEntity;", "deleteMethod", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByEntitiesWithAppEntities", "OLD_AUTHORITY", "NEW_AUTHORITY", "fixContentUri", "Landroid/net/Uri;", "uri", "getFontScale", "", "getDisplaySizeScale", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f11537a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.memorydata.memory.ui.detail.l f11538b = null;

    static {
        f11537a = new f();
        f11538b = new com.obric.memorydata.memory.ui.detail.l(0, 1, null);
    }

    private f() {
    }

    public static /* synthetic */ MemoryEntity a(f r0, String r1, Integer r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.a(r1, r2);
    }

    public final Uri a(Uri r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r4.getAuthority(), "com.obric.memorydata.fileprovider") == true) goto L8;
        return r4;
    L8:
        String r3 = r4.getLastPathSegment();
        if (r3 != null) goto L11;
        return r4;
    L11:
        List<String> r0 = r4.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(r0, "getPathSegments(...)");
        String r1 = (String) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r0), String.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r1, "memory_image") == false) goto L14;
        r1 = "com.obric.memorydata.plugin_memory_image";
    L17:
        return new Uri.Builder().scheme(Params.CONTENT).authority("com.larus.nova.zeus.memorydata.fileprovider").appendPath(r1).appendPath(r3).build();
    L14:
        if (r1 != null) goto L17;
        return r4;
    }

    public final AppEntity a(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, Api.KEY_UUID);
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r1 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(r3);
        if (r1 == null) goto L5;
        com.obric.memorydata.database.entity.d r4 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r1.queryByUUID(r2), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L6:
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.convertToAppEntity();
    L5:
        r4 = null;
        goto L6
    }

    public final MemoryEntity a(MemoryEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "memoryEntity");
        if (r3.getType() == 10105) goto L12;
        bt r2 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getCollectMemoryWithRelevantByEntityId(r3.getId());
        if (r2 == null) goto L9;
        RawMemoryEntity r4 = new bo(r2.a(), r2.b()).a();
        if (r4 == null) goto L9;
        return com.obric.memorydata.database.entity.memoryindex.m.a().toMemoryEntity(r4);
    L9:
        return null;
    L12:
        return a(r3.getId(), Integer.valueOf(r3.getType()));
    }

    public final MemoryEntity a(String r5) {
        Intrinsics.checkNotNullParameter(r5, Api.KEY_UUID);
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new KFunction[]{new MemoryUtils$queryMemoryEntityByUUID$1(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao()), new MemoryUtils$queryMemoryEntityByUUID$2(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao())}), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        MemoryEntity r2 = null;
        if (r4.hasNext() == false) goto L13;
        com.obric.memorydata.database.entity.d r0 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.preCheckCast((KFunction) ZeusTransformUtils.preCheckCast(r4.next(), KFunction.class, "com.obric.memorydata.plugin"), Function1.class, "com.obric.memorydata.plugin")).invoke(r5), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        AppEntity r1 = r0.convertToAppEntity();
    L10:
        if (ZeusTransformUtils.instanceOf(r1, MemoryEntity.class) == false) goto L12;
        r2 = (MemoryEntity) ZeusTransformUtils.preCheckCast(r1, MemoryEntity.class, "com.obric.memorydata.plugin");
    L12:
        if (r2 == null) goto L3;
    L8:
        r1 = null;
    L13:
        return r2;
    }

    public final MemoryEntity a(String r2, Integer r3) {
        Intrinsics.checkNotNullParameter(r2, "memoryEntityId");
        if (r3 != null) goto L6;
    L12:
        bt r4 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().getCollectMemoryWithRelevantByEntityId(r2);
        if (r4 == null) goto L20;
        RawMemoryEntity r5 = new bo(r4.a(), r4.b()).a();
        if (r5 != null) goto L19;
        return null;
    L19:
        return com.obric.memorydata.database.entity.memoryindex.m.a().toMemoryEntity(r5);
    L20:
        return null;
    L6:
        if (r3.intValue() != 10105) goto L12;
        ih r6 = (ih) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByEntityIdWithRelevantPojo(r2)), ih.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L17;
        r5 = new ig(r6.a(), r6.b()).c();
        if (r5 != null) goto L19;
        return null;
    L17:
        return null;
    }

    public final MemoryTab a(AppEntity r1) {
        if (r1 == null) goto L18;
        int r0 = r1.getType();
        if (r0 == 502) goto L17;
        if (r0 == 20001) goto L20;
        if (r0 == 10201) goto L18;
        if (r0 == 10202) goto L18;
        switch(r0) {
            case 10101: goto L19;
            case 10102: goto L19;
            case 10103: goto L19;
            case 10104: goto L19;
            case 10105: goto L19;
            default: goto L18;
        };
    L19:
        return MemoryTab.PROFILE;
    L20:
        return MemoryTab.OBSERVATION;
    L17:
        return MemoryTab.AUDIO;
    L18:
        return MemoryTab.COLLECT;
    }

    public final Object a(Activity r23, AppEntity r24, Continuation<? super Unit> r25) {
        AppEntity r1 = r24;
        Activity r2 = (Activity) ZeusTransformUtils.wrapperContextForParams(r23, Activity.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, MemoryUtils$viewAppEntity$1.class) == false) goto L7;
        MemoryUtils$viewAppEntity$1 r5 = (MemoryUtils$viewAppEntity$1) ZeusTransformUtils.preCheckCast(r4, MemoryUtils$viewAppEntity$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r6 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L18;
        if (r7 == 1) goto L17;
        if (r7 == 2) goto L16;
        if (r7 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        JobResult r0 = (JobResult) ZeusTransformUtils.preCheckCast(r5.L$0, JobResult.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
    L57:
        return Unit.INSTANCE;
    L17:
        AppEntity r3 = (AppEntity) ZeusTransformUtils.preCheckCast(r5.L$1, AppEntity.class, "com.obric.memorydata.plugin");
        r2 = (Activity) ZeusTransformUtils.preCheckCast(r5.L$0, Activity.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        r1 = r3;
        Object r8 = r6;
        Object r9 = r15;
    L39:
        JobResultWrapper r10 = (JobResultWrapper) ZeusTransformUtils.preCheckCast(r8, JobResultWrapper.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("MemoryUtils", "viewAppEntity: jobResult: " + r10);
        if (r10 == null) goto L57;
        JobResult r11 = r10.getJobResult();
        if (r11 == null) goto L57;
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r11.getExecRecords(), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L57;
        int r12 = ((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r11.getExecRecords().get(0), IntentExecutionRecord.class, "com.obric.memorydata.plugin")).getResult().getRet();
        if (r12 != (-2005)) goto L48;
        CoroutineContext r13 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r14 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryUtils$viewAppEntity$2$2(r2, r1, null), Function2.class, "com.obric.memorydata.plugin");
        r5.L$0 = r11;
        r5.L$1 = null;
        r5.label = 3;
        if (kotlinx.coroutines.i.a(r13, r14, r5) != r9) goto L57;
        return r9;
    L48:
        if (r12 != 200) goto L57;
        CoroutineContext r16 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r17 = (Function2) ZeusTransformUtils.preCheckCast(new MemoryUtils$viewAppEntity$2$1(r2, null), Function2.class, "com.obric.memorydata.plugin");
        r5.L$0 = r11;
        r5.L$1 = null;
        r5.label = 2;
        if (kotlinx.coroutines.i.a(r16, r17, r5) != r9) goto L57;
        return r9;
    L18:
        ResultKt.throwOnFailure(r6);
        if (ZeusTransformUtils.instanceOf(r1, PhotoEntity.class) == false) goto L24;
        a((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"), ((PhotoEntity) ZeusTransformUtils.preCheckCast(r1, PhotoEntity.class, "com.obric.memorydata.plugin")).getFile());
    L22:
        return Unit.INSTANCE;
    L24:
        if (ZeusTransformUtils.instanceOf(r1, MessageEntity.class) == false) goto L28;
        IntentParams r18 = (IntentParams) ZeusTransformUtils.preCheckCast(new MessagesShowMessageParams((MessageEntity) ZeusTransformUtils.preCheckCast(r1, MessageEntity.class, "com.obric.memorydata.plugin")), IntentParams.class, "com.obric.memorydata.plugin");
        String r19 = "Messages_ShowMessage";
    L26:
        IntentParams r20 = r18;
        String r21 = r19;
        com.obric.capability.schedulekit.a r22 = com.obric.capability.schedulekit.a.f7373a;
        r5.L$0 = r2;
        r5.L$1 = r1;
        r5.label = 1;
        r9 = r15;
        r8 = com.obric.capability.schedulekit.a.a(r22, r21, r20, 0, 0, null, false, null, r5, 124, null);
        if (r8 != r9) goto L39;
        return r9;
    L28:
        if (ZeusTransformUtils.instanceOf(r1, ScheduleEntity.class) == false) goto L31;
        r18 = (IntentParams) ZeusTransformUtils.preCheckCast(new CalendarShowScheduleParams((ScheduleEntity) ZeusTransformUtils.preCheckCast(r1, ScheduleEntity.class, "com.obric.memorydata.plugin")), IntentParams.class, "com.obric.memorydata.plugin");
        r19 = "Calendar_ShowSchedule";
        goto L26
    L31:
        if (ZeusTransformUtils.instanceOf(r1, CallHistoryEntity.class) == false) goto L34;
        r18 = (IntentParams) ZeusTransformUtils.preCheckCast(new PhoneShowCallHistoryParams((CallHistoryEntity) ZeusTransformUtils.preCheckCast(r1, CallHistoryEntity.class, "com.obric.memorydata.plugin")), IntentParams.class, "com.obric.memorydata.plugin");
        r19 = "Phone_ShowCallHistory";
        goto L26
    L34:
        if (ZeusTransformUtils.instanceOf(r1, RecordingEntity.class) == false) goto L58;
        r18 = (IntentParams) ZeusTransformUtils.preCheckCast(new RecorderShowRecordingParams((RecordingEntity) ZeusTransformUtils.preCheckCast(r1, RecordingEntity.class, "com.obric.memorydata.plugin")), IntentParams.class, "com.obric.memorydata.plugin");
        r19 = "Recorder_ShowRecording";
        goto L26
    L58:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUtils", "viewAppEntity: unknown appEntity " + r24.getType(), null, 4, null);
    L7:
        r5 = new MemoryUtils$viewAppEntity$1(this, r4);
        goto L8
    }

    public final Object a(Activity r4, String r5, Continuation<? super Unit> r6) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        Object r8 = kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryUtils$viewSourceAppEntity$2(r5, r3, null), Function2.class, "com.obric.memorydata.plugin"), r7);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to calculate best type for var: r3v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v12 ??, new type: java.util.Collection
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v12 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v12 ??, new type: java.util.Collection
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v13 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v13 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v13 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public final java.lang.Object a(com.obric.capabilitykit.entity.app.AppEntity r18, kotlin.coroutines.Continuation<? super java.lang.Boolean> r19) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x012f: CHECK_CAST (r3v12 ?? I:java.util.Collection) = (java.util.Collection) (r3v11 java.lang.Object) in method: com.obric.memorydata.memory.utils.f.a(com.obric.capabilitykit.entity.app.AppEntity, kotlin.coroutines.Continuation<? super java.lang.Boolean>):java.lang.Object, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.memorydata.memory.utils.f.a(com.obric.capabilitykit.entity.app.AppEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object a(List<TargetEntity> r10, String r11, Continuation<? super List<? extends AppEntity>> r12) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUtils", "entities size: " + r9.size(), false, 4, null);
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");
        Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L8;
        Object r17 = r16.next();
        if (at.a(((TargetEntity) ZeusTransformUtils.preCheckCast(r17, TargetEntity.class, "com.obric.memorydata.plugin")).get_packageName()) == false) goto L4;
        r15.add(r17);
        goto L4
    L8:
        Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r20 = r18.iterator();
    L10:
        if (r20.hasNext() == false) goto L12;
        TargetEntity r110 = (TargetEntity) ZeusTransformUtils.preCheckCast(r20.next(), TargetEntity.class, "com.obric.memorydata.plugin");
        r19.add(new cu(r110.getId(), cu.f8996a.a(r110.getType()), r110.get_packageName(), null, 8, null));
        goto L10
    L12:
        List r21 = (List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin");
        long r1 = System.currentTimeMillis();
        List<AppEntity> r22 = d.f11534a.b((Collection) ZeusTransformUtils.preCheckCast(r21, Collection.class, "com.obric.memorydata.plugin"), r11);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryUtils", "delete cost time: " + (System.currentTimeMillis() - r1) + " ms", false, 4, null);
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r111 = new StringBuilder().append("successful delete appEntities size: ");
        if (r22 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("appEntities");
        List<AppEntity> r112 = null;
    L16:
        IRunLog.a.a(r0, "MemoryUtils", r111.append(r112.size()).toString(), false, 4, null);
        return r22;
    L15:
        r112 = r22;
        goto L16
    }

    public final String a(long r3) {
        String r2 = new SimpleDateFormat("HH:00", Locale.getDefault()).format(new Date(r3));
        Intrinsics.checkNotNullExpressionValue(r2, "format(...)");
        return r2;
    }

    public final String a(long r6, long r8, boolean r10) {
        SimpleDateFormat r0 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String r1 = r0.format(new Date(r6));
        String r2 = r0.format(new Date(r8));
        if (r10 == false) goto L15;
        LocalDate r7 = Instant.ofEpochMilli(r6).atZone(ZoneId.systemDefault()).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(r7, "toLocalDate(...)");
        String r9 = a(r7, false);
        if (Intrinsics.areEqual(r1, r2) == false) goto L9;
        StringBuilder r5 = new StringBuilder().append(r9).append(' ').append(r1);
    L8:
        return r5.toString();
    L9:
        LocalDate r11 = Instant.ofEpochMilli(r8).atZone(ZoneId.systemDefault()).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(r11, "toLocalDate(...)");
        String r12 = a(r11, false);
        if (Intrinsics.areEqual(r9, r12) == false) goto L13;
        StringBuilder r13 = new StringBuilder().append(r9).append(' ').append(r1).append('-');
    L12:
        r5 = r13.append(r2);
        goto L8
    L13:
        r13 = new StringBuilder().append(r9).append(' ').append(r1).append('-').append(r12).append(' ');
        goto L12
    L15:
        if (Intrinsics.areEqual(r1, r2) == false) goto L18;
        Intrinsics.checkNotNull(r1);
        return r1;
    L18:
        return r1 + '-' + r2;
    }

    public final String a(long r5, boolean r7) {
        if (r7 == false) goto L4;
        LocalDate r0 = Instant.ofEpochMilli(r5).atZone(ZoneId.systemDefault()).toLocalDate();
        Intrinsics.checkNotNullExpressionValue(r0, "toLocalDate(...)");
        String r4 = a(r0, false);
    L5:
        long r1 = System.currentTimeMillis() - r5;
        if (r1 < 180000) goto L8;
    L10:
        String r6 = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(r5));
    L11:
        if (r7 == true) goto L15;
        Intrinsics.checkNotNull(r6);
        return r6;
    L15:
        return r4 + ' ' + r6;
    L8:
        if (r1 < 0) goto L10;
        r6 = at.a(ZeusTransformUtils.mapRes(R.string.memory_just_now, TypedValues.Custom.S_STRING, "memory_just_now"));
        goto L11
    L4:
        r4 = "";
        goto L5
    }

    public final String a(LocalDate r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "date");
        if (r8 == false) goto L24;
        LocalDate r6 = LocalDate.now(ZoneId.systemDefault());
        long r2 = ChronoUnit.DAYS.between((Temporal) ZeusTransformUtils.preCheckCast(r6, Temporal.class, "com.obric.memorydata.plugin"), (Temporal) ZeusTransformUtils.preCheckCast(r7, Temporal.class, "com.obric.memorydata.plugin"));
        if (r2 != 0) goto L9;
        String r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_date_today, TypedValues.Custom.S_STRING, "memory_date_today"));
        Intrinsics.checkNotNullExpressionValue(r9, "getString(...)");
        return r9;
    L9:
        if (r2 != (-1)) goto L13;
        String r10 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_date_yesterday, TypedValues.Custom.S_STRING, "memory_date_yesterday"));
        Intrinsics.checkNotNullExpressionValue(r10, "getString(...)");
        return r10;
    L13:
        if (r2 != (-2)) goto L17;
        String r11 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_date_before_yesterday, TypedValues.Custom.S_STRING, "memory_date_before_yesterday"));
        Intrinsics.checkNotNullExpressionValue(r11, "getString(...)");
        return r11;
    L17:
        if (r2 != 1) goto L21;
        String r12 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_date_tomorrow, TypedValues.Custom.S_STRING, "memory_date_tomorrow"));
        Intrinsics.checkNotNullExpressionValue(r12, "getString(...)");
        return r12;
    L21:
        if (r2 != 2) goto L24;
        String r13 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(ZeusTransformUtils.mapRes(R.string.memory_date_after_tomorrow, TypedValues.Custom.S_STRING, "memory_date_after_tomorrow"));
        Intrinsics.checkNotNullExpressionValue(r13, "getString(...)");
        return r13;
    L24:
        long r14 = r7.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return com.obric.memorydata.memory.ui.e.f10891a.a(r14);
    }

    public final void a(Context r5, FileEntity r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r6, "fileEntity");
        if (f11538b.a(SystemClock.elapsedRealtime()) == true) goto L6;
        RunLog.INSTANCE.debug("MemoryUtils", "ignore duplicated image viewer launch");
        return;
    L6:
        Intent r0 = new Intent(r7, ImageViewerActivity.class);
        r0.putExtra(ImageViewerActivity.EXTRA_IMAGE_URI, (Parcelable) ZeusTransformUtils.preCheckCast(r6.getContentUrl(), Parcelable.class, "com.obric.memorydata.plugin"));
        r0.putExtra(ImageViewerActivity.EXTRA_SCALE_BOUNCE_BACK, true);
        if (ZeusTransformUtils.instanceOf(r7, Activity.class) == false) goto L9;
        Activity r8 = (Activity) ZeusTransformUtils.preCheckCast(r7, Activity.class, "com.obric.memorydata.plugin");
    L10:
        if (r8 == null) goto L13;
        com.obric.memorydata.memory.ui.detail.p.f10869a.a(r8);
    L13:
        if (a(r7, r0) == false) goto L16;
        if (r8 == null) goto L16;
        r8.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        return;
    L16:
        com.obric.memorydata.memory.ui.detail.p.f10869a.b();
        return;
    L9:
        r8 = null;
        goto L10
    }

    public final void a(cr r1) {
        Intrinsics.checkNotNullParameter(r1, "memoryEntityToCalendar");
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryEntityToCalendarDao().insert(r1);
    }

    public final boolean a(long r1, long r3) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r1);
        int r2 = r0.get(11);
        Calendar r4 = Calendar.getInstance();
        r4.setTimeInMillis(r3);
        if (r2 != r4.get(11)) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean a(Context r2, Intent r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.INTENT);
        return com.obric.memorydata.utils.ba.a(r1, r3);
    }

    public final fj b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "audioMemoryId");
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao().queryByEntityId(r1);
    }

    public final void b(AppEntity r5) {
        Intrinsics.checkNotNullParameter(r5, "appEntity");
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intent r1 = new Intent();
        r1.setClassName("com.obric.recorder", "com.bytedanceos.recorder.activity.RecorderPlayActivity");
        r1.putExtra("RECORD_URI", r5.getId());
        r1.setFlags(268468224);
        Unit r6 = Unit.INSTANCE;
        a(r0, r1);
    }

    public final boolean b(MemoryEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "memoryEntity");
        if (ArraysKt.contains(new int[]{EntityType.MEMORY_EVENT_TODO, EntityType.MEMORY_EVENT_SCHEDULE, 10006, 10001, 10002, 10004}, r2.getType()) == true) goto L5;
    L8:
        return true;
    L5:
        if (MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryEntityToCalendarDao().exists(r2.getId()) == true) goto L8;
        return false;
    }

    public final ProactiveMemoryEntity c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "entityId");
        EpisodicMemoryEntity r1 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().queryByEntityId(r2);
        if (r1 == null) goto L5;
        AppEntity r3 = r1.convertToAppEntity();
    L7:
        if (ZeusTransformUtils.instanceOf(r3, ProactiveMemoryEntity.class) == true) goto L9;
        return null;
    L9:
        return (ProactiveMemoryEntity) ZeusTransformUtils.preCheckCast(r3, ProactiveMemoryEntity.class, "com.obric.memorydata.plugin");
    L5:
        r3 = null;
        goto L7
    }

    public final AutoMemoryProEntity d(String r1) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryByEntityId(r1);
    }

    public final AppEntity e(String r5) {
        Intrinsics.checkNotNullParameter(r5, "memoryEntityId");
        RawMemoryEntity r4 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryByEntityId(r5);
        if (r4 != null) goto L5;
        return null;
    L5:
        List<ct> r6 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMemoryMapTableDao().queryByMemoryRawDbId(r4.getId());
        if (r6.isEmpty() == false) goto L8;
        return null;
    L8:
        long r0 = ((ct) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r6), ct.class, "com.obric.memorydata.plugin")).c();
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r7 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(((ct) ZeusTransformUtils.preCheckCast(CollectionsKt.first(r6), ct.class, "com.obric.memorydata.plugin")).b());
        if (r7 == null) goto L11;
        com.obric.memorydata.database.entity.d r8 = (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r7.queryById(r0), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L12:
        if (r8 != null) goto L14;
        return null;
    L14:
        return r8.convertToAppEntity();
    L11:
        r8 = null;
        goto L12
    }
}
