package com.ss.android.lark.component.appcontext.model;

import b8b.c;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.lark.chameleon.GeckoConst;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b?\b\u0086\b\u0018\u00002\u00020\u0001BÛ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u00104\u001a\u00020\u0003J\u0006\u00105\u001a\u00020\u0003J\u0006\u00106\u001a\u00020\u0003J\u0006\u00107\u001a\u00020\u0003J\u001f\u00108\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\b¢\u0006\u0002\u00109J\u0006\u0010:\u001a\u00020\u0003J\u000e\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u000fJ\u001b\u0010=\u001a\u0004\u0018\u0001H>\"\u0004\b\u0000\u0010>2\u0006\u0010?\u001a\u00020\u000b¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010C\u001a\u00020\u0012H\u0016J\b\u0010D\u001a\u00020\u000bH\u0016J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÂ\u0003¢\u0006\u0002\u0010IJ\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010L\u001a\u00020\rHÆ\u0003J\u0014\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007HÂ\u0003¢\u0006\u0002\u0010NJ\t\u0010O\u001a\u00020\u000bHÆ\u0003J\t\u0010P\u001a\u00020\u0012HÆ\u0003J\t\u0010Q\u001a\u00020\u000bHÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u000bHÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\u0017\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aHÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u001dHÆ\u0003Jè\u0001\u0010Z\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u001dHÆ\u0001¢\u0006\u0002\u0010[R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010!R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010!R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010(R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0013\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010!R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010!R\u0011\u0010\u0016\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010!R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u001f\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010!R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006\\"}, d2 = {"Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", BuildConfig.FLAVOR, GeckoConst.DEBUG, BuildConfig.FLAVOR, "inHouse", "isABI32", "flavors", BuildConfig.FLAVOR, "Lcom/ss/android/lark/component/appcontext/model/Flavor;", "isMiraOpen", "loginType", BuildConfig.FLAVOR, "thirdSdkKeys", "Lcom/ss/android/lark/component/appcontext/model/ThirdSdkKeys;", "enablePlugins", "Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;", "commitId", "slardarAppId", BuildConfig.FLAVOR, "veSDKVersion", "isHWComponentEnabled", "isLiteBuildMode", "alchemyProjectId", "lynxDebug", "enablePerfTools", "allValues", BuildConfig.FLAVOR, "isOfficeSDKImIntegrated", "appName", "Lcom/ss/android/lark/component/appcontext/model/AppName;", "<init>", "(ZZZ[Lcom/ss/android/lark/component/appcontext/model/Flavor;ZLjava/lang/String;Lcom/ss/android/lark/component/appcontext/model/ThirdSdkKeys;[Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;ZZLjava/util/Map;ZLcom/ss/android/lark/component/appcontext/model/AppName;)V", "getDebug", "()Z", "getInHouse", "[Lcom/ss/android/lark/component/appcontext/model/Flavor;", "getLoginType", "()Ljava/lang/String;", "getThirdSdkKeys", "()Lcom/ss/android/lark/component/appcontext/model/ThirdSdkKeys;", "[Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;", "getCommitId", "getSlardarAppId", "()I", "getVeSDKVersion", "getAlchemyProjectId", "getLynxDebug", "getEnablePerfTools", "getAllValues", "()Ljava/util/Map;", "getAppName", "()Lcom/ss/android/lark/component/appcontext/model/AppName;", "isDebug", "isLarkApp", "isMempopeApp", "isOfficeSDK", "isFlavors", "([Lcom/ss/android/lark/component/appcontext/model/Flavor;)Z", "isUsPackage", "isPluginEnable", "plugin", "getValue", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "equals", "other", "hashCode", "toString", "component1", "component2", "component3", "component4", "()[Lcom/ss/android/lark/component/appcontext/model/Flavor;", "component5", "component6", "component7", "component8", "()[Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(ZZZ[Lcom/ss/android/lark/component/appcontext/model/Flavor;ZLjava/lang/String;Lcom/ss/android/lark/component/appcontext/model/ThirdSdkKeys;[Lcom/ss/android/lark/component/appcontext/model/DynamicPlugins;Ljava/lang/String;ILjava/lang/String;ZZLjava/lang/String;ZZLjava/util/Map;ZLcom/ss/android/lark/component/appcontext/model/AppName;)Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", "appcontext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkBuildConfig {
    private final String alchemyProjectId;
    private final Map<String, Object> allValues;
    private final AppName appName;
    private final String commitId;
    private final boolean debug;
    private final boolean enablePerfTools;
    private final DynamicPlugins[] enablePlugins;
    private final Flavor[] flavors;
    private final boolean inHouse;
    private final boolean isABI32;
    private final boolean isHWComponentEnabled;
    private final boolean isLiteBuildMode;
    private final boolean isMiraOpen;
    private final boolean isOfficeSDKImIntegrated;
    private final String loginType;
    private final boolean lynxDebug;
    private final int slardarAppId;
    private final c thirdSdkKeys;
    private final String veSDKVersion;

    private final Flavor[] component4() {
        return this.flavors;
    }

    private final DynamicPlugins[] component8() {
        return this.enablePlugins;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LarkBuildConfig copy$default(LarkBuildConfig r17, boolean r18, boolean r19, boolean r20, Flavor[] r21, boolean r22, String r23, c r24, DynamicPlugins[] r25, String r26, int r27, String r28, boolean r29, boolean r30, String r31, boolean r32, boolean r33, Map r34, boolean r35, AppName r36, int r37, Object r38) {
        if ((r37 & 1) == 0) goto L5;
        boolean r2 = r17.debug;
    L7:
        if ((r37 & 2) == 0) goto L9;
        boolean r3 = r17.inHouse;
    L11:
        if ((r37 & 4) == 0) goto L13;
        boolean r4 = r17.isABI32;
    L15:
        if ((r37 & 8) == 0) goto L17;
        Flavor[] r5 = r17.flavors;
    L19:
        if ((r37 & 16) == 0) goto L21;
        boolean r6 = r17.isMiraOpen;
    L23:
        if ((r37 & 32) == 0) goto L25;
        String r7 = r17.loginType;
    L27:
        if ((r37 & 64) == 0) goto L29;
        c r8 = r17.thirdSdkKeys;
    L31:
        if ((r37 & 128) == 0) goto L33;
        DynamicPlugins[] r9 = r17.enablePlugins;
    L35:
        if ((r37 & 256) == 0) goto L37;
        String r10 = r17.commitId;
    L39:
        if ((r37 & 512) == 0) goto L41;
        int r11 = r17.slardarAppId;
    L43:
        if ((r37 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
        String r12 = r17.veSDKVersion;
    L47:
        if ((r37 & 2048) == 0) goto L49;
        boolean r13 = r17.isHWComponentEnabled;
    L51:
        if ((r37 & 4096) == 0) goto L53;
        boolean r14 = r17.isLiteBuildMode;
    L55:
        if ((r37 & 8192) == 0) goto L57;
        String r15 = r17.alchemyProjectId;
    L58:
        String r39 = r15;
        if ((r37 & 16384) == 0) goto L61;
        boolean r16 = r17.lynxDebug;
    L62:
        boolean r310 = r16;
        if ((r37 & 32768) == 0) goto L65;
        boolean r110 = r17.enablePerfTools;
    L66:
        boolean r311 = r110;
        if ((r37 & 65536) == 0) goto L69;
        Map r111 = r17.allValues;
    L70:
        Map r312 = r111;
        if ((r37 & 131072) == 0) goto L73;
        boolean r112 = r17.isOfficeSDKImIntegrated;
    L75:
        if ((r37 & 262144) == 0) goto L77;
        AppName r1 = r17.appName;
    L79:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r39, r310, r311, r312, r112, r1);
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

    public final boolean component1() {
        return this.debug;
    }

    public final int component10() {
        return this.slardarAppId;
    }

    public final String component11() {
        return this.veSDKVersion;
    }

    public final boolean component12() {
        return this.isHWComponentEnabled;
    }

    public final boolean component13() {
        return this.isLiteBuildMode;
    }

    public final String component14() {
        return this.alchemyProjectId;
    }

    public final boolean component15() {
        return this.lynxDebug;
    }

    public final boolean component16() {
        return this.enablePerfTools;
    }

    public final Map<String, Object> component17() {
        return this.allValues;
    }

    public final boolean component18() {
        return this.isOfficeSDKImIntegrated;
    }

    public final AppName component19() {
        return this.appName;
    }

    public final boolean component2() {
        return this.inHouse;
    }

    public final boolean component3() {
        return this.isABI32;
    }

    public final boolean component5() {
        return this.isMiraOpen;
    }

    public final String component6() {
        return this.loginType;
    }

    public final c component7() {
        return this.thirdSdkKeys;
    }

    public final String component9() {
        return this.commitId;
    }

    public final LarkBuildConfig copy(boolean r22, boolean r23, boolean r24, Flavor[] r25, boolean r26, String r27, c r28, DynamicPlugins[] r29, String r30, int r31, String r32, boolean r33, boolean r34, String r35, boolean r36, boolean r37, Map<String, ? extends Object> r38, boolean r39, AppName r40) {
        Intrinsics.checkNotNullParameter(r25, "flavors");
        Intrinsics.checkNotNullParameter(r28, "thirdSdkKeys");
        Intrinsics.checkNotNullParameter(r29, "enablePlugins");
        Intrinsics.checkNotNullParameter(r30, "commitId");
        Intrinsics.checkNotNullParameter(r32, "veSDKVersion");
        Intrinsics.checkNotNullParameter(r35, "alchemyProjectId");
        Intrinsics.checkNotNullParameter(r38, "allValues");
        Intrinsics.checkNotNullParameter(r40, "appName");
        return new LarkBuildConfig(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40);
    }

    public final boolean isUsPackage() {
        return isFlavors(new Flavor[]{Flavor.REGION_US});
    }

    public int hashCode() {
        if (this.debug == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + Arrays.hashCode(this.flavors)) * 31) + Arrays.hashCode(this.enablePlugins);
    L5:
        r0 = 1237;
        goto L7
    }

    public final boolean isLarkApp() {
        return this.appName.isLark();
    }

    public final boolean isMempopeApp() {
        return this.appName.isMempope();
    }

    public final boolean isOfficeSDK() {
        return this.appName.isOfficeSDK();
    }

    public String toString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public final String getAlchemyProjectId() {
        return this.alchemyProjectId;
    }

    public final Map<String, Object> getAllValues() {
        return this.allValues;
    }

    public final AppName getAppName() {
        return this.appName;
    }

    public final String getCommitId() {
        return this.commitId;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    public final boolean getEnablePerfTools() {
        return this.enablePerfTools;
    }

    public final boolean getInHouse() {
        return this.inHouse;
    }

    public final String getLoginType() {
        return this.loginType;
    }

    public final boolean getLynxDebug() {
        return this.lynxDebug;
    }

    public final int getSlardarAppId() {
        return this.slardarAppId;
    }

    public final c getThirdSdkKeys() {
        return this.thirdSdkKeys;
    }

    public final String getVeSDKVersion() {
        return this.veSDKVersion;
    }

    public final boolean isABI32() {
        return this.isABI32;
    }

    public final boolean isDebug() {
        return this.debug;
    }

    public final boolean isHWComponentEnabled() {
        return this.isHWComponentEnabled;
    }

    public final boolean isLiteBuildMode() {
        return this.isLiteBuildMode;
    }

    public final boolean isMiraOpen() {
        return this.isMiraOpen;
    }

    public final boolean isOfficeSDKImIntegrated() {
        return this.isOfficeSDKImIntegrated;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(LarkBuildConfig.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.component.appcontext.model.LarkBuildConfig");
        LarkBuildConfig r6 = (LarkBuildConfig) r5;
        if (this.debug == r6.debug) goto L16;
        return false;
    L16:
        if (Arrays.equals(this.flavors, r6.flavors) == true) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.enablePlugins, r6.enablePlugins) == true) goto L21;
        return false;
    L21:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final <T> T getValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return (T) this.allValues.get(r2);
    }

    public final boolean isFlavors(Flavor... r6) {
        Intrinsics.checkNotNullParameter(r6, "flavors");
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        Flavor r3 = r6[r2];
        if (ArraysKt.contains(this.flavors, r3) == false) goto L12;
        r2 = r2 + 1;
        goto L3
    L12:
        return false;
    L8:
        return true;
    }

    public final boolean isPluginEnable(DynamicPlugins r2) {
        Intrinsics.checkNotNullParameter(r2, "plugin");
        return ArraysKt.contains(this.enablePlugins, r2);
    }

    public LarkBuildConfig(boolean r11, boolean r12, boolean r13, Flavor[] r14, boolean r15, String r16, c r17, DynamicPlugins[] r18, String r19, int r20, String r21, boolean r22, boolean r23, String r24, boolean r25, boolean r26, Map<String, ? extends Object> r27, boolean r28, AppName r29) {
        Intrinsics.checkNotNullParameter(r14, "flavors");
        Intrinsics.checkNotNullParameter(r17, "thirdSdkKeys");
        Intrinsics.checkNotNullParameter(r18, "enablePlugins");
        Intrinsics.checkNotNullParameter(r19, "commitId");
        Intrinsics.checkNotNullParameter(r21, "veSDKVersion");
        Intrinsics.checkNotNullParameter(r24, "alchemyProjectId");
        Intrinsics.checkNotNullParameter(r27, "allValues");
        Intrinsics.checkNotNullParameter(r29, "appName");
        this.debug = r11;
        this.inHouse = r12;
        this.isABI32 = r13;
        this.flavors = r14;
        this.isMiraOpen = r15;
        this.loginType = r16;
        this.thirdSdkKeys = r17;
        this.enablePlugins = r18;
        this.commitId = r19;
        this.slardarAppId = r20;
        this.veSDKVersion = r21;
        this.isHWComponentEnabled = r22;
        this.isLiteBuildMode = r23;
        this.alchemyProjectId = r24;
        this.lynxDebug = r25;
        this.enablePerfTools = r26;
        this.allValues = r27;
        this.isOfficeSDKImIntegrated = r28;
        this.appName = r29;
    }

    public /* synthetic */ LarkBuildConfig(boolean r24, boolean r25, boolean r26, Flavor[] r27, boolean r28, String r29, c r30, DynamicPlugins[] r31, String r32, int r33, String r34, boolean r35, boolean r36, String r37, boolean r38, boolean r39, Map r40, boolean r41, AppName r42, int r43, DefaultConstructorMarker r44) {
        if ((r43 & 1) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r43 & 2) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r43 & 4) == 0) goto L13;
        boolean r6 = false;
    L15:
        if ((r43 & 8) == 0) goto L17;
        Flavor[] r7 = {Flavor.REGION_CHINA, Flavor.ENV_PRODUCTION};
    L19:
        if ((r43 & 16) == 0) goto L21;
        boolean r8 = false;
    L23:
        if ((r43 & 128) == 0) goto L25;
        DynamicPlugins[] r11 = new DynamicPlugins[0];
    L27:
        if ((r43 & 256) == 0) goto L29;
        String r12 = BuildConfig.FLAVOR;
    L31:
        if ((r43 & 512) == 0) goto L33;
        int r13 = 0;
    L35:
        if ((r43 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L37;
        String r14 = BuildConfig.FLAVOR;
    L39:
        if ((r43 & 2048) == 0) goto L41;
        boolean r15 = false;
    L43:
        if ((r43 & 4096) == 0) goto L45;
        boolean r16 = false;
    L47:
        if ((r43 & 8192) == 0) goto L49;
        String r17 = BuildConfig.FLAVOR;
    L51:
        if ((r43 & 16384) == 0) goto L53;
        boolean r18 = false;
    L55:
        if ((32768 & r43) == 0) goto L57;
        boolean r19 = false;
    L59:
        if ((65536 & r43) == 0) goto L61;
        Map r20 = MapsKt.emptyMap();
    L63:
        if ((r43 & 131072) == 0) goto L65;
        boolean r21 = false;
    L66:
        this(r4, r5, r6, r7, r8, r29, r30, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r42);
        return;
    L65:
        r21 = r41;
        goto L66
    L61:
        r20 = r40;
        goto L63
    L57:
        r19 = r39;
        goto L59
    L53:
        r18 = r38;
        goto L55
    L49:
        r17 = r37;
        goto L51
    L45:
        r16 = r36;
        goto L47
    L41:
        r15 = r35;
        goto L43
    L37:
        r14 = r34;
        goto L39
    L33:
        r13 = r33;
        goto L35
    L29:
        r12 = r32;
        goto L31
    L25:
        r11 = r31;
        goto L27
    L21:
        r8 = r28;
        goto L23
    L17:
        r7 = r27;
        goto L19
    L13:
        r6 = r26;
        goto L15
    L9:
        r5 = r25;
        goto L11
    L5:
        r4 = r24;
        goto L7
    }
}
