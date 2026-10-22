package com.bytedance.bdinstall.dtrait.interfaces;

import android.util.Pair;
import com.bytedance.bdinstall.dtrait.model.DTraitResponse;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IDTraitNetworkApi {
    DTraitResponse get(String r1, Map<String, String> r2);

    DTraitResponse post(String r1, List<Pair<String, String>> r2);

    DTraitResponse post(String r1, byte[] r2, String r3);

    DTraitResponse post(String r1, byte[] r2, Map<String, String> r3);

    byte[] postStream(String r1, byte[] r2, Map<String, String> r3);
}
