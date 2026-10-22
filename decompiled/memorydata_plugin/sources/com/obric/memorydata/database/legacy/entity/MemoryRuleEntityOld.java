package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b^\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r¢\u0006\u0004\b \u0010!J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\t\u0010^\u001a\u00020\u0005HÆ\u0003J\t\u0010_\u001a\u00020\rHÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0005HÆ\u0003J\t\u0010b\u001a\u00020\u0005HÆ\u0003J\t\u0010c\u001a\u00020\u0005HÆ\u0003J\t\u0010d\u001a\u00020\u0005HÆ\u0003J\t\u0010e\u001a\u00020\rHÆ\u0003J\t\u0010f\u001a\u00020\rHÆ\u0003J\t\u0010g\u001a\u00020\rHÆ\u0003J\t\u0010h\u001a\u00020\rHÆ\u0003J\t\u0010i\u001a\u00020\u0018HÆ\u0003J\t\u0010j\u001a\u00020\u0018HÆ\u0003J\t\u0010k\u001a\u00020\u0018HÆ\u0003J\t\u0010l\u001a\u00020\u0005HÆ\u0003J\t\u0010m\u001a\u00020\u0005HÆ\u0003J\t\u0010n\u001a\u00020\u0005HÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\rHÆ\u0003J\u008d\u0002\u0010q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\rHÆ\u0001J\u0013\u0010r\u001a\u00020\r2\b\u0010s\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010t\u001a\u00020\u0018HÖ\u0001J\t\u0010u\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u001e\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010*R\u001e\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010%\"\u0004\b,\u0010*R\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010%\"\u0004\b.\u0010*R\u001e\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010*R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010#\"\u0004\b6\u00107R\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010%\"\u0004\b9\u0010*R\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010%\"\u0004\b;\u0010*R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010%\"\u0004\b=\u0010*R\u001e\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010%\"\u0004\b?\u0010*R\u001e\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u00102\"\u0004\b@\u00104R\u001e\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00102\"\u0004\bB\u00104R\u001e\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u00102\"\u0004\bC\u00104R\u001e\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00102\"\u0004\bE\u00104R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001e\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010G\"\u0004\bK\u0010IR\u001e\u0010\u001a\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010G\"\u0004\bM\u0010IR\u001e\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010%\"\u0004\bO\u0010*R\u001e\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010%\"\u0004\bQ\u0010*R\u001e\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010%\"\u0004\bS\u0010*R\u001e\u0010\u001e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010#\"\u0004\bU\u00107R\u0016\u0010\u001f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u00102¨\u0006v"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/MemoryRuleEntityOld;", "", OaidModel.KEY_ID, "", "title", "", Params.CONTENT, "appPackages", "imageFilterQuery", "imageFilterModelVersion", "clientModelQuery", "clientModelVersion", "useClientModel", "", "memoryCount", AILabCheckPermissionTask.KEY_SOURCE, "triggerMode", "cronExpression", "memoryInfoJson", "isPaused", "autoCaptureEnabled", "isFromPreset", "canDisplay", "ruleSettingsVersion", "", "activeStartMinute", "activeEndMinute", "iconKey", "iconColorKey", "iconGenerateVersion", "lastExposedAutoMemoryId", "personalDbSplitMigrated", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getContent", "getAppPackages", "getImageFilterQuery", "setImageFilterQuery", "(Ljava/lang/String;)V", "getImageFilterModelVersion", "setImageFilterModelVersion", "getClientModelQuery", "setClientModelQuery", "getClientModelVersion", "setClientModelVersion", "getUseClientModel", "()Z", "setUseClientModel", "(Z)V", "getMemoryCount", "setMemoryCount", "(J)V", "getSource", "setSource", "getTriggerMode", "setTriggerMode", "getCronExpression", "setCronExpression", "getMemoryInfoJson", "setMemoryInfoJson", "setPaused", "getAutoCaptureEnabled", "setAutoCaptureEnabled", "setFromPreset", "getCanDisplay", "setCanDisplay", "getRuleSettingsVersion", "()I", "setRuleSettingsVersion", "(I)V", "getActiveStartMinute", "setActiveStartMinute", "getActiveEndMinute", "setActiveEndMinute", "getIconKey", "setIconKey", "getIconColorKey", "setIconColorKey", "getIconGenerateVersion", "setIconGenerateVersion", "getLastExposedAutoMemoryId", "setLastExposedAutoMemoryId", "getPersonalDbSplitMigrated", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryRuleEntityOld {
    private int activeEndMinute;
    private int activeStartMinute;
    private final String appPackages;
    private boolean autoCaptureEnabled;
    private boolean canDisplay;
    private String clientModelQuery;
    private String clientModelVersion;
    private final String content;
    private String cronExpression;
    private String iconColorKey;
    private String iconGenerateVersion;
    private String iconKey;
    private final long id;
    private String imageFilterModelVersion;
    private String imageFilterQuery;
    private boolean isFromPreset;
    private boolean isPaused;
    private long lastExposedAutoMemoryId;
    private long memoryCount;
    private String memoryInfoJson;
    private final boolean personalDbSplitMigrated;
    private int ruleSettingsVersion;
    private String source;
    private final String title;
    private String triggerMode;
    private boolean useClientModel;

    public MemoryRuleEntityOld(long r17, String r19, String r20, String r21, String r22, String r23, String r24, String r25, boolean r26, long r27, String r29, String r30, String r31, String r32, boolean r33, boolean r34, boolean r35, boolean r36, int r37, int r38, int r39, String r40, String r41, String r42, long r43, boolean r45) {
        Intrinsics.checkNotNullParameter(r19, "title");
        Intrinsics.checkNotNullParameter(r20, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r21, "appPackages");
        Intrinsics.checkNotNullParameter(r22, "imageFilterQuery");
        Intrinsics.checkNotNullParameter(r23, "imageFilterModelVersion");
        Intrinsics.checkNotNullParameter(r24, "clientModelQuery");
        Intrinsics.checkNotNullParameter(r25, "clientModelVersion");
        Intrinsics.checkNotNullParameter(r29, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r30, "triggerMode");
        Intrinsics.checkNotNullParameter(r31, "cronExpression");
        Intrinsics.checkNotNullParameter(r32, "memoryInfoJson");
        Intrinsics.checkNotNullParameter(r40, "iconKey");
        Intrinsics.checkNotNullParameter(r41, "iconColorKey");
        Intrinsics.checkNotNullParameter(r42, "iconGenerateVersion");
        this.id = r17;
        this.title = r19;
        this.content = r20;
        this.appPackages = r21;
        this.imageFilterQuery = r22;
        this.imageFilterModelVersion = r23;
        this.clientModelQuery = r24;
        this.clientModelVersion = r25;
        this.useClientModel = r26;
        this.memoryCount = r27;
        this.source = r29;
        this.triggerMode = r30;
        this.cronExpression = r31;
        this.memoryInfoJson = r32;
        this.isPaused = r33;
        this.autoCaptureEnabled = r34;
        this.isFromPreset = r35;
        this.canDisplay = r36;
        this.ruleSettingsVersion = r37;
        this.activeStartMinute = r38;
        this.activeEndMinute = r39;
        this.iconKey = r40;
        this.iconColorKey = r41;
        this.iconGenerateVersion = r42;
        this.lastExposedAutoMemoryId = r43;
        this.personalDbSplitMigrated = r45;
    }

    public /* synthetic */ MemoryRuleEntityOld(long r35, String r37, String r38, String r39, String r40, String r41, String r42, String r43, boolean r44, long r45, String r47, String r48, String r49, String r50, boolean r51, boolean r52, boolean r53, boolean r54, int r55, int r56, int r57, String r58, String r59, String r60, long r61, boolean r63, int r64, DefaultConstructorMarker r65) {
        if ((r64 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r64 & 16) == 0) goto L9;
        String r10 = "";
    L11:
        if ((r64 & 32) == 0) goto L13;
        String r11 = "";
    L15:
        if ((r64 & 64) == 0) goto L17;
        String r12 = "";
    L19:
        if ((r64 & 128) == 0) goto L21;
        String r13 = "";
    L23:
        if ((r64 & 256) == 0) goto L25;
        boolean r14 = false;
    L27:
        if ((r64 & 512) == 0) goto L29;
        long r15 = 0;
    L31:
        if ((r64 & 1024) == 0) goto L33;
        String r17 = "";
    L35:
        if ((r64 & 2048) == 0) goto L37;
        String r18 = "";
    L39:
        if ((r64 & 4096) == 0) goto L41;
        String r19 = "";
    L43:
        if ((r64 & 8192) == 0) goto L45;
        String r20 = "";
    L47:
        if ((r64 & 16384) == 0) goto L49;
        boolean r21 = false;
    L51:
        if ((32768 & r64) == 0) goto L53;
        boolean r22 = true;
    L55:
        if ((65536 & r64) == 0) goto L57;
        boolean r23 = false;
    L59:
        if ((131072 & r64) == 0) goto L61;
        boolean r24 = true;
    L63:
        if ((262144 & r64) == 0) goto L65;
        int r25 = 0;
    L67:
        if ((524288 & r64) == 0) goto L69;
        int r26 = -1;
    L71:
        if ((1048576 & r64) == 0) goto L73;
        int r27 = -1;
    L75:
        if ((2097152 & r64) == 0) goto L77;
        String r28 = "";
    L79:
        if ((4194304 & r64) == 0) goto L81;
        String r29 = "";
    L83:
        if ((8388608 & r64) == 0) goto L85;
        String r30 = "";
    L87:
        if ((16777216 & r64) == 0) goto L89;
        long r31 = 0;
    L91:
        if ((r64 & 33554432) == 0) goto L93;
        boolean r33 = false;
    L94:
        this(r5, r37, r38, r39, r10, r11, r12, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r33);
        return;
    L93:
        r33 = r63;
        goto L94
    L89:
        r31 = r61;
        goto L91
    L85:
        r30 = r60;
        goto L87
    L81:
        r29 = r59;
        goto L83
    L77:
        r28 = r58;
        goto L79
    L73:
        r27 = r57;
        goto L75
    L69:
        r26 = r56;
        goto L71
    L65:
        r25 = r55;
        goto L67
    L61:
        r24 = r54;
        goto L63
    L57:
        r23 = r53;
        goto L59
    L53:
        r22 = r52;
        goto L55
    L49:
        r21 = r51;
        goto L51
    L45:
        r20 = r50;
        goto L47
    L41:
        r19 = r49;
        goto L43
    L37:
        r18 = r48;
        goto L39
    L33:
        r17 = r47;
        goto L35
    L29:
        r15 = r45;
        goto L31
    L25:
        r14 = r44;
        goto L27
    L21:
        r13 = r43;
        goto L23
    L17:
        r12 = r42;
        goto L19
    L13:
        r11 = r41;
        goto L15
    L9:
        r10 = r40;
        goto L11
    L5:
        r5 = r35;
        goto L7
    }

    public static /* synthetic */ MemoryRuleEntityOld copy$default(MemoryRuleEntityOld r17, long r18, String r20, String r21, String r22, String r23, String r24, String r25, String r26, boolean r27, long r28, String r30, String r31, String r32, String r33, boolean r34, boolean r35, boolean r36, boolean r37, int r38, int r39, int r40, String r41, String r42, String r43, long r44, boolean r46, int r47, Object r48) {
        if ((r47 & 1) == 0) goto L5;
        long r2 = r17.id;
    L7:
        if ((r47 & 2) == 0) goto L9;
        String r4 = r17.title;
    L11:
        if ((r47 & 4) == 0) goto L13;
        String r5 = r17.content;
    L15:
        if ((r47 & 8) == 0) goto L17;
        String r6 = r17.appPackages;
    L19:
        if ((r47 & 16) == 0) goto L21;
        String r7 = r17.imageFilterQuery;
    L23:
        if ((r47 & 32) == 0) goto L25;
        String r8 = r17.imageFilterModelVersion;
    L27:
        if ((r47 & 64) == 0) goto L29;
        String r9 = r17.clientModelQuery;
    L31:
        if ((r47 & 128) == 0) goto L33;
        String r10 = r17.clientModelVersion;
    L35:
        if ((r47 & 256) == 0) goto L37;
        boolean r11 = r17.useClientModel;
    L39:
        if ((r47 & 512) == 0) goto L41;
        long r12 = r17.memoryCount;
    L43:
        if ((r47 & 1024) == 0) goto L45;
        String r14 = r17.source;
    L47:
        if ((r47 & 2048) == 0) goto L49;
        String r15 = r17.triggerMode;
    L50:
        String r310 = r15;
        if ((r47 & 4096) == 0) goto L53;
        String r16 = r17.cronExpression;
    L54:
        String r311 = r16;
        if ((r47 & 8192) == 0) goto L57;
        String r19 = r17.memoryInfoJson;
    L58:
        String r312 = r19;
        if ((r47 & 16384) == 0) goto L61;
        boolean r110 = r17.isPaused;
    L62:
        boolean r313 = r110;
        if ((r47 & 32768) == 0) goto L65;
        boolean r111 = r17.autoCaptureEnabled;
    L66:
        boolean r314 = r111;
        if ((r47 & 65536) == 0) goto L69;
        boolean r112 = r17.isFromPreset;
    L70:
        boolean r315 = r112;
        if ((r47 & 131072) == 0) goto L73;
        boolean r113 = r17.canDisplay;
    L74:
        boolean r316 = r113;
        if ((r47 & 262144) == 0) goto L77;
        int r114 = r17.ruleSettingsVersion;
    L78:
        int r317 = r114;
        if ((r47 & 524288) == 0) goto L81;
        int r115 = r17.activeStartMinute;
    L82:
        int r318 = r115;
        if ((r47 & 1048576) == 0) goto L85;
        int r116 = r17.activeEndMinute;
    L86:
        int r45 = r116;
        if ((r47 & 2097152) == 0) goto L89;
        String r117 = r17.iconKey;
    L90:
        String r49 = r117;
        if ((r47 & 4194304) == 0) goto L93;
        String r118 = r17.iconColorKey;
    L94:
        String r410 = r118;
        if ((r47 & 8388608) == 0) goto L97;
        String r119 = r17.iconGenerateVersion;
    L98:
        String r319 = r14;
        String r411 = r119;
        if ((r47 & 16777216) == 0) goto L101;
        long r120 = r17.lastExposedAutoMemoryId;
    L103:
        if ((r47 & 33554432) == 0) goto L105;
        boolean r1 = r17.personalDbSplitMigrated;
    L107:
        return r17.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r319, r310, r311, r312, r313, r314, r315, r316, r317, r318, r45, r49, r410, r411, r120, r1);
    L105:
        r1 = r46;
        goto L107
    L101:
        r120 = r44;
        goto L103
    L97:
        r119 = r43;
        goto L98
    L93:
        r118 = r42;
        goto L94
    L89:
        r117 = r41;
        goto L90
    L85:
        r116 = r40;
        goto L86
    L81:
        r115 = r39;
        goto L82
    L77:
        r114 = r38;
        goto L78
    L73:
        r113 = r37;
        goto L74
    L69:
        r112 = r36;
        goto L70
    L65:
        r111 = r35;
        goto L66
    L61:
        r110 = r34;
        goto L62
    L57:
        r19 = r33;
        goto L58
    L53:
        r16 = r32;
        goto L54
    L49:
        r15 = r31;
        goto L50
    L45:
        r14 = r30;
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

    public final long component1() {
        return this.id;
    }

    public final long component10() {
        return this.memoryCount;
    }

    public final String component11() {
        return this.source;
    }

    public final String component12() {
        return this.triggerMode;
    }

    public final String component13() {
        return this.cronExpression;
    }

    public final String component14() {
        return this.memoryInfoJson;
    }

    public final boolean component15() {
        return this.isPaused;
    }

    public final boolean component16() {
        return this.autoCaptureEnabled;
    }

    public final boolean component17() {
        return this.isFromPreset;
    }

    public final boolean component18() {
        return this.canDisplay;
    }

    public final int component19() {
        return this.ruleSettingsVersion;
    }

    public final String component2() {
        return this.title;
    }

    public final int component20() {
        return this.activeStartMinute;
    }

    public final int component21() {
        return this.activeEndMinute;
    }

    public final String component22() {
        return this.iconKey;
    }

    public final String component23() {
        return this.iconColorKey;
    }

    public final String component24() {
        return this.iconGenerateVersion;
    }

    public final long component25() {
        return this.lastExposedAutoMemoryId;
    }

    public final boolean component26() {
        return this.personalDbSplitMigrated;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.appPackages;
    }

    public final String component5() {
        return this.imageFilterQuery;
    }

    public final String component6() {
        return this.imageFilterModelVersion;
    }

    public final String component7() {
        return this.clientModelQuery;
    }

    public final String component8() {
        return this.clientModelVersion;
    }

    public final boolean component9() {
        return this.useClientModel;
    }

    public final MemoryRuleEntityOld copy(long r32, String r34, String r35, String r36, String r37, String r38, String r39, String r40, boolean r41, long r42, String r44, String r45, String r46, String r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, String r55, String r56, String r57, long r58, boolean r60) {
        Intrinsics.checkNotNullParameter(r34, "title");
        Intrinsics.checkNotNullParameter(r35, Params.CONTENT);
        Intrinsics.checkNotNullParameter(r36, "appPackages");
        Intrinsics.checkNotNullParameter(r37, "imageFilterQuery");
        Intrinsics.checkNotNullParameter(r38, "imageFilterModelVersion");
        Intrinsics.checkNotNullParameter(r39, "clientModelQuery");
        Intrinsics.checkNotNullParameter(r40, "clientModelVersion");
        Intrinsics.checkNotNullParameter(r44, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r45, "triggerMode");
        Intrinsics.checkNotNullParameter(r46, "cronExpression");
        Intrinsics.checkNotNullParameter(r47, "memoryInfoJson");
        Intrinsics.checkNotNullParameter(r55, "iconKey");
        Intrinsics.checkNotNullParameter(r56, "iconColorKey");
        Intrinsics.checkNotNullParameter(r57, "iconGenerateVersion");
        return new MemoryRuleEntityOld(r32, r34, r35, r36, r37, r38, r39, r40, r41, r42, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r60);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, MemoryRuleEntityOld.class) == true) goto L8;
        return false;
    L8:
        MemoryRuleEntityOld r10 = (MemoryRuleEntityOld) ZeusTransformUtils.preCheckCast(r9, MemoryRuleEntityOld.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r10.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appPackages, r10.appPackages) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.imageFilterQuery, r10.imageFilterQuery) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.imageFilterModelVersion, r10.imageFilterModelVersion) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.clientModelQuery, r10.clientModelQuery) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.clientModelVersion, r10.clientModelVersion) == true) goto L33;
        return false;
    L33:
        if (this.useClientModel == r10.useClientModel) goto L36;
        return false;
    L36:
        if (this.memoryCount == r10.memoryCount) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.source, r10.source) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.triggerMode, r10.triggerMode) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.cronExpression, r10.cronExpression) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.memoryInfoJson, r10.memoryInfoJson) == true) goto L51;
        return false;
    L51:
        if (this.isPaused == r10.isPaused) goto L54;
        return false;
    L54:
        if (this.autoCaptureEnabled == r10.autoCaptureEnabled) goto L57;
        return false;
    L57:
        if (this.isFromPreset == r10.isFromPreset) goto L60;
        return false;
    L60:
        if (this.canDisplay == r10.canDisplay) goto L63;
        return false;
    L63:
        if (this.ruleSettingsVersion == r10.ruleSettingsVersion) goto L66;
        return false;
    L66:
        if (this.activeStartMinute == r10.activeStartMinute) goto L69;
        return false;
    L69:
        if (this.activeEndMinute == r10.activeEndMinute) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.iconKey, r10.iconKey) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.iconColorKey, r10.iconColorKey) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.iconGenerateVersion, r10.iconGenerateVersion) == true) goto L81;
        return false;
    L81:
        if (this.lastExposedAutoMemoryId == r10.lastExposedAutoMemoryId) goto L84;
        return false;
    L84:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L86;
        return false;
    L86:
        return true;
    }

    public final int getActiveEndMinute() {
        return this.activeEndMinute;
    }

    public final int getActiveStartMinute() {
        return this.activeStartMinute;
    }

    public final String getAppPackages() {
        return this.appPackages;
    }

    public final boolean getAutoCaptureEnabled() {
        return this.autoCaptureEnabled;
    }

    public final boolean getCanDisplay() {
        return this.canDisplay;
    }

    public final String getClientModelQuery() {
        return this.clientModelQuery;
    }

    public final String getClientModelVersion() {
        return this.clientModelVersion;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getCronExpression() {
        return this.cronExpression;
    }

    public final String getIconColorKey() {
        return this.iconColorKey;
    }

    public final String getIconGenerateVersion() {
        return this.iconGenerateVersion;
    }

    public final String getIconKey() {
        return this.iconKey;
    }

    public final long getId() {
        return this.id;
    }

    public final String getImageFilterModelVersion() {
        return this.imageFilterModelVersion;
    }

    public final String getImageFilterQuery() {
        return this.imageFilterQuery;
    }

    public final long getLastExposedAutoMemoryId() {
        return this.lastExposedAutoMemoryId;
    }

    public final long getMemoryCount() {
        return this.memoryCount;
    }

    public final String getMemoryInfoJson() {
        return this.memoryInfoJson;
    }

    public final boolean getPersonalDbSplitMigrated() {
        return this.personalDbSplitMigrated;
    }

    public final int getRuleSettingsVersion() {
        return this.ruleSettingsVersion;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTriggerMode() {
        return this.triggerMode;
    }

    public final boolean getUseClientModel() {
        return this.useClientModel;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + this.appPackages.hashCode()) * 31) + this.imageFilterQuery.hashCode()) * 31) + this.imageFilterModelVersion.hashCode()) * 31) + this.clientModelQuery.hashCode()) * 31) + this.clientModelVersion.hashCode()) * 31) + Boolean.hashCode(this.useClientModel)) * 31) + Long.hashCode(this.memoryCount)) * 31) + this.source.hashCode()) * 31) + this.triggerMode.hashCode()) * 31) + this.cronExpression.hashCode()) * 31) + this.memoryInfoJson.hashCode()) * 31) + Boolean.hashCode(this.isPaused)) * 31) + Boolean.hashCode(this.autoCaptureEnabled)) * 31) + Boolean.hashCode(this.isFromPreset)) * 31) + Boolean.hashCode(this.canDisplay)) * 31) + Integer.hashCode(this.ruleSettingsVersion)) * 31) + Integer.hashCode(this.activeStartMinute)) * 31) + Integer.hashCode(this.activeEndMinute)) * 31) + this.iconKey.hashCode()) * 31) + this.iconColorKey.hashCode()) * 31) + this.iconGenerateVersion.hashCode()) * 31) + Long.hashCode(this.lastExposedAutoMemoryId)) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
    }

    public final boolean isFromPreset() {
        return this.isFromPreset;
    }

    public final boolean isPaused() {
        return this.isPaused;
    }

    public final void setActiveEndMinute(int r1) {
        this.activeEndMinute = r1;
    }

    public final void setActiveStartMinute(int r1) {
        this.activeStartMinute = r1;
    }

    public final void setAutoCaptureEnabled(boolean r1) {
        this.autoCaptureEnabled = r1;
    }

    public final void setCanDisplay(boolean r1) {
        this.canDisplay = r1;
    }

    public final void setClientModelQuery(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.clientModelQuery = r2;
    }

    public final void setClientModelVersion(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.clientModelVersion = r2;
    }

    public final void setCronExpression(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.cronExpression = r2;
    }

    public final void setFromPreset(boolean r1) {
        this.isFromPreset = r1;
    }

    public final void setIconColorKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.iconColorKey = r2;
    }

    public final void setIconGenerateVersion(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.iconGenerateVersion = r2;
    }

    public final void setIconKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.iconKey = r2;
    }

    public final void setImageFilterModelVersion(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.imageFilterModelVersion = r2;
    }

    public final void setImageFilterQuery(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.imageFilterQuery = r2;
    }

    public final void setLastExposedAutoMemoryId(long r1) {
        this.lastExposedAutoMemoryId = r1;
    }

    public final void setMemoryCount(long r1) {
        this.memoryCount = r1;
    }

    public final void setMemoryInfoJson(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.memoryInfoJson = r2;
    }

    public final void setPaused(boolean r1) {
        this.isPaused = r1;
    }

    public final void setRuleSettingsVersion(int r1) {
        this.ruleSettingsVersion = r1;
    }

    public final void setSource(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.source = r2;
    }

    public final void setTriggerMode(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.triggerMode = r2;
    }

    public final void setUseClientModel(boolean r1) {
        this.useClientModel = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("MemoryRuleEntityOld(id=").append(this.id).append(", title=").append(this.title).append(", content=").append(this.content).append(", appPackages=").append(this.appPackages).append(", imageFilterQuery=").append(this.imageFilterQuery).append(", imageFilterModelVersion=").append(this.imageFilterModelVersion).append(", clientModelQuery=").append(this.clientModelQuery).append(", clientModelVersion=").append(this.clientModelVersion).append(", useClientModel=").append(this.useClientModel).append(", memoryCount=").append(this.memoryCount).append(", source=").append(this.source).append(", triggerMode=");
        r0.append(this.triggerMode).append(", cronExpression=").append(this.cronExpression).append(", memoryInfoJson=").append(this.memoryInfoJson).append(", isPaused=").append(this.isPaused).append(", autoCaptureEnabled=").append(this.autoCaptureEnabled).append(", isFromPreset=").append(this.isFromPreset).append(", canDisplay=").append(this.canDisplay).append(", ruleSettingsVersion=").append(this.ruleSettingsVersion).append(", activeStartMinute=").append(this.activeStartMinute).append(", activeEndMinute=").append(this.activeEndMinute).append(", iconKey=").append(this.iconKey).append(", iconColorKey=").append(this.iconColorKey);
        r0.append(", iconGenerateVersion=").append(this.iconGenerateVersion).append(", lastExposedAutoMemoryId=").append(this.lastExposedAutoMemoryId).append(", personalDbSplitMigrated=").append(this.personalDbSplitMigrated).append(')');
        return r0.toString();
    }
}
