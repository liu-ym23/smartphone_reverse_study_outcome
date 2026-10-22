package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.io.File;
import java.util.List;
import java.util.Map;
import oj.b;
import oj.f;

/* JADX INFO: loaded from: classes2.dex */
public interface IHttpService extends IService {
    f buildMultipartUpload(String r5, String r10, boolean r11) throws Exception;

    f buildMultipartUpload(String r5, String r10, boolean r11, Map<String, String> r12) throws Exception;

    b doGet(String r5, Map<String, String> r10) throws Exception;

    b doPost(String r5, byte[] r10, Map<String, String> r11) throws Exception;

    b uploadFiles(String r5, List<File> r10, Map<String, String> r11) throws Exception;
}
