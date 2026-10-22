package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/entity/MemoryKeyInfoEntity;", "", OaidModel.KEY_ID, "", "sourceEntityId", "", "key", EventBody.KEY_VALUE, "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getId", "()J", "getSourceEntityId", "()Ljava/lang/String;", "getKey", "getValue", "()Ljava/util/Set;", "isValid", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryKeyInfoEntity {
    private static final List<String> ALL_KEY_TYPES = null;
    public static final a Companion = null;
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_IDENTIFIER = "identifier";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_URL = "url";
    private final long id;
    private final String key;
    private final String sourceEntityId;
    private final Set<String> value;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b2\u0006\u0010\u0010\u001a\u00020\u00052\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00130\u0012J2\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/database/entity/MemoryKeyInfoEntity$Companion;", "", "<init>", "()V", "KEY_LOCATION", "", "KEY_ADDRESS", "KEY_PHONE", "KEY_URL", "KEY_IDENTIFIER", "ALL_KEY_TYPES", "", "getALL_KEY_TYPES", "()Ljava/util/List;", "convertMapToEntities", "Lcom/obric/memorydata/database/entity/MemoryKeyInfoEntity;", "sourceEntityId", "keyValueMap", "", "", "create", "key", "values", OaidModel.KEY_ID, "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ MemoryKeyInfoEntity a(a r6, String r7, String r8, Collection r9, long r10, int r12, Object r13) {
            Collection<String> r11 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
            if ((r12 & 4) == 0) goto L5;
            r11 = (Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.emptyList(), Collection.class, "com.obric.memorydata.plugin");
        L5:
            Collection<String> r3 = r11;
            if ((r12 & 8) == 0) goto L9;
            r10 = 0;
        L9:
            return r6.a(r7, r8, r3, r10);
        }

        public final MemoryKeyInfoEntity a(String r9, String r10, Collection<String> r11, long r12) {
            Collection r13 = (Collection) ZeusTransformUtils.wrapperContextForParams(r11, Collection.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r9, "sourceEntityId");
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r13, "values");
            if (a().contains(r10) == false) goto L13;
            String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.filterNotNull((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r15 = r8.iterator();
        L6:
            if (r15.hasNext() == false) goto L11;
            Object r16 = r15.next();
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L6;
            r14.add(r16);
            goto L6
        L11:
            return new MemoryKeyInfoEntity(r12, r5, r10, (Set) ZeusTransformUtils.preCheckCast(CollectionsKt.toHashSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin")), Set.class, "com.obric.memorydata.plugin"));
        L13:
            throw new IllegalArgumentException(("不支持的 Key 类型: " + r10 + "，仅支持: " + MemoryKeyInfoEntity.Companion.a()).toString());
        }

        public final List<String> a() {
            return MemoryKeyInfoEntity.access$getALL_KEY_TYPES$cp();
        }

        public final List<MemoryKeyInfoEntity> a(String r12, Map<String, ? extends Collection<String>> r13) {
            Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "sourceEntityId");
            Intrinsics.checkNotNullParameter(r11, "keyValueMap");
            LinkedHashMap r14 = new LinkedHashMap();
            Iterator r15 = r11.entrySet().iterator();
        L4:
            if (r15.hasNext() == false) goto L8;
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
            if (MemoryKeyInfoEntity.Companion.a().contains(r2) == false) goto L4;
            r14.put(r1.getKey(), r1.getValue());
            goto L4
        L8:
            Map r16 = (Map) ZeusTransformUtils.preCheckCast(r14, Map.class, "com.obric.memorydata.plugin");
            Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r16.size()), Collection.class, "com.obric.memorydata.plugin");
            Iterator r18 = r16.entrySet().iterator();
        L10:
            if (r18.hasNext() == false) goto L13;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            String r5 = (String) ZeusTransformUtils.preCheckCast(r3.getKey(), String.class, "com.obric.memorydata.plugin");
            Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(r3.getValue(), Collection.class, "com.obric.memorydata.plugin");
            r17.add(a(MemoryKeyInfoEntity.Companion, r12, r5, r6, 0, 8, null));
            goto L10
        L13:
            return (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
        }
    }

    static {
        Companion = new a(null);
        ALL_KEY_TYPES = CollectionsKt.listOf(new String[]{"location", KEY_ADDRESS, KEY_PHONE, "url", KEY_IDENTIFIER});
    }

    public MemoryKeyInfoEntity(long r3, String r5, String r6, Set<String> r7) {
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "sourceEntityId");
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r8, EventBody.KEY_VALUE);
        this.id = r3;
        this.sourceEntityId = r5;
        this.key = r6;
        this.value = r8;
    }

    public /* synthetic */ MemoryKeyInfoEntity(long r7, String r9, String r10, Set r11, int r12, DefaultConstructorMarker r13) {
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = 0;
    L5:
        long r1 = r7;
        if ((r12 & 8) == 0) goto L8;
        r14 = SetsKt.emptySet();
    L8:
        this(r1, r9, r10, r14);
    }

    public static final /* synthetic */ List access$getALL_KEY_TYPES$cp() {
        return ALL_KEY_TYPES;
    }

    public static /* synthetic */ MemoryKeyInfoEntity copy$default(MemoryKeyInfoEntity r6, long r7, String r9, String r10, Set r11, int r12, Object r13) {
        Set<String> r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.id;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.sourceEntityId;
    L8:
        String r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.key;
    L11:
        String r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        r14 = r6.value;
    L15:
        return r6.copy(r1, r3, r4, r14);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.sourceEntityId;
    }

    public final String component3() {
        return this.key;
    }

    public final Set<String> component4() {
        return this.value;
    }

    public final MemoryKeyInfoEntity copy(long r7, String r9, String r10, Set<String> r11) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "sourceEntityId");
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r5, EventBody.KEY_VALUE);
        return new MemoryKeyInfoEntity(r7, r9, r10, r5);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, MemoryKeyInfoEntity.class) == true) goto L8;
        return false;
    L8:
        MemoryKeyInfoEntity r10 = (MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r9, MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceEntityId, r10.sourceEntityId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r10.key) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.value, r10.value) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final long getId() {
        return this.id;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getSourceEntityId() {
        return this.sourceEntityId;
    }

    public final Set<String> getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.id) * 31) + this.sourceEntityId.hashCode()) * 31) + this.key.hashCode()) * 31) + this.value.hashCode();
    }

    public final boolean isValid() {
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(this.sourceEntityId, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L5;
    L7:
        return false;
    L5:
        if (ALL_KEY_TYPES.contains(this.key) == false) goto L7;
        return true;
    }

    public String toString() {
        return "MemoryKeyInfoEntity(id=" + this.id + ", sourceEntityId=" + this.sourceEntityId + ", key=" + this.key + ", value=" + this.value + ')';
    }
}
