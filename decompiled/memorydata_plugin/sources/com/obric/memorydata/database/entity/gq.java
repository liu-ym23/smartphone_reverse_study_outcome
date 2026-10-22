package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.cae.libs.nfc.CaeNfcCardInfo;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\n\u00107\u001a\u0004\u0018\u000108H\u0014J\u0018\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0016J\u0012\u0010=\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020\u0005H\u0016J\u0006\u0010>\u001a\u00020?J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\tHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0018HÆ\u0003J\t\u0010S\u001a\u00020\u0018HÆ\u0003Jã\u0001\u0010T\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0018HÆ\u0001J\u0013\u0010U\u001a\u00020?2\b\u0010V\u001a\u0004\u0018\u00010WHÖ\u0003J\t\u0010X\u001a\u00020\tHÖ\u0001J\t\u0010Y\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010!R\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\r\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010!R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010!R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010!R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010!R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b6\u00105¨\u0006Z"}, d2 = {"Lcom/obric/memorydata/database/entity/RawMetaLocationEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", "sourceType", "country", "stateOrProvince", "administrativeArea", "locality", "subLocality", "thoroughfare", "subThoroughfare", "namedLocation", "fullAddress", "longitude", "", "latitude", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DD)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getSourceType", "getCountry", "getStateOrProvince", "getAdministrativeArea", "getLocality", "getSubLocality", "getThoroughfare", "getSubThoroughfare", "getNamedLocation", "getFullAddress", "getLongitude", "()D", "getLatitude", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "isInvalidateData", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class gq extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9162b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private final int i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final String q;
    private final String r;
    private final double s;
    private final double t;

    /* JADX WARN: Multi-variable type inference failed */
    public gq(long r20, String r22, long r23, long r25, int r27, long r28, String r30, int r31, int r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, double r42, double r44) {
        Intrinsics.checkNotNullParameter(r22, "entityId");
        Intrinsics.checkNotNullParameter(r30, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Object[] r15 = 0 == true ? 1 : 0;
        Object[] r16 = 0 == true ? 1 : 0;
        super(r20, r22, r23, r25, r27, r28, r30, r31, null, r15, r16, null, CaeNfcCardInfo.LIFE_CYCLE_INACTIVE, null);
        this.f9161a = r20;
        this.f9162b = r22;
        this.c = r23;
        this.d = r25;
        this.e = r27;
        this.f = r28;
        this.g = r30;
        this.h = r31;
        this.i = r32;
        this.j = r33;
        this.k = r34;
        this.l = r35;
        this.m = r36;
        this.n = r37;
        this.o = r38;
        this.p = r39;
        this.q = r40;
        this.r = r41;
        this.s = r42;
        this.t = r44;
    }

    public /* synthetic */ gq(long r30, String r32, long r33, long r35, int r37, long r38, String r40, int r41, int r42, String r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, String r51, double r52, double r54, int r56, DefaultConstructorMarker r57) {
        if ((r56 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r56 & 32) == 0) goto L9;
        long r11 = System.currentTimeMillis();
    L11:
        if ((r56 & 262144) == 0) goto L13;
        double r25 = 0.0d;
    L15:
        if ((r56 & 524288) == 0) goto L17;
        double r27 = 0.0d;
    L18:
        this(r3, r32, r33, r35, r37, r11, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r25, r27);
        return;
    L17:
        r27 = r54;
        goto L18
    L13:
        r25 = r52;
        goto L15
    L9:
        r11 = r38;
        goto L11
    L5:
        r3 = r30;
        goto L7
    }

    public final int a() {
        return this.i;
    }

    public final String b() {
        return this.j;
    }

    public final String c() {
        return this.k;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new dm(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final String d() {
        return this.l;
    }

    public final String e() {
        return this.m;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, gq.class) == true) goto L8;
        return false;
    L8:
        gq r10 = (gq) ZeusTransformUtils.preCheckCast(r9, gq.class, "com.obric.memorydata.plugin");
        if (this.f9161a == r10.f9161a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9162b, r10.f9162b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L42;
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
        if (Intrinsics.areEqual(this.p, r10.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r10.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r10.r) == true) goto L63;
        return false;
    L63:
        if (Double.compare(this.s, r10.s) == 0) goto L66;
        return false;
    L66:
        if (Double.compare(this.t, r10.t) == 0) goto L68;
        return false;
    L68:
        return true;
    }

    public final String f() {
        return this.n;
    }

    public final String g() {
        return this.o;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9162b;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9161a;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.d
    public int getType() {
        return this.e;
    }

    public final String h() {
        return this.p;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((Long.hashCode(this.f9161a) * 31) + this.f9162b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + Integer.hashCode(this.i)) * 31;
        String r1 = this.j;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.k;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.l;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.m;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.n;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.o;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.p;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r19 + r21) * 31;
        String r23 = this.q;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.r;
        if (r26 == null) goto L39;
        r2 = r26.hashCode();
    L39:
        return ((((r25 + r2) * 31) + Double.hashCode(this.s)) * 31) + Double.hashCode(this.t);
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
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
        return this.q;
    }

    public final String j() {
        return this.r;
    }

    public final double k() {
        return this.s;
    }

    public final double l() {
        return this.t;
    }

    public final boolean m() {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.j, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L80;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(this.k, CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L13;
    L16:
        boolean r3 = true;
    L17:
        if (r3 == false) goto L81;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(this.l, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == false) goto L82;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(this.m, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L29;
    L32:
        boolean r7 = true;
    L33:
        if (r7 == false) goto L83;
        CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(this.n, CharSequence.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L37;
    L40:
        boolean r9 = true;
    L41:
        if (r9 == false) goto L84;
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(this.o, CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L45;
    L48:
        boolean r11 = true;
    L49:
        if (r11 == false) goto L85;
        CharSequence r12 = (CharSequence) ZeusTransformUtils.preCheckCast(this.p, CharSequence.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L53;
    L56:
        boolean r13 = true;
    L57:
        if (r13 == false) goto L86;
        CharSequence r14 = (CharSequence) ZeusTransformUtils.preCheckCast(this.q, CharSequence.class, "com.obric.memorydata.plugin");
        if (r14 != null) goto L61;
    L64:
        boolean r15 = true;
    L65:
        if (r15 == false) goto L87;
        CharSequence r16 = (CharSequence) ZeusTransformUtils.preCheckCast(this.r, CharSequence.class, "com.obric.memorydata.plugin");
        if (r16 != null) goto L69;
    L72:
        boolean r17 = true;
    L73:
        if (r17 == true) goto L75;
        return false;
    L75:
        if (com.obric.memorydata.utils.i.f13228a.a(this.s) == true) goto L77;
        return false;
    L77:
        if (com.obric.memorydata.utils.i.f13228a.a(this.t) == true) goto L79;
        return false;
    L79:
        return true;
    L69:
        if (r16.length() == 0) goto L72;
        r17 = false;
        goto L73
    L87:
        return false;
    L61:
        if (r14.length() == 0) goto L64;
        r15 = false;
        goto L65
    L86:
        return false;
    L53:
        if (r12.length() == 0) goto L56;
        r13 = false;
        goto L57
    L85:
        return false;
    L45:
        if (r10.length() == 0) goto L48;
        r11 = false;
        goto L49
    L84:
        return false;
    L37:
        if (r8.length() == 0) goto L40;
        r9 = false;
        goto L41
    L83:
        return false;
    L29:
        if (r6.length() == 0) goto L32;
        r7 = false;
        goto L33
    L82:
        return false;
    L21:
        if (r4.length() == 0) goto L24;
        r5 = false;
        goto L25
    L81:
        return false;
    L13:
        if (r2.length() == 0) goto L16;
        r3 = false;
        goto L17
    L80:
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9161a = r1;
    }

    @Override // com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawMetaLocationEntity(id=").append(this.f9161a).append(", entityId=").append(this.f9162b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", sourceType=").append(this.i).append(", country=").append(this.j).append(", stateOrProvince=").append(this.k).append(", administrativeArea=");
        r0.append(this.l).append(", locality=").append(this.m).append(", subLocality=").append(this.n).append(", thoroughfare=").append(this.o).append(", subThoroughfare=").append(this.p).append(", namedLocation=").append(this.q).append(", fullAddress=").append(this.r).append(", longitude=").append(this.s).append(", latitude=").append(this.t).append(')');
        return r0.toString();
    }
}
