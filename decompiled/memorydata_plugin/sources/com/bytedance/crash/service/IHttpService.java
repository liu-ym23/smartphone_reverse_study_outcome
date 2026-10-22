package com.bytedance.crash.service;

import android.util.Pair;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IHttpService {
    IMultipartService buildMultipartService(String r1, String r2, boolean r3);

    Pair<Integer, byte[]> doGet(String r1, Map<String, String> r2);

    Pair<Integer, byte[]> doPost(String r1, byte[] r2, Map<String, String> r3);
}
