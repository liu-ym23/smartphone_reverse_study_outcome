package com.bytedance.android.live.ktv.common.model.api;

import com.bytedance.android.livesdk.d9;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/s0;", "", "", "openUid", "Ljava/lang/String;", "getOpenUid", "()Ljava/lang/String;", "getOpenUid$annotations", "()V", "", "uid", "Ljava/lang/Long;", "getUid", "()Ljava/lang/Long;", "getUid$annotations", "nickName", "b", "Lpy/k;", "avatar", "Lpy/k;", "a", "()Lpy/k;", "uidStr", "getUidStr", "getUidStr$annotations", "secUid", "c", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class s0 implements vh7.h {

    @SerializedName("avatar")
    protected py.k avatar;

    @SerializedName("nickname")
    protected String nickName;

    @IgnoreProtoFieldCheck
    @SerializedName("open_id")
    protected String openUid;

    @IgnoreProtoFieldCheck
    @SerializedName("sec_uid")
    protected String secUid;

    @IgnoreProtoFieldCheck
    @SerializedName("uid")
    protected Long uid;

    @IgnoreProtoFieldCheck
    @SerializedName("uid_str")
    protected String uidStr;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s0) == false) goto L18;
        s0 r4 = (s0) r3;
        if (Intrinsics.areEqual(this.openUid, r4.openUid) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.uid, r4.uid) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.nickName, r4.nickName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatar, r4.avatar) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.uidStr, r4.uidStr) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.secUid, r4.secUid) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r0 = this.openUid;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.uid;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.nickName;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        py.k r11 = this.avatar;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.uidStr;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.secUid;
        if (r17 == null) goto L26;
        r1 = r17.hashCode();
    L26:
        return r16 + r1;
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ReportMidiScoreResponseUserInfo(openUid=" + this.openUid + ", uid=" + this.uid + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ", uidStr=" + this.uidStr + ", secUid=" + this.secUid + ")";
    }

    public final String d() {
        String r0 = d9.a(this.uidStr);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return d9.c(this.uid, this.openUid);
    }

    public s0() {
        this.openUid = null;
        this.uid = null;
        this.nickName = null;
        this.avatar = null;
        this.uidStr = null;
        this.secUid = null;
    }

    public final py.k a() {
        return this.avatar;
    }

    public final String b() {
        return this.nickName;
    }

    public final String c() {
        return this.secUid;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object, py.k] */
    public s0(am3.g r5) {
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L24;
        if (r2 != 1) goto L8;
        this.uid = Long.valueOf(r5.j());
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.nickName = am3.h.c(r5);
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.avatar = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.uidStr = am3.h.c(r5);
        goto L3
    L14:
        if (r2 != 5) goto L16;
        this.secUid = am3.h.c(r5);
        goto L3
    L16:
        if (r2 != 5000) goto L17;
        this.openUid = am3.h.c(r5);
        goto L3
    L17:
        am3.h.e(r5);
        goto L3
    L24:
        r5.d(r0);
        if (this.openUid != null) goto L28;
        this.openUid = null;
    L28:
        if (this.uid != null) goto L31;
        this.uid = null;
    L31:
        if (this.nickName != null) goto L34;
        this.nickName = null;
    L34:
        if (this.avatar != null) goto L37;
        this.avatar = null;
    L37:
        if (this.uidStr != null) goto L40;
        this.uidStr = null;
    L40:
        if (this.secUid != null) goto L64;
        this.secUid = null;
        return;
    }
}
