package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/config/n21;", "", "", "useDouyinAccessKey", "Z", "c", "()Z", "useDouyinHost", "d", "", "", "removeEffectTabList", "Ljava/util/List;", "a", "()Ljava/util/List;", "removeInteractSticker", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n21 {
    public static final /* synthetic */ int a = 0;

    @SerializedName("remove_effect_tab_list")
    private final List<String> removeEffectTabList;

    @SerializedName("remove_interact_sticker")
    private final Boolean removeInteractSticker;

    @SerializedName("use_douyin_access_key")
    private final boolean useDouyinAccessKey;

    @SerializedName("use_douyin_access_host")
    private final boolean useDouyinHost;

    public static final class a {
        public static boolean a() {
            return mq.a.getValue().c();
        }
    }

    static {
    }

    public n21() {
        this(null);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n21) == false) goto L14;
        n21 r4 = (n21) r3;
        if (this.useDouyinAccessKey == r4.useDouyinAccessKey) goto L8;
        return false;
    L8:
        if (this.useDouyinHost == r4.useDouyinHost) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.removeEffectTabList, r4.removeEffectTabList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.removeInteractSticker, r4.removeInteractSticker) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        boolean r0 = this.useDouyinAccessKey;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.useDouyinHost;
        if (r4 == true) goto L9;
        r1 = r4;
    L9:
        int r5 = (r3 + r1) * 31;
        List<String> r6 = this.removeEffectTabList;
        int r7 = 0;
        if (r6 == null) goto L12;
        int r8 = r6.hashCode();
    L13:
        int r9 = (r5 + r8) * 31;
        Boolean r10 = this.removeInteractSticker;
        if (r10 == null) goto L17;
        r7 = r10.hashCode();
    L17:
        return r9 + r7;
    L12:
        r8 = 0;
        goto L13
    }

    public final String toString() {
        return "LiveEffectSaasInitConfig(useDouyinAccessKey=" + this.useDouyinAccessKey + ", useDouyinHost=" + this.useDouyinHost + ", removeEffectTabList=" + this.removeEffectTabList + ", removeInteractSticker=" + this.removeInteractSticker + ")";
    }

    public final List<String> a() {
        return this.removeEffectTabList;
    }

    public final Boolean b() {
        return this.removeInteractSticker;
    }

    public final boolean c() {
        return this.useDouyinAccessKey;
    }

    public final boolean d() {
        return this.useDouyinHost;
    }

    public n21(Object r3) {
        List<String> r4 = CollectionsKt.listOf("41931");
        Boolean r0 = Boolean.TRUE;
        this.useDouyinAccessKey = true;
        this.useDouyinHost = true;
        this.removeEffectTabList = r4;
        this.removeInteractSticker = r0;
    }
}
