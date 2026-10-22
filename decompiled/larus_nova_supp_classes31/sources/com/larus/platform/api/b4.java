package com.larus.platform.api;

import com.larus.bmhome.upload.sdk.ResourceUploadEngine;
import com.larus.platform.model.upload.ResourceUploadError;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface b4 {

    public interface a {
        void a(ResourceUploadError r1);

        void b(mr9.k r1);

        void c(mr9.l r1);
    }

    void a();

    void b(ResourceUploadEngine.upload.2.1 r1);

    void cancel(String r1, boolean r2);
}
