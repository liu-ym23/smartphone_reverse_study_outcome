package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.dao.IAppEntityRawDbDao;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\n\u00100\u001a\u0004\u0018\u000101H\u0014J\u0018\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0005H\u0016J\u0012\u00106\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u0005H\u0016J\n\u00107\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00108\u001a\u00020\tH\u0016J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\tHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\tHÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u0099\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010KHÖ\u0003J\t\u0010L\u001a\u00020\tHÖ\u0001J\t\u0010M\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u001a\u0010\r\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\u000e\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010+R \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001a\"\u0004\b-\u0010+R\u001e\u0010\u0012\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010\u0018¨\u0006N"}, d2 = {"Lcom/obric/memorydata/database/entity/RawCommonVideoFrameEntity;", "Lcom/obric/memorydata/database/entity/AbstractVideoFrameEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", "startTime", "endTime", "frameTime", "caption", "ocr", "photoEntityDbId", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;IJJJLjava/lang/String;Ljava/lang/String;J)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getStartTime", "setStartTime", "getEndTime", "setEndTime", "getFrameTime", "setFrameTime", "getCaption", "setCaption", "(Ljava/lang/String;)V", "getOcr", "setOcr", "getPhotoEntityDbId", "setPhotoEntityDbId", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "getFileEntityJson", "getPhotoEntityType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class fv extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9137b;
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
    private long n;

    public fv(long r6, String r8, long r9, long r11, int r13, long r14, String r16, int r17, long r18, long r20, long r22, String r24, String r25, long r26) {
        Intrinsics.checkNotNullParameter(r8, "entityId");
        Intrinsics.checkNotNullParameter(r16, ObricMemoryConstants.KEY_PACKAGE_NAME);
        super(r6, r8, r9, r11, r13, r14, r16, r17, r18, r20, r22, r24, r25, r26);
        this.f9136a = r6;
        this.f9137b = r8;
        this.c = r9;
        this.d = r11;
        this.e = r13;
        this.f = r14;
        this.g = r16;
        this.h = r17;
        this.i = r18;
        this.j = r20;
        this.k = r22;
        this.l = r24;
        this.m = r25;
        this.n = r26;
    }

    public /* synthetic */ fv(long r27, String r29, long r30, long r32, int r34, long r35, String r37, int r38, long r39, long r41, long r43, String r45, String r46, long r47, int r49, DefaultConstructorMarker r50) {
        if ((r49 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r49 & 2048) == 0) goto L9;
        String r22 = null;
    L11:
        if ((r49 & 4096) == 0) goto L13;
        String r23 = null;
    L14:
        this(r4, r29, r30, r32, r34, r35, r37, r38, r39, r41, r43, r22, r23, r47);
        return;
    L13:
        r23 = r46;
        goto L14
    L9:
        r22 = r45;
        goto L11
    L5:
        r4 = r27;
        goto L7
    }

    @Override // com.obric.memorydata.database.entity.j
    public long a() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.j
    public void a(String r1) {
        this.l = r1;
    }

    @Override // com.obric.memorydata.database.entity.j
    public long b() {
        return this.j;
    }

    @Override // com.obric.memorydata.database.entity.j
    public void b(String r1) {
        this.m = r1;
    }

    @Override // com.obric.memorydata.database.entity.j
    public long c() {
        return this.k;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r10) {
        Intrinsics.checkNotNullParameter(r10, "column");
        return (i) ZeusTransformUtils.preCheckCast(new ao(0, getId(), r10, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new ap(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.j
    public String d() {
        return this.l;
    }

    @Override // com.obric.memorydata.database.entity.j
    public String e() {
        return this.m;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, fv.class) == true) goto L8;
        return false;
    L8:
        fv r10 = (fv) ZeusTransformUtils.preCheckCast(r9, fv.class, "com.obric.memorydata.plugin");
        if (this.f9136a == r10.f9136a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9137b, r10.f9137b) == true) goto L15;
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
        if (this.n == r10.n) goto L50;
        return false;
    L50:
        return true;
    }

    @Override // com.obric.memorydata.database.entity.j
    public long f() {
        return this.n;
    }

    @Override // com.obric.memorydata.database.entity.j
    public String g() {
        IAppEntityRawDbDao<d> r0 = com.obric.memorydata.database.index.s.a().getRawDaoByEntityType(NetError.ERR_UNSAFE_REDIRECT);
        if (r0 == null) goto L5;
        d r1 = (d) ZeusTransformUtils.preCheckCast(r0.queryById(f()), d.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L10;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), d.TAG, "getVideoFrameFileEntityJson (id: " + f() + ") is null", null, 4, null);
        return null;
    L10:
        if (ZeusTransformUtils.instanceOf(r1, ft.class) == false) goto L12;
        ft r9 = (ft) ZeusTransformUtils.preCheckCast(r1, ft.class, "com.obric.memorydata.plugin");
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
        return this.f9137b;
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9136a;
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
        return NetError.ERR_UNSAFE_REDIRECT;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((((Long.hashCode(this.f9136a) * 31) + this.f9137b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + Long.hashCode(this.j)) * 31) + Long.hashCode(this.k)) * 31;
        String r1 = this.l;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.m;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return ((r4 + r2) * 31) + Long.hashCode(this.n);
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9136a = r1;
    }

    @Override // com.obric.memorydata.database.entity.j, com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawCommonVideoFrameEntity(id=").append(this.f9136a).append(", entityId=").append(this.f9137b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", startTime=").append(this.i).append(", endTime=").append(this.j).append(", frameTime=").append(this.k).append(", caption=");
        r0.append(this.l).append(", ocr=").append(this.m).append(", photoEntityDbId=").append(this.n).append(')');
        return r0.toString();
    }
}
