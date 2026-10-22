package com.ss.android.newmedia;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.MaxLength;

/* JADX INFO: loaded from: classes2.dex */
public interface IMediaApi {
    @GET("/get_blacklist/")
    Call<Object> getHijackUrlPathStore(@MaxLength int r8);
}
