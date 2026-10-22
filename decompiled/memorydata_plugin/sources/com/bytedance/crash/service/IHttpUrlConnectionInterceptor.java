package com.bytedance.crash.service;

import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public interface IHttpUrlConnectionInterceptor {
    HttpURLConnection getUrlConnection(URL r1);
}
