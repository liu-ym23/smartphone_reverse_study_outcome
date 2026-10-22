package com.bytedance.bdinstall;

import android.util.Pair;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface INetworkClient {
    String get(String r10, Map<String, String> r11);

    String post(String r10, List<Pair<String, String>> r11);

    String post(String r10, byte[] r11, String r12);

    String post(String r10, byte[] r11, Map<String, String> r12);

    byte[] postStream(String r10, byte[] r11, Map<String, String> r12);
}
