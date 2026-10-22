package com.obric.memorydata.memory.ui.automemory.settings;

import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b6\b\u0086\b\u0018\u0000 M2\u00020\u0001:\u0001MBÇ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\u000bHÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0005HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0015HÆ\u0003J\t\u0010D\u001a\u00020\u0015HÆ\u0003J\t\u0010E\u001a\u00020\u0018HÆ\u0003J\t\u0010F\u001a\u00020\u000bHÆ\u0003JÎ\u0001\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020\u000b2\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020\u0015HÖ\u0001J\t\u0010L\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010&R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010&R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0019\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010&R\u0011\u00103\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b3\u0010&¨\u0006N"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/DraftRule;", "", "editingRuleId", "", "title", "", "originalTitle", Params.CONTENT, "rewriteResult", "appPackages", "useClientModel", "", AILabCheckPermissionTask.KEY_SOURCE, "triggerMode", "cronExpression", "isPaused", "autoCaptureEnabled", "iconKey", "iconColorKey", "iconGenerateVersion", "activeStartMinute", "", "activeEndMinute", "memoryInfo", "Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;", "isFromPreset", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;Z)V", "getEditingRuleId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "()Ljava/lang/String;", "getOriginalTitle", "getContent", "getRewriteResult", "getAppPackages", "getUseClientModel", "()Z", "getSource", "getTriggerMode", "getCronExpression", "getAutoCaptureEnabled", "getIconKey", "getIconColorKey", "getIconGenerateVersion", "getActiveStartMinute", "()I", "getActiveEndMinute", "getMemoryInfo", "()Lcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;", "isAllDay", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/obric/memorydata/memory/ui/automemory/settings/MemoryInfo;Z)Lcom/obric/memorydata/memory/ui/automemory/settings/DraftRule;", "equals", "other", "hashCode", "toString", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10748a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f10749b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final boolean h;
    private final String i;
    private final String j;
    private final String k;
    private final boolean l;
    private final boolean m;
    private final String n;
    private final String o;
    private final String p;
    private final int q;
    private final int r;
    private final e s;
    private final boolean t;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/settings/DraftRule$Companion;", "", "<init>", "()V", "fromEntity", "Lcom/obric/memorydata/memory/ui/automemory/settings/DraftRule;", "entity", "Lcom/obric/memorydata/database/entity/MemoryRuleEntity;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final b a(MemoryRuleEntity r25) {
            Intrinsics.checkNotNullParameter(r25, "entity");
            String r7 = null;
            return new b(Long.valueOf(r25.getId()), r25.getTitle(), r25.getTitle(), r25.getContent(), r7, r25.getAppPackages(), r25.getUseClientModel(), r25.getSource(), r25.getTriggerMode(), r25.getCronExpression(), r25.isPaused(), r25.getAutoCaptureEnabled(), r25.getIconKey(), r25.getIconColorKey(), r25.getIconGenerateVersion(), r25.getActiveStartMinute(), r25.getActiveEndMinute(), e.f10753a.a(r25.getMemoryInfoJson()), r25.isFromPreset(), 16, null);
        }
    }

    static {
        f10748a = new a(null);
    }

    public b() {
        this(null, null, null, null, null, null, false, null, null, null, false, false, null, null, null, 0, 0, null, false, 524287, null);
    }

    public b(Long r15, String r16, String r17, String r18, String r19, String r20, boolean r21, String r22, String r23, String r24, boolean r25, boolean r26, String r27, String r28, String r29, int r30, int r31, e r32, boolean r33) {
        Intrinsics.checkNotNullParameter(r16, "title");
        Intrinsics.checkNotNullParameter(r17, "originalTitle");
        Intrinsics.checkNotNullParameter(r18, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r19, "rewriteResult");
        Intrinsics.checkNotNullParameter(r20, "appPackages");
        Intrinsics.checkNotNullParameter(r22, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r23, "triggerMode");
        Intrinsics.checkNotNullParameter(r24, "cronExpression");
        Intrinsics.checkNotNullParameter(r27, "iconKey");
        Intrinsics.checkNotNullParameter(r28, "iconColorKey");
        Intrinsics.checkNotNullParameter(r29, "iconGenerateVersion");
        Intrinsics.checkNotNullParameter(r32, "memoryInfo");
        this.f10749b = r15;
        this.c = r16;
        this.d = r17;
        this.e = r18;
        this.f = r19;
        this.g = r20;
        this.h = r21;
        this.i = r22;
        this.j = r23;
        this.k = r24;
        this.l = r25;
        this.m = r26;
        this.n = r27;
        this.o = r28;
        this.p = r29;
        this.q = r30;
        this.r = r31;
        this.s = r32;
        this.t = r33;
    }

    public /* synthetic */ b(Long r30, String r31, String r32, String r33, String r34, String r35, boolean r36, String r37, String r38, String r39, boolean r40, boolean r41, String r42, String r43, String r44, int r45, int r46, e r47, boolean r48, int r49, DefaultConstructorMarker r50) {
        if ((r49 & 1) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r49 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r49 & 4) == 0) goto L13;
        String r4 = r2;
    L15:
        if ((r49 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r49 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r49 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r49 & 64) == 0) goto L29;
        boolean r8 = false;
    L31:
        if ((r49 & 128) == 0) goto L33;
        String r10 = "";
    L35:
        if ((r49 & 256) == 0) goto L37;
        String r11 = "";
    L39:
        if ((r49 & 512) == 0) goto L41;
        String r12 = "";
    L43:
        if ((r49 & 1024) == 0) goto L45;
        boolean r13 = false;
    L47:
        if ((r49 & 2048) == 0) goto L49;
        boolean r14 = true;
    L51:
        if ((r49 & 4096) == 0) goto L53;
        String r15 = "";
    L55:
        if ((r49 & 8192) == 0) goto L57;
        String r9 = "";
    L59:
        if ((r49 & 16384) == 0) goto L61;
        String r3 = "";
    L62:
        int r17 = -1;
        if ((r49 & 32768) == 0) goto L65;
        int r16 = -1;
    L67:
        if ((r49 & 65536) != 0) goto L71;
        r17 = r46;
    L71:
        if ((r49 & 131072) == 0) goto L73;
        e r18 = new e(null, null, null, null, null, null, null, null, 255, null);
    L75:
        if ((r49 & 262144) == 0) goto L77;
        boolean r0 = false;
    L78:
        this(r1, r2, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15, r9, r3, r16, r17, r18, r0);
        return;
    L77:
        r0 = r48;
        goto L78
    L73:
        r18 = r47;
        goto L75
    L65:
        r16 = r45;
        goto L67
    L61:
        r3 = r44;
        goto L62
    L57:
        r9 = r43;
        goto L59
    L53:
        r15 = r42;
        goto L55
    L49:
        r14 = r41;
        goto L51
    L45:
        r13 = r40;
        goto L47
    L41:
        r12 = r39;
        goto L43
    L37:
        r11 = r38;
        goto L39
    L33:
        r10 = r37;
        goto L35
    L29:
        r8 = r36;
        goto L31
    L25:
        r7 = r35;
        goto L27
    L21:
        r6 = r34;
        goto L23
    L17:
        r5 = r33;
        goto L19
    L13:
        r4 = r32;
        goto L15
    L9:
        r2 = r31;
        goto L11
    L5:
        r1 = r30;
        goto L7
    }

    public static /* synthetic */ b a(b r17, Long r18, String r19, String r20, String r21, String r22, String r23, boolean r24, String r25, String r26, String r27, boolean r28, boolean r29, String r30, String r31, String r32, int r33, int r34, e r35, boolean r36, int r37, Object r38) {
        if ((r37 & 1) == 0) goto L5;
        Long r2 = r17.f10749b;
    L7:
        if ((r37 & 2) == 0) goto L9;
        String r3 = r17.c;
    L11:
        if ((r37 & 4) == 0) goto L13;
        String r4 = r17.d;
    L15:
        if ((r37 & 8) == 0) goto L17;
        String r5 = r17.e;
    L19:
        if ((r37 & 16) == 0) goto L21;
        String r6 = r17.f;
    L23:
        if ((r37 & 32) == 0) goto L25;
        String r7 = r17.g;
    L27:
        if ((r37 & 64) == 0) goto L29;
        boolean r8 = r17.h;
    L31:
        if ((r37 & 128) == 0) goto L33;
        String r9 = r17.i;
    L35:
        if ((r37 & 256) == 0) goto L37;
        String r10 = r17.j;
    L39:
        if ((r37 & 512) == 0) goto L41;
        String r11 = r17.k;
    L43:
        if ((r37 & 1024) == 0) goto L45;
        boolean r12 = r17.l;
    L47:
        if ((r37 & 2048) == 0) goto L49;
        boolean r13 = r17.m;
    L51:
        if ((r37 & 4096) == 0) goto L53;
        String r14 = r17.n;
    L55:
        if ((r37 & 8192) == 0) goto L57;
        String r15 = r17.o;
    L58:
        String r39 = r15;
        if ((r37 & 16384) == 0) goto L61;
        String r16 = r17.p;
    L62:
        String r310 = r16;
        if ((r37 & 32768) == 0) goto L65;
        int r110 = r17.q;
    L66:
        int r311 = r110;
        if ((r37 & 65536) == 0) goto L69;
        int r111 = r17.r;
    L70:
        int r312 = r111;
        if ((r37 & 131072) == 0) goto L73;
        e r112 = r17.s;
    L75:
        if ((r37 & 262144) == 0) goto L77;
        boolean r1 = r17.t;
    L79:
        return r17.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r39, r310, r311, r312, r112, r1);
    L77:
        r1 = r36;
        goto L79
    L73:
        r112 = r35;
        goto L75
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final b a(Long r22, String r23, String r24, String r25, String r26, String r27, boolean r28, String r29, String r30, String r31, boolean r32, boolean r33, String r34, String r35, String r36, int r37, int r38, e r39, boolean r40) {
        Intrinsics.checkNotNullParameter(r23, "title");
        Intrinsics.checkNotNullParameter(r24, "originalTitle");
        Intrinsics.checkNotNullParameter(r25, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r26, "rewriteResult");
        Intrinsics.checkNotNullParameter(r27, "appPackages");
        Intrinsics.checkNotNullParameter(r29, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r30, "triggerMode");
        Intrinsics.checkNotNullParameter(r31, "cronExpression");
        Intrinsics.checkNotNullParameter(r34, "iconKey");
        Intrinsics.checkNotNullParameter(r35, "iconColorKey");
        Intrinsics.checkNotNullParameter(r36, "iconGenerateVersion");
        Intrinsics.checkNotNullParameter(r39, "memoryInfo");
        return new b(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40);
    }

    public final Long a() {
        return this.f10749b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10749b, r6.f10749b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L27;
        return false;
    L27:
        if (this.h == r6.h) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.j, r6.j) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L39;
        return false;
    L39:
        if (this.l == r6.l) goto L42;
        return false;
    L42:
        if (this.m == r6.m) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.n, r6.n) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.o, r6.o) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.p, r6.p) == true) goto L54;
        return false;
    L54:
        if (this.q == r6.q) goto L57;
        return false;
    L57:
        if (this.r == r6.r) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.s, r6.s) == true) goto L63;
        return false;
    L63:
        if (this.t == r6.t) goto L65;
        return false;
    L65:
        return true;
    }

    public final String f() {
        return this.g;
    }

    public final boolean g() {
        return this.h;
    }

    public final String h() {
        return this.i;
    }

    public int hashCode() {
        Long r0 = this.f10749b;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((((((((((((((((((((((((((((((((r1 * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Boolean.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + Boolean.hashCode(this.l)) * 31) + Boolean.hashCode(this.m)) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode()) * 31) + Integer.hashCode(this.q)) * 31) + Integer.hashCode(this.r)) * 31) + this.s.hashCode()) * 31) + Boolean.hashCode(this.t);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String i() {
        return this.j;
    }

    public final String j() {
        return this.k;
    }

    public final boolean k() {
        return this.l;
    }

    public final boolean l() {
        return this.m;
    }

    public final String m() {
        return this.n;
    }

    public final String n() {
        return this.o;
    }

    public final String o() {
        return this.p;
    }

    public final int p() {
        return this.q;
    }

    public final int q() {
        return this.r;
    }

    public final e r() {
        return this.s;
    }

    public final boolean s() {
        return this.t;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("DraftRule(editingRuleId=").append(this.f10749b).append(", title=").append(this.c).append(", originalTitle=").append(this.d).append(", content=").append(this.e).append(", rewriteResult=").append(this.f).append(", appPackages=").append(this.g).append(", useClientModel=").append(this.h).append(", source=").append(this.i).append(", triggerMode=").append(this.j).append(", cronExpression=").append(this.k).append(", isPaused=").append(this.l).append(", autoCaptureEnabled=");
        r0.append(this.m).append(", iconKey=").append(this.n).append(", iconColorKey=").append(this.o).append(", iconGenerateVersion=").append(this.p).append(", activeStartMinute=").append(this.q).append(", activeEndMinute=").append(this.r).append(", memoryInfo=").append(this.s).append(", isFromPreset=").append(this.t).append(')');
        return r0.toString();
    }
}
