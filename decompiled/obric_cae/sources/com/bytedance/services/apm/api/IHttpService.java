package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.io.File;
import java.util.List;
import java.util.Map;
import u8.b;
import u8.e;

/* JADX INFO: loaded from: classes.dex */
public interface IHttpService extends IService {
    e buildMultipartUpload(String r8, String r10, boolean r11);

    e buildMultipartUpload(String r8, String r10, boolean r11, Map<String, String> r12);

    b doGet(String r8, Map<String, String> r10);

    b doPost(String r8, byte[] r10, Map<String, String> r11);

    b uploadFiles(String r8, List<File> r10, Map<String, String> r11);
}
