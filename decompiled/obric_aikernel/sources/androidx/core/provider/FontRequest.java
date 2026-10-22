package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    public FontRequest(@NonNull String r10, @NonNull String r11, @NonNull String r12, @ArrayRes int r13) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(r10);
        this.mProviderPackage = (String) Preconditions.checkNotNull(r11);
        this.mQuery = (String) Preconditions.checkNotNull(r12);
        this.mCertificates = null;
        if (r13 == 0) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkArgument(r14);
        this.mCertificatesArray = r13;
        this.mIdentifier = createIdentifier(r10, r11, r12);
        return;
    L5:
        r14 = false;
        goto L6
    }

    public FontRequest(@NonNull String r10, @NonNull String r11, @NonNull String r12, @NonNull List<List<byte[]>> r13) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(r10);
        this.mProviderPackage = (String) Preconditions.checkNotNull(r11);
        this.mQuery = (String) Preconditions.checkNotNull(r12);
        this.mCertificates = (List) Preconditions.checkNotNull(r13);
        this.mCertificatesArray = 0;
        this.mIdentifier = createIdentifier(r10, r11, r12);
    }

    private String createIdentifier(@NonNull String r10, @NonNull String r11, @NonNull String r12) {
        return r10 + "-" + r11 + "-" + r12;
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
    String getId() {
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
        StringBuilder r10 = new StringBuilder();
        r10.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        int r11 = 0;
    L4:
        if (r11 >= this.mCertificates.size()) goto L10;
        r10.append(" [");
        List<byte[]> r12 = this.mCertificates.get(r11);
        int r13 = 0;
    L7:
        if (r13 >= r12.size()) goto L9;
        r10.append(" \"");
        r10.append(Base64.encodeToString(r12.get(r13), 0));
        r10.append("\"");
        r13 = r13 + 1;
        goto L7
    L9:
        r10.append(" ]");
        r11 = r11 + 1;
        goto L4
    L10:
        r10.append("}");
        r10.append("mCertificatesArray: " + this.mCertificatesArray);
        return r10.toString();
    }
}
