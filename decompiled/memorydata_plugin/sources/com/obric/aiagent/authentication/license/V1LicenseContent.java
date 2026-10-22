package com.obric.aiagent.authentication.license;

import com.google.gson.annotations.SerializedName;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001BI\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0003¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J!\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0003JQ\u0010\u0012\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00042 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R(\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00030\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/obric/aiagent/authentication/license/V1LicenseContent;", "", "actions", "", "", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "signatures", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;)V", "getActions", "()Ljava/util/Map;", "getPackageName", "()Ljava/lang/String;", "getSignatures", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "authentication_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class V1LicenseContent {

    @SerializedName("actions")
    private final Map<String, List<String>> actions;

    @SerializedName("package_name")
    private final String packageName;

    @SerializedName("signatures")
    private final Map<String, Map<String, String>> signatures;

    public V1LicenseContent(Map<String, ? extends List<String>> r3, String r4, Map<String, ? extends Map<String, String>> r5) {
        Map<String, List<String>> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map<String, Map<String, String>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "actions");
        Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r7, "signatures");
        this.actions = r6;
        this.packageName = r4;
        this.signatures = r7;
    }

    public static /* synthetic */ V1LicenseContent copy$default(V1LicenseContent r1, Map r2, String r3, Map r4, int r5, Object r6) {
        Map<String, List<String>> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Map<String, Map<String, String>> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.actions;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.packageName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r8 = r1.signatures;
    L12:
        return r1.copy(r7, r3, r8);
    }

    public final Map<String, List<String>> component1() {
        return this.actions;
    }

    public final String component2() {
        return this.packageName;
    }

    public final Map<String, Map<String, String>> component3() {
        return this.signatures;
    }

    public final V1LicenseContent copy(Map<String, ? extends List<String>> r2, String r3, Map<String, ? extends Map<String, String>> r4) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "actions");
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r5, "signatures");
        return new V1LicenseContent(r1, r3, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, V1LicenseContent.class) == true) goto L8;
        return false;
    L8:
        V1LicenseContent r6 = (V1LicenseContent) ZeusTransformUtils.preCheckCast(r5, V1LicenseContent.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.actions, r6.actions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.signatures, r6.signatures) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Map<String, List<String>> getActions() {
        return this.actions;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Map<String, Map<String, String>> getSignatures() {
        return this.signatures;
    }

    public int hashCode() {
        return (((this.actions.hashCode() * 31) + this.packageName.hashCode()) * 31) + this.signatures.hashCode();
    }

    public String toString() {
        return "V1LicenseContent(actions=" + this.actions + ", packageName=" + this.packageName + ", signatures=" + this.signatures + ')';
    }
}
