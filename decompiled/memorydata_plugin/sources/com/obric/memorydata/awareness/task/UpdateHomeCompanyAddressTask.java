package com.obric.memorydata.awareness.task;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.obric.memory.model.GetLocationRequest;
import com.bytedance.obric.memory.model.GetLocationResponse;
import com.bytedance.rpc.RpcException;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.database.entity.ProfileKey;
import com.obric.memorydata.database.entity.hn;
import com.obric.memorydata.memory.api.CommonAddressManager;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskParameter;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0002()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u001c\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00122\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0002J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J \u0010\u001f\u001a\u0004\u0018\u00010 2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00180\u00162\u0006\u0010!\u001a\u00020\"H\u0002J(\u0010#\u001a\u0004\u0018\u0001H$\"\u0006\b\u0000\u0010$\u0018\u00012\u0006\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012H\u0082\b¢\u0006\u0002\u0010'¨\u0006*"}, d2 = {"Lcom/obric/memorydata/awareness/task/UpdateHomeCompanyAddressTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskParameter", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "updateAddress", "", TypedValues.AttributesType.S_TARGET, "Lcom/obric/memorydata/awareness/task/UpdateHomeCompanyAddressTask$AddressTarget;", "isTriggeredByAutoLearn", "", "waitForNextAddressLookupAttempt", "isTaskTriggeredByAutoLearn", "getTargetAddressTypes", "", "", "isSelectedManualAddressGps", "addressType", "gps", "", "getValidGps", "", "featureName", "getCachedLearnedAddress", "Lcom/obric/memorydata/memory/api/model/AddressInfo;", "userId", "restoreSelectedManualAddressIfPresent", "syncLearnedAddressIfAutoLearnDisabled", "getAddressInfo", "Lcom/obric/memorydata/awareness/task/AddressInfo;", "locationData", "Lcom/obric/memorydata/awareness/task/LocationData;", "parseJson", ExifInterface.GPS_DIRECTION_TRUE, "json", "contentName", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;", "Companion", "AddressTarget", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UpdateHomeCompanyAddressTask extends NativeTask {
    private static final int ADDRESS_LOOKUP_MAX_ATTEMPTS = 3;
    private static final long ADDRESS_LOOKUP_RETRY_DELAY_MS = 10000;
    public static final a Companion = null;
    private static final String KEY_UPDATED_ADDRESS_TYPES = "updatedAddressTypes";
    public static final String NAME = "UpdateHomeCompanyAddressTask";
    private static final String TAG = "UpdateHomeCompanyAddressTask";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/awareness/task/UpdateHomeCompanyAddressTask$AddressTarget;", "", "inputType", "", "featureName", "addressType", "storageKey", "profileKey", "Lcom/obric/memorydata/database/entity/ProfileKey;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/database/entity/ProfileKey;)V", "getInputType", "()Ljava/lang/String;", "getFeatureName", "getAddressType", "getStorageKey", "getProfileKey", "()Lcom/obric/memorydata/database/entity/ProfileKey;", "HOME", "COMPANY", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final enum AddressTarget extends Enum<AddressTarget> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ AddressTarget[] $VALUES = null;
        public static final AddressTarget COMPANY = null;
        public static final AddressTarget HOME = null;
        private final String addressType;
        private final String featureName;
        private final String inputType;
        private final ProfileKey profileKey;
        private final String storageKey;

        private static final /* synthetic */ AddressTarget[] $values() {
            return new AddressTarget[]{HOME, COMPANY};
        }

        static {
            HOME = new AddressTarget("HOME", 0, "home", "location_home_gps", "家", "home_address", ProfileKey.ADDRESS_HOME);
            COMPANY = new AddressTarget("COMPANY", 1, "company", "location_company_gps", "公司", "company_address", ProfileKey.ADDRESS_COMPANY);
            AddressTarget[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private AddressTarget(String r1, int r2, String r3, String r4, String r5, String r6, ProfileKey r7) {
            super(r1, r2);
            this.inputType = r3;
            this.featureName = r4;
            this.addressType = r5;
            this.storageKey = r6;
            this.profileKey = r7;
        }

        public static EnumEntries<AddressTarget> getEntries() {
            return $ENTRIES;
        }

        public static AddressTarget valueOf(String r2) {
            return (AddressTarget) ZeusTransformUtils.preCheckCast(Enum.valueOf(AddressTarget.class, r2), AddressTarget.class, "com.obric.memorydata.plugin");
        }

        public static AddressTarget[] values() {
            return (AddressTarget[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AddressTarget[].class, "com.obric.memorydata.plugin");
        }

        public final String getAddressType() {
            return this.addressType;
        }

        public final String getFeatureName() {
            return this.featureName;
        }

        public final String getInputType() {
            return this.inputType;
        }

        public final ProfileKey getProfileKey() {
            return this.profileKey;
        }

        public final String getStorageKey() {
            return this.storageKey;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/awareness/task/UpdateHomeCompanyAddressTask$Companion;", "", "<init>", "()V", "TAG", "", "KEY_UPDATED_ADDRESS_TYPES", "ADDRESS_LOOKUP_MAX_ATTEMPTS", "", "ADDRESS_LOOKUP_RETRY_DELAY_MS", "", "NAME", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public UpdateHomeCompanyAddressTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskParameter");
        super(r2);
    }

    private final AddressInfo getAddressInfo(List<Double> r20, LocationData r21) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Place r2 = r21.getPlace();
        if (r2 == null) goto L48;
        StringBuilder r3 = new StringBuilder().append(r2.getAdminArea()).append(r2.getLocality()).append(r2.getSubLocality());
        Town r4 = r21.getTown();
        String r5 = "";
        if (r4 == null) goto L8;
        String r6 = r4.getName();
        if (r6 == null) goto L8;
    L9:
        String r8 = r3.append(r6).toString();
        List r7 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<AreaOfInterest> r9 = r2.getAoi();
        if (r9 != null) goto L12;
        r9 = CollectionsKt.emptyList();
    L12:
        Iterator<AreaOfInterest> r10 = r9.iterator();
    L13:
        boolean r11 = true;
        if (r10.hasNext() == false) goto L28;
        AreaOfInterest r12 = (AreaOfInterest) ZeusTransformUtils.preCheckCast(r10.next(), AreaOfInterest.class, "com.obric.memorydata.plugin");
        Double r13 = r12.getDistance();
        if (r13 == null) goto L13;
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).doubleValue() > 1.0E-5d) goto L13;
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(r12.getName(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L22;
    L25:
        if (r11 == true) goto L13;
        r7.add(r12.getName());
        goto L13
    L22:
        if (r14.length() == 0) goto L25;
        r11 = false;
        goto L25
    L28:
        if (r7.isEmpty() == false) goto L45;
        List<AreaOfInterest> r15 = r2.getAoi();
        if (r15 != null) goto L32;
    L34:
        boolean r16 = false;
    L35:
        if (r16 == true) goto L47;
        StringBuilder r17 = new StringBuilder();
        List<AreaOfInterest> r18 = r2.getAoi();
        if (r18 == null) goto L44;
        AreaOfInterest r19 = (AreaOfInterest) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r18), AreaOfInterest.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L44;
        String r22 = r19.getName();
        if (r22 == null) goto L44;
        r5 = r22;
    L44:
        r5 = r17.append(r5).append("附近").toString();
    L47:
        return new AddressInfo(r5, r8, ((Number) ZeusTransformUtils.preCheckCast(r0.get(1), Number.class, "com.obric.memorydata.plugin")).doubleValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(0), Number.class, "com.obric.memorydata.plugin")).doubleValue(), false, true);
    L32:
        if (r15.isEmpty() != true) goto L34;
        r16 = true;
        goto L35
    L45:
        r5 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null);
    L8:
        r6 = "";
        goto L9
    L48:
        return null;
    }

    private final com.obric.memorydata.memory.api.model.AddressInfo getCachedLearnedAddress(AddressTarget r6, String r7) {
        boolean r2 = false;
        Object r4 = null;
        String r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).getString(r6.getStorageKey() + '_' + r7, "");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        r2 = true;
    L5:
        if (r2 == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L18;
        String r8 = r6.getAddressType() + "地址缓存";
        r4 = u.a().fromJson(r5, com.obric.memorydata.memory.api.model.AddressInfo.class);     // Catch: JsonParseException -> L12
    L15:
        return (com.obric.memorydata.memory.api.model.AddressInfo) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.memory.api.model.AddressInfo.class, "com.obric.memorydata.plugin");
    L12:
        e = move-exception;
        RunLog.INSTANCE.warn("UpdateHomeCompanyAddressTask", "解析" + r8 + "失败", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L15
    L18:
        return null;
    }

    private final Set<String> getTargetAddressTypes(boolean r9) {
        if (r9 == true) goto L10;
        Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(AddressTarget.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast((Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin");
        Iterator r11 = r8.iterator();
    L6:
        if (r11.hasNext() == false) goto L9;
        r10.add(((AddressTarget) ZeusTransformUtils.preCheckCast(r11.next(), AddressTarget.class, "com.obric.memorydata.plugin")).getInputType());
        goto L6
    L9:
        return (Set) ZeusTransformUtils.preCheckCast(r10, Set.class, "com.obric.memorydata.plugin");
    L10:
        String r12 = getTaskRequest().getTaskParameter().getInputParams().optString(KEY_UPDATED_ADDRESS_TYPES);
        Intrinsics.checkNotNullExpressionValue(r12, "optString(...)");
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{','}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L12:
        if (r14.hasNext() == false) goto L14;
        r1.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin")).toString());
        goto L12
    L14:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L16:
        if (r16.hasNext() == false) goto L30;
        Object r3 = r16.next();
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(AddressTarget.getEntries(), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L20;
    L22:
        Iterator r6 = r5.iterator();
    L24:
        if (r6.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(((AddressTarget) ZeusTransformUtils.preCheckCast(r6.next(), AddressTarget.class, "com.obric.memorydata.plugin")).getInputType(), r4) == false) goto L24;
        boolean r7 = true;
    L28:
        if (r7 == false) goto L16;
        r2.add(r3);
    L21:
        r7 = false;
        goto L28
    L20:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L22;
    L30:
        Set<String> r17 = CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        if (r17.isEmpty() == false) goto L33;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "自动学习地址更新任务缺少有效的地址类型", null, 4, null);
    L33:
        return r17;
    }

    private final List<Double> getValidGps(String r11) {
        Object r10 = FeatureManager.INSTANCE.getFeature(r11);
        if (ZeusTransformUtils.instanceOf(r10, List.class) == false) goto L5;
        List r12 = (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.memorydata.plugin");
    L6:
        if (r12 != null) goto L9;
        return null;
    L9:
        if (r12.size() == 2) goto L11;
        return null;
    L11:
        Object r3 = r12.get(0);
        if (ZeusTransformUtils.instanceOf(r3, Number.class) == false) goto L14;
        Number r4 = (Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin");
    L15:
        if (r4 == null) goto L52;
        double r5 = r4.doubleValue();
        Object r13 = r12.get(1);
        if (ZeusTransformUtils.instanceOf(r13, Number.class) == false) goto L19;
        Number r14 = (Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin");
    L20:
        if (r14 == null) goto L52;
        double r6 = r14.doubleValue();
        if (Double.isInfinite(r5) == false) goto L24;
    L26:
        boolean r15 = false;
    L27:
        if (r15 == false) goto L52;
        if ((-180.0d) <= r5) goto L31;
    L33:
        boolean r16 = false;
    L34:
        if (r16 == false) goto L52;
        if (Double.isInfinite(r6) == false) goto L38;
    L40:
        boolean r17 = false;
    L41:
        if (r17 == false) goto L52;
        if ((-90.0d) <= r6) goto L45;
    L47:
        boolean r18 = false;
    L48:
        if (r18 == false) goto L52;
        return CollectionsKt.listOf(new Double[]{Double.valueOf(r5), Double.valueOf(r6)});
    L45:
        if (r6 > 90.0d) goto L47;
        r18 = true;
        goto L48
    L38:
        if (Double.isNaN(r6) == true) goto L40;
        r17 = true;
        goto L41
    L31:
        if (r5 > 180.0d) goto L33;
        r16 = true;
        goto L34
    L24:
        if (Double.isNaN(r5) == true) goto L26;
        r15 = true;
        goto L27
    L19:
        r14 = null;
    L52:
        return null;
    L14:
        r4 = null;
        goto L15
    L5:
        r12 = null;
        goto L6
    }

    private final boolean isSelectedManualAddressGps(String r14, List<?> r15) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        Object r1 = r13.get(0);
        Object r3 = null;
        if (ZeusTransformUtils.instanceOf(r1, Number.class) == false) goto L5;
        Number r2 = (Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin");
    L6:
        if (r2 == null) goto L34;
        double r9 = r2.doubleValue();
        Object r16 = r13.get(1);
        if (ZeusTransformUtils.instanceOf(r16, Number.class) == false) goto L10;
        Number r17 = (Number) ZeusTransformUtils.preCheckCast(r16, Number.class, "com.obric.memorydata.plugin");
    L11:
        if (r17 == null) goto L35;
        double r11 = r17.doubleValue();
        Iterator r18 = ((Iterable) ZeusTransformUtils.preCheckCast(CommonAddressManager.INSTANCE.getAddressList(r14), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r18.hasNext() == false) goto L23;
        Object r19 = r18.next();
        com.obric.memorydata.memory.api.model.AddressInfo r4 = (com.obric.memorydata.memory.api.model.AddressInfo) ZeusTransformUtils.preCheckCast(r19, com.obric.memorydata.memory.api.model.AddressInfo.class, "com.obric.memorydata.plugin");
        if (r4.isSelect() == true) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == false) goto L14;
        r3 = r19;
        goto L23
    L18:
        if (r4.isFromAutoLearn() == true) goto L20;
        r5 = true;
    L23:
        com.obric.memorydata.memory.api.model.AddressInfo r110 = (com.obric.memorydata.memory.api.model.AddressInfo) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.api.model.AddressInfo.class, "com.obric.memorydata.plugin");
        if (r110 != null) goto L26;
        return false;
    L26:
        if (com.obric.memorydata.awareness.task.a.f8793a.a(r110.getLongitude(), r110.getLatitude(), r9, r11) == true) goto L28;
        return false;
    L28:
        return true;
    L35:
        return false;
    L10:
        r17 = null;
        goto L11
    L34:
        return false;
    L5:
        r2 = null;
        goto L6
    }

    private final boolean isTaskTriggeredByAutoLearn() {
        AbsTaskRequest r1 = getTaskRequest().getParentTaskRequest();
        if (r1 == null) goto L7;
        TaskParameter r2 = r1.getTaskParameter();
        if (r2 == null) goto L7;
        String r3 = r2.getName();
    L9:
        return Intrinsics.areEqual(r3, "home_company_location_calculate");
    L7:
        r3 = null;
        goto L9
    }

    private final /* synthetic */ <T> T parseJson(String r4, String r5) {
        Gson r0 = u.a();     // Catch: JsonParseException -> L5
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: JsonParseException -> L5
        return (T) r0.fromJson(r4, (Class) ZeusTransformUtils.preCheckCast(Object.class, Class.class, "com.obric.memorydata.plugin"));
    L5:
        e = move-exception;
        RunLog.INSTANCE.warn("UpdateHomeCompanyAddressTask", "解析" + r5 + "失败", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    private final void restoreSelectedManualAddressIfPresent(String r8) {
        List<com.obric.memorydata.memory.api.model.AddressInfo> r7 = CommonAddressManager.INSTANCE.getAddressList(r8);
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L6;
        com.obric.memorydata.memory.api.model.AddressInfo r2 = (com.obric.memorydata.memory.api.model.AddressInfo) ZeusTransformUtils.preCheckCast(r1.next(), com.obric.memorydata.memory.api.model.AddressInfo.class, "com.obric.memorydata.plugin");
        if (r2.isSelect() == true) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L9;
    L17:
        if (r3 == false) goto L19;
        return;
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "恢复用户手动设置的" + r8 + InfoCommonMemoryEntity.InfoKeyType.ADDRESS, false, 4, null);
        CommonAddressManager.INSTANCE.updateUserSetAddress(r7, r8);
        return;
    L13:
        if (r2.isFromAutoLearn() == true) goto L15;
        r4 = true;
    L6:
        r3 = true;
        goto L17
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L6
    }

    private final void syncLearnedAddressIfAutoLearnDisabled(String r1) {
        if (com.obric.memorydata.address.a.f8427a.a() == true) goto L6;
        CommonAddressManager.INSTANCE.reOrganizeAddress(r1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v16 */
    private final void updateAddress(AddressTarget r28, boolean r29) {
        if (com.obric.memorydata.address.a.f8427a.c() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "自动学习或位置权限状态已变化，停止更新" + r28.getAddressType() + InfoCommonMemoryEntity.InfoKeyType.ADDRESS, false, 4, null);
        return;
    L6:
        String r6 = AppContext.INSTANCE.getUserId();
        int r7 = 1;
        int r8 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "用户未登录，跳过" + r28.getAddressType() + "地址更新", false, 4, null);
        return;
    L13:
        List<Double> r9 = getValidGps(r28.getFeatureName());
        if (r9 != null) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "未获取到有效的" + r28.getAddressType() + "学习坐标，清理对应地址缓存", false, 4, null);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{r28.getStorageKey()});
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).remove(new String[]{r28.getStorageKey() + '_' + r6});
        if (r29 == false) goto L106;
        restoreSelectedManualAddressIfPresent(r28.getAddressType());
        return;
    L106:
        return;
    L19:
        if (r29 == true) goto L25;
        if (isSelectedManualAddressGps(r28.getAddressType(), r9) == false) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", r28.getAddressType() + "坐标来自用户手动设置，跳过地址反查", false, 4, null);
        return;
    L25:
        if (com.obric.memorydata.awareness.task.a.f8793a.a(((Number) ZeusTransformUtils.preCheckCast(r9.get(0), Number.class, "com.obric.memorydata.plugin")).doubleValue(), ((Number) ZeusTransformUtils.preCheckCast(r9.get(1), Number.class, "com.obric.memorydata.plugin")).doubleValue(), getCachedLearnedAddress(r28, r6)) == true) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", r28.getAddressType() + "学习坐标未变化，复用已缓存地址", false, 4, null);
        return;
    L28:
        int r14 = 1;
    L30:
        if (r14 >= 4) goto L92;
        if (com.obric.memorydata.address.a.f8427a.c() == false) goto L33;
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r6) == false) goto L37;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "开始第" + r14 + "次反查" + r28.getAddressType() + InfoCommonMemoryEntity.InfoKeyType.ADDRESS, false, 4, null);     // Catch: RpcException -> L46
        GetLocationRequest r1 = new GetLocationRequest();     // Catch: RpcException -> L46
        int r18 = r14;
        r1.longitude = ((Number) ZeusTransformUtils.preCheckCast(r9.get(r8), Number.class, "com.obric.memorydata.plugin")).doubleValue();     // Catch: RpcException -> L44
        r1.latitude = ((Number) ZeusTransformUtils.preCheckCast(r9.get(r7), Number.class, "com.obric.memorydata.plugin")).doubleValue();     // Catch: RpcException -> L44
        GetLocationResponse r2 = com.bytedance.obric.memory.a.a.a(r1);     // Catch: RpcException -> L44
        int r15 = r18;
    L49:
        if (r2 == null) goto L78;
        if (r2.code != 0) goto L78;
        if (r2.data == null) goto L78;
        String r3 = r2.data;
        Intrinsics.checkNotNullExpressionValue(r3, "data");
        String r4 = r28.getAddressType() + "地址响应";
        Object r5 = u.a().fromJson(r3, LocationData.class);     // Catch: JsonParseException -> L58
    L60:
        LocationData r10 = (LocationData) ZeusTransformUtils.preCheckCast(r5, LocationData.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L63;
        return;
    L63:
        AddressInfo r11 = getAddressInfo(r9, r10);
        if (r11 != null) goto L68;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", r28.getAddressType() + "地址响应中缺少有效地址信息", null, 4, null);
        return;
    L68:
        if (com.obric.memorydata.address.a.f8427a.c() == true) goto L72;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "自动学习或位置权限状态已变化，跳过写入" + r28.getAddressType() + InfoCommonMemoryEntity.InfoKeyType.ADDRESS, false, 4, null);
        return;
    L72:
        if (Intrinsics.areEqual(AppContext.INSTANCE.getUserId(), r6) == true) goto L75;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "登录账号已变化，跳过写入" + r28.getAddressType() + InfoCommonMemoryEntity.InfoKeyType.ADDRESS, false, 4, null);
        return;
    L75:
        hn.f9187a.a(r28.getProfileKey(), r11.getDetail() + r11.getName(), r7);
        IStore r12 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        String[] r13 = new String[r7];
        r13[0] = r28.getStorageKey();
        r12.remove(r13);
        IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null).save(r28.getStorageKey() + '_' + r6, u.a(r11));
        syncLearnedAddressIfAutoLearnDisabled(r28.getAddressType());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", r28.getAddressType() + "地址更新成功", false, 4, null);
        return;
    L58:
        e = move-exception;
        RunLog.INSTANCE.warn("UpdateHomeCompanyAddressTask", "解析" + r4 + "失败", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r5 = null;
    L78:
        if (r2 != null) goto L81;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", 31532 + r15 + "次反查" + r28.getAddressType() + "地址失败，响应为空", null, 4, null);
    L86:
        if (r15 >= 3) goto L92;
        if (waitForNextAddressLookupAttempt(r28) == false) goto L90;
        r14 = r15 + 1;
        r8 = 0;
        r7 = 1;
        goto L30
    L90:
        return;
    L81:
        if (r2.code == 0) goto L83;
        IRunLog r19 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder().append(31532).append(r15).append("次反查").append(r28.getAddressType()).append("地址失败，错误码=").append(r2.code);
    L84:
        IRunLog.a.a(r19, "UpdateHomeCompanyAddressTask", r16.toString(), null, 4, null);
        goto L86
    L83:
        r19 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r16 = new StringBuilder().append(31532).append(r15).append("次反查").append(r28.getAddressType()).append("地址失败，响应数据为空");
    L44:
        e = e;
    L48:
        r15 = r18;
        RunLog.INSTANCE.warn("UpdateHomeCompanyAddressTask", 31532 + r15 + "次请求" + r28.getAddressType() + "地址发生 RPC 异常", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        r2 = null;
    L46:
        e = e;
        r18 = r14;
        goto L48
    L37:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "登录账号已变化，停止反查" + r28.getAddressType() + InfoCommonMemoryEntity.InfoKeyType.ADDRESS, false, 4, null);
        return;
    L33:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "自动学习或位置权限状态已变化，停止反查" + r28.getAddressType() + InfoCommonMemoryEntity.InfoKeyType.ADDRESS, false, 4, null);
        return;
    L92:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "反查" + r28.getAddressType() + "地址连续失败，已停止重试", null, 4, null);
        return;
    L9:
        r0 = false;
        goto L10
    }

    private final boolean waitForNextAddressLookupAttempt(AddressTarget r9) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "10秒后重试" + r9.getAddressType() + "地址反查", false, 4, null);
        Thread.sleep(10000);     // Catch: InterruptedException -> L5
        return true;
    L5:
        Thread.currentThread().interrupt();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", r9.getAddressType() + "地址反查等待被中断，停止重试", false, 4, null);
        return false;
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "开始执行家/公司地址更新任务", false, 4, null);
        boolean r0 = isTaskTriggeredByAutoLearn();
        if (com.obric.memorydata.address.a.f8427a.a() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "自动学习已关闭，跳过家/公司地址更新", false, 4, null);
        return new TaskResult(0, null, null, null, 14, null);
    L7:
        if (com.obric.memorydata.address.a.f8427a.b() == true) goto L10;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "UpdateHomeCompanyAddressTask", "位置权限不可用，跳过家/公司地址更新", false, 4, null);
        return new TaskResult(0, null, null, null, 14, null);
    L10:
        Set<String> r1 = getTargetAddressTypes(r0);
        Iterator<AddressTarget> r3 = AddressTarget.getEntries().iterator();
    L12:
        if (r3.hasNext() == false) goto L17;
        AddressTarget r4 = (AddressTarget) ZeusTransformUtils.preCheckCast(r3.next(), AddressTarget.class, "com.obric.memorydata.plugin");
        if (r1.contains(r4.getInputType()) == false) goto L12;
        updateAddress(r4, r0);
        goto L12
    L17:
        return new TaskResult(0, null, null, null, 14, null);
    }
}
