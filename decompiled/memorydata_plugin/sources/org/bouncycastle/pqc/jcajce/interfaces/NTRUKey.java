package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.Key;
import org.bouncycastle.pqc.jcajce.spec.NTRUParameterSpec;

/* JADX INFO: loaded from: classes7.dex */
public interface NTRUKey extends Key {
    NTRUParameterSpec getParameterSpec();
}
