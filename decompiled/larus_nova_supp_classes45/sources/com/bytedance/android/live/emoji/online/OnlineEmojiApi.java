package com.bytedance.android.live.emoji.online;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.retrofit2.http.GET;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface OnlineEmojiApi {
    @GET("/webcast/openapi/resources/emoji/")
    Single<Response<w90.a>> getSmallEmojiResources();
}
