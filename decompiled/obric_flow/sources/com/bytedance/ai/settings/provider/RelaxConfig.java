package com.bytedance.ai.settings.provider;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kk.a;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/settings/provider/RelaxConfig;", "", "", "Lcom/bytedance/ai/settings/provider/WidgetDegradeSetting;", "a", "Ljava/util/List;", "()Ljava/util/List;", "degradeStragety", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "globalSettings", "c", "renderMode", "d", "rtsWorkerPackage", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RelaxConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("degrade_stragety")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<WidgetDegradeSetting> f2781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("relaxSettings")
    private final String f2782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("render_mode")
    private final String f2783c;

    @SerializedName("rts_worker_package")
    private final List<String> d;

    public RelaxConfig() {
        this(0);
    }

    public final List a() {
        return this.f2781a;
    }

    public final String b() {
        return this.f2782b;
    }

    public final String c() {
        return this.f2783c;
    }

    public final List d() {
        return this.d;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RelaxConfig) == true) goto L8;
        return false;
    L8:
        RelaxConfig r10 = (RelaxConfig) r5;
        if (Intrinsics.areEqual(this.f2781a, r10.f2781a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f2782b, r10.f2782b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f2783c, r10.f2783c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r10.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        List<WidgetDegradeSetting> r5 = this.f2781a;
        int r10 = 0;
        if (r5 != null) goto L5;
        int r11 = 0;
    L6:
        int r12 = r11 * 31;
        String r13 = this.f2782b;
        if (r13 == null) goto L11;
        r10 = r13.hashCode();
    L11:
        return this.d.hashCode() + a.b(this.f2783c, (r12 + r10) * 31, 31);
    L5:
        r11 = r5.hashCode();
        goto L6
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("RelaxConfig(degradeStragety=");
        r5.append(this.f2781a);
        r5.append(", globalSettings=");
        r5.append(this.f2782b);
        r5.append(", renderMode=");
        r5.append(this.f2783c);
        r5.append(", rtsWorkerPackage=");
        return androidx.constraintlayout.motion.widget.a.v(r5, this.d, ')');
    }

    public RelaxConfig(List r5, String r10, String r11, List r12) {
        Intrinsics.checkNotNullParameter(r11, "renderMode");
        Intrinsics.checkNotNullParameter(r12, "rtsWorkerPackage");
        this.f2781a = r5;
        this.f2782b = r10;
        this.f2783c = r11;
        this.d = r12;
    }

    public /* synthetic */ RelaxConfig(int r5) {
        this(CollectionsKt.emptyList(), "", "", CollectionsKt.emptyList());
    }
}
