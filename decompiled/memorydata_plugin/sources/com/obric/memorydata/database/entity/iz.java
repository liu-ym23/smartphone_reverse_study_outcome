package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b@\b\u0087\b\u0018\u00002\u00020\u0001BÛ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\tHÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\tHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0005HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0015HÆ\u0003J\t\u0010M\u001a\u00020\tHÆ\u0003J\t\u0010N\u001a\u00020\tHÆ\u0003J\t\u0010O\u001a\u00020\u0015HÆ\u0003J\t\u0010P\u001a\u00020\u001aHÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0015HÆ\u0003J\t\u0010S\u001a\u00020\tHÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003Jû\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00152\b\b\u0002\u0010\u001d\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u0003HÆ\u0001J\u0013\u0010V\u001a\u00020\u00152\b\u0010W\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010X\u001a\u00020\tHÖ\u0001J\t\u0010Y\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u0016\u0010\u0017\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0016\u0010\u0018\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00104R\u0016\u0010\u0019\u001a\u00020\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0016\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0016\u0010\u001c\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u00104R\u0016\u0010\u001d\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0016\u0010\u001e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"¨\u0006Z"}, d2 = {"Lcom/obric/memorydata/database/entity/UpdateUnionSemanticMemoryEntity;", "", OaidModel.KEY_ID, "", "entityId", "", "createTime", "modifyTime", "type", "", "timestamp", ObricMemoryConstants.KEY_PACKAGE_NAME, "hashCodeValue", Api.KEY_UUID, "semanticType", "tagPath", "keyPhrase", "description", "embeddingContent", "sources", "userEdit", "", "evidenceCount", "productType", "useForInsight", "confidence", "", "updateResult", "isUpdated", "retryTime", "lastExecuteUpdateTimestamp", "<init>", "(JLjava/lang/String;JJIJLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIIZFLjava/lang/String;ZIJ)V", "getId", "()J", "getEntityId", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getType", "()I", "getTimestamp", "getPackageName", "getHashCodeValue", "getUuid", "getSemanticType", "getTagPath", "getKeyPhrase", "getDescription", "getEmbeddingContent", "getSources", "getUserEdit", "()Z", "getEvidenceCount", "getProductType", "getUseForInsight", "getConfidence", "()F", "getUpdateResult", "getRetryTime", "getLastExecuteUpdateTimestamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class iz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9250b;
    private final long c;
    private final long d;
    private final int e;
    private final long f;
    private final String g;
    private final int h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final String o;
    private final boolean p;
    private final int q;
    private final int r;
    private final boolean s;
    private final float t;
    private final String u;
    private final boolean v;
    private final int w;
    private final long x;

    public iz(long r13, String r15, long r16, long r18, int r20, long r21, String r23, int r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, boolean r32, int r33, int r34, boolean r35, float r36, String r37, boolean r38, int r39, long r40) {
        Intrinsics.checkNotNullParameter(r15, "entityId");
        Intrinsics.checkNotNullParameter(r23, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r26, "semanticType");
        Intrinsics.checkNotNullParameter(r27, "tagPath");
        Intrinsics.checkNotNullParameter(r28, "keyPhrase");
        Intrinsics.checkNotNullParameter(r29, "description");
        Intrinsics.checkNotNullParameter(r30, "embeddingContent");
        Intrinsics.checkNotNullParameter(r31, "sources");
        Intrinsics.checkNotNullParameter(r37, "updateResult");
        this.f9249a = r13;
        this.f9250b = r15;
        this.c = r16;
        this.d = r18;
        this.e = r20;
        this.f = r21;
        this.g = r23;
        this.h = r24;
        this.i = r25;
        this.j = r26;
        this.k = r27;
        this.l = r28;
        this.m = r29;
        this.n = r30;
        this.o = r31;
        this.p = r32;
        this.q = r33;
        this.r = r34;
        this.s = r35;
        this.t = r36;
        this.u = r37;
        this.v = r38;
        this.w = r39;
        this.x = r40;
    }

    public /* synthetic */ iz(long r35, String r37, long r38, long r40, int r42, long r43, String r45, int r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, boolean r54, int r55, int r56, boolean r57, float r58, String r59, boolean r60, int r61, long r62, int r64, DefaultConstructorMarker r65) {
        if ((r64 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r64 & 32) == 0) goto L9;
        long r13 = System.currentTimeMillis();
    L11:
        if ((r64 & 256) == 0) goto L13;
        String r17 = UUID.randomUUID().toString();
    L15:
        if ((262144 & r64) == 0) goto L17;
        boolean r27 = false;
    L19:
        if ((524288 & r64) == 0) goto L21;
        float r28 = 0.0f;
    L23:
        if ((1048576 & r64) == 0) goto L25;
        String r29 = "";
    L27:
        if ((2097152 & r64) == 0) goto L29;
        boolean r30 = false;
    L31:
        if ((4194304 & r64) == 0) goto L33;
        int r31 = 0;
    L35:
        if ((r64 & 8388608) == 0) goto L37;
        long r32 = 0;
    L38:
        this(r5, r37, r38, r40, r42, r13, r45, r46, r17, r48, r49, r50, r51, r52, r53, r54, r55, r56, r27, r28, r29, r30, r31, r32);
        return;
    L37:
        r32 = r62;
        goto L38
    L33:
        r31 = r61;
        goto L35
    L29:
        r30 = r60;
        goto L31
    L25:
        r29 = r59;
        goto L27
    L21:
        r28 = r58;
        goto L23
    L17:
        r27 = r57;
        goto L19
    L13:
        r17 = r47;
        goto L15
    L9:
        r13 = r43;
        goto L11
    L5:
        r5 = r35;
        goto L7
    }

    public static /* synthetic */ iz a(iz r17, long r18, String r20, long r21, long r23, int r25, long r26, String r28, int r29, String r30, String r31, String r32, String r33, String r34, String r35, String r36, boolean r37, int r38, int r39, boolean r40, float r41, String r42, boolean r43, int r44, long r45, int r47, Object r48) {
        if ((r47 & 1) == 0) goto L5;
        long r2 = r17.f9249a;
    L7:
        if ((r47 & 2) == 0) goto L9;
        String r4 = r17.f9250b;
    L11:
        if ((r47 & 4) == 0) goto L13;
        long r5 = r17.c;
    L15:
        if ((r47 & 8) == 0) goto L17;
        long r7 = r17.d;
    L19:
        if ((r47 & 16) == 0) goto L21;
        int r9 = r17.e;
    L23:
        if ((r47 & 32) == 0) goto L25;
        long r10 = r17.f;
    L27:
        if ((r47 & 64) == 0) goto L29;
        String r12 = r17.g;
    L31:
        if ((r47 & 128) == 0) goto L33;
        int r13 = r17.h;
    L35:
        if ((r47 & 256) == 0) goto L37;
        String r14 = r17.i;
    L39:
        if ((r47 & 512) == 0) goto L41;
        String r15 = r17.j;
    L42:
        String r310 = r15;
        if ((r47 & 1024) == 0) goto L45;
        String r16 = r17.k;
    L46:
        String r311 = r16;
        if ((r47 & 2048) == 0) goto L49;
        String r19 = r17.l;
    L50:
        String r312 = r19;
        if ((r47 & 4096) == 0) goto L53;
        String r110 = r17.m;
    L54:
        String r313 = r110;
        if ((r47 & 8192) == 0) goto L57;
        String r111 = r17.n;
    L58:
        String r314 = r111;
        if ((r47 & 16384) == 0) goto L61;
        String r112 = r17.o;
    L62:
        String r315 = r112;
        if ((r47 & 32768) == 0) goto L65;
        boolean r113 = r17.p;
    L66:
        boolean r316 = r113;
        if ((r47 & 65536) == 0) goto L69;
        int r114 = r17.q;
    L70:
        int r317 = r114;
        if ((r47 & 131072) == 0) goto L73;
        int r115 = r17.r;
    L74:
        int r318 = r115;
        if ((r47 & 262144) == 0) goto L77;
        boolean r116 = r17.s;
    L78:
        boolean r46 = r116;
        if ((r47 & 524288) == 0) goto L81;
        float r117 = r17.t;
    L82:
        float r49 = r117;
        if ((r47 & 1048576) == 0) goto L85;
        String r118 = r17.u;
    L86:
        String r410 = r118;
        if ((r47 & 2097152) == 0) goto L89;
        boolean r119 = r17.v;
    L90:
        boolean r411 = r119;
        if ((r47 & 4194304) == 0) goto L93;
        int r120 = r17.w;
    L94:
        String r319 = r14;
        int r412 = r120;
        if ((r47 & 8388608) == 0) goto L97;
        long r121 = r17.x;
    L99:
        return r17.a(r2, r4, r5, r7, r9, r10, r12, r13, r319, r310, r311, r312, r313, r314, r315, r316, r317, r318, r46, r49, r410, r411, r412, r121);
    L97:
        r121 = r45;
        goto L99
    L93:
        r120 = r44;
        goto L94
    L89:
        r119 = r43;
        goto L90
    L85:
        r118 = r42;
        goto L86
    L81:
        r117 = r41;
        goto L82
    L77:
        r116 = r40;
        goto L78
    L73:
        r115 = r39;
        goto L74
    L69:
        r114 = r38;
        goto L70
    L65:
        r113 = r37;
        goto L66
    L61:
        r112 = r36;
        goto L62
    L57:
        r111 = r35;
        goto L58
    L53:
        r110 = r34;
        goto L54
    L49:
        r19 = r33;
        goto L50
    L45:
        r16 = r32;
        goto L46
    L41:
        r15 = r31;
        goto L42
    L37:
        r14 = r30;
        goto L39
    L33:
        r13 = r29;
        goto L35
    L29:
        r12 = r28;
        goto L31
    L25:
        r10 = r26;
        goto L27
    L21:
        r9 = r25;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final long a() {
        return this.f9249a;
    }

    public final iz a(long r32, String r34, long r35, long r37, int r39, long r40, String r42, int r43, String r44, String r45, String r46, String r47, String r48, String r49, String r50, boolean r51, int r52, int r53, boolean r54, float r55, String r56, boolean r57, int r58, long r59) {
        Intrinsics.checkNotNullParameter(r34, "entityId");
        Intrinsics.checkNotNullParameter(r42, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r45, "semanticType");
        Intrinsics.checkNotNullParameter(r46, "tagPath");
        Intrinsics.checkNotNullParameter(r47, "keyPhrase");
        Intrinsics.checkNotNullParameter(r48, "description");
        Intrinsics.checkNotNullParameter(r49, "embeddingContent");
        Intrinsics.checkNotNullParameter(r50, "sources");
        Intrinsics.checkNotNullParameter(r56, "updateResult");
        return new iz(r32, r34, r35, r37, r39, r40, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59);
    }

    public final String b() {
        return this.f9250b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    public final long e() {
        return this.f;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, iz.class) == true) goto L8;
        return false;
    L8:
        iz r10 = (iz) ZeusTransformUtils.preCheckCast(r9, iz.class, "com.obric.memorydata.plugin");
        if (this.f9249a == r10.f9249a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f9250b, r10.f9250b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.n, r10.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r10.p) goto L57;
        return false;
    L57:
        if (this.q == r10.q) goto L60;
        return false;
    L60:
        if (this.r == r10.r) goto L63;
        return false;
    L63:
        if (this.s == r10.s) goto L66;
        return false;
    L66:
        if (Float.compare(this.t, r10.t) == 0) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r10.u) == true) goto L72;
        return false;
    L72:
        if (this.v == r10.v) goto L75;
        return false;
    L75:
        if (this.w == r10.w) goto L78;
        return false;
    L78:
        if (this.x == r10.x) goto L80;
        return false;
    L80:
        return true;
    }

    public final String f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final int getType() {
        return this.e;
    }

    public final String h() {
        return this.i;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.f9249a) * 31) + this.f9250b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Long.hashCode(this.f)) * 31) + this.g.hashCode()) * 31) + Integer.hashCode(this.h)) * 31;
        String r1 = this.i;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((((((((((((((((((((((r0 + r2) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + Boolean.hashCode(this.p)) * 31) + Integer.hashCode(this.q)) * 31) + Integer.hashCode(this.r)) * 31) + Boolean.hashCode(this.s)) * 31) + Float.hashCode(this.t)) * 31) + this.u.hashCode()) * 31) + Boolean.hashCode(this.v)) * 31) + Integer.hashCode(this.w)) * 31) + Long.hashCode(this.x);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String i() {
        return this.j;
    }

    public final String j() {
        return this.k;
    }

    public final String k() {
        return this.l;
    }

    public final String l() {
        return this.m;
    }

    public final String m() {
        return this.n;
    }

    public final String n() {
        return this.o;
    }

    public final boolean o() {
        return this.p;
    }

    public final int p() {
        return this.q;
    }

    public final int q() {
        return this.r;
    }

    public final boolean r() {
        return this.s;
    }

    public final float s() {
        return this.t;
    }

    public final String t() {
        return this.u;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("UpdateUnionSemanticMemoryEntity(id=").append(this.f9249a).append(", entityId=").append(this.f9250b).append(", createTime=").append(this.c).append(", modifyTime=").append(this.d).append(", type=").append(this.e).append(", timestamp=").append(this.f).append(", packageName=").append(this.g).append(", hashCodeValue=").append(this.h).append(", uuid=").append(this.i).append(", semanticType=").append(this.j).append(", tagPath=").append(this.k).append(", keyPhrase=");
        r0.append(this.l).append(", description=").append(this.m).append(", embeddingContent=").append(this.n).append(", sources=").append(this.o).append(", userEdit=").append(this.p).append(", evidenceCount=").append(this.q).append(", productType=").append(this.r).append(", useForInsight=").append(this.s).append(", confidence=").append(this.t).append(", updateResult=").append(this.u).append(", isUpdated=").append(this.v).append(", retryTime=").append(this.w);
        r0.append(", lastExecuteUpdateTimestamp=").append(this.x).append(')');
        return r0.toString();
    }

    public final boolean u() {
        return this.v;
    }

    public final int v() {
        return this.w;
    }

    public final long w() {
        return this.x;
    }
}
