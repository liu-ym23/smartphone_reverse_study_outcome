package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bb\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bé\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\bHÆ\u0003J\t\u0010V\u001a\u00020\bHÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\bHÆ\u0003J\t\u0010Z\u001a\u00020\bHÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00106J\t\u0010\\\u001a\u00020\bHÆ\u0003J\t\u0010]\u001a\u00020\bHÆ\u0003J\t\u0010^\u001a\u00020\bHÆ\u0003J\t\u0010_\u001a\u00020\u0005HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00106J\t\u0010b\u001a\u00020\bHÆ\u0003J\t\u0010c\u001a\u00020\bHÆ\u0003J\t\u0010d\u001a\u00020\bHÆ\u0003J\t\u0010e\u001a\u00020\u0005HÆ\u0003J\t\u0010f\u001a\u00020\bHÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003Jð\u0001\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010iJ\u0013\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010m\u001a\u00020\u0005HÖ\u0001J\t\u0010n\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\"\"\u0004\b.\u0010$R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010(\"\u0004\b2\u0010*R\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010(\"\u0004\b4\u0010*R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\u000f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010(\"\u0004\b;\u0010*R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010(\"\u0004\b=\u0010*R\u001a\u0010\u0011\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010(\"\u0004\b?\u0010*R\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\"\"\u0004\bA\u0010$R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\bB\u00106\"\u0004\bC\u00108R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\bD\u00106\"\u0004\bE\u00108R\u001a\u0010\u0015\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010(\"\u0004\bG\u0010*R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010(\"\u0004\bI\u0010*R\u001a\u0010\u0017\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010(\"\u0004\bK\u0010*R\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\"\"\u0004\bM\u0010$R\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010(\"\u0004\bO\u0010*R\u001e\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001e\"\u0004\bQ\u0010 ¨\u0006o"}, d2 = {"Lcom/obric/memorydata/database/entity/EvaluationSourceDataEntity;", "", "timestamp", "", "dataId", "", "groupId", "dataContent", "", "targetSummaryEvent", ObricMemoryConstants.KEY_SESSION_ID, "userType", "sessionType", "originalData", "groundTruth", "groundTruthReason", "searchText", WsConstants.KEY_EXTRA, "validQuery", "largeModelUsage", "gsb", "gsbReason", "retrievalScore", "retrievalScoreReason", "userIndex", "realValue", OaidModel.KEY_ID, "<init>", "(JIILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;J)V", "getTimestamp", "()J", "setTimestamp", "(J)V", "getDataId", "()I", "setDataId", "(I)V", "getGroupId", "setGroupId", "getDataContent", "()Ljava/lang/String;", "setDataContent", "(Ljava/lang/String;)V", "getTargetSummaryEvent", "setTargetSummaryEvent", "getSessionId", "setSessionId", "getUserType", "setUserType", "getSessionType", "setSessionType", "getOriginalData", "setOriginalData", "getGroundTruth", "()Ljava/lang/Long;", "setGroundTruth", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getGroundTruthReason", "setGroundTruthReason", "getSearchText", "setSearchText", "getExtra", "setExtra", "getValidQuery", "setValidQuery", "getLargeModelUsage", "setLargeModelUsage", "getGsb", "setGsb", "getGsbReason", "setGsbReason", "getRetrievalScore", "setRetrievalScore", "getRetrievalScoreReason", "setRetrievalScoreReason", "getUserIndex", "setUserIndex", "getRealValue", "setRealValue", "getId", "setId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "copy", "(JIILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;J)Lcom/obric/memorydata/database/entity/EvaluationSourceDataEntity;", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8947b;
    private int c;
    private String d;
    private String e;
    private int f;
    private int g;
    private String h;
    private String i;
    private Long j;
    private String k;
    private String l;
    private String m;
    private int n;
    private Long o;
    private Long p;
    private String q;
    private String r;
    private String s;
    private int t;
    private String u;
    private long v;

    public bu() {
        this(0, 0, 0, null, null, 0, 0, null, null, null, null, null, null, 0, null, null, null, null, null, 0, null, 0, 4194303, null);
    }

    public bu(long r15, int r17, int r18, String r19, String r20, int r21, int r22, String r23, String r24, Long r25, String r26, String r27, String r28, int r29, Long r30, Long r31, String r32, String r33, String r34, int r35, String r36, long r37) {
        Intrinsics.checkNotNullParameter(r19, "dataContent");
        Intrinsics.checkNotNullParameter(r20, "targetSummaryEvent");
        Intrinsics.checkNotNullParameter(r23, "sessionType");
        Intrinsics.checkNotNullParameter(r24, "originalData");
        Intrinsics.checkNotNullParameter(r26, "groundTruthReason");
        Intrinsics.checkNotNullParameter(r27, "searchText");
        Intrinsics.checkNotNullParameter(r28, WsConstants.KEY_EXTRA);
        Intrinsics.checkNotNullParameter(r32, "gsbReason");
        Intrinsics.checkNotNullParameter(r33, "retrievalScore");
        Intrinsics.checkNotNullParameter(r34, "retrievalScoreReason");
        Intrinsics.checkNotNullParameter(r36, "realValue");
        this.f8946a = r15;
        this.f8947b = r17;
        this.c = r18;
        this.d = r19;
        this.e = r20;
        this.f = r21;
        this.g = r22;
        this.h = r23;
        this.i = r24;
        this.j = r25;
        this.k = r26;
        this.l = r27;
        this.m = r28;
        this.n = r29;
        this.o = r30;
        this.p = r31;
        this.q = r32;
        this.r = r33;
        this.s = r34;
        this.t = r35;
        this.u = r36;
        this.v = r37;
    }

    public /* synthetic */ bu(long r26, int r28, int r29, String r30, String r31, int r32, int r33, String r34, String r35, Long r36, String r37, String r38, String r39, int r40, Long r41, Long r42, String r43, String r44, String r45, int r46, String r47, long r48, int r50, DefaultConstructorMarker r51) {
        if ((r50 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r50 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r50 & 4) == 0) goto L13;
        int r7 = 0;
    L15:
        if ((r50 & 8) == 0) goto L17;
        String r8 = "";
    L19:
        if ((r50 & 16) == 0) goto L21;
        String r10 = "";
    L23:
        if ((r50 & 32) == 0) goto L25;
        int r11 = 0;
    L27:
        if ((r50 & 64) == 0) goto L29;
        int r12 = 0;
    L31:
        if ((r50 & 128) == 0) goto L33;
        String r13 = "";
    L35:
        if ((r50 & 256) == 0) goto L37;
        String r14 = "";
    L38:
        Long r16 = null;
        if ((r50 & 512) == 0) goto L41;
        Long r15 = null;
    L43:
        if ((r50 & 1024) == 0) goto L45;
        String r2 = "";
    L47:
        if ((r50 & 2048) == 0) goto L49;
        String r3 = "";
    L51:
        if ((r50 & 4096) == 0) goto L53;
        String r6 = "";
    L55:
        if ((r50 & 8192) == 0) goto L57;
        int r9 = 0;
    L58:
        int r49 = r9;
        if ((r50 & 16384) == 0) goto L61;
        Long r17 = null;
    L63:
        if ((r50 & 32768) != 0) goto L67;
        r16 = r42;
    L67:
        if ((r50 & 65536) == 0) goto L69;
        String r19 = "";
    L71:
        if ((r50 & 131072) == 0) goto L73;
        String r20 = "";
    L75:
        if ((r50 & 262144) == 0) goto L77;
        String r21 = "";
    L79:
        if ((r50 & 524288) == 0) goto L81;
        int r22 = 0;
    L83:
        if ((r50 & 1048576) == 0) goto L85;
        String r23 = "";
    L87:
        if ((r50 & 2097152) == 0) goto L89;
        long r18 = 0;
    L90:
        this(r4, r1, r7, r8, r10, r11, r12, r13, r14, r15, r2, r3, r6, r49, r17, r16, r19, r20, r21, r22, r23, r18);
        return;
    L89:
        r18 = r48;
        goto L90
    L85:
        r23 = r47;
        goto L87
    L81:
        r22 = r46;
        goto L83
    L77:
        r21 = r45;
        goto L79
    L73:
        r20 = r44;
        goto L75
    L69:
        r19 = r43;
        goto L71
    L61:
        r17 = r41;
        goto L63
    L57:
        r9 = r40;
        goto L58
    L53:
        r6 = r39;
        goto L55
    L49:
        r3 = r38;
        goto L51
    L45:
        r2 = r37;
        goto L47
    L41:
        r15 = r36;
        goto L43
    L37:
        r14 = r35;
        goto L38
    L33:
        r13 = r34;
        goto L35
    L29:
        r12 = r33;
        goto L31
    L25:
        r11 = r32;
        goto L27
    L21:
        r10 = r31;
        goto L23
    L17:
        r8 = r30;
        goto L19
    L13:
        r7 = r29;
        goto L15
    L9:
        r1 = r28;
        goto L11
    L5:
        r4 = r26;
        goto L7
    }

    public static /* synthetic */ bu a(bu r17, long r18, int r20, int r21, String r22, String r23, int r24, int r25, String r26, String r27, Long r28, String r29, String r30, String r31, int r32, Long r33, Long r34, String r35, String r36, String r37, int r38, String r39, long r40, int r42, Object r43) {
        if ((r42 & 1) == 0) goto L5;
        long r2 = r17.f8946a;
    L7:
        if ((r42 & 2) == 0) goto L9;
        int r4 = r17.f8947b;
    L11:
        if ((r42 & 4) == 0) goto L13;
        int r5 = r17.c;
    L15:
        if ((r42 & 8) == 0) goto L17;
        String r6 = r17.d;
    L19:
        if ((r42 & 16) == 0) goto L21;
        String r7 = r17.e;
    L23:
        if ((r42 & 32) == 0) goto L25;
        int r8 = r17.f;
    L27:
        if ((r42 & 64) == 0) goto L29;
        int r9 = r17.g;
    L31:
        if ((r42 & 128) == 0) goto L33;
        String r10 = r17.h;
    L35:
        if ((r42 & 256) == 0) goto L37;
        String r11 = r17.i;
    L39:
        if ((r42 & 512) == 0) goto L41;
        Long r12 = r17.j;
    L43:
        if ((r42 & 1024) == 0) goto L45;
        String r13 = r17.k;
    L47:
        if ((r42 & 2048) == 0) goto L49;
        String r14 = r17.l;
    L51:
        if ((r42 & 4096) == 0) goto L53;
        String r15 = r17.m;
    L54:
        String r310 = r15;
        if ((r42 & 8192) == 0) goto L57;
        int r16 = r17.n;
    L58:
        int r311 = r16;
        if ((r42 & 16384) == 0) goto L61;
        Long r19 = r17.o;
    L62:
        Long r312 = r19;
        if ((r42 & 32768) == 0) goto L65;
        Long r110 = r17.p;
    L66:
        Long r313 = r110;
        if ((r42 & 65536) == 0) goto L69;
        String r111 = r17.q;
    L70:
        String r314 = r111;
        if ((r42 & 131072) == 0) goto L73;
        String r112 = r17.r;
    L74:
        String r315 = r112;
        if ((r42 & 262144) == 0) goto L77;
        String r113 = r17.s;
    L78:
        String r316 = r113;
        if ((r42 & 524288) == 0) goto L81;
        int r114 = r17.t;
    L82:
        int r317 = r114;
        if ((r42 & 1048576) == 0) goto L85;
        String r115 = r17.u;
    L86:
        String r318 = r14;
        String r319 = r115;
        if ((r42 & 2097152) == 0) goto L89;
        long r116 = r17.v;
    L91:
        return r17.a(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r318, r310, r311, r312, r313, r314, r315, r316, r317, r319, r116);
    L89:
        r116 = r40;
        goto L91
    L85:
        r115 = r39;
        goto L86
    L81:
        r114 = r38;
        goto L82
    L77:
        r113 = r37;
        goto L78
    L73:
        r112 = r36;
        goto L74
    L69:
        r111 = r35;
        goto L70
    L65:
        r110 = r34;
        goto L66
    L61:
        r19 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L54
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r6 = r22;
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
        return this.f8946a;
    }

    public final bu a(long r27, int r29, int r30, String r31, String r32, int r33, int r34, String r35, String r36, Long r37, String r38, String r39, String r40, int r41, Long r42, Long r43, String r44, String r45, String r46, int r47, String r48, long r49) {
        Intrinsics.checkNotNullParameter(r31, "dataContent");
        Intrinsics.checkNotNullParameter(r32, "targetSummaryEvent");
        Intrinsics.checkNotNullParameter(r35, "sessionType");
        Intrinsics.checkNotNullParameter(r36, "originalData");
        Intrinsics.checkNotNullParameter(r38, "groundTruthReason");
        Intrinsics.checkNotNullParameter(r39, "searchText");
        Intrinsics.checkNotNullParameter(r40, WsConstants.KEY_EXTRA);
        Intrinsics.checkNotNullParameter(r44, "gsbReason");
        Intrinsics.checkNotNullParameter(r45, "retrievalScore");
        Intrinsics.checkNotNullParameter(r46, "retrievalScoreReason");
        Intrinsics.checkNotNullParameter(r48, "realValue");
        return new bu(r27, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49);
    }

    public final int b() {
        return this.f8947b;
    }

    public final int c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, bu.class) == true) goto L8;
        return false;
    L8:
        bu r10 = (bu) ZeusTransformUtils.preCheckCast(r9, bu.class, "com.obric.memorydata.plugin");
        if (this.f8946a == r10.f8946a) goto L12;
        return false;
    L12:
        if (this.f8947b == r10.f8947b) goto L15;
        return false;
    L15:
        if (this.c == r10.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r10.h) == true) goto L33;
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
        if (Intrinsics.areEqual(this.p, r10.p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r10.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r10.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r10.s) == true) goto L66;
        return false;
    L66:
        if (this.t == r10.t) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r10.u) == true) goto L72;
        return false;
    L72:
        if (this.v == r10.v) goto L74;
        return false;
    L74:
        return true;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((Long.hashCode(this.f8946a) * 31) + Integer.hashCode(this.f8947b)) * 31) + Integer.hashCode(this.c)) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + Integer.hashCode(this.f)) * 31) + Integer.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        Long r1 = this.j;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((((((((r0 + r3) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31) + Integer.hashCode(this.n)) * 31;
        Long r5 = this.o;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.p;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((((((((((r7 + r2) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + Integer.hashCode(this.t)) * 31) + this.u.hashCode()) * 31) + Long.hashCode(this.v);
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String i() {
        return this.i;
    }

    public final Long j() {
        return this.j;
    }

    public final String k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final String m() {
        return this.m;
    }

    public final int n() {
        return this.n;
    }

    public final Long o() {
        return this.o;
    }

    public final Long p() {
        return this.p;
    }

    public final String q() {
        return this.q;
    }

    public final String r() {
        return this.r;
    }

    public final String s() {
        return this.s;
    }

    public final int t() {
        return this.t;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("EvaluationSourceDataEntity(timestamp=").append(this.f8946a).append(", dataId=").append(this.f8947b).append(", groupId=").append(this.c).append(", dataContent=").append(this.d).append(", targetSummaryEvent=").append(this.e).append(", sessionId=").append(this.f).append(", userType=").append(this.g).append(", sessionType=").append(this.h).append(", originalData=").append(this.i).append(", groundTruth=").append(this.j).append(", groundTruthReason=").append(this.k).append(", searchText=");
        r0.append(this.l).append(", extra=").append(this.m).append(", validQuery=").append(this.n).append(", largeModelUsage=").append(this.o).append(", gsb=").append(this.p).append(", gsbReason=").append(this.q).append(", retrievalScore=").append(this.r).append(", retrievalScoreReason=").append(this.s).append(", userIndex=").append(this.t).append(", realValue=").append(this.u).append(", id=").append(this.v).append(')');
        return r0.toString();
    }

    public final String u() {
        return this.u;
    }

    public final long v() {
        return this.v;
    }
}
