package com.bytedance.bdinstall;

import android.util.Pair;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkClient {
    String get(String r1, Map<String, String> r2);

    String post(String r1, List<Pair<String, String>> r2);

    String post(String r1, byte[] r2, String r3);

    String post(String r1, byte[] r2, Map<String, String> r3);

    byte[] postStream(String r1, byte[] r2, Map<String, String> r3);
}
