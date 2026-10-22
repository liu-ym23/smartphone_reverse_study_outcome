package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jt\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0015\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\f\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006."}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallRustApiRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "command", BuildConfig.FLAVOR, "params", BuildConfig.FLAVOR, "pb", "Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;", "collectTrace", BuildConfig.FLAVOR, "contextId", "extendParams", "isPacketBuffer", "spanId", "userId", "<init>", "(ILjava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getCommand", "()I", "getParams", "()Ljava/lang/String;", "getPb", "()Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;", "getCollectTrace", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getContextId", "getExtendParams", "getSpanId", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallRustApiRequest;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITransport$Internal$CallRustApiRequest implements NonProguard {
    private final Boolean collectTrace;
    private final int command;
    private final String contextId;
    private final String extendParams;
    private final Boolean isPacketBuffer;
    private final String params;
    private final ITransport$Internal$Protobuf pb;
    private final String spanId;
    private final String userId;

    public static /* synthetic */ ITransport$Internal$CallRustApiRequest copy$default(ITransport$Internal$CallRustApiRequest r10, int r11, String r12, ITransport$Internal$Protobuf r13, Boolean r14, String r15, String r16, Boolean r17, String r18, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        int r2 = r10.command;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.params;
    L11:
        if ((r20 & 4) == 0) goto L13;
        ITransport$Internal$Protobuf r4 = r10.pb;
    L15:
        if ((r20 & 8) == 0) goto L17;
        Boolean r5 = r10.collectTrace;
    L19:
        if ((r20 & 16) == 0) goto L21;
        String r6 = r10.contextId;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.extendParams;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Boolean r8 = r10.isPacketBuffer;
    L31:
        if ((r20 & 128) == 0) goto L33;
        String r9 = r10.spanId;
    L35:
        if ((r20 & 256) == 0) goto L37;
        String r1 = r10.userId;
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

    public final String component2() {
        return this.params;
    }

    public final ITransport$Internal$Protobuf component3() {
        return this.pb;
    }

    public final Boolean component4() {
        return this.collectTrace;
    }

    public final String component5() {
        return this.contextId;
    }

    public final String component6() {
        return this.extendParams;
    }

    public final Boolean component7() {
        return this.isPacketBuffer;
    }

    public final String component8() {
        return this.spanId;
    }

    public final String component9() {
        return this.userId;
    }

    public final ITransport$Internal$CallRustApiRequest copy(int r12, String r13, ITransport$Internal$Protobuf r14, Boolean r15, String r16, String r17, Boolean r18, String r19, String r20) {
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r14, "pb");
        return new ITransport$Internal$CallRustApiRequest(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ITransport$Internal$CallRustApiRequest) == true) goto L8;
        return false;
    L8:
        ITransport$Internal$CallRustApiRequest r6 = (ITransport$Internal$CallRustApiRequest) r5;
        if (this.command == r6.command) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pb, r6.pb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.collectTrace, r6.collectTrace) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.contextId, r6.contextId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.extendParams, r6.extendParams) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.isPacketBuffer, r6.isPacketBuffer) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.spanId, r6.spanId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.command * 31) + this.params.hashCode()) * 31) + this.pb.hashCode()) * 31;
        Boolean r1 = this.collectTrace;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.contextId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.extendParams;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Boolean r11 = this.isPacketBuffer;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.spanId;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.userId;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
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

    public String toString() {
        return "CallRustApiRequest(command=" + this.command + ", params=" + this.params + ", pb=" + this.pb + ", collectTrace=" + this.collectTrace + ", contextId=" + this.contextId + ", extendParams=" + this.extendParams + ", isPacketBuffer=" + this.isPacketBuffer + ", spanId=" + this.spanId + ", userId=" + this.userId + ')';
    }

    public final Boolean getCollectTrace() {
        return this.collectTrace;
    }

    public final int getCommand() {
        return this.command;
    }

    public final String getContextId() {
        return this.contextId;
    }

    public final String getExtendParams() {
        return this.extendParams;
    }

    public final String getParams() {
        return this.params;
    }

    public final ITransport$Internal$Protobuf getPb() {
        return this.pb;
    }

    public final String getSpanId() {
        return this.spanId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Boolean isPacketBuffer() {
        return this.isPacketBuffer;
    }

    public ITransport$Internal$CallRustApiRequest(int r2, String r3, ITransport$Internal$Protobuf r4, Boolean r5, String r6, String r7, Boolean r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "pb");
        this.command = r2;
        this.params = r3;
        this.pb = r4;
        this.collectTrace = r5;
        this.contextId = r6;
        this.extendParams = r7;
        this.isPacketBuffer = r8;
        this.spanId = r9;
        this.userId = r10;
    }
}
