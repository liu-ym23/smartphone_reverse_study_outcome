package org.bouncycastle.jcajce.provider.config;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class ProviderConfigurationPermission extends BasicPermission {
    private static final int ACCEPTABLE_EC_CURVES = 16;
    private static final String ACCEPTABLE_EC_CURVES_STR = "acceptableeccurves";
    private static final int ADDITIONAL_EC_PARAMETERS = 32;
    private static final String ADDITIONAL_EC_PARAMETERS_STR = "additionalecparameters";
    private static final int ALL = 63;
    private static final String ALL_STR = "all";
    private static final int DH_DEFAULT_PARAMS = 8;
    private static final String DH_DEFAULT_PARAMS_STR = "dhdefaultparams";
    private static final int EC_IMPLICITLY_CA = 2;
    private static final String EC_IMPLICITLY_CA_STR = "ecimplicitlyca";
    private static final int THREAD_LOCAL_DH_DEFAULT_PARAMS = 4;
    private static final String THREAD_LOCAL_DH_DEFAULT_PARAMS_STR = "threadlocaldhdefaultparams";
    private static final int THREAD_LOCAL_EC_IMPLICITLY_CA = 1;
    private static final String THREAD_LOCAL_EC_IMPLICITLY_CA_STR = "threadlocalecimplicitlyca";
    private final String actions;
    private final int permissionMask;

    public ProviderConfigurationPermission(String r1) {
        super(r1);
        this.actions = "all";
        this.permissionMask = 63;
    }

    public ProviderConfigurationPermission(String r1, String r2) {
        super(r1, r2);
        this.actions = r2;
        this.permissionMask = calculateMask(r2);
    }

    private int calculateMask(String r3) {
        StringTokenizer r2 = new StringTokenizer(Strings.toLowerCase(r3), " ,");
        int r4 = 0;
    L4:
        if (r2.hasMoreTokens() == false) goto L26;
        String r0 = r2.nextToken();
        if (r0.equals(THREAD_LOCAL_EC_IMPLICITLY_CA_STR) == true) goto L7;
        if (r0.equals(EC_IMPLICITLY_CA_STR) == true) goto L10;
        if (r0.equals(THREAD_LOCAL_DH_DEFAULT_PARAMS_STR) == true) goto L13;
        if (r0.equals(DH_DEFAULT_PARAMS_STR) == true) goto L16;
        if (r0.equals(ACCEPTABLE_EC_CURVES_STR) == true) goto L19;
        if (r0.equals(ADDITIONAL_EC_PARAMETERS_STR) == true) goto L22;
        if (r0.equals("all") == false) goto L4;
        r4 = r4 | 63;
        goto L4
    L22:
        r4 = r4 | 32;
        goto L4
    L19:
        r4 = r4 | 16;
        goto L4
    L16:
        r4 = r4 | 8;
        goto L4
    L13:
        r4 = r4 | 4;
        goto L4
    L10:
        r4 = r4 | 2;
        goto L4
    L7:
        r4 = r4 | 1;
        goto L4
    L26:
        if (r4 == 0) goto L29;
        return r4;
    L29:
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ProviderConfigurationPermission.class) == false) goto L14;
        ProviderConfigurationPermission r6 = (ProviderConfigurationPermission) ZeusTransformUtils.preCheckCast(r5, ProviderConfigurationPermission.class, "com.obric.memorydata.plugin");
        if (this.permissionMask != r6.permissionMask) goto L13;
        if (getName().equals(r6.getName()) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public String getActions() {
        return this.actions;
    }

    public int hashCode() {
        return getName().hashCode() + this.permissionMask;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public boolean implies(Permission r5) {
        if (ZeusTransformUtils.instanceOf(r5, ProviderConfigurationPermission.class) == true) goto L6;
        return false;
    L6:
        if (getName().equals(r5.getName()) == true) goto L8;
        return false;
    L8:
        ProviderConfigurationPermission r6 = (ProviderConfigurationPermission) ZeusTransformUtils.preCheckCast(r5, ProviderConfigurationPermission.class, "com.obric.memorydata.plugin");
        int r4 = this.permissionMask;
        int r7 = r6.permissionMask;
        if ((r4 & r7) != r7) goto L12;
        return true;
    L12:
        return false;
    }
}
