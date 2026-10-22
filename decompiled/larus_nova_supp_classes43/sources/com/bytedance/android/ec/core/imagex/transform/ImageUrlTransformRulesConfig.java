package com.bytedance.android.ec.core.imagex.transform;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRulesConfig;", "Ljava/io/Serializable;", "", "origin", "Lcom/bytedance/android/ec/core/imagex/transform/a;", "resizeConfig", "transform", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "rulesVersion", "getRulesVersion", "setRulesVersion", "Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules;", "rules", "Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules;", "getRules", "()Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules;", "setRules", "(Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules;)V", "<init>", "()V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageUrlTransformRulesConfig implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @Expose(deserialize = false, serialize = false)
    private String name;

    @SerializedName("rules")
    private ImageUrlTransformRules rules;

    @SerializedName("rules_version")
    private String rulesVersion;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImageUrlTransformRulesConfig() {
    }

    public final String getName() {
        return this.name;
    }

    public final ImageUrlTransformRules getRules() {
        return this.rules;
    }

    public final String getRulesVersion() {
        return this.rulesVersion;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final void setRules(ImageUrlTransformRules r1) {
        this.rules = r1;
    }

    public final void setRulesVersion(String r1) {
        this.rulesVersion = r1;
    }

    public final String transform(String r10, com.bytedance.android.ec.core.imagex.transform.a r11) {
        Intrinsics.checkNotNullParameter(r10, "origin");
        ImageUrlTransformRules r0 = this.rules;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.transform(r10, r11);
    }
}
