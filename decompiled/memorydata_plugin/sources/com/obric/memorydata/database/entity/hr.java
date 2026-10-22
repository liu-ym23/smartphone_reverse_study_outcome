package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.app.VideoFrame;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0014J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0005H\u0014J\u0006\u0010;\u001a\u00020<J\u0018\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0005H\u0016J\u0012\u0010A\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020\u0005H\u0016J\n\u0010B\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010C\u001a\u00020\tH\u0016J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\tHÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\tHÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J±\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001J\u0013\u0010U\u001a\u0002092\b\u0010V\u001a\u0004\u0018\u00010WHÖ\u0003J\t\u0010X\u001a\u00020\tHÖ\u0001J\t\u0010Y\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u001a\u0010\r\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010-R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001c\"\u0004\b/\u0010-R \u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001c\"\u0004\b1\u0010-R \u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001c\"\u0004\b3\u0010-R\u001e\u0010\u0014\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001a¨\u0006Z"}, d2 = {"Lcom/obric/memorydata/database/entity/RawVideoFrameEntity;", "Lcom/obric/memorydata/database/entity/AbstractVideoFrameEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", "startTime", "endTime", "frameTime", "tags", "faces", "caption", "ocr", "photoEntityDbId", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;IJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getStartTime", "setStartTime", "getEndTime", "setEndTime", "getFrameTime", "setFrameTime", "getTags", "setTags", "(Ljava/lang/String;)V", "getFaces", "setFaces", "getCaption", "setCaption", "getOcr", "setOcr", "getPhotoEntityDbId", "setPhotoEntityDbId", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "isValidateValue", "", "columnsName", "covertToVideoFrame", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "getFileEntityJson", "getPhotoEntityType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class hr extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9193b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private long i;
    private long j;
    private long k;
    private String l;
    private String m;
    private String n;
    private String o;
    private long p;

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends String>> {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/obric/memorydata/utils/GsonExtKt$toListObj$1", "Lcom/google/gson/reflect/TypeToken;", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends TypeToken<List<? extends String>> {
        public b() {
        }
    }

    public hr(long r27, String r29, long r30, long r32, int r34, long r35, String r37, int r38, long r39, long r41, long r43, String r45, String r46, String r47, String r48, long r49) {
        Intrinsics.checkNotNullParameter(r29, "entityId");
        Intrinsics.checkNotNullParameter(r37, ObricMemoryConstants.KEY_PACKAGE_NAME);
        super(r27, r29, r30, r32, r34, r35, r37, r38, r39, r41, r43, r47, r48, r49);
        this.f9192a = r27;
        this.f9193b = r29;
        this.c = r30;
        this.d = r32;
        this.e = r34;
        this.f = r35;
        this.g = r37;
        this.h = r38;
        this.i = r39;
        this.j = r41;
        this.k = r43;
        this.l = r45;
        this.m = r46;
        this.n = r47;
        this.o = r48;
        this.p = r49;
    }

    public /* synthetic */ hr(long r29, String r31, long r32, long r34, int r36, long r37, String r39, int r40, long r41, long r43, long r45, String r47, String r48, String r49, String r50, long r51, int r53, DefaultConstructorMarker r54) {
        if ((r53 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r53 & 2048) == 0) goto L9;
        String r22 = null;
    L11:
        if ((r53 & 4096) == 0) goto L13;
        String r23 = null;
    L15:
        if ((r53 & 8192) == 0) goto L17;
        String r24 = null;
    L19:
        if ((r53 & 16384) == 0) goto L21;
        String r25 = null;
    L22:
        this(r4, r31, r32, r34, r36, r37, r39, r40, r41, r43, r45, r22, r23, r24, r25, r51);
        return;
    L21:
        r25 = r50;
        goto L22
    L17:
        r24 = r49;
        goto L19
    L13:
        r23 = r48;
        goto L15
    L9:
        r22 = r47;
        goto L11
    L5:
        r4 = r29;
        goto L7
    }

    @Override // com.obric.memorydata.database.entity.j
    public long a() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.j
    public void a(String r1) {
        this.n = r1;
    }

    @Override // com.obric.memorydata.database.entity.j
    public long b() {
        return this.j;
    }

    @Override // com.obric.memorydata.database.entity.j
    public void b(String r1) {
        this.o = r1;
    }

    @Override // com.obric.memorydata.database.entity.j
    public long c() {
        return this.k;
    }

    public final void c(String r1) {
        this.l = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r10) {
        Intrinsics.checkNotNullParameter(r10, "column");
        return (i) ZeusTransformUtils.preCheckCast(new jh(0, getId(), r10, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new ji(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.j
    public String d() {
        return this.n;
    }

    @Override // com.obric.memorydata.database.entity.j
    public String e() {
        return this.o;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, hr.class) == true) goto L8;
        return false;
    L8:
        hr r10 = (hr) ZeusTransformUtils.preCheckCast(r9, hr.class, "com.obric.memorydata.plugin");
        if (this.f9192a == r10.f9192a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9193b, r10.f9193b) == true) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (this.d == r10.d) goto L21;
        return false;
    L21:
        if (this.e == r10.e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r10.h) goto L33;
        return false;
    L33:
        if (this.i == r10.i) goto L36;
        return false;
    L36:
        if (this.j == r10.j) goto L39;
        return false;
    L39:
        if (this.k == r10.k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r10.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r10.p) goto L56;
        return false;
    L56:
        return true;
    }

    @Override // com.obric.memorydata.database.entity.j
    public long f() {
        return this.p;
    }

    @Override // com.obric.memorydata.database.entity.j
    public String g() {
        IAppEntityRawDbDao<d> r0 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(301);
        if (r0 == null) goto L5;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0.queryById(f()), d.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), d.TAG, "getVideoFrameFileEntityJson (id: " + f() + ") is null", null, 4, null);
        return null;
    L10:
        if (ZeusTransformUtils.instanceOf(r1, hb.class) == false) goto L12;
        hb r9 = (hb) ZeusTransformUtils.preCheckCast(r1, hb.class, "com.obric.memorydata.plugin");
    L13:
        if (r9 != null) goto L15;
        return null;
    L15:
        return r9.a();
    L12:
        r9 = null;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9193b;
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9192a;
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public int getType() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.j
    public int h() {
        return 301;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((((Long.hashCode(this.f9192a) * 31) + this.f9193b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31) + Long.hashCode(this.k)) * 31;
        String r1 = this.l;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.m;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.n;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.o;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return ((r10 + r2) * 31) + Long.hashCode(this.p);
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String i() {
        return this.l;
    }

    @Override // com.obric.memorydata.database.entity.d
    public boolean isValidateValue(String r4) {
        Intrinsics.checkNotNullParameter(r4, "columnsName");
        if (DeviceInfoState.INSTANCE.getSelfCollectionEntitySupport().a(301) == true) goto L19;
        if (Intrinsics.areEqual(r4, "ocr") == false) goto L12;
        if (e() == null) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (Intrinsics.areEqual(r4, "caption") == false) goto L19;
        if (d() == null) goto L17;
        return true;
    L17:
        return false;
    L19:
        return super.isValidateValue(r4);
    }

    public final String j() {
        return this.m;
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [T, java.util.List] */
    /* JADX WARN: Type inference failed for: r0v31, types: [T, java.util.List] */
    public final VideoFrame k() {
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        String r0 = this.l;
        List<String> r4 = null;
        if (r0 != null) goto L36;
    L17:
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        String r1 = this.m;
        if (r1 == null) goto L33;
        r4 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r1, new b().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L21 JsonSyntaxException -> L23
    L26:
        if (r4 == null) goto L33;
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getPhotoFaceRawDbDao().queryByEntityIdList(r4), Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r3.iterator();
    L29:
        if (r6.hasNext() == false) goto L31;
        AppEntity r8 = ((hc) ZeusTransformUtils.preCheckCast(r6.next(), hc.class, "com.obric.memorydata.plugin")).convertToAppEntity();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.PhotoFaceEntity");
        r5.add((PhotoFaceEntity) ZeusTransformUtils.preCheckCast(r8, PhotoFaceEntity.class, "com.obric.memorydata.plugin"));
        goto L29
    L31:
        r7.element = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        goto L33
    L23:
        e = e;
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder();
    L25:
        IRunLog.a.b(r9, "GsonExt", r10.append("toListObj error : ").append(e).toString(), null, 4, null);
    L21:
        e = e;
        r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r10 = new StringBuilder();
    L33:
        return new VideoFrame(a(), b(), c(), (List) ZeusTransformUtils.preCheckCast(r2.element, List.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.preCheckCast(r7.element, List.class, "com.obric.memorydata.plugin"), d(), e());
    L36:
        List<String> r11 = (List) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.u.a().fromJson(r0, new a().getType()), List.class, "com.obric.memorydata.plugin");     // Catch: JsonParseException -> L6 JsonSyntaxException -> L8
    L11:
        if (r11 == null) goto L17;
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getMetaTagRawDbDao().queryByEntityIdList(r11), Iterable.class, "com.obric.memorydata.plugin");
        Collection r13 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r14 = r12.iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        r13.add(((gs) ZeusTransformUtils.preCheckCast(r14.next(), gs.class, "com.obric.memorydata.plugin")).b());
        goto L14
    L16:
        r2.element = (List) ZeusTransformUtils.preCheckCast(r13, List.class, "com.obric.memorydata.plugin");
        goto L17
    L8:
        e = e;
        IRunLog r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r16 = new StringBuilder();
    L10:
        IRunLog.a.b(r15, "GsonExt", r16.append("toListObj error : ").append(e).toString(), null, 4, null);
        r11 = null;
    L6:
        e = e;
        r15 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r16 = new StringBuilder();
        goto L10
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9192a = r1;
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawVideoFrameEntity(id=").append(this.f9192a).append(", entityId=").append(this.f9193b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", startTime=").append(this.i).append(", endTime=").append(this.j).append(", frameTime=").append(this.k).append(", tags=");
        r0.append(this.l).append(", faces=").append(this.m).append(", caption=").append(this.n).append(", ocr=").append(this.o).append(", photoEntityDbId=").append(this.p).append(')');
        return r0.toString();
    }
}
