package com.obric.smssdk;

import android.content.Context;
import com.obric.a.a.f;
import com.obric.capabilitykit.EntitySupplier;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.sync.EntityIdData;
import com.obric.capabilitykit.sync.EntitySyncDataSupplier;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0002\u0018\u0019B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\tH\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/smssdk/SmsMmsEntitySupplier;", "Lcom/obric/capabilitykit/EntitySupplier;", "Lcom/obric/capabilitykit/sync/EntitySyncDataSupplier;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "buildEntityIdData", "Lcom/obric/capabilitykit/sync/EntityIdData;", "sourceType", "", "rowId", "", "lastModifyTime", "getWholeEntities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "idList", "type", "", "parseEntityId", "Lcom/obric/smssdk/SmsMmsEntitySupplier$ParsedEntityId;", "entityId", "provideAllEntities", "provideSampleEntities", "Companion", "ParsedEntityId", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class b implements EntitySupplier, EntitySyncDataSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14976a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f14977b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/smssdk/SmsMmsEntitySupplier$Companion;", "", "()V", "MMS_PREFIX", "", "SMS_PREFIX", "TAG", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.smssdk.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/obric/smssdk/SmsMmsEntitySupplier$ParsedEntityId;", "", "entityId", "", "rowId", "sourceType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEntityId", "()Ljava/lang/String;", "getRowId", "getSourceType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "contactsdk_debug"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class C0801b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14979b;
        private final String c;

        public C0801b(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "entityId");
            Intrinsics.checkNotNullParameter(r3, "rowId");
            Intrinsics.checkNotNullParameter(r4, "sourceType");
            this.f14978a = r2;
            this.f14979b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f14979b;
        }

        public final String b() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0801b.class) == true) goto L8;
            return false;
        L8:
            C0801b r6 = (C0801b) ZeusTransformUtils.preCheckCast(r5, C0801b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f14978a, r6.f14978a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f14979b, r6.f14979b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f14978a.hashCode() * 31) + this.f14979b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "ParsedEntityId(entityId=" + this.f14978a + ", rowId=" + this.f14979b + ", sourceType=" + this.c + ')';
        }
    }

    static {
        f14976a = new a(null);
    }

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.f14977b = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
    }

    private final EntityIdData a(String r1, long r2, long r4) {
        if (Intrinsics.areEqual(r1, "sms") == false) goto L7;
        StringBuilder r0 = new StringBuilder();
        String r3 = "sms_";
    L5:
        String r5 = r0.append(r3).append(r2).toString();
    L11:
        return new EntityIdData(r5, 101, r4);
    L7:
        if (Intrinsics.areEqual(r1, "mms") == false) goto L9;
        r0 = new StringBuilder();
        r3 = "mms_";
        goto L5
    L9:
        r5 = String.valueOf(r2);
        goto L11
    }

    private final C0801b a(String r6) {
        if (StringsKt.startsWith$default(r6, "sms_", false, 2, null) == false) goto L6;
        return new C0801b(r6, StringsKt.removePrefix(r6, (CharSequence) ZeusTransformUtils.preCheckCast("sms_", CharSequence.class, "com.obric.memorydata.plugin")), "sms");
    L6:
        if (StringsKt.startsWith$default(r6, "mms_", false, 2, null) == true) goto L8;
        return null;
    L8:
        return new C0801b(r6, StringsKt.removePrefix(r6, (CharSequence) ZeusTransformUtils.preCheckCast("mms_", CharSequence.class, "com.obric.memorydata.plugin")), "mms");
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<AppEntity> getWholeEntities(List<String> r18, int r19) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "idList");
        if (r2.isEmpty() == false) goto L7;
        f.a(f.f5867a, "SmsMmsDataManager", "getWholeEntities: idList is empty", null, 4, null);
        return CollectionsKt.emptyList();
    L7:
        if (r19 == 101) goto L10;
        f.a(f.f5867a, "SmsMmsDataManager", "getWholeEntities: unknown entity type: " + r19, null, 4, null);
        return CollectionsKt.emptyList();
    L10:
        List<String> r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<String> r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L12:
        if (r6.hasNext() == false) goto L22;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        C0801b r10 = a(r7);
        if (r10 == null) goto L15;
        String r8 = r10.b();
        if (Intrinsics.areEqual(r8, "sms") == true) goto L18;
        if (Intrinsics.areEqual(r8, "mms") == false) goto L12;
        r5.add(r10.a());
        goto L12
    L18:
        r4.add(r10.a());
        goto L12
    L15:
        f.a(f.f5867a, "SmsMmsDataManager", "getWholeEntities: unknown entity id format: " + r7 + ", type=" + r19, null, 4, null);
        goto L12
    L22:
        List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    L30:
        e = move-exception;
        f.f5867a.a("SmsMmsDataManager", "getWholeEntities error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L32:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r0, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r9 = r0.iterator();
    L34:
        if (r9.hasNext() == false) goto L36;
        Object r11 = r9.next();
        r3.put(((MessageEntity) ZeusTransformUtils.preCheckCast(r11, MessageEntity.class, "com.obric.memorydata.plugin")).getId(), r11);
        goto L34
    L36:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L38:
        if (r14.hasNext() == false) goto L43;
        MessageEntity r15 = (MessageEntity) ZeusTransformUtils.preCheckCast(r3.get((String) ZeusTransformUtils.preCheckCast(r14.next(), String.class, "com.obric.memorydata.plugin")), MessageEntity.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L38;
        r13.add(r15);
        goto L38
    L43:
        return (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
    L24:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L27;
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(com.obric.smssdk.utils.a.f14982a.a(r4, "sms", this.f14977b), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L30
    L27:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L32;
        r1.addAll((Collection) ZeusTransformUtils.preCheckCast(com.obric.smssdk.utils.a.f14982a.a(r5, "mms", this.f14977b), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L30
        goto L32
    }

    @Override // com.obric.capabilitykit.EntitySupplier
    public List<AppEntity> provideAllEntities() {
        f.f5867a.b("SmsMmsDataManager", "in provideAllEntities");
        ArrayList r0 = new ArrayList((Collection) ZeusTransformUtils.preCheckCast(com.obric.smssdk.utils.a.f14982a.a(this.f14977b), Collection.class, "com.obric.memorydata.plugin"));
        f.f5867a.b("SmsMmsDataManager", "provideAllEntities, allMessageEntities size = " + r0.size());
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.capabilitykit.sync.EntitySyncDataSupplier
    public List<EntityIdData> provideSampleEntities() {
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.smssdk.utils.a.f14982a.b(this.f14977b), Iterable.class, "com.obric.memorydata.plugin");
        Collection r1 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        com.obric.smssdk.utils.a.C0802a r3 = (com.obric.smssdk.utils.a.C0802a) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.smssdk.utils.a.C0802a.class, "com.obric.memorydata.plugin");
        r1.add(a(r3.getType(), r3.a(), r3.b()));
        goto L4
    L6:
        List<EntityIdData> r10 = (List) ZeusTransformUtils.preCheckCast(r1, List.class, "com.obric.memorydata.plugin");
        f.f5867a.b("SmsMmsDataManager", "provideSampleEntities size = " + r10.size());
        return r10;
    }
}
