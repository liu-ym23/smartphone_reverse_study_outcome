package ix8;

import com.larus.camera.api.vlm.VLMIntentTrackSource;
import com.larus.camera.api.vlm.VLMSceneType;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final List<b> a;
    public final VLMSceneType b;
    public final ix8.a c;
    public final Map<String, Object> d;
    public final VLMIntentTrackSource e;

    public static final class a {
    }

    static {
    }

    public c() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        VLMIntentTrackSource r1 = this.e;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "VLMIntentDetectRequest(files=" + this.a + ", sceneType=" + this.b + ", config=" + this.c + ", ext=" + this.d + ", trackSource=" + this.e + ')';
    }

    public /* synthetic */ c(List r11, VLMSceneType r12, ix8.a r13, VLMIntentTrackSource r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        r11 = CollectionsKt.emptyList();
    L5:
        List r1 = r11;
        if ((r15 & 2) == 0) goto L8;
        r12 = VLMSceneType.TAKE_PICTURE;
    L8:
        VLMSceneType r2 = r12;
        if ((r15 & 4) == 0) goto L11;
        ix8.a r3 = new ix8.a(null, 0.0f, 0, false, false, 63);
    L13:
        if ((r15 & 8) == 0) goto L15;
        Map r4 = MapsKt.emptyMap();
    L17:
        if ((r15 & 16) == 0) goto L19;
        VLMIntentTrackSource r5 = null;
    L20:
        this(r1, r2, r3, r4, r5);
        return;
    L19:
        r5 = r14;
        goto L20
    L15:
        r4 = null;
        goto L17
    L11:
        r3 = r13;
        goto L13
    }

    public c(List<b> r2, VLMSceneType r3, ix8.a r4, Map<String, ? extends Object> r5, VLMIntentTrackSource r6) {
        Intrinsics.checkNotNullParameter(r2, "files");
        Intrinsics.checkNotNullParameter(r3, "sceneType");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "ext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
