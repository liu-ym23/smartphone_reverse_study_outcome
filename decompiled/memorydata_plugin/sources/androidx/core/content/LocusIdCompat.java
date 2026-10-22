package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    private static class Api29Impl {
        private Api29Impl() {
        }

        static LocusId create(String r1) {
            return new LocusId(r1);
        }

        static String getId(LocusId r0) {
            return r0.getId();
        }
    }

    public LocusIdCompat(String r4) {
        this.mId = (String) ZeusTransformUtils.preCheckCast(Preconditions.checkStringNotEmpty(r4, "id cannot be empty"), String.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 29) goto L5;
        LocusId r5 = Api29Impl.create(r4);
    L6:
        this.mWrapped = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    private String getSanitizedId() {
        return this.mId.length() + "_chars";
    }

    public static LocusIdCompat toLocusIdCompat(LocusId r3) {
        Preconditions.checkNotNull(r3, "locusId cannot be null");
        return new LocusIdCompat((String) ZeusTransformUtils.preCheckCast(Preconditions.checkStringNotEmpty(Api29Impl.getId(r3), "id cannot be empty"), String.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (getClass() == r5.getClass()) goto L11;
        return false;
    L11:
        LocusIdCompat r6 = (LocusIdCompat) ZeusTransformUtils.preCheckCast(r5, LocusIdCompat.class, "com.obric.memorydata.plugin");
        String r4 = this.mId;
        if (r4 != null) goto L19;
        if (r6.mId != null) goto L17;
        return true;
    L17:
        return false;
    L19:
        return r4.equals(r6.mId);
    }

    public String getId() {
        return this.mId;
    }

    public int hashCode() {
        String r1 = this.mId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return 31 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public LocusId toLocusId() {
        return this.mWrapped;
    }

    public String toString() {
        return "LocusIdCompat[" + getSanitizedId() + "]";
    }
}
