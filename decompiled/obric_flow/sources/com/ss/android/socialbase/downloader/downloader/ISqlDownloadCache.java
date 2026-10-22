package com.ss.android.socialbase.downloader.downloader;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.db.SqlCacheLoadCompleteCallback;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ISqlDownloadCache extends IDownloadCache {
    void a(SparseArray r5, HashMap r10, List r11, List r12, SqlCacheLoadCompleteCallback r13);
}
