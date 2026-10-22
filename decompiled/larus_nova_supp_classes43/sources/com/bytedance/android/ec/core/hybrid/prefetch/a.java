package com.bytedance.android.ec.core.hybrid.prefetch;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/prefetch/a;", "", "", "keyPath", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "bizTag", "a", "sceneTag", "c", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("biz_tag")
    private final String bizTag;

    @SerializedName("preload_imgs_key_path")
    private final String keyPath;

    @SerializedName("scene_tag")
    private final String sceneTag;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == false) goto L12;
        a r11 = (a) r10;
        if (Intrinsics.areEqual(this.keyPath, r11.keyPath) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bizTag, r11.bizTag) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sceneTag, r11.sceneTag) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.keyPath;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.bizTag;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.sceneTag;
        if (r15 == null) goto L14;
        r1 = r15.hashCode();
    L14:
        return r14 + r1;
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public final String toString() {
        return "ApiPreloadConfig(keyPath=" + this.keyPath + ", bizTag=" + this.bizTag + ", sceneTag=" + this.sceneTag + ")";
    }

    public a() {
        this.keyPath = null;
        this.bizTag = null;
        this.sceneTag = null;
    }

    public final String a() {
        return this.bizTag;
    }

    public final String b() {
        return this.keyPath;
    }

    public final String c() {
        return this.sceneTag;
    }
}
