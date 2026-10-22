package com.bytedance.ai.settings.provider;

import androidx.constraintlayout.motion.widget.a;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ai/settings/provider/LynxTemplateVerifyConfig;", "", "", "", "a", "Ljava/util/List;", "getInnerDomains", "()Ljava/util/List;", "innerDomains", "", "b", "Z", "getEnableIntercept", "()Z", "enableIntercept", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LynxTemplateVerifyConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("inner_domains")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> f2777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("enable_intercept")
    private final boolean f2778b;

    public LynxTemplateVerifyConfig() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof LynxTemplateVerifyConfig) == true) goto L8;
        return false;
    L8:
        LynxTemplateVerifyConfig r10 = (LynxTemplateVerifyConfig) r5;
        if (Intrinsics.areEqual(this.f2777a, r10.f2777a) == true) goto L12;
        return false;
    L12:
        if (this.f2778b == r10.f2778b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<String> r5 = this.f2777a;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = Boolean.hashCode(this.f2778b);
        return r11 + (r10 * 31);
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("LynxTemplateVerifyConfig(innerDomains=");
        r5.append(this.f2777a);
        r5.append(", enableIntercept=");
        return a.w(r5, this.f2778b, ')');
    }

    public LynxTemplateVerifyConfig(int r5) {
        this.f2777a = CollectionsKt.listOf(new String[]{".bytegecko.com", ".byted.org"});
        this.f2778b = true;
    }
}
