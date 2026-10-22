package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\n\u00101\u001a\u0004\u0018\u000102H\u0014J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u0005H\u0016J\u0012\u00107\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u000209H\u0016J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\tHÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\tHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J¯\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0005HÆ\u0001J\u0013\u0010K\u001a\u0002092\b\u0010L\u001a\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001a\u00020\tHÖ\u0001J\t\u0010O\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010'R\u0016\u0010\u000e\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0014\u0010\u000f\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010'R \u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010'R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001c¨\u0006P"}, d2 = {"Lcom/obric/memorydata/database/entity/RawCommonPhotoEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawPhotoEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "file", "assetType", "caption", "ocr", "rawDbType", "rawEntityId", "rawDbColumn", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "setUuid", "(Ljava/lang/String;)V", "getFile", "getAssetType", "getCaption", "setCaption", "getOcr", "setOcr", "getRawDbType", "getRawEntityId", "getRawDbColumn", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "delete", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ft extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9135b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private String i;
    private final String j;
    private final String k;
    private String l;
    private String m;
    private final int n;
    private final String o;
    private final String p;

    public ft(long r27, String r29, long r30, long r32, int r34, long r35, String r37, int r38, String r39, String r40, String r41, String r42, String r43, int r44, String r45, String r46) {
        Intrinsics.checkNotNullParameter(r29, "entityId");
        Intrinsics.checkNotNullParameter(r37, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r40, "file");
        Intrinsics.checkNotNullParameter(r41, "assetType");
        Intrinsics.checkNotNullParameter(r45, "rawEntityId");
        Intrinsics.checkNotNullParameter(r46, "rawDbColumn");
        super(r27, r29, r30, r32, r34, r35, r37, r38, r40, r41, r42, r43, r39);
        this.f9134a = r27;
        this.f9135b = r29;
        this.c = r30;
        this.d = r32;
        this.e = r34;
        this.f = r35;
        this.g = r37;
        this.h = r38;
        this.i = r39;
        this.j = r40;
        this.k = r41;
        this.l = r42;
        this.m = r43;
        this.n = r44;
        this.o = r45;
        this.p = r46;
    }

    public /* synthetic */ ft(long r25, String r27, long r28, long r30, int r32, long r33, String r35, int r36, String r37, String r38, String r39, String r40, String r41, int r42, String r43, String r44, int r45, DefaultConstructorMarker r46) {
        if ((r45 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r45 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r45 & 256) == 0) goto L13;
        String r16 = UUID.randomUUID().toString();
    L14:
        this(r4, r27, r28, r30, r32, r12, r35, r36, r16, r38, r39, r40, r41, r42, r43, r44);
        return;
    L13:
        r16 = r37;
        goto L14
    L9:
        r12 = r33;
        goto L11
    L5:
        r4 = r25;
        goto L7
    }

    private static final Object a(ft r1) {
        String r2 = com.obric.memorydata.personalcontext.util.f.b(r1.a()).getContentUrl().getPath();
        if (r2 == null) goto L5;
        File r0 = new File(r2);
        if (r0.exists() == false) goto L10;
        return Boolean.valueOf(r0.delete());
    L10:
        return Unit.INSTANCE;
    L5:
        return true;
    }

    private static final Unit a(ft r3, Exception r4) {
        Intrinsics.checkNotNullParameter(r4, "e");
        RunLog.INSTANCE.error(d.TAG, "Failed to delete file for entityId=" + r3.getEntityId() + ", file=" + r3.a(), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object lambda$BDrdx636CU_snuY2qdKk0ehXuwU(ft r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$pKfKkQus36YqI-DAi8WrEmGOb0Q, reason: not valid java name */
    public static /* synthetic */ Unit m550lambda$pKfKkQus36YqIDAi8WrEmGOb0Q(ft r0, Exception r1) {
        return a(r0, r1);
    }

    @Override // com.obric.memorydata.database.entity.g
    public String a() {
        return this.j;
    }

    @Override // com.obric.memorydata.database.entity.g
    public void a(String r1) {
        this.l = r1;
    }

    @Override // com.obric.memorydata.database.entity.g
    public String b() {
        return this.k;
    }

    @Override // com.obric.memorydata.database.entity.g
    public void b(String r1) {
        this.m = r1;
    }

    @Override // com.obric.memorydata.database.entity.g
    public String c() {
        return this.l;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r10) {
        Intrinsics.checkNotNullParameter(r10, "column");
        return (i) ZeusTransformUtils.preCheckCast(new am(0, getId(), r10, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new an(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.g
    public String d() {
        return this.m;
    }

    @Override // com.obric.memorydata.database.entity.d, com.obric.memorydata.database.a
    public boolean delete() {
        if (super.delete() == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(b(), "VIDEO") == false) goto L13;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getCommonVideoFrameRawDbDao().queryByPhotoEntityDbId(getId()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r0.hasNext() == false) goto L13;
        ((fv) ZeusTransformUtils.preCheckCast(r0.next(), fv.class, "com.obric.memorydata.plugin")).delete();
    L13:
        if (this.n != 801) goto L18;
        com.obric.memorydata.utils.y.a(new $$Lambda$ft$pKfKkQus36YqIDAi8WrEmGOb0Q(this), new $$Lambda$ft$BDrdx636CU_snuY2qdKk0ehXuwU(this));
        return true;
    L18:
        return true;
    }

    public final int e() {
        return this.n;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ft.class) == true) goto L8;
        return false;
    L8:
        ft r10 = (ft) ZeusTransformUtils.preCheckCast(r9, ft.class, "com.obric.memorydata.plugin");
        if (this.f9134a == r10.f9134a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9135b, r10.f9135b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
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
        if (this.n == r10.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r10.p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final String f() {
        return this.o;
    }

    public final String g() {
        return this.p;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9135b;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9134a;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public int getType() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.i;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.f9134a) * 31) + this.f9135b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31;
        String r1 = this.i;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((r0 + r3) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31;
        String r5 = this.l;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.m;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((((r7 + r2) * 31) + Integer.hashCode(this.n)) * 31) + this.o.hashCode()) * 31) + this.p.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9134a = r1;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    @Override // com.obric.memorydata.database.entity.g, com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.i = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawCommonPhotoEntity(id=").append(this.f9134a).append(", entityId=").append(this.f9135b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", uuid=").append(this.i).append(", file=").append(this.j).append(", assetType=").append(this.k).append(", caption=");
        r0.append(this.l).append(", ocr=").append(this.m).append(", rawDbType=").append(this.n).append(", rawEntityId=").append(this.o).append(", rawDbColumn=").append(this.p).append(')');
        return r0.toString();
    }
}
