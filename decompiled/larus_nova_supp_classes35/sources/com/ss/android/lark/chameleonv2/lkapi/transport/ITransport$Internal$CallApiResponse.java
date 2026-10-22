package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003Bm\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J%\u0010%\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bHÆ\u0003J\u000e\u0010&\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u001bJ\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\nHÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u008c\u0001\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b2\b\b\u0002\u0010\f\u001a\u00028\u00002\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00072\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001f¨\u00063"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallApiResponse;", "T", "Ljava/io/Serializable;", "Lcom/bytedance/ee/util/io/NonProguard;", "command", BuildConfig.FLAVOR, "hasError", BuildConfig.FLAVOR, "packetBizMeta", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lkotlin/collections/HashMap;", ChameleonOpenTracker.ParamKey.RESULT, "rustApiCostTimeMs", "sdkUserId", "trace", "verifyUserId", "packetBuffer", "<init>", "(IZLjava/util/HashMap;Ljava/io/Serializable;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getCommand", "()I", "getHasError", "()Z", "getPacketBizMeta", "()Ljava/util/HashMap;", "getResult", "()Ljava/io/Serializable;", "Ljava/io/Serializable;", "getRustApiCostTimeMs", "getSdkUserId", "()Ljava/lang/String;", "getTrace", "getVerifyUserId", "getPacketBuffer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IZLjava/util/HashMap;Ljava/io/Serializable;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallApiResponse;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITransport$Internal$CallApiResponse<T extends Serializable> implements NonProguard {
    private final int command;
    private final boolean hasError;
    private final HashMap<String, String> packetBizMeta;
    private final String packetBuffer;
    private final T result;
    private final int rustApiCostTimeMs;
    private final String sdkUserId;
    private final String trace;
    private final boolean verifyUserId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ITransport$Internal$CallApiResponse copy$default(ITransport$Internal$CallApiResponse r10, int r11, boolean r12, HashMap r13, Serializable r14, int r15, String r16, String r17, boolean r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r2 = r10.command;
    L7:
        if ((r20 & 2) == 0) goto L9;
        boolean r3 = r10.hasError;
    L11:
        if ((r20 & 4) == 0) goto L13;
        HashMap r4 = r10.packetBizMeta;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Serializable r5 = r10.result;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r6 = r10.rustApiCostTimeMs;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.sdkUserId;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r8 = r10.trace;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r9 = r10.verifyUserId;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.packetBuffer;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final int component1() {
        return this.command;
    }

    public final boolean component2() {
        return this.hasError;
    }

    public final HashMap<String, String> component3() {
        return this.packetBizMeta;
    }

    public final T component4() {
        return this.result;
    }

    public final int component5() {
        return this.rustApiCostTimeMs;
    }

    public final String component6() {
        return this.sdkUserId;
    }

    public final String component7() {
        return this.trace;
    }

    public final boolean component8() {
        return this.verifyUserId;
    }

    public final String component9() {
        return this.packetBuffer;
    }

    public final ITransport$Internal$CallApiResponse<T> copy(int r12, boolean r13, HashMap<String, String> r14, T r15, int r16, String r17, String r18, boolean r19, String r20) {
        Intrinsics.checkNotNullParameter(r14, "packetBizMeta");
        Intrinsics.checkNotNullParameter(r15, ChameleonOpenTracker.ParamKey.RESULT);
        Intrinsics.checkNotNullParameter(r17, "sdkUserId");
        Intrinsics.checkNotNullParameter(r18, "trace");
        return new ITransport$Internal$CallApiResponse(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ITransport$Internal$CallApiResponse) == true) goto L8;
        return false;
    L8:
        ITransport$Internal$CallApiResponse r6 = (ITransport$Internal$CallApiResponse) r5;
        if (this.command == r6.command) goto L12;
        return false;
    L12:
        if (this.hasError == r6.hasError) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packetBizMeta, r6.packetBizMeta) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.result, r6.result) == true) goto L21;
        return false;
    L21:
        if (this.rustApiCostTimeMs == r6.rustApiCostTimeMs) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sdkUserId, r6.sdkUserId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.trace, r6.trace) == true) goto L30;
        return false;
    L30:
        if (this.verifyUserId == r6.verifyUserId) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.packetBuffer, r6.packetBuffer) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = this.command * 31;
        int r2 = 1231;
        if (this.hasError == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((((((((((r0 + r1) * 31) + this.packetBizMeta.hashCode()) * 31) + this.result.hashCode()) * 31) + this.rustApiCostTimeMs) * 31) + this.sdkUserId.hashCode()) * 31) + this.trace.hashCode()) * 31;
        if (this.verifyUserId == true) goto L10;
        r2 = 1237;
    L10:
        int r4 = (r3 + r2) * 31;
        String r5 = this.packetBuffer;
        if (r5 != null) goto L13;
        int r6 = 0;
    L15:
        return r4 + r6;
    L13:
        r6 = r5.hashCode();
        goto L15
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "CallApiResponse(command=" + this.command + ", hasError=" + this.hasError + ", packetBizMeta=" + this.packetBizMeta + ", result=" + this.result + ", rustApiCostTimeMs=" + this.rustApiCostTimeMs + ", sdkUserId=" + this.sdkUserId + ", trace=" + this.trace + ", verifyUserId=" + this.verifyUserId + ", packetBuffer=" + this.packetBuffer + ')';
    }

    public final int getCommand() {
        return this.command;
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    public final HashMap<String, String> getPacketBizMeta() {
        return this.packetBizMeta;
    }

    public final String getPacketBuffer() {
        return this.packetBuffer;
    }

    public final T getResult() {
        return this.result;
    }

    public final int getRustApiCostTimeMs() {
        return this.rustApiCostTimeMs;
    }

    public final String getSdkUserId() {
        return this.sdkUserId;
    }

    public final String getTrace() {
        return this.trace;
    }

    public final boolean getVerifyUserId() {
        return this.verifyUserId;
    }

    public ITransport$Internal$CallApiResponse(int r2, boolean r3, HashMap<String, String> r4, T r5, int r6, String r7, String r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r4, "packetBizMeta");
        Intrinsics.checkNotNullParameter(r5, ChameleonOpenTracker.ParamKey.RESULT);
        Intrinsics.checkNotNullParameter(r7, "sdkUserId");
        Intrinsics.checkNotNullParameter(r8, "trace");
        this.command = r2;
        this.hasError = r3;
        this.packetBizMeta = r4;
        this.result = r5;
        this.rustApiCostTimeMs = r6;
        this.sdkUserId = r7;
        this.trace = r8;
        this.verifyUserId = r9;
        this.packetBuffer = r10;
    }
}
