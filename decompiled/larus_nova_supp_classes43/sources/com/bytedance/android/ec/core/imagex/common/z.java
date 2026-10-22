package com.bytedance.android.ec.core.imagex.common;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/common/z;", "Lcom/bytedance/android/shopping/api/image/d$b;", "", "Lcom/bytedance/android/shopping/api/image/d;", "supportMather", "Ljava/util/List;", "e", "()Ljava/util/List;", "", "matchersType", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "", "ignoreMatch", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "isExperiment", "b", "experimentKey", "a", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public class z implements com.bytedance.android.shopping.api.image.d.b {

    @SerializedName("experiment_key")
    private final String experimentKey;

    @SerializedName("ignore_match")
    private final Boolean ignoreMatch;

    @SerializedName("is_experiment")
    private final Boolean isExperiment;

    @SerializedName("matchers_type")
    private final String matchersType;

    @SerializedName("support_mather")
    private final List<com.bytedance.android.shopping.api.image.d> supportMather;

    public z() {
    }

    public final String a() {
        return this.experimentKey;
    }

    public final Boolean b() {
        return this.isExperiment;
    }

    public final Boolean c() {
        return this.ignoreMatch;
    }

    public final List<com.bytedance.android.shopping.api.image.d> e() {
        return this.supportMather;
    }

    public final String g() {
        return this.matchersType;
    }
}
