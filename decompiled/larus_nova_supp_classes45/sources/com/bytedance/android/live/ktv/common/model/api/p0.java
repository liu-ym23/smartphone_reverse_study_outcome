package com.bytedance.android.live.ktv.common.model.api;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/ktv/common/model/api/p0;", "", "", "prompt", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "promptWithEarphone", "b", "", "", "songIdList", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "isInWaitingList", "Z", "()Z", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class p0 implements vh7.h {

    @SerializedName("in_song_waiting_list")
    protected boolean isInWaitingList;

    @SerializedName("prompt")
    protected String prompt;

    @SerializedName("prompt_with_earphone")
    protected String promptWithEarphone;

    @SerializedName("succeed_song_id_list")
    protected List<Long> songIdList;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p0) == false) goto L14;
        p0 r4 = (p0) r3;
        if (Intrinsics.areEqual(this.prompt, r4.prompt) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promptWithEarphone, r4.promptWithEarphone) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.songIdList, r4.songIdList) == true) goto L12;
        return false;
    L12:
        if (this.isInWaitingList == r4.isInWaitingList) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        String r0 = this.prompt;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.promptWithEarphone;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<Long> r7 = this.songIdList;
        if (r7 == null) goto L13;
        r1 = r7.hashCode();
    L13:
        int r8 = (r6 + r1) * 31;
        boolean r9 = this.isInWaitingList;
        ?? r11 = r9;
        if (r9 == false) goto L17;
        r11 = 1;
    L17:
        return r8 + r11;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PromptsResult(prompt=" + this.prompt + ", promptWithEarphone=" + this.promptWithEarphone + ", songIdList=" + this.songIdList + ", isInWaitingList=" + this.isInWaitingList + ")";
    }

    public p0() {
        this.prompt = "";
        this.promptWithEarphone = "";
        this.songIdList = null;
        this.isInWaitingList = false;
    }

    public final String a() {
        return this.prompt;
    }

    public final String b() {
        return this.promptWithEarphone;
    }

    public final List<Long> c() {
        return this.songIdList;
    }

    public p0(am3.g r8) {
        this.songIdList = new ArrayList();
        long r0 = r8.c();
        boolean r3 = false;
    L3:
        int r4 = r8.f();
        if (r4 == (-1)) goto L17;
        if (r4 != 1) goto L7;
        this.prompt = am3.h.c(r8);
        goto L3
    L7:
        if (r4 != 2) goto L9;
        this.promptWithEarphone = am3.h.c(r8);
        goto L3
    L9:
        if (r4 != 3) goto L11;
        this.songIdList.add(Long.valueOf(r8.j()));
        goto L3
    L11:
        if (r4 != 4) goto L12;
        this.isInWaitingList = am3.h.a(r8);
        r3 = r3 | true;
        goto L3
    L12:
        am3.h.e(r8);
        goto L3
    L17:
        r8.d(r0);
        if (this.prompt != null) goto L21;
        this.prompt = "";
    L21:
        if (this.promptWithEarphone != null) goto L24;
        this.promptWithEarphone = "";
    L24:
        if (this.songIdList.isEmpty() == false) goto L27;
        this.songIdList = null;
    L27:
        if ((r3 & true) == true) goto L45;
        this.isInWaitingList = false;
        return;
    }
}
