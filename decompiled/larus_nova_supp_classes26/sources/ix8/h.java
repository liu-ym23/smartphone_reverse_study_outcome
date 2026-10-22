package ix8;

import com.larus.camera.api.vlm.VLMIntentScene;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {
    public final List<VLMIntentScene> a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((h) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "VLMIntentSceneResolveResult(scenes=" + this.a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(List<? extends VLMIntentScene> r2) {
        Intrinsics.checkNotNullParameter(r2, "scenes");
        this.a = r2;
    }
}
