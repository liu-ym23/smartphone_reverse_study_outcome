package mo0;

import com.bytedance.android.live.openplatform.api.utils.image.ImageTag;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public final ImageTag a;
    public final BaseControllerListener<ImageInfo> b;
    public final boolean c;
    public final boolean d;

    public b() {
        throw null;
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L16;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(null, null) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L12;
        return false;
    L12:
        if (this.c == r4.c) goto L14;
        return false;
    L14:
        if (this.d == r4.d) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        ImageTag r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + 0) * 31;
        BaseControllerListener<ImageInfo> r4 = this.b;
        if (r4 == null) goto L9;
        r1 = r4.hashCode();
    L9:
        int r5 = (r3 + r1) * 31;
        boolean r6 = this.c;
        ?? r7 = 1;
        ?? r8 = r6;
        if (r6 == false) goto L12;
        r8 = 1;
    L12:
        int r9 = (r5 + r8) * 31;
        boolean r10 = this.d;
        if (r10 == true) goto L17;
        r7 = r10;
    L17:
        return r9 + r7;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageLoadConfig(tag=" + this.a + ", scaleConfig=null, controllerListener=" + this.b + ", removeControllerListenerAfterPlayOnce=" + this.c + ", enableFrameMonitor=" + this.d + ")";
    }

    public b(ImageTag r3, BaseControllerListener r4, boolean r5, boolean r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 8) == 0) goto L9;
        r5 = false;
    L9:
        if ((r7 & 16) == 0) goto L11;
        r6 = false;
    L11:
        Intrinsics.checkNotNullParameter(r3, "tag");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
