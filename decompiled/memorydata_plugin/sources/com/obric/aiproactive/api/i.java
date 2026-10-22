package com.obric.aiproactive.api;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b?\b\u0086\b\u0018\u00002\u00020\u0001Bõ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0004\b!\u0010\"J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\nHÆ\u0003J\t\u0010H\u001a\u00020\nHÆ\u0003J\t\u0010I\u001a\u00020\rHÆ\u0003J\t\u0010J\u001a\u00020\nHÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\nHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0015HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\u000f\u0010Y\u001a\b\u0012\u0004\u0012\u00020 0\u001fHÆ\u0003J\u0089\u0002\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fHÆ\u0001J\u0013\u0010[\u001a\u00020\u00152\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020\nHÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b/\u0010+R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b1\u0010+R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010$R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006_"}, d2 = {"Lcom/obric/aiproactive/api/AiProactiveAgentRunStepDto;", "", "stepId", "", EventBody.KEY_CATEGORY, "event", "state", "summary", "toolName", "round", "", "sequence", "timestampMillis", "", "protocolVersion", "stageId", "stageOrder", "stageType", "operation", "effect", "requiresConfirmation", "", "toolDisplayName", "toolType", "displayTitle", "displaySubtitle", "displayMarkdown", "presentationType", "secondaryListStyle", "mobileSessionId", "displayItems", "", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDisplayItemDto;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIJILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getStepId", "()Ljava/lang/String;", "getCategory", "getEvent", "getState", "getSummary", "getToolName", "getRound", "()I", "getSequence", "getTimestampMillis", "()J", "getProtocolVersion", "getStageId", "getStageOrder", "getStageType", "getOperation", "getEffect", "getRequiresConfirmation", "()Z", "getToolDisplayName", "getToolType", "getDisplayTitle", "getDisplaySubtitle", "getDisplayMarkdown", "getPresentationType", "getSecondaryListStyle", "getMobileSessionId", "getDisplayItems", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "equals", "other", "hashCode", "toString", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6254b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;
    private final int h;
    private final long i;
    private final int j;
    private final String k;
    private final int l;
    private final String m;
    private final String n;
    private final String o;
    private final boolean p;
    private final String q;
    private final String r;
    private final String s;
    private final String t;
    private final String u;
    private final String v;
    private final String w;
    private final String x;
    private final List<f> y;

    public i(String r17, String r18, String r19, String r20, String r21, String r22, int r23, int r24, long r25, int r27, String r28, int r29, String r30, String r31, String r32, boolean r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, List<f> r42) {
        List<f> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r42, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r17, "stepId");
        Intrinsics.checkNotNullParameter(r18, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r19, "event");
        Intrinsics.checkNotNullParameter(r20, "state");
        Intrinsics.checkNotNullParameter(r21, "summary");
        Intrinsics.checkNotNullParameter(r22, "toolName");
        Intrinsics.checkNotNullParameter(r28, "stageId");
        Intrinsics.checkNotNullParameter(r30, "stageType");
        Intrinsics.checkNotNullParameter(r31, "operation");
        Intrinsics.checkNotNullParameter(r32, "effect");
        Intrinsics.checkNotNullParameter(r34, "toolDisplayName");
        Intrinsics.checkNotNullParameter(r35, "toolType");
        Intrinsics.checkNotNullParameter(r36, "displayTitle");
        Intrinsics.checkNotNullParameter(r37, "displaySubtitle");
        Intrinsics.checkNotNullParameter(r38, "displayMarkdown");
        Intrinsics.checkNotNullParameter(r39, "presentationType");
        Intrinsics.checkNotNullParameter(r40, "secondaryListStyle");
        Intrinsics.checkNotNullParameter(r41, "mobileSessionId");
        Intrinsics.checkNotNullParameter(r0, "displayItems");
        this.f6253a = r17;
        this.f6254b = r18;
        this.c = r19;
        this.d = r20;
        this.e = r21;
        this.f = r22;
        this.g = r23;
        this.h = r24;
        this.i = r25;
        this.j = r27;
        this.k = r28;
        this.l = r29;
        this.m = r30;
        this.n = r31;
        this.o = r32;
        this.p = r33;
        this.q = r34;
        this.r = r35;
        this.s = r36;
        this.t = r37;
        this.u = r38;
        this.v = r39;
        this.w = r40;
        this.x = r41;
        this.y = r0;
    }

    public static /* synthetic */ i a(i r17, String r18, String r19, String r20, String r21, String r22, String r23, int r24, int r25, long r26, int r28, String r29, int r30, String r31, String r32, String r33, boolean r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, List r43, int r44, Object r45) {
        List<f> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r43, List.class, "com.obric.memorydata.plugin");
        if ((r44 & 1) == 0) goto L5;
        String r3 = r17.f6253a;
    L7:
        if ((r44 & 2) == 0) goto L9;
        String r4 = r17.f6254b;
    L11:
        if ((r44 & 4) == 0) goto L13;
        String r5 = r17.c;
    L15:
        if ((r44 & 8) == 0) goto L17;
        String r6 = r17.d;
    L19:
        if ((r44 & 16) == 0) goto L21;
        String r7 = r17.e;
    L23:
        if ((r44 & 32) == 0) goto L25;
        String r8 = r17.f;
    L27:
        if ((r44 & 64) == 0) goto L29;
        int r9 = r17.g;
    L31:
        if ((r44 & 128) == 0) goto L33;
        int r10 = r17.h;
    L35:
        if ((r44 & 256) == 0) goto L37;
        long r11 = r17.i;
    L39:
        if ((r44 & 512) == 0) goto L41;
        int r13 = r17.j;
    L43:
        if ((r44 & 1024) == 0) goto L45;
        String r14 = r17.k;
    L47:
        if ((r44 & 2048) == 0) goto L49;
        int r15 = r17.l;
    L51:
        if ((r44 & 4096) == 0) goto L53;
        String r12 = r17.m;
    L54:
        String r310 = r12;
        if ((r44 & 8192) == 0) goto L57;
        String r16 = r17.n;
    L58:
        String r311 = r16;
        if ((r44 & 16384) == 0) goto L61;
        String r27 = r17.o;
    L62:
        String r312 = r27;
        if ((r44 & 32768) == 0) goto L65;
        boolean r46 = r17.p;
    L66:
        boolean r313 = r46;
        if ((r44 & 65536) == 0) goto L69;
        String r47 = r17.q;
    L70:
        String r314 = r47;
        if ((r44 & 131072) == 0) goto L73;
        String r48 = r17.r;
    L74:
        String r315 = r48;
        if ((r44 & 262144) == 0) goto L77;
        String r49 = r17.s;
    L78:
        String r316 = r49;
        if ((r44 & 524288) == 0) goto L81;
        String r50 = r17.t;
    L82:
        String r317 = r50;
        if ((r44 & 1048576) == 0) goto L85;
        String r51 = r17.u;
    L86:
        String r318 = r51;
        if ((r44 & 2097152) == 0) goto L89;
        String r52 = r17.v;
    L90:
        String r410 = r52;
        if ((r44 & 4194304) == 0) goto L93;
        String r53 = r17.w;
    L94:
        String r411 = r53;
        if ((r44 & 8388608) == 0) goto L97;
        String r54 = r17.x;
    L99:
        if ((r44 & 16777216) == 0) goto L101;
        List<f> r1 = r17.y;
    L103:
        return r17.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r54, r1);
    L101:
        r1 = r2;
        goto L103
    L97:
        r54 = r42;
        goto L99
    L93:
        r53 = r41;
        goto L94
    L89:
        r52 = r40;
        goto L90
    L85:
        r51 = r39;
        goto L86
    L81:
        r50 = r38;
        goto L82
    L77:
        r49 = r37;
        goto L78
    L73:
        r48 = r36;
        goto L74
    L69:
        r47 = r35;
        goto L70
    L65:
        r46 = r34;
        goto L66
    L61:
        r27 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r12 = r31;
        goto L54
    L49:
        r15 = r30;
        goto L51
    L45:
        r14 = r29;
        goto L47
    L41:
        r13 = r28;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r3 = r18;
        goto L7
    }

    public final i a(String r30, String r31, String r32, String r33, String r34, String r35, int r36, int r37, long r38, int r40, String r41, int r42, String r43, String r44, String r45, boolean r46, String r47, String r48, String r49, String r50, String r51, String r52, String r53, String r54, List<f> r55) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r55, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r30, "stepId");
        Intrinsics.checkNotNullParameter(r31, EventBody.KEY_CATEGORY);
        Intrinsics.checkNotNullParameter(r32, "event");
        Intrinsics.checkNotNullParameter(r33, "state");
        Intrinsics.checkNotNullParameter(r34, "summary");
        Intrinsics.checkNotNullParameter(r35, "toolName");
        Intrinsics.checkNotNullParameter(r41, "stageId");
        Intrinsics.checkNotNullParameter(r43, "stageType");
        Intrinsics.checkNotNullParameter(r44, "operation");
        Intrinsics.checkNotNullParameter(r45, "effect");
        Intrinsics.checkNotNullParameter(r47, "toolDisplayName");
        Intrinsics.checkNotNullParameter(r48, "toolType");
        Intrinsics.checkNotNullParameter(r49, "displayTitle");
        Intrinsics.checkNotNullParameter(r50, "displaySubtitle");
        Intrinsics.checkNotNullParameter(r51, "displayMarkdown");
        Intrinsics.checkNotNullParameter(r52, "presentationType");
        Intrinsics.checkNotNullParameter(r53, "secondaryListStyle");
        Intrinsics.checkNotNullParameter(r54, "mobileSessionId");
        Intrinsics.checkNotNullParameter(r0, "displayItems");
        return new i(r30, r31, r32, r33, r34, r35, r36, r37, r38, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r0);
    }

    public final String a() {
        return this.f6253a;
    }

    public final String b() {
        return this.f6254b;
    }

    public final String c() {
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
        if (ZeusTransformUtils.instanceOf(r9, i.class) == true) goto L8;
        return false;
    L8:
        i r10 = (i) ZeusTransformUtils.preCheckCast(r9, i.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6253a, r10.f6253a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6254b, r10.f6254b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r10.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r10.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L30;
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
        if (Intrinsics.areEqual(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r10.l) goto L45;
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
        if (Intrinsics.areEqual(this.q, r10.q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.r, r10.r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.s, r10.s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.t, r10.t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.u, r10.u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.v, r10.v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r10.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r10.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r10.y) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((this.f6253a.hashCode() * 31) + this.f6254b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Integer.hashCode(this.g)) * 31) + Integer.hashCode(this.h)) * 31) + Long.hashCode(this.i)) * 31) + Integer.hashCode(this.j)) * 31) + this.k.hashCode()) * 31) + Integer.hashCode(this.l)) * 31) + this.m.hashCode()) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + Boolean.hashCode(this.p)) * 31) + this.q.hashCode()) * 31) + this.r.hashCode()) * 31) + this.s.hashCode()) * 31) + this.t.hashCode()) * 31) + this.u.hashCode()) * 31) + this.v.hashCode()) * 31) + this.w.hashCode()) * 31) + this.x.hashCode()) * 31) + this.y.hashCode();
    }

    public final long i() {
        return this.i;
    }

    public final int j() {
        return this.j;
    }

    public final String k() {
        return this.k;
    }

    public final int l() {
        return this.l;
    }

    public final String m() {
        return this.m;
    }

    public final String n() {
        return this.n;
    }

    public final String o() {
        return this.o;
    }

    public final boolean p() {
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

    public final String t() {
        return this.t;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AiProactiveAgentRunStepDto(stepId=").append(this.f6253a).append(", category=").append(this.f6254b).append(", event=").append(this.c).append(", state=").append(this.d).append(", summary=").append(this.e).append(", toolName=").append(this.f).append(", round=").append(this.g).append(", sequence=").append(this.h).append(", timestampMillis=").append(this.i).append(", protocolVersion=").append(this.j).append(", stageId=").append(this.k).append(", stageOrder=");
        r0.append(this.l).append(", stageType=").append(this.m).append(", operation=").append(this.n).append(", effect=").append(this.o).append(", requiresConfirmation=").append(this.p).append(", toolDisplayName=").append(this.q).append(", toolType=").append(this.r).append(", displayTitle=").append(this.s).append(", displaySubtitle=").append(this.t).append(", displayMarkdown=").append(this.u).append(", presentationType=").append(this.v).append(", secondaryListStyle=").append(this.w);
        r0.append(", mobileSessionId=").append(this.x).append(", displayItems=").append(this.y).append(')');
        return r0.toString();
    }

    public final String u() {
        return this.u;
    }

    public final String v() {
        return this.v;
    }

    public final String w() {
        return this.w;
    }

    public final String x() {
        return this.x;
    }

    public final List<f> y() {
        return this.y;
    }
}
