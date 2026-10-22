package com.bytedance.bdinstall.dtrait.interfaces;

import com.bytedance.bdinstall.dtrait.model.DTraitResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IDtraitNetworkConfig {
    byte[] encrypt(byte[] r1, int r2);

    DTraitResponse post(String r1, byte[] r2, Map<String, String> r3);
}
