package com.obric.aiproactive.ui.progress;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00120\tHÆ\u0003J\t\u00103\u001a\u00020\u0014HÆ\u0003J\u008d\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u00105\u001a\u00020\r2\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\t¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006:"}, d2 = {"Lcom/obric/aiproactive/ui/progress/AgentRunUiStep;", "", OaidModel.KEY_ID, "", "title", "subtitle", "state", "Lcom/obric/aiproactive/ui/progress/AgentRunUiState;", "groups", "", "Lcom/obric/aiproactive/ui/progress/AgentRunUiGroup;", "contentMarkdown", "showCollapsedSubtitle", "", "executionId", "stageId", "mobileSessionId", "activityItems", "Lcom/obric/aiproactive/ui/progress/AgentRunActivityUiItem;", "secondaryListStyle", "Lcom/obric/aiproactive/ui/progress/AgentRunSecondaryListStyle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/obric/aiproactive/ui/progress/AgentRunUiState;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/obric/aiproactive/ui/progress/AgentRunSecondaryListStyle;)V", "getId", "()Ljava/lang/String;", "getTitle", "getSubtitle", "getState", "()Lcom/obric/aiproactive/ui/progress/AgentRunUiState;", "getGroups", "()Ljava/util/List;", "getContentMarkdown", "getShowCollapsedSubtitle", "()Z", "getExecutionId", "getStageId", "getMobileSessionId", "getActivityItems", "getSecondaryListStyle", "()Lcom/obric/aiproactive/ui/progress/AgentRunSecondaryListStyle;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "", "toString", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f6836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6837b;
    private final String c;
    private final AgentRunUiState d;
    private final List<k> e;
    private final String f;
    private final boolean g;
    private final String h;
    private final String i;
    private final String j;
    private final List<a> k;
    private final AgentRunSecondaryListStyle l;

    public n(String r3, String r4, String r5, AgentRunUiState r6, List<k> r7, String r8, boolean r9, String r10, String r11, String r12, List<a> r13, AgentRunSecondaryListStyle r14) {
        List<k> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        List<a> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r5, "subtitle");
        Intrinsics.checkNotNullParameter(r6, "state");
        Intrinsics.checkNotNullParameter(r15, "groups");
        Intrinsics.checkNotNullParameter(r8, "contentMarkdown");
        Intrinsics.checkNotNullParameter(r10, "executionId");
        Intrinsics.checkNotNullParameter(r11, "stageId");
        Intrinsics.checkNotNullParameter(r12, "mobileSessionId");
        Intrinsics.checkNotNullParameter(r16, "activityItems");
        Intrinsics.checkNotNullParameter(r14, "secondaryListStyle");
        this.f6836a = r3;
        this.f6837b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r15;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r16;
        this.l = r14;
    }

    public /* synthetic */ n(String r17, String r18, String r19, AgentRunUiState r20, List r21, String r22, boolean r23, String r24, String r25, String r26, List r27, AgentRunSecondaryListStyle r28, int r29, DefaultConstructorMarker r30) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r21, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        if ((r29 & 16) == 0) goto L5;
        r1 = CollectionsKt.emptyList();
    L5:
        List r8 = r1;
        if ((r29 & 32) == 0) goto L8;
        String r9 = "";
    L10:
        if ((r29 & 64) == 0) goto L12;
        boolean r10 = false;
    L14:
        if ((r29 & 128) == 0) goto L16;
        String r11 = "";
    L18:
        if ((r29 & 256) == 0) goto L20;
        String r12 = "";
    L22:
        if ((r29 & 512) == 0) goto L24;
        String r13 = "";
    L26:
        if ((r29 & 1024) == 0) goto L28;
        r2 = CollectionsKt.emptyList();
    L28:
        List r14 = r2;
        if ((r29 & 2048) == 0) goto L31;
        AgentRunSecondaryListStyle r15 = AgentRunSecondaryListStyle.UNORDERED;
    L32:
        this(r17, r18, r19, r20, r8, r9, r10, r11, r12, r13, r14, r15);
        return;
    L31:
        r15 = r28;
        goto L32
    L24:
        r13 = r26;
        goto L26
    L20:
        r12 = r25;
        goto L22
    L16:
        r11 = r24;
        goto L18
    L12:
        r10 = r23;
        goto L14
    L8:
        r9 = r22;
        goto L10
    }

    public static /* synthetic */ n a(n r14, String r15, String r16, String r17, AgentRunUiState r18, List r19, String r20, boolean r21, String r22, String r23, String r24, List r25, AgentRunSecondaryListStyle r26, int r27, Object r28) {
        List<k> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        List<a> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        if ((r27 & 1) == 0) goto L5;
        String r4 = r14.f6836a;
    L7:
        if ((r27 & 2) == 0) goto L9;
        String r5 = r14.f6837b;
    L11:
        if ((r27 & 4) == 0) goto L13;
        String r6 = r14.c;
    L15:
        if ((r27 & 8) == 0) goto L17;
        AgentRunUiState r7 = r14.d;
    L19:
        if ((r27 & 16) == 0) goto L22;
        r2 = r14.e;
    L22:
        if ((r27 & 32) == 0) goto L24;
        String r8 = r14.f;
    L26:
        if ((r27 & 64) == 0) goto L28;
        boolean r9 = r14.g;
    L30:
        if ((r27 & 128) == 0) goto L32;
        String r10 = r14.h;
    L34:
        if ((r27 & 256) == 0) goto L36;
        String r11 = r14.i;
    L38:
        if ((r27 & 512) == 0) goto L40;
        String r12 = r14.j;
    L42:
        if ((r27 & 1024) == 0) goto L45;
        r3 = r14.k;
    L45:
        if ((r27 & 2048) == 0) goto L47;
        AgentRunSecondaryListStyle r1 = r14.l;
    L49:
        return r14.a(r4, r5, r6, r7, r2, r8, r9, r10, r11, r12, r3, r1);
    L47:
        r1 = r26;
        goto L49
    L40:
        r12 = r24;
        goto L42
    L36:
        r11 = r23;
        goto L38
    L32:
        r10 = r22;
        goto L34
    L28:
        r9 = r21;
        goto L30
    L24:
        r8 = r20;
        goto L26
    L17:
        r7 = r18;
        goto L19
    L13:
        r6 = r17;
        goto L15
    L9:
        r5 = r16;
        goto L11
    L5:
        r4 = r15;
        goto L7
    }

    public final n a(String r16, String r17, String r18, AgentRunUiState r19, List<k> r20, String r21, boolean r22, String r23, String r24, String r25, List<a> r26, AgentRunSecondaryListStyle r27) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r17, "title");
        Intrinsics.checkNotNullParameter(r18, "subtitle");
        Intrinsics.checkNotNullParameter(r19, "state");
        Intrinsics.checkNotNullParameter(r7, "groups");
        Intrinsics.checkNotNullParameter(r21, "contentMarkdown");
        Intrinsics.checkNotNullParameter(r23, "executionId");
        Intrinsics.checkNotNullParameter(r24, "stageId");
        Intrinsics.checkNotNullParameter(r25, "mobileSessionId");
        Intrinsics.checkNotNullParameter(r13, "activityItems");
        Intrinsics.checkNotNullParameter(r27, "secondaryListStyle");
        return new n(r16, r17, r18, r19, r7, r21, r22, r23, r24, r25, r13, r27);
    }

    public final String a() {
        return this.f6836a;
    }

    public final String b() {
        return this.f6837b;
    }

    public final String c() {
        return this.c;
    }

    public final AgentRunUiState d() {
        return this.d;
    }

    public final List<k> e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, n.class) == true) goto L8;
        return false;
    L8:
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f6836a, r6.f6836a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f6837b, r6.f6837b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r6.l) goto L44;
        return false;
    L44:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final boolean g() {
        return this.g;
    }

    public final String h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.f6836a.hashCode() * 31) + this.f6837b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Boolean.hashCode(this.g)) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode();
    }

    public final String i() {
        return this.i;
    }

    public final String j() {
        return this.j;
    }

    public final List<a> k() {
        return this.k;
    }

    public final AgentRunSecondaryListStyle l() {
        return this.l;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AgentRunUiStep(id=").append(this.f6836a).append(", title=").append(this.f6837b).append(", subtitle=").append(this.c).append(", state=").append(this.d).append(", groups=").append(this.e).append(", contentMarkdown=").append(this.f).append(", showCollapsedSubtitle=").append(this.g).append(", executionId=").append(this.h).append(", stageId=").append(this.i).append(", mobileSessionId=").append(this.j).append(", activityItems=").append(this.k).append(", secondaryListStyle=");
        r0.append(this.l).append(')');
        return r0.toString();
    }
}
