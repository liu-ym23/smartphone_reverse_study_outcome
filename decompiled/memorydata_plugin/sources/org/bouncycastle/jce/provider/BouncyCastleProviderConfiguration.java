package org.bouncycastle.jce.provider;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.Permission;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jcajce.provider.config.ProviderConfigurationPermission;
import org.bouncycastle.jce.spec.ECParameterSpec;

/* JADX INFO: loaded from: classes7.dex */
class BouncyCastleProviderConfiguration implements ProviderConfiguration {
    private static Permission BC_ADDITIONAL_EC_CURVE_PERMISSION;
    private static Permission BC_DH_LOCAL_PERMISSION;
    private static Permission BC_DH_PERMISSION;
    private static Permission BC_EC_CURVE_PERMISSION;
    private static Permission BC_EC_LOCAL_PERMISSION;
    private static Permission BC_EC_PERMISSION;
    private volatile Set acceptableNamedCurves;
    private volatile Map additionalECParameters;
    private volatile Object dhDefaultParams;
    private ThreadLocal dhThreadSpec;
    private volatile ECParameterSpec ecImplicitCaParams;
    private ThreadLocal ecThreadSpec;

    static {
        BC_EC_LOCAL_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "threadLocalEcImplicitlyCa");
        BC_EC_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "ecImplicitlyCa");
        BC_DH_LOCAL_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "threadLocalDhDefaultParams");
        BC_DH_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "DhDefaultParams");
        BC_EC_CURVE_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "acceptableEcCurves");
        BC_ADDITIONAL_EC_CURVE_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "additionalEcParameters");
    }

    BouncyCastleProviderConfiguration() {
        this.ecThreadSpec = new ThreadLocal();
        this.dhThreadSpec = new ThreadLocal();
        this.acceptableNamedCurves = new HashSet();
        this.additionalECParameters = new HashMap();
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public Set getAcceptableNamedCurves() {
        return Collections.unmodifiableSet(this.acceptableNamedCurves);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public Map getAdditionalECParameters() {
        return Collections.unmodifiableMap(this.additionalECParameters);
    }

    @Override // org.bouncycastle.jcajce.provider.config.ProviderConfiguration
    public ECParameterSpec getEcImplicitlyCa() {
        ECParameterSpec r0 = (ECParameterSpec) ZeusTransformUtils.preCheckCast(this.ecThreadSpec.get(), ECParameterSpec.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.ecImplicitCaParams;
    }

    void setParameter(String r4, Object r5) {
        SecurityManager r0 = System.getSecurityManager();
        if (r4.equals("threadLocalEcImplicitlyCa") == false) goto L17;
        if (r0 == null) goto L7;
        r0.checkPermission(BC_EC_LOCAL_PERMISSION);
    L7:
        if (ZeusTransformUtils.instanceOf(r5, ECParameterSpec.class) == true) goto L11;
        if (r5 == null) goto L11;
        ECParameterSpec r6 = EC5Util.convertSpec((java.security.spec.ECParameterSpec) ZeusTransformUtils.preCheckCast(r5, java.security.spec.ECParameterSpec.class, "com.obric.memorydata.plugin"));
    L12:
        ThreadLocal r3 = this.ecThreadSpec;
        if (r6 != null) goto L15;
    L14:
        r3.remove();
        return;
    L15:
        r3.set(r6);
        return;
    L11:
        r6 = (ECParameterSpec) ZeusTransformUtils.preCheckCast(r5, ECParameterSpec.class, "com.obric.memorydata.plugin");
        goto L12
    L17:
        if (r4.equals("ecImplicitlyCa") == false) goto L28;
        if (r0 == null) goto L21;
        r0.checkPermission(BC_EC_PERMISSION);
    L21:
        if (ZeusTransformUtils.instanceOf(r5, ECParameterSpec.class) == true) goto L25;
        if (r5 == null) goto L25;
        ECParameterSpec r7 = EC5Util.convertSpec((java.security.spec.ECParameterSpec) ZeusTransformUtils.preCheckCast(r5, java.security.spec.ECParameterSpec.class, "com.obric.memorydata.plugin"));
    L26:
        this.ecImplicitCaParams = r7;
        return;
    L25:
        r7 = (ECParameterSpec) ZeusTransformUtils.preCheckCast(r5, ECParameterSpec.class, "com.obric.memorydata.plugin");
        goto L26
    L28:
        if (r4.equals("threadLocalDhDefaultParams") == false) goto L44;
        if (r0 == null) goto L32;
        r0.checkPermission(BC_DH_LOCAL_PERMISSION);
    L32:
        if (ZeusTransformUtils.instanceOf(r5, DHParameterSpec.class) == false) goto L34;
    L39:
        r3 = this.dhThreadSpec;
        if (r5 == null) goto L14;
        r3.set(r5);
        return;
    L34:
        if ((r5 instanceof DHParameterSpec[]) == true) goto L39;
        if (r5 == null) goto L39;
        throw new IllegalArgumentException("not a valid DHParameterSpec");
    L44:
        if (r4.equals("DhDefaultParams") == false) goto L57;
        if (r0 == null) goto L48;
        r0.checkPermission(BC_DH_PERMISSION);
    L48:
        if (ZeusTransformUtils.instanceOf(r5, DHParameterSpec.class) == false) goto L50;
    L55:
        this.dhDefaultParams = r5;
        return;
    L50:
        if ((r5 instanceof DHParameterSpec[]) == true) goto L55;
        if (r5 == null) goto L55;
        throw new IllegalArgumentException("not a valid DHParameterSpec or DHParameterSpec[]");
    L57:
        if (r4.equals("acceptableEcCurves") == false) goto L62;
        if (r0 == null) goto L60;
        r0.checkPermission(BC_EC_CURVE_PERMISSION);
    L60:
        this.acceptableNamedCurves = (Set) ZeusTransformUtils.preCheckCast(r5, Set.class, "com.obric.memorydata.plugin");
        return;
    L62:
        if (r4.equals("additionalEcParameters") == false) goto L73;
        if (r0 == null) goto L65;
        r0.checkPermission(BC_ADDITIONAL_EC_CURVE_PERMISSION);
    L65:
        this.additionalECParameters = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
        return;
    }
}
