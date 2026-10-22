package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u000e\u0010\u0012\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$TransportPushDetail;", "T", "Lcom/bytedance/ee/util/io/NonProguard;", "command", BuildConfig.FLAVOR, "content", "packet", "Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$RustSdkPacketDetail;", "<init>", "(ILjava/lang/Object;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$RustSdkPacketDetail;)V", "getCommand", "()I", "getContent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPacket", "()Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$RustSdkPacketDetail;", "component1", "component2", "component3", "copy", "(ILjava/lang/Object;Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$RustSdkPacketDetail;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Ipc$TransportPushDetail;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITransport$Ipc$TransportPushDetail<T> implements NonProguard {
    private final int command;
    private final T content;
    private final ITransport$Ipc$RustSdkPacketDetail packet;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ITransport$Ipc$TransportPushDetail copy$default(ITransport$Ipc$TransportPushDetail r0, int r1, Object r2, ITransport$Ipc$RustSdkPacketDetail r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.command;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.packet;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.command;
    }

    public final T component2() {
        return this.content;
    }

    public final ITransport$Ipc$RustSdkPacketDetail component3() {
        return this.packet;
    }

    public final ITransport$Ipc$TransportPushDetail<T> copy(int r2, T r3, ITransport$Ipc$RustSdkPacketDetail r4) {
        Intrinsics.checkNotNullParameter(r4, "packet");
        return new ITransport$Ipc$TransportPushDetail(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ITransport$Ipc$TransportPushDetail) == true) goto L8;
        return false;
    L8:
        ITransport$Ipc$TransportPushDetail r6 = (ITransport$Ipc$TransportPushDetail) r5;
        if (this.command == r6.command) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packet, r6.packet) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = this.command * 31;
        T r1 = this.content;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.packet.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "TransportPushDetail(command=" + this.command + ", content=" + this.content + ", packet=" + this.packet + ')';
    }

    public final int getCommand() {
        return this.command;
    }

    public final T getContent() {
        return this.content;
    }

    public final ITransport$Ipc$RustSdkPacketDetail getPacket() {
        return this.packet;
    }

    public ITransport$Ipc$TransportPushDetail(int r2, T r3, ITransport$Ipc$RustSdkPacketDetail r4) {
        Intrinsics.checkNotNullParameter(r4, "packet");
        this.command = r2;
        this.content = r3;
        this.packet = r4;
    }
}
