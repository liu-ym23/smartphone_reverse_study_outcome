package com.obric.memorydata.migration.sdk;

import androidx.core.app.FrameMetricsAggregator;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0003J|\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\tHÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u001a\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00060"}, d2 = {"Lcom/obric/memorydata/migration/sdk/QrPayload;", "", "protocolVersion", "", "senderUidHash", "senderUidSaltBase64", "senderAppVersionCode", "", "serverPort", "", "pairingCode", "sessionAesKey", "exportScope", "endpoints", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)V", "getProtocolVersion", "()Ljava/lang/String;", "getSenderUidHash", "getSenderUidSaltBase64", "getSenderAppVersionCode", "()J", "getServerPort", "()I", "getPairingCode", "getSessionAesKey", "getExportScope", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEndpoints", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Lcom/obric/memorydata/migration/sdk/QrPayload;", "equals", "", "other", "hashCode", "toString", "migration_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class QrPayload {

    @SerializedName("endpoints")
    private final List<String> endpoints;

    @SerializedName("exportScope")
    private final Integer exportScope;

    @SerializedName("pairingCode")
    private final String pairingCode;

    @SerializedName("protocolVersion")
    private final String protocolVersion;

    @SerializedName("senderAppVersionCode")
    private final long senderAppVersionCode;

    @SerializedName("senderUidHash")
    private final String senderUidHash;

    @SerializedName("senderUidSaltBase64")
    private final String senderUidSaltBase64;

    @SerializedName("serverPort")
    private final int serverPort;

    @SerializedName("sessionAesKey")
    private final String sessionAesKey;

    public QrPayload() {
        this(null, null, null, 0, 0, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public QrPayload(String r3, String r4, String r5, long r6, int r8, String r9, String r10, Integer r11, List<String> r12) {
        List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        this.protocolVersion = r3;
        this.senderUidHash = r4;
        this.senderUidSaltBase64 = r5;
        this.senderAppVersionCode = r6;
        this.serverPort = r8;
        this.pairingCode = r9;
        this.sessionAesKey = r10;
        this.exportScope = r11;
        this.endpoints = r13;
    }

    public /* synthetic */ QrPayload(String r13, String r14, String r15, long r16, int r18, String r19, String r20, Integer r21, List r22, int r23, DefaultConstructorMarker r24) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        List r3 = null;
        if ((r23 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r5 = null;
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r6 = 0;
    L19:
        if ((r23 & 16) == 0) goto L21;
        int r8 = 0;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r23 & 64) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r23 & 128) == 0) goto L33;
        Integer r11 = null;
    L35:
        if ((r23 & 256) != 0) goto L38;
        r3 = r1;
    L38:
        this(r2, r4, r5, r6, r8, r9, r10, r11, r3);
        return;
    L33:
        r11 = r21;
        goto L35
    L29:
        r10 = r20;
        goto L31
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public static /* synthetic */ QrPayload copy$default(QrPayload r12, String r13, String r14, String r15, long r16, int r18, String r19, String r20, Integer r21, List r22, int r23, Object r24) {
        List<String> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        if ((r23 & 1) == 0) goto L5;
        String r3 = r12.protocolVersion;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r4 = r12.senderUidHash;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r5 = r12.senderUidSaltBase64;
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r6 = r12.senderAppVersionCode;
    L19:
        if ((r23 & 16) == 0) goto L21;
        int r8 = r12.serverPort;
    L23:
        if ((r23 & 32) == 0) goto L25;
        String r9 = r12.pairingCode;
    L27:
        if ((r23 & 64) == 0) goto L29;
        String r10 = r12.sessionAesKey;
    L31:
        if ((r23 & 128) == 0) goto L33;
        Integer r11 = r12.exportScope;
    L35:
        if ((r23 & 256) == 0) goto L37;
        List<String> r1 = r12.endpoints;
    L39:
        return r12.copy(r3, r4, r5, r6, r8, r9, r10, r11, r1);
    L37:
        r1 = r2;
        goto L39
    L33:
        r11 = r21;
        goto L35
    L29:
        r10 = r20;
        goto L31
    L25:
        r9 = r19;
        goto L27
    L21:
        r8 = r18;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public final String component1() {
        return this.protocolVersion;
    }

    public final String component2() {
        return this.senderUidHash;
    }

    public final String component3() {
        return this.senderUidSaltBase64;
    }

    public final long component4() {
        return this.senderAppVersionCode;
    }

    public final int component5() {
        return this.serverPort;
    }

    public final String component6() {
        return this.pairingCode;
    }

    public final String component7() {
        return this.sessionAesKey;
    }

    public final Integer component8() {
        return this.exportScope;
    }

    public final List<String> component9() {
        return this.endpoints;
    }

    public final QrPayload copy(String r13, String r14, String r15, long r16, int r18, String r19, String r20, Integer r21, List<String> r22) {
        return new QrPayload(r13, r14, r15, r16, r18, r19, r20, r21, (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, QrPayload.class) == true) goto L8;
        return false;
    L8:
        QrPayload r10 = (QrPayload) ZeusTransformUtils.preCheckCast(r9, QrPayload.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.protocolVersion, r10.protocolVersion) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.senderUidHash, r10.senderUidHash) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.senderUidSaltBase64, r10.senderUidSaltBase64) == true) goto L18;
        return false;
    L18:
        if (this.senderAppVersionCode == r10.senderAppVersionCode) goto L21;
        return false;
    L21:
        if (this.serverPort == r10.serverPort) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.pairingCode, r10.pairingCode) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.sessionAesKey, r10.sessionAesKey) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.exportScope, r10.exportScope) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.endpoints, r10.endpoints) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final List<String> getEndpoints() {
        return this.endpoints;
    }

    public final Integer getExportScope() {
        return this.exportScope;
    }

    public final String getPairingCode() {
        return this.pairingCode;
    }

    public final String getProtocolVersion() {
        return this.protocolVersion;
    }

    public final long getSenderAppVersionCode() {
        return this.senderAppVersionCode;
    }

    public final String getSenderUidHash() {
        return this.senderUidHash;
    }

    public final String getSenderUidSaltBase64() {
        return this.senderUidSaltBase64;
    }

    public final int getServerPort() {
        return this.serverPort;
    }

    public final String getSessionAesKey() {
        return this.sessionAesKey;
    }

    public int hashCode() {
        String r0 = this.protocolVersion;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.senderUidHash;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.senderUidSaltBase64;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((((r6 + r8) * 31) + Long.hashCode(this.senderAppVersionCode)) * 31) + Integer.hashCode(this.serverPort)) * 31;
        String r10 = this.pairingCode;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.sessionAesKey;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.exportScope;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<String> r19 = this.endpoints;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
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

    public String toString() {
        return "QrPayload(protocolVersion=" + this.protocolVersion + ", senderUidHash=" + this.senderUidHash + ", senderUidSaltBase64=" + this.senderUidSaltBase64 + ", senderAppVersionCode=" + this.senderAppVersionCode + ", serverPort=" + this.serverPort + ", pairingCode=" + this.pairingCode + ", sessionAesKey=" + this.sessionAesKey + ", exportScope=" + this.exportScope + ", endpoints=" + this.endpoints + ')';
    }
}
