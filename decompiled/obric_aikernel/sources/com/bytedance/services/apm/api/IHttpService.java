package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.io.File;
import java.util.List;
import java.util.Map;
import t4.c;
import t4.g;

/* JADX INFO: loaded from: classes.dex */
public interface IHttpService extends IService {
    g buildMultipartUpload(String r10, String r11, boolean r12);

    g buildMultipartUpload(String r10, String r11, boolean r12, Map<String, String> r13);

    c doGet(String r10, Map<String, String> r11);

    c doPost(String r10, byte[] r11, Map<String, String> r12);

    c uploadFiles(String r10, List<File> r11, Map<String, String> r12);
}
