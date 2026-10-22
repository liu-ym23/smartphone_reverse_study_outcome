package com.bytedance.crash.service;

import android.util.Pair;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IMultipartService {
    void addFilePart(File r1, String r2, Map<String, String> r3);

    void addFilePart(File r1, Map<String, String> r2);

    void addFilePart(String r1, File r2);

    void addFormField(String r1, String r2);

    void addFormField(String r1, byte[] r2);

    void addGZIPFilePart(String r1, List<File> r2);

    Pair<Integer, String> finish();
}
