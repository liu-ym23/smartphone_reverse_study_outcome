package com.bytedance.crash.service;

import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public interface IHttpUrlConnectionInterceptor {
    HttpURLConnection getUrlConnection(URL r10);
}
