package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyCommonGadgetPushRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "isOnline", BuildConfig.FLAVOR, "biz", BuildConfig.FLAVOR, "timestamp", Keys.API_RETURN_KEY_DATA, "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getBiz", "()Ljava/lang/String;", "getTimestamp", "getData", "component1", "component2", "component3", "component4", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyCommonGadgetPushRequest implements NonProguard {
    private final String biz;
    private final String data;
    private final boolean isOnline;
    private final String timestamp;

    public static /* synthetic */ MyCommonGadgetPushRequest copy$default(MyCommonGadgetPushRequest r0, boolean r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.isOnline;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.biz;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.timestamp;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.data;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.isOnline;
    }

    public final String component2() {
        return this.biz;
    }

    public final String component3() {
        return this.timestamp;
    }

    public final String component4() {
        return this.data;
    }

    public final MyCommonGadgetPushRequest copy(boolean r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "biz");
        return new MyCommonGadgetPushRequest(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MyCommonGadgetPushRequest) == true) goto L8;
        return false;
    L8:
        MyCommonGadgetPushRequest r6 = (MyCommonGadgetPushRequest) r5;
        if (this.isOnline == r6.isOnline) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.biz, r6.biz) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.timestamp, r6.timestamp) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.isOnline == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.biz.hashCode()) * 31;
        String r2 = this.timestamp;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.data;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "MyCommonGadgetPushRequest(isOnline=" + this.isOnline + ", biz=" + this.biz + ", timestamp=" + this.timestamp + ", data=" + this.data + ')';
    }

    public final String getBiz() {
        return this.biz;
    }

    public final String getData() {
        return this.data;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final boolean isOnline() {
        return this.isOnline;
    }

    public MyCommonGadgetPushRequest(boolean r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "biz");
        this.isOnline = r2;
        this.biz = r3;
        this.timestamp = r4;
        this.data = r5;
    }
}
