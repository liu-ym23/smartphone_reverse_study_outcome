package com.obric.memorydata.personalcontext.storage;

import android.database.sqlite.SQLiteException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.entity.meta.MetaLocation;
import com.obric.memorydata.annotation.Type;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.entity.cd;
import com.obric.memorydata.database.entity.gd;
import com.obric.memorydata.database.entity.gq;
import com.obric.memorydata.database.entity.gs;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.entity.hr;
import com.obric.memorydata.database.index.EntityIndexEngine;
import com.obric.memorydata.database.index.GatewayTransactionMode;
import com.obric.memorydata.database.index.ao;
import com.obric.memorydata.database.index.az;
import com.obric.memorydata.database.index.ba;
import com.obric.memorydata.database.index.bc;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u000256B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J,\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u000b\u001a\u00020\nH\u0016JF\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J0\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\r2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0019H\u0002J2\u0010\u001f\u001a\u00020 2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\r2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\r2\u0006\u0010%\u001a\u00020\u001dH\u0002J&\u0010&\u001a\u00020'2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0*H\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0002J\u001a\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u0005H\u0016J\u001a\u00101\u001a\u0004\u0018\u00010/2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u00102\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010/H\u0016J\u0018\u00104\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u00067"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/PhotoEntityStorage;", "Lcom/obric/memorydata/personalcontext/storage/AbstractAppEntityStorage;", "<init>", "()V", "index", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "delete", "entityId", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "bulkDelete", "", "entitiesIds", "type", "", "isSupportBulkDelete", "getRawDbEntityFromEntityIdList", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "bulkPreIndex", "", "entityTableDao", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "appEntitiesById", "", "entities", "isUpdate", "preIndexDonatedLocationsWithReplay", "Lcom/obric/memorydata/database/entity/RawMetaLocationEntity;", "rawDbIds", "preIndexDonatedLocations", "Lcom/obric/memorydata/personalcontext/storage/PhotoEntityStorage$LocationPreIndexResult;", "transactionMode", "Lcom/obric/memorydata/database/index/GatewayTransactionMode;", "buildLocationPendingEntities", "Lcom/obric/memorydata/database/entity/IndexPendingEntity;", "location", "insertTag", "", LocationMonitorConst.TAG, "insertIdList", "", "makeRawPhotoLocationEntity", "photoEntity", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "transformAppEntityToRawDbEntity", "Lcom/obric/memorydata/database/IAppEntityRawDbData;", "isLazyIndex", "getRawDbEntityFromEntityId", "getRawDbEntityByAppEntityAndHistoryEntity", "historyEntity", "isEnableLazyIndex", "Companion", "LocationPreIndexResult", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class w extends com.obric.memorydata.personalcontext.storage.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12349a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f12350b = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/PhotoEntityStorage$Companion;", "", "<init>", "()V", "VIDEO_FRAME_SUFFIX", "", "TAG", "VIDEO_FRAME_COLUMNS_NAME", "OCR_COLUMNS_NAME", "TAG_COLUMNS_NAME", "PHOTO_LOCATION_PREINDEX_SOURCE", "PHOTO_LOCATION_WRITE_LOCK", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/personalcontext/storage/PhotoEntityStorage$LocationPreIndexResult;", "", "locations", "", "Lcom/obric/memorydata/database/entity/RawMetaLocationEntity;", "replayReceipt", "Lcom/obric/memorydata/database/index/PendingOnlyReplayReceipt;", "<init>", "(Ljava/util/List;Lcom/obric/memorydata/database/index/PendingOnlyReplayReceipt;)V", "getLocations", "()Ljava/util/List;", "getReplayReceipt", "()Lcom/obric/memorydata/database/index/PendingOnlyReplayReceipt;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<gq> f12351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ba f12352b;

        public b(List<gq> r3, ba r4) {
            List<gq> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            ba r6 = (ba) ZeusTransformUtils.wrapperContextForParams(r4, ba.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "locations");
            this.f12351a = r5;
            this.f12352b = r6;
        }

        public final List<gq> a() {
            return this.f12351a;
        }

        public final ba b() {
            return this.f12352b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12351a, r6.f12351a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12352b, r6.f12352b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f12351a.hashCode() * 31;
            ba r1 = this.f12352b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "LocationPreIndexResult(locations=" + this.f12351a + ", replayReceipt=" + this.f12352b + ')';
        }
    }

    static {
        f12349a = new a(null);
        f12350b = new Object();
    }

    public w() {
    }

    private final gq a(PhotoEntity r31) {
        String r3 = r31.getId();
        long r4 = r31.getCreateTime();
        long r6 = r31.getLastModifiedTime();
        String r11 = r31.get_packageName();
        int r12 = r31.getHashCodeValue();
        int r13 = r31.getType();
        MetaLocation r0 = r31.getLocation();
        if (r0 == null) goto L5;
        String r14 = r0.getCountry();
    L6:
        MetaLocation r1 = r31.getLocation();
        if (r1 == null) goto L9;
        String r15 = r1.getStateOrProvince();
    L10:
        MetaLocation r2 = r31.getLocation();
        if (r2 == null) goto L13;
        String r16 = r2.getAdministrativeArea();
    L14:
        MetaLocation r5 = r31.getLocation();
        if (r5 == null) goto L17;
        String r17 = r5.getLocality();
    L18:
        MetaLocation r7 = r31.getLocation();
        if (r7 == null) goto L21;
        String r18 = r7.getSubLocality();
    L22:
        MetaLocation r8 = r31.getLocation();
        if (r8 == null) goto L25;
        String r19 = r8.getThoroughfare();
    L26:
        MetaLocation r9 = r31.getLocation();
        if (r9 == null) goto L29;
        String r20 = r9.getSubThoroughfare();
    L30:
        MetaLocation r10 = r31.getLocation();
        if (r10 == null) goto L33;
        String r21 = r10.getNamedLocation();
    L34:
        MetaLocation r22 = r31.getLocation();
        if (r22 == null) goto L37;
        String r23 = r22.getFullAddress();
    L38:
        MetaLocation r24 = r31.getLocation();
        if (r24 == null) goto L41;
        double r25 = r24.getLongitude();
    L42:
        MetaLocation r26 = r31.getLocation();
        if (r26 == null) goto L45;
        double r27 = r26.getLatitude();
    L47:
        return new gq(0, r3, r4, r6, NetError.ERR_DISALLOWED_URL_SCHEME, 0, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r25, r27, 33, null);
    L45:
        r27 = 0.0d;
        goto L47
    L41:
        r25 = 0.0d;
        goto L42
    L37:
        r23 = null;
        goto L38
    L33:
        r21 = null;
        goto L34
    L29:
        r20 = null;
        goto L30
    L25:
        r19 = null;
        goto L26
    L21:
        r18 = null;
        goto L22
    L17:
        r17 = null;
        goto L18
    L13:
        r16 = null;
        goto L14
    L9:
        r15 = null;
        goto L10
    L5:
        r14 = null;
        goto L6
    }

    private static final b a(w r2, List r3, Map r4) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), GatewayTransactionMode.OBSERVED_IN_CALLER_TRANSACTION);
    }

    private final b a(List<Long> r21, Map<String, ? extends AppEntity> r22, GatewayTransactionMode r23) {
        List<Long> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r22, Map.class, "com.obric.memorydata.plugin");
        List<T> r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao().queryByIds(r1);
        gq r5 = null;
        if (r2.isEmpty() == true) goto L5;
        List r4 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r8 = r6.iterator();
    L8:
        if (r8.hasNext() == false) goto L13;
        Object r9 = r8.next();
        String r10 = ((hb) ZeusTransformUtils.preCheckCast(r9, hb.class, "com.obric.memorydata.plugin")).getPackageName();
        Object r11 = r7.get(r10);
        if (r11 != null) goto L12;
        r11 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r7.put(r10, r11);
    L12:
        ((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin")).add(r9);
        goto L8
    L13:
        Iterator r12 = r7.entrySet().iterator();
        ba r13 = null;
    L15:
        if (r12.hasNext() == false) goto L105;
        Map.Entry r14 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r15 = (String) ZeusTransformUtils.preCheckCast(r14.getKey(), String.class, "com.obric.memorydata.plugin");
        List r16 = (List) ZeusTransformUtils.preCheckCast(r14.getValue(), List.class, "com.obric.memorydata.plugin");
        Iterable r17 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r18 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r19 = r17.iterator();
    L18:
        if (r19.hasNext() == false) goto L20;
        r18.add(((hb) ZeusTransformUtils.preCheckCast(r19.next(), hb.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L18
    L20:
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaLocationRawDbDao().queryByEntityIdListAndPackageName((List) ZeusTransformUtils.preCheckCast(r18, List.class, "com.obric.memorydata.plugin"), r15), Iterable.class, "com.obric.memorydata.plugin");
        Map r24 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r20, 10)), 16)), Map.class, "com.obric.memorydata.plugin");
        Iterator r25 = r20.iterator();
    L22:
        if (r25.hasNext() == false) goto L24;
        Object r110 = r25.next();
        r24.put(((gq) ZeusTransformUtils.preCheckCast(r110, gq.class, "com.obric.memorydata.plugin")).getEntityId(), r110);
        goto L22
    L24:
        Iterable r26 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r111 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r27 = r26.iterator();
    L26:
        if (r27.hasNext() == false) goto L40;
        hb r112 = (hb) ZeusTransformUtils.preCheckCast(r27.next(), hb.class, "com.obric.memorydata.plugin");
        if (r24.containsKey(r112.getEntityId()) == false) goto L30;
    L29:
        gq r113 = r5;
    L38:
        if (r113 == null) goto L26;
        r111.add(r113);
        goto L26
    L30:
        Object r114 = r3.get(r112.getEntityId());
        if (ZeusTransformUtils.instanceOf(r114, PhotoEntity.class) == false) goto L33;
        PhotoEntity r115 = (PhotoEntity) ZeusTransformUtils.preCheckCast(r114, PhotoEntity.class, "com.obric.memorydata.plugin");
    L34:
        if (r115 == null) goto L29;
        r113 = a(r115);
        if (r113.m() == true) goto L29;
    L33:
        r115 = r5;
        goto L34
    L40:
        List r28 = (List) ZeusTransformUtils.preCheckCast(r111, List.class, "com.obric.memorydata.plugin");
        List<Long> r116 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaLocationRawDbDao().insertAll(r28);
        if (r116.size() != r28.size()) goto L103;
        Iterable r117 = (Iterable) ZeusTransformUtils.preCheckCast(r116, Iterable.class, "com.obric.memorydata.plugin");
        boolean r118 = true;
        if (ZeusTransformUtils.instanceOf(r117, Collection.class) == true) goto L45;
    L47:
        Iterator r119 = r117.iterator();
    L49:
        if (r119.hasNext() == false) goto L46;
        if (((Number) ZeusTransformUtils.preCheckCast(r119.next(), Number.class, "com.obric.memorydata.plugin")).longValue() > 0) goto L53;
        boolean r29 = true;
    L54:
        if (r29 == false) goto L49;
        boolean r30 = true;
    L57:
        if (r30 == true) goto L103;
        Iterator r31 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.zip((Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r116, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L60:
        if (r31.hasNext() == false) goto L62;
        Pair r120 = (Pair) ZeusTransformUtils.preCheckCast(r31.next(), Pair.class, "com.obric.memorydata.plugin");
        ((gq) ZeusTransformUtils.preCheckCast(r120.component1(), gq.class, "com.obric.memorydata.plugin")).setId(((Number) ZeusTransformUtils.preCheckCast(r120.component2(), Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L60
    L62:
        r4.addAll((Collection) ZeusTransformUtils.preCheckCast(r28, Collection.class, "com.obric.memorydata.plugin"));
        Iterable r32 = (Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin");
        Collection r121 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r33 = r32.iterator();
    L64:
        if (r33.hasNext() == false) goto L66;
        CollectionsKt.addAll(r121, (Iterable) ZeusTransformUtils.preCheckCast(a((gq) ZeusTransformUtils.preCheckCast(r33.next(), gq.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin"));
        goto L64
    L66:
        List<cd> r34 = (List) ZeusTransformUtils.preCheckCast(r121, List.class, "com.obric.memorydata.plugin");
        az<List<Long>> r122 = ao.f9372a.a("PUBLIC", r34, (bc) ZeusTransformUtils.preCheckCast(new bc.a(System.currentTimeMillis()), bc.class, "com.obric.memorydata.plugin"), r23);
        List r123 = (List) ZeusTransformUtils.preCheckCast(r122.a(), List.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L70;
        r13 = r122.b();
    L70:
        if (r123.size() != r34.size()) goto L101;
        Iterable r35 = (Iterable) ZeusTransformUtils.preCheckCast(r123, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r35, Collection.class) == true) goto L74;
    L76:
        Iterator r36 = r35.iterator();
    L78:
        if (r36.hasNext() == false) goto L75;
        if (((Number) ZeusTransformUtils.preCheckCast(r36.next(), Number.class, "com.obric.memorydata.plugin")).longValue() > 0) goto L82;
        boolean r124 = true;
    L83:
        if (r124 == false) goto L78;
    L84:
        if (r118 == true) goto L101;
        Set r37 = r24.keySet();
        Iterable r38 = (Iterable) ZeusTransformUtils.preCheckCast(r28, Iterable.class, "com.obric.memorydata.plugin");
        Collection r39 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r38, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r40 = r38.iterator();
    L87:
        if (r40.hasNext() == false) goto L89;
        r39.add(((gq) ZeusTransformUtils.preCheckCast(r40.next(), gq.class, "com.obric.memorydata.plugin")).getEntityId());
        goto L87
    L89:
        Set r41 = SetsKt.plus(r37, (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r39, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        Iterable r42 = (Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin");
        Collection r43 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r44 = r42.iterator();
    L91:
        if (r44.hasNext() == false) goto L95;
        Object r45 = r44.next();
        if (r41.contains(((hb) ZeusTransformUtils.preCheckCast(r45, hb.class, "com.obric.memorydata.plugin")).getEntityId()) == false) goto L91;
        r43.add(r45);
        goto L91
    L95:
        Iterable r46 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r43, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
        Iterator r47 = r46.iterator();
    L97:
        if (r47.hasNext() == false) goto L99;
        hb r48 = (hb) ZeusTransformUtils.preCheckCast(r47.next(), hb.class, "com.obric.memorydata.plugin");
        r48.d(r48.getEntityId());
        goto L97
    L99:
        MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao().updateAll((List) ZeusTransformUtils.preCheckCast(r46, List.class, "com.obric.memorydata.plugin"));
        r5 = null;
        goto L15
    L82:
        r124 = false;
    L75:
        r118 = false;
        goto L84
    L74:
        if (((Collection) ZeusTransformUtils.preCheckCast(r35, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L76;
    L101:
        throw new SQLiteException("insert photo location pending batch failed");
    L53:
        r29 = false;
    L46:
        r30 = false;
        goto L57
    L45:
        if (((Collection) ZeusTransformUtils.preCheckCast(r117, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L47;
    L103:
        throw new SQLiteException("insert photo location batch failed");
    L105:
        return new b(r4, r13);
    L5:
        return new b(CollectionsKt.emptyList(), null);
    }

    private final List<cd> a(gq r28) {
        EntityIndexEngine r1 = com.obric.memorydata.database.index.s.a();
        Set<String> r2 = r1.getAllColumns((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r28, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.intersect((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r1.getKeywordColumnMap((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r28, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).keySet(), Iterable.class, "com.obric.memorydata.plugin")), Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
        r2.add("insert_keyword_task");
    L5:
        Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r1.getEntityIndexPendingList((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r28, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin"), r2), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r0.iterator();
    L7:
        if (r4.hasNext() == false) goto L13;
        cd r5 = (cd) ZeusTransformUtils.preCheckCast(r4.next(), cd.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r5.i(), "keyword") == false) goto L11;
        r5 = cd.a(r5, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, "photo_location_preindex", false, 0, 0, 30719, null);
    L11:
        r3.add(r5);
        goto L7
    L13:
        return (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
    }

    private final List<gq> a(List<Long> r4, Map<String, ? extends AppEntity> r5) {
        final List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        return ((b) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().runInTransaction(new $$Lambda$w$yvgYO1OA9qabdOSTMxysZLVGwm4(this, r6, r7)), b.class, "com.obric.memorydata.plugin")).a();
    L5:
        b r3 = (b) ZeusTransformUtils.preCheckCast(ao.f9372a.a("PUBLIC", new $$Lambda$w$0sDaQeqD9whmEa50LU2bP6ZiZ7Y(this, r6, r7)), b.class, "com.obric.memorydata.plugin");
        ba r8 = r3.b();
        if (r8 == null) goto L9;
        ao.f9372a.a(r8);
    L9:
        return r3.a();
    }

    private final void a(AppEntity r22, String r23, List<String> r24) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        gs r2 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaTagRawDbDao().queryOneRecord(r23, r22.get_packageName());
        if (r2 != null) goto L5;
        long r10 = System.currentTimeMillis();
        r2 = new gs(0, gd.f9146a.a(), r10, r10, NetError.ERR_UNKNOWN_URL_SCHEME, 0, r22.get_packageName(), r22.getHashCodeValue(), r22.getType(), r23, 33, null);
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
    L5:
        r0.add(r2.getEntityId());
    }

    private static final b b(w r2, List r3, Map r4) {
        return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"), GatewayTransactionMode.PENDING_ONLY_IN_CALLER_TRANSACTION);
    }

    public static /* synthetic */ b lambda$0sDaQeqD9whmEa50LU2bP6ZiZ7Y(w r0, List r1, Map r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ b lambda$yvgYO1OA9qabdOSTMxysZLVGwm4(w r0, List r1, Map r2) {
        return a(r0, r1, r2);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(AppEntity r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "appEntity");
        return null;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.a a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "entityId");
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao().queryByEntityId(r1, r2)), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public com.obric.memorydata.database.entity.d a(AppEntity r39, com.obric.memorydata.database.a r40) {
        com.obric.memorydata.database.a r1 = (com.obric.memorydata.database.a) ZeusTransformUtils.wrapperContextForParams(r40, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r39, "appEntity");
        if (ZeusTransformUtils.instanceOf(r39, PhotoEntity.class) == true) goto L5;
        return null;
    L5:
        String r8 = r39.getId();
        long r9 = r39.getCreateTime();
        long r11 = r39.getLastModifiedTime();
        int r13 = r39.getType();
        String r16 = r39.get_packageName();
        int r17 = r39.getHashCodeValue();
        String r19 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin")).getName();
        String r20 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(((PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin")).getFile(), AppEntity.class, "com.obric.memorydata.plugin"));
        String r21 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin")).getAssetType().name();
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(((PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin")).getInAlbum(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        r5.add(((AlbumEntity) ZeusTransformUtils.preCheckCast(r4.next(), AlbumEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L7
    L9:
        String r22 = ((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")).toString();
        String r23 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin")).getResolution();
        long r24 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin")).getFileSize();
        boolean r26 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin")).isFavorite();
        if (ZeusTransformUtils.instanceOf(r1, hb.class) == false) goto L12;
        hb r6 = (hb) ZeusTransformUtils.preCheckCast(r1, hb.class, "com.obric.memorydata.plugin");
    L13:
        if (r6 == null) goto L15;
        String r27 = r6.j();
    L17:
        if (ZeusTransformUtils.instanceOf(r1, hb.class) == false) goto L19;
        hb r7 = (hb) ZeusTransformUtils.preCheckCast(r1, hb.class, "com.obric.memorydata.plugin");
    L20:
        if (r7 == null) goto L22;
        String r28 = r7.k();
    L24:
        if (ZeusTransformUtils.instanceOf(r1, hb.class) == false) goto L26;
        hb r10 = (hb) ZeusTransformUtils.preCheckCast(r1, hb.class, "com.obric.memorydata.plugin");
    L27:
        if (r10 == null) goto L29;
        String r29 = r10.l();
    L30:
        String r30 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin")).getCaption();
        String r32 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin")).getOcr();
        String r34 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin")).getSourcePackageName();
        String r33 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin")).getSourceAppName();
        SourceDeviceResolver r12 = SourceDeviceResolver.f12339a;
        PhotoEntity r14 = (PhotoEntity) ZeusTransformUtils.preCheckCast(r39, PhotoEntity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, hb.class) == false) goto L33;
        hb r15 = (hb) ZeusTransformUtils.preCheckCast(r1, hb.class, "com.obric.memorydata.plugin");
    L34:
        if (r15 == null) goto L36;
        String r18 = r15.p();
    L37:
        com.obric.memorydata.database.a r0 = a(r39, (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new hb(0, r8, r9, r11, r13, 0, r16, r17, null, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, null, r32, r33, r34, r12.a(r14, r18), 1048865, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), r1);
        if (ZeusTransformUtils.instanceOf(r0, com.obric.memorydata.database.entity.d.class) == true) goto L40;
        return null;
    L40:
        return (com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin");
    L36:
        r18 = null;
        goto L37
    L33:
        r15 = null;
        goto L34
    L29:
        r29 = null;
        goto L30
    L26:
        r10 = null;
        goto L27
    L22:
        r28 = null;
        goto L24
    L19:
        r7 = null;
        goto L20
    L15:
        r27 = null;
        goto L17
    L12:
        r6 = null;
        goto L13
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<Long> a(IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r5, Map<String, ? extends AppEntity> r6, List<? extends com.obric.memorydata.database.entity.d> r7, boolean r8) {
        IAppEntityRawDbDao<com.obric.memorydata.database.entity.d> r9 = (IAppEntityRawDbDao) ZeusTransformUtils.wrapperContextForParams(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin");
        Map<String, ? extends AppEntity> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        List<? extends com.obric.memorydata.database.entity.d> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "entityTableDao");
        Intrinsics.checkNotNullParameter(r10, "appEntitiesById");
        Intrinsics.checkNotNullParameter(r11, "entities");
        List<Long> r12 = super.a(r9, r10, r11, r8);
        if (r8 == false) goto L9;
        Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r13.iterator();
    L6:
        if (r14.hasNext() == false) goto L8;
        r0.add(Long.valueOf(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r14.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId()));
        goto L6
    L8:
        List<Long> r15 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
    L11:
        if (r15.isEmpty() == false) goto L28;
        return r12;
    L28:
        Object r1 = f12350b;     // Catch: SQLiteException -> L25
        monitor-enter(r1);     // Catch: SQLiteException -> L25
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(a(r15, r10), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L22
    L17:
        if (r4.hasNext() == false) goto L19;
        com.obric.memorydata.personalcontext.n.f12234a.a((gq) ZeusTransformUtils.preCheckCast(r4.next(), gq.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L22
        goto L17
    L19:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: SQLiteException -> L25
    L27:
        return r12;
    L22:
        th = move-exception;
        throw th;     // Catch: SQLiteException -> L25
    L25:
        e = move-exception;
        RunLog.INSTANCE.error("PhotoEntityStorage", "bulkPreIndex location failed, isUpdate=" + r8 + ", rawDbCount=" + r15.size(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L27
    L9:
        r15 = r12;
        goto L11
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<String> a(List<String> r10, int r11, String r12) {
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "entitiesIds");
        Intrinsics.checkNotNullParameter(r12, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Object r0 = f12350b;
        monitor-enter(r0);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (r13.isEmpty() == false) goto L7;
        List<String> r9 = CollectionsKt.emptyList();     // Catch: Throwable -> L24
    L22:
        monitor-exit(r0);
        return r9;
    L7:
        com.obric.memorydata.personalcontext.storage.a r1 = com.obric.memorydata.personalcontext.q.a(com.obric.memorydata.personalcontext.q.f12255a, NetError.ERR_DISALLOWED_URL_SCHEME, false, 2, null);     // Catch: Throwable -> L24
        if (r1 == null) goto L10;
        r1.a(r13, NetError.ERR_DISALLOWED_URL_SCHEME, r12);     // Catch: Throwable -> L24
    L10:
        List<com.obric.memorydata.database.entity.d> r2 = a(r13, r12);     // Catch: Throwable -> L24
        if (r2 == null) goto L17;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        Iterator r4 = r3.iterator();     // Catch: Throwable -> L24
    L14:
        if (r4.hasNext() == false) goto L16;
        r5.add(Long.valueOf(((com.obric.memorydata.database.entity.d) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.memorydata.database.entity.d.class, "com.obric.memorydata.plugin")).getId()));     // Catch: Throwable -> L24
        goto L14
    L16:
        List<Long> r6 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
    L18:
        List<String> r7 = MemoryDbEngine.INSTANCE.getGlobalDbEngine().getVideoFrameRawDbDao().queryEntityIdsByPhotoEntityDbIdList(r6, r12);     // Catch: Throwable -> L24
        com.obric.memorydata.personalcontext.storage.a r8 = com.obric.memorydata.personalcontext.q.a(com.obric.memorydata.personalcontext.q.f12255a, -304, false, 2, null);     // Catch: Throwable -> L24
        if (r8 == null) goto L21;
        r8.a(r7, -304, r12);     // Catch: Throwable -> L24
    L21:
        r9 = super.a(r13, r11, r12);     // Catch: Throwable -> L24
        goto L22
    L17:
        r6 = CollectionsKt.emptyList();     // Catch: Throwable -> L24
        goto L18
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public List<com.obric.memorydata.database.entity.d> a(List<String> r2, String r3) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "entitiesIds");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoRawDbDao().queryByEntityIdListAndPackageName(r1, r3);
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a() {
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return true;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean a(AppEntity r45) {
        Intrinsics.checkNotNullParameter(r45, "appEntity");
        if (ZeusTransformUtils.instanceOf(r45, PhotoEntity.class) == true) goto L5;
        return false;
    L5:
        List<String> r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<String> r2 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getTags();
        if (r2 == null) goto L12;
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        a(r45, (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin"), r1);
        goto L9
    L11:
        Unit r4 = Unit.INSTANCE;
    L12:
        Object r5 = f12350b;
        monitor-enter(r5);
        gq r6 = (gq) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaLocationRawDbDao().queryByEntityId(r45.getId(), r45.get_packageName())), gq.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L124
        if (r6 != null) goto L21;
        r6 = a((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L124
        if (r6.m() == true) goto L20;
        com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r6, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);     // Catch: Throwable -> L124
        com.obric.memorydata.personalcontext.n.f12234a.a(r6);     // Catch: Throwable -> L124
        goto L21
    L20:
        r6 = null;
    L21:
        monitor-exit(r5);
        if (r6 == null) goto L24;
        String r7 = r6.getEntityId();
    L25:
        if (r7 != null) goto L27;
        r7 = "";
    L27:
        String r35 = r7;
        com.obric.memorydata.database.a r8 = a(r45.getId(), r45.get_packageName());
        if (ZeusTransformUtils.instanceOf(r8, hb.class) == false) goto L30;
        hb r9 = (hb) ZeusTransformUtils.preCheckCast(r8, hb.class, "com.obric.memorydata.plugin");
    L31:
        if (r9 == null) goto L33;
        String r10 = r9.p();
    L34:
        com.obric.memorydata.personalcontext.storage.a r11 = (com.obric.memorydata.personalcontext.storage.a) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.personalcontext.storage.a.class, "com.obric.memorydata.plugin");
        String r14 = r45.getId();
        long r15 = r45.getCreateTime();
        long r17 = r45.getLastModifiedTime();
        int r19 = r45.getType();
        String r22 = r45.get_packageName();
        int r23 = r45.getHashCodeValue();
        String r25 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getName();
        String r26 = EntityExtKt.toJson((AppEntity) ZeusTransformUtils.preCheckCast(((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getFile(), AppEntity.class, "com.obric.memorydata.plugin"));
        String r27 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getAssetType().name();
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getInAlbum(), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r12.iterator();
    L36:
        if (r16.hasNext() == false) goto L38;
        r13.add(((AlbumEntity) ZeusTransformUtils.preCheckCast(r16.next(), AlbumEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L36
    L38:
        String r28 = ((List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin")).toString();
        String r29 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getResolution();
        long r30 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getFileSize();
        boolean r32 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).isFavorite();
        String r33 = r1.toString();
        List<PhotoFaceEntity> r18 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getFaces();
        if (r18 == null) goto L45;
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r18, Iterable.class, "com.obric.memorydata.plugin");
        Collection r21 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r24 = r20.iterator();
    L42:
        if (r24.hasNext() == false) goto L44;
        r21.add(((PhotoFaceEntity) ZeusTransformUtils.preCheckCast(r24.next(), PhotoFaceEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L42
    L44:
        List r31 = (List) ZeusTransformUtils.preCheckCast(r21, List.class, "com.obric.memorydata.plugin");
    L46:
        int r110 = 10;
        com.obric.memorydata.database.a r34 = com.obric.memorydata.personalcontext.storage.a.a(r11, r45, (com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(new hb(0, r14, r15, r17, r19, 0, r22, r23, null, r25, r26, r27, r28, r29, r30, r32, r33, String.valueOf(r31), r35, ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getCaption(), null, ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getOcr(), ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getSourceAppName(), ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getSourcePackageName(), SourceDeviceResolver.f12339a.a((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin"), r10), 1048865, null), com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), null, 4, null);
        Intrinsics.checkNotNull(r34, "null cannot be cast to non-null type com.obric.memorydata.database.entity.RawPhotoEntity");
        hb r36 = (hb) ZeusTransformUtils.preCheckCast(r34, hb.class, "com.obric.memorydata.plugin");
        if (((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getAssetType() != AssetTypeEnum.VIDEO) goto L51;
        com.obric.memorydata.database.a r37 = a(r45.getId(), r45.get_packageName());
        if (ZeusTransformUtils.instanceOf(r37, hb.class) == false) goto L51;
        hb r38 = (hb) ZeusTransformUtils.preCheckCast(r37, hb.class, "com.obric.memorydata.plugin");
    L52:
        boolean r39 = com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r36, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null);
        if (((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getAssetType() != AssetTypeEnum.VIDEO) goto L116;
        if (r39 == false) goto L114;
        com.obric.memorydata.database.a r40 = a(r45.getId(), r45.get_packageName());
        if (ZeusTransformUtils.instanceOf(r40, hb.class) == false) goto L58;
        hb r41 = (hb) ZeusTransformUtils.preCheckCast(r40, hb.class, "com.obric.memorydata.plugin");
    L59:
        if (r41 == null) goto L113;
        gd r111 = gd.f9146a;
        if (r38 == null) goto L63;
        String r112 = r38.a();
    L65:
        if (r111.a(r112, r41.a(), Type.FILE_ENTITY, null, false) == true) goto L71;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PhotoEntityStorage", "video file change, delete videoFrame, id: " + r45.getId(), false, 4, null);
        Iterator r42 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getVideoFrameRawDbDao().queryByPhotoEntityDbId(r41.getId()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L68:
        if (r42.hasNext() == false) goto L71;
        ((hr) ZeusTransformUtils.preCheckCast(r42.next(), hr.class, "com.obric.memorydata.plugin")).delete();
    L71:
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L76;
        List<VideoFrame> r43 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getVideoFrames();
        long r44 = r41.getId();
        if (r43 == null) goto L75;
        r41.removePendingColumn(r44, "videoFrames");
        Unit r46 = Unit.INSTANCE;
        goto L76
    L75:
        Boolean.valueOf(r41.insertInvalidatePendingColumn(r44, "videoFrames"));
    L76:
        long r47 = System.currentTimeMillis();
        List<VideoFrame> r48 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getVideoFrames();
        if (r48 == null) goto L109;
        Iterator r49 = ((Iterable) ZeusTransformUtils.preCheckCast(r48, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        int r113 = 0;
    L80:
        if (r49.hasNext() == false) goto L108;
        Object r114 = r49.next();
        int r310 = r113 + 1;
        if (r113 >= 0) goto L84;
        CollectionsKt.throwIndexOverflow();
    L84:
        VideoFrame r410 = (VideoFrame) ZeusTransformUtils.preCheckCast(r114, VideoFrame.class, "com.obric.memorydata.plugin");
        List<String> r115 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        List<String> r116 = r410.getTags();
        if (r116 == null) goto L91;
        Iterator r117 = ((Iterable) ZeusTransformUtils.preCheckCast(r116, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L88:
        if (r117.hasNext() == false) goto L90;
        a(r45, (String) ZeusTransformUtils.preCheckCast(r117.next(), String.class, "com.obric.memorydata.plugin"), r115);
        goto L88
    L90:
        Unit r50 = Unit.INSTANCE;
    L91:
        String r118 = r45.getId() + "_index" + r410.getFrameTime();
        long r119 = r45.getCreateTime();
        long r120 = r45.getLastModifiedTime();
        String r210 = r45.get_packageName();
        long r211 = r410.getStartTime();
        long r212 = r410.getEndTime();
        long r213 = r410.getFrameTime();
        String r311 = r115.toString();
        List<PhotoFaceEntity> r51 = r410.getFaces();
        if (r51 == null) goto L98;
        Iterable r52 = (Iterable) ZeusTransformUtils.preCheckCast(r51, Iterable.class, "com.obric.memorydata.plugin");
        Collection r53 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r52, r110)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r54 = r52.iterator();
    L95:
        if (r54.hasNext() == false) goto L97;
        r53.add(((PhotoFaceEntity) ZeusTransformUtils.preCheckCast(r54.next(), PhotoFaceEntity.class, "com.obric.memorydata.plugin")).getId());
        goto L95
    L97:
        List r55 = (List) ZeusTransformUtils.preCheckCast(r53, List.class, "com.obric.memorydata.plugin");
    L99:
        hr r56 = new hr(0, r118, r119, r120, -304, r47, r210, 0, r211, r212, r213, r311, String.valueOf(r55), r410.getCaption(), r410.getOcr(), r41.getId(), 1, null);
        if (com.obric.memorydata.database.a.C0451a.a((com.obric.memorydata.database.a) ZeusTransformUtils.preCheckCast(r56, com.obric.memorydata.database.a.class, "com.obric.memorydata.plugin"), false, 1, null) == false) goto L107;
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L107;
        List<String> r57 = r410.getTags();
        long r121 = r56.getId();
        if (r57 == null) goto L106;
        r56.removePendingColumn(r121, "tags");
        Unit r58 = Unit.INSTANCE;
        goto L107
    L106:
        Boolean.valueOf(r56.insertInvalidatePendingColumn(r121, "tags"));
    L107:
        r113 = r310;
        r110 = 10;
        goto L80
    L98:
        r55 = null;
        goto L99
    L108:
        Unit r0 = Unit.INSTANCE;
    L109:
        Iterator r59 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getVideoFrameRawDbDao().queryByPhotoEntityDbId(r41.getId(), r47), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L111:
        if (r59.hasNext() == false) goto L123;
        ((hr) ZeusTransformUtils.preCheckCast(r59.next(), hr.class, "com.obric.memorydata.plugin")).delete();
    L123:
        return r39;
    L63:
        r112 = null;
        goto L65
    L113:
        IRunLog r60 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r61 = "PhotoEntityStorage";
        StringBuilder r62 = new StringBuilder();
        String r63 = "get RawPhotoEntity failed, id: ";
    L115:
        IRunLog.a.b(r60, r61, r62.append(r63).append(r45.getId()).append(", not update videoFrame").toString(), null, 4, null);
        goto L123
    L58:
        r41 = null;
        goto L59
    L114:
        r60 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r61 = "PhotoEntityStorage";
        r62 = new StringBuilder();
        r63 = "index PhotoEntity failed, id: ";
        goto L115
    L116:
        if (r39 == false) goto L123;
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L123;
        List<String> r64 = ((PhotoEntity) ZeusTransformUtils.preCheckCast(r45, PhotoEntity.class, "com.obric.memorydata.plugin")).getTags();
        long r65 = r36.getId();
        if (r64 == null) goto L122;
        r36.removePendingColumn(r65, "tags");
        Unit r66 = Unit.INSTANCE;
        goto L123
    L122:
        Boolean.valueOf(r36.insertInvalidatePendingColumn(r65, "tags"));
    L51:
        r38 = null;
        goto L52
    L45:
        r31 = null;
        goto L46
    L33:
        r10 = null;
        goto L34
    L30:
        r9 = null;
        goto L31
    L24:
        r7 = null;
    L124:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.personalcontext.storage.a
    public boolean delete(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "entityId");
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Object r0 = f12350b;
        monitor-enter(r0);
        gq r1 = (gq) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaLocationRawDbDao().queryByEntityId(r6, r7)), gq.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r1 == null) goto L7;
        r1.delete();     // Catch: Throwable -> L19
    L7:
        com.obric.memorydata.database.a r2 = a(r6, r7);     // Catch: Throwable -> L19
        if (ZeusTransformUtils.instanceOf(r2, hb.class) == false) goto L10;
        hb r3 = (hb) ZeusTransformUtils.preCheckCast(r2, hb.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
    L11:
        if (r3 == null) goto L16;
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getVideoFrameRawDbDao().queryByPhotoEntityDbId(r3.getId()), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L19
    L14:
        if (r4.hasNext() == false) goto L16;
        ((hr) ZeusTransformUtils.preCheckCast(r4.next(), hr.class, "com.obric.memorydata.plugin")).delete();     // Catch: Throwable -> L19
    L16:
        boolean r5 = super.delete(r6, r7);     // Catch: Throwable -> L19
        monitor-exit(r0);
        return r5;
    L10:
        r3 = null;
    L19:
        th = move-exception;
        throw th;
    }
}
