package com.tencent.tauth;

import com.tencent.open.utils.HttpUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface IRequestListener {
    void onComplete(JSONObject r1);

    void onHttpStatusException(HttpUtils.HttpStatusException r1);

    void onIOException(IOException r1);

    void onJSONException(JSONException r1);

    void onMalformedURLException(MalformedURLException r1);

    void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException r1);

    void onSocketTimeoutException(SocketTimeoutException r1);

    void onUnknowException(Exception r1);
}
