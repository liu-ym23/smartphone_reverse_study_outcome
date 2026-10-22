package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/ae1;", "", "", "channelId", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "", "enterFromMerges", "Ljava/util/List;", "getEnterFromMerges", "()Ljava/util/List;", "enterMethods", "getEnterMethods", "a", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ae1 {
    public static final a a = null;

    @SerializedName("channel")
    private final String channelId;

    @SerializedName("enter_from_merges")
    private final List<String> enterFromMerges;

    @SerializedName("enter_methods")
    private final List<String> enterMethods;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ae1) == false) goto L12;
        ae1 r4 = (ae1) r3;
        if (Intrinsics.areEqual(this.channelId, r4.channelId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.enterFromMerges, r4.enterFromMerges) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterMethods, r4.enterMethods) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.channelId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.enterFromMerges;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<String> r7 = this.enterMethods;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "PangleFeedArgsConfig(channelId=" + this.channelId + ", enterFromMerges=" + this.enterFromMerges + ", enterMethods=" + this.enterMethods + ")";
    }

    static {
        a = new a();
    }
}
