package androidx.core.content;

import ai.j0;
import android.content.LocusId;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @NonNull
        public static LocusId create(@NonNull String r5) {
            return new LocusId(r5);
        }

        @NonNull
        public static String getId(@NonNull LocusId r5) {
            return r5.getId();
        }
    }

    public LocusIdCompat(@NonNull String r5) {
        this.mId = (String) Preconditions.checkStringNotEmpty(r5, "id cannot be empty");
        this.mWrapped = Api29Impl.create(r5);
    }

    @NonNull
    private String getSanitizedId() {
        return this.mId.length() + "_chars";
    }

    @NonNull
    @RequiresApi(29)
    public static LocusIdCompat toLocusIdCompat(@NonNull LocusId r5) {
        Preconditions.checkNotNull(r5, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(Api29Impl.getId(r5), "id cannot be empty"));
    }

    public boolean equals(@Nullable Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (LocusIdCompat.class == r5.getClass()) goto L11;
        return false;
    L11:
        LocusIdCompat r10 = (LocusIdCompat) r5;
        String r11 = this.mId;
        if (r11 != null) goto L19;
        if (r10.mId != null) goto L17;
        return true;
    L17:
        return false;
    L19:
        return r11.equals(r10.mId);
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public int hashCode() {
        String r5 = this.mId;
        if (r5 != null) goto L5;
        int r10 = 0;
    L7:
        return 31 + r10;
    L5:
        r10 = r5.hashCode();
        goto L7
    }

    @NonNull
    @RequiresApi(29)
    public LocusId toLocusId() {
        return this.mWrapped;
    }

    @NonNull
    public String toString() {
        return j0.q(new StringBuilder("LocusIdCompat["), getSanitizedId(), "]");
    }
}
