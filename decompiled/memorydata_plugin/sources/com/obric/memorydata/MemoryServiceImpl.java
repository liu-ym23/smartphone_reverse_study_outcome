package com.obric.memorydata;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.api.MemoryServiceApi;
import com.obric.memorydata.memory.k;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.lab.AILabPermissionRepository;
import com.obric.memorydata.memory.memoryentity.MemoryEntityManager;
import com.obric.memorydata.memory.ui.automemory.m;
import com.obric.memorydata.memory.ui.settings.l;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.union.build.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J \u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0016J\u0016\u0010&\u001a\u00020\u00062\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000f0(H\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J \u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016H\u0016J\u0016\u0010.\u001a\u00020\t2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000(H\u0016J\u0016\u00101\u001a\u00020\u00062\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00160(H\u0016J\u0010\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\u000fH\u0016J8\u00105\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020\u00162\u0006\u00109\u001a\u00020\u0016H\u0016J\b\u0010:\u001a\u00020\u0006H\u0016¨\u0006;"}, d2 = {"Lcom/obric/memorydata/MemoryServiceImpl;", "Lcom/obric/memorydata/memory/api/MemoryServiceApi;", "<init>", "()V", "getInst", "requestInAppRuleSync", "", "experienceState", "Lkotlinx/coroutines/flow/StateFlow;", "", "indexMemory", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "deleteMemoryDirectly", "memoryRawDbId", "", "deleteMemoryImage", "fileEntity", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getAppIcon", "Landroid/graphics/drawable/Drawable;", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "clearAppIconCache", "assistantSmartMemoryEnabled", "isAILabScreenMemoryEnabled", "markContextAwarenessConfigured", "autoMemoryEffectiveEnabled", "createAutoMemoryRule", "title", Params.CONTENT, "deleteCollectionRule", "ruleId", "updateCollectionRule", "resolveAutoMemoryIconKey", "semanticKey", "oldIconKey", "stableSeed", "onSemanticMemoryDeleted", "deletedItemIds", "", "runAfterRawMemoryTranslateTask", "reportMemoryTraceOps", "logId", AILabCheckPermissionTask.KEY_SOURCE, "memoryOpsJson", "reportInAppTrace", "items", "Lcom/obric/memorydata/memory/api/InAppTraceReportItem;", "updateInAppSignalCollectionPackages", "packageNames", "requestInAppSignalFlush", "screenshotTimestamp", "associateInAppTraceWithScreenshot", "observationId", "screenshotPath", "viewTreePath", "flushRequestId", "onSemanticMigrationUnblocked", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryServiceImpl implements MemoryServiceApi {
    public static final MemoryServiceImpl INSTANCE = null;

    static {
        INSTANCE = new MemoryServiceImpl();
    }

    private MemoryServiceImpl() {
    }

    @JvmStatic
    public static final MemoryServiceImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean assistantSmartMemoryEnabled() {
        boolean r3 = d.f8801a.a();
        boolean r0 = ((Set) ZeusTransformUtils.preCheckCast(l.f11479a.a().i().c(), Set.class, "com.obric.memorydata.plugin")).contains("assistant.history");
        if (r3 == false) goto L6;
        if (r0 == false) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void associateInAppTraceWithScreenshot(long r11, long r13, String r15, String r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r15, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r16, "screenshotPath");
        Intrinsics.checkNotNullParameter(r17, "viewTreePath");
        Intrinsics.checkNotNullParameter(r18, "flushRequestId");
        com.obric.memorydata.memory.inapptrace.b.f10159a.a(r11, r13, r15, r16, r17);
        com.obric.memorydata.memory.inapptrace.d.f10164a.a(r11, r13, r18);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public ar<Boolean> autoMemoryEffectiveEnabled() {
        return l.f11479a.a().m();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void clearAppIconCache() {
        com.obric.memorydata.utils.icon.b.f13229a.b();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public long createAutoMemoryRule(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "title");
        Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
        return com.obric.memorydata.memory.ui.automemory.create.a.f10659a.a(r1, r2);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean deleteCollectionRule(long r1) {
        return com.obric.memorydata.memory.ui.automemory.create.a.f10659a.a(r1);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean deleteMemoryDirectly(long r2) {
        return MemoryEntityManager.INSTANCE.deleteDirectly(r2, null);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void deleteMemoryImage(FileEntity r1) {
        Intrinsics.checkNotNullParameter(r1, "fileEntity");
        com.obric.memorydata.memory.memoryentity.a.a.f10310a.a(r1);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public ar<Boolean> experienceState() {
        return l.f11479a.a().j();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public Drawable getAppIcon(String r10) {
        Intrinsics.checkNotNullParameter(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return com.obric.memorydata.utils.icon.b.a(com.obric.memorydata.utils.icon.b.f13229a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r10, true, null, null, null, 56, null);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void indexMemory(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "appEntity");
        if (ZeusTransformUtils.instanceOf(r3, MemoryEntity.class) == false) goto L6;
        MemoryEntityManager.INSTANCE.index((MemoryEntity) ZeusTransformUtils.preCheckCast(r3, MemoryEntity.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean isAILabScreenMemoryEnabled() {
        return AILabPermissionRepository.a(AILabPermissionRepository.f10236a, null, 1, null);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void markContextAwarenessConfigured() {
        l.f11479a.a().A();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void onSemanticMemoryDeleted(List<Long> r2) {
        List<Long> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "deletedItemIds");
        if (r1.isEmpty() == false) goto L5;
        return;
    L5:
        List<T> r3 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao().queryByIds(r1);
        if (r3.isEmpty() == false) goto L8;
        return;
    L8:
        s.f13110a.a(r3);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void onSemanticMigrationUnblocked() {
        com.obric.memorydata.init.tasks.e.b(com.obric.memorydata.init.tasks.e.f9922a, 0, 1, null);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean reportInAppTrace(List<com.obric.memorydata.memory.api.b> r2) {
        List<com.obric.memorydata.memory.api.b> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "items");
        return com.obric.memorydata.memory.review.trace.g.f10488a.a(r1);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean reportMemoryTraceOps(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "logId");
        Intrinsics.checkNotNullParameter(r2, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r3, "memoryOpsJson");
        return com.obric.memorydata.memory.review.trace.g.f10488a.a(r1, r2, r3);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void requestInAppRuleSync() {
        com.obric.memorydata.memory.inapprule.d.f10154a.a();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public String requestInAppSignalFlush(long r1) {
        return k.f10230a.a(r1);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public String resolveAutoMemoryIconKey(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "semanticKey");
        Intrinsics.checkNotNullParameter(r2, "oldIconKey");
        Intrinsics.checkNotNullParameter(r3, "stableSeed");
        return m.f10685a.a(r1, r2, r3);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void runAfterRawMemoryTranslateTask() {
        com.obric.memorydata.memory.f.a.f10122a.a();
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public boolean updateCollectionRule(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
        return com.obric.memorydata.memory.ui.automemory.create.a.f10659a.a(r1, r3);
    }

    @Override // com.obric.memorydata.memory.api.MemoryServiceApi
    public void updateInAppSignalCollectionPackages(List<String> r3) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "packageNames");
        k.f10230a.a((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin"));
    }
}
