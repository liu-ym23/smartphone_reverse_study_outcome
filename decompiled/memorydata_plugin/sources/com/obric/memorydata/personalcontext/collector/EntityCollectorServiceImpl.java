package com.obric.memorydata.personalcontext.collector;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.obric.memorydata.middleware.api.IAgentServiceProvider;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.device.SelfCollectionSupportType;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IEntityCollectorService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\u0013\u001a\u00020\u0000H\u0007J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0005J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J$\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f2\u0006\u0010&\u001a\u00020\u0011H\u0016J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u001aH\u0017J\n\u0010)\u001a\u0004\u0018\u00010*H\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110\u001fH\u0016J\u0012\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020\u0011H\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0016J\b\u00100\u001a\u00020\u0016H\u0016J\b\u00101\u001a\u00020\u0016H\u0016J\b\u00102\u001a\u00020\u0016H\u0016J\u0010\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u000205H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/EntityCollectorServiceImpl;", "Lcom/obric/memorydata/personalcontext/api/IEntityCollectorService;", "<init>", "()V", "TAG", "", "initializedCollectorTypes", "", "subCollectors", "", "Lcom/obric/memorydata/personalcontext/api/AbsEntityCollector;", "getSubCollectors", "()Ljava/util/Map;", "subCollectors$delegate", "Lkotlin/Lazy;", "smsEntityTypes", "", "", "buildSubCollectorMap", "getInst", "getInitializedCollectorTypes", "initDataCollector", "", "context", "Landroid/content/Context;", "syncDataDelay", "", "onPermissionChanged", "dataTag", "hasPermission", "getAllContactAndSmsData", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "getAllContactAndCallHistoryData", "getAllCallHistoryData", "getAllSmsData", "getDataAndTriggerIndex", "noPcIds", "entityType", "reIndexData", "noNeedDelete", "getEntitySupplier", "Lcom/obric/capabilitykit/EntitySupplier;", "getEntitySyncDataSupplier", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "getDonateEntityTypeList", "getPackageNameByEntityType", "getNeedRequestPermissions", CommonConsts.APM_INNER_EVENT_COST_START, "stop", "syncData", "registerIAgentServiceProvider", "agentServiceProvider", "Lcom/obric/memorydata/middleware/api/IAgentServiceProvider;", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class EntityCollectorServiceImpl implements IEntityCollectorService {
    public static final EntityCollectorServiceImpl INSTANCE = null;
    private static final String TAG = "ObricEntityCollectorServiceImpl";
    private static final Set<String> initializedCollectorTypes = null;
    private static final Set<Integer> smsEntityTypes = null;
    private static final Lazy subCollectors$delegate = null;

    static {
        INSTANCE = new EntityCollectorServiceImpl();
        initializedCollectorTypes = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        subCollectors$delegate = LazyKt.lazy($$Lambda$EntityCollectorServiceImpl$RZuRzBBbw4cdllNji8UKQ92OxTE.INSTANCE);
        smsEntityTypes = SetsKt.setOf(new Integer[]{201, 101, 202});
    }

    private EntityCollectorServiceImpl() {
    }

    private final Map<String, com.obric.memorydata.personalcontext.api.a> buildSubCollectorMap() {
        com.obric.memorydata.middleware.api.device.a r10 = DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport();
        com.obric.memorydata.personalcontext.external.file.c r2 = null;
        if (r10.a() == SelfCollectionSupportType.NONE) goto L14;
        Set r0 = CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r10.b(), Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(smsEntityTypes, Iterable.class, "com.obric.memorydata.plugin"));
        if (r0.isEmpty() == true) goto L7;
        c r1 = new c(r0);
    L9:
        if (r10.a(EntityType.FILE) == false) goto L11;
        r2 = new com.obric.memorydata.personalcontext.external.file.c();
    L12:
        Pair r3 = TuplesKt.to(r1, r2);
    L17:
        com.obric.memorydata.personalcontext.api.a r4 = (com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r3.component1(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.personalcontext.api.a r5 = (com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r3.component2(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin");
        Map<String, com.obric.memorydata.personalcontext.api.a> r6 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L20;
        r6.put(IEntityCollectorService.SMS_TAG, r4);
    L20:
        if (r5 == null) goto L23;
        r6.put(IEntityCollectorService.FILE_TAG, r5);
    L23:
        if (r10.a(301) == false) goto L26;
        r6.put(IEntityCollectorService.PHOTO_TAG, new com.obric.memorydata.personalcontext.external.d.c());
    L26:
        if (r10.a(402) == false) goto L28;
        r6.put(IEntityCollectorService.SCHEDULE_TAG, new com.obric.memorydata.personalcontext.external.schedule.c());
    L28:
        return r6;
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "not build ExternalFileEntityCollector, not support file", false, 4, null);
        goto L12
    L7:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "not build ExternalSmsEntityCollector, externalTrioTypes is empty", false, 4, null);
        r1 = null;
        goto L9
    L14:
        if (DeviceInfoState.INSTANCE.isObricOsDevice() == false) goto L16;
        r3 = TuplesKt.to(new m(), new g());
        goto L17
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "config type is none and not obric device", false, 4, null);
        r3 = TuplesKt.to(null, null);
        goto L17
    }

    @JvmStatic
    public static final EntityCollectorServiceImpl getInst() {
        return INSTANCE;
    }

    private final Map<String, com.obric.memorydata.personalcontext.api.a> getSubCollectors() {
        return (Map) ZeusTransformUtils.preCheckCast(subCollectors$delegate.getValue(), Map.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Map lambda$RZuRzBBbw4cdllNji8UKQ92OxTE() {
        return subCollectors_delegate$lambda$0();
    }

    private static final Map subCollectors_delegate$lambda$0() {
        return INSTANCE.buildSubCollectorMap();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllCallHistoryData() {
        if (hasPermission(IEntityCollectorService.SMS_TAG) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return a.f12050a.e();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllContactAndCallHistoryData() {
        if (hasPermission(IEntityCollectorService.SMS_TAG) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return a.f12050a.f();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllContactAndSmsData() {
        if (hasPermission(IEntityCollectorService.SMS_TAG) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return a.f12050a.d();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getAllSmsData() {
        if (hasPermission(IEntityCollectorService.SMS_TAG) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return a.f12050a.g();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<AppEntity> getDataAndTriggerIndex(List<String> r3, int r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "noPcIds");
        if (r5.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r4 != 301) goto L9;
        String r0 = IEntityCollectorService.PHOTO_TAG;
    L13:
        com.obric.memorydata.personalcontext.api.a r2 = (com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(getSubCollectors().get(r0), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L18;
        List<AppEntity> r6 = r2.a(r4, r5);
        if (r6 == null) goto L18;
        return r6;
    L18:
        return CollectionsKt.emptyList();
    L9:
        if (r4 == 801) goto L11;
        r0 = IEntityCollectorService.SMS_TAG;
        goto L13
    L11:
        r0 = IEntityCollectorService.FILE_TAG;
        goto L13
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<Integer> getDonateEntityTypeList() {
        List<Integer> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, com.obric.memorydata.personalcontext.api.a>> r5 = getSubCollectors().entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r1.getValue(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).d() == false) goto L4;
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r1.getValue(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).h(), Collection.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        return r0;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public EntitySupplier getEntitySupplier() {
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, com.obric.memorydata.personalcontext.api.a>> r5 = getSubCollectors().entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r1.getValue(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).d() == false) goto L4;
        r0.add(((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r1.getValue(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).e());
        goto L4
    L9:
        if (r0.isEmpty() == false) goto L13;
        return null;
    L13:
        return (EntitySupplier) ZeusTransformUtils.preCheckCast(new j(r0), EntitySupplier.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public EntitySyncDataSupplier getEntitySyncDataSupplier() {
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, com.obric.memorydata.personalcontext.api.a>> r5 = getSubCollectors().entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L14;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r1.getValue(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).d() == false) goto L4;
        EntitySyncDataSupplier r3 = ((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r1.getValue(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).f();
        if (r3 != null) goto L9;
        EntitySupplier r2 = ((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r1.getValue(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).e();
        if (r2 == null) goto L4;
        r3 = new com.obric.memorydata.personalcontext.api.b(r2);
    L9:
        r0.add(r3);
        goto L4
    L14:
        if (r0.isEmpty() == false) goto L18;
        return null;
    L18:
        if (r0.size() != 1) goto L22;
        Object r6 = r0.get(0);
    L21:
        return (EntitySyncDataSupplier) ZeusTransformUtils.preCheckCast(r6, EntitySyncDataSupplier.class, "com.obric.memorydata.plugin");
    L22:
        r6 = new k(r0);
        goto L21
    }

    public final Set<String> getInitializedCollectorTypes() {
        return initializedCollectorTypes;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public List<String> getNeedRequestPermissions() {
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        Iterator<Map.Entry<String, com.obric.memorydata.personalcontext.api.a>> r5 = getSubCollectors().entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r1.getValue(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).g(), Collection.class, "com.obric.memorydata.plugin"));
        if (Intrinsics.areEqual(r3, IEntityCollectorService.SMS_TAG) == false) goto L4;
        r0.add("android.permission.READ_SMS");
        r0.add("android.permission.READ_CALL_LOG");
        r0.add("android.permission.READ_CONTACTS");
        goto L4
    L9:
        return CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public String getPackageNameByEntityType(int r4) {
        Iterator<com.obric.memorydata.personalcontext.api.a> r3 = getSubCollectors().values().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        String r0 = ((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).a(r4);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public boolean hasPermission() {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "hasPermission, privacy not agree", false, 4, null);
        return false;
    L6:
        boolean r0 = true;
        Iterator<Map.Entry<String, com.obric.memorydata.personalcontext.api.a>> r8 = getSubCollectors().entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r0 == false) goto L8;
        if (((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r3.getValue(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).d() == true) goto L8;
        r0 = false;
        goto L8
    L14:
        return r0;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public boolean hasPermission(String r9) {
        Intrinsics.checkNotNullParameter(r9, "dataTag");
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "hasPermission, privacy not agree, tag: " + r9, false, 4, null);
        return false;
    L6:
        com.obric.memorydata.personalcontext.api.a r8 = (com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(getSubCollectors().get(r9), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L9;
        return false;
    L9:
        return r8.d();
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void initDataCollector(Context r4, boolean r5) {
        Intrinsics.checkNotNullParameter((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), "context");
        Iterator<Map.Entry<String, com.obric.memorydata.personalcontext.api.a>> r3 = getSubCollectors().entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        ((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r6.getValue(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).a(r5);
        List<String> r7 = ((com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(r6.getValue(), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin")).b();
        if (r7 == null) goto L4;
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r8.hasNext() == false) goto L4;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        initializedCollectorTypes.add(r0);
        goto L9
    }

    public final void onPermissionChanged(String r2) {
        Intrinsics.checkNotNullParameter(r2, "dataTag");
        com.obric.memorydata.personalcontext.api.a r1 = (com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(getSubCollectors().get(r2), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.c();
        return;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void reIndexData(String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "dataTag");
        if (hasPermission(r7) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "reIndexData, privacy not agree, tag: " + r7, false, 4, null);
        return;
    L6:
        com.obric.memorydata.personalcontext.api.a r6 = (com.obric.memorydata.personalcontext.api.a) ZeusTransformUtils.preCheckCast(getSubCollectors().get(r7), com.obric.memorydata.personalcontext.api.a.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L10;
        r6.c(r8);
        return;
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void registerIAgentServiceProvider(IAgentServiceProvider r2) {
        Intrinsics.checkNotNullParameter((IAgentServiceProvider) ZeusTransformUtils.wrapperContextForParams(r2, IAgentServiceProvider.class, "com.obric.memorydata.plugin"), "agentServiceProvider");
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void start() {
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void stop() {
    }

    @Override // com.obric.memorydata.personalcontext.api.IEntityCollectorService
    public void syncData() {
    }
}
