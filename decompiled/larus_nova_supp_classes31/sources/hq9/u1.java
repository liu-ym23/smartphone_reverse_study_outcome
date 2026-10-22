package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 62\u00020\u0001:\u00016B«\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0013\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tHÆ\u0003J\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tHÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tHÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tHÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J²\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\"\u0010\u0014R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b#\u0010\u0014¨\u00067"}, d2 = {"Lcom/larus/platform/model/ImageInstantUploadConfig;", "", "enabled", "", "enableSdkChain", "enableFallbackRegister", "preQueryPath", "", "bizSceneWhiteList", "", "uploadSceneBlackList", "uploadSourceSceneBlackList", "policyFamilyWhiteList", "maxOriginHashFileSize", "", "failOpen", "enableLog", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableSdkChain", "getEnableFallbackRegister", "getPreQueryPath", "()Ljava/lang/String;", "getBizSceneWhiteList", "()Ljava/util/List;", "getUploadSceneBlackList", "getUploadSourceSceneBlackList", "getPolicyFamilyWhiteList", "getMaxOriginHashFileSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFailOpen", "getEnableLog", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/platform/model/ImageInstantUploadConfig;", "equals", "other", "hashCode", "", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class u1 {
    public static final List<String> a = null;
    public static final List<String> b = null;

    @SerializedName("biz_scene_whitelist")
    private final List<String> bizSceneWhiteList;

    @SerializedName("enable_fallback_register")
    private final Boolean enableFallbackRegister;

    @SerializedName("enable_log")
    private final Boolean enableLog;

    @SerializedName("enable_sdk_chain")
    private final Boolean enableSdkChain;

    @SerializedName("enabled")
    private final Boolean enabled;

    @SerializedName("fail_open")
    private final Boolean failOpen;

    @SerializedName("max_origin_hash_file_size")
    private final Long maxOriginHashFileSize;

    @SerializedName("policy_family_whitelist")
    private final List<String> policyFamilyWhiteList;

    @SerializedName("pre_query_path")
    private final String preQueryPath;

    @SerializedName("upload_scene_blacklist")
    private final List<String> uploadSceneBlackList;

    @SerializedName("upload_source_scene_blacklist")
    private final List<String> uploadSourceSceneBlackList;

    public static final class a {
    }

    public u1() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u1) == true) goto L8;
        return false;
    L8:
        u1 r6 = (u1) r5;
        if (Intrinsics.areEqual(this.enabled, r6.enabled) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableSdkChain, r6.enableSdkChain) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableFallbackRegister, r6.enableFallbackRegister) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.preQueryPath, r6.preQueryPath) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bizSceneWhiteList, r6.bizSceneWhiteList) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.uploadSceneBlackList, r6.uploadSceneBlackList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.uploadSourceSceneBlackList, r6.uploadSourceSceneBlackList) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.policyFamilyWhiteList, r6.policyFamilyWhiteList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.maxOriginHashFileSize, r6.maxOriginHashFileSize) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.failOpen, r6.failOpen) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.enableLog, r6.enableLog) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.enabled;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.enableSdkChain;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.enableFallbackRegister;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.preQueryPath;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<String> r13 = this.bizSceneWhiteList;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.uploadSceneBlackList;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.uploadSourceSceneBlackList;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        List<String> r22 = this.policyFamilyWhiteList;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Long r25 = this.maxOriginHashFileSize;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.failOpen;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.enableLog;
        if (r31 == null) goto L47;
        r1 = r31.hashCode();
    L47:
        return r30 + r1;
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ImageInstantUploadConfig(enabled=" + this.enabled + ", enableSdkChain=" + this.enableSdkChain + ", enableFallbackRegister=" + this.enableFallbackRegister + ", preQueryPath=" + this.preQueryPath + ", bizSceneWhiteList=" + this.bizSceneWhiteList + ", uploadSceneBlackList=" + this.uploadSceneBlackList + ", uploadSourceSceneBlackList=" + this.uploadSourceSceneBlackList + ", policyFamilyWhiteList=" + this.policyFamilyWhiteList + ", maxOriginHashFileSize=" + this.maxOriginHashFileSize + ", failOpen=" + this.failOpen + ", enableLog=" + this.enableLog + ')';
    }

    static {
        a = CollectionsKt.listOf("CHAT_ATTACHMENT_VIDEO");
        b = CollectionsKt.listOf(new String[]{"shoot", "shoot_ocr"});
    }

    public final List<String> a() {
        return this.bizSceneWhiteList;
    }

    public final Boolean b() {
        return this.enableFallbackRegister;
    }

    public final Boolean c() {
        return this.enableLog;
    }

    public final Boolean d() {
        return this.enableSdkChain;
    }

    public final Boolean e() {
        return this.enabled;
    }

    public final Boolean f() {
        return this.failOpen;
    }

    public final Long g() {
        return this.maxOriginHashFileSize;
    }

    public final List<String> h() {
        return this.policyFamilyWhiteList;
    }

    public final String i() {
        return this.preQueryPath;
    }

    public final List<String> j() {
        return this.uploadSceneBlackList;
    }

    public final List<String> k() {
        return this.uploadSourceSceneBlackList;
    }

    public u1(Object r8) {
        Boolean r9 = Boolean.FALSE;
        List<String> r0 = CollectionsKt.emptyList();
        List<String> r1 = a;
        List<String> r2 = b;
        List<String> r3 = CollectionsKt.emptyList();
        Boolean r5 = Boolean.TRUE;
        this.enabled = r9;
        this.enableSdkChain = r9;
        this.enableFallbackRegister = r9;
        this.preQueryPath = "/alice/resource/pre_check_fast_upload";
        this.bizSceneWhiteList = r0;
        this.uploadSceneBlackList = r1;
        this.uploadSourceSceneBlackList = r2;
        this.policyFamilyWhiteList = r3;
        this.maxOriginHashFileSize = 52428800L;
        this.failOpen = r5;
        this.enableLog = r9;
    }
}
