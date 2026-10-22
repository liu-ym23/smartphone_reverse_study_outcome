package androidx.core.provider;

import android.util.Base64;
import androidx.core.util.Preconditions;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    public FontRequest(String r4, String r5, String r6, int r7) {
        this.mProviderAuthority = (String) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r4), String.class, "com.obric.memorydata.plugin");
        this.mProviderPackage = (String) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r5), String.class, "com.obric.memorydata.plugin");
        this.mQuery = (String) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r6), String.class, "com.obric.memorydata.plugin");
        this.mCertificates = null;
        if (r7 == 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        this.mCertificatesArray = r7;
        this.mIdentifier = createIdentifier(r4, r5, r6);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public FontRequest(String r4, String r5, String r6, List<List<byte[]>> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.mProviderAuthority = (String) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r4), String.class, "com.obric.memorydata.plugin");
        this.mProviderPackage = (String) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r5), String.class, "com.obric.memorydata.plugin");
        this.mQuery = (String) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r6), String.class, "com.obric.memorydata.plugin");
        this.mCertificates = (List) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r8), List.class, "com.obric.memorydata.plugin");
        this.mCertificatesArray = 0;
        this.mIdentifier = createIdentifier(r4, r5, r6);
    }

    private String createIdentifier(String r1, String r2, String r3) {
        return r1 + "-" + r2 + "-" + r3;
    }

    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    String getId() {
        return this.mIdentifier;
    }

    @Deprecated
    public String getIdentifier() {
        return this.mIdentifier;
    }

    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        int r2 = 0;
    L4:
        if (r2 >= this.mCertificates.size()) goto L10;
        r0.append(" [");
        List r3 = (List) ZeusTransformUtils.preCheckCast(this.mCertificates.get(r2), List.class, "com.obric.memorydata.plugin");
        int r4 = 0;
    L7:
        if (r4 >= r3.size()) goto L9;
        r0.append(" \"");
        r0.append(Base64.encodeToString((byte[]) ZeusTransformUtils.preCheckCast(r3.get(r4), byte[].class, "com.obric.memorydata.plugin"), 0));
        r0.append("\"");
        r4 = r4 + 1;
        goto L7
    L9:
        r0.append(" ]");
        r2 = r2 + 1;
        goto L4
    L10:
        r0.append("}");
        r0.append("mCertificatesArray: " + this.mCertificatesArray);
        return r0.toString();
    }
}
