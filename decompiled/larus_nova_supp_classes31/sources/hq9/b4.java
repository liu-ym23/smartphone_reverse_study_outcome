package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/ResourceCenterConfig;", "", "enabled", "", "enabledForSceneConfig", "Lcom/larus/platform/model/ResourceCenterEnabledForSceneConfig;", "sceneIdOverride", "", "<init>", "(ZLcom/larus/platform/model/ResourceCenterEnabledForSceneConfig;Ljava/lang/String;)V", "getEnabled", "()Z", "getEnabledForSceneConfig", "()Lcom/larus/platform/model/ResourceCenterEnabledForSceneConfig;", "getSceneIdOverride", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class b4 {

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("enabled_for_scene")
    private final c4 enabledForSceneConfig;

    @SerializedName("scene_id_override")
    private final String sceneIdOverride;

    public b4() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b4) == true) goto L8;
        return false;
    L8:
        b4 r6 = (b4) r5;
        if (this.enabled == r6.enabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enabledForSceneConfig, r6.enabledForSceneConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sceneIdOverride, r6.sceneIdOverride) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        if (this.enabled == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        c4 r2 = this.enabledForSceneConfig;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        String r6 = this.sceneIdOverride;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ResourceCenterConfig(enabled=" + this.enabled + ", enabledForSceneConfig=" + this.enabledForSceneConfig + ", sceneIdOverride=" + this.sceneIdOverride + ')';
    }

    public final boolean a() {
        return this.enabled;
    }

    public final c4 b() {
        return this.enabledForSceneConfig;
    }

    public final String c() {
        return this.sceneIdOverride;
    }

    public b4(int r2) {
        c4 r3 = new c4(0);
        this.enabled = true;
        this.enabledForSceneConfig = r3;
        this.sceneIdOverride = null;
    }
}
