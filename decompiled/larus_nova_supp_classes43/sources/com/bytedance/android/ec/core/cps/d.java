package com.bytedance.android.ec.core.cps;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/core/cps/d;", "", "", "function", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "version", "g", "createTime", "b", "salt", "f", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "hashEncoder", "d", "cnt", "a", "rule", "e", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("pc")
    private final Integer cnt;

    @SerializedName("ct")
    private final String createTime;

    @SerializedName("f")
    private final String function;

    @SerializedName("am")
    private final String hashEncoder;

    @SerializedName("r")
    private final String rule;

    @SerializedName("s")
    private final String salt;

    @SerializedName("t")
    private final Integer type;

    @SerializedName("v")
    private final String version;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof d) == false) goto L22;
        d r11 = (d) r10;
        if (Intrinsics.areEqual(this.function, r11.function) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.version, r11.version) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.createTime, r11.createTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.salt, r11.salt) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.type, r11.type) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.hashEncoder, r11.hashEncoder) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.cnt, r11.cnt) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.rule, r11.rule) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        String r0 = this.function;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.version;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.createTime;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.salt;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        Integer r21 = this.type;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        String r24 = this.hashEncoder;
        if (r24 == null) goto L25;
        int r25 = r24.hashCode();
    L26:
        int r26 = (r23 + r25) * 31;
        Integer r27 = this.cnt;
        if (r27 == null) goto L29;
        int r28 = r27.hashCode();
    L30:
        int r29 = (r26 + r28) * 31;
        String r30 = this.rule;
        if (r30 == null) goto L34;
        r1 = r30.hashCode();
    L34:
        return r29 + r1;
    L29:
        r28 = 0;
        goto L30
    L25:
        r25 = 0;
        goto L26
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicEventConfig(function=" + this.function + ", version=" + this.version + ", createTime=" + this.createTime + ", salt=" + this.salt + ", type=" + this.type + ", hashEncoder=" + this.hashEncoder + ", cnt=" + this.cnt + ", rule=" + this.rule + ")";
    }

    public d() {
        this.function = null;
        this.version = null;
        this.createTime = null;
        this.salt = null;
        this.type = null;
        this.hashEncoder = null;
        this.cnt = null;
        this.rule = null;
    }

    public final Integer a() {
        return this.cnt;
    }

    public final String b() {
        return this.createTime;
    }

    public final String c() {
        return this.function;
    }

    public final String d() {
        return this.hashEncoder;
    }

    public final String e() {
        return this.rule;
    }

    public final String f() {
        return this.salt;
    }

    public final String g() {
        return this.version;
    }

    public final Integer getType() {
        return this.type;
    }
}
