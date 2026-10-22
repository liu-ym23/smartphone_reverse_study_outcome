package com.bytedance.ai.settings.provider;

import androidx.constraintlayout.motion.widget.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/settings/provider/OptimizeSettings;", "", "", "a", "Z", "getOptimizeRender", "()Z", "optimizeRender", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OptimizeSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("optimize_render")
    private final boolean f2780a;

    public OptimizeSettings() {
        this.f2780a = true;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OptimizeSettings) == true) goto L9;
        return false;
    L9:
        if (this.f2780a == ((OptimizeSettings) r5).f2780a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f2780a);
    }

    public final String toString() {
        return a.w(new StringBuilder("OptimizeSettings(optimizeRender="), this.f2780a, ')');
    }

    public OptimizeSettings(int r5) {
        this.f2780a = true;
    }
}
