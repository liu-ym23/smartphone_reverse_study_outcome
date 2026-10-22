package org.bouncycastle.jcajce.provider.config;

import java.util.Map;
import java.util.Set;
import org.bouncycastle.jce.spec.ECParameterSpec;

/* JADX INFO: loaded from: classes7.dex */
public interface ProviderConfiguration {
    Set getAcceptableNamedCurves();

    Map getAdditionalECParameters();

    ECParameterSpec getEcImplicitlyCa();
}
