package com.obric.widget.host.runtime;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\ba\b\u0086\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001b\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001b¢\u0006\u0004\b \u0010!J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0011HÆ\u0003J\t\u0010l\u001a\u00020\u0013HÆ\u0003J\t\u0010m\u001a\u00020\u0013HÆ\u0003J\t\u0010n\u001a\u00020\u0013HÆ\u0003J\t\u0010o\u001a\u00020\u0013HÆ\u0003J\t\u0010p\u001a\u00020\u0013HÆ\u0003J\t\u0010q\u001a\u00020\u0019HÆ\u0003J\t\u0010r\u001a\u00020\u001bHÆ\u0003J\t\u0010s\u001a\u00020\u001bHÆ\u0003J\t\u0010t\u001a\u00020\u001bHÆ\u0003J\t\u0010u\u001a\u00020\u001bHÆ\u0003J\t\u0010v\u001a\u00020\u001bHÆ\u0003Jÿ\u0001\u0010w\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u001bHÆ\u0001J\u0013\u0010x\u001a\u00020\u00132\b\u0010y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010z\u001a\u00020\u0003HÖ\u0001J\t\u0010{\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010#\"\u0004\b%\u0010&R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010&R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010#\"\u0004\b4\u0010&R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010#\"\u0004\b6\u0010&R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010#\"\u0004\b8\u0010&R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010#\"\u0004\b:\u0010&R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010#\"\u0004\b<\u0010&R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010\u0014\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010B\"\u0004\bF\u0010DR\u001a\u0010\u0015\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DR\u001a\u0010\u0016\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010B\"\u0004\bJ\u0010DR\u001a\u0010\u0017\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010B\"\u0004\bL\u0010DR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010\u001c\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010R\"\u0004\bV\u0010TR\u001a\u0010\u001d\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010R\"\u0004\bX\u0010TR\u001a\u0010\u001e\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010R\"\u0004\bZ\u0010TR\u001a\u0010\u001f\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010R\"\u0004\b\\\u0010TR\u0013\u0010]\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b^\u0010*¨\u0006|"}, d2 = {"Lcom/obric/widget/host/runtime/WidgetInstanceRecord;", "", "hostWidgetInstanceId", "", "hostItemId", "appWidgetId", "hostId", "", "appletId", "widgetId", "definitionId", "screenId", "cellX", "cellY", "spanX", "spanY", "bindReason", "Lcom/obric/widget/host/runtime/WidgetBindReason;", "attached", "", "visible", "dirty", "destroyed", "hasRenderedContent", "lifecycleState", "Lcom/obric/widget/host/runtime/WidgetLifecycleState;", "dirtyVersion", "", "lastRenderedDirtyVersion", "lastAttachElapsedRealtime", "lastVisibleElapsedRealtime", "lastSuccessElapsedRealtime", "<init>", "(IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIILcom/obric/widget/host/runtime/WidgetBindReason;ZZZZZLcom/obric/widget/host/runtime/WidgetLifecycleState;JJJJJ)V", "getHostWidgetInstanceId", "()I", "getHostItemId", "setHostItemId", "(I)V", "getAppWidgetId", "setAppWidgetId", "getHostId", "()Ljava/lang/String;", "setHostId", "(Ljava/lang/String;)V", "getAppletId", "setAppletId", "getWidgetId", "setWidgetId", "getDefinitionId", "setDefinitionId", "getScreenId", "setScreenId", "getCellX", "setCellX", "getCellY", "setCellY", "getSpanX", "setSpanX", "getSpanY", "setSpanY", "getBindReason", "()Lcom/obric/widget/host/runtime/WidgetBindReason;", "setBindReason", "(Lcom/obric/widget/host/runtime/WidgetBindReason;)V", "getAttached", "()Z", "setAttached", "(Z)V", "getVisible", "setVisible", "getDirty", "setDirty", "getDestroyed", "setDestroyed", "getHasRenderedContent", "setHasRenderedContent", "getLifecycleState", "()Lcom/obric/widget/host/runtime/WidgetLifecycleState;", "setLifecycleState", "(Lcom/obric/widget/host/runtime/WidgetLifecycleState;)V", "getDirtyVersion", "()J", "setDirtyVersion", "(J)V", "getLastRenderedDirtyVersion", "setLastRenderedDirtyVersion", "getLastAttachElapsedRealtime", "setLastAttachElapsedRealtime", "getLastVisibleElapsedRealtime", "setLastVisibleElapsedRealtime", "getLastSuccessElapsedRealtime", "setLastSuccessElapsedRealtime", "widgetType", "getWidgetType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "equals", "other", "hashCode", "toString", "widget-host-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class WidgetInstanceRecord {
    private int appWidgetId;
    private String appletId;
    private boolean attached;
    private WidgetBindReason bindReason;
    private int cellX;
    private int cellY;
    private String definitionId;
    private boolean destroyed;
    private boolean dirty;
    private long dirtyVersion;
    private boolean hasRenderedContent;
    private String hostId;
    private int hostItemId;
    private final int hostWidgetInstanceId;
    private long lastAttachElapsedRealtime;
    private long lastRenderedDirtyVersion;
    private long lastSuccessElapsedRealtime;
    private long lastVisibleElapsedRealtime;
    private WidgetLifecycleState lifecycleState;
    private int screenId;
    private int spanX;
    private int spanY;
    private boolean visible;
    private String widgetId;

    public WidgetInstanceRecord(int r10, int r11, int r12, String r13, String r14, String r15, String r16, int r17, int r18, int r19, int r110, int r111, WidgetBindReason r112, boolean r113, boolean r20, boolean r21, boolean r22, boolean r23, WidgetLifecycleState r24, long r25, long r27, long r29, long r31, long r33) {
        Intrinsics.checkNotNullParameter(r13, "hostId");
        Intrinsics.checkNotNullParameter(r112, "bindReason");
        Intrinsics.checkNotNullParameter(r24, "lifecycleState");
        this.hostWidgetInstanceId = r10;
        this.hostItemId = r11;
        this.appWidgetId = r12;
        this.hostId = r13;
        this.appletId = r14;
        this.widgetId = r15;
        this.definitionId = r16;
        this.screenId = r17;
        this.cellX = r18;
        this.cellY = r19;
        this.spanX = r110;
        this.spanY = r111;
        this.bindReason = r112;
        this.attached = r113;
        this.visible = r20;
        this.dirty = r21;
        this.destroyed = r22;
        this.hasRenderedContent = r23;
        this.lifecycleState = r24;
        this.dirtyVersion = r25;
        this.lastRenderedDirtyVersion = r27;
        this.lastAttachElapsedRealtime = r29;
        this.lastVisibleElapsedRealtime = r31;
        this.lastSuccessElapsedRealtime = r33;
    }

    public static /* synthetic */ WidgetInstanceRecord copy$default(WidgetInstanceRecord r17, int r18, int r19, int r20, String r21, String r22, String r23, String r24, int r25, int r26, int r27, int r28, int r29, WidgetBindReason r30, boolean r31, boolean r32, boolean r33, boolean r34, boolean r35, WidgetLifecycleState r36, long r37, long r39, long r41, long r43, long r45, int r47, Object r48) {
        if ((r47 & 1) == 0) goto L5;
        int r5 = r17.hostWidgetInstanceId;
    L7:
        if ((r47 & 2) == 0) goto L9;
        int r10 = r17.hostItemId;
    L11:
        if ((r47 & 4) == 0) goto L13;
        int r11 = r17.appWidgetId;
    L15:
        if ((r47 & 8) == 0) goto L17;
        String r12 = r17.hostId;
    L19:
        if ((r47 & 16) == 0) goto L21;
        String r13 = r17.appletId;
    L23:
        if ((r47 & 32) == 0) goto L25;
        String r14 = r17.widgetId;
    L27:
        if ((r47 & 64) == 0) goto L29;
        String r15 = r17.definitionId;
    L31:
        if ((r47 & 128) == 0) goto L33;
        int r16 = r17.screenId;
    L35:
        if ((r47 & 256) == 0) goto L37;
        int r110 = r17.cellX;
    L39:
        if ((r47 & 512) == 0) goto L41;
        int r111 = r17.cellY;
    L43:
        if ((r47 & 1024) == 0) goto L45;
        int r112 = r17.spanX;
    L47:
        if ((r47 & 2048) == 0) goto L49;
        int r113 = r17.spanY;
    L51:
        if ((r47 & 4096) == 0) goto L53;
        WidgetBindReason r114 = r17.bindReason;
    L55:
        if ((r47 & 8192) == 0) goto L57;
        boolean r115 = r17.attached;
    L58:
        boolean r38 = r115;
        if ((r47 & 16384) == 0) goto L61;
        boolean r116 = r17.visible;
    L62:
        boolean r310 = r116;
        if ((r47 & 32768) == 0) goto L65;
        boolean r117 = r17.dirty;
    L66:
        boolean r311 = r117;
        if ((r47 & 65536) == 0) goto L69;
        boolean r118 = r17.destroyed;
    L70:
        boolean r312 = r118;
        if ((r47 & 131072) == 0) goto L73;
        boolean r119 = r17.hasRenderedContent;
    L74:
        boolean r313 = r119;
        if ((r47 & 262144) == 0) goto L77;
        WidgetLifecycleState r120 = r17.lifecycleState;
    L78:
        WidgetBindReason r314 = r114;
        WidgetLifecycleState r315 = r120;
        if ((r47 & 524288) == 0) goto L81;
        long r121 = r17.dirtyVersion;
    L82:
        long r316 = r121;
        if ((r47 & 1048576) == 0) goto L85;
        long r122 = r17.lastRenderedDirtyVersion;
    L86:
        long r317 = r122;
        if ((r47 & 2097152) == 0) goto L89;
        long r123 = r17.lastAttachElapsedRealtime;
    L90:
        long r42 = r123;
        if ((r47 & 4194304) == 0) goto L93;
        long r124 = r17.lastVisibleElapsedRealtime;
    L94:
        long r44 = r124;
        if ((r47 & 8388608) == 0) goto L97;
        long r125 = r17.lastSuccessElapsedRealtime;
    L99:
        return r17.copy(r5, r10, r11, r12, r13, r14, r15, r16, r110, r111, r112, r113, r314, r38, r310, r311, r312, r313, r315, r316, r317, r42, r44, r125);
    L97:
        r125 = r45;
        goto L99
    L93:
        r124 = r43;
        goto L94
    L89:
        r123 = r41;
        goto L90
    L85:
        r122 = r39;
        goto L86
    L81:
        r121 = r37;
        goto L82
    L77:
        r120 = r36;
        goto L78
    L73:
        r119 = r35;
        goto L74
    L69:
        r118 = r34;
        goto L70
    L65:
        r117 = r33;
        goto L66
    L61:
        r116 = r32;
        goto L62
    L57:
        r115 = r31;
        goto L58
    L53:
        r114 = r30;
        goto L55
    L49:
        r113 = r29;
        goto L51
    L45:
        r112 = r28;
        goto L47
    L41:
        r111 = r27;
        goto L43
    L37:
        r110 = r26;
        goto L39
    L33:
        r16 = r25;
        goto L35
    L29:
        r15 = r24;
        goto L31
    L25:
        r14 = r23;
        goto L27
    L21:
        r13 = r22;
        goto L23
    L17:
        r12 = r21;
        goto L19
    L13:
        r11 = r20;
        goto L15
    L9:
        r10 = r19;
        goto L11
    L5:
        r5 = r18;
        goto L7
    }

    public final int component1() {
        return this.hostWidgetInstanceId;
    }

    public final int component10() {
        return this.cellY;
    }

    public final int component11() {
        return this.spanX;
    }

    public final int component12() {
        return this.spanY;
    }

    public final WidgetBindReason component13() {
        return this.bindReason;
    }

    public final boolean component14() {
        return this.attached;
    }

    public final boolean component15() {
        return this.visible;
    }

    public final boolean component16() {
        return this.dirty;
    }

    public final boolean component17() {
        return this.destroyed;
    }

    public final boolean component18() {
        return this.hasRenderedContent;
    }

    public final WidgetLifecycleState component19() {
        return this.lifecycleState;
    }

    public final int component2() {
        return this.hostItemId;
    }

    public final long component20() {
        return this.dirtyVersion;
    }

    public final long component21() {
        return this.lastRenderedDirtyVersion;
    }

    public final long component22() {
        return this.lastAttachElapsedRealtime;
    }

    public final long component23() {
        return this.lastVisibleElapsedRealtime;
    }

    public final long component24() {
        return this.lastSuccessElapsedRealtime;
    }

    public final int component3() {
        return this.appWidgetId;
    }

    public final String component4() {
        return this.hostId;
    }

    public final String component5() {
        return this.appletId;
    }

    public final String component6() {
        return this.widgetId;
    }

    public final String component7() {
        return this.definitionId;
    }

    public final int component8() {
        return this.screenId;
    }

    public final int component9() {
        return this.cellX;
    }

    public final WidgetInstanceRecord copy(int r32, int r33, int r34, String r35, String r36, String r37, String r38, int r39, int r40, int r41, int r42, int r43, WidgetBindReason r44, boolean r45, boolean r46, boolean r47, boolean r48, boolean r49, WidgetLifecycleState r50, long r51, long r53, long r55, long r57, long r59) {
        Intrinsics.checkNotNullParameter(r35, "hostId");
        Intrinsics.checkNotNullParameter(r44, "bindReason");
        Intrinsics.checkNotNullParameter(r50, "lifecycleState");
        return new WidgetInstanceRecord(r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r53, r55, r57, r59);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof WidgetInstanceRecord) == true) goto L8;
        return false;
    L8:
        WidgetInstanceRecord r11 = (WidgetInstanceRecord) r10;
        if (this.hostWidgetInstanceId == r11.hostWidgetInstanceId) goto L12;
        return false;
    L12:
        if (this.hostItemId == r11.hostItemId) goto L15;
        return false;
    L15:
        if (this.appWidgetId == r11.appWidgetId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.hostId, r11.hostId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.appletId, r11.appletId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.widgetId, r11.widgetId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.definitionId, r11.definitionId) == true) goto L30;
        return false;
    L30:
        if (this.screenId == r11.screenId) goto L33;
        return false;
    L33:
        if (this.cellX == r11.cellX) goto L36;
        return false;
    L36:
        if (this.cellY == r11.cellY) goto L39;
        return false;
    L39:
        if (this.spanX == r11.spanX) goto L42;
        return false;
    L42:
        if (this.spanY == r11.spanY) goto L45;
        return false;
    L45:
        if (this.bindReason == r11.bindReason) goto L48;
        return false;
    L48:
        if (this.attached == r11.attached) goto L51;
        return false;
    L51:
        if (this.visible == r11.visible) goto L54;
        return false;
    L54:
        if (this.dirty == r11.dirty) goto L57;
        return false;
    L57:
        if (this.destroyed == r11.destroyed) goto L60;
        return false;
    L60:
        if (this.hasRenderedContent == r11.hasRenderedContent) goto L63;
        return false;
    L63:
        if (this.lifecycleState == r11.lifecycleState) goto L66;
        return false;
    L66:
        if (this.dirtyVersion == r11.dirtyVersion) goto L69;
        return false;
    L69:
        if (this.lastRenderedDirtyVersion == r11.lastRenderedDirtyVersion) goto L72;
        return false;
    L72:
        if (this.lastAttachElapsedRealtime == r11.lastAttachElapsedRealtime) goto L75;
        return false;
    L75:
        if (this.lastVisibleElapsedRealtime == r11.lastVisibleElapsedRealtime) goto L78;
        return false;
    L78:
        if (this.lastSuccessElapsedRealtime == r11.lastSuccessElapsedRealtime) goto L80;
        return false;
    L80:
        return true;
    }

    public final int getAppWidgetId() {
        return this.appWidgetId;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final boolean getAttached() {
        return this.attached;
    }

    public final WidgetBindReason getBindReason() {
        return this.bindReason;
    }

    public final int getCellX() {
        return this.cellX;
    }

    public final int getCellY() {
        return this.cellY;
    }

    public final String getDefinitionId() {
        return this.definitionId;
    }

    public final boolean getDestroyed() {
        return this.destroyed;
    }

    public final boolean getDirty() {
        return this.dirty;
    }

    public final long getDirtyVersion() {
        return this.dirtyVersion;
    }

    public final boolean getHasRenderedContent() {
        return this.hasRenderedContent;
    }

    public final String getHostId() {
        return this.hostId;
    }

    public final int getHostItemId() {
        return this.hostItemId;
    }

    public final int getHostWidgetInstanceId() {
        return this.hostWidgetInstanceId;
    }

    public final long getLastAttachElapsedRealtime() {
        return this.lastAttachElapsedRealtime;
    }

    public final long getLastRenderedDirtyVersion() {
        return this.lastRenderedDirtyVersion;
    }

    public final long getLastSuccessElapsedRealtime() {
        return this.lastSuccessElapsedRealtime;
    }

    public final long getLastVisibleElapsedRealtime() {
        return this.lastVisibleElapsedRealtime;
    }

    public final WidgetLifecycleState getLifecycleState() {
        return this.lifecycleState;
    }

    public final int getScreenId() {
        return this.screenId;
    }

    public final int getSpanX() {
        return this.spanX;
    }

    public final int getSpanY() {
        return this.spanY;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public final String getWidgetType() {
        return this.definitionId;
    }

    public int hashCode() {
        int r5 = androidx.constraintlayout.motion.widget.a.c(androidx.room.jarjarred.org.antlr.runtime.a.c(this.appWidgetId, androidx.room.jarjarred.org.antlr.runtime.a.c(this.hostItemId, Integer.hashCode(this.hostWidgetInstanceId) * 31, 31), 31), 31, this.hostId);
        String r10 = this.appletId;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.widgetId;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.definitionId;
        if (r17 == null) goto L15;
        r11 = r17.hashCode();
    L15:
        return Long.hashCode(this.lastSuccessElapsedRealtime) + androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.e(androidx.room.jarjarred.org.antlr.runtime.a.e((this.lifecycleState.hashCode() + androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.room.jarjarred.org.antlr.runtime.a.d(androidx.room.jarjarred.org.antlr.runtime.a.d((this.bindReason.hashCode() + androidx.room.jarjarred.org.antlr.runtime.a.c(this.spanY, androidx.room.jarjarred.org.antlr.runtime.a.c(this.spanX, androidx.room.jarjarred.org.antlr.runtime.a.c(this.cellY, androidx.room.jarjarred.org.antlr.runtime.a.c(this.cellX, androidx.room.jarjarred.org.antlr.runtime.a.c(this.screenId, (r16 + r11) * 31, 31), 31), 31), 31), 31)) * 31, 31, this.attached), 31, this.visible), 31, this.dirty), 31, this.destroyed), 31, this.hasRenderedContent)) * 31, this.dirtyVersion, 31), this.lastRenderedDirtyVersion, 31), this.lastAttachElapsedRealtime, 31), this.lastVisibleElapsedRealtime, 31);
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final void setAppWidgetId(int r5) {
        this.appWidgetId = r5;
    }

    public final void setAppletId(String r5) {
        this.appletId = r5;
    }

    public final void setAttached(boolean r5) {
        this.attached = r5;
    }

    public final void setBindReason(WidgetBindReason r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.bindReason = r5;
    }

    public final void setCellX(int r5) {
        this.cellX = r5;
    }

    public final void setCellY(int r5) {
        this.cellY = r5;
    }

    public final void setDefinitionId(String r5) {
        this.definitionId = r5;
    }

    public final void setDestroyed(boolean r5) {
        this.destroyed = r5;
    }

    public final void setDirty(boolean r5) {
        this.dirty = r5;
    }

    public final void setDirtyVersion(long r5) {
        this.dirtyVersion = r5;
    }

    public final void setHasRenderedContent(boolean r5) {
        this.hasRenderedContent = r5;
    }

    public final void setHostId(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.hostId = r5;
    }

    public final void setHostItemId(int r5) {
        this.hostItemId = r5;
    }

    public final void setLastAttachElapsedRealtime(long r5) {
        this.lastAttachElapsedRealtime = r5;
    }

    public final void setLastRenderedDirtyVersion(long r5) {
        this.lastRenderedDirtyVersion = r5;
    }

    public final void setLastSuccessElapsedRealtime(long r5) {
        this.lastSuccessElapsedRealtime = r5;
    }

    public final void setLastVisibleElapsedRealtime(long r5) {
        this.lastVisibleElapsedRealtime = r5;
    }

    public final void setLifecycleState(WidgetLifecycleState r5) {
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        this.lifecycleState = r5;
    }

    public final void setScreenId(int r5) {
        this.screenId = r5;
    }

    public final void setSpanX(int r5) {
        this.spanX = r5;
    }

    public final void setSpanY(int r5) {
        this.spanY = r5;
    }

    public final void setVisible(boolean r5) {
        this.visible = r5;
    }

    public final void setWidgetId(String r5) {
        this.widgetId = r5;
    }

    public String toString() {
        int r5 = this.hostWidgetInstanceId;
        int r10 = this.hostItemId;
        int r11 = this.appWidgetId;
        String r12 = this.hostId;
        String r13 = this.appletId;
        String r14 = this.widgetId;
        String r15 = this.definitionId;
        int r16 = this.screenId;
        int r17 = this.cellX;
        int r18 = this.cellY;
        int r19 = this.spanX;
        int r110 = this.spanY;
        WidgetBindReason r111 = this.bindReason;
        boolean r112 = this.attached;
        boolean r113 = this.visible;
        boolean r114 = this.dirty;
        boolean r115 = this.destroyed;
        boolean r116 = this.hasRenderedContent;
        WidgetLifecycleState r117 = this.lifecycleState;
        long r118 = this.dirtyVersion;
        long r119 = this.lastRenderedDirtyVersion;
        long r120 = this.lastAttachElapsedRealtime;
        long r121 = this.lastVisibleElapsedRealtime;
        long r122 = this.lastSuccessElapsedRealtime;
        StringBuilder r20 = j0.v("WidgetInstanceRecord(hostWidgetInstanceId=", r5, r10, ", hostItemId=", ", appWidgetId=");
        androidx.room.jarjarred.org.antlr.runtime.a.D(r20, r11, ", hostId=", r12, ", appletId=");
        androidx.constraintlayout.motion.widget.a.C(r20, r13, ", widgetId=", r14, ", definitionId=");
        r20.append(r15);
        r20.append(", screenId=");
        r20.append(r16);
        r20.append(", cellX=");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r20, r17, ", cellY=", r18, ", spanX=");
        androidx.room.jarjarred.org.antlr.runtime.a.C(r20, r19, ", spanY=", r110, ", bindReason=");
        r20.append(r111);
        r20.append(", attached=");
        r20.append(r112);
        r20.append(", visible=");
        r20.append(r113);
        r20.append(", dirty=");
        r20.append(r114);
        r20.append(", destroyed=");
        r20.append(r115);
        r20.append(", hasRenderedContent=");
        r20.append(r116);
        r20.append(", lifecycleState=");
        r20.append(r117);
        r20.append(", dirtyVersion=");
        r20.append(r118);
        kotlin.collections.a.o(r20, ", lastRenderedDirtyVersion=", r119, ", lastAttachElapsedRealtime=");
        r20.append(r120);
        kotlin.collections.a.o(r20, ", lastVisibleElapsedRealtime=", r121, ", lastSuccessElapsedRealtime=");
        return j0.o(r20, r122, ")");
    }

    public /* synthetic */ WidgetInstanceRecord(int r34, int r35, int r36, String r37, String r38, String r39, String r40, int r41, int r42, int r43, int r44, int r45, WidgetBindReason r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, WidgetLifecycleState r52, long r53, long r55, long r57, long r59, long r61, int r63, DefaultConstructorMarker r64) {
        if ((r63 & 8192) == 0) goto L5;
        boolean r17 = false;
    L7:
        if ((r63 & 16384) == 0) goto L9;
        boolean r18 = false;
    L11:
        if ((32768 & r63) == 0) goto L13;
        boolean r19 = false;
    L15:
        if ((65536 & r63) == 0) goto L17;
        boolean r20 = false;
    L19:
        if ((131072 & r63) == 0) goto L21;
        boolean r21 = false;
    L23:
        if ((262144 & r63) == 0) goto L25;
        WidgetLifecycleState r22 = WidgetLifecycleState.PERSISTED;
    L27:
        if ((524288 & r63) == 0) goto L29;
        long r23 = 0;
    L31:
        if ((1048576 & r63) == 0) goto L33;
        long r25 = 0;
    L35:
        if ((2097152 & r63) == 0) goto L37;
        long r27 = 0;
    L39:
        if ((4194304 & r63) == 0) goto L41;
        long r29 = 0;
    L43:
        if ((r63 & 8388608) == 0) goto L45;
        long r31 = 0;
    L46:
        this(r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r17, r18, r19, r20, r21, r22, r23, r25, r27, r29, r31);
        return;
    L45:
        r31 = r61;
        goto L46
    L41:
        r29 = r59;
        goto L43
    L37:
        r27 = r57;
        goto L39
    L33:
        r25 = r55;
        goto L35
    L29:
        r23 = r53;
        goto L31
    L25:
        r22 = r52;
        goto L27
    L21:
        r21 = r51;
        goto L23
    L17:
        r20 = r50;
        goto L19
    L13:
        r19 = r49;
        goto L15
    L9:
        r18 = r48;
        goto L11
    L5:
        r17 = r47;
        goto L7
    }
}
