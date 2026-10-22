package com.bytedance.crash.service;

import android.util.Pair;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IHttpService {
    IMultipartService buildMultipartService(String r10, String r11, boolean r12);

    Pair<Integer, byte[]> doGet(String r10, Map<String, String> r11);

    Pair<Integer, byte[]> doPost(String r10, byte[] r11, Map<String, String> r12);
}
