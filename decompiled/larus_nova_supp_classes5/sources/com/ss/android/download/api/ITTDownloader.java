package com.ss.android.download.api;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.extend.DownloadCompletedListener;
import com.ss.android.downloadad.api.AdDownloadCompletedEventHandler;
import com.ss.android.downloadad.api.AdWebViewDownloadManager;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface ITTDownloader {
    void action(String r1, int r2, DownloadEventConfig r3);

    void action(String r1, long r2, int r4);

    void action(String r1, long r2, int r4, DownloadEventConfig r5, DownloadController r6);

    void action(String r1, long r2, int r4, DownloadEventConfig r5, DownloadController r6, IDownloadButtonClickListener r7);

    void action(String r1, long r2, int r4, DownloadEventConfig r5, DownloadController r6, OnItemClickListener r7, IDownloadButtonClickListener r8);

    void action(String r1, long r2, int r4, DownloadEventConfig r5, DownloadController r6, DownloadModel r7);

    void action(String r1, long r2, int r4, DownloadEventConfig r5, DownloadController r6, JSONObject r7);

    void addDownloadCompletedListener(DownloadCompletedListener r1);

    void bind(int r1, DownloadStatusChangeListener r2, DownloadModel r3);

    void bind(Context r1, int r2, DownloadStatusChangeListener r3, DownloadModel r4);

    void cancel(String r1);

    void cancel(String r1, boolean r2);

    ActionDecisionApi getActionDecision(String r1, long r2, int r4, DownloadEventConfig r5, DownloadController r6);

    AdDownloadCompletedEventHandler getAdDownloadCompletedEventHandler();

    AdWebViewDownloadManager getAdWebViewDownloadManager();

    DownloadConfigure getDownloadConfigure();

    DownloadInfo getDownloadInfo(String r1);

    DownloadInfo getDownloadInfo(String r1, String r2);

    boolean isStarted(String r1);

    void removeDownloadCompletedListener(DownloadCompletedListener r1);

    void unbind(String r1, int r2);
}
