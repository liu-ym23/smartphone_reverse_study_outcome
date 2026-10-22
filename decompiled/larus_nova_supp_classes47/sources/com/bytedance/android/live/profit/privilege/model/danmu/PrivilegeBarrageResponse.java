package com.bytedance.android.live.profit.privilege.model.danmu;

import com.bytedance.android.live.base.model.user.IBaseUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u000e\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u000e\u0010\u0018\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f¢\u0006\u0004\b1\u00102J\u0011\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\b\u001a\u00020\u0007HÆ\u0003J\t\u0010\t\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\t\u0010\r\u001a\u00020\u000bHÆ\u0003J\u0011\u0010\u0010\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fHÆ\u0003Jm\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fHÆ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001f\u0010\u0011\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010\u0013\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0014\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b(\u0010'R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b)\u0010$R\u0017\u0010\u0016\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010\u0017\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010*\u001a\u0004\b-\u0010,R\u001f\u0010\u0018\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8\u0006¢\u0006\f\n\u0004\b\u0018\u0010.\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/danmu/PrivilegeBarrageResponse;", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/android/live/base/model/user/IBaseUserKt;", "component1", "", "component2", "", "component3", "component4", "component5", "", "component6", "component7", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "component8", "user", "orderId", "leftDiamond", "msgId", "toast", "skin", "showIdentity", "identityLabel", "copy", "toString", "hashCode", "other", "", "equals", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "getUser", "()Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Ljava/lang/String;", "getOrderId", "()Ljava/lang/String;", "J", "getLeftDiamond", "()J", "getMsgId", "getToast", "I", "getSkin", "()I", "getShowIdentity", "Lpy/k;", "getIdentityLabel", "()Lpy/k;", "<init>", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;Ljava/lang/String;JJLjava/lang/String;IILpy/k;)V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PrivilegeBarrageResponse {
    private final k identityLabel;
    private final long leftDiamond;
    private final long msgId;
    private final String orderId;
    private final int showIdentity;
    private final int skin;
    private final String toast;
    private final IBaseUser user;

    public static /* synthetic */ PrivilegeBarrageResponse copy$default(PrivilegeBarrageResponse r12, IBaseUser r13, String r14, long r15, long r16, String r18, int r19, int r20, k r22, int r23, Object r24) {
        if ((r23 & 1) == 0) goto L5;
        IBaseUser r2 = r12.user;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r3 = r12.orderId;
    L11:
        if ((r23 & 4) == 0) goto L13;
        long r4 = r12.leftDiamond;
    L15:
        if ((r23 & 8) == 0) goto L17;
        long r6 = r12.msgId;
    L19:
        if ((r23 & 16) == 0) goto L21;
        String r8 = r12.toast;
    L23:
        if ((r23 & 32) == 0) goto L25;
        int r9 = r12.skin;
    L27:
        if ((r23 & 64) == 0) goto L29;
        int r10 = r12.showIdentity;
    L31:
        if ((r23 & 128) == 0) goto L33;
        k r1 = r12.identityLabel;
    L35:
        return r12.copy(r2, r3, r4, r6, r8, r9, r10, r1);
    L33:
        r1 = r22;
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
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final IBaseUser component1() {
        return this.user;
    }

    public final String component2() {
        return this.orderId;
    }

    public final long component3() {
        return this.leftDiamond;
    }

    public final long component4() {
        return this.msgId;
    }

    public final String component5() {
        return this.toast;
    }

    public final int component6() {
        return this.skin;
    }

    public final int component7() {
        return this.showIdentity;
    }

    public final k component8() {
        return this.identityLabel;
    }

    public final PrivilegeBarrageResponse copy(IBaseUser r13, String r14, long r15, long r17, String r19, int r20, int r22, k r23) {
        return new PrivilegeBarrageResponse(r13, r14, r15, r17, r19, r20, r22, r23);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof PrivilegeBarrageResponse) == false) goto L22;
        PrivilegeBarrageResponse r7 = (PrivilegeBarrageResponse) r6;
        if (Intrinsics.areEqual(this.user, r7.user) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.orderId, r7.orderId) == true) goto L10;
        return false;
    L10:
        if (this.leftDiamond == r7.leftDiamond) goto L12;
        return false;
    L12:
        if (this.msgId == r7.msgId) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.toast, r7.toast) == true) goto L16;
        return false;
    L16:
        if (this.skin == r7.skin) goto L18;
        return false;
    L18:
        if (this.showIdentity == r7.showIdentity) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.identityLabel, r7.identityLabel) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        IBaseUser r0 = this.user;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.orderId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.leftDiamond;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.msgId;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        String r12 = this.toast;
        if (r12 == null) goto L13;
        int r13 = r12.hashCode();
    L14:
        int r14 = (((((r10 + r13) * 31) + this.skin) * 31) + this.showIdentity) * 31;
        k r15 = this.identityLabel;
        if (r15 == null) goto L18;
        r1 = r15.hashCode();
    L18:
        return r14 + r1;
    L13:
        r13 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PrivilegeBarrageResponse(user=" + this.user + ", orderId=" + this.orderId + ", leftDiamond=" + this.leftDiamond + ", msgId=" + this.msgId + ", toast=" + this.toast + ", skin=" + this.skin + ", showIdentity=" + this.showIdentity + ", identityLabel=" + this.identityLabel + ")";
    }

    public final k getIdentityLabel() {
        return this.identityLabel;
    }

    public final long getLeftDiamond() {
        return this.leftDiamond;
    }

    public final long getMsgId() {
        return this.msgId;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final int getShowIdentity() {
        return this.showIdentity;
    }

    public final int getSkin() {
        return this.skin;
    }

    public final String getToast() {
        return this.toast;
    }

    public final IBaseUser getUser() {
        return this.user;
    }

    public PrivilegeBarrageResponse(IBaseUser r1, String r2, long r3, long r5, String r7, int r8, int r9, k r10) {
        this.user = r1;
        this.orderId = r2;
        this.leftDiamond = r3;
        this.msgId = r5;
        this.toast = r7;
        this.skin = r8;
        this.showIdentity = r9;
        this.identityLabel = r10;
    }
}
