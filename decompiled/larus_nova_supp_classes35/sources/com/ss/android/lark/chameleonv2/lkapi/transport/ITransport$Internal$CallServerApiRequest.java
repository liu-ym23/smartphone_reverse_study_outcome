package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003JP\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\t\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallServerApiRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "command", BuildConfig.FLAVOR, "params", BuildConfig.FLAVOR, "pb", "Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;", "contextId", "isPacketBuffer", BuildConfig.FLAVOR, "userId", "<init>", "(ILjava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getCommand", "()I", "getParams", "()Ljava/lang/String;", "getPb", "()Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;", "getContextId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$Protobuf;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$CallServerApiRequest;", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITransport$Internal$CallServerApiRequest implements NonProguard {
    private final int command;
    private final String contextId;
    private final Boolean isPacketBuffer;
    private final String params;
    private final ITransport$Internal$Protobuf pb;
    private final String userId;

    public static /* synthetic */ ITransport$Internal$CallServerApiRequest copy$default(ITransport$Internal$CallServerApiRequest r4, int r5, String r6, ITransport$Internal$Protobuf r7, String r8, Boolean r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.command;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.params;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.pb;
    L11:
        ITransport$Internal$Protobuf r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.contextId;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.isPacketBuffer;
    L17:
        Boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.userId;
    L20:
        int r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
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

    public final String component4() {
        return this.contextId;
    }

    public final Boolean component5() {
        return this.isPacketBuffer;
    }

    public final String component6() {
        return this.userId;
    }

    public final ITransport$Internal$CallServerApiRequest copy(int r9, String r10, ITransport$Internal$Protobuf r11, String r12, Boolean r13, String r14) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "pb");
        return new ITransport$Internal$CallServerApiRequest(r9, r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ITransport$Internal$CallServerApiRequest) == true) goto L8;
        return false;
    L8:
        ITransport$Internal$CallServerApiRequest r6 = (ITransport$Internal$CallServerApiRequest) r5;
        if (this.command == r6.command) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pb, r6.pb) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.contextId, r6.contextId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.isPacketBuffer, r6.isPacketBuffer) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.command * 31) + this.params.hashCode()) * 31) + this.pb.hashCode()) * 31;
        String r1 = this.contextId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Boolean r5 = this.isPacketBuffer;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.userId;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "CallServerApiRequest(command=" + this.command + ", params=" + this.params + ", pb=" + this.pb + ", contextId=" + this.contextId + ", isPacketBuffer=" + this.isPacketBuffer + ", userId=" + this.userId + ')';
    }

    public final int getCommand() {
        return this.command;
    }

    public final String getContextId() {
        return this.contextId;
    }

    public final String getParams() {
        return this.params;
    }

    public final ITransport$Internal$Protobuf getPb() {
        return this.pb;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final Boolean isPacketBuffer() {
        return this.isPacketBuffer;
    }

    public ITransport$Internal$CallServerApiRequest(int r2, String r3, ITransport$Internal$Protobuf r4, String r5, Boolean r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "pb");
        this.command = r2;
        this.params = r3;
        this.pb = r4;
        this.contextId = r5;
        this.isPacketBuffer = r6;
        this.userId = r7;
    }
}
