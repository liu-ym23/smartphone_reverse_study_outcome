package com.ss.android.lark.chameleonv2.lkapi.env;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u0019\u0010G\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\u0007HÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0005HÆ\u0003J\u009d\u0002\u0010W\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0005HÆ\u0001J\u0013\u0010X\u001a\u00020\u00072\b\u0010Y\u001a\u0004\u0018\u00010ZHÖ\u0003J\t\u0010[\u001a\u00020\u0005HÖ\u0001J\t\u0010\\\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010)R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u0014\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u0010)R\u0011\u0010\u0015\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0013\u0010\u0016\u001a\u00020\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010)R\u0013\u0010\u0017\u001a\u00020\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010)R\u0013\u0010\u0018\u001a\u00020\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010)R\u0013\u0010\u0019\u001a\u00020\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010)R\u0013\u0010\u001a\u001a\u00020\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010)R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010'¨\u0006]"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$Property;", "Lcom/bytedance/ee/util/io/NonProguard;", "appChannel", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_APP_ID, BuildConfig.FLAVOR, "boeHeaderWithXUseBoe", BuildConfig.FLAVOR, "boeRPCPersistDyecpFDKey", "boeRPCPersistDyecpFDValue", "boeTTFeatureEnv", "boeUnit", "boeUseBOE", "boeWithExtraHeader", "clientUnit", "customSchema", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleonv2/lkapi/env/IEnv$CustomSchema;", "Lkotlin/collections/ArrayList;", "deployMode", "firstRunAfterInstall", "forceSaasLogin", "isDev", "isKA", "isMAS", "isOfficialRelease", "isOverseaPkg", "kaChannel", "logFilter", "logLevel", "nodeEnv", Keys.CMD_BIND_PACKAGE_NAME, "pasChannel", "versionCode", "<init>", "(Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;ZZZZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAppChannel", "()Ljava/lang/String;", "getAppId", "()I", "getBoeHeaderWithXUseBoe", "()Z", "getBoeRPCPersistDyecpFDKey", "getBoeRPCPersistDyecpFDValue", "getBoeTTFeatureEnv", "getBoeUnit", "getBoeUseBOE", "getBoeWithExtraHeader", "getClientUnit", "getCustomSchema", "()Ljava/util/ArrayList;", "getDeployMode", "getFirstRunAfterInstall", "getForceSaasLogin", "getKaChannel", "getLogFilter", "getLogLevel", "getNodeEnv", "getPackageName", "getPasChannel", "getVersionCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IEnv$Property implements NonProguard {
    private final String appChannel;
    private final int appId;
    private final boolean boeHeaderWithXUseBoe;
    private final String boeRPCPersistDyecpFDKey;
    private final String boeRPCPersistDyecpFDValue;
    private final String boeTTFeatureEnv;
    private final String boeUnit;
    private final boolean boeUseBOE;
    private final boolean boeWithExtraHeader;
    private final String clientUnit;
    private final ArrayList<IEnv$CustomSchema> customSchema;
    private final String deployMode;
    private final boolean firstRunAfterInstall;
    private final boolean forceSaasLogin;
    private final boolean isDev;
    private final boolean isKA;
    private final boolean isMAS;
    private final boolean isOfficialRelease;
    private final boolean isOverseaPkg;
    private final String kaChannel;
    private final String logFilter;
    private final String logLevel;
    private final String nodeEnv;
    private final String packageName;
    private final String pasChannel;
    private final int versionCode;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IEnv$Property copy$default(IEnv$Property r17, String r18, int r19, boolean r20, String r21, String r22, String r23, String r24, boolean r25, boolean r26, String r27, ArrayList r28, String r29, boolean r30, boolean r31, boolean r32, boolean r33, boolean r34, boolean r35, boolean r36, String r37, String r38, String r39, String r40, String r41, String r42, int r43, int r44, Object r45) {
        if ((r44 & 1) == 0) goto L5;
        String r2 = r17.appChannel;
    L7:
        if ((r44 & 2) == 0) goto L9;
        int r3 = r17.appId;
    L11:
        if ((r44 & 4) == 0) goto L13;
        boolean r4 = r17.boeHeaderWithXUseBoe;
    L15:
        if ((r44 & 8) == 0) goto L17;
        String r5 = r17.boeRPCPersistDyecpFDKey;
    L19:
        if ((r44 & 16) == 0) goto L21;
        String r6 = r17.boeRPCPersistDyecpFDValue;
    L23:
        if ((r44 & 32) == 0) goto L25;
        String r7 = r17.boeTTFeatureEnv;
    L27:
        if ((r44 & 64) == 0) goto L29;
        String r8 = r17.boeUnit;
    L31:
        if ((r44 & 128) == 0) goto L33;
        boolean r9 = r17.boeUseBOE;
    L35:
        if ((r44 & 256) == 0) goto L37;
        boolean r10 = r17.boeWithExtraHeader;
    L39:
        if ((r44 & 512) == 0) goto L41;
        String r11 = r17.clientUnit;
    L43:
        if ((r44 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        ArrayList r12 = r17.customSchema;
    L47:
        if ((r44 & 2048) == 0) goto L49;
        String r13 = r17.deployMode;
    L51:
        if ((r44 & 4096) == 0) goto L53;
        boolean r14 = r17.firstRunAfterInstall;
    L55:
        if ((r44 & 8192) == 0) goto L57;
        boolean r15 = r17.forceSaasLogin;
    L58:
        boolean r310 = r15;
        if ((r44 & 16384) == 0) goto L61;
        boolean r16 = r17.isDev;
    L62:
        boolean r311 = r16;
        if ((r44 & 32768) == 0) goto L65;
        boolean r110 = r17.isKA;
    L66:
        boolean r312 = r110;
        if ((r44 & 65536) == 0) goto L69;
        boolean r111 = r17.isMAS;
    L70:
        boolean r313 = r111;
        if ((r44 & 131072) == 0) goto L73;
        boolean r112 = r17.isOfficialRelease;
    L74:
        boolean r314 = r112;
        if ((r44 & 262144) == 0) goto L77;
        boolean r113 = r17.isOverseaPkg;
    L78:
        boolean r315 = r113;
        if ((r44 & 524288) == 0) goto L81;
        String r114 = r17.kaChannel;
    L82:
        String r316 = r114;
        if ((r44 & 1048576) == 0) goto L85;
        String r115 = r17.logFilter;
    L86:
        String r317 = r115;
        if ((r44 & Bridge.TRANSFER_MAX_SIZE) == 0) goto L89;
        String r116 = r17.logLevel;
    L90:
        String r318 = r116;
        if ((r44 & 4194304) == 0) goto L93;
        String r117 = r17.nodeEnv;
    L94:
        String r46 = r117;
        if ((r44 & 8388608) == 0) goto L97;
        String r118 = r17.packageName;
    L98:
        String r47 = r118;
        if ((r44 & 16777216) == 0) goto L101;
        String r119 = r17.pasChannel;
    L103:
        if ((r44 & 33554432) == 0) goto L105;
        int r1 = r17.versionCode;
    L107:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r318, r46, r47, r119, r1);
    L105:
        r1 = r43;
        goto L107
    L101:
        r119 = r42;
        goto L103
    L97:
        r118 = r41;
        goto L98
    L93:
        r117 = r40;
        goto L94
    L89:
        r116 = r39;
        goto L90
    L85:
        r115 = r38;
        goto L86
    L81:
        r114 = r37;
        goto L82
    L77:
        r113 = r36;
        goto L78
    L73:
        r112 = r35;
        goto L74
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

    public final String component1() {
        return this.appChannel;
    }

    public final String component10() {
        return this.clientUnit;
    }

    public final ArrayList<IEnv$CustomSchema> component11() {
        return this.customSchema;
    }

    public final String component12() {
        return this.deployMode;
    }

    public final boolean component13() {
        return this.firstRunAfterInstall;
    }

    public final boolean component14() {
        return this.forceSaasLogin;
    }

    public final boolean component15() {
        return this.isDev;
    }

    public final boolean component16() {
        return this.isKA;
    }

    public final boolean component17() {
        return this.isMAS;
    }

    public final boolean component18() {
        return this.isOfficialRelease;
    }

    public final boolean component19() {
        return this.isOverseaPkg;
    }

    public final int component2() {
        return this.appId;
    }

    public final String component20() {
        return this.kaChannel;
    }

    public final String component21() {
        return this.logFilter;
    }

    public final String component22() {
        return this.logLevel;
    }

    public final String component23() {
        return this.nodeEnv;
    }

    public final String component24() {
        return this.packageName;
    }

    public final String component25() {
        return this.pasChannel;
    }

    public final int component26() {
        return this.versionCode;
    }

    public final boolean component3() {
        return this.boeHeaderWithXUseBoe;
    }

    public final String component4() {
        return this.boeRPCPersistDyecpFDKey;
    }

    public final String component5() {
        return this.boeRPCPersistDyecpFDValue;
    }

    public final String component6() {
        return this.boeTTFeatureEnv;
    }

    public final String component7() {
        return this.boeUnit;
    }

    public final boolean component8() {
        return this.boeUseBOE;
    }

    public final boolean component9() {
        return this.boeWithExtraHeader;
    }

    public final IEnv$Property copy(String r30, int r31, boolean r32, String r33, String r34, String r35, String r36, boolean r37, boolean r38, String r39, ArrayList<IEnv$CustomSchema> r40, String r41, boolean r42, boolean r43, boolean r44, boolean r45, boolean r46, boolean r47, boolean r48, String r49, String r50, String r51, String r52, String r53, String r54, int r55) {
        Intrinsics.checkNotNullParameter(r30, "appChannel");
        Intrinsics.checkNotNullParameter(r33, "boeRPCPersistDyecpFDKey");
        Intrinsics.checkNotNullParameter(r34, "boeRPCPersistDyecpFDValue");
        Intrinsics.checkNotNullParameter(r35, "boeTTFeatureEnv");
        Intrinsics.checkNotNullParameter(r36, "boeUnit");
        Intrinsics.checkNotNullParameter(r39, "clientUnit");
        Intrinsics.checkNotNullParameter(r40, "customSchema");
        Intrinsics.checkNotNullParameter(r41, "deployMode");
        Intrinsics.checkNotNullParameter(r49, "kaChannel");
        Intrinsics.checkNotNullParameter(r50, "logFilter");
        Intrinsics.checkNotNullParameter(r51, "logLevel");
        Intrinsics.checkNotNullParameter(r52, "nodeEnv");
        Intrinsics.checkNotNullParameter(r53, Keys.CMD_BIND_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r54, "pasChannel");
        return new IEnv$Property(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IEnv$Property) == true) goto L8;
        return false;
    L8:
        IEnv$Property r6 = (IEnv$Property) r5;
        if (Intrinsics.areEqual(this.appChannel, r6.appChannel) == true) goto L12;
        return false;
    L12:
        if (this.appId == r6.appId) goto L15;
        return false;
    L15:
        if (this.boeHeaderWithXUseBoe == r6.boeHeaderWithXUseBoe) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.boeRPCPersistDyecpFDKey, r6.boeRPCPersistDyecpFDKey) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.boeRPCPersistDyecpFDValue, r6.boeRPCPersistDyecpFDValue) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.boeTTFeatureEnv, r6.boeTTFeatureEnv) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.boeUnit, r6.boeUnit) == true) goto L30;
        return false;
    L30:
        if (this.boeUseBOE == r6.boeUseBOE) goto L33;
        return false;
    L33:
        if (this.boeWithExtraHeader == r6.boeWithExtraHeader) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.clientUnit, r6.clientUnit) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.customSchema, r6.customSchema) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.deployMode, r6.deployMode) == true) goto L45;
        return false;
    L45:
        if (this.firstRunAfterInstall == r6.firstRunAfterInstall) goto L48;
        return false;
    L48:
        if (this.forceSaasLogin == r6.forceSaasLogin) goto L51;
        return false;
    L51:
        if (this.isDev == r6.isDev) goto L54;
        return false;
    L54:
        if (this.isKA == r6.isKA) goto L57;
        return false;
    L57:
        if (this.isMAS == r6.isMAS) goto L60;
        return false;
    L60:
        if (this.isOfficialRelease == r6.isOfficialRelease) goto L63;
        return false;
    L63:
        if (this.isOverseaPkg == r6.isOverseaPkg) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.kaChannel, r6.kaChannel) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.logFilter, r6.logFilter) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.logLevel, r6.logLevel) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.nodeEnv, r6.nodeEnv) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.pasChannel, r6.pasChannel) == true) goto L84;
        return false;
    L84:
        if (this.versionCode == r6.versionCode) goto L86;
        return false;
    L86:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.appChannel.hashCode() * 31) + this.appId) * 31;
        int r2 = 1231;
        if (this.boeHeaderWithXUseBoe == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((((((r0 + r1) * 31) + this.boeRPCPersistDyecpFDKey.hashCode()) * 31) + this.boeRPCPersistDyecpFDValue.hashCode()) * 31) + this.boeTTFeatureEnv.hashCode()) * 31) + this.boeUnit.hashCode()) * 31;
        if (this.boeUseBOE == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.boeWithExtraHeader == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (((((((r5 + r6) * 31) + this.clientUnit.hashCode()) * 31) + this.customSchema.hashCode()) * 31) + this.deployMode.hashCode()) * 31;
        if (this.firstRunAfterInstall == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.forceSaasLogin == false) goto L21;
        int r10 = 1231;
    L22:
        int r11 = (r9 + r10) * 31;
        if (this.isDev == false) goto L25;
        int r12 = 1231;
    L26:
        int r13 = (r11 + r12) * 31;
        if (this.isKA == false) goto L29;
        int r14 = 1231;
    L30:
        int r15 = (r13 + r14) * 31;
        if (this.isMAS == false) goto L33;
        int r16 = 1231;
    L34:
        int r17 = (r15 + r16) * 31;
        if (this.isOfficialRelease == false) goto L37;
        int r18 = 1231;
    L38:
        int r19 = (r17 + r18) * 31;
        if (this.isOverseaPkg == true) goto L43;
        r2 = 1237;
    L43:
        return ((((((((((((((r19 + r2) * 31) + this.kaChannel.hashCode()) * 31) + this.logFilter.hashCode()) * 31) + this.logLevel.hashCode()) * 31) + this.nodeEnv.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.pasChannel.hashCode()) * 31) + this.versionCode;
    L37:
        r18 = 1237;
        goto L38
    L33:
        r16 = 1237;
        goto L34
    L29:
        r14 = 1237;
        goto L30
    L25:
        r12 = 1237;
        goto L26
    L21:
        r10 = 1237;
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "Property(appChannel=" + this.appChannel + ", appId=" + this.appId + ", boeHeaderWithXUseBoe=" + this.boeHeaderWithXUseBoe + ", boeRPCPersistDyecpFDKey=" + this.boeRPCPersistDyecpFDKey + ", boeRPCPersistDyecpFDValue=" + this.boeRPCPersistDyecpFDValue + ", boeTTFeatureEnv=" + this.boeTTFeatureEnv + ", boeUnit=" + this.boeUnit + ", boeUseBOE=" + this.boeUseBOE + ", boeWithExtraHeader=" + this.boeWithExtraHeader + ", clientUnit=" + this.clientUnit + ", customSchema=" + this.customSchema + ", deployMode=" + this.deployMode + ", firstRunAfterInstall=" + this.firstRunAfterInstall + ", forceSaasLogin=" + this.forceSaasLogin + ", isDev=" + this.isDev + ", isKA=" + this.isKA + ", isMAS=" + this.isMAS + ", isOfficialRelease=" + this.isOfficialRelease + ", isOverseaPkg=" + this.isOverseaPkg + ", kaChannel=" + this.kaChannel + ", logFilter=" + this.logFilter + ", logLevel=" + this.logLevel + ", nodeEnv=" + this.nodeEnv + ", packageName=" + this.packageName + ", pasChannel=" + this.pasChannel + ", versionCode=" + this.versionCode + ')';
    }

    public final String getAppChannel() {
        return this.appChannel;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final boolean getBoeHeaderWithXUseBoe() {
        return this.boeHeaderWithXUseBoe;
    }

    public final String getBoeRPCPersistDyecpFDKey() {
        return this.boeRPCPersistDyecpFDKey;
    }

    public final String getBoeRPCPersistDyecpFDValue() {
        return this.boeRPCPersistDyecpFDValue;
    }

    public final String getBoeTTFeatureEnv() {
        return this.boeTTFeatureEnv;
    }

    public final String getBoeUnit() {
        return this.boeUnit;
    }

    public final boolean getBoeUseBOE() {
        return this.boeUseBOE;
    }

    public final boolean getBoeWithExtraHeader() {
        return this.boeWithExtraHeader;
    }

    public final String getClientUnit() {
        return this.clientUnit;
    }

    public final ArrayList<IEnv$CustomSchema> getCustomSchema() {
        return this.customSchema;
    }

    public final String getDeployMode() {
        return this.deployMode;
    }

    public final boolean getFirstRunAfterInstall() {
        return this.firstRunAfterInstall;
    }

    public final boolean getForceSaasLogin() {
        return this.forceSaasLogin;
    }

    public final String getKaChannel() {
        return this.kaChannel;
    }

    public final String getLogFilter() {
        return this.logFilter;
    }

    public final String getLogLevel() {
        return this.logLevel;
    }

    public final String getNodeEnv() {
        return this.nodeEnv;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPasChannel() {
        return this.pasChannel;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    @JSONField(name = "isDev")
    public final boolean isDev() {
        return this.isDev;
    }

    @JSONField(name = "isKA")
    public final boolean isKA() {
        return this.isKA;
    }

    @JSONField(name = "isMAS")
    public final boolean isMAS() {
        return this.isMAS;
    }

    @JSONField(name = "isOfficialRelease")
    public final boolean isOfficialRelease() {
        return this.isOfficialRelease;
    }

    @JSONField(name = "isOverseaPkg")
    public final boolean isOverseaPkg() {
        return this.isOverseaPkg;
    }

    public IEnv$Property(String r17, int r18, boolean r19, String r20, String r21, String r22, String r23, boolean r24, boolean r25, String r26, ArrayList<IEnv$CustomSchema> r27, String r28, boolean r29, boolean r30, boolean r31, boolean r32, boolean r33, boolean r34, boolean r35, String r36, String r37, String r38, String r39, String r40, String r41, int r42) {
        Intrinsics.checkNotNullParameter(r17, "appChannel");
        Intrinsics.checkNotNullParameter(r20, "boeRPCPersistDyecpFDKey");
        Intrinsics.checkNotNullParameter(r21, "boeRPCPersistDyecpFDValue");
        Intrinsics.checkNotNullParameter(r22, "boeTTFeatureEnv");
        Intrinsics.checkNotNullParameter(r23, "boeUnit");
        Intrinsics.checkNotNullParameter(r26, "clientUnit");
        Intrinsics.checkNotNullParameter(r27, "customSchema");
        Intrinsics.checkNotNullParameter(r28, "deployMode");
        Intrinsics.checkNotNullParameter(r36, "kaChannel");
        Intrinsics.checkNotNullParameter(r37, "logFilter");
        Intrinsics.checkNotNullParameter(r38, "logLevel");
        Intrinsics.checkNotNullParameter(r39, "nodeEnv");
        Intrinsics.checkNotNullParameter(r40, Keys.CMD_BIND_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r41, "pasChannel");
        this.appChannel = r17;
        this.appId = r18;
        this.boeHeaderWithXUseBoe = r19;
        this.boeRPCPersistDyecpFDKey = r20;
        this.boeRPCPersistDyecpFDValue = r21;
        this.boeTTFeatureEnv = r22;
        this.boeUnit = r23;
        this.boeUseBOE = r24;
        this.boeWithExtraHeader = r25;
        this.clientUnit = r26;
        this.customSchema = r27;
        this.deployMode = r28;
        this.firstRunAfterInstall = r29;
        this.forceSaasLogin = r30;
        this.isDev = r31;
        this.isKA = r32;
        this.isMAS = r33;
        this.isOfficialRelease = r34;
        this.isOverseaPkg = r35;
        this.kaChannel = r36;
        this.logFilter = r37;
        this.logLevel = r38;
        this.nodeEnv = r39;
        this.packageName = r40;
        this.pasChannel = r41;
        this.versionCode = r42;
    }
}
