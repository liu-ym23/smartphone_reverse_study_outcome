package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface IHttpService extends IService {
    g buildMultipartUpload(String r1, String r2, boolean r3);

    g buildMultipartUpload(String r1, String r2, boolean r3, Map<String, String> r4);

    c doGet(String r1, Map<String, String> r2);

    c doPost(String r1, byte[] r2, Map<String, String> r3);

    c uploadFiles(String r1, List<File> r2, Map<String, String> r3);
}
