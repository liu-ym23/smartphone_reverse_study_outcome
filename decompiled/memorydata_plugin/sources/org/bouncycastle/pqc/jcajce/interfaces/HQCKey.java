package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.pqc.jcajce.spec.HQCParameterSpec;

/* JADX INFO: loaded from: classes7.dex */
public interface HQCKey extends Key {
    HQCParameterSpec getParameterSpec();
}
