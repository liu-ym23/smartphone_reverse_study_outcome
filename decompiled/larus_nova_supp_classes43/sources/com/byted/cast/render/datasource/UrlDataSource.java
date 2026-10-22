package com.byted.cast.render.datasource;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class UrlDataSource {
    static String TAG = "UrlDataSource";
    private long dataSourceId;
    private IDataSourceListener listener;

    private native long native_setUrl(String r1);

    private native boolean native_start(long r1);

    private native void native_stop(long r1);

    public boolean start() {
        return native_start(this.dataSourceId);
    }

    public void stop() {
        native_stop(this.dataSourceId);
    }

    public UrlDataSource() {
        this.dataSourceId = 0;
    }

    public void setDataListener(IDataSourceListener r1) {
        this.listener = r1;
    }

    public void setUrl(String r10) {
        this.dataSourceId = native_setUrl(r10);
    }

    private void onAudioDataCallback(byte[] r10, long r11) {
        if (r10.length <= 0) goto L6;
        this.listener.onAudioPacketAvailable(r10, r11);
        return;
    }

    private void onVideoDataCallback(byte[] r10, long r11) {
        if (r10.length <= 0) goto L6;
        this.listener.onVideoPacketAvailable(r10, r11);
        return;
    }
}
