package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.pqc.jcajce.spec.SIKEParameterSpec;

/* JADX INFO: loaded from: classes7.dex */
public interface SIKEKey extends Key {
    SIKEParameterSpec getParameterSpec();
}
