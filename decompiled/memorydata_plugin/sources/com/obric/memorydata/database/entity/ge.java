package com.obric.memorydata.database.entity;

import android.net.Uri;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.memorydata.database.dao.FileHistoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\b\u00104\u001a\u000205H\u0014J\u0018\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0016J\u0012\u0010:\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020<H\u0014J\b\u0010=\u001a\u00020>H\u0016J\n\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016J&\u0010E\u001a\u00020<2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00050G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020IH\u0014J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0005HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\tHÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\tHÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J½\u0001\u0010\\\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010]\u001a\u00020>2\b\u0010^\u001a\u0004\u0018\u00010_HÖ\u0003J\t\u0010`\u001a\u00020\tHÖ\u0001J\t\u0010a\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u0014\u0010\u000b\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0014\u0010\f\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR \u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001d\"\u0004\b,\u0010-R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010-R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010-R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001d\"\u0004\b3\u0010-¨\u0006b"}, d2 = {"Lcom/obric/memorydata/database/entity/RawFileEntity;", "Lcom/obric/memorydata/database/entity/AbstractRawFileDbEntity;", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", "fileName", "fileSize", "contentUrl", "fileType", "mimeType", "fullContent", "docNodeJson", Api.KEY_UUID, "resFiles", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "setTimestamp", "getPackageName", "getHashCodeValue", "getFileName", "getFileSize", "getContentUrl", "getFileType", "getMimeType", "getFullContent", "setFullContent", "(Ljava/lang/String;)V", "getDocNodeJson", "setDocNodeJson", "getUuid", "setUuid", "getResFiles", "setResFiles", "convertToAppEntityInternal", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "convertToTextVectorCopilotEntity", "Lcom/obric/memorydata/database/entity/AbstractVectorCopilotEntity;", "column", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "convertToImageVectorCopilotEntity", "onFirstIndex", "", "delete", "", "convertToRawHistoryEntity", "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "createFileTextEntity", "Lcom/obric/memorydata/database/entity/AbstractRawFileTextDbEntity;", "passageMaterial", "Lcom/obric/memorydata/database/util/file_utils/PassageGenerator$PassageMaterial;", "onUpdate", "updateColumns", "", "oldEntity", "Lcom/obric/memorydata/database/entity/AbstractRawDbEntity;", "newEntity", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ge extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f9149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9150b;
    private final long c;
    private final long d;
    private final int e;
    private long f;
    private final String g;
    private final int h;
    private final String i;
    private final long j;
    private final String k;
    private final String l;
    private final String m;
    private String n;
    private String o;
    private String p;
    private String q;

    public ge(long r17, String r19, long r20, long r22, int r24, long r25, String r27, int r28, String r29, long r30, String r32, String r33, String r34, String r35, String r36, String r37, String r38) {
        Intrinsics.checkNotNullParameter(r19, "entityId");
        Intrinsics.checkNotNullParameter(r27, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r29, "fileName");
        Intrinsics.checkNotNullParameter(r32, "contentUrl");
        Intrinsics.checkNotNullParameter(r33, "fileType");
        super(r17, r19, r20, r22, r24, r25, r27, r28, r37, r36);
        this.f9149a = r17;
        this.f9150b = r19;
        this.c = r20;
        this.d = r22;
        this.e = r24;
        this.f = r25;
        this.g = r27;
        this.h = r28;
        this.i = r29;
        this.j = r30;
        this.k = r32;
        this.l = r33;
        this.m = r34;
        this.n = r35;
        this.o = r36;
        this.p = r37;
        this.q = r38;
    }

    public /* synthetic */ ge(long r27, String r29, long r30, long r32, int r34, long r35, String r37, int r38, String r39, long r40, String r42, String r43, String r44, String r45, String r46, String r47, String r48, int r49, DefaultConstructorMarker r50) {
        if ((r49 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r49 & 32) == 0) goto L9;
        long r12 = System.currentTimeMillis();
    L11:
        if ((r49 & 8192) == 0) goto L13;
        String r22 = null;
    L15:
        if ((r49 & 16384) == 0) goto L17;
        String r23 = null;
    L19:
        if ((32768 & r49) == 0) goto L21;
        String r24 = UUID.randomUUID().toString();
    L23:
        if ((r49 & 65536) == 0) goto L25;
        String r25 = null;
    L26:
        this(r4, r29, r30, r32, r34, r12, r37, r38, r39, r40, r42, r43, r44, r22, r23, r24, r25);
        return;
    L25:
        r25 = r48;
        goto L26
    L21:
        r24 = r47;
        goto L23
    L17:
        r23 = r46;
        goto L19
    L13:
        r22 = r45;
        goto L15
    L9:
        r12 = r35;
        goto L11
    L5:
        r4 = r27;
        goto L7
    }

    @Override // com.obric.memorydata.database.entity.e
    public f a(com.obric.memorydata.database.util.file_utils.s.a r21) {
        Intrinsics.checkNotNullParameter(r21, "passageMaterial");
        long r8 = System.currentTimeMillis();
        return (f) ZeusTransformUtils.preCheckCast(new gg(0, gd.f9146a.a(), r8, r8, -308, 0, getPackageName(), getHashCodeValue(), getEntityId(), r21.a(), r21.b(), 33, null), f.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.e
    public String a() {
        return this.o;
    }

    @Override // com.obric.memorydata.database.entity.e
    public void a(String r1) {
        this.o = r1;
    }

    public final String c() {
        return this.i;
    }

    @Override // com.obric.memorydata.database.entity.d
    public AppEntity convertToAppEntityInternal() {
        String r1 = getEntityId();
        long r2 = getCreateTime();
        long r4 = getModifyTime();
        String r6 = this.i;
        long r7 = this.j;
        Uri r9 = Uri.parse(this.k);
        Intrinsics.checkNotNullExpressionValue(r9, "parse(...)");
        FileTypeEnum r0 = FileTypeEnum.Companion.from(this.l);
        if (r0 != null) goto L5;
        r0 = FileTypeEnum.FILE;
    L5:
        FileEntity r12 = new FileEntity(r1, r2, r4, r6, r7, r9, r0, this.m);
        r12.set_packageName(getPackageName());
        r12.setUuid(getUuid());
        List<String> r13 = b();
        if (r13 == null) goto L8;
        JSONObject r3 = new JSONObject();
        r3.put("relevantTextContent", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(r13, Collection.class, "com.obric.memorydata.plugin")));
        String r14 = r3.toString();
    L9:
        r12.setExtraData(r14);
        return (AppEntity) ZeusTransformUtils.preCheckCast(r12, AppEntity.class, "com.obric.memorydata.plugin");
    L8:
        r14 = null;
        goto L9
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToImageVectorCopilotEntity(String r1) {
        Intrinsics.checkNotNullParameter(r1, "column");
        return null;
    }

    @Override // com.obric.memorydata.database.entity.d
    public c convertToRawHistoryEntity() {
        return (c) ZeusTransformUtils.preCheckCast(new FileHistoryEntity(0, this, 1, null), c.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.database.entity.d
    public i convertToTextVectorCopilotEntity(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "column");
        Intrinsics.checkNotNullParameter(r12, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        return (i) ZeusTransformUtils.preCheckCast(new bv(0, getId(), r11, r12, 1, null), i.class, "com.obric.memorydata.plugin");
    }

    public final long d() {
        return this.j;
    }

    @Override // com.obric.memorydata.database.entity.d, com.obric.memorydata.database.a
    public boolean delete() {
        boolean r0 = super.delete();
        if (r0 == false) goto L5;
        gd.f9146a.a(getEntityId(), getType(), getPackageName(), null, CollectionsKt.emptyList());
    L5:
        return r0;
    }

    public final String e() {
        return this.k;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ge.class) == true) goto L8;
        return false;
    L8:
        ge r10 = (ge) ZeusTransformUtils.preCheckCast(r9, ge.class, "com.obric.memorydata.plugin");
        if (this.f9149a == r10.f9149a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9150b, r10.f9150b) == true) goto L15;
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
        if (this.j == r10.j) goto L39;
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
        if (Intrinsics.areEqual(this.q, r10.q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final String f() {
        return this.l;
    }

    public final String g() {
        return this.m;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getCreateTime() {
        return this.c;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public String getEntityId() {
        return this.f9150b;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public int getHashCodeValue() {
        return this.h;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getId() {
        return this.f9149a;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getModifyTime() {
        return this.d;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public String getPackageName() {
        return this.g;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public long getTimestamp() {
        return this.f;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public int getType() {
        return this.e;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public String getUuid() {
        return this.p;
    }

    public final String h() {
        return this.n;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((((((Long.hashCode(this.f9149a) * 31) + this.f9150b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + Long.hashCode(this.j)) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31;
        String r1 = this.m;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.n;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.o;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.p;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.q;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
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

    @Override // com.obric.memorydata.database.entity.d
    public void onFirstIndex() {
        super.onFirstIndex();
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(this.q, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        gd.f9146a.a((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.memorydata.plugin"), "resFiles", this.q);
        return;
    L12:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.memorydata.database.entity.d
    public void onUpdate(Set<String> r6, d r7, d r8) {
        Set<String> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "updateColumns");
        Intrinsics.checkNotNullParameter(r7, "oldEntity");
        Intrinsics.checkNotNullParameter(r8, "newEntity");
        super.onUpdate(r9, r7, r8);
        ge r10 = (ge) ZeusTransformUtils.preCheckCast(r7, ge.class, "com.obric.memorydata.plugin");
        ge r11 = (ge) ZeusTransformUtils.preCheckCast(r8, ge.class, "com.obric.memorydata.plugin");
        if (r9.contains("fileName") == false) goto L5;
    L8:
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getFileTextRawDbDao().queryByParentEntityId(getEntityId()), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        ((gg) ZeusTransformUtils.preCheckCast(r5.next(), gg.class, "com.obric.memorydata.plugin")).delete();
        goto L10
    L12:
        r9.add("contentUrl");
        return;
    L5:
        if (r10.getModifyTime() != r11.getModifyTime()) goto L8;
        if (r10.j != r11.j) goto L8;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public void setId(long r1) {
        this.f9149a = r1;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public void setTimestamp(long r1) {
        this.f = r1;
    }

    @Override // com.obric.memorydata.database.entity.e, com.obric.memorydata.database.entity.d
    public void setUuid(String r1) {
        this.p = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawFileEntity(id=").append(this.f9149a).append(", entityId=").append(this.f9150b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", fileName=").append(this.i).append(", fileSize=").append(this.j).append(", contentUrl=").append(this.k).append(", fileType=");
        r0.append(this.l).append(", mimeType=").append(this.m).append(", fullContent=").append(this.n).append(", docNodeJson=").append(this.o).append(", uuid=").append(this.p).append(", resFiles=").append(this.q).append(')');
        return r0.toString();
    }
}
