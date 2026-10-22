package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/l41;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "", "enableScene", "Ljava/util/List;", "b", "()Ljava/util/List;", "setEnableScene", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdk/config/g8;", "recFeatureConfig", "c", "setRecFeatureConfig", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l41 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_scene")
    private List<String> enableScene;

    @SerializedName("enable_feature")
    private List<g8> recFeatureConfig;

    public l41() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l41) == false) goto L12;
        l41 r4 = (l41) r3;
        if (this.enable == r4.enable) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enableScene, r4.enableScene) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.recFeatureConfig, r4.recFeatureConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r0 = this.enable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        List<String> r3 = this.enableScene;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        List<g8> r7 = this.recFeatureConfig;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public final String toString() {
        return "LiveInnerRecFeatureABConfig(enable=" + this.enable + ", enableScene=" + this.enableScene + ", recFeatureConfig=" + this.recFeatureConfig + ")";
    }

    public final boolean a() {
        return this.enable;
    }

    public final List<String> b() {
        return this.enableScene;
    }

    public final List<g8> c() {
        return this.recFeatureConfig;
    }

    public l41(Object r7) {
        List<String> r8 = CollectionsKt.listOf("homepage_hot");
        List<g8> r0 = CollectionsKt.listOf(new g8[]{new g8("preclk", "double"), new g8("ctr0", "double"), new g8("mq2_is_base_send", "int"), new g8("mq2_is_ecom_send", "int"), new g8("mq2_is_revenue_send", "int"), new g8("mq2_is_groupon_send", "int"), new g8("mq3_is_main_send", "int"), new g8("staytime", "double")});
        this.enable = false;
        this.enableScene = r8;
        this.recFeatureConfig = r0;
    }
}
