package com.obric.aiproactive.ui.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b3\b\u0080\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010*\u001a\u00020\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¨\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\b2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\u0006HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016¨\u0006;"}, d2 = {"Lcom/obric/aiproactive/ui/model/InspirationLocalPatch;", "", "inspirationId", "", "sourceId", "recommendStatus", "", "hasActionExecuteInstructionUpdate", "", "actionExecuteInstruction", "hasActionConditionUpdate", "actionCondition", "hasFeedbackActionUpdate", "feedbackAction", "hasUserFeedbackUpdate", "userFeedback", "hasStructuredFeedbackUpdate", "feedbackReason", "feedbackText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getInspirationId", "()Ljava/lang/String;", "getSourceId", "getRecommendStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasActionExecuteInstructionUpdate", "()Z", "getActionExecuteInstruction", "getHasActionConditionUpdate", "getActionCondition", "getHasFeedbackActionUpdate", "getFeedbackAction", "getHasUserFeedbackUpdate", "getUserFeedback", "getHasStructuredFeedbackUpdate", "getFeedbackReason", "getFeedbackText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Lcom/obric/aiproactive/ui/model/InspirationLocalPatch;", "equals", "other", "hashCode", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6728b;
    private final Integer c;
    private final boolean d;
    private final String e;
    private final boolean f;
    private final String g;
    private final boolean h;
    private final String i;
    private final boolean j;
    private final String k;
    private final boolean l;
    private final String m;
    private final String n;

    public h(String r2, String r3, Integer r4, boolean r5, String r6, boolean r7, String r8, boolean r9, String r10, boolean r11, String r12, boolean r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r2, "inspirationId");
        Intrinsics.checkNotNullParameter(r3, "sourceId");
        this.f6727a = r2;
        this.f6728b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = r15;
    }

    public /* synthetic */ h(String r15, String r16, Integer r17, boolean r18, String r19, boolean r20, String r21, boolean r22, String r23, boolean r24, String r25, boolean r26, String r27, String r28, int r29, DefaultConstructorMarker r30) {
        if ((r29 & 2) == 0) goto L5;
        String r1 = "";
    L6:
        String r3 = null;
        if ((r29 & 4) == 0) goto L9;
        Integer r2 = null;
    L10:
        boolean r5 = false;
        if ((r29 & 8) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r29 & 16) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r29 & 32) == 0) goto L21;
        boolean r7 = false;
    L23:
        if ((r29 & 64) == 0) goto L25;
        String r8 = null;
    L27:
        if ((r29 & 128) == 0) goto L29;
        boolean r9 = false;
    L31:
        if ((r29 & 256) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r29 & 512) == 0) goto L37;
        boolean r11 = false;
    L39:
        if ((r29 & 1024) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r29 & 2048) != 0) goto L47;
        r5 = r26;
    L47:
        if ((r29 & 4096) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r29 & 8192) != 0) goto L54;
        r3 = r28;
    L54:
        this(r15, r1, r2, r4, r6, r7, r8, r9, r10, r11, r12, r5, r13, r3);
        return;
    L49:
        r13 = r27;
        goto L51
    L41:
        r12 = r25;
        goto L43
    L37:
        r11 = r24;
        goto L39
    L33:
        r10 = r23;
        goto L35
    L29:
        r9 = r22;
        goto L31
    L25:
        r8 = r21;
        goto L27
    L21:
        r7 = r20;
        goto L23
    L17:
        r6 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r2 = r17;
        goto L10
    L5:
        r1 = r16;
        goto L6
    }

    public static /* synthetic */ h a(h r15, String r16, String r17, Integer r18, boolean r19, String r20, boolean r21, String r22, boolean r23, String r24, boolean r25, String r26, boolean r27, String r28, String r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        String r2 = r15.f6727a;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r3 = r15.f6728b;
    L11:
        if ((r30 & 4) == 0) goto L13;
        Integer r4 = r15.c;
    L15:
        if ((r30 & 8) == 0) goto L17;
        boolean r5 = r15.d;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = r15.e;
    L23:
        if ((r30 & 32) == 0) goto L25;
        boolean r7 = r15.f;
    L27:
        if ((r30 & 64) == 0) goto L29;
        String r8 = r15.g;
    L31:
        if ((r30 & 128) == 0) goto L33;
        boolean r9 = r15.h;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r10 = r15.i;
    L39:
        if ((r30 & 512) == 0) goto L41;
        boolean r11 = r15.j;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r12 = r15.k;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        boolean r13 = r15.l;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r14 = r15.m;
    L55:
        if ((r30 & 8192) == 0) goto L57;
        String r1 = r15.n;
    L59:
        return r15.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L57:
        r1 = r29;
        goto L59
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final h a(String r17, String r18, Integer r19, boolean r20, String r21, boolean r22, String r23, boolean r24, String r25, boolean r26, String r27, boolean r28, String r29, String r30) {
        Intrinsics.checkNotNullParameter(r17, "inspirationId");
        Intrinsics.checkNotNullParameter(r18, "sourceId");
        return new h(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public final String a() {
        return this.f6727a;
    }

    public final String b() {
        return this.f6728b;
    }

    public final Integer c() {
        return this.c;
    }

    public final boolean d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6727a, r6.f6727a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6728b, r6.f6728b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final boolean f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final boolean h() {
        return this.h;
    }

    public int hashCode() {
        int r0 = ((this.f6727a.hashCode() * 31) + this.f6728b.hashCode()) * 31;
        Integer r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Boolean.hashCode(this.d)) * 31;
        String r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Boolean.hashCode(this.f)) * 31;
        String r8 = this.g;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (((r7 + r9) * 31) + Boolean.hashCode(this.h)) * 31;
        String r11 = this.i;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((r10 + r12) * 31) + Boolean.hashCode(this.j)) * 31;
        String r14 = this.k;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((r13 + r15) * 31) + Boolean.hashCode(this.l)) * 31;
        String r17 = this.m;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        String r20 = this.n;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return r19 + r2;
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
        return this.i;
    }

    public final boolean j() {
        return this.j;
    }

    public final String k() {
        return this.k;
    }

    public final boolean l() {
        return this.l;
    }

    public final String m() {
        return this.m;
    }

    public final String n() {
        return this.n;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("InspirationLocalPatch(inspirationId=").append(this.f6727a).append(", sourceId=").append(this.f6728b).append(", recommendStatus=").append(this.c).append(", hasActionExecuteInstructionUpdate=").append(this.d).append(", actionExecuteInstruction=").append(this.e).append(", hasActionConditionUpdate=").append(this.f).append(", actionCondition=").append(this.g).append(", hasFeedbackActionUpdate=").append(this.h).append(", feedbackAction=").append(this.i).append(", hasUserFeedbackUpdate=").append(this.j).append(", userFeedback=").append(this.k).append(", hasStructuredFeedbackUpdate=");
        r0.append(this.l).append(", feedbackReason=").append(this.m).append(", feedbackText=").append(this.n).append(')');
        return r0.toString();
    }
}
