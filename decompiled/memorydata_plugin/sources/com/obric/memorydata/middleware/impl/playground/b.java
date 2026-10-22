package com.obric.memorydata.middleware.impl.playground;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b0\b\u0080\b\u0018\u00002\u00020\u0001B·\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010<\u001a\u00020\u0011HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010A\u001a\u00020\u0011HÆ\u0003J\t\u0010B\u001a\u00020\u0018HÆ\u0003JÁ\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u0018HÆ\u0001J\u0013\u0010D\u001a\u00020\u00112\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\u0005HÖ\u0001J\t\u0010G\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0011\u0010\u0013\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b-\u0010(R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0011\u0010\u0016\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010+R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u0006H"}, d2 = {"Lcom/obric/memorydata/middleware/impl/playground/DispatchIntentResult;", "", "questionId", "", "ret", "", "details", "", "entity", "message", "actionResultData", "resultId", "resultQuestionId", "resultExt", "Lorg/json/JSONObject;", "rawResult", "hasRawResult", "", "rawResultSource", "intentResultExt", "uiType", "screenshotBase64", "isInfrastructureFailure", "resultMode", "Lcom/obric/memorydata/middleware/impl/playground/AppIntentResultMode;", "<init>", "(JILjava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;JJLorg/json/JSONObject;Ljava/lang/Object;ZLjava/lang/String;Lorg/json/JSONObject;ILjava/lang/String;ZLcom/obric/memorydata/middleware/impl/playground/AppIntentResultMode;)V", "getQuestionId", "()J", "getRet", "()I", "getDetails", "()Ljava/lang/String;", "getEntity", "()Ljava/lang/Object;", "getMessage", "getActionResultData", "getResultId", "getResultQuestionId", "getResultExt", "()Lorg/json/JSONObject;", "getRawResult", "getHasRawResult", "()Z", "getRawResultSource", "getIntentResultExt", "getUiType", "getScreenshotBase64", "getResultMode", "()Lcom/obric/memorydata/middleware/impl/playground/AppIntentResultMode;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f11805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f11806b;
    private final String c;
    private final Object d;
    private final String e;
    private final String f;
    private final long g;
    private final long h;
    private final JSONObject i;
    private final Object j;
    private final boolean k;
    private final String l;
    private final JSONObject m;
    private final int n;
    private final String o;
    private final boolean p;
    private final AppIntentResultMode q;

    public b(long r7, int r9, String r10, Object r11, String r12, String r13, long r14, long r16, JSONObject r18, Object r19, boolean r20, String r21, JSONObject r22, int r23, String r24, boolean r25, AppIntentResultMode r26) {
        Intrinsics.checkNotNullParameter(r18, "resultExt");
        Intrinsics.checkNotNullParameter(r22, "intentResultExt");
        Intrinsics.checkNotNullParameter(r26, "resultMode");
        this.f11805a = r7;
        this.f11806b = r9;
        this.c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.h = r16;
        this.i = r18;
        this.j = r19;
        this.k = r20;
        this.l = r21;
        this.m = r22;
        this.n = r23;
        this.o = r24;
        this.p = r25;
        this.q = r26;
    }

    public /* synthetic */ b(long r25, int r27, String r28, Object r29, String r30, String r31, long r32, long r34, JSONObject r36, Object r37, boolean r38, String r39, JSONObject r40, int r41, String r42, boolean r43, AppIntentResultMode r44, int r45, DefaultConstructorMarker r46) {
        if ((r45 & 16) == 0) goto L5;
        String r9 = null;
    L7:
        if ((r45 & 32) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r45 & 64) == 0) goto L13;
        long r11 = -1;
    L15:
        if ((r45 & 128) == 0) goto L17;
        long r13 = r25;
    L19:
        if ((r45 & 256) == 0) goto L21;
        JSONObject r15 = new JSONObject();
    L23:
        if ((r45 & 512) == 0) goto L25;
        Object r16 = null;
    L27:
        if ((r45 & 1024) == 0) goto L29;
        boolean r17 = false;
    L31:
        if ((r45 & 2048) == 0) goto L33;
        String r18 = null;
    L35:
        if ((r45 & 4096) == 0) goto L37;
        JSONObject r19 = new JSONObject();
    L39:
        if ((r45 & 8192) == 0) goto L41;
        int r20 = 0;
    L43:
        if ((r45 & 16384) == 0) goto L45;
        String r21 = null;
    L47:
        if ((32768 & r45) == 0) goto L49;
        boolean r22 = false;
    L51:
        if ((r45 & 65536) == 0) goto L53;
        AppIntentResultMode r23 = AppIntentResultMode.JOB_RESULT;
    L54:
        this(r25, r27, r28, r29, r9, r10, r11, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23);
        return;
    L53:
        r23 = r44;
        goto L54
    L49:
        r22 = r43;
        goto L51
    L45:
        r21 = r42;
        goto L47
    L41:
        r20 = r41;
        goto L43
    L37:
        r19 = r40;
        goto L39
    L33:
        r18 = r39;
        goto L35
    L29:
        r17 = r38;
        goto L31
    L25:
        r16 = r37;
        goto L27
    L21:
        r15 = r36;
        goto L23
    L17:
        r13 = r34;
        goto L19
    L13:
        r11 = r32;
        goto L15
    L9:
        r10 = r31;
        goto L11
    L5:
        r9 = r30;
        goto L7
    }

    public static /* synthetic */ b a(b r17, long r18, int r20, String r21, Object r22, String r23, String r24, long r25, long r27, JSONObject r29, Object r30, boolean r31, String r32, JSONObject r33, int r34, String r35, boolean r36, AppIntentResultMode r37, int r38, Object r39) {
        if ((r38 & 1) == 0) goto L5;
        long r2 = r17.f11805a;
    L7:
        if ((r38 & 2) == 0) goto L9;
        int r4 = r17.f11806b;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r5 = r17.c;
    L15:
        if ((r38 & 8) == 0) goto L17;
        Object r6 = r17.d;
    L19:
        if ((r38 & 16) == 0) goto L21;
        String r7 = r17.e;
    L23:
        if ((r38 & 32) == 0) goto L25;
        String r8 = r17.f;
    L27:
        if ((r38 & 64) == 0) goto L29;
        long r9 = r17.g;
    L31:
        if ((r38 & 128) == 0) goto L33;
        long r11 = r17.h;
    L35:
        if ((r38 & 256) == 0) goto L37;
        JSONObject r13 = r17.i;
    L39:
        if ((r38 & 512) == 0) goto L41;
        Object r14 = r17.j;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        boolean r15 = r17.k;
    L46:
        boolean r310 = r15;
        if ((r38 & 2048) == 0) goto L49;
        String r16 = r17.l;
    L50:
        String r311 = r16;
        if ((r38 & 4096) == 0) goto L53;
        JSONObject r19 = r17.m;
    L54:
        JSONObject r312 = r19;
        if ((r38 & 8192) == 0) goto L57;
        int r110 = r17.n;
    L58:
        int r313 = r110;
        if ((r38 & 16384) == 0) goto L61;
        String r111 = r17.o;
    L62:
        String r314 = r111;
        if ((r38 & 32768) == 0) goto L65;
        boolean r112 = r17.p;
    L67:
        if ((r38 & 65536) == 0) goto L69;
        AppIntentResultMode r1 = r17.q;
    L71:
        return r17.a(r2, r4, r5, r6, r7, r8, r9, r11, r13, r14, r310, r311, r312, r313, r314, r112, r1);
    L69:
        r1 = r37;
        goto L71
    L65:
        r112 = r36;
        goto L67
    L61:
        r111 = r35;
        goto L62
    L57:
        r110 = r34;
        goto L58
    L53:
        r19 = r33;
        goto L54
    L49:
        r16 = r32;
        goto L50
    L45:
        r15 = r31;
        goto L46
    L41:
        r14 = r30;
        goto L43
    L37:
        r13 = r29;
        goto L39
    L33:
        r11 = r27;
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
        return this.f11805a;
    }

    public final b a(long r23, int r25, String r26, Object r27, String r28, String r29, long r30, long r32, JSONObject r34, Object r35, boolean r36, String r37, JSONObject r38, int r39, String r40, boolean r41, AppIntentResultMode r42) {
        Intrinsics.checkNotNullParameter(r34, "resultExt");
        Intrinsics.checkNotNullParameter(r38, "intentResultExt");
        Intrinsics.checkNotNullParameter(r42, "resultMode");
        return new b(r23, r25, r26, r27, r28, r29, r30, r32, r34, r35, r36, r37, r38, r39, r40, r41, r42);
    }

    public final int b() {
        return this.f11806b;
    }

    public final String c() {
        return this.c;
    }

    public final Object d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
        return false;
    L8:
        b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
        if (this.f11805a == r10.f11805a) goto L12;
        return false;
    L12:
        if (this.f11806b == r10.f11806b) goto L15;
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
        if (Intrinsics.areEqual(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r10.j) == true) goto L39;
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
        if (this.n == r10.n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r10.o) == true) goto L54;
        return false;
    L54:
        if (this.p == r10.p) goto L57;
        return false;
    L57:
        if (this.q == r10.q) goto L59;
        return false;
    L59:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((Long.hashCode(this.f11805a) * 31) + Integer.hashCode(this.f11806b)) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Object r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((((((r10 + r12) * 31) + Long.hashCode(this.g)) * 31) + Long.hashCode(this.h)) * 31) + this.i.hashCode()) * 31;
        Object r14 = this.j;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((r13 + r15) * 31) + Boolean.hashCode(this.k)) * 31;
        String r17 = this.l;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((((r16 + r18) * 31) + this.m.hashCode()) * 31) + Integer.hashCode(this.n)) * 31;
        String r20 = this.o;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return ((((r19 + r2) * 31) + Boolean.hashCode(this.p)) * 31) + this.q.hashCode();
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

    public final JSONObject i() {
        return this.i;
    }

    public final Object j() {
        return this.j;
    }

    public final boolean k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final JSONObject m() {
        return this.m;
    }

    public final int n() {
        return this.n;
    }

    public final String o() {
        return this.o;
    }

    public final boolean p() {
        return this.p;
    }

    public final AppIntentResultMode q() {
        return this.q;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("DispatchIntentResult(questionId=").append(this.f11805a).append(", ret=").append(this.f11806b).append(", details=").append(this.c).append(", entity=").append(this.d).append(", message=").append(this.e).append(", actionResultData=").append(this.f).append(", resultId=").append(this.g).append(", resultQuestionId=").append(this.h).append(", resultExt=").append(this.i).append(", rawResult=").append(this.j).append(", hasRawResult=").append(this.k).append(", rawResultSource=");
        r0.append(this.l).append(", intentResultExt=").append(this.m).append(", uiType=").append(this.n).append(", screenshotBase64=").append(this.o).append(", isInfrastructureFailure=").append(this.p).append(", resultMode=").append(this.q).append(')');
        return r0.toString();
    }
}
