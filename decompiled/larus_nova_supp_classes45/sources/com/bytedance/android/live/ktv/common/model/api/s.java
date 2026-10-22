package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/s;", "", "", "content", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "", "Lcom/bytedance/android/live/ktv/common/model/api/t;", "poses", "Ljava/util/List;", "d", "()Ljava/util/List;", "setPoses", "(Ljava/util/List;)V", "color", "a", "setColor", "groupId", "c", "setGroupId", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class s implements vh7.h {
    public String a;

    @SerializedName("color")
    protected String color;

    @SerializedName("content")
    protected String content;

    @SerializedName("group_id")
    protected String groupId;

    @SerializedName("pos")
    protected List<t> poses;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof s) == false) goto L16;
        s r4 = (s) r3;
        if (Intrinsics.areEqual(this.content, r4.content) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.poses, r4.poses) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.color, r4.color) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.groupId, r4.groupId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.content;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<t> r4 = this.poses;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.color;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r11 = this.groupId;
        if (r11 == null) goto L17;
        int r12 = r11.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        String r14 = this.a;
        if (r14 == null) goto L22;
        r1 = r14.hashCode();
    L22:
        return r13 + r1;
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
        return "GuessWord(content=" + this.content + ", poses=" + this.poses + ", color=" + this.color + ", groupId=" + this.groupId + ", imprId=" + this.a + ")";
    }

    public s() {
        this.content = "";
        this.poses = new ArrayList();
        this.color = "#EBA825";
        this.groupId = "";
    }

    public final String a() {
        return this.color;
    }

    public final String b() {
        return this.content;
    }

    public final String c() {
        return this.groupId;
    }

    public final List<t> d() {
        return this.poses;
    }

    public s(am3.g r5) {
        this.poses = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L18;
        if (r2 != 1) goto L8;
        this.content = am3.h.c(r5);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.poses.add(new t(r5));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.color = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L13;
        this.groupId = am3.h.c(r5);
        goto L3
    L13:
        am3.h.e(r5);
        goto L3
    L18:
        r5.d(r0);
        if (this.content != null) goto L22;
        this.content = "";
    L22:
        if (this.poses.isEmpty() == false) goto L25;
        this.poses = new ArrayList();
    L25:
        if (this.color != null) goto L28;
        this.color = "#EBA825";
    L28:
        if (this.groupId != null) goto L46;
        this.groupId = "";
        return;
    }
}
