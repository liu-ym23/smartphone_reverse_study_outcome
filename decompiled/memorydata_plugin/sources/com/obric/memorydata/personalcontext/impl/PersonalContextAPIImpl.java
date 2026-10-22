package com.obric.memorydata.personalcontext.impl;

import android.net.Uri;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.keva.KevaImpl;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.entity.gq;
import com.obric.memorydata.database.util.b;
import com.obric.memorydata.memory.api.MemoryBuildOuter;
import com.obric.memorydata.memory.api.MemoryBuildOuterApi;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.personalcontext.e;
import com.obric.memorydata.personalcontext.m;
import com.obric.memorydata.personalcontext.n;
import com.obric.memorydata.personalcontext.s;
import com.obric.memorydata.personalcontext.search.global.f;
import com.obric.memorydata.personalcontext.task.EntityConsistencyCheckTask;
import com.obric.memorydata.personalcontext.util.EmbeddingState;
import com.obric.memorydata.personalcontext.util.c;
import com.obric.memorydata.personalcontext.vectordb.PersonalVectorDbFileMigrator;
import com.obric.memorydata.personalcontext.vectordb.d;
import com.obric.memorydata.personalcontext.vectordb.g;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J*\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J<\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001aH\u0016J\"\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J:\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050!2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u001a0!H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\u0016\u0010%\u001a\u00020\u00132\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130'H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J*\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0005H\u0016J\u0010\u00101\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0005H\u0016J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050!H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050!H\u0016J\u001e\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010!2\u0006\u00106\u001a\u000207H\u0096@¢\u0006\u0002\u00108J\u0010\u00109\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u001aH\u0016J\b\u0010;\u001a\u00020<H\u0016J\"\u0010=\u001a\u0004\u0018\u00010\r2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\bH\u0016J\b\u0010A\u001a\u00020\bH\u0016J \u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\bH\u0016J\u0016\u0010F\u001a\u00020\b2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00160!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/PersonalContextAPIImpl;", "Lcom/obric/memorydata/personalcontext/api/IPersonalContextAPI;", "<init>", "()V", "TAG", "", "getInst", "insertVectorCopilotItem", "", "tableName", OaidModel.KEY_ID, "", "vectorArray", "", "useVLM", "deleteVectorCopilotItem", "table", "migratePersonalVectorDbFilesIfNeededBlocking", "migrateMetaFullContentUidIfNeeded", "", "onRawEntityInsert", "entityType", "", "entityId", "rawId", "rawAppEntity", "", "onRawEntityUpdate", "isInvalidateIndex", "oldRawAppEntity", "onRawEntityDelete", "onBulkEntityDelete", "rawIds", "", "rawAppEntityIds", "rawAppEntities", "reDonateVdbEntity", "addForceIndexStateChangeListener", "listener", "Lkotlin/Function0;", "notifyForceIndexStateChange", "deepSearch", "Lcom/obric/memorydata/sdk/entity/global/GlobalAssistantSearchResponse;", ChatMessage.TYPE_QUERY, ObricMemoryConstants.KEY_PACKAGE_NAME, "searchType", "businessName", "memorySearchForProactiveUserProfile", "onPackageTaskStart", "onPackageTaskFinish", "getDbBackupFileList", "getDbBlackList", "extractSingleFile", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addLocation2MetaLocationManager", "locationEntity", "getEmbeddingState", "Lcom/obric/memorydata/personalcontext/util/EmbeddingState;", "queryVector", "vectorDbName", "key", "useVlm", "canUseVlmEmbedding", "triggerEntityConsistencyCheckTask", "isFastMode", "isSyncAfterEnableApp", "isSyncDonateApp", "allowDonateByLocalSearch", "types", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PersonalContextAPIImpl implements IPersonalContextAPI {
    public static final PersonalContextAPIImpl INSTANCE = null;
    public static final String TAG = "PersonalContextAPIImpl";

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12187a = null;

        static {
            int[] r0 = new int[EmbeddingState.values().length];
            r0[EmbeddingState.USE_VLM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[EmbeddingState.USE_LITTLE_MODEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f12187a = r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.impl.PersonalContextAPIImpl$reDonateVdbEntity$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.impl.PersonalContextAPIImpl$reDonateVdbEntity$1", f = "PersonalContextAPIImpl.kt", i = {}, l = {210}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            g r6 = g.f12413a;
            Continuation<? super Unit> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r6.a(r2) != r0) goto L12;
            return r0;
        }
    }

    static {
        INSTANCE = new PersonalContextAPIImpl();
    }

    private PersonalContextAPIImpl() {
    }

    @JvmStatic
    public static final PersonalContextAPIImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void addForceIndexStateChangeListener(Function0<Unit> r2) {
        Function0<Unit> r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        com.obric.memorydata.personalcontext.util.g.f12373a.a(r1);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void addLocation2MetaLocationManager(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "locationEntity");
        if (ZeusTransformUtils.instanceOf(r3, gq.class) == false) goto L6;
        n.f12234a.a((gq) ZeusTransformUtils.preCheckCast(r3, gq.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public boolean allowDonateByLocalSearch(List<Integer> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "types");
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        int r5 = ((Number) ZeusTransformUtils.preCheckCast(r4.next(), Number.class, "com.obric.memorydata.plugin")).intValue();
        if (e.f12095a.a(r5) == true) goto L4;
        return false;
    L9:
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public boolean canUseVlmEmbedding() {
        return c.f12363a.a();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public GlobalAssistantSearchResponse deepSearch(String r22, String r23, String r24, String r25) {
        Intrinsics.checkNotNullParameter(r22, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r23, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r25, "businessName");
        GlobalAssistantSearchResponse r7 = new GlobalAssistantSearchResponse(0, "success", null, null, null, null, null, null, 252, null);
        return f.a(f.f12331a, "", CollectionsKt.listOf(r22), null, r24, true, r7, r25, r23, null, null, 772, null);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public /* bridge */ /* synthetic */ Object deepSearch(String r1, String r2, String r3, String r4) {
        return deepSearch(r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public boolean deleteVectorCopilotItem(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "table");
        EmbeddingState r3 = c.f12363a.b();
        int r6 = a.f12187a[r3.ordinal()];
        if (r6 != 1) goto L5;
        d r7 = new d(r4, true);
    L14:
        return r7.delete(r5);
    L5:
        if (r6 != 2) goto L7;
        r7 = new d(r4, false);
        goto L14
    L7:
        if (new d(r4, true).delete(r5) == true) goto L9;
        return false;
    L9:
        if (new d(r4, false).delete(r5) == true) goto L17;
        return false;
    L17:
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public Object extractSingleFile(Uri r2, Continuation<? super List<VideoFrame>> r3) {
        Continuation<? super List<VideoFrame>> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return com.obric.memorydata.personalcontext.util.video.e.f12392a.a(r2, r1);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public List<String> getDbBackupFileList() {
        return (List) ZeusTransformUtils.preCheckCast(CollectionsKt.arrayListOf(new String[]{"databases", KevaImpl.PrivateConstants.FILES_DIR_NAME}), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public List<String> getDbBlackList() {
        return (List) ZeusTransformUtils.preCheckCast(CollectionsKt.arrayListOf(new String[]{"542488@bd_tea_agent.db", "542488_feature_engineering.db", "apm_monitor_t1.db", "EntityHistory.db", "downloader.db"}), List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public EmbeddingState getEmbeddingState() {
        return c.f12363a.b();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public boolean insertVectorCopilotItem(String r1, long r2, float[] r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r1, "tableName");
        Intrinsics.checkNotNullParameter(r4, "vectorArray");
        if (r5 == false) goto L5;
        d r0 = new d(r1, true);
    L7:
        return r0.insert(r2, r4);
    L5:
        r0 = new d(r1, false);
        goto L7
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public String memorySearchForProactiveUserProfile(String r1) {
        Intrinsics.checkNotNullParameter(r1, ChatMessage.TYPE_QUERY);
        return f.f12331a.b(r1);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void migrateMetaFullContentUidIfNeeded() {
        m.f12231a.a();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public String migratePersonalVectorDbFilesIfNeededBlocking() {
        return PersonalVectorDbFileMigrator.f12393a.a().a().name();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void notifyForceIndexStateChange() {
        com.obric.memorydata.personalcontext.util.g.f12373a.d();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onBulkEntityDelete(int r8, List<Long> r9, List<String> r10, List<? extends Object> r11) {
        List<Long> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "rawIds");
        Intrinsics.checkNotNullParameter(r12, "rawAppEntityIds");
        Intrinsics.checkNotNullParameter(r13, "rawAppEntities");
        com.obric.memorydata.personalcontext.impl.events.c r14 = com.obric.memorydata.personalcontext.impl.events.d.f12201a.a(r8);
        if (r14 != null) goto L5;
    L23:
        com.obric.memorydata.personalcontext.a.a.f12030a.a(r8, r7, r12, "delete");
        com.obric.memorydata.personalcontext.storage.e r15 = com.obric.memorydata.personalcontext.storage.e.f12343a;
        Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r18 = r16.iterator();
    L25:
        if (r18.hasNext() == false) goto L29;
        Object r19 = r18.next();
        if (ZeusTransformUtils.instanceOf(r19, com.obric.memorydata.database.entity.d.class) == false) goto L25;
        r17.add(r19);
        goto L25
    L29:
        r15.a(r8, (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin"));
        s.f12268a.a();
        return;
    L5:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L23;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r3 = r1.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r4 = r3.next();
        if (ZeusTransformUtils.instanceOf(r4, com.obric.memorydata.database.entity.d.class) == false) goto L8;
        r2.add(r4);
        goto L8
    L12:
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r5, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r20 = r5.iterator();
    L14:
        if (r20.hasNext() == false) goto L16;
        Object r21 = r20.next();
        r6.put(Long.valueOf(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r21, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId()), r21);
        goto L14
    L16:
        Iterator r22 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L18:
        if (r22.hasNext() == false) goto L23;
        long r23 = ((Number) ZeusTransformUtils.preCheckCast(r22.next(), Number.class, "com.obric.memorydata.plugin")).longValue();
        Iterator r24 = ((Iterable) ZeusTransformUtils.preCheckCast(r14.b(r23, r6.get(Long.valueOf(r23))), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r24.hasNext() == false) goto L18;
        com.obric.memorydata.personalcontext.impl.events.a r25 = (com.obric.memorydata.personalcontext.impl.events.a) ZeusTransformUtils.preCheckCast(r24.next(), com.obric.memorydata.personalcontext.impl.events.a.class, "com.obric.memorydata.plugin");
        AwarenessManager.INSTANCE.dispatchAwarenessEvent(r25.a(), r25.b());
        goto L21
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onPackageTaskFinish(String r1) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (Intrinsics.areEqual(r1, com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME) == false) goto L5;
    L6:
        b.f9624a.b(r1);
        return;
    L5:
        if (Intrinsics.areEqual(r1, com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME) == true) goto L6;
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onPackageTaskStart(String r1) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
        if (Intrinsics.areEqual(r1, com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME) == false) goto L5;
    L6:
        b.f9624a.a(r1);
        return;
    L5:
        if (Intrinsics.areEqual(r1, com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME) == true) goto L6;
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onRawEntityDelete(int r11, long r12, Object r14) {
        com.obric.memorydata.personalcontext.impl.events.c r10 = com.obric.memorydata.personalcontext.impl.events.d.f12201a.a(r11);
        if (r10 == null) goto L10;
        List<com.obric.memorydata.personalcontext.impl.events.a> r13 = r10.b(r12, r14);
        if (r13 == null) goto L10;
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        com.obric.memorydata.personalcontext.impl.events.a r1 = (com.obric.memorydata.personalcontext.impl.events.a) ZeusTransformUtils.preCheckCast(r15.next(), com.obric.memorydata.personalcontext.impl.events.a.class, "com.obric.memorydata.plugin");
        AwarenessManager.INSTANCE.dispatchAwarenessEvent(r1.a(), r1.b());
    L10:
        com.obric.memorydata.personalcontext.a.a.f12030a.a(r11, r12, "", "delete");
        if (ZeusTransformUtils.instanceOf(r14, com.obric.memorydata.database.entity.d.class) == false) goto L13;
        com.obric.memorydata.personalcontext.storage.e.f12343a.c(r11, (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r14, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"));
    L13:
        s.f12268a.a();
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onRawEntityInsert(int r11, String r12, long r13, Object r15) {
        Intrinsics.checkNotNullParameter(r12, "entityId");
        if (r15 == null) goto L12;
        com.obric.memorydata.personalcontext.impl.events.c r0 = com.obric.memorydata.personalcontext.impl.events.d.f12201a.a(r11);
        if (r0 == null) goto L12;
        List<com.obric.memorydata.personalcontext.impl.events.a> r1 = r0.a(r13, r15);
        if (r1 == null) goto L12;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        com.obric.memorydata.personalcontext.impl.events.a r3 = (com.obric.memorydata.personalcontext.impl.events.a) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.memorydata.personalcontext.impl.events.a.class, "com.obric.memorydata.plugin");
        AwarenessManager.INSTANCE.dispatchAwarenessEvent(r3.a(), r3.b());
    L12:
        com.obric.memorydata.personalcontext.a.a.f12030a.a(r11, r13, r12, "index");
        if (ZeusTransformUtils.instanceOf(r15, com.obric.memorydata.database.entity.d.class) == false) goto L16;
        com.obric.memorydata.personalcontext.storage.e.f12343a.a(r11, (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"));
    L16:
        if (ZeusTransformUtils.instanceOf(r15, fj.class) == false) goto L22;
        AppEntity r4 = ((fj) ZeusTransformUtils.preCheckCast(r15, fj.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (r4 == null) goto L23;
        RunLog.INSTANCE.debug(TAG, "insert AuditoryRecordingEntity: " + r4.getId());
        MemoryBuildOuterApi.a.a((MemoryBuildOuterApi) ZeusTransformUtils.preCheckCast(MemoryBuildOuter.INSTANCE, MemoryBuildOuterApi.class, "com.obric.memorydata.plugin"), r4, "add_new", false, 4, null);
        return;
    L23:
        return;
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void onRawEntityUpdate(int r11, String r12, long r13, Object r15, boolean r16, Object r17) {
        Intrinsics.checkNotNullParameter(r12, "entityId");
        if (r15 == null) goto L13;
        com.obric.memorydata.personalcontext.impl.events.c r0 = com.obric.memorydata.personalcontext.impl.events.d.f12201a.a(r11);
        if (r0 == null) goto L13;
        List<com.obric.memorydata.personalcontext.impl.events.a> r1 = r0.a(r13, r17, r15);
        if (r1 == null) goto L13;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r2.hasNext() == false) goto L13;
        com.obric.memorydata.personalcontext.impl.events.a r3 = (com.obric.memorydata.personalcontext.impl.events.a) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.memorydata.personalcontext.impl.events.a.class, "com.obric.memorydata.plugin");
        AwarenessManager.INSTANCE.dispatchAwarenessEvent(r3.a(), r3.b());
    L13:
        if (r16 == true) goto L16;
        com.obric.memorydata.personalcontext.a.a.f12030a.a(r11, r13, r12, "index");
    L16:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.memorydata.database.entity.d.class) == false) goto L19;
        com.obric.memorydata.personalcontext.storage.e.f12343a.b(r11, (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r15, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"));
    L19:
        if (ZeusTransformUtils.instanceOf(r15, fj.class) == false) goto L25;
        AppEntity r4 = ((fj) ZeusTransformUtils.preCheckCast(r15, fj.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        if (r4 == null) goto L26;
        RunLog.INSTANCE.debug(TAG, "insert AuditoryRecordingEntity: " + r4.getId());
        MemoryBuildOuterApi.a.a((MemoryBuildOuterApi) ZeusTransformUtils.preCheckCast(MemoryBuildOuter.INSTANCE, MemoryBuildOuterApi.class, "com.obric.memorydata.plugin"), r4, BuildConfig.CHANNEL, false, 4, null);
        return;
    L26:
        return;
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public float[] queryVector(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "vectorDbName");
        Intrinsics.checkNotNullParameter(r2, "key");
        return new d(r1, r3).a(r2);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void reDonateVdbEntity() {
        i.a((al) ZeusTransformUtils.preCheckCast(bp.f17245a, al.class, "com.obric.memorydata.plugin"), (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }

    @Override // com.obric.memorydata.personalcontext.api.IPersonalContextAPI
    public void triggerEntityConsistencyCheckTask(boolean r1, boolean r2, boolean r3) {
        EntityConsistencyCheckTask.Companion.triggerTask(r1, r2, r3);
    }
}
