package cn.nubia.neopush.protocol.http;

/* JADX INFO: loaded from: classes.dex */
public interface HttpRequestListener {
    void onComplete(String r5);

    void onError(int r5);

    void onStart();
}
