package com.bytedance.android.ec.core.hybrid.prefetch;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/v;", "", "", "startTime", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "endTime", "b", "", "", "preloadImgs", "Ljava/util/List;", "c", "()Ljava/util/List;", "bizTag", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "sceneTag", "d", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v {

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("end_time")
    private final Long endTime;

    @SerializedName("preload_imgs")
    private final List<String> preloadImgs;

    @SerializedName("scene_tag")
    private final String sceneTag;

    @SerializedName("start_time")
    private final Long startTime;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof v) == false) goto L16;
        v r11 = (v) r10;
        if (Intrinsics.areEqual(this.startTime, r11.startTime) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.endTime, r11.endTime) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.preloadImgs, r11.preloadImgs) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bizTag, r11.bizTag) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.sceneTag, r11.sceneTag) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Long r0 = this.startTime;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        Long r12 = this.endTime;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        List<String> r15 = this.preloadImgs;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.bizTag;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        String r21 = this.sceneTag;
        if (r21 == null) goto L22;
        r1 = r21.hashCode();
    L22:
        return r20 + r1;
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
        return "StaticPreloadConfig(startTime=" + this.startTime + ", endTime=" + this.endTime + ", preloadImgs=" + this.preloadImgs + ", bizTag=" + this.bizTag + ", sceneTag=" + this.sceneTag + ")";
    }

    public v() {
        this.startTime = null;
        this.endTime = null;
        this.preloadImgs = null;
        this.bizTag = null;
        this.sceneTag = null;
    }

    public final String a() {
        return this.bizTag;
    }

    public final Long b() {
        return this.endTime;
    }

    public final List<String> c() {
        return this.preloadImgs;
    }

    public final String d() {
        return this.sceneTag;
    }

    public final Long e() {
        return this.startTime;
    }
}
