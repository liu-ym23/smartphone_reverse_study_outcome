package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    private String getSanitizedId() {
        return this.mId.length() + "_chars";
    }

    public int hashCode() {
        String r0 = this.mId;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return 31 + r1;
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "LocusIdCompat[" + getSanitizedId() + "]";
    }

    public String getId() {
        return this.mId;
    }

    public LocusId toLocusId() {
        return this.mWrapped;
    }

    public LocusIdCompat(String r3) {
        this.mId = (String) Preconditions.checkStringNotEmpty(r3, "id cannot be empty");
        if (Build.VERSION.SDK_INT < 29) goto L5;
        this.mWrapped = Api29Impl.create(r3);
        return;
    L5:
        this.mWrapped = null;
    }

    public static LocusIdCompat toLocusIdCompat(LocusId r2) {
        Preconditions.checkNotNull(r2, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(Api29Impl.getId(r2), "id cannot be empty"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (LocusIdCompat.class == r5.getClass()) goto L11;
        return false;
    L11:
        LocusIdCompat r6 = (LocusIdCompat) r5;
        String r2 = this.mId;
        if (r2 != null) goto L19;
        if (r6.mId == null) goto L20;
        return false;
    L20:
        return true;
    L19:
        return r2.equals(r6.mId);
    }
}
