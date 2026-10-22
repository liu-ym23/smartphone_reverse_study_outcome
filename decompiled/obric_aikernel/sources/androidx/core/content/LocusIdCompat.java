package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @NonNull
        static LocusId create(@NonNull String r10) {
            return new LocusId(r10);
        }

        @NonNull
        static String getId(@NonNull LocusId r10) {
            return r10.getId();
        }
    }

    public LocusIdCompat(@NonNull String r10) {
        this.mId = (String) Preconditions.checkStringNotEmpty(r10, "id cannot be empty");
        if (Build.VERSION.SDK_INT < 29) goto L5;
        LocusId r11 = Api29Impl.create(r10);
    L6:
        this.mWrapped = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }

    @NonNull
    private String getSanitizedId() {
        return this.mId.length() + "_chars";
    }

    @NonNull
    @RequiresApi(29)
    public static LocusIdCompat toLocusIdCompat(@NonNull LocusId r10) {
        Preconditions.checkNotNull(r10, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(Api29Impl.getId(r10), "id cannot be empty"));
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L9;
        return false;
    L9:
        if (LocusIdCompat.class == r10.getClass()) goto L11;
        return false;
    L11:
        LocusIdCompat r11 = (LocusIdCompat) r10;
        String r12 = this.mId;
        if (r12 != null) goto L19;
        if (r11.mId != null) goto L17;
        return true;
    L17:
        return false;
    L19:
        return r12.equals(r11.mId);
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public int hashCode() {
        String r10 = this.mId;
        if (r10 != null) goto L5;
        int r11 = 0;
    L7:
        return 31 + r11;
    L5:
        r11 = r10.hashCode();
        goto L7
    }

    @NonNull
    @RequiresApi(29)
    public LocusId toLocusId() {
        return this.mWrapped;
    }

    @NonNull
    public String toString() {
        return "LocusIdCompat[" + getSanitizedId() + "]";
    }
}
