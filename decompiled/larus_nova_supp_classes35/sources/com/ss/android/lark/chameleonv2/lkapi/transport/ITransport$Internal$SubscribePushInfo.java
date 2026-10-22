package com.ss.android.lark.chameleonv2.lkapi.transport;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/ITransport$Internal$SubscribePushInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "command", BuildConfig.FLAVOR, "pb", BuildConfig.FLAVOR, "<init>", "(ILjava/lang/String;)V", "getCommand", "()I", "getPb", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ITransport$Internal$SubscribePushInfo implements NonProguard {
    private final int command;
    private final String pb;

    public static /* synthetic */ ITransport$Internal$SubscribePushInfo copy$default(ITransport$Internal$SubscribePushInfo r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.command;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.pb;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.command;
    }

    public final String component2() {
        return this.pb;
    }

    public final ITransport$Internal$SubscribePushInfo copy(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "pb");
        return new ITransport$Internal$SubscribePushInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ITransport$Internal$SubscribePushInfo) == true) goto L8;
        return false;
    L8:
        ITransport$Internal$SubscribePushInfo r6 = (ITransport$Internal$SubscribePushInfo) r5;
        if (this.command == r6.command) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pb, r6.pb) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.command * 31) + this.pb.hashCode();
    }

    public String toString() {
        return "SubscribePushInfo(command=" + this.command + ", pb=" + this.pb + ')';
    }

    public final int getCommand() {
        return this.command;
    }

    public final String getPb() {
        return this.pb;
    }

    public ITransport$Internal$SubscribePushInfo(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "pb");
        this.command = r2;
        this.pb = r3;
    }
}
