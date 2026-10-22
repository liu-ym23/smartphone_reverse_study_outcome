package com.obric.aiproactive.impl.bridge;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiproactive.api.AiProactiveArtifactResourceKind;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.impl.aidb.AiProactiveDb;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\u0000H\u0007J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020 H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0005H\u0016J\u0016\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050*H\u0016J\b\u0010+\u001a\u00020%H\u0016J\b\u0010,\u001a\u00020%H\u0016J\b\u0010-\u001a\u00020%H\u0016J\b\u0010.\u001a\u00020%H\u0016J\u0018\u0010/\u001a\u00020%2\u0006\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020(H\u0002J\b\u00104\u001a\u00020(H\u0002J\b\u00105\u001a\u00020(H\u0002J\u0018\u00106\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001072\u0006\u00108\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018¨\u00069"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/AiProactiveAgentBridgeImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IAiProactiveAgentBridgeAPI;", "<init>", "()V", "TAG", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "lock", "", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "pendingListeningJob", "Lkotlinx/coroutines/Job;", "pendingSpellListeningJob", "artifactResourceStore", "Lcom/obric/aiproactive/impl/bridge/ArtifactResourceStore;", "getArtifactResourceStore", "()Lcom/obric/aiproactive/impl/bridge/ArtifactResourceStore;", "artifactResourceStore$delegate", "Lkotlin/Lazy;", "artifactResourceBridge", "Lcom/obric/aiproactive/impl/bridge/ArtifactResourceBridge;", "getArtifactResourceBridge", "()Lcom/obric/aiproactive/impl/bridge/ArtifactResourceBridge;", "artifactResourceBridge$delegate", "prepareArtifactOpenLocator", "artifact", "Lcom/obric/aiproactive/api/AiProactiveArtifact;", "prepareArtifactOpenLocator$ai_proactive_impl_obricRelease", "getInst", "getAiProactiveArtifactProtocolVersion", "", "materializeAiProactiveArtifact", "requestJson", "getAiProactiveProgressProtocolVersion", "reportAiProactiveAgentProgress", "", "progressJson", "refreshAiProactive", "", "refreshTypes", "", "startAiProactiveEcaListening", "stopAiProactiveEcaListening", "startSpellProactiveEcaListening", "stopSpellProactiveEcaListening", "notifySpellProactiveTrigger", InfoRequestQPSOptTraceLogger.REASON, "conditionJson", "scheduleStartAfterDbReady", "cancelPendingStart", "scheduleSpellStartAfterDbReady", "cancelPendingSpellStart", "loadReferencedArtifactLocators", "", "userId", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AiProactiveAgentBridgeImpl implements IAiProactiveAgentBridgeAPI {
    public static final AiProactiveAgentBridgeImpl INSTANCE = null;
    public static final String TAG = "AiProactiveAgentBridgeImpl";
    private static final Lazy artifactResourceBridge$delegate = null;
    private static final Lazy artifactResourceStore$delegate = null;
    private static final CoroutineExceptionHandler exceptionHandler = null;
    private static final Object lock = null;
    private static volatile bx pendingListeningJob;
    private static volatile bx pendingSpellListeningJob;
    private static final al scope = null;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public a(CoroutineExceptionHandler.a r3) {
            super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r2, Throwable r3) {
            CoroutineContext r1 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r2, CoroutineContext.class, "com.obric.memorydata.plugin");
            RunLog.INSTANCE.error(AiProactiveAgentBridgeImpl.TAG, "pending startAiProactiveEcaListening failed", r3);
        }
    }

    static {
        INSTANCE = new AiProactiveAgentBridgeImpl();
        scope = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        lock = new Object();
        exceptionHandler = (CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new a(CoroutineExceptionHandler.f17198b), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin");
        artifactResourceStore$delegate = LazyKt.lazy($$Lambda$AiProactiveAgentBridgeImpl$o8g1rryhj8eQ2sKShHEGMfAu_lQ.INSTANCE);
        artifactResourceBridge$delegate = LazyKt.lazy($$Lambda$AiProactiveAgentBridgeImpl$PGzzAFzuDtEYEOUQYAt4YqAp4.INSTANCE);
    }

    private AiProactiveAgentBridgeImpl() {
    }

    public static final /* synthetic */ Object access$getLock$p() {
        return lock;
    }

    public static final /* synthetic */ bx access$getPendingListeningJob$p() {
        return pendingListeningJob;
    }

    public static final /* synthetic */ bx access$getPendingSpellListeningJob$p() {
        return pendingSpellListeningJob;
    }

    public static final /* synthetic */ Set access$loadReferencedArtifactLocators(AiProactiveAgentBridgeImpl r0, String r1) {
        return r0.loadReferencedArtifactLocators(r1);
    }

    public static final /* synthetic */ void access$setPendingListeningJob$p(bx r2) {
        pendingListeningJob = (bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void access$setPendingSpellListeningJob$p(bx r2) {
        pendingSpellListeningJob = (bx) ZeusTransformUtils.wrapperContextForParams(r2, bx.class, "com.obric.memorydata.plugin");
    }

    private static final c artifactResourceBridge_delegate$lambda$3() {
        return new c(INSTANCE.getArtifactResourceStore());
    }

    private static final d artifactResourceStore_delegate$lambda$2() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        return new d(new File(r0.getFilesDir(), "export_share"), r0.getExternalCacheDir(), (Function1) ZeusTransformUtils.preCheckCast(new AiProactiveAgentBridgeImpl$artifactResourceStore$2$1(INSTANCE), Function1.class, "com.obric.memorydata.plugin"), $$Lambda$AiProactiveAgentBridgeImpl$GODJSlQASdHdgtio4vXPGinDUv0.INSTANCE, null, null, null, 112, null);
    }

    private static final String artifactResourceStore_delegate$lambda$2$lambda$1() {
        return com.obric.aiproactive.impl.a.a(AppContext.INSTANCE.getUserId());
    }

    private final void cancelPendingSpellStart() {
        Object r3 = lock;
        monitor-enter(r3);
        bx r0 = pendingSpellListeningJob;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        bx.a.a(r0, null, 1, null);     // Catch: Throwable -> L10
    L7:
        pendingSpellListeningJob = null;     // Catch: Throwable -> L10
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r3);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final void cancelPendingStart() {
        Object r3 = lock;
        monitor-enter(r3);
        bx r0 = pendingListeningJob;     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        bx.a.a(r0, null, 1, null);     // Catch: Throwable -> L10
    L7:
        pendingListeningJob = null;     // Catch: Throwable -> L10
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r3);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private final c getArtifactResourceBridge() {
        return (c) ZeusTransformUtils.preCheckCast(artifactResourceBridge$delegate.getValue(), c.class, "com.obric.memorydata.plugin");
    }

    private final d getArtifactResourceStore() {
        return (d) ZeusTransformUtils.preCheckCast(artifactResourceStore$delegate.getValue(), d.class, "com.obric.memorydata.plugin");
    }

    @JvmStatic
    public static final AiProactiveAgentBridgeImpl getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ String lambda$GODJSlQASdHdgtio4vXPGinDUv0() {
        return artifactResourceStore_delegate$lambda$2$lambda$1();
    }

    public static /* synthetic */ String lambda$OYWWL36qtYCdwitvGyov7yVMclY(com.obric.aiproactive.api.j r0) {
        return loadReferencedArtifactLocators$lambda$10(r0);
    }

    /* JADX INFO: renamed from: lambda$PGzzAFz--uDtEYEOUQYAt4YqAp4, reason: not valid java name */
    public static /* synthetic */ c m222lambda$PGzzAFzuDtEYEOUQYAt4YqAp4() {
        return artifactResourceBridge_delegate$lambda$3();
    }

    public static /* synthetic */ Sequence lambda$XsvOj_mwrEZCps886PyVlX6WvsY(String r0) {
        return loadReferencedArtifactLocators$lambda$8(r0);
    }

    public static /* synthetic */ d lambda$o8g1rryhj8eQ2sKShHEGMfAu_lQ() {
        return artifactResourceStore_delegate$lambda$2();
    }

    private final Set<String> loadReferencedArtifactLocators(String r4) {
        AiProactiveDb r3 = com.obric.aiproactive.impl.aidb.b.f6306a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        if (r3 != null) goto L6;
        return null;
    L6:
        com.obric.aiproactive.impl.aidb.dao.g r5 = r3.recommendationDao();
        if (com.obric.aiproactive.impl.aidb.l.a(r5) == true) goto L11;
        return SetsKt.emptySet();
    L11:
        return SequencesKt.toSet(SequencesKt.mapNotNull(SequencesKt.flatMap(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r5.listArtifactJsonSync(), Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$AiProactiveAgentBridgeImpl$XsvOj_mwrEZCps886PyVlX6WvsY.INSTANCE), $$Lambda$AiProactiveAgentBridgeImpl$OYWWL36qtYCdwitvGyov7yVMclY.INSTANCE));
    }

    private static final String loadReferencedArtifactLocators$lambda$10(com.obric.aiproactive.api.j r5) {
        Intrinsics.checkNotNullParameter(r5, "artifact");
        com.obric.aiproactive.api.m r6 = r5.f();
        if (r6 == null) goto L15;
        boolean r3 = false;
        if (r6.a() == AiProactiveArtifactResourceKind.EXPORTED_FILE) goto L7;
    L9:
        if (r3 == true) goto L12;
        r6 = null;
    L12:
        if (r6 != null) goto L14;
        return null;
    L14:
        return r6.b();
    L7:
        if (StringsKt.startsWith$default(r6.b(), "managed/", false, 2, null) == false) goto L9;
        r3 = true;
        goto L9
    L15:
        return null;
    }

    private static final Sequence loadReferencedArtifactLocators$lambda$8(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiproactive.api.k.a(r2), Iterable.class, "com.obric.memorydata.plugin"));
    }

    private final void scheduleSpellStartAfterDbReady() {
        Object r7 = lock;
        monitor-enter(r7);
        bx r0 = pendingSpellListeningJob;     // Catch: Throwable -> L17
        boolean r1 = true;
        if (r0 != null) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == false) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "startSpellProactiveEcaListening pending already scheduled", false, 4, null);     // Catch: Throwable -> L17
        monitor-exit(r7);
        return;
    L14:
        bx r2 = kotlinx.coroutines.i.a(scope, (CoroutineContext) ZeusTransformUtils.preCheckCast(exceptionHandler, CoroutineContext.class, "com.obric.memorydata.plugin"), CoroutineStart.LAZY, (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveAgentBridgeImpl$scheduleSpellStartAfterDbReady$1$job$1(null), Function2.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
        pendingSpellListeningJob = r2;     // Catch: Throwable -> L17
        r2.s_();     // Catch: Throwable -> L17
        monitor-exit(r7);
        return;
    L7:
        if (r0.a() != true) goto L9;
    L17:
        th = move-exception;
        throw th;
    }

    private final void scheduleStartAfterDbReady() {
        Object r7 = lock;
        monitor-enter(r7);
        bx r0 = pendingListeningJob;     // Catch: Throwable -> L17
        boolean r1 = true;
        if (r0 != null) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == false) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "startAiProactiveEcaListening pending already scheduled", false, 4, null);     // Catch: Throwable -> L17
        monitor-exit(r7);
        return;
    L14:
        bx r2 = kotlinx.coroutines.i.a(scope, (CoroutineContext) ZeusTransformUtils.preCheckCast(exceptionHandler, CoroutineContext.class, "com.obric.memorydata.plugin"), CoroutineStart.LAZY, (Function2) ZeusTransformUtils.preCheckCast(new AiProactiveAgentBridgeImpl$scheduleStartAfterDbReady$1$job$1(null), Function2.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
        pendingListeningJob = r2;     // Catch: Throwable -> L17
        r2.s_();     // Catch: Throwable -> L17
        monitor-exit(r7);
        return;
    L7:
        if (r0.a() != true) goto L9;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public int getAiProactiveArtifactProtocolVersion() {
        return 2;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public int getAiProactiveProgressProtocolVersion() {
        return 5;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public String materializeAiProactiveArtifact(String r2) {
        Intrinsics.checkNotNullParameter(r2, "requestJson");
        return getArtifactResourceBridge().a(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean notifySpellProactiveTrigger(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r5, "conditionJson");
        stopSpellProactiveEcaListening();
        return com.obric.aiproactive.impl.spell.b.f6517a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public final String prepareArtifactOpenLocator$ai_proactive_impl_obricRelease(com.obric.aiproactive.api.j r5) {
        Intrinsics.checkNotNullParameter(r5, "artifact");
        com.obric.aiproactive.api.m r0 = r5.f();
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r5.h() == true) goto L8;
        return null;
    L8:
        if (r0.a() != AiProactiveArtifactResourceKind.EXPORTED_FILE) goto L16;
        return getArtifactResourceStore().a(r0.b(), r5.d());
    L17:
        return null;
    L16:
        return null;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public void refreshAiProactive(List<String> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "refreshTypes");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "refreshAiProactive types=" + r7, false, 4, null);
        IProactiveService r9 = (IProactiveService) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IProactiveService.class)), IProactiveService.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L6;
        r9.refreshAiProactive(com.obric.aiproactive.impl.bridge.a.a(r7));
        return;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean reportAiProactiveAgentProgress(String r1) {
        Intrinsics.checkNotNullParameter(r1, "progressJson");
        JSONObject r0 = com.obric.aiproactive.impl.bridge.a.a(r1);
        if (r0 != null) goto L7;
        return false;
    L7:
        return com.obric.aiproactive.impl.progress.c.f6499a.a(r0);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean startAiProactiveEcaListening() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "startAiProactiveEcaListening", false, 4, null);
        IProactiveService r0 = (IProactiveService) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IProactiveService.class)), IProactiveService.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r5 = null;
        int r6 = 4;
        Object r7 = null;
        String r3 = TAG;
        String r4 = "startAiProactiveEcaListening aborted: service not ready";
    L5:
        IRunLog.a.a(r2, r3, r4, r5, r6, r7);
        return false;
    L8:
        if (r0.ensureAgreePrivacyAndLogin() == true) goto L11;
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = null;
        r6 = 4;
        r7 = null;
        r3 = TAG;
        r4 = "startAiProactiveEcaListening blocked by privacy/login";
        goto L5
    L11:
        if (r0.isAiProactiveWakeUpEnabled() == true) goto L14;
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = null;
        r6 = 4;
        r7 = null;
        r3 = TAG;
        r4 = "startAiProactiveEcaListening ignored wakeUpDisabled";
        goto L5
    L14:
        if (r0.isAiProactiveEntryReady() == true) goto L18;
        scheduleStartAfterDbReady();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "startAiProactiveEcaListening pendingDbReady", false, 4, null);
        return true;
    L18:
        return com.obric.aiproactive.impl.trigger.a.f6521a.a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean startSpellProactiveEcaListening() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "startSpellProactiveEcaListening", false, 4, null);
        IProactiveService r0 = (IProactiveService) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IProactiveService.class)), IProactiveService.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        IRunLog r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r5 = null;
        int r6 = 4;
        Object r7 = null;
        String r3 = TAG;
        String r4 = "startSpellProactiveEcaListening aborted: service not ready";
    L5:
        IRunLog.a.a(r2, r3, r4, r5, r6, r7);
        return false;
    L8:
        if (r0.ensureAgreePrivacyAndLogin() == true) goto L11;
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = null;
        r6 = 4;
        r7 = null;
        r3 = TAG;
        r4 = "startSpellProactiveEcaListening blocked by privacy/login";
        goto L5
    L11:
        if (r0.isAiProactiveWakeUpEnabled() == true) goto L14;
        r2 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = null;
        r6 = 4;
        r7 = null;
        r3 = TAG;
        r4 = "startSpellProactiveEcaListening ignored wakeUpDisabled";
        goto L5
    L14:
        if (r0.isAiProactiveEntryReady() == true) goto L18;
        scheduleSpellStartAfterDbReady();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "startSpellProactiveEcaListening pendingDbReady", false, 4, null);
        return true;
    L18:
        return com.obric.aiproactive.impl.trigger.c.f6527a.a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean stopAiProactiveEcaListening() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "stopAiProactiveEcaListening", false, 4, null);
        cancelPendingStart();
        return com.obric.aiproactive.impl.trigger.a.f6521a.b();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IAiProactiveAgentBridgeAPI
    public boolean stopSpellProactiveEcaListening() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "stopSpellProactiveEcaListening", false, 4, null);
        cancelPendingSpellStart();
        return com.obric.aiproactive.impl.trigger.c.f6527a.b();
    }
}
