package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.room.writer.DaoWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    public FontRequest(@NonNull String r5, @NonNull String r10, @NonNull String r11, @NonNull List<List<byte[]>> r12) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(r5);
        this.mProviderPackage = (String) Preconditions.checkNotNull(r10);
        this.mQuery = (String) Preconditions.checkNotNull(r11);
        this.mCertificates = (List) Preconditions.checkNotNull(r12);
        this.mCertificatesArray = 0;
        this.mIdentifier = createIdentifier(r5, r10, r11);
    }

    private String createIdentifier(@NonNull String r5, @NonNull String r10, @NonNull String r11) {
        return r5 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r10 + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r11;
    }

    @Nullable
    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    @ArrayRes
    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String getId() {
        return this.mIdentifier;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public String getIdentifier() {
        return this.mIdentifier;
    }

    @NonNull
    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    @NonNull
    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    @NonNull
    public String getQuery() {
        return this.mQuery;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        int r10 = 0;
    L4:
        if (r10 >= this.mCertificates.size()) goto L10;
        r5.append(" [");
        List<byte[]> r11 = this.mCertificates.get(r10);
        int r12 = 0;
    L7:
        if (r12 >= r11.size()) goto L9;
        r5.append(" \"");
        r5.append(Base64.encodeToString(r11.get(r12), 0));
        r5.append("\"");
        r12 = r12 + 1;
        goto L7
    L9:
        r5.append(" ]");
        r10 = r10 + 1;
        goto L4
    L10:
        r5.append("}");
        r5.append("mCertificatesArray: " + this.mCertificatesArray);
        return r5.toString();
    }

    public FontRequest(@NonNull String r5, @NonNull String r10, @NonNull String r11, @ArrayRes int r12) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(r5);
        this.mProviderPackage = (String) Preconditions.checkNotNull(r10);
        this.mQuery = (String) Preconditions.checkNotNull(r11);
        this.mCertificates = null;
        if (r12 == 0) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13);
        this.mCertificatesArray = r12;
        this.mIdentifier = createIdentifier(r5, r10, r11);
        return;
    L5:
        r13 = false;
        goto L6
    }
}
