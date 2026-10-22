package com.obric.memorydata.personalcontext.datausage.plugin.action.manager;

import android.net.Uri;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.common.intent.PCPersonalContextFetchParams;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.controller.ApiController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.middleware.impl.image.ImageXBizType;
import com.obric.memorydata.middleware.impl.image.m;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.cu;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011H\u0082@¢\u0006\u0002\u0010\u0014J,\u0010\u0015\u001a\u0004\u0018\u00010\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/PersonalContextFetchIntentExecutor;", "Lcom/obric/memorydata/personalcontext/datausage/plugin/action/manager/IMemoryIntentExecutor;", "Lcom/obric/capabilitykit/common/intent/PCPersonalContextFetchParams;", "Lcom/obric/capabilitykit/common/intent/Empty;", "<init>", "()V", "TAG", "", "MAX_CONCURRENT_UPLOAD_COUNT", "", "doAction", "Lcom/obric/capabilitykit/common/intent/IntentResult;", TrackerImpl.PARAMS, "questionId", "", "(Lcom/obric/capabilitykit/common/intent/PCPersonalContextFetchParams;Ljava/lang/Long;)Lcom/obric/capabilitykit/common/intent/IntentResult;", "fetchRawPhotoUploadUrls", "", "entities", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadRawPhoto", "rawPhotoByEntityId", "", "Lcom/obric/memorydata/database/entity/RawPhotoEntity;", "entity", "(Ljava/util/Map;Lcom/obric/capabilitykit/entity/app/AppEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h implements d<PCPersonalContextFetchParams, Empty> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f12090a = null;

    static {
        f12090a = new h();
    }

    private h() {
    }

    public static final /* synthetic */ Object a(h r2, List r3, Continuation r4) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object a(h r2, Map r3, AppEntity r4, Continuation r5) {
        return r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x02c3 -> B:63:0x02c6). Please report as a decompilation issue!!! */
    private final Object a(List<? extends AppEntity> r18, Continuation<? super List<String>> r19) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$1.class) == false) goto L7;
        PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$1 r3 = (PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$1) ZeusTransformUtils.preCheckCast(r2, PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        Iterator r1 = (Iterator) ZeusTransformUtils.preCheckCast(r3.L$2, Iterator.class, "com.obric.memorydata.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(r3.L$1, Collection.class, "com.obric.memorydata.plugin");
        Map r8 = (Map) ZeusTransformUtils.preCheckCast(r3.L$0, Map.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
    L63:
        CollectionsKt.addAll(r7, (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin"));
    L59:
        if (r1.hasNext() == false) goto L65;
        Function2 r9 = (Function2) ZeusTransformUtils.preCheckCast(new PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$2$1((List) ZeusTransformUtils.preCheckCast(r1.next(), List.class, "com.obric.memorydata.plugin"), r8, null), Function2.class, "com.obric.memorydata.plugin");
        r3.L$0 = r8;
        r3.L$1 = r7;
        r3.L$2 = r1;
        r3.label = 1;
        r4 = cu.a(r9, r3);
        if (r4 != r5) goto L63;
        return r5;
    L65:
        return CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin");
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r12 = r10.iterator();
    L16:
        if (r12.hasNext() == false) goto L25;
        Object r13 = r12.next();
        AppEntity r14 = (AppEntity) ZeusTransformUtils.preCheckCast(r13, AppEntity.class, "com.obric.memorydata.plugin");
        if (r14.getType() != 301) goto L20;
        boolean r15 = true;
    L21:
        if (r15 == true) goto L23;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersonalContextFetchIntent", "unsupported entity type: " + r14.getType() + ", entityId: " + r14.getId(), null, 4, null);
    L23:
        if (r15 == false) goto L16;
        r11.add(r13);
        goto L16
    L20:
        r15 = false;
        goto L21
    L25:
        List r16 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r21 = r17.iterator();
    L27:
        if (r21.hasNext() == false) goto L36;
        AppEntity r22 = (AppEntity) ZeusTransformUtils.preCheckCast(r21.next(), AppEntity.class, "com.obric.memorydata.plugin");
        String r23 = r22.getId();
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L32;
        r23 = null;
    L32:
        if (r23 != null) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersonalContextFetchIntent", "blank entity id, entityType: " + r22.getType(), null, 4, null);
    L34:
        if (r23 == null) goto L27;
        r20.add(r23);
        goto L27
    L36:
        List<String> r24 = (List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin");
        if (r24.isEmpty() == true) goto L39;
        Iterable r25 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao().queryByEntityIdList(r24), Iterable.class, "com.obric.memorydata.plugin");
        Collection r26 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r27 = r25.iterator();
    L42:
        if (r27.hasNext() == false) goto L46;
        Object r28 = r27.next();
        if (ZeusTransformUtils.instanceOf(r28, hb.class) == false) goto L42;
        r26.add(r28);
        goto L42
    L46:
        Iterable r29 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r26, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r30 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r31 = r29.iterator();
    L48:
        if (r31.hasNext() == false) goto L53;
        Object r32 = r31.next();
        String r33 = ((hb) ZeusTransformUtils.preCheckCast(r32, hb.class, "com.obric.memorydata.plugin")).getEntityId();
        Object r110 = r30.get(r33);
        if (r110 != null) goto L52;
        r110 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r30.put(r33, r110);
    L52:
        ((List) ZeusTransformUtils.preCheckCast(r110, List.class, "com.obric.memorydata.plugin")).add(r32);
        goto L48
    L53:
        Map r34 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(MapsKt.mapCapacity(r30.size())), Map.class, "com.obric.memorydata.plugin");
        Iterator r35 = ((Iterable) ZeusTransformUtils.preCheckCast(r30.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L55:
        if (r35.hasNext() == false) goto L57;
        Object r36 = r35.next();
        r34.put(((Map.Entry) ZeusTransformUtils.preCheckCast(r36, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), (hb) ZeusTransformUtils.preCheckCast(CollectionsKt.first((List) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r36, Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), List.class, "com.obric.memorydata.plugin")), hb.class, "com.obric.memorydata.plugin"));
        goto L55
    L57:
        Iterable r37 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.chunked((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), 2), Iterable.class, "com.obric.memorydata.plugin");
        r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        r1 = r37.iterator();
        r8 = r34;
        goto L59
    L39:
        return CollectionsKt.emptyList();
    L7:
        r3 = new PersonalContextFetchIntentExecutor$fetchRawPhotoUploadUrls$1(this, r2);
        goto L8
    }

    private final Object a(Map<String, hb> r23, AppEntity r24, Continuation<? super String> r25) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r25, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, PersonalContextFetchIntentExecutor$uploadRawPhoto$1.class) == false) goto L7;
        PersonalContextFetchIntentExecutor$uploadRawPhoto$1 r3 = (PersonalContextFetchIntentExecutor$uploadRawPhoto$1) ZeusTransformUtils.preCheckCast(r2, PersonalContextFetchIntentExecutor$uploadRawPhoto$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        PersonalContextFetchIntentExecutor$uploadRawPhoto$1 r9 = r3;
        Object r4 = r9.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r9.label;
        boolean r12 = true;
        if (r6 == 0) goto L18;
        if (r6 != 1) goto L17;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r9.L$3, String.class, "com.obric.memorydata.plugin");
        Uri r7 = (Uri) ZeusTransformUtils.preCheckCast(r9.L$2, Uri.class, "com.obric.memorydata.plugin");
        String r8 = (String) ZeusTransformUtils.preCheckCast(r9.L$1, String.class, "com.obric.memorydata.plugin");
        AppEntity r10 = (AppEntity) ZeusTransformUtils.preCheckCast(r9.L$0, AppEntity.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L14
    L51:
        CharSequence r11 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r11 != null) goto L54;
    L57:
        if (r12 == false) goto L59;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersonalContextFetchIntent", "upload photo failed, entityId: " + r8 + ", entityType: " + r10.getType() + ", uri: " + r7 + ", sourcePackage: " + r1, null, 4, null);     // Catch: Throwable -> L14
    L59:
        return (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
    L54:
        if (StringsKt.isBlank(r11) == true) goto L57;
        r12 = false;
    L14:
        th = th;
    L63:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersonalContextFetchIntent", "upload photo error, entityId: " + r10.getId() + ", entityType: " + r10.getType() + ", error: " + th.getMessage(), null, 4, null);
        return null;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r4);
        String r13 = r24.getId();     // Catch: Throwable -> L61
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L22;
        return null;
    L22:
        hb r14 = (hb) ZeusTransformUtils.preCheckCast(r0.get(r13), hb.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        if (r14 != null) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersonalContextFetchIntent", "raw photo not found, entityId: " + r13 + ", entityType: " + r24.getType(), null, 4, null);     // Catch: Throwable -> L61
        return null;
    L27:
        if (Intrinsics.areEqual(r14.b(), "PHOTO") == true) goto L30;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersonalContextFetchIntent", "unsupported asset type: " + r14.b() + ", entityId: " + r13 + ", entityType: " + r24.getType(), null, 4, null);     // Catch: Throwable -> L61
        return null;
    L30:
        FileEntity r15 = com.obric.memorydata.personalcontext.util.f.c(r14.a());     // Catch: Throwable -> L61
        if (r15 != null) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PersonalContextFetchIntent", "parse photo file failed, entityId: " + r13 + ", entityType: " + r24.getType(), null, 4, null);     // Catch: Throwable -> L61
        return null;
    L34:
        Uri r16 = r15.getContentUrl();     // Catch: Throwable -> L61
        if (Intrinsics.areEqual(r16.getScheme(), "file") == false) goto L37;
        r1 = null;
    L47:
        RunLog.INSTANCE.debug("PersonalContextFetchIntent", "start upload photo, entityId: " + r13 + ", entityType: " + r24.getType() + ", uri: " + r16 + ", sourcePackage: " + r1);     // Catch: Throwable -> L61
        m.a r17 = m.f11745a;     // Catch: Throwable -> L61
        ImageXBizType r18 = ImageXBizType.DOUBAO;     // Catch: Throwable -> L61
        r9.L$0 = r24;     // Catch: Throwable -> L61
        r9.L$1 = r13;     // Catch: Throwable -> L61
        r9.L$2 = r16;     // Catch: Throwable -> L61
        r9.L$3 = r1;     // Catch: Throwable -> L61
        r9.label = 1;     // Catch: Throwable -> L61
        Object r19 = r17.b(r18, r16, r1, null, r9);     // Catch: Throwable -> L61
        if (r19 != r5) goto L50;
        return r5;
    L50:
        r10 = r24;
        r7 = r16;
        r8 = r13;
        r4 = r19;
        goto L51
    L37:
        String r20 = r14.o();     // Catch: Throwable -> L61
        if (r20 != null) goto L40;
    L46:
        r1 = r14.getPackageName();     // Catch: Throwable -> L61
        goto L47
    L40:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r20, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L43;
        r20 = null;
    L43:
        if (r20 == null) goto L46;
        r1 = r20;
    L61:
        th = th;
        r10 = r24;
    L7:
        r3 = new PersonalContextFetchIntentExecutor$uploadRawPhoto$1(this, r2);
        goto L8
    }

    @Override // com.obric.memorydata.personalcontext.datausage.plugin.action.manager.d
    public /* synthetic */ IntentResult<Empty> a(IntentParams r3, Long r4) {
        return a((PCPersonalContextFetchParams) ZeusTransformUtils.preCheckCast((IntentParams) ZeusTransformUtils.wrapperContextForParams(r3, IntentParams.class, "com.obric.memorydata.plugin"), PCPersonalContextFetchParams.class, "com.obric.memorydata.plugin"), r4);
    }

    public IntentResult<Empty> a(PCPersonalContextFetchParams r18, Long r19) {
        if (ApiController.INSTANCE.isEnable() == true) goto L7;
        return new IntentResult(100, null, null, null, false, false, 0, null, null, null, 1022, null);
    L7:
        if (r18 == null) goto L13;
        AppEntity[] r2 = r18.getEntities();
        if (r2 == null) goto L13;
        List r3 = ArraysKt.filterNotNull(r2);
        if (r3 == null) goto L13;
        List r4 = CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin"));
    L14:
        if (r4 != null) goto L17;
        r4 = CollectionsKt.emptyList();
    L17:
        if (r4.isEmpty() == false) goto L21;
        return new IntentResult(103, null, null, null, false, false, 0, null, null, null, 1022, null);
    L21:
        return new IntentResult(0, null, null, u.a().toJson((List) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new PersonalContextFetchIntentExecutor$doAction$urlList$1(r4, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), List.class, "com.obric.memorydata.plugin")), false, false, 256, null, null, null, 950, null);
    L13:
        r4 = null;
        goto L14
    }
}
