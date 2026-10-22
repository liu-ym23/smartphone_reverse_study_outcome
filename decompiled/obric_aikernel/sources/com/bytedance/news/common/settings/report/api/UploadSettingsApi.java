package com.bytedance.news.common.settings.report.api;

import com.bytedance.retrofit2.b;
import com.google.gson.k;
import o4.g0;
import o4.n;
import o4.t;

/* JADX INFO: loaded from: classes.dex */
public interface UploadSettingsApi {
    @t
    @n({"Content-type:application/json;charset=UTF-8"})
    b<String> executePost(@g0 String r10, @o4.b k r11);
}
