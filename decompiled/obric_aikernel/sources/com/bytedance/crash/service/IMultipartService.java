package com.bytedance.crash.service;

import android.util.Pair;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IMultipartService {
    void addFilePart(File r10, String r11, Map<String, String> r12);

    void addFilePart(File r10, Map<String, String> r11);

    void addFilePart(String r10, File r11);

    void addFormField(String r10, String r11);

    void addFormField(String r10, byte[] r11);

    void addGZIPFilePart(String r10, List<File> r11);

    Pair<Integer, String> finish();
}
