package ix8;

import android.graphics.Bitmap;
import com.larus.camera.api.vlm.VLMFileDataType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final Bitmap a;
    public final VLMFileDataType b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "VLMIntentDetectFile(bitmap=" + this.a + ", type=" + this.b + ')';
    }

    public final VLMFileDataType getType() {
        return this.b;
    }

    public b(Bitmap r2, VLMFileDataType r3) {
        Intrinsics.checkNotNullParameter(r2, "bitmap");
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a = r2;
        this.b = r3;
    }
}
